package com.kingnod.etraining.activity.service;

import java.util.List;
import java.util.Map;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.pager.Pager;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.activity.entity.ActivityDetails;
import com.kingnod.etraining.activity.entity.Elearning;
import com.kingnod.etraining.activity.entity.UserActivitySummary;
import com.kingnod.etraining.common.ObjectType;


    @com.kingnod.core.annotation.Generated("2012-03-13 18:12")
public interface ActivityService {

    
    @com.kingnod.core.annotation.Generated("2012-03-13 18:12")
    ActivityDetails get(ObjectType activityType, Long activityId);

    
    @com.kingnod.core.annotation.Generated("2012-03-13 18:12")
    int saveActivity(ActivityDetails activity);

    @com.kingnod.core.annotation.Generated("2012-03-13 18:12")
    int saveActivities(List<ActivityDetails> entities);
    
    @com.kingnod.core.annotation.Generated("2012-03-13 18:12")
    int deleteActivity(ActivityDetails... entities);

    
    @com.kingnod.core.annotation.Generated("2012-03-13 18:12")
    int deleteActivityByIds(String activityType, Long... activityId);

    
    @com.kingnod.core.annotation.Generated("2012-03-13 18:12")
    PagingResult<ActivityDetails> findActivity(Criteria criteria);
    
    List<ActivityDetails> findActivityByCriteria(Criteria criteria);
    
    PagingResult<ActivityDetails> findActivityByCourseId(Long courseId,Pager<ActivityDetails> pager);
    
    //更新课程的注册状态，主要针对选修和必修
    int setEnrollStatusEnrolled(Long userId,Long activityId);
    
    int logoutEnrollStatusEnrolled(Long userId,Long activityId);
    // 根据关键字搜索所有活动
   // PagingResult<UserActivitySummary> searchAllActivity(Long userId,String keyWord);
}