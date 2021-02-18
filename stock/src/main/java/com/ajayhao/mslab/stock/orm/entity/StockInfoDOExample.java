package com.ajayhao.mslab.stock.orm.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StockInfoDOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StockInfoDOExample() {
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

        public Criteria andIdEqualTo(BigDecimal value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(BigDecimal value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(BigDecimal value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(BigDecimal value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<BigDecimal> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<BigDecimal> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andGidIsNull() {
            addCriterion("GID is null");
            return (Criteria) this;
        }

        public Criteria andGidIsNotNull() {
            addCriterion("GID is not null");
            return (Criteria) this;
        }

        public Criteria andGidEqualTo(String value) {
            addCriterion("GID =", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidNotEqualTo(String value) {
            addCriterion("GID <>", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidGreaterThan(String value) {
            addCriterion("GID >", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidGreaterThanOrEqualTo(String value) {
            addCriterion("GID >=", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidLessThan(String value) {
            addCriterion("GID <", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidLessThanOrEqualTo(String value) {
            addCriterion("GID <=", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidLike(String value) {
            addCriterion("GID like", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidNotLike(String value) {
            addCriterion("GID not like", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidIn(List<String> values) {
            addCriterion("GID in", values, "gid");
            return (Criteria) this;
        }

        public Criteria andGidNotIn(List<String> values) {
            addCriterion("GID not in", values, "gid");
            return (Criteria) this;
        }

        public Criteria andGidBetween(String value1, String value2) {
            addCriterion("GID between", value1, value2, "gid");
            return (Criteria) this;
        }

        public Criteria andGidNotBetween(String value1, String value2) {
            addCriterion("GID not between", value1, value2, "gid");
            return (Criteria) this;
        }

        public Criteria andWorkDateIsNull() {
            addCriterion("WORK_DATE is null");
            return (Criteria) this;
        }

        public Criteria andWorkDateIsNotNull() {
            addCriterion("WORK_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andWorkDateEqualTo(String value) {
            addCriterion("WORK_DATE =", value, "workDate");
            return (Criteria) this;
        }

        public Criteria andWorkDateNotEqualTo(String value) {
            addCriterion("WORK_DATE <>", value, "workDate");
            return (Criteria) this;
        }

        public Criteria andWorkDateGreaterThan(String value) {
            addCriterion("WORK_DATE >", value, "workDate");
            return (Criteria) this;
        }

        public Criteria andWorkDateGreaterThanOrEqualTo(String value) {
            addCriterion("WORK_DATE >=", value, "workDate");
            return (Criteria) this;
        }

        public Criteria andWorkDateLessThan(String value) {
            addCriterion("WORK_DATE <", value, "workDate");
            return (Criteria) this;
        }

        public Criteria andWorkDateLessThanOrEqualTo(String value) {
            addCriterion("WORK_DATE <=", value, "workDate");
            return (Criteria) this;
        }

        public Criteria andWorkDateLike(String value) {
            addCriterion("WORK_DATE like", value, "workDate");
            return (Criteria) this;
        }

        public Criteria andWorkDateNotLike(String value) {
            addCriterion("WORK_DATE not like", value, "workDate");
            return (Criteria) this;
        }

        public Criteria andWorkDateIn(List<String> values) {
            addCriterion("WORK_DATE in", values, "workDate");
            return (Criteria) this;
        }

        public Criteria andWorkDateNotIn(List<String> values) {
            addCriterion("WORK_DATE not in", values, "workDate");
            return (Criteria) this;
        }

        public Criteria andWorkDateBetween(String value1, String value2) {
            addCriterion("WORK_DATE between", value1, value2, "workDate");
            return (Criteria) this;
        }

        public Criteria andWorkDateNotBetween(String value1, String value2) {
            addCriterion("WORK_DATE not between", value1, value2, "workDate");
            return (Criteria) this;
        }

        public Criteria andStockNameIsNull() {
            addCriterion("STOCK_NAME is null");
            return (Criteria) this;
        }

        public Criteria andStockNameIsNotNull() {
            addCriterion("STOCK_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andStockNameEqualTo(String value) {
            addCriterion("STOCK_NAME =", value, "stockName");
            return (Criteria) this;
        }

        public Criteria andStockNameNotEqualTo(String value) {
            addCriterion("STOCK_NAME <>", value, "stockName");
            return (Criteria) this;
        }

        public Criteria andStockNameGreaterThan(String value) {
            addCriterion("STOCK_NAME >", value, "stockName");
            return (Criteria) this;
        }

        public Criteria andStockNameGreaterThanOrEqualTo(String value) {
            addCriterion("STOCK_NAME >=", value, "stockName");
            return (Criteria) this;
        }

        public Criteria andStockNameLessThan(String value) {
            addCriterion("STOCK_NAME <", value, "stockName");
            return (Criteria) this;
        }

        public Criteria andStockNameLessThanOrEqualTo(String value) {
            addCriterion("STOCK_NAME <=", value, "stockName");
            return (Criteria) this;
        }

        public Criteria andStockNameLike(String value) {
            addCriterion("STOCK_NAME like", value, "stockName");
            return (Criteria) this;
        }

        public Criteria andStockNameNotLike(String value) {
            addCriterion("STOCK_NAME not like", value, "stockName");
            return (Criteria) this;
        }

        public Criteria andStockNameIn(List<String> values) {
            addCriterion("STOCK_NAME in", values, "stockName");
            return (Criteria) this;
        }

        public Criteria andStockNameNotIn(List<String> values) {
            addCriterion("STOCK_NAME not in", values, "stockName");
            return (Criteria) this;
        }

        public Criteria andStockNameBetween(String value1, String value2) {
            addCriterion("STOCK_NAME between", value1, value2, "stockName");
            return (Criteria) this;
        }

        public Criteria andStockNameNotBetween(String value1, String value2) {
            addCriterion("STOCK_NAME not between", value1, value2, "stockName");
            return (Criteria) this;
        }

        public Criteria andIncrePerIsNull() {
            addCriterion("INCRE_PER is null");
            return (Criteria) this;
        }

        public Criteria andIncrePerIsNotNull() {
            addCriterion("INCRE_PER is not null");
            return (Criteria) this;
        }

        public Criteria andIncrePerEqualTo(BigDecimal value) {
            addCriterion("INCRE_PER =", value, "increPer");
            return (Criteria) this;
        }

        public Criteria andIncrePerNotEqualTo(BigDecimal value) {
            addCriterion("INCRE_PER <>", value, "increPer");
            return (Criteria) this;
        }

        public Criteria andIncrePerGreaterThan(BigDecimal value) {
            addCriterion("INCRE_PER >", value, "increPer");
            return (Criteria) this;
        }

        public Criteria andIncrePerGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("INCRE_PER >=", value, "increPer");
            return (Criteria) this;
        }

        public Criteria andIncrePerLessThan(BigDecimal value) {
            addCriterion("INCRE_PER <", value, "increPer");
            return (Criteria) this;
        }

        public Criteria andIncrePerLessThanOrEqualTo(BigDecimal value) {
            addCriterion("INCRE_PER <=", value, "increPer");
            return (Criteria) this;
        }

        public Criteria andIncrePerIn(List<BigDecimal> values) {
            addCriterion("INCRE_PER in", values, "increPer");
            return (Criteria) this;
        }

        public Criteria andIncrePerNotIn(List<BigDecimal> values) {
            addCriterion("INCRE_PER not in", values, "increPer");
            return (Criteria) this;
        }

        public Criteria andIncrePerBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("INCRE_PER between", value1, value2, "increPer");
            return (Criteria) this;
        }

        public Criteria andIncrePerNotBetween(String value1, String value2) {
            addCriterion("INCRE_PER not between", value1, value2, "increPer");
            return (Criteria) this;
        }

        public Criteria andIncreaseIsNull() {
            addCriterion("INCREASE is null");
            return (Criteria) this;
        }

        public Criteria andIncreaseIsNotNull() {
            addCriterion("INCREASE is not null");
            return (Criteria) this;
        }

        public Criteria andIncreaseEqualTo(BigDecimal value) {
            addCriterion("INCREASE =", value, "increase");
            return (Criteria) this;
        }

        public Criteria andIncreaseNotEqualTo(BigDecimal value) {
            addCriterion("INCREASE <>", value, "increase");
            return (Criteria) this;
        }

        public Criteria andIncreaseGreaterThan(BigDecimal value) {
            addCriterion("INCREASE >", value, "increase");
            return (Criteria) this;
        }

        public Criteria andIncreaseGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("INCREASE >=", value, "increase");
            return (Criteria) this;
        }

        public Criteria andIncreaseLessThan(BigDecimal value) {
            addCriterion("INCREASE <", value, "increase");
            return (Criteria) this;
        }

        public Criteria andIncreaseLessThanOrEqualTo(BigDecimal value) {
            addCriterion("INCREASE <=", value, "increase");
            return (Criteria) this;
        }

        public Criteria andIncreaseIn(List<BigDecimal> values) {
            addCriterion("INCREASE in", values, "increase");
            return (Criteria) this;
        }

        public Criteria andIncreaseNotIn(List<BigDecimal> values) {
            addCriterion("INCREASE not in", values, "increase");
            return (Criteria) this;
        }

        public Criteria andIncreaseBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("INCREASE between", value1, value2, "increase");
            return (Criteria) this;
        }

        public Criteria andIncreaseNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("INCREASE not between", value1, value2, "increase");
            return (Criteria) this;
        }

        public Criteria andTodayStartPriIsNull() {
            addCriterion("TODAY_START_PRI is null");
            return (Criteria) this;
        }

        public Criteria andTodayStartPriIsNotNull() {
            addCriterion("TODAY_START_PRI is not null");
            return (Criteria) this;
        }

        public Criteria andTodayStartPriEqualTo(BigDecimal value) {
            addCriterion("TODAY_START_PRI =", value, "todayStartPri");
            return (Criteria) this;
        }

        public Criteria andTodayStartPriNotEqualTo(BigDecimal value) {
            addCriterion("TODAY_START_PRI <>", value, "todayStartPri");
            return (Criteria) this;
        }

        public Criteria andTodayStartPriGreaterThan(BigDecimal value) {
            addCriterion("TODAY_START_PRI >", value, "todayStartPri");
            return (Criteria) this;
        }

        public Criteria andTodayStartPriGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TODAY_START_PRI >=", value, "todayStartPri");
            return (Criteria) this;
        }

        public Criteria andTodayStartPriLessThan(BigDecimal value) {
            addCriterion("TODAY_START_PRI <", value, "todayStartPri");
            return (Criteria) this;
        }

        public Criteria andTodayStartPriLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TODAY_START_PRI <=", value, "todayStartPri");
            return (Criteria) this;
        }

        public Criteria andTodayStartPriIn(List<BigDecimal> values) {
            addCriterion("TODAY_START_PRI in", values, "todayStartPri");
            return (Criteria) this;
        }

        public Criteria andTodayStartPriNotIn(List<BigDecimal> values) {
            addCriterion("TODAY_START_PRI not in", values, "todayStartPri");
            return (Criteria) this;
        }

        public Criteria andTodayStartPriBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TODAY_START_PRI between", value1, value2, "todayStartPri");
            return (Criteria) this;
        }

        public Criteria andTodayStartPriNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TODAY_START_PRI not between", value1, value2, "todayStartPri");
            return (Criteria) this;
        }

        public Criteria andYestodEndPriIsNull() {
            addCriterion("YESTOD_END_PRI is null");
            return (Criteria) this;
        }

        public Criteria andYestodEndPriIsNotNull() {
            addCriterion("YESTOD_END_PRI is not null");
            return (Criteria) this;
        }

        public Criteria andYestodEndPriEqualTo(BigDecimal value) {
            addCriterion("YESTOD_END_PRI =", value, "yestodEndPri");
            return (Criteria) this;
        }

        public Criteria andYestodEndPriNotEqualTo(BigDecimal value) {
            addCriterion("YESTOD_END_PRI <>", value, "yestodEndPri");
            return (Criteria) this;
        }

        public Criteria andYestodEndPriGreaterThan(BigDecimal value) {
            addCriterion("YESTOD_END_PRI >", value, "yestodEndPri");
            return (Criteria) this;
        }

        public Criteria andYestodEndPriGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("YESTOD_END_PRI >=", value, "yestodEndPri");
            return (Criteria) this;
        }

        public Criteria andYestodEndPriLessThan(BigDecimal value) {
            addCriterion("YESTOD_END_PRI <", value, "yestodEndPri");
            return (Criteria) this;
        }

        public Criteria andYestodEndPriLessThanOrEqualTo(BigDecimal value) {
            addCriterion("YESTOD_END_PRI <=", value, "yestodEndPri");
            return (Criteria) this;
        }

        public Criteria andYestodEndPriIn(List<BigDecimal> values) {
            addCriterion("YESTOD_END_PRI in", values, "yestodEndPri");
            return (Criteria) this;
        }

        public Criteria andYestodEndPriNotIn(List<BigDecimal> values) {
            addCriterion("YESTOD_END_PRI not in", values, "yestodEndPri");
            return (Criteria) this;
        }

        public Criteria andYestodEndPriBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("YESTOD_END_PRI between", value1, value2, "yestodEndPri");
            return (Criteria) this;
        }

        public Criteria andYestodEndPriNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("YESTOD_END_PRI not between", value1, value2, "yestodEndPri");
            return (Criteria) this;
        }

        public Criteria andNowPriIsNull() {
            addCriterion("NOW_PRI is null");
            return (Criteria) this;
        }

        public Criteria andNowPriIsNotNull() {
            addCriterion("NOW_PRI is not null");
            return (Criteria) this;
        }

        public Criteria andNowPriEqualTo(BigDecimal value) {
            addCriterion("NOW_PRI =", value, "nowPri");
            return (Criteria) this;
        }

        public Criteria andNowPriNotEqualTo(BigDecimal value) {
            addCriterion("NOW_PRI <>", value, "nowPri");
            return (Criteria) this;
        }

        public Criteria andNowPriGreaterThan(BigDecimal value) {
            addCriterion("NOW_PRI >", value, "nowPri");
            return (Criteria) this;
        }

        public Criteria andNowPriGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("NOW_PRI >=", value, "nowPri");
            return (Criteria) this;
        }

        public Criteria andNowPriLessThan(BigDecimal value) {
            addCriterion("NOW_PRI <", value, "nowPri");
            return (Criteria) this;
        }

        public Criteria andNowPriLessThanOrEqualTo(BigDecimal value) {
            addCriterion("NOW_PRI <=", value, "nowPri");
            return (Criteria) this;
        }

        public Criteria andNowPriIn(List<BigDecimal> values) {
            addCriterion("NOW_PRI in", values, "nowPri");
            return (Criteria) this;
        }

        public Criteria andNowPriNotIn(List<BigDecimal> values) {
            addCriterion("NOW_PRI not in", values, "nowPri");
            return (Criteria) this;
        }

        public Criteria andNowPriBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("NOW_PRI between", value1, value2, "nowPri");
            return (Criteria) this;
        }

        public Criteria andNowPriNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("NOW_PRI not between", value1, value2, "nowPri");
            return (Criteria) this;
        }

        public Criteria andTodayMaxIsNull() {
            addCriterion("TODAY_MAX is null");
            return (Criteria) this;
        }

        public Criteria andTodayMaxIsNotNull() {
            addCriterion("TODAY_MAX is not null");
            return (Criteria) this;
        }

        public Criteria andTodayMaxEqualTo(BigDecimal value) {
            addCriterion("TODAY_MAX =", value, "todayMax");
            return (Criteria) this;
        }

        public Criteria andTodayMaxNotEqualTo(BigDecimal value) {
            addCriterion("TODAY_MAX <>", value, "todayMax");
            return (Criteria) this;
        }

        public Criteria andTodayMaxGreaterThan(BigDecimal value) {
            addCriterion("TODAY_MAX >", value, "todayMax");
            return (Criteria) this;
        }

        public Criteria andTodayMaxGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TODAY_MAX >=", value, "todayMax");
            return (Criteria) this;
        }

        public Criteria andTodayMaxLessThan(BigDecimal value) {
            addCriterion("TODAY_MAX <", value, "todayMax");
            return (Criteria) this;
        }

        public Criteria andTodayMaxLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TODAY_MAX <=", value, "todayMax");
            return (Criteria) this;
        }

        public Criteria andTodayMaxIn(List<BigDecimal> values) {
            addCriterion("TODAY_MAX in", values, "todayMax");
            return (Criteria) this;
        }

        public Criteria andTodayMaxNotIn(List<BigDecimal> values) {
            addCriterion("TODAY_MAX not in", values, "todayMax");
            return (Criteria) this;
        }

        public Criteria andTodayMaxBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TODAY_MAX between", value1, value2, "todayMax");
            return (Criteria) this;
        }

        public Criteria andTodayMaxNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TODAY_MAX not between", value1, value2, "todayMax");
            return (Criteria) this;
        }

        public Criteria andTodayMinIsNull() {
            addCriterion("TODAY_MIN is null");
            return (Criteria) this;
        }

        public Criteria andTodayMinIsNotNull() {
            addCriterion("TODAY_MIN is not null");
            return (Criteria) this;
        }

        public Criteria andTodayMinEqualTo(BigDecimal value) {
            addCriterion("TODAY_MIN =", value, "todayMin");
            return (Criteria) this;
        }

        public Criteria andTodayMinNotEqualTo(BigDecimal value) {
            addCriterion("TODAY_MIN <>", value, "todayMin");
            return (Criteria) this;
        }

        public Criteria andTodayMinGreaterThan(BigDecimal value) {
            addCriterion("TODAY_MIN >", value, "todayMin");
            return (Criteria) this;
        }

        public Criteria andTodayMinGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TODAY_MIN >=", value, "todayMin");
            return (Criteria) this;
        }

        public Criteria andTodayMinLessThan(BigDecimal value) {
            addCriterion("TODAY_MIN <", value, "todayMin");
            return (Criteria) this;
        }

        public Criteria andTodayMinLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TODAY_MIN <=", value, "todayMin");
            return (Criteria) this;
        }

        public Criteria andTodayMinIn(List<BigDecimal> values) {
            addCriterion("TODAY_MIN in", values, "todayMin");
            return (Criteria) this;
        }

        public Criteria andTodayMinNotIn(List<BigDecimal> values) {
            addCriterion("TODAY_MIN not in", values, "todayMin");
            return (Criteria) this;
        }

        public Criteria andTodayMinBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TODAY_MIN between", value1, value2, "todayMin");
            return (Criteria) this;
        }

        public Criteria andTodayMinNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TODAY_MIN not between", value1, value2, "todayMin");
            return (Criteria) this;
        }

        public Criteria andTraNumberIsNull() {
            addCriterion("TRA_NUMBER is null");
            return (Criteria) this;
        }

        public Criteria andTraNumberIsNotNull() {
            addCriterion("TRA_NUMBER is not null");
            return (Criteria) this;
        }

        public Criteria andTraNumberEqualTo(BigDecimal value) {
            addCriterion("TRA_NUMBER =", value, "traNumber");
            return (Criteria) this;
        }

        public Criteria andTraNumberNotEqualTo(BigDecimal value) {
            addCriterion("TRA_NUMBER <>", value, "traNumber");
            return (Criteria) this;
        }

        public Criteria andTraNumberGreaterThan(BigDecimal value) {
            addCriterion("TRA_NUMBER >", value, "traNumber");
            return (Criteria) this;
        }

        public Criteria andTraNumberGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TRA_NUMBER >=", value, "traNumber");
            return (Criteria) this;
        }

        public Criteria andTraNumberLessThan(BigDecimal value) {
            addCriterion("TRA_NUMBER <", value, "traNumber");
            return (Criteria) this;
        }

        public Criteria andTraNumberLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TRA_NUMBER <=", value, "traNumber");
            return (Criteria) this;
        }

        public Criteria andTraNumberIn(List<BigDecimal> values) {
            addCriterion("TRA_NUMBER in", values, "traNumber");
            return (Criteria) this;
        }

        public Criteria andTraNumberNotIn(List<BigDecimal> values) {
            addCriterion("TRA_NUMBER not in", values, "traNumber");
            return (Criteria) this;
        }

        public Criteria andTraNumberBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TRA_NUMBER between", value1, value2, "traNumber");
            return (Criteria) this;
        }

        public Criteria andTraNumberNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TRA_NUMBER not between", value1, value2, "traNumber");
            return (Criteria) this;
        }

        public Criteria andTraAmountIsNull() {
            addCriterion("TRA_AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andTraAmountIsNotNull() {
            addCriterion("TRA_AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andTraAmountEqualTo(BigDecimal value) {
            addCriterion("TRA_AMOUNT =", value, "traAmount");
            return (Criteria) this;
        }

        public Criteria andTraAmountNotEqualTo(BigDecimal value) {
            addCriterion("TRA_AMOUNT <>", value, "traAmount");
            return (Criteria) this;
        }

        public Criteria andTraAmountGreaterThan(BigDecimal value) {
            addCriterion("TRA_AMOUNT >", value, "traAmount");
            return (Criteria) this;
        }

        public Criteria andTraAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TRA_AMOUNT >=", value, "traAmount");
            return (Criteria) this;
        }

        public Criteria andTraAmountLessThan(BigDecimal value) {
            addCriterion("TRA_AMOUNT <", value, "traAmount");
            return (Criteria) this;
        }

        public Criteria andTraAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TRA_AMOUNT <=", value, "traAmount");
            return (Criteria) this;
        }

        public Criteria andTraAmountIn(List<BigDecimal> values) {
            addCriterion("TRA_AMOUNT in", values, "traAmount");
            return (Criteria) this;
        }

        public Criteria andTraAmountNotIn(List<BigDecimal> values) {
            addCriterion("TRA_AMOUNT not in", values, "traAmount");
            return (Criteria) this;
        }

        public Criteria andTraAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TRA_AMOUNT between", value1, value2, "traAmount");
            return (Criteria) this;
        }

        public Criteria andTraAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TRA_AMOUNT not between", value1, value2, "traAmount");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedIsNull() {
            addCriterion("GMT_CREATED is null");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedIsNotNull() {
            addCriterion("GMT_CREATED is not null");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedEqualTo(Date value) {
            addCriterion("GMT_CREATED =", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedNotEqualTo(Date value) {
            addCriterion("GMT_CREATED <>", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedGreaterThan(Date value) {
            addCriterion("GMT_CREATED >", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedGreaterThanOrEqualTo(Date value) {
            addCriterion("GMT_CREATED >=", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedLessThan(Date value) {
            addCriterion("GMT_CREATED <", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedLessThanOrEqualTo(Date value) {
            addCriterion("GMT_CREATED <=", value, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedIn(List<Date> values) {
            addCriterion("GMT_CREATED in", values, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedNotIn(List<Date> values) {
            addCriterion("GMT_CREATED not in", values, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedBetween(Date value1, Date value2) {
            addCriterion("GMT_CREATED between", value1, value2, "gmtCreated");
            return (Criteria) this;
        }

        public Criteria andGmtCreatedNotBetween(Date value1, Date value2) {
            addCriterion("GMT_CREATED not between", value1, value2, "gmtCreated");
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

        public Criteria andGmtModifiedIsNull() {
            addCriterion("GMT_MODIFIED is null");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIsNotNull() {
            addCriterion("GMT_MODIFIED is not null");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedEqualTo(Date value) {
            addCriterion("GMT_MODIFIED =", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotEqualTo(Date value) {
            addCriterion("GMT_MODIFIED <>", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThan(Date value) {
            addCriterion("GMT_MODIFIED >", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedGreaterThanOrEqualTo(Date value) {
            addCriterion("GMT_MODIFIED >=", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThan(Date value) {
            addCriterion("GMT_MODIFIED <", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedLessThanOrEqualTo(Date value) {
            addCriterion("GMT_MODIFIED <=", value, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedIn(List<Date> values) {
            addCriterion("GMT_MODIFIED in", values, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotIn(List<Date> values) {
            addCriterion("GMT_MODIFIED not in", values, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedBetween(Date value1, Date value2) {
            addCriterion("GMT_MODIFIED between", value1, value2, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andGmtModifiedNotBetween(Date value1, Date value2) {
            addCriterion("GMT_MODIFIED not between", value1, value2, "gmtModified");
            return (Criteria) this;
        }

        public Criteria andModifierIsNull() {
            addCriterion("MODIFIER is null");
            return (Criteria) this;
        }

        public Criteria andModifierIsNotNull() {
            addCriterion("MODIFIER is not null");
            return (Criteria) this;
        }

        public Criteria andModifierEqualTo(String value) {
            addCriterion("MODIFIER =", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierNotEqualTo(String value) {
            addCriterion("MODIFIER <>", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierGreaterThan(String value) {
            addCriterion("MODIFIER >", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierGreaterThanOrEqualTo(String value) {
            addCriterion("MODIFIER >=", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierLessThan(String value) {
            addCriterion("MODIFIER <", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierLessThanOrEqualTo(String value) {
            addCriterion("MODIFIER <=", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierLike(String value) {
            addCriterion("MODIFIER like", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierNotLike(String value) {
            addCriterion("MODIFIER not like", value, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierIn(List<String> values) {
            addCriterion("MODIFIER in", values, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierNotIn(List<String> values) {
            addCriterion("MODIFIER not in", values, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierBetween(String value1, String value2) {
            addCriterion("MODIFIER between", value1, value2, "modifier");
            return (Criteria) this;
        }

        public Criteria andModifierNotBetween(String value1, String value2) {
            addCriterion("MODIFIER not between", value1, value2, "modifier");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNull() {
            addCriterion("IS_DELETED is null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNotNull() {
            addCriterion("IS_DELETED is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedEqualTo(String value) {
            addCriterion("IS_DELETED =", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotEqualTo(String value) {
            addCriterion("IS_DELETED <>", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThan(String value) {
            addCriterion("IS_DELETED >", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThanOrEqualTo(String value) {
            addCriterion("IS_DELETED >=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThan(String value) {
            addCriterion("IS_DELETED <", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThanOrEqualTo(String value) {
            addCriterion("IS_DELETED <=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLike(String value) {
            addCriterion("IS_DELETED like", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotLike(String value) {
            addCriterion("IS_DELETED not like", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIn(List<String> values) {
            addCriterion("IS_DELETED in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotIn(List<String> values) {
            addCriterion("IS_DELETED not in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedBetween(String value1, String value2) {
            addCriterion("IS_DELETED between", value1, value2, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotBetween(String value1, String value2) {
            addCriterion("IS_DELETED not between", value1, value2, "isDeleted");
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