package com.kingnod.etraining.exam.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.criteria.Order;
import com.kingnod.core.extensions.struts2.action.EntityAction;
import com.kingnod.core.extensions.struts2.action.FilterableEntityAction;
import com.kingnod.core.extensions.struts2.annotation.ErrorMapping;
import com.kingnod.etraining.activity.action.ExamUtil;
import com.kingnod.etraining.exam.entity.QuestionTestGroup;
import com.kingnod.etraining.exam.entity.TestGroup;
import com.kingnod.etraining.exam.service.QuestionTestGroupService;
import com.kingnod.etraining.exam.service.TestGroupService;

@org.springframework.stereotype.Controller
@Namespace("/exm")
@Results({ 
	@Result(name = EntityAction.RELOAD, type = "redirectAction", params = {"actionName", "question-test-group", "namespace", "/exm","examPaperId","${examPaperId}","testGroupId","${testGroupId}","type","${type}","courseId","${courseId}","folderId", "${folderId}","degree","${degree}","knowledge","${knowledge}", "questionType", "${questionType}" }), 
	@Result(name = "back",type="redirectAction", params = {"actionName", "question-list", "namespace", "/exm","examPaperId", "${examPaperId}", "testGroupId","${testGroupId}", "type", "${type}","courseId","${courseId}","folderId", "${folderId}","degree","${degree}","knowledge","${knowledge}", "questionType", "${questionType}" }),
	@Result(name = "generating",type="redirectAction", params = {"actionName", "generating-paper-rule", "namespace", "/exm","examPaperId", "${examPaperId}", "testGroupId","${testGroupId}", "type", "${questionType}" })
})
@com.kingnod.core.annotation.Generated("2012-02-29 10:15")
public class QuestionTestGroupAction extends FilterableEntityAction<QuestionTestGroup, Long> {
	private static final long serialVersionUID = -1860797102840991270L;
	private Long testGroupId;
	private String courseId;
	private Long examPaperId;
	private String questionType;
	private String folderId;
	private String degree;
	private String knowledge;
	private String generatorPaperPattern; // 组卷方式

	@Autowired
	@com.kingnod.core.annotation.Generated("2012-02-29 10:15")
	private QuestionTestGroupService questionTestGroupService;
	
	@Autowired
	private TestGroupService testGroupService;
	
	@Override
	public String list() throws Exception {
		HttpSession session = request.getSession();
		// 如果是自动组卷  将请求转发
		TestGroup testGroup = testGroupService.findSocreAndQuestionNumber(testGroupId);
		if(null == testGroup) {
			testGroup = testGroupService.getTestGroup(testGroupId);
		}
		testGroup.setTotalScoreStr(ExamUtil.formatNumerical(testGroup.getTotalScore()));
		session.setAttribute("testGroup", testGroup);
		if(null != generatorPaperPattern && "A".equals(generatorPaperPattern)) {
			//super.list();
			return "generating";
		} else {
			// 否则   请求继续传递
			return super.list();
		}
	}

	/**
	 * 上移  下移 至顶  至尾
	 */
	@ErrorMapping(result=RELOAD)
	public String moveble() {
		// 查询该试卷是否已发布  如果是发布状态   则不可以再组卷
		testGroupService.getPaper(examPaperId);
		questionTestGroupService.movebleQuestionTestGroup(this.getModel());
		return EntityAction.RELOAD;
	}
	
	@ErrorMapping(result=RELOAD)
	public String getBatch() {
		// 查询该试卷是否已发布  如果是发布状态   则不可以再组卷
		testGroupService.getPaper(examPaperId);
		this.getValueStack().set("ids", this.getIdValues());
		Long[] ids = this.getIdValues();
		if(null!=ids) {
			if(ids.length==1){
				BeanUtils.copyProperties(questionTestGroupService.getQuestionTestGroup(ids[0]), entity);
			}else{
				entity.setType(request.getAttribute("generatorPaperPattern").toString());
			}
		} else {
			return EntityAction.RELOAD;
		}
		return EntityAction.INPUT;
	}
	
	@Override
	@ErrorMapping(result=RELOAD)
	public String delete() throws Exception {
		// 查询该试卷是否已发布  如果是发布状态   则不可以再组卷
		testGroupService.getPaper(examPaperId);
		return super.delete();
	}
	
	@Override
	@ErrorMapping(result=RELOAD)
	public String input() throws Exception {
		// 查询该试卷是否已发布  如果是发布状态   则不可以再组卷
		testGroupService.getPaper(examPaperId);
		return super.input();
	}
	
	@Override
	public String save() throws Exception {
		Long[] ids = this.getIdValues();
		if(null==ids){
			questionTestGroupService.saveQuestionTestGroup(entity);
		}else{
			for(int i=0;i<ids.length;i++){
				entity.setId(ids[i]);
			    questionTestGroupService.saveQuestionTestGroup(entity);
			}
			
		}
		return EntityAction.RELOAD;
	}
	
	@Override
	protected void afterPreparedCriteriaBuilder(CriteriaBuilder cb) {
		if (null != testGroupId && 0 != testGroupId) {
			cb.andGroup(Cnd.builder().andEQ("testGroupId", testGroupId));
		}
		if(null != examPaperId && 0 != examPaperId) {
			cb.orderBy("sequence", Order.ASC);
		}
	}

	@com.kingnod.core.annotation.Generated("2012-02-29 10:15")
	public String filterDefines() {
		return "exm.questionTestGroupFilterItems";
	}

	@com.kingnod.core.annotation.Generated("2012-02-29 10:15")
	protected Object getEntityService() {
		this.getIdValues();
		return this.questionTestGroupService;
	}
	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getFolderId() {
		return folderId;
	}

	public void setFolderId(String folderId) {
		this.folderId = folderId;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getKnowledge() {
		return knowledge;
	}

	public void setKnowledge(String knowledge) {
		this.knowledge = knowledge;
	}

	public Long getTestGroupId() {
		return testGroupId;
	}

	public void setTestGroupId(Long testGroupId) {
		this.testGroupId = testGroupId;
	}

	public Long getExamPaperId() {
		return examPaperId;
	}

	public void setExamPaperId(Long examPaperId) {
		this.examPaperId = examPaperId;
	}

	public String getGeneratorPaperPattern() {
		return generatorPaperPattern;
	}

	public void setGeneratorPaperPattern(String generatorPaperPattern) {
		this.generatorPaperPattern = generatorPaperPattern;
	}

	public String getQuestionType() {
		return questionType;
	}

	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}
}