package com.ajayhao.mslab.crawler.helper;


import com.ajayhao.mslab.crawler.dto.mail.EmailConfInfo;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeUtility;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

/**
 * @author Ajay Hao 2020/05/18.
 */

public class MailParser {
    private static Logger logger = LoggerFactory.getLogger(MailParser.class);

    private static final int PAGE_SIZE = 5;


    public static Store connectMailServer(EmailConfInfo cfgPO) throws MessagingException {
        Properties props = new Properties();
        props.setProperty("mail.store.protocol", cfgPO.getProtocol());
        props.setProperty("mail.imap.host", cfgPO.getHost());
        props.setProperty("mail.imap.port", String.valueOf(cfgPO.getPort()));
        props.setProperty("mail.mime.address.strict", "false");
        Session session = Session.getInstance(props);
        //FIXME 生产环境debug需要关闭
        session.setDebug(false);
        Store store = session.getStore();
        store.connect(cfgPO.getHost(), cfgPO.getPort(), cfgPO.getUsername(), cfgPO.getPassword());
        return store;
    }

    public static List<Folder> parseFolderList(Folder root) {
        List<Folder> result = new ArrayList<>();
        if (!StringUtils.isEmpty(root.getName())) {
            result.add(root);
        }
        try {
            for (Folder f : root.list()) {
                result.addAll(parseFolderList(f));
            }
            return result;
        } catch (Exception e) {
            return result;
        }
    }


    public static List<Message> getMailList(Folder folder, Date begin, Date end, String subjectQueryName) throws Exception {
        int count = folder.getMessageCount();
        List<Message> mails = new ArrayList<>();
        int endIndex = count;
        while (true) {
            int beginIndex = endIndex - PAGE_SIZE + 1;
            if (beginIndex < 1) {
                beginIndex = 1;
            }
            if (endIndex - beginIndex < 0) {
                break;
            }
            Message[] messages = folder.getMessages(beginIndex, endIndex);

            boolean outRange = false;
            for (int length = messages.length, i = length - 1; i > -1; i--) {
                String subject = messages[i].getSubject();
                Date sendDate = messages[i].getReceivedDate();
                if (sendDate == null) {
                    sendDate = messages[i].getSentDate();
                }
                if (sendDate == null) {
                    continue;
                }
                if (sendDate.compareTo(end) > 0) {
                    continue;
                }
                if (sendDate.compareTo(begin) < 0) {
                    outRange = true;
                    continue;
                }
                if (!StringUtils.isEmpty(subjectQueryName)) {
                    if (subject.contains(subjectQueryName)) {
                        mails.add(messages[i]);
                    }
                } else {
                    mails.add(messages[i]);
                }
            }
            endIndex = endIndex - PAGE_SIZE;
            if (outRange) {
                break;
            }
        }
        return mails;
    }


    public static void analyzeByMimeMessage(Message message/*, final EmailPO emailPO*/) throws Exception {
        String from = null;
        try {
            from = parseFrom(message);
        } catch (Exception e) {
            logger.error("解析发件人异常", e);
            throw e;
        }

        String to = null;
        try {
            to = parseMailAddress(message, "to");
        } catch (Exception e) {
            logger.error("解析收件人异常", e);
            throw e;
        }

        String cc = null;
        try {
            cc = parseMailAddress(message, "cc");
        } catch (Exception e) {
            logger.error("解析抄送人异常", e);
            throw e;
        }

        String bcc = null;
        try {
            bcc = parseMailAddress(message, "bcc");
        } catch (Exception e) {
            logger.error("解析密送人异常", e);
            throw e;
        }

        String content = null;
        try {
            content = parseMailContent(message);
        } catch (Exception e) {
            logger.error("解析邮件正文异常", e);
            throw e;
        }

        List<EmailAttachPO> emailAttachPOList = new ArrayList<>();
        try {
            parseMailAttaches(message, emailAttachPOList);
        } catch (Exception e) {
            log.error("解析邮件附件异常", e);
            emailPO.setStatus(MailStatusEnum.ATTACH_PARSE_FAILDE.getCode());
        }
        emailPO.setFrom(from);
        emailPO.setTo(to);
        emailPO.setCopy(cc);
        emailPO.setbCopy(bcc);
        emailPO.setContent(content);
        if(!emailAttachPOList.isEmpty()) {
            emailPO.setAttachPath(emailAttachPOList);
        }
    }

    /**
     * 解析eml字符串
     * @param message
     * @return
     */
    public static String parseEmlStr(Message message) throws IOException, MessagingException {
        String emlStr = null;
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            message.writeTo(baos);
            emlStr = baos.toString();
            MailCommonUtil.close(baos);
        } catch (Exception e) {
            logger.error("从Message抽取eml信息异常", e);
            throw e;
        }
        return emlStr;
    }


    /**
     * 获得发件人的地址和姓名
     */
    private static String parseFrom(final Message message) throws Exception {
        InternetAddress address[] = (InternetAddress[]) message.getFrom();
        String addr = (ArrayUtils.isNotEmpty(address) && address[0] != null) ? address[0].getAddress() : null;
        if (addr == null) {
            addr = "";
        }
        String personal = (ArrayUtils.isNotEmpty(address) && address[0] != null) ? address[0].getPersonal() : null;
        if (personal == null) {
            personal = addr;
        }
        return String.format("%s<%s>", personal, addr);
    }

    /**
     * 获得邮件的收件人，抄送，和密送的地址和姓名，根据所传递的参数的不同 "TO"----收件人 "CC"---抄送人地址 "BCC"---密送人地址
     */
    private static String parseMailAddress(final Message message, String type) throws Exception {
        String mailaddr = "";
        String addtype = type.toUpperCase();
        InternetAddress[] address = null;
        if (addtype.equals("TO") || addtype.equals("CC") || addtype.equals("BCC")) {
            if (addtype.equals("TO")) {
                address = (InternetAddress[]) message.getRecipients(Message.RecipientType.TO);
            } else if (addtype.equals("CC")) {
                address = (InternetAddress[]) message.getRecipients(Message.RecipientType.CC);
            } else {
                address = (InternetAddress[]) message.getRecipients(Message.RecipientType.BCC);
            }
            if (ArrayUtils.isNotEmpty(address)) {
                for (int i = 0; i < address.length; i++) {
                    if(address[i] != null) {
                        String addr = address[i].getAddress();
                        if (addr == null) {
                            addr = "";
                        } else {
                            addr = MimeUtility.decodeText(addr);
                        }
                        String personal = address[i].getPersonal();
                        if (personal == null) {
                            personal = addr;
                        } else {
                            personal = MimeUtility.decodeText(personal);
                        }
                        String compositeAddr = personal + "<" + addr + ">";
                        mailaddr += ";" + compositeAddr;
                    }
                }
                if (StringUtils.isNotEmpty(mailaddr)) {
                    mailaddr = mailaddr.substring(1);
                }
            }
        } else {
            throw new Exception("Error emailaddr type!");
        }
        return mailaddr;
    }


    /**
     * 解析邮件，把得到的邮件内容保存到一个StringBuffer对象中，解析邮件 主要是根据MimeType类型的不同执行不同的操作，一步一步的解析
     */
    private static String parseMailContent(Part part) throws Exception {
        MailContent mailContent = new MailContent();
        parseMailContent(part, mailContent);
        if (StringUtils.isNotBlank(mailContent.getHtmlTextStr())) {
            return mailContent.getHtmlTextStr();
        } else {
            return mailContent.getPlainTextStr();
        }
    }

    private static void parseMailContent(final Part part, final MailContent content) throws Exception {
        String contentType = part.getContentType();
        int nameIndex = contentType.indexOf("name");
        boolean containsName = (nameIndex != -1);
        if (part.isMimeType("text/plain") && !containsName) {
            content.appendPlainText((String) part.getContent());
        } else if (part.isMimeType("text/html") && !containsName) {
            content.appendHtmlText((String) part.getContent());
        } else if (part.isMimeType("multipart/*")) {
            Multipart multipart = (Multipart) part.getContent();
            int counts = multipart.getCount();
            for (int i = 0; i < counts; i++) {
                parseMailContent(multipart.getBodyPart(i), content);
            }
        } else if (part.isMimeType("message/rfc822")) {
            parseMailContent((Part) part.getContent(), content);
        }
        // else 其他待处理
    }

    private static class MailContent {
        private StringBuffer plainText;

        private StringBuffer htmlText;

        MailContent() {
            plainText = new StringBuffer();
            htmlText = new StringBuffer();
        }

        String getPlainTextStr() {
            return plainText.toString();
        }

        String getHtmlTextStr() {
            return htmlText.toString();
        }

        void appendPlainText(String content) {
            this.plainText = this.plainText.append(content);
        }

        void appendHtmlText(String content) {
            this.htmlText = this.htmlText.append(content);
        }
    }
}
