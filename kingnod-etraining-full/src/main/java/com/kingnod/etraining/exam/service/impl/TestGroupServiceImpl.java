package com.kingnod.etraining.exam.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.criteria.Order;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.exception.Exceptions;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.core.util.collection.ListUtils;
import com.kingnod.etraining.exam.ExamConstant;
import com.kingnod.etraining.exam.dao.GeneratingPaperRuleDAO;
import com.kingnod.etraining.exam.dao.GeneratingPaperScopeDAO;
import com.kingnod.etraining.exam.dao.PaperDAO;
import com.kingnod.etraining.exam.dao.QuestionDAO;
import com.kingnod.etraining.exam.dao.QuestionTestGroupDAO;
import com.kingnod.etraining.exam.dao.TestGroupDAO;
import com.kingnod.etraining.exam.entity.GeneratingPaperRule;
import com.kingnod.etraining.exam.entity.GeneratingPaperScope;
import com.kingnod.etraining.exam.entity.Paper;
import com.kingnod.etraining.exam.entity.Question;
import com.kingnod.etraining.exam.entity.QuestionTestGroup;
import com.kingnod.etraining.exam.entity.TestGroup;
import com.kingnod.etraining.exam.service.GeneratingPaperScopeService;
import com.kingnod.etraining.exam.service.TestGroupService;

@org.springframework.stereotype.Service
public class TestGroupServiceImpl implements TestGroupService {

	@Autowired
	protected TestGroupDAO testGroupDAO;

	@Autowired
	private QuestionDAO questionDAO;
	
	@Autowired
	private PaperDAO paperDAO;

	@Autowired
	private QuestionTestGroupDAO questionTestGroupDAO;
	
	@Autowired
	private GeneratingPaperRuleDAO ruleDAO;
	
	@Autowired
	private GeneratingPaperScopeDAO scopeDAO;
	
	@Autowired
    private GeneratingPaperScopeService scopeService;

	public TestGroup getTestGroup(Long id) {
		return testGroupDAO.get(id);
	}

	public int saveTestGroup(TestGroup testGroup) {
		int count = 0;
		IdEntity<Long> idEntity = (IdEntity<Long>) testGroup;
		if (null != idEntity.getId() && null != testGroupDAO.get(idEntity.getId())) {
			count = testGroupDAO.update(testGroup);
			// 如果更新成功  则开始更新试卷的总分数
			if(count > 0) {
				Long examPaperId = testGroup.getExamPaperId();// 试卷Id
				int totalScore = 0; // 试卷总分数
				CriteriaBuilder cb = Cnd.builder(TestGroup.class);
				cb.andEQ("examPaperId", examPaperId).andEQ("recordStatus", "A")
				.andNotEQ("id", testGroup.getId());
				List<TestGroup> testGroupList = testGroupDAO.findByCriteria(cb.buildCriteria()); // 查询该试卷下面的所有测试区 
				for (TestGroup test : testGroupList) {
					totalScore += test.getScore();
				}
				totalScore += testGroup.getScore();
				Paper paper = new Paper();
				paper.setTotalScore(totalScore);
				paper.setId(examPaperId);
				paperDAO.updatePaperTotalScore(paper);
			}
		} else {
			Integer groupSeq = testGroupDAO.findMaxByGroupSeq(testGroup.getExamPaperId());
			if (null != groupSeq) {
				groupSeq += 1;
			} else
				groupSeq = 0;
			testGroup.setGroupSeq(Short.parseShort(String.valueOf(groupSeq)));
			count = testGroupDAO.insert(testGroup);
		}
		return count;
	}

	public int deleteTestGroup(TestGroup testGroup) {
		return testGroupDAO.delete(testGroup);
	}

	public int deleteTestGroupByIds(Long[] ids) {
		if (null == ids)
			return 0;
		CriteriaBuilder cb = Cnd.builder();
		CriteriaBuilder cb2 = Cnd.builder();
		cb2.andEQ("id", ids[0]);
		cb.andGroup(cb2);
		List<TestGroup> tgList = testGroupDAO.findByCriteria(cb.buildCriteria());
		long paperId = tgList.get(0).getExamPaperId();
		int cont = testGroupDAO.deleteById(ids);
		CriteriaBuilder cb3 = Cnd.builder();
		CriteriaBuilder cb4 = Cnd.builder();
		cb4.andEQ("EXAM_PAPER_ID", paperId);
		cb3.andGroup(cb4);
		cb3.orderBy("group_seq", Order.ASC);
		List<TestGroup> testGroupList = testGroupDAO.findByCriteria(cb3.buildCriteria());
		for (int i = 0; i < testGroupList.size(); i++) {
			TestGroup testg = testGroupList.get(i);
			short seq = testg.getGroupSeq();
			if (seq != i) {
				seq = (short) i;
				testg.setGroupSeq(seq);
				testGroupDAO.update(testg);
			}
		}
		return cont;
	}

	public PagingResult<TestGroup> findTestGroup(Criteria criteria) {
		return testGroupDAO.findPagingResult(criteria);
	}

	/*
	 * 0 -- 上移+ 1 -- 下移- 2 -- 至顶 3 -- 至尾
	 */
	public void movebleTestGroup(TestGroup testGroup) {
		String upOrDown = testGroup.getUpOrDown();
		Short seq = testGroup.getGroupSeq();
		TestGroup tGroup = null;
		List<TestGroup> tgList = testGroupDAO.findByGroupSeq(testGroup);
		if (null == tgList || 0 == tgList.size()) {
			return;
		}
		tGroup = tgList.get(0);
		testGroup.setGroupSeq(tGroup.getGroupSeq());
		// 至顶
		if ("2".equals(upOrDown)) {
			testGroupDAO.update(testGroup);
			testGroup.setGroupSeq((short) 1);
			testGroup.setNewGroupSeq(seq);
			testGroupDAO.updateGroupSeq(testGroup);
			return;
		}
		// 至尾
		if ("3".equals(upOrDown)) {
			testGroupDAO.update(testGroup);
			testGroup.setGroupSeq((short) 1);
			testGroup.setNewGroupSeq(seq);
			testGroupDAO.updateGroupSeq(testGroup);
			return;
		}
		tGroup.setGroupSeq(seq);
		testGroupDAO.update(tGroup);
		testGroupDAO.update(testGroup);
	}

	// 根据试卷id删除  组卷范围、组卷规则、题纲
	public Integer deleteTestGroupByPaperId(Long[] ids) {
		List<Long> idsList = new ArrayList<Long>();
		for (int i = 0; i < ids.length; i++) {
			idsList.add(ids[i]);
		}
		ruleDAO.deleteByCriteria(Cnd.builder(GeneratingPaperRule.class).andIn("examPaperId", idsList).buildCriteria()); // 删除组卷规则
		scopeDAO.deleteByCriteria(Cnd.builder(GeneratingPaperScope.class).andIn("examPaperId", idsList).buildCriteria());// 删除组卷范围
		return testGroupDAO.deleteByCriteria(Cnd.builder(TestGroup.class).andIn("examPaperId", idsList).buildCriteria()); // 删除题纲
	}

	/**
	 * 在测试区中处理批量预览 先得到 EXM_QUESTION_TEST_GROUP 表的ID 再根据ID查询得到questionId
	 * 把得到两个对象的数据进行比较 如果内容不相同 则以QuestionTestGroup为准 否则 反之
	 */
	public List<Question> batchPreview(Long[] testGroupId) {
		CriteriaBuilder cb = Cnd.builder();
		CriteriaBuilder cb2 = Cnd.builder();
		for (int i = 0; i < testGroupId.length; i++) {
			cb2.orEQ("TEST_GROUP_ID", testGroupId[i]);
		}
		cb.andGroup(cb2);
		List<QuestionTestGroup> qtgList = questionTestGroupDAO.findByCriteria(cb.buildCriteria());
		if (null == qtgList || 0 == qtgList.size()) {
			return new ArrayList<Question>();
		}
		CriteriaBuilder cb3 = Cnd.builder();
		CriteriaBuilder cb4 = Cnd.builder();
		for (int i = 0; i < qtgList.size(); i++) {
			QuestionTestGroup quesTestgroup = qtgList.get(i);
			cb4.orEQ("id", quesTestgroup.getQuestionId());
		}
		cb3.andGroup(cb4);
		List<Question> quesList = questionDAO.findByCriteria(cb3.buildCriteria());
		List<Question> questionList = new ArrayList<Question>();
		if (null != quesList && 0 != quesList.size()) {
			for (int i = 0; i < quesList.size(); i++) {
				QuestionTestGroup quesTestGroup = qtgList.get(i);
				Question ques = quesList.get(i);
				if (quesTestGroup.getQuestionId() == quesList.get(i).getId()) {
					Short degree = quesTestGroup.getDegree();
					float score = quesTestGroup.getScore();
					if (!ques.getDegree().equals(degree)) {
						ques.setDegree(degree);
					}
					if (!ques.getScore().equals(score)) {
						ques.setScore(score);
					}
				}
				questionList.add(ques);
			}
		}
		return questionList;
	}

	public TestGroup findSocreAndQuestionNumber(Long id) {
		return testGroupDAO.findSocreQuestionNumber(id);
	}

	/**
	 * 获取试卷名称
	 */
	public String findPaperNameByPaperId(Long examPaperId) {
		return testGroupDAO.findPaperName(examPaperId);
	}

	public Paper getPaper(long examPaperId) {
		Paper paper = paperDAO.get(examPaperId);
		String status = paper.getStatus();
		if(ExamConstant.STATUS_R.equals(status)) {
			throw Exceptions.createAppException("exm002002");
		}
		return paper;
	}

	/**
	 * 测试区组卷是否完成：如果题目数一致、总分数一致，就是完成，否则为未完成
	 */
	public boolean isComplete(TestGroup testGroup, Long examPaperId) {
		// 处理   自动组卷的测试区
		if(ExamConstant.GENERATOR_PAPER_A.equals(testGroup.getGeneratorPaperPattern())) {
			Float testScore = Float.parseFloat(testGroup.getScore().toString());
			CriteriaBuilder cb = Cnd.builder(GeneratingPaperRule.class);
			cb.andEQ("testGroupId", testGroup.getId()).andEQ("examPaperId", examPaperId);
			List<GeneratingPaperRule> ruleList = ruleDAO.findByCriteria(cb.buildCriteria());
			List<GeneratingPaperScope> scopeList = scopeDAO.findByCriteria(Cnd.builder(GeneratingPaperScope.class).andEQ("testGroupId", testGroup.getId()).andEQ("examPaperId", examPaperId).buildCriteria());
			if(!ListUtils.isEmpty(ruleList)) {
				Float totalScore = 0f;
				for (GeneratingPaperRule rule : ruleList) {
					int questionNumber = scopeService.findQuestionNumberSize(scopeList, rule);
					if(questionNumber < rule.getAmountQuestion()) return false;
					totalScore += rule.getEveryQuestionScore() * rule.getAmountQuestion();
				}
				if(totalScore.equals(testScore)) {
					return true;
				}
			}
			return false;
		}
		Integer questionNumber = testGroup.getQuestionNumber();
		Integer score = testGroup.getScore();
		if( null != questionNumber && null != score && questionNumber> 0 &&  score> 0) {
			Double totalScore = questionTestGroupDAO.findQuestionTotalScore(testGroup);
			int questions = questionTestGroupDAO.countByCriteria(Cnd.builder(QuestionTestGroup.class).andEQ("testGroupId", testGroup.getId()).andEQ("examPaperId", testGroup.getExamPaperId()).buildCriteria());
			if(testGroup.getQuestionNumber() == questions && NumberUtils.toDouble(testGroup.getScore().toString()) == totalScore) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 获取某个考试活动的测试区
	 */
	public List<TestGroup> findPaPerTestGroupByExamId(Long examId){
		return testGroupDAO.findPaPerTestGroupByExamId(examId);
	}
	
	


	/**
	 * 根据试卷ID、阅卷方式，查询试卷下所有测试区的总分数
	 * @param examPaperId
	 * @param readingType
	 * @return
	 */
	public void resetPaperTotalScore(Long paperId) {
		Integer totalScore = testGroupDAO.findTestGroupTotalScore(paperId, null);
		Paper paper = paperDAO.get(paperId);
		paper.setTotalScore(totalScore);
		paperDAO.update(paper);
	}
	
	/**
	 * 根据试卷Id，获取某个考试活动的测试区
	 */
	public List<TestGroup> findPaPerTestGroupByPaperId(Long paperId){
		return testGroupDAO.findPaPerTestGroupByPaperId(paperId);
	}
}