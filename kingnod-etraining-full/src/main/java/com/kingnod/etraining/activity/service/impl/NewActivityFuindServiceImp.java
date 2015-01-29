package com.kingnod.etraining.activity.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.activity.dao.ActivityDAO;
import com.kingnod.etraining.activity.entity.ActivityDetails;
import com.kingnod.etraining.activity.entity.Period;
import com.kingnod.etraining.activity.service.NewActivityFindService;
import com.kingnod.etraining.activity.service.PeriodService;
import com.kingnod.etraining.common.ObjectType;
import com.kingnod.etraining.common.service.AttachmentService;

/**
 * 最新课程处理的service类
 * @author thinkpad
 *
 */
@org.springframework.stereotype.Service
public class NewActivityFuindServiceImp implements NewActivityFindService{

	@Autowired
	protected ActivityDAO activityDAO;
	
	@Autowired
    protected AttachmentService attachmentService;
	
  @Autowired  
  private PeriodService periodService;
	
	public List<ActivityDetails> findNewActivityList(Criteria criteria)
	{
		
		List<ActivityDetails> findActivityList = activityDAO.findNewActivityList(criteria);
		for(ActivityDetails activity : findActivityList)
		{
			activity.setImgPath(attachmentService.getAttachmentUrl(activity.getAttachmentId()));
		}
		return findActivityList;
	}


	public List<ActivityDetails> findGradeActivityList(Criteria criteria) {
		// TODO Auto-generated method stub
		List<ActivityDetails> findActivityList = activityDAO.findGradeActivityList(criteria);
		for(ActivityDetails activity : findActivityList)
		{
			activity.setImgPath(attachmentService.getAttachmentUrl(activity.getAttachmentId()));
		}
		return findActivityList;
	}


	public PagingResult<ActivityDetails> findGradeActivityPagerCourseInfos(
			Criteria criteria) {
		// TODO Auto-generated method stub
		//return activityDAO.findGradeActivityPagerCourseInfos(criteria);
    PagingResult<ActivityDetails> result = activityDAO.findGradeActivityPagerCourseInfos(criteria);
    
    if(null != result && null != result.getResult()){
      for(ActivityDetails bean:result.getResult()){
        
        //判断是否在有效时间段内
        Period period = periodService.getPeriodByFlagId(bean.getActivityId(),bean.getType());
        bean.setInValidateDate(periodService.availabilityDate(period));
 
      }
    }
    return result;
	}


	public PagingResult<ActivityDetails> findNewActivityPagerCourseInfos(
			Criteria criteria) {
		// TODO Auto-generated method stub
		//return activityDAO.findNewActivityPagerCourseInfos(criteria);
   PagingResult<ActivityDetails> result =activityDAO.findNewActivityPagerCourseInfos(criteria);
    
    if(null != result && null != result.getResult()){
      for(ActivityDetails bean:result.getResult()){
        
        //判断是否在有效时间段内
        Period period = periodService.getPeriodByFlagId(bean.getActivityId(),bean.getType());
        bean.setInValidateDate(periodService.availabilityDate(period));
 
      }
    }
    return result;
    
	}
}
