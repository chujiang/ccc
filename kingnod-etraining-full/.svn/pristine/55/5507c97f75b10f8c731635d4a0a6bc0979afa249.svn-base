package com.kingnod.etraining.resource.action;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.extensions.struts2.action.EntityAction;
import com.kingnod.core.extensions.struts2.action.FilterableEntityAction;
import com.kingnod.etraining.resource.entity.Trainer;
import com.kingnod.etraining.resource.service.TrainerService;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Controller
@Namespace("/res")
@Results( 
{
@Result(name = EntityAction.RELOAD, type = "redirectAction", params = { "actionName", "trainer", "namespace", "/res", "folderId", "${folderId}"})
}
)

    @com.kingnod.core.annotation.Generated("2012-02-13 12:55")
public class TrainerAction extends FilterableEntityAction<Trainer, Long> {

    @Autowired
    
    @com.kingnod.core.annotation.Generated("2012-02-13 12:55")
    private TrainerService trainerService;
    private Long folderId;

    
    public Long getFolderId() {
		return folderId;
	}


	public void setFolderId(Long folderId) {
		this.folderId = folderId;
	}


	@com.kingnod.core.annotation.Generated("2012-02-13 12:55")
    public String filterDefines() {
        return "res.trainerFilterItems";
    }

    
    @com.kingnod.core.annotation.Generated("2012-02-13 12:55")
    protected Object getEntityService() {
        return this.trainerService;
    }
    
    @Override
    protected void preparedCriteriaBuilder(CriteriaBuilder cb) {
    	super.preparedCriteriaBuilder(cb);
    	cb.andGroup(Cnd.builder().andEQ("folderId", folderId));
    }
}