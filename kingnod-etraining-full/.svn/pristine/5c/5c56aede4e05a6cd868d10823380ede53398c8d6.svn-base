package com.kingnod.etraining.course.service;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.course.entity.CourseInfo;
import com.kingnod.etraining.course.entity.ItemInfo;
import com.kingnod.etraining.course.entity.Performance;
import com.kingnod.etraining.course.entity.SCOPerformance;


    @com.kingnod.core.annotation.Generated("2012-02-07 16:17")
public interface PerformanceService {

    
    @com.kingnod.core.annotation.Generated("2012-02-07 16:17")
    Performance getPerformance(Long id);

    
    @com.kingnod.core.annotation.Generated("2012-02-07 16:17")
    int savePerformance(Performance performance);

    
    @com.kingnod.core.annotation.Generated("2012-02-07 16:17")
    int deletePerformance(Performance performance);

    
    @com.kingnod.core.annotation.Generated("2012-02-07 16:17")
    int deletePerformanceByIds(Long[] ids);

    
    @com.kingnod.core.annotation.Generated("2012-02-07 16:17")
    PagingResult<Performance> findPerformance(Criteria criteria);
    
    
    //初始化时调用
    int initPerformance(Long acivityId,Long courseId,Long userId);
    
    //完成时调用
    int finishPerformance(Long acivityId,Long courseId,Long userId);
    
    //获取启动的章节
    ItemInfo getLaunchSCO(Long courseId,Long userId);
    
    //课程信息:获取导航模式,name
    CourseInfo getCourseInfoById(Long courseId);
    
    //增加活动在线人数
    void addOnlineCount(Long activityId);
    
   //减少活动在线人数
    void minusOnlineCount(Long activityId);
}