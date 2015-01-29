package com.kingnod.etraining.activity.action;

import com.kingnod.core.extensions.struts2.action.EntityAction;
import com.kingnod.core.extensions.struts2.action.FilterableEntityAction;
import com.kingnod.etraining.activity.entity.TrainingPlanProcess;
import com.kingnod.etraining.activity.service.TrainingPlanProcessService;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Controller
@Namespace("/aty")
@Results( 
{
@Result(name = EntityAction.RELOAD, type = "redirectAction", params = { "actionName", "training-plan-process", "namespace", "/aty"})
}
)

    @com.kingnod.core.annotation.Generated("2012-02-14 15:01")
public class TrainingPlanProcessAction extends FilterableEntityAction<TrainingPlanProcess, Long> {

    @Autowired
    
    @com.kingnod.core.annotation.Generated("2012-02-14 15:01")
    private TrainingPlanProcessService trainingPlanProcessService;
    
    @com.kingnod.core.annotation.Generated("2012-02-14 15:01")
    public String filterDefines() {
        return "aty.trainingPlanProcessFilterItems";
    }

    
    @com.kingnod.core.annotation.Generated("2012-02-14 15:01")
    protected Object getEntityService() {
        return this.trainingPlanProcessService;
    }
    
    public String initial(){
    	trainingPlanProcessService.initTrainingPlanProcess(this.getModel().getTrainingPlanId());
    	return EntityAction.RELOAD;
    }
}