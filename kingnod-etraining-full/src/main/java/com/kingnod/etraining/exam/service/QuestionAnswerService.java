package com.kingnod.etraining.exam.service;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.exam.entity.QuestionAnswer;


    @com.kingnod.core.annotation.Generated("2012-05-02 19:32")
public interface QuestionAnswerService {

    
    @com.kingnod.core.annotation.Generated("2012-05-02 19:32")
    QuestionAnswer getQuestionAnswer(Long id);

    
    @com.kingnod.core.annotation.Generated("2012-05-02 19:32")
    int saveQuestionAnswer(QuestionAnswer questionAnswer);

    
    @com.kingnod.core.annotation.Generated("2012-05-02 19:32")
    int deleteQuestionAnswer(QuestionAnswer questionAnswer);

    
    @com.kingnod.core.annotation.Generated("2012-05-02 19:32")
    int deleteQuestionAnswerByIds(Long[] ids);

    
    @com.kingnod.core.annotation.Generated("2012-05-02 19:32")
    PagingResult<QuestionAnswer> findQuestionAnswer(Criteria criteria);
}