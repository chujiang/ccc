package com.kingnod.etraining.activity.action;

import java.util.List;

import com.kingnod.core.extensions.struts2.action.EntityAction;
import com.kingnod.core.extensions.struts2.action.FilterableEntityAction;
import com.kingnod.etraining.activity.entity.Period;
import com.kingnod.etraining.activity.service.PeriodService;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Controller
@Namespace("/aty")
@Results( 
{
@Result(name = EntityAction.RELOAD, type = "redirectAction", params = { "actionName", "period", "namespace", "/aty"})
}
)

    @com.kingnod.core.annotation.Generated("2012-03-08 11:15")
public class PeriodAction extends FilterableEntityAction<Period, Long> {

    @Autowired
    
    @com.kingnod.core.annotation.Generated("2012-03-08 11:15")
    private PeriodService periodService;


    
    @com.kingnod.core.annotation.Generated("2012-03-08 11:15")
    public String filterDefines() {
        return "aty.periodFilterItems";
    }

    
    @com.kingnod.core.annotation.Generated("2012-03-08 11:15")
    protected Object getEntityService() {
        return this.periodService;
    }
}