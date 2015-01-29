package com.kingnod.etraining.exam.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.criteria.Order;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.core.util.SecurityUtils;
import com.kingnod.core.util.StringUtils;
import com.kingnod.core.util.collection.CollectionUtils;
import com.kingnod.core.util.collection.ListUtils;
import com.kingnod.etraining.activity.dao.ExamineesHistoryDAO;
import com.kingnod.etraining.activity.entity.Examination;
import com.kingnod.etraining.activity.entity.ExamineesHistory;
import com.kingnod.etraining.exam.ExamConstant;
import com.kingnod.etraining.exam.dao.ExamineeAnswerDAO;
import com.kingnod.etraining.exam.dao.ExamineeQuestionDAO;
import com.kingnod.etraining.exam.dao.GeneratingPaperRuleDAO;
import com.kingnod.etraining.exam.dao.GeneratingPaperScopeDAO;
import com.kingnod.etraining.exam.dao.QuestionDAO;
import com.kingnod.etraining.exam.dao.TestGroupDAO;
import com.kingnod.etraining.exam.entity.ConditionRule;
import com.kingnod.etraining.exam.entity.ExaminationManage;
import com.kingnod.etraining.exam.entity.ExamineeAnswer;
import com.kingnod.etraining.exam.entity.ExamineeQuestion;
import com.kingnod.etraining.exam.entity.GeneratingPaperRule;
import com.kingnod.etraining.exam.entity.GeneratingPaperScope;
import com.kingnod.etraining.exam.entity.Question;
import com.kingnod.etraining.exam.entity.QuestionAnswer;
import com.kingnod.etraining.exam.entity.TestGroup;
import com.kingnod.etraining.exam.service.ExamineeQuestionService;
import com.kingnod.etraining.security.entity.UserAccount;

@org.springframework.stereotype.Service
public class ExamineeQuestionServiceImpl implements ExamineeQuestionService {
	@Autowired
	protected ExamineeQuestionDAO examineeQuestionDAO;
	@Autowired
	private ExamineeAnswerDAO examineeAnswerDAO;
	@Autowired
	protected TestGroupDAO testGroupDAO;
	@Autowired
	private ExamineesHistoryDAO examineesHistoryDAO;
	@Autowired
	private GeneratingPaperRuleDAO ruleDAO;
	@Autowired
	private GeneratingPaperScopeDAO scopeDAO;
	@Autowired
	private QuestionDAO questionDAO;

	public ExamineeQuestion getExamineeQuestion(Long id) {
		return examineeQuestionDAO.get(id);
	}

	public int saveExamineeQuestion(ExamineeQuestion examineeQuestion) {
		int count = 0;
		IdEntity<Long> idEntity = (IdEntity<Long>) examineeQuestion;
		if (null != idEntity.getId()
				&& null != examineeQuestionDAO.get(idEntity.getId())) {
			count = examineeQuestionDAO.update(examineeQuestion);
		} else {
			count = examineeQuestionDAO.insert(examineeQuestion);
		}
		return count;
	}

	public int deleteExamineeQuestion(ExamineeQuestion examineeQuestion) {
		return examineeQuestionDAO.delete(examineeQuestion);
	}

	public int deleteExamineeQuestionByIds(Long[] ids) {
		return examineeQuestionDAO.deleteById(ids);
	}

	public PagingResult<ExamineeQuestion> findExamineeQuestion(Criteria criteria) {
		return examineeQuestionDAO.findPagingResult(criteria);
	}
	
	
	/**
	 * 计算阅卷-审核总分数
	 * 
	 */
	public boolean calculateTotal(Examination examination) {
		boolean bool = false;
		int questionTotalSize = -1;
		
		// 只查询得到所有 考生考试的历史记录  
		List<ExamineesHistory> historyList = examineesHistoryDAO.findByCriteria(Cnd.builder(ExamineesHistory.class).andEQ("status", examination.getStatus()).andEQ("examinationId", examination.getId()).buildCriteria());
		for (ExamineesHistory history : historyList) {
			CriteriaBuilder cb = Cnd.builder(ExamineeQuestion.class);
			cb.andEQ("userId", history.getUserId()).andEQ("examPaperId", history.getAtyPaperId())
			.andEQ("examinationId", history.getExaminationId()).andEQ("examNumber", history.getTimes());
			
			if(questionTotalSize == -1){
				questionTotalSize = examineeQuestionDAO.countByCriteria(cb.buildCriteria()); // 查询当前考生参加考试活动试卷中的试题总数量
			}
			
			if(ExamConstant.EXAM_QUES_STATUS_E.equals(examination.getStatus())) {// ---------- 阅卷
				cb.andGroup(Cnd.builder().orEQ("status", ExamConstant.EXAM_QUES_STATUS_D)
						.orEQ("status", ExamConstant.EXAM_QUES_STATUS_R)
						.orEQ("status", ExamConstant.EXAM_QUES_STATUS_P));
			} else if(ExamConstant.EXAM_QUES_STATUS_R.equals(examination.getStatus())){// ---------- 审核
				cb.andGroup(Cnd.builder().orEQ("status", ExamConstant.EXAM_QUES_STATUS_P));
			}
			
			// 查询考生试题记录中  否则还存在阅卷中的试题 （是否阅卷完成）
			List<ExamineeQuestion> examQuestionList = examineeQuestionDAO.findByCriteria(cb.buildCriteria());
			// 如果不存在  则计算该考生的阅卷分数  并将阅卷的分数   与   自动阅卷的分相加  存入  考生历史记录表中
			if(questionTotalSize == examQuestionList.size()) {
				if(ExamConstant.EXAM_QUES_STATUS_E.equals(examination.getStatus())){// ---------- 阅卷
					String markingCheck = examination.getMarkingCheck();//是否存在审核人员，如果不存在就计算总分
					if(StringUtils.isNotEmpty(markingCheck) && "N".equals(markingCheck)){
						history = getCalculateScore(history);//计算总分
						bool = true;
					}
					history.setStatus(ExamConstant.EXAM_QUES_STATUS_R); // 阅卷完成状态
				}else if(ExamConstant.EXAM_QUES_STATUS_R.equals(examination.getStatus())){// ---------- 审核
					bool = true;
					history = getCalculateScore(history);//计算总分
					history.setStatus(ExamConstant.EXAM_QUES_STATUS_P); //审核完成状态
				}
				examineesHistoryDAO.update(history);
			}
		}
		return bool;
	}
	
	/**
	 * 计算总分数
	 * @param history
	 * @return ExamineesHistory
	 */
	public ExamineesHistory getCalculateScore(ExamineesHistory history){
		Integer auswertungScore = examineeQuestionDAO.calculateAuswertungScore(history);// 计算阅卷分数
		Float totalScore = auswertungScore + history.getScore();
		history.setTotalscore(totalScore); // setter 总分数
		return history;
	}
	
	/**
	 * 处理 -- 随机取出题目
	 * 答案选项显示次序  -- ANSWER_DISPLAY_ORDER
	 * 试题显示次序  -- DISPLAY_ORDER
	 * 处理 -- 试题显示次序：F，固定显示  R，随机显示
	 * 答案选项显示次序： F，固定显示  R，随机显示
	 */
	public List<Question> randomList(List<Question> questionList, Examination examination) {
		//是否随机显示 -- 试题次序
		List<Question> qList = null;
		List<Question> quesList = null;
		if(ExamConstant.COMM_DISPLAY_R.equals(examination.getDisplayOrder())) {
			quesList = CollectionUtils.shuffle(questionList);
		}
		// 判断是否经过试题随机  如果没有 将questionList赋值给quesList
		if(null == quesList) {
			quesList = questionList;
		}
		qList = new ArrayList<Question>();
		for (Question question : quesList) {
			// 是否随机显示  答案
			if(ExamConstant.COMM_DISPLAY_R.equals(examination.getAnswerDisplayOrder())) {
				List<QuestionAnswer> answerList = question.getQuestionAnswers();
				if(ListUtils.isEmpty(answerList)) {
					continue;
				}
				String type = answerList.get(0).getType();
				// 得到题目类型   只对单选题 、   多选题  、 判断题、  进行答案随机
				if(ExamConstant.QUESTION_TYPE_R.equals(type) || ExamConstant.QUESTION_TYPE_C.equals(type) || ExamConstant.QUESTION_TYPE_B.equals(type)) {
					List<QuestionAnswer> quesAnswerList = CollectionUtils.shuffle(question.getQuestionAnswers());
					question.setQuestionAnswers(quesAnswerList);
					question = this.processAnswerOption(question);
				}
			} else {
				question = this.processAnswerOption(question);
			}
			qList.add(question);
		}
			return qList;
	}
	/**处理答案选项
	 * @param quesAnswerList
	 * @return
	 */
	protected Question processAnswerOption(Question question) {
		List<QuestionAnswer> quesAnswerList = null;
		if("Z".equals(question.getType())) {
			List<Question> childQuestionList = question.getChildQuestionList();
			List<Question> childQuesList = new ArrayList<Question>();
			for (Question childQuestion : childQuestionList) {
				Question childQues = new Question();
				childQues = childQuestion;
				quesAnswerList = childQuestion.getQuestionAnswers();
				childQues.setQuestionAnswers(this.addAnswers(quesAnswerList));
				childQuesList.add(childQues);
			}
			question.setChildQuestionList(childQuesList);
		} else {
			quesAnswerList = question.getQuestionAnswers();
			question.setQuestionAnswers(this.addAnswers(quesAnswerList));
		}
		return question;
	}
	
	/**
	 * 查询已经生成的考生试题
	 * @param history
	 * @return
	 */
	public List<TestGroup> getAlreadyExamineeQuestion(ExamineesHistory history) {
		List<TestGroup> testGroupList = new ArrayList<TestGroup>();
		if(null != history) {
			testGroupList = testGroupDAO.findTestGroups(history);
			ExamineeQuestion exam = new ExamineeQuestion();
			exam.setExamPaperId(history.getAtyPaperId());
			exam.setExaminationId(history.getExaminationId());
			exam.setExamNumber(history.getTimes());
			exam.setUserId(history.getUserId());
			for (TestGroup testGroup : testGroupList) {
				exam.setTestGroupId(testGroup.getId());
				List<Question> questionList = this.findAlreadyGenneratedQuestion(exam);
				testGroup.setQuestionList(questionList);
			}
		}
		return testGroupList;
	}
	
	
	private Integer findQuestionNumberSize(String[] folderIdArray, GeneratingPaperRule rule, List<Long> questionIds) {
		ConditionRule conditionRule = new ConditionRule();
		// setter folderId
		conditionRule.setFolderIdArray(folderIdArray);
		String knowledgeIds = rule.getKnowledgeId();
		String courseIds = rule.getCourseId();
		String questionType = rule.getQuestionType();
		Short degree = rule.getDegree();
		// setter 知识点ID
		if(StringUtils.isNotEmpty(knowledgeIds)) {
			String[] knowledgeIdArray = knowledgeIds.split(",");
			conditionRule.setKnowledgeIdArray(knowledgeIdArray);
		}
		// setter 课程ID
		if(StringUtils.isNotEmpty(courseIds)) {
			String[] courseIdArray = courseIds.split(",");
			conditionRule.setCourseIdArray(courseIdArray);
		}
		// setter 试题类型
		if(StringUtils.isNotEmpty(questionType)) {
			conditionRule.setConditionType(questionType);
		}
		// setter 试题难度
		if(null != degree && 0 != degree) {
			conditionRule.setDegree(degree);
		}
		// setter questionIds
		if(ListUtils.isNotEmpty(questionIds)) {
			conditionRule.setIdsList(questionIds);
		}
		return scopeDAO.totalQuestionNumber(conditionRule);
	}
	
	
	/**
	 * 处理   
	 * 
	 * 1，预览试卷  与   预览考试活动    参数： 只需要new一个Examination  把examPaperId setter 穿进来即可 其它参数为null
	 * 
	 *      2，参加考试    参数： A，如果是第一次进来还没有生成考生试题  则只需要把 Examination穿进来即可， 其它参数为null
	 *      				  B，如果已经生成了试题，则不要再重新抽取试题  只需要把ExamineesHistory穿进来即可，其它参数为null
	 * @param examination
	 * @param history
	 * @return
	 */
	public List<TestGroup> previewPaperOrExam(Examination examination, ExamineesHistory history) {
		Long examPaperId = null;
		Long examinationId = null;
		Integer examNumber = null;
		if(null != examination) {
			examPaperId = examination.getAtyPaperId();
			examinationId = examination.getId();
			examNumber = examination.getTimes();
		} else {
			// 查询已经生成的考生试题
			return this.getAlreadyExamineeQuestion(history);
		}
		// 判断  examPaperId 为空   则默认去查询考生的历史记录
		if(null == examPaperId) {
			return this.getAlreadyExamineeQuestion(history);
		}
		
		// 查询手工抽题的测试区
		List<TestGroup> testGroups = testGroupDAO.findByCriteria(Cnd.builder(TestGroup.class).andEQ("examPaperId", examPaperId).andEQ("generatorPaperPattern", "M").buildCriteria());
		if(null == testGroups) {
			testGroups = new ArrayList<TestGroup>();
		}
		List<Long> rList = new ArrayList<Long>(); // 记录被添加过的单选题ID
		List<Long> cList = new ArrayList<Long>(); // *************多选题ID
		List<Long> bList = new ArrayList<Long>(); // *************判断题ID
		List<Long> tList = new ArrayList<Long>(); // *************填空题ID
		List<Long> aList = new ArrayList<Long>(); // *************简答题ID
		List<Long> allList = new ArrayList<Long>(); // 记录被添加过所有的试题ID
		for (TestGroup test : testGroups) {
			for (Question question : test.getQuestionList()) {
				String type = question.getType();
				allList.add(question.getId());
				if(ExamConstant.QUESTION_TYPE_R.equals(type)) {
					rList.add(question.getId());
				} else if(ExamConstant.QUESTION_TYPE_C.equals(type)) {
					cList.add(question.getId());
				} else if(ExamConstant.QUESTION_TYPE_T.equals(type)) {
					tList.add(question.getId());
				} else if(ExamConstant.QUESTION_TYPE_A.equals(type)) {
					aList.add(question.getId());
				} else if(ExamConstant.QUESTION_TYPE_B.equals(type)) {
					bList.add(question.getId());
				}
			}
		}
		if(null != examinationId && null != examNumber) {
			this.saveExamineeQuestionAndAnswer(testGroups, examination, null, null);
		}
		// 查询自动抽题的测试区
		List<TestGroup> tsetList = testGroupDAO.findByCriteria(Cnd.builder(TestGroup.class).andEQ("examPaperId", examPaperId).andEQ("generatorPaperPattern", "A").orderBy("groupSeq", Order.ASC).buildCriteria());
		
		int totalQuestionNumber = 0; // 题库的题目总数量
		for (TestGroup testGroup : tsetList) {
			if("A".equals(testGroup.getGeneratorPaperPattern())) {
				// 查询自动组卷规则列表
				List<GeneratingPaperRule> ruleList = ruleDAO.findRule(testGroup);
				// 查询自动组卷范围列表
				List<GeneratingPaperScope> scopeList = scopeDAO.findScope(testGroup);
				// 开始根据测试区设定的规则  进行随机抽题
				List<Question> questions = new ArrayList<Question>();
				for (GeneratingPaperRule rule : ruleList) {
					ConditionRule comdition = new ConditionRule();
					String questionType = rule.getQuestionType();
					// setter  题库
					String[] folderIdArray = null;
					if(!ListUtils.isEmpty(scopeList)) {
						folderIdArray = new String[scopeList.size()];
						for (int i = 0; i < scopeList.size(); i++) {
							folderIdArray[i] = scopeList.get(i).getQuestionFolderId();
						}
						comdition.setFolderIdArray(folderIdArray);
					}
					// 查询得到题库的题目数量
					totalQuestionNumber = this.findQuestionNumberSize(folderIdArray, rule, null);
					
					if(ExamConstant.QUESTION_TYPE_R.equals(questionType)) {
						int alreadyQuestionNumber = 0;
						if(ListUtils.isNotEmpty(rList)) {
							alreadyQuestionNumber = this.findQuestionNumberSize(folderIdArray, rule, rList);
						}
						totalQuestionNumber = totalQuestionNumber - alreadyQuestionNumber;
						//setter 已经被添加过的试题ID
						comdition.setIdsList(rList);
					} else if(ExamConstant.QUESTION_TYPE_C.equals(questionType)) {
						int alreadyQuestionNumber = 0;
						if(ListUtils.isNotEmpty(cList)) {
							alreadyQuestionNumber = this.findQuestionNumberSize(folderIdArray, rule, cList);
						}
						totalQuestionNumber = totalQuestionNumber - alreadyQuestionNumber;
						//setter 已经被添加过的试题ID
						comdition.setIdsList(cList);
					} else if(ExamConstant.QUESTION_TYPE_T.equals(questionType)) {
						int alreadyQuestionNumber = 0;
						if(ListUtils.isNotEmpty(tList)) {
							alreadyQuestionNumber = this.findQuestionNumberSize(folderIdArray, rule, tList);
						}
						totalQuestionNumber = totalQuestionNumber - alreadyQuestionNumber;
						//setter 已经被添加过的试题ID
						comdition.setIdsList(tList);
					} else if(ExamConstant.QUESTION_TYPE_A.equals(questionType)) {
						int alreadyQuestionNumber = 0;
						if(ListUtils.isNotEmpty(aList)) {
							alreadyQuestionNumber = this.findQuestionNumberSize(folderIdArray, rule, aList);
						}
						totalQuestionNumber = totalQuestionNumber - alreadyQuestionNumber;
						//setter 已经被添加过的试题ID
						comdition.setIdsList(aList);
					} else if(ExamConstant.QUESTION_TYPE_B.equals(questionType)) {
						int alreadyQuestionNumber = 0;
						if(ListUtils.isNotEmpty(bList)) {
							alreadyQuestionNumber = this.findQuestionNumberSize(folderIdArray, rule, bList);
						}
						totalQuestionNumber = totalQuestionNumber - alreadyQuestionNumber;
						//setter 已经被添加过的试题ID
						comdition.setIdsList(bList);
					} else {
						int alreadyQuestionNumber = 0;
						if(ListUtils.isNotEmpty(allList)) {
							alreadyQuestionNumber = this.findQuestionNumberSize(folderIdArray, rule, allList);
						}
						totalQuestionNumber = totalQuestionNumber - alreadyQuestionNumber;
						comdition.setIdsList(allList);
					}
					Float everyQuestionScore = rule.getEveryQuestionScore(); // 每题分数
					Short degree = rule.getDegree(); // 难度
					Integer amountQuestion = rule.getAmountQuestion(); // 需要抽取的题目数量
					String courseId = rule.getCourseId(); // 课程ID
					String knowledgeId = rule.getKnowledgeId(); // 知识点ID
					Random rand = new Random();
					// 组织抽题条件
					List<Integer> rowNumerdList = new ArrayList<Integer>();
					// 判断如果题目数量小于要抽取的考核题量  则跳出本次循环
					if(0 == totalQuestionNumber || totalQuestionNumber < amountQuestion) break;
					while (true) {
						Integer randNumber = rand.nextInt(totalQuestionNumber); // 在 totalQuestionNumber 题库总数量之间获取随机数
						randNumber += 1;
						if(randNumber < 0) {
							continue;
						}
						// 如果有相同的  则重新获取
						if(!ListUtils.isEmpty(rowNumerdList)) {
							if(rowNumerdList.indexOf(randNumber) != -1) {
								continue;
							}
						}
						rowNumerdList.add(randNumber);
						if(amountQuestion == rowNumerdList.size()) {
							break;
						}
					}
					// setter  随机抽取的试题rowNumer行数
					comdition.setRowNumerdList(rowNumerdList);
					// setter 试题难度系数
					if(null != degree && 0 != degree) {
						comdition.setDegree(degree);
					}
					// setter  课程
					if(!StringUtils.isEmpty(courseId)) {
						String[] courseIdArray = courseId.split(",");
						comdition.setCourseIdArray(courseIdArray);
					}
					// setter 知识点
					if(!StringUtils.isEmpty(knowledgeId)) {
						String[] knowledgeIdArray = knowledgeId.split(",");
						comdition.setKnowledgeIdArray(knowledgeIdArray);
					}
					// setter 试题类型
					comdition.setConditionType(questionType);
					// setter 试卷ID
					comdition.setExamPaperId(examPaperId);
					// setter userId
					comdition.setUserId(this.getUserId());
					// setter 活动ID
					comdition.setExaminationId(examinationId);
					// setter 本次随机生成试卷的考生考试次数
					comdition.setExamNumber(examNumber);
					
					// 开始根据条件抽取试题 
					List<Question> questionList = questionDAO.randomQuestion(comdition);
					for (Question question : questionList) {
						question.setScore(everyQuestionScore);
						String type = question.getType();
						allList.add(question.getId());
						if(ExamConstant.QUESTION_TYPE_R.equals(type)) {
							rList.add(question.getId());
						} else if(ExamConstant.QUESTION_TYPE_C.equals(type)) {
							cList.add(question.getId());
						} else if(ExamConstant.QUESTION_TYPE_T.equals(type)) {
							tList.add(question.getId());
						} else if(ExamConstant.QUESTION_TYPE_A.equals(type)) {
							aList.add(question.getId());
						} else if(ExamConstant.QUESTION_TYPE_B.equals(type)) {
							bList.add(question.getId());
						}
					}
					questions.addAll(questionList);
					if(null != examinationId && null != examNumber) {
						List<TestGroup> testGroupList = new ArrayList<TestGroup>();
						testGroup.setQuestionList(questionList);
						testGroupList.add(testGroup);
						this.saveExamineeQuestionAndAnswer(testGroupList, examination, everyQuestionScore, rule.getId());
					}
					
				}
				testGroup.setQuestionList(questions);
				testGroups.add(testGroup);
			}
		}
		
		if(null != examinationId && null != examNumber) {
			this.insertExaminetionHistory(examination);
		}
		// 将 题目顺序 与  答案顺序  随机显示
		if(null != examination) {
			for (TestGroup test : testGroups) {
				this.randomList(test.getQuestionList(), examination);
			}
		}
		return testGroups;
	}
	
	/**
	 * 添加答案选项 如：
	 * 111 改为 ：A 111
	 * 222 改为 ：B 222
	 * @param quesAnswerList
	 * @return
	 */
	protected List<QuestionAnswer> addAnswers(List<QuestionAnswer> quesAnswerList) {
		List<QuestionAnswer> newAnswerList = new ArrayList<QuestionAnswer>();
		for (int j = 0; j < quesAnswerList.size(); j++) {
			QuestionAnswer answer = quesAnswerList.get(j);
			char options = (char) (j + 65);
			answer.setItemContent(options + ExamConstant.COMM_NBSP + answer.getItemContent());
			newAnswerList.add(answer);
		}
		return newAnswerList;
	}
	
	/**
	 * 处理将随机后试卷中的题目与答案的顺序 存入考生表 与 考生答案选项表中
	 * 为考生查看试卷做准备
	 */
	public void insertQuestionAnswerSeq(List<Question> quesList, Examination exam) {
		// 保存考生 试题 与 答案
		//this.saveExamineeQuestionAndAnswer(quesList, exam, null);
		
		// 向考生考试记录表中新增一条数据
		this.insertExaminetionHistory(exam);
		return;
	}
	
	/**
	 * 处理  保存  考生试题与答案
	 * @param quesList
	 * @param exam
	 */
	protected void saveExamineeQuestionAndAnswer(List<TestGroup> testGroupList, Examination exam, Float everyQuestionScore, Long ruleId) {
		if(null == exam) {
			return;
		}
		Long userId = this.getUserId();
		Long examPaperId = exam.getAtyPaperId();
		Integer times = this.getMaxTimes(exam);
		times = times == null || times.intValue() == 0 ? 1 : times + 1;
		for (TestGroup testGroup : testGroupList) {
			List<Question> quesList = testGroup.getQuestionList();
			for(int i = 0; i < quesList.size(); i++) {
				String correctAnswers = "";
				int index = 0;
				ExamineeQuestion examineeQues = new ExamineeQuestion();
				Question ques = quesList.get(i);
				List<QuestionAnswer> quesAnswerList = ques.getQuestionAnswers();
				for (int j = 0; j < quesAnswerList.size(); j++) {
					QuestionAnswer answers = quesAnswerList.get(j);
					// 获取 单选题  与  判断题的正确答案
					if(ExamConstant.QUESTION_TYPE_R.equals(answers.getType()) || ExamConstant.QUESTION_TYPE_B.equals(answers.getType())) {
						if(null != answers.getCorrect() && answers.getCorrect()) {
							correctAnswers += answers.getId();
						}
					} else if(ExamConstant.QUESTION_TYPE_C.equals(answers.getType())) { // 获取多选题的正确答案
						if(null != answers.getCorrect() && answers.getCorrect()) {
							if(index == 0) {
								correctAnswers += answers.getId();
							} else 
							correctAnswers += "," + answers.getId();
							index ++;
						}
					}
				}
				// 将正确答案插入考生试题表中   如果是将题目随机  则记录题目顺序  为自动阅卷    与   考生查看试卷做准备
				examineeQues = new ExamineeQuestion();
				long questionId = ques.getId();
				examineeQues.setQuestionId(questionId);
				examineeQues.setExaminationId(exam.getId());
				examineeQues.setQuestionSeq((long) i);
				examineeQues.setUserId(userId);
				examineeQues.setExamPaperId(examPaperId);
				examineeQues.setTestGroupId(testGroup.getId());
				examineeQues.setStatus(ExamConstant.EXAM_QUES_STATUS_S);
				if(null == everyQuestionScore) {
					examineeQues.setScore(ques.getScore());
				} else {
					examineeQues.setScore(everyQuestionScore);
				}
				examineeQues.setDegree(ques.getDegree());
				examineeQues.setExamNumber(times);
				examineeQues.setCorrectAnswers(correctAnswers);
				examineeQues.setQuestionType(ques.getType());
				examineeQues.setRuleId(ruleId);
				examineeQuestionDAO.insert(examineeQues);
				// 将题目答案选项插入考生答案选项表中    记录答案选项的顺序   为考生查看试卷做准备
				for (int j = 0; j < quesAnswerList.size(); j++ ) {
					QuestionAnswer answer = quesAnswerList.get(j);
					ExamineeAnswer examineeAnswer = new ExamineeAnswer();
					examineeAnswer.setAnswerId(answer.getId());
					examineeAnswer.setQuestionId(questionId);
					examineeAnswer.setItemSeq((long) j);
					examineeAnswer.setExamineeQuestionId(examineeQues.getId());
					examineeAnswer.setContent(answer.getItemContent());
					examineeAnswerDAO.insert(examineeAnswer);
				}
			}
		}
	}
	
	
	/**
	 * 根据考试开始时间和考试时长，计算考试结束时间
	 * @param startDate
	 * @param atyTime
	 * @return Date
	 */
	protected Date getEndDate(Date startDate,Integer atyTime){
		if(startDate != null && atyTime >= 0){
			long startTimes = startDate.getTime();
			return new Date(startTimes + atyTime*60000);
		}
		return new Date();
	}
	
	/**
     * 处理在线考试 取出题目
     */
	public List<TestGroup> onLineGetQuestions(Examination exam) {
		long userId = this.getUserId();
		Long paperId = exam.getAtyPaperId();
		if(null == paperId) {
			return null;
		}
		ExamineesHistory history = this.getNotSubmitExamNumber(exam, true);
		ExamineeQuestion examineeQues = new ExamineeQuestion();
		examineeQues.setExamPaperId(exam.getAtyPaperId());
		examineeQues.setUserId(userId);
		examineeQues.setExaminationId(exam.getId());
		//判断是否已经随机生成了题目与 答案
		if(null != history) {
			if(history.getGenerated()) {
				return this.previewPaperOrExam(null, history);
			}
		}
		//判断是否考试次数已经用完
		Integer historyTimes = this.getMaxTimes(exam);
		if(null != historyTimes && 0 != historyTimes) {
			if((null == exam.getReexamTimes() || 0 == exam.getReexamTimes()) || exam.getReexamTimes().equals(historyTimes)) {
				return new ArrayList<TestGroup>();
			}
		}
		//如果还有考试机会  则重新读取题目
		exam.setTimes(historyTimes + 1);
		List<TestGroup> testGroupList = this.previewPaperOrExam(exam, null);
		return testGroupList;
	}
	
	/**
	 * 处理   在随机抽取试卷之后    插入一条历史记录
	 * @param exam
	 */
	public void insertExaminetionHistory(Examination exam) {
		if(null == exam) {
			return;
		}
		long paperId = exam.getAtyPaperId();
		long userId = this.getUserId();
		Integer times = this.getMaxTimes(exam);
		times = times == null || times.intValue() == 0 ? 1 : times+1;
		// 向考生考试记录表中新增一条数据
		ExamineesHistory examineesHistory = new ExamineesHistory();
		examineesHistory.setAtyPaperId(paperId);
		examineesHistory.setUserId(userId);
		examineesHistory.setExaminationId(exam.getId());
		examineesHistory.setGenerated(true);
		examineesHistory.setStatus(ExamConstant.EXAM_QUES_STATUS_S);
		examineesHistory.setTimes(times);
		examineesHistory.setAuswertungStatus("I");
		
		//开始时间  == 当前系统时间  ，  结束时间 == 开始时间 + 考试时长
		Date startDate = new Date();
		examineesHistory.setStartTime(startDate);
		examineesHistory.setEndTime(getEndDate(startDate,exam.getAtyTime()));
		
		examineesHistory.setAnswerTimeLength((double) exam.getAtyTime());
		examineesHistoryDAO.insert(examineesHistory);
	}
	
	/**
	 * 查询自动组卷时生成的试题
	 * @return
	 */
	public List<Question> findByAutoGeneratingQuestion(ExamineeQuestion examinee) {
		return questionDAO.findListByAutoGeneratingQuestion(examinee);
	}
	
	/**
	 * 处理  -- 考试倒计时
	 */
	public ExamineesHistory examCountdown(Examination examination, HttpSession session) {
		Long lastTime = (Long) session.getAttribute("lastUrlTime");
		CriteriaBuilder cb = Cnd.builder(ExamineesHistory.class);
		Integer times = examination.getTimes();
		cb.andGroup(Cnd.builder().andEQ("examinationId", examination.getId()).andEQ("userId", this.getUserId()));
		if(null == times || 0 == times) {
			cb.andEQ("status", ExamConstant.EXAM_QUES_STATUS_S);
		} else {
			cb.andEQ("times", times);
		}
		List<ExamineesHistory> examHistoryList = examineesHistoryDAO.findByCriteria(cb.buildCriteria());
		if(null == examHistoryList || 0 == examHistoryList.size()) {
			return null;
		}
		ExamineesHistory examHistory = examHistoryList.get(0);
		Examination exam = examHistory.getExamination();
		Integer surplusTime = examHistory.getSurplusTime();
		Integer surplus = null;
		if(null != lastTime) {
			Long nowTime = this.getNowTime();
			Integer time = (int) (nowTime - lastTime);
			if(null == surplusTime || 0 == surplusTime) {
				surplusTime = exam.getAtyTime() * 1000 * 60;
			}
			surplus = surplusTime - time;
			if(0 >= surplus) {
				examHistory.setSurplusTime(0);
				examineesHistoryDAO.update(examHistory);
				return null; 
			}
			examHistory.setSurplusTime(surplus);
			examineesHistoryDAO.update(examHistory);
			examHistory.setSurplusTime(surplus / (1000 * 60));
			return examHistory;
		} else if(null != surplusTime) {
			examHistory.setSurplusTime(surplusTime / (1000 * 60));
			return examHistory;
		}
		examHistory.setSurplusTime(exam.getAtyTime());
		return examHistory;
	}
	
	/**
     * 处理--如果已经生成了试卷 将不会再次生成   而是直接读取上一次生成试卷的题目与答案
     */
	public List<Question> findAlreadyGenneratedQuestion(ExamineeQuestion exam) {
		return examineeQuestionDAO.findAlreadyQuestion(exam);
	}
	
	/**
	 * 查找考试次数
	 */
	protected List<ExamineesHistory> getExamNumber(Examination exam, boolean falg) {
		CriteriaBuilder cb = Cnd.builder(ExamineesHistory.class);
		CriteriaBuilder cb2 = Cnd.builder();
		Integer times = exam.getTimes();
		if(0 == times) {
			times = 1;
		}
		cb2.andEQ("atyPaperId", exam.getAtyPaperId()).andEQ("userId", this.getUserId()).andEQ("examinationId", exam.getId()).andEQ("times", times);
		if(falg) {
			cb2.andEQ("status", ExamConstant.EXAM_QUES_STATUS_S);
		} else {
			cb2.andNotEQ("status", ExamConstant.EXAM_QUES_STATUS_S);
		}
		cb.andGroup(cb2);
		List<ExamineesHistory> historyList = examineesHistoryDAO.findByCriteria(cb.buildCriteria());
		return historyList;
	}
	
	/**
	 * 查找还未交卷的考试历史记录
	 */
	public ExamineesHistory getNotSubmitExamNumber(Examination exam, boolean falg) {
		CriteriaBuilder cb = Cnd.builder(ExamineesHistory.class);
		CriteriaBuilder cb2 = Cnd.builder();
		cb2.andEQ("atyPaperId", exam.getAtyPaperId()).andEQ("userId", this.getUserId()).andEQ("examinationId", exam.getId());
		cb2.andEQ("status", ExamConstant.EXAM_QUES_STATUS_S);
		cb.andGroup(cb2);
		List<ExamineesHistory> historyList = examineesHistoryDAO.findByCriteria(cb.buildCriteria());
		return ListUtils.isEmpty(historyList)?null:historyList.get(0);
	}
	
	/**
	 * 得到考生历史记录的考试最大次数
	 * @return Integer
	 */
	public Integer getMaxTimes(Examination exam) {
		ExamineesHistory examHistory = new ExamineesHistory();
		examHistory.setAtyPaperId(exam.getAtyPaperId());
		examHistory.setUserId(this.getUserId());
		examHistory.setExaminationId(exam.getId());
		return examineesHistoryDAO.findMaxByTimes(examHistory);
	}
	
	
	
	// 处理 得到userId
	protected long getUserId() {
		UserAccount userAccount = (UserAccount)SecurityUtils.getCurrentUser();
		return userAccount.getId();
	}
	
	/**
	 * 得到系统时间
	 * @return
	 */
	protected Long getNowTime() {
		return new Date().getTime();
	}

	/**
	 * 处理   交卷
	 */
	public ExamineesHistory carryPaper(ExamineesHistory examHistory) {
		Examination examination = new Examination();
		examination.setId(examHistory.getExaminationId());
		examination.setAtyPaperId(examHistory.getAtyPaperId());
		ExamineesHistory examineesHistory = this.getNotSubmitExamNumber(examination, true);
		//计算总分数
		this.calculateFraction(examineesHistory);
		return examineesHistory;
	}
	
	/**
	 * 创建公用sql查询
	 * @param examHistory
	 * @return
	 */
	private CriteriaBuilder createCriteria(ExamineesHistory examHistory) {
		Long userId = this.getUserId();
		CriteriaBuilder criteria = Cnd.builder(ExamineeQuestion.class);
		criteria.andEQ("examPaperId", examHistory.getAtyPaperId()).andEQ("userId", userId)
		.andEQ("examNumber", examHistory.getTimes()).andEQ("examinationId", examHistory.getExaminationId());
		return criteria;
	}
	
	/**
	 * 计算分数
	 */
	protected Float calculateFraction(ExamineesHistory examHistory) {
		
		// 设置需要自动阅卷的试题类型
		List<String> autoTypeList = new ArrayList<String>();
		autoTypeList.add(ExamConstant.QUESTION_TYPE_R);
		autoTypeList.add(ExamConstant.QUESTION_TYPE_C);
		autoTypeList.add(ExamConstant.QUESTION_TYPE_B);
		// 设置不需要自动阅卷的试题类型
		List<String> noAutoTypeList = new ArrayList<String>();
		noAutoTypeList.add(ExamConstant.QUESTION_TYPE_T);
		noAutoTypeList.add(ExamConstant.QUESTION_TYPE_A);
		CriteriaBuilder autoCriteria = this.createCriteria(examHistory);
		autoCriteria.andGroup(Cnd.builder().andIn("questionType", autoTypeList));
		List<ExamineeQuestion> autoExamList = examineeQuestionDAO.findByCriteria(autoCriteria.buildCriteria());
		Float totalScore = 0f;
		try {
			List<Long> autoIdList = new ArrayList<Long>();
			for (ExamineeQuestion examineeQuestion : autoExamList) {
				String correctAnswers = examineeQuestion.getCorrectAnswers();
				if(null != correctAnswers && correctAnswers.equals(examineeQuestion.getExamineeAnswer())) {
					totalScore += examineeQuestion.getScore();
				}
				autoIdList.add(examineeQuestion.getId());
			}
			
			// 更新自动阅卷的考生试题
			 Examination examination = examHistory.getExamination();
			 String markingCheck = examination.getMarkingCheck();
			 
			 ExamineeQuestion examQuestion = new ExamineeQuestion();
			 
			 CriteriaBuilder cb = this.createCriteria(examHistory);
			 if(ListUtils.isNotEmpty(autoIdList)) {
				 cb.andGroup(Cnd.builder().andIn("id", autoIdList));
			 }
			 
			 CriteriaBuilder criteria = this.createCriteria(examHistory);
			 if(ListUtils.isNotEmpty(autoIdList)) {
				 criteria.andGroup(Cnd.builder().andNotIn("id", autoIdList));
			 }
			 
			 
			 examQuestion.setStatus(ExamConstant.EXAM_QUES_STATUS_E);
			 //查询需要人工阅卷的试题数量
			 int countQuestion = examineeQuestionDAO.countByCriteria(criteria.buildCriteria());
			 if(countQuestion == 0) {
				//如果没有人工阅卷的试题  则直接将试题状态改为“P”
				 examQuestion.setStatus(ExamConstant.EXAM_QUES_STATUS_P);
				 examineeQuestionDAO.updateByCriteria(examQuestion, cb.buildCriteria());
				 //更新考生历史记录
				 examHistory.setScore(totalScore);
				 examHistory.setTotalscore(totalScore);
				 examHistory.setStatus(ExamConstant.EXAM_QUES_STATUS_P);
				this.updateExamHistory(examHistory);
			 } else {
				//将需要手动阅卷的试题状态改为E(考试结束完)
				 examineeQuestionDAO.updateByCriteria(examQuestion, criteria.buildCriteria());
				 
				//如果有自动阅卷的试题   将自动阅卷的试题状态改为R或P(判断是否需要审核，如果需要审核状态为P,否则为R)
				 if(ListUtils.isNotEmpty(autoIdList)) {
					 if("N".equals(markingCheck)) {
						 examQuestion.setStatus(ExamConstant.EXAM_QUES_STATUS_R);
						 examineeQuestionDAO.updateByCriteria(examQuestion, cb.buildCriteria());
					 } else if("Y".equals(markingCheck)) {
						 examQuestion.setStatus(ExamConstant.EXAM_QUES_STATUS_P);
						 examineeQuestionDAO.updateByCriteria(examQuestion, cb.buildCriteria());
					 }
				 }
				 
				 /**
				 * 判断  如果该测试区中全部都是 自动阅卷  并且不需要审核   则  直接更新考生历史记录的状态为  "D"（审核完成状态）
				 * 如果需要审核	则  直接更新考生历史记录的状态为  "R"（阅卷完成状态）examHistory
				 */
				// 查询 考生试题  状态为  E 的试题
				CriteriaBuilder cb_E = this.createCriteria(examHistory);
				cb_E.andGroup(Cnd.builder().andEQ("status", "E"));
				List<ExamineeQuestion> exam_E = examineeQuestionDAO.findByCriteria(cb_E.buildCriteria());
				// 查询 考生试题  状态为  R 的试题
				CriteriaBuilder cb_R = this.createCriteria(examHistory);
				cb_R.andGroup(Cnd.builder().andEQ("status", "R"));
				List<ExamineeQuestion> exam_R = examineeQuestionDAO.findByCriteria(cb_R.buildCriteria());
				examHistory.setScore(totalScore);
				if(ListUtils.isEmpty(exam_E)) {
					if(ListUtils.isEmpty(exam_R)) {
						examHistory.setStatus(ExamConstant.EXAM_QUES_STATUS_P);
						this.updateExamHistory(examHistory);
					} else {
						examHistory.setStatus(ExamConstant.EXAM_QUES_STATUS_R);
						this.updateExamHistory(examHistory);
					}
				} else {
					examHistory.setStatus(ExamConstant.EXAM_QUES_STATUS_E);
					this.updateExamHistory(examHistory);
				}
			 }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return totalScore;
	}
	
	/**
	 * 处理考生历史记录
	 * 当交卷之后  考生历史记录中的 状态也应该变更为 --- E：考试结束
	 * @return
	 */
	protected Integer updateExamHistory(ExamineesHistory examHistory) {
		examHistory.setEndTime(new Date());
		return examineesHistoryDAO.update(examHistory); // 更新成功之后   返回考试次数
	}
	
	/**
	 * 处理 考生试题答案
	 */
	public int updateExamineeQuestion(ExamineeQuestion exam) {
		Examination examination = new Examination();
		examination.setId(exam.getExaminationId());
		examination.setAtyPaperId(exam.getExamPaperId());
		ExamineesHistory history = this.getNotSubmitExamNumber(examination, true);
		Integer examNumber = history.getTimes();
		exam.setExamNumber(examNumber);
		CriteriaBuilder cb = Cnd.builder(ExamineeQuestion.class);
		cb.andGroup(Cnd.builder().andEQ("questionId", exam.getQuestionId()).andEQ("userId", this.getUserId()).andEQ("examNumber", examNumber).andEQ("examPaperId", exam.getExamPaperId()).andEQ("examinationId", exam.getExaminationId()).andEQ("status", ExamConstant.EXAM_QUES_STATUS_S).andEQ("recordStatus", "A"));
		return examineeQuestionDAO.updateByCriteria(exam, cb.buildCriteria());
	}

	/**
	 * 处理标记复查
	 */
	public boolean examineeQuestionReviewed(ExamineeQuestion examineeQuestion) {
		examineeQuestionDAO.update(examineeQuestion);
		return examineeQuestion.getReviewed();
	}

	/**
	 * 异步处理答题情况 -- 查询出当前考生的所有试题
	 */
	public List<ExamineeQuestion> findExamQuestion(ExamineesHistory examHistory) {
		return findExamQuestion(examHistory, false);
	}
	
	public List<ExamineeQuestion> findExamQuestion(ExamineesHistory examHistory, boolean isAdmin) {
		CriteriaBuilder cb = Cnd.builder(ExamineeQuestion.class);
		if(isAdmin) {
			cb.andGroup(Cnd.builder().andEQ("examPaperId", examHistory.getAtyPaperId()).andEQ("examNumber", examHistory.getTimes())
					.andEQ("examinationId", examHistory.getExaminationId()).andEQ("userId", examHistory.getUserId())).orderBy("questionSeq", Order.ASC);
		} else {
			cb.andGroup(Cnd.builder().andEQ("examPaperId", examHistory.getAtyPaperId()).andEQ("examNumber", examHistory.getTimes())
					.andEQ("examinationId", examHistory.getExaminationId()).andEQ("userId", this.getUserId())).orderBy("questionSeq", Order.ASC);
		}
		return examineeQuestionDAO.findByCriteria(cb.buildCriteria());
	}

	/**
	 * 查询试卷下面的所有试题
	 * @return
	 */
	public List<ExamineeQuestion> findPaperAllQuestion(ExamineeQuestion examQuestion) {
		return examineeQuestionDAO.paperQuestion(examQuestion);
	}

	public Integer updateExamQuestion(ExamineeQuestion examQuestion) {
		return updateExamQuestion(examQuestion, false);
	}
	
	public Integer updateExamQuestion(ExamineeQuestion examQuestion, boolean isAdmin) {
//		if(StringUtils.equals(examQuestion.getStatus(), "R")){//阅卷
//			String score = NumberUtils.toFloat(examQuestion.getViewScore() + "", 0f) + "";
//			examQuestion.setViewScore(NumberUtils.createBigDecimal(score));
//			examQuestion.setViewPerson(getUserId());
//		}else if(StringUtils.equals(examQuestion.getStatus(), "P")){//审核
//			String score = NumberUtils.toFloat(examQuestion.getApproveScore() + "", 0f) + "";
//			examQuestion.setApproveScore(NumberUtils.createBigDecimal(score));
//			examQuestion.setApprovePerson(getUserId());
//		}
		
		CriteriaBuilder cb = Cnd.builder(ExamineeQuestion.class).andEQ("questionId", examQuestion.getQuestionId())
		.andEQ("examNumber", examQuestion.getExamNumber()).andEQ("userId", examQuestion.getUserId())
		.andEQ("examPaperId", examQuestion.getExamPaperId());
		if(!isAdmin) // 管理员从后台处理时,不需要id条件
			cb.andEQ("id", examQuestion.getId());
		return examineeQuestionDAO.updateByCriteria(examQuestion, cb.buildCriteria());
	}
	
	/**
	 * 获取考生试题
	 * @param examineesHistory
	 * @return List<ExamineeQuestion>
	 */
//	public List<ExamineeQuestion> findExamQuestion(ExamineesHistory examineesHistory){
//		return examineeQuestionDAO.findExamQuestion(examineesHistory);
//	}
	
	/**
	 * 获取某次考试记录可以阅卷的题数
	 * @param examineesHistory 考试记录Id
	 * @return List<ExamineeQuestion>
	 */
	public Integer findExamAuswertungQuestionCount(ExamineesHistory examineesHistory){
		return examineeQuestionDAO.findExamAuswertungQuestionCount(examineesHistory);
	}
	
	/**
	 * 获取当前考试活动某次记录的试卷信息
	 * @param paperId 试卷Id
	 * @param userId 用户Id
	 * @param examNumber 考试次数
	 * @return List<ExamineeQuestion>
	 */
	public List<Question> findExamActivityQuestion(ExamineesHistory examHistory){
		return examineeQuestionDAO.findExamActivityQuestion(examHistory);
	}
	
	/**
	 * 获取学员的考生试题
	 */
	public List<ExamineeQuestion> findExamQuestionByUser(Map<String,Object> map){
		return examineeQuestionDAO.findExamQuestionByUser(map);
	}
	
	/**
	 * 修改试题的阅卷信息
	 * @param map
	 */
	public void updateExamQuestionAuswertungInfo(Map<String,Object> map){
		examineeQuestionDAO.updateExamQuestionAuswertungInfo(map);
	}
	
	/**
	 * 获取当前考试记录填写了答案的试题的数据，判断阅卷是否完成
	 * @param map
	 * @return List<ExamineeQuestion>
	 */
	public List<ExamineeQuestion> findExamAuswertungStatus(Map<String,Object> map){
		return examineeQuestionDAO.findExamAuswertungStatus(map);
	}
	
	/**
	 * 计算每个学员本次考试的总成绩
	 * @param map
	 * @return Map<Long,Long>
	 */ 
	public Map<Long,Long> calculateTotalScore(Map<String,Object> map){
		return examineeQuestionDAO.calculateTotalScore(map);
	}
	
	/**
	 * 修改考生试题表的状态
	 * @param map
	 */
	public void updateExamQuestionStatus(Map<String,Object> map){
		examineeQuestionDAO.updateExamQuestionStatus(map);
	}
	
	/**
	 * 获取可阅卷的考试记录
	 * @return PagingResult<ExaminationManage>
	 */
	public PagingResult<ExaminationManage> findExamManageByCriteria(String type){
		boolean bool = StringUtils.equals(ExamConstant.HISTORY_STATUS_A,type) ? true : false;
		CriteriaBuilder cb = Cnd.builder(ExamineeQuestion.class)
		.addParam("userId", getUserId())
		.addParam("status", bool ? "E" : "R")
		.addParam("workType", bool ? "M" : "A")
		.addParam("recordStatus", bool ? "A" : "D");
		return examineeQuestionDAO.findExamManageByCriteria(cb.buildCriteria());
	}
	
	/**
	 * 获取阅卷的试题
	 * @return PagingResult<ExamineeQuestion>
	 */
	public PagingResult<ExamineeQuestion> findNeedMarkingQuestionByCriteria(String type,Long examinationId,long number){
		boolean bool = StringUtils.equals(ExamConstant.HISTORY_STATUS_A,type) ? true : false;
		CriteriaBuilder cb = Cnd.builder(ExamineeQuestion.class)
		.addParam("userId", getUserId())
		.addParam("examinationId", examinationId)
		.addParam("status", bool ? "E" : "R")
		.addParam("recordStatus", bool ? "A" : "D");
		Criteria criteria = cb.buildCriteria().limit(0L,number+1);
		return examineeQuestionDAO.findNeedMarkingQuestionByCriteria(criteria);
	}

	public void systemCarryPaper() {
		Date now = new Date();
		List<ExamineesHistory> list = examineesHistoryDAO.findExaminatingAndTimeout(now);
		if (ListUtils.isNotEmpty(list)) {
			examineesHistoryDAO.updateStatusByExamination(list, now);
		}
	}
	
	/**
	 * 获取阅卷测试区题目
	 * @param map
	 * @return List<ExamineeQuestion>
	 */
	public List<Question> findAuswertungQuestion(Map<String,Object> map){
		return examineeQuestionDAO.findAuswertungQuestion(map);
	}
	
	/**
	 * 根据输入题数，获取考生试题答案
	 * @param map
	 * @return List<ExamineeQuestion>
	 */
	public List<ExamineeQuestion> auswertungQuestion(Map<String,Object> map){
		return examineeQuestionDAO.auswertungQuestion(map);
	}
	
	/**
	 * 根据试题Id修改试题状态(阅卷中)
	 * @param map
	 */
	public void updateStatus(Map<String,Object> map){
		examineeQuestionDAO.updateStatus(map);
	}
	
	/**
	 * 将锁定状态的阅卷中，审核中的试题改为阅卷完，审核完
	 * @param map
	 */
	public void updateLockedStatus(Map<String,Object> map){
		examineeQuestionDAO.updateLockedStatus(map);
	}
	
	/**
	 * 解锁，将阅卷中，审核中状态改为未阅卷，未审核
	 * @param examQuesIds
	 */
	public void decontrolStatus(Map<String,Object> map){
		examineeQuestionDAO.decontrolStatus(map);
	}

	public void updateNewScore(Map<String, Object> map) {
		examineeQuestionDAO.updateNewScore(map);
	}
	
	/**
	 * 管理员查阅试卷，重新给分，获取重新给分的试题信息
	 * @param map
	 * @return ExamineeQuestion
	 */
	public ExamineeQuestion getExamQuestionByGiveScore(Map<String,Object> map){
		return examineeQuestionDAO.getExamQuestionByGiveScore(map);
	}
	
	/**
	 * 根据多个Id获取ExamineeQuestion
	 * @param list
	 * @return List<ExamineeQuestion>
	 */
	public List<ExamineeQuestion> getExamQuestionByIds(List<Long> list){
		return examineeQuestionDAO.getExamQuestionByIds(list);
	}
}