package com.kingnod.etraining.course.dao;

import com.kingnod.core.dao.EntityDAO;
import com.kingnod.etraining.course.entity.Performance;


    @com.kingnod.core.annotation.Generated("2012-02-06 17:02")
public interface PerformanceDAO extends EntityDAO<Performance, Long> {

      int updateByCourseId(Performance scPoerformance);
}