package com.ajayhao.mslab.crawler.helper;

import com.ajayhao.mslab.core.util.HMACUtil;
import com.ajayhao.mslab.crawler.config.ElecreditConfig;
import com.ajayhao.mslab.crawler.dto.EntEquityDetailInfo;
import com.ajayhao.mslab.crawler.dto.EntEquityInfo;
import com.ajayhao.mslab.crawler.dto.EntGsInfo;
import com.ajayhao.mslab.crawler.dto.EntInvestChainInfo;
import com.ajayhao.mslab.crawler.remote.dto.Inv;
import com.ajayhao.mslab.crawler.remote.dto.InvRoad;
import com.ajayhao.mslab.crawler.remote.dto.SaicInv;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import jodd.util.CollectionUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.math.BigDecimal;
import java.util.*;

/**
 * @ClassName ElecreditHelper
 * @Description 元素征信辅助类
 * @Author Ajay Hao
 * @Date 2018/6/22 10:48
 * @Version 1.0
 **/
@Component
public class ElecreditHelper {

    private final String charset = "UTF-8";

    @Autowired
    private ElecreditConfig elecreditConfig;

    /**
    * @Description 构造请求entity
    * @Param [paramMap]
    * @return org.springframework.http.HttpEntity<org.springframework.util.MultiValueMap>
    **/
    public HttpEntity<MultiValueMap> buildRequestEntity(Map<String,String> paramMap){
        //加签加密
        String authStr = getSignRawStr(elecreditConfig.getUserKey(), paramMap);
        //构造请求头
        HttpHeaders requestHeaders = buildRequestHeader(authStr);
        //构造请求体
        MultiValueMap<String, String> requestBody = buildRequestBody(paramMap);
        //构造请求entity
        HttpEntity<MultiValueMap> requestEntity = new HttpEntity<>(requestBody, requestHeaders);
        return requestEntity;
    }

    private MultiValueMap<String,String> buildRequestBody(Map<String, String> paramMap) {
        MultiValueMap<String,String> body = new LinkedMultiValueMap<>();
        for(String key : paramMap.keySet()){
            body.add(key, paramMap.get(key));
        }
        return body;
    }

    private HttpHeaders buildRequestHeader(String auth) {
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        requestHeaders.add("authorization", auth);
        requestHeaders.add("charset", charset);
        return requestHeaders;
    }

    private String getSignRawStr(String userKey, final Map<String,String> params){
        Map<String,String> sortedParams = new TreeMap<>(params);
        StringBuffer sb = new StringBuffer();
        for(String key : sortedParams.keySet()){
            sb = sb.append(key).append(sortedParams.get(key));
        }
        String signRawStr = sb.append(params.get("userid")).toString();
        String authStr = null;
        try {
            authStr = HMACUtil.encode(userKey, signRawStr);
        }catch(Exception e){
            e.printStackTrace();
        }
        return authStr;
    }
    /**
    * @Description 工商信息接口参数
    * @Param entId, category
    * @return java.util.Map<java.lang.String,java.lang.String>
    **/
    public Map<String,String> buildElsaicParam(String entId, String category){
        Map<String,String> paramMap = new HashMap<>();
        paramMap.put("userid",elecreditConfig.getUserId());
        paramMap.put("entid",entId);
        if(StringUtils.isNotBlank(category)) {
            paramMap.put("version", category);
        }
        return paramMap;
    }

    /**
    * @Description 获取企业id接口参数
    * @Param [keyWord, type]
    * @return java.util.Map<java.lang.String,java.lang.String>
    **/
    public Map<String,String> buildGetEntIdParam(String keyWord, String type) {
        Map<String,String> paramMap = new HashMap<>();
        paramMap.put("userid",elecreditConfig.getUserId());
        paramMap.put("key",keyWord);
        paramMap.put("type", type);
        return paramMap;
    }

    /**
     * @Description 获取企业全称接口参数
     * @Param keyWord
     * @return java.util.Map<java.lang.String,java.lang.String>
     **/
    public Map<String,String> buildFullNameParam(String keyWord) {
        Map<String,String> paramMap = new HashMap<>();
        paramMap.put("userid",elecreditConfig.getUserId());
        paramMap.put("key",keyWord);
        return paramMap;
    }

    /**
     * @Description 根据工商注册号获取企业全称接口参数
     * @Param key
     * @return java.util.Map<java.lang.String,java.lang.String>
     **/
    public Map<String,String> buildCompnameByCreditCodeParam(String key) {
        Map<String,String> paramMap = new HashMap<>();
        paramMap.put("userid",elecreditConfig.getUserId());
        paramMap.put("key",key);
        return paramMap;
    }

    /**
     * @Description 查询企业新闻接口参数
     * @Param key
     * @return java.util.Map<java.lang.String,java.lang.String>
     **/
    public Map<String,String> buildPublicVoicesParam(String companyId, String begin, String end) {
        Map<String,String> paramMap = new HashMap<>();
        paramMap.put("userid",elecreditConfig.getUserId());
        paramMap.put("entid",companyId);
        if(StringUtils.isNotBlank(begin)) {
            paramMap.put("begin", begin);
        }
        if(StringUtils.isNotBlank(end)) {
            paramMap.put("end", end);
        }
        return paramMap;
    }

    /**
     * @Description 查询股权投资链接口参数
     * @Param companyId 企业id
     * @Param version 请求版本
     * @return java.util.Map<java.lang.String,java.lang.String>
     **/
    public Map<String,String> buildEntityInvestChainParam(String companyId, String version) {
        Map<String,String> paramMap = new HashMap<>();
        paramMap.put("userid",elecreditConfig.getUserId());
        paramMap.put("entid",companyId);
        if(StringUtils.isNotBlank(version)) {
            paramMap.put("version", version);
        }
        return paramMap;
    }

    /**
     * @Description 解析工商信息返回结果
     * @Param jsonStr 待解析串
     * @return EntGsInfo
     **/
    public EntGsInfo resolveElsaicResp(JSONObject json){
        EntGsInfo entGsInfo = null;
        JSONObject dataObj = (JSONObject)json.get("data");
        if(dataObj != null) {
            JSONObject basicObj = ((JSONArray) dataObj.get("BASIC")).getJSONObject(0);
            entGsInfo = new EntGsInfo();
            entGsInfo.setEntName(basicObj.getString("ENTNAME"));
            entGsInfo.setRegNo(basicObj.getString("REGNO"));
            entGsInfo.setOriRegNo(basicObj.getString("ORIREGNO"));
            entGsInfo.setCreditCode(basicObj.getString("CREDITCODE"));
            entGsInfo.setFrName(basicObj.getString("FRNAME"));
            entGsInfo.setRegCap(basicObj.getBigDecimal("REGCAP"));
            entGsInfo.setRegCapCur(basicObj.getString("REGCAPCUR"));
            entGsInfo.setEntStatus(basicObj.getString("ENTSTATUS"));
            entGsInfo.setEntType(basicObj.getString("ENTTYPE"));
            entGsInfo.setEsDate(basicObj.getString("ESDATE"));
            entGsInfo.setOpFrom(basicObj.getString("OPFROM"));
            entGsInfo.setOpTo(basicObj.getString("OPTO"));
            entGsInfo.setRegAddr(basicObj.getString("DOM"));
            entGsInfo.setRegOrg(basicObj.getString("REGORG"));
            entGsInfo.setRegOrgCode(basicObj.getString("REGORGCODE"));
            entGsInfo.setRegOrgProvince(basicObj.getString("REGORGPROVINCE"));
            entGsInfo.setEmpNum(basicObj.getLong("EMPNUM"));
            entGsInfo.setTel(basicObj.getString("TEL"));
            entGsInfo.setOpLocation(basicObj.getString("OPLOC"));
            entGsInfo.setIndustryCode(basicObj.getString("INDUSTRYPHYCODE"));
            entGsInfo.setIndustryName(basicObj.getString("INDUSTRYPHYNAME"));
            entGsInfo.setOpScope(basicObj.getString("OPSCOPE"));
        }

        return entGsInfo;
    }

    public EntInvestChainInfo resolveInvestChainInfoResp(SaicInv saicInv, String entId) {
        EntInvestChainInfo entInvestChainInfo = null;
        if(CollectionUtils.isNotEmpty(saicInv.getInv())){
            Inv inv = saicInv.getInv().get(0);
            entInvestChainInfo = new EntInvestChainInfo();
            entInvestChainInfo.setEntId(entId);
            entInvestChainInfo.setCerType(inv.getCertype());
            if(StringUtils.isNotBlank(inv.getCertype())){
                entInvestChainInfo.setSubjectType(inv.getCertype().charAt(0)+"");
            }
            try{
                String finalRationNumStr = inv.getFinalRatio().replaceAll("%" , "");
                entInvestChainInfo.setFinalRatio(new BigDecimal(finalRationNumStr));
            }catch(Exception e){
                entInvestChainInfo.setFinalRatio(BigDecimal.ZERO);
            }

            try{
                entInvestChainInfo.setFinalSubsNum(new BigDecimal(inv.getFinalSubcOnam()));
            }catch(Exception e){
                entInvestChainInfo.setFinalSubsNum(BigDecimal.ZERO);
            }

            try{
                entInvestChainInfo.setFinalAccNum(new BigDecimal(inv.getFinalAccOnam()));
            }catch(Exception e){
                entInvestChainInfo.setFinalAccNum(BigDecimal.ZERO);
            }

            entInvestChainInfo.setIdCard(inv.getIdCard());
            entInvestChainInfo.setRatioRoad(inv.getRatioRoad());
            entInvestChainInfo.setAddress(inv.getAddress());
            entInvestChainInfo.setFinalEntName(inv.getFinalEntName());
            entInvestChainInfo.setPosition(inv.getPosition());
            entInvestChainInfo.setCapitalChain(inv.getCapitalChain());
            if(StringUtils.isNotBlank(inv.getCapitalChain())){
                String[] nodes = inv.getCapitalChain().split("->");
                entInvestChainInfo.setEntName(nodes[nodes.length-1].trim());
            }else{
                entInvestChainInfo.setEntName(inv.getFinalEntName());
            }
        }
        return entInvestChainInfo;
    }

    /**
     * @Description 解析股权返回结果
     * @Param entInvestChainInfo 目标列表
     * @Param currentNode 待解析树当前node
     * @Param rootEntId 根entId
     * @Param rootEntName 根entName
     * @Param parentName 父节点entName
     * @Param level 当前层数
     * @return EntGsInfo
     **/
    public void resolveEquityDetailListResp(List<EntEquityDetailInfo> entEquityDetailList,
                                                                 InvRoad currentNode,
                                                                 String rootEntId,
                                                                 String rootEntName,
                                                                 String parentName,
                                                                 int level) {

        EntEquityDetailInfo equityDetail = new EntEquityDetailInfo();
        equityDetail.setEntId(rootEntId);
        equityDetail.setEntName(rootEntName);
        equityDetail.setCerType(currentNode.getCertype());
        equityDetail.setIdCard(currentNode.getIdcard());
        if(StringUtils.isNotBlank(currentNode.getCertype())) {
            equityDetail.setSubjectType(currentNode.getCertype().charAt(0) + "");
        }else{
            equityDetail.setSubjectType("C");
        }
        equityDetail.setConName(parentName);
        equityDetail.setNodeName(currentNode.getName());
        equityDetail.setAddress(currentNode.getAddress());
        equityDetail.setConProp(currentNode.getConprop());
        equityDetail.setRealConProp(currentNode.getRealConprop());
        equityDetail.setPosition(currentNode.getPosition());
        equityDetail.setTags(currentNode.getTags()+"");
        equityDetail.setTraceLevel(level);
        entEquityDetailList.add(equityDetail);
        //递归生成
        if(CollectionUtils.isNotEmpty(currentNode.getChildren())){
            for(InvRoad road : currentNode.getChildren()){
                resolveEquityDetailListResp(entEquityDetailList, road, rootEntId, rootEntName, currentNode.getName(), level+1);
            }
        }
    }

    public EntEquityInfo resolveEquityInfoResp(SaicInv saicInv, String entId) {
        EntEquityInfo entEquityInfo = new EntEquityInfo();
        EntInvestChainInfo investChainInfo = resolveInvestChainInfoResp(saicInv, entId);
        List<EntEquityDetailInfo> equityDetailList = null;
        if(saicInv != null && saicInv.getRoad() != null) {
            equityDetailList = new ArrayList<>();
            resolveEquityDetailListResp(equityDetailList, saicInv.getRoad(), entId, investChainInfo.getEntName(), null, 1);
        }
        entEquityInfo.setInvestChainInfo(investChainInfo);
        entEquityInfo.setEquityDetailList(equityDetailList);
        return entEquityInfo;
    }
}
