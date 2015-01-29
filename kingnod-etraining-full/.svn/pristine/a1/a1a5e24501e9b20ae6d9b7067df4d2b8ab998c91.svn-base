package com.kingnod.etraining.resource.action;

import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.extensions.struts2.action.EntityAction;
import com.kingnod.core.extensions.struts2.action.FilterableEntityAction;
import com.kingnod.etraining.activity.entity.TrainingPlan;
import com.kingnod.etraining.resource.entity.Location;
import com.kingnod.etraining.resource.service.LocationService;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Controller
@Namespace("/res")
@Results( 
{
@Result(name = EntityAction.RELOAD, type = "redirectAction", params = { "actionName", "location", "namespace", "/res"})
}
)

    @com.kingnod.core.annotation.Generated("2012-02-10 18:41")
public class LocationAction extends FilterableEntityAction<Location, Long> {
private Long folderId;

    @Autowired
    
    @com.kingnod.core.annotation.Generated("2012-02-10 18:41")
    private LocationService locationService;

      public Long getFolderId(){
        return folderId;
      }
      public void setFolderId(Long folderId){
        this.folderId=folderId;
      }
      @Override 
      protected void preparedCriteriaBuilder(CriteriaBuilder cb){
        super.preparedCriteriaBuilder(cb);
        cb.andEQ("folderId",folderId);
      }

    
    @com.kingnod.core.annotation.Generated("2012-02-10 18:41")
    public String filterDefines() {
        return "res.locationFilterItems";
    }

    
    @com.kingnod.core.annotation.Generated("2012-02-10 18:41")
    protected Object getEntityService() {
        return this.locationService;
    }
}