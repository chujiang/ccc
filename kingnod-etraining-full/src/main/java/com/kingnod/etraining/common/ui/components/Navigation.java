package com.kingnod.etraining.common.ui.components;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.ClosingUIBean;
import org.apache.struts2.views.annotations.StrutsTag;

import com.kingnod.core.entity.IdEntity;
import com.kingnod.etraining.activity.entity.ActivityFolder;
import com.kingnod.etraining.common.ObjectType;
import com.kingnod.etraining.common.tree.TreeViewUtils;
import com.kingnod.etraining.exam.entity.Knowledge;
import com.kingnod.etraining.organization.entity.Organization;
import com.kingnod.etraining.organization.entity.Site;
import com.kingnod.etraining.organization.entity.User;
import com.kingnod.etraining.resource.entity.ResourceFolder;
import com.kingnod.etraining.resource.entity.ScoreSheet;
import com.opensymphony.xwork2.util.ValueStack;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

@StrutsTag(name = "navigation", tldTagClass = "com.kingnod.etraining.common.ui.tags.NavigationTag", description = "这个标签用于创建一个navigation")
public class Navigation extends ClosingUIBean {

	private static final Logger LOG = LoggerFactory.getLogger(Navigation.class);
	public static final String OPEN_TEMPLATE = "navigation";
	public static final String TEMPLATE = "navigation-close";
	public static final String COMPONENT_NAME = Navigation.class.getName();
	protected ObjectType objectType;
	protected Long objectId;

	public Navigation(ValueStack stack, HttpServletRequest req, HttpServletResponse res) {
		super(stack, req, res);
	}
	
	@Override
	public void evaluateParams() {
		super.evaluateParams();
		List<Object> result = TreeViewUtils.getNavigationItems(objectType, objectId);
		java.util.Collections.reverse(result);
		List<Map> objectTypes = new ArrayList<Map>();
		for(Object object:result){
			if(null == object)continue;
			Map map = new HashMap();
			if(object instanceof IdEntity){
				map.put("objectId", ((IdEntity)object).getId());
			}
			if(object instanceof Organization){
				map.put("objectType", ObjectType.O_OO);
				map.put("name", ((Organization)object).getName());
			}else if(object instanceof Site){
				map.put("objectType", ObjectType.O_OS);
				map.put("name", ((Site)object).getName());
			}else if(object instanceof User){
				map.put("objectType", ObjectType.O_OU);
				map.put("name", ((User)object).getFullName());
			}else if(object instanceof ResourceFolder){
				ResourceFolder resFolder = (ResourceFolder)object;
				map.put("objectType", resFolder.getType());
				map.put("name", resFolder.getName());
			}else if(object instanceof ActivityFolder){
				ActivityFolder resFolder = (ActivityFolder)object;
				map.put("objectType", resFolder.getType());
				map.put("name", resFolder.getName());
			}
			else if(object instanceof ScoreSheet){
				ScoreSheet scoreSheet = (ScoreSheet)object;
				map.put("objectType", ObjectType.R_AL);
				map.put("name", scoreSheet.getName());
			}else if(object instanceof Knowledge){
				Knowledge knowledge = (Knowledge)object;
				map.put("objectType", ObjectType.R_ZZ);
				map.put("name", knowledge.getName());
			}
			map.put("src", TreeViewUtils.getSrcPath(object));
			objectTypes.add(map);
		}
		this.addParameter("objectList", objectTypes);
	}

	public String getDefaultOpenTemplate() {
		return OPEN_TEMPLATE;
	}

	protected String getDefaultTemplate() {
		return TEMPLATE;
	}

	public String getTemplateDir() {
		return "com/kingnod/etraining/common/ui/views";
	}

	public String getTheme() {
		return "kingnod";
	}
	
	public void setObjectType(ObjectType objectType) {
		this.objectType = objectType;
	}

	public void setObjectId(Long objectId) {
		this.objectId = objectId;
	}
	
	

}
