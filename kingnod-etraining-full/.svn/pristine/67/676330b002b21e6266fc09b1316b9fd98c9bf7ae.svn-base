package com.kingnod.etraining.activity.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.core.util.SecurityUtils;
import com.kingnod.etraining.activity.action.ExamUtil;
import com.kingnod.etraining.activity.dao.ExamineesHistoryDAO;
import com.kingnod.etraining.activity.entity.Examination;
import com.kingnod.etraining.activity.entity.ExamineesHistory;
import com.kingnod.etraining.activity.service.ExamineesHistoryService;
import com.kingnod.etraining.security.entity.UserAccount;

@org.springframework.stereotype.Service
public class ExamineesHistoryServiceImpl implements ExamineesHistoryService {

	@Autowired
	protected ExamineesHistoryDAO examineesHistoryDAO;

	public ExamineesHistory getExamineesHistory(Long id) {
		return examineesHistoryDAO.get(id);
	}

	public int saveExamineesHistory(ExamineesHistory examineesHistory) {
		int count = 0;
		IdEntity<Long> idEntity = (IdEntity<Long>) examineesHistory;
		if (null != idEntity.getId()
				&& null != examineesHistoryDAO.get(idEntity.getId())) {
			count = examineesHistoryDAO.update(examineesHistory);
		} else {
			count = examineesHistoryDAO.insert(examineesHistory);
		}
		return count;
	}

	public int deleteExamineesHistory(ExamineesHistory examineesHistory) {
		return examineesHistoryDAO.delete(examineesHistory);
	}

	public int deleteExamineesHistoryByIds(Long[] ids) {
		return examineesHistoryDAO.deleteById(ids);
	}

	public PagingResult<ExamineesHistory> findExamineesHistory(Criteria criteria) {
		PagingResult<ExamineesHistory> pagingResult = examineesHistoryDAO.findPagingResult(criteria);
		List<ExamineesHistory> historyList = pagingResult.getResult();
		// 处理  分数的显示
		for (ExamineesHistory examinees : historyList) {
			examinees.setTotalScoreStr(ExamUtil.formatNumerical(examinees.getTotalscore()));
		}
		return pagingResult;
	}

	/**
     * 查询所有可以阅卷的考试列表
     * @return
     */
	public List<ExamineesHistory> findReadExamination() {
		return examineesHistoryDAO.readExam();
	}
	
	/**
	 * 查询当前考试活动的所有历史考试记录
	 * @return
	 */
	public List<ExamineesHistory> findExamDetail(Examination exam){
		if(exam != null){
			ExamineesHistory examHistory = new ExamineesHistory(); 
			examHistory.setUserId(getUserId());
			examHistory.setExaminationId(exam.getId());
			examHistory.setAtyPaperId(exam.getAtyPaperId());
			return examineesHistoryDAO.findExamDetail(examHistory);
		}
		return new ArrayList<ExamineesHistory>();
	}
	/**
	 * 查询当前考试活动的所有历史考试记录分页 @author maxudong
	 * @return
	 */
	public PagingResult<ExamineesHistory> findExamDetailPage(Criteria criteria){
		return examineesHistoryDAO.findExamDetailPage(criteria);
	}
	
	// 处理 得到userId
	protected long getUserId() {
		UserAccount userAccount = (UserAccount)SecurityUtils.getCurrentUser();
		return userAccount.getId();
	}
	
	/**
     * 获取考试限制的数据集
     * @return Long
     */
	public Long findAtyRestraintCount(Map<String,Object> map) {
		return examineesHistoryDAO.findAtyRestraintCount(map);
	}
	
	/**
     * 根据计分方式，获取考试得分
     * @return Long
     */
	public Double findExamAVGScore(Map<String,Object> map,String type) {
		return examineesHistoryDAO.findExamAVGScore(map,type);
	}
	
	/**
	 * 查询当前考试活动的所有历史考试记录
	 * @return
	 */
	public PagingResult<ExamineesHistory> findExamDetails(Criteria criteria){
		PagingResult<ExamineesHistory> pagingResult = examineesHistoryDAO.findExamDetails(criteria);
		List<ExamineesHistory> historyList = pagingResult.getResult();
		for (ExamineesHistory history : historyList) {
			history.setTotalScoreStr(ExamUtil.formatNumerical(history.getFinalScore()));
		}
		return pagingResult;
	}
	
	/**
     * 获取本次考试参加的人数
     * @return Long
     */
	public Long findExamHistoryUserCount(ExamineesHistory examHistory) {
		return examineesHistoryDAO.findExamHistoryUserCount(examHistory);
	}
	
	/**
     * 获取可以阅卷的考试记录
     * @return List<ExamineesHistory>
     */
	public List<ExamineesHistory> findCanAuswertungHistory(String status) {
		return examineesHistoryDAO.findCanAuswertungHistory(status);
	}
	
	/**
	 * 根据阅卷员指定的阅卷数量，抽取考试记录
	 * @param map
	 * @return List<ExamineesHistory>
	 */
	public List<ExamineesHistory> findCanExamHistoryNumber(Map<String,Object> map){
		return examineesHistoryDAO.findCanExamHistoryNumber(map);
	}
	/**
	 *  修改考试记录表的阅卷状态
	 * @param list
	 */
	public void updateExamHistoryAuswertungStatus(Map<String,Object> map){
		examineesHistoryDAO.updateExamHistoryAuswertungStatus(map);
	}
	
	/**
	 * 修改考试记录表的阅卷状态 -- 阅卷成功
	 * @param map
	 */
	public void updateExamHistorySuccessStatus(Map<String,Object> map){
		examineesHistoryDAO.updateExamHistorySuccessStatus(map);
	}
	
	/**
	 * 修改考试记录表的总分数
	 * @param map
	 */
	public void updateExamHistoryTotalScore(Map<String,Object> map){
		examineesHistoryDAO.updateExamHistoryTotalScore(map);
	}
	
	/**
	 * 管理员重新给分，修改考试记录的总分
	 * @param map
	 */
	public void updateNewTotalScore(Map<String,Object> map){
		examineesHistoryDAO.updateNewTotalScore(map);
	}
}