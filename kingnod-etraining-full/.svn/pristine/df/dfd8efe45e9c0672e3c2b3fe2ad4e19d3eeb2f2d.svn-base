package com.kingnod.etraining.activity.service;

import java.util.List;
import java.util.Map;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.activity.entity.Examination;
import com.kingnod.etraining.activity.entity.ExamineesHistory;


    @com.kingnod.core.annotation.Generated("2012-03-16 19:59")
public interface ExamineesHistoryService {

    
    @com.kingnod.core.annotation.Generated("2012-03-16 19:59")
    ExamineesHistory getExamineesHistory(Long id);

    
    @com.kingnod.core.annotation.Generated("2012-03-16 19:59")
    int saveExamineesHistory(ExamineesHistory examineesHistory);

    
    @com.kingnod.core.annotation.Generated("2012-03-16 19:59")
    int deleteExamineesHistory(ExamineesHistory examineesHistory);

    
    @com.kingnod.core.annotation.Generated("2012-03-16 19:59")
    int deleteExamineesHistoryByIds(Long[] ids);

    
    @com.kingnod.core.annotation.Generated("2012-03-16 19:59")
    PagingResult<ExamineesHistory> findExamineesHistory(Criteria criteria);

    /**
     * 查询所有可以阅卷的考试列表
     * @return
     */
	List<ExamineesHistory> findReadExamination();
	
	/**
	 * 查询当前考试活动的所有历史考试记录
	 * @return
	 */
	List<ExamineesHistory> findExamDetail(Examination exam);
	/**
	 * 查询当前考试活动的所有历史考试记录 @author maxudong
	 * @return
	 */
	public PagingResult<ExamineesHistory> findExamDetailPage(Criteria criteria);
	
	/**
     * 获取考试限制的数据集
     * @return Long
     */
	Long findAtyRestraintCount(Map<String,Object> map);
	
	/**
     * 根据计分方式，获取考试得分
     * @return Long
     */
	Double findExamAVGScore(Map<String,Object> map,String type);
	
	/**
	 * 考试详情
	 * @return
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
	 * 根据阅卷员指定的阅卷数量，抽取考试记录
	 * @param map
	 * @return List<ExamineesHistory>
	 */
	List<ExamineesHistory> findCanExamHistoryNumber(Map<String,Object> map);
	
	/**
	 *  修改考试记录表的阅卷状态
	 * @param list
	 */
	void updateExamHistoryAuswertungStatus(Map<String,Object> map);
	
	/**
	 * 修改考试记录表的阅卷状态 -- 阅卷成功
	 * @param map
	 */
	void updateExamHistorySuccessStatus(Map<String,Object> map);
	
	/**
	 * 修改考试记录表的总分数
	 * @param map
	 */
	void updateExamHistoryTotalScore(Map<String,Object> map);

	/**
	 * 管理员重新给分，修改考试记录的总分
	 * @param map
	 */
	public void updateNewTotalScore(Map<String,Object> map);
}