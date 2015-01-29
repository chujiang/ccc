package com.kingnod.etraining.course.service.impl;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.criteria.Order;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.entity.RecordStatus;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.activity.dao.ActivityDAO;
import com.kingnod.etraining.activity.dao.ActivityDetailsDAO;
import com.kingnod.etraining.activity.dao.ElearningDAO;
import com.kingnod.etraining.activity.entity.ActivityDetails;
import com.kingnod.etraining.common.ObjectType;
import com.kingnod.etraining.course.CourseConstant;
import com.kingnod.etraining.course.dao.CourseInfoDAO;
import com.kingnod.etraining.course.dao.ItemInfoDAO;
import com.kingnod.etraining.course.dao.PerformanceDAO;
import com.kingnod.etraining.course.dao.SCOPerformanceDAO;
import com.kingnod.etraining.course.entity.CourseInfo;
import com.kingnod.etraining.course.entity.ItemInfo;
import com.kingnod.etraining.course.entity.Performance;
import com.kingnod.etraining.course.entity.SCOPerformance;
import com.kingnod.etraining.course.service.PerformanceService;
import com.kingnod.etraining.course.utils.AbbreviateUtil;
import com.kingnod.etraining.organization.entity.Site;
import com.kingnod.etraining.organization.entity.User;

import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class PerformanceServiceImpl implements PerformanceService {

    @Autowired
    protected PerformanceDAO performanceDAO;
    
    
    @Autowired
    protected SCOPerformanceDAO sCOPerformanceDAO;
    
    @Autowired
    protected ItemInfoDAO  itemInfoDAO;
    
    @Autowired
    protected ActivityDAO activityDAO;
    @Autowired
    protected ElearningDAO elearningDAO;
    
    @Autowired
    protected CourseInfoDAO courseInfoDAO;
    
    @Autowired
    protected ActivityDetailsDAO activityDetailsDAO;


    public Performance getPerformance(Long id) {
        return performanceDAO.get(id);
    }

    public int savePerformance(Performance performance) {
        int count = 0;
        IdEntity<Long> idEntity = (IdEntity)performance;
        if(null != idEntity.getId() && null != performanceDAO.get(idEntity.getId())){
            count = performanceDAO.update(performance);
        }else{
            count = performanceDAO.insert(performance);
        }
        return count;
    }

    public int deletePerformance(Performance performance) {
        return performanceDAO.delete(performance);
    }

    public int deletePerformanceByIds(Long[] ids) {
        return performanceDAO.deleteById(ids);
    }

    public PagingResult<Performance> findPerformance(Criteria criteria) {
        return performanceDAO.findPagingResult(criteria);
    }
    
  //初始化时调用
    public int initPerformance(Long acivityId, Long courseId,Long userId){
      int count = 0;
      Performance performance= new Performance();
      performance.setUserId(userId);
      performance.setCourseId(courseId);

      CriteriaBuilder cbTot = Cnd.builder(ItemInfo.class);
      cbTot.andEQ("courseId",courseId);
      cbTot.andIsNotNull("launch");
      int scoTotalCount= itemInfoDAO.countByCriteria(cbTot.buildCriteria());
      
      
      performance.setScoTotalCount(scoTotalCount);
      performance.setCompletedScoCount(0);
      performance.setCompletedPercentage(CourseConstant.DEFAULT_COMPLETEDPERCENTAGE);
      performance.setStatus(AbbreviateUtil.abbreviateStatus("incomplete"));
      performance.setLessonTotalTime(CourseConstant.DEFAULT_TIME);
      performance.setCompletedTotalTime(CourseConstant.DEFAULT_TIME);
      performance.setScore(CourseConstant.DEFAULT_SCORE);
      
      
      performance.setActivityId(acivityId);
       
      CriteriaBuilder cb = Cnd.builder(Site.class);
      cb.andEQ("A.COURSE_ID",courseId).andEQ("A.USER_ID",userId);
      
      List<Performance> sCOPList = performanceDAO.findByCriteria(cb.buildCriteria());
      if(sCOPList.size()<1){
        count = performanceDAO.insert(performance);
      }
     return count;
    }
    
    //完成时调用
    public int finishPerformance(Long acivityId,Long courseId,Long userId){
       int count = 0;
       Performance performance= new Performance();
       performance.setActivityId(acivityId);
       performance.setUserId(userId);
       performance.setCourseId(courseId);
       
       //performance.setStatus(AbbreviateUtil.abbreviateStatus("incomplete"));
       
       CriteriaBuilder cbUpdate=Cnd.builder();
       cbUpdate.andEQ("A.USER_ID",userId);
       cbUpdate.andEQ("A.COURSE_ID",courseId);
       

       CriteriaBuilder cb = Cnd.builder(SCOPerformance.class);
       cb.andEQ("courseId",courseId).andEQ("userId",userId);
       cb.andGroup(Cnd.builder().andEQ("status", AbbreviateUtil.abbreviateStatus("completed")).orEQ("A.STATUS", AbbreviateUtil.abbreviateStatus("passed")));
       
       int finshedSCO = sCOPerformanceDAO.countByCriteria(cb
           .buildCriteria());
       
       CriteriaBuilder cbTot = Cnd.builder(ItemInfo.class);
       cbTot.andEQ("courseId",courseId);
       cbTot.andIsNotNull("launch");
       
       int scoTotalCount= itemInfoDAO.countByCriteria(cbTot.buildCriteria());
       
       performance.setScoTotalCount(scoTotalCount);
       performance.setCompletedScoCount(finshedSCO);
       
       String percentage=  finshedSCO+"/"+scoTotalCount;
       performance.setCompletedPercentage(percentage);//需要讨论，全部完成时状态为完成;全部都完成且有通过状态时，状态为通过
       
       CriteriaBuilder cbTotTim=Cnd.builder();
       cbTotTim.andEQ("A.USER_ID",userId);
       cbTotTim.andEQ("A.COURSE_ID",courseId);

       long lessonTotalTime= sCOPerformanceDAO.countByTatalTimeCriteria(cbTotTim.buildCriteria());
       performance.setLessonTotalTime(lessonTotalTime);
       
       Date compDate=null;
       List<Performance> listP=performanceDAO.findByCriteria(cbUpdate.buildCriteria());
       if(listP.size()>0){
         Performance perf=listP.get(0);
         compDate = perf.getCompletedDate();
         
         performance.setId(perf.getId());
       }
       //为了解决服务器上的后面这个判断删掉
       //if(finshedSCO==scoTotalCount&&compDate!=null){
         //performance.setStatus(AbbreviateUtil.abbreviateStatus("completed"));
       //}
       
       //正常流程
       if(compDate==null){
         performance.setStatus(AbbreviateUtil.abbreviateStatus("incomplete"));
       }
       if(finshedSCO==scoTotalCount&&compDate==null){//全部完成而且completedDate为空时更新
         performance.setCompletedDate(new Date());//全部都完成，记录完成时间
         performance.setCompletedTotalTime(lessonTotalTime);
         performance.setStatus(AbbreviateUtil.abbreviateStatus("completed"));
         
         
         CriteriaBuilder cbMaxScore = Cnd.builder(Site.class);
         cbMaxScore.andEQ("A.COURSE_ID",courseId).andEQ("A.USER_ID",userId);
        // cbMaxScore.andEQ("A.STATUS",AbbreviateUtil.abbreviateStatus("passed"));
         BigDecimal maxScore = sCOPerformanceDAO.queryMaxScoreByCriteria(cbMaxScore.buildCriteria());
         if(-1!=maxScore.intValue()){
           performance.setScore(maxScore);//全部都完成或者通过,取通过了的集合中的数据
         }
         
         CriteriaBuilder cbPass = Cnd.builder(Site.class);
         cbPass.andEQ("A.COURSE_ID",courseId).andEQ("A.USER_ID",userId);
         cbPass.andEQ("A.STATUS",AbbreviateUtil.abbreviateStatus("passed"));
         
         
         int finshedSCOPassed = sCOPerformanceDAO.countByCriteria(cbPass.buildCriteria());
         if(finshedSCOPassed>0){
           performance.setStatus(AbbreviateUtil.abbreviateStatus("passed"));
         }
         
       }

     //更新活动状态
       performanceDAO.update(performance);
       //count =  performanceDAO.updateByCriteria(performance, cbUpdate.buildCriteria());
      return count;
    }
    
    
  //获取启动的章节
   public ItemInfo getLaunchSCO(Long courseId,Long userId){
     SCOPerformance sco = null;
     ItemInfo itemInfo = null;

     //2.如果第一步存在记录，是否有entry=“resume”的记录，按最后更新时间排序，如果有，说明学生是点击暂停按钮从上次学习中退出
       CriteriaBuilder cbSco=Cnd.builder();
       cbSco.andEQ("A.USER_ID",userId);
       cbSco.andEQ("A.COURSE_ID",courseId);
       cbSco.andEQ("A.ENTRY_STATUS",AbbreviateUtil.abbreviateEntry("resume"));
       
       cbSco.orderBy("A.UPDATE_DATE", Order.DESC);
       
       List<SCOPerformance> sCOPList = sCOPerformanceDAO.findByCriteria(cbSco.buildCriteria());
       if(sCOPList.size()>0){
         sco=sCOPList.get(0);
       }else{
         
         //3.如果第一步存在记录，第二步步无记录,查找是否有是否有未完成的SCO，按最后更新时间排序，
         CriteriaBuilder cbScoStatus=Cnd.builder();
         cbScoStatus.andEQ("A.USER_ID",userId);
         cbScoStatus.andEQ("A.COURSE_ID",courseId);
         cbScoStatus.andEQ("A.STATUS",AbbreviateUtil.abbreviateStatus("incomplete"));
         
         cbScoStatus.orderBy("A.UPDATE_DATE", Order.DESC);
         
         List<SCOPerformance> sCOPListStatus = sCOPerformanceDAO.findByCriteria(cbScoStatus.buildCriteria());
         if(sCOPListStatus.size()>0){
           sco = sCOPListStatus.get(0);
         }else{
         //3.如果第一步存无记录，则从lessonstatus为notattempted的记录开始学起
           CriteriaBuilder cbScoStatu=Cnd.builder();
           cbScoStatu.andEQ("A.COURSE_ID",courseId);
           cbScoStatu.andIsNull("A.USER_ID");//用户从来没学过的
           //cbScoStatu.andIsNotNull("B.LAUNCH");
          
          // cbScoStatu.orderBy("B.ID", Order.ASC);//以后改为按排序字段排
           
           List<SCOPerformance> sCOPListStatu = sCOPerformanceDAO.findByCriteria(cbScoStatu.buildCriteria());
        
           
           if(sCOPListStatu.size()>0){
             sco = sCOPListStatu.get(0); 
           }else{
             //4.否则就是复习从第一章开始
           /*  CriteriaBuilder cbScoReview=Cnd.builder();
             cbScoReview.andEQ("A.OURSE_ID",courseId);
             cbScoReview.andIsNotNull("B.LAUNCH");
            
             cbScoReview.orderBy("B.ID", Order.ASC);*///以后改为按排序字段排
             
             CriteriaBuilder cbItem = Cnd.builder(ItemInfo.class);
             cbItem.andEQ("courseId",courseId);
             cbItem.andIsNotNull("launch");
             cbItem.orderBy("id", Order.ASC);
             List<ItemInfo> itemList = itemInfoDAO.findByCriteria(cbItem.buildCriteria());
             
             //List<SCOPerformance> sCOPListReview = sCOPerformanceDAO.findByCriteria(cbScoReview.buildCriteria());
             if(itemList.size()>0){
               itemInfo = itemList.get(0);
               //预留需要设置浏览模式为 复习
               }
           }
           
       }

     }
       

       if(itemInfo == null&&sco!=null){
          itemInfo = itemInfoDAO.get(sco.getScoId());
       }
     
     return itemInfo;
    }
   
   //课程信息:获取导航模式,name
   public CourseInfo getCourseInfoById(Long courseId){
     CourseInfo  courseInfo =courseInfoDAO.get(courseId);
     return courseInfo;
   }
   
   //增加活动在线人数
   public void addOnlineCount(Long activityId){
     if (activityId != null) {
       ActivityDetails activityDetailsTemp = activityDetailsDAO.get(ObjectType.A_EL, activityId);
         Long onlineNumber = activityDetailsTemp.getOnlineNumber();
         if (onlineNumber == null) {
           onlineNumber = 0l;
         }
         ActivityDetails activityDetails = new ActivityDetails();
         activityDetails.setActivityId(activityId);
         activityDetails.setOnlineNumber(onlineNumber + 1);
         activityDetails.setType(ObjectType.A_EL);
         activityDetailsDAO.update(activityDetails);
       }
     
   }
   
  //减少活动在线人数
   public void minusOnlineCount(Long activityId){
     if (activityId != null) {
       ActivityDetails activityDetailsTemp = activityDetailsDAO.get(ObjectType.A_EL, activityId);
         Long onlineNumber = activityDetailsTemp.getOnlineNumber();
         if (onlineNumber == null) {
           onlineNumber = 0l;
         }
         ActivityDetails activityDetails = new ActivityDetails();
         activityDetails.setActivityId(activityId);
         if(onlineNumber!=0l){
           onlineNumber=onlineNumber - 1;
         }
         activityDetails.setOnlineNumber(onlineNumber);
         activityDetails.setType(ObjectType.A_EL);
         activityDetailsDAO.update(activityDetails);
       }
   }
   
}