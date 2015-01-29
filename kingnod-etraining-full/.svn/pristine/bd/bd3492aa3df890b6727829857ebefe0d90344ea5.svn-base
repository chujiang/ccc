package com.kingnod.etraining.course.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.criteria.Order;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.util.SecurityUtils;
import com.kingnod.etraining.course.dao.AttempDAO;
import com.kingnod.etraining.course.dao.SCOPerformanceDAO;
import com.kingnod.etraining.course.entity.Attemp;
import com.kingnod.etraining.course.entity.SCOPerformance;
import com.kingnod.etraining.course.exception.LMSException;
import com.kingnod.etraining.course.service.LMSCmiCoreService;
import com.kingnod.etraining.course.utils.AbbreviateUtil;
import com.kingnod.etraining.course.utils.TimeUtil;
import com.kingnod.etraining.security.entity.UserAccount;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

@org.springframework.stereotype.Service
public class LMSCmiCoreServiceImpl implements LMSCmiCoreService {
  
  protected static Logger log = LoggerFactory.getLogger(LMSCmiCoreServiceImpl.class);
  
  @Autowired
  protected AttempDAO  attempDAO;
  
  @Autowired
  protected SCOPerformanceDAO  scoPerformanceDAO;
  
  
  public String getChildren(Long courseId, Long scoId, Long userId) throws LMSException {
    return "student_id,student_name,lesson_location,credit,lesson_status,entry,score,total_time,lesson_mode,exit,session_time";
  }

  public String getStudentId(Long courseId, Long scoId, Long userId) throws LMSException {
    
    return userId+"";
  }

  public String getStudentName(Long courseId, Long scoId, Long userId) throws LMSException {
    return SecurityUtils.getCurrentUserName();
  }

  public void setLessonLocation(Long courseId, Long scoId, Long userId, String value) throws LMSException {
    UserAccount userDetails = SecurityUtils.getCurrentUser();
    Long attempId = (Long)userDetails.getAttribute("attempId");
    
    Attemp attemp = new Attemp();
    attemp.setId(attempId);
    attemp.setLessonLocation(value);
    
    attempDAO.update(attemp);
  }

  public String getLessonLocation(Long courseId, Long scoId, Long userId) throws LMSException {
   
    UserAccount userDetails = SecurityUtils.getCurrentUser();
   // Long attempId = (Long)userDetails.getAttribute("attempId");
    //Attemp attemp =   attempDAO.get(attempId);
     
     //return attemp.getLessonLocation();
      String lessonLocation="";
    //查询sco的状态
      CriteriaBuilder cb=Cnd.builder(SCOPerformance.class);
      cb.andEQ("courseId",courseId);
      cb.andEQ("scoId",scoId);
      cb.andEQ("userId",userId);
      
      List<SCOPerformance> list = scoPerformanceDAO.findByCriteria(cb.buildCriteria());
      if(list.size()>0){
        SCOPerformance bean= list.get(0);
        lessonLocation= bean.getLessonLocation();
      }
      
      return lessonLocation;
  }

  public String getCredit(Long courseId, Long scoId, Long userId) throws LMSException {
    String credit="";
   
    CriteriaBuilder cb=Cnd.builder(SCOPerformance.class);
    cb.andEQ("userId", userId);
    cb.andEQ("courseId",courseId);
    cb.andEQ("scoId",scoId);
    List<SCOPerformance> scoPerformanceList = scoPerformanceDAO.findByCriteria(cb.buildCriteria());
    
    if(scoPerformanceList.size()>0){
      SCOPerformance scoPerformanceLast =scoPerformanceList.get(0);
      credit = AbbreviateUtil.expandCredit(scoPerformanceLast.getCredit());
    }
     
     return  credit;//attemp.get;
  }

  public void setLessonStatus(Long courseId, Long scoId, Long userId, String value) throws LMSException {
    log.debug("setLessonStatusLai="+value);
    UserAccount userDetails = SecurityUtils.getCurrentUser();
    Long attempId = (Long)userDetails.getAttribute("attempId");
    
    Attemp attemp = new Attemp();
    attemp.setId(attempId);
    String status= AbbreviateUtil.abbreviateStatus(value);
    attemp.setRawStatus(status);
    
    attempDAO.update(attemp);
  }

  public String getLessonStatus(Long courseId, Long scoId, Long userId) throws LMSException {
   UserAccount userDetails = SecurityUtils.getCurrentUser();
    //Long attempId = (Long)userDetails.getAttribute("attempId");
    //Attemp attemp =   attempDAO.get(attempId);
   String lessonStatus="";
 //查询sco的状态
   CriteriaBuilder cb=Cnd.builder(SCOPerformance.class);
   cb.andEQ("courseId",courseId);
   cb.andEQ("scoId",scoId);
   cb.andEQ("userId",userId);
   
   List<SCOPerformance> list = scoPerformanceDAO.findByCriteria(cb.buildCriteria());
   if(list.size()>0){
     SCOPerformance bean= list.get(0);
     lessonStatus= AbbreviateUtil.expandStatus(bean.getStatus());
   }

     return lessonStatus;
  }

  public String getEntry(Long courseId, Long scoId, Long userId) throws LMSException {
    UserAccount userDetails = SecurityUtils.getCurrentUser();
    Long attempId = (Long)userDetails.getAttribute("attempId");
    Attemp attemp =   attempDAO.get(attempId);
     return attemp.getEntryStatus();
  }

  public String getTotalTime(Long courseId, Long scoId, Long userId) throws LMSException {

    scoPerformanceDAO.queryTotalTime(courseId,  scoId, userId);
    
    return "";
  }

  public String getLessonMode(Long courseId, Long scoId, Long userId) throws LMSException {
    UserAccount userDetails = SecurityUtils.getCurrentUser();
    Long attempId = (Long)userDetails.getAttribute("attempId");
    Attemp attemp =   attempDAO.get(attempId);
    String lessonMode = AbbreviateUtil.expandLessonMode(attemp.getLessonMode());
     
     return lessonMode;
  }

  public void setExit(Long courseId, Long scoId, Long userId, String value) throws LMSException {
    UserAccount userDetails = SecurityUtils.getCurrentUser();
    Long attempId = (Long)userDetails.getAttribute("attempId");
    
    Attemp attemp = new Attemp();
    attemp.setId(attempId);
    String exit= AbbreviateUtil.abbreviateExit(value);
    
    attemp.setExitMode(exit);
    
    //后面需完善 如果为非suspend entry值设为空
    
    attempDAO.update(attemp);
  }

  public void setSessionTime(Long courseId, Long scoId, Long userId, String value) throws LMSException {
    
    //log.debug("setSessionTime lai:"+value);//00:09:19.33
    UserAccount userDetails = SecurityUtils.getCurrentUser();
    Long attempId = (Long)userDetails.getAttribute("attempId");
    Long sessionTime=null;
    
    
    sessionTime = TimeUtil.HHMMSSToSec(value);
    
    //获取之前数据库中的时间与本次累加
    if(null!=attempId){
      Attemp attempPrevious =  attempDAO.get(attempId);
      Long sessionTimePrevious =attempPrevious.getSessionTime();
      
      if(null!=sessionTimePrevious){
        sessionTime =  sessionTimePrevious+sessionTime;
      }
    }
    
    
    Attemp attemp = new Attemp();
    attemp.setId(attempId);
    
    
    //String sessionTime= AbbreviateUtil.abbreviateExit(value);
    attemp.setSessionTime(sessionTime);//面需要换成
    
    attempDAO.update(attemp);

  }

  public void setSuspendData(Long courseId, Long scoId, Long userId, String value) throws LMSException {
    UserAccount userDetails = SecurityUtils.getCurrentUser();
    Long attempId = (Long)userDetails.getAttribute("attempId");
    
    //设定为”suspend”时，LMS必须将cmi.core.entry的值设定为”resume”
    
    //不是”suspend”时，LMS必须将cmi.core.entry的值设定为””
    Attemp attemp = new Attemp();
    attemp.setId(attempId);
    attemp.setSuspendData(value);
    attempDAO.update(attemp);

  }

  public String getSuspendData(Long courseId, Long scoId, Long userId) throws LMSException {
    UserAccount userDetails = SecurityUtils.getCurrentUser();
    //Long attempId = (Long)userDetails.getAttribute("attempId");
    //Attemp attemp =   attempDAO.get(attempId);
    String suspendData = "";
    
    //查询上一次执行的记录
    //如果上一次无记录获取本次记录，解决服务至信课程
    CriteriaBuilder cb=Cnd.builder(Attemp.class);
    cb.andEQ("courseId",courseId);
    cb.andEQ("scoId",scoId);
    cb.andEQ("userId",userId);
    
    cb.orderBy("id", Order.DESC);
    
    List<Attemp> attempList = attempDAO.findByCriteria(cb.buildCriteria());
    if(attempList.size()>1){
      Attemp attemp= attempList.get(1);
      suspendData= attemp.getSuspendData();
    }else if(attempList.size()>0){
      Attemp attemp= attempList.get(0);
      suspendData= attemp.getSuspendData();
    }
    return suspendData;
  }

  public String getLaunch_Data(Long courseId, Long scoId, Long userId) throws LMSException {
      //从COURSE表获取
     return "Launch_Datat";
  }

  public String getMasteryScore(Long courseId, Long scoId, Long userId) throws LMSException {
    // TODO Auto-generated method stub
    //从COURSE表获取
    return "10";
  }

}
