package com.ajayhao.mslab.filecrawler.service.manager;

import com.ajayhao.mslab.filecrawler.service.vo.FileInfo;
import com.ajayhao.mslab.filecrawler.service.vo.StatisticInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

/**
 * Created by AjayHao on 2017/7/4.
 */
public class FileInfoResourceManager {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private volatile boolean isStop;

    //TODO 用双端队列优化，因目录的处理既当生产者又当消费者，长度较小时会把自己死锁
    //生产任务队列-处理目录
    private BlockingQueue<FileInfo> scannerQueue = new LinkedBlockingDeque<FileInfo>();

    //消费任务队列-处理文件
    private BlockingQueue<FileInfo> collectQueue = new LinkedBlockingDeque<FileInfo>();

    //明细信息
    private ConcurrentHashMap<String,CopyOnWriteArraySet<FileInfo>> statInfoDetailMap = new ConcurrentHashMap(4);

    //汇总信息
    private ConcurrentHashMap<String, StatisticInfo> statInfoMap = new ConcurrentHashMap(4);


    public final List<Map> getDetailInfo(String ext) {
        List<Map> fileList = new ArrayList();
        CopyOnWriteArraySet<FileInfo> fileInfos = statInfoDetailMap.get(ext);
        if(fileInfos != null && fileInfos.size() != 0){
            for(FileInfo fileInfo : fileInfos){
                fileList.add(fileInfo.getInfo());
            }
        }
        return fileList;
    }

    public final List<Map> getStatInfo() {
        List<Map> list = new ArrayList();
        for(StatisticInfo statisticInfo : statInfoMap.values()){
            list.add(statisticInfo.getInfo());
        }
        return list;
    }

    //插入目录信息到队尾
    public void putDirInfo(FileInfo fileInfo) throws InterruptedException {
        scannerQueue.put(fileInfo);
        logger.debug(fileInfo+"加入生产队列,队列长度:"+ collectQueue.size());
    }

    //取队首的目录信息
    public FileInfo takeDirInfo() throws InterruptedException {
        FileInfo f = scannerQueue.take();
        logger.debug(f+"离开生产队列,队列长度:"+ collectQueue.size());
        return f;
    }

    //插入文件信息到队尾
    public void putFileInfo(FileInfo fileInfo) throws InterruptedException {
        collectQueue.put(fileInfo);
        logger.debug(fileInfo+"加入消费队列,队列长度:"+ collectQueue.size());
    }

    //取队首的文件信息
    public FileInfo takeFileInfo() throws InterruptedException {
        FileInfo f = collectQueue.take();
        logger.debug(f+"离开消费队列,队列长度:"+ collectQueue.size());
        return f;
    }

    //重要，putIfAbsent思想
    public void putStatInfoIfAbsent(String ext, FileInfo fileInfo){
        CopyOnWriteArraySet<FileInfo> set = statInfoDetailMap.get(ext);
        if(set == null){
            CopyOnWriteArraySet<FileInfo> _set = new CopyOnWriteArraySet<FileInfo>();
            set = statInfoDetailMap.putIfAbsent(ext, _set);
            if(set == null){
                set = _set;
            }
        }
        set.add(fileInfo);
    }

    //重要，putIfAbsent思想
    public void atomicAdd(String ext,long fileSize){
        StatisticInfo s = statInfoMap.get(ext);
        if(s == null){
            StatisticInfo _s = new StatisticInfo(ext);
            s = statInfoMap.putIfAbsent(ext, _s);
            if(s == null){
                s = _s;
            }
        }
        s.atomicAddTotalSpace(fileSize);
        s.countIncrement();
    }

    public final boolean isStop() {
        return isStop;
    }

    public void stop() {
        isStop = true;
    }
}
