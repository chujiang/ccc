package com.kingnod.etraining.exam.dao;

import com.kingnod.core.dao.EntityDAO;
import com.kingnod.etraining.exam.entity.Knowledge;
import com.kingnod.etraining.exam.entity.Question;
import java.util.List;

@com.kingnod.core.annotation.Generated("2012-04-11 17:04")
public interface KnowledgeDAO extends EntityDAO<Knowledge, Long> {
	/**
	 * 查询出所有与该知识点相关联的试题
	 * @return
	 */
	List<Question> findQuestion(Long id);

	/**
	 * 查询文件夹名称
	 */
	String findFolderName(Long folderId);

}