package com.kingnod.etraining.activity.service;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.activity.entity.TrainingPlanActivity;


    @com.kingnod.core.annotation.Generated("2012-02-15 11:44")
public interface TrainingPlanActivityService {

    
    @com.kingnod.core.annotation.Generated("2012-02-15 11:44")
    TrainingPlanActivity getTrainingPlanActivity(Long id);

    
    @com.kingnod.core.annotation.Generated("2012-02-15 11:44")
    int saveTrainingPlanActivity(TrainingPlanActivity trainingPlanActivity);

    
    @com.kingnod.core.annotation.Generated("2012-02-15 11:44")
    int deleteTrainingPlanActivity(TrainingPlanActivity trainingPlanActivity);

    
    @com.kingnod.core.annotation.Generated("2012-02-15 11:44")
    int deleteTrainingPlanActivityByIds(Long[] ids);

    
    @com.kingnod.core.annotation.Generated("2012-02-15 11:44")
    PagingResult<TrainingPlanActivity> findTrainingPlanActivity(Criteria criteria);
}