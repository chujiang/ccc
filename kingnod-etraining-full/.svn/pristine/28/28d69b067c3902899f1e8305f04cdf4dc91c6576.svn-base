package com.kingnod.etraining.exam.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.criteria.Order;
import com.kingnod.core.extensions.struts2.action.EntityAction;
import com.kingnod.core.extensions.struts2.action.FilterableEntityAction;
import com.kingnod.core.extensions.struts2.annotation.ErrorMapping;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.core.util.StringUtils;
import com.kingnod.core.util.collection.ListUtils;
import com.kingnod.core.util.collection.MapUtils;
import com.kingnod.core.util.web.Struts2Utils;
import com.kingnod.etraining.exam.ExamConstant;
import com.kingnod.etraining.exam.entity.GeneratingPaperRule;
import com.kingnod.etraining.exam.entity.GeneratingPaperScope;
import com.kingnod.etraining.exam.entity.Question;
import com.kingnod.etraining.exam.entity.QuestionTestGroup;
import com.kingnod.etraining.exam.entity.TestGroup;
import com.kingnod.etraining.exam.service.GeneratingPaperRuleService;
import com.kingnod.etraining.exam.service.GeneratingPaperScopeService;
import com.kingnod.etraining.exam.service.QuestionTestGroupService;
import com.kingnod.etraining.exam.service.TestGroupService;

@org.springframework.stereotype.Controller
@Namespace("/exm")
@Results({ 
	@Result(name = EntityAction.RELOAD, type = "redirectAction", params = {"actionName", "test-group", "namespace", "/exm", "examPaperId", "${examPaperId}", "folderId", "${folderId}"}), 
	@Result(name = "auto", location = "/WEB-INF/content/exm/auto-test-group-input.jsp")
})
@com.kingnod.core.annotation.Generated("2012-04-12 17:46")
public class TestGroupAction extends FilterableEntityAction<TestGroup, Long> {
	private static final long serialVersionUID = 9141890746823569662L;
	private Long examPaperId;
	private Long folderId;
	private Long testGroupId;
	private List<TestGroup> testGroupList;
	private String paperName;
	private String editTable; // 是否可以修改
	
	public String newTestGroup() {
		return INPUT;
	}
	
	public String newAutoTestGroup() {
		return "auto";
	}

	@Override
	public String list() throws Exception {
		// 查询题库名称
		paperName = testGroupService.findPaperNameByPaperId(examPaperId);
		CriteriaBuilder cb = Cnd.builder(TestGroup.class);
		afterPreparedCriteriaBuilder(cb);
		PagingResult<TestGroup> pagingResult = testGroupService.findTestGroup(cb.buildCriteria().useLimitit(false));
		testGroupList = pagingResult.getResult();
		if(null != testGroupList) {	// 试卷组卷策略中，给左边的测试区添加图标，以示区别完成或未完成状态。
			for(TestGroup testGroup : testGroupList) {
				boolean isComplete = testGroupService.isComplete(testGroup, examPaperId);
				testGroup.setComplete(isComplete);
			}
		}
		request.setAttribute("testGroupList", testGroupList);
		request.setAttribute("isNew", true);
		return SUCCESS;
	}
	
	@Override
	@ErrorMapping(result=ExamConstant.ACTION_JSONRESULT)
	public String save() throws Exception {
		// 查询该试卷是否已发布  如果是发布状态   则不可以再组卷
		testGroupService.getPaper(examPaperId);
		super.save();
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set(ExamConstant.ACTION_JSONROOT, MapUtils.mapByAarray("isNew",true));
		testGroupService.resetPaperTotalScore(examPaperId);	//重设试卷总分
		return ExamConstant.ACTION_JSONRESULT;
	}
	@Override
	@ErrorMapping(result=EntityAction.RELOAD)
	public String delete() throws Exception {
		if(null != testGroupId && null != examPaperId) {
			// 查询该试卷是否已发布  如果是发布状态   则不可以再组卷
			testGroupService.getPaper(examPaperId);
			String pattern = this.getModel().getGeneratorPaperPattern();
			// 如果是自动组卷  则删除  组卷范围 与  规则
			if(StringUtils.isNotEmpty(pattern) && ExamConstant.GENERATOR_PAPER_A.equals(pattern)) {
				scopeService.deleteScopeById(examPaperId, testGroupId);
				ruleService.deleteRuleById(examPaperId, testGroupId);
			} else {
				// 否则  删除 手工添加过的试题
				questionTestGroupService.deletequestionTestGroupByPaperId(testGroupId, examPaperId);
			}
			testGroupService.deleteTestGroupByIds(new Long[] { testGroupId });
			testGroupService.resetPaperTotalScore(examPaperId);	//重设试卷总分
		}
		return RELOAD;
	}

	/**
	 * 处理在测试区中批量预览
	 * 
	 * @return
	 */
	public String preview() {
		Long[] testGroupId = this.getIdValues();
		List<Question> quesList = testGroupService.batchPreview(testGroupId);
		request.setAttribute("page", quesList);
		return ExamConstant.PREVIEW;
	}

	@ErrorMapping(result=EntityAction.RELOAD)
	public String moveble() {
		// 查询该试卷是否已发布  如果是发布状态   则不可以再组卷
		testGroupService.getPaper(examPaperId);
		testGroupService.movebleTestGroup(this.getModel());
		return EntityAction.RELOAD;
	}
	
	@Autowired
	private QuestionTestGroupService questionTestGroupService;
	@Autowired
	private GeneratingPaperRuleService ruleService;
	@Autowired
	private GeneratingPaperScopeService scopeService;

	@Autowired
	@com.kingnod.core.annotation.Generated("2012-04-12 17:46")
	private TestGroupService testGroupService;
	
	@Override
	protected void afterPreparedCriteriaBuilder(CriteriaBuilder cb) {
		if (!"".equals(examPaperId) && 0 != examPaperId) {
			cb.andGroup(Cnd.builder().andEQ("examPaperId", examPaperId));
			cb.orderBy("groupSeq", Order.ASC);
		}
	}

	public List<TestGroup> getTestGroupList() {
		return testGroupList;
	}

	public void setTestGroupList(List<TestGroup> testGroupList) {
		this.testGroupList = testGroupList;
	}

	public Long getFolderId() {
		return folderId;
	}

	public void setFolderId(Long folderId) {
		this.folderId = folderId;
	}

	@com.kingnod.core.annotation.Generated("2012-04-12 17:46")
	public String filterDefines() {
		return "exm.testGroupFilterItems";
	}

	@com.kingnod.core.annotation.Generated("2012-04-12 17:46")
	protected Object getEntityService() {
		return this.testGroupService;
	}

	public String getPaperName() {
		return paperName;
	}

	public void setPaperName(String paperName) {
		this.paperName = paperName;
	}

	public Long getTestGroupId() {
		return testGroupId;
	}

	public void setTestGroupId(Long testGroupId) {
		this.testGroupId = testGroupId;
	}

	@Override
	@ErrorMapping(result=INPUT)
	public String input() throws Exception {
		CriteriaBuilder cb = Cnd.builder(QuestionTestGroup.class);
		Long[] ids = this.getIdValues();
		if(null != ids && 0 != ids.length) {
			cb.andEQ("testGroupId", ids[0]).andEQ("examPaperId", examPaperId);
			List<QuestionTestGroup> qtgList = questionTestGroupService.findQuestionTestGroup(cb.buildCriteria()).getResult();
			List<GeneratingPaperScope> scopeList = scopeService.findGeneratingPaperScope(cb.buildCriteria()).getResult();
			List<GeneratingPaperRule> ruleList = ruleService.findGeneratingPaperRule(cb.buildCriteria()).getResult();
			if((ListUtils.isEmpty(qtgList)) && (ListUtils.isEmpty(ruleList)) && ListUtils.isEmpty(scopeList)) {
				editTable = "yes";
			} else {
				editTable = "no";
			}
			request.setAttribute("editTable", editTable);
		} else {
			editTable = "yes";
			request.setAttribute("editTable", editTable);
		}
		return super.input();
	}

	public String getEditTable() {
		return editTable;
	}

	public void setEditTable(String editTable) {
		this.editTable = editTable;
	}

	public Long getExamPaperId() {
		return examPaperId;
	}

	public void setExamPaperId(Long examPaperId) {
		this.examPaperId = examPaperId;
	}
}