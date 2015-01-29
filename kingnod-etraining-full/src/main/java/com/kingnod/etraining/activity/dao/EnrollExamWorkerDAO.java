package com.kingnod.etraining.activity.dao;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.dao.EntityDAO;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.activity.entity.EnrollExamWorker;


    @com.kingnod.core.annotation.Generated("2012-04-06 09:33")
public interface EnrollExamWorkerDAO extends EntityDAO<EnrollExamWorker, Long> {
    	PagingResult<EnrollExamWorker> findByExaminationId(Criteria criteria);
}