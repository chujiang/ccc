package com.kingnod.etraining.activity.service;

import java.io.InputStream;
import java.util.List;

import org.activiti.engine.impl.pvm.process.ActivityImpl;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.activity.entity.TrainingPlan;
import com.kingnod.etraining.workflow.entity.HistoryEntity;
import com.kingnod.etraining.workflow.entity.MyTask;


    @com.kingnod.core.annotation.Generated("2012-02-08 15:35")
public interface TrainingPlanService {

    
    @com.kingnod.core.annotation.Generated("2012-02-08 15:35")
    TrainingPlan getTrainingPlan(Long id);

    
    @com.kingnod.core.annotation.Generated("2012-02-08 15:35")
    int saveTrainingPlan(TrainingPlan trainingPlan);

    
    @com.kingnod.core.annotation.Generated("2012-02-08 15:35")
    int deleteTrainingPlan(TrainingPlan trainingPlan);

    
    @com.kingnod.core.annotation.Generated("2012-02-08 15:35")
    int deleteTrainingPlanByIds(Long[] ids);

    
    @com.kingnod.core.annotation.Generated("2012-02-08 15:35")
    PagingResult<TrainingPlan> findTrainingPlan(Criteria criteria);
    
    void release(Long id);
    
    void operateTask(String taskId,String approvalOpinion,String remarks,String approvalType);
    
    List<HistoryEntity> viewTask(String id);
    
    InputStream showImg(String name);
    
    ActivityImpl traceProcess(Long id);
    
    List<MyTask> selectTask();
    
    List<HistoryEntity> heTaskUser();
}