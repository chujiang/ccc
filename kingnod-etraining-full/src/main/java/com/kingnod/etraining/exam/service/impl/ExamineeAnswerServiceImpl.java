package com.kingnod.etraining.exam.service.impl;

import java.util.List;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.activity.entity.ExamineesHistory;
import com.kingnod.etraining.exam.dao.ExamineeAnswerDAO;
import com.kingnod.etraining.exam.entity.ExamineeAnswer;
import com.kingnod.etraining.exam.entity.QuestionAnswer;
import com.kingnod.etraining.exam.service.ExamineeAnswerService;

import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class ExamineeAnswerServiceImpl implements ExamineeAnswerService {

	@Autowired
	protected ExamineeAnswerDAO examineeAnswerDAO;

	public ExamineeAnswer getExamineeAnswer(Long id) {
		return examineeAnswerDAO.get(id);
	}

	public int saveExamineeAnswer(ExamineeAnswer examineeAnswer) {
		int count = 0;
		IdEntity<Long> idEntity = (IdEntity<Long>) examineeAnswer;
		if (null != idEntity.getId()
				&& null != examineeAnswerDAO.get(idEntity.getId())) {
			count = examineeAnswerDAO.update(examineeAnswer);
		} else {
			count = examineeAnswerDAO.insert(examineeAnswer);
		}
		return count;
	}

	public int deleteExamineeAnswer(ExamineeAnswer examineeAnswer) {
		return examineeAnswerDAO.delete(examineeAnswer);
	}

	public int deleteExamineeAnswerByIds(Long[] ids) {
		return examineeAnswerDAO.deleteById(ids);
	}

	public PagingResult<ExamineeAnswer> findExamineeAnswer(Criteria criteria) {
		return examineeAnswerDAO.findPagingResult(criteria);
	}
	
	/**
	 * 获取findExamActivityAnswer
	 */
	public List<QuestionAnswer> findExamActivityAnswer(ExamineesHistory examHistory){
		return examineeAnswerDAO.findExamActivityAnswer(examHistory);
	}
}