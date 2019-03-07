package com.ajayhao.mslab.proxy.controller;

import com.ajayhao.mslab.core.util.ZipUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;
import java.util.zip.ZipOutputStream;

/**
 * ProxyController
 * <p>
 * TODO
 *
 * @author Ajay Hao
 * @version 1.0
 * @date 2018/8/29 16:04
 */
@RestController
@Slf4j
public class ProxyController {

    @RequestMapping("/service-proxy/zip")
    public void testZipDownload() {
        ZipOutputStream zOut = null;
        File tempFile = null;
        try {
            tempFile = File.createTempFile("temp" + UUID.randomUUID().toString(), ".zip");
            zOut = new ZipOutputStream(new FileOutputStream(tempFile));
            String parentPath = "管理人准入\\材料清单";

            ZipUtil.addZipFile(new File("D:\\workDoc\\众安工作资料\\2018年中国区块链产业白皮书.pdf"),
                    parentPath,zOut, "2018年中国区块链产业白皮书.pdf");
            ZipUtil.addZipFile(new File("D:\\workDoc\\众安工作资料\\dubbox使用指南.ppt"),
                    parentPath,zOut, "dubbox使用指南.ppt");
            ZipUtil.addZipFile(new File("D:\\workDoc\\众安工作资料\\whitepaper.pdf"),
                    parentPath,zOut, "whitepaper.pdf");
            log.info(tempFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                zOut.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
