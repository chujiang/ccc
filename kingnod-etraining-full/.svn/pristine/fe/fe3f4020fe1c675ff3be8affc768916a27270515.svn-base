package com.kingnod.etraining.activity.service;

import java.sql.Time;
import java.util.List;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.activity.entity.Examination;
import com.kingnod.etraining.activity.entity.ExamineesHistory;

@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
public interface ExaminationService {
	/**
	 * 根据userId 查找学员可以参加的考试
	 * 
	 * @param paperId
	 * @return
	 */
	List<Examination> findUserByExaminationInfo();

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	Examination getExamination(Long id);

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	int saveExamination(Examination examination);

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	int deleteExamination(Examination examination);

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	int deleteExaminationByIds(Long[] ids);

	@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
	PagingResult<Examination> findExamination(Criteria criteria);

	/**
	 * 根据Id获取考试活动
	 * @param id
	 * @return Examination
	 */
	Examination getExaminationById(Long id);
	
	/**
	 * 发布考试
	 * @param examination	考试对象
	 * @param isPublished	 考试是否已发布
	 * @return
	 */
	int publish(Examination examination, boolean isPublished);

	/**
	 * 查询文件夹名称
	 */
	String findFolderNameByFolderId(Long folderId);
	
	/**
	 * 判断考试次数
	 * @param exam
	 * @return boolean
	 */
	boolean getExaminationRestraintNumber(Examination exam);
	
	/**
	 * 判断到达了迟到时间
	 * @param time
	 * @param advanceTime
	 * @return boolean
	 */
	boolean getAdvanceTime(Time time ,Long advanceTime);
	
	/**
	 * 判断当前系统时间能不能交卷
	 * @param examId
	 * @return
	 */
	boolean advancePutExam(Examination exam);
	
	/**
	 * 考试活动是否已经结束,已经结束返回true,没有结束返回false
	 * @return boolean
	 */
	boolean ifExamActivityEnd(Examination examination);
	
	/**
	 * 获取可以参加的考试活动
	 * @return List<Examination> 
	 */
	PagingResult<Examination> getCanExamRecord();
	
	/**
	 * 获取已经结束的考试活动记录
	 * @return List<Examination>
	 */
	PagingResult<Examination> getAlreadyExamRecord();
	
	/**
	 * 根据名称查询考试活动
	 * @param examName
	 * @return List<Examination>
	 */
	List<Examination> findExamByName(String examName,String examType);
	
	/**
	 * 获取当前考试活动的已考次数
	 * @param exam
	 * @return Integer
	 */
	Integer getTimes(Examination exam);
	
	/**
	 * 判断当前系统时间是否在两次考试的间隔时间之外，如果是return true, 否则返回false
	 * @return boolean
	 */
	boolean estimateReexamTimeInterval(Examination examId);
	
	/**
	 * 获取当前考试活动最后一次的考试记录
	 * @param exam
	 * @return Examination
	 */
	ExamineesHistory getLastExam(Examination exam);
	
	/**
	 * 获取已经填写了答案的题目数量
	 * @param exam
	 * @return Integer
	 */
	Integer findExamAnswerQuestionCount(Examination exam);
	
	/**
	 * 根据userId查询已完成考试
	 * @return
	 */
	PagingResult<Examination> findAlreadyExamByUserId(Criteria criteria);
	
	/**
	 * 获取最后一次考试记录
	 * @param examHistory
	 * @return Integer
	 */
	Integer findLastByTimes(ExamineesHistory examHistory);
	
	/**
	 * 获取已考次数，状态不为'考试中'(S)
	 * @param exam
	 * @return Integer
	 */
	Integer findMaxByTimes(Examination exam);
	
	/**
	 * 获取可以阅卷的考试活动
	 * @param map
	 * @return Examination
	 */
	PagingResult<Examination> findAuswertungExamination();
	
	PagingResult<Examination> findExaminationByPageId(Long paperId);
}