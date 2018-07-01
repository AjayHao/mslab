package com.ajayhao.mslab.crawler.orm.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EntGsInfoEntityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EntGsInfoEntityExample() {
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

        public Criteria andRegNoIsNull() {
            addCriterion("REG_NO is null");
            return (Criteria) this;
        }

        public Criteria andRegNoIsNotNull() {
            addCriterion("REG_NO is not null");
            return (Criteria) this;
        }

        public Criteria andRegNoEqualTo(String value) {
            addCriterion("REG_NO =", value, "regNo");
            return (Criteria) this;
        }

        public Criteria andRegNoNotEqualTo(String value) {
            addCriterion("REG_NO <>", value, "regNo");
            return (Criteria) this;
        }

        public Criteria andRegNoGreaterThan(String value) {
            addCriterion("REG_NO >", value, "regNo");
            return (Criteria) this;
        }

        public Criteria andRegNoGreaterThanOrEqualTo(String value) {
            addCriterion("REG_NO >=", value, "regNo");
            return (Criteria) this;
        }

        public Criteria andRegNoLessThan(String value) {
            addCriterion("REG_NO <", value, "regNo");
            return (Criteria) this;
        }

        public Criteria andRegNoLessThanOrEqualTo(String value) {
            addCriterion("REG_NO <=", value, "regNo");
            return (Criteria) this;
        }

        public Criteria andRegNoLike(String value) {
            addCriterion("REG_NO like", value, "regNo");
            return (Criteria) this;
        }

        public Criteria andRegNoNotLike(String value) {
            addCriterion("REG_NO not like", value, "regNo");
            return (Criteria) this;
        }

        public Criteria andRegNoIn(List<String> values) {
            addCriterion("REG_NO in", values, "regNo");
            return (Criteria) this;
        }

        public Criteria andRegNoNotIn(List<String> values) {
            addCriterion("REG_NO not in", values, "regNo");
            return (Criteria) this;
        }

        public Criteria andRegNoBetween(String value1, String value2) {
            addCriterion("REG_NO between", value1, value2, "regNo");
            return (Criteria) this;
        }

        public Criteria andRegNoNotBetween(String value1, String value2) {
            addCriterion("REG_NO not between", value1, value2, "regNo");
            return (Criteria) this;
        }

        public Criteria andOriRegNoIsNull() {
            addCriterion("ORI_REG_NO is null");
            return (Criteria) this;
        }

        public Criteria andOriRegNoIsNotNull() {
            addCriterion("ORI_REG_NO is not null");
            return (Criteria) this;
        }

        public Criteria andOriRegNoEqualTo(String value) {
            addCriterion("ORI_REG_NO =", value, "oriRegNo");
            return (Criteria) this;
        }

        public Criteria andOriRegNoNotEqualTo(String value) {
            addCriterion("ORI_REG_NO <>", value, "oriRegNo");
            return (Criteria) this;
        }

        public Criteria andOriRegNoGreaterThan(String value) {
            addCriterion("ORI_REG_NO >", value, "oriRegNo");
            return (Criteria) this;
        }

        public Criteria andOriRegNoGreaterThanOrEqualTo(String value) {
            addCriterion("ORI_REG_NO >=", value, "oriRegNo");
            return (Criteria) this;
        }

        public Criteria andOriRegNoLessThan(String value) {
            addCriterion("ORI_REG_NO <", value, "oriRegNo");
            return (Criteria) this;
        }

        public Criteria andOriRegNoLessThanOrEqualTo(String value) {
            addCriterion("ORI_REG_NO <=", value, "oriRegNo");
            return (Criteria) this;
        }

        public Criteria andOriRegNoLike(String value) {
            addCriterion("ORI_REG_NO like", value, "oriRegNo");
            return (Criteria) this;
        }

        public Criteria andOriRegNoNotLike(String value) {
            addCriterion("ORI_REG_NO not like", value, "oriRegNo");
            return (Criteria) this;
        }

        public Criteria andOriRegNoIn(List<String> values) {
            addCriterion("ORI_REG_NO in", values, "oriRegNo");
            return (Criteria) this;
        }

        public Criteria andOriRegNoNotIn(List<String> values) {
            addCriterion("ORI_REG_NO not in", values, "oriRegNo");
            return (Criteria) this;
        }

        public Criteria andOriRegNoBetween(String value1, String value2) {
            addCriterion("ORI_REG_NO between", value1, value2, "oriRegNo");
            return (Criteria) this;
        }

        public Criteria andOriRegNoNotBetween(String value1, String value2) {
            addCriterion("ORI_REG_NO not between", value1, value2, "oriRegNo");
            return (Criteria) this;
        }

        public Criteria andCreditCodeIsNull() {
            addCriterion("CREDIT_CODE is null");
            return (Criteria) this;
        }

        public Criteria andCreditCodeIsNotNull() {
            addCriterion("CREDIT_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andCreditCodeEqualTo(String value) {
            addCriterion("CREDIT_CODE =", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeNotEqualTo(String value) {
            addCriterion("CREDIT_CODE <>", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeGreaterThan(String value) {
            addCriterion("CREDIT_CODE >", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeGreaterThanOrEqualTo(String value) {
            addCriterion("CREDIT_CODE >=", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeLessThan(String value) {
            addCriterion("CREDIT_CODE <", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeLessThanOrEqualTo(String value) {
            addCriterion("CREDIT_CODE <=", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeLike(String value) {
            addCriterion("CREDIT_CODE like", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeNotLike(String value) {
            addCriterion("CREDIT_CODE not like", value, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeIn(List<String> values) {
            addCriterion("CREDIT_CODE in", values, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeNotIn(List<String> values) {
            addCriterion("CREDIT_CODE not in", values, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeBetween(String value1, String value2) {
            addCriterion("CREDIT_CODE between", value1, value2, "creditCode");
            return (Criteria) this;
        }

        public Criteria andCreditCodeNotBetween(String value1, String value2) {
            addCriterion("CREDIT_CODE not between", value1, value2, "creditCode");
            return (Criteria) this;
        }

        public Criteria andFrNameIsNull() {
            addCriterion("FR_NAME is null");
            return (Criteria) this;
        }

        public Criteria andFrNameIsNotNull() {
            addCriterion("FR_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andFrNameEqualTo(String value) {
            addCriterion("FR_NAME =", value, "frName");
            return (Criteria) this;
        }

        public Criteria andFrNameNotEqualTo(String value) {
            addCriterion("FR_NAME <>", value, "frName");
            return (Criteria) this;
        }

        public Criteria andFrNameGreaterThan(String value) {
            addCriterion("FR_NAME >", value, "frName");
            return (Criteria) this;
        }

        public Criteria andFrNameGreaterThanOrEqualTo(String value) {
            addCriterion("FR_NAME >=", value, "frName");
            return (Criteria) this;
        }

        public Criteria andFrNameLessThan(String value) {
            addCriterion("FR_NAME <", value, "frName");
            return (Criteria) this;
        }

        public Criteria andFrNameLessThanOrEqualTo(String value) {
            addCriterion("FR_NAME <=", value, "frName");
            return (Criteria) this;
        }

        public Criteria andFrNameLike(String value) {
            addCriterion("FR_NAME like", value, "frName");
            return (Criteria) this;
        }

        public Criteria andFrNameNotLike(String value) {
            addCriterion("FR_NAME not like", value, "frName");
            return (Criteria) this;
        }

        public Criteria andFrNameIn(List<String> values) {
            addCriterion("FR_NAME in", values, "frName");
            return (Criteria) this;
        }

        public Criteria andFrNameNotIn(List<String> values) {
            addCriterion("FR_NAME not in", values, "frName");
            return (Criteria) this;
        }

        public Criteria andFrNameBetween(String value1, String value2) {
            addCriterion("FR_NAME between", value1, value2, "frName");
            return (Criteria) this;
        }

        public Criteria andFrNameNotBetween(String value1, String value2) {
            addCriterion("FR_NAME not between", value1, value2, "frName");
            return (Criteria) this;
        }

        public Criteria andRegCapIsNull() {
            addCriterion("REG_CAP is null");
            return (Criteria) this;
        }

        public Criteria andRegCapIsNotNull() {
            addCriterion("REG_CAP is not null");
            return (Criteria) this;
        }

        public Criteria andRegCapEqualTo(BigDecimal value) {
            addCriterion("REG_CAP =", value, "regCap");
            return (Criteria) this;
        }

        public Criteria andRegCapNotEqualTo(BigDecimal value) {
            addCriterion("REG_CAP <>", value, "regCap");
            return (Criteria) this;
        }

        public Criteria andRegCapGreaterThan(BigDecimal value) {
            addCriterion("REG_CAP >", value, "regCap");
            return (Criteria) this;
        }

        public Criteria andRegCapGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("REG_CAP >=", value, "regCap");
            return (Criteria) this;
        }

        public Criteria andRegCapLessThan(BigDecimal value) {
            addCriterion("REG_CAP <", value, "regCap");
            return (Criteria) this;
        }

        public Criteria andRegCapLessThanOrEqualTo(BigDecimal value) {
            addCriterion("REG_CAP <=", value, "regCap");
            return (Criteria) this;
        }

        public Criteria andRegCapIn(List<BigDecimal> values) {
            addCriterion("REG_CAP in", values, "regCap");
            return (Criteria) this;
        }

        public Criteria andRegCapNotIn(List<BigDecimal> values) {
            addCriterion("REG_CAP not in", values, "regCap");
            return (Criteria) this;
        }

        public Criteria andRegCapBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("REG_CAP between", value1, value2, "regCap");
            return (Criteria) this;
        }

        public Criteria andRegCapNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("REG_CAP not between", value1, value2, "regCap");
            return (Criteria) this;
        }

        public Criteria andRegCapCurIsNull() {
            addCriterion("REG_CAP_CUR is null");
            return (Criteria) this;
        }

        public Criteria andRegCapCurIsNotNull() {
            addCriterion("REG_CAP_CUR is not null");
            return (Criteria) this;
        }

        public Criteria andRegCapCurEqualTo(String value) {
            addCriterion("REG_CAP_CUR =", value, "regCapCur");
            return (Criteria) this;
        }

        public Criteria andRegCapCurNotEqualTo(String value) {
            addCriterion("REG_CAP_CUR <>", value, "regCapCur");
            return (Criteria) this;
        }

        public Criteria andRegCapCurGreaterThan(String value) {
            addCriterion("REG_CAP_CUR >", value, "regCapCur");
            return (Criteria) this;
        }

        public Criteria andRegCapCurGreaterThanOrEqualTo(String value) {
            addCriterion("REG_CAP_CUR >=", value, "regCapCur");
            return (Criteria) this;
        }

        public Criteria andRegCapCurLessThan(String value) {
            addCriterion("REG_CAP_CUR <", value, "regCapCur");
            return (Criteria) this;
        }

        public Criteria andRegCapCurLessThanOrEqualTo(String value) {
            addCriterion("REG_CAP_CUR <=", value, "regCapCur");
            return (Criteria) this;
        }

        public Criteria andRegCapCurLike(String value) {
            addCriterion("REG_CAP_CUR like", value, "regCapCur");
            return (Criteria) this;
        }

        public Criteria andRegCapCurNotLike(String value) {
            addCriterion("REG_CAP_CUR not like", value, "regCapCur");
            return (Criteria) this;
        }

        public Criteria andRegCapCurIn(List<String> values) {
            addCriterion("REG_CAP_CUR in", values, "regCapCur");
            return (Criteria) this;
        }

        public Criteria andRegCapCurNotIn(List<String> values) {
            addCriterion("REG_CAP_CUR not in", values, "regCapCur");
            return (Criteria) this;
        }

        public Criteria andRegCapCurBetween(String value1, String value2) {
            addCriterion("REG_CAP_CUR between", value1, value2, "regCapCur");
            return (Criteria) this;
        }

        public Criteria andRegCapCurNotBetween(String value1, String value2) {
            addCriterion("REG_CAP_CUR not between", value1, value2, "regCapCur");
            return (Criteria) this;
        }

        public Criteria andEntStatusIsNull() {
            addCriterion("ENT_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andEntStatusIsNotNull() {
            addCriterion("ENT_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andEntStatusEqualTo(String value) {
            addCriterion("ENT_STATUS =", value, "entStatus");
            return (Criteria) this;
        }

        public Criteria andEntStatusNotEqualTo(String value) {
            addCriterion("ENT_STATUS <>", value, "entStatus");
            return (Criteria) this;
        }

        public Criteria andEntStatusGreaterThan(String value) {
            addCriterion("ENT_STATUS >", value, "entStatus");
            return (Criteria) this;
        }

        public Criteria andEntStatusGreaterThanOrEqualTo(String value) {
            addCriterion("ENT_STATUS >=", value, "entStatus");
            return (Criteria) this;
        }

        public Criteria andEntStatusLessThan(String value) {
            addCriterion("ENT_STATUS <", value, "entStatus");
            return (Criteria) this;
        }

        public Criteria andEntStatusLessThanOrEqualTo(String value) {
            addCriterion("ENT_STATUS <=", value, "entStatus");
            return (Criteria) this;
        }

        public Criteria andEntStatusLike(String value) {
            addCriterion("ENT_STATUS like", value, "entStatus");
            return (Criteria) this;
        }

        public Criteria andEntStatusNotLike(String value) {
            addCriterion("ENT_STATUS not like", value, "entStatus");
            return (Criteria) this;
        }

        public Criteria andEntStatusIn(List<String> values) {
            addCriterion("ENT_STATUS in", values, "entStatus");
            return (Criteria) this;
        }

        public Criteria andEntStatusNotIn(List<String> values) {
            addCriterion("ENT_STATUS not in", values, "entStatus");
            return (Criteria) this;
        }

        public Criteria andEntStatusBetween(String value1, String value2) {
            addCriterion("ENT_STATUS between", value1, value2, "entStatus");
            return (Criteria) this;
        }

        public Criteria andEntStatusNotBetween(String value1, String value2) {
            addCriterion("ENT_STATUS not between", value1, value2, "entStatus");
            return (Criteria) this;
        }

        public Criteria andEntTypeIsNull() {
            addCriterion("ENT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andEntTypeIsNotNull() {
            addCriterion("ENT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andEntTypeEqualTo(String value) {
            addCriterion("ENT_TYPE =", value, "entType");
            return (Criteria) this;
        }

        public Criteria andEntTypeNotEqualTo(String value) {
            addCriterion("ENT_TYPE <>", value, "entType");
            return (Criteria) this;
        }

        public Criteria andEntTypeGreaterThan(String value) {
            addCriterion("ENT_TYPE >", value, "entType");
            return (Criteria) this;
        }

        public Criteria andEntTypeGreaterThanOrEqualTo(String value) {
            addCriterion("ENT_TYPE >=", value, "entType");
            return (Criteria) this;
        }

        public Criteria andEntTypeLessThan(String value) {
            addCriterion("ENT_TYPE <", value, "entType");
            return (Criteria) this;
        }

        public Criteria andEntTypeLessThanOrEqualTo(String value) {
            addCriterion("ENT_TYPE <=", value, "entType");
            return (Criteria) this;
        }

        public Criteria andEntTypeLike(String value) {
            addCriterion("ENT_TYPE like", value, "entType");
            return (Criteria) this;
        }

        public Criteria andEntTypeNotLike(String value) {
            addCriterion("ENT_TYPE not like", value, "entType");
            return (Criteria) this;
        }

        public Criteria andEntTypeIn(List<String> values) {
            addCriterion("ENT_TYPE in", values, "entType");
            return (Criteria) this;
        }

        public Criteria andEntTypeNotIn(List<String> values) {
            addCriterion("ENT_TYPE not in", values, "entType");
            return (Criteria) this;
        }

        public Criteria andEntTypeBetween(String value1, String value2) {
            addCriterion("ENT_TYPE between", value1, value2, "entType");
            return (Criteria) this;
        }

        public Criteria andEntTypeNotBetween(String value1, String value2) {
            addCriterion("ENT_TYPE not between", value1, value2, "entType");
            return (Criteria) this;
        }

        public Criteria andEsDateIsNull() {
            addCriterion("ES_DATE is null");
            return (Criteria) this;
        }

        public Criteria andEsDateIsNotNull() {
            addCriterion("ES_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andEsDateEqualTo(String value) {
            addCriterion("ES_DATE =", value, "esDate");
            return (Criteria) this;
        }

        public Criteria andEsDateNotEqualTo(String value) {
            addCriterion("ES_DATE <>", value, "esDate");
            return (Criteria) this;
        }

        public Criteria andEsDateGreaterThan(String value) {
            addCriterion("ES_DATE >", value, "esDate");
            return (Criteria) this;
        }

        public Criteria andEsDateGreaterThanOrEqualTo(String value) {
            addCriterion("ES_DATE >=", value, "esDate");
            return (Criteria) this;
        }

        public Criteria andEsDateLessThan(String value) {
            addCriterion("ES_DATE <", value, "esDate");
            return (Criteria) this;
        }

        public Criteria andEsDateLessThanOrEqualTo(String value) {
            addCriterion("ES_DATE <=", value, "esDate");
            return (Criteria) this;
        }

        public Criteria andEsDateLike(String value) {
            addCriterion("ES_DATE like", value, "esDate");
            return (Criteria) this;
        }

        public Criteria andEsDateNotLike(String value) {
            addCriterion("ES_DATE not like", value, "esDate");
            return (Criteria) this;
        }

        public Criteria andEsDateIn(List<String> values) {
            addCriterion("ES_DATE in", values, "esDate");
            return (Criteria) this;
        }

        public Criteria andEsDateNotIn(List<String> values) {
            addCriterion("ES_DATE not in", values, "esDate");
            return (Criteria) this;
        }

        public Criteria andEsDateBetween(String value1, String value2) {
            addCriterion("ES_DATE between", value1, value2, "esDate");
            return (Criteria) this;
        }

        public Criteria andEsDateNotBetween(String value1, String value2) {
            addCriterion("ES_DATE not between", value1, value2, "esDate");
            return (Criteria) this;
        }

        public Criteria andOpFromIsNull() {
            addCriterion("OP_FROM is null");
            return (Criteria) this;
        }

        public Criteria andOpFromIsNotNull() {
            addCriterion("OP_FROM is not null");
            return (Criteria) this;
        }

        public Criteria andOpFromEqualTo(String value) {
            addCriterion("OP_FROM =", value, "opFrom");
            return (Criteria) this;
        }

        public Criteria andOpFromNotEqualTo(String value) {
            addCriterion("OP_FROM <>", value, "opFrom");
            return (Criteria) this;
        }

        public Criteria andOpFromGreaterThan(String value) {
            addCriterion("OP_FROM >", value, "opFrom");
            return (Criteria) this;
        }

        public Criteria andOpFromGreaterThanOrEqualTo(String value) {
            addCriterion("OP_FROM >=", value, "opFrom");
            return (Criteria) this;
        }

        public Criteria andOpFromLessThan(String value) {
            addCriterion("OP_FROM <", value, "opFrom");
            return (Criteria) this;
        }

        public Criteria andOpFromLessThanOrEqualTo(String value) {
            addCriterion("OP_FROM <=", value, "opFrom");
            return (Criteria) this;
        }

        public Criteria andOpFromLike(String value) {
            addCriterion("OP_FROM like", value, "opFrom");
            return (Criteria) this;
        }

        public Criteria andOpFromNotLike(String value) {
            addCriterion("OP_FROM not like", value, "opFrom");
            return (Criteria) this;
        }

        public Criteria andOpFromIn(List<String> values) {
            addCriterion("OP_FROM in", values, "opFrom");
            return (Criteria) this;
        }

        public Criteria andOpFromNotIn(List<String> values) {
            addCriterion("OP_FROM not in", values, "opFrom");
            return (Criteria) this;
        }

        public Criteria andOpFromBetween(String value1, String value2) {
            addCriterion("OP_FROM between", value1, value2, "opFrom");
            return (Criteria) this;
        }

        public Criteria andOpFromNotBetween(String value1, String value2) {
            addCriterion("OP_FROM not between", value1, value2, "opFrom");
            return (Criteria) this;
        }

        public Criteria andOpToIsNull() {
            addCriterion("OP_TO is null");
            return (Criteria) this;
        }

        public Criteria andOpToIsNotNull() {
            addCriterion("OP_TO is not null");
            return (Criteria) this;
        }

        public Criteria andOpToEqualTo(String value) {
            addCriterion("OP_TO =", value, "opTo");
            return (Criteria) this;
        }

        public Criteria andOpToNotEqualTo(String value) {
            addCriterion("OP_TO <>", value, "opTo");
            return (Criteria) this;
        }

        public Criteria andOpToGreaterThan(String value) {
            addCriterion("OP_TO >", value, "opTo");
            return (Criteria) this;
        }

        public Criteria andOpToGreaterThanOrEqualTo(String value) {
            addCriterion("OP_TO >=", value, "opTo");
            return (Criteria) this;
        }

        public Criteria andOpToLessThan(String value) {
            addCriterion("OP_TO <", value, "opTo");
            return (Criteria) this;
        }

        public Criteria andOpToLessThanOrEqualTo(String value) {
            addCriterion("OP_TO <=", value, "opTo");
            return (Criteria) this;
        }

        public Criteria andOpToLike(String value) {
            addCriterion("OP_TO like", value, "opTo");
            return (Criteria) this;
        }

        public Criteria andOpToNotLike(String value) {
            addCriterion("OP_TO not like", value, "opTo");
            return (Criteria) this;
        }

        public Criteria andOpToIn(List<String> values) {
            addCriterion("OP_TO in", values, "opTo");
            return (Criteria) this;
        }

        public Criteria andOpToNotIn(List<String> values) {
            addCriterion("OP_TO not in", values, "opTo");
            return (Criteria) this;
        }

        public Criteria andOpToBetween(String value1, String value2) {
            addCriterion("OP_TO between", value1, value2, "opTo");
            return (Criteria) this;
        }

        public Criteria andOpToNotBetween(String value1, String value2) {
            addCriterion("OP_TO not between", value1, value2, "opTo");
            return (Criteria) this;
        }

        public Criteria andRegAddrIsNull() {
            addCriterion("REG_ADDR is null");
            return (Criteria) this;
        }

        public Criteria andRegAddrIsNotNull() {
            addCriterion("REG_ADDR is not null");
            return (Criteria) this;
        }

        public Criteria andRegAddrEqualTo(String value) {
            addCriterion("REG_ADDR =", value, "regAddr");
            return (Criteria) this;
        }

        public Criteria andRegAddrNotEqualTo(String value) {
            addCriterion("REG_ADDR <>", value, "regAddr");
            return (Criteria) this;
        }

        public Criteria andRegAddrGreaterThan(String value) {
            addCriterion("REG_ADDR >", value, "regAddr");
            return (Criteria) this;
        }

        public Criteria andRegAddrGreaterThanOrEqualTo(String value) {
            addCriterion("REG_ADDR >=", value, "regAddr");
            return (Criteria) this;
        }

        public Criteria andRegAddrLessThan(String value) {
            addCriterion("REG_ADDR <", value, "regAddr");
            return (Criteria) this;
        }

        public Criteria andRegAddrLessThanOrEqualTo(String value) {
            addCriterion("REG_ADDR <=", value, "regAddr");
            return (Criteria) this;
        }

        public Criteria andRegAddrLike(String value) {
            addCriterion("REG_ADDR like", value, "regAddr");
            return (Criteria) this;
        }

        public Criteria andRegAddrNotLike(String value) {
            addCriterion("REG_ADDR not like", value, "regAddr");
            return (Criteria) this;
        }

        public Criteria andRegAddrIn(List<String> values) {
            addCriterion("REG_ADDR in", values, "regAddr");
            return (Criteria) this;
        }

        public Criteria andRegAddrNotIn(List<String> values) {
            addCriterion("REG_ADDR not in", values, "regAddr");
            return (Criteria) this;
        }

        public Criteria andRegAddrBetween(String value1, String value2) {
            addCriterion("REG_ADDR between", value1, value2, "regAddr");
            return (Criteria) this;
        }

        public Criteria andRegAddrNotBetween(String value1, String value2) {
            addCriterion("REG_ADDR not between", value1, value2, "regAddr");
            return (Criteria) this;
        }

        public Criteria andRegOrgIsNull() {
            addCriterion("REG_ORG is null");
            return (Criteria) this;
        }

        public Criteria andRegOrgIsNotNull() {
            addCriterion("REG_ORG is not null");
            return (Criteria) this;
        }

        public Criteria andRegOrgEqualTo(String value) {
            addCriterion("REG_ORG =", value, "regOrg");
            return (Criteria) this;
        }

        public Criteria andRegOrgNotEqualTo(String value) {
            addCriterion("REG_ORG <>", value, "regOrg");
            return (Criteria) this;
        }

        public Criteria andRegOrgGreaterThan(String value) {
            addCriterion("REG_ORG >", value, "regOrg");
            return (Criteria) this;
        }

        public Criteria andRegOrgGreaterThanOrEqualTo(String value) {
            addCriterion("REG_ORG >=", value, "regOrg");
            return (Criteria) this;
        }

        public Criteria andRegOrgLessThan(String value) {
            addCriterion("REG_ORG <", value, "regOrg");
            return (Criteria) this;
        }

        public Criteria andRegOrgLessThanOrEqualTo(String value) {
            addCriterion("REG_ORG <=", value, "regOrg");
            return (Criteria) this;
        }

        public Criteria andRegOrgLike(String value) {
            addCriterion("REG_ORG like", value, "regOrg");
            return (Criteria) this;
        }

        public Criteria andRegOrgNotLike(String value) {
            addCriterion("REG_ORG not like", value, "regOrg");
            return (Criteria) this;
        }

        public Criteria andRegOrgIn(List<String> values) {
            addCriterion("REG_ORG in", values, "regOrg");
            return (Criteria) this;
        }

        public Criteria andRegOrgNotIn(List<String> values) {
            addCriterion("REG_ORG not in", values, "regOrg");
            return (Criteria) this;
        }

        public Criteria andRegOrgBetween(String value1, String value2) {
            addCriterion("REG_ORG between", value1, value2, "regOrg");
            return (Criteria) this;
        }

        public Criteria andRegOrgNotBetween(String value1, String value2) {
            addCriterion("REG_ORG not between", value1, value2, "regOrg");
            return (Criteria) this;
        }

        public Criteria andRegOrgCodeIsNull() {
            addCriterion("REG_ORG_CODE is null");
            return (Criteria) this;
        }

        public Criteria andRegOrgCodeIsNotNull() {
            addCriterion("REG_ORG_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andRegOrgCodeEqualTo(String value) {
            addCriterion("REG_ORG_CODE =", value, "regOrgCode");
            return (Criteria) this;
        }

        public Criteria andRegOrgCodeNotEqualTo(String value) {
            addCriterion("REG_ORG_CODE <>", value, "regOrgCode");
            return (Criteria) this;
        }

        public Criteria andRegOrgCodeGreaterThan(String value) {
            addCriterion("REG_ORG_CODE >", value, "regOrgCode");
            return (Criteria) this;
        }

        public Criteria andRegOrgCodeGreaterThanOrEqualTo(String value) {
            addCriterion("REG_ORG_CODE >=", value, "regOrgCode");
            return (Criteria) this;
        }

        public Criteria andRegOrgCodeLessThan(String value) {
            addCriterion("REG_ORG_CODE <", value, "regOrgCode");
            return (Criteria) this;
        }

        public Criteria andRegOrgCodeLessThanOrEqualTo(String value) {
            addCriterion("REG_ORG_CODE <=", value, "regOrgCode");
            return (Criteria) this;
        }

        public Criteria andRegOrgCodeLike(String value) {
            addCriterion("REG_ORG_CODE like", value, "regOrgCode");
            return (Criteria) this;
        }

        public Criteria andRegOrgCodeNotLike(String value) {
            addCriterion("REG_ORG_CODE not like", value, "regOrgCode");
            return (Criteria) this;
        }

        public Criteria andRegOrgCodeIn(List<String> values) {
            addCriterion("REG_ORG_CODE in", values, "regOrgCode");
            return (Criteria) this;
        }

        public Criteria andRegOrgCodeNotIn(List<String> values) {
            addCriterion("REG_ORG_CODE not in", values, "regOrgCode");
            return (Criteria) this;
        }

        public Criteria andRegOrgCodeBetween(String value1, String value2) {
            addCriterion("REG_ORG_CODE between", value1, value2, "regOrgCode");
            return (Criteria) this;
        }

        public Criteria andRegOrgCodeNotBetween(String value1, String value2) {
            addCriterion("REG_ORG_CODE not between", value1, value2, "regOrgCode");
            return (Criteria) this;
        }

        public Criteria andRegOrgProvinceIsNull() {
            addCriterion("REG_ORG_PROVINCE is null");
            return (Criteria) this;
        }

        public Criteria andRegOrgProvinceIsNotNull() {
            addCriterion("REG_ORG_PROVINCE is not null");
            return (Criteria) this;
        }

        public Criteria andRegOrgProvinceEqualTo(String value) {
            addCriterion("REG_ORG_PROVINCE =", value, "regOrgProvince");
            return (Criteria) this;
        }

        public Criteria andRegOrgProvinceNotEqualTo(String value) {
            addCriterion("REG_ORG_PROVINCE <>", value, "regOrgProvince");
            return (Criteria) this;
        }

        public Criteria andRegOrgProvinceGreaterThan(String value) {
            addCriterion("REG_ORG_PROVINCE >", value, "regOrgProvince");
            return (Criteria) this;
        }

        public Criteria andRegOrgProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("REG_ORG_PROVINCE >=", value, "regOrgProvince");
            return (Criteria) this;
        }

        public Criteria andRegOrgProvinceLessThan(String value) {
            addCriterion("REG_ORG_PROVINCE <", value, "regOrgProvince");
            return (Criteria) this;
        }

        public Criteria andRegOrgProvinceLessThanOrEqualTo(String value) {
            addCriterion("REG_ORG_PROVINCE <=", value, "regOrgProvince");
            return (Criteria) this;
        }

        public Criteria andRegOrgProvinceLike(String value) {
            addCriterion("REG_ORG_PROVINCE like", value, "regOrgProvince");
            return (Criteria) this;
        }

        public Criteria andRegOrgProvinceNotLike(String value) {
            addCriterion("REG_ORG_PROVINCE not like", value, "regOrgProvince");
            return (Criteria) this;
        }

        public Criteria andRegOrgProvinceIn(List<String> values) {
            addCriterion("REG_ORG_PROVINCE in", values, "regOrgProvince");
            return (Criteria) this;
        }

        public Criteria andRegOrgProvinceNotIn(List<String> values) {
            addCriterion("REG_ORG_PROVINCE not in", values, "regOrgProvince");
            return (Criteria) this;
        }

        public Criteria andRegOrgProvinceBetween(String value1, String value2) {
            addCriterion("REG_ORG_PROVINCE between", value1, value2, "regOrgProvince");
            return (Criteria) this;
        }

        public Criteria andRegOrgProvinceNotBetween(String value1, String value2) {
            addCriterion("REG_ORG_PROVINCE not between", value1, value2, "regOrgProvince");
            return (Criteria) this;
        }

        public Criteria andEmpNumIsNull() {
            addCriterion("EMP_NUM is null");
            return (Criteria) this;
        }

        public Criteria andEmpNumIsNotNull() {
            addCriterion("EMP_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andEmpNumEqualTo(Long value) {
            addCriterion("EMP_NUM =", value, "empNum");
            return (Criteria) this;
        }

        public Criteria andEmpNumNotEqualTo(Long value) {
            addCriterion("EMP_NUM <>", value, "empNum");
            return (Criteria) this;
        }

        public Criteria andEmpNumGreaterThan(Long value) {
            addCriterion("EMP_NUM >", value, "empNum");
            return (Criteria) this;
        }

        public Criteria andEmpNumGreaterThanOrEqualTo(Long value) {
            addCriterion("EMP_NUM >=", value, "empNum");
            return (Criteria) this;
        }

        public Criteria andEmpNumLessThan(Long value) {
            addCriterion("EMP_NUM <", value, "empNum");
            return (Criteria) this;
        }

        public Criteria andEmpNumLessThanOrEqualTo(Long value) {
            addCriterion("EMP_NUM <=", value, "empNum");
            return (Criteria) this;
        }

        public Criteria andEmpNumIn(List<Long> values) {
            addCriterion("EMP_NUM in", values, "empNum");
            return (Criteria) this;
        }

        public Criteria andEmpNumNotIn(List<Long> values) {
            addCriterion("EMP_NUM not in", values, "empNum");
            return (Criteria) this;
        }

        public Criteria andEmpNumBetween(Long value1, Long value2) {
            addCriterion("EMP_NUM between", value1, value2, "empNum");
            return (Criteria) this;
        }

        public Criteria andEmpNumNotBetween(Long value1, Long value2) {
            addCriterion("EMP_NUM not between", value1, value2, "empNum");
            return (Criteria) this;
        }

        public Criteria andTelIsNull() {
            addCriterion("TEL is null");
            return (Criteria) this;
        }

        public Criteria andTelIsNotNull() {
            addCriterion("TEL is not null");
            return (Criteria) this;
        }

        public Criteria andTelEqualTo(String value) {
            addCriterion("TEL =", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotEqualTo(String value) {
            addCriterion("TEL <>", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThan(String value) {
            addCriterion("TEL >", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelGreaterThanOrEqualTo(String value) {
            addCriterion("TEL >=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThan(String value) {
            addCriterion("TEL <", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLessThanOrEqualTo(String value) {
            addCriterion("TEL <=", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelLike(String value) {
            addCriterion("TEL like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotLike(String value) {
            addCriterion("TEL not like", value, "tel");
            return (Criteria) this;
        }

        public Criteria andTelIn(List<String> values) {
            addCriterion("TEL in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotIn(List<String> values) {
            addCriterion("TEL not in", values, "tel");
            return (Criteria) this;
        }

        public Criteria andTelBetween(String value1, String value2) {
            addCriterion("TEL between", value1, value2, "tel");
            return (Criteria) this;
        }

        public Criteria andTelNotBetween(String value1, String value2) {
            addCriterion("TEL not between", value1, value2, "tel");
            return (Criteria) this;
        }

        public Criteria andOpLocationIsNull() {
            addCriterion("OP_LOCATION is null");
            return (Criteria) this;
        }

        public Criteria andOpLocationIsNotNull() {
            addCriterion("OP_LOCATION is not null");
            return (Criteria) this;
        }

        public Criteria andOpLocationEqualTo(String value) {
            addCriterion("OP_LOCATION =", value, "opLocation");
            return (Criteria) this;
        }

        public Criteria andOpLocationNotEqualTo(String value) {
            addCriterion("OP_LOCATION <>", value, "opLocation");
            return (Criteria) this;
        }

        public Criteria andOpLocationGreaterThan(String value) {
            addCriterion("OP_LOCATION >", value, "opLocation");
            return (Criteria) this;
        }

        public Criteria andOpLocationGreaterThanOrEqualTo(String value) {
            addCriterion("OP_LOCATION >=", value, "opLocation");
            return (Criteria) this;
        }

        public Criteria andOpLocationLessThan(String value) {
            addCriterion("OP_LOCATION <", value, "opLocation");
            return (Criteria) this;
        }

        public Criteria andOpLocationLessThanOrEqualTo(String value) {
            addCriterion("OP_LOCATION <=", value, "opLocation");
            return (Criteria) this;
        }

        public Criteria andOpLocationLike(String value) {
            addCriterion("OP_LOCATION like", value, "opLocation");
            return (Criteria) this;
        }

        public Criteria andOpLocationNotLike(String value) {
            addCriterion("OP_LOCATION not like", value, "opLocation");
            return (Criteria) this;
        }

        public Criteria andOpLocationIn(List<String> values) {
            addCriterion("OP_LOCATION in", values, "opLocation");
            return (Criteria) this;
        }

        public Criteria andOpLocationNotIn(List<String> values) {
            addCriterion("OP_LOCATION not in", values, "opLocation");
            return (Criteria) this;
        }

        public Criteria andOpLocationBetween(String value1, String value2) {
            addCriterion("OP_LOCATION between", value1, value2, "opLocation");
            return (Criteria) this;
        }

        public Criteria andOpLocationNotBetween(String value1, String value2) {
            addCriterion("OP_LOCATION not between", value1, value2, "opLocation");
            return (Criteria) this;
        }

        public Criteria andIndustryCodeIsNull() {
            addCriterion("INDUSTRY_CODE is null");
            return (Criteria) this;
        }

        public Criteria andIndustryCodeIsNotNull() {
            addCriterion("INDUSTRY_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andIndustryCodeEqualTo(String value) {
            addCriterion("INDUSTRY_CODE =", value, "industryCode");
            return (Criteria) this;
        }

        public Criteria andIndustryCodeNotEqualTo(String value) {
            addCriterion("INDUSTRY_CODE <>", value, "industryCode");
            return (Criteria) this;
        }

        public Criteria andIndustryCodeGreaterThan(String value) {
            addCriterion("INDUSTRY_CODE >", value, "industryCode");
            return (Criteria) this;
        }

        public Criteria andIndustryCodeGreaterThanOrEqualTo(String value) {
            addCriterion("INDUSTRY_CODE >=", value, "industryCode");
            return (Criteria) this;
        }

        public Criteria andIndustryCodeLessThan(String value) {
            addCriterion("INDUSTRY_CODE <", value, "industryCode");
            return (Criteria) this;
        }

        public Criteria andIndustryCodeLessThanOrEqualTo(String value) {
            addCriterion("INDUSTRY_CODE <=", value, "industryCode");
            return (Criteria) this;
        }

        public Criteria andIndustryCodeLike(String value) {
            addCriterion("INDUSTRY_CODE like", value, "industryCode");
            return (Criteria) this;
        }

        public Criteria andIndustryCodeNotLike(String value) {
            addCriterion("INDUSTRY_CODE not like", value, "industryCode");
            return (Criteria) this;
        }

        public Criteria andIndustryCodeIn(List<String> values) {
            addCriterion("INDUSTRY_CODE in", values, "industryCode");
            return (Criteria) this;
        }

        public Criteria andIndustryCodeNotIn(List<String> values) {
            addCriterion("INDUSTRY_CODE not in", values, "industryCode");
            return (Criteria) this;
        }

        public Criteria andIndustryCodeBetween(String value1, String value2) {
            addCriterion("INDUSTRY_CODE between", value1, value2, "industryCode");
            return (Criteria) this;
        }

        public Criteria andIndustryCodeNotBetween(String value1, String value2) {
            addCriterion("INDUSTRY_CODE not between", value1, value2, "industryCode");
            return (Criteria) this;
        }

        public Criteria andIndustryNameIsNull() {
            addCriterion("INDUSTRY_NAME is null");
            return (Criteria) this;
        }

        public Criteria andIndustryNameIsNotNull() {
            addCriterion("INDUSTRY_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andIndustryNameEqualTo(String value) {
            addCriterion("INDUSTRY_NAME =", value, "industryName");
            return (Criteria) this;
        }

        public Criteria andIndustryNameNotEqualTo(String value) {
            addCriterion("INDUSTRY_NAME <>", value, "industryName");
            return (Criteria) this;
        }

        public Criteria andIndustryNameGreaterThan(String value) {
            addCriterion("INDUSTRY_NAME >", value, "industryName");
            return (Criteria) this;
        }

        public Criteria andIndustryNameGreaterThanOrEqualTo(String value) {
            addCriterion("INDUSTRY_NAME >=", value, "industryName");
            return (Criteria) this;
        }

        public Criteria andIndustryNameLessThan(String value) {
            addCriterion("INDUSTRY_NAME <", value, "industryName");
            return (Criteria) this;
        }

        public Criteria andIndustryNameLessThanOrEqualTo(String value) {
            addCriterion("INDUSTRY_NAME <=", value, "industryName");
            return (Criteria) this;
        }

        public Criteria andIndustryNameLike(String value) {
            addCriterion("INDUSTRY_NAME like", value, "industryName");
            return (Criteria) this;
        }

        public Criteria andIndustryNameNotLike(String value) {
            addCriterion("INDUSTRY_NAME not like", value, "industryName");
            return (Criteria) this;
        }

        public Criteria andIndustryNameIn(List<String> values) {
            addCriterion("INDUSTRY_NAME in", values, "industryName");
            return (Criteria) this;
        }

        public Criteria andIndustryNameNotIn(List<String> values) {
            addCriterion("INDUSTRY_NAME not in", values, "industryName");
            return (Criteria) this;
        }

        public Criteria andIndustryNameBetween(String value1, String value2) {
            addCriterion("INDUSTRY_NAME between", value1, value2, "industryName");
            return (Criteria) this;
        }

        public Criteria andIndustryNameNotBetween(String value1, String value2) {
            addCriterion("INDUSTRY_NAME not between", value1, value2, "industryName");
            return (Criteria) this;
        }

        public Criteria andOpScopeIsNull() {
            addCriterion("OP_SCOPE is null");
            return (Criteria) this;
        }

        public Criteria andOpScopeIsNotNull() {
            addCriterion("OP_SCOPE is not null");
            return (Criteria) this;
        }

        public Criteria andOpScopeEqualTo(String value) {
            addCriterion("OP_SCOPE =", value, "opScope");
            return (Criteria) this;
        }

        public Criteria andOpScopeNotEqualTo(String value) {
            addCriterion("OP_SCOPE <>", value, "opScope");
            return (Criteria) this;
        }

        public Criteria andOpScopeGreaterThan(String value) {
            addCriterion("OP_SCOPE >", value, "opScope");
            return (Criteria) this;
        }

        public Criteria andOpScopeGreaterThanOrEqualTo(String value) {
            addCriterion("OP_SCOPE >=", value, "opScope");
            return (Criteria) this;
        }

        public Criteria andOpScopeLessThan(String value) {
            addCriterion("OP_SCOPE <", value, "opScope");
            return (Criteria) this;
        }

        public Criteria andOpScopeLessThanOrEqualTo(String value) {
            addCriterion("OP_SCOPE <=", value, "opScope");
            return (Criteria) this;
        }

        public Criteria andOpScopeLike(String value) {
            addCriterion("OP_SCOPE like", value, "opScope");
            return (Criteria) this;
        }

        public Criteria andOpScopeNotLike(String value) {
            addCriterion("OP_SCOPE not like", value, "opScope");
            return (Criteria) this;
        }

        public Criteria andOpScopeIn(List<String> values) {
            addCriterion("OP_SCOPE in", values, "opScope");
            return (Criteria) this;
        }

        public Criteria andOpScopeNotIn(List<String> values) {
            addCriterion("OP_SCOPE not in", values, "opScope");
            return (Criteria) this;
        }

        public Criteria andOpScopeBetween(String value1, String value2) {
            addCriterion("OP_SCOPE between", value1, value2, "opScope");
            return (Criteria) this;
        }

        public Criteria andOpScopeNotBetween(String value1, String value2) {
            addCriterion("OP_SCOPE not between", value1, value2, "opScope");
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