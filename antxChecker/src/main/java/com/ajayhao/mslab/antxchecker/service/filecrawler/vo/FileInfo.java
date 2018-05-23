package com.ajayhao.mslab.antxchecker.service.filecrawler.vo;

import com.ajayhao.mslab.antxchecker.service.filecrawler.exception.FileCrawlerException;

import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by AjayHao on 2017/7/4.
 *
 * 文件基本信息
 */
public class FileInfo {

    private String fullFileName;

    private File file;

    public FileInfo(String fullFileName){
        this.fullFileName = fullFileName;
        this.file = new File(fullFileName);
    }

    public FileInfo(File file){
        this.file = file;
        this.fullFileName = file.getAbsolutePath();
    }

    public String getFullFileName() {
        return fullFileName;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public boolean isDirectory(){
        return file.isDirectory();
    }

    public boolean exists(){
        return file.exists();
    }

    public List<FileInfo> listFiles() throws FileCrawlerException {
        if(file == null){
            throw new FileCrawlerException("无法展开目录, file=null，fullFileName="+ fullFileName);
        }
        List<FileInfo> fileInfoList = new ArrayList<FileInfo>();
        File[] arr = file.listFiles();
        if(arr != null && arr.length > 0) {
            for (File f : file.listFiles()) {
                FileInfo fileInfo = new FileInfo(f.getAbsolutePath());
                fileInfoList.add(fileInfo);
            }
        }
        return fileInfoList;
    }

    public long getFileSize(){
        return file.length();
    }

    public String getFileExt() throws FileCrawlerException {
        if(file == null){
            throw new FileCrawlerException("无法取得后缀, file=null，fullFileName="+ fullFileName);
        }
        String fileName= file.getName();
        int offset = fileName.lastIndexOf(".");
        if(offset < 0){
            return "unknown";
        }else {
            return fileName.substring(offset+1);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FileInfo fileInfo = (FileInfo) o;

        return fullFileName != null ? fullFileName.equals(fileInfo.fullFileName) : fileInfo.fullFileName == null;

    }

    @Override
    public int hashCode() {
        return fullFileName != null ? fullFileName.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "FileInfo{" +
                "fullFileName='" + fullFileName + '\'' +
                '}';
    }

    public Map getInfo() {
        Map m = new HashMap<String, String>();
        BigDecimal decimal;
        if(file !=null ){
            decimal = new BigDecimal(file.length() * 1.0d / 1024);
            decimal = decimal.setScale(0, RoundingMode.UP);
        }else{
            decimal = BigDecimal.ZERO;
        }
        m.put("fullName", fullFileName);
        m.put("fileSize", decimal.doubleValue());
        return m;
    }
}
