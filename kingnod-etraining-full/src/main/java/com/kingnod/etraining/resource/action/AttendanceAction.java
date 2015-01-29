package com.kingnod.etraining.resource.action;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.extensions.struts2.action.EntityAction;
import com.kingnod.core.extensions.struts2.action.FilterableEntityAction;
import com.kingnod.etraining.resource.entity.Attendance;
import com.kingnod.etraining.resource.service.AttendanceService;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Controller
@Namespace("/res")
@Results( 
{
@Result(name = EntityAction.RELOAD, type = "redirectAction", params = { "actionName", "attendance", "namespace", "/res", "folderId", "${folderId}"})
}
)

    @com.kingnod.core.annotation.Generated("2012-02-16 15:57")
public class AttendanceAction extends FilterableEntityAction<Attendance, Long> {

    @Autowired
    
    @com.kingnod.core.annotation.Generated("2012-02-16 15:57")
    private AttendanceService attendanceService;
    private Long folderId;

    
    public Long getFolderId() {
		return folderId;
	}


	public void setFolderId(Long folderId) {
		this.folderId = folderId;
	}


    
    @com.kingnod.core.annotation.Generated("2012-02-16 15:57")
    public String filterDefines() {
        return "res.attendanceFilterItems";
    }

    
    @com.kingnod.core.annotation.Generated("2012-02-16 15:57")
    protected Object getEntityService() {
        return this.attendanceService;
    }
    
    @Override
    protected void preparedCriteriaBuilder(CriteriaBuilder cb) {
    	super.preparedCriteriaBuilder(cb);
    	cb.andGroup(Cnd.builder().andEQ("folderId", folderId));
    }
}