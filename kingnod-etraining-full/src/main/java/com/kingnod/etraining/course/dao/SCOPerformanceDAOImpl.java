package com.kingnod.etraining.course.dao;

import java.math.BigDecimal;
import java.util.List;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.dao.MybatisEntityDAO;
import com.kingnod.etraining.course.entity.SCOPerformance;

@org.springframework.stereotype.Repository

    @com.kingnod.core.annotation.Generated("2012-02-06 17:03")
public class SCOPerformanceDAOImpl extends MybatisEntityDAO<SCOPerformance, Long> implements SCOPerformanceDAO {


  public int updateBySCOId(SCOPerformance scPoerformance){
    
    CriteriaBuilder cb=Cnd.builder();
    Cnd.builder().andEQ("A.USER_ID",scPoerformance.getUserId());
    Cnd.builder().andEQ("A.COURSE_ID",scPoerformance.getCourseId());
    Cnd.builder().andEQ("A.SCO_ID",scPoerformance.getScoId());
    
    return getSqlSession().update(sqlId("updateByCriteria"),cb.buildCriteria());
  }
  
  
  public String queryTotalTime(Long courseId, Long scoId, Long userId){
    CriteriaBuilder cb=Cnd.builder();//后面删掉在外面实现
    cb.andEQ("A.COURSE_ID",courseId);
    cb.andEQ("A.SCO_ID",scoId);
    cb.andEQ("A.USER_ID",userId);
    
    SCOPerformance scoPerformance = (SCOPerformance)getSqlSession().selectOne(sqlId("updateByCriteria"),cb.buildCriteria());
     
     return scoPerformance.getTotalTime()+"";
  }
 
//查询用户一门课程的sco所有信息
/*  public List<SCOPerformance> findUserAllScoInfoByCriteria(Criteria c){

    List<SCOPerformance> list=getSqlSession().selectList(sqlId("findUserScoInfoByCriteria"),c);
    return list;
  }*/

  public int countByTatalTimeCriteria(Criteria c){

    return (Integer)getSqlSession().selectOne(sqlId("countByTatalTimeCriteria"), c);
  }
  
  
//查询最大分数
  public BigDecimal queryMaxScoreByCriteria(Criteria c){
    return (BigDecimal)getSqlSession().selectOne(sqlId("queryMaxScoreByCriteria"), c);
  }
  
}