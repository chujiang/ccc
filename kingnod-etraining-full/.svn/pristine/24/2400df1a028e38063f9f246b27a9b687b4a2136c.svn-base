package com.kingnod.etraining.activity.dao;

import java.util.Map;

import com.kingnod.core.dao.MybatisEntityDAO;
import com.kingnod.core.util.collection.MapUtils;
import com.kingnod.etraining.activity.entity.EnrollLearner;
import com.kingnod.etraining.common.ObjectType;

@org.springframework.stereotype.Repository
@com.kingnod.core.annotation.Generated("2012-03-13 18:53")
public class EnrollLearnerDAOImpl extends MybatisEntityDAO<EnrollLearner, Long> implements EnrollLearnerDAO {

	public Long getSiteIdByActivityId(Long activityId,ObjectType objectType) {
		Map  params = MapUtils.mapByAarray("activityId",activityId,"activityType",objectType);
		return (Long) getSqlSession().selectOne(sqlId("getSiteIdByActivityId"),params);
	}

}