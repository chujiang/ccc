package com.kingnod.etraining.activity.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.xwork.StringUtils;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.dao.MybatisEntityDAO;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.core.util.DateUtils;
import com.kingnod.core.util.collection.ListUtils;
import com.kingnod.core.util.collection.MapUtils;
import com.kingnod.etraining.activity.entity.ExamineesHistory;
import com.kingnod.etraining.exam.ExamConstant;

@org.springframework.stereotype.Repository
@com.kingnod.core.annotation.Generated("2012-03-16 19:59")
public class ExamineesHistoryDAOImpl extends MybatisEntityDAO<ExamineesHistory, Long> implements ExamineesHistoryDAO {

	/**
	 * 得到考生历史记录的考试最大次数
	 * 
	 * @return
	 */
	public Integer findMaxByTimes(ExamineesHistory examHistory) {
		Integer maxTimes = new Integer(0);
		Object obj = getSqlSession().selectOne(ExamConstant.FINDMAXBYTIMES, examHistory);
		if(obj != null && obj instanceof Integer){
			maxTimes = (Integer)obj == 0 ? 0 : (Integer)obj;
		}
		return maxTimes;
	}
	
	/**
	 * 获取最后一次考试记录
	 * @param examHistory
	 * @return Integer
	 */
	public Integer findLastByTimes(ExamineesHistory examHistory){
		Integer maxTimes = null;
		Object obj = getSqlSession().selectOne(ExamConstant.FINDLASTBYTIMES, examHistory);
		if(obj != null){
			maxTimes = (Integer)obj == 0 ? 0 : (Integer)obj;
		}
		return maxTimes;
	}

	/**
	 * 根据examinationId获取历史记录
	 * 
	 * @param examinationId
	 * @return
	 */
	public ExamineesHistory findListByExaminationId(ExamineesHistory examHistory) {
		return (ExamineesHistory) getSqlSession().selectOne(ExamConstant.FINDMAXTIMESBYID, examHistory);
	}
	
	/**
	 * 获取考试活动的已考次数
	 * @param examHistory
	 * @return ExamineesHistory
	 */
	public ExamineesHistory findMaxExaminationExamSurplusNumber(ExamineesHistory examHistory){
		return (ExamineesHistory) getSqlSession().selectOne(ExamConstant.EXAM_MAX_SURPLUSNUMBER, examHistory);
	}

	/**
     * 查询所有可以阅卷的考试列表
     * @return List<ExamineesHistory>
     */
	@SuppressWarnings("unchecked")
	public List<ExamineesHistory> readExam() {
		return getSqlSession().selectList(ExamConstant.FINDREADEXAMINATION);
	}
	
	/**
     * 获取考试限制的数据集
     * @return Long
     */
	public Long findAtyRestraintCount(Map<String,Object> map) {
		Object obj = getSqlSession().selectOne(ExamConstant.FINDATYRESTRAINTCOUNT,map);
		if(obj != null && obj instanceof Long){
			return (Long)obj;
		}
		return 0L;
	}
	
	/**
	 * 查询当前考试活动的所有历史考试记录
	 * @return List<ExamineesHistory>
	 */
	@SuppressWarnings("unchecked")
	public List<ExamineesHistory> findExamDetail(ExamineesHistory examHistory){
		List<ExamineesHistory> list = new ArrayList<ExamineesHistory>();
		if(examHistory != null){
			Object obj = getSqlSession().selectList(ExamConstant.FINDEXAMINATIONDETAIL,examHistory);
			if(obj instanceof List){
				list = (List<ExamineesHistory>)obj;
			}
		}
		return list;
	}
	
	/**
	 * 查询当前考试活动的所有历史考试记录 分页@author maxudomg
	 * @return List<ExamineesHistory>
	 */
	public PagingResult<ExamineesHistory> findExamDetailPage(Criteria criteria){
		return pagingQuery(ExamConstant.FINDEXAMINATIONDETAILPAGECOUNT,ExamConstant.FINDEXAMINATIONDETAILPAGE, criteria);
	}
	
	/**
     * 根据计分方式，获取考试得分
     * @return Long
     */
	public Double findExamAVGScore(Map<String,Object> map,String type) {
		Object obj = getSqlSession().selectOne(type,map);
		if(obj != null && obj instanceof Double){
			return (Double)obj;
		}
		return 0D;
	}
	
	/**
	 * 查询当前考试活动下的所有学员的考试详情
	 * @return List<ExamineesHistory>
	 */
	public PagingResult<ExamineesHistory> findExamDetails(Criteria criteria){
		return pagingQuery("countExamDetailsByCriteria", "findExamDetails", criteria);
	}
	
	/**
     * 获取本次考试参加的人数
     * @return Long
     */
	public Long findExamHistoryUserCount(ExamineesHistory examHistory) {
		Object obj = getSqlSession().selectOne(ExamConstant.FINDEXAMHISTORYUSERCOUNT, examHistory);
		if(obj != null && obj instanceof Long){
			return (Long)obj;
		}
		return 0L;
	}
	
	/**
	 * 获取可以阅卷的考试记录
	 * @param map
	 * @return List<ExamineesHistory>
	 */
	@SuppressWarnings("unchecked")
	public List<ExamineesHistory> findCanAuswertungHistory(String status) {
		if(StringUtils.isNotEmpty(status)){
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("status", status);
			Object obj = getSqlSession().selectList(ExamConstant.FINDCANAUSWERTUNGHISTORY,map);
			if(obj != null && obj instanceof List){
				return (List<ExamineesHistory>)obj;
			}
		}
		return new ArrayList<ExamineesHistory>();
	}
	
	/**
	 * 根据阅卷员指定的阅卷数量，抽取考试记录
	 * @param map
	 * @return List<ExamineesHistory>
	 */
	@SuppressWarnings("unchecked")
	public List<ExamineesHistory> findCanExamHistoryNumber(Map<String,Object> map) {
		Object obj = getSqlSession().selectList(ExamConstant.FINDCANEXAMHISTORYNUMBER,map);
		if(obj != null && obj instanceof List){
			return (List<ExamineesHistory>)obj;
		}
		return new ArrayList<ExamineesHistory>();
	}
	
	/**
	 * 修改考试记录表的阅卷状态 -- 阅卷中
	 * @param list
	 */
	public void updateExamHistoryAuswertungStatus(Map<String,Object> map){
		if(map != null && map.size() > 0){
			getSqlSession().update(ExamConstant.UPDATEEXAMHISTORYAUSWERTUNGSTATUS,map);
		}
	}
	
	/**
	 * 修改考试记录表的阅卷状态 -- 阅卷成功
	 * @param list
	 */
	public void updateExamHistorySuccessStatus(Map<String,Object> map){
		if(map != null && map.size() > 0){
			getSqlSession().update(ExamConstant.UPDATEEXAMHISTORYSUCCESSSTATUS,map);
		}
	}
	
	/**
	 * 修改考试记录表的总分数
	 * @param map
	 */
	public void updateExamHistoryTotalScore(Map<String,Object> map){
		if(map != null && map.size() > 0){
			getSqlSession().update(ExamConstant.UPDATEEXAMHISTORYTOTALSCORE,map);
		}
	}

	/**
	 * 获取学员每次考试的最大值或者平均值
	 */
	public Float getMaxOrAvgScore(Criteria criteria) {
		return (Float) getSqlSession().selectOne(sqlId("getMaxOrAvgScore"),criteria);
	}

	public List<ExamineesHistory> findExaminatingAndTimeout(Date current) {
		Map params = MapUtils.map("currentDateTime",DateUtils.format(current,"yyyy-MM-dd HH:mm:ss"));
		Integer count = (Integer) getSqlSession().selectOne(sqlId("countExaminatingAndTimeout"),params);
		if (count != null && count > 0) {
			return getSqlSession().selectList(sqlId("findExaminatingAndTimeout"),params);
		}
		return null;
	}

	public void updateStatusByExamination(List<ExamineesHistory> data, Date current) {
		if (ListUtils.isNotEmpty(data) && current != null) {
			Map params = MapUtils.mapByAarray("currentDateTime",DateUtils.format(current,"yyyy-MM-dd HH:mm:ss"));
			getSqlSession().update(sqlId("updateStatusByTimeout"),params);
			for (ExamineesHistory eh : data) {
				params.put("times", eh.getTimes());
				params.put("examinationId", eh.getExaminationId());
				getSqlSession().update(sqlId("updateExamaineeQAStatusByTimeout"), params);
			}
		}
	}
	
	/**
	 * 管理员重新给分，修改考试记录的总分
	 * @param map
	 */
	public void updateNewTotalScore(Map<String,Object> map){
		if(map != null && map.size() > 0){
			getSqlSession().update("updateNewTotalScore", map);
		}
	}
}