package com.kingnod.etraining.exam.dao;

import java.util.List;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.dao.EntityDAO;
import com.kingnod.etraining.activity.entity.ExamineesHistory;
import com.kingnod.etraining.exam.entity.TestGroup;

@com.kingnod.core.annotation.Generated("2012-04-12 17:54")
public interface TestGroupDAO extends EntityDAO<TestGroup, Long> {
	
	Integer findMaxByGroupSeq(long paperId);

	List<TestGroup> findByGroupSeq(TestGroup testGroup);

	Integer updateGroupSeq(TestGroup testGroup);

	List<TestGroup> findBytestGroupId(Criteria buildCriteria);

	TestGroup findSocreQuestionNumber(Long id);

	/**
	 * 获取试卷名称
	 * @param examPaperId
	 * @return
	 */
	String findPaperName(Long examPaperId);

	/**
	 * 根据试卷ID、阅卷方式，查询试卷下所有测试区的总分数
	 * @param examPaperId
	 * @param readingType
	 * @return
	 */
	Integer findTestGroupTotalScore(Long examPaperId, String readingType);

	/**
	 * 获取某个考试活动的测试区
	 */
	List<TestGroup> findPaPerTestGroupByExamId(Long examId);
	
	/**
	 * 根据试卷Id，获取某个考试活动的测试区
	 */
	List<TestGroup> findPaPerTestGroupByPaperId(Long paperId);

	/**
	 * 
	 * @param history
	 * @return
	 */
	List<TestGroup> findTestGroups(ExamineesHistory history);

	/**
	 * 查询	当前题纲下 所有手工组卷添加的试题Id
	 * @param testGroup
	 * @return
	 */
	List<Long> findQuestionId(TestGroup testGroup);

}