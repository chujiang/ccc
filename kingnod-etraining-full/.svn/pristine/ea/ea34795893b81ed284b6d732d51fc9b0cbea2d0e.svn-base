package com.kingnod.etraining.activity.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.extensions.struts2.action.EntityAction;
import com.kingnod.core.extensions.struts2.action.FilterableEntityAction;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.core.util.StringUtils;
import com.kingnod.etraining.activity.entity.Examination;
import com.kingnod.etraining.activity.entity.ExamineesHistory;
import com.kingnod.etraining.activity.service.ExaminationService;
import com.kingnod.etraining.activity.service.ExamineesHistoryService;
import com.kingnod.etraining.common.ObjectType;
import com.kingnod.etraining.exam.entity.ExamineeQuestion;
import com.kingnod.etraining.exam.entity.Question;
import com.kingnod.etraining.exam.entity.QuestionAnswer;
import com.kingnod.etraining.exam.entity.TestGroup;
import com.kingnod.etraining.exam.service.ExamineeQuestionService;

@org.springframework.stereotype.Controller
@Namespace("/aty")
@Results( 
{
@Result(name = EntityAction.RELOAD, type = "redirectAction", params = { "actionName", "examinees-history", "namespace", "/aty"}),
@Result(name = "exam-details", location = "/WEB-INF/content/aty/enroll-learner-exam-details.jsp", params = { "actionName", "examinees-history", "namespace", "/aty", "siteId", "${siteId}", "folderId", "${folderId}", "activityId", "${activityId}", "activityType", "${activityType}", "paperId", "${paperId}", "scoringType", "${scoringType}"}),
@Result(name = "exam-detail", location = "/WEB-INF/content/aty/enroll-learner-exam-detail.jsp", params = { "actionName", "examinees-history", "namespace", "/aty", "siteId", "${siteId}", "folderId", "${folderId}", "activityId", "${activityId}", "activityType", "${activityType}", "paperId", "${paperId}"}),
@Result(name = "exam-detail-view", location = "/WEB-INF/content/aty/enroll-learner-exam-detail-view.jsp", params = { "actionName", "examinees-history", "namespace", "/aty", "siteId", "${siteId}", "folderId", "${folderId}", "activityId", "${activityId}", "activityType", "${activityType}", "paperId", "${paperId}"}),
@Result(name = "exam-detail-view-questions", location = "/WEB-INF/content/aty/enroll-learner-exam-detail-view-questions.jsp", params = { "actionName", "examinees-history", "namespace", "/aty", "siteId", "${siteId}", "folderId", "${folderId}", "activityId", "${activityId}", "activityType", "${activityType}", "paperId", "${paperId}"})
}
)

    @com.kingnod.core.annotation.Generated("2012-03-16 19:59")
public class ExamineesHistoryAction extends FilterableEntityAction<ExamineesHistory, Long> {
	private static final long serialVersionUID = 3829895989359999502L;
	@Autowired
    private ExamineesHistoryService examineesHistoryService;
	@Autowired
	private ExamineeQuestionService examineeQuestionService;
	@Autowired
	private ExaminationService examinationService;
	
    private Long activityId;
    private Long userId;
    private Long paperId;
    private String fullName;
    private String loginName;

    private Long siteId;
    private Long folderId;
    private ObjectType activityType;
    private String paperTotalScore;
    
	private List<Question> questionList;	//考试试题
	private List<QuestionAnswer> answerList;//考试答案
	private Examination exam;				//考试活动
	private ExamineesHistory examHistory;	//考试活动历史
	private ExamineeQuestion examQuestion;
	private List<TestGroup> testGroupList = new ArrayList<TestGroup>();

    
    @com.kingnod.core.annotation.Generated("2012-03-16 19:59")
    public String filterDefines() {
        return "aty.examDetailsFilterItems";
    }

    
    @com.kingnod.core.annotation.Generated("2012-03-16 19:59")
    protected Object getEntityService() {
        return this.examineesHistoryService;
    }
    
    
    /**
     * 考试活动_考试详情
     * @return
     * @throws Exception
     */
    public String list() throws Exception {
    	Criteria criteria = createCriteria()
    						.addParam("scoringType", entity.getScoringType())
    						.addParam("examinationId", entity.getExaminationId());
		PagingResult<ExamineesHistory> pagingResult = examineesHistoryService.findExamDetails(criteria);
		pager.setTotalCount(pagingResult.getTotalRows());
		pager.setResult(pagingResult.getResult());
		request.setAttribute("pager", pager);
    	return "exam-details";
    }
    
    
    /**
     * 考试活动_考试详情_考试历史记录列表
     * @return
     * @throws Exception
     */
    public String examDetail() throws Exception {
		if(activityId != null){
			CriteriaBuilder cb = Cnd.builder(ExamineesHistory.class);
			cb.andEQ("userId", userId).andEQ("EXAMINATION_ID", activityId).andEQ("atyPaperId", paperId).addParam("isQuery", "true");
			PagingResult<ExamineesHistory> pagingResult = examineesHistoryService.findExamineesHistory(cb.buildCriteria());
			
			pager.setTotalCount(pagingResult.getTotalRows());
			pager.setResult(pagingResult.getResult());
			setTotal(pagingResult.getResult());
			
			request.setAttribute("page", pager);
		}
    	return "exam-detail";
    }
    
    public void setTotal(List<ExamineesHistory> list){
    	if(list != null && list.size() > 0){
    		Float totalScore = 0F;
    		for (ExamineesHistory examHistory : list) {
    			totalScore = examHistory.getTotalscore();
    			if(totalScore != null){
    				examHistory.setTotalScoreStr(ExamUtil.formatNumerical(totalScore));
    			}else{
    				examHistory.setTotalScoreStr(ExamUtil.formatNumerical(examHistory.getScore()));
    			}
			}
    	}
    }

	/**
	 * TODO 查看整张试卷答题情况
	 * @return String
	 */
	public String examDetailView(){
		if(examHistory != null){
			exam = examinationService.getExamination(examHistory.getExaminationId());
			exam.setDisplayAnswer("ConsultAnswer");
			examHistory = examineesHistoryService.getExamineesHistory(examHistory.getId());
			if(exam != null && exam.getTotalScore() == null){
				exam.setTotalScore(0);
			}
			if(examHistory != null && examHistory.getScore() == null){
				examHistory.setScore(0F);
			}
			examHistory.setTotalScoreStr(ExamUtil.formatNumerical(getTotalScore(examHistory)));//设置考试记录总分数
			request.setAttribute("exam", exam);
			request.setAttribute("examin", examHistory);
			
			testGroupList = examineeQuestionService.previewPaperOrExam(null, examHistory);
		}
		return "exam-detail-view";
	}
	

	/**
	 * 查看整张试卷答题情况_试题内容
	 * @return
	 * @throws IOException
	 */
	public String examDetailViewQuestions() throws IOException {
		if(examHistory.getId() != null){
			examHistory = examineesHistoryService.getExamineesHistory(examHistory.getId());
			exam = examinationService.getExamination(examHistory.getExaminationId());
			exam.setTimes(examHistory.getTimes());
			testGroupList = examineeQuestionService.previewPaperOrExam(null, examHistory);
			
			setViewInfo();//设置阅卷人，审核人信息
			request.setAttribute("displayAnswer",getDisplayAnswer(exam));
			request.setAttribute("testGroupList", testGroupList);
		}
		
		return "exam-detail-view-questions";
	}
	
	/**
	 * 设置阅卷人，审核人信息
	 */
	public void setViewInfo(){
		List<Question> listQuestion = new ArrayList<Question>();//主观题
		List<Long> quesIds = new ArrayList<Long>();//获取试卷所有主观题Id
		for (TestGroup testGroup : testGroupList) {
			if(getQuestionType(testGroup.getQuestionType())){
				List<Question> list = testGroup.getQuestionList();
				for (Question question : list) {
					if(getQuestionType(question.getType())){
						quesIds.add(question.getId());
						listQuestion.add(question);
					}
				}
			}
		}
		List<ExamineeQuestion> examQuess = examineeQuestionService.getExamQuestionByIds(quesIds);//根据主观题Id获取ExamineeQuestion
		for (ExamineeQuestion examQues : examQuess) {
			canIfApprove(examQues);
			q : for (Question ques : listQuestion) {
				if(ques.getId().longValue() == examQues.getId().longValue()){
					ques.setExamineeQuestion(examQues);
					break q;
				}
			}
		}
	}
	
	/**
	 * 判断是否需要审核,用来后台管理员查阅试卷，能否给分。
	 * @param examQues
	 * @return boolean
	 */
	public void canIfApprove(ExamineeQuestion examQues){
		boolean bool = false;
		if(exam != null && examQues != null){
			String markingCheck = exam.getMarkingCheck();//是否需要审核
			if(StringUtils.isNotEmpty(markingCheck) && "Y".equals(markingCheck)){//需要审核
				bool = "P".equals(examQues.getStatus()) ? true : false;
			}else{
				bool = "R".equals(examQues.getStatus()) ? true : false;
			}
		}
		examQues.setApproveStatus(bool);
	}
	/**
	 * 判断是否是主观题
	 * @param type
	 * @return boolean
	 */
	public boolean getQuestionType(String type){
		boolean bool = false;
		if(StringUtils.isNotEmpty(type)){
			bool = "R".equals(type) || "C".equals(type) || "B".equals(type) ? false : true;
		}
		return bool;
	}
	
	/**
	 * 试题顺序对应测试区里的试题顺序
	 * @param quesList
	 * @return List<Question>
	 */
	public List<Question> questionSort(List<Question> quesList){
		List<String> testGroupSeq = ExamUtil.getTestGroupSeq();
		
		List<Question> list = new ArrayList<Question>();
		for (String string : testGroupSeq) {
			for (Question question : quesList) {
				if(StringUtils.equals(string, question.getType())){
					list.add(question);
				}
			}
		}
		return list;
	}



/**
 * 设置试题分数
 * @param list
 * @param question
 */
public void setExamQuestionScore(List<ExamineeQuestion> list,Question question){
	if(question != null && list != null && list.size() > 0){
		for(ExamineeQuestion examQuestion : list){
			if(examQuestion.getQuestionId().longValue() == question.getId().longValue()){
				question.setScore(examQuestion.getScore() == null ? 0.0F : examQuestion.getScore());
				break;
			}
		}
	}
}

/**
 * 获取是否显示正确答案的标识符
 * @param exam
 * @return String
 */
public String getDisplayAnswer(Examination exam){
	String defalut = com.kingnod.etraining.exam.ExamConstant.STATUS_CONSULT;
	if(exam != null){
		return StringUtils.isNotEmpty(exam.getDisplayAnswer()) ? exam.getDisplayAnswer() : defalut;
	}
	return defalut;
}

/**
 * 获取单选，判断，多选
 * @param question
 * @param answerList
 */
public void setExamRightAnswer(Question question,List<QuestionAnswer> answerList,List<ExamineeQuestion> list){
	List<QuestionAnswer> questionAnswers = new ArrayList<QuestionAnswer>();
	for(QuestionAnswer answer : answerList){
		if(question.getId().longValue() == answer.getQuestionId().longValue()){
			if(StringUtils.isEmpty(answer.getItemContent())){
				answer.setItemContent("");
			}
			questionAnswers.add(answer);
		}
	}
	question.setQuestionAnswers(questionAnswers);//保存答案集,比如单选题的多个答案选项
	
	for(ExamineeQuestion examQuestion : list){
		if(question.getId().longValue() == examQuestion.getQuestionId().longValue()){
			String rightAnswer = examQuestion.getCorrectAnswers();//正确答案集Id
			List<Long> rightLong = getCorrectAnswersIds(rightAnswer);
			List<String> listRightStr = new ArrayList<String>();
			for(QuestionAnswer answer : answerList){
				for(Long l : rightLong){
					if(answer.getId().longValue() == l){
						listRightStr.add(answer.getItemContent());
					}
				}
			}
			question.setRightAnswer(listRightStr);
			
			List<String> listExamStr = new ArrayList<String>();
			String examAnswer = examQuestion.getExamineeAnswer();//考生答案
			if(StringUtils.equals(question.getType(), "T") && StringUtils.isNotEmpty(examAnswer)){
				String[] a = examAnswer.split(",");
				for (String string : a) {
					listExamStr.add(string);
				}
			}else{
				List<Long> examLong = getCorrectAnswersIds(examAnswer);
				
				for(QuestionAnswer answer : answerList){
					for(Long l : examLong){
						if(answer.getId().longValue() == l){
							listExamStr.add(answer.getItemContent());
						}
					}
				}
			}
			question.setExamAnswer(listExamStr);
		}
	}
}

/**
 * 设置简答题
 * @param question
 * @param answerList
 * @param list
 */
public void setJianDa(Question question,List<QuestionAnswer> answerList,List<ExamineeQuestion> list){
	List<String> lista = new ArrayList<String>();
	for(QuestionAnswer answer : answerList){
		if(question.getId().longValue() == answer.getQuestionId().longValue()){
			lista.add(StringUtils.isNotEmpty(answer.getItemContent()) ? answer.getItemContent() : "");
		}
	}
	if(lista.size() == 0)lista.add("");
	question.setRightAnswer(lista);//保存正确答案
	
	List<String> lists = new ArrayList<String>();
	for(ExamineeQuestion examQuestion : list){
		if(question.getId().longValue() == examQuestion.getQuestionId().longValue()){
			lists.add(StringUtils.isNotEmpty(examQuestion.getExamineeAnswer()) ? examQuestion.getExamineeAnswer() : "");
		}
	}
	if(lists.size() == 0)lists.add("");
	question.setExamAnswer(lists);//保存考生答案
}

	/**
	 * 获取答案集数组
	 * @param cAnswers
	 * @return List<Long>
	 */
	public List<Long> getCorrectAnswersIds(String cAnswers){
		List<Long> list = new ArrayList<Long>();
		if(StringUtils.isNotEmpty(cAnswers)){
			for(String answer : cAnswers.split(",")){
				Long lanswer = NumberUtils.toLong(answer);
				if(lanswer != null){
					list.add(lanswer);
				}
			}
		}
		return list;
	}
	
	
	/**
	 * TODO 管理员查阅试卷，重新打分（超级管理员在后台操作）
	 * @return String
	 */
	public String saveViewScore() {
		if(examQuestion != null 
				&& examQuestion.getExaminationId() != null 
				&& examQuestion.getExamNumber() != null 
				&& examQuestion.getQuestionId() != null 
				&& examQuestion.getScore() != null){
			
			Float newScore = examQuestion.getScore();//重新给的分数
			
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("examId", examQuestion.getExaminationId());//考试活动Id
			map.put("examNumber", examQuestion.getExamNumber());//考试活动的次数
			map.put("questionId", examQuestion.getQuestionId());//重新给分的试题Id
			
			ExamineeQuestion examQuestions = examineeQuestionService.getExamQuestionByGiveScore(map);
			if(examQuestions != null && examQuestions.getScore() != null){
				Float oldScore = 0F;
				if(examQuestions.getApproveScore() != null){
					map.put("approveScore", newScore);
					oldScore = examQuestions.getApproveScore().floatValue();
				}else if(examQuestions.getViewScore() != null){
					map.put("viewScore", newScore);
					oldScore = examQuestions.getViewScore().floatValue();
				}
				
				//修改审核得分
				examineeQuestionService.updateNewScore(map);
				
				//修改考试记录的总分数
				map.put("totalScore", examQuestions.getScore() - oldScore + newScore);//新的总分数
				examineesHistoryService.updateNewTotalScore(map);
			}
		}
		return "jsonResult";
	}


	/**
	 * 获取本次考试记录 - 考生得分
	 * @return Float
	 */
	public Float getTotalScore(ExamineesHistory exmaHistory){
		Float totalScroeStr = 0.0F;
		if(exmaHistory != null){
			//totalScore是自动阅卷得分和手动阅卷得分的和
			totalScroeStr = exmaHistory.getTotalscore() == null ? exmaHistory.getScore() : exmaHistory.getTotalscore();//手动阅卷得分
		}
		return totalScroeStr;
	}
	

	/**
	 * 给测试区排序
	 */
	public void testGroupSort(){
		//给测试区中的试题标识排序
		List<String> testGroupSeq = ExamUtil.getTestGroupSeq();
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
	

	public Long getActivityId() {
		return activityId;
	}


	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}


	public Long getUserId() {
		return userId;
	}


	public void setUserId(Long userId) {
		this.userId = userId;
	}


	public Long getPaperId() {
		return paperId;
	}


	public void setPaperId(Long paperId) {
		this.paperId = paperId;
	}


	public Long getSiteId() {
		return siteId;
	}


	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}


	public Long getFolderId() {
		return folderId;
	}


	public void setFolderId(Long folderId) {
		this.folderId = folderId;
	}


	public ObjectType getActivityType() {
		return activityType;
	}


	public void setActivityType(ObjectType activityType) {
		this.activityType = activityType;
	}


	public String getPaperTotalScore() {
		return paperTotalScore;
	}


	public void setPaperTotalScore(String paperTotalScore) {
		this.paperTotalScore = paperTotalScore;
	}


	public ExamineesHistory getExamHistory() {
		return examHistory;
	}


	public void setExamHistory(ExamineesHistory examHistory) {
		this.examHistory = examHistory;
	}


	public List<Question> getQuestionList() {
		return questionList;
	}


	public void setQuestionList(List<Question> questionList) {
		this.questionList = questionList;
	}


	public List<QuestionAnswer> getAnswerList() {
		return answerList;
	}


	public void setAnswerList(List<QuestionAnswer> answerList) {
		this.answerList = answerList;
	}


	public ExamineeQuestion getExamQuestion() {
		return examQuestion;
	}


	public void setExamQuestion(ExamineeQuestion examQuestion) {
		this.examQuestion = examQuestion;
	}


	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public String getLoginName() {
		return loginName;
	}


	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}


	public Examination getExam() {
		return exam;
	}


	public void setExam(Examination exam) {
		this.exam = exam;
	}


	public List<TestGroup> getTestGroupList() {
		return testGroupList;
	}


	public void setTestGroupList(List<TestGroup> testGroupList) {
		this.testGroupList = testGroupList;
	}

}