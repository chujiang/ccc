package com.kingnod.etraining.activity.dao;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.dao.EntityDAO;
import com.kingnod.etraining.activity.entity.TrainingPlanItem;


    @com.kingnod.core.annotation.Generated("2012-02-08 17:20")
public interface TrainingPlanItemDAO extends EntityDAO<TrainingPlanItem, Long> {
    	
    	public Integer sumCostByCriteria(Criteria criteria);
    	
    	public Integer sumLessonsByCriteria(Criteria criteria);
    	
    	public Integer sumLearnerNumberByCriteria(Criteria criteria);

}