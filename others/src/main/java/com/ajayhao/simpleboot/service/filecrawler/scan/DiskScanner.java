package com.ajayhao.simpleboot.service.filecrawler.scan;

import com.ajayhao.simpleboot.service.filecrawler.manager.FileInfoResourceManager;
import com.ajayhao.simpleboot.service.filecrawler.exception.FileCrawlerException;
import com.ajayhao.simpleboot.service.filecrawler.vo.FileInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by AjayHao on 2017/7/4.
 *
 * 磁盘扫描类，扫描目录与文件，作为生产者角色
 */
public class DiskScanner implements Runnable, Scannable {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final FileInfoResourceManager resourceManager;

    public DiskScanner(FileInfoResourceManager resourceManager){
        this.resourceManager = resourceManager;
    }

    @Override
    public void run() {
        try {
            while (!resourceManager.isStop()) {
                pathScan(resourceManager.takeDirInfo());
            }
        } catch (InterruptedException ie) {
            logger.info("DirInfo Consumer Interrupted:"+ ie);
        } catch (FileCrawlerException e) {
            e.printStackTrace();
        } finally {
            resourceManager.stop();
        }
    }

    //对fileInfo所在的目录进行单层遍历扫描
    @Override
    public void pathScan(FileInfo fileInfo) throws FileCrawlerException {

        if(fileInfo == null){
            logger.error("未扫描到结果，直接返回");
            return;
        }

        if(!fileInfo.exists()){
            throw new FileCrawlerException("执行扫描时发生异常，文件不存在：fileInfo="+ fileInfo);
        }

        if(!fileInfo.isDirectory()){
            //不是目录则提示异常
            throw new FileCrawlerException("执行扫描时发生异常：任务项不是目录，无法扫描: fileInfo="+ fileInfo);
        }

        for(FileInfo _fileinfo_: fileInfo.listFiles()){
            if(resourceManager.isStop()) break;
            processFileInfo(_fileinfo_);
        }
    }

    private void processFileInfo(FileInfo _fileinfo_) {
        if(_fileinfo_.isDirectory()){
            //插入生产者队列
            try {
                resourceManager.putDirInfo(_fileinfo_);
            } catch (InterruptedException e) {
                logger.info("DirInfo Producer Interrupted:"+ e);
                resourceManager.stop();
            }
        }else{
            //插入消费者队列
            try {
                resourceManager.putFileInfo(_fileinfo_);
            } catch (InterruptedException e) {
                logger.info("FileInfo Producer Interrupted:"+ e);
                resourceManager.stop();
            }
        }
    }
}
