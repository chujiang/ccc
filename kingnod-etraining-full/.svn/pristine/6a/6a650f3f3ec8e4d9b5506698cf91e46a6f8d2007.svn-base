package com.kingnod.etraining.common.action;

import com.kingnod.core.extensions.struts2.action.EntityAction;
import com.kingnod.core.extensions.struts2.action.FilterableEntityAction;
import com.kingnod.etraining.common.entity.RoleRef;
import com.kingnod.etraining.common.service.RoleRefService;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Controller
@Namespace("/cmn")
@Results( 
{
@Result(name = EntityAction.RELOAD, type = "redirectAction", params = { "actionName", "role-ref", "namespace", "/cmn"})
}
)

@com.kingnod.core.annotation.Generated("2012-03-16 09:42")
public class RoleRefAction extends FilterableEntityAction<RoleRef, Long> {

    @Autowired
    
    @com.kingnod.core.annotation.Generated("2012-03-16 09:42")
    private RoleRefService roleRefService;


    
    @com.kingnod.core.annotation.Generated("2012-03-16 09:42")
    public String filterDefines() {
        return "cmn.roleRefFilterItems";
    }

    
    @com.kingnod.core.annotation.Generated("2012-03-16 09:42")
    protected Object getEntityService() {
        return this.roleRefService;
    }
}