package com.kingnod.etraining.exam.action;

import com.kingnod.core.extensions.struts2.action.EntityAction;
import com.kingnod.core.extensions.struts2.action.FilterableEntityAction;
import com.kingnod.etraining.exam.entity.QuestionAnswer;
import com.kingnod.etraining.exam.service.QuestionAnswerService;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Controller
@Namespace("/exm")
@Results( 
{
@Result(name = EntityAction.RELOAD, type = "redirectAction", params = { "actionName", "question-answer", "namespace", "/exm"})
}
)

    @com.kingnod.core.annotation.Generated("2012-05-02 19:32")
public class QuestionAnswerAction extends FilterableEntityAction<QuestionAnswer, Long> {
private static final long serialVersionUID=-1334840182294036714L;

    @Autowired
    
    @com.kingnod.core.annotation.Generated("2012-05-02 19:32")
    private QuestionAnswerService questionAnswerService;


    
    @com.kingnod.core.annotation.Generated("2012-05-02 19:32")
    public String filterDefines() {
        return "exm.questionAnswerFilterItems";
    }

    
    @com.kingnod.core.annotation.Generated("2012-05-02 19:32")
    protected Object getEntityService() {
        return this.questionAnswerService;
    }
}