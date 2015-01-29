package com.kingnod.etraining.course.dao;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.dao.MybatisEntityDAO;
import com.kingnod.etraining.course.entity.Performance;

@org.springframework.stereotype.Repository

    @com.kingnod.core.annotation.Generated("2012-02-06 17:02")
public class PerformanceDAOImpl extends MybatisEntityDAO<Performance, Long> implements PerformanceDAO {

  public int updateByCourseId(Performance scPoerformance){
    
    CriteriaBuilder cb=Cnd.builder();
    Cnd.builder().andEQ("A.USER_ID",scPoerformance.getUserId());
    Cnd.builder().andEQ("A.COURSE_ID",scPoerformance.getCourseId());
    
    return getSqlSession().update(sqlId("updateByCriteria"),cb.buildCriteria());
    
  }

}