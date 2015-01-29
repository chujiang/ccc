package com.kingnod.etraining.exam.dao;

import java.util.List;

import com.kingnod.core.dao.MybatisEntityDAO;
import com.kingnod.etraining.exam.entity.GeneratingPaperRule;
import com.kingnod.etraining.exam.entity.TestGroup;

@org.springframework.stereotype.Repository

    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
public class GeneratingPaperRuleDAOImpl extends MybatisEntityDAO<GeneratingPaperRule, Long> implements GeneratingPaperRuleDAO {

	/*
	 * 根据 试卷ID  查询规则列表
	 * (non-Javadoc)
	 * @see com.kingnod.etraining.exam.dao.GeneratingPaperRuleDAO#findRule(com.kingnod.etraining.exam.entity.TestGroup)
	 */
	@SuppressWarnings("unchecked")
	public List<GeneratingPaperRule> findRule(TestGroup testGroup) {
		return getSqlSession().selectList("findAllGeneratingPaperRule", testGroup);
	}

	/*
	 * 计算试卷中需要动态抽题的题目总数量
	 * (non-Javadoc)
	 * @see com.kingnod.etraining.exam.dao.GeneratingPaperRuleDAO#findTotalAmountQuestion(java.lang.Long)
	 */
	public Integer findTotalAmountQuestion(Long examPaperId) {
		return (Integer) getSqlSession().selectOne("totalAmountQuestion", examPaperId);
	}
	
	/*计算当前类型的题目数量
	 * (non-Javadoc)
	 * @see com.kingnod.etraining.exam.dao.GeneratingPaperRuleDAO#countByTestGroupIdAndPaperId(com.kingnod.etraining.exam.entity.GeneratingPaperRule)
	 */
	public int countByTestGroupIdAndPaperId(GeneratingPaperRule rule) {
		return (Integer) getSqlSession().selectOne("findByTotalQuestionNumber", rule);
	}
}