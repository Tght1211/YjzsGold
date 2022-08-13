package com.yjzs.gold.main.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TSupportExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TSupportExample() {
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

        public Criteria andSupIdIsNull() {
            addCriterion("sup_id is null");
            return (Criteria) this;
        }

        public Criteria andSupIdIsNotNull() {
            addCriterion("sup_id is not null");
            return (Criteria) this;
        }

        public Criteria andSupIdEqualTo(Integer value) {
            addCriterion("sup_id =", value, "supId");
            return (Criteria) this;
        }

        public Criteria andSupIdNotEqualTo(Integer value) {
            addCriterion("sup_id <>", value, "supId");
            return (Criteria) this;
        }

        public Criteria andSupIdGreaterThan(Integer value) {
            addCriterion("sup_id >", value, "supId");
            return (Criteria) this;
        }

        public Criteria andSupIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("sup_id >=", value, "supId");
            return (Criteria) this;
        }

        public Criteria andSupIdLessThan(Integer value) {
            addCriterion("sup_id <", value, "supId");
            return (Criteria) this;
        }

        public Criteria andSupIdLessThanOrEqualTo(Integer value) {
            addCriterion("sup_id <=", value, "supId");
            return (Criteria) this;
        }

        public Criteria andSupIdIn(List<Integer> values) {
            addCriterion("sup_id in", values, "supId");
            return (Criteria) this;
        }

        public Criteria andSupIdNotIn(List<Integer> values) {
            addCriterion("sup_id not in", values, "supId");
            return (Criteria) this;
        }

        public Criteria andSupIdBetween(Integer value1, Integer value2) {
            addCriterion("sup_id between", value1, value2, "supId");
            return (Criteria) this;
        }

        public Criteria andSupIdNotBetween(Integer value1, Integer value2) {
            addCriterion("sup_id not between", value1, value2, "supId");
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

        public Criteria andFundZrjzIsNull() {
            addCriterion("fund_zrjz is null");
            return (Criteria) this;
        }

        public Criteria andFundZrjzIsNotNull() {
            addCriterion("fund_zrjz is not null");
            return (Criteria) this;
        }

        public Criteria andFundZrjzEqualTo(BigDecimal value) {
            addCriterion("fund_zrjz =", value, "fundZrjz");
            return (Criteria) this;
        }

        public Criteria andFundZrjzNotEqualTo(BigDecimal value) {
            addCriterion("fund_zrjz <>", value, "fundZrjz");
            return (Criteria) this;
        }

        public Criteria andFundZrjzGreaterThan(BigDecimal value) {
            addCriterion("fund_zrjz >", value, "fundZrjz");
            return (Criteria) this;
        }

        public Criteria andFundZrjzGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fund_zrjz >=", value, "fundZrjz");
            return (Criteria) this;
        }

        public Criteria andFundZrjzLessThan(BigDecimal value) {
            addCriterion("fund_zrjz <", value, "fundZrjz");
            return (Criteria) this;
        }

        public Criteria andFundZrjzLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fund_zrjz <=", value, "fundZrjz");
            return (Criteria) this;
        }

        public Criteria andFundZrjzIn(List<BigDecimal> values) {
            addCriterion("fund_zrjz in", values, "fundZrjz");
            return (Criteria) this;
        }

        public Criteria andFundZrjzNotIn(List<BigDecimal> values) {
            addCriterion("fund_zrjz not in", values, "fundZrjz");
            return (Criteria) this;
        }

        public Criteria andFundZrjzBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fund_zrjz between", value1, value2, "fundZrjz");
            return (Criteria) this;
        }

        public Criteria andFundZrjzNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fund_zrjz not between", value1, value2, "fundZrjz");
            return (Criteria) this;
        }

        public Criteria andSupMoneyIsNull() {
            addCriterion("sup_money is null");
            return (Criteria) this;
        }

        public Criteria andSupMoneyIsNotNull() {
            addCriterion("sup_money is not null");
            return (Criteria) this;
        }

        public Criteria andSupMoneyEqualTo(BigDecimal value) {
            addCriterion("sup_money =", value, "supMoney");
            return (Criteria) this;
        }

        public Criteria andSupMoneyNotEqualTo(BigDecimal value) {
            addCriterion("sup_money <>", value, "supMoney");
            return (Criteria) this;
        }

        public Criteria andSupMoneyGreaterThan(BigDecimal value) {
            addCriterion("sup_money >", value, "supMoney");
            return (Criteria) this;
        }

        public Criteria andSupMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("sup_money >=", value, "supMoney");
            return (Criteria) this;
        }

        public Criteria andSupMoneyLessThan(BigDecimal value) {
            addCriterion("sup_money <", value, "supMoney");
            return (Criteria) this;
        }

        public Criteria andSupMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("sup_money <=", value, "supMoney");
            return (Criteria) this;
        }

        public Criteria andSupMoneyIn(List<BigDecimal> values) {
            addCriterion("sup_money in", values, "supMoney");
            return (Criteria) this;
        }

        public Criteria andSupMoneyNotIn(List<BigDecimal> values) {
            addCriterion("sup_money not in", values, "supMoney");
            return (Criteria) this;
        }

        public Criteria andSupMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sup_money between", value1, value2, "supMoney");
            return (Criteria) this;
        }

        public Criteria andSupMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sup_money not between", value1, value2, "supMoney");
            return (Criteria) this;
        }

        public Criteria andSupPriceIsNull() {
            addCriterion("sup_price is null");
            return (Criteria) this;
        }

        public Criteria andSupPriceIsNotNull() {
            addCriterion("sup_price is not null");
            return (Criteria) this;
        }

        public Criteria andSupPriceEqualTo(BigDecimal value) {
            addCriterion("sup_price =", value, "supPrice");
            return (Criteria) this;
        }

        public Criteria andSupPriceNotEqualTo(BigDecimal value) {
            addCriterion("sup_price <>", value, "supPrice");
            return (Criteria) this;
        }

        public Criteria andSupPriceGreaterThan(BigDecimal value) {
            addCriterion("sup_price >", value, "supPrice");
            return (Criteria) this;
        }

        public Criteria andSupPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("sup_price >=", value, "supPrice");
            return (Criteria) this;
        }

        public Criteria andSupPriceLessThan(BigDecimal value) {
            addCriterion("sup_price <", value, "supPrice");
            return (Criteria) this;
        }

        public Criteria andSupPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("sup_price <=", value, "supPrice");
            return (Criteria) this;
        }

        public Criteria andSupPriceIn(List<BigDecimal> values) {
            addCriterion("sup_price in", values, "supPrice");
            return (Criteria) this;
        }

        public Criteria andSupPriceNotIn(List<BigDecimal> values) {
            addCriterion("sup_price not in", values, "supPrice");
            return (Criteria) this;
        }

        public Criteria andSupPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sup_price between", value1, value2, "supPrice");
            return (Criteria) this;
        }

        public Criteria andSupPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sup_price not between", value1, value2, "supPrice");
            return (Criteria) this;
        }

        public Criteria andSupNumIsNull() {
            addCriterion("sup_num is null");
            return (Criteria) this;
        }

        public Criteria andSupNumIsNotNull() {
            addCriterion("sup_num is not null");
            return (Criteria) this;
        }

        public Criteria andSupNumEqualTo(BigDecimal value) {
            addCriterion("sup_num =", value, "supNum");
            return (Criteria) this;
        }

        public Criteria andSupNumNotEqualTo(BigDecimal value) {
            addCriterion("sup_num <>", value, "supNum");
            return (Criteria) this;
        }

        public Criteria andSupNumGreaterThan(BigDecimal value) {
            addCriterion("sup_num >", value, "supNum");
            return (Criteria) this;
        }

        public Criteria andSupNumGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("sup_num >=", value, "supNum");
            return (Criteria) this;
        }

        public Criteria andSupNumLessThan(BigDecimal value) {
            addCriterion("sup_num <", value, "supNum");
            return (Criteria) this;
        }

        public Criteria andSupNumLessThanOrEqualTo(BigDecimal value) {
            addCriterion("sup_num <=", value, "supNum");
            return (Criteria) this;
        }

        public Criteria andSupNumIn(List<BigDecimal> values) {
            addCriterion("sup_num in", values, "supNum");
            return (Criteria) this;
        }

        public Criteria andSupNumNotIn(List<BigDecimal> values) {
            addCriterion("sup_num not in", values, "supNum");
            return (Criteria) this;
        }

        public Criteria andSupNumBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sup_num between", value1, value2, "supNum");
            return (Criteria) this;
        }

        public Criteria andSupNumNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sup_num not between", value1, value2, "supNum");
            return (Criteria) this;
        }

        public Criteria andSupProfitIsNull() {
            addCriterion("sup_profit is null");
            return (Criteria) this;
        }

        public Criteria andSupProfitIsNotNull() {
            addCriterion("sup_profit is not null");
            return (Criteria) this;
        }

        public Criteria andSupProfitEqualTo(BigDecimal value) {
            addCriterion("sup_profit =", value, "supProfit");
            return (Criteria) this;
        }

        public Criteria andSupProfitNotEqualTo(BigDecimal value) {
            addCriterion("sup_profit <>", value, "supProfit");
            return (Criteria) this;
        }

        public Criteria andSupProfitGreaterThan(BigDecimal value) {
            addCriterion("sup_profit >", value, "supProfit");
            return (Criteria) this;
        }

        public Criteria andSupProfitGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("sup_profit >=", value, "supProfit");
            return (Criteria) this;
        }

        public Criteria andSupProfitLessThan(BigDecimal value) {
            addCriterion("sup_profit <", value, "supProfit");
            return (Criteria) this;
        }

        public Criteria andSupProfitLessThanOrEqualTo(BigDecimal value) {
            addCriterion("sup_profit <=", value, "supProfit");
            return (Criteria) this;
        }

        public Criteria andSupProfitIn(List<BigDecimal> values) {
            addCriterion("sup_profit in", values, "supProfit");
            return (Criteria) this;
        }

        public Criteria andSupProfitNotIn(List<BigDecimal> values) {
            addCriterion("sup_profit not in", values, "supProfit");
            return (Criteria) this;
        }

        public Criteria andSupProfitBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sup_profit between", value1, value2, "supProfit");
            return (Criteria) this;
        }

        public Criteria andSupProfitNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sup_profit not between", value1, value2, "supProfit");
            return (Criteria) this;
        }

        public Criteria andSupTotalMoneyIsNull() {
            addCriterion("sup_total_money is null");
            return (Criteria) this;
        }

        public Criteria andSupTotalMoneyIsNotNull() {
            addCriterion("sup_total_money is not null");
            return (Criteria) this;
        }

        public Criteria andSupTotalMoneyEqualTo(BigDecimal value) {
            addCriterion("sup_total_money =", value, "supTotalMoney");
            return (Criteria) this;
        }

        public Criteria andSupTotalMoneyNotEqualTo(BigDecimal value) {
            addCriterion("sup_total_money <>", value, "supTotalMoney");
            return (Criteria) this;
        }

        public Criteria andSupTotalMoneyGreaterThan(BigDecimal value) {
            addCriterion("sup_total_money >", value, "supTotalMoney");
            return (Criteria) this;
        }

        public Criteria andSupTotalMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("sup_total_money >=", value, "supTotalMoney");
            return (Criteria) this;
        }

        public Criteria andSupTotalMoneyLessThan(BigDecimal value) {
            addCriterion("sup_total_money <", value, "supTotalMoney");
            return (Criteria) this;
        }

        public Criteria andSupTotalMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("sup_total_money <=", value, "supTotalMoney");
            return (Criteria) this;
        }

        public Criteria andSupTotalMoneyIn(List<BigDecimal> values) {
            addCriterion("sup_total_money in", values, "supTotalMoney");
            return (Criteria) this;
        }

        public Criteria andSupTotalMoneyNotIn(List<BigDecimal> values) {
            addCriterion("sup_total_money not in", values, "supTotalMoney");
            return (Criteria) this;
        }

        public Criteria andSupTotalMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sup_total_money between", value1, value2, "supTotalMoney");
            return (Criteria) this;
        }

        public Criteria andSupTotalMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("sup_total_money not between", value1, value2, "supTotalMoney");
            return (Criteria) this;
        }

        public Criteria andSuoDateIsNull() {
            addCriterion("suo_date is null");
            return (Criteria) this;
        }

        public Criteria andSuoDateIsNotNull() {
            addCriterion("suo_date is not null");
            return (Criteria) this;
        }

        public Criteria andSuoDateEqualTo(Date value) {
            addCriterion("suo_date =", value, "suoDate");
            return (Criteria) this;
        }

        public Criteria andSuoDateNotEqualTo(Date value) {
            addCriterion("suo_date <>", value, "suoDate");
            return (Criteria) this;
        }

        public Criteria andSuoDateGreaterThan(Date value) {
            addCriterion("suo_date >", value, "suoDate");
            return (Criteria) this;
        }

        public Criteria andSuoDateGreaterThanOrEqualTo(Date value) {
            addCriterion("suo_date >=", value, "suoDate");
            return (Criteria) this;
        }

        public Criteria andSuoDateLessThan(Date value) {
            addCriterion("suo_date <", value, "suoDate");
            return (Criteria) this;
        }

        public Criteria andSuoDateLessThanOrEqualTo(Date value) {
            addCriterion("suo_date <=", value, "suoDate");
            return (Criteria) this;
        }

        public Criteria andSuoDateIn(List<Date> values) {
            addCriterion("suo_date in", values, "suoDate");
            return (Criteria) this;
        }

        public Criteria andSuoDateNotIn(List<Date> values) {
            addCriterion("suo_date not in", values, "suoDate");
            return (Criteria) this;
        }

        public Criteria andSuoDateBetween(Date value1, Date value2) {
            addCriterion("suo_date between", value1, value2, "suoDate");
            return (Criteria) this;
        }

        public Criteria andSuoDateNotBetween(Date value1, Date value2) {
            addCriterion("suo_date not between", value1, value2, "suoDate");
            return (Criteria) this;
        }

        public Criteria andSupStatusIsNull() {
            addCriterion("sup_status is null");
            return (Criteria) this;
        }

        public Criteria andSupStatusIsNotNull() {
            addCriterion("sup_status is not null");
            return (Criteria) this;
        }

        public Criteria andSupStatusEqualTo(String value) {
            addCriterion("sup_status =", value, "supStatus");
            return (Criteria) this;
        }

        public Criteria andSupStatusNotEqualTo(String value) {
            addCriterion("sup_status <>", value, "supStatus");
            return (Criteria) this;
        }

        public Criteria andSupStatusGreaterThan(String value) {
            addCriterion("sup_status >", value, "supStatus");
            return (Criteria) this;
        }

        public Criteria andSupStatusGreaterThanOrEqualTo(String value) {
            addCriterion("sup_status >=", value, "supStatus");
            return (Criteria) this;
        }

        public Criteria andSupStatusLessThan(String value) {
            addCriterion("sup_status <", value, "supStatus");
            return (Criteria) this;
        }

        public Criteria andSupStatusLessThanOrEqualTo(String value) {
            addCriterion("sup_status <=", value, "supStatus");
            return (Criteria) this;
        }

        public Criteria andSupStatusLike(String value) {
            addCriterion("sup_status like", value, "supStatus");
            return (Criteria) this;
        }

        public Criteria andSupStatusNotLike(String value) {
            addCriterion("sup_status not like", value, "supStatus");
            return (Criteria) this;
        }

        public Criteria andSupStatusIn(List<String> values) {
            addCriterion("sup_status in", values, "supStatus");
            return (Criteria) this;
        }

        public Criteria andSupStatusNotIn(List<String> values) {
            addCriterion("sup_status not in", values, "supStatus");
            return (Criteria) this;
        }

        public Criteria andSupStatusBetween(String value1, String value2) {
            addCriterion("sup_status between", value1, value2, "supStatus");
            return (Criteria) this;
        }

        public Criteria andSupStatusNotBetween(String value1, String value2) {
            addCriterion("sup_status not between", value1, value2, "supStatus");
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