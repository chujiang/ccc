package com.kingnod.etraining.exam.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.exception.Exceptions;
import com.kingnod.core.extensions.struts2.action.EntityAction;
import com.kingnod.core.extensions.struts2.annotation.ErrorMapping;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.core.util.StringUtils;
import com.kingnod.etraining.activity.ActivityConstant;
import com.kingnod.etraining.activity.entity.Examination;
import com.kingnod.etraining.common.action.DefaultOrderBaseAction;
import com.kingnod.etraining.exam.ExamConstant;
import com.kingnod.etraining.exam.TestGroupUtils;
import com.kingnod.etraining.exam.entity.Question;
import com.kingnod.etraining.exam.entity.QuestionAnswer;
import com.kingnod.etraining.exam.entity.TestGroup;
import com.kingnod.etraining.exam.service.QuestionService;

@org.springframework.stereotype.Controller
@Namespace("/exm")
@Results({ 
	@Result(name = EntityAction.RELOAD, type = "redirectAction", params = {"actionName", "question", "namespace", "/exm", "folderId", "${folderId}", "questionContent", "${questionContent}", "totalScore", "${totalScore}", "score", "${score}"}), 
	@Result(name = ExamConstant.ACTION_EDITQUESTION, location = "/WEB-INF/content/exm/edit-question.jsp"),
	@Result(name = ExamConstant.ACTION_EDITANSWER, location = "/WEB-INF/content/exm/edit-answer.jsp"),
	@Result(name = "knowledgeQquestionList", location = "/WEB-INF/content/exm/knowledge-questions.jsp"),
	@Result(name = "selectType", location = "/WEB-INF/content/exm/selectQuestionType.jsp"),
	@Result(name = ExamConstant.PREVIEW, location = "/WEB-INF/content/exm/previewes.jsp"),
	@Result(name = ExamConstant.ACTION_SAVE, type = "redirectAction", params = {"actionName", "question", "method", "input", "namespace", "/exm", "folderId", "${folderId}", "questionContent", "${questionContent}", "type","${type}", "totalScore", "${totalScore}", "score", "${score}", "degree", "${degree}", "knowledgeId", "${knowledgeId}", "courseId", "${courseId}", "id", "${id}", "questionIndex", "${questionIndex}", "differentiate", "${differentiate}", "questionType", "${questionType}", "questionScore", "${questionScore}"})
})
@com.kingnod.core.annotation.Generated("2012-04-12 16:00")
public class QuestionAction extends DefaultOrderBaseAction<Question, Long> {
	private static final long serialVersionUID = 9011935499147461818L;
	private long folderId;
	private boolean includeSubFolderVal;
	private String questionContent; // 试题内容
	private String answerContent; // 答案内容
	private String type; // 类型
	private Integer answerIndex;
	private List<QuestionAnswer> answerList = new ArrayList<QuestionAnswer>(); // 答案集
	private Float score; // 分数
	private Float totalScore = 0f; // 组合题分数
	private Integer degree; // 难度
	private String knowledgeId; // 知识点ID 
	private String courseId; // 课程ID
	private Long id; // 试题ID
	private List<Question> questionList = new ArrayList<Question>(); // 小题目集
	private List<TestGroup> testGroupList = new ArrayList<TestGroup>();//分区
	private Integer differentiate; // 区分是添加题目  还是小题目
	private Integer questionIndex;
	private String questionType; // 小题目类型
	private Float questionScore; // 小题目分数
	
	private String qusetionIds;  //update maxudong 试题选择预览标示
	
	private String q_type;
	
	public String getQ_type() {
		return q_type;
	}

	public void setQ_type(String q_type) {
		this.q_type = q_type;
	}
	

	/**
	 * 保存试题
	 */
	@Override
	@ErrorMapping(result=INPUT)
	public String save() throws Exception {
		HttpSession session = request.getSession();
		if("Z".equals(type)) {
			// 保存组合题
			questionContent = (String) session.getAttribute("questionContent");
			Question ques = this.getModel();
			ques.setContent(questionContent);
			questionList.add(0, ques);
			questionService.saveQuestion(questionList);
		} else {
			Question question = this.getModel();
			questionContent = (String) session.getAttribute("questionContent");
			question.setContent(questionContent);
			questionService.saveQuestion(question);
		}
		return EntityAction.RELOAD;
	}
	
 
	@ErrorMapping(result=EntityAction.RELOAD )
	public String delete() throws Exception {
		return super.delete();
	}
	
	/**
	 * 编辑试题内容
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String editQuestion() {
		HttpSession session = request.getSession();
		try {
			if(null != differentiate && 1 == differentiate) {
				questionList = (List<Question>) session.getAttribute("questionList");
				if(null != questionList && null != questionIndex) {
					questionContent = questionList.get(questionIndex).getContent();
					questionList.get(questionIndex).setScore(questionScore);
				}
			} else {
				questionContent = (String) session.getAttribute("questionContent");
			}
		} catch (Exception e) {
		}
		return ExamConstant.ACTION_EDITQUESTION;
	}
	
	/**
	 * 保存试题内容
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@ErrorMapping(result=ExamConstant.ACTION_SAVE)
	public String saveQuestion() {
		HttpSession session = request.getSession();
		if(null == questionContent || "".equals(questionContent)) {
			throw Exceptions.createAppException("exm001001");
		}
		//questionContent = questionContent.replace("<p>", "").replace("</p>", "");
		if("T".equals(type)) {
			Question question = this.getModel();
			session.setAttribute("answerList", question.getQuestionAnswers());
			session.setAttribute("questionContent", questionContent);
		} else if(null != differentiate && 1 == differentiate) {
			questionList = (List<Question>) session.getAttribute("questionList");
			if(null == questionList) {
				questionList = new ArrayList<Question>();
			}
			if(null != questionIndex) {
				questionList.get(questionIndex).setContent(questionContent);
			} else {
				Question question = new Question();
				if("B".equals(questionType)) {
					question.setType(questionType);
					question.setContent(questionContent);
					question.setScore(questionScore);
					List<QuestionAnswer> questionAnswerList = new ArrayList<QuestionAnswer>();
					QuestionAnswer questionAnswer = new QuestionAnswer();
					questionAnswer.setItemContent("正确");
					questionAnswer.setType(questionType);
					questionAnswerList.add(questionAnswer);
					questionAnswer = new QuestionAnswer();
					questionAnswer.setItemContent("错误");
					questionAnswer.setType(questionType);
					questionAnswerList.add(questionAnswer);
					question.setQuestionAnswers(questionAnswerList);
				} else if("T".equals(questionType)) {
					question = questionService.parseStringT(questionList, questionContent);
					question.setType(questionType);
					question.setScore(questionScore);
				} else {
					question.setType(questionType);
					question.setScore(questionScore);
					question.setContent(questionContent);
				}
				questionList.add(question);
			}
			session.setAttribute("questionList", questionList);
		} else {
			if("B".equals(type)) {
				answerList = (List<QuestionAnswer>) session.getAttribute("answerList");
				if(null == answerList || 0 == answerList.size()) {
					answerList = new ArrayList<QuestionAnswer>();
					QuestionAnswer questionAnswer = new QuestionAnswer();
					questionAnswer.setItemContent("正确");
					questionAnswer.setType(type);
					answerList.add(questionAnswer);
					questionAnswer = new QuestionAnswer();
					questionAnswer.setItemContent("错误");
					questionAnswer.setType(type);
					answerList.add(questionAnswer);
					session.setAttribute("answerList", answerList);
				}
			}
			session.setAttribute("questionContent", questionContent);
		}
		return ExamConstant.ACTION_SAVE;
	}
	
	/**
	 * 编辑答案内容
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String editAnswer() {
		HttpSession session = request.getSession();
		try {
			if("Z".equals(type)) {
				questionList = (List<Question>) session.getAttribute("questionList");
				answerContent = questionList.get(questionIndex).getQuestionAnswers().get(answerIndex).getItemContent();
			} else {
				answerList  = (List<QuestionAnswer>) session.getAttribute("answerList");
				answerContent = answerList.get(answerIndex).getItemContent();
			}
		} catch (Exception e) {
		}
		return ExamConstant.ACTION_EDITANSWER;
	}
	
	/**
	 * 保存答案内容
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@ErrorMapping(result=ExamConstant.ACTION_SAVE)
	public String saveAnswer() {
		HttpSession session = request.getSession();
		questionContent = (String) session.getAttribute("questionContent");
		if(null == answerContent || "".equals(answerContent)) {
			throw Exceptions.createAppException("exm001002");
		}
		if("Z".equals(type)) {
			questionList = (List<Question>) session.getAttribute("questionList");
			if(null != answerIndex && null != questionIndex) {
				questionList.get(questionIndex).getQuestionAnswers().get(answerIndex).setItemContent(answerContent);
			} else {
				List<QuestionAnswer> quesAnswerList = questionList.get(questionIndex).getQuestionAnswers();
				if(null == quesAnswerList) {
					quesAnswerList = new ArrayList<QuestionAnswer>();
				}
				QuestionAnswer questionAnswer = new QuestionAnswer();
				questionAnswer.setItemContent(answerContent);
				questionAnswer.setType(questionType);
				questionAnswer.setScore(questionScore);
				quesAnswerList.add(questionAnswer);
				questionList.get(questionIndex).setQuestionAnswers(quesAnswerList);
			}
			session.setAttribute("questionList", questionList);
		} else {
			answerList  = (List<QuestionAnswer>) session.getAttribute("answerList");
			if(null == answerList) {
				answerList = new ArrayList<QuestionAnswer>();
			}
			if(null != answerIndex) {
				answerList.get(answerIndex).setItemContent(answerContent);
			} else {
				QuestionAnswer answer = new QuestionAnswer();
				answer.setItemContent(answerContent);
				answer.setType(type);
				answerList.add(answer);
			}
			session.setAttribute("answerList", answerList);
		}
		return ExamConstant.ACTION_SAVE;
	}
	
	/**
	 * 删除试题内容
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String deleteQuestionContent() {
		if("Z".equals(type)) {
			HttpSession session = request.getSession();
			questionList = (List<Question>) session.getAttribute("questionList");
			if(null != questionList) {
				questionList.remove((int) questionIndex);
				session.setAttribute("questionList", questionList);
			}
		}
		return ExamConstant.ACTION_SAVE;
	}
	
	/**
	 * 删除答案内容
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String deleteAnswerConetnt() {
		HttpSession session = request.getSession();
		if("Z".equals(type)) {
			questionList = (List<Question>) session.getAttribute("questionList");
			if(null != questionList) {
				questionList.get(questionIndex).getQuestionAnswers().remove((int) answerIndex);
				session.setAttribute("questionList", questionList);
			}
		} else {
			answerList = new ArrayList<QuestionAnswer>();
			answerList  = (List<QuestionAnswer>) session.getAttribute("answerList");
			answerList.remove((int) answerIndex);
			session.setAttribute("answerList", answerList);
		}
		return ExamConstant.ACTION_SAVE;
	}
	
	/**
	 * 获取编辑内容
	 * @return
	 */
	public String getEditorContent() {
		return INPUT;
	}
	
	/**
	 * 选择试题类型  进行相关处理
	 * 如：选择题换解答题   那么选择题的答案 将会被清空    试题内容会继续保留
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public String selectType() {
		HttpSession session = request.getSession();
		if(!"R".equals(type) && !"C".equals(type)) {
			session.removeAttribute("answerList");
		} else {
			answerList = (List<QuestionAnswer>) session.getAttribute("answerList");
			if(null == answerList || 0 == answerList.size()) {
				return ExamConstant.ACTION_SAVE;
			}
			List<QuestionAnswer> answeres = new ArrayList<QuestionAnswer>();
			for (QuestionAnswer answer : answerList) {
				answer.setType(type);
				answeres.add(answer);
			}
			answerList = answeres;
		}
		return ExamConstant.ACTION_SAVE;
	}
	
	/**
	 * 在新建组合题的时候，先弹出选择试题类型  与   分数的页面
	 * 选择小题目的试题类型  与   填写  该小题目占用的分数   再去编辑试题内容的页面
	 * @return
	 */
	public String selectQuestionType() {
		return "selectType";
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public String input() throws Exception {
		HttpSession session = request.getSession();
		session.setAttribute("updateCourse", true);
		session.setAttribute("updateKnowledge", true);
		//删除存在session中的试题 与 答案
		if(null == type || "".equals(type)) {
			session.removeAttribute("answerList");
			session.removeAttribute("questionContent");
			session.removeAttribute("questionList");
		}
		Long[] ids = this.getIdValues();
		Question ques = null;
		// 判断  是修改  还是新增
		if(null != ids && 0 != ids.length) {
			Long id = ids[0];
			ques = questionService.getQuestion(id);
			ques = questionService.isUpdate(ques);
			session.setAttribute("ques", ques);
		}
		else {
			session.setAttribute("ques", new Question());
		}
		if(null != ques) {
			questionContent = ques.getContent();
			session.setAttribute("questionContent", questionContent);
			answerList = ques.getQuestionAnswers();
			if(0 == answerList.size()) {
				// 当取出的题目  没有答案的时候  说明该试题是组合题   再根据该试题的ID 去查询所有 parentId 等于该试题ID的数据
				questionList = questionService.findListByParentId(ques.getId());
				for (int i = 0; i < questionList.size(); i++) {
					totalScore += questionList.get(i).getScore();
				}
				session.setAttribute("questionList", questionList);
			} else {
				session.setAttribute("answerList", answerList);
			}
		} else {
			questionContent = (String) session.getAttribute("questionContent");
			questionList = (List<Question>) session.getAttribute("questionList");
			if(null != questionList && 0 != questionList.size()) {
				for (int i = 0; i < questionList.size(); i++) {
					totalScore += questionList.get(i).getScore();
				}
			}
		}
		return INPUT;
	}

	@Override
	protected void afterPreparedCriteriaBuilder(CriteriaBuilder cb) {
		if(includeSubFolderVal){
			cb.addParam("folderId", folderId);
		}
		if(StringUtils.isNotEmpty(q_type)){
			cb.andEQ("type", q_type);
		}
		if (!includeSubFolderVal) {
			cb.andGroup(Cnd.builder().andEQ("folderId", folderId));
		}
	}

	/**
	 * @author maxudong
	 * 查询知识库题目
	 * knowledgeId 是String 类型，在questiomMpper文件中 引用了DECIMAL
	 */
	public String  findKnowlegelQquestions(){
	  
		Criteria cb= createCriteria();
	    
	    cb.addParam("knowledgeId", knowledgeId);
		
	    PagingResult<Question>	pagingResult = questionService.findListByKnowlegeId(cb);
		
	    pager.setTotalCount(pagingResult.getTotalRows());
		
	    pager.setResult(pagingResult.getResult());
		
	    request.setAttribute("page", pager);
	    
	    return "knowledgeQquestionList";
		
	}
	
	/**
	 * @author maxudong
	 * TODO 预览与该知识点相关的试题,单条记录预览和整个知识库预览
	 * @author maxudong
	 */

	public String questionPreview() {
		if (StringUtils.isNotEmpty(qusetionIds)) {
			testGroupList = questionService.previewQuestion(null, this.constructLonArray(qusetionIds));
			TestGroupUtils.calculateScore(testGroupList);//计算测试区总分
		}
		Examination examination = new Examination();
		examination.setName("知识点关联试题预览");
		examination.setTotalScore(TestGroupUtils.getTestGroupTotalScore(testGroupList));
		
		request.setAttribute("type", ActivityConstant.PREVIEWES_TYPE_D);
		request.setAttribute("examination", examination);
		request.setAttribute("testGroupList", testGroupList);
		request.setAttribute("qusetionIds", qusetionIds);
		request.setAttribute("knowledgeId", knowledgeId);
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
	
	/**
	 * 字符串构造long数组
	 * @param constructStr
	 * @return
	 */
	public Long[] constructLonArray(String constructStr) {

		if (StringUtils.isEmpty(constructStr))
			return new Long[1];

		String strArray[] = constructStr.split(",");

		Long longArray[] = new Long[strArray.length];

		for (int i = 0; i < strArray.length; i++) {
			longArray[i] = Long.valueOf(strArray[i]);
		}
		return longArray;
	}
	@Autowired
	@com.kingnod.core.annotation.Generated("2012-04-12 16:00")
	private QuestionService questionService;
	
	public long getFolderId() {
		return folderId;
	}

	public void setFolderId(long folderId) {
		this.folderId = folderId;
	}

	@com.kingnod.core.annotation.Generated("2012-04-12 16:00")
	public String filterDefines() {
		return "exm.questionFilterItems";
	}

	@com.kingnod.core.annotation.Generated("2012-04-12 16:00")
	protected Object getEntityService() {
		return this.questionService;
	}

	public boolean isIncludeSubFolderVal() {
		return includeSubFolderVal;
	}

	public void setIncludeSubFolderVal(boolean includeSubFolderVal) {
		this.includeSubFolderVal = includeSubFolderVal;
	}

	public String getQuestionContent() {
		return questionContent;
	}

	public void setQuestionContent(String questionContent) {
		this.questionContent = questionContent;
	}

	public String getAnswerContent() {
		return answerContent;
	}

	public void setAnswerContent(String answerContent) {
		this.answerContent = answerContent;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<QuestionAnswer> getAnswerList() {
		return answerList;
	}

	public void setAnswerList(List<QuestionAnswer> answerList) {
		this.answerList = answerList;
	}

	public Integer getAnswerIndex() {
		return answerIndex;
	}

	public void setAnswerIndex(Integer answerIndex) {
		this.answerIndex = answerIndex;
	}

	public Integer getDegree() {
		return degree;
	}

	public void setDegree(Integer degree) {
		this.degree = degree;
	}

	public String getKnowledgeId() {
		if("undefined".equals(knowledgeId)) {
			return "";
		}
		return knowledgeId;
	}

	public void setKnowledgeId(String knowledgeId) {
		if("undefined".equals(knowledgeId)) {
			knowledgeId = "";
		}
		this.knowledgeId = knowledgeId;
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Question> getQuestionList() {
		return questionList;
	}

	public void setQuestionList(List<Question> questionList) {
		this.questionList = questionList;
	}

	public Integer getDifferentiate() {
		return differentiate;
	}

	public void setDifferentiate(Integer differentiate) {
		this.differentiate = differentiate;
	}

	public Integer getQuestionIndex() {
		return questionIndex;
	}

	public void setQuestionIndex(Integer questionIndex) {
		this.questionIndex = questionIndex;
	}

	public String getQuestionType() {
		return questionType;
	}

	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}

	public Float getQuestionScore() {
		return questionScore;
	}

	public void setQuestionScore(Float questionScore) {
		this.questionScore = questionScore;
	}

	public Float getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(Float totalScore) {
		this.totalScore = totalScore;
	}

	public Float getScore() {
		return score;
	}

	public void setScore(Float score) {
		this.score = score;
	}

	public String getQusetionIds() {
		return qusetionIds;
	}

	public void setQusetionIds(String qusetionIds) {
		this.qusetionIds = qusetionIds;
	}
}