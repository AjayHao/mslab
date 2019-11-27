package com.ajayhao.mslab.crawler.helper;

import com.ajayhao.mslab.crawler.config.AmacCrawlerConfig;
import com.ajayhao.mslab.crawler.dto.AmacExecutiveInfo;
import com.ajayhao.mslab.crawler.dto.AmacFundInfo;
import com.ajayhao.mslab.crawler.dto.AmacManagerCreditInfo;
import com.ajayhao.mslab.crawler.dto.AmacManagerInfo;
import com.ajayhao.mslab.crawler.remote.enums.AmacCreditInfoType;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.ajayhao.mslab.crawler.constant.CrawlerConstants.DEFAULT_MAP_SIZE;
import static com.ajayhao.mslab.crawler.remote.constant.RemoteAmacTitle.*;
import static com.ajayhao.mslab.crawler.remote.constant.RemoteConstant.*;


/**
 * AmacCrawlerHelper
 * 基金业协会爬虫辅助类
 * @author Ajay Hao
 * @date 2018/7/20 10:48
 * @version 1.0
 **/
@Component
public class AmacCrawlerHelper {

    private final String charset = "UTF-8";

    @Autowired
    private AmacCrawlerConfig amacCrawlerConfig;


    public Map<String, String> buildAmacKeywordQueryParam(String keyword) {
        Map<String, String> paramMap = new HashMap<>(DEFAULT_MAP_SIZE);
        paramMap.put(AMAC_PARAM_KEY, keyword);
        return paramMap;
    }

    public String buildAmacManagerDefaultUrl() {
        Integer defaultPageNo = amacCrawlerConfig.getPageNo() != null ? amacCrawlerConfig.getPageNo() : AMAC_DEFAULT_PAGE_NO;
        Integer defaultSize = amacCrawlerConfig.getSize() != null ? amacCrawlerConfig.getSize() : AMAC_DEFAULT_PAGE_SIZE;
        return buildAmacManagerUrl(defaultPageNo, defaultSize);
    }

    public String buildAmacManagerUrl(Integer pageNo, Integer size) {
        return String.format(AMAC_MANAGER_URL, String.valueOf(RandomUtils.nextDouble()), pageNo, size);
    }

    public String buildAmacFundDefaultUrl() {
        Integer defaultPageNo = amacCrawlerConfig.getPageNo() != null ? amacCrawlerConfig.getPageNo() : AMAC_DEFAULT_PAGE_NO;
        Integer defaultSize = amacCrawlerConfig.getSize() != null ? amacCrawlerConfig.getSize() : AMAC_DEFAULT_PAGE_SIZE;
        return buildAmacFundUrl(defaultPageNo, defaultSize);
    }

    public String buildAmacFundUrl(Integer pageNo, Integer size) {
        return String.format(AMAC_FUND_URL, String.valueOf(RandomUtils.nextDouble()), pageNo, size);
    }
    /**
     * 解析管理人明细
     */
    public AmacManagerInfo resolveAmacManagerInfoResp(Document document) {
        Elements elements = document.select("div.m-manager-list>table>tbody>tr>td.td-title");
        AmacManagerInfo amacManagerInfo = null;
        if (CollectionUtils.isNotEmpty(elements)) {
            amacManagerInfo = new AmacManagerInfo();
            for(Element titleElement : elements) {
                //诚信信息
                if (TITLE_M_INTEGRITY_INFO.equals(titleElement.html())) {
                    Element integrityElement = titleElement.nextElementSibling();
                    String integrityInfo = integrityElement.select("span.htmltext").html();
                    amacManagerInfo.setIntegrityInfo(integrityInfo);
                }
                //管理人名称
                if (TITLE_M_MANANGER_NAME.equals(titleElement.html())) {
                    Element contentElement = titleElement.nextElementSibling();
                    String managerName = contentElement.select("#complaint1").html();
                    amacManagerInfo.setManagerName(HtmlEscaper.unescape(managerName));
                }

                //英文全称
                if (TITLE_M_MANAGER_NAME_EN.equals(titleElement.html())) {
                    Element contentElement = titleElement.nextElementSibling();
                    String managerEnName = contentElement.html();
                    amacManagerInfo.setManagerNameEn(HtmlEscaper.unescape(managerEnName));
                }

                //登记编号
                if (TITLE_M_REG_NO.equals(titleElement.html())) {
                    Element contentElement = titleElement.nextElementSibling();
                    String regNo = contentElement.html();
                    amacManagerInfo.setRegisterNo(HtmlEscaper.unescape(regNo));
                }

                //组织机构代码
                if (TITLE_M_ORG_NO.equals(titleElement.html())) {
                    Element contentElement = titleElement.nextElementSibling();
                    String orgNo = contentElement.html();
                    amacManagerInfo.setOrgNo(HtmlEscaper.unescape(orgNo));
                }

                //登记时间
                if (TITLE_M_REG_DATE.equals(titleElement.html())) {
                    Element contentElement = titleElement.nextElementSibling();
                    String registerDate = contentElement.html();
                    amacManagerInfo.setRegisterDate(HtmlEscaper.unescape(registerDate));
                }

                //成立时间
                if (TITLE_M_ESTAB_DATE.equals(titleElement.html())) {
                    Element contentElement = titleElement.nextElementSibling();
                    String establishDate = contentElement.html();
                    amacManagerInfo.setEstablishDate(HtmlEscaper.unescape(establishDate));
                }

                //注册地址
                if (TITLE_M_REG_ADDR.equals(titleElement.html())) {
                    Element contentElement = titleElement.nextElementSibling();
                    String registerAddress = contentElement.html();
                    amacManagerInfo.setRegisterAddress(HtmlEscaper.unescape(registerAddress));
                }

                //办公地址
                if (TITLE_M_OFFICE_ADDR.equals(titleElement.html())) {
                    Element contentElement = titleElement.nextElementSibling();
                    String officeAddress = contentElement.html();
                    amacManagerInfo.setOfficeAddress(HtmlEscaper.unescape(officeAddress));
                }

                //注册资本(万元)(人民币)
                if (TITLE_M_SUB_CAPITAL.equals(titleElement.html())) {
                    Element contentElement = titleElement.nextElementSibling();
                    String subsCaptail = contentElement.html();
                    if (StringUtils.isNotBlank(subsCaptail)) {
                        amacManagerInfo.setSubscribedCapital(new BigDecimal(HtmlEscaper.unescape(subsCaptail.replaceAll(",", ""))));
                    }
                }

                //实缴资本(万元)(人民币)
                if (TITLE_M_PAIDIN_CAPITAL.equals(titleElement.html())) {
                    Element contentElement = titleElement.nextElementSibling();
                    String paidInCaptail = contentElement.html();
                    if (StringUtils.isNotBlank(paidInCaptail)) {
                        amacManagerInfo.setPaidInCapital(new BigDecimal(HtmlEscaper.unescape(paidInCaptail.replaceAll(",", ""))));
                    }
                }

                //企业性质
                if (TITLE_M_ENT_TYPE.equals(titleElement.html())) {
                    Element contentElement = titleElement.nextElementSibling();
                    String entType = contentElement.html();
                    amacManagerInfo.setEntType(HtmlEscaper.unescape(entType));
                }

                //注册资本实缴比例
                if (TITLE_M_SUB_RATIO.equals(titleElement.html())) {
                    Element contentElement = titleElement.nextElementSibling();
                    String subscribeRatio = contentElement.html();
                    if (StringUtils.isNotBlank(subscribeRatio)) {
                        amacManagerInfo.setSubscribeRatio(new BigDecimal(HtmlEscaper.unescape(subscribeRatio.replaceAll("%|,", ""))));
                    }
                }

                //管理基金主要类别
                if (TITLE_M_INVEST_TYPE.equals(titleElement.html())) {
                    Element contentElement = titleElement.nextElementSibling();
                    String investType = contentElement.html();
                    if (StringUtils.isNotBlank(investType)) {
                        amacManagerInfo.setInvestType(HtmlEscaper.unescape(investType));
                    }
                }

                //全职员工人数
                if (titleElement.childNodeSize() > 1) {
                    Element subtitleElement = (Element)titleElement.childNode(0);
                    if (TITLE_M_EMPLOYEE_NUM.equals(subtitleElement.html())) {
                        Element contentElement = titleElement.nextElementSibling();
                        String employeeNum = contentElement.html();
                        if (StringUtils.isNotBlank(employeeNum)) {
                            amacManagerInfo.setEmployeeNum(Integer.parseInt(employeeNum.replaceAll(",", "")));
                        }
                    }
                }

                //是否会员
                if (TITLE_M_MEMBER_FLAG.equals(titleElement.html())) {
                    Element contentElement = titleElement.nextElementSibling();
                    String memberFlag = contentElement.html();
                    if (StringUtils.isNotBlank(memberFlag)) {
                        amacManagerInfo.setMemberFlag(memberFlag);
                    }
                }

                //当前会员类型
                if (TITLE_M_MEMBER_TYPE.equals(titleElement.html())) {
                    Element contentElement = titleElement.nextElementSibling();
                    String memberType = contentElement.html();
                    if (StringUtils.isNotBlank(memberType)) {
                        amacManagerInfo.setMemberType(memberType);
                    }
                }

                //入会时间
                if (TITLE_M_MEMBER_DATE.equals(titleElement.html())) {
                    Element contentElement = titleElement.nextElementSibling();
                    String memberDate = contentElement.html();
                    if (StringUtils.isNotBlank(memberDate)) {
                        amacManagerInfo.setMemberDate(memberDate);
                    }
                }

                //法人代表
                if (TITLE_M_FR_NAME.equals(titleElement.html())) {
                    Element contentElement = titleElement.nextElementSibling();
                    String frName = contentElement.html();
                    if (StringUtils.isNotBlank(frName)) {
                        amacManagerInfo.setFrName(frName);
                    }
                }
            }
        }
        return amacManagerInfo;
    }

    /**
     * 解析amac高管信息
     * @param document
     * @return
     */
    public List<AmacExecutiveInfo> resolveAmacEmployerInfoResp(Document document) {
        List<AmacExecutiveInfo> amacEmployerInfoList = null;
        String regNo = null;
        Elements outerElements = document.select("div.m-manager-list>table>tbody>tr>td.td-title");
        if (CollectionUtils.isNotEmpty(outerElements)) {
            for (Element titleElement : outerElements) {
                //协会登记编号
                if (TITLE_M_REG_NO.equals(titleElement.html())) {
                    Element contentElement = titleElement.nextElementSibling();
                    regNo = contentElement.html();
                }

                if (TITLE_M_EXECUTIVE.equals(titleElement.html())) {
                    Element outerExecutivesElement = titleElement.nextElementSibling();
                    Elements elements = outerExecutivesElement.select("td>table:eq(0)>tbody>tr");
                    if (CollectionUtils.isNotEmpty(elements)) {
                        amacEmployerInfoList = new ArrayList<>();
                        //解析高管信息
                        for (Element e : elements) {
                            Elements executiveElements = e.select("tr>td");
                            if (CollectionUtils.isNotEmpty(executiveElements)) {
                                AmacExecutiveInfo amacEmployerInfo = new AmacExecutiveInfo();
                                amacEmployerInfo.setRegisterNo(regNo);
                                String employerName = executiveElements.get(0).html();
                                amacEmployerInfo.setExecutiveName(employerName);
                                String position = executiveElements.get(1).html();
                                amacEmployerInfo.setPosition(position);
                                String qualiStr = executiveElements.get(2).html();
                                int leftB = qualiStr.indexOf("(");
                                int rightB = qualiStr.indexOf(")");
                                if (leftB > 0) {
                                    String qualification = qualiStr.substring(0, leftB);
                                    String qualifiedBy = qualiStr.substring(leftB + 1, rightB);
                                    amacEmployerInfo.setQualification(qualification);
                                    amacEmployerInfo.setQualifiedBy(qualifiedBy);
                                } else {
                                    amacEmployerInfo.setQualification(qualiStr);
                                }
                                amacEmployerInfoList.add(amacEmployerInfo);
                            }
                        }
                    }
                }
            }
        }
        return amacEmployerInfoList;
    }

    /**
     * 解析基金明细
     */
    public AmacFundInfo resolveAmacFundInfoResp(Document document) {
        Elements elements = document.select("div.m-manager-list>table>tbody>tr>td.td-title");
        AmacFundInfo amacFundInfo = null;
        if (CollectionUtils.isNotEmpty(elements)) {
            amacFundInfo = new AmacFundInfo();
            for(Element titleElement : elements) {
                //基金名称
                if (TITLE_F_FUND_NAME.equals(titleElement.html())) {
                    Element contentElement = titleElement.nextElementSibling();
                    String fundName = contentElement.html();
                    amacFundInfo.setFundName(HtmlEscaper.unescape(fundName));
                }

                //基金编号
                if (TITLE_F_FUND_NO.equals(titleElement.html())) {
                    Element contentElement = titleElement.nextElementSibling();
                    String fundNo = contentElement.html();
                    amacFundInfo.setFundNo(HtmlEscaper.unescape(fundNo));
                }

                //成立时间
                if (TITLE_F_ESTAB_DATE.equals(titleElement.html())) {
                    Element contentElement = titleElement.nextElementSibling();
                    String establishDate = contentElement.html();
                    amacFundInfo.setEstablishDate(HtmlEscaper.unescape(establishDate));
                }

                //备案时间
                if (TITLE_F_PUT_ON_RECORD_DATE.equals(titleElement.html())) {
                    Element contentElement = titleElement.nextElementSibling();
                    String putOnRecordDate = contentElement.html();
                    amacFundInfo.setPutOnRecordDate(HtmlEscaper.unescape(putOnRecordDate));
                }

                //基金备案阶段
                if (TITLE_F_PUT_ON_RECORD_STAGE.equals(titleElement.html())) {
                    Element contentElement = titleElement.nextElementSibling();
                    String putOnRecordStage = contentElement.html();
                    amacFundInfo.setPutOnRecordStage(HtmlEscaper.unescape(putOnRecordStage));
                }

                //基金类型
                if (TITLE_F_FUND_TYPE.equals(titleElement.html())) {
                    Element contentElement = titleElement.nextElementSibling();
                    String fundType = contentElement.html();
                    amacFundInfo.setFundType(HtmlEscaper.unescape(fundType));
                }

                //基金管理人名称
                if (TITLE_F_MANAGER_NAME.equals(titleElement.html())) {
                    Element managerNode = titleElement.nextElementSibling();
                    if (managerNode.child(0) != null) {
                        amacFundInfo.setManagerName(HtmlEscaper.unescape(managerNode.child(0).html()));
                    } else {
                        amacFundInfo.setManagerName(HtmlEscaper.unescape(managerNode.html()));
                    }
                }

                //管理类型
                if (TITLE_F_MANAGER_TYPE.equals(titleElement.html())) {
                    Element contentElement = titleElement.nextElementSibling();
                    String managerType = contentElement.html();
                    amacFundInfo.setManagerType(HtmlEscaper.unescape(managerType));
                }

                //托管人名称
                if (TITLE_F_MANDATOR_NAME.equals(titleElement.html())) {
                    Element contentElement = titleElement.nextElementSibling();
                    String mandatorName = contentElement.html();
                    if (StringUtils.isNotBlank(mandatorName)) {
                        amacFundInfo.setMandatorName(HtmlEscaper.unescape(mandatorName));
                    }
                }

                //运作状态
                if (TITLE_F_WORKING_STATE.equals(titleElement.html())) {
                    Element contentElement = titleElement.nextElementSibling();
                    String workingState = contentElement.html();
                    if (StringUtils.isNotBlank(workingState)) {
                        amacFundInfo.setWorkingState(HtmlEscaper.unescape(workingState));
                    }
                }

                //基金信息最后更新时间
                if (TITLE_F_LATEST_UPDATE_DATE.equals(titleElement.html())) {
                    Element contentElement = titleElement.nextElementSibling();
                    String latestUpdateDate = contentElement.html();
                    amacFundInfo.setLatestUpdateDate(HtmlEscaper.unescape(latestUpdateDate));
                }

                //协会特别提示（针对基金）
                if (TITLE_F_SPECIAL_TIPS.equals(titleElement.html())) {
                    Element contentElement = titleElement.nextElementSibling();
                    String speicalTips = contentElement.html();
                    if (StringUtils.isNotBlank(speicalTips)) {
                        amacFundInfo.setSpecialTips(speicalTips);
                    }
                }
            }
        }
        return amacFundInfo;
    }

    /**
     * 解析amac管理人诚信信息
     * @param document
     * @return
     */
    public List<AmacManagerCreditInfo> resolveAmacCreditInfoResp(Document document) {
        Elements elements = document.select("div.m-manager-list>table>tbody>tr>td.td-title");
        List<AmacManagerCreditInfo> amacManagerCreditList = null;
        if (CollectionUtils.isNotEmpty(elements)) {
            amacManagerCreditList = new ArrayList<>();
            Element regNoElement = null, integrityElement = null;
            String regNo = null;
            for(Element titleElement : elements) {
                //诚信信息
                if (TITLE_M_INTEGRITY_INFO.equals(titleElement.html())) {
                    //table类型
                    integrityElement = titleElement.nextElementSibling();
                }

                //协会登记编号
                if (TITLE_M_REG_NO.equals(titleElement.html())) {
                    regNo = titleElement.nextElementSibling().html();
                }
            }

            if(integrityElement != null) {
                //每项一条
                Elements integrityInfos = integrityElement.select("table>tbody>tr");
                if (integrityInfos != null && integrityInfos.size() > 0) {
                    for (int i = 0; i < integrityInfos.size(); i++) {
                        AmacManagerCreditInfo creditInfo = resolveAmacCreditInfo(regNo,integrityInfos.get(i));
                        amacManagerCreditList.add(creditInfo);
                    }
                }
            }
        }
        return amacManagerCreditList;
    }

    private AmacManagerCreditInfo resolveAmacCreditInfo(String regNo, Element element) {
        AmacManagerCreditInfo creditInfo = null;
        if(element != null) {
            creditInfo = new AmacManagerCreditInfo();
            creditInfo.setRegisterNo(regNo);
            Element tdElement = element.child(0);
            String creditTypeStr = tdElement.child(0).html();
            AmacCreditInfoType creditInfoType = (AmacCreditInfoType.getByMessage(creditTypeStr) == null) ?
                    AmacCreditInfoType.OTHERS : AmacCreditInfoType.getByMessage(creditTypeStr);
            //中文写入
            creditInfo.setCreditType(creditTypeStr);
            String creditInfoStr;
            if (AmacCreditInfoType.LOST_CONTACT == creditInfoType) {
                creditInfoStr = resolveLostContactStr(tdElement);
            }else{
                creditInfoStr = tdElement.child(1).html();
            }
            creditInfo.setCreditInfo(creditInfoStr);
        }
        return creditInfo;
    }

    private String resolveLostContactStr(Element tdElement) {
        StringBuffer sb = new StringBuffer(tdElement.childNode(1).toString())
                .append(tdElement.childNode(2).outerHtml())
                .append(tdElement.childNode(3).toString());
        return sb.toString().trim();
    }
}
