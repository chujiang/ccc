package com.kingnod.etraining.activity.dao;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.dao.EntityDAO;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.activity.entity.UserActivity;
import com.kingnod.etraining.activity.entity.UserActivitySummary;


    @com.kingnod.core.annotation.Generated("2012-03-13 18:40")
public interface UserActivityDAO extends EntityDAO<UserActivity, Long> {
    	
    	public int findUserActivitiesCount(Criteria criteria);
    	
    	public PagingResult<UserActivitySummary> findUserActivitiesByCriteria(Criteria criteria);
    	
    	//根据课程分类查找活动
    	 public PagingResult<UserActivitySummary> findUserActivitiesByCriteriaCaegory(Criteria criteria);
    	 
        /**
	     * 根据活动Id获取UserActivity
	     * @param activityId
	     * @return UserActivity
	     */
	    public UserActivity getUserActivityByActId(Long activityId);
}