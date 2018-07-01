package com.ajayhao.mslab.crawler.orm.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EntInvestChainEntityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EntInvestChainEntityExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("ID like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("ID not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andEntIdIsNull() {
            addCriterion("ENT_ID is null");
            return (Criteria) this;
        }

        public Criteria andEntIdIsNotNull() {
            addCriterion("ENT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andEntIdEqualTo(String value) {
            addCriterion("ENT_ID =", value, "entId");
            return (Criteria) this;
        }

        public Criteria andEntIdNotEqualTo(String value) {
            addCriterion("ENT_ID <>", value, "entId");
            return (Criteria) this;
        }

        public Criteria andEntIdGreaterThan(String value) {
            addCriterion("ENT_ID >", value, "entId");
            return (Criteria) this;
        }

        public Criteria andEntIdGreaterThanOrEqualTo(String value) {
            addCriterion("ENT_ID >=", value, "entId");
            return (Criteria) this;
        }

        public Criteria andEntIdLessThan(String value) {
            addCriterion("ENT_ID <", value, "entId");
            return (Criteria) this;
        }

        public Criteria andEntIdLessThanOrEqualTo(String value) {
            addCriterion("ENT_ID <=", value, "entId");
            return (Criteria) this;
        }

        public Criteria andEntIdLike(String value) {
            addCriterion("ENT_ID like", value, "entId");
            return (Criteria) this;
        }

        public Criteria andEntIdNotLike(String value) {
            addCriterion("ENT_ID not like", value, "entId");
            return (Criteria) this;
        }

        public Criteria andEntIdIn(List<String> values) {
            addCriterion("ENT_ID in", values, "entId");
            return (Criteria) this;
        }

        public Criteria andEntIdNotIn(List<String> values) {
            addCriterion("ENT_ID not in", values, "entId");
            return (Criteria) this;
        }

        public Criteria andEntIdBetween(String value1, String value2) {
            addCriterion("ENT_ID between", value1, value2, "entId");
            return (Criteria) this;
        }

        public Criteria andEntIdNotBetween(String value1, String value2) {
            addCriterion("ENT_ID not between", value1, value2, "entId");
            return (Criteria) this;
        }

        public Criteria andEntNameIsNull() {
            addCriterion("ENT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andEntNameIsNotNull() {
            addCriterion("ENT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andEntNameEqualTo(String value) {
            addCriterion("ENT_NAME =", value, "entName");
            return (Criteria) this;
        }

        public Criteria andEntNameNotEqualTo(String value) {
            addCriterion("ENT_NAME <>", value, "entName");
            return (Criteria) this;
        }

        public Criteria andEntNameGreaterThan(String value) {
            addCriterion("ENT_NAME >", value, "entName");
            return (Criteria) this;
        }

        public Criteria andEntNameGreaterThanOrEqualTo(String value) {
            addCriterion("ENT_NAME >=", value, "entName");
            return (Criteria) this;
        }

        public Criteria andEntNameLessThan(String value) {
            addCriterion("ENT_NAME <", value, "entName");
            return (Criteria) this;
        }

        public Criteria andEntNameLessThanOrEqualTo(String value) {
            addCriterion("ENT_NAME <=", value, "entName");
            return (Criteria) this;
        }

        public Criteria andEntNameLike(String value) {
            addCriterion("ENT_NAME like", value, "entName");
            return (Criteria) this;
        }

        public Criteria andEntNameNotLike(String value) {
            addCriterion("ENT_NAME not like", value, "entName");
            return (Criteria) this;
        }

        public Criteria andEntNameIn(List<String> values) {
            addCriterion("ENT_NAME in", values, "entName");
            return (Criteria) this;
        }

        public Criteria andEntNameNotIn(List<String> values) {
            addCriterion("ENT_NAME not in", values, "entName");
            return (Criteria) this;
        }

        public Criteria andEntNameBetween(String value1, String value2) {
            addCriterion("ENT_NAME between", value1, value2, "entName");
            return (Criteria) this;
        }

        public Criteria andEntNameNotBetween(String value1, String value2) {
            addCriterion("ENT_NAME not between", value1, value2, "entName");
            return (Criteria) this;
        }

        public Criteria andPullDateIsNull() {
            addCriterion("PULL_DATE is null");
            return (Criteria) this;
        }

        public Criteria andPullDateIsNotNull() {
            addCriterion("PULL_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andPullDateEqualTo(String value) {
            addCriterion("PULL_DATE =", value, "pullDate");
            return (Criteria) this;
        }

        public Criteria andPullDateNotEqualTo(String value) {
            addCriterion("PULL_DATE <>", value, "pullDate");
            return (Criteria) this;
        }

        public Criteria andPullDateGreaterThan(String value) {
            addCriterion("PULL_DATE >", value, "pullDate");
            return (Criteria) this;
        }

        public Criteria andPullDateGreaterThanOrEqualTo(String value) {
            addCriterion("PULL_DATE >=", value, "pullDate");
            return (Criteria) this;
        }

        public Criteria andPullDateLessThan(String value) {
            addCriterion("PULL_DATE <", value, "pullDate");
            return (Criteria) this;
        }

        public Criteria andPullDateLessThanOrEqualTo(String value) {
            addCriterion("PULL_DATE <=", value, "pullDate");
            return (Criteria) this;
        }

        public Criteria andPullDateLike(String value) {
            addCriterion("PULL_DATE like", value, "pullDate");
            return (Criteria) this;
        }

        public Criteria andPullDateNotLike(String value) {
            addCriterion("PULL_DATE not like", value, "pullDate");
            return (Criteria) this;
        }

        public Criteria andPullDateIn(List<String> values) {
            addCriterion("PULL_DATE in", values, "pullDate");
            return (Criteria) this;
        }

        public Criteria andPullDateNotIn(List<String> values) {
            addCriterion("PULL_DATE not in", values, "pullDate");
            return (Criteria) this;
        }

        public Criteria andPullDateBetween(String value1, String value2) {
            addCriterion("PULL_DATE between", value1, value2, "pullDate");
            return (Criteria) this;
        }

        public Criteria andPullDateNotBetween(String value1, String value2) {
            addCriterion("PULL_DATE not between", value1, value2, "pullDate");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeIsNull() {
            addCriterion("SUBJECT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeIsNotNull() {
            addCriterion("SUBJECT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeEqualTo(String value) {
            addCriterion("SUBJECT_TYPE =", value, "subjectType");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeNotEqualTo(String value) {
            addCriterion("SUBJECT_TYPE <>", value, "subjectType");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeGreaterThan(String value) {
            addCriterion("SUBJECT_TYPE >", value, "subjectType");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeGreaterThanOrEqualTo(String value) {
            addCriterion("SUBJECT_TYPE >=", value, "subjectType");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeLessThan(String value) {
            addCriterion("SUBJECT_TYPE <", value, "subjectType");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeLessThanOrEqualTo(String value) {
            addCriterion("SUBJECT_TYPE <=", value, "subjectType");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeLike(String value) {
            addCriterion("SUBJECT_TYPE like", value, "subjectType");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeNotLike(String value) {
            addCriterion("SUBJECT_TYPE not like", value, "subjectType");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeIn(List<String> values) {
            addCriterion("SUBJECT_TYPE in", values, "subjectType");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeNotIn(List<String> values) {
            addCriterion("SUBJECT_TYPE not in", values, "subjectType");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeBetween(String value1, String value2) {
            addCriterion("SUBJECT_TYPE between", value1, value2, "subjectType");
            return (Criteria) this;
        }

        public Criteria andSubjectTypeNotBetween(String value1, String value2) {
            addCriterion("SUBJECT_TYPE not between", value1, value2, "subjectType");
            return (Criteria) this;
        }

        public Criteria andIdCardIsNull() {
            addCriterion("ID_CARD is null");
            return (Criteria) this;
        }

        public Criteria andIdCardIsNotNull() {
            addCriterion("ID_CARD is not null");
            return (Criteria) this;
        }

        public Criteria andIdCardEqualTo(String value) {
            addCriterion("ID_CARD =", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotEqualTo(String value) {
            addCriterion("ID_CARD <>", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardGreaterThan(String value) {
            addCriterion("ID_CARD >", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardGreaterThanOrEqualTo(String value) {
            addCriterion("ID_CARD >=", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardLessThan(String value) {
            addCriterion("ID_CARD <", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardLessThanOrEqualTo(String value) {
            addCriterion("ID_CARD <=", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardLike(String value) {
            addCriterion("ID_CARD like", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotLike(String value) {
            addCriterion("ID_CARD not like", value, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardIn(List<String> values) {
            addCriterion("ID_CARD in", values, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotIn(List<String> values) {
            addCriterion("ID_CARD not in", values, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardBetween(String value1, String value2) {
            addCriterion("ID_CARD between", value1, value2, "idCard");
            return (Criteria) this;
        }

        public Criteria andIdCardNotBetween(String value1, String value2) {
            addCriterion("ID_CARD not between", value1, value2, "idCard");
            return (Criteria) this;
        }

        public Criteria andCerTypeIsNull() {
            addCriterion("CER_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andCerTypeIsNotNull() {
            addCriterion("CER_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andCerTypeEqualTo(String value) {
            addCriterion("CER_TYPE =", value, "cerType");
            return (Criteria) this;
        }

        public Criteria andCerTypeNotEqualTo(String value) {
            addCriterion("CER_TYPE <>", value, "cerType");
            return (Criteria) this;
        }

        public Criteria andCerTypeGreaterThan(String value) {
            addCriterion("CER_TYPE >", value, "cerType");
            return (Criteria) this;
        }

        public Criteria andCerTypeGreaterThanOrEqualTo(String value) {
            addCriterion("CER_TYPE >=", value, "cerType");
            return (Criteria) this;
        }

        public Criteria andCerTypeLessThan(String value) {
            addCriterion("CER_TYPE <", value, "cerType");
            return (Criteria) this;
        }

        public Criteria andCerTypeLessThanOrEqualTo(String value) {
            addCriterion("CER_TYPE <=", value, "cerType");
            return (Criteria) this;
        }

        public Criteria andCerTypeLike(String value) {
            addCriterion("CER_TYPE like", value, "cerType");
            return (Criteria) this;
        }

        public Criteria andCerTypeNotLike(String value) {
            addCriterion("CER_TYPE not like", value, "cerType");
            return (Criteria) this;
        }

        public Criteria andCerTypeIn(List<String> values) {
            addCriterion("CER_TYPE in", values, "cerType");
            return (Criteria) this;
        }

        public Criteria andCerTypeNotIn(List<String> values) {
            addCriterion("CER_TYPE not in", values, "cerType");
            return (Criteria) this;
        }

        public Criteria andCerTypeBetween(String value1, String value2) {
            addCriterion("CER_TYPE between", value1, value2, "cerType");
            return (Criteria) this;
        }

        public Criteria andCerTypeNotBetween(String value1, String value2) {
            addCriterion("CER_TYPE not between", value1, value2, "cerType");
            return (Criteria) this;
        }

        public Criteria andFinalEntNameIsNull() {
            addCriterion("FINAL_ENT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andFinalEntNameIsNotNull() {
            addCriterion("FINAL_ENT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andFinalEntNameEqualTo(String value) {
            addCriterion("FINAL_ENT_NAME =", value, "finalEntName");
            return (Criteria) this;
        }

        public Criteria andFinalEntNameNotEqualTo(String value) {
            addCriterion("FINAL_ENT_NAME <>", value, "finalEntName");
            return (Criteria) this;
        }

        public Criteria andFinalEntNameGreaterThan(String value) {
            addCriterion("FINAL_ENT_NAME >", value, "finalEntName");
            return (Criteria) this;
        }

        public Criteria andFinalEntNameGreaterThanOrEqualTo(String value) {
            addCriterion("FINAL_ENT_NAME >=", value, "finalEntName");
            return (Criteria) this;
        }

        public Criteria andFinalEntNameLessThan(String value) {
            addCriterion("FINAL_ENT_NAME <", value, "finalEntName");
            return (Criteria) this;
        }

        public Criteria andFinalEntNameLessThanOrEqualTo(String value) {
            addCriterion("FINAL_ENT_NAME <=", value, "finalEntName");
            return (Criteria) this;
        }

        public Criteria andFinalEntNameLike(String value) {
            addCriterion("FINAL_ENT_NAME like", value, "finalEntName");
            return (Criteria) this;
        }

        public Criteria andFinalEntNameNotLike(String value) {
            addCriterion("FINAL_ENT_NAME not like", value, "finalEntName");
            return (Criteria) this;
        }

        public Criteria andFinalEntNameIn(List<String> values) {
            addCriterion("FINAL_ENT_NAME in", values, "finalEntName");
            return (Criteria) this;
        }

        public Criteria andFinalEntNameNotIn(List<String> values) {
            addCriterion("FINAL_ENT_NAME not in", values, "finalEntName");
            return (Criteria) this;
        }

        public Criteria andFinalEntNameBetween(String value1, String value2) {
            addCriterion("FINAL_ENT_NAME between", value1, value2, "finalEntName");
            return (Criteria) this;
        }

        public Criteria andFinalEntNameNotBetween(String value1, String value2) {
            addCriterion("FINAL_ENT_NAME not between", value1, value2, "finalEntName");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("ADDRESS =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("ADDRESS <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("ADDRESS >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("ADDRESS >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("ADDRESS <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("ADDRESS <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("ADDRESS like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("ADDRESS not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("ADDRESS in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("ADDRESS not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("ADDRESS between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("ADDRESS not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andFinalRatioIsNull() {
            addCriterion("FINAL_RATIO is null");
            return (Criteria) this;
        }

        public Criteria andFinalRatioIsNotNull() {
            addCriterion("FINAL_RATIO is not null");
            return (Criteria) this;
        }

        public Criteria andFinalRatioEqualTo(BigDecimal value) {
            addCriterion("FINAL_RATIO =", value, "finalRatio");
            return (Criteria) this;
        }

        public Criteria andFinalRatioNotEqualTo(BigDecimal value) {
            addCriterion("FINAL_RATIO <>", value, "finalRatio");
            return (Criteria) this;
        }

        public Criteria andFinalRatioGreaterThan(BigDecimal value) {
            addCriterion("FINAL_RATIO >", value, "finalRatio");
            return (Criteria) this;
        }

        public Criteria andFinalRatioGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FINAL_RATIO >=", value, "finalRatio");
            return (Criteria) this;
        }

        public Criteria andFinalRatioLessThan(BigDecimal value) {
            addCriterion("FINAL_RATIO <", value, "finalRatio");
            return (Criteria) this;
        }

        public Criteria andFinalRatioLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FINAL_RATIO <=", value, "finalRatio");
            return (Criteria) this;
        }

        public Criteria andFinalRatioIn(List<BigDecimal> values) {
            addCriterion("FINAL_RATIO in", values, "finalRatio");
            return (Criteria) this;
        }

        public Criteria andFinalRatioNotIn(List<BigDecimal> values) {
            addCriterion("FINAL_RATIO not in", values, "finalRatio");
            return (Criteria) this;
        }

        public Criteria andFinalRatioBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FINAL_RATIO between", value1, value2, "finalRatio");
            return (Criteria) this;
        }

        public Criteria andFinalRatioNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FINAL_RATIO not between", value1, value2, "finalRatio");
            return (Criteria) this;
        }

        public Criteria andFinalSubsNumIsNull() {
            addCriterion("FINAL_SUBS_NUM is null");
            return (Criteria) this;
        }

        public Criteria andFinalSubsNumIsNotNull() {
            addCriterion("FINAL_SUBS_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andFinalSubsNumEqualTo(BigDecimal value) {
            addCriterion("FINAL_SUBS_NUM =", value, "finalSubsNum");
            return (Criteria) this;
        }

        public Criteria andFinalSubsNumNotEqualTo(BigDecimal value) {
            addCriterion("FINAL_SUBS_NUM <>", value, "finalSubsNum");
            return (Criteria) this;
        }

        public Criteria andFinalSubsNumGreaterThan(BigDecimal value) {
            addCriterion("FINAL_SUBS_NUM >", value, "finalSubsNum");
            return (Criteria) this;
        }

        public Criteria andFinalSubsNumGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FINAL_SUBS_NUM >=", value, "finalSubsNum");
            return (Criteria) this;
        }

        public Criteria andFinalSubsNumLessThan(BigDecimal value) {
            addCriterion("FINAL_SUBS_NUM <", value, "finalSubsNum");
            return (Criteria) this;
        }

        public Criteria andFinalSubsNumLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FINAL_SUBS_NUM <=", value, "finalSubsNum");
            return (Criteria) this;
        }

        public Criteria andFinalSubsNumIn(List<BigDecimal> values) {
            addCriterion("FINAL_SUBS_NUM in", values, "finalSubsNum");
            return (Criteria) this;
        }

        public Criteria andFinalSubsNumNotIn(List<BigDecimal> values) {
            addCriterion("FINAL_SUBS_NUM not in", values, "finalSubsNum");
            return (Criteria) this;
        }

        public Criteria andFinalSubsNumBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FINAL_SUBS_NUM between", value1, value2, "finalSubsNum");
            return (Criteria) this;
        }

        public Criteria andFinalSubsNumNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FINAL_SUBS_NUM not between", value1, value2, "finalSubsNum");
            return (Criteria) this;
        }

        public Criteria andFinalAccNumIsNull() {
            addCriterion("FINAL_ACC_NUM is null");
            return (Criteria) this;
        }

        public Criteria andFinalAccNumIsNotNull() {
            addCriterion("FINAL_ACC_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andFinalAccNumEqualTo(BigDecimal value) {
            addCriterion("FINAL_ACC_NUM =", value, "finalAccNum");
            return (Criteria) this;
        }

        public Criteria andFinalAccNumNotEqualTo(BigDecimal value) {
            addCriterion("FINAL_ACC_NUM <>", value, "finalAccNum");
            return (Criteria) this;
        }

        public Criteria andFinalAccNumGreaterThan(BigDecimal value) {
            addCriterion("FINAL_ACC_NUM >", value, "finalAccNum");
            return (Criteria) this;
        }

        public Criteria andFinalAccNumGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FINAL_ACC_NUM >=", value, "finalAccNum");
            return (Criteria) this;
        }

        public Criteria andFinalAccNumLessThan(BigDecimal value) {
            addCriterion("FINAL_ACC_NUM <", value, "finalAccNum");
            return (Criteria) this;
        }

        public Criteria andFinalAccNumLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FINAL_ACC_NUM <=", value, "finalAccNum");
            return (Criteria) this;
        }

        public Criteria andFinalAccNumIn(List<BigDecimal> values) {
            addCriterion("FINAL_ACC_NUM in", values, "finalAccNum");
            return (Criteria) this;
        }

        public Criteria andFinalAccNumNotIn(List<BigDecimal> values) {
            addCriterion("FINAL_ACC_NUM not in", values, "finalAccNum");
            return (Criteria) this;
        }

        public Criteria andFinalAccNumBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FINAL_ACC_NUM between", value1, value2, "finalAccNum");
            return (Criteria) this;
        }

        public Criteria andFinalAccNumNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FINAL_ACC_NUM not between", value1, value2, "finalAccNum");
            return (Criteria) this;
        }

        public Criteria andRatioRoadIsNull() {
            addCriterion("RATIO_ROAD is null");
            return (Criteria) this;
        }

        public Criteria andRatioRoadIsNotNull() {
            addCriterion("RATIO_ROAD is not null");
            return (Criteria) this;
        }

        public Criteria andRatioRoadEqualTo(String value) {
            addCriterion("RATIO_ROAD =", value, "ratioRoad");
            return (Criteria) this;
        }

        public Criteria andRatioRoadNotEqualTo(String value) {
            addCriterion("RATIO_ROAD <>", value, "ratioRoad");
            return (Criteria) this;
        }

        public Criteria andRatioRoadGreaterThan(String value) {
            addCriterion("RATIO_ROAD >", value, "ratioRoad");
            return (Criteria) this;
        }

        public Criteria andRatioRoadGreaterThanOrEqualTo(String value) {
            addCriterion("RATIO_ROAD >=", value, "ratioRoad");
            return (Criteria) this;
        }

        public Criteria andRatioRoadLessThan(String value) {
            addCriterion("RATIO_ROAD <", value, "ratioRoad");
            return (Criteria) this;
        }

        public Criteria andRatioRoadLessThanOrEqualTo(String value) {
            addCriterion("RATIO_ROAD <=", value, "ratioRoad");
            return (Criteria) this;
        }

        public Criteria andRatioRoadLike(String value) {
            addCriterion("RATIO_ROAD like", value, "ratioRoad");
            return (Criteria) this;
        }

        public Criteria andRatioRoadNotLike(String value) {
            addCriterion("RATIO_ROAD not like", value, "ratioRoad");
            return (Criteria) this;
        }

        public Criteria andRatioRoadIn(List<String> values) {
            addCriterion("RATIO_ROAD in", values, "ratioRoad");
            return (Criteria) this;
        }

        public Criteria andRatioRoadNotIn(List<String> values) {
            addCriterion("RATIO_ROAD not in", values, "ratioRoad");
            return (Criteria) this;
        }

        public Criteria andRatioRoadBetween(String value1, String value2) {
            addCriterion("RATIO_ROAD between", value1, value2, "ratioRoad");
            return (Criteria) this;
        }

        public Criteria andRatioRoadNotBetween(String value1, String value2) {
            addCriterion("RATIO_ROAD not between", value1, value2, "ratioRoad");
            return (Criteria) this;
        }

        public Criteria andPositionIsNull() {
            addCriterion("POSITION is null");
            return (Criteria) this;
        }

        public Criteria andPositionIsNotNull() {
            addCriterion("POSITION is not null");
            return (Criteria) this;
        }

        public Criteria andPositionEqualTo(String value) {
            addCriterion("POSITION =", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotEqualTo(String value) {
            addCriterion("POSITION <>", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionGreaterThan(String value) {
            addCriterion("POSITION >", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionGreaterThanOrEqualTo(String value) {
            addCriterion("POSITION >=", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionLessThan(String value) {
            addCriterion("POSITION <", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionLessThanOrEqualTo(String value) {
            addCriterion("POSITION <=", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionLike(String value) {
            addCriterion("POSITION like", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotLike(String value) {
            addCriterion("POSITION not like", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionIn(List<String> values) {
            addCriterion("POSITION in", values, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotIn(List<String> values) {
            addCriterion("POSITION not in", values, "position");
            return (Criteria) this;
        }

        public Criteria andPositionBetween(String value1, String value2) {
            addCriterion("POSITION between", value1, value2, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotBetween(String value1, String value2) {
            addCriterion("POSITION not between", value1, value2, "position");
            return (Criteria) this;
        }

        public Criteria andCapitalChainIsNull() {
            addCriterion("CAPITAL_CHAIN is null");
            return (Criteria) this;
        }

        public Criteria andCapitalChainIsNotNull() {
            addCriterion("CAPITAL_CHAIN is not null");
            return (Criteria) this;
        }

        public Criteria andCapitalChainEqualTo(String value) {
            addCriterion("CAPITAL_CHAIN =", value, "capitalChain");
            return (Criteria) this;
        }

        public Criteria andCapitalChainNotEqualTo(String value) {
            addCriterion("CAPITAL_CHAIN <>", value, "capitalChain");
            return (Criteria) this;
        }

        public Criteria andCapitalChainGreaterThan(String value) {
            addCriterion("CAPITAL_CHAIN >", value, "capitalChain");
            return (Criteria) this;
        }

        public Criteria andCapitalChainGreaterThanOrEqualTo(String value) {
            addCriterion("CAPITAL_CHAIN >=", value, "capitalChain");
            return (Criteria) this;
        }

        public Criteria andCapitalChainLessThan(String value) {
            addCriterion("CAPITAL_CHAIN <", value, "capitalChain");
            return (Criteria) this;
        }

        public Criteria andCapitalChainLessThanOrEqualTo(String value) {
            addCriterion("CAPITAL_CHAIN <=", value, "capitalChain");
            return (Criteria) this;
        }

        public Criteria andCapitalChainLike(String value) {
            addCriterion("CAPITAL_CHAIN like", value, "capitalChain");
            return (Criteria) this;
        }

        public Criteria andCapitalChainNotLike(String value) {
            addCriterion("CAPITAL_CHAIN not like", value, "capitalChain");
            return (Criteria) this;
        }

        public Criteria andCapitalChainIn(List<String> values) {
            addCriterion("CAPITAL_CHAIN in", values, "capitalChain");
            return (Criteria) this;
        }

        public Criteria andCapitalChainNotIn(List<String> values) {
            addCriterion("CAPITAL_CHAIN not in", values, "capitalChain");
            return (Criteria) this;
        }

        public Criteria andCapitalChainBetween(String value1, String value2) {
            addCriterion("CAPITAL_CHAIN between", value1, value2, "capitalChain");
            return (Criteria) this;
        }

        public Criteria andCapitalChainNotBetween(String value1, String value2) {
            addCriterion("CAPITAL_CHAIN not between", value1, value2, "capitalChain");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIsNull() {
            addCriterion("CREATED_AT is null");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIsNotNull() {
            addCriterion("CREATED_AT is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedAtEqualTo(Date value) {
            addCriterion("CREATED_AT =", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotEqualTo(Date value) {
            addCriterion("CREATED_AT <>", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtGreaterThan(Date value) {
            addCriterion("CREATED_AT >", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATED_AT >=", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtLessThan(Date value) {
            addCriterion("CREATED_AT <", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtLessThanOrEqualTo(Date value) {
            addCriterion("CREATED_AT <=", value, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtIn(List<Date> values) {
            addCriterion("CREATED_AT in", values, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotIn(List<Date> values) {
            addCriterion("CREATED_AT not in", values, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtBetween(Date value1, Date value2) {
            addCriterion("CREATED_AT between", value1, value2, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatedAtNotBetween(Date value1, Date value2) {
            addCriterion("CREATED_AT not between", value1, value2, "createdAt");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNull() {
            addCriterion("CREATOR is null");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNotNull() {
            addCriterion("CREATOR is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorEqualTo(String value) {
            addCriterion("CREATOR =", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotEqualTo(String value) {
            addCriterion("CREATOR <>", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThan(String value) {
            addCriterion("CREATOR >", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThanOrEqualTo(String value) {
            addCriterion("CREATOR >=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThan(String value) {
            addCriterion("CREATOR <", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThanOrEqualTo(String value) {
            addCriterion("CREATOR <=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLike(String value) {
            addCriterion("CREATOR like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotLike(String value) {
            addCriterion("CREATOR not like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorIn(List<String> values) {
            addCriterion("CREATOR in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotIn(List<String> values) {
            addCriterion("CREATOR not in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorBetween(String value1, String value2) {
            addCriterion("CREATOR between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotBetween(String value1, String value2) {
            addCriterion("CREATOR not between", value1, value2, "creator");
            return (Criteria) this;
        }


        public Criteria andUpdatedAtIsNull() {
            addCriterion("UPDATED_AT is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIsNotNull() {
            addCriterion("UPDATED_AT is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtEqualTo(Date value) {
            addCriterion("UPDATED_AT =", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotEqualTo(Date value) {
            addCriterion("UPDATED_AT <>", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtGreaterThan(Date value) {
            addCriterion("UPDATED_AT >", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATED_AT >=", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtLessThan(Date value) {
            addCriterion("UPDATED_AT <", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtLessThanOrEqualTo(Date value) {
            addCriterion("UPDATED_AT <=", value, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtIn(List<Date> values) {
            addCriterion("UPDATED_AT in", values, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotIn(List<Date> values) {
            addCriterion("UPDATED_AT not in", values, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtBetween(Date value1, Date value2) {
            addCriterion("UPDATED_AT between", value1, value2, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdatedAtNotBetween(Date value1, Date value2) {
            addCriterion("UPDATED_AT not between", value1, value2, "updatedAt");
            return (Criteria) this;
        }

        public Criteria andUpdaterIsNull() {
            addCriterion("UPDATER is null");
            return (Criteria) this;
        }

        public Criteria andUpdaterIsNotNull() {
            addCriterion("UPDATER is not null");
            return (Criteria) this;
        }

        public Criteria andUpdaterEqualTo(String value) {
            addCriterion("UPDATER =", value, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterNotEqualTo(String value) {
            addCriterion("UPDATER <>", value, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterGreaterThan(String value) {
            addCriterion("UPDATER >", value, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterGreaterThanOrEqualTo(String value) {
            addCriterion("UPDATER >=", value, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterLessThan(String value) {
            addCriterion("UPDATER <", value, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterLessThanOrEqualTo(String value) {
            addCriterion("UPDATER <=", value, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterLike(String value) {
            addCriterion("UPDATER like", value, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterNotLike(String value) {
            addCriterion("UPDATER not like", value, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterIn(List<String> values) {
            addCriterion("UPDATER in", values, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterNotIn(List<String> values) {
            addCriterion("UPDATER not in", values, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterBetween(String value1, String value2) {
            addCriterion("UPDATER between", value1, value2, "updater");
            return (Criteria) this;
        }

        public Criteria andUpdaterNotBetween(String value1, String value2) {
            addCriterion("UPDATER not between", value1, value2, "updater");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNull() {
            addCriterion("IS_DELETE is null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIsNotNull() {
            addCriterion("IS_DELETE is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeleteEqualTo(Integer value) {
            addCriterion("IS_DELETE =", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotEqualTo(Integer value) {
            addCriterion("IS_DELETE <>", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThan(Integer value) {
            addCriterion("IS_DELETE >", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThanOrEqualTo(Integer value) {
            addCriterion("IS_DELETE >=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThan(Integer value) {
            addCriterion("IS_DELETE <", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThanOrEqualTo(Integer value) {
            addCriterion("IS_DELETE <=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIn(List<Integer> values) {
            addCriterion("IS_DELETE in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotIn(List<Integer> values) {
            addCriterion("IS_DELETE not in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteBetween(Integer value1, Integer value2) {
            addCriterion("IS_DELETE between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotBetween(Integer value1, Integer value2) {
            addCriterion("IS_DELETE not between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andUniqueTokenIsNull() {
            addCriterion("UNIQUE_TOKEN is null");
            return (Criteria) this;
        }

        public Criteria andUniqueTokenIsNotNull() {
            addCriterion("UNIQUE_TOKEN is not null");
            return (Criteria) this;
        }

        public Criteria andUniqueTokenEqualTo(String value) {
            addCriterion("UNIQUE_TOKEN =", value, "uniqueToken");
            return (Criteria) this;
        }

        public Criteria andUniqueTokenNotEqualTo(String value) {
            addCriterion("UNIQUE_TOKEN <>", value, "uniqueToken");
            return (Criteria) this;
        }

        public Criteria andUniqueTokenGreaterThan(String value) {
            addCriterion("UNIQUE_TOKEN >", value, "uniqueToken");
            return (Criteria) this;
        }

        public Criteria andUniqueTokenGreaterThanOrEqualTo(String value) {
            addCriterion("UNIQUE_TOKEN >=", value, "uniqueToken");
            return (Criteria) this;
        }

        public Criteria andUniqueTokenLessThan(String value) {
            addCriterion("UNIQUE_TOKEN <", value, "uniqueToken");
            return (Criteria) this;
        }

        public Criteria andUniqueTokenLessThanOrEqualTo(String value) {
            addCriterion("UNIQUE_TOKEN <=", value, "uniqueToken");
            return (Criteria) this;
        }

        public Criteria andUniqueTokenLike(String value) {
            addCriterion("UNIQUE_TOKEN like", value, "uniqueToken");
            return (Criteria) this;
        }

        public Criteria andUniqueTokenNotLike(String value) {
            addCriterion("UNIQUE_TOKEN not like", value, "uniqueToken");
            return (Criteria) this;
        }

        public Criteria andUniqueTokenIn(List<String> values) {
            addCriterion("UNIQUE_TOKEN in", values, "uniqueToken");
            return (Criteria) this;
        }

        public Criteria andUniqueTokenNotIn(List<String> values) {
            addCriterion("UNIQUE_TOKEN not in", values, "uniqueToken");
            return (Criteria) this;
        }

        public Criteria andUniqueTokenBetween(String value1, String value2) {
            addCriterion("UNIQUE_TOKEN between", value1, value2, "uniqueToken");
            return (Criteria) this;
        }

        public Criteria andUniqueTokenNotBetween(String value1, String value2) {
            addCriterion("UNIQUE_TOKEN not between", value1, value2, "uniqueToken");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}