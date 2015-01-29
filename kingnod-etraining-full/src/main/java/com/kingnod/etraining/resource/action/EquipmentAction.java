package com.kingnod.etraining.resource.action;

import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.extensions.struts2.action.EntityAction;
import com.kingnod.core.extensions.struts2.action.FilterableEntityAction;
import com.kingnod.etraining.resource.entity.Equipment;
import com.kingnod.etraining.resource.service.EquipmentService;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Controller
@Namespace("/res")
@Results( 
{
@Result(name = EntityAction.RELOAD, type = "redirectAction", params = { "actionName", "equipment", "namespace", "/res"})
}
)

    @com.kingnod.core.annotation.Generated("2012-02-12 11:06")
public class EquipmentAction extends FilterableEntityAction<Equipment, Long> {
    private Long folderId;
    
    @Autowired
    @com.kingnod.core.annotation.Generated("2012-02-12 11:06")
    private EquipmentService equipmentService;

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
    
    @com.kingnod.core.annotation.Generated("2012-02-12 11:06")
    public String filterDefines() {
        return "res.equipmentFilterItems";
    }

    
    @com.kingnod.core.annotation.Generated("2012-02-12 11:06")
    protected Object getEntityService() {
        return this.equipmentService;
    }
}