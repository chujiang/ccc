package com.kingnod.etraining.exam.dao;

import java.util.List;

import com.kingnod.core.dao.EntityDAO;
import com.kingnod.etraining.exam.entity.ConditionRule;
import com.kingnod.etraining.exam.entity.GeneratingPaperScope;
import com.kingnod.etraining.exam.entity.TestGroup;

@com.kingnod.core.annotation.Generated("2012-05-09 17:57")
public interface GeneratingPaperScopeDAO extends EntityDAO<GeneratingPaperScope, Long> {

	/**
	 * 根据 examPaperId  查询自动组卷范围列表
	 * @param atyPaperId
	 * @return
	 */
	List<GeneratingPaperScope> findScope(TestGroup testGroup);

	/**
	 * 根据条件计算试题数
	 * @param conditionRule
	 * @return
	 */
	Integer totalQuestionNumber(ConditionRule conditionRule);

}