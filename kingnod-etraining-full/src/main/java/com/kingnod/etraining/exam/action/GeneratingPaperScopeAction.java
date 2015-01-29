package com.kingnod.etraining.exam.action;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.extensions.struts2.action.EntityAction;
import com.kingnod.core.extensions.struts2.action.FilterableEntityAction;
import com.kingnod.core.extensions.struts2.annotation.ErrorMapping;
import com.kingnod.core.util.web.Struts2Utils;
import com.kingnod.etraining.exam.ExamConstant;
import com.kingnod.etraining.exam.entity.GeneratingPaperScope;
import com.kingnod.etraining.exam.service.GeneratingPaperScopeService;
import com.kingnod.etraining.exam.service.TestGroupService;

@org.springframework.stereotype.Controller
@Namespace("/exm")
@Results
({
	@Result(name = EntityAction.RELOAD, type = "redirectAction", params = { "actionName", "generating-paper-scope", "namespace", "/exm"}),
	@Result(name = "rule", type = "redirectAction", params = { "actionName", "generating-paper-rule", "namespace", "/exm", "examPaperId", "${examPaperId}", "testGroupId", "${testGroupId}", "questionType", "${questionType}"})
})

    @com.kingnod.core.annotation.Generated("2012-05-09 10:19")
public class GeneratingPaperScopeAction extends FilterableEntityAction<GeneratingPaperScope, Long> {
	/** 
	 * 自动组卷范围action
	 */
	private static final long serialVersionUID=-2007689384292309632L;
	
	private Long examPaperId; // 试卷ID
	private Long testGroupId; // 测试区ID
	private String questionType; // 试题类型
	
//	@Override
//	public String save() throws Exception {
//		super.save();
//		return "rule";
//	}
	
	@Override
	@ErrorMapping(result=INPUT)
	public String save()  {
		// 查询该试卷是否已发布  如果是发布状态   则不可以再组卷
		testGroupService.getPaper(examPaperId);
		try {
			super.save();
		} catch (Exception e) {
			e.printStackTrace();
			ServletActionContext.getValueStack(Struts2Utils.getRequest()).set(ExamConstant.ACTION_JSONROOT, -1);
			return ExamConstant.ACTION_JSONRESULT;
		}
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set(ExamConstant.ACTION_JSONROOT, 1);
		return ExamConstant.ACTION_JSONRESULT;
	}
	
	@Override
	@ErrorMapping(result="rule")
	public String delete() throws Exception {
		// 查询该试卷是否已发布  如果是发布状态   则不可以再组卷
		testGroupService.getPaper(examPaperId);
		super.delete();
		return "rule";
	}
	
	@Override
	@ErrorMapping(result=INPUT)
	public String input() throws Exception {
		// 查询该试卷是否已发布  如果是发布状态   则不可以再组卷
		testGroupService.getPaper(examPaperId);
		Long[] ids = this.getIdValues();
		if(null != ids && 0 != ids.length) {
			entity = generatingPaperScopeService.getGeneratingPaperScope(ids[0]);
		}
		return INPUT;
	}

    @Autowired
    @com.kingnod.core.annotation.Generated("2012-05-09 10:19")
    private GeneratingPaperScopeService generatingPaperScopeService;
    
    @Autowired
	private TestGroupService testGroupService;
    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:19")
    public String filterDefines() {
        return "exm.generatingPaperScopeFilterItems";
    }
    
    @com.kingnod.core.annotation.Generated("2012-05-09 10:19")
    protected Object getEntityService() {
        return this.generatingPaperScopeService;
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

	protected Long[] getIdValues() {
		String[] idsParam = request.getParameterValues("scopeIds");
		if(null != idsParam) {
			Long[] ids = new Long[idsParam.length];
			for (int i = 0; i < idsParam.length; i++) {
				ids[i] = Long.parseLong(idsParam[i]);
			}
			return ids;
		} 
		return null;
	}

	public String getQuestionType() {
		return questionType;
	}

	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}
}