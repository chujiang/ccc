package com.kingnod.etraining.exam.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.exam.dao.QuestionAnswerDAO;
import com.kingnod.etraining.exam.entity.QuestionAnswer;
import com.kingnod.etraining.exam.service.QuestionAnswerService;

@org.springframework.stereotype.Service
public class QuestionAnswerServiceImpl implements QuestionAnswerService {

	@Autowired
	protected QuestionAnswerDAO questionAnswerDAO;

	public QuestionAnswer getQuestionAnswer(Long id) {
		return questionAnswerDAO.get(id);
	}

	public int saveQuestionAnswer(QuestionAnswer questionAnswer) {
		int count = 0;
		IdEntity<Long> idEntity = (IdEntity<Long>) questionAnswer;
		if (null != idEntity.getId()
				&& null != questionAnswerDAO.get(idEntity.getId())) {
			count = questionAnswerDAO.update(questionAnswer);
		} else {
			count = questionAnswerDAO.insert(questionAnswer);
		}
		return count;
	}

	public int deleteQuestionAnswer(QuestionAnswer questionAnswer) {
		return questionAnswerDAO.delete(questionAnswer);
	}

	public int deleteQuestionAnswerByIds(Long[] ids) {
		return questionAnswerDAO.deleteById(ids);
	}

	public PagingResult<QuestionAnswer> findQuestionAnswer(Criteria criteria) {
		return questionAnswerDAO.findPagingResult(criteria);
	}
}