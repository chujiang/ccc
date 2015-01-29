package com.kingnod.etraining.activity.action;

import com.kingnod.core.extensions.struts2.action.EntityAction;
import com.kingnod.core.extensions.struts2.action.FilterableEntityAction;
import com.kingnod.etraining.activity.entity.WokflowBusiness;
import com.kingnod.etraining.activity.service.WokflowBusinessService;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Controller
@Namespace("/aty")
@Results( 
{
@Result(name = EntityAction.RELOAD, type = "redirectAction", params = { "actionName", "wokflow-business", "namespace", "/aty"})
}
)

    @com.kingnod.core.annotation.Generated("2012-03-06 18:48")
public class WokflowBusinessAction extends FilterableEntityAction<WokflowBusiness, Long> {

    @Autowired
    
    @com.kingnod.core.annotation.Generated("2012-03-06 18:48")
    private WokflowBusinessService wokflowBusinessService;


    
    @com.kingnod.core.annotation.Generated("2012-03-06 18:48")
    public String filterDefines() {
        return "aty.wokflowBusinessFilterItems";
    }

    
    @com.kingnod.core.annotation.Generated("2012-03-06 18:48")
    protected Object getEntityService() {
        return this.wokflowBusinessService;
    }
}