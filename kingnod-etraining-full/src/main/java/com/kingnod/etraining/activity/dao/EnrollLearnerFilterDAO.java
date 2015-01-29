package com.kingnod.etraining.activity.dao;

import java.util.List;
import java.util.Map;

import com.kingnod.core.dao.EntityDAO;
import com.kingnod.etraining.activity.entity.EnrollLearnerFilter;
import com.kingnod.etraining.common.ObjectType;


    @com.kingnod.core.annotation.Generated("2012-03-08 10:55")
public interface EnrollLearnerFilterDAO extends EntityDAO<EnrollLearnerFilter, Long> {
    	public Long getGroupNumber();
    	public void mergeCondition(Map ids);
    	List<EnrollLearnerFilter> findByActivityId(Long activityId, ObjectType objectType);
}