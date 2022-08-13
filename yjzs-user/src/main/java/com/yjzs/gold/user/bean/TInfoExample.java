package com.yjzs.gold.user.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TInfoExample() {
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

        public Criteria andInfoIdIsNull() {
            addCriterion("info_id is null");
            return (Criteria) this;
        }

        public Criteria andInfoIdIsNotNull() {
            addCriterion("info_id is not null");
            return (Criteria) this;
        }

        public Criteria andInfoIdEqualTo(Integer value) {
            addCriterion("info_id =", value, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdNotEqualTo(Integer value) {
            addCriterion("info_id <>", value, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdGreaterThan(Integer value) {
            addCriterion("info_id >", value, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("info_id >=", value, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdLessThan(Integer value) {
            addCriterion("info_id <", value, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdLessThanOrEqualTo(Integer value) {
            addCriterion("info_id <=", value, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdIn(List<Integer> values) {
            addCriterion("info_id in", values, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdNotIn(List<Integer> values) {
            addCriterion("info_id not in", values, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdBetween(Integer value1, Integer value2) {
            addCriterion("info_id between", value1, value2, "infoId");
            return (Criteria) this;
        }

        public Criteria andInfoIdNotBetween(Integer value1, Integer value2) {
            addCriterion("info_id not between", value1, value2, "infoId");
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

        public Criteria andInfoTotalMoneyIsNull() {
            addCriterion("info_total_money is null");
            return (Criteria) this;
        }

        public Criteria andInfoTotalMoneyIsNotNull() {
            addCriterion("info_total_money is not null");
            return (Criteria) this;
        }

        public Criteria andInfoTotalMoneyEqualTo(BigDecimal value) {
            addCriterion("info_total_money =", value, "infoTotalMoney");
            return (Criteria) this;
        }

        public Criteria andInfoTotalMoneyNotEqualTo(BigDecimal value) {
            addCriterion("info_total_money <>", value, "infoTotalMoney");
            return (Criteria) this;
        }

        public Criteria andInfoTotalMoneyGreaterThan(BigDecimal value) {
            addCriterion("info_total_money >", value, "infoTotalMoney");
            return (Criteria) this;
        }

        public Criteria andInfoTotalMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("info_total_money >=", value, "infoTotalMoney");
            return (Criteria) this;
        }

        public Criteria andInfoTotalMoneyLessThan(BigDecimal value) {
            addCriterion("info_total_money <", value, "infoTotalMoney");
            return (Criteria) this;
        }

        public Criteria andInfoTotalMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("info_total_money <=", value, "infoTotalMoney");
            return (Criteria) this;
        }

        public Criteria andInfoTotalMoneyIn(List<BigDecimal> values) {
            addCriterion("info_total_money in", values, "infoTotalMoney");
            return (Criteria) this;
        }

        public Criteria andInfoTotalMoneyNotIn(List<BigDecimal> values) {
            addCriterion("info_total_money not in", values, "infoTotalMoney");
            return (Criteria) this;
        }

        public Criteria andInfoTotalMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("info_total_money between", value1, value2, "infoTotalMoney");
            return (Criteria) this;
        }

        public Criteria andInfoTotalMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("info_total_money not between", value1, value2, "infoTotalMoney");
            return (Criteria) this;
        }

        public Criteria andInfoOccupyMoneyIsNull() {
            addCriterion("info_occupy_money is null");
            return (Criteria) this;
        }

        public Criteria andInfoOccupyMoneyIsNotNull() {
            addCriterion("info_occupy_money is not null");
            return (Criteria) this;
        }

        public Criteria andInfoOccupyMoneyEqualTo(BigDecimal value) {
            addCriterion("info_occupy_money =", value, "infoOccupyMoney");
            return (Criteria) this;
        }

        public Criteria andInfoOccupyMoneyNotEqualTo(BigDecimal value) {
            addCriterion("info_occupy_money <>", value, "infoOccupyMoney");
            return (Criteria) this;
        }

        public Criteria andInfoOccupyMoneyGreaterThan(BigDecimal value) {
            addCriterion("info_occupy_money >", value, "infoOccupyMoney");
            return (Criteria) this;
        }

        public Criteria andInfoOccupyMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("info_occupy_money >=", value, "infoOccupyMoney");
            return (Criteria) this;
        }

        public Criteria andInfoOccupyMoneyLessThan(BigDecimal value) {
            addCriterion("info_occupy_money <", value, "infoOccupyMoney");
            return (Criteria) this;
        }

        public Criteria andInfoOccupyMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("info_occupy_money <=", value, "infoOccupyMoney");
            return (Criteria) this;
        }

        public Criteria andInfoOccupyMoneyIn(List<BigDecimal> values) {
            addCriterion("info_occupy_money in", values, "infoOccupyMoney");
            return (Criteria) this;
        }

        public Criteria andInfoOccupyMoneyNotIn(List<BigDecimal> values) {
            addCriterion("info_occupy_money not in", values, "infoOccupyMoney");
            return (Criteria) this;
        }

        public Criteria andInfoOccupyMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("info_occupy_money between", value1, value2, "infoOccupyMoney");
            return (Criteria) this;
        }

        public Criteria andInfoOccupyMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("info_occupy_money not between", value1, value2, "infoOccupyMoney");
            return (Criteria) this;
        }

        public Criteria andInfoYjzsProfitIsNull() {
            addCriterion("info_yjzs_profit is null");
            return (Criteria) this;
        }

        public Criteria andInfoYjzsProfitIsNotNull() {
            addCriterion("info_yjzs_profit is not null");
            return (Criteria) this;
        }

        public Criteria andInfoYjzsProfitEqualTo(BigDecimal value) {
            addCriterion("info_yjzs_profit =", value, "infoYjzsProfit");
            return (Criteria) this;
        }

        public Criteria andInfoYjzsProfitNotEqualTo(BigDecimal value) {
            addCriterion("info_yjzs_profit <>", value, "infoYjzsProfit");
            return (Criteria) this;
        }

        public Criteria andInfoYjzsProfitGreaterThan(BigDecimal value) {
            addCriterion("info_yjzs_profit >", value, "infoYjzsProfit");
            return (Criteria) this;
        }

        public Criteria andInfoYjzsProfitGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("info_yjzs_profit >=", value, "infoYjzsProfit");
            return (Criteria) this;
        }

        public Criteria andInfoYjzsProfitLessThan(BigDecimal value) {
            addCriterion("info_yjzs_profit <", value, "infoYjzsProfit");
            return (Criteria) this;
        }

        public Criteria andInfoYjzsProfitLessThanOrEqualTo(BigDecimal value) {
            addCriterion("info_yjzs_profit <=", value, "infoYjzsProfit");
            return (Criteria) this;
        }

        public Criteria andInfoYjzsProfitIn(List<BigDecimal> values) {
            addCriterion("info_yjzs_profit in", values, "infoYjzsProfit");
            return (Criteria) this;
        }

        public Criteria andInfoYjzsProfitNotIn(List<BigDecimal> values) {
            addCriterion("info_yjzs_profit not in", values, "infoYjzsProfit");
            return (Criteria) this;
        }

        public Criteria andInfoYjzsProfitBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("info_yjzs_profit between", value1, value2, "infoYjzsProfit");
            return (Criteria) this;
        }

        public Criteria andInfoYjzsProfitNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("info_yjzs_profit not between", value1, value2, "infoYjzsProfit");
            return (Criteria) this;
        }

        public Criteria andInfoYjzsTomProfitIsNull() {
            addCriterion("info_yjzs_tom_profit is null");
            return (Criteria) this;
        }

        public Criteria andInfoYjzsTomProfitIsNotNull() {
            addCriterion("info_yjzs_tom_profit is not null");
            return (Criteria) this;
        }

        public Criteria andInfoYjzsTomProfitEqualTo(BigDecimal value) {
            addCriterion("info_yjzs_tom_profit =", value, "infoYjzsTomProfit");
            return (Criteria) this;
        }

        public Criteria andInfoYjzsTomProfitNotEqualTo(BigDecimal value) {
            addCriterion("info_yjzs_tom_profit <>", value, "infoYjzsTomProfit");
            return (Criteria) this;
        }

        public Criteria andInfoYjzsTomProfitGreaterThan(BigDecimal value) {
            addCriterion("info_yjzs_tom_profit >", value, "infoYjzsTomProfit");
            return (Criteria) this;
        }

        public Criteria andInfoYjzsTomProfitGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("info_yjzs_tom_profit >=", value, "infoYjzsTomProfit");
            return (Criteria) this;
        }

        public Criteria andInfoYjzsTomProfitLessThan(BigDecimal value) {
            addCriterion("info_yjzs_tom_profit <", value, "infoYjzsTomProfit");
            return (Criteria) this;
        }

        public Criteria andInfoYjzsTomProfitLessThanOrEqualTo(BigDecimal value) {
            addCriterion("info_yjzs_tom_profit <=", value, "infoYjzsTomProfit");
            return (Criteria) this;
        }

        public Criteria andInfoYjzsTomProfitIn(List<BigDecimal> values) {
            addCriterion("info_yjzs_tom_profit in", values, "infoYjzsTomProfit");
            return (Criteria) this;
        }

        public Criteria andInfoYjzsTomProfitNotIn(List<BigDecimal> values) {
            addCriterion("info_yjzs_tom_profit not in", values, "infoYjzsTomProfit");
            return (Criteria) this;
        }

        public Criteria andInfoYjzsTomProfitBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("info_yjzs_tom_profit between", value1, value2, "infoYjzsTomProfit");
            return (Criteria) this;
        }

        public Criteria andInfoYjzsTomProfitNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("info_yjzs_tom_profit not between", value1, value2, "infoYjzsTomProfit");
            return (Criteria) this;
        }

        public Criteria andInfoDateIsNull() {
            addCriterion("info_date is null");
            return (Criteria) this;
        }

        public Criteria andInfoDateIsNotNull() {
            addCriterion("info_date is not null");
            return (Criteria) this;
        }

        public Criteria andInfoDateEqualTo(Date value) {
            addCriterion("info_date =", value, "infoDate");
            return (Criteria) this;
        }

        public Criteria andInfoDateNotEqualTo(Date value) {
            addCriterion("info_date <>", value, "infoDate");
            return (Criteria) this;
        }

        public Criteria andInfoDateGreaterThan(Date value) {
            addCriterion("info_date >", value, "infoDate");
            return (Criteria) this;
        }

        public Criteria andInfoDateGreaterThanOrEqualTo(Date value) {
            addCriterion("info_date >=", value, "infoDate");
            return (Criteria) this;
        }

        public Criteria andInfoDateLessThan(Date value) {
            addCriterion("info_date <", value, "infoDate");
            return (Criteria) this;
        }

        public Criteria andInfoDateLessThanOrEqualTo(Date value) {
            addCriterion("info_date <=", value, "infoDate");
            return (Criteria) this;
        }

        public Criteria andInfoDateIn(List<Date> values) {
            addCriterion("info_date in", values, "infoDate");
            return (Criteria) this;
        }

        public Criteria andInfoDateNotIn(List<Date> values) {
            addCriterion("info_date not in", values, "infoDate");
            return (Criteria) this;
        }

        public Criteria andInfoDateBetween(Date value1, Date value2) {
            addCriterion("info_date between", value1, value2, "infoDate");
            return (Criteria) this;
        }

        public Criteria andInfoDateNotBetween(Date value1, Date value2) {
            addCriterion("info_date not between", value1, value2, "infoDate");
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