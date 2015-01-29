package com.kingnod.etraining.exam.dao;

import com.kingnod.core.dao.EntityDAO;
import com.kingnod.etraining.exam.entity.QuestionAnswer;
import java.util.List;


    @com.kingnod.core.annotation.Generated("2012-05-02 19:32")
public interface QuestionAnswerDAO extends EntityDAO<QuestionAnswer, Long> {
List<QuestionAnswer> findByQuestionId(long questionId);

}