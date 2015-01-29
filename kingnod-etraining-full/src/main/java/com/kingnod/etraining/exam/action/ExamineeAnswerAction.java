package com.kingnod.etraining.exam.action;

import com.kingnod.core.extensions.struts2.action.EntityAction;
import com.kingnod.core.extensions.struts2.action.FilterableEntityAction;
import com.kingnod.etraining.exam.entity.ExamineeAnswer;
import com.kingnod.etraining.exam.service.ExamineeAnswerService;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Controller
@Namespace("/exm")
@Results( 
{
@Result(name = EntityAction.RELOAD, type = "redirectAction", params = { "actionName", "examinee-answer", "namespace", "/exm"})
}
)

    @com.kingnod.core.annotation.Generated("2012-03-12 10:47")
public class ExamineeAnswerAction extends FilterableEntityAction<ExamineeAnswer, Long> {
private static final long serialVersionUID=1518688305291493182L;

    @Autowired
    
    @com.kingnod.core.annotation.Generated("2012-03-12 10:47")
    private ExamineeAnswerService examineeAnswerService;


    
    @com.kingnod.core.annotation.Generated("2012-03-12 10:47")
    public String filterDefines() {
        return "exm.examineeAnswerFilterItems";
    }

    
    @com.kingnod.core.annotation.Generated("2012-03-12 10:47")
    protected Object getEntityService() {
        return this.examineeAnswerService;
    }
}