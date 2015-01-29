package com.kingnod.etraining.activity.action;

import com.kingnod.core.extensions.struts2.action.EntityAction;
import com.kingnod.core.extensions.struts2.action.FilterableEntityAction;
import com.kingnod.etraining.activity.entity.WorkFlowApproval;
import com.kingnod.etraining.activity.service.WorkFlowApprovalService;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Controller
@Namespace("/aty")
@Results( 
{
@Result(name = EntityAction.RELOAD, type = "redirectAction", params = { "actionName", "work-flow-approval", "namespace", "/aty"})
}
)

    @com.kingnod.core.annotation.Generated("2012-03-15 15:48")
public class WorkFlowApprovalAction extends FilterableEntityAction<WorkFlowApproval, Long> {

    @Autowired
    
    @com.kingnod.core.annotation.Generated("2012-03-15 15:48")
    private WorkFlowApprovalService workFlowApprovalService;


    
    @com.kingnod.core.annotation.Generated("2012-03-15 15:48")
    public String filterDefines() {
        return "aty.workFlowApprovalFilterItems";
    }

    
    @com.kingnod.core.annotation.Generated("2012-03-15 15:48")
    protected Object getEntityService() {
        return this.workFlowApprovalService;
    }
}