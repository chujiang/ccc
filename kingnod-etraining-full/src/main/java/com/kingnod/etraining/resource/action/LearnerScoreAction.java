package com.kingnod.etraining.resource.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.extensions.struts2.action.EntityAction;
import com.kingnod.core.extensions.struts2.action.FilterableEntityAction;
import com.kingnod.core.util.collection.MapUtils;
import com.kingnod.etraining.resource.entity.LearnerScore;
import com.kingnod.etraining.resource.entity.ScoreRelation;
import com.kingnod.etraining.resource.entity.ScoreSheet;
import com.kingnod.etraining.resource.service.LearnerScoreService;
import com.kingnod.etraining.resource.service.ScoreRelationService;

@org.springframework.stereotype.Controller
@Namespace("/res")
@Results( 
{
@Result(name = EntityAction.RELOAD, type = "redirectAction", params = { "actionName", "learner-score", "namespace", "/res","scoreSheetId" ,"${scoreSheetId}" })
}
)

    @com.kingnod.core.annotation.Generated("2012-02-24 10:44")
public class LearnerScoreAction extends FilterableEntityAction<LearnerScore, Long> {

    @Autowired
    
    @com.kingnod.core.annotation.Generated("2012-02-24 10:44")
    private LearnerScoreService learnerScoreService;
    
    @Autowired
    @com.kingnod.core.annotation.Generated("2012-02-24 10:44")
    private ScoreRelationService scoreRelationService;
    public long getScoreSheetId() {
		return scoreSheetId;
	}


	public void setScoreSheetId(long scoreSheetId) {
		this.scoreSheetId = scoreSheetId;
	}

	private long scoreSheetId;


    @com.kingnod.core.annotation.Generated("2012-02-24 10:44")
    public String filterDefines() {
        return "res.learnerScoreFilterItems";
    }

    
    @com.kingnod.core.annotation.Generated("2012-02-24 10:44")
    protected Object getEntityService() {
        return this.learnerScoreService;
    }
    
    @Override
    protected void afterPreparedCriteriaBuilder(CriteriaBuilder cb) {    	
    	cb.andEQ("scoreSheetId", scoreSheetId);
    	List scoreSheet = scoreRelationService.findByLearnerScoreId(scoreSheetId);
    	for(int i = 0; i < scoreSheet.size(); i++)
    	{
    		((ScoreRelation)scoreSheet.get(i)).setColumnName(((ScoreRelation)scoreSheet.get(i)).getColumnName() 
    				+ "(" + ((ScoreRelation)scoreSheet.get(i)).getScorePercentage() + "%" + ")");
    	}
    	request.setAttribute("scoreSheet", scoreSheet);
    }
    
    @Override
    public String input() throws Exception
    {
    	List scoreSheet = scoreRelationService.findByLearnerScoreId(scoreSheetId);
    	request.setAttribute("scoreSheet", scoreSheet);
    	return INPUT;
    }
}