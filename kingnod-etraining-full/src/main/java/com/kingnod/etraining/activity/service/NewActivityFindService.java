package com.kingnod.etraining.activity.service;

import java.util.List;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.activity.entity.ActivityDetails;
import com.kingnod.etraining.common.ObjectType;

public interface NewActivityFindService {
	
	public List<ActivityDetails> findNewActivityList(Criteria criteria);
	
	public List<ActivityDetails> findGradeActivityList(Criteria criteria);
	
	public PagingResult<ActivityDetails>  findGradeActivityPagerCourseInfos(Criteria criteria);
	
	public PagingResult<ActivityDetails>  findNewActivityPagerCourseInfos(Criteria criteria);

}
