package com.kingnod.etraining.course.service;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.course.entity.CourseInfo;


    @com.kingnod.core.annotation.Generated("2012-02-17 10:47")
public interface CourseInfoService {

    
    @com.kingnod.core.annotation.Generated("2012-02-17 10:47")
    CourseInfo getCourseInfo(Long id);

    
    @com.kingnod.core.annotation.Generated("2012-02-17 10:47")
    int saveCourseInfo(CourseInfo courseInfo);

    
    @com.kingnod.core.annotation.Generated("2012-02-17 10:47")
    int deleteCourseInfo(CourseInfo courseInfo);

    
    @com.kingnod.core.annotation.Generated("2012-02-17 10:47")
    int deleteCourseInfoByIds(Long[] ids);

    
    @com.kingnod.core.annotation.Generated("2012-02-17 10:47")
    PagingResult<CourseInfo> findCourseInfo(Criteria criteria);
    
    /**
     * 根据课程类别查找
     * @param criteria
     * @param category
     * @return
     */
    PagingResult<CourseInfo> findCourseInfoByCategory(Criteria criteria, Long categoryId, String category);
    
    /**
     * 根据活动ID查找课程ID
     * @param acivityId
     * @return Long
     */
    Long findCourseIdByAcivityId(Long acivityId);
    
    int updateCourseByCourseId(Long id,String status);
    
   
    
}