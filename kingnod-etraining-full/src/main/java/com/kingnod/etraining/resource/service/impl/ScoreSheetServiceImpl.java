package com.kingnod.etraining.resource.service.impl;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.resource.dao.ScoreSheetDAO;
import com.kingnod.etraining.resource.entity.ScoreSheet;
import com.kingnod.etraining.resource.service.ScoreSheetService;

import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class ScoreSheetServiceImpl implements ScoreSheetService {

    @Autowired
    protected ScoreSheetDAO scoreSheetDAO;


    public ScoreSheet getScoreSheet(Long id) {
        return scoreSheetDAO.get(id);
    }

    public int saveScoreSheet(ScoreSheet scoreSheet) {
        int count = 0;
        IdEntity<Long> idEntity = (IdEntity)scoreSheet;
        if(null != idEntity.getId() && null != scoreSheetDAO.get(idEntity.getId())){
            count = scoreSheetDAO.update(scoreSheet);
        }else{
            count = scoreSheetDAO.insert(scoreSheet);
        }
        return count;
    }

    public int deleteScoreSheet(ScoreSheet scoreSheet) {
        return scoreSheetDAO.delete(scoreSheet);
    }

    public int deleteScoreSheetByIds(Long[] ids) {
        return scoreSheetDAO.deleteById(ids);
    }

    public PagingResult<ScoreSheet> findScoreSheet(Criteria criteria) {
        return scoreSheetDAO.findPagingResult(criteria);
    }
}