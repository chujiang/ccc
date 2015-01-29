package com.kingnod.etraining.activity.dao;

import java.util.List;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.dao.MybatisEntityDAO;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.activity.entity.ActivityDetails;
import com.kingnod.etraining.activity.entity.RecommendObject;
import com.kingnod.etraining.course.entity.CourseInfo;

@org.springframework.stereotype.Repository

    @com.kingnod.core.annotation.Generated("2012-04-21 12:48")
public class RecommendObjectDAOImpl extends MybatisEntityDAO<RecommendObject, Long> implements RecommendObjectDAO {

	public List<ActivityDetails> findRecommendCourseInfos(Criteria criteria) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("findCourseInfo", criteria);
	}

	public PagingResult<ActivityDetails> findRecommendPagerCourseInfos(
			Criteria criteria) {
		// TODO Auto-generated method stub
		return pagingQuery("countCoursInfoByCriteria", "findCourseInfo", criteria);
	}


}