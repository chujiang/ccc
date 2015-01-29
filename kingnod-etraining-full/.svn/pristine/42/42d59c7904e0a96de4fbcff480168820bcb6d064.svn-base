package com.kingnod.etraining.exam.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.extensions.struts2.action.EntityAction;
import com.kingnod.core.extensions.struts2.action.FilterableEntityAction;
import com.kingnod.core.util.StringUtils;
import com.kingnod.etraining.exam.ExamConstant;
import com.kingnod.etraining.exam.entity.Knowledge;
import com.kingnod.etraining.exam.entity.Question;
import com.kingnod.etraining.exam.entity.TestGroup;
import com.kingnod.etraining.exam.service.KnowledgeService;
import com.kingnod.etraining.exam.service.QuestionService;

@org.springframework.stereotype.Controller
@Namespace("/exm")
@Results({ @Result(name = EntityAction.RELOAD, type = "redirectAction", params = { "actionName", "knowledge", "namespace", "/exm", "folderId", "${folderId}" }), @Result(name = ExamConstant.ACTION_VIEW, location = "/WEB-INF/content/exm/knowledge-questions.jsp", params = { "actionName", "knowledge", "namespace", "/exm", "folderId", "${folderId}" }), @Result(name = ExamConstant.PREVIEW, location = "/WEB-INF/content/exm/previewes.jsp")

})
@com.kingnod.core.annotation.Generated("2012-04-11 17:04")
public class KnowledgeAction extends FilterableEntityAction<Knowledge, Long> {
	private static final long serialVersionUID = -2824117581105480143L;
	private Long folderId;
	private List<Question> quesList;
	private List<TestGroup> testGroupList;
	public List<TestGroup> getTestGroupList() {
		return testGroupList;
	}

	public void setTestGroupList(List<TestGroup> testGroupList) {
		this.testGroupList = testGroupList;
	}

	private String folderName;
	private boolean includeSubFolderVal;

	@Autowired
	private QuestionService questionService; // 为了预览引用 update by maxudong

	private String qusetionIds;

	/**
	 * 查询出所有与该知识点相关联的试题
	 * @since 由于此方法不支持分页,暂时不调用 ,已转至question.action
	 * update by maxudong 
	 * @return
	 */
	public String questions() {
		quesList = knowledgeService.findInteractionQuestion(this.getIdValues());
		request.setAttribute("page", quesList);
		this.entity.setId(this.getIdValues()[0]);
		return ExamConstant.ACTION_VIEW;
	}

	/**
	 * 预览与该知识点相关的试题,单条记录预览和整个知识库预览
	 * @author maxudong
	 *  此方法也转移至question.action
	 */

	public String questionPreview() {
		if (!StringUtils.isEmpty(qusetionIds)) {
			testGroupList = questionService.previewQuestion(null, this.constructLonArray(qusetionIds));
		}
//		else {
//			testGroupList = knowledgeService.findInteractionQuestion(this.getIdValues());
//		}
		request.setAttribute("page", testGroupList);
		return ExamConstant.PREVIEW;

	}

	/**
	 * 查询文件夹名称
	 */
	@Override
	public String input() throws Exception {
		folderName = knowledgeService.findFolderNameByFolderId(folderId);
		return super.input();
	}

	public Long[] constructLonArray(String constructStr) {

		if (StringUtils.isEmpty(constructStr))
			return null;

		String strArray[] = constructStr.split(",");

		Long longArray[] = new Long[strArray.length];

		for (int i = 0; i < strArray.length; i++) {
			longArray[i] = Long.valueOf(strArray[i]);
		}
		return longArray;
	}

	@Autowired
	@com.kingnod.core.annotation.Generated("2012-04-11 17:04")
	private KnowledgeService knowledgeService;
	
	public Long getFolderId() {
		return folderId;
	}

	public void setFolderId(Long folderId) {
		this.folderId = folderId;
	}

	@Override
	protected void afterPreparedCriteriaBuilder(CriteriaBuilder cb) {
		if (includeSubFolderVal) {
			cb.addParam("folderId", folderId);
		} else if (null != folderId && 0 != folderId) {
			cb.andGroup(Cnd.builder().andEQ("folderId", folderId));
		}
	}

	@com.kingnod.core.annotation.Generated("2012-04-11 17:04")
	public String filterDefines() {
		return "exm.knowledgeFilterItems";
	}

	@com.kingnod.core.annotation.Generated("2012-04-11 17:04")
	protected Object getEntityService() {
		return this.knowledgeService;
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

	public String getQusetionIds() {
		return qusetionIds;
	}

	public void setQusetionIds(String qusetionIds) {
		this.qusetionIds = qusetionIds;
	}

}