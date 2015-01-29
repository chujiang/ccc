package com.kingnod.etraining.activity.service;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.activity.entity.UserActivity;
import com.kingnod.etraining.activity.entity.UserActivitySummary;


    @com.kingnod.core.annotation.Generated("2012-03-20 11:03")
public interface UserActivityService {
public PagingResult<UserActivitySummary> findUserActivitiesByCriteria(Criteria criteria);

    UserActivity getUserActivity(Long id);

    int saveUserActivity(UserActivity userActivity);
    
    int findActivitiesByCategoryCount(Criteria criteria);
    
    int deleteUserActivity(UserActivity userActivity);
    
    int deleteUserActivityByIds(Long[] ids);
    
    PagingResult<UserActivity> findUserActivity(Criteria criteria);
    
    //根据课程分类查找活动
    PagingResult<UserActivitySummary> findUserActivitiesByCriteriaCategory(Criteria criteria);
    
    /**
     * 根据活动Id获取UserActivity
     * @param activityId
     * @return boolean
     */
    UserActivity getUserActivityByActId(Long activityId);
   
}