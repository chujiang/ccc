/**
 * 
 */
package com.kingnod.etraining.security.action;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import net.sf.json.JSONArray;

import org.apache.commons.lang.xwork.StringUtils;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.extensions.struts2.action.EntityAction;
import com.kingnod.core.extensions.struts2.action.FilterableEntityAction;
import com.kingnod.core.util.SpringUtils;
import com.kingnod.etraining.activity.entity.ActivityFolder;
import com.kingnod.etraining.activity.service.ActivityFolderService;
import com.kingnod.etraining.common.CommonConstant;
import com.kingnod.etraining.common.ObjectType;
import com.kingnod.etraining.common.entity.Role;
import com.kingnod.etraining.common.service.RoleService;
import com.kingnod.etraining.organization.entity.Organization;
import com.kingnod.etraining.organization.entity.Site;
import com.kingnod.etraining.organization.entity.User;
import com.kingnod.etraining.organization.entity.UserGroup;
import com.kingnod.etraining.organization.service.OrganizationService;
import com.kingnod.etraining.organization.service.SiteService;
import com.kingnod.etraining.organization.service.UserGroupService;
import com.kingnod.etraining.organization.service.UserService;
import com.kingnod.etraining.resource.entity.ResourceFolder;
import com.kingnod.etraining.resource.service.ResourceFolderService;
import com.kingnod.etraining.security.PermissionAuthorityService;
import com.kingnod.etraining.security.PermisssionService;
import com.kingnod.etraining.security.SecurityConstant;
import com.kingnod.etraining.security.entity.BitMapping;
import com.kingnod.etraining.security.entity.EntityAuthority;
import com.kingnod.etraining.security.entity.EntityObject;
import com.kingnod.etraining.security.entity.EntityPermission;
import com.kingnod.etraining.security.entity.EntityReadPermission;
import com.kingnod.etraining.security.entity.OwnerAutValue;
import com.kingnod.etraining.security.entity.OwnerAuthority;

/**
 * 数据级权限功能
 * 
 * @author liuxiaobin
 * 
 */
@org.springframework.stereotype.Controller
@Namespace("/sec")
@Results({ @Result(name = EntityAction.RELOAD, type = "redirectAction", params = {
		"actionName", "permission-authority", "namespace", "/sec" }) })
@com.kingnod.core.annotation.Generated("2012-03-06 15:30")
public class PermissionAuthorityAction extends
		FilterableEntityAction<EntityAuthority, Long> {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private PermissionAuthorityService permissionAuthorityService;// 权限

	@Autowired
	private PermisssionService permisssionService;// 其他操作类型

	@Autowired
	private UserGroupService userGroupService;// 用户组

	@Autowired
	private UserService userService;// 用户

	@Autowired
	private RoleService roleService;// 角色

	@Autowired
	private SiteService siteService;// 站点

	@Autowired
	private OrganizationService organizationService;// 组织
	
	@Autowired
	private ResourceFolderService resourceFolderService;// 资源
	
	@Autowired
	private ActivityFolderService activityFolderService;// 活动

	private Long siteId = 0L;// 站点Id

	private Long entityId = 0L;// 记录Id：当前节点树ID

	private String entityName = StringUtils.EMPTY;// 记录Name：当前节点树的Name

	private String dictType;// objectType：O_OO, A_FF, R_FF

	private String type = "G";// 类型：R,U,G

	private String jsonStrArray = StringUtils.EMPTY;;// 保存用户设置的权限值

	private String msgStr = StringUtils.EMPTY;;// 保存用户，用户组，角色的名称信息

	private String condition = null;// 搜索条件

	private List<OwnerAuthority> listOwnerAuthority = new ArrayList<OwnerAuthority>();

	private List<EntityAuthority> listAuthority = new ArrayList<EntityAuthority>();

	private List<Long> listSiteId = new ArrayList<Long>();// 当前站点以及父节点

	private ServletContext sContext = null;
	
	private String isApplySuper = "true";//应用父级权限的按钮是否可用

	/**
	 * 初始化ServletContext对象
	 * 
	 * @return ServletContext
	 */
	public void initServletContext() {
		sContext = request.getSession().getServletContext();
	}

	/**
	 * 添加映射对象
	 * 
	 * @param list
	 */
	public void saveBitMapping(List<BitMapping> list) {
		if (sContext == null)
			initServletContext();
		// sContext.setAttribute(SecurityConstant.BIT_MAPPING, list);
	}

	/**
	 * 获取父节点Id，祖父节点Id
	 * 
	 * @param pSiteId
	 */
	public void getParentSiteId(Long pSiteId) {
		if (pSiteId != null && pSiteId != CommonConstant.ROOT_SITE_ID) {
			Site site = siteService.getSite(pSiteId);
			if(site != null && site.getParentId() != null){
				listSiteId.add(site.getParentId());
				getParentSiteId(site.getParentId());
			}
		}
	}
	
	/**
	 * 初始化
	 */
	public void initListSiteId() {
		listSiteId.clear();
		listSiteId.add(siteId);
		getParentSiteId(siteId);
	}

	@Override
	public String execute() throws Exception {
		initListSiteId();

		// 获取当前组织下所有的权限
		listAuthority = permisssionService.findAuthorityByType(dictType);

		if (condition != null) {
			// 判断是否存在搜索条件
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("siteId", listSiteId);
			map.put("name",
					StringUtils.isNotEmpty(condition.trim()) ? com.kingnod.core.util.StringUtils.filterFuzzyQueryString(condition.trim())
							: null);

			OwnerAuthority ownerAuthority = null;
			if (StringUtils.equals(type, "R")) {// -------角色

				List<Role> listRole = roleService.findRoleBySiteId(map);// 获取当前站点下所有的角色

				// 获取角色所拥有的权限
				for (Role role : listRole) {
					ownerAuthority = new OwnerAuthority();
					ownerAuthority.setId(role.getId());
					ownerAuthority.setName(role.getName());
					ownerAuthority.setList(getOwnerAuthority(role.getId()));// 获取已有的权限
					listOwnerAuthority.add(ownerAuthority);
				}
			} else if (StringUtils.equals(type, "G")) {// -------用户组
				List<UserGroup> listUserGroup = userGroupService
						.getUserGroupBySiteId(map);// 获取当前站点下所有的用户组

				// 获取用户组所拥有的权限
				for (UserGroup userGroup : listUserGroup) {
					ownerAuthority = new OwnerAuthority();
					ownerAuthority.setId(userGroup.getId());
					ownerAuthority.setName(userGroup.getName());
					ownerAuthority
							.setList(getOwnerAuthority(userGroup.getId()));// 获取已有的权限
					ownerAuthority.setSiteId(userGroup.getSiteId());
					Site site = siteService.getSite(userGroup.getSiteId());
					if(null != site){
						ownerAuthority.setSiteName(site.getName());
					}
					listOwnerAuthority.add(ownerAuthority);
				}
			} else if (StringUtils.equals(type, "U")) {// -------用户
				List<User> listUserGroup = userService.findAllReadableAdministrator(map);

				// 获取用户所拥有的权限
				for (User user : listUserGroup) {
					ownerAuthority = new OwnerAuthority();
					ownerAuthority.setId(user.getId());
					ownerAuthority.setName(user.getFullName() + "("
							+ user.getLoginName() + ")");
					ownerAuthority.setList(getOwnerAuthority(user.getId()));
					ownerAuthority.setSiteId(user.getSiteId());
					Site site = siteService.getSite(user.getSiteId());
					if(null != site){
						ownerAuthority.setSiteName(site.getName());
					}
					listOwnerAuthority.add(ownerAuthority);
				}
			}
		}

		getEntityNameBySiteId();// 获取当前站点名称
		getMessageInfo();// 获取当前对象名：角色，用户，用户组
		//isApplySuper();//如果上级菜单是根节点，就不能应用上级权限
		return "success";
	}

	public void isApplySuper(){
		if(StringUtils.equals(dictType, ObjectType.O_OO.name())){
			Organization organization = organizationService.getOrganization(entityId);
			if(organization != null){
				if(organization.getParentId() != null){
					isApplySuper = "true";
				}else{
					isApplySuper = siteId == 0 ? "false" : "true";
				}
			}
		}else if(StringUtils.equals(dictType, ObjectType.O_OS.name())){
			Site site = siteService.getSite(entityId);
			if(site != null){
				isApplySuper = site.getParentId() == 0 ? "false" : "true";
			}
		}
	}
	
	/**
	 * 获取当前站点下用户，用户组或者角色已有的权限
	 * 
	 * @param ownerId
	 *            Id
	 * @param readAuthority
	 *            读权限的boolean值
	 * @return List<OwnerAutValue>
	 */
	public List<OwnerAutValue> getOwnerAuthority(Long ownerId) {
		List<OwnerAutValue> listAutValue = new ArrayList<OwnerAutValue>();

/*		EntityPermission permission = new EntityPermission();
		permission.setEntityId(entityId);
		permission.setEntityType(dictType);
		permission.setOwnerId(ownerId);
		permission.setOwnerType(type);*/
		
		//获取用户当前实体的权限,包括继承的权限
		List<EntityPermission> permissions = null;
		if (StringUtils.equals(type, "U")) {
			permissions = permisssionService.getEntityPermissionByUser(entityId, dictType, ownerId);
		} else if (StringUtils.equals(type, "G")) {
			permissions = permisssionService.getEntityPermissionByUserGroup(entityId, dictType, ownerId);
		}
		
		long inharitPermValue = 0L;
		long fullPermValue = 0L;
		//遍历权限，获取最终的权限与继承的权限
		for (EntityPermission perm: permissions) {
			//如果类型不同，只取 rwda的权限 
			long tempPermValue = StringUtils.equals(dictType, perm.getEntityType()) ? perm.getPermissionValue().longValue() : (perm.getPermissionValue().longValue() & SecurityConstant.COMM_PERM_TOTAL);
			//判断是不是继承，1种是从父目录继承的，另一种是从用户组获取的权限。
			if (!perm.getEntityId().equals(entityId) || !StringUtils.equals(type, perm.getOwnerType())) {
				inharitPermValue = inharitPermValue | tempPermValue;

			}
			fullPermValue = fullPermValue | tempPermValue;
		}

/*		EntityPermission entityPermission = permissionAuthorityService
				.get(permission);// 获取角色拥有的其他操作权限
		int value = entityPermission != null ? entityPermission
				.getPermissionValue().intValue() : 0;// 权限值*/

		// 所有操作权限
		for (int i = 0; i < listAuthority.size(); i++) {
			OwnerAutValue ownerAutValue = new OwnerAutValue();
			int atValue = listAuthority.get(i).getAuthorityValue().intValue();
			ownerAutValue.setValue(atValue);
			ownerAutValue.setBool(atValue > 0 ? ((fullPermValue & atValue) > 0 ? true : false) : false);
			ownerAutValue.setInherit((inharitPermValue & atValue) > 0);
			listAutValue.add(ownerAutValue);
		}
		return listAutValue;
	}

	/**
	 * 应用操作,保存用户赋予之后的权限
	 * 
	 * @return String
	 * @throws Exception
	 */
	public String apply() throws Exception {
		List<EntityPermission> listPermission = new ArrayList<EntityPermission>();
		Map<Long, Long> map = parseJsonData();

		List<Long> readOwnerIds = new ArrayList<Long>();
		for (Map.Entry<Long, Long> mapObj : map.entrySet()) {
			if ((mapObj.getValue() & 1) > 0) {
				readOwnerIds.add(Long.valueOf(mapObj.getKey()));
			}
		}

		for (Map.Entry<Long, Long> mapObj : map.entrySet()) {
			EntityPermission entityPermission = new EntityPermission();
			entityPermission.setEntityId(entityId);
			entityPermission.setOwnerType(type);// --------------------------------------这里保存其他操作权限时，没有根据objectType
			entityPermission.setEntityType(dictType);
			entityPermission.setOwnerId(mapObj.getKey());

			Long value = mapObj.getValue();
			entityPermission.setPermissionValue(BigDecimal.valueOf(value));

			listPermission.add(entityPermission);
		}

		permisssionService.saveReadAthority(
				new EntityObject(entityId.intValue(), ObjectType
						.valueOf(dictType)), type, readOwnerIds
						.toArray(new Long[0]));

		// 授权
		permisssionService.perm(listPermission);
		request.getSession().setAttribute("apply",
				SpringUtils.getMessage("sec.permission_save_success"));
		return execute();
	}

	/**
	 * 应用父级权限
	 * 
	 * @return String
	 */
	public String applySuper() throws Exception {
		List<EntityPermission> list = new ArrayList<EntityPermission>();// 相同部分的记录

		// 查询当前记录的权限
		List<EntityPermission> listCurPermission = permisssionService
				.getPermissionByEntityId(entityId);

		// 查询父级记录的权限
		Long pEntityId = getSuperEntityId();
		List<EntityPermission> listpartPermission = permisssionService
				.getPermissionByEntityId(pEntityId);
		ObjectType pEntityType = null;
		if(listpartPermission.size() > 0){
			String pEntityTypeStr = listpartPermission.get(0).getEntityType();
			pEntityType = ObjectType.valueOf(pEntityTypeStr);//获取父级的ObjectType
		}
		
		
		// 获取相同部分的记录
		for (EntityPermission parentPer : listpartPermission) {
			for (EntityPermission permission : listCurPermission) {
				if (equals(parentPer, permission)) {
					Long authValue = getAuthorityValue(parentPer
							.getPermissionValue().longValue(), permission
							.getPermissionValue().longValue());
					permission.setPermissionValue(new BigDecimal(authValue));
					list.add(permission);
					break;
				}
			}
		}

		//父级减去共有的部分
		for (EntityPermission common : list) {
			for (EntityPermission parent : listpartPermission) {
				if (equals(parent, common)) {
					parent.setEntityId((long)-1);
					break;
				}
			}
		}
		
		//把父级独有的权限添加到
		for(EntityPermission parent : listpartPermission) {
			if(parent.getEntityId() != -1){
				parent.setEntityId(entityId);
				listCurPermission.add(parent);
			}
		}
		
		// 授权
		permisssionService.perm(listCurPermission);
		
		//根据EntityId和entityType查询一条读的权限记录
		if(pEntityType != null){
			EntityObject eo = new EntityObject();
			eo.setEntityId(pEntityId.intValue());
			eo.setEntityType(pEntityType);
			
			//获取父级的读权限记录
			EntityReadPermission readPermission = permisssionService.getReadPermissionByEntityId(eo);
			if(readPermission != null){
				readPermission.setEntityId(entityId);
				readPermission.setEntityType(ObjectType.valueOf(dictType));
				
				//保存父级权限记录到当前只读表中
				permisssionService.saveReadPermission(readPermission);
			}
		}
		
		request.getSession().setAttribute("applySuper",
				SpringUtils.getMessage("sec.permission_save_success"));
		
		return execute();
	}

	public Long getAuthorityValue(Long pVal, Long cVal) {
		long a = pVal & cVal; // 取子级和父级相同的部分权限值的和
		long b = pVal ^ a;// 父级权限值 - 相同部分权限值 = 父级独有的权限值
		return cVal | b;// 子级权限制 + 父级权限值 = 子级和父级合并之后的权限值
	}

	/**
	 * 判断两个对象是否相同
	 * 
	 * @param parentPer
	 * @param permission
	 * @return boolean
	 */
	public boolean equals(EntityPermission parentPer,
			EntityPermission permission) {
		return StringUtils.equals(parentPer.getOwnerType(),
						permission.getOwnerType())
				&& parentPer.getOwnerId() == permission.getOwnerId();
	}

	/**
	 * 获取父级记录的entityId
	 * 
	 * @return
	 */
	public Long getSuperEntityId() {
		Long pEntityId = null;
		if (StringUtils.equals(dictType, ObjectType.O_OS.name())) {
			Site site = siteService.getSite(entityId);
			pEntityId = site != null ? site.getParentId() : null;
		} else if (StringUtils.equals(dictType, ObjectType.O_OO.name())) {
			Organization organization = organizationService
					.getOrganization(entityId);
			pEntityId = organization != null ? organization.getParentId()
					: null;
		}
		return pEntityId;
	}

	/**
	 * 解析json数据，获取操作者及其对应的权限值
	 * 
	 * @return Map<Long,Long>
	 */
	public Map<Long, Long> parseJsonData() {
		Map<Long, Long> maps = new HashMap<Long, Long>();
		JSONArray jsonArray = JSONArray.fromObject(jsonStrArray);
		Collection<?> liss = JSONArray.toCollection(jsonArray, Map.class);
		Iterator<?> iterator = liss.iterator();
		while (iterator.hasNext()) {
			Object obj = iterator.next();
			if (obj instanceof Map) {
				Map<?, ?> mapObj = (Map<?, ?>) obj;
				Long ownerId = 0L;
				Long intValue = 0L;
				for (Map.Entry<?, ?> map : mapObj.entrySet()) {
					Object key = map.getKey();
					if (StringUtils.equals(key.toString(), "roleId")) {// 操作者Id
						ownerId = parseLong(map.getValue());
					} else if (StringUtils.equals(key.toString(), "value")) {// 权限值
						intValue = parseLong(map.getValue());
					}
				}
				maps.put(ownerId, intValue);
			}
		}
		return maps;
	}

	/**
	 * 获取用户选择的类型名称：用户，角色，用户组
	 * 
	 * @param type
	 */
	public void getMessageInfo() {
		if (StringUtils.equals(type, "R")) {
			msgStr = "角色名称";
		} else if (StringUtils.equals(type, "U")) {
			msgStr = "用户名称";
		} else if (StringUtils.equals(type, "G")) {
			msgStr = "用户组名称";
		}
	}

	/**
	 * 强转成Long
	 * 
	 * @param obj
	 * @return Long
	 */
	public Long parseLong(Object obj) {
		try {
			if (obj != null) {
				return Long.parseLong(obj.toString());
			}
		} catch (Exception e) {
		}
		return 0L;
	}

	/**
	 * 初始化entityName
	 */
	public void getEntityNameBySiteId() {
		if (StringUtils.equals(dictType, String.valueOf(ObjectType.O_OO))) {// 组织
			Organization organization = organizationService
					.getOrganization(entityId);
			if (organization != null) {
				entityName = organization.getName();
			}
		} else if (StringUtils
				.equals(dictType, String.valueOf(ObjectType.O_OS))) {// 站点
			Site site = siteService.getSite(siteId);
			if (site != null) {
				entityName = site.getName();
			}
		} else if (dictType.startsWith("R_")) {// 资源视图
			ResourceFolder resFolder = resourceFolderService
					.getResourceFolder(entityId);
			if (resFolder != null) {
				entityName = resFolder.getName();
			}
		} else if (dictType.startsWith("A_")) {// 活动视图
			ActivityFolder atyFolder = activityFolderService
					.getActivityFolder(entityId);
			if (atyFolder != null) {
				entityName = atyFolder.getName();
			}
		}
	}

	public String filterDefines() {
		return "cmn.roleFilterItems";
	}

	@Override
	protected Object getEntityService() {
		return this.permisssionService;
	}

	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}

	public void setListAuthority(List<EntityAuthority> listAuthority) {
		this.listAuthority = listAuthority;
	}

	public void setListOwnerAuthority(List<OwnerAuthority> listOwnerAuthority) {
		this.listOwnerAuthority = listOwnerAuthority;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setDictType(String dictType) {
		this.dictType = dictType;
	}

	public void setJsonStr(String jsonStr) {
		this.jsonStrArray = jsonStr;
	}

	public String getMsgStr() {
		return msgStr;
	}

	public void setMsgStr(String msgStr) {
		this.msgStr = msgStr;
	}

	public void setEntityId(Long entityId) {
		this.entityId = entityId;
	}

	public Long getSiteId() {
		return siteId;
	}

	public Long getEntityId() {
		return entityId;
	}

	public String getDictType() {
		return dictType;
	}

	public String getType() {
		return type;
	}

	public String getJsonStr() {
		return jsonStrArray;
	}

	public List<OwnerAuthority> getListOwnerAuthority() {
		return listOwnerAuthority;
	}

	public List<EntityAuthority> getListAuthority() {
		return listAuthority;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public String getIsApplySuper() {
		return isApplySuper;
	}

	public void setIsApplySuper(String isApplySuper) {
		this.isApplySuper = isApplySuper;
	}

}
