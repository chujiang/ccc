package com.kingnod.etraining.organization.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.criteria.Order;
import com.kingnod.core.exception.Exceptions;
import com.kingnod.core.extensions.struts2.action.EntityAction;
import com.kingnod.core.extensions.struts2.action.FilterableEntityAction;
import com.kingnod.core.extensions.struts2.annotation.ErrorMapping;
import com.kingnod.etraining.organization.entity.UserProperties;
import com.kingnod.etraining.organization.service.UserPropertiesService;

@org.springframework.stereotype.Controller
@Namespace("/org")
@Results( 
{
@Result(name = EntityAction.RELOAD, type = "redirectAction", params = { "actionName", "user-properties", "namespace", "/org", "siteId", "${siteId}"})
}
)

    @com.kingnod.core.annotation.Generated("2012-02-18 18:13")
public class UserPropertiesAction extends FilterableEntityAction<UserProperties, Long> {

	private static final long serialVersionUID = -8649264725638206553L;
	@Autowired
    @com.kingnod.core.annotation.Generated("2012-02-18 18:13")
    private UserPropertiesService userPropertiesService;


    
    @com.kingnod.core.annotation.Generated("2012-02-18 18:13")
    public String filterDefines() {
        return "org.userPropertiesFilterItems";
    }

    
    @com.kingnod.core.annotation.Generated("2012-02-18 18:13")
    protected Object getEntityService() {
        return this.userPropertiesService;
    }
    
    @Override
    protected void afterPreparedCriteriaBuilder(CriteriaBuilder cb) {
    	cb.andEQ("siteId", entity.getSiteId());
    	cb.orderBy("seq", Order.ASC);
    }
    
    /**
     * 处理  上移  下移  顶置  顶尾
     * @return
     */
    public String moveble() {
    	userPropertiesService.movebleUserProperties(this.getModel());
		return EntityAction.RELOAD;
    }
    
    
    /**
     * 保存
     */
    @ErrorMapping
    @Override
    public String save() throws Exception {
		CriteriaBuilder cb = Cnd.builder(UserProperties.class);
		cb.andEQ("name", entity.getName());
		cb.andEQ("siteId", entity.getSiteId());
		if (null != entity.getId()) {
			cb.andNotEQ("id", entity.getId());
		}
		List<UserProperties> properties = userPropertiesService.findUserProperties(cb.buildCriteria()).getResult();
		if (properties != null && properties.size() > 0) {	//相同站点下，属性名称不能重复
			throw Exceptions.createAppException("org001008");
		}
		return super.save();
    }
}