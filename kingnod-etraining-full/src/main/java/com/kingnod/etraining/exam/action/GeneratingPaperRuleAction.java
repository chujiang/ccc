package com.kingnod.etraining.exam.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.extensions.struts2.action.EntityAction;
import com.kingnod.core.extensions.struts2.action.FilterableEntityAction;
import com.kingnod.core.extensions.struts2.annotation.ErrorMapping;
import com.kingnod.core.pager.Pager;
import com.kingnod.core.util.StringUtils;
import com.kingnod.core.util.collection.ListUtils;
import com.kingnod.core.util.web.Struts2Utils;
import com.kingnod.etraining.exam.ExamConstant;
import com.kingnod.etraining.exam.entity.GeneratingPaperRule;
import com.kingnod.etraining.exam.entity.GeneratingPaperScope;
import com.kingnod.etraining.exam.entity.TestGroup;
import com.kingnod.etraining.exam.service.GeneratingPaperRuleService;
import com.kingnod.etraining.exam.service.GeneratingPaperScopeService;
import com.kingnod.etraining.exam.service.TestGroupService;

@org.springframework.stereotype.Controller
@Namespace("/exm")
@Results
({
	@Result(name = EntityAction.RELOAD, type = "redirectAction", params = { "actionName", "generating-paper-rule", "namespace", "/exm", "testGroupId", "${testGroupId}", "examPaperId", "${examPaperId}", "questionType", "${questionType}", "type", "${type}"})
})

    @com.kingnod.core.annotation.Generated("2012-05-09 10:08")
public class GeneratingPaperRuleAction extends FilterableEntityAction<GeneratingPaperRule, Long> {
	
	private Long examPaperId; // 试卷ID
	private Long testGroupId; // 测试区ID
	private List<GeneratingPaperRule> ruleList;
	private List<GeneratingPaperScope> scopeList;
	private Integer questionNumber;
	private TestGroup testGroup;
	private String questionType; // 试题类型
	private String type; // 题纲中的试题类型
	private Float testGroupTotalScore; // 测试区总分
	/** 
	 * 自动组卷规则action
	 */
	private static final long serialVersionUID=-5127548771548904870L;
	
	@Override
	@ErrorMapping(result=INPUT)
	public String save() throws Exception {
		// 查询该试卷是否已发布  如果是发布状态   则不可以再组卷
		testGroupService.getPaper(examPaperId);
		GeneratingPaperRule rule = this.getModel();
		Integer already = this.findQuestionTypeAlready(rule);
		if(already == -2) {
			ServletActionContext.getValueStack(Struts2Utils.getRequest()).set(ExamConstant.ACTION_JSONROOT, -6);
			return ExamConstant.ACTION_JSONRESULT;
		}
		// 验证 抽取的试题不能为零或负数
		if(0 >= rule.getAmountQuestion()) {
			ServletActionContext.getValueStack(Struts2Utils.getRequest()).set(ExamConstant.ACTION_JSONROOT, -4);
			return ExamConstant.ACTION_JSONRESULT;
		}
		// 验证 试题分数 不能为零或负数
		if(0 >= rule.getEveryQuestionScore().intValue()) {
			ServletActionContext.getValueStack(Struts2Utils.getRequest()).set(ExamConstant.ACTION_JSONROOT, -5);
			return ExamConstant.ACTION_JSONRESULT;
		}
		// 查询 组卷范围
		scopeList = generatingPaperScopeService.findGeneratingPaperScope(Cnd.builder(GeneratingPaperScope.class).andEQ("examPaperId", examPaperId).andEQ("testGroupId", testGroupId).buildCriteria()).getResult();
		// 判断组卷范围列表为空  则不允许添加组卷规则
		if(ListUtils.isEmpty(scopeList)) {
			ServletActionContext.getValueStack(Struts2Utils.getRequest()).set(ExamConstant.ACTION_JSONROOT, -2);
			return ExamConstant.ACTION_JSONRESULT;
		}
		
		Integer totalQuestionNumber = generatingPaperScopeService.findQuestionNumberSize(scopeList, rule); // 题库总数量
		Integer amountQuestion = rule.getAmountQuestion(); // 考核题量
		CriteriaBuilder criteria = Cnd.builder(GeneratingPaperRule.class);
		criteria.andEQ("examPaperId", examPaperId).andEQ("testGroupId", testGroupId).andEQ("questionType", rule.getQuestionType());
		Long ruleId = rule.getId();
		if(ruleId != null && ruleId != 0) {
			criteria.andNotEQ("id", ruleId);
		}
		List<GeneratingPaperRule> ruleList = generatingPaperRuleService.findGeneratingPaperRule(criteria.buildCriteria()).getResult();
		for (GeneratingPaperRule r : ruleList) {
			amountQuestion += r.getAmountQuestion();
		}
		
		// 判断  整个测试区的抽题数量总和  是否大于题库总数量  如果是  则  return -1
		if(amountQuestion > totalQuestionNumber) {
			ServletActionContext.getValueStack(Struts2Utils.getRequest()).set(ExamConstant.ACTION_JSONROOT, -1);
			return ExamConstant.ACTION_JSONRESULT;
		}
		
		CriteriaBuilder cb = Cnd.builder(GeneratingPaperRule.class);
		cb.andEQ("examPaperId", examPaperId).andEQ("testGroupId", testGroupId);
		if(ruleId != null && ruleId != 0) {
			cb.andNotEQ("id", rule.getId());
		}
		List<GeneratingPaperRule> rList = generatingPaperRuleService.findGeneratingPaperRule(cb.buildCriteria()).getResult();
		Float totalScore = 0f; // 当前题纲下  所有规则的总分数
		Integer totalAmount = 0; // 当前题纲下  所有规则的考核题量总和
		for (GeneratingPaperRule ru : rList) {
			Integer amount = ru.getAmountQuestion();
			totalScore += amount * ru.getEveryQuestionScore();
			totalAmount += amount;
		}
		totalScore += amountQuestion * rule.getEveryQuestionScore();
		if(totalScore > testGroupTotalScore) {
			ServletActionContext.getValueStack(Struts2Utils.getRequest()).set(ExamConstant.ACTION_JSONROOT, -3);
			return ExamConstant.ACTION_JSONRESULT;
		}
		generatingPaperRuleService.saveGeneratingPaperRule(rule);
		return ExamConstant.ACTION_JSONRESULT;
	}
	
	@Override
	@ErrorMapping(result=EntityAction.RELOAD)
	public String delete() throws Exception {
		// 查询该试卷是否已发布  如果是发布状态   则不可以再组卷
		testGroupService.getPaper(examPaperId);
		return super.delete();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public String list() throws Exception {
		testGroup = testGroupService.getTestGroup(testGroupId);
		request.setAttribute("testGroup", testGroup);
		// 查询组卷规则
		ruleList = generatingPaperRuleService.findGeneratingPaperRule(Cnd.builder(GeneratingPaperRule.class).andEQ("examPaperId", examPaperId).andEQ("testGroupId", testGroupId).buildCriteria()).getResult();
		Pager rulePager = null;
		if(null == ruleList || 0 == ruleList.size()) {
			rulePager = new Pager().pageNo(1).pageNo(0);
		} else {
			rulePager = new Pager().pageNo(1).pageNo(ruleList.size());
		}
		// 查询 组卷范围
		scopeList = generatingPaperScopeService.findGeneratingPaperScope(Cnd.builder(GeneratingPaperScope.class).andEQ("examPaperId", examPaperId).andEQ("testGroupId", testGroupId).buildCriteria()).getResult();
		Pager scopePager = null;
		if(null == scopeList || 0 == scopeList.size()) {
			scopePager = new Pager().pageNo(1).pageNo(0);
		} else {
			scopePager = new Pager().pageNo(1).pageNo(scopeList.size());
		}
		// 查询题库的题目总数量
		ruleList = generatingPaperScopeService.setQuantityQuestion(scopeList, ruleList);
		rulePager.setResult(ruleList);
		request.setAttribute("ruleList", rulePager);
		scopePager.setResult(scopeList);
		request.setAttribute("scopeList", scopePager);
		return SUCCESS;
	}
	
	/**
	 * 查询题库 试题 数量
	 * @return
	 */
	public String findQuestionNumber() {
		GeneratingPaperRule rule = this.getModel();
		Integer already = this.findQuestionTypeAlready(rule);
		if(already == -2) {
			ServletActionContext.getValueStack(Struts2Utils.getRequest()).set(ExamConstant.ACTION_JSONROOT, already);
			return ExamConstant.ACTION_JSONRESULT;
		}
		scopeList = generatingPaperScopeService.findGeneratingPaperScope(Cnd.builder(GeneratingPaperScope.class).andEQ("examPaperId", examPaperId).andEQ("testGroupId", testGroupId).buildCriteria()).getResult();
		Integer totalQuestion = generatingPaperScopeService.findQuestionNumberSize(scopeList, rule);
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set(ExamConstant.ACTION_JSONROOT, totalQuestion);
		return ExamConstant.ACTION_JSONRESULT;
	}
	
	/**
	 * 判断当前类型的规则是否存在
	 * @param rule
	 * @return
	 */
	private Integer findQuestionTypeAlready(GeneratingPaperRule rule) {
		String questionType = rule.getQuestionType();
		if(StringUtils.isNotEmpty(questionType)) {
			List<GeneratingPaperRule> ruleList = generatingPaperRuleService.findGeneratingPaperRule(Cnd.builder(GeneratingPaperRule.class).andEQ("examPaperId", examPaperId).andEQ("testGroupId", testGroupId).andEQ("questionType", questionType).andNotEQ("id", rule.getId() != null ? rule.getId() : 0L).buildCriteria()).getResult();
			if(ListUtils.isNotEmpty(ruleList)) {
				return -2;
			}
		}
		return 0;
	}

    @Autowired
    @com.kingnod.core.annotation.Generated("2012-05-09 10:08")
    private GeneratingPaperRuleService generatingPaperRuleService;
    
    @Autowired
	private TestGroupService testGroupService;
    
    @Autowired
    private GeneratingPaperScopeService generatingPaperScopeService;


    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:08")
    public String filterDefines() {
        return "exm.generatingPaperRuleFilterItems";
    }

    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:08")
    protected Object getEntityService() {
        return this.generatingPaperRuleService;
    }

	public List<GeneratingPaperRule> getRuleList() {
		return ruleList;
	}

	public void setRuleList(List<GeneratingPaperRule> ruleList) {
		this.ruleList = ruleList;
	}

	public void setScopeList(List<GeneratingPaperScope> scopeList) {
		this.scopeList = scopeList;
	}

	public Integer getQuestionNumber() {
		return questionNumber;
	}

	public void setQuestionNumber(Integer questionNumber) {
		this.questionNumber = questionNumber;
	}

	public Long getExamPaperId() {
		return examPaperId;
	}

	public void setExamPaperId(Long examPaperId) {
		this.examPaperId = examPaperId;
	}

	public Long getTestGroupId() {
		return testGroupId;
	}

	public void setTestGroupId(Long testGroupId) {
		this.testGroupId = testGroupId;
	}

	public TestGroup getTestGroup() {
		return testGroup;
	}

	public void setTestGroup(TestGroup testGroup) {
		this.testGroup = testGroup;
	}

	public Float getTestGroupTotalScore() {
		return testGroupTotalScore;
	}

	public void setTestGroupTotalScore(Float testGroupTotalScore) {
		this.testGroupTotalScore = testGroupTotalScore;
	}

	public String getQuestionType() {
		return questionType;
	}

	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}