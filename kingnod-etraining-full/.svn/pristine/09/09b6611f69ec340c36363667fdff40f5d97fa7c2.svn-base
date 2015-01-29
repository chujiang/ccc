package com.kingnod.etraining.exam.service;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.exam.entity.GeneratingPaperRule;


    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
public interface GeneratingPaperRuleService {

    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    GeneratingPaperRule getGeneratingPaperRule(Long id);

    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    int saveGeneratingPaperRule(GeneratingPaperRule generatingPaperRule);

    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    int deleteGeneratingPaperRule(GeneratingPaperRule generatingPaperRule);

    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    int deleteGeneratingPaperRuleByIds(Long[] ids);

    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:16")
    PagingResult<GeneratingPaperRule> findGeneratingPaperRule(Criteria criteria);

    /**
     * 根据 examPaperId  计算出所有测试区下面所有规则的抽题总数量
     * 换一种说法 就是 计算出该试卷自动抽题的总数量
     * @param examPaperId
     * @return
     */
	Integer findTotalByPaperIdAndTestGroupId(Long examPaperId);

	/**
	 * 删除 题纲下面 所有的规则
	 * @param examPaperId
	 * @param testGroupId
	 * @return
	 */
	int deleteRuleById(Long examPaperId, Long testGroupId);

}