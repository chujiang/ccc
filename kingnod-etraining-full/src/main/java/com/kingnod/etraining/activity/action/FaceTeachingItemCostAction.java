package com.kingnod.etraining.activity.action;

import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.extensions.struts2.action.EntityAction;
import com.kingnod.core.extensions.struts2.action.FilterableEntityAction;
import com.kingnod.etraining.activity.entity.FaceTeachingItemCost;
import com.kingnod.etraining.activity.service.FaceTeachingItemCostService;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Controller
@Namespace("/aty")
@Results( 
{
@Result(name = EntityAction.RELOAD, type = "redirectAction", params = { "actionName", "face-teaching-item-cost", "namespace", "/aty"})
}
)

@com.kingnod.core.annotation.Generated("2012-03-03 11:34")
public class FaceTeachingItemCostAction extends FilterableEntityAction<FaceTeachingItemCost, Long> {
	
	private Long faceTeachingItemId;
	
    public Long getFaceTeachingItemId() {
		return faceTeachingItemId;
	}

	public void setFaceTeachingItemId(Long faceTeachingItemId) {
		this.faceTeachingItemId = faceTeachingItemId;
	}

	@Override
	protected void preparedCriteriaBuilder(CriteriaBuilder cb) {
		super.preparedCriteriaBuilder(cb);
		cb.andEQ("faceTeachingItemId", faceTeachingItemId);
	}
	
	@Autowired
    @com.kingnod.core.annotation.Generated("2012-03-03 11:34")
    private FaceTeachingItemCostService faceTeachingItemCostService;
    
    @com.kingnod.core.annotation.Generated("2012-03-03 11:34")
    public String filterDefines() {
        return "aty.faceTeachingItemCostFilterItems";
    }
    
    @com.kingnod.core.annotation.Generated("2012-03-03 11:34")
    protected Object getEntityService() {
        return this.faceTeachingItemCostService;
    }
}