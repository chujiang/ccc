package com.kingnod.etraining.common.ui.components;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.ClosingUIBean;
import org.apache.struts2.views.annotations.StrutsTag;

import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.util.collection.ListUtils;
import com.kingnod.core.util.collection.MapUtils;
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

/**
 * Title: <br>
 * Description:<br>
 * @author tanxiaodan
 */
@StrutsTag(name = "objectLocation", tldTagClass = "com.kingnod.etraining.common.ui.tags.ObjectLocationTag", description = "这个标签用于创建一个ObjectLocation")
public class ObjectLocation extends ClosingUIBean {
	
	
	private static final String OPEN_TEMPLATE = "objectLocation.ftl";
	
	private static final String TEMPLATE = "objectLocation-close.ftl";
	
	protected ObjectType objectType;
	protected Long objectId;
	protected String objectName;
	
	public ObjectLocation(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
		super(stack, request, response);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void evaluateParams() {
		super.evaluateParams();
		List<Object> result = TreeViewUtils.getNavigationItems(objectType, objectId);
		Collections.reverse(result);
		List<Map> objects = new ArrayList<Map>();
		
		if (!ListUtils.isEmpty(result)) {
			for (Object object : result) {
				if (null == object) {
					continue;
				}
				
				Map map = MapUtils.newMap();
				if (object instanceof IdEntity) {//获取ID
					map.put("objectId", ((IdEntity)object).getId());
				}
				/* 根据不同的实体类型，返回相应的类型编码与实体名称 */
				if (object instanceof Organization) {
					map.put("objectType", ObjectType.O_OO);
					map.put("name", ((Organization) object).getName());
				} else if (object instanceof Site) {
					map.put("objectType", ObjectType.O_OS);
					map.put("name", ((Site) object).getName());
				} else if (object instanceof User) {
					map.put("objectType", ObjectType.O_OU);
					map.put("name", ((User) object).getFullName());
				} else if (object instanceof ResourceFolder) {
					ResourceFolder resFolder = (ResourceFolder) object;
					map.put("objectType", resFolder.getType());
					map.put("name", resFolder.getName());
				} else if (object instanceof ActivityFolder) {
					ActivityFolder resFolder = (ActivityFolder) object;
					map.put("objectType", resFolder.getType());
					map.put("name", resFolder.getName());
				} else if (object instanceof ScoreSheet) {
					ScoreSheet scoreSheet = (ScoreSheet) object;
					map.put("objectType", ObjectType.R_AL);
					map.put("name", scoreSheet.getName());
				} else if (object instanceof Knowledge) {
					Knowledge knowledge = (Knowledge) object;
					map.put("objectType", ObjectType.R_ZZ);
					map.put("name", knowledge.getName());
				}
				
				/* 要跟踪下，不知道这一句是什么意思 */
				map.put("src", TreeViewUtils.getSrcPath(object));
				
				objects.add(map);
			}
		}
		
		this.addParameter("objectName", objectName);
		this.addParameter("objectList", objects);
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

	public String getObjectName() {
		return objectName;
	}

	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}
}
