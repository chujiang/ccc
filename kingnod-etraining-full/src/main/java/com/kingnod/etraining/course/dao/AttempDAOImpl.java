package com.kingnod.etraining.course.dao;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.dao.MybatisEntityDAO;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.etraining.course.entity.Attemp;
import com.kingnod.etraining.course.entity.SCOPerformance;

@org.springframework.stereotype.Repository

    @com.kingnod.core.annotation.Generated("2012-02-06 17:03")
public class AttempDAOImpl extends MybatisEntityDAO<Attemp, Long> implements AttempDAO {


  
  /*public String queryLessonLocationBySCOId(Long courseId, Long scoId, Long userId){
    
    CriteriaBuilder cb=Cnd.builder();
    Cnd.builder().andEQ("A.COURSE_ID",courseId);
    Cnd.builder().andEQ("A.SCO_ID",scoId);
 
    
  }
  
  public int updateLessonLocationBySCOId(Long courseId, Long scoId, Long userId, String value){
    
   CriteriaBuilder cb=Cnd.builder();
    Cnd.builder().andEQ("A.COURSE_ID",courseId);
    Cnd.builder().andEQ("A.SCO_ID",scoId);
    Cnd.builder().andEQ("A.LAUNCH_LOCATION",value);
  
    
  }*/
  
}