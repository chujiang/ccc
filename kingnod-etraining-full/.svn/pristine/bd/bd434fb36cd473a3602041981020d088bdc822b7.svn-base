package com.kingnod.etraining.resource.service.impl;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.resource.dao.LearnerScoreDAO;
import com.kingnod.etraining.resource.entity.LearnerScore;
import com.kingnod.etraining.resource.service.LearnerScoreService;

import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class LearnerScoreServiceImpl implements LearnerScoreService {

    @Autowired
    protected LearnerScoreDAO learnerScoreDAO;


    public LearnerScore getLearnerScore(Long id) {
        return learnerScoreDAO.get(id);
    }

    public int saveLearnerScore(LearnerScore learnerScore) {
        int count = 0;
        IdEntity<Long> idEntity = (IdEntity)learnerScore;
        if(null != idEntity.getId() && null != learnerScoreDAO.get(idEntity.getId())){
            count = learnerScoreDAO.update(learnerScore);
        }else{
            count = learnerScoreDAO.insert(learnerScore);
        }
        return count;
    }

    public int deleteLearnerScore(LearnerScore learnerScore) {
        return learnerScoreDAO.delete(learnerScore);
    }

    public int deleteLearnerScoreByIds(Long[] ids) {
        return learnerScoreDAO.deleteById(ids);
    }

    public PagingResult<LearnerScore> findLearnerScore(Criteria criteria) {
        return learnerScoreDAO.findPagingResult(criteria);
    }
}