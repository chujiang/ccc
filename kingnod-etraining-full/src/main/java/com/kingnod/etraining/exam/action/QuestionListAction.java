package com.kingnod.etraining.exam.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.extensions.struts2.action.EntityAction;
import com.kingnod.core.extensions.struts2.action.FilterableEntityAction;
import com.kingnod.core.extensions.struts2.annotation.ErrorMapping;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.core.util.StringUtils;
import com.kingnod.etraining.activity.ActivityConstant;
import com.kingnod.etraining.activity.entity.Examination;
import com.kingnod.etraining.exam.ExamConstant;
import com.kingnod.etraining.exam.TestGroupUtils;
import com.kingnod.etraining.exam.entity.Question;
import com.kingnod.etraining.exam.entity.QuestionUtils;
import com.kingnod.etraining.exam.entity.TestGroup;
import com.kingnod.etraining.exam.service.QuestionService;
import com.kingnod.etraining.exam.service.QuestionTestGroupService;
import com.kingnod.etraining.exam.service.TestGroupService;

@org.springframework.stereotype.Controller
@Namespace("/exm")
@Results
({
		@Result(name = EntityAction.RELOAD, type = "redirectAction", params = {"actionName", "question-list", "namespace", "/exm","examPaperId", "${examPaperId}", "testGroupId","${testGroupId}", "type", "${type}", "objectPicker_questionFolderId", "${objectPicker_questionFolderId}", "objectPicker_courseId", "${objectPicker_courseId}", "objectPicker_knowledgeId", "${objectPicker_knowledgeId}"}),
		@Result(name = ExamConstant.BACK, location = "/WEB-INF/content/exm/question-list.jsp",params = {"actionName", "question-list", "namespace", "/exm","examPaperId", "${examPaperId}", "testGroupId","${testGroupId}", "type", "${type}", "objectPicker_questionFolderId", "${objectPicker_questionFolderId}", "objectPicker_courseId", "${objectPicker_courseId}", "objectPicker_knowledgeId", "${objectPicker_knowledgeId}"}),
		@Result(name = ExamConstant.PREVIEW, location = "/WEB-INF/content/exm/previewes.jsp",params = {"actionName", "question-list", "namespace", "/exm" })
})
@com.kingnod.core.annotation.Generated("2012-02-23 15:01")
public class QuestionListAction extends FilterableEntityAction<Question, Long> {

	private static final long serialVersionUID = 9102251006352204519L;
	private String type;
	private Long examPaperId;
	private Long testGroupId;
	private Question question;
	private String objectPicker_questionFolderId; // 题库名称
	private String objectPicker_courseId; // 课程名称
	private String objectPicker_knowledgeId; // 知识点名称
	private List<Question> questionList = new ArrayList<Question>();
	private List<TestGroup> testGroupList = new ArrayList<TestGroup>();//区分测试区
	private String isViewAll;
	private int falg;
	
	/**
	 * 处理添加试题时，已经添加的试题不再显示   只显示未添加的试题
	 */
	public String queryQuestion() {
		PagingResult<Question> pagingResult = questionService.searchQuestion(this.getModel(), pager);
		pager.setTotalCount(pagingResult.getTotalRows());
		pager.setResult(pagingResult.getResult());
		request.setAttribute("page", pager);
		request.setAttribute("falg", falg);
		return SUCCESS;
	}
	
	@Override
	protected PagingResult<Question> doQuery(Criteria criteria) {
		return questionService.searchQuestion(this.getModel(), pager);
	}
	
	/**
	 * 处理批量添加
	 */
	@ErrorMapping(result=RELOAD)
	public String saveQuestionTestGroup() {
		// 查询该试卷是否已发布  如果是发布状态   则不可以再组卷
		try {
			testGroupService.getPaper(examPaperId);
		} catch (Exception e) {
			falg = -1;
			return this.queryQuestion();
		}
		Long[] ids = this.getIdValues();
		if(null == ids) {
			return "back";
		}
		TestGroup testGroup = testGroupService.findSocreAndQuestionNumber(testGroupId);
		if(null == testGroup) {
			testGroup = testGroupService.getTestGroup(testGroupId);
		}
		request.getSession().setAttribute("testGroup", testGroup);
		falg = questionTestGroupService.batchAdd(ids, testGroupId, examPaperId);
		return this.queryQuestion();
	}

	/*
	 * TODO 根据 questionId查询得到 批量预览结果
	 */
	public String batchPreview() {
		Long[] ids = this.getIdValues();
		testGroupList = questionService.previewQuestion(null, ids);
		TestGroupUtils.calculateScore(testGroupList);
		String qusetionIds = "";
		
		if(ids != null && ids.length > 0){
			for (Long lValue : ids) {
				qusetionIds = qusetionIds + lValue + ",";
			}
		}
		
		Examination examination = new Examination();
		examination.setName("组卷试题预览");
		examination.setTotalScore(TestGroupUtils.getTestGroupTotalScore(testGroupList));
		
		request.setAttribute("type", ActivityConstant.PREVIEWES_TYPE_N);
		request.setAttribute("examination", examination);
		request.setAttribute("testGroupList", testGroupList);
		request.setAttribute("qusetionIds", qusetionIds);
		return ExamConstant.PREVIEW;
	}
	
	/**
	 * 获取测试区固定顺序
	 * @return List<String>
	 */
	public List<String> getTestGroupSeq(){
		List<String> testGroupSeq = new ArrayList<String>();//保存测试区顺序
		testGroupSeq.add(ExamConstant.QUESTION_TYPE_R);//单选
		testGroupSeq.add(ExamConstant.QUESTION_TYPE_C);//多选
		testGroupSeq.add(ExamConstant.QUESTION_TYPE_B);//判断
		testGroupSeq.add(ExamConstant.QUESTION_TYPE_T);//填空
		testGroupSeq.add(ExamConstant.QUESTION_TYPE_A);//简答
		testGroupSeq.add(ExamConstant.QUESTION_TYPE_U);//无限制
		return testGroupSeq;
	}
	
	/**
	 * 给测试区排序
	 */
	public void testGroupSort(){
		//给测试区中的试题标识排序
		List<String> testGroupSeq = getTestGroupSeq();
		int i = 1; 
		List<Question> list = new ArrayList<Question>();
		for (String string : testGroupSeq) {
			for (Question question : questionList) {
				if(StringUtils.equals(string, question.getType())){
					question.setSequence(i);
					i++;
					list.add(question);
				}
			}
		}
		questionList.clear();
		questionList = list;
		
		//给测试区排序
		List<TestGroup> listTestGroup = new ArrayList<TestGroup>();
		for(String seq : testGroupSeq){
			for(TestGroup testGroup : testGroupList){
				if(StringUtils.equals(testGroup.getQuestionType(), seq)){
					listTestGroup.add(testGroup);
				}
			}
		}
		testGroupList.clear();
		testGroupList = listTestGroup;
	}
	
	/**
	 * 判断当前试题类型的测试区是否存在，如果 不存在，就创建测试区
	 * @param question
	 */
	public void exitTestGroup(Question question){
		if(testGroupList != null && testGroupList.size() <= 0){
			createTestGroup(question);
		}else{
			for(TestGroup testGroup : testGroupList){
				if(StringUtils.equals(testGroup.getQuestionType(), question.getType())){
					testGroup.getListQuestion().add(question);
					return;
				}
			}
			createTestGroup(question);
		}
	}
	
	/**
	 * 创建测试区
	 * @param question
	 */
	public void createTestGroup(Question question){
		TestGroup testGroup = new TestGroup();
		testGroup.setName(getTestGroupType(question.getType()));
		testGroup.setQuestionType(question.getType());
		testGroup.getListQuestion().add(question);
		testGroupList.add(testGroup);
	}
	
	/**
	 * 获取测试区类型
	 * @param type
	 * @return String
	 */
	public static String getTestGroupType(String type){
		type = StringUtils.isNotEmpty(type) ? type : ExamConstant.QUESTION_TYPE_U;
		if(StringUtils.equals(ExamConstant.QUESTION_TYPE_R, type)){
			return "单选题";
		}else if(StringUtils.equals(ExamConstant.QUESTION_TYPE_C, type)){
			return "多选题";
		}else if(StringUtils.equals(ExamConstant.QUESTION_TYPE_B, type)){
			return "判断题";
		}else if(StringUtils.equals(ExamConstant.QUESTION_TYPE_T, type)){
			return "填空题";
		}else if(StringUtils.equals(ExamConstant.QUESTION_TYPE_A, type)){
			return "简答题";
		}else if(StringUtils.equals(ExamConstant.QUESTION_TYPE_U, type)){
			return "无限制";
		}
		return "无限制";
	}
	
	/*
	 * TODO 根据 questionId查询得到 批量预览结果
	 */
	public String previewQuestion() {
		String qeusIds = request.getParameter("questionIds");
		Long[] ids = StringUtils.isNotEmpty(qeusIds) ? QuestionUtils.parseIntValue(qeusIds) : this.getIdValues();
		testGroupList = questionService.previewQuestion(testGroupId, ids);
		TestGroupUtils.calculateScore(testGroupList);
		String qusetionIds = "";
		
		if(ids != null && ids.length > 0) {
			for (Long lValue : ids) {
				qusetionIds = qusetionIds + lValue + ",";
			}
		} else {
			// 如果是全部预览
			if("yes".equals(isViewAll)) {
				TestGroup testGroup = testGroupService.getTestGroup(testGroupId);
				testGroupList = TestGroupUtils.buildTestGroup(testGroup.getQuestionList(), new ArrayList<TestGroup>());
			}
		}
		
		Examination examination = new Examination();
		examination.setName("组卷试题预览");
		examination.setTotalScore(TestGroupUtils.getTestGroupTotalScore(testGroupList));
		
		request.setAttribute("type", ActivityConstant.PREVIEWES_TYPE_Q);
		request.setAttribute("examination", examination);
		request.setAttribute("testGroupList", testGroupList);
		request.setAttribute("qusetionIds", qusetionIds);
		return ExamConstant.PREVIEW;
	}
	
	/**
	 * 查询
	 * @return
	 */
	public String back() {
		List<Question> quesList = new ArrayList<Question>();
		request.setAttribute("page", quesList);
		return ExamConstant.BACK;
	}
	
	@Autowired
	private TestGroupService testGroupService;
	
	@Autowired
	private QuestionTestGroupService questionTestGroupService;

	@Autowired
	@com.kingnod.core.annotation.Generated("2012-02-12 17:42")
	private QuestionService questionService;

	@com.kingnod.core.annotation.Generated("2012-02-12 17:42")
	public String filterDefines() {
		return "exm.questionFilterItems";
	}

	@com.kingnod.core.annotation.Generated("2012-02-12 17:42")
	protected Object getEntityService() {
		return this.questionService;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public String getObjectPicker_questionFolderId() {
		return objectPicker_questionFolderId;
	}

	public void setObjectPicker_questionFolderId(
			String objectPicker_questionFolderId) {
		this.objectPicker_questionFolderId = objectPicker_questionFolderId;
	}

	public String getObjectPicker_courseId() {
		return objectPicker_courseId;
	}

	public void setObjectPicker_courseId(String objectPicker_courseId) {
		this.objectPicker_courseId = objectPicker_courseId;
	}

	public String getObjectPicker_knowledgeId() {
		return objectPicker_knowledgeId;
	}

	public void setObjectPicker_knowledgeId(String objectPicker_knowledgeId) {
		this.objectPicker_knowledgeId = objectPicker_knowledgeId;
	}

	public List<Question> getQuestionList() {
		return questionList;
	}

	public void setQuestionList(List<Question> questionList) {
		this.questionList = questionList;
	}

	public List<TestGroup> getTestGroupList() {
		return testGroupList;
	}

	public void setTestGroupList(List<TestGroup> testGroupList) {
		this.testGroupList = testGroupList;
	}

	public String getIsViewAll() {
		return isViewAll;
	}

	public void setIsViewAll(String isViewAll) {
		this.isViewAll = isViewAll;
	}

	public int getFalg() {
		return falg;
	}

	public void setFalg(int falg) {
		this.falg = falg;
	}
}