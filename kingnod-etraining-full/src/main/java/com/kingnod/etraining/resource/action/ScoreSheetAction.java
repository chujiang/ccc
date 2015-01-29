package com.kingnod.etraining.resource.action;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.extensions.struts2.action.EntityAction;
import com.kingnod.core.extensions.struts2.action.FilterableEntityAction;
import com.kingnod.etraining.resource.entity.ScoreSheet;
import com.kingnod.etraining.resource.service.ScoreSheetService;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Controller
@Namespace("/res")
@Results( 
{
@Result(name = EntityAction.RELOAD, type = "redirectAction", params = { "actionName", "score-sheet", "namespace", "/res","folderId", "${folderId}"})
}
)

    @com.kingnod.core.annotation.Generated("2012-02-22 15:44")
public class ScoreSheetAction extends FilterableEntityAction<ScoreSheet, Long> {

    @Autowired
    
    @com.kingnod.core.annotation.Generated("2012-02-22 15:44")
    private ScoreSheetService scoreSheetService;
    private Long folderId;

    @com.kingnod.core.annotation.Generated("2012-02-22 15:44")
    public Long getFolderId() {
		return folderId;
	}

    @com.kingnod.core.annotation.Generated("2012-02-22 15:44")
	public void setFolderId(Long folderId) {
		this.folderId = folderId;
	}



    
    @com.kingnod.core.annotation.Generated("2012-02-22 15:44")
    public String filterDefines() {
        return "res.scoreSheetFilterItems";
    }

    
    @com.kingnod.core.annotation.Generated("2012-02-22 15:44")
    protected Object getEntityService() {
        return this.scoreSheetService;
    }
    
    
    @Override
    protected void preparedCriteriaBuilder(CriteriaBuilder cb) {
    	super.preparedCriteriaBuilder(cb);
    	cb.andGroup(Cnd.builder().andEQ("folderId", folderId));
    }
}