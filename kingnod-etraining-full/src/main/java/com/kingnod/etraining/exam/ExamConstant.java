package com.kingnod.etraining.exam;

public final class ExamConstant {

	private ExamConstant() {
		
	}

	// 常量名需要大写，词与词之间用“_”分隔， 例如：public static final String RECORD_STATUS_ACTIVE =
	// "A";
	public static final String COMM_DISPLAY_R = "R"; // 随机显示
	public static final String COMM_DISPLAY_F = "R"; // 固定显示
	public static final String QUESTION_TYPE_R = "R"; // R: 单选题
	public static final String QUESTION_TYPE_C = "C"; // C：多选题
	public static final String QUESTION_TYPE_B = "B"; // B: 判断题
	public static final String QUESTION_TYPE_T = "T"; // T：填空题
	public static final String QUESTION_TYPE_A = "A"; // A: 简答题
	public static final String QUESTION_TYPE_Z = "Z"; // Z: 组合题
	public static final String QUESTION_TYPE_U = "U"; // U: 无限制
	
	/**
	 * 知识类型
	 */
	public static final String KNOWLEDGE_K = "K"; // 知识点
	public static final String KNOWLEDGE_C = "C"; // 课程
	public static final String KNOWLEDGE_E = "E"; // 组卷规则中的知识点
	public static final String KNOWLEDGE_O = "O"; // 组卷规则中的课程
	
	/**
	 * 组卷类型
	 */
	public static final String GENERATOR_PAPER_A = "A"; // 自动组卷
	public static final String GENERATOR_PAPER_M = "M"; // 手工组卷
	
	public static final String PREVIEW = "preview"; // 预览
	public static final String BACK = "back"; // return数据为空
	public static final String COMM_NBSP = "&nbsp;&nbsp;"; // 空格
	
	/**
	 * 定义json
	 */
	public static final String ACTION_JSONRESULT = "jsonResult"; // 返回jsonResult
	public static final String ACTION_JSONROOT = "jsonRoot"; // set jsonRoot
	
	/**
	 * 考生试题状态
	 */
    public static final String EXAM_QUES_STATUS_S = "S"; // 考试中
    public static final String EXAM_QUES_STATUS_E = "E"; // 考试结束
    public static final String EXAM_QUES_STATUS_N = "N"; // 还未开始
    public static final String EXAM_QUES_STATUS_A = "A"; // 阅卷中
    public static final String EXAM_QUES_STATUS_R = "R"; // 阅卷完成
    public static final String EXAM_QUES_STATUS_D = "D"; // 审核中
    public static final String EXAM_QUES_STATUS_P = "P"; // 审核完成
    
    /**
     * 考试限制，每天/每月/每周可以考试多少次，配合考试次数一起用
     */
    public static final String EXAM_RESTRAINT_STATUS_N = "N"; // 无
    public static final String EXAM_RESTRAINT_STATUS_D = "D"; // 每天
    public static final String EXAM_RESTRAINT_STATUS_W = "W"; // 每周
    public static final String EXAM_RESTRAINT_STATUS_M = "M"; // 每月
	
    /**
     * 阅卷方式
     */
    public static final String EXAM_READINGTYPE_A = "A"; // 自动阅卷
    public static final String EXAM_READINGTYPE_M = "M"; // 人工阅卷
    
    /**
     * 试卷状态
     * P：未发布， C: 审核中， R：已发布';
     */
    public static final String STATUS_P = "P";
    public static final String STATUS_C = "C";
    public static final String STATUS_R = "R";
    
    /**
     * 查阅试卷时，是否显示正确答案
     * ConsultAnswer:显示正确答案，Consult：不显示争取答案
     */
    public static final String STATUS_CONSULT_Y = "Y";//显示成绩
    public static final String STATUS_CONSULT_N = "N";//不显示成绩
    public static final String STATUS_CONSULT_ANSWER = "ConsultAnswer";
    public static final String STATUS_CONSULT = "Consult";
    
    /**
     * 定义ACTION
     */
    public static final String ACTION_VIEW = "view";
    public static final String ACTION_PUBLISH = "publish";
    public static final String ACTION_EDITQUESTION = "editQuestion";
    public static final String ACTION_EDITANSWER = "editAnswer";
    public static final String ACTION_SAVE = "save";
    
    /**
     * 考试记录状态
     */
    public static final String HISTORY_STATUS_I = "I";//未阅卷
    public static final String HISTORY_STATUS_A = "A";//阅卷中
    public static final String HISTORY_STATUS_S = "S";//阅卷成功
    public static final String HISTORY_STATUS_D = "D";//审核中
    public static final String HISTORY_STATUS_P = "P";//审核完成
    
    /**
     * jsp页面公用
     */
    public static final String JSP_STATUS_Y = "Y";//阅卷
    public static final String JSP_STATUS_S = "S";//审核
    public static final String JSP_STATUS_AUSWERTUNG = "阅卷";//阅卷
    public static final String JSP_STATUS_AUDITING = "审核";//审核
    
    /**
     * 定义 SQL
     */
	public static final String EXAM_FINDQUESTIONLIST = "findQuestionList";
	public static final String EXAM_FINDCHILDQUESTIONLIST = "findChildQuestionList";
	public static final String EXMA_FINDLISTBYEXAMINEEANSWER = "findListByExamineeAnswer";
	public static final String EXAM_TOTALFRACTION = "totalFraction";
	public static final String EXAM_EXAMACTIVITYQUESTION = "findExamActivityQuestion";
	public static final String EXAM_EXAMACTIVITYQUESTIONCOUNT = "findExamAnswerQuestionCount";
	public static final String EXAM_FINDEXAMQUESTION = "findExamQuestion";
	public static final String EXAM_EXAMACTIVITYANSWER = "findExamActivityAnswer";
	public static final String EXAM_FINDANSWERSITUATIONTOTAL = "findAnswerSituationTotal";
	public static final String FINDUSERBYEXAMINATION = "findUserByExaminationInfo";
	public static final String FINDMAXTIMESBYID = "findMaxTimesById";
	public static final String EXAM_MAX_SURPLUSNUMBER = "findExamMaxSurplusnumber";
	public static final String FINDMAXBYTIMES = "findMaxByTimes";
	public static final String FINDLASTBYTIMES = "findLastByTimes";
	public static final String FINDSOCREANDQUESTIONNUMBER = "findSocreAndQuestionNumber";
	public static final String FINDBYTESTGROUPIDS = "findBytestGroupIds";
	public static final String FINDMAXBYGROUPSEQ = "findMaxByGroupSeq";
	public static final String FINDBYGROUPSEQ = "findByGroupSeq";
	public static final String UPDATEALLGROUPSEQES = "updateAllGroupSeqes";
	public static final String DELETEBYCRITERIA = "TestGroup.deleteByCriteria";
	public static final String FINDBYQUESTIONID = "findByQuestionId";
	public static final String FINDCRITERIABYQUESTION = "findCriteriaByQuestion";
	public static final String SEARCHBYQUESTION = "searchByQuestion";
	public static final String FINDBYSEQUENCE = "findBySequence";
	public static final String FINDLISTBYPARENTID = "findListByParentId";
	public static final String FINDMAXBYSEQUENCEONE = "findMaxBySequenceOne";
	public static final String FINDPAPERTESTGROUPBYEXAMID = "findPaPerTestGroupByExamId";
	public static final String FINDPAPERTESTGROUPBYPAPERID = "findPaPerTestGroupByPaperId";
	public static final String UPDATEALLSEQUENCES = "updateAllSequences";
	public static final String QTGDELETEBYCRITERIA = "QuestionTestGroup.deleteByCriteria";
	public static final String FINDFOLDERNAMEBYID = "findFolderNameById";
	public static final String FINDLISTBYQUESTIONS = "findListByQuestions";
	public static final String FINDFOLDERNAMEBYFOLDERID = "findfolderNameByfolderId";
	public static final String FINDREADEXAMINATION = "findReadExamination";
	public static final String FINDATYRESTRAINTCOUNT = "findAtyRestraintCount";
	public static final String FINDEXAMAVGSCORE = "findExamAVGScore";
	public static final String FINDEXAMMAXSCORE = "findExamMAXScore";
	public static final String FINDEXAMLASTSCORE = "findExamLASTScore";
	public static final String FINDEXAMINATIONDETAIL = "findExamDetail";
	public static final String FINDEXAMINATIONDETAILPAGE = "findExamDetailPage";
	public static final String FINDEXAMINATIONDETAILPAGECOUNT = "findExamDetailPageCount";
	public static final String FIND_EXAMINATION_DETAILS = "findExamDetails";
	public static final String FINDEXAMHISTORYUSERCOUNT = "findExamHistoryUserCount";
	
	public static final String FINDCANAUSWERTUNGHISTORY = "findCanAuswertungHistory";//可以阅卷的考试记录
	public static final String UPDATEEXAMHISTORYAUSWERTUNGSTATUS = "updateExamHistoryAuswertungStatus";// 修改考试记录表的阅卷状态 --阅卷中
	public static final String UPDATEEXAMHISTORYSUCCESSSTATUS = "updateExamHistorySuccessStatus";// 修改考试记录表的阅卷状态 -- 阅卷成功
	public static final String FINDCANEXAMHISTORYNUMBER = "findCanExamHistoryNumber";//抽取阅卷员指定的阅卷数量
	public static final String FINDEXAMQUESTIONBYUSER = "findExamQuestionByUser";//获取学员试卷的试题
	public static final String FINDEXAMAUSWERTUNGQUESTIONCOUNT = "findExamAuswertungQuestionCount";//可阅卷的题目数
	public static final String UPDATEEXAMQUESTIONAUSWERTUNGINFO = "updateExamQuestionAuswertungInfo";//修改试卷的阅卷信息
	public static final String FINDEXAMAUSWERTUNGSTATUS = "findExamAuswertungStatus";//修改试卷的阅卷信息
	public static final String CALCULATETOTALSCORE = "calculateTotalScore";//修改试卷的阅卷信息
	public static final String UPDATEEXAMHISTORYTOTALSCORE = "updateExamHistoryTotalScore";//修改试卷记录表的总分数
	
	public static final String ACTION_E = "E"; // 考试结束
	public static final String FINDQUESTION = "findListByInteractionQuestion";
	public static final String PREVIE = "findPreviewByQuestion";
	public static final String FINDFOLDERNAME_KNOWLEDGE = "findfolderName_knowledge";
	public static final String FINDFOLDERNAME_PAPER = "findFolderName_paper";
	public static final String FINDFOLDERNAME_EXAMINATION = "findFolderName_examination";
	public static final String FINDEXAMINATIONBYID = "findExaminationById";//FINDEXAMINATIONBYID
	public static final String FINDPAPERNAME = "findPaperNameByPaperId";
	public static final String DELETEALL = "deleteAllAnswersById";
	public static final String  PAGEKNOWLEGGEQUEST= "findByCriteriaKnowledgeQuestion"; //小马添加试题关联知识点查询
	public static final String PAGECOUNTKNOWLEGGEQUEST = "countByCriteriaKnowledgeQuestion"; //小马添加试题关联知识点查询
	
}
