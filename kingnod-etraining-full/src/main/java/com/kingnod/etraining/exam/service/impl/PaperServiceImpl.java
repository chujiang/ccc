package com.kingnod.etraining.exam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.exception.Exceptions;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.core.util.collection.ListUtils;
import com.kingnod.etraining.exam.ExamConstant;
import com.kingnod.etraining.exam.dao.GeneratingPaperRuleDAO;
import com.kingnod.etraining.exam.dao.GeneratingPaperScopeDAO;
import com.kingnod.etraining.exam.dao.PaperDAO;
import com.kingnod.etraining.exam.dao.QuestionTestGroupDAO;
import com.kingnod.etraining.exam.dao.TestGroupDAO;
import com.kingnod.etraining.exam.entity.GeneratingPaperRule;
import com.kingnod.etraining.exam.entity.GeneratingPaperScope;
import com.kingnod.etraining.exam.entity.Paper;
import com.kingnod.etraining.exam.entity.QuestionTestGroup;
import com.kingnod.etraining.exam.entity.TestGroup;
import com.kingnod.etraining.exam.service.GeneratingPaperScopeService;
import com.kingnod.etraining.exam.service.PaperService;

@org.springframework.stereotype.Service
public class PaperServiceImpl implements PaperService {

	@Autowired
	protected PaperDAO paperDAO;
	@Autowired
	private QuestionTestGroupDAO questionTestGroupDAO;
	@Autowired
	private TestGroupDAO testGroupDAO;
	@Autowired
	private GeneratingPaperRuleDAO ruleDAO;
	@Autowired
	private GeneratingPaperScopeDAO scopeDAO;
	@Autowired
	private GeneratingPaperScopeService scopeService;

	public Paper getPaper(Long id) {
		return paperDAO.get(id);
	}

	public int savePaper(Paper paper) {
		int count = 0;
		IdEntity<Long> idEntity = (IdEntity<Long>) paper;
		if (null != idEntity.getId() && null != paperDAO.get(idEntity.getId())) {
			count = paperDAO.update(paper);
		} else {
			paper.setStatus(ExamConstant.STATUS_P);//setter试卷默认为未发布
			count = paperDAO.insert(paper);
		}
		return count;
	}

	public int deletePaper(Paper paper) {
		return paperDAO.delete(paper);
	}

	public int deletePaperByIds(Long[] ids) {
		return paperDAO.deleteById(ids);
	}

	public PagingResult<Paper> findPaper(Criteria criteria) {
		return paperDAO.findPagingResult(criteria);
	}
	
	/**
	 * 验证题纲下 所有根据规则抽取题目的   题目总分数  是否等于  题纲总分数
	 * @param testGroup
	 */
	public void provingAutoTest(TestGroup testGroup) {
		CriteriaBuilder cb = Cnd.builder(GeneratingPaperRule.class);
		cb.andEQ("testGroupId", testGroup.getId()).andEQ("examPaperId", testGroup.getExamPaperId());
		List<GeneratingPaperRule> ruleList = ruleDAO.findByCriteria(cb.buildCriteria());
		List<GeneratingPaperScope> scopeList = scopeDAO.findByCriteria(Cnd.builder(GeneratingPaperScope.class).andEQ("testGroupId", testGroup.getId()).andEQ("examPaperId", testGroup.getExamPaperId()).buildCriteria());
		Float ruleTotalScore = 0f;
		for (GeneratingPaperRule rule : ruleList) {
			int questionNumber = scopeService.findQuestionNumberSize(scopeList, rule);
			if(questionNumber < rule.getAmountQuestion()) {
				throw Exceptions.createAppException("exm002005");
			}
			ruleTotalScore += rule.getAmountQuestion() * rule.getEveryQuestionScore();
		}
		if(testGroup.getScore().intValue() != ruleTotalScore.intValue()) {
			throw Exceptions.createAppException("exm002008");
		}
		return;
	}

	/**
	 * 处理 -- 发布试卷
	 */
	public Integer publishQuestionByPaper(Paper paper, boolean bool) {
		if(null != paper) {
			Long paperId = paper.getId();
			List<TestGroup> testList = testGroupDAO.findByCriteria(Cnd.builder(TestGroup.class).andEQ("examPaperId", paperId).buildCriteria().addParam("recordStatus", "A"));
			if(bool) {
				if(ListUtils.isEmpty(testList)) return 0;
				// 如果该试卷中  有自动组卷  与  动态抽题的测试区   则只需要验证   试卷的总分数与测试区的总分数是否相等
				for (TestGroup testGroup : testList) {
					if("D".equals(testGroup.getExtractingQuestionWay()) && "A".equals(testGroup.getGeneratorPaperPattern())) {
						this.provingAutoTest(testGroup);
					} else {
						//比较  手工组卷的题纲下  所有的试题总分数  是否等与测试区总分数       所有的试题数量  是否等与测试区试题总数
						this.testTotalCompareQuestionScore(testGroup);
					}
				}
				paper.setStatus(ExamConstant.STATUS_R);
				//return paperDAO.updateByCriteria(paper, Cnd.builder(Paper.class).andEQ("id", paperId).buildCriteria());
			} else {
				Long[] aperIds = {paperId};
				if(findExamByPaperOfCount(aperIds)){//校验试卷是否有考试活动引用，如果有考试活动引用就不能取消发布
					paper.setStatus(ExamConstant.STATUS_P);
				}else{
					return 0;
				}
			}
			return paperDAO.updateByCriteria(paper, Cnd.builder(Paper.class).andEQ("id", paperId).buildCriteria());
		}
		return 0;
	}
	
	/**
	 * 能否取消发布，如果当前试卷有考试活动引用不能取消发布
	 * @param paperId
	 * @return boolean
	 */
	public boolean findExamByPaperOfCount(Long[] paperId){
		return paperDAO.findExamByPaperOfCount(paperId);
	}
	
	/**
	 * 比较  手工组卷的题纲下  所有的试题总分数  是否等  与测试区总分数
	 * ********************所有的试题数量  是否等  与测试区试题总数
	 * @param examPaperId
	 * @return
	 */
	public void testTotalCompareQuestionScore(TestGroup testGroup) {
		Integer testTotalScore = testGroup.getScore();
		Integer questionNumber = testGroup.getQuestionNumber();
		Double questionTotalScore = questionTestGroupDAO.findQuestionTotalScore(testGroup);
		int questionTestSize = questionTestGroupDAO.countByCriteria(Cnd.builder(QuestionTestGroup.class).andEQ("examPaperId", testGroup.getExamPaperId()).andEQ("testGroupId", testGroup.getId()).buildCriteria().addParam("recordStatus", "A"));
		if(!testTotalScore.equals(questionTotalScore.intValue())) {// 比较 测试区总分数  与  试卷总分数
			throw Exceptions.createAppException("exm002003");
		} else if(!questionNumber.equals(questionTestSize)) {// 比较  每个测试区下面的题目总数  与   测试区的题目总数
			throw Exceptions.createAppException("exm002004"); 
		}
		return;
	}

	/**
	 * 查询文件夹名称
	 */
	public String findFolderNameByFolderId(String folderId) {
		return paperDAO.findFolderName(folderId);
	}

}