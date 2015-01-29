package com.kingnod.etraining.organization.action;

import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.extensions.struts2.action.EntityAction;
import com.kingnod.core.extensions.struts2.action.FilterableEntityAction;
import com.kingnod.etraining.organization.entity.UserPropertyOption;
import com.kingnod.etraining.organization.service.UserPropertyOptionService;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Controller
@Namespace("/org")
@Results( 
{
@Result(name = EntityAction.RELOAD, type = "redirectAction", params = { "actionName", "user-property-option", "namespace", "/org", "siteId", "${siteId}", "propertyId", "${propertyId}"})
}
)

    @com.kingnod.core.annotation.Generated("2012-02-15 21:28")
public class UserPropertyOptionAction extends FilterableEntityAction<UserPropertyOption, Long> {

    @Autowired
    
    @com.kingnod.core.annotation.Generated("2012-02-15 21:28")
    private UserPropertyOptionService userPropertyOptionService;
    private Long siteId;
    private Long propertyId;

    
    public Long getSiteId() {
		return siteId;
	}


	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}


	public Long getPropertyId() {
		return propertyId;
	}


	public void setPropertyId(Long propertyId) {
		this.propertyId = propertyId;
	}


	@com.kingnod.core.annotation.Generated("2012-02-15 21:28")
    public String filterDefines() {
        return "org.userPropertyOptionFilterItems";
    }

    
    @com.kingnod.core.annotation.Generated("2012-02-15 21:28")
    protected Object getEntityService() {
        return this.userPropertyOptionService;
    }
    
    @Override
    protected void afterPreparedCriteriaBuilder(CriteriaBuilder cb) { 
    	cb.andEQ("propertyId", propertyId);
    }
}