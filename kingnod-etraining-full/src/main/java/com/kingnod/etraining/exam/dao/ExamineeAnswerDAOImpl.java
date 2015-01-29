package com.kingnod.etraining.exam.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kingnod.core.dao.MybatisEntityDAO;
import com.kingnod.etraining.activity.entity.ExamineesHistory;
import com.kingnod.etraining.exam.ExamConstant;
import com.kingnod.etraining.exam.entity.ExamineeAnswer;
import com.kingnod.etraining.exam.entity.QuestionAnswer;

@org.springframework.stereotype.Repository

    @com.kingnod.core.annotation.Generated("2012-03-12 10:47")
public class ExamineeAnswerDAOImpl extends MybatisEntityDAO<ExamineeAnswer, Long> implements ExamineeAnswerDAO {

	/**
	 * findExamActivityAnswer
	 */
	@SuppressWarnings("unchecked")
	public List<QuestionAnswer> findExamActivityAnswer(ExamineesHistory examHistory) {
		if(examHistory != null){
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("userId", examHistory.getUserId());
			map.put("atyPaperId", examHistory.getAtyPaperId());
			map.put("times", examHistory.getTimes());
			map.put("examId", examHistory.getExaminationId());
			Object obj = getSqlSession().selectList(ExamConstant.EXAM_EXAMACTIVITYANSWER, map);
			if(obj instanceof List){
				return (List<QuestionAnswer>)obj;
			}
		}
		return new ArrayList<QuestionAnswer>();
	}
}