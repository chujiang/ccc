package com.kingnod.etraining.course.dao;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.dao.EntityDAO;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.course.entity.CourseInfo;


    @com.kingnod.core.annotation.Generated("2012-02-17 10:47")
public interface CourseInfoDAO extends EntityDAO<CourseInfo, Long> {
    	
    	PagingResult<CourseInfo> findPagingResultByCategory(Criteria criteria, Long categoryId, String category);

}