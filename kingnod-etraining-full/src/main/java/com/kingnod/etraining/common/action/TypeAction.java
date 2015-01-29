package com.kingnod.etraining.common.action;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JsonConfig;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.entity.RecordStatus;
import com.kingnod.core.extensions.struts2.action.EntityAction;
import com.kingnod.core.extensions.struts2.action.FilterableEntityAction;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.core.util.web.Struts2Utils;
import com.kingnod.etraining.common.entity.Type;
import com.kingnod.etraining.common.service.TypeService;
import com.kingnod.etraining.common.tree.TreeViewUtils;

@org.springframework.stereotype.Controller
@Namespace("/cmn")
@Results( 
{
@Result(name = EntityAction.RELOAD, type = "redirectAction", params = { "actionName", "type", "namespace", "/cmn", "curSite", "${curSite}", "parentId", "${parentId}"})
}
)

    @com.kingnod.core.annotation.Generated("2012-04-18 03:28")
public class TypeAction extends FilterableEntityAction<Type, Long> {

    @Autowired
    
    @com.kingnod.core.annotation.Generated("2012-04-18 03:28")
    private TypeService typeService;
    
    private Long curSite;

	public Long getCurSite() {
		return curSite;
	}

	public void setCurSite(Long curSite) {
		this.curSite = curSite;
	}


	@com.kingnod.core.annotation.Generated("2012-04-18 03:28")
    public String filterDefines() {
        return "cmn.typeFilterItems";
    }

    
    @com.kingnod.core.annotation.Generated("2012-04-18 03:28")
    protected Object getEntityService() {
        return this.typeService;
    }
    
    @Override
    public String execute() throws Exception {
    	if(null == this.entity.getParentId()){
    		this.entity.setParentId(-1L);
    	}
    	 super.execute();
    	 for(Type type:getPager().getResult()){
    		 if(!type.getSiteId().equals(curSite)){
    			 type.setName(type.getName() + "(被继承的)");
    		 }
    	 }
    	 return SUCCESS;
    }
    
   @Override
   protected void afterPreparedCriteriaBuilder(CriteriaBuilder cb) {
	   cb.andEQ("parentId", this.entity.getParentId()==null?-1L:this.entity.getParentId());
   }
   
   @Override
   protected Map preparedCriteriaParams() {
	   Map params = new HashMap();
	   params.put("visibleInherited", true);
	   params.put("siteId", curSite);
	   return params;
   }
   
	@Override
	public String save() throws Exception {
		Type parentType = typeService.getType(this.entity.getParentId());
		this.entity.setSiteId(curSite);
		this.entity.setObjectType(this.entity.getObjectType());
		this.entity.setRoot(false);
		this.entity.setChildLevel((short) (parentType.getChildLevel() - 1));
		if (this.entity.getInheritAble() == null) {
			this.entity.setInheritAble(false);
		}
		super.save();
		return RELOAD;
	}
	
	public String tree() throws Exception {
		Type parentType = typeService.getType(this.entity.getParentId());
		CriteriaBuilder cb = Cnd.builder(Type.class);
		cb.andEQ("objectType", parentType.getObjectType()).andEQ("recordStatus", RecordStatus.ACTIVE).andGT("childLevel", 0);
		Criteria criteria = cb.buildCriteria();
		criteria.addParam("siteId", curSite);
		PagingResult<Type> listType = typeService.findType(criteria);
		
		JsonConfig jsonconfig = new JsonConfig();
		jsonconfig.registerJsonBeanProcessor(Type.class, TreeViewUtils.viewTypeListProcessor);
		
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonRoot", listType.getResult());
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonconfig", jsonconfig);
		return "jsonResult";
	}
}