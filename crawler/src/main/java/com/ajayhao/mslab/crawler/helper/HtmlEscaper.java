package com.ajayhao.mslab.crawler.helper;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.StringEscapeUtils;

/**
 * HtmlEscaper
 *
 * @author Ajay Hao
 * @version 1.0
 * html字符解析
 * @date 2018/7/23 1:51
 **/
public class HtmlEscaper {

    public static String unescape(String htmlStr){
        if(StringUtils.isNotBlank(htmlStr)){
            return StringEscapeUtils.unescapeHtml4(htmlStr)
                            .replaceAll("[\\u00A0]+", "")
                            .replaceAll("\\(","（")
                            .replaceAll("\\)","）")
                            .trim();
        }
        return htmlStr;
    }

}
