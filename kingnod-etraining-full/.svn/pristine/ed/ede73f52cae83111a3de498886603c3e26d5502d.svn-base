package com.kingnod.etraining.activity.service.impl;

import java.util.List;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.pager.Pager;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.core.util.collection.ListUtils;
import com.kingnod.etraining.activity.dao.RecommendObjectDAO;
import com.kingnod.etraining.activity.entity.ActivityDetails;
import com.kingnod.etraining.activity.entity.Period;
import com.kingnod.etraining.activity.entity.RecommendObject;
import com.kingnod.etraining.activity.entity.UserActivitySummary;
import com.kingnod.etraining.activity.service.PeriodService;
import com.kingnod.etraining.activity.service.RecommendObjectService;
import com.kingnod.etraining.common.ObjectType;
import com.kingnod.etraining.common.service.AttachmentService;
import com.kingnod.etraining.course.entity.CourseInfo;

import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class RecommendObjectServiceImpl implements RecommendObjectService {

    @Autowired
    protected RecommendObjectDAO recommendObjectDAO;

    @Autowired
    protected AttachmentService attachmentService;
    
    @Autowired  
    private PeriodService periodService;

    public RecommendObject getRecommendObject(Long id) {
    	RecommendObject result = recommendObjectDAO.get(id);
    	Period period = new Period();
    	period.setPeriodFlagId(id);
    	period.setPeriodFlagType(ObjectType.A_EL.name());
     	List<Period> periodList = periodService.getPeriodByFlagID(period);
     	if(!ListUtils.isEmpty(periodList)){
     		result.setPeriods(periodList.get(0));
     	}
    	return result;
    }

    public int saveRecommendObject(RecommendObject recommendObject) {
        int count = 0;
        IdEntity<Long> idEntity = (IdEntity)recommendObject;
        if(null != idEntity.getId() && null != recommendObjectDAO.get(idEntity.getId())){
            count = recommendObjectDAO.update(recommendObject);
        }else{
            count = recommendObjectDAO.insert(recommendObject);
        }
        if(0<count)
        {
        	if(null != recommendObject.getPeriods()){
        		recommendObject.getPeriods().setPeriodFlagId(recommendObject.getId());
        		recommendObject.getPeriods().setPeriodFlagType(ObjectType.A_EL.name());
        		periodService.savePeriod(recommendObject.getPeriods());
        	}
        }
        return count;
    }

    public int deleteRecommendObject(RecommendObject recommendObject) {
        return recommendObjectDAO.delete(recommendObject);
    }

    public int deleteRecommendObjectByIds(Long[] ids) {
        return recommendObjectDAO.deleteById(ids);
    }

    public PagingResult<RecommendObject> findRecommendObject(Criteria criteria) {
        return recommendObjectDAO.findPagingResult(criteria);
    }

	public List<ActivityDetails> findRecommendCourseInfos(Criteria criteria) {
		// TODO Auto-generated method stub
		List<ActivityDetails> recommendObjectList = recommendObjectDAO.findRecommendCourseInfos(criteria);
		for(ActivityDetails activity : recommendObjectList)
		{
			activity.setImgPath(attachmentService.getAttachmentUrl(activity.getAttachmentId()));
		}
		return recommendObjectList;
	}

	/**
	 * 分页查询推荐课程详细信息
	 */
	public PagingResult<ActivityDetails> findRecommendPagerCourseInfos(
			Criteria criteria) {
		// TODO Auto-generated method stub
		//return recommendObjectDAO.findRecommendPagerCourseInfos(criteria);
   PagingResult<ActivityDetails> result = recommendObjectDAO.findRecommendPagerCourseInfos(criteria);
    
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