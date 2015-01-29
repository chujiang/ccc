package com.kingnod.etraining.common.action;

import com.kingnod.core.extensions.struts2.action.EntityAction;
import com.kingnod.core.extensions.struts2.action.FilterableEntityAction;
import com.kingnod.etraining.common.entity.Menu;
import com.kingnod.etraining.common.service.MenuService;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Controller
@Namespace("/cmn")
@Results( 
{
@Result(name = EntityAction.RELOAD, type = "redirectAction", params = { "actionName", "menu", "namespace", "/cmn"})
}
)

    @com.kingnod.core.annotation.Generated("2012-03-14 21:21")
public class MenuAction extends FilterableEntityAction<Menu, Long> {

    @Autowired
    
    @com.kingnod.core.annotation.Generated("2012-03-14 21:21")
    private MenuService menuService;


    
    @com.kingnod.core.annotation.Generated("2012-03-14 21:21")
    public String filterDefines() {
        return "cmn.menuFilterItems";
    }

    
    @com.kingnod.core.annotation.Generated("2012-03-14 21:21")
    protected Object getEntityService() {
        return this.menuService;
    }
}