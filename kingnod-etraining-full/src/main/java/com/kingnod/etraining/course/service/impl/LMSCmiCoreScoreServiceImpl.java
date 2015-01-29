package com.kingnod.etraining.course.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.util.SecurityUtils;
import com.kingnod.etraining.course.dao.AttempDAO;
import com.kingnod.etraining.course.dao.SCOPerformanceDAO;
import com.kingnod.etraining.course.entity.Attemp;
import com.kingnod.etraining.course.entity.SCOPerformance;
import com.kingnod.etraining.course.exception.LMSException;
import com.kingnod.etraining.course.service.LMSCmiCoreScoreService;
import com.kingnod.etraining.security.entity.UserAccount;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

@org.springframework.stereotype.Service
public class LMSCmiCoreScoreServiceImpl implements LMSCmiCoreScoreService {

  protected static Logger log = LoggerFactory.getLogger(LMSCmiCoreScoreServiceImpl.class);
  
  
  @Autowired
  protected AttempDAO  attempDAO;
  
  @Autowired
  protected SCOPerformanceDAO  scoPerformanceDAO;
  
  
  
  public String getChildren(Long courseId, Long scoId, Long userId) throws LMSException {
    return "raw,max,min";
  }

  public String getRaw(Long courseId, Long scoId, Long userId) throws LMSException {
    
    UserAccount userDetails = SecurityUtils.getCurrentUser();
    String score="";
   // Long attempId = (Long)userDetails.getAttribute("attempId");
    ///Attemp attemp =   attempDAO.get(attempId);
    //查询sco的分数
    CriteriaBuilder cb=Cnd.builder(SCOPerformance.class);
    cb.andEQ("courseId",courseId);
    cb.andEQ("scoId",scoId);
    cb.andEQ("userId",userId);
    
    List<SCOPerformance> list = scoPerformanceDAO.findByCriteria(cb.buildCriteria());
    if(list.size()>0){
      SCOPerformance bean= list.get(0);
      score=  bean.getScore()+"";
    }
     return score;
  }

  public void setRaw(Long courseId, Long scoId, Long userId, String value) throws LMSException {
    UserAccount userDetails = SecurityUtils.getCurrentUser();
    Long attempId = (Long)userDetails.getAttribute("attempId");
    
    Attemp attemp = new Attemp();
    attemp.setId(attempId);
    BigDecimal maxScore =new BigDecimal(0);
    
      if(value!=null&&!"".equals(value)){
        maxScore =new BigDecimal(value);
      }
    attemp.setRawScore(maxScore);
    
    attempDAO.update(attemp);

  }

  public String getMax(Long courseId, Long scoId, Long userId) throws LMSException {
    UserAccount userDetails = SecurityUtils.getCurrentUser();
    //Long attempId = (Long)userDetails.getAttribute("attempId");
    //Attemp attemp =   attempDAO.get(attempId);
    
    String score="";
    CriteriaBuilder cb=Cnd.builder(SCOPerformance.class);
    cb.andEQ("courseId",courseId);
    cb.andEQ("scoId",scoId);
    cb.andEQ("userId",userId);
    
    List<SCOPerformance> list = scoPerformanceDAO.findByCriteria(cb.buildCriteria());
    if(list.size()>0){
      SCOPerformance bean= list.get(0);
      score=  bean.getScoreMax()+"";
    }
     return score;
     
     //return attemp.getScoreMax()+"";
  }

  public void setMax(Long courseId, Long scoId, Long userId, String value) throws LMSException {
    UserAccount userDetails = SecurityUtils.getCurrentUser();
    Long attempId = (Long)userDetails.getAttribute("attempId");
    
    Attemp attemp = new Attemp();
    attemp.setId(attempId);
    BigDecimal maxScore =new BigDecimal(0);
    
      if(value!=null&&!"".equals(value)){
        maxScore =new BigDecimal(value);
      }
    attemp.setRawScore(maxScore);
    
    attempDAO.update(attemp);
  }

  public String getMin(Long courseId, Long scoId, Long userId) throws LMSException {
    UserAccount userDetails = SecurityUtils.getCurrentUser();
   // Long attempId = (Long)userDetails.getAttribute("attempId");
    //Attemp attemp =   attempDAO.get(attempId);
     
     //return attemp.getScoreMin()+"";
     
     String score="";
     CriteriaBuilder cb=Cnd.builder(SCOPerformance.class);
     cb.andEQ("courseId",courseId);
     cb.andEQ("scoId",scoId);
     cb.andEQ("userId",userId);
     
     List<SCOPerformance> list = scoPerformanceDAO.findByCriteria(cb.buildCriteria());
     if(list.size()>0){
       SCOPerformance bean= list.get(0);
       score=  bean.getScoreMin()+"";
     }
      return score;
  }

  public void setMin(Long courseId, Long scoId, Long userId, String value) throws LMSException {
    UserAccount userDetails = SecurityUtils.getCurrentUser();
    Long attempId = (Long)userDetails.getAttribute("attempId");
    
    Attemp attemp = new Attemp();
    attemp.setId(attempId);
    BigDecimal maxScore =new BigDecimal(0);
    
      if(value!=null&&!"".equals(value)){
        maxScore =new BigDecimal(value);
      }
      
    attemp.setScoreMin(maxScore);
    
    attempDAO.update(attemp);

  }

}
