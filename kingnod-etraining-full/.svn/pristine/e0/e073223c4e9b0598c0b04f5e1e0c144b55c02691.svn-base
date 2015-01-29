package com.kingnod.etraining.course.dao;

import java.math.BigDecimal;
import java.util.List;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.dao.EntityDAO;
import com.kingnod.etraining.course.entity.SCOPerformance;


    @com.kingnod.core.annotation.Generated("2012-02-06 17:03")
public interface SCOPerformanceDAO extends EntityDAO<SCOPerformance, Long> {

      int updateBySCOId(SCOPerformance scPoerformance);

      //得到TotalTime
      String queryTotalTime(Long courseId, Long scoId, Long userId);
      
      //查询用户一门课程的sco所有信息
      //List<SCOPerformance> findUserAllScoInfoByCriteria(Criteria c);
      
      //统计学习时间
      int countByTatalTimeCriteria(Criteria c);
      
      //查询最大分数
      BigDecimal queryMaxScoreByCriteria(Criteria c);
}