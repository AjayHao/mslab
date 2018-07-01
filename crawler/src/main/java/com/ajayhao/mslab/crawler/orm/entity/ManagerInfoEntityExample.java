package com.ajayhao.mslab.crawler.orm.entity;

import java.util.ArrayList;
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

        public Criteria andGlrdmIsNull() {
            addCriterion("GLRDM is null");
            return (Criteria) this;
        }

        public Criteria andGlrdmIsNotNull() {
            addCriterion("GLRDM is not null");
            return (Criteria) this;
        }

        public Criteria andGlrdmEqualTo(String value) {
            addCriterion("GLRDM =", value, "glrdm");
            return (Criteria) this;
        }

        public Criteria andGlrdmNotEqualTo(String value) {
            addCriterion("GLRDM <>", value, "glrdm");
            return (Criteria) this;
        }

        public Criteria andGlrdmGreaterThan(String value) {
            addCriterion("GLRDM >", value, "glrdm");
            return (Criteria) this;
        }

        public Criteria andGlrdmGreaterThanOrEqualTo(String value) {
            addCriterion("GLRDM >=", value, "glrdm");
            return (Criteria) this;
        }

        public Criteria andGlrdmLessThan(String value) {
            addCriterion("GLRDM <", value, "glrdm");
            return (Criteria) this;
        }

        public Criteria andGlrdmLessThanOrEqualTo(String value) {
            addCriterion("GLRDM <=", value, "glrdm");
            return (Criteria) this;
        }

        public Criteria andGlrdmLike(String value) {
            addCriterion("GLRDM like", value, "glrdm");
            return (Criteria) this;
        }

        public Criteria andGlrdmNotLike(String value) {
            addCriterion("GLRDM not like", value, "glrdm");
            return (Criteria) this;
        }

        public Criteria andGlrdmIn(List<String> values) {
            addCriterion("GLRDM in", values, "glrdm");
            return (Criteria) this;
        }

        public Criteria andGlrdmNotIn(List<String> values) {
            addCriterion("GLRDM not in", values, "glrdm");
            return (Criteria) this;
        }

        public Criteria andGlrdmBetween(String value1, String value2) {
            addCriterion("GLRDM between", value1, value2, "glrdm");
            return (Criteria) this;
        }

        public Criteria andGlrdmNotBetween(String value1, String value2) {
            addCriterion("GLRDM not between", value1, value2, "glrdm");
            return (Criteria) this;
        }

        public Criteria andKhdmIsNull() {
            addCriterion("KHDM is null");
            return (Criteria) this;
        }

        public Criteria andKhdmIsNotNull() {
            addCriterion("KHDM is not null");
            return (Criteria) this;
        }

        public Criteria andKhdmEqualTo(String value) {
            addCriterion("KHDM =", value, "khdm");
            return (Criteria) this;
        }

        public Criteria andKhdmNotEqualTo(String value) {
            addCriterion("KHDM <>", value, "khdm");
            return (Criteria) this;
        }

        public Criteria andKhdmGreaterThan(String value) {
            addCriterion("KHDM >", value, "khdm");
            return (Criteria) this;
        }

        public Criteria andKhdmGreaterThanOrEqualTo(String value) {
            addCriterion("KHDM >=", value, "khdm");
            return (Criteria) this;
        }

        public Criteria andKhdmLessThan(String value) {
            addCriterion("KHDM <", value, "khdm");
            return (Criteria) this;
        }

        public Criteria andKhdmLessThanOrEqualTo(String value) {
            addCriterion("KHDM <=", value, "khdm");
            return (Criteria) this;
        }

        public Criteria andKhdmLike(String value) {
            addCriterion("KHDM like", value, "khdm");
            return (Criteria) this;
        }

        public Criteria andKhdmNotLike(String value) {
            addCriterion("KHDM not like", value, "khdm");
            return (Criteria) this;
        }

        public Criteria andKhdmIn(List<String> values) {
            addCriterion("KHDM in", values, "khdm");
            return (Criteria) this;
        }

        public Criteria andKhdmNotIn(List<String> values) {
            addCriterion("KHDM not in", values, "khdm");
            return (Criteria) this;
        }

        public Criteria andKhdmBetween(String value1, String value2) {
            addCriterion("KHDM between", value1, value2, "khdm");
            return (Criteria) this;
        }

        public Criteria andKhdmNotBetween(String value1, String value2) {
            addCriterion("KHDM not between", value1, value2, "khdm");
            return (Criteria) this;
        }

        public Criteria andKhfwlxIsNull() {
            addCriterion("KHFWLX is null");
            return (Criteria) this;
        }

        public Criteria andKhfwlxIsNotNull() {
            addCriterion("KHFWLX is not null");
            return (Criteria) this;
        }

        public Criteria andKhfwlxEqualTo(String value) {
            addCriterion("KHFWLX =", value, "khfwlx");
            return (Criteria) this;
        }

        public Criteria andKhfwlxNotEqualTo(String value) {
            addCriterion("KHFWLX <>", value, "khfwlx");
            return (Criteria) this;
        }

        public Criteria andKhfwlxGreaterThan(String value) {
            addCriterion("KHFWLX >", value, "khfwlx");
            return (Criteria) this;
        }

        public Criteria andKhfwlxGreaterThanOrEqualTo(String value) {
            addCriterion("KHFWLX >=", value, "khfwlx");
            return (Criteria) this;
        }

        public Criteria andKhfwlxLessThan(String value) {
            addCriterion("KHFWLX <", value, "khfwlx");
            return (Criteria) this;
        }

        public Criteria andKhfwlxLessThanOrEqualTo(String value) {
            addCriterion("KHFWLX <=", value, "khfwlx");
            return (Criteria) this;
        }

        public Criteria andKhfwlxLike(String value) {
            addCriterion("KHFWLX like", value, "khfwlx");
            return (Criteria) this;
        }

        public Criteria andKhfwlxNotLike(String value) {
            addCriterion("KHFWLX not like", value, "khfwlx");
            return (Criteria) this;
        }

        public Criteria andKhfwlxIn(List<String> values) {
            addCriterion("KHFWLX in", values, "khfwlx");
            return (Criteria) this;
        }

        public Criteria andKhfwlxNotIn(List<String> values) {
            addCriterion("KHFWLX not in", values, "khfwlx");
            return (Criteria) this;
        }

        public Criteria andKhfwlxBetween(String value1, String value2) {
            addCriterion("KHFWLX between", value1, value2, "khfwlx");
            return (Criteria) this;
        }

        public Criteria andKhfwlxNotBetween(String value1, String value2) {
            addCriterion("KHFWLX not between", value1, value2, "khfwlx");
            return (Criteria) this;
        }

        public Criteria andGlrmcIsNull() {
            addCriterion("GLRMC is null");
            return (Criteria) this;
        }

        public Criteria andGlrmcIsNotNull() {
            addCriterion("GLRMC is not null");
            return (Criteria) this;
        }

        public Criteria andGlrmcEqualTo(String value) {
            addCriterion("GLRMC =", value, "glrmc");
            return (Criteria) this;
        }

        public Criteria andGlrmcNotEqualTo(String value) {
            addCriterion("GLRMC <>", value, "glrmc");
            return (Criteria) this;
        }

        public Criteria andGlrmcGreaterThan(String value) {
            addCriterion("GLRMC >", value, "glrmc");
            return (Criteria) this;
        }

        public Criteria andGlrmcGreaterThanOrEqualTo(String value) {
            addCriterion("GLRMC >=", value, "glrmc");
            return (Criteria) this;
        }

        public Criteria andGlrmcLessThan(String value) {
            addCriterion("GLRMC <", value, "glrmc");
            return (Criteria) this;
        }

        public Criteria andGlrmcLessThanOrEqualTo(String value) {
            addCriterion("GLRMC <=", value, "glrmc");
            return (Criteria) this;
        }

        public Criteria andGlrmcLike(String value) {
            addCriterion("GLRMC like", value, "glrmc");
            return (Criteria) this;
        }

        public Criteria andGlrmcNotLike(String value) {
            addCriterion("GLRMC not like", value, "glrmc");
            return (Criteria) this;
        }

        public Criteria andGlrmcIn(List<String> values) {
            addCriterion("GLRMC in", values, "glrmc");
            return (Criteria) this;
        }

        public Criteria andGlrmcNotIn(List<String> values) {
            addCriterion("GLRMC not in", values, "glrmc");
            return (Criteria) this;
        }

        public Criteria andGlrmcBetween(String value1, String value2) {
            addCriterion("GLRMC between", value1, value2, "glrmc");
            return (Criteria) this;
        }

        public Criteria andGlrmcNotBetween(String value1, String value2) {
            addCriterion("GLRMC not between", value1, value2, "glrmc");
            return (Criteria) this;
        }

        public Criteria andGlrlxIsNull() {
            addCriterion("GLRLX is null");
            return (Criteria) this;
        }

        public Criteria andGlrlxIsNotNull() {
            addCriterion("GLRLX is not null");
            return (Criteria) this;
        }

        public Criteria andGlrlxEqualTo(String value) {
            addCriterion("GLRLX =", value, "glrlx");
            return (Criteria) this;
        }

        public Criteria andGlrlxNotEqualTo(String value) {
            addCriterion("GLRLX <>", value, "glrlx");
            return (Criteria) this;
        }

        public Criteria andGlrlxGreaterThan(String value) {
            addCriterion("GLRLX >", value, "glrlx");
            return (Criteria) this;
        }

        public Criteria andGlrlxGreaterThanOrEqualTo(String value) {
            addCriterion("GLRLX >=", value, "glrlx");
            return (Criteria) this;
        }

        public Criteria andGlrlxLessThan(String value) {
            addCriterion("GLRLX <", value, "glrlx");
            return (Criteria) this;
        }

        public Criteria andGlrlxLessThanOrEqualTo(String value) {
            addCriterion("GLRLX <=", value, "glrlx");
            return (Criteria) this;
        }

        public Criteria andGlrlxLike(String value) {
            addCriterion("GLRLX like", value, "glrlx");
            return (Criteria) this;
        }

        public Criteria andGlrlxNotLike(String value) {
            addCriterion("GLRLX not like", value, "glrlx");
            return (Criteria) this;
        }

        public Criteria andGlrlxIn(List<String> values) {
            addCriterion("GLRLX in", values, "glrlx");
            return (Criteria) this;
        }

        public Criteria andGlrlxNotIn(List<String> values) {
            addCriterion("GLRLX not in", values, "glrlx");
            return (Criteria) this;
        }

        public Criteria andGlrlxBetween(String value1, String value2) {
            addCriterion("GLRLX between", value1, value2, "glrlx");
            return (Criteria) this;
        }

        public Criteria andGlrlxNotBetween(String value1, String value2) {
            addCriterion("GLRLX not between", value1, value2, "glrlx");
            return (Criteria) this;
        }

        public Criteria andGlrlbIsNull() {
            addCriterion("GLRLB is null");
            return (Criteria) this;
        }

        public Criteria andGlrlbIsNotNull() {
            addCriterion("GLRLB is not null");
            return (Criteria) this;
        }

        public Criteria andGlrlbEqualTo(String value) {
            addCriterion("GLRLB =", value, "glrlb");
            return (Criteria) this;
        }

        public Criteria andGlrlbNotEqualTo(String value) {
            addCriterion("GLRLB <>", value, "glrlb");
            return (Criteria) this;
        }

        public Criteria andGlrlbGreaterThan(String value) {
            addCriterion("GLRLB >", value, "glrlb");
            return (Criteria) this;
        }

        public Criteria andGlrlbGreaterThanOrEqualTo(String value) {
            addCriterion("GLRLB >=", value, "glrlb");
            return (Criteria) this;
        }

        public Criteria andGlrlbLessThan(String value) {
            addCriterion("GLRLB <", value, "glrlb");
            return (Criteria) this;
        }

        public Criteria andGlrlbLessThanOrEqualTo(String value) {
            addCriterion("GLRLB <=", value, "glrlb");
            return (Criteria) this;
        }

        public Criteria andGlrlbLike(String value) {
            addCriterion("GLRLB like", value, "glrlb");
            return (Criteria) this;
        }

        public Criteria andGlrlbNotLike(String value) {
            addCriterion("GLRLB not like", value, "glrlb");
            return (Criteria) this;
        }

        public Criteria andGlrlbIn(List<String> values) {
            addCriterion("GLRLB in", values, "glrlb");
            return (Criteria) this;
        }

        public Criteria andGlrlbNotIn(List<String> values) {
            addCriterion("GLRLB not in", values, "glrlb");
            return (Criteria) this;
        }

        public Criteria andGlrlbBetween(String value1, String value2) {
            addCriterion("GLRLB between", value1, value2, "glrlb");
            return (Criteria) this;
        }

        public Criteria andGlrlbNotBetween(String value1, String value2) {
            addCriterion("GLRLB not between", value1, value2, "glrlb");
            return (Criteria) this;
        }

        public Criteria andGlrcxIsNull() {
            addCriterion("GLRCX is null");
            return (Criteria) this;
        }

        public Criteria andGlrcxIsNotNull() {
            addCriterion("GLRCX is not null");
            return (Criteria) this;
        }

        public Criteria andGlrcxEqualTo(String value) {
            addCriterion("GLRCX =", value, "glrcx");
            return (Criteria) this;
        }

        public Criteria andGlrcxNotEqualTo(String value) {
            addCriterion("GLRCX <>", value, "glrcx");
            return (Criteria) this;
        }

        public Criteria andGlrcxGreaterThan(String value) {
            addCriterion("GLRCX >", value, "glrcx");
            return (Criteria) this;
        }

        public Criteria andGlrcxGreaterThanOrEqualTo(String value) {
            addCriterion("GLRCX >=", value, "glrcx");
            return (Criteria) this;
        }

        public Criteria andGlrcxLessThan(String value) {
            addCriterion("GLRCX <", value, "glrcx");
            return (Criteria) this;
        }

        public Criteria andGlrcxLessThanOrEqualTo(String value) {
            addCriterion("GLRCX <=", value, "glrcx");
            return (Criteria) this;
        }

        public Criteria andGlrcxLike(String value) {
            addCriterion("GLRCX like", value, "glrcx");
            return (Criteria) this;
        }

        public Criteria andGlrcxNotLike(String value) {
            addCriterion("GLRCX not like", value, "glrcx");
            return (Criteria) this;
        }

        public Criteria andGlrcxIn(List<String> values) {
            addCriterion("GLRCX in", values, "glrcx");
            return (Criteria) this;
        }

        public Criteria andGlrcxNotIn(List<String> values) {
            addCriterion("GLRCX not in", values, "glrcx");
            return (Criteria) this;
        }

        public Criteria andGlrcxBetween(String value1, String value2) {
            addCriterion("GLRCX between", value1, value2, "glrcx");
            return (Criteria) this;
        }

        public Criteria andGlrcxNotBetween(String value1, String value2) {
            addCriterion("GLRCX not between", value1, value2, "glrcx");
            return (Criteria) this;
        }

        public Criteria andClrqIsNull() {
            addCriterion("CLRQ is null");
            return (Criteria) this;
        }

        public Criteria andClrqIsNotNull() {
            addCriterion("CLRQ is not null");
            return (Criteria) this;
        }

        public Criteria andClrqEqualTo(String value) {
            addCriterion("CLRQ =", value, "clrq");
            return (Criteria) this;
        }

        public Criteria andClrqNotEqualTo(String value) {
            addCriterion("CLRQ <>", value, "clrq");
            return (Criteria) this;
        }

        public Criteria andClrqGreaterThan(String value) {
            addCriterion("CLRQ >", value, "clrq");
            return (Criteria) this;
        }

        public Criteria andClrqGreaterThanOrEqualTo(String value) {
            addCriterion("CLRQ >=", value, "clrq");
            return (Criteria) this;
        }

        public Criteria andClrqLessThan(String value) {
            addCriterion("CLRQ <", value, "clrq");
            return (Criteria) this;
        }

        public Criteria andClrqLessThanOrEqualTo(String value) {
            addCriterion("CLRQ <=", value, "clrq");
            return (Criteria) this;
        }

        public Criteria andClrqLike(String value) {
            addCriterion("CLRQ like", value, "clrq");
            return (Criteria) this;
        }

        public Criteria andClrqNotLike(String value) {
            addCriterion("CLRQ not like", value, "clrq");
            return (Criteria) this;
        }

        public Criteria andClrqIn(List<String> values) {
            addCriterion("CLRQ in", values, "clrq");
            return (Criteria) this;
        }

        public Criteria andClrqNotIn(List<String> values) {
            addCriterion("CLRQ not in", values, "clrq");
            return (Criteria) this;
        }

        public Criteria andClrqBetween(String value1, String value2) {
            addCriterion("CLRQ between", value1, value2, "clrq");
            return (Criteria) this;
        }

        public Criteria andClrqNotBetween(String value1, String value2) {
            addCriterion("CLRQ not between", value1, value2, "clrq");
            return (Criteria) this;
        }

        public Criteria andZzjgdmIsNull() {
            addCriterion("ZZJGDM is null");
            return (Criteria) this;
        }

        public Criteria andZzjgdmIsNotNull() {
            addCriterion("ZZJGDM is not null");
            return (Criteria) this;
        }

        public Criteria andZzjgdmEqualTo(String value) {
            addCriterion("ZZJGDM =", value, "zzjgdm");
            return (Criteria) this;
        }

        public Criteria andZzjgdmNotEqualTo(String value) {
            addCriterion("ZZJGDM <>", value, "zzjgdm");
            return (Criteria) this;
        }

        public Criteria andZzjgdmGreaterThan(String value) {
            addCriterion("ZZJGDM >", value, "zzjgdm");
            return (Criteria) this;
        }

        public Criteria andZzjgdmGreaterThanOrEqualTo(String value) {
            addCriterion("ZZJGDM >=", value, "zzjgdm");
            return (Criteria) this;
        }

        public Criteria andZzjgdmLessThan(String value) {
            addCriterion("ZZJGDM <", value, "zzjgdm");
            return (Criteria) this;
        }

        public Criteria andZzjgdmLessThanOrEqualTo(String value) {
            addCriterion("ZZJGDM <=", value, "zzjgdm");
            return (Criteria) this;
        }

        public Criteria andZzjgdmLike(String value) {
            addCriterion("ZZJGDM like", value, "zzjgdm");
            return (Criteria) this;
        }

        public Criteria andZzjgdmNotLike(String value) {
            addCriterion("ZZJGDM not like", value, "zzjgdm");
            return (Criteria) this;
        }

        public Criteria andZzjgdmIn(List<String> values) {
            addCriterion("ZZJGDM in", values, "zzjgdm");
            return (Criteria) this;
        }

        public Criteria andZzjgdmNotIn(List<String> values) {
            addCriterion("ZZJGDM not in", values, "zzjgdm");
            return (Criteria) this;
        }

        public Criteria andZzjgdmBetween(String value1, String value2) {
            addCriterion("ZZJGDM between", value1, value2, "zzjgdm");
            return (Criteria) this;
        }

        public Criteria andZzjgdmNotBetween(String value1, String value2) {
            addCriterion("ZZJGDM not between", value1, value2, "zzjgdm");
            return (Criteria) this;
        }

        public Criteria andGlrfrIsNull() {
            addCriterion("GLRFR is null");
            return (Criteria) this;
        }

        public Criteria andGlrfrIsNotNull() {
            addCriterion("GLRFR is not null");
            return (Criteria) this;
        }

        public Criteria andGlrfrEqualTo(String value) {
            addCriterion("GLRFR =", value, "glrfr");
            return (Criteria) this;
        }

        public Criteria andGlrfrNotEqualTo(String value) {
            addCriterion("GLRFR <>", value, "glrfr");
            return (Criteria) this;
        }

        public Criteria andGlrfrGreaterThan(String value) {
            addCriterion("GLRFR >", value, "glrfr");
            return (Criteria) this;
        }

        public Criteria andGlrfrGreaterThanOrEqualTo(String value) {
            addCriterion("GLRFR >=", value, "glrfr");
            return (Criteria) this;
        }

        public Criteria andGlrfrLessThan(String value) {
            addCriterion("GLRFR <", value, "glrfr");
            return (Criteria) this;
        }

        public Criteria andGlrfrLessThanOrEqualTo(String value) {
            addCriterion("GLRFR <=", value, "glrfr");
            return (Criteria) this;
        }

        public Criteria andGlrfrLike(String value) {
            addCriterion("GLRFR like", value, "glrfr");
            return (Criteria) this;
        }

        public Criteria andGlrfrNotLike(String value) {
            addCriterion("GLRFR not like", value, "glrfr");
            return (Criteria) this;
        }

        public Criteria andGlrfrIn(List<String> values) {
            addCriterion("GLRFR in", values, "glrfr");
            return (Criteria) this;
        }

        public Criteria andGlrfrNotIn(List<String> values) {
            addCriterion("GLRFR not in", values, "glrfr");
            return (Criteria) this;
        }

        public Criteria andGlrfrBetween(String value1, String value2) {
            addCriterion("GLRFR between", value1, value2, "glrfr");
            return (Criteria) this;
        }

        public Criteria andGlrfrNotBetween(String value1, String value2) {
            addCriterion("GLRFR not between", value1, value2, "glrfr");
            return (Criteria) this;
        }

        public Criteria andGlrlxdzIsNull() {
            addCriterion("GLRLXDZ is null");
            return (Criteria) this;
        }

        public Criteria andGlrlxdzIsNotNull() {
            addCriterion("GLRLXDZ is not null");
            return (Criteria) this;
        }

        public Criteria andGlrlxdzEqualTo(String value) {
            addCriterion("GLRLXDZ =", value, "glrlxdz");
            return (Criteria) this;
        }

        public Criteria andGlrlxdzNotEqualTo(String value) {
            addCriterion("GLRLXDZ <>", value, "glrlxdz");
            return (Criteria) this;
        }

        public Criteria andGlrlxdzGreaterThan(String value) {
            addCriterion("GLRLXDZ >", value, "glrlxdz");
            return (Criteria) this;
        }

        public Criteria andGlrlxdzGreaterThanOrEqualTo(String value) {
            addCriterion("GLRLXDZ >=", value, "glrlxdz");
            return (Criteria) this;
        }

        public Criteria andGlrlxdzLessThan(String value) {
            addCriterion("GLRLXDZ <", value, "glrlxdz");
            return (Criteria) this;
        }

        public Criteria andGlrlxdzLessThanOrEqualTo(String value) {
            addCriterion("GLRLXDZ <=", value, "glrlxdz");
            return (Criteria) this;
        }

        public Criteria andGlrlxdzLike(String value) {
            addCriterion("GLRLXDZ like", value, "glrlxdz");
            return (Criteria) this;
        }

        public Criteria andGlrlxdzNotLike(String value) {
            addCriterion("GLRLXDZ not like", value, "glrlxdz");
            return (Criteria) this;
        }

        public Criteria andGlrlxdzIn(List<String> values) {
            addCriterion("GLRLXDZ in", values, "glrlxdz");
            return (Criteria) this;
        }

        public Criteria andGlrlxdzNotIn(List<String> values) {
            addCriterion("GLRLXDZ not in", values, "glrlxdz");
            return (Criteria) this;
        }

        public Criteria andGlrlxdzBetween(String value1, String value2) {
            addCriterion("GLRLXDZ between", value1, value2, "glrlxdz");
            return (Criteria) this;
        }

        public Criteria andGlrlxdzNotBetween(String value1, String value2) {
            addCriterion("GLRLXDZ not between", value1, value2, "glrlxdz");
            return (Criteria) this;
        }

        public Criteria andGlrlxdhIsNull() {
            addCriterion("GLRLXDH is null");
            return (Criteria) this;
        }

        public Criteria andGlrlxdhIsNotNull() {
            addCriterion("GLRLXDH is not null");
            return (Criteria) this;
        }

        public Criteria andGlrlxdhEqualTo(String value) {
            addCriterion("GLRLXDH =", value, "glrlxdh");
            return (Criteria) this;
        }

        public Criteria andGlrlxdhNotEqualTo(String value) {
            addCriterion("GLRLXDH <>", value, "glrlxdh");
            return (Criteria) this;
        }

        public Criteria andGlrlxdhGreaterThan(String value) {
            addCriterion("GLRLXDH >", value, "glrlxdh");
            return (Criteria) this;
        }

        public Criteria andGlrlxdhGreaterThanOrEqualTo(String value) {
            addCriterion("GLRLXDH >=", value, "glrlxdh");
            return (Criteria) this;
        }

        public Criteria andGlrlxdhLessThan(String value) {
            addCriterion("GLRLXDH <", value, "glrlxdh");
            return (Criteria) this;
        }

        public Criteria andGlrlxdhLessThanOrEqualTo(String value) {
            addCriterion("GLRLXDH <=", value, "glrlxdh");
            return (Criteria) this;
        }

        public Criteria andGlrlxdhLike(String value) {
            addCriterion("GLRLXDH like", value, "glrlxdh");
            return (Criteria) this;
        }

        public Criteria andGlrlxdhNotLike(String value) {
            addCriterion("GLRLXDH not like", value, "glrlxdh");
            return (Criteria) this;
        }

        public Criteria andGlrlxdhIn(List<String> values) {
            addCriterion("GLRLXDH in", values, "glrlxdh");
            return (Criteria) this;
        }

        public Criteria andGlrlxdhNotIn(List<String> values) {
            addCriterion("GLRLXDH not in", values, "glrlxdh");
            return (Criteria) this;
        }

        public Criteria andGlrlxdhBetween(String value1, String value2) {
            addCriterion("GLRLXDH between", value1, value2, "glrlxdh");
            return (Criteria) this;
        }

        public Criteria andGlrlxdhNotBetween(String value1, String value2) {
            addCriterion("GLRLXDH not between", value1, value2, "glrlxdh");
            return (Criteria) this;
        }

        public Criteria andXycpslIsNull() {
            addCriterion("XYCPSL is null");
            return (Criteria) this;
        }

        public Criteria andXycpslIsNotNull() {
            addCriterion("XYCPSL is not null");
            return (Criteria) this;
        }

        public Criteria andXycpslEqualTo(String value) {
            addCriterion("XYCPSL =", value, "xycpsl");
            return (Criteria) this;
        }

        public Criteria andXycpslNotEqualTo(String value) {
            addCriterion("XYCPSL <>", value, "xycpsl");
            return (Criteria) this;
        }

        public Criteria andXycpslGreaterThan(String value) {
            addCriterion("XYCPSL >", value, "xycpsl");
            return (Criteria) this;
        }

        public Criteria andXycpslGreaterThanOrEqualTo(String value) {
            addCriterion("XYCPSL >=", value, "xycpsl");
            return (Criteria) this;
        }

        public Criteria andXycpslLessThan(String value) {
            addCriterion("XYCPSL <", value, "xycpsl");
            return (Criteria) this;
        }

        public Criteria andXycpslLessThanOrEqualTo(String value) {
            addCriterion("XYCPSL <=", value, "xycpsl");
            return (Criteria) this;
        }

        public Criteria andXycpslLike(String value) {
            addCriterion("XYCPSL like", value, "xycpsl");
            return (Criteria) this;
        }

        public Criteria andXycpslNotLike(String value) {
            addCriterion("XYCPSL not like", value, "xycpsl");
            return (Criteria) this;
        }

        public Criteria andXycpslIn(List<String> values) {
            addCriterion("XYCPSL in", values, "xycpsl");
            return (Criteria) this;
        }

        public Criteria andXycpslNotIn(List<String> values) {
            addCriterion("XYCPSL not in", values, "xycpsl");
            return (Criteria) this;
        }

        public Criteria andXycpslBetween(String value1, String value2) {
            addCriterion("XYCPSL between", value1, value2, "xycpsl");
            return (Criteria) this;
        }

        public Criteria andXycpslNotBetween(String value1, String value2) {
            addCriterion("XYCPSL not between", value1, value2, "xycpsl");
            return (Criteria) this;
        }

        public Criteria andHzcpslIsNull() {
            addCriterion("HZCPSL is null");
            return (Criteria) this;
        }

        public Criteria andHzcpslIsNotNull() {
            addCriterion("HZCPSL is not null");
            return (Criteria) this;
        }

        public Criteria andHzcpslEqualTo(String value) {
            addCriterion("HZCPSL =", value, "hzcpsl");
            return (Criteria) this;
        }

        public Criteria andHzcpslNotEqualTo(String value) {
            addCriterion("HZCPSL <>", value, "hzcpsl");
            return (Criteria) this;
        }

        public Criteria andHzcpslGreaterThan(String value) {
            addCriterion("HZCPSL >", value, "hzcpsl");
            return (Criteria) this;
        }

        public Criteria andHzcpslGreaterThanOrEqualTo(String value) {
            addCriterion("HZCPSL >=", value, "hzcpsl");
            return (Criteria) this;
        }

        public Criteria andHzcpslLessThan(String value) {
            addCriterion("HZCPSL <", value, "hzcpsl");
            return (Criteria) this;
        }

        public Criteria andHzcpslLessThanOrEqualTo(String value) {
            addCriterion("HZCPSL <=", value, "hzcpsl");
            return (Criteria) this;
        }

        public Criteria andHzcpslLike(String value) {
            addCriterion("HZCPSL like", value, "hzcpsl");
            return (Criteria) this;
        }

        public Criteria andHzcpslNotLike(String value) {
            addCriterion("HZCPSL not like", value, "hzcpsl");
            return (Criteria) this;
        }

        public Criteria andHzcpslIn(List<String> values) {
            addCriterion("HZCPSL in", values, "hzcpsl");
            return (Criteria) this;
        }

        public Criteria andHzcpslNotIn(List<String> values) {
            addCriterion("HZCPSL not in", values, "hzcpsl");
            return (Criteria) this;
        }

        public Criteria andHzcpslBetween(String value1, String value2) {
            addCriterion("HZCPSL between", value1, value2, "hzcpsl");
            return (Criteria) this;
        }

        public Criteria andHzcpslNotBetween(String value1, String value2) {
            addCriterion("HZCPSL not between", value1, value2, "hzcpsl");
            return (Criteria) this;
        }

        public Criteria andBzIsNull() {
            addCriterion("BZ is null");
            return (Criteria) this;
        }

        public Criteria andBzIsNotNull() {
            addCriterion("BZ is not null");
            return (Criteria) this;
        }

        public Criteria andBzEqualTo(String value) {
            addCriterion("BZ =", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzNotEqualTo(String value) {
            addCriterion("BZ <>", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzGreaterThan(String value) {
            addCriterion("BZ >", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzGreaterThanOrEqualTo(String value) {
            addCriterion("BZ >=", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzLessThan(String value) {
            addCriterion("BZ <", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzLessThanOrEqualTo(String value) {
            addCriterion("BZ <=", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzLike(String value) {
            addCriterion("BZ like", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzNotLike(String value) {
            addCriterion("BZ not like", value, "bz");
            return (Criteria) this;
        }

        public Criteria andBzIn(List<String> values) {
            addCriterion("BZ in", values, "bz");
            return (Criteria) this;
        }

        public Criteria andBzNotIn(List<String> values) {
            addCriterion("BZ not in", values, "bz");
            return (Criteria) this;
        }

        public Criteria andBzBetween(String value1, String value2) {
            addCriterion("BZ between", value1, value2, "bz");
            return (Criteria) this;
        }

        public Criteria andBzNotBetween(String value1, String value2) {
            addCriterion("BZ not between", value1, value2, "bz");
            return (Criteria) this;
        }

        public Criteria andGxryIsNull() {
            addCriterion("GXRY is null");
            return (Criteria) this;
        }

        public Criteria andGxryIsNotNull() {
            addCriterion("GXRY is not null");
            return (Criteria) this;
        }

        public Criteria andGxryEqualTo(String value) {
            addCriterion("GXRY =", value, "gxry");
            return (Criteria) this;
        }

        public Criteria andGxryNotEqualTo(String value) {
            addCriterion("GXRY <>", value, "gxry");
            return (Criteria) this;
        }

        public Criteria andGxryGreaterThan(String value) {
            addCriterion("GXRY >", value, "gxry");
            return (Criteria) this;
        }

        public Criteria andGxryGreaterThanOrEqualTo(String value) {
            addCriterion("GXRY >=", value, "gxry");
            return (Criteria) this;
        }

        public Criteria andGxryLessThan(String value) {
            addCriterion("GXRY <", value, "gxry");
            return (Criteria) this;
        }

        public Criteria andGxryLessThanOrEqualTo(String value) {
            addCriterion("GXRY <=", value, "gxry");
            return (Criteria) this;
        }

        public Criteria andGxryLike(String value) {
            addCriterion("GXRY like", value, "gxry");
            return (Criteria) this;
        }

        public Criteria andGxryNotLike(String value) {
            addCriterion("GXRY not like", value, "gxry");
            return (Criteria) this;
        }

        public Criteria andGxryIn(List<String> values) {
            addCriterion("GXRY in", values, "gxry");
            return (Criteria) this;
        }

        public Criteria andGxryNotIn(List<String> values) {
            addCriterion("GXRY not in", values, "gxry");
            return (Criteria) this;
        }

        public Criteria andGxryBetween(String value1, String value2) {
            addCriterion("GXRY between", value1, value2, "gxry");
            return (Criteria) this;
        }

        public Criteria andGxryNotBetween(String value1, String value2) {
            addCriterion("GXRY not between", value1, value2, "gxry");
            return (Criteria) this;
        }

        public Criteria andGxrqIsNull() {
            addCriterion("GXRQ is null");
            return (Criteria) this;
        }

        public Criteria andGxrqIsNotNull() {
            addCriterion("GXRQ is not null");
            return (Criteria) this;
        }

        public Criteria andGxrqEqualTo(String value) {
            addCriterion("GXRQ =", value, "gxrq");
            return (Criteria) this;
        }

        public Criteria andGxrqNotEqualTo(String value) {
            addCriterion("GXRQ <>", value, "gxrq");
            return (Criteria) this;
        }

        public Criteria andGxrqGreaterThan(String value) {
            addCriterion("GXRQ >", value, "gxrq");
            return (Criteria) this;
        }

        public Criteria andGxrqGreaterThanOrEqualTo(String value) {
            addCriterion("GXRQ >=", value, "gxrq");
            return (Criteria) this;
        }

        public Criteria andGxrqLessThan(String value) {
            addCriterion("GXRQ <", value, "gxrq");
            return (Criteria) this;
        }

        public Criteria andGxrqLessThanOrEqualTo(String value) {
            addCriterion("GXRQ <=", value, "gxrq");
            return (Criteria) this;
        }

        public Criteria andGxrqLike(String value) {
            addCriterion("GXRQ like", value, "gxrq");
            return (Criteria) this;
        }

        public Criteria andGxrqNotLike(String value) {
            addCriterion("GXRQ not like", value, "gxrq");
            return (Criteria) this;
        }

        public Criteria andGxrqIn(List<String> values) {
            addCriterion("GXRQ in", values, "gxrq");
            return (Criteria) this;
        }

        public Criteria andGxrqNotIn(List<String> values) {
            addCriterion("GXRQ not in", values, "gxrq");
            return (Criteria) this;
        }

        public Criteria andGxrqBetween(String value1, String value2) {
            addCriterion("GXRQ between", value1, value2, "gxrq");
            return (Criteria) this;
        }

        public Criteria andGxrqNotBetween(String value1, String value2) {
            addCriterion("GXRQ not between", value1, value2, "gxrq");
            return (Criteria) this;
        }

        public Criteria andGxsjIsNull() {
            addCriterion("GXSJ is null");
            return (Criteria) this;
        }

        public Criteria andGxsjIsNotNull() {
            addCriterion("GXSJ is not null");
            return (Criteria) this;
        }

        public Criteria andGxsjEqualTo(String value) {
            addCriterion("GXSJ =", value, "gxsj");
            return (Criteria) this;
        }

        public Criteria andGxsjNotEqualTo(String value) {
            addCriterion("GXSJ <>", value, "gxsj");
            return (Criteria) this;
        }

        public Criteria andGxsjGreaterThan(String value) {
            addCriterion("GXSJ >", value, "gxsj");
            return (Criteria) this;
        }

        public Criteria andGxsjGreaterThanOrEqualTo(String value) {
            addCriterion("GXSJ >=", value, "gxsj");
            return (Criteria) this;
        }

        public Criteria andGxsjLessThan(String value) {
            addCriterion("GXSJ <", value, "gxsj");
            return (Criteria) this;
        }

        public Criteria andGxsjLessThanOrEqualTo(String value) {
            addCriterion("GXSJ <=", value, "gxsj");
            return (Criteria) this;
        }

        public Criteria andGxsjLike(String value) {
            addCriterion("GXSJ like", value, "gxsj");
            return (Criteria) this;
        }

        public Criteria andGxsjNotLike(String value) {
            addCriterion("GXSJ not like", value, "gxsj");
            return (Criteria) this;
        }

        public Criteria andGxsjIn(List<String> values) {
            addCriterion("GXSJ in", values, "gxsj");
            return (Criteria) this;
        }

        public Criteria andGxsjNotIn(List<String> values) {
            addCriterion("GXSJ not in", values, "gxsj");
            return (Criteria) this;
        }

        public Criteria andGxsjBetween(String value1, String value2) {
            addCriterion("GXSJ between", value1, value2, "gxsj");
            return (Criteria) this;
        }

        public Criteria andGxsjNotBetween(String value1, String value2) {
            addCriterion("GXSJ not between", value1, value2, "gxsj");
            return (Criteria) this;
        }

        public Criteria andKhjlIsNull() {
            addCriterion("KHJL is null");
            return (Criteria) this;
        }

        public Criteria andKhjlIsNotNull() {
            addCriterion("KHJL is not null");
            return (Criteria) this;
        }

        public Criteria andKhjlEqualTo(String value) {
            addCriterion("KHJL =", value, "khjl");
            return (Criteria) this;
        }

        public Criteria andKhjlNotEqualTo(String value) {
            addCriterion("KHJL <>", value, "khjl");
            return (Criteria) this;
        }

        public Criteria andKhjlGreaterThan(String value) {
            addCriterion("KHJL >", value, "khjl");
            return (Criteria) this;
        }

        public Criteria andKhjlGreaterThanOrEqualTo(String value) {
            addCriterion("KHJL >=", value, "khjl");
            return (Criteria) this;
        }

        public Criteria andKhjlLessThan(String value) {
            addCriterion("KHJL <", value, "khjl");
            return (Criteria) this;
        }

        public Criteria andKhjlLessThanOrEqualTo(String value) {
            addCriterion("KHJL <=", value, "khjl");
            return (Criteria) this;
        }

        public Criteria andKhjlLike(String value) {
            addCriterion("KHJL like", value, "khjl");
            return (Criteria) this;
        }

        public Criteria andKhjlNotLike(String value) {
            addCriterion("KHJL not like", value, "khjl");
            return (Criteria) this;
        }

        public Criteria andKhjlIn(List<String> values) {
            addCriterion("KHJL in", values, "khjl");
            return (Criteria) this;
        }

        public Criteria andKhjlNotIn(List<String> values) {
            addCriterion("KHJL not in", values, "khjl");
            return (Criteria) this;
        }

        public Criteria andKhjlBetween(String value1, String value2) {
            addCriterion("KHJL between", value1, value2, "khjl");
            return (Criteria) this;
        }

        public Criteria andKhjlNotBetween(String value1, String value2) {
            addCriterion("KHJL not between", value1, value2, "khjl");
            return (Criteria) this;
        }

        public Criteria andKhjl1IsNull() {
            addCriterion("KHJL1 is null");
            return (Criteria) this;
        }

        public Criteria andKhjl1IsNotNull() {
            addCriterion("KHJL1 is not null");
            return (Criteria) this;
        }

        public Criteria andKhjl1EqualTo(String value) {
            addCriterion("KHJL1 =", value, "khjl1");
            return (Criteria) this;
        }

        public Criteria andKhjl1NotEqualTo(String value) {
            addCriterion("KHJL1 <>", value, "khjl1");
            return (Criteria) this;
        }

        public Criteria andKhjl1GreaterThan(String value) {
            addCriterion("KHJL1 >", value, "khjl1");
            return (Criteria) this;
        }

        public Criteria andKhjl1GreaterThanOrEqualTo(String value) {
            addCriterion("KHJL1 >=", value, "khjl1");
            return (Criteria) this;
        }

        public Criteria andKhjl1LessThan(String value) {
            addCriterion("KHJL1 <", value, "khjl1");
            return (Criteria) this;
        }

        public Criteria andKhjl1LessThanOrEqualTo(String value) {
            addCriterion("KHJL1 <=", value, "khjl1");
            return (Criteria) this;
        }

        public Criteria andKhjl1Like(String value) {
            addCriterion("KHJL1 like", value, "khjl1");
            return (Criteria) this;
        }

        public Criteria andKhjl1NotLike(String value) {
            addCriterion("KHJL1 not like", value, "khjl1");
            return (Criteria) this;
        }

        public Criteria andKhjl1In(List<String> values) {
            addCriterion("KHJL1 in", values, "khjl1");
            return (Criteria) this;
        }

        public Criteria andKhjl1NotIn(List<String> values) {
            addCriterion("KHJL1 not in", values, "khjl1");
            return (Criteria) this;
        }

        public Criteria andKhjl1Between(String value1, String value2) {
            addCriterion("KHJL1 between", value1, value2, "khjl1");
            return (Criteria) this;
        }

        public Criteria andKhjl1NotBetween(String value1, String value2) {
            addCriterion("KHJL1 not between", value1, value2, "khjl1");
            return (Criteria) this;
        }

        public Criteria andXhjsIsNull() {
            addCriterion("XHJS is null");
            return (Criteria) this;
        }

        public Criteria andXhjsIsNotNull() {
            addCriterion("XHJS is not null");
            return (Criteria) this;
        }

        public Criteria andXhjsEqualTo(String value) {
            addCriterion("XHJS =", value, "xhjs");
            return (Criteria) this;
        }

        public Criteria andXhjsNotEqualTo(String value) {
            addCriterion("XHJS <>", value, "xhjs");
            return (Criteria) this;
        }

        public Criteria andXhjsGreaterThan(String value) {
            addCriterion("XHJS >", value, "xhjs");
            return (Criteria) this;
        }

        public Criteria andXhjsGreaterThanOrEqualTo(String value) {
            addCriterion("XHJS >=", value, "xhjs");
            return (Criteria) this;
        }

        public Criteria andXhjsLessThan(String value) {
            addCriterion("XHJS <", value, "xhjs");
            return (Criteria) this;
        }

        public Criteria andXhjsLessThanOrEqualTo(String value) {
            addCriterion("XHJS <=", value, "xhjs");
            return (Criteria) this;
        }

        public Criteria andXhjsLike(String value) {
            addCriterion("XHJS like", value, "xhjs");
            return (Criteria) this;
        }

        public Criteria andXhjsNotLike(String value) {
            addCriterion("XHJS not like", value, "xhjs");
            return (Criteria) this;
        }

        public Criteria andXhjsIn(List<String> values) {
            addCriterion("XHJS in", values, "xhjs");
            return (Criteria) this;
        }

        public Criteria andXhjsNotIn(List<String> values) {
            addCriterion("XHJS not in", values, "xhjs");
            return (Criteria) this;
        }

        public Criteria andXhjsBetween(String value1, String value2) {
            addCriterion("XHJS between", value1, value2, "xhjs");
            return (Criteria) this;
        }

        public Criteria andXhjsNotBetween(String value1, String value2) {
            addCriterion("XHJS not between", value1, value2, "xhjs");
            return (Criteria) this;
        }

        public Criteria andGlrzcdzIsNull() {
            addCriterion("GLRZCDZ is null");
            return (Criteria) this;
        }

        public Criteria andGlrzcdzIsNotNull() {
            addCriterion("GLRZCDZ is not null");
            return (Criteria) this;
        }

        public Criteria andGlrzcdzEqualTo(String value) {
            addCriterion("GLRZCDZ =", value, "glrzcdz");
            return (Criteria) this;
        }

        public Criteria andGlrzcdzNotEqualTo(String value) {
            addCriterion("GLRZCDZ <>", value, "glrzcdz");
            return (Criteria) this;
        }

        public Criteria andGlrzcdzGreaterThan(String value) {
            addCriterion("GLRZCDZ >", value, "glrzcdz");
            return (Criteria) this;
        }

        public Criteria andGlrzcdzGreaterThanOrEqualTo(String value) {
            addCriterion("GLRZCDZ >=", value, "glrzcdz");
            return (Criteria) this;
        }

        public Criteria andGlrzcdzLessThan(String value) {
            addCriterion("GLRZCDZ <", value, "glrzcdz");
            return (Criteria) this;
        }

        public Criteria andGlrzcdzLessThanOrEqualTo(String value) {
            addCriterion("GLRZCDZ <=", value, "glrzcdz");
            return (Criteria) this;
        }

        public Criteria andGlrzcdzLike(String value) {
            addCriterion("GLRZCDZ like", value, "glrzcdz");
            return (Criteria) this;
        }

        public Criteria andGlrzcdzNotLike(String value) {
            addCriterion("GLRZCDZ not like", value, "glrzcdz");
            return (Criteria) this;
        }

        public Criteria andGlrzcdzIn(List<String> values) {
            addCriterion("GLRZCDZ in", values, "glrzcdz");
            return (Criteria) this;
        }

        public Criteria andGlrzcdzNotIn(List<String> values) {
            addCriterion("GLRZCDZ not in", values, "glrzcdz");
            return (Criteria) this;
        }

        public Criteria andGlrzcdzBetween(String value1, String value2) {
            addCriterion("GLRZCDZ between", value1, value2, "glrzcdz");
            return (Criteria) this;
        }

        public Criteria andGlrzcdzNotBetween(String value1, String value2) {
            addCriterion("GLRZCDZ not between", value1, value2, "glrzcdz");
            return (Criteria) this;
        }

        public Criteria andFwptztIsNull() {
            addCriterion("FWPTZT is null");
            return (Criteria) this;
        }

        public Criteria andFwptztIsNotNull() {
            addCriterion("FWPTZT is not null");
            return (Criteria) this;
        }

        public Criteria andFwptztEqualTo(String value) {
            addCriterion("FWPTZT =", value, "fwptzt");
            return (Criteria) this;
        }

        public Criteria andFwptztNotEqualTo(String value) {
            addCriterion("FWPTZT <>", value, "fwptzt");
            return (Criteria) this;
        }

        public Criteria andFwptztGreaterThan(String value) {
            addCriterion("FWPTZT >", value, "fwptzt");
            return (Criteria) this;
        }

        public Criteria andFwptztGreaterThanOrEqualTo(String value) {
            addCriterion("FWPTZT >=", value, "fwptzt");
            return (Criteria) this;
        }

        public Criteria andFwptztLessThan(String value) {
            addCriterion("FWPTZT <", value, "fwptzt");
            return (Criteria) this;
        }

        public Criteria andFwptztLessThanOrEqualTo(String value) {
            addCriterion("FWPTZT <=", value, "fwptzt");
            return (Criteria) this;
        }

        public Criteria andFwptztLike(String value) {
            addCriterion("FWPTZT like", value, "fwptzt");
            return (Criteria) this;
        }

        public Criteria andFwptztNotLike(String value) {
            addCriterion("FWPTZT not like", value, "fwptzt");
            return (Criteria) this;
        }

        public Criteria andFwptztIn(List<String> values) {
            addCriterion("FWPTZT in", values, "fwptzt");
            return (Criteria) this;
        }

        public Criteria andFwptztNotIn(List<String> values) {
            addCriterion("FWPTZT not in", values, "fwptzt");
            return (Criteria) this;
        }

        public Criteria andFwptztBetween(String value1, String value2) {
            addCriterion("FWPTZT between", value1, value2, "fwptzt");
            return (Criteria) this;
        }

        public Criteria andFwptztNotBetween(String value1, String value2) {
            addCriterion("FWPTZT not between", value1, value2, "fwptzt");
            return (Criteria) this;
        }

        public Criteria andSfbmdIsNull() {
            addCriterion("SFBMD is null");
            return (Criteria) this;
        }

        public Criteria andSfbmdIsNotNull() {
            addCriterion("SFBMD is not null");
            return (Criteria) this;
        }

        public Criteria andSfbmdEqualTo(String value) {
            addCriterion("SFBMD =", value, "sfbmd");
            return (Criteria) this;
        }

        public Criteria andSfbmdNotEqualTo(String value) {
            addCriterion("SFBMD <>", value, "sfbmd");
            return (Criteria) this;
        }

        public Criteria andSfbmdGreaterThan(String value) {
            addCriterion("SFBMD >", value, "sfbmd");
            return (Criteria) this;
        }

        public Criteria andSfbmdGreaterThanOrEqualTo(String value) {
            addCriterion("SFBMD >=", value, "sfbmd");
            return (Criteria) this;
        }

        public Criteria andSfbmdLessThan(String value) {
            addCriterion("SFBMD <", value, "sfbmd");
            return (Criteria) this;
        }

        public Criteria andSfbmdLessThanOrEqualTo(String value) {
            addCriterion("SFBMD <=", value, "sfbmd");
            return (Criteria) this;
        }

        public Criteria andSfbmdLike(String value) {
            addCriterion("SFBMD like", value, "sfbmd");
            return (Criteria) this;
        }

        public Criteria andSfbmdNotLike(String value) {
            addCriterion("SFBMD not like", value, "sfbmd");
            return (Criteria) this;
        }

        public Criteria andSfbmdIn(List<String> values) {
            addCriterion("SFBMD in", values, "sfbmd");
            return (Criteria) this;
        }

        public Criteria andSfbmdNotIn(List<String> values) {
            addCriterion("SFBMD not in", values, "sfbmd");
            return (Criteria) this;
        }

        public Criteria andSfbmdBetween(String value1, String value2) {
            addCriterion("SFBMD between", value1, value2, "sfbmd");
            return (Criteria) this;
        }

        public Criteria andSfbmdNotBetween(String value1, String value2) {
            addCriterion("SFBMD not between", value1, value2, "sfbmd");
            return (Criteria) this;
        }

        public Criteria andYxjlIsNull() {
            addCriterion("YXJL is null");
            return (Criteria) this;
        }

        public Criteria andYxjlIsNotNull() {
            addCriterion("YXJL is not null");
            return (Criteria) this;
        }

        public Criteria andYxjlEqualTo(String value) {
            addCriterion("YXJL =", value, "yxjl");
            return (Criteria) this;
        }

        public Criteria andYxjlNotEqualTo(String value) {
            addCriterion("YXJL <>", value, "yxjl");
            return (Criteria) this;
        }

        public Criteria andYxjlGreaterThan(String value) {
            addCriterion("YXJL >", value, "yxjl");
            return (Criteria) this;
        }

        public Criteria andYxjlGreaterThanOrEqualTo(String value) {
            addCriterion("YXJL >=", value, "yxjl");
            return (Criteria) this;
        }

        public Criteria andYxjlLessThan(String value) {
            addCriterion("YXJL <", value, "yxjl");
            return (Criteria) this;
        }

        public Criteria andYxjlLessThanOrEqualTo(String value) {
            addCriterion("YXJL <=", value, "yxjl");
            return (Criteria) this;
        }

        public Criteria andYxjlLike(String value) {
            addCriterion("YXJL like", value, "yxjl");
            return (Criteria) this;
        }

        public Criteria andYxjlNotLike(String value) {
            addCriterion("YXJL not like", value, "yxjl");
            return (Criteria) this;
        }

        public Criteria andYxjlIn(List<String> values) {
            addCriterion("YXJL in", values, "yxjl");
            return (Criteria) this;
        }

        public Criteria andYxjlNotIn(List<String> values) {
            addCriterion("YXJL not in", values, "yxjl");
            return (Criteria) this;
        }

        public Criteria andYxjlBetween(String value1, String value2) {
            addCriterion("YXJL between", value1, value2, "yxjl");
            return (Criteria) this;
        }

        public Criteria andYxjlNotBetween(String value1, String value2) {
            addCriterion("YXJL not between", value1, value2, "yxjl");
            return (Criteria) this;
        }

        public Criteria andSfhmdIsNull() {
            addCriterion("SFHMD is null");
            return (Criteria) this;
        }

        public Criteria andSfhmdIsNotNull() {
            addCriterion("SFHMD is not null");
            return (Criteria) this;
        }

        public Criteria andSfhmdEqualTo(String value) {
            addCriterion("SFHMD =", value, "sfhmd");
            return (Criteria) this;
        }

        public Criteria andSfhmdNotEqualTo(String value) {
            addCriterion("SFHMD <>", value, "sfhmd");
            return (Criteria) this;
        }

        public Criteria andSfhmdGreaterThan(String value) {
            addCriterion("SFHMD >", value, "sfhmd");
            return (Criteria) this;
        }

        public Criteria andSfhmdGreaterThanOrEqualTo(String value) {
            addCriterion("SFHMD >=", value, "sfhmd");
            return (Criteria) this;
        }

        public Criteria andSfhmdLessThan(String value) {
            addCriterion("SFHMD <", value, "sfhmd");
            return (Criteria) this;
        }

        public Criteria andSfhmdLessThanOrEqualTo(String value) {
            addCriterion("SFHMD <=", value, "sfhmd");
            return (Criteria) this;
        }

        public Criteria andSfhmdLike(String value) {
            addCriterion("SFHMD like", value, "sfhmd");
            return (Criteria) this;
        }

        public Criteria andSfhmdNotLike(String value) {
            addCriterion("SFHMD not like", value, "sfhmd");
            return (Criteria) this;
        }

        public Criteria andSfhmdIn(List<String> values) {
            addCriterion("SFHMD in", values, "sfhmd");
            return (Criteria) this;
        }

        public Criteria andSfhmdNotIn(List<String> values) {
            addCriterion("SFHMD not in", values, "sfhmd");
            return (Criteria) this;
        }

        public Criteria andSfhmdBetween(String value1, String value2) {
            addCriterion("SFHMD between", value1, value2, "sfhmd");
            return (Criteria) this;
        }

        public Criteria andSfhmdNotBetween(String value1, String value2) {
            addCriterion("SFHMD not between", value1, value2, "sfhmd");
            return (Criteria) this;
        }

        public Criteria andSfxgIsNull() {
            addCriterion("SFXG is null");
            return (Criteria) this;
        }

        public Criteria andSfxgIsNotNull() {
            addCriterion("SFXG is not null");
            return (Criteria) this;
        }

        public Criteria andSfxgEqualTo(String value) {
            addCriterion("SFXG =", value, "sfxg");
            return (Criteria) this;
        }

        public Criteria andSfxgNotEqualTo(String value) {
            addCriterion("SFXG <>", value, "sfxg");
            return (Criteria) this;
        }

        public Criteria andSfxgGreaterThan(String value) {
            addCriterion("SFXG >", value, "sfxg");
            return (Criteria) this;
        }

        public Criteria andSfxgGreaterThanOrEqualTo(String value) {
            addCriterion("SFXG >=", value, "sfxg");
            return (Criteria) this;
        }

        public Criteria andSfxgLessThan(String value) {
            addCriterion("SFXG <", value, "sfxg");
            return (Criteria) this;
        }

        public Criteria andSfxgLessThanOrEqualTo(String value) {
            addCriterion("SFXG <=", value, "sfxg");
            return (Criteria) this;
        }

        public Criteria andSfxgLike(String value) {
            addCriterion("SFXG like", value, "sfxg");
            return (Criteria) this;
        }

        public Criteria andSfxgNotLike(String value) {
            addCriterion("SFXG not like", value, "sfxg");
            return (Criteria) this;
        }

        public Criteria andSfxgIn(List<String> values) {
            addCriterion("SFXG in", values, "sfxg");
            return (Criteria) this;
        }

        public Criteria andSfxgNotIn(List<String> values) {
            addCriterion("SFXG not in", values, "sfxg");
            return (Criteria) this;
        }

        public Criteria andSfxgBetween(String value1, String value2) {
            addCriterion("SFXG between", value1, value2, "sfxg");
            return (Criteria) this;
        }

        public Criteria andSfxgNotBetween(String value1, String value2) {
            addCriterion("SFXG not between", value1, value2, "sfxg");
            return (Criteria) this;
        }

        public Criteria andYclxIsNull() {
            addCriterion("YCLX is null");
            return (Criteria) this;
        }

        public Criteria andYclxIsNotNull() {
            addCriterion("YCLX is not null");
            return (Criteria) this;
        }

        public Criteria andYclxEqualTo(String value) {
            addCriterion("YCLX =", value, "yclx");
            return (Criteria) this;
        }

        public Criteria andYclxNotEqualTo(String value) {
            addCriterion("YCLX <>", value, "yclx");
            return (Criteria) this;
        }

        public Criteria andYclxGreaterThan(String value) {
            addCriterion("YCLX >", value, "yclx");
            return (Criteria) this;
        }

        public Criteria andYclxGreaterThanOrEqualTo(String value) {
            addCriterion("YCLX >=", value, "yclx");
            return (Criteria) this;
        }

        public Criteria andYclxLessThan(String value) {
            addCriterion("YCLX <", value, "yclx");
            return (Criteria) this;
        }

        public Criteria andYclxLessThanOrEqualTo(String value) {
            addCriterion("YCLX <=", value, "yclx");
            return (Criteria) this;
        }

        public Criteria andYclxLike(String value) {
            addCriterion("YCLX like", value, "yclx");
            return (Criteria) this;
        }

        public Criteria andYclxNotLike(String value) {
            addCriterion("YCLX not like", value, "yclx");
            return (Criteria) this;
        }

        public Criteria andYclxIn(List<String> values) {
            addCriterion("YCLX in", values, "yclx");
            return (Criteria) this;
        }

        public Criteria andYclxNotIn(List<String> values) {
            addCriterion("YCLX not in", values, "yclx");
            return (Criteria) this;
        }

        public Criteria andYclxBetween(String value1, String value2) {
            addCriterion("YCLX between", value1, value2, "yclx");
            return (Criteria) this;
        }

        public Criteria andYclxNotBetween(String value1, String value2) {
            addCriterion("YCLX not between", value1, value2, "yclx");
            return (Criteria) this;
        }

        public Criteria andYcbzIsNull() {
            addCriterion("YCBZ is null");
            return (Criteria) this;
        }

        public Criteria andYcbzIsNotNull() {
            addCriterion("YCBZ is not null");
            return (Criteria) this;
        }

        public Criteria andYcbzEqualTo(String value) {
            addCriterion("YCBZ =", value, "ycbz");
            return (Criteria) this;
        }

        public Criteria andYcbzNotEqualTo(String value) {
            addCriterion("YCBZ <>", value, "ycbz");
            return (Criteria) this;
        }

        public Criteria andYcbzGreaterThan(String value) {
            addCriterion("YCBZ >", value, "ycbz");
            return (Criteria) this;
        }

        public Criteria andYcbzGreaterThanOrEqualTo(String value) {
            addCriterion("YCBZ >=", value, "ycbz");
            return (Criteria) this;
        }

        public Criteria andYcbzLessThan(String value) {
            addCriterion("YCBZ <", value, "ycbz");
            return (Criteria) this;
        }

        public Criteria andYcbzLessThanOrEqualTo(String value) {
            addCriterion("YCBZ <=", value, "ycbz");
            return (Criteria) this;
        }

        public Criteria andYcbzLike(String value) {
            addCriterion("YCBZ like", value, "ycbz");
            return (Criteria) this;
        }

        public Criteria andYcbzNotLike(String value) {
            addCriterion("YCBZ not like", value, "ycbz");
            return (Criteria) this;
        }

        public Criteria andYcbzIn(List<String> values) {
            addCriterion("YCBZ in", values, "ycbz");
            return (Criteria) this;
        }

        public Criteria andYcbzNotIn(List<String> values) {
            addCriterion("YCBZ not in", values, "ycbz");
            return (Criteria) this;
        }

        public Criteria andYcbzBetween(String value1, String value2) {
            addCriterion("YCBZ between", value1, value2, "ycbz");
            return (Criteria) this;
        }

        public Criteria andYcbzNotBetween(String value1, String value2) {
            addCriterion("YCBZ not between", value1, value2, "ycbz");
            return (Criteria) this;
        }

        public Criteria andYwlxIsNull() {
            addCriterion("YWLX is null");
            return (Criteria) this;
        }

        public Criteria andYwlxIsNotNull() {
            addCriterion("YWLX is not null");
            return (Criteria) this;
        }

        public Criteria andYwlxEqualTo(String value) {
            addCriterion("YWLX =", value, "ywlx");
            return (Criteria) this;
        }

        public Criteria andYwlxNotEqualTo(String value) {
            addCriterion("YWLX <>", value, "ywlx");
            return (Criteria) this;
        }

        public Criteria andYwlxGreaterThan(String value) {
            addCriterion("YWLX >", value, "ywlx");
            return (Criteria) this;
        }

        public Criteria andYwlxGreaterThanOrEqualTo(String value) {
            addCriterion("YWLX >=", value, "ywlx");
            return (Criteria) this;
        }

        public Criteria andYwlxLessThan(String value) {
            addCriterion("YWLX <", value, "ywlx");
            return (Criteria) this;
        }

        public Criteria andYwlxLessThanOrEqualTo(String value) {
            addCriterion("YWLX <=", value, "ywlx");
            return (Criteria) this;
        }

        public Criteria andYwlxLike(String value) {
            addCriterion("YWLX like", value, "ywlx");
            return (Criteria) this;
        }

        public Criteria andYwlxNotLike(String value) {
            addCriterion("YWLX not like", value, "ywlx");
            return (Criteria) this;
        }

        public Criteria andYwlxIn(List<String> values) {
            addCriterion("YWLX in", values, "ywlx");
            return (Criteria) this;
        }

        public Criteria andYwlxNotIn(List<String> values) {
            addCriterion("YWLX not in", values, "ywlx");
            return (Criteria) this;
        }

        public Criteria andYwlxBetween(String value1, String value2) {
            addCriterion("YWLX between", value1, value2, "ywlx");
            return (Criteria) this;
        }

        public Criteria andYwlxNotBetween(String value1, String value2) {
            addCriterion("YWLX not between", value1, value2, "ywlx");
            return (Criteria) this;
        }

        public Criteria andZzlxIsNull() {
            addCriterion("ZZLX is null");
            return (Criteria) this;
        }

        public Criteria andZzlxIsNotNull() {
            addCriterion("ZZLX is not null");
            return (Criteria) this;
        }

        public Criteria andZzlxEqualTo(String value) {
            addCriterion("ZZLX =", value, "zzlx");
            return (Criteria) this;
        }

        public Criteria andZzlxNotEqualTo(String value) {
            addCriterion("ZZLX <>", value, "zzlx");
            return (Criteria) this;
        }

        public Criteria andZzlxGreaterThan(String value) {
            addCriterion("ZZLX >", value, "zzlx");
            return (Criteria) this;
        }

        public Criteria andZzlxGreaterThanOrEqualTo(String value) {
            addCriterion("ZZLX >=", value, "zzlx");
            return (Criteria) this;
        }

        public Criteria andZzlxLessThan(String value) {
            addCriterion("ZZLX <", value, "zzlx");
            return (Criteria) this;
        }

        public Criteria andZzlxLessThanOrEqualTo(String value) {
            addCriterion("ZZLX <=", value, "zzlx");
            return (Criteria) this;
        }

        public Criteria andZzlxLike(String value) {
            addCriterion("ZZLX like", value, "zzlx");
            return (Criteria) this;
        }

        public Criteria andZzlxNotLike(String value) {
            addCriterion("ZZLX not like", value, "zzlx");
            return (Criteria) this;
        }

        public Criteria andZzlxIn(List<String> values) {
            addCriterion("ZZLX in", values, "zzlx");
            return (Criteria) this;
        }

        public Criteria andZzlxNotIn(List<String> values) {
            addCriterion("ZZLX not in", values, "zzlx");
            return (Criteria) this;
        }

        public Criteria andZzlxBetween(String value1, String value2) {
            addCriterion("ZZLX between", value1, value2, "zzlx");
            return (Criteria) this;
        }

        public Criteria andZzlxNotBetween(String value1, String value2) {
            addCriterion("ZZLX not between", value1, value2, "zzlx");
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