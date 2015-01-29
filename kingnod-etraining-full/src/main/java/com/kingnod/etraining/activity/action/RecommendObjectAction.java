package com.kingnod.etraining.activity.action;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.extensions.struts2.action.EntityAction;
import com.kingnod.core.extensions.struts2.action.FilterableEntityAction;
import com.kingnod.etraining.activity.entity.RecommendObject;
import com.kingnod.etraining.activity.service.RecommendObjectService;

@org.springframework.stereotype.Controller
@Namespace("/aty")
@Results( 
{
@Result(name = EntityAction.RELOAD, type = "redirectAction", params = { "actionName", "recommend-object", "namespace", "/aty", "siteId", "${siteId}","flagType","${flagType}"})
}
)

    @com.kingnod.core.annotation.Generated("2012-04-21 12:48")
public class RecommendObjectAction extends FilterableEntityAction<RecommendObject, Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long  siteId;
	private String flagType;
	
    public String getFlagType() {
		return flagType;
	}


	public void setFlagType(String flagType) {
		this.flagType = flagType;
	}


	public Long getSiteId() {
		return siteId;
	}


	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}


	@Autowired
    
    @com.kingnod.core.annotation.Generated("2012-04-21 12:48")
    private RecommendObjectService recommendObjectService;


    
    @com.kingnod.core.annotation.Generated("2012-04-21 12:48")
    public String filterDefines() {
        return "aty.recommendObjectFilterItems";
    }

    
    @com.kingnod.core.annotation.Generated("2012-04-21 12:48")
    protected Object getEntityService() {
        return this.recommendObjectService;
    }
    
    @Override
    protected void afterPreparedCriteriaBuilder(CriteriaBuilder cb) {
    	 cb.andEQ("siteId", siteId);
    	 cb.andEQ("flagType", flagType);
    }
}