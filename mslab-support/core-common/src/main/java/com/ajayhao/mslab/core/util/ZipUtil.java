package com.ajayhao.mslab.core.util;

import com.ajayhao.mslab.core.common.exception.BusinessBizException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import static com.ajayhao.mslab.core.common.enums.RespCodeType.FILE_NOT_EXIST;

public class ZipUtil {

    static Logger logger = LoggerFactory.getLogger(ZipUtil.class);

    public static void addZipFile(InputStream fin, String innerPath, ZipOutputStream outputStream,String fileName) throws IOException {
        outputStream.putNextEntry(new ZipEntry(innerPath + File.separator + fileName));
        int len;
        byte[] buffer = new byte[1024];
        // 读入需要下载的文件的内容，打包到zip文件
        while ((len = fin.read(buffer)) > 0) {
            outputStream.write(buffer, 0, len);
        }
        outputStream.flush();
        outputStream.closeEntry();
        fin.close();
    }

    public static void addZipFile(File file,String innerPath,ZipOutputStream outputStream,String fileName) throws IOException {
        if (!file.exists()) {
            logger.warn("文件不存在[{}]",file.getPath());
            throw new BusinessBizException(FILE_NOT_EXIST);
        }
        if(StringUtils.isEmpty(fileName)){
            fileName = file.getName();
        }
        addZipFile(new FileInputStream(file),innerPath,outputStream,fileName);
    }

    /**
     * 生成压缩包
     */
    public static ZipOutputStream createZipOutputStream(File tempZipFile) throws IOException{
        ZipOutputStream outputStream = null;
        if (!tempZipFile.exists()) {
            if(!tempZipFile.createNewFile()){
                logger.error("创建文件失败,File:{}",tempZipFile);
                throw new BusinessBizException(FILE_NOT_EXIST);
            }
        }
        outputStream = new ZipOutputStream(new FileOutputStream(tempZipFile));
        return outputStream;
    }
}
