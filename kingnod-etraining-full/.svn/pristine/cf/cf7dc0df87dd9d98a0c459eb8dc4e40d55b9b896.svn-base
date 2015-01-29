package com.kingnod.etraining.exam.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.dao.MybatisEntityDAO;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.activity.entity.ExamineesHistory;
import com.kingnod.etraining.exam.ExamConstant;
import com.kingnod.etraining.exam.entity.ExaminationManage;
import com.kingnod.etraining.exam.entity.ExamineeQuestion;
import com.kingnod.etraining.exam.entity.Question;
import com.kingnod.etraining.exam.entity.QuestionAnswer;

@org.springframework.stereotype.Repository
@com.kingnod.core.annotation.Generated("2012-04-06 22:38")
@SuppressWarnings("unchecked")
public class ExamineeQuestionDAOImpl extends MybatisEntityDAO<ExamineeQuestion, Long> implements ExamineeQuestionDAO {

	/**
	 * 取出试题
	 * 
	 * @param examineeQuestion
	 * @return
	 */
//	public List<Question> findExamineeQuestionList(ExamineeQuestion examineeQuestion) {
//		return getSqlSession().selectList(ExamConstant.EXAM_FINDQUESTIONLIST, examineeQuestion);
//	}

	public List<QuestionAnswer> findExamineeAnswerList(long id) {
		return getSqlSession().selectList(ExamConstant.EXMA_FINDLISTBYEXAMINEEANSWER, id);
	}

//	public Float getTotalFraction(ExamineesHistory examHistory) {
//		return (Float) getSqlSession().selectOne(ExamConstant.EXAM_TOTALFRACTION, examHistory);
//	}

	/**
	 * 查询试卷下面的所有试题
	 * 
	 * @return List<ExamineeQuestion>
	 */
	public List<ExamineeQuestion> paperQuestion(ExamineeQuestion examQuestion) {
		return getSqlSession().selectList("findListByPaperAllQuestion", examQuestion);
	}

	/**
	 * 获取学员的考生试题
	 */
	public List<ExamineeQuestion> findExamQuestionByUser(Map<String,Object> map){
		if(map != null && map.size() > 0){
			return getSqlSession().selectList(ExamConstant.FINDEXAMQUESTIONBYUSER, map);
		}
		return new ArrayList<ExamineeQuestion>();
	}
	
	/**
	 * 获取考生试题
	 * @param examineesHistory
	 * @return List<ExamineeQuestion>
	 */
	public List<ExamineeQuestion> findExamQuestion(ExamineesHistory examineesHistory){
		if(examineesHistory != null){
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("userId", examineesHistory.getUserId());
			map.put("atyPaperId", examineesHistory.getAtyPaperId());
			map.put("times", examineesHistory.getTimes());
			Object obj = getSqlSession().selectList(ExamConstant.EXAM_FINDEXAMQUESTION, map);
			if(obj instanceof List){
				return (List<ExamineeQuestion>)obj;
			}
		}
		return new ArrayList<ExamineeQuestion>();
	}
	
	/**
	 * 获取当前考试活动某次记录的试卷信息
	 * @param paperId 试卷Id
	 * @param userId 用户Id
	 * @param examNumber 考试次数
	 * @return List<ExamineeQuestion>
	 */
	public List<Question> findExamActivityQuestion(ExamineesHistory examineesHistory){
		if(examineesHistory != null){
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("userId", examineesHistory.getUserId());
			map.put("atyPaperId", examineesHistory.getAtyPaperId());
			map.put("times", examineesHistory.getTimes());
			map.put("examId", examineesHistory.getExaminationId());
			Object obj = getSqlSession().selectList(ExamConstant.EXAM_EXAMACTIVITYQUESTION, map);
			if(obj instanceof List){
				return (List<Question>)obj;
			}
		}
		return new ArrayList<Question>();
	}
	
	/**
	 * 获取某次考试活动某次记录填写了答案的题目数量
	 * @param examineesHistory 考试记录Id
	 * @return List<ExamineeQuestion>
	 */
	public Integer findExamAnswerQuestionCount(ExamineesHistory examineesHistory){
		if(examineesHistory != null){
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("userId", examineesHistory.getUserId());
			map.put("atyPaperId", examineesHistory.getAtyPaperId());
			map.put("times", examineesHistory.getTimes());
			map.put("examinationId", examineesHistory.getExaminationId());
			Object obj = getSqlSession().selectOne(ExamConstant.EXAM_EXAMACTIVITYQUESTIONCOUNT, map);
			if(obj instanceof Integer){
				return (Integer)obj;
			}
		}
		return 0;
	}
	
	/**
	 * 获取某次考试记录可以阅卷的题数
	 * @param examineesHistory 考试记录Id
	 * @return List<ExamineeQuestion>
	 */
	public Integer findExamAuswertungQuestionCount(ExamineesHistory examineesHistory){
		if(examineesHistory != null){
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("examNumber", examineesHistory.getTimes());
			map.put("examId", examineesHistory.getExaminationId());
			map.put("status", examineesHistory.getStatus());
			Object obj = getSqlSession().selectOne(ExamConstant.FINDEXAMAUSWERTUNGQUESTIONCOUNT, map);
			if(obj instanceof Integer){
				return (Integer)obj;
			}
		}
		return 0;
	}
	
	/**
	 * 修改试题的阅卷信息
	 * @param map
	 */
	public void updateExamQuestionAuswertungInfo(Map<String,Object> map){
		if(map != null && map.size() > 0){
			getSqlSession().selectOne(ExamConstant.UPDATEEXAMQUESTIONAUSWERTUNGINFO, map);
		}
	}
	
	/**
	 * 获取当前考试记录填写了答案的试题的数据，判断阅卷是否完成
	 * @param map
	 * @return List<ExamineeQuestion>
	 */
	public List<ExamineeQuestion> findExamAuswertungStatus(Map<String,Object> map){
		if(map != null && map.size() > 0){
			return getSqlSession().selectList(ExamConstant.FINDEXAMAUSWERTUNGSTATUS, map);
		}
		return null;
	}
	
	/**
	 * 计算每个学员本次考试的总成绩
	 * @param map
	 * @return Map<Long,Long>
	 */ 
	public Map<Long,Long> calculateTotalScore(Map<String,Object> map){
		Map<Long,Long> mapResult = new HashMap<Long,Long>();
		if(map != null && map.size() > 0){
			Object obj = getSqlSession().selectList(ExamConstant.CALCULATETOTALSCORE, map);
			if(obj != null && obj instanceof Map){
				mapResult = (Map<Long,Long>)obj; 
			}
		}
		return mapResult;
	}
	
	/**
	 * 修改考生试题表的状态
	 * @param map
	 */
	public void updateExamQuestionStatus(Map<String,Object> map){
		if(map != null && map.size() > 0){
			getSqlSession().update("updateExamQuestionStatus",map);
		}
	}
	
	public PagingResult<ExaminationManage> findExamManageByCriteria(Criteria criteria) {
		return pagingQuery(sqlId("countExamManageByCriteria"),sqlId("findExamManageByCriteria"),criteria);
	}

	/**
	 * 查询可阅卷的记录
	 */
	public PagingResult<ExamineeQuestion> findNeedMarkingQuestionByCriteria(Criteria criteria) {
		return pagingQuery(sqlId("countNeedMarkingQuestionByCriteria"),sqlId("findNeedMarkingQuestionByCriteria"),criteria);
	}
	
	/**
	 * 查询可审核的记录
	 */
	public PagingResult<ExamineeQuestion> findNeedMarkingAuditingQuestionByCriteria(Criteria criteria) {
		return pagingQuery(sqlId("countNeedMarkingAuditingQuestionByCriteria"),sqlId("findNeedMarkingAuditingQuestionByCriteria"),criteria);
	}
	
	/**
	 * 获取阅卷测试区题目
	 * @param map
	 * @return List<ExamineeQuestion>
	 */
	public List<Question> findAuswertungQuestion(Map<String,Object> map){
		List<Question> list = new ArrayList<Question>(); 
		Object obj = getSqlSession().selectList("findAuswertungQuestion",map);
		if(obj != null && obj instanceof List){
			list = (List<Question>)obj;
		}
		return list;
	}

	/*
	 * 计算阅卷总分数
	 * (non-Javadoc)
	 * @see com.kingnod.etraining.exam.dao.ExamineeQuestionDAO#calculateAuswertungScore(com.kingnod.etraining.activity.entity.ExamineesHistory)
	 */
	public Integer calculateAuswertungScore(ExamineesHistory history) {
		Integer score = 0;
		Object obj = getSqlSession().selectOne("findCalculateAuswertungTotalScore", history);
		if(obj != null && obj instanceof Integer){
			score = (Integer)obj;
		}
		return score;
	}

	/*
	 * 获取自动组卷中  可以自动阅卷的题目
	 * (non-Javadoc)
	 * @see com.kingnod.etraining.exam.dao.ExamineeQuestionDAO#findListByAutoGenneratingPaper(com.kingnod.etraining.activity.entity.ExamineesHistory)
	 */
	public List<ExamineeQuestion> findListByAutoGenneratingPaper(ExamineesHistory examHistory) {
		return getSqlSession().selectList("findListByAutoGenneratingPaperQuestion", examHistory);
	}

	/*
	 * (non-Javadoc)
	 * @see com.kingnod.etraining.exam.dao.ExamineeQuestionDAO#findAlreadyQuestion(com.kingnod.etraining.exam.entity.ExamineeQuestion)
	 */
	public List<Question> findAlreadyQuestion(ExamineeQuestion exam) {
		return getSqlSession().selectList("findListByAlreadyGenneratedQuestions", exam);
	}
	
	/**
	 * 根据输入题数，获取考生试题答案
	 * @param map
	 * @return List<ExamineeQuestion>
	 */
	public List<ExamineeQuestion> auswertungQuestion(Map<String,Object> map){
		List<ExamineeQuestion> list = new ArrayList<ExamineeQuestion>();
		Object obj = getSqlSession().selectList("auswertungQuestion", map);
		if(obj != null && obj instanceof List){
			list = (List<ExamineeQuestion>)obj;
		}
		return list;
	}
	
	/**
	 * 根据试题Id修改试题状态(阅卷中)
	 * @param examQuesIds
	 */
	public void updateStatus(Map<String,Object> map){
		getSqlSession().selectList("updateQuestionStatus", map);
	}
	
	/**
	 * 将锁定状态的阅卷中，审核中的试题改为阅卷完，审核完
	 * @param map
	 */
	public void updateLockedStatus(Map<String,Object> map){
		if(map != null && map.size() > 0){
			getSqlSession().selectList("updateLockedStatus", map);
		}
	}
	
	/**
	 * 解锁，将阅卷中，审核中状态改为未阅卷，未审核
	 * @param examQuesIds
	 */
	public void decontrolStatus(Map<String,Object> map){
		getSqlSession().selectList("decontrolStatus", map);
	}
	
	/**
	 * 修改试题分数
	 * @param map
	 */
	public void updateNewScore(Map<String,Object> map){
		if(map != null && map.size() > 0){
			getSqlSession().update("updateNewScore", map);
		}
	}
	
	/**
	 * 管理员查阅试卷，重新给分，获取重新给分的试题信息
	 * @param map
	 * @return ExamineeQuestion
	 */
	public ExamineeQuestion getExamQuestionByGiveScore(Map<String,Object> map){
		ExamineeQuestion examQuestion = null;
		if(map != null && map.size() > 0){
			Object obj = getSqlSession().selectOne("getExamQuestionByGiveScore", map);
			if(obj != null && obj instanceof ExamineeQuestion){
				examQuestion = (ExamineeQuestion)obj;
			}
		}
		return examQuestion;
	}
	
	/**
	 * 根据多个Id获取ExamineeQuestion
	 * @param list
	 * @return List<ExamineeQuestion>
	 */
	public List<ExamineeQuestion> getExamQuestionByIds(List<Long> list){
		List<ExamineeQuestion> examQueslist = new ArrayList<ExamineeQuestion>();
		if(list != null && list.size() > 0){
			Object obj = getSqlSession().selectList("getExamQuestionByIds", list);
			if(obj != null && obj instanceof List){
				examQueslist = (List<ExamineeQuestion>)obj;
			}
		}
		return examQueslist;
	}
	
}