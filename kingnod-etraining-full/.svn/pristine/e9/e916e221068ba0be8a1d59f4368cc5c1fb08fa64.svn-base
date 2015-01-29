package com.kingnod.etraining.exam.action;

import java.util.ArrayList;
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
import com.kingnod.core.util.StringUtils;
import com.kingnod.core.util.web.Struts2Utils;
import com.kingnod.etraining.activity.ActivityConstant;
import com.kingnod.etraining.activity.entity.Examination;
import com.kingnod.etraining.exam.ExamConstant;
import com.kingnod.etraining.exam.entity.Paper;
import com.kingnod.etraining.exam.entity.Question;
import com.kingnod.etraining.exam.entity.TestGroup;
import com.kingnod.etraining.exam.service.ExamineeQuestionService;
import com.kingnod.etraining.exam.service.PaperService;
import com.kingnod.etraining.exam.service.QuestionTestGroupService;
import com.kingnod.etraining.exam.service.TestGroupService;

@org.springframework.stereotype.Controller
@Namespace("/exm")
@Results({ 
	@Result(name = EntityAction.RELOAD, type = "redirectAction", params = {"actionName", "paper", "namespace", "/exm","folderId", "${folderId}"}),
	@Result(name = ExamConstant.PREVIEW, location = "/WEB-INF/content/exm/previewes.jsp", params = {"actionName", "paper", "namespace", "/exm" })
})
@com.kingnod.core.annotation.Generated("2012-02-23 10:16")
public class PaperAction extends FilterableEntityAction<Paper, Long> {
	private static final long serialVersionUID = 7996309078022186979L;
	private String folderId;
	private Paper paper;
	private List<Question> quesList;
	private String folderName;
	private boolean includeSubFolderVal;
	private String q_status; //查询发布状态 @author maxudong
	private List<TestGroup> testGroupList = new ArrayList<TestGroup>();
	
	@Override
	public String delete() throws Exception {
		Long[] ids = this.getIdValues();
		if(ids != null && ids.length > 0 && ids[0] != null) {
			if(paperService.findExamByPaperOfCount(ids)) {
				questionTestGroupService.deletequestionTestGroupByPaperId(null, ids); // 删除提纲下所有手工添加的试题
				testGroupService.deleteTestGroupByPaperId(ids);
				return super.delete();
			}
		}
		return EntityAction.RELOAD;
	}
	
	/**
	 * 校验是否可以删除，如果当前试卷被考试活动引用不能删除
	 * @return String
	 */
	public String validDelete(){
		Long[] ids = this.getIdValues();
		if(ids != null && ids.length > 0 && ids[0] != null){
			boolean bool = paperService.findExamByPaperOfCount(ids);
			if(bool){
				ServletActionContext.getValueStack(Struts2Utils.getRequest()).set(ExamConstant.ACTION_JSONROOT, true);
			}else{
				ServletActionContext.getValueStack(Struts2Utils.getRequest()).set(ExamConstant.ACTION_JSONROOT, "删除失败！！！有考试活动引用不能删除???");
			}
			return ExamConstant.ACTION_JSONRESULT;
		}
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set(ExamConstant.ACTION_JSONROOT, "删除失败！！！请选择需要删除的记录???");
		return ExamConstant.ACTION_JSONRESULT;
	}
	
	/**
	 * 查询文件夹名称
	 */
	@Override
	public String input() throws Exception {
		folderName = paperService.findFolderNameByFolderId(folderId);
		return super.input();
	}
	
	/**
	 * 发布试卷
	 * @return
	 * @throws Exception 
	 */
	@ErrorMapping(result = ExamConstant.ACTION_JSONRESULT)
	public String publishPaper() throws Exception {
		Integer cont = paperService.publishQuestionByPaper(paper, true);
		if(null == cont || 0 == cont) {
			ServletActionContext.getValueStack(Struts2Utils.getRequest()).set(ExamConstant.ACTION_JSONROOT, -1);
			return ExamConstant.ACTION_JSONRESULT;
		}
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set(ExamConstant.ACTION_JSONROOT, 1);
		return ExamConstant.ACTION_JSONRESULT;
	}
	
	/**
	 * 取消发布试卷
	 * @return String
	 * @throws Exception
	 */
	public String cancellationPublish() throws Exception {
		Integer cont = paperService.publishQuestionByPaper(paper, false);
		if(null == cont || 0 == cont) {
			ServletActionContext.getValueStack(Struts2Utils.getRequest()).set(ExamConstant.ACTION_JSONROOT, 2);
			return ExamConstant.ACTION_JSONRESULT;
		}
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set(ExamConstant.ACTION_JSONROOT, 3);
		return ExamConstant.ACTION_JSONRESULT;
	}
	
	/**
	 * 处理试卷预览
	 * @return String
	 */
	public String preview() {
		if(paper != null && paper.getId() != null){
			paper = paperService.getPaper(paper.getId());
			
			Examination examination = new Examination(); 
			examination.setAtyPaperId(paper.getId());
			examination.setName(paper.getName());
			examination.setTotalScore(paper.getTotalScore() == null ? 0 : paper.getTotalScore());
			request.setAttribute("examination", examination);
			testGroupList = examineeQuestionService.previewPaperOrExam(examination, null);
		}
		request.setAttribute("type", ActivityConstant.PREVIEWES_TYPE_P);
		request.setAttribute("testGroupList", testGroupList);
		request.getSession().setAttribute("testGroupList", testGroupList);
		return ExamConstant.PREVIEW;
	}
	
	/**
	 * 覆盖此方法  根据节点过滤
	 */
	@Override
	protected void afterPreparedCriteriaBuilder(CriteriaBuilder cb) {
		if(includeSubFolderVal){
			cb.addParam("folderId", folderId);
		}else if(null != folderId && !"".equals(folderId)) {
			cb.andGroup(Cnd.builder().andEQ("folderId", folderId));
		}
		if(!StringUtils.isEmpty(q_status)){
			cb.andEQ("status", q_status);
		}
	}
	
	@Autowired
	private TestGroupService testGroupService;
	
	@Autowired
	private QuestionTestGroupService questionTestGroupService;

	@Autowired
	@com.kingnod.core.annotation.Generated("2012-02-23 10:16")
	private PaperService paperService;
	@Autowired
	private ExamineeQuestionService examineeQuestionService;

	@com.kingnod.core.annotation.Generated("2012-02-23 10:16")
	public String filterDefines() {
		return "exm.paperFilterItems";
	}

	@com.kingnod.core.annotation.Generated("2012-02-23 10:16")
	protected Object getEntityService() {
		return this.paperService;
	}

	public String getFolderId() {
		return folderId;
	}

	public void setFolderId(String folderId) {
		this.folderId = folderId;
	}

	public Paper getPaper() {
		return paper;
	}

	public void setPaper(Paper paper) {
		this.paper = paper;
	}

	public List<Question> getQuesList() {
		return quesList;
	}

	public void setQuesList(List<Question> quesList) {
		this.quesList = quesList;
	}

	public String getFolderName() {
		return folderName;
	}

	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}

	public boolean isIncludeSubFolderVal() {
		return includeSubFolderVal;
	}

	public void setIncludeSubFolderVal(boolean includeSubFolderVal) {
		this.includeSubFolderVal = includeSubFolderVal;
	}

	public String getQ_status() {
		return q_status;
	}

	public void setQ_status(String q_status) {
		this.q_status = q_status;
	}
}