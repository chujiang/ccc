package com.kingnod.etraining.activity.action;

import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.extensions.struts2.action.EntityAction;
import com.kingnod.core.extensions.struts2.action.FilterableEntityAction;
import com.kingnod.etraining.activity.entity.FaceTeachingItem;
import com.kingnod.etraining.activity.service.FaceTeachingItemService;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Controller
@Namespace("/aty")
@Results( 
{
@Result(name = EntityAction.RELOAD, type = "redirectAction", params = { "actionName", "face-teaching-item", "namespace", "/aty"})
}
)

    @com.kingnod.core.annotation.Generated("2012-03-03 11:28")
public class FaceTeachingItemAction extends FilterableEntityAction<FaceTeachingItem, Long> {

	private Long faceTeachingId;

	public Long getFaceTeachingId() {
		return faceTeachingId;
	}

	public void setFaceTeachingId(Long faceTeachingId) {
		this.faceTeachingId = faceTeachingId;
	}

	@Override
	protected void preparedCriteriaBuilder(CriteriaBuilder cb) {
		super.preparedCriteriaBuilder(cb);
		cb.andEQ("faceTeachingId", faceTeachingId);
	}
	
    @Autowired
    @com.kingnod.core.annotation.Generated("2012-03-03 11:28")
    private FaceTeachingItemService faceTeachingItemService;


    
    @com.kingnod.core.annotation.Generated("2012-03-03 11:28")
    public String filterDefines() {
        return "aty.faceTeachingItemFilterItems";
    }

    
    @com.kingnod.core.annotation.Generated("2012-03-03 11:28")
    protected Object getEntityService() {
        return this.faceTeachingItemService;
    }
}