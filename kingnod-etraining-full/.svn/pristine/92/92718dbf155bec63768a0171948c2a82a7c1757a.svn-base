package com.kingnod.etraining.resource.action;

import java.util.List;

import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.extensions.struts2.action.EntityAction;
import com.kingnod.core.extensions.struts2.action.FilterableEntityAction;
import com.kingnod.etraining.resource.entity.ScoreRelation;
import com.kingnod.etraining.resource.service.ScoreRelationService;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Controller
@Namespace("/res")
@Results( 
{
@Result(name = EntityAction.RELOAD, type = "redirectAction", params = { "actionName", "score-relation", "namespace", "/res","scoreSheetId" ,"${scoreSheetId}" })
}
)

    @com.kingnod.core.annotation.Generated("2012-02-27 17:33")
	public class ScoreRelationAction extends FilterableEntityAction<ScoreRelation, Long> {
	private long scoreSheetId;

    @Autowired
    
    @com.kingnod.core.annotation.Generated("2012-02-27 17:33")
    private ScoreRelationService scoreRelationService;

	public long getScoreSheetId(){
	  return scoreSheetId;
	}
	public void setScoreSheetId(long scoreSheetId){
	  this.scoreSheetId=scoreSheetId;
	}
	
	@Override protected void afterPreparedCriteriaBuilder(CriteriaBuilder cb){
	  cb.andEQ("scoreSheetId",scoreSheetId);
	}

    
    @com.kingnod.core.annotation.Generated("2012-02-27 17:33")
    public String filterDefines() {
        return "res.scoreRelationFilterItems";
    }

    
    @com.kingnod.core.annotation.Generated("2012-02-27 17:33")
    protected Object getEntityService() {
        return this.scoreRelationService;
    }
    
}