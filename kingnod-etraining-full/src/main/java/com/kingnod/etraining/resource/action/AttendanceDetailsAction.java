package com.kingnod.etraining.resource.action;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.extensions.struts2.action.EntityAction;
import com.kingnod.core.extensions.struts2.action.FilterableEntityAction;
import com.kingnod.etraining.resource.entity.AttendanceDetails;
import com.kingnod.etraining.resource.service.AttendanceDetailsService;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Controller
@Namespace("/res")
@Results( 
{
@Result(name = EntityAction.RELOAD, type = "redirectAction", params = { "actionName", "attendance-details", "namespace", "/res", "attendanceProjectId" ,"${attendanceProjectId}"})
}
)

    @com.kingnod.core.annotation.Generated("2012-02-17 19:00")
public class AttendanceDetailsAction extends FilterableEntityAction<AttendanceDetails, Long> {

    @Autowired
    
    @com.kingnod.core.annotation.Generated("2012-02-17 19:00")
    private AttendanceDetailsService attendanceDetailsService;
    private long attendanceProjectId;
    

    
    public long getAttendanceProjectId() {
		return attendanceProjectId;
	}


	public void setAttendanceProjectId(long attendanceProjectId) {
		this.attendanceProjectId = attendanceProjectId;
	}


	@com.kingnod.core.annotation.Generated("2012-02-17 19:00")
    public String filterDefines() {
        return "res.attendanceDetailsFilterItems";
    }

    
    @com.kingnod.core.annotation.Generated("2012-02-17 19:00")
    protected Object getEntityService() {
        return this.attendanceDetailsService;
    }
    
    @Override
    protected void preparedCriteriaBuilder(CriteriaBuilder cb) {
    	super.preparedCriteriaBuilder(cb);
    	cb.andGroup(Cnd.builder().andEQ("attendanceProjectId", attendanceProjectId));
    }
}