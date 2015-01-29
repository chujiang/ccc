package com.kingnod.etraining.common.action;

import com.kingnod.core.extensions.struts2.action.EntityAction;
import com.kingnod.core.extensions.struts2.action.FilterableEntityAction;
import com.kingnod.etraining.common.entity.NoticeSettings;
import com.kingnod.etraining.common.service.NoticeSettingsService;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Controller
@Namespace("/cmn")
@Results( 
{
@Result(name = EntityAction.RELOAD, type = "redirectAction", params = { "actionName", "notice-settings", "namespace", "/cmn"})
}
)

    @com.kingnod.core.annotation.Generated("2012-05-15 17:11")
public class NoticeSettingsAction extends FilterableEntityAction<NoticeSettings, Long> {

    @Autowired
    
    @com.kingnod.core.annotation.Generated("2012-05-15 17:11")
    private NoticeSettingsService noticeSettingsService;


    
    @com.kingnod.core.annotation.Generated("2012-05-15 17:11")
    public String filterDefines() {
        return "cmn.noticeSettingsFilterItems";
    }

    
    @com.kingnod.core.annotation.Generated("2012-05-15 17:11")
    protected Object getEntityService() {
        return this.noticeSettingsService;
    }
}