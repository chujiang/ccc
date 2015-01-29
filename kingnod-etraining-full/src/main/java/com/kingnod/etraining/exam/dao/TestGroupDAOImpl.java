package com.kingnod.etraining.exam.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.dao.MybatisEntityDAO;
import com.kingnod.core.util.collection.MapUtils;
import com.kingnod.etraining.activity.entity.ExamineesHistory;
import com.kingnod.etraining.exam.ExamConstant;
import com.kingnod.etraining.exam.entity.TestGroup;

@org.springframework.stereotype.Repository
@com.kingnod.core.annotation.Generated("2012-04-12 17:54")
public class TestGroupDAOImpl extends MybatisEntityDAO<TestGroup, Long> implements TestGroupDAO {

	public Integer findMaxByGroupSeq(long paperId) {
		return (Integer) getSqlSession().selectOne(ExamConstant.FINDMAXBYGROUPSEQ, paperId);
	}

	@SuppressWarnings("unchecked")
	public List<TestGroup> findByGroupSeq(TestGroup testGroup) {
		return getSqlSession().selectList(ExamConstant.FINDBYGROUPSEQ, testGroup);
	}

	public Integer updateGroupSeq(TestGroup testGroup) {
		return getSqlSession().update(ExamConstant.UPDATEALLGROUPSEQES, testGroup);
	}

	@SuppressWarnings("unchecked")
	public List<TestGroup> findBytestGroupId(Criteria criteria) {
		return getSqlSession().selectList(ExamConstant.FINDBYTESTGROUPIDS, criteria);
	}

	public TestGroup findSocreQuestionNumber(Long id) {
		return (TestGroup) getSqlSession().selectOne(ExamConstant.FINDSOCREANDQUESTIONNUMBER, id);
	}

	/**
	 * 获取试卷名称
	 */
	public String findPaperName(Long examPaperId) {
		return (String) getSqlSession().selectOne(ExamConstant.FINDPAPERNAME, examPaperId);
	}

	/**
	 * 根据试卷ID、阅卷方式，查询试卷下 所有测试区的总分数
	 */
	@SuppressWarnings("rawtypes")
	public Integer findTestGroupTotalScore(Long examPaperId, String readingType) {
		Map params = MapUtils.mapByAarray("examPaperId", examPaperId, "readingType", readingType);
		return (Integer) getSqlSession().selectOne("findTestTotalScoreByPaperId", params);
	}
	
	/**
	 * 根据活动Id，获取某个考试活动的测试区
	 */
	@SuppressWarnings("unchecked")
	public List<TestGroup> findPaPerTestGroupByExamId(Long examId) {
		Object obj = getSqlSession().selectList(ExamConstant.FINDPAPERTESTGROUPBYEXAMID, examId);
		if(obj != null && obj instanceof List){
			return (List<TestGroup>)obj;
		}
		return new ArrayList<TestGroup>();
	}
	
	/**
	 * 根据试卷Id，获取某个考试活动的测试区
	 */
	@SuppressWarnings("unchecked")
	public List<TestGroup> findPaPerTestGroupByPaperId(Long paperId) {
		Object obj = getSqlSession().selectList(ExamConstant.FINDPAPERTESTGROUPBYPAPERID, paperId);
		if(obj != null && obj instanceof List){
			return (List<TestGroup>)obj;
		}
		return new ArrayList<TestGroup>();
	}

	@SuppressWarnings("unchecked")
	public List<TestGroup> findTestGroups(ExamineesHistory history) {
		return getSqlSession().selectList("findAlreadyGeneratedQuestions", history);
	}

	@SuppressWarnings("unchecked")
	public List<Long> findQuestionId(TestGroup testGroup) {
		return getSqlSession().selectList("findAllQuestionId", testGroup);
	}
}