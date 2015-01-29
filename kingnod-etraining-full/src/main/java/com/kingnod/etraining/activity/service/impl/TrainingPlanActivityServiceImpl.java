package com.kingnod.etraining.activity.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.activity.dao.TrainingPlanActivityDAO;
import com.kingnod.etraining.activity.entity.TrainingPlanActivity;
import com.kingnod.etraining.activity.service.TrainingPlanActivityService;

@org.springframework.stereotype.Service
public class TrainingPlanActivityServiceImpl implements TrainingPlanActivityService {

    @Autowired
    protected TrainingPlanActivityDAO trainingPlanActivityDAO;


    public TrainingPlanActivity getTrainingPlanActivity(Long id) {
        return trainingPlanActivityDAO.get(id);
    }

    public int saveTrainingPlanActivity(TrainingPlanActivity trainingPlanActivity) {
        int count = 0;
        IdEntity<Long> idEntity = (IdEntity)trainingPlanActivity;
        if(null != idEntity.getId() && null != trainingPlanActivityDAO.get(idEntity.getId())){
            count = trainingPlanActivityDAO.update(trainingPlanActivity);
        }else{
            count = trainingPlanActivityDAO.insert(trainingPlanActivity);
        }
        return count;
    }

    public int deleteTrainingPlanActivity(TrainingPlanActivity trainingPlanActivity) {
        return trainingPlanActivityDAO.delete(trainingPlanActivity);
    }

    public int deleteTrainingPlanActivityByIds(Long[] ids) {
        return trainingPlanActivityDAO.deleteById(ids);
    }

    public PagingResult<TrainingPlanActivity> findTrainingPlanActivity(Criteria criteria) {
        return trainingPlanActivityDAO.findPagingResult(criteria);
    }
}
