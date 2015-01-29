package com.kingnod.etraining.activity.dao;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.dao.MybatisEntityDAO;
import com.kingnod.etraining.activity.entity.TrainingPlanItem;

@org.springframework.stereotype.Repository

    @com.kingnod.core.annotation.Generated("2012-02-08 17:20")
public class TrainingPlanItemDAOImpl extends MybatisEntityDAO<TrainingPlanItem, Long> implements TrainingPlanItemDAO {

	public Integer sumCostByCriteria(Criteria criteria) {
		return (Integer)getSqlSession().selectOne(sqlId("sumCostByCriteria"), criteria);
	}

	public Integer sumLessonsByCriteria(Criteria criteria) {
		return (Integer)getSqlSession().selectOne(sqlId("sumLessonsByCriteria"), criteria);
	}

	public Integer sumLearnerNumberByCriteria(Criteria criteria) {
		return (Integer)getSqlSession().selectOne(sqlId("sumLearnerNumberByCriteria"), criteria);
	}


}