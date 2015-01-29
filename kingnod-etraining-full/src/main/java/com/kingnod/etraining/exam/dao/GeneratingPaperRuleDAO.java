package com.kingnod.etraining.exam.dao;

import java.util.List;

import com.kingnod.core.dao.EntityDAO;
import com.kingnod.etraining.exam.entity.GeneratingPaperRule;
import com.kingnod.etraining.exam.entity.TestGroup;


    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
public interface GeneratingPaperRuleDAO extends EntityDAO<GeneratingPaperRule, Long> {

    	/**
         * 根据 试卷ID  查询规则列表
         * @param examPaperId
         * @return
         */
		List<GeneratingPaperRule> findRule(TestGroup testGroup);

		/**
		 * 根据 examPaperId 计算出所有测试区下面所有规则的抽题总数量
		 * 换一种说法 就是 计算出该试卷自动抽题的总数量
		 * @param examPaperId
		 * @return
		 */
		Integer findTotalAmountQuestion(Long examPaperId);
		
		/**
		 * 根据 testGroupId  与   examPaperId 查询得到题库题目的总数量
		 * @param testGroup
		 * @return
		 */
		int countByTestGroupIdAndPaperId(GeneratingPaperRule rule);

}