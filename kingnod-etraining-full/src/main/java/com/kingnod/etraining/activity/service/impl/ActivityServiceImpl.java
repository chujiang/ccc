package com.kingnod.etraining.activity.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.criteria.Logic;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.pager.Pager;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.activity.ActivityConstant;
import com.kingnod.etraining.activity.dao.ActivityDetailsDAO;
import com.kingnod.etraining.activity.dao.EnrollLearnerDAO;
import com.kingnod.etraining.activity.dao.UserActivityDAO;
import com.kingnod.etraining.activity.entity.ActivityDetails;
import com.kingnod.etraining.activity.entity.Elearning;
import com.kingnod.etraining.activity.entity.EnrollLearner;
import com.kingnod.etraining.activity.entity.Period;
import com.kingnod.etraining.activity.entity.UserActivity;
import com.kingnod.etraining.activity.entity.UserActivitySummary;
import com.kingnod.etraining.activity.service.ActivityService;
import com.kingnod.etraining.activity.service.PeriodService;
import com.kingnod.etraining.activity.service.UserActivityService;
import com.kingnod.etraining.common.ObjectType;

@Service
public class ActivityServiceImpl implements ActivityService,UserActivityService {

	

	@Autowired
    protected UserActivityDAO userActivityDAO;
	
	@Autowired
    protected ActivityDetailsDAO activityDetailsDAO;
	
	 @Autowired
   protected EnrollLearnerDAO enrollLearnerDAO;
	 
	 @Autowired
	  PeriodService periodService;


    public UserActivity getUserActivity(Long id) {
        return userActivityDAO.get(id);
    }

    public int saveUserActivity(UserActivity userActivity) {
        int count = 0;
        IdEntity<Long> idEntity = (IdEntity)userActivity;
        if(null != idEntity.getId() && null != userActivityDAO.get(idEntity.getId())){
            count = userActivityDAO.update(userActivity);
        }else{
            count = userActivityDAO.insert(userActivity);
        }
        return count;
    }

    
    public int findActivitiesByCategoryCount(Criteria criteria) {
		// TODO Auto-generated method stub
		return userActivityDAO.findUserActivitiesCount(criteria);
	}

	public int deleteUserActivity(UserActivity userActivity) {
        return userActivityDAO.delete(userActivity);
    }

    public int deleteUserActivityByIds(Long[] ids) {
        return userActivityDAO.deleteById(ids);
    }

    public PagingResult<UserActivity> findUserActivity(Criteria criteria) {
        return userActivityDAO.findPagingResult(criteria);
    }
    
    /**
     * 根据活动Id获取数据
     * @param activityId
     * @return boolean
     */
    public UserActivity getUserActivityByActId(Long activityId){
    	return userActivityDAO.getUserActivityByActId(activityId);
    }
    
	public PagingResult<UserActivitySummary> findUserActivitiesByCriteria(
			Criteria criteria) {
		PagingResult<UserActivitySummary> result = userActivityDAO.findUserActivitiesByCriteria(criteria);
		if(null != result && null != result.getResult()){
			for(UserActivitySummary actSummary:result.getResult()){
			  //判断是否在有效时间段内
        Period period = periodService.getPeriodByFlagId(actSummary.getActivityId(),actSummary.getType());
        actSummary.setInValidateDate(periodService.availabilityDate(period));
        
        
				ActivityDetails activityDetails = (ActivityDetails)activityDetailsDAO.get(actSummary.getType(), actSummary.getActivityId());
				actSummary.setActivityObject(activityDetails.getActivityObject());
				actSummary.setLearningTime(com.kingnod.etraining.course.utils.TimeUtil.secToHHMMSS(actSummary.getTotalTime()==null?0:actSummary.getTotalTime()));
			}
		}
		return result;
	}
	
	//根据课程分类查找活动
	public PagingResult<UserActivitySummary> findUserActivitiesByCriteriaCategory(
      Criteria criteria) {
    PagingResult<UserActivitySummary> result = userActivityDAO.findUserActivitiesByCriteriaCaegory(criteria);
    
    if(null != result && null != result.getResult()){
      for(UserActivitySummary actSummary:result.getResult()){
        
        //判断是否在有效时间段内
        Period period = periodService.getPeriodByFlagId(actSummary.getActivityId(),actSummary.getType());
        actSummary.setInValidateDate(periodService.availabilityDate(period));
        
        
        ActivityDetails activityDetails = (ActivityDetails)activityDetailsDAO.get(actSummary.getType(), actSummary.getActivityId());
        actSummary.setActivityObject(activityDetails.getActivityObject());
      }
    }
    return result;
  }

	@Autowired
	ActivityDetailsDAO activityDao;
	
	public ActivityDetails get(ObjectType activityType, Long activityId) {
		// TODO Auto-generated method stub
		return activityDao.get(activityType, activityId);
	}

	public int saveActivity(ActivityDetails activity) {
		// TODO Auto-generated method stub
		int count = 0;
		if ( null != activityDao.get(activity.getType(),activity.getActivityId())) {
			count = activityDao.update(activity);
		} else {
			count = activityDao.insert(activity);
		}
		return count;
	}

	public int saveActivities(List<ActivityDetails> entities) {
		// TODO Auto-generated method stub
		return activityDao.insert(entities);
	}

	public int deleteActivity(ActivityDetails... entities) {
		// TODO Auto-generated method stub
		return activityDao.delete(entities);
	}

	public int deleteActivityByIds(String activityType, Long... activityId) {
		// TODO Auto-generated method stub
		return activityDao.deleteById(activityType, activityId);
	}

	public PagingResult<ActivityDetails> findActivity(Criteria criteria) {
		// TODO Auto-generated method stub
		return activityDao.findPagingResult(criteria);
	}

	public List<ActivityDetails> findActivityByCriteria(Criteria criteria) {
		// TODO Auto-generated method stub
		return activityDao.findByCriteria(criteria);
	}

	  public PagingResult<ActivityDetails> findActivityByCourseId(Long courseId,Pager<ActivityDetails> pager) {
		  CriteriaBuilder builder = Cnd.builder(ActivityDetails.class);
			builder.andEQ("courseId", courseId).andEQ("recordStatus", "A");
			Criteria limit = builder.buildCriteria().limit(Long.valueOf(pager.getFirst()), Long.valueOf(pager.getLast()));
			return findActivity(limit);
	}
  //更新课程的注册状态，主要针对选修和必修
	public int setEnrollStatusEnrolled(Long userId,Long activityId){
	  EnrollLearner enrollLearner=new EnrollLearner();
	  enrollLearner.setStauts(ActivityConstant.ENROLL_STATUS_R);
	  
	  CriteriaBuilder cb = Cnd.builder(EnrollLearner.class);
    cb.andEQ("activityId",activityId);
    cb.andEQ("userId",userId); 

    return enrollLearnerDAO.updateByCriteria(enrollLearner, cb.buildCriteria());
	}
	
	
	public int logoutEnrollStatusEnrolled(Long userId,Long activityId){
		  EnrollLearner enrollLearner=new EnrollLearner();
		  enrollLearner.setStauts(ActivityConstant.ENROLL_STATUS_O);
		  CriteriaBuilder cb = Cnd.builder(EnrollLearner.class);
	    cb.andEQ("activityId",activityId);
	    cb.andEQ("userId",userId); 

	    return enrollLearnerDAO.updateByCriteria(enrollLearner, cb.buildCriteria());
		}
  // 根据关键字搜索所有活动
/*	public PagingResult<UserActivitySummary> searchAllActivity(Long userId,String keyWord){
   // userActivityDAO.findByCriteria(arg0);
    return null;
  }*/


}
