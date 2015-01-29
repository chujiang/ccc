package com.kingnod.etraining.activity.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.dao.EntityDAO;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.activity.entity.ExamineesHistory;

@com.kingnod.core.annotation.Generated("2012-03-16 19:59")
public interface ExamineesHistoryDAO extends EntityDAO<ExamineesHistory, Long> {
	/**
	 * 得到考生历史记录的考试最大次数
	 * 
	 * @return
	 */
	Integer findMaxByTimes(ExamineesHistory examHistory);

	/**
	 * 根据examinationId获取历史记录
	 * 
	 * @param examinationId
	 * @return
	 */
	ExamineesHistory findListByExaminationId(ExamineesHistory examHistory);

	/**
     * 查询所有可以阅卷的考试列表
     * @return
     */
	List<ExamineesHistory> readExam();
	
	/**
	 * 获取考试活动的最后一次考试的记录
	 * @param examHistory
	 * @return ExamineesHistory
	 */
	ExamineesHistory findMaxExaminationExamSurplusNumber(ExamineesHistory examHistory);
	
	/**
	 * 查询当前考试活动的所有历史考试记录
	 * @return List<ExamineesHistory>
	 */
	List<ExamineesHistory> findExamDetail(ExamineesHistory examHistory);
	
	
	/**
	 * 查询当前考试活动的所有历史考试记录分页 @author maxudong
	 * @return List<ExamineesHistory>
	 */
	public PagingResult<ExamineesHistory> findExamDetailPage(Criteria criteria);
	
	/**
	 * 获取考试限制的数据集
	 * @param map
	 * @return Long
	 */
	Long findAtyRestraintCount(Map<String,Object> map);
	
	/**
     * 根据计分方式，获取考试得分
     * @return Long
     */
	Double findExamAVGScore(Map<String,Object> map,String type);
	
	/**
	 * 查询当前考试活动下的所有学员的考试详情
	 * @return List<ExamineesHistory>
	 */
	PagingResult<ExamineesHistory> findExamDetails(Criteria criteria);
	

	/**
     * 获取本次考试参加的人数
     * @return Long
     */
	Long findExamHistoryUserCount(ExamineesHistory examHistory);
	
	/**
     * 获取可以阅卷的考试记录
     * @return List<ExamineesHistory>
     */
	List<ExamineesHistory> findCanAuswertungHistory(String status);
	
	/**
	 *  修改考试记录表的阅卷状态
	 * @param list
	 */
	void updateExamHistoryAuswertungStatus(Map<String,Object> map);
	
	/**
	 * 根据阅卷员指定的阅卷数量，抽取考试记录
	 * @param map
	 * @return List<ExamineesHistory>
	 */
	List<ExamineesHistory> findCanExamHistoryNumber(Map<String,Object> map);
	
	/**
	 * 修改考试记录表的阅卷状态 -- 阅卷成功
	 * @param list
	 */
	void updateExamHistorySuccessStatus(Map<String,Object> map);
	
	/**
	 * 修改考试记录表的总分数
	 * @param map
	 */
	void updateExamHistoryTotalScore(Map<String,Object> map);
	
	/**
	 * 获取学员每次考试的最大值或者平均值
	 * @param criteria
	 * @return
	 */
	Float getMaxOrAvgScore(Criteria criteria);
	
	/**
	 * 查找已超时且还没有正常交卷的记录
	 * @return
	 */
	List<ExamineesHistory> findExaminatingAndTimeout(Date current);
	
	/**
	 * 根据指定的记录和时间进行交卷
	 */
	void updateStatusByExamination(List<ExamineesHistory> data,Date current);
	
	/**
	 * 获取最后一次考试记录
	 * @param examHistory
	 * @return Integer
	 */
	Integer findLastByTimes(ExamineesHistory examHistory);
	
	/**
	 * 管理员重新给分，修改考试记录的总分
	 * @param map
	 */
	void updateNewTotalScore(Map<String,Object> map);
}