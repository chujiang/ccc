package com.kingnod.etraining.course.dao;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.dao.MybatisEntityDAO;
import com.kingnod.etraining.course.entity.CourseEvaluation;

@org.springframework.stereotype.Repository

    @com.kingnod.core.annotation.Generated("2012-04-10 14:20")
public class CourseEvaluationDAOImpl extends MybatisEntityDAO<CourseEvaluation, Long> implements CourseEvaluationDAO {

	public int getSumByCourseId(Criteria criteria) {
		// TODO Auto-generated method stub
		return (Integer)getSqlSession().selectOne(sqlId("countByUser"), criteria);
	}


}