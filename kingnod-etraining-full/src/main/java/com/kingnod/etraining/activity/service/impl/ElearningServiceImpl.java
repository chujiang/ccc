package com.kingnod.etraining.activity.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.criteria.Order;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.exception.Exceptions;
import com.kingnod.core.pager.Pager;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.core.util.collection.ListUtils;
import com.kingnod.etraining.activity.ActivityConstant;
import com.kingnod.etraining.activity.dao.ElearningDAO;
import com.kingnod.etraining.activity.dao.TrainingPlanActivityDAO;
import com.kingnod.etraining.activity.dao.UserActivityDAO;
import com.kingnod.etraining.activity.entity.Elearning;
import com.kingnod.etraining.activity.entity.ElearningSituation;
import com.kingnod.etraining.activity.entity.Period;
import com.kingnod.etraining.activity.entity.TrainingPlanActivity;
import com.kingnod.etraining.activity.entity.UserActivity;
import com.kingnod.etraining.activity.service.ElearningService;
import com.kingnod.etraining.activity.service.PeriodService;
import com.kingnod.etraining.course.utils.TimeUtil;
import com.kingnod.etraining.exam.ExamConstant;
import com.kingnod.etraining.organization.dao.OrganizationDAO;
import com.kingnod.etraining.organization.entity.Organization;

@org.springframework.stereotype.Service
public class ElearningServiceImpl implements ElearningService {

    @Autowired
    protected ElearningDAO elearningDAO;
    
    @Autowired
    protected TrainingPlanActivityDAO trainingPlanActivityDAO;
    
    @Autowired  
    private PeriodService periodService;
    
    @Autowired  
    private UserActivityDAO userActivityDAO;
    
	@Autowired
	protected OrganizationDAO organizationDAO;

    public Elearning getElearning(Long id) {
    	Elearning result = elearningDAO.get(id);
    	Period period = new Period();
    	period.setPeriodFlagId(id);
    	period.setPeriodFlagType(result.getActivityType().toString());
     	List<Period> periodList = periodService.getPeriodByFlagID(period);
     	if(!ListUtils.isEmpty(periodList)){
     		result.setPeriods(periodList.get(0));
     	}
    	return result;
    }

    public int saveElearning(Elearning elearning) {
        int count = 0;
        IdEntity<Long> idEntity = (IdEntity)elearning;
        int nameCount=0;
        CriteriaBuilder cb = Cnd.builder(Elearning.class);
		cb.andEQ("name", elearning.getName());
		cb.andEQ("folderId", elearning.getFolderId());
        if(null != idEntity.getId() && null != elearningDAO.get(idEntity.getId())){
        	cb.andNotEQ("id", elearning.getId());
        	nameCount = elearningDAO.countByCriteria(cb.buildCriteria());
        	if(nameCount > 0) { //活动名称是否已经存在
    			throw Exceptions.createAppException("aty001006");
    		}else{
    			count = elearningDAO.update(elearning);	
    		}
        }else{
            nameCount = elearningDAO.countByCriteria(cb.buildCriteria());
    		if(nameCount > 0) { //活动名称是否已经存在
    			throw Exceptions.createAppException("aty001006");
    		}else{
    			 elearning.setReleaseStauts(ActivityConstant.RELEASESTAUTS_P);
    	         count = elearningDAO.insert(elearning);
    		}
           
        }
        if(0<count)
        {
        	if(null != elearning.getPeriods()){
        		elearning.getPeriods().setPeriodFlagId(elearning.getId());
        		elearning.getPeriods().setPeriodFlagType(elearning.getActivityType().toString());
        		periodService.savePeriod(elearning.getPeriods());
        	}
        }
        return count;
    }

    public int deleteElearning(Elearning elearning) {
//        return elearningDAO.delete(elearning);
    	int count = elearningDAO.delete(elearning);
        if(0 < count)
        {
        	Long[] ids = {elearning.getId()};
        	periodService.deletePeriodByFlagId(ids,elearning.getActivityType().toString());
        }
    	return count;
    }

    public int deleteElearningByIds(Long[] ids) {
        int count = elearningDAO.deleteById(ids);
        if(0 < count)
        {
        	periodService.deletePeriodByFlagId(ids,"A_EL");
        }
    	return count;
    }

    public PagingResult<Elearning> findElearning(Criteria criteria) {
        return elearningDAO.findPagingResult(criteria);
    }

    public PagingResult<Elearning> findElearningByCourseId(Long courseId,Pager<Elearning> pager) {
    	CriteriaBuilder builder = Cnd.builder(Elearning.class);
    	builder.andEQ("courseId", courseId).andEQ("recordStatus", "A");
    	Criteria limit = null;
    	if(null != pager){
    		limit = builder.buildCriteria().limit(Long.valueOf(pager.getFirst()), Long.valueOf(pager.getLast()));
    	}else{
    		limit = builder.buildCriteria();
    	}
		return findElearning(limit);
	}
	public int saveTrainingPlanActivity(Elearning elearning,Long processId) {
		 int count = 0;
		 IdEntity<Long> idEntity = (IdEntity)elearning;
	     count = saveElearning(elearning);
	        TrainingPlanActivity trainingPlanActivity=new TrainingPlanActivity();
	        IdEntity<Long> idEntity2 = (IdEntity)trainingPlanActivity;
	        trainingPlanActivity.setProcessId(processId);
	        trainingPlanActivity.setActivityId(idEntity.getId());
	    	trainingPlanActivity.setActivityName(elearning.getName());
	    	trainingPlanActivity.setActivityType(elearning.getActivityType().toString());
	        if(null != idEntity2.getId() && null != trainingPlanActivityDAO.get(idEntity2.getId())){
	            count = trainingPlanActivityDAO.update(trainingPlanActivity);
	        }else{
	            count = trainingPlanActivityDAO.insert(trainingPlanActivity);
	        }
	        return count;
	}
	
	
	/**
   * 发布考试  
   */
  /**
   * Description: 发布在线学习<br>
   * Implement: <br>
   * [参数列表，说明每个参数用途]
   * 
   * @param isPublish true 发布  false取消
   *            
   * @return int 记录条数
   */
  public int publish(Elearning elearning, boolean isPublish) {
    if(null != elearning) {
      
      elearning.setReleaseDate(new Date());
      
      if(isPublish) {
        elearning.setReleaseStauts(ExamConstant.STATUS_R);
      } else {
        elearning.setReleaseStauts(ExamConstant.STATUS_P);
      }
     return elearningDAO.update(elearning);
      //return elearningDAO.updateByCriteria(elearning, Cnd.builder(Elearning.class).andEQ("id", elearning.getId()).buildCriteria());
    }
    return 0;
  }
  
  public PagingResult<ElearningSituation> findBySituation(Criteria criteria) {
	  PagingResult<ElearningSituation> pe=elearningDAO.findBySituation(criteria);
	 for(int i=0;i<pe.getResult().size();i++){
		 	CriteriaBuilder cb = Cnd.builder(Organization.class);
			cb.addParam("organizationID", pe.getResult().get(i).getOrganizationId()).orderBy("hierarchy_level", Order.DESC);
			List<Organization> organizationList=organizationDAO.findhierarchyByChildId(cb.buildCriteria());
			String hierarchyName="";
			for (Organization organization : organizationList) {
				hierarchyName+="/"+organization.getName();
			}
			pe.getResult().get(i).seteName(hierarchyName);
		 if(null!=pe.getResult().get(i).getTotalTime()){
			 pe.getResult().get(i).setTotalDate(TimeUtil.secToHHMMSS(pe.getResult().get(i).getTotalTime()));
		 }
		 if(null!=pe.getResult().get(i).getScore()&&pe.getResult().get(i).getScore().doubleValue()<0){
			 pe.getResult().get(i).setScore(null);
		 }
	 }
		return pe;
	}

	public ElearningSituation getElearningSituation(Long activityId, Long userId) {
		 ElearningSituation elearningSituation=null;
		  CriteriaBuilder cb = Cnd.builder(ElearningSituation.class);
		  cb.addParam("activityId", activityId);
		  cb.addParam("userId", userId);
		  PagingResult<ElearningSituation> elearningSituationList= elearningDAO.findBySituation(cb.buildCriteria());
		  if(null!=elearningSituationList && !ListUtils.isEmpty(elearningSituationList.getResult())){
			  elearningSituation=elearningSituationList.getResult().get(0);
		  }
		return elearningSituation;
	}

	public int updateSituation(ElearningSituation elearningSituation) {
		int cunt=0;
		UserActivity userActivity=userActivityDAO.get(elearningSituation.getId());
		userActivity.setScore(elearningSituation.getScore());
		userActivity.setTotalTime(elearningSituation.getTotalTime());
		userActivity.setStatus(elearningSituation.getStatus());
		userActivity.setCompletedDate(elearningSituation.getCompletedDate());
		userActivity.setComments(elearningSituation.getComments());
		cunt+=userActivityDAO.update(userActivity);
		return cunt;
	}

	public int updateElearningSituation(Long[] ids,Long activityId,ElearningSituation elearningSituation) {
		int cunt=0;
		for(int i=0;i<ids.length;i++){
			 CriteriaBuilder cb = Cnd.builder(UserActivity.class);
			 cb.andEQ("activityId", activityId);
			 cb.andEQ("userId", ids[i]);
			List<UserActivity> userActivityList=userActivityDAO.findByCriteria(cb.buildCriteria());
			if(null!=userActivityList&&userActivityList.size()>0){
				for (UserActivity userActivity : userActivityList) {
					userActivity.setScore(elearningSituation.getScore());
					userActivity.setTotalTime(elearningSituation.getTotalTime());
					userActivity.setStatus(elearningSituation.getStatus());
					userActivity.setCompletedDate(elearningSituation.getCompletedDate());
					userActivity.setComments(elearningSituation.getComments());
					cunt+=userActivityDAO.update(userActivity);
				}
			}else{
				UserActivity userActivity=new UserActivity();
				userActivity.setActivityId(activityId);
				userActivity.setUserId(ids[i]);
				userActivity.setScore(elearningSituation.getScore());
				userActivity.setTotalTime(elearningSituation.getTotalTime());
				userActivity.setStatus(elearningSituation.getStatus());
				userActivity.setCompletedDate(elearningSituation.getCompletedDate());
				userActivity.setComments(elearningSituation.getComments());
				cunt+=userActivityDAO.insert(userActivity);
			}
		}
//		UserActivity userActivity=userActivityDAO.get(elearningSituation.getId());
//		userActivity.setScore(elearningSituation.getScore());
//		userActivity.setTotalTime(elearningSituation.getTotalTime());
//		userActivity.setStatus(elearningSituation.getStatus());
//		userActivity.setCompletedDate(elearningSituation.getCompletedDate());
//		cunt+=userActivityDAO.update(userActivity);
		return cunt;
	}
}