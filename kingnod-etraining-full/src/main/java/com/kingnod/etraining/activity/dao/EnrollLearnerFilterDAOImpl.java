package com.kingnod.etraining.activity.dao;

import java.util.List;
import java.util.Map;

import com.kingnod.core.dao.MybatisEntityDAO;
import com.kingnod.core.util.collection.MapUtils;
import com.kingnod.etraining.activity.entity.EnrollLearnerFilter;
import com.kingnod.etraining.common.ObjectType;

@org.springframework.stereotype.Repository

    @com.kingnod.core.annotation.Generated("2012-03-08 10:55")
public class EnrollLearnerFilterDAOImpl extends MybatisEntityDAO<EnrollLearnerFilter, Long> implements EnrollLearnerFilterDAO {

	public Long getGroupNumber() {
		return (Long) getSqlSession().selectOne(sqlId("getGroupNumber"));
	}

	public void mergeCondition(Map ids) {
		getSqlSession().update(sqlId("mergeCondition"),ids);
	}

	public List<EnrollLearnerFilter> findByActivityId(Long activityId, ObjectType objectType) {
		Map  params = MapUtils.mapByAarray("activityId",activityId,"activityType",objectType);
		return getSqlSession().selectList(sqlId("findByActivityId"), params);
	}

}