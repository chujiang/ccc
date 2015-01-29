package com.kingnod.etraining.activity.service;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.activity.entity.TrainingPlanItemCost;


    @com.kingnod.core.annotation.Generated("2012-02-08 21:54")
public interface TrainingPlanItemCostService {

    
    @com.kingnod.core.annotation.Generated("2012-02-08 21:54")
    TrainingPlanItemCost getTrainingPlanItemCost(Long id);

    
    @com.kingnod.core.annotation.Generated("2012-02-08 21:54")
    int saveTrainingPlanItemCost(TrainingPlanItemCost trainingPlanItemCost);

    
    @com.kingnod.core.annotation.Generated("2012-02-08 21:54")
    int deleteTrainingPlanItemCost(TrainingPlanItemCost trainingPlanItemCost);

    
    @com.kingnod.core.annotation.Generated("2012-02-08 21:54")
    int deleteTrainingPlanItemCostByIds(Long[] ids);

    
    @com.kingnod.core.annotation.Generated("2012-02-08 21:54")
    PagingResult<TrainingPlanItemCost> findTrainingPlanItemCost(Criteria criteria);
}