package com.ajayhao.mslab.weixinwork.service;


import com.ajayhao.mslab.weixinwork.utils.weixin.aes.AesException;
import com.ajayhao.mslab.weixinwork.utils.weixin.aes.WXBizMsgCrypt;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;

/**
 * WeixinWorkService
 * <p>
 *
 * 企业名称： 小而美信息技术有限公司（测试号）
 * corpid: ww012d62799cd8e96d
 * secret: A6WhNC3szKHVF1CJo5kHfAB2aOd76jRGg1kkzj01ttc
 * AgentId: 1000002
 * 同步助手secret: Xe0zK24GGEQJIKU4oqh5_DUtiIzYBMC9YTtIPkO7k3A
 *
 * @author Ajay Hao
 * @version 1.0
 * @date 2020/5/10 17:06
 */

@Service
public class WeixinWorkService {

    String corpId = "ww012d62799cd8e96d";
    String verifyToken = "tdnNuEzGdvAPpz";
    String verifyEncodingAESKey = "wPYlmdYgR8DyGXy0v86RAUl67RWhIpWy0eRNtb77aIp";
    String agentId = "1000002";

    String replyTextTemplate = "<xml><ToUserName><![CDATA[%s]]></ToUserName><FromUserName><![CDATA[%s]]></FromUserName><CreateTime>%s</CreateTime><MsgType><![CDATA[text]]></MsgType><Content><![CDATA[%s]]></Content><MsgId>%s</MsgId><AgentID>%s</AgentID></xml>";

    public String verifyCallbackUrl(String msgSignature, String timestamp, String nonce, String echoStr) throws AesException {

        WXBizMsgCrypt wxcpt = new WXBizMsgCrypt(verifyToken, verifyEncodingAESKey, corpId);

        //需要返回的明文
        String sEchoStr = null;
        try {
            sEchoStr = wxcpt.verifyURL(msgSignature, timestamp, nonce, echoStr);
            System.out.println("verifyurl echostr: " + sEchoStr);
            // 验证URL成功，将sEchoStr返回
        } catch (Exception e) {
            //验证URL失败，错误原因请查看异常
            e.printStackTrace();
        }

        return sEchoStr;

    }


    public String handleReqMsg(String msgSignature, String timestamp, String nonce, String messageData) throws Exception{
        String reqData = decryptRequestMsg(msgSignature, timestamp, nonce, messageData);
        return encryptReplyMsg(timestamp, nonce, reqData);
    }

    /* --------------- 对用户回复的消息解密---------------
		用户回复消息或者点击事件响应时，企业会收到回调消息，此消息是经过企业微信加密之后的密文以post形式发送给企业，密文格式请参考官方文档
		假设企业收到企业微信的回调消息如下：
		POST /cgi-bin/wxpush? msg_signature=477715d11cdb4164915debcba66cb864d751f3e6&timestamp=1409659813&nonce=1372623149 HTTP/1.1
		Host: qy.weixin.qq.com
		Content-Length: 613
		<xml>		<ToUserName><![CDATA[wx5823bf96d3bd56c7]]></ToUserName><Encrypt><![CDATA[RypEvHKD8QQKFhvQ6QleEB4J58tiPdvo+rtK1I9qca6aM/wvqnLSV5zEPeusUiX5L5X/0lWfrf0QADHHhGd3QczcdCUpj911L3vg3W/sYYvuJTs3TUUkSUXxaccAS0qhxchrRYt66wiSpGLYL42aM6A8dTT+6k4aSknmPj48kzJs8qLjvd4Xgpue06DOdnLxAUHzM6+kDZ+HMZfJYuR+LtwGc2hgf5gsijff0ekUNXZiqATP7PF5mZxZ3Izoun1s4zG4LUMnvw2r+KqCKIw+3IQH03v+BCA9nMELNqbSf6tiWSrXJB3LAVGUcallcrw8V2t9EL4EhzJWrQUax5wLVMNS0+rUPA3k22Ncx4XXZS9o0MBH27Bo6BpNelZpS+/uh9KsNlY6bHCmJU9p8g7m3fVKn28H3KDYA5Pl/T8Z1ptDAVe0lXdQ2YoyyH2uyPIGHBZZIs2pDBS8R07+qN+E7Q==]]></Encrypt>
		<AgentID><![CDATA[218]]></AgentID>
		</xml>

		企业收到post请求之后应该
		1.解析出url上的参数，包括消息体签名(msg_signature)，时间戳(timestamp)以及随机数字串(nonce)
		2.验证消息体签名的正确性。
		3.将post请求的数据进行xml解析，并将<Encrypt>标签的内容进行解密，解密出来的明文即是用户回复消息的明文，明文格式请参考官方文档
		第2，3步可以用企业微信提供的库函数DecryptMsg来实现。
	*/
    private String decryptRequestMsg(String msgSignature, String timestamp, String nonce, String messageData) throws AesException {
        WXBizMsgCrypt wxcpt = new WXBizMsgCrypt(verifyToken, verifyEncodingAESKey, corpId);
        String content = null;
        try {
            String sMsg = wxcpt.decryptMsg(msgSignature, timestamp, nonce, messageData);
            System.out.println("after decrypt msg: " + sMsg);
            // TODO: 解析出明文xml标签的内容进行处理
            // For example:
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            StringReader sr = new StringReader(sMsg);
            InputSource is = new InputSource(sr);
            Document document = db.parse(is);

            Element root = document.getDocumentElement();
            // TODO 看看能解析多少字段
            NodeList nodelist1 = root.getElementsByTagName("Content");
            content = nodelist1.item(0).getTextContent();
            System.out.println("Content：" + content);

        } catch (Exception e) {
            // TODO
            // 解密失败，失败原因请查看异常
            e.printStackTrace();
        }
        return content;
    }


    /* ------------使用示例三：企业回复用户消息的加密---------------
		企业被动回复用户的消息也需要进行加密，并且拼接成密文格式的xml串。
		假设企业需要回复用户的明文如下：
		<xml>
		<ToUserName><![CDATA[mycreate]]></ToUserName>
		<FromUserName><![CDATA[wx5823bf96d3bd56c7]]></FromUserName>
		<CreateTime>1348831860</CreateTime>
		<MsgType><![CDATA[text]]></MsgType>
		<Content><![CDATA[this is a test]]></Content>
		<MsgId>1234567890123456</MsgId>
		<AgentID>128</AgentID>
		</xml>

		为了将此段明文回复给用户，企业应：
		1.自己生成时间时间戳(timestamp),随机数字串(nonce)以便生成消息体签名，也可以直接用从企业微信的post url上解析出的对应值。
		2.将明文加密得到密文。
		3.用密文，步骤1生成的timestamp,nonce和企业在企业微信设定的token生成消息体签名。
		4.将密文，消息体签名，时间戳，随机数字串拼接成xml格式的字符串，发送给企业。
		以上2，3，4步可以用企业微信提供的库函数EncryptMsg来实现。

		<xml><ToUserName><![CDATA[%s]]></ToUserName><FromUserName><![CDATA[%s]]></FromUserName><CreateTime>%s</CreateTime><MsgType><![CDATA[text]]></MsgType><Content><![CDATA[%s]]></Content><MsgId>%s</MsgId><AgentID>%s</AgentID></xml>
	*/
    private String encryptReplyMsg(String timestamp, String nonce, String messageData) throws AesException {
        WXBizMsgCrypt wxcpt = new WXBizMsgCrypt(verifyToken, verifyEncodingAESKey, corpId);
        //TODO messageId可以处理幂等，建议人工管理
        String msgId = "121314";
        String respData = String.format(replyTextTemplate, corpId, "mycreate", System.currentTimeMillis() / 1000, "收到的请求为："+ messageData, msgId, agentId);
        String sEncryptMsg = "";
        try {
            sEncryptMsg = wxcpt.encryptMsg(respData, timestamp, nonce);
            System.out.println("after encrypt sEncrytMsg: " + sEncryptMsg);
        } catch(Exception e) {
            e.printStackTrace();
            // 加密失败
        }

        return sEncryptMsg;
    }
}
