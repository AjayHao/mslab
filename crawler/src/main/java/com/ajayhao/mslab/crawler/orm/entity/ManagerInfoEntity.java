package com.ajayhao.mslab.crawler.orm.entity;

import java.math.BigDecimal;
import java.util.Date;

public class ManagerInfoEntity {
    private String id;

    private String entId;

    private String entName;

    private String pullDate;

    private String subjectType;

    private Short traceLevel;

    private String nodeName;

    private String tags;

    private String conName;

    private BigDecimal conProp;

    private BigDecimal realConProp;

    private String position;

    private String idCard;

    private String cerType;

    private String address;

    private String uniqueToken;

    private Date createdAt;

    private String creator;

    private Date updatedAt;

    private String updater;

    private Short isDelete;

    private String nodeId;

    private String parentNodeId;

    private BigDecimal regAmt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getEntId() {
        return entId;
    }

    public void setEntId(String entId) {
        this.entId = entId == null ? null : entId.trim();
    }

    public String getEntName() {
        return entName;
    }

    public void setEntName(String entName) {
        this.entName = entName == null ? null : entName.trim();
    }

    public String getPullDate() {
        return pullDate;
    }

    public void setPullDate(String pullDate) {
        this.pullDate = pullDate == null ? null : pullDate.trim();
    }

    public String getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(String subjectType) {
        this.subjectType = subjectType == null ? null : subjectType.trim();
    }

    public Short getTraceLevel() {
        return traceLevel;
    }

    public void setTraceLevel(Short traceLevel) {
        this.traceLevel = traceLevel;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName == null ? null : nodeName.trim();
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags == null ? null : tags.trim();
    }

    public String getConName() {
        return conName;
    }

    public void setConName(String conName) {
        this.conName = conName == null ? null : conName.trim();
    }

    public BigDecimal getConProp() {
        return conProp;
    }

    public void setConProp(BigDecimal conProp) {
        this.conProp = conProp;
    }

    public BigDecimal getRealConProp() {
        return realConProp;
    }

    public void setRealConProp(BigDecimal realConProp) {
        this.realConProp = realConProp;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    public String getCerType() {
        return cerType;
    }

    public void setCerType(String cerType) {
        this.cerType = cerType == null ? null : cerType.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getUniqueToken() {
        return uniqueToken;
    }

    public void setUniqueToken(String uniqueToken) {
        this.uniqueToken = uniqueToken == null ? null : uniqueToken.trim();
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater == null ? null : updater.trim();
    }

    public Short getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Short isDelete) {
        this.isDelete = isDelete;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId == null ? null : nodeId.trim();
    }

    public String getParentNodeId() {
        return parentNodeId;
    }

    public void setParentNodeId(String parentNodeId) {
        this.parentNodeId = parentNodeId == null ? null : parentNodeId.trim();
    }

    public BigDecimal getRegAmt() {
        return regAmt;
    }

    public void setRegAmt(BigDecimal regAmt) {
        this.regAmt = regAmt;
    }
}