package com.yjzs.gold.main.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TOperationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TOperationExample() {
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

        public Criteria andOpeIdIsNull() {
            addCriterion("ope_id is null");
            return (Criteria) this;
        }

        public Criteria andOpeIdIsNotNull() {
            addCriterion("ope_id is not null");
            return (Criteria) this;
        }

        public Criteria andOpeIdEqualTo(Integer value) {
            addCriterion("ope_id =", value, "opeId");
            return (Criteria) this;
        }

        public Criteria andOpeIdNotEqualTo(Integer value) {
            addCriterion("ope_id <>", value, "opeId");
            return (Criteria) this;
        }

        public Criteria andOpeIdGreaterThan(Integer value) {
            addCriterion("ope_id >", value, "opeId");
            return (Criteria) this;
        }

        public Criteria andOpeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ope_id >=", value, "opeId");
            return (Criteria) this;
        }

        public Criteria andOpeIdLessThan(Integer value) {
            addCriterion("ope_id <", value, "opeId");
            return (Criteria) this;
        }

        public Criteria andOpeIdLessThanOrEqualTo(Integer value) {
            addCriterion("ope_id <=", value, "opeId");
            return (Criteria) this;
        }

        public Criteria andOpeIdIn(List<Integer> values) {
            addCriterion("ope_id in", values, "opeId");
            return (Criteria) this;
        }

        public Criteria andOpeIdNotIn(List<Integer> values) {
            addCriterion("ope_id not in", values, "opeId");
            return (Criteria) this;
        }

        public Criteria andOpeIdBetween(Integer value1, Integer value2) {
            addCriterion("ope_id between", value1, value2, "opeId");
            return (Criteria) this;
        }

        public Criteria andOpeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ope_id not between", value1, value2, "opeId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andFundIdIsNull() {
            addCriterion("fund_id is null");
            return (Criteria) this;
        }

        public Criteria andFundIdIsNotNull() {
            addCriterion("fund_id is not null");
            return (Criteria) this;
        }

        public Criteria andFundIdEqualTo(Integer value) {
            addCriterion("fund_id =", value, "fundId");
            return (Criteria) this;
        }

        public Criteria andFundIdNotEqualTo(Integer value) {
            addCriterion("fund_id <>", value, "fundId");
            return (Criteria) this;
        }

        public Criteria andFundIdGreaterThan(Integer value) {
            addCriterion("fund_id >", value, "fundId");
            return (Criteria) this;
        }

        public Criteria andFundIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("fund_id >=", value, "fundId");
            return (Criteria) this;
        }

        public Criteria andFundIdLessThan(Integer value) {
            addCriterion("fund_id <", value, "fundId");
            return (Criteria) this;
        }

        public Criteria andFundIdLessThanOrEqualTo(Integer value) {
            addCriterion("fund_id <=", value, "fundId");
            return (Criteria) this;
        }

        public Criteria andFundIdIn(List<Integer> values) {
            addCriterion("fund_id in", values, "fundId");
            return (Criteria) this;
        }

        public Criteria andFundIdNotIn(List<Integer> values) {
            addCriterion("fund_id not in", values, "fundId");
            return (Criteria) this;
        }

        public Criteria andFundIdBetween(Integer value1, Integer value2) {
            addCriterion("fund_id between", value1, value2, "fundId");
            return (Criteria) this;
        }

        public Criteria andFundIdNotBetween(Integer value1, Integer value2) {
            addCriterion("fund_id not between", value1, value2, "fundId");
            return (Criteria) this;
        }

        public Criteria andOpeMoneyIsNull() {
            addCriterion("ope_money is null");
            return (Criteria) this;
        }

        public Criteria andOpeMoneyIsNotNull() {
            addCriterion("ope_money is not null");
            return (Criteria) this;
        }

        public Criteria andOpeMoneyEqualTo(BigDecimal value) {
            addCriterion("ope_money =", value, "opeMoney");
            return (Criteria) this;
        }

        public Criteria andOpeMoneyNotEqualTo(BigDecimal value) {
            addCriterion("ope_money <>", value, "opeMoney");
            return (Criteria) this;
        }

        public Criteria andOpeMoneyGreaterThan(BigDecimal value) {
            addCriterion("ope_money >", value, "opeMoney");
            return (Criteria) this;
        }

        public Criteria andOpeMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ope_money >=", value, "opeMoney");
            return (Criteria) this;
        }

        public Criteria andOpeMoneyLessThan(BigDecimal value) {
            addCriterion("ope_money <", value, "opeMoney");
            return (Criteria) this;
        }

        public Criteria andOpeMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ope_money <=", value, "opeMoney");
            return (Criteria) this;
        }

        public Criteria andOpeMoneyIn(List<BigDecimal> values) {
            addCriterion("ope_money in", values, "opeMoney");
            return (Criteria) this;
        }

        public Criteria andOpeMoneyNotIn(List<BigDecimal> values) {
            addCriterion("ope_money not in", values, "opeMoney");
            return (Criteria) this;
        }

        public Criteria andOpeMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ope_money between", value1, value2, "opeMoney");
            return (Criteria) this;
        }

        public Criteria andOpeMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ope_money not between", value1, value2, "opeMoney");
            return (Criteria) this;
        }

        public Criteria andOpePriceIsNull() {
            addCriterion("ope_price is null");
            return (Criteria) this;
        }

        public Criteria andOpePriceIsNotNull() {
            addCriterion("ope_price is not null");
            return (Criteria) this;
        }

        public Criteria andOpePriceEqualTo(BigDecimal value) {
            addCriterion("ope_price =", value, "opePrice");
            return (Criteria) this;
        }

        public Criteria andOpePriceNotEqualTo(BigDecimal value) {
            addCriterion("ope_price <>", value, "opePrice");
            return (Criteria) this;
        }

        public Criteria andOpePriceGreaterThan(BigDecimal value) {
            addCriterion("ope_price >", value, "opePrice");
            return (Criteria) this;
        }

        public Criteria andOpePriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ope_price >=", value, "opePrice");
            return (Criteria) this;
        }

        public Criteria andOpePriceLessThan(BigDecimal value) {
            addCriterion("ope_price <", value, "opePrice");
            return (Criteria) this;
        }

        public Criteria andOpePriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ope_price <=", value, "opePrice");
            return (Criteria) this;
        }

        public Criteria andOpePriceIn(List<BigDecimal> values) {
            addCriterion("ope_price in", values, "opePrice");
            return (Criteria) this;
        }

        public Criteria andOpePriceNotIn(List<BigDecimal> values) {
            addCriterion("ope_price not in", values, "opePrice");
            return (Criteria) this;
        }

        public Criteria andOpePriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ope_price between", value1, value2, "opePrice");
            return (Criteria) this;
        }

        public Criteria andOpePriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ope_price not between", value1, value2, "opePrice");
            return (Criteria) this;
        }

        public Criteria andOpeNumIsNull() {
            addCriterion("ope_num is null");
            return (Criteria) this;
        }

        public Criteria andOpeNumIsNotNull() {
            addCriterion("ope_num is not null");
            return (Criteria) this;
        }

        public Criteria andOpeNumEqualTo(BigDecimal value) {
            addCriterion("ope_num =", value, "opeNum");
            return (Criteria) this;
        }

        public Criteria andOpeNumNotEqualTo(BigDecimal value) {
            addCriterion("ope_num <>", value, "opeNum");
            return (Criteria) this;
        }

        public Criteria andOpeNumGreaterThan(BigDecimal value) {
            addCriterion("ope_num >", value, "opeNum");
            return (Criteria) this;
        }

        public Criteria andOpeNumGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ope_num >=", value, "opeNum");
            return (Criteria) this;
        }

        public Criteria andOpeNumLessThan(BigDecimal value) {
            addCriterion("ope_num <", value, "opeNum");
            return (Criteria) this;
        }

        public Criteria andOpeNumLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ope_num <=", value, "opeNum");
            return (Criteria) this;
        }

        public Criteria andOpeNumIn(List<BigDecimal> values) {
            addCriterion("ope_num in", values, "opeNum");
            return (Criteria) this;
        }

        public Criteria andOpeNumNotIn(List<BigDecimal> values) {
            addCriterion("ope_num not in", values, "opeNum");
            return (Criteria) this;
        }

        public Criteria andOpeNumBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ope_num between", value1, value2, "opeNum");
            return (Criteria) this;
        }

        public Criteria andOpeNumNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ope_num not between", value1, value2, "opeNum");
            return (Criteria) this;
        }

        public Criteria andOpeDateIsNull() {
            addCriterion("ope_date is null");
            return (Criteria) this;
        }

        public Criteria andOpeDateIsNotNull() {
            addCriterion("ope_date is not null");
            return (Criteria) this;
        }

        public Criteria andOpeDateEqualTo(Date value) {
            addCriterion("ope_date =", value, "opeDate");
            return (Criteria) this;
        }

        public Criteria andOpeDateNotEqualTo(Date value) {
            addCriterion("ope_date <>", value, "opeDate");
            return (Criteria) this;
        }

        public Criteria andOpeDateGreaterThan(Date value) {
            addCriterion("ope_date >", value, "opeDate");
            return (Criteria) this;
        }

        public Criteria andOpeDateGreaterThanOrEqualTo(Date value) {
            addCriterion("ope_date >=", value, "opeDate");
            return (Criteria) this;
        }

        public Criteria andOpeDateLessThan(Date value) {
            addCriterion("ope_date <", value, "opeDate");
            return (Criteria) this;
        }

        public Criteria andOpeDateLessThanOrEqualTo(Date value) {
            addCriterion("ope_date <=", value, "opeDate");
            return (Criteria) this;
        }

        public Criteria andOpeDateIn(List<Date> values) {
            addCriterion("ope_date in", values, "opeDate");
            return (Criteria) this;
        }

        public Criteria andOpeDateNotIn(List<Date> values) {
            addCriterion("ope_date not in", values, "opeDate");
            return (Criteria) this;
        }

        public Criteria andOpeDateBetween(Date value1, Date value2) {
            addCriterion("ope_date between", value1, value2, "opeDate");
            return (Criteria) this;
        }

        public Criteria andOpeDateNotBetween(Date value1, Date value2) {
            addCriterion("ope_date not between", value1, value2, "opeDate");
            return (Criteria) this;
        }

        public Criteria andOpeStatusIsNull() {
            addCriterion("ope_status is null");
            return (Criteria) this;
        }

        public Criteria andOpeStatusIsNotNull() {
            addCriterion("ope_status is not null");
            return (Criteria) this;
        }

        public Criteria andOpeStatusEqualTo(String value) {
            addCriterion("ope_status =", value, "opeStatus");
            return (Criteria) this;
        }

        public Criteria andOpeStatusNotEqualTo(String value) {
            addCriterion("ope_status <>", value, "opeStatus");
            return (Criteria) this;
        }

        public Criteria andOpeStatusGreaterThan(String value) {
            addCriterion("ope_status >", value, "opeStatus");
            return (Criteria) this;
        }

        public Criteria andOpeStatusGreaterThanOrEqualTo(String value) {
            addCriterion("ope_status >=", value, "opeStatus");
            return (Criteria) this;
        }

        public Criteria andOpeStatusLessThan(String value) {
            addCriterion("ope_status <", value, "opeStatus");
            return (Criteria) this;
        }

        public Criteria andOpeStatusLessThanOrEqualTo(String value) {
            addCriterion("ope_status <=", value, "opeStatus");
            return (Criteria) this;
        }

        public Criteria andOpeStatusLike(String value) {
            addCriterion("ope_status like", value, "opeStatus");
            return (Criteria) this;
        }

        public Criteria andOpeStatusNotLike(String value) {
            addCriterion("ope_status not like", value, "opeStatus");
            return (Criteria) this;
        }

        public Criteria andOpeStatusIn(List<String> values) {
            addCriterion("ope_status in", values, "opeStatus");
            return (Criteria) this;
        }

        public Criteria andOpeStatusNotIn(List<String> values) {
            addCriterion("ope_status not in", values, "opeStatus");
            return (Criteria) this;
        }

        public Criteria andOpeStatusBetween(String value1, String value2) {
            addCriterion("ope_status between", value1, value2, "opeStatus");
            return (Criteria) this;
        }

        public Criteria andOpeStatusNotBetween(String value1, String value2) {
            addCriterion("ope_status not between", value1, value2, "opeStatus");
            return (Criteria) this;
        }

        public Criteria andOpeTepeIsNull() {
            addCriterion("ope_tepe is null");
            return (Criteria) this;
        }

        public Criteria andOpeTepeIsNotNull() {
            addCriterion("ope_tepe is not null");
            return (Criteria) this;
        }

        public Criteria andOpeTepeEqualTo(String value) {
            addCriterion("ope_tepe =", value, "opeTepe");
            return (Criteria) this;
        }

        public Criteria andOpeTepeNotEqualTo(String value) {
            addCriterion("ope_tepe <>", value, "opeTepe");
            return (Criteria) this;
        }

        public Criteria andOpeTepeGreaterThan(String value) {
            addCriterion("ope_tepe >", value, "opeTepe");
            return (Criteria) this;
        }

        public Criteria andOpeTepeGreaterThanOrEqualTo(String value) {
            addCriterion("ope_tepe >=", value, "opeTepe");
            return (Criteria) this;
        }

        public Criteria andOpeTepeLessThan(String value) {
            addCriterion("ope_tepe <", value, "opeTepe");
            return (Criteria) this;
        }

        public Criteria andOpeTepeLessThanOrEqualTo(String value) {
            addCriterion("ope_tepe <=", value, "opeTepe");
            return (Criteria) this;
        }

        public Criteria andOpeTepeLike(String value) {
            addCriterion("ope_tepe like", value, "opeTepe");
            return (Criteria) this;
        }

        public Criteria andOpeTepeNotLike(String value) {
            addCriterion("ope_tepe not like", value, "opeTepe");
            return (Criteria) this;
        }

        public Criteria andOpeTepeIn(List<String> values) {
            addCriterion("ope_tepe in", values, "opeTepe");
            return (Criteria) this;
        }

        public Criteria andOpeTepeNotIn(List<String> values) {
            addCriterion("ope_tepe not in", values, "opeTepe");
            return (Criteria) this;
        }

        public Criteria andOpeTepeBetween(String value1, String value2) {
            addCriterion("ope_tepe between", value1, value2, "opeTepe");
            return (Criteria) this;
        }

        public Criteria andOpeTepeNotBetween(String value1, String value2) {
            addCriterion("ope_tepe not between", value1, value2, "opeTepe");
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