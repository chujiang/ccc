package com.kingnod.etraining.exam.service;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.exam.entity.Paper;
import com.kingnod.etraining.exam.entity.Question;
import com.kingnod.etraining.exam.entity.TestGroup;
import java.util.List;

@com.kingnod.core.annotation.Generated("2012-04-12 17:54")
public interface TestGroupService {
	/**
	 * 查询测试区分数 、试题数
	 * 
	 * @param id
	 * @return
	 */
	TestGroup findSocreAndQuestionNumber(Long id);

	void movebleTestGroup(TestGroup model);

	Integer deleteTestGroupByPaperId(Long[] ids);

	List<Question> batchPreview(Long[] testGroupId);

	@com.kingnod.core.annotation.Generated("2012-04-12 17:54")
	TestGroup getTestGroup(Long id);

	@com.kingnod.core.annotation.Generated("2012-04-12 17:54")
	int saveTestGroup(TestGroup testGroup);

	@com.kingnod.core.annotation.Generated("2012-04-12 17:54")
	int deleteTestGroup(TestGroup testGroup);

	@com.kingnod.core.annotation.Generated("2012-04-12 17:54")
	int deleteTestGroupByIds(Long[] ids);

	@com.kingnod.core.annotation.Generated("2012-04-12 17:54")
	PagingResult<TestGroup> findTestGroup(Criteria criteria);

	/**
	 * 获取试卷名称
	 * @return
	 */
	String findPaperNameByPaperId(Long examPaperId);

	/**
	 * 获取试卷信息
	 * @param examPaperId
	 * @return
	 */
	Paper getPaper(long examPaperId);
	
	/**
	 * 测试区组卷是否完成
	 * @param testGroup
	 * @param examPaperId
	 * @return
	 */
	boolean isComplete(TestGroup testGroup, Long examPaperId);
	
	/**
	 * 获取某个考试活动的测试区
	 */
	List<TestGroup> findPaPerTestGroupByExamId(Long examId);
	
	/**
	 * 当新增或删除测试区时，需要重新计算试卷总分
	 */
	void resetPaperTotalScore(Long paperId);
	
	/**
	 * 根据试卷Id，获取某个考试活动的测试区
	 */
	List<TestGroup> findPaPerTestGroupByPaperId(Long paperId);
}