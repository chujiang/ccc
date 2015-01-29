package com.kingnod.etraining.course.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.core.util.SecurityUtils;
import com.kingnod.etraining.course.CourseConstant;
import com.kingnod.etraining.course.dao.AttempDAO;
import com.kingnod.etraining.course.entity.Attemp;
import com.kingnod.etraining.course.service.AttempService;
import com.kingnod.etraining.course.utils.AbbreviateUtil;
import com.kingnod.etraining.security.entity.UserAccount;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

@org.springframework.stereotype.Service
public class AttempServiceImpl implements AttempService {
  
  protected static Logger log = LoggerFactory.getLogger(AttempService.class);
  
  @Autowired
  protected AttempDAO attempDAO;


  public Attemp getAttemp(Long id) {
      return attempDAO.get(id);
  }

  public int saveAttemp(Attemp attemp) {
      int count = 0;
      IdEntity<Long> idEntity = (IdEntity)attemp;
      if(null != idEntity.getId() && null != attempDAO.get(idEntity.getId())){
          count = attempDAO.update(attemp);
      }else{
          count = attempDAO.insert(attemp);
      }
      return count;
  }

  public int deleteAttemp(Attemp attemp) {
      return attempDAO.delete(attemp);
  }

  public int deleteAttempByIds(Long[] ids) {
      return attempDAO.deleteById(ids);
  }

  public PagingResult<Attemp> findAttemp(Criteria criteria) {
      return attempDAO.findPagingResult(criteria);
  }
  
  //初始化一条记录
  public int initAttemp(Long courseId, Long scoId,Long userId){
    int count = 0;
    Attemp attemp = new Attemp();
    attemp.setCourseId(courseId);
    attemp.setScoId(scoId);
    attemp.setUserId(userId);
    attemp.setRawStatus(AbbreviateUtil.abbreviateStatus("incomplete"));
    attemp.setRawScore(CourseConstant.DEFAULT_SCORE);
    attemp.setSessionTime(CourseConstant.DEFAULT_TIME);
    attemp.setExitMode("");
    attemp.setEntryStatus(AbbreviateUtil.abbreviateEntry("ab-initio"));

    attemp.setLessonMode("nomal"); //怎么确定的
    
   
     count = attempDAO.insert(attemp);
     
     ((UserAccount)SecurityUtils.getCurrentUser()).setAttribute("attempId", attemp.getId());
     
    
    return count;
  }
  
  //完成时调用
  public int finishAttemp(Long courseId, Long scoId,Long userId){
    int count = 0;

    UserAccount userDetails = SecurityUtils.getCurrentUser();
    
    Long attempId = (Long)userDetails.getAttribute("attempId");
   
    //Attemp attemp = new Attemp();
    //attemp.setId(attempId);
    //attemp.setEntryStatus("");//课程中调用set suspend 自动设置

   
   // count = attempDAO.update(attemp);
    
    return count;
  }
}
