package com.kingnod.etraining.exam.dao;

import java.util.List;

import com.kingnod.core.dao.MybatisEntityDAO;
import com.kingnod.etraining.exam.ExamConstant;
import com.kingnod.etraining.exam.entity.QuestionTestGroup;
import com.kingnod.etraining.exam.entity.TestGroup;

@org.springframework.stereotype.Repository
@com.kingnod.core.annotation.Generated("2012-02-29 10:15")
@SuppressWarnings("unchecked")
public class QuestionTestGroupDAOImpl extends MybatisEntityDAO<QuestionTestGroup, Long> implements QuestionTestGroupDAO {
	
	/**
	 * 根据条件  分别查出 上移  下移  至顶  至尾  的前一条数据或后一条
	 */
	public List<QuestionTestGroup> findBySequence(QuestionTestGroup quesgroup) {
		return getSqlSession().selectList(ExamConstant.FINDBYSEQUENCE, quesgroup);
	}

	/**
	 * 查询最大的sequence
	 */
	public Integer findMaxBySequenceOne(QuestionTestGroup questionTestGroup) {
		return (Integer) getSqlSession().selectOne(ExamConstant.FINDMAXBYSEQUENCEONE, questionTestGroup);
	}
	/**
	 * 更新所有满足条件的 sequence
	 */
	public Integer updateSequences(QuestionTestGroup questionTestGroup) {
		return getSqlSession().update(ExamConstant.UPDATEALLSEQUENCES, questionTestGroup);
	}

	/**
	 * 根据folderId 查询得到folderName
	 * @param folderId
	 * @param type
	 * @return folderName
	 */
	public String findFolderName(long folderId, String type) {
		return (String) getSqlSession().selectOne(ExamConstant.FINDFOLDERNAMEBYID, folderId);
	}

	public Double findQuestionTotalScore(TestGroup testGroup) {
		return (Double) getSqlSession().selectOne("findQuestionTotalScoreByTestGroup", testGroup);
	}
}