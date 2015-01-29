package com.kingnod.etraining.exam.action;

import com.kingnod.core.extensions.struts2.action.EntityAction;
import com.kingnod.core.extensions.struts2.action.FilterableEntityAction;
import com.kingnod.etraining.exam.entity.ExamineeQuestion;
import com.kingnod.etraining.exam.service.ExamineeQuestionService;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Controller
@Namespace("/exm")
@Results( 
{
@Result(name = EntityAction.RELOAD, type = "redirectAction", params = { "actionName", "examinee-question", "namespace", "/exm"})
}
)

    @com.kingnod.core.annotation.Generated("2012-05-14 10:22")
public class ExamineeQuestionAction extends FilterableEntityAction<ExamineeQuestion, Long> {
private static final long serialVersionUID=-7260605652009445546L;

    @Autowired
    
    @com.kingnod.core.annotation.Generated("2012-05-14 10:22")
    private ExamineeQuestionService examineeQuestionService;


    
    @com.kingnod.core.annotation.Generated("2012-05-14 10:22")
    public String filterDefines() {
        return "exm.examineeQuestionFilterItems";
    }

    
    @com.kingnod.core.annotation.Generated("2012-05-14 10:22")
    protected Object getEntityService() {
        return this.examineeQuestionService;
    }
}