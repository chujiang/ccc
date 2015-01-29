package com.kingnod.etraining.activity.dao;

import java.util.List;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.dao.EntityDAO;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.activity.entity.ActivityDetails;
import com.kingnod.etraining.activity.entity.RecommendObject;
import com.kingnod.etraining.course.entity.CourseInfo;


    @com.kingnod.core.annotation.Generated("2012-04-21 12:48")
public interface RecommendObjectDAO extends EntityDAO<RecommendObject, Long> {

		List<ActivityDetails> findRecommendCourseInfos(Criteria criteria);
		
		PagingResult<ActivityDetails> findRecommendPagerCourseInfos(Criteria criteria);

}