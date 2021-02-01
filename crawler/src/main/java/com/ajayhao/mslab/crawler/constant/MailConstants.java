package com.ajayhao.mslab.crawler.constant;

import java.util.Arrays;
import java.util.List;

/**
 * MailConstants
 * <p>
 * 邮件常量
 *
 * @author Ajay Hao
 * @version 1.0
 * @date 2020/5/18 16:54
 **/
public class MailConstants {

    public static final int MAX_CONTENT_LENGTH = 3900;
    public static final int MAX_FILENAME_LENGTH = 200;

    public static final List<String> FILTER_FOLDER_LIST = Arrays.asList(
       "Drafts",
       "Sent Items",
       "Trash",
       "Junk E-mail",
       "Virus Items"
    );
}
