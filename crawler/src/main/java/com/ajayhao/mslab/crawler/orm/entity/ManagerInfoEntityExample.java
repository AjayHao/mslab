package com.ajayhao.mslab.crawler.orm.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ManagerInfoEntityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ManagerInfoEntityExample() {
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

        public Criteria andTraceLevelIsNull() {
            addCriterion("TRACE_LEVEL is null");
            return (Criteria) this;
        }

        public Criteria andTraceLevelIsNotNull() {
            addCriterion("TRACE_LEVEL is not null");
            return (Criteria) this;
        }

        public Criteria andTraceLevelEqualTo(Short value) {
            addCriterion("TRACE_LEVEL =", value, "traceLevel");
            return (Criteria) this;
        }

        public Criteria andTraceLevelNotEqualTo(Short value) {
            addCriterion("TRACE_LEVEL <>", value, "traceLevel");
            return (Criteria) this;
        }

        public Criteria andTraceLevelGreaterThan(Short value) {
            addCriterion("TRACE_LEVEL >", value, "traceLevel");
            return (Criteria) this;
        }

        public Criteria andTraceLevelGreaterThanOrEqualTo(Short value) {
            addCriterion("TRACE_LEVEL >=", value, "traceLevel");
            return (Criteria) this;
        }

        public Criteria andTraceLevelLessThan(Short value) {
            addCriterion("TRACE_LEVEL <", value, "traceLevel");
            return (Criteria) this;
        }

        public Criteria andTraceLevelLessThanOrEqualTo(Short value) {
            addCriterion("TRACE_LEVEL <=", value, "traceLevel");
            return (Criteria) this;
        }

        public Criteria andTraceLevelIn(List<Short> values) {
            addCriterion("TRACE_LEVEL in", values, "traceLevel");
            return (Criteria) this;
        }

        public Criteria andTraceLevelNotIn(List<Short> values) {
            addCriterion("TRACE_LEVEL not in", values, "traceLevel");
            return (Criteria) this;
        }

        public Criteria andTraceLevelBetween(Short value1, Short value2) {
            addCriterion("TRACE_LEVEL between", value1, value2, "traceLevel");
            return (Criteria) this;
        }

        public Criteria andTraceLevelNotBetween(Short value1, Short value2) {
            addCriterion("TRACE_LEVEL not between", value1, value2, "traceLevel");
            return (Criteria) this;
        }

        public Criteria andNodeNameIsNull() {
            addCriterion("NODE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andNodeNameIsNotNull() {
            addCriterion("NODE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andNodeNameEqualTo(String value) {
            addCriterion("NODE_NAME =", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameNotEqualTo(String value) {
            addCriterion("NODE_NAME <>", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameGreaterThan(String value) {
            addCriterion("NODE_NAME >", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameGreaterThanOrEqualTo(String value) {
            addCriterion("NODE_NAME >=", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameLessThan(String value) {
            addCriterion("NODE_NAME <", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameLessThanOrEqualTo(String value) {
            addCriterion("NODE_NAME <=", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameLike(String value) {
            addCriterion("NODE_NAME like", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameNotLike(String value) {
            addCriterion("NODE_NAME not like", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameIn(List<String> values) {
            addCriterion("NODE_NAME in", values, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameNotIn(List<String> values) {
            addCriterion("NODE_NAME not in", values, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameBetween(String value1, String value2) {
            addCriterion("NODE_NAME between", value1, value2, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameNotBetween(String value1, String value2) {
            addCriterion("NODE_NAME not between", value1, value2, "nodeName");
            return (Criteria) this;
        }

        public Criteria andTagsIsNull() {
            addCriterion("TAGS is null");
            return (Criteria) this;
        }

        public Criteria andTagsIsNotNull() {
            addCriterion("TAGS is not null");
            return (Criteria) this;
        }

        public Criteria andTagsEqualTo(String value) {
            addCriterion("TAGS =", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsNotEqualTo(String value) {
            addCriterion("TAGS <>", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsGreaterThan(String value) {
            addCriterion("TAGS >", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsGreaterThanOrEqualTo(String value) {
            addCriterion("TAGS >=", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsLessThan(String value) {
            addCriterion("TAGS <", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsLessThanOrEqualTo(String value) {
            addCriterion("TAGS <=", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsLike(String value) {
            addCriterion("TAGS like", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsNotLike(String value) {
            addCriterion("TAGS not like", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsIn(List<String> values) {
            addCriterion("TAGS in", values, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsNotIn(List<String> values) {
            addCriterion("TAGS not in", values, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsBetween(String value1, String value2) {
            addCriterion("TAGS between", value1, value2, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsNotBetween(String value1, String value2) {
            addCriterion("TAGS not between", value1, value2, "tags");
            return (Criteria) this;
        }

        public Criteria andConNameIsNull() {
            addCriterion("CON_NAME is null");
            return (Criteria) this;
        }

        public Criteria andConNameIsNotNull() {
            addCriterion("CON_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andConNameEqualTo(String value) {
            addCriterion("CON_NAME =", value, "conName");
            return (Criteria) this;
        }

        public Criteria andConNameNotEqualTo(String value) {
            addCriterion("CON_NAME <>", value, "conName");
            return (Criteria) this;
        }

        public Criteria andConNameGreaterThan(String value) {
            addCriterion("CON_NAME >", value, "conName");
            return (Criteria) this;
        }

        public Criteria andConNameGreaterThanOrEqualTo(String value) {
            addCriterion("CON_NAME >=", value, "conName");
            return (Criteria) this;
        }

        public Criteria andConNameLessThan(String value) {
            addCriterion("CON_NAME <", value, "conName");
            return (Criteria) this;
        }

        public Criteria andConNameLessThanOrEqualTo(String value) {
            addCriterion("CON_NAME <=", value, "conName");
            return (Criteria) this;
        }

        public Criteria andConNameLike(String value) {
            addCriterion("CON_NAME like", value, "conName");
            return (Criteria) this;
        }

        public Criteria andConNameNotLike(String value) {
            addCriterion("CON_NAME not like", value, "conName");
            return (Criteria) this;
        }

        public Criteria andConNameIn(List<String> values) {
            addCriterion("CON_NAME in", values, "conName");
            return (Criteria) this;
        }

        public Criteria andConNameNotIn(List<String> values) {
            addCriterion("CON_NAME not in", values, "conName");
            return (Criteria) this;
        }

        public Criteria andConNameBetween(String value1, String value2) {
            addCriterion("CON_NAME between", value1, value2, "conName");
            return (Criteria) this;
        }

        public Criteria andConNameNotBetween(String value1, String value2) {
            addCriterion("CON_NAME not between", value1, value2, "conName");
            return (Criteria) this;
        }

        public Criteria andConPropIsNull() {
            addCriterion("CON_PROP is null");
            return (Criteria) this;
        }

        public Criteria andConPropIsNotNull() {
            addCriterion("CON_PROP is not null");
            return (Criteria) this;
        }

        public Criteria andConPropEqualTo(BigDecimal value) {
            addCriterion("CON_PROP =", value, "conProp");
            return (Criteria) this;
        }

        public Criteria andConPropNotEqualTo(BigDecimal value) {
            addCriterion("CON_PROP <>", value, "conProp");
            return (Criteria) this;
        }

        public Criteria andConPropGreaterThan(BigDecimal value) {
            addCriterion("CON_PROP >", value, "conProp");
            return (Criteria) this;
        }

        public Criteria andConPropGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CON_PROP >=", value, "conProp");
            return (Criteria) this;
        }

        public Criteria andConPropLessThan(BigDecimal value) {
            addCriterion("CON_PROP <", value, "conProp");
            return (Criteria) this;
        }

        public Criteria andConPropLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CON_PROP <=", value, "conProp");
            return (Criteria) this;
        }

        public Criteria andConPropIn(List<BigDecimal> values) {
            addCriterion("CON_PROP in", values, "conProp");
            return (Criteria) this;
        }

        public Criteria andConPropNotIn(List<BigDecimal> values) {
            addCriterion("CON_PROP not in", values, "conProp");
            return (Criteria) this;
        }

        public Criteria andConPropBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CON_PROP between", value1, value2, "conProp");
            return (Criteria) this;
        }

        public Criteria andConPropNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CON_PROP not between", value1, value2, "conProp");
            return (Criteria) this;
        }

        public Criteria andRealConPropIsNull() {
            addCriterion("REAL_CON_PROP is null");
            return (Criteria) this;
        }

        public Criteria andRealConPropIsNotNull() {
            addCriterion("REAL_CON_PROP is not null");
            return (Criteria) this;
        }

        public Criteria andRealConPropEqualTo(BigDecimal value) {
            addCriterion("REAL_CON_PROP =", value, "realConProp");
            return (Criteria) this;
        }

        public Criteria andRealConPropNotEqualTo(BigDecimal value) {
            addCriterion("REAL_CON_PROP <>", value, "realConProp");
            return (Criteria) this;
        }

        public Criteria andRealConPropGreaterThan(BigDecimal value) {
            addCriterion("REAL_CON_PROP >", value, "realConProp");
            return (Criteria) this;
        }

        public Criteria andRealConPropGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("REAL_CON_PROP >=", value, "realConProp");
            return (Criteria) this;
        }

        public Criteria andRealConPropLessThan(BigDecimal value) {
            addCriterion("REAL_CON_PROP <", value, "realConProp");
            return (Criteria) this;
        }

        public Criteria andRealConPropLessThanOrEqualTo(BigDecimal value) {
            addCriterion("REAL_CON_PROP <=", value, "realConProp");
            return (Criteria) this;
        }

        public Criteria andRealConPropIn(List<BigDecimal> values) {
            addCriterion("REAL_CON_PROP in", values, "realConProp");
            return (Criteria) this;
        }

        public Criteria andRealConPropNotIn(List<BigDecimal> values) {
            addCriterion("REAL_CON_PROP not in", values, "realConProp");
            return (Criteria) this;
        }

        public Criteria andRealConPropBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("REAL_CON_PROP between", value1, value2, "realConProp");
            return (Criteria) this;
        }

        public Criteria andRealConPropNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("REAL_CON_PROP not between", value1, value2, "realConProp");
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

        public Criteria andIsDeleteEqualTo(Short value) {
            addCriterion("IS_DELETE =", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotEqualTo(Short value) {
            addCriterion("IS_DELETE <>", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThan(Short value) {
            addCriterion("IS_DELETE >", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteGreaterThanOrEqualTo(Short value) {
            addCriterion("IS_DELETE >=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThan(Short value) {
            addCriterion("IS_DELETE <", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteLessThanOrEqualTo(Short value) {
            addCriterion("IS_DELETE <=", value, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteIn(List<Short> values) {
            addCriterion("IS_DELETE in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotIn(List<Short> values) {
            addCriterion("IS_DELETE not in", values, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteBetween(Short value1, Short value2) {
            addCriterion("IS_DELETE between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andIsDeleteNotBetween(Short value1, Short value2) {
            addCriterion("IS_DELETE not between", value1, value2, "isDelete");
            return (Criteria) this;
        }

        public Criteria andNodeIdIsNull() {
            addCriterion("NODE_ID is null");
            return (Criteria) this;
        }

        public Criteria andNodeIdIsNotNull() {
            addCriterion("NODE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andNodeIdEqualTo(String value) {
            addCriterion("NODE_ID =", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdNotEqualTo(String value) {
            addCriterion("NODE_ID <>", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdGreaterThan(String value) {
            addCriterion("NODE_ID >", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdGreaterThanOrEqualTo(String value) {
            addCriterion("NODE_ID >=", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdLessThan(String value) {
            addCriterion("NODE_ID <", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdLessThanOrEqualTo(String value) {
            addCriterion("NODE_ID <=", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdLike(String value) {
            addCriterion("NODE_ID like", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdNotLike(String value) {
            addCriterion("NODE_ID not like", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdIn(List<String> values) {
            addCriterion("NODE_ID in", values, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdNotIn(List<String> values) {
            addCriterion("NODE_ID not in", values, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdBetween(String value1, String value2) {
            addCriterion("NODE_ID between", value1, value2, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdNotBetween(String value1, String value2) {
            addCriterion("NODE_ID not between", value1, value2, "nodeId");
            return (Criteria) this;
        }

        public Criteria andParentNodeIdIsNull() {
            addCriterion("PARENT_NODE_ID is null");
            return (Criteria) this;
        }

        public Criteria andParentNodeIdIsNotNull() {
            addCriterion("PARENT_NODE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andParentNodeIdEqualTo(String value) {
            addCriterion("PARENT_NODE_ID =", value, "parentNodeId");
            return (Criteria) this;
        }

        public Criteria andParentNodeIdNotEqualTo(String value) {
            addCriterion("PARENT_NODE_ID <>", value, "parentNodeId");
            return (Criteria) this;
        }

        public Criteria andParentNodeIdGreaterThan(String value) {
            addCriterion("PARENT_NODE_ID >", value, "parentNodeId");
            return (Criteria) this;
        }

        public Criteria andParentNodeIdGreaterThanOrEqualTo(String value) {
            addCriterion("PARENT_NODE_ID >=", value, "parentNodeId");
            return (Criteria) this;
        }

        public Criteria andParentNodeIdLessThan(String value) {
            addCriterion("PARENT_NODE_ID <", value, "parentNodeId");
            return (Criteria) this;
        }

        public Criteria andParentNodeIdLessThanOrEqualTo(String value) {
            addCriterion("PARENT_NODE_ID <=", value, "parentNodeId");
            return (Criteria) this;
        }

        public Criteria andParentNodeIdLike(String value) {
            addCriterion("PARENT_NODE_ID like", value, "parentNodeId");
            return (Criteria) this;
        }

        public Criteria andParentNodeIdNotLike(String value) {
            addCriterion("PARENT_NODE_ID not like", value, "parentNodeId");
            return (Criteria) this;
        }

        public Criteria andParentNodeIdIn(List<String> values) {
            addCriterion("PARENT_NODE_ID in", values, "parentNodeId");
            return (Criteria) this;
        }

        public Criteria andParentNodeIdNotIn(List<String> values) {
            addCriterion("PARENT_NODE_ID not in", values, "parentNodeId");
            return (Criteria) this;
        }

        public Criteria andParentNodeIdBetween(String value1, String value2) {
            addCriterion("PARENT_NODE_ID between", value1, value2, "parentNodeId");
            return (Criteria) this;
        }

        public Criteria andParentNodeIdNotBetween(String value1, String value2) {
            addCriterion("PARENT_NODE_ID not between", value1, value2, "parentNodeId");
            return (Criteria) this;
        }

        public Criteria andRegAmtIsNull() {
            addCriterion("REG_AMT is null");
            return (Criteria) this;
        }

        public Criteria andRegAmtIsNotNull() {
            addCriterion("REG_AMT is not null");
            return (Criteria) this;
        }

        public Criteria andRegAmtEqualTo(BigDecimal value) {
            addCriterion("REG_AMT =", value, "regAmt");
            return (Criteria) this;
        }

        public Criteria andRegAmtNotEqualTo(BigDecimal value) {
            addCriterion("REG_AMT <>", value, "regAmt");
            return (Criteria) this;
        }

        public Criteria andRegAmtGreaterThan(BigDecimal value) {
            addCriterion("REG_AMT >", value, "regAmt");
            return (Criteria) this;
        }

        public Criteria andRegAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("REG_AMT >=", value, "regAmt");
            return (Criteria) this;
        }

        public Criteria andRegAmtLessThan(BigDecimal value) {
            addCriterion("REG_AMT <", value, "regAmt");
            return (Criteria) this;
        }

        public Criteria andRegAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("REG_AMT <=", value, "regAmt");
            return (Criteria) this;
        }

        public Criteria andRegAmtIn(List<BigDecimal> values) {
            addCriterion("REG_AMT in", values, "regAmt");
            return (Criteria) this;
        }

        public Criteria andRegAmtNotIn(List<BigDecimal> values) {
            addCriterion("REG_AMT not in", values, "regAmt");
            return (Criteria) this;
        }

        public Criteria andRegAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("REG_AMT between", value1, value2, "regAmt");
            return (Criteria) this;
        }

        public Criteria andRegAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("REG_AMT not between", value1, value2, "regAmt");
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