package com.kingnod.etraining.exam.dao;

import java.util.List;

import com.kingnod.core.dao.EntityDAO;
import com.kingnod.etraining.exam.entity.QuestionTestGroup;
import com.kingnod.etraining.exam.entity.TestGroup;

@com.kingnod.core.annotation.Generated("2012-02-29 10:15")
public interface QuestionTestGroupDAO extends EntityDAO<QuestionTestGroup, Long> {
	
	List<QuestionTestGroup> findBySequence(QuestionTestGroup quesgroup);

	Integer findMaxBySequenceOne(QuestionTestGroup questionTestGroup);

	Integer updateSequences(QuestionTestGroup questionTestGroup);

	/**
	 * 根据folderId 查询得到folderName
	 * @param folderId
	 * @param type
	 * @return folderName
	 */
	String findFolderName(long folderId, String type);

	/**
	 * 查询测试区下   所有试题的总分数
	 * @param testGroup
	 * @return
	 */
	Double findQuestionTotalScore(TestGroup testGroup);
}