package com.kingnod.etraining.resource.action;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.extensions.struts2.action.EntityAction;
import com.kingnod.core.extensions.struts2.action.FilterableEntityAction;
import com.kingnod.etraining.resource.entity.AttendanceProject;
import com.kingnod.etraining.resource.service.AttendanceProjectService;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Controller
@Namespace("/res")
@Results( 
{
@Result(name = EntityAction.RELOAD, type = "redirectAction", params = { "actionName", "attendance-project", "namespace", "/res", "attendanceId", "${attendanceId}"})
}
)

    @com.kingnod.core.annotation.Generated("2012-02-17 16:02")
public class AttendanceProjectAction extends FilterableEntityAction<AttendanceProject, Long> {

    @Autowired
    
    @com.kingnod.core.annotation.Generated("2012-02-17 16:02")
    private AttendanceProjectService attendanceProjectService;
    private Long attendanceId;


    
    public Long getAttendanceId() {
		return attendanceId;
	}


	public void setAttendanceId(Long attendanceId) {
		this.attendanceId = attendanceId;
	}


	@com.kingnod.core.annotation.Generated("2012-02-17 16:02")
    public String filterDefines() {
        return "res.attendanceProjectFilterItems";
    }

    
    @com.kingnod.core.annotation.Generated("2012-02-17 16:02")
    protected Object getEntityService() {
        return this.attendanceProjectService;
    }
    
    @Override
    protected void preparedCriteriaBuilder(CriteriaBuilder cb) {
    	super.preparedCriteriaBuilder(cb);
    	cb.andGroup(Cnd.builder().andEQ("attendanceId", attendanceId));
    }
}