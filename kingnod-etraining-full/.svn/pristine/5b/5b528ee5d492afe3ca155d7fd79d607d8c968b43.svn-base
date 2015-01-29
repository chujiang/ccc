package com.kingnod.etraining.activity.action;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.extensions.struts2.action.EntityAction;
import com.kingnod.core.extensions.struts2.action.FilterableEntityAction;
import com.kingnod.etraining.activity.entity.TrainingPlan;
import com.kingnod.etraining.activity.service.TrainingPlanService;



@org.springframework.stereotype.Controller
@Namespace("/aty")
@Results( 
{
@Result(name = EntityAction.RELOAD, type = "redirectAction", params = { "actionName", "training-plan-process-reports", "namespace", "/aty"})
}
)
public class TrainingPlanProcessReportsAction extends FilterableEntityAction<TrainingPlan, Long>{

	@Autowired
	    
	    private TrainingPlanService trainingPlanService;


	    
	    public String filterDefines() {
	        return "aty.trainingPlanFilterItems";
	    }

	    
	    protected Object getEntityService() {
	        return this.trainingPlanService;
	    }




	}
