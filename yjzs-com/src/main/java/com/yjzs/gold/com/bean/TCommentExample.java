package com.yjzs.gold.com.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TCommentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TCommentExample() {
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

        public Criteria andComIdIsNull() {
            addCriterion("com_id is null");
            return (Criteria) this;
        }

        public Criteria andComIdIsNotNull() {
            addCriterion("com_id is not null");
            return (Criteria) this;
        }

        public Criteria andComIdEqualTo(Integer value) {
            addCriterion("com_id =", value, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdNotEqualTo(Integer value) {
            addCriterion("com_id <>", value, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdGreaterThan(Integer value) {
            addCriterion("com_id >", value, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("com_id >=", value, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdLessThan(Integer value) {
            addCriterion("com_id <", value, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdLessThanOrEqualTo(Integer value) {
            addCriterion("com_id <=", value, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdIn(List<Integer> values) {
            addCriterion("com_id in", values, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdNotIn(List<Integer> values) {
            addCriterion("com_id not in", values, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdBetween(Integer value1, Integer value2) {
            addCriterion("com_id between", value1, value2, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdNotBetween(Integer value1, Integer value2) {
            addCriterion("com_id not between", value1, value2, "comId");
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

        public Criteria andComConIdIsNull() {
            addCriterion("com_con_id is null");
            return (Criteria) this;
        }

        public Criteria andComConIdIsNotNull() {
            addCriterion("com_con_id is not null");
            return (Criteria) this;
        }

        public Criteria andComConIdEqualTo(Integer value) {
            addCriterion("com_con_id =", value, "comConId");
            return (Criteria) this;
        }

        public Criteria andComConIdNotEqualTo(Integer value) {
            addCriterion("com_con_id <>", value, "comConId");
            return (Criteria) this;
        }

        public Criteria andComConIdGreaterThan(Integer value) {
            addCriterion("com_con_id >", value, "comConId");
            return (Criteria) this;
        }

        public Criteria andComConIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("com_con_id >=", value, "comConId");
            return (Criteria) this;
        }

        public Criteria andComConIdLessThan(Integer value) {
            addCriterion("com_con_id <", value, "comConId");
            return (Criteria) this;
        }

        public Criteria andComConIdLessThanOrEqualTo(Integer value) {
            addCriterion("com_con_id <=", value, "comConId");
            return (Criteria) this;
        }

        public Criteria andComConIdIn(List<Integer> values) {
            addCriterion("com_con_id in", values, "comConId");
            return (Criteria) this;
        }

        public Criteria andComConIdNotIn(List<Integer> values) {
            addCriterion("com_con_id not in", values, "comConId");
            return (Criteria) this;
        }

        public Criteria andComConIdBetween(Integer value1, Integer value2) {
            addCriterion("com_con_id between", value1, value2, "comConId");
            return (Criteria) this;
        }

        public Criteria andComConIdNotBetween(Integer value1, Integer value2) {
            addCriterion("com_con_id not between", value1, value2, "comConId");
            return (Criteria) this;
        }

        public Criteria andComContentIsNull() {
            addCriterion("com_content is null");
            return (Criteria) this;
        }

        public Criteria andComContentIsNotNull() {
            addCriterion("com_content is not null");
            return (Criteria) this;
        }

        public Criteria andComContentEqualTo(String value) {
            addCriterion("com_content =", value, "comContent");
            return (Criteria) this;
        }

        public Criteria andComContentNotEqualTo(String value) {
            addCriterion("com_content <>", value, "comContent");
            return (Criteria) this;
        }

        public Criteria andComContentGreaterThan(String value) {
            addCriterion("com_content >", value, "comContent");
            return (Criteria) this;
        }

        public Criteria andComContentGreaterThanOrEqualTo(String value) {
            addCriterion("com_content >=", value, "comContent");
            return (Criteria) this;
        }

        public Criteria andComContentLessThan(String value) {
            addCriterion("com_content <", value, "comContent");
            return (Criteria) this;
        }

        public Criteria andComContentLessThanOrEqualTo(String value) {
            addCriterion("com_content <=", value, "comContent");
            return (Criteria) this;
        }

        public Criteria andComContentLike(String value) {
            addCriterion("com_content like", value, "comContent");
            return (Criteria) this;
        }

        public Criteria andComContentNotLike(String value) {
            addCriterion("com_content not like", value, "comContent");
            return (Criteria) this;
        }

        public Criteria andComContentIn(List<String> values) {
            addCriterion("com_content in", values, "comContent");
            return (Criteria) this;
        }

        public Criteria andComContentNotIn(List<String> values) {
            addCriterion("com_content not in", values, "comContent");
            return (Criteria) this;
        }

        public Criteria andComContentBetween(String value1, String value2) {
            addCriterion("com_content between", value1, value2, "comContent");
            return (Criteria) this;
        }

        public Criteria andComContentNotBetween(String value1, String value2) {
            addCriterion("com_content not between", value1, value2, "comContent");
            return (Criteria) this;
        }

        public Criteria andComDateIsNull() {
            addCriterion("com_date is null");
            return (Criteria) this;
        }

        public Criteria andComDateIsNotNull() {
            addCriterion("com_date is not null");
            return (Criteria) this;
        }

        public Criteria andComDateEqualTo(Date value) {
            addCriterion("com_date =", value, "comDate");
            return (Criteria) this;
        }

        public Criteria andComDateNotEqualTo(Date value) {
            addCriterion("com_date <>", value, "comDate");
            return (Criteria) this;
        }

        public Criteria andComDateGreaterThan(Date value) {
            addCriterion("com_date >", value, "comDate");
            return (Criteria) this;
        }

        public Criteria andComDateGreaterThanOrEqualTo(Date value) {
            addCriterion("com_date >=", value, "comDate");
            return (Criteria) this;
        }

        public Criteria andComDateLessThan(Date value) {
            addCriterion("com_date <", value, "comDate");
            return (Criteria) this;
        }

        public Criteria andComDateLessThanOrEqualTo(Date value) {
            addCriterion("com_date <=", value, "comDate");
            return (Criteria) this;
        }

        public Criteria andComDateIn(List<Date> values) {
            addCriterion("com_date in", values, "comDate");
            return (Criteria) this;
        }

        public Criteria andComDateNotIn(List<Date> values) {
            addCriterion("com_date not in", values, "comDate");
            return (Criteria) this;
        }

        public Criteria andComDateBetween(Date value1, Date value2) {
            addCriterion("com_date between", value1, value2, "comDate");
            return (Criteria) this;
        }

        public Criteria andComDateNotBetween(Date value1, Date value2) {
            addCriterion("com_date not between", value1, value2, "comDate");
            return (Criteria) this;
        }

        public Criteria andComTypeIsNull() {
            addCriterion("com_type is null");
            return (Criteria) this;
        }

        public Criteria andComTypeIsNotNull() {
            addCriterion("com_type is not null");
            return (Criteria) this;
        }

        public Criteria andComTypeEqualTo(String value) {
            addCriterion("com_type =", value, "comType");
            return (Criteria) this;
        }

        public Criteria andComTypeNotEqualTo(String value) {
            addCriterion("com_type <>", value, "comType");
            return (Criteria) this;
        }

        public Criteria andComTypeGreaterThan(String value) {
            addCriterion("com_type >", value, "comType");
            return (Criteria) this;
        }

        public Criteria andComTypeGreaterThanOrEqualTo(String value) {
            addCriterion("com_type >=", value, "comType");
            return (Criteria) this;
        }

        public Criteria andComTypeLessThan(String value) {
            addCriterion("com_type <", value, "comType");
            return (Criteria) this;
        }

        public Criteria andComTypeLessThanOrEqualTo(String value) {
            addCriterion("com_type <=", value, "comType");
            return (Criteria) this;
        }

        public Criteria andComTypeLike(String value) {
            addCriterion("com_type like", value, "comType");
            return (Criteria) this;
        }

        public Criteria andComTypeNotLike(String value) {
            addCriterion("com_type not like", value, "comType");
            return (Criteria) this;
        }

        public Criteria andComTypeIn(List<String> values) {
            addCriterion("com_type in", values, "comType");
            return (Criteria) this;
        }

        public Criteria andComTypeNotIn(List<String> values) {
            addCriterion("com_type not in", values, "comType");
            return (Criteria) this;
        }

        public Criteria andComTypeBetween(String value1, String value2) {
            addCriterion("com_type between", value1, value2, "comType");
            return (Criteria) this;
        }

        public Criteria andComTypeNotBetween(String value1, String value2) {
            addCriterion("com_type not between", value1, value2, "comType");
            return (Criteria) this;
        }

        public Criteria andPosIdIsNull() {
            addCriterion("pos_id is null");
            return (Criteria) this;
        }

        public Criteria andPosIdIsNotNull() {
            addCriterion("pos_id is not null");
            return (Criteria) this;
        }

        public Criteria andPosIdEqualTo(Integer value) {
            addCriterion("pos_id =", value, "posId");
            return (Criteria) this;
        }

        public Criteria andPosIdNotEqualTo(Integer value) {
            addCriterion("pos_id <>", value, "posId");
            return (Criteria) this;
        }

        public Criteria andPosIdGreaterThan(Integer value) {
            addCriterion("pos_id >", value, "posId");
            return (Criteria) this;
        }

        public Criteria andPosIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("pos_id >=", value, "posId");
            return (Criteria) this;
        }

        public Criteria andPosIdLessThan(Integer value) {
            addCriterion("pos_id <", value, "posId");
            return (Criteria) this;
        }

        public Criteria andPosIdLessThanOrEqualTo(Integer value) {
            addCriterion("pos_id <=", value, "posId");
            return (Criteria) this;
        }

        public Criteria andPosIdIn(List<Integer> values) {
            addCriterion("pos_id in", values, "posId");
            return (Criteria) this;
        }

        public Criteria andPosIdNotIn(List<Integer> values) {
            addCriterion("pos_id not in", values, "posId");
            return (Criteria) this;
        }

        public Criteria andPosIdBetween(Integer value1, Integer value2) {
            addCriterion("pos_id between", value1, value2, "posId");
            return (Criteria) this;
        }

        public Criteria andPosIdNotBetween(Integer value1, Integer value2) {
            addCriterion("pos_id not between", value1, value2, "posId");
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