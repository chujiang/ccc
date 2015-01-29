package com.kingnod.etraining.activity.dao;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.dao.MybatisEntityDAO;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.activity.entity.EnrollExamWorker;

@org.springframework.stereotype.Repository

    @com.kingnod.core.annotation.Generated("2012-04-06 09:33")
public class EnrollExamWorkerDAOImpl extends MybatisEntityDAO<EnrollExamWorker, Long> implements EnrollExamWorkerDAO {

	public PagingResult<EnrollExamWorker> findByExaminationId(Criteria criteria) {
		return pagingQuery(sqlId("countByExaminationId"),sqlId("findByExaminationId"),criteria);
	}

}