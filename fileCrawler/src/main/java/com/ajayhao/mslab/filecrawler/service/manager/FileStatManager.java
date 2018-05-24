package com.ajayhao.mslab.filecrawler.service.manager;

import com.ajayhao.mslab.filecrawler.service.collect.FileInfoCollector;
import com.ajayhao.mslab.filecrawler.service.scan.DiskScanner;
import com.ajayhao.mslab.filecrawler.service.vo.FileInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

/**
 * Created by AjayHao on 2017/7/4.
 *
 * 磁盘信息统计管理器
 */
@Component
public class FileStatManager {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //生产者线程池
    private ExecutorService scannerPool;

    //消费者线程池
    private ExecutorService collectorPool;

    //资源管理器
    private FileInfoResourceManager fileInfoResourceManager;

    public FileStatManager(){
        int corePoolSize = Runtime.getRuntime().availableProcessors() * 2;
        scannerPool = new ThreadPoolExecutor(corePoolSize, corePoolSize, 0L, TimeUnit.MILLISECONDS,
             new LinkedBlockingQueue<Runnable>());
        /*collectorPool = new ThreadPoolExecutor(corePoolSize, corePoolSize, 1L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(corePoolSize * 4));*/
        collectorPool = Executors.newFixedThreadPool(corePoolSize * 4);
        fileInfoResourceManager = new FileInfoResourceManager();
    }

    //执行统计
    public void execute(String pathStart){
        FileInfo fileStart = new FileInfo(pathStart);
        try {
            fileInfoResourceManager.putDirInfo(fileStart);
        } catch (InterruptedException e) {
            logger.debug("Thread Interrupted: FileStatManager-"+ e);
            fileInfoResourceManager.stop();
        }

        for(int i = 0; i < 2; i++){
            scannerPool.execute(new DiskScanner(fileInfoResourceManager));
            collectorPool.execute(new FileInfoCollector(fileInfoResourceManager));
        }

        //shutdownAndAwaitTermination(scannerPool);// 任务执行完毕后，关闭线程池
        //shutdownAndAwaitTermination(collectorPool);

    }

    public final List<Map> getStatInfoDetailByExt(String ext) {
        return fileInfoResourceManager.getDetailInfo(ext);
    }

    public final List<Map> getStatInfoList(){
        return fileInfoResourceManager.getStatInfo();
    }

    void shutdownAndAwaitTermination(ExecutorService pool) {
        if(pool != null && !pool.isShutdown()) {
            pool.shutdown();
        }
        try {
            // 等60秒后强制关闭
            if (!pool.awaitTermination(60, TimeUnit.SECONDS)) {
                pool.shutdownNow();
                // 再等60秒后打印错误日志
                if (!pool.awaitTermination(60, TimeUnit.SECONDS))
                    System.err.println("无法终止线程池"+pool);
            }
        } catch (InterruptedException ie) {
            pool.shutdownNow();
        }
    }

}
