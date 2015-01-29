package com.kingnod.etraining.exam.service;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.exam.entity.Knowledge;
import com.kingnod.etraining.exam.entity.Question;
import java.util.List;

@com.kingnod.core.annotation.Generated("2012-04-11 17:04")
public interface KnowledgeService {
	/**
	 * 查询出所有与该知识点相关联的试题
	 * @return
	 */
	List<Question> findInteractionQuestion(Long[] ids);

	@com.kingnod.core.annotation.Generated("2012-04-11 17:04")
	Knowledge getKnowledge(Long id);

	@com.kingnod.core.annotation.Generated("2012-04-11 17:04")
	int saveKnowledge(Knowledge knowledge);

	@com.kingnod.core.annotation.Generated("2012-04-11 17:04")
	int deleteKnowledge(Knowledge knowledge);

	@com.kingnod.core.annotation.Generated("2012-04-11 17:04")
	int deleteKnowledgeByIds(Long[] ids);

	@com.kingnod.core.annotation.Generated("2012-04-11 17:04")
	PagingResult<Knowledge> findKnowledge(Criteria criteria);

	/**
	 * 查询文件夹名称
	 */
	String findFolderNameByFolderId(Long folderId);
}