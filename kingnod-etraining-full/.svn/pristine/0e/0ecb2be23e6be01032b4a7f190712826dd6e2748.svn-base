package com.kingnod.etraining.activity.action;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.extensions.struts2.action.EntityAction;
import com.kingnod.core.extensions.struts2.action.FilterableEntityAction;
import com.kingnod.etraining.activity.entity.TrainingPlanActivity;
import com.kingnod.etraining.activity.service.TrainingPlanActivityService;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Controller
@Namespace("/aty")
@Results( 
{
@Result(name = EntityAction.RELOAD, type = "redirectAction", params = { "actionName", "training-plan-activity", "namespace", "/aty"})
}
)

    @com.kingnod.core.annotation.Generated("2012-02-15 11:44")
public class TrainingPlanActivityAction extends FilterableEntityAction<TrainingPlanActivity, Long> {

    @Autowired
    
    @com.kingnod.core.annotation.Generated("2012-02-15 11:44")
    private TrainingPlanActivityService trainingPlanActivityService;


    
    @com.kingnod.core.annotation.Generated("2012-02-15 11:44")
    public String filterDefines() {
        return "aty.trainingPlanActivityFilterItems";
    }

    
    @com.kingnod.core.annotation.Generated("2012-02-15 11:44")
    protected Object getEntityService() {
        return this.trainingPlanActivityService;
    }
    
    @Override
    protected void preparedCriteriaBuilder(CriteriaBuilder cb) {
    	super.preparedCriteriaBuilder(cb);
    	cb.andGroup(Cnd.builder().andEQ("processId", this.getModel().getProcessId()));
    }
}