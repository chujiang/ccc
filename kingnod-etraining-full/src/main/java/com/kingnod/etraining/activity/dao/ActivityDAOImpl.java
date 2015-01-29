package com.kingnod.etraining.activity.dao;

import java.util.List;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.dao.MybatisEntityDAO;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.activity.entity.Activity;
import com.kingnod.etraining.activity.entity.ActivityDetails;
import com.kingnod.etraining.common.ObjectType;

@org.springframework.stereotype.Repository

    @com.kingnod.core.annotation.Generated("2012-03-13 18:12")
public class ActivityDAOImpl extends MybatisEntityDAO<Activity, Long> implements ActivityDAO {

	public List<ActivityDetails> findNewActivityList(Criteria criteria) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("findNewActivity",criteria);
	}

	public List<ActivityDetails> findGradeActivityList(Criteria criteria) {
		// TODO Auto-generated method stub
		
		return getSqlSession().selectList("findGradeActivity",criteria);
	}

	public PagingResult<ActivityDetails> findGradeActivityPagerCourseInfos(
			Criteria criteria) {
		// TODO Auto-generated method stub
		return pagingQuery("countFindGradeActivityByCriteria", "findGradeActivity", criteria);
	}

	public PagingResult<ActivityDetails> findNewActivityPagerCourseInfos(
			Criteria criteria) {
		// TODO Auto-generated method stub
		return pagingQuery("countFindNewActivityByCriteria", "findNewActivity", criteria);
	}


}