package com.kingnod.etraining.exam.dao;

import com.kingnod.core.dao.MybatisEntityDAO;
import com.kingnod.etraining.exam.ExamConstant;
import com.kingnod.etraining.exam.entity.QuestionAnswer;
import java.util.List;

@org.springframework.stereotype.Repository

    @com.kingnod.core.annotation.Generated("2012-05-02 19:32")
public class QuestionAnswerDAOImpl extends MybatisEntityDAO<QuestionAnswer, Long> implements QuestionAnswerDAO {

@SuppressWarnings("unchecked") public List<QuestionAnswer> findByQuestionId(long questionId){
  return getSqlSession().selectList(ExamConstant.FINDBYQUESTIONID,questionId);
}

}