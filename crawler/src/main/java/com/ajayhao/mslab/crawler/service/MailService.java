package com.ajayhao.mslab.crawler.service;

import com.ajayhao.mslab.crawler.dto.mail.EmailConfInfo;
import com.ajayhao.mslab.crawler.helper.MailParser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Store;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.ajayhao.mslab.crawler.constant.MailConstants.FILTER_FOLDER_LIST;

/**
 * MailService
 * <p>
 *
 *
 * @author Ajay Hao
 * @version 1.0
 * @date 2021/1/11 12:11
 */
@Service
@Slf4j
public class MailService {

    @Autowired
    @Qualifier("mailConfigMap")
    private Map<String, EmailConfInfo> mailConfigMap;

    public void downloadMail(String mailAddress, Date begin, Date end, String subjectQueryName) throws Exception {
        log.info("#BEGIN# downloadMail.downloadMail, mailAddress={}, begin={}, end={}", mailAddress, begin, end);
        final EmailConfInfo cfgPo = mailConfigMap.get(mailAddress);
        final Store store = MailParser.connectMailServer(cfgPo);
        int sum = 0;
        try {
            if ("pop3".equals(cfgPo.getProtocol())) {
                Folder folder = store.getFolder("INBOX");
                downMailList(cfgPo, folder, begin, end, subjectQueryName);
            } else if ("imap".equals(cfgPo.getProtocol())) {
                Folder root = store.getDefaultFolder();
                List<Folder> folderList = MailParser.parseFolderList(root);
                for (Folder folder : folderList) {
                    downMailList(cfgPo, folder, begin, end, subjectQueryName);
                }
            } else {
                log.error("未知的邮件收件协议:" + cfgPo.getProtocol());
            }
        } finally {
            store.close();
        }

        log.info("#END# ReceiveEmailDataService.downloadMail, 处理数量:{}",sum);
        //return sum;
    }


    private int downMailList(final EmailConfInfo emailCfg, Folder folder, Date begin, Date end, String subjectQueryName) throws Exception {
        if (FILTER_FOLDER_LIST.contains(folder.getFullName())) {
            log.info("过滤名单邮件文件夹:{}, 本次不解析", folder.getFullName());
            return 0;
        }
        try {
            folder.open(Folder.READ_ONLY);
            List<Message> mails = MailParser.getMailList(folder, begin, end, subjectQueryName);
            log.info("批次待处理邮件总条数:" + mails.size());
            if (!mails.isEmpty()) {
                for (Message message : mails) {
                    try {
                        String subject = message.getSubject();
                        String contentType = message.getContentType();
                        log.info("开始解析邮件: {}, {}", subject, contentType);
                        String emlStr = MailParser.parseEmlStr(message);
                        // Md5码
                        /*String emlMd5 = MD5Utils.getMd5(new ByteArrayInputStream(emlStr.getBytes()));
                        log.info("md5摘要编码: {}", emlMd5);
                        EmailEntity entity = queryEmailByMd5Code(emlMd5);
                        if (entity != null) {
                            log.info("找到相同md5码的邮件, 标识为重复邮件, 不再解析落库：emailId:{}, md5:{}", entity.getSeqId(), entity.getEmlMd5());
                        } else {
                            processMail(emailCfg, message, emlStr, emlMd5);
                        }*/
                        processMail(emailCfg, message, emlStr);
                    } catch (Exception e) {
                        log.error("邮件未能落库，邮件主题及摘要处理异常:{}", e);
                    }
                }
            }
            return mails.size();
        } finally {
            folder.close(false);
        }
    }


    private void processMail(final EmailConfInfo emailCfg, Message message, String emlStr) throws MessagingException {
        String subject = message.getSubject();
        Date sendTime = message.getSentDate() != null ? message.getSentDate() : message.getReceivedDate();
        // 1. 归档eml文本
        /*String emlFileId = archiveEmlData(subject, emlStr);
        emailPO.setEmlFileId(emlFileId);
        emailPO.setMd5(emlMd5);
        emailPO.setMailName(emailCfg.getUsername());
        emailPO.setSubject(subject);
        emailPO.setSendTime(sendTime);
        try {
            emailPO.setResolvedId(((IMAPMessage) message).getMessageID());
        }catch (Exception e){
            log.error("邮箱协议错误，无法转成IMAPMessage",e);
            emailPO.setResolvedId("");
        }
        String mailSeqId = insertMailToDB(emailPO);
        try {
            //2. 解析邮件
            MailParser.analyzeByMimeMessage(message, emailPO);

            //3. 附件归档
            if (CollectionUtils.isNotEmpty(emailPO.getAttachPath())) {
                for (final EmailAttachPO attachPO : emailPO.getAttachPath()) {
                    if (MailAttachStatusEnum.PARSE_SUCCESS != MailAttachStatusEnum.get(attachPO.getAttachStatus())) {
                        emailPO.setStatus(MailStatusEnum.ATTACH_PARSE_FAILDE.getCode());
                    }
                    if (StringUtils.isNotBlank(attachPO.getBase64())) {
                        archiveMailAttachment(mailSeqId, attachPO);
                    }
                }
            }

            //4. 待分拣
            if (StringUtils.isEmpty(emailPO.getStatus())) {
                emailPO.setStatus(MailStatusEnum.WAIT_DISPATCH.getCode());
            }

        } catch (Exception e) {
            log.error("邮件解析过程中出现异常", e);
            emailPO.setStatus(MailStatusEnum.PARSE_FAILDE.getCode());
        } finally {
            //4. 更新解析信息
            updateParsedMailData(mailSeqId, emailPO);
        }*/

        //解析邮件
        MailParser.analyzeByMimeMessage(message);
    }
}
