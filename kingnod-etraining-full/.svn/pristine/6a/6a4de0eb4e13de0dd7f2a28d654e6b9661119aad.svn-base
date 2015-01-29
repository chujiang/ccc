package com.kingnod.etraining.exam.service;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.activity.entity.Examination;
import com.kingnod.etraining.activity.entity.ExamineesHistory;
import com.kingnod.etraining.exam.entity.ExaminationManage;
import com.kingnod.etraining.exam.entity.ExamineeQuestion;
import com.kingnod.etraining.exam.entity.Question;
import com.kingnod.etraining.exam.entity.TestGroup;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

@com.kingnod.core.annotation.Generated("2012-04-06 22:38")
public interface ExamineeQuestionService {
	
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
	List<TestGroup> previewPaperOrExam(Examination examination, ExamineesHistory history);
	
	/**
	 * 处理 -- 交卷
	 * 
	 * @return
	 */
	ExamineesHistory carryPaper(ExamineesHistory examHistory);
	
	/**
	 * 系统交卷，检测考试超时或者特殊原因没有交卷的试卷，让其执行交卷操作
	 */
	void systemCarryPaper();

	/**
	 * 处理 -- 考试倒计时
	 */
	ExamineesHistory examCountdown(Examination examination, HttpSession session);

	/**
	 * 处理将随机后试卷中的题目与答案的顺序 存入考生表 与 考生答案选项表中 为考生查看试卷做准备
	 */
	void insertQuestionAnswerSeq(List<Question> quesList, Examination exam);

	/**
	 * 处理 -- 试题显示次序：F，固定显示 R，随机显示 答案选项显示次序： F，固定显示 R，随机显示
	 */
	List<Question> randomList(List<Question> questionList, Examination examination);

	/**
	 * 处理在线考试 取出题目
	 */
	List<TestGroup> onLineGetQuestions(Examination examination);

	/**
	 * 更新考生试题答案
	 * 
	 * @param examineeQuestion
	 * @return
	 */
	int updateExamineeQuestion(ExamineeQuestion examineeQuestion);

	/**
	 * 处理 标记复查
	 * 
	 * @param examineeQuestion
	 * @return
	 */
	boolean examineeQuestionReviewed(ExamineeQuestion examineeQuestion);

	/**
	 * 得到考生历史记录的考试最大次数
	 * 
	 * @return
	 */
	Integer getMaxTimes(Examination exam);

	/**
	 * 异步处理答题情况 -- 查询出当前考生的所有试题
	 * 
	 * @return
	 */
	List<ExamineeQuestion> findExamQuestion(ExamineesHistory examHistory);
	List<ExamineeQuestion> findExamQuestion(ExamineesHistory examHistory, boolean isAdmin);

	@com.kingnod.core.annotation.Generated("2012-04-06 22:38")
	ExamineeQuestion getExamineeQuestion(Long id);

	@com.kingnod.core.annotation.Generated("2012-04-06 22:38")
	int saveExamineeQuestion(ExamineeQuestion examineeQuestion);

	@com.kingnod.core.annotation.Generated("2012-04-06 22:38")
	int deleteExamineeQuestion(ExamineeQuestion examineeQuestion);

	@com.kingnod.core.annotation.Generated("2012-04-06 22:38")
	int deleteExamineeQuestionByIds(Long[] ids);

	@com.kingnod.core.annotation.Generated("2012-04-06 22:38")
	PagingResult<ExamineeQuestion> findExamineeQuestion(Criteria criteria);

	/**
	 * 查询试卷下面的所有试题
	 * 
	 * @return
	 */
	List<ExamineeQuestion> findPaperAllQuestion(ExamineeQuestion examQuestion);

	/**
	 * 更新考生阅卷信息
	 * 
	 * @param examineeQuestion
	 * @return
	 */
	Integer updateExamQuestion(ExamineeQuestion examQuestion);
	
	Integer updateExamQuestion(ExamineeQuestion examQuestion, boolean isAdmin);
	
	/**
	 * 获取当前考试活动某次记录的试卷信息
	 * @param paperId 试卷Id
	 * @param userId 用户Id
	 * @param examNumber 考试次数
	 * @return List<ExamineeQuestion>
	 */
	List<Question> findExamActivityQuestion(ExamineesHistory examHistory);
	
	/**
	 * 获取某次考试记录可以阅卷的题数
	 * @param examineesHistory 考试记录Id
	 * @return List<ExamineeQuestion>
	 */
	Integer findExamAuswertungQuestionCount(ExamineesHistory examineesHistory);
	
	/**
	 * 获取学员的考生试题
	 */
	List<ExamineeQuestion> findExamQuestionByUser(Map<String,Object> map);
	
	/**
	 * 修改试题的阅卷信息
	 * @param map
	 */
	void updateExamQuestionAuswertungInfo(Map<String,Object> map);
	
	/**
	 * 获取当前考试记录填写了答案的试题的数据，判断阅卷是否完成
	 * @param map
	 * @return List<ExamineeQuestion>
	 */
	List<ExamineeQuestion> findExamAuswertungStatus(Map<String,Object> map);
	
	/**
	 * 计算每个学员本次考试的总成绩
	 * @param map
	 * @return Map<Long,Long>
	 */ 
	Map<Long,Long> calculateTotalScore(Map<String,Object> map);
	
	/**
	 * 修改考生试题表的状态
	 * @param map
	 */
	void updateExamQuestionStatus(Map<String,Object> map);
	
	/**
	 * 查找还未交卷的考试历史记录
	 */
	ExamineesHistory getNotSubmitExamNumber(Examination exam, boolean falg);
	
	/**
	 * 获取可阅卷的考试记录
	 * @return PagingResult<ExaminationManage>
	 */
	PagingResult<ExaminationManage> findExamManageByCriteria(String type);
	
	/**
	 * 获取阅卷的试题
	 * @return PagingResult<ExamineeQuestion>
	 */
	PagingResult<ExamineeQuestion> findNeedMarkingQuestionByCriteria(String type,Long examinationId,long number);
	
	/**
	 * 计算某一次考试活动中 有多少个考生的试题被阅卷之后   并计算出来  insert到考生记录表中
	 * @param examination
	 */
	public boolean calculateTotal(Examination examination);
	
	/**
	 * 获取阅卷测试区题目
	 * @param map
	 * @return List<ExamineeQuestion>
	 */
	List<Question> findAuswertungQuestion(Map<String,Object> map);
	
	/**
	 * 根据输入题数，获取考生试题答案
	 * @param map
	 * @return List<ExamineeQuestion>
	 */
	List<ExamineeQuestion> auswertungQuestion(Map<String,Object> map);
	
	/**
	 * 根据试题Id修改试题状态(阅卷中)
	 * @param examQuesIds
	 */
	void updateStatus(Map<String,Object> map);
	
	/**
	 * 将锁定状态的阅卷中，审核中试题该为阅卷完，审核完
	 * @param examQuesIds
	 */
	void updateLockedStatus(Map<String,Object> map);
	
	/**
	 * 解锁，将阅卷中，审核中状态改为未阅卷，未审核
	 * @param examQuesIds
	 */
	void decontrolStatus(Map<String,Object> map);
	
	/**
	 * 修改试题分数
	 * @param map
	 */
	void updateNewScore(Map<String,Object> map);
	
	/**
	 * 管理员查阅试卷，重新给分，获取重新给分的试题信息
	 * @param map
	 * @return ExamineeQuestion
	 */
	ExamineeQuestion getExamQuestionByGiveScore(Map<String,Object> map);
	
	/**
	 * 根据多个Id获取ExamineeQuestion
	 * @param list
	 * @return List<ExamineeQuestion>
	 */
	List<ExamineeQuestion> getExamQuestionByIds(List<Long> list);
}