package com.kingnod.etraining.common.service;

import java.util.List;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.pager.Pager;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.activity.entity.EvaluationAuthority;
import com.kingnod.etraining.common.entity.Evaluation;
import com.kingnod.etraining.common.entity.Type;

@com.kingnod.core.annotation.Generated("2012-06-12 14:49")
public interface EvaluationService {

	@com.kingnod.core.annotation.Generated("2012-06-12 14:49")
	Evaluation getEvaluation(Long id);

	@com.kingnod.core.annotation.Generated("2012-06-12 14:49")
	int saveEvaluation(Evaluation evaluation);

	@com.kingnod.core.annotation.Generated("2012-06-12 14:49")
	int deleteEvaluation(Evaluation evaluation);

	@com.kingnod.core.annotation.Generated("2012-06-12 14:49")
	int deleteEvaluationByIds(Long[] ids);

	@com.kingnod.core.annotation.Generated("2012-06-12 14:49")
	PagingResult<Evaluation> findEvaluation(Criteria criteria);
	
	/**
	 * 查找评论类型
	 * @return
	 */
	List<Type> findEvaluationTypes(Type type);
	
	/**
	 * 获取评论权限
	 * @param activityType  活动类型
	 * @param activityId	活动ID
	 * @return
	 */
	EvaluationAuthority getEvaluationAuthority(Long activityId, String activityType);

	/**
	 * 
	 * @param activityId
	 * @param pager
	 * @return
	 */
	List<Evaluation> getEvaluations(Long activityId, Pager<Evaluation> pager);
}