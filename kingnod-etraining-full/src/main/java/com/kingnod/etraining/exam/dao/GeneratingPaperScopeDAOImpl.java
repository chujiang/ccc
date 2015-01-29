package com.kingnod.etraining.exam.dao;

import java.util.List;

import com.kingnod.core.dao.MybatisEntityDAO;
import com.kingnod.etraining.exam.entity.ConditionRule;
import com.kingnod.etraining.exam.entity.GeneratingPaperScope;
import com.kingnod.etraining.exam.entity.TestGroup;

@org.springframework.stereotype.Repository

    @com.kingnod.core.annotation.Generated("2012-05-09 17:57")
public class GeneratingPaperScopeDAOImpl extends MybatisEntityDAO<GeneratingPaperScope, Long> implements GeneratingPaperScopeDAO {

	/*
	 * 根据 examPaperId  查询自动组卷范围列表
	 * (non-Javadoc)
	 * @see com.kingnod.etraining.exam.dao.GeneratingPaperScopeDAO#findScope(com.kingnod.etraining.exam.entity.TestGroup)
	 */
	@SuppressWarnings("unchecked")
	public List<GeneratingPaperScope> findScope(TestGroup testGroup) {
		return getSqlSession().selectList("findAllGeneratingPaperScope", testGroup);
	}

	/*
	 * (non-Javadoc)
	 * @see com.kingnod.etraining.exam.dao.GeneratingPaperScopeDAO#totalQuestionNumber(com.kingnod.etraining.exam.entity.ConditionRule)
	 */
	public Integer totalQuestionNumber(ConditionRule conditionRule) {
		return (Integer) getSqlSession().selectOne("totalQuestionNumberByCondition", conditionRule);
	}

}