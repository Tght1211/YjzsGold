package com.yjzs.gold.com.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TPostsExample {
    protected String orderByClause;

     // 排除
    protected boolean distinct;

    // 排序
    protected List<Criteria> oredCriteria;

    public TPostsExample() {
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

        public Criteria andPosTitleIsNull() {
            addCriterion("pos_title is null");
            return (Criteria) this;
        }

        public Criteria andPosTitleIsNotNull() {
            addCriterion("pos_title is not null");
            return (Criteria) this;
        }

        public Criteria andPosTitleEqualTo(String value) {
            addCriterion("pos_title =", value, "posTitle");
            return (Criteria) this;
        }

        public Criteria andPosTitleNotEqualTo(String value) {
            addCriterion("pos_title <>", value, "posTitle");
            return (Criteria) this;
        }

        public Criteria andPosTitleGreaterThan(String value) {
            addCriterion("pos_title >", value, "posTitle");
            return (Criteria) this;
        }

        public Criteria andPosTitleGreaterThanOrEqualTo(String value) {
            addCriterion("pos_title >=", value, "posTitle");
            return (Criteria) this;
        }

        public Criteria andPosTitleLessThan(String value) {
            addCriterion("pos_title <", value, "posTitle");
            return (Criteria) this;
        }

        public Criteria andPosTitleLessThanOrEqualTo(String value) {
            addCriterion("pos_title <=", value, "posTitle");
            return (Criteria) this;
        }

        public Criteria andPosTitleLike(String value) {
            addCriterion("pos_title like", value, "posTitle");
            return (Criteria) this;
        }

        public Criteria andPosTitleNotLike(String value) {
            addCriterion("pos_title not like", value, "posTitle");
            return (Criteria) this;
        }

        public Criteria andPosTitleIn(List<String> values) {
            addCriterion("pos_title in", values, "posTitle");
            return (Criteria) this;
        }

        public Criteria andPosTitleNotIn(List<String> values) {
            addCriterion("pos_title not in", values, "posTitle");
            return (Criteria) this;
        }

        public Criteria andPosTitleBetween(String value1, String value2) {
            addCriterion("pos_title between", value1, value2, "posTitle");
            return (Criteria) this;
        }

        public Criteria andPosTitleNotBetween(String value1, String value2) {
            addCriterion("pos_title not between", value1, value2, "posTitle");
            return (Criteria) this;
        }

        public Criteria andPosContentIsNull() {
            addCriterion("pos_content is null");
            return (Criteria) this;
        }

        public Criteria andPosContentIsNotNull() {
            addCriterion("pos_content is not null");
            return (Criteria) this;
        }

        public Criteria andPosContentEqualTo(String value) {
            addCriterion("pos_content =", value, "posContent");
            return (Criteria) this;
        }

        public Criteria andPosContentNotEqualTo(String value) {
            addCriterion("pos_content <>", value, "posContent");
            return (Criteria) this;
        }

        public Criteria andPosContentGreaterThan(String value) {
            addCriterion("pos_content >", value, "posContent");
            return (Criteria) this;
        }

        public Criteria andPosContentGreaterThanOrEqualTo(String value) {
            addCriterion("pos_content >=", value, "posContent");
            return (Criteria) this;
        }

        public Criteria andPosContentLessThan(String value) {
            addCriterion("pos_content <", value, "posContent");
            return (Criteria) this;
        }

        public Criteria andPosContentLessThanOrEqualTo(String value) {
            addCriterion("pos_content <=", value, "posContent");
            return (Criteria) this;
        }

        public Criteria andPosContentLike(String value) {
            addCriterion("pos_content like", value, "posContent");
            return (Criteria) this;
        }

        public Criteria andPosContentNotLike(String value) {
            addCriterion("pos_content not like", value, "posContent");
            return (Criteria) this;
        }

        public Criteria andPosContentIn(List<String> values) {
            addCriterion("pos_content in", values, "posContent");
            return (Criteria) this;
        }

        public Criteria andPosContentNotIn(List<String> values) {
            addCriterion("pos_content not in", values, "posContent");
            return (Criteria) this;
        }

        public Criteria andPosContentBetween(String value1, String value2) {
            addCriterion("pos_content between", value1, value2, "posContent");
            return (Criteria) this;
        }

        public Criteria andPosContentNotBetween(String value1, String value2) {
            addCriterion("pos_content not between", value1, value2, "posContent");
            return (Criteria) this;
        }

        public Criteria andPosDateIsNull() {
            addCriterion("pos_date is null");
            return (Criteria) this;
        }

        public Criteria andPosDateIsNotNull() {
            addCriterion("pos_date is not null");
            return (Criteria) this;
        }

        public Criteria andPosDateEqualTo(Date value) {
            addCriterion("pos_date =", value, "posDate");
            return (Criteria) this;
        }

        public Criteria andPosDateNotEqualTo(Date value) {
            addCriterion("pos_date <>", value, "posDate");
            return (Criteria) this;
        }

        public Criteria andPosDateGreaterThan(Date value) {
            addCriterion("pos_date >", value, "posDate");
            return (Criteria) this;
        }

        public Criteria andPosDateGreaterThanOrEqualTo(Date value) {
            addCriterion("pos_date >=", value, "posDate");
            return (Criteria) this;
        }

        public Criteria andPosDateLessThan(Date value) {
            addCriterion("pos_date <", value, "posDate");
            return (Criteria) this;
        }

        public Criteria andPosDateLessThanOrEqualTo(Date value) {
            addCriterion("pos_date <=", value, "posDate");
            return (Criteria) this;
        }

        public Criteria andPosDateIn(List<Date> values) {
            addCriterion("pos_date in", values, "posDate");
            return (Criteria) this;
        }

        public Criteria andPosDateNotIn(List<Date> values) {
            addCriterion("pos_date not in", values, "posDate");
            return (Criteria) this;
        }

        public Criteria andPosDateBetween(Date value1, Date value2) {
            addCriterion("pos_date between", value1, value2, "posDate");
            return (Criteria) this;
        }

        public Criteria andPosDateNotBetween(Date value1, Date value2) {
            addCriterion("pos_date not between", value1, value2, "posDate");
            return (Criteria) this;
        }

        public Criteria andPosHotIsNull() {
            addCriterion("pos_hot is null");
            return (Criteria) this;
        }

        public Criteria andPosHotIsNotNull() {
            addCriterion("pos_hot is not null");
            return (Criteria) this;
        }

        public Criteria andPosHotEqualTo(Integer value) {
            addCriterion("pos_hot =", value, "posHot");
            return (Criteria) this;
        }

        public Criteria andPosHotNotEqualTo(Integer value) {
            addCriterion("pos_hot <>", value, "posHot");
            return (Criteria) this;
        }

        public Criteria andPosHotGreaterThan(Integer value) {
            addCriterion("pos_hot >", value, "posHot");
            return (Criteria) this;
        }

        public Criteria andPosHotGreaterThanOrEqualTo(Integer value) {
            addCriterion("pos_hot >=", value, "posHot");
            return (Criteria) this;
        }

        public Criteria andPosHotLessThan(Integer value) {
            addCriterion("pos_hot <", value, "posHot");
            return (Criteria) this;
        }

        public Criteria andPosHotLessThanOrEqualTo(Integer value) {
            addCriterion("pos_hot <=", value, "posHot");
            return (Criteria) this;
        }

        public Criteria andPosHotIn(List<Integer> values) {
            addCriterion("pos_hot in", values, "posHot");
            return (Criteria) this;
        }

        public Criteria andPosHotNotIn(List<Integer> values) {
            addCriterion("pos_hot not in", values, "posHot");
            return (Criteria) this;
        }

        public Criteria andPosHotBetween(Integer value1, Integer value2) {
            addCriterion("pos_hot between", value1, value2, "posHot");
            return (Criteria) this;
        }

        public Criteria andPosHotNotBetween(Integer value1, Integer value2) {
            addCriterion("pos_hot not between", value1, value2, "posHot");
            return (Criteria) this;
        }

        public Criteria andPosStatusIsNull() {
            addCriterion("pos_status is null");
            return (Criteria) this;
        }

        public Criteria andPosStatusIsNotNull() {
            addCriterion("pos_status is not null");
            return (Criteria) this;
        }

        public Criteria andPosStatusEqualTo(String value) {
            addCriterion("pos_status =", value, "posStatus");
            return (Criteria) this;
        }

        public Criteria andPosStatusNotEqualTo(String value) {
            addCriterion("pos_status <>", value, "posStatus");
            return (Criteria) this;
        }

        public Criteria andPosStatusGreaterThan(String value) {
            addCriterion("pos_status >", value, "posStatus");
            return (Criteria) this;
        }

        public Criteria andPosStatusGreaterThanOrEqualTo(String value) {
            addCriterion("pos_status >=", value, "posStatus");
            return (Criteria) this;
        }

        public Criteria andPosStatusLessThan(String value) {
            addCriterion("pos_status <", value, "posStatus");
            return (Criteria) this;
        }

        public Criteria andPosStatusLessThanOrEqualTo(String value) {
            addCriterion("pos_status <=", value, "posStatus");
            return (Criteria) this;
        }

        public Criteria andPosStatusLike(String value) {
            addCriterion("pos_status like", value, "posStatus");
            return (Criteria) this;
        }

        public Criteria andPosStatusNotLike(String value) {
            addCriterion("pos_status not like", value, "posStatus");
            return (Criteria) this;
        }

        public Criteria andPosStatusIn(List<String> values) {
            addCriterion("pos_status in", values, "posStatus");
            return (Criteria) this;
        }

        public Criteria andPosStatusNotIn(List<String> values) {
            addCriterion("pos_status not in", values, "posStatus");
            return (Criteria) this;
        }

        public Criteria andPosStatusBetween(String value1, String value2) {
            addCriterion("pos_status between", value1, value2, "posStatus");
            return (Criteria) this;
        }

        public Criteria andPosStatusNotBetween(String value1, String value2) {
            addCriterion("pos_status not between", value1, value2, "posStatus");
            return (Criteria) this;
        }

        public Criteria andPosTypeIsNull() {
            addCriterion("pos_type is null");
            return (Criteria) this;
        }

        public Criteria andPosTypeIsNotNull() {
            addCriterion("pos_type is not null");
            return (Criteria) this;
        }

        public Criteria andPosTypeEqualTo(String value) {
            addCriterion("pos_type =", value, "posType");
            return (Criteria) this;
        }

        public Criteria andPosTypeNotEqualTo(String value) {
            addCriterion("pos_type <>", value, "posType");
            return (Criteria) this;
        }

        public Criteria andPosTypeGreaterThan(String value) {
            addCriterion("pos_type >", value, "posType");
            return (Criteria) this;
        }

        public Criteria andPosTypeGreaterThanOrEqualTo(String value) {
            addCriterion("pos_type >=", value, "posType");
            return (Criteria) this;
        }

        public Criteria andPosTypeLessThan(String value) {
            addCriterion("pos_type <", value, "posType");
            return (Criteria) this;
        }

        public Criteria andPosTypeLessThanOrEqualTo(String value) {
            addCriterion("pos_type <=", value, "posType");
            return (Criteria) this;
        }

        public Criteria andPosTypeLike(String value) {
            addCriterion("pos_type like", value, "posType");
            return (Criteria) this;
        }

        public Criteria andPosTypeNotLike(String value) {
            addCriterion("pos_type not like", value, "posType");
            return (Criteria) this;
        }

        public Criteria andPosTypeIn(List<String> values) {
            addCriterion("pos_type in", values, "posType");
            return (Criteria) this;
        }

        public Criteria andPosTypeNotIn(List<String> values) {
            addCriterion("pos_type not in", values, "posType");
            return (Criteria) this;
        }

        public Criteria andPosTypeBetween(String value1, String value2) {
            addCriterion("pos_type between", value1, value2, "posType");
            return (Criteria) this;
        }

        public Criteria andPosTypeNotBetween(String value1, String value2) {
            addCriterion("pos_type not between", value1, value2, "posType");
            return (Criteria) this;
        }

        public Criteria andPosOffIsNull() {
            addCriterion("pos_off is null");
            return (Criteria) this;
        }

        public Criteria andPosOffIsNotNull() {
            addCriterion("pos_off is not null");
            return (Criteria) this;
        }

        public Criteria andPosOffEqualTo(String value) {
            addCriterion("pos_off =", value, "posOff");
            return (Criteria) this;
        }

        public Criteria andPosOffNotEqualTo(String value) {
            addCriterion("pos_off <>", value, "posOff");
            return (Criteria) this;
        }

        public Criteria andPosOffGreaterThan(String value) {
            addCriterion("pos_off >", value, "posOff");
            return (Criteria) this;
        }

        public Criteria andPosOffGreaterThanOrEqualTo(String value) {
            addCriterion("pos_off >=", value, "posOff");
            return (Criteria) this;
        }

        public Criteria andPosOffLessThan(String value) {
            addCriterion("pos_off <", value, "posOff");
            return (Criteria) this;
        }

        public Criteria andPosOffLessThanOrEqualTo(String value) {
            addCriterion("pos_off <=", value, "posOff");
            return (Criteria) this;
        }

        public Criteria andPosOffLike(String value) {
            addCriterion("pos_off like", value, "posOff");
            return (Criteria) this;
        }

        public Criteria andPosOffNotLike(String value) {
            addCriterion("pos_off not like", value, "posOff");
            return (Criteria) this;
        }

        public Criteria andPosOffIn(List<String> values) {
            addCriterion("pos_off in", values, "posOff");
            return (Criteria) this;
        }

        public Criteria andPosOffNotIn(List<String> values) {
            addCriterion("pos_off not in", values, "posOff");
            return (Criteria) this;
        }

        public Criteria andPosOffBetween(String value1, String value2) {
            addCriterion("pos_off between", value1, value2, "posOff");
            return (Criteria) this;
        }

        public Criteria andPosOffNotBetween(String value1, String value2) {
            addCriterion("pos_off not between", value1, value2, "posOff");
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