package com.kingnod.etraining.report.action;

import com.kingnod.core.extensions.struts2.action.EntityAction;
import com.kingnod.core.extensions.struts2.action.FilterableEntityAction;
import com.kingnod.etraining.report.entity.ReportFolder;
import com.kingnod.etraining.report.service.ReportFolderService;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Controller
@Namespace("/rpt")
@Results( 
{
@Result(name = EntityAction.RELOAD, type = "redirectAction", params = { "actionName", "report-folder", "namespace", "/rpt"})
}
)

    @com.kingnod.core.annotation.Generated("2012-05-11 10:26")
public class ReportFolderAction extends FilterableEntityAction<ReportFolder, Long> {

    @Autowired
    
    @com.kingnod.core.annotation.Generated("2012-05-11 10:26")
    private ReportFolderService reportFolderService;


    
    @com.kingnod.core.annotation.Generated("2012-05-11 10:26")
    public String filterDefines() {
        return "rpt.reportFolderFilterItems";
    }

    
    @com.kingnod.core.annotation.Generated("2012-05-11 10:26")
    protected Object getEntityService() {
        return this.reportFolderService;
    }
}