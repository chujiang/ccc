package com.kingnod.etraining.resource.service;

import java.util.List;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.resource.entity.ScoreRelation;


    @com.kingnod.core.annotation.Generated("2012-02-27 17:33")
public interface ScoreRelationService {

    
    @com.kingnod.core.annotation.Generated("2012-02-27 17:33")
    ScoreRelation getScoreRelation(Long id);

    
    @com.kingnod.core.annotation.Generated("2012-02-27 17:33")
    int saveScoreRelation(ScoreRelation scoreRelation);

    
    @com.kingnod.core.annotation.Generated("2012-02-27 17:33")
    int deleteScoreRelation(ScoreRelation scoreRelation);

    
    @com.kingnod.core.annotation.Generated("2012-02-27 17:33")
    int deleteScoreRelationByIds(Long[] ids);

    
    @com.kingnod.core.annotation.Generated("2012-02-27 17:33")
    PagingResult<ScoreRelation> findScoreRelation(Criteria criteria);
    
    List<ScoreRelation> findByLearnerScoreId(Long lsId);
}