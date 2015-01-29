package com.kingnod.etraining.exam.dao;

import java.util.List;
import java.util.Map;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.dao.EntityDAO;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.activity.entity.ExamineesHistory;
import com.kingnod.etraining.exam.entity.ExaminationManage;
import com.kingnod.etraining.exam.entity.ExamineeQuestion;
import com.kingnod.etraining.exam.entity.Question;
import com.kingnod.etraining.exam.entity.QuestionAnswer;

@com.kingnod.core.annotation.Generated("2012-04-06 22:38")
public interface ExamineeQuestionDAO extends EntityDAO<ExamineeQuestion, Long> {
	/**
	 * 取出试题
	 * 
	 * @param criteria
	 * @return
	 */
	//List<Question> findExamineeQuestionList(ExamineeQuestion examineeQuestion);

	List<QuestionAnswer> findExamineeAnswerList(long id);

//	/**
//	 * 根据测试区的题目类型 -- 取出该类型的总分数
//	 * 
//	 * @param criteria
//	 * @return
//	 */
//	Float getTotalFraction(ExamineesHistory examHistory);

	/**
	 * 查询试卷下面的所有试题
	 * 
	 * @return
	 */
	List<ExamineeQuestion> paperQuestion(ExamineeQuestion examQuestion);

	/**
	 * 获取考生试题
	 * @param examineesHistory
	 * @return List<ExamineeQuestion>
	 */
	List<ExamineeQuestion> findExamQuestion(ExamineesHistory examineesHistory);
	
	/**
	 * 获取当前考试活动某次记录的试卷信息
	 * @param paperId 试卷Id
	 * @param userId 用户Id
	 * @param examNumber 考试次数
	 * @return List<ExamineeQuestion>
	 */
	List<Question> findExamActivityQuestion(ExamineesHistory examHistory);
	
	/**
	 * 获取某次考试活动某次记录填写了答案的题目数量
	 * @param examineesHistory 考试记录Id
	 * @return List<ExamineeQuestion>
	 */
	Integer findExamAnswerQuestionCount(ExamineesHistory examineesHistory);
	
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
	 * 查询可阅卷考试或可审核考试
	 * criteria.addParam("userId", xx);指定可阅卷人ID
	 * @param criteria
	 * @return
	 */
	PagingResult<ExaminationManage> findExamManageByCriteria(Criteria criteria);
	
	/**
	 * 可阅卷人查询需要阅卷的试题
	 * criteria.addParam("exminationId", xx)
	 * @param criteria
	 * @return PagingResult<ExamineeQuestion>
	 */
	PagingResult<ExamineeQuestion> findNeedMarkingQuestionByCriteria(Criteria criteria);
	
	/**
	 * 查询可审核的记录
	 * 
	 * @param criteria
	 * @return PagingResult<ExamineeQuestion>
	 */
	PagingResult<ExamineeQuestion> findNeedMarkingAuditingQuestionByCriteria(Criteria criteria);

	/**
	 * 计算阅卷完成的总分数
	 * @param history
	 * @return
	 */
	Integer calculateAuswertungScore(ExamineesHistory history);

	/**
	 * 获取自动组卷中  可以自动阅卷的题目
	 * @param examHistory
	 * @return
	 */
	List<ExamineeQuestion> findListByAutoGenneratingPaper(ExamineesHistory examHistory);

	/**
	 * 查询已经生成的试题
	 * @param exam
	 * @return
	 */
	List<Question> findAlreadyQuestion(ExamineeQuestion exam);
	
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
	 * 将锁定状态的阅卷中，审核中的试题改为阅卷完，审核完
	 * @param map
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
	public void updateNewScore(Map<String,Object> map);
	
	/**
	 * 管理员查阅试卷，重新给分，获取重新给分的试题信息
	 * @param map
	 * @return ExamineeQuestion
	 */
	public ExamineeQuestion getExamQuestionByGiveScore(Map<String,Object> map);
	
	/**
	 * 根据多个Id获取ExamineeQuestion
	 * @param list
	 * @return List<ExamineeQuestion>
	 */
	List<ExamineeQuestion> getExamQuestionByIds(List<Long> list);
}