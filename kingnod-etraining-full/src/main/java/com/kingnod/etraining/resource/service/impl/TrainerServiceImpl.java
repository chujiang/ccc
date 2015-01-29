package com.kingnod.etraining.resource.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.resource.dao.TrainerDAO;
import com.kingnod.etraining.resource.entity.Trainer;
import com.kingnod.etraining.resource.service.TrainerService;

@org.springframework.stereotype.Service
public class TrainerServiceImpl implements TrainerService {

    @Autowired
    protected TrainerDAO trainerDAO;


    public Trainer getTrainer(Long id) {
        return trainerDAO.get(id);
    }

    public int saveTrainer(Trainer trainer) {
        int count = 0;
        IdEntity<Long> idEntity = (IdEntity)trainer;
        if(null != idEntity.getId() && null != trainerDAO.get(idEntity.getId())){
            count = trainerDAO.update(trainer);
        }else{
            count = trainerDAO.insert(trainer);
        }
        return count;
    }

    public int deleteTrainer(Trainer trainer) {
        return trainerDAO.delete(trainer);
    }

    public int deleteTrainerByIds(Long[] ids) {
        return trainerDAO.deleteById(ids);
    }

    public PagingResult<Trainer> findTrainer(Criteria criteria) {
        return trainerDAO.findPagingResult(criteria);
    }
    
    public Trainer getTrainerById(Long id){
    	return trainerDAO.getTrainerById(id);
    }
}
