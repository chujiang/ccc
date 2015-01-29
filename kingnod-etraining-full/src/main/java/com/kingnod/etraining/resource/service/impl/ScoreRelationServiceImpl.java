package com.kingnod.etraining.resource.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.criteria.Order;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.exception.Exceptions;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.resource.dao.ScoreRelationDAO;
import com.kingnod.etraining.resource.entity.ScoreRelation;
import com.kingnod.etraining.resource.service.ScoreRelationService;

@org.springframework.stereotype.Service
public class ScoreRelationServiceImpl implements ScoreRelationService {

    @Autowired
    protected ScoreRelationDAO scoreRelationDAO;


    public ScoreRelation getScoreRelation(Long id) {
        return scoreRelationDAO.get(id);
    }

    public int saveScoreRelation(ScoreRelation scoreRelation) {
        int count = 0;
        IdEntity<Long> idEntity = (IdEntity)scoreRelation;
        if(null != idEntity.getId() && null != scoreRelationDAO.get(idEntity.getId())){
            count = scoreRelationDAO.update(scoreRelation);
        }else{
        	Criteria c = Cnd.builder(ScoreRelation.class).andEQ("scoreSheetId",scoreRelation.getScoreSheetId()).buildCriteria();
        	int s = scoreRelationDAO.countByCriteria(c);
        	if (s < 10) {
				scoreRelation.setLearnerScoreColumn("SCORE" + (s + 1));
				count = scoreRelationDAO.insert(scoreRelation);
			}
        	else
        	{
        		throw Exceptions.createAppException("res003001");
        	}
        }
        return count;
    }

    public int deleteScoreRelation(ScoreRelation scoreRelation) {
        return scoreRelationDAO.delete(scoreRelation);
    }

    public int deleteScoreRelationByIds(Long[] ids) {
        return scoreRelationDAO.deleteById(ids);
    }

    public PagingResult<ScoreRelation> findScoreRelation(Criteria criteria) {
        return scoreRelationDAO.findPagingResult(criteria);
    }

	public List<ScoreRelation> findByLearnerScoreId(Long lsId) {
		CriteriaBuilder cb = Cnd.builder(ScoreRelation.class);
		cb.andEQ("scoreSheetId", lsId).orderBy("LEARNER_SCORE_COLUMN", Order.ASC);
//		int s = scoreRelationDAO.countByCriteria(cb.buildCriteria());
		return scoreRelationDAO.findByCriteria(cb.buildCriteria());
	}
}