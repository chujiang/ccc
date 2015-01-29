package com.kingnod.etraining.activity.dao;

import java.util.List;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.dao.EntityDAO;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.activity.entity.Activity;
import com.kingnod.etraining.activity.entity.ActivityDetails;
import com.kingnod.etraining.common.ObjectType;


    @com.kingnod.core.annotation.Generated("2012-03-13 18:12")
public interface ActivityDAO extends EntityDAO<Activity, Long> {
    	
    	public List<ActivityDetails> findNewActivityList(Criteria criteria);
    	
    	public List<ActivityDetails> findGradeActivityList(Criteria criteria);
    	
    	public PagingResult<ActivityDetails>  findGradeActivityPagerCourseInfos(Criteria criteria);
    	
    	public PagingResult<ActivityDetails>  findNewActivityPagerCourseInfos(Criteria criteria);

}