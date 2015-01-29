package com.kingnod.etraining.common.action;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.criteria.Order;
import com.kingnod.core.extensions.struts2.action.EntityAction;
import com.kingnod.core.extensions.struts2.action.FilterableEntityAction;
import com.kingnod.etraining.common.entity.Bulletin;
import com.kingnod.etraining.common.service.BulletinService;

@org.springframework.stereotype.Controller
@Namespace("/cmn")
@Results( 
{
@Result(name = EntityAction.RELOAD, type = "redirectAction", params = { "actionName", "bulletin", "namespace", "/cmn","objectId","${objectId}","objectType","${objectType}","typeId","${typeId}"})
}
)

    @com.kingnod.core.annotation.Generated("2012-04-21 11:11")
public class BulletinAction extends FilterableEntityAction<Bulletin, Long> {
	
private String objectId;
private String objectType;
private String typeId;

    @Autowired
    
    @com.kingnod.core.annotation.Generated("2012-04-21 11:11")
    private BulletinService bulletinService;

    
    public String getObjectId() {
		return objectId;
	}


	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}


	public String getObjectType() {
		return objectType;
	}


	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}
	


	public String getTypeId() {
		return typeId;
	}


	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}


	@com.kingnod.core.annotation.Generated("2012-04-21 11:11")
    public String filterDefines() {
        return "cmn.bulletinFilterItems";
    }

    
    @com.kingnod.core.annotation.Generated("2012-04-21 11:11")
    protected Object getEntityService() {
        return this.bulletinService;
    }


	/**
	 * 默认按照group_number（条件区标识）进行排序
	 */
	protected void preparedCriteriaBuilder(CriteriaBuilder cb) {
		super.preparedCriteriaBuilder(cb);
		cb.andEQ("objectType", objectType);
		cb.andEQ("objectId", objectId);
		cb.orderBy("updateDate", Order.DESC);
	}
}