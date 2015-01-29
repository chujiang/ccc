package com.kingnod.etraining.exam.service;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.exam.entity.GeneratingPaperRule;
import com.kingnod.etraining.exam.entity.GeneratingPaperScope;
import java.util.List;

@com.kingnod.core.annotation.Generated("2012-05-18 11:25")
public interface GeneratingPaperScopeService {
	/**
	 * setter 题库的题目总量
	 * @param scopeList
	 * @param ruleList
	 * @return
	 */
	List<GeneratingPaperRule> setQuantityQuestion(List<GeneratingPaperScope> scopeList, List<GeneratingPaperRule> ruleList);

	/**
	 * 根据 folderId 查询题库试题总数
	 * @param scopeList
	 * @param questionType
	 * @return
	 */
	Integer findQuestionNumberSize(List<GeneratingPaperScope> scopeList, GeneratingPaperRule rule);

	@com.kingnod.core.annotation.Generated("2012-05-18 11:25")
	GeneratingPaperScope getGeneratingPaperScope(Long id);

	@com.kingnod.core.annotation.Generated("2012-05-18 11:25")
	int saveGeneratingPaperScope(GeneratingPaperScope generatingPaperScope);

	@com.kingnod.core.annotation.Generated("2012-05-18 11:25")
	int deleteGeneratingPaperScope(GeneratingPaperScope generatingPaperScope);

	@com.kingnod.core.annotation.Generated("2012-05-18 11:25")
	int deleteGeneratingPaperScopeByIds(Long[] ids);

	@com.kingnod.core.annotation.Generated("2012-05-18 11:25")
	PagingResult<GeneratingPaperScope> findGeneratingPaperScope(Criteria criteria);

	/**
	 * 删除题纲下面 所有的组卷范围
	 * @param examPaperId
	 * @param testGroupId
	 * @return
	 */
	int deleteScopeById(Long examPaperId, Long testGroupId);
}