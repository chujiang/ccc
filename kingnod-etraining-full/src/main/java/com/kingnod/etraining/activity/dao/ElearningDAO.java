package com.kingnod.etraining.activity.dao;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.dao.EntityDAO;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.activity.entity.Elearning;
import com.kingnod.etraining.activity.entity.ElearningSituation;


    @com.kingnod.core.annotation.Generated("2012-03-13 18:54")
public interface ElearningDAO extends EntityDAO<Elearning, Long> {
    	
    	public PagingResult<ElearningSituation>  findBySituation(Criteria criteria);

}