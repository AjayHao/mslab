package com.ajayhao.simpleboot.service.antxchecker;

import com.ajayhao.core.enumtype.BizCode;
import com.ajayhao.core.exception.BaseException;
import com.ajayhao.simpleboot.dto.antxchecker.AntxCheckDetail;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringReader;
import java.util.*;

/**
 * Created by haozhenjie on 2017/9/18.
 */

@Service
public class AntxCheckerServiceImpl implements AntxCheckerService{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public List<AntxCheckDetail> checkAntx(String inputPath, String antxContent){
        List<AntxCheckDetail> antxCheckDetailList = new ArrayList<AntxCheckDetail>();
        Set<String> keys = fetchKeys(antxContent);
        List<File> autoConfigs = getAutoConfigFiles(inputPath);
        if(CollectionUtils.isEmpty(autoConfigs)){
            throw new BaseException(BizCode.FILE_NOT_EXIST, "目录下找不到auto-config文件");
        }

        for(File autoConfigFile : autoConfigs){
            List<AntxCheckDetail> matchList = parseAutoConfigFile(autoConfigFile, keys);
            antxCheckDetailList.addAll(matchList);
        }

        return antxCheckDetailList;
    }


    private List<AntxCheckDetail> parseAutoConfigFile(File autoConfigFile, Set<String> keySet) {
        List<AntxCheckDetail> antxCheckDetails = new ArrayList<AntxCheckDetail>();
        //创建SAXReader对象
        SAXReader reader = new SAXReader();
        try {
            Document document = reader.read(autoConfigFile);
            //获取根节点元素对象
            Element root = document.getRootElement();
            if(!"config".equals(root.getName())){
                throw new BaseException(BizCode.XML_PARSE_ERROR, autoConfigFile.getName(), "找不到config节点");
            }

            List<Element> groups = root.elements();
            if (CollectionUtils.isEmpty(groups)) {
                throw new BaseException(BizCode.XML_PARSE_ERROR, autoConfigFile.getName(), "找不到group节点");
            }
            for(Element group : root.elements()){
                List<Element> propertyNodes = group.elements("property");
                if (!CollectionUtils.isEmpty(propertyNodes)) {
                    for (Element propertyNode : propertyNodes) {
                        Attribute property = propertyNode.attribute("name");
                        if (property != null) {
                            String key = property.getValue();
                            AntxCheckDetail detail = new AntxCheckDetail();
                            if (!keySet.contains(key)) {
                                detail.setKeyName(key);
                                detail.setState(0);
                                detail.setResult("未配置");
                                antxCheckDetails.add(detail);
                                keySet.remove(key);
                            }
                        }
                    }
                }
            }
            return antxCheckDetails;
        } catch (DocumentException e) {
            e.printStackTrace();
            throw new BaseException(BizCode.XML_PARSE_ERROR, autoConfigFile.getName(), e.getMessage());
        }
    }

    private Set<String> fetchKeys(String antxContent) {
        Properties props = new Properties();
        try {
            StringReader reader = new StringReader(antxContent);
            props.load(reader);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return props.stringPropertyNames();
    }

    private List<File> getAutoConfigFiles(String inputPath){
        File rootDir = new File(inputPath);
        List<File> autoConfigFiles = new ArrayList<File>();
        Queue<File> queue = new LinkedList<File>();
        File[] files = rootDir.listFiles();
        queue.addAll(Arrays.asList(files));
        while(!queue.isEmpty()){
            File f = queue.poll();
            if(f.isFile()){
                String fileName = f.getName().toLowerCase();
                if(fileName.contains("auto-config") && !f.getAbsolutePath().toLowerCase().contains("test") && !f.getAbsolutePath().toLowerCase().contains("target")){
                    autoConfigFiles.add(f);
                }
            }else if(f.isDirectory()){
                queue.addAll(Arrays.asList(f.listFiles()));
            }
        }
        return autoConfigFiles;
    }
}
