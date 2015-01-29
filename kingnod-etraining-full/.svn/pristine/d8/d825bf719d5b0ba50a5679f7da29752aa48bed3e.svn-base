package com.kingnod.etraining.common.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonBeanProcessor;

import org.apache.commons.lang.xwork.StringUtils;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.criteria.Order;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.entity.RecordStatus;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.core.util.SpringUtils;
import com.kingnod.core.util.SysParameterUtils;
import com.kingnod.core.util.TemplateUtils;
import com.kingnod.core.util.collection.ListUtils;
import com.kingnod.core.util.web.Struts2Utils;
import com.kingnod.etraining.activity.dao.ActivityFolderDAO;
import com.kingnod.etraining.activity.entity.ActivityDetails;
import com.kingnod.etraining.activity.entity.ActivityFolder;
import com.kingnod.etraining.activity.service.ActivityFolderService;
import com.kingnod.etraining.common.CommonConstant;
import com.kingnod.etraining.common.ObjectType;
import com.kingnod.etraining.common.dao.MenuDAO;
import com.kingnod.etraining.common.dao.TypeDAO;
import com.kingnod.etraining.common.entity.Menu;
import com.kingnod.etraining.common.entity.Type;
import com.kingnod.etraining.common.ui.components.ContextMenu;
import com.kingnod.etraining.common.ui.components.TreeNode;
import com.kingnod.etraining.course.entity.CourseInfo;
import com.kingnod.etraining.course.entity.ItemInfo;
import com.kingnod.etraining.exam.dao.KnowledgeDAO;
import com.kingnod.etraining.exam.entity.Knowledge;
import com.kingnod.etraining.exam.entity.Paper;
import com.kingnod.etraining.organization.dao.OrganizationDAO;
import com.kingnod.etraining.organization.dao.SiteDAO;
import com.kingnod.etraining.organization.dao.UserDAO;
import com.kingnod.etraining.organization.entity.Organization;
import com.kingnod.etraining.organization.entity.Site;
import com.kingnod.etraining.organization.entity.User;
import com.kingnod.etraining.organization.entity.UserGroup;
import com.kingnod.etraining.organization.service.OrganizationService;
import com.kingnod.etraining.report.entity.ReportFolder;
import com.kingnod.etraining.resource.dao.ResourceFolderDAO;
import com.kingnod.etraining.resource.dao.ScoreSheetDAO;
import com.kingnod.etraining.resource.entity.ResourceFolder;
import com.kingnod.etraining.resource.entity.ScoreSheet;
import com.kingnod.etraining.resource.service.ResourceFolderService;
import com.kingnod.etraining.security.PermisssionService;

public class TreeViewUtils {

	
	public static JsonBeanProcessor basicSiteProcessor;
	public static JsonBeanProcessor basicUserGroupProcessor;
	public static JsonBeanProcessor viewSiteProcessor;
	public static JsonBeanProcessor menuProcessor;
	public static JsonBeanProcessor basicOrganizationProcessor;
	public static JsonBeanProcessor viewOrganizationProcessor;
	public static JsonBeanProcessor basicUserProcessor;
	public static JsonBeanProcessor basicResFolderProcessor;
	public static JsonBeanProcessor basicCategoryProcessor;
	public static JsonBeanProcessor pickerResFolderProcessor;
	public static JsonBeanProcessor basicCourseProcessor;
	public static JsonBeanProcessor basicKnowledgeProcessor; // 处理知识点
	public static JsonBeanProcessor basicPaperProcessor; // 处理试卷
	public static JsonBeanProcessor viewResFolderProcessor;
	public static JsonBeanProcessor viewCourseCategoryProcessor;
	public static JsonBeanProcessor basicAtyFolderProcessor;
	public static JsonBeanProcessor viewAtyFolderProcessor;
	
	public static JsonBeanProcessor basicActivityDetailsProcessor;
	
	public static JsonBeanProcessor viewCourseScoProcessor;
	public static JsonBeanProcessor viewListCourseScoProcessor;
	
	public static JsonBeanProcessor viewTypeProcessor;
	public static JsonBeanProcessor viewTypeListProcessor;
	
	public static JsonBeanProcessor basicRptFolderProcessor;
	
	public static JsonBeanProcessor viewRptFolderProcessor;
	static {
		
		basicSiteProcessor = new JsonBeanProcessor() {
			public JSONObject processBean(Object bean, JsonConfig jsonConfig) {
				Site entity = (Site) bean;
				JSONObject jsonObj = new JSONObject();
				siteBasicPropertyProcessor(entity, jsonObj);
				return jsonObj;
			}
		};
		viewSiteProcessor = new JsonBeanProcessor() {
			public JSONObject processBean(Object bean, JsonConfig jsonConfig) {
				Site entity = (Site) bean;
				JSONObject jsonObj = new JSONObject(); 
				siteBasicPropertyProcessor(entity, jsonObj);
				siteClickPropertyProcessor(entity, jsonObj);
				siteMenuPropertyProcessor(entity, jsonObj,"SMenu");
				return jsonObj;
			}
		};
		menuProcessor = new JsonBeanProcessor() {
			public JSONObject processBean(Object bean, JsonConfig jsonConfig) {
				Menu entity = (Menu) bean;
				JSONObject jsonObj = new JSONObject();
				menuProcessor(entity, jsonObj);
				return jsonObj;
			}
		};
		basicOrganizationProcessor = new JsonBeanProcessor() {
			public JSONObject processBean(Object bean, JsonConfig jsonConfig) {
				Organization entity = (Organization) bean;
				JSONObject jsonObj = new JSONObject();
				orgBasicPropertyProcessor(entity, jsonObj);
				return jsonObj;
			}
		};
		viewOrganizationProcessor = new JsonBeanProcessor() {
			public JSONObject processBean(Object bean, JsonConfig jsonConfig) {
				Organization entity = (Organization) bean;
				JSONObject jsonObj = new JSONObject();
				orgBasicPropertyProcessor(entity, jsonObj);
				orgClickPropertyProcessor(entity, jsonObj);
				siteMenuPropertyProcessor(entity, jsonObj,"OMenu");
				return jsonObj;
			}
		};
		basicUserProcessor = new JsonBeanProcessor() {
			public JSONObject processBean(Object bean, JsonConfig jsonConfig) {
				User entity = (User) bean;
				JSONObject jsonObj = new JSONObject();
				userBasicPropertyProcessor(entity, jsonObj);
				return jsonObj;
			}
		};
		basicUserGroupProcessor = new JsonBeanProcessor() {
			public JSONObject processBean(Object bean, JsonConfig jsonConfig) {
				UserGroup entity = (UserGroup) bean;
				JSONObject jsonObj = new JSONObject();
				userGroupBasicPropertyProcessor(entity, jsonObj);
				return jsonObj;
			}
		};
		basicResFolderProcessor = new JsonBeanProcessor() {
			public JSONObject processBean(Object bean, JsonConfig jsonConfig) {
				ResourceFolder entity = (ResourceFolder) bean;
				JSONObject jsonObj = new JSONObject();
				resFolderBasicPropertyProcessor(entity, jsonObj);
				return jsonObj;
			}
		};
		basicCategoryProcessor = new JsonBeanProcessor() {
			public JSONObject processBean(Object bean, JsonConfig jsonConfig) {
				ResourceFolder entity = (ResourceFolder) bean;
				JSONObject jsonObj = new JSONObject();
				resCategoryBasicPropertyProcessor(entity, jsonObj);
				return jsonObj;
			}
		};
		
		pickerResFolderProcessor = new JsonBeanProcessor() {
			public JSONObject processBean(Object bean, JsonConfig jsonConfig) {
				ResourceFolder entity = (ResourceFolder) bean;
				JSONObject jsonObj = new JSONObject();
				resFolderPickerPropertyProcessor(entity, jsonObj);
				return jsonObj;
			}
		};
		viewResFolderProcessor = new JsonBeanProcessor() {
			public JSONObject processBean(Object bean, JsonConfig jsonConfig) {
				ResourceFolder entity = (ResourceFolder) bean;
				JSONObject jsonObj = new JSONObject();
				resFolderBasicPropertyProcessor(entity, jsonObj);
				resFolderClickPropertyProcessor(entity, jsonObj);
				resMenuPropertyProcessor(entity, jsonObj);
				return jsonObj;
			}
		};
		viewCourseCategoryProcessor = new JsonBeanProcessor() {
			public JSONObject processBean(Object bean, JsonConfig jsonConfig) {
				ResourceFolder entity = (ResourceFolder) bean;
				JSONObject jsonObj = new JSONObject();
				resFolderBasicPropertyProcessor(entity, jsonObj);
				viewCourseCategoryClickPropertyProcessor(entity, jsonObj);
				resMenuPropertyProcessorNoCheckPermission(entity, jsonObj);
				return jsonObj;
			}
		};
		basicCourseProcessor = new JsonBeanProcessor() {
			public JSONObject processBean(Object bean, JsonConfig jsonConfig) {
				CourseInfo entity = (CourseInfo) bean;
				JSONObject jsonObj = new JSONObject();
				courseBasicPropertyProcessor(entity, jsonObj);
				return jsonObj;
			}
		};
		basicKnowledgeProcessor = new JsonBeanProcessor() {
			public JSONObject processBean(Object bean, JsonConfig jsonConfig) {
				Knowledge entity = (Knowledge) bean;
				JSONObject jsonObj = new JSONObject();
				knowledgeBasicPropertyProcessor(entity, jsonObj);
				return jsonObj;
			}
		};
		basicPaperProcessor = new JsonBeanProcessor() {
			public JSONObject processBean(Object bean, JsonConfig jsonConfig) {
				Paper entity = (Paper) bean;
				JSONObject jsonObj = new JSONObject();
				paperBasicPropertyProcessor(entity, jsonObj);
				return jsonObj;
			}
		};
		basicAtyFolderProcessor = new JsonBeanProcessor() {
			public JSONObject processBean(Object bean, JsonConfig jsonConfig) {
				ActivityFolder entity = (ActivityFolder) bean;
				JSONObject jsonObj = new JSONObject();
				atyFolderBasicPropertyProcessor(entity, jsonObj);
				return jsonObj;
			}
		};
		viewAtyFolderProcessor = new JsonBeanProcessor() {
			public JSONObject processBean(Object bean, JsonConfig jsonConfig) {
				ActivityFolder entity = (ActivityFolder) bean;
				JSONObject jsonObj = new JSONObject();
				atyFolderBasicPropertyProcessor(entity, jsonObj);
				atyFolderClickPropertyProcessor(entity, jsonObj);
				resMenuPropertyProcessor(entity, jsonObj);
				return jsonObj;
			}
		};
		
		basicActivityDetailsProcessor = new JsonBeanProcessor() {
			public JSONObject processBean(Object bean, JsonConfig jsonConfig) {
				ActivityDetails entity = (ActivityDetails) bean;
				JSONObject jsonObj = new JSONObject();
				activityDetailsBasicPropertyProcessor(entity, jsonObj);
				return jsonObj;
			}
		};
		
		viewCourseScoProcessor = new JsonBeanProcessor() {
			public JSONObject processBean(Object bean, JsonConfig jsonConfig) {
				ItemInfo entity = (ItemInfo) bean;
				JSONObject jsonobj = new JSONObject();
				itemInfoPropertyProcessor(entity, jsonobj);
				return jsonobj;
			}
		};
		
		viewListCourseScoProcessor = new JsonBeanProcessor() {
			public JSONObject processBean(Object bean, JsonConfig jsonConfig) {
				ItemInfo entity = (ItemInfo) bean;
				JSONObject jsonobj = new JSONObject();
				itemInfoListPropertyProcessor(entity, jsonobj);
				return jsonobj;
			}
		};
		
		viewTypeListProcessor = new JsonBeanProcessor() {
			public JSONObject processBean(Object bean, JsonConfig jsonConfig) {
				Type entity = (Type) bean;
				JSONObject jsonobj = new JSONObject();
				typeListPropertyProcessor(entity, jsonobj);
				return jsonobj;
			}
		};
		
		viewTypeProcessor = new JsonBeanProcessor() {
			public JSONObject processBean(Object bean, JsonConfig jsonConfig) {
				Type entity = (Type) bean;
				JSONObject jsonobj = new JSONObject();
				typePropertyProcessor(entity, jsonobj);
				return jsonobj;
			}
		};
		
		basicRptFolderProcessor = new JsonBeanProcessor() {
			public JSONObject processBean(Object bean, JsonConfig jsonConfig) {
				ReportFolder entity = (ReportFolder) bean;
				JSONObject jsonObj = new JSONObject();
				rptFolderBasicPropertyProcessor(entity, jsonObj);
				return jsonObj;
			}
		};
		
		viewRptFolderProcessor = new JsonBeanProcessor() {
			public JSONObject processBean(Object bean, JsonConfig jsonConfig) {
				ReportFolder entity = (ReportFolder) bean;
				JSONObject jsonObj = new JSONObject();
				rptFolderBasicPropertyProcessor(entity, jsonObj);
				rptFolderClickPropertyProcessor(entity, jsonObj);
				resMenuPropertyProcessor(entity, jsonObj);
				return jsonObj;
			}
		};
	}
	
	protected static void typePropertyProcessor(Type entity, JSONObject jsonObj){
		jsonObj.element("id", entity.getId())
		.element("pId", entity.getParentId())
		.element("name", entity.getName())
		.element("isRoot", false)
		.element("childNode", true)
		.element("editable", true)
		.element("isParent", false)
		.element("width", getTreeNodeInputEditWith())
		.element("icon", Struts2Utils.getRequest().getContextPath()+ "/img/tree/site.gif");
	}
	
	protected static void typeListPropertyProcessor(Type entity, JSONObject jsonObj){
		Object nodeType = Struts2Utils.getValueStack().findValue("nodeType");
		Object nodeId = Struts2Utils.getValueStack().findValue("id");
		
		//判断是否父节点，父节点和子节点，小图标不一样
		CriteriaBuilder orgCb2 = Cnd.builder(Type.class);
		orgCb2.andEQ("parentId", entity.getId()).andEQ("recordStatus",RecordStatus.ACTIVE);
		//orgCb2.orderBy("sequence", Order.ASC);
		int typesize = getTypeDAO().countByCriteria(orgCb2.buildCriteria());
		boolean isParent = typesize > 0 ? true : false;
		
		//if(StringUtils.EMPTY.equals(nodeType)){//根节点
			jsonObj.element("id", entity.getId())
			.element("pId", entity.getParentId())
			.element("inheritAble", entity.getInheritAble())
			.element("isRoot", entity.getRoot())
			.element("childLevel", entity.getChildLevel());
			if(entity.getInheritAble() && !entity.getRoot()){
				jsonObj.element("name", entity.getName() + "(继承的)");
			}else{
				jsonObj.element("name", entity.getName());
			}
			//.element("editable", false)//不可以编辑和删除
			//.element("isParent", isParent)//是否父节点，图标不一样
			//.element("width", getTreeNodeInputEditWith())
			//.element("icon", Struts2Utils.getRequest().getContextPath()+ "/img/tree/site.gif");
		/*}else if(nodeId != null && (Long.parseLong(nodeId.toString())) != 0){//子节点
			
			jsonObj.element("id", entity.getId())
			.element("pId", entity.getParentId())
			.element("name", entity.getName())
			.element("siteId", entity.getSiteId())
			.element("isRoot", true)
			.element("childNode", getChildLevel(entity))
			.element("editable", true)
			.element("isParent", isParent)
			.element("width", getTreeNodeInputEditWith())
			.element("icon", Struts2Utils.getRequest().getContextPath()+ "/img/tree/site.gif");
		}*/
	}
	
	public static boolean getChildLevel(Type type) {
		boolean childExist = true;
		if(type.getChildLevel() == 0){
			childExist = false;
		}
		return childExist;
	}
	
	protected static void itemInfoPropertyProcessor(ItemInfo entity, JSONObject jsonObj){
		jsonObj.element("id", entity.getId())
		.element("pId", entity.getItemParent())
		.element("name", entity.getItemTitle())
		.element("isParent", false)
		.element("childNode", false)
		.element("editable", true)
		.element("parentId", entity.getItemParent())
		.element("icon", Struts2Utils.getRequest().getContextPath()+"/img/tree/site.gif")
		.element("sequence", entity.getSequence())
		.element("launch", entity.getLaunch())
		.element("masteryScore", entity.getMasteryScore())
		.element("prerequisites", entity.getPrerequisites())
		.element("width", getTreeNodeInputEditWith())
		.element("description", entity.getItemDescription());
	}
	
	protected static void itemInfoListPropertyProcessor(ItemInfo entity, JSONObject jsonObj){
		boolean isRoot = false;
		boolean editable = true;
		if (entity.getItemParent() == null || entity.getItemParent().longValue() == 0) {
			isRoot = true;// 设置根节点不能拖拽
			editable = false;// 设置根节点不可以编辑和删除
		}
			
		jsonObj.element("id", entity.getId())
		.element("pId", entity.getItemParent())
		.element("open", true)
		.element("name", entity.getItemTitle())
		.element("isRoot", isRoot)
		.element("editable", editable)
		.element("nodeType", TreeNode.SITE)
		.element("childNode", true)
		//.element("icon", Struts2Utils.getRequest().getContextPath()+"/img/tree/site.gif")
		.element("sequence", entity.getSequence())
		.element("launch", entity.getLaunch())
		.element("masteryScore", entity.getMasteryScore())
		.element("prerequisites", entity.getPrerequisites())
		.element("width", getTreeNodeInputEditWith())
		.element("description", entity.getItemDescription());
	}
	
	protected static void siteBasicPropertyProcessor(Site entity, JSONObject jsonObj){
		jsonObj.element("id", entity.getId())
		.element("pId", entity.getParentId())
		.element("name", entity.getName())
		.element("isParent", true)
		.element("icon", getIconPath(ObjectType.O_OS.name()))
		.element("editable", true)
		.element("nodeType", ObjectType.O_OS);
	}
	
	protected static void menuProcessor(Menu entity, JSONObject jsonObj){
		jsonObj.element("name", entity.getName())
		.element("src", "");
	}
	
	protected static void resMenuPropertyProcessorNoCheckPermission(Object entity, JSONObject jsonObj){
		String code = StringUtils.EMPTY;
		Long parentId = 0L;
		Long siteId = 0L;
		ObjectType objectType = null;
		Map<String,Object> dataModule = new HashMap<String,Object>();
		if(entity instanceof ResourceFolder){
			ResourceFolder resourceFd = (ResourceFolder)entity;
			parentId = resourceFd.getId();
			code = resourceFd.getType().name();
			siteId = resourceFd.getSiteId();
			dataModule.put("id", resourceFd.getId());
			dataModule.put("type", resourceFd.getType());
			objectType = resourceFd.getType();
		}
		dataModule.put("siteId", siteId);
		dataModule.put("parentId", parentId);
		
		JSONArray jsonarray = new JSONArray();
		JSONObject menu1 = new JSONObject();
		
		//设置右键菜单
		List<Menu> listMenu = getMenuDAO().findByCriteria(Cnd.builder(Menu.class).andEQ("type", objectType.name()).orderBy("serialNumber", Order.ASC).buildCriteria());
		for (Menu menu : listMenu) {
			if(((ResourceFolder)entity).getName().equals(SpringUtils.getMessage("crs.CategoryCourse", null))){
				if(!menu.getName().equals("新建课程体系文件夹")){
					continue;
				}
			}
				ContextMenu contextMenu = new ContextMenu(menu.getName(),menu.getName());
				if(null != menu.getUrl()){
					String url = menu.getUrl();
					url = TemplateUtils.render(url, dataModule);
					url = Struts2Utils.getRequest().getContextPath() +url;
					contextMenu.setSrc(url);
				}
				contextMenu.setOpenMode(menu.getOpenMode());
				contextMenu.setTarget("iframeName");
				jsonarray.add(contextMenu);
		}
		menu1.element("contextMenus", jsonarray);
		jsonObj.element("contextMenus", menu1);
	}
	
	protected static void resMenuPropertyProcessor(Object entity, JSONObject jsonObj){
		String code = StringUtils.EMPTY;
		Long parentId = 0L;
		Long siteId = 0L;
		ObjectType objectType = null;
		Map<String,Object> dataModule = new HashMap<String,Object>();
		if(entity instanceof ActivityFolder){
			ActivityFolder activityFd = (ActivityFolder)entity;
			parentId = activityFd.getId();
			code = activityFd.getType().name();
			siteId = activityFd.getSiteId();
			objectType = activityFd.getType();
			dataModule.put("id", activityFd.getId());
			dataModule.put("type", activityFd.getType());
		}else if(entity instanceof ResourceFolder){
			ResourceFolder resourceFd = (ResourceFolder)entity;
			parentId = resourceFd.getId();
			code = resourceFd.getType().name();
			siteId = resourceFd.getSiteId();
			dataModule.put("id", resourceFd.getId());
			dataModule.put("type", resourceFd.getType());
			objectType = resourceFd.getType();
		}else if(entity instanceof ReportFolder){
			ReportFolder reportFolder = (ReportFolder)entity;
			parentId = reportFolder.getId();
			code = reportFolder.getType().name();
			siteId = reportFolder.getSiteId();
			dataModule.put("id", reportFolder.getId());
			dataModule.put("type", reportFolder.getType());
			objectType = reportFolder.getType();
		}
		dataModule.put("siteId", siteId);
		dataModule.put("parentId", parentId);
		
		JSONArray jsonarray = new JSONArray();
		JSONObject menu1 = new JSONObject();
		
		long permValue = getPermisssionService().getAllEntityPermissionValueByCurrentUser(Long.valueOf(dataModule.get("id").toString()), objectType.name());
		//设置右键菜单
		List<Menu> listMenu = getMenuDAO().findByCriteria(Cnd.builder(Menu.class).andEQ("type", objectType.name()).orderBy("serialNumber", Order.ASC).buildCriteria());
		for (Menu menu : listMenu) {
			if (hasPermissionMenu(menu, permValue)) {
				ContextMenu contextMenu = new ContextMenu(menu.getName(),menu.getName());
				if(null != menu.getUrl()){
					String url = menu.getUrl();
					url = TemplateUtils.render(url, dataModule);
					url = Struts2Utils.getRequest().getContextPath() +url;
					contextMenu.setSrc(url);
				}
				contextMenu.setOpenMode(menu.getOpenMode());
				contextMenu.setTarget("iframeName");
				jsonarray.add(contextMenu);
			}
		}
		menu1.element("contextMenus", jsonarray);
		jsonObj.element("contextMenus", menu1);
	}
	
	/**
	 * 如果是授权菜单，就添加一个记录Id参数
	 * @param code
	 * @param entityId
	 * @return String
	 */
	public static String accreditMenu(String type,Long entityId){
		if(StringUtils.equals("R_ACCREDIT", type)){
			return "&entityId=" + entityId;
		}
		return StringUtils.EMPTY;
	}
	
	protected static void siteMenuPropertyProcessor(Object entity, JSONObject jsonObj, String type){
		Organization organization = (Organization)entity;
		Map<String,Object> dataModule = new HashMap<String,Object>();
		if(entity instanceof Organization){
			dataModule.put("id", organization.getId());
			dataModule.put("siteId", organization.getSiteId());
			dataModule.put("type", organization.getType().name());
			dataModule.put("parentId", organization.getParentId());
		}
		JSONArray jsonarray = new JSONArray();
		JSONObject menu1 = new JSONObject();
		//获取当前节点的权限值
		long permValue = getPermisssionService().getAllEntityPermissionValueByCurrentUser(organization.getId(), organization.getType().name());
		//设置右键菜单
		List<Menu> listMenu = getMenuDAO().findByCriteria(Cnd.builder(Menu.class).andEQ("type", organization.getType().name()).orderBy("serialNumber", Order.ASC).buildCriteria());
		for (Menu menu : listMenu) {
			if (hasPermissionMenu(menu, permValue)) {
				ContextMenu contextMenu = new ContextMenu(menu.getName(),menu.getName());
				String url = menu.getUrl();
				url = TemplateUtils.render(url, dataModule);
				url = Struts2Utils.getRequest().getContextPath() +url;//StringUtils.EMPTY;
				contextMenu.setSrc(url);
				contextMenu.setOpenMode(menu.getOpenMode());
				contextMenu.setTarget("iframeName");
				jsonarray.add(contextMenu);
			}
		}
		menu1.element("contextMenus", jsonarray);
		jsonObj.element("contextMenus", menu1);
	}
	
	/**
	 * 区分新建模块和新建文件夹
	 */
	public static String getType(String type){
		String typeParame = "&dictType=Folder";
		if(StringUtils.isNotEmpty(type)){
			if(type.endsWith("_NEW_MODEL_MENU")){
				typeParame = "&dictType=Module";
			}
		}
		return typeParame;
	}
	/**
	 * 获取右键菜单标识
	 * @param treeType
	 * @param menuType
	 * @return String
	 */
	public static String getRMenu(String treeType,String nodeType,String type){
		String menuStr = StringUtils.EMPTY;
		if(CommonConstant.TREE_TYPE_ORGANIZATION.equals(treeType)){
			if("".equals(nodeType)){
				menuStr = "ORG_COMMON_MENU";//组织视图 - 根站点
			}else if("SMenu".equals(type)){
				menuStr = "ORG_SITE_COMMON_MENU";//组织视图 - 站点
			}else if("OMenu".equals(type)){
				menuStr = "ORG_ORG_COMMON_MENU";//组织视图 - 组织
			}
		}else if(CommonConstant.TREE_TYPE_RESOURCE.equals(treeType)){
			if("".equals(nodeType)){
				menuStr = "RES_COMMON_MENU";//资源视图 - 根站点
			}else if("SMenu".equals(type)){
				menuStr = "RES_SITE_COMMON_MENU";//资源视图 - 站点
			}else if("OMenu".equals(type)){
				menuStr = "RES_ORG_COMMON_MENU";//资源视图 - 组织
			}
		}else if(CommonConstant.TREE_TYPE_ACTIVITY.equals(treeType)){
			if("".equals(nodeType)){
				menuStr = "ATY_COMMON_MENU";//活动视图- 根站点
			}else if("SMenu".equals(type)){
				menuStr = "ATY_SITE_COMMON_MENU";//活动视图 - 站点
			}else if("OMenu".equals(type)){
				menuStr = "ATY_ORG_COMMON_MENU";//活动视图 - 组织
			}
		}
		return menuStr;
	}
	
	protected static void siteClickPropertyProcessor(Site entity, JSONObject jsonObj){
		jsonObj.element("src", getSrcPath(entity))
		.element("openMode", CommonConstant.WINDOW_OPEN_MODE_TARGET)
		.element("target", "iframeName");
	}
	
	protected static void orgBasicPropertyProcessor(Organization entity, JSONObject jsonObj){
		jsonObj.element("id", entity.getId());
		jsonObj.element("pId", entity.getParentId());
		if(null != entity.getObjectCount() && entity.getObjectCount() > 0){
			jsonObj.element("name", String.format("%s(%d)", entity.getName(), entity.getObjectCount()));
		}else{
			jsonObj.element("name", entity.getName());
		}
		jsonObj.element("isParent", null==entity.getOrganizationCount()||entity.getOrganizationCount()==0?false:true)
		.element("icon", getIconPath(entity.getType().name()))
		.element("nodeType", entity.getType());
	}
	
	protected static void orgClickPropertyProcessor(Organization entity, JSONObject jsonObj){
		jsonObj.element("src", getSrcPath(entity))
		.element("openMode", CommonConstant.WINDOW_OPEN_MODE_TARGET)
		.element("target", "iframeName");
	}
	
	protected static void userBasicPropertyProcessor(User entity, JSONObject jsonObj){
		jsonObj.element("id", entity.getId())
		.element("pId", entity.getOrganizationId())
		.element("name", entity.getFullName())
		.element("isParent", true)
		.element("icon", getIconPath("user"))
		.element("nodeType", ObjectType.O_OU);
	}
	
	protected static void userGroupBasicPropertyProcessor(UserGroup entity, JSONObject jsonObj){
		jsonObj.element("id", entity.getId())
		.element("pId", entity.getSiteId())
		.element("name", entity.getName())
		.element("isParent", true)
		.element("icon", getIconPath("user-group"))
		.element("nodeType", ObjectType.O_OG);
	}
	
	protected static void rptFolderBasicPropertyProcessor(ReportFolder entity, JSONObject jsonObj){
		jsonObj.element("id", entity.getId())
		.element("pId", entity.getParentId())
		.element("isParent", null==entity.getFolderCount()||entity.getFolderCount()==0?false:true)
		.element("icon", getIconPath(entity.getType().name()))
		.element("nodeType", entity.getType());
		if(null != entity.getObjectCount() && entity.getObjectCount() > 0){
			jsonObj.element("name", String.format("%s(%d)", entity.getName(), entity.getObjectCount()));
		}else{
			jsonObj.element("name", entity.getName());
		}
		jsonObj.element("click", true);
	}
	
	protected static void rptFolderClickPropertyProcessor(ReportFolder entity, JSONObject jsonObj){
		jsonObj.element("src", getSrcPath(entity))
		.element("openMode", CommonConstant.WINDOW_OPEN_MODE_TARGET)
		.element("target", "iframeName");
	}
	
	protected static void resFolderBasicPropertyProcessor(ResourceFolder entity, JSONObject jsonObj){
		jsonObj.element("id", entity.getId())
		.element("pId", entity.getParentId())
		.element("isParent", null==entity.getFolderCount()||entity.getFolderCount()==0?false:true)
		.element("icon", getIconPath(entity.getType().name()))
		.element("nodeType", entity.getType());
		if(null != entity.getObjectCount() && entity.getObjectCount() > 0){
			jsonObj.element("name", String.format("%s(%d)", entity.getName(), entity.getObjectCount()));
		}else{
			jsonObj.element("name", entity.getName());
		}
		//if((entity.getType().name().endsWith("F") && entity.getType() != ObjectType.R_FF && entity.getType() != ObjectType.R_QF) || entity.getType() == ObjectType.R_QB){
			jsonObj.element("click", true);
		//}else{
		//	jsonObj.element("click", false);
		//}
	}
	
	protected static void resCategoryBasicPropertyProcessor(ResourceFolder entity, JSONObject jsonObj){
		jsonObj.element("id", entity.getId())
		.element("pId", entity.getParentId())
		.element("isParent", null==entity.getFolderCount()||entity.getFolderCount()==0?false:true)
		.element("icon", getIconPath(entity.getType().name()))
		.element("nodeType", entity.getType());
		jsonObj.element("name", entity.getName());
		//if((entity.getType().name().endsWith("F") && entity.getType() != ObjectType.R_FF && entity.getType() != ObjectType.R_QF) || entity.getType() == ObjectType.R_QB){
			jsonObj.element("click", true);
		//}else{
		//	jsonObj.element("click", false);
		//}
	}
	protected static void resFolderPickerPropertyProcessor(ResourceFolder entity, JSONObject jsonObj){
		jsonObj.element("id", entity.getId())
		.element("pId", entity.getParentId())
		.element("name", entity.getName())
		.element("isParent", true)
		.element("icon", getIconPath("folder"))
		.element("nodeType", entity.getType());
	}
	
	protected static void resFolderClickPropertyProcessor(ResourceFolder entity, JSONObject jsonObj){
		jsonObj.element("src", getSrcPath(entity))
		.element("openMode", CommonConstant.WINDOW_OPEN_MODE_TARGET)
		.element("target", "iframeName");
	}
	
	protected static void viewCourseCategoryClickPropertyProcessor(ResourceFolder entity, JSONObject jsonObj){
		jsonObj.element("src", getSrcPath(entity))
		.element("openMode", CommonConstant.WINDOW_OPEN_MODE_TARGET)
		.element("target", "courselist");
	}
	
	protected static void courseBasicPropertyProcessor(CourseInfo entity, JSONObject jsonObj){
		jsonObj.element("id", entity.getId())
		.element("pId", entity.getFolderId())
		.element("name", entity.getCourseTitle())
		.element("isParent", false)
		.element("icon", getIconPath("course"))
		.element("nodeType", entity.getType());
	}
	
	protected static void knowledgeBasicPropertyProcessor(Knowledge entity, JSONObject jsonObj){
		jsonObj.element("id", entity.getId())
		.element("pId", entity.getFolderId())
		.element("name", entity.getName())
		.element("isParent", false)
		.element("icon", getIconPath("knowledge"));
	}
	
	protected static void paperBasicPropertyProcessor(Paper entity, JSONObject jsonObj){
		jsonObj.element("id", entity.getId())
		.element("pId", entity.getFolderId())
		.element("name", entity.getName())
		.element("isParent", false)
		.element("icon", getIconPath("paper"))
		.element("nodeType", entity.getType());
	}
	
	protected static void atyFolderBasicPropertyProcessor(ActivityFolder entity, JSONObject jsonObj){
		jsonObj.element("id", entity.getId())
		.element("pId", entity.getParentId())
		.element("isParent", null==entity.getFolderCount()||entity.getFolderCount()==0?false:true);
		if(null != entity.getObjectCount() && entity.getObjectCount() > 0){
			jsonObj.element("name", String.format("%s(%d)", entity.getName(), entity.getObjectCount()));
		}else{
			jsonObj.element("name", entity.getName());
		}
		jsonObj.element("icon", getIconPath(entity.getType().name()))
		.element("nodeType", entity.getType())
		.element("click", true);;
	}
	
	protected static void activityDetailsBasicPropertyProcessor(ActivityDetails entity, JSONObject jsonObj){
		jsonObj.element("id", entity.getActivityId())
		.element("name", entity.getName())
		.element("isParent", false)
		.element("icon", getIconPath(entity.getActivityType().name()))
		.element("nodeType", entity.getActivityType())
		.element("click", true);;
	}
	
	protected static void atyFolderClickPropertyProcessor(ActivityFolder entity, JSONObject jsonObj){
		jsonObj.element("src", getSrcPath(entity))
		.element("openMode", CommonConstant.WINDOW_OPEN_MODE_TARGET)
		.element("target", "iframeName");
	}
	
	protected static String getIconPath(String name){
		return Struts2Utils.getRequest().getContextPath() + "/img/tree/"+name+".gif";
	}
	
	public static String getSrcPath(Object entity){
		String path = Struts2Utils.getRequest().getContextPath();
		if(entity instanceof Site){
			Site object = (Site)entity;
			path = path + "/org/site-option.action?siteId=" + object.getId();
		}else if(entity instanceof Organization){
			Organization object = (Organization)entity;
			path = path + "/org/user.action?organizationId=" + object.getId() + "&siteId=" + object.getSiteId() + "&entityType=" + object.getType();
		}else if(entity instanceof Knowledge){
			Knowledge knowledge = (Knowledge)entity;
			path = path + "/exm/question!findKnowlegelQquestions.action?knowledgeId="+knowledge.getId()+"&folderId="+knowledge.getFolderId();
		}else if(entity instanceof ReportFolder){
			ReportFolder reportFolder = (ReportFolder)entity;
			if(ObjectType.P_AF.equals(reportFolder.getType())){
			  path = path + "/rpt/user-activity-details-report.action?siteId="+reportFolder.getSiteId();
			}else if(ObjectType.P_BF.equals(reportFolder.getType())){
				path = path + "/rpt/course-message.action?siteId="+reportFolder.getSiteId();
			}else if(ObjectType.P_CF.equals(reportFolder.getType())){
				path = path + "/rpt/user-examination-report.action?siteId="+reportFolder.getSiteId();
			}else if(ObjectType.P_DF.equals(reportFolder.getType())){
				path = path + "/rpt/examination-stat.action?siteId="+reportFolder.getSiteId();
			}else {
			  path ="";// path + "/rpt/report-folder.action?ids="+reportFolder.getId();
			}
			
		}else if(entity instanceof ResourceFolder){
			ResourceFolder object = (ResourceFolder)entity;
			if(ObjectType.R_LF == object.getType()){
				path = path + "/res/location.action?folderId=";
			}else if(ObjectType.R_QB == object.getType() || ObjectType.R_QF == object.getType()){
				path = path + "/exm/question.action?folderId=";
			}else if(ObjectType.R_EF == object.getType()){
				path = path + "/res/equipment.action?folderId=";
			}else if(ObjectType.R_TF == object.getType()){
				path = path + "/res/trainer.action?folderId=";
			}else if(ObjectType.R_CF == object.getType()){
				path = path + "/crs/course-info.action?category="+ObjectType.R_CF+"&folderId=";
			}else if(ObjectType.R_SF == object.getType()){
				path = path + "/crs/course-category.action?category="+ObjectType.R_SF+"&folderId=";
			}else if(ObjectType.R_PF == object.getType()){
				path = path + "/exm/paper.action?folderId=";
			}else if(ObjectType.R_ZF == object.getType()){
				path = path + "/exm/knowledge.action?folderId=";
			}else if(ObjectType.R_BF == object.getType()){
				path = path + "/res/attendance.action?folderId=";
			}else if(ObjectType.R_AF == object.getType()){
				path = path + "/res/score-sheet.action?folderId=";
			}else{
				path = "";
			}
			if(!StringUtils.isEmpty(path)){
				path = path + object.getId().toString();
				path = path + "&siteId=" + String.valueOf(object.getSiteId());
				path = path + "&dictType="+object.getType().name();
			}else{
				path = "javascript:void(0);";
			}
		}else if(entity instanceof ActivityFolder){
			ActivityFolder object = (ActivityFolder)entity;
			if(ObjectType.A_PF == object.getType()){
				path = path + "/aty/training-plan.action?folderId=";
			}else if(ObjectType.A_EM == object.getType()){
				path = path + "/aty/activity-folder.action?folderId=";
			}else if(ObjectType.A_EF == object.getType()){
				path = path + "/aty/elearning.action?folderId=";
			}else if(ObjectType.A_XF == object.getType()){
				path = path + "/aty/examination.action?folderId=";
			}else{
				path = "";
			}
			if(!StringUtils.isEmpty(path)){
				path = path + object.getId().toString();
				path = path + "&siteId=" + object.getSiteId();
				path = path + "&dictType="+object.getType().name();
			}else{
				path = "javascript:void(0);";
			}
		} else if (entity instanceof ScoreSheet) {
			if (((ScoreSheet) entity).getObjectType() == ObjectType.R_AL) {
				path = path + "/res/learner-score.action?scoreSheetId=";
				path = path + ((ScoreSheet) entity).getId().toString();
			}else
			{
				path = path + "/res/score-relation.action?scoreSheetId=";
				path = path + ((ScoreSheet) entity).getId().toString();
			}
		}
		return path;
	}
	
	/**
	 * 修改树节点name时，编辑文本框的长度
	 * @return Integer
	 */
	public static Integer getTreeNodeInputEditWith(){
		Integer width = 150;
		Integer tmpWidth = SysParameterUtils.getInteger("sys.tree_node_input_width");
		if(!new Integer(-1).equals(tmpWidth)){
			width = tmpWidth;
		}
		return width;
	}
	
	public static boolean hasPermissionMenu(Menu menu, long permValue) {
		return (menu.getAuthId() == null || menu.getAuthorityValue() == null ||  (permValue & menu.getAuthorityValue().longValue()) > 0);
	}
	
	/**
	 * 获取MenuDAO
	 */
	public static MenuDAO getMenuDAO() {
		return SpringUtils.getBean(MenuDAO.class);
	}
	
	/**
	 * 获取PermisssionService
	 * @return
	 */
	public static PermisssionService getPermisssionService() {
		return SpringUtils.getBean(PermisssionService.class);
	}
	
	/**
	 * 获取TypeDAO
	 */
	public static TypeDAO getTypeDAO() {
		return SpringUtils.getBean(TypeDAO.class);
	}
	
	public static List<Object> getNavigationItems(ObjectType objectType, Long objectId){
		if(null == objectType){
			return new ArrayList<Object>();
		}
		if(objectType == ObjectType.O_OS){
			OrganizationService organizatonService = (OrganizationService)SpringUtils.getBean(OrganizationService.class);
			CriteriaBuilder cb = Cnd.builder(Organization.class);
			cb.andEQ("siteId", objectId).andEQ("type", objectType.name());
			PagingResult<Organization> pageResult = organizatonService.findOrganization(cb.buildCriteria());
			if(!ListUtils.isEmpty(pageResult.getResult())){
				objectId = ((Organization)pageResult.getResult().get(0)).getId();
			}
		}
		List<Object> result = new ArrayList<Object>();
		List<Long> topIds = new ArrayList<Long>();
		if(objectType.name().startsWith("O_")){
			OrganizationService organizatonService = (OrganizationService)SpringUtils.getBean(OrganizationService.class);
			List<Organization> orgList = organizatonService.findTopLevelOrganization(ObjectType.O_OS, ObjectType.O_OO);
			for(Organization organization:orgList){
				topIds.add(organization.getId());
			}
		}else if(objectType.name().startsWith("R_")){
			ResourceFolderService resourceFolderService=(ResourceFolderService)SpringUtils.getBean(ResourceFolderService.class);
			List<ResourceFolder> resList=resourceFolderService.findTopLevelResourceFolder(ObjectType.R_OS,ObjectType.R__F);
			for (ResourceFolder resourceFolder : resList) {
				topIds.add(resourceFolder.getId());
			}
		}else if(objectType.name().startsWith("A_")){
			ActivityFolderService activityFolderService=(ActivityFolderService)SpringUtils.getBean(ActivityFolderService.class);
			List<ActivityFolder> actList=activityFolderService.findTopLevelResourceFolder(ObjectType.A_OS,ObjectType.A__F);
			for (ActivityFolder activityFolder : actList) {
				topIds.add(activityFolder.getId());
			}
			
		}
		if(objectType == ObjectType.O_OS){
			OrganizationDAO dao = (OrganizationDAO)SpringUtils.getBean(OrganizationDAO.class);
			Organization entity = dao.get(objectId);
			result.add(entity);
			getParentObject(result, entity, topIds);
		}else if(objectType == ObjectType.O_OO){
			OrganizationDAO dao = (OrganizationDAO)SpringUtils.getBean(OrganizationDAO.class);
			Organization entity = dao.get(objectId);
			result.add(entity);
			getParentObject(result, entity, topIds);
		}else if(objectType == ObjectType.O_OU){
			UserDAO dao = (UserDAO)SpringUtils.getBean(UserDAO.class);
			User entity = dao.get(objectId);
			result.add(entity);
			getParentObject(result, entity, topIds);
		}else if(objectType == ObjectType.R_ZZ){
			KnowledgeDAO dao = (KnowledgeDAO)SpringUtils.getBean(KnowledgeDAO.class);
			Knowledge entity = dao.get(objectId);
			result.add(entity);
			getParentObject(result, entity, topIds);
		}else if(objectType.name().startsWith("R_")){
			ResourceFolderDAO dao = (ResourceFolderDAO)SpringUtils.getBean(ResourceFolderDAO.class);
			ResourceFolder entity = dao.get(objectId);
			result.add(entity);
			getParentObject(result, entity, topIds);
		}else if(objectType.name().startsWith("A_")){
			ActivityFolderDAO dao = (ActivityFolderDAO)SpringUtils.getBean(ActivityFolderDAO.class);
			ActivityFolder entity = dao.get(objectId);
			result.add(entity);
			getParentObject(result, entity, topIds);
		}else if(objectType == ObjectType.R_AL){
			ScoreSheetDAO dao = (ScoreSheetDAO)SpringUtils.getBean(ScoreSheetDAO.class);
			ScoreSheet entity = dao.get(objectId);
			entity.setObjectType(ObjectType.R_AL);
			result.add(entity);
			getParentObject(result, entity, topIds);			
		}else if(objectType == ObjectType.R_AR){
			ScoreSheetDAO dao = (ScoreSheetDAO)SpringUtils.getBean(ScoreSheetDAO.class);
			ScoreSheet entity = dao.get(objectId);
			entity.setObjectType(ObjectType.R_AR);
			result.add(entity);
			getParentObject(result, entity, topIds);			
		}
		
		
		return result;
	}
	
	protected static void getParentObject(List<Object> result, Object object, List<Long> topIds){
		
		if (object != null && topIds.contains(((IdEntity)object).getId()) ) {
			return;
		}
		int menuNumber = SysParameterUtils.getInteger("sys.navigation_menu_number");
		if(result.size() >= menuNumber){
			return;
		}
		Object parenetObject = null;
		if(object instanceof Organization){
			Organization subObject = (Organization)object;
			if(null != subObject.getParentId()){
				OrganizationDAO dao = (OrganizationDAO)SpringUtils.getBean(OrganizationDAO.class);
				Organization entity = dao.get(subObject.getParentId());
				parenetObject = entity;
			}else{
				SiteDAO dao = (SiteDAO)SpringUtils.getBean(SiteDAO.class);
				Site entity = dao.get(subObject.getSiteId());
				parenetObject = entity;
			}
		}else if(object instanceof Site){
			Site subObject = (Site)object;
			if(null != subObject.getParentId()){
				SiteDAO dao = (SiteDAO)SpringUtils.getBean(SiteDAO.class);
				Site entity = dao.get(subObject.getParentId());
				parenetObject = entity;
			}
		}else if(object instanceof User){
			User subObject = (User)object;
			if(null != subObject.getOrganizationId()){
				OrganizationDAO dao = (OrganizationDAO)SpringUtils.getBean(OrganizationDAO.class);
				Organization entity = dao.get(subObject.getOrganizationId());
				parenetObject = entity;
			}
		}else if(object instanceof ResourceFolder){
			ResourceFolder subObject = (ResourceFolder)object;
			if(null != subObject.getParentId()){
				ResourceFolderDAO dao = (ResourceFolderDAO)SpringUtils.getBean(ResourceFolderDAO.class);
				ResourceFolder entity = dao.get(subObject.getParentId());
				parenetObject = entity;
			}else{
				SiteDAO dao = (SiteDAO)SpringUtils.getBean(SiteDAO.class);
				Site entity = dao.get(subObject.getSiteId());
				parenetObject = entity;
			}
		}else if(object instanceof ActivityFolder){
			ActivityFolder subObject = (ActivityFolder)object;
			if(null != subObject.getParentId()){
				ActivityFolderDAO dao = (ActivityFolderDAO)SpringUtils.getBean(ActivityFolderDAO.class);
				ActivityFolder entity = dao.get(subObject.getParentId());
				parenetObject = entity;
			}else{
				SiteDAO dao = (SiteDAO)SpringUtils.getBean(SiteDAO.class);
				Site entity = dao.get(subObject.getSiteId());
				parenetObject = entity;
			}
		}else if(object instanceof ScoreSheet){
			ScoreSheet subObject = (ScoreSheet)object;
			if(null != subObject.getFolderId()){
				ResourceFolderDAO dao = (ResourceFolderDAO)SpringUtils.getBean(ResourceFolderDAO.class);
				ResourceFolder entity = dao.get(subObject.getFolderId());
				parenetObject = entity;
			}
		}else if(object instanceof Knowledge){
			Knowledge subObject = (Knowledge)object;
			if(null != subObject.getFolderId()){
				ResourceFolderDAO dao = (ResourceFolderDAO)SpringUtils.getBean(ResourceFolderDAO.class);
				ResourceFolder entity = dao.get(subObject.getFolderId());
				parenetObject = entity;
			}
		}
		if(null == parenetObject){
			return;
		}
		result.add(parenetObject);
		if(parenetObject instanceof IdEntity){
			IdEntity idEntity = (IdEntity)parenetObject;
			if(topIds.contains(idEntity.getId())){
				return;
			}
		}
		getParentObject(result, parenetObject, topIds);
	}
	
}
