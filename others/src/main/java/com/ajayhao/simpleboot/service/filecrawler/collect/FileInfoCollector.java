package com.ajayhao.simpleboot.service.filecrawler.collect;

import com.ajayhao.simpleboot.service.filecrawler.manager.FileInfoResourceManager;
import com.ajayhao.simpleboot.service.filecrawler.vo.FileInfo;
import com.ajayhao.simpleboot.service.filecrawler.exception.FileCrawlerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by AjayHao on 2017/7/4.
 */
public class FileInfoCollector implements Runnable,Collectable{

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final FileInfoResourceManager resourceManager;

    public FileInfoCollector(FileInfoResourceManager resourceManager){
        this.resourceManager = resourceManager;
    }

    @Override
    public void run() {
        try {
            while (!resourceManager.isStop()) {
                collect(resourceManager.takeFileInfo());
            }
        } catch (InterruptedException ie) {
            logger.info("FileInfo Consumer Interrupted:"+ ie);
            //Thread.currentThread().interrupt();
        } catch (FileCrawlerException e) {
            e.printStackTrace();
        } finally {
            resourceManager.stop();
        }
    }

    //采集逻辑
    @Override
    public void collect(FileInfo fileInfo) throws FileCrawlerException {
        if(fileInfo.isDirectory()){
            throw new FileCrawlerException("采集任务中不应该有目录对象");
        }else {
            processFileInfo(fileInfo);
        }
    }

    private void processFileInfo(FileInfo fileInfo) throws FileCrawlerException {
        String fileExt = fileInfo.getFileExt().toLowerCase();
        resourceManager.putStatInfoIfAbsent(fileExt, fileInfo);
        resourceManager.atomicAdd(fileExt,fileInfo.getFileSize());
        logger.info(fileInfo + "已采集");
    }

}
