package com.kingnod.etraining.organization.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.xwork.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.extensions.struts2.action.EntityAction;
import com.kingnod.core.extensions.struts2.action.FilterableEntityAction;
import com.kingnod.core.extensions.struts2.annotation.ErrorMapping;
import com.kingnod.core.util.collection.MapUtils;
import com.kingnod.core.util.web.Struts2Utils;
import com.kingnod.etraining.common.entity.Role;
import com.kingnod.etraining.common.entity.RoleRef;
import com.kingnod.etraining.common.service.NoticeService;
import com.kingnod.etraining.common.service.RoleRefService;
import com.kingnod.etraining.common.service.RoleService;
import com.kingnod.etraining.organization.entity.Organization;
import com.kingnod.etraining.organization.entity.Site;
import com.kingnod.etraining.organization.entity.User;
import com.kingnod.etraining.organization.entity.UserProperties;
import com.kingnod.etraining.organization.service.OrganizationService;
import com.kingnod.etraining.organization.service.SiteService;
import com.kingnod.etraining.organization.service.UserPropertiesService;
import com.kingnod.etraining.organization.service.UserService;

@org.springframework.stereotype.Controller
@Namespace("/org")
@Results({
		@Result(name = EntityAction.RELOAD, type = "redirectAction", params = { "actionName", "user", "namespace", "/org", "organizationId",
				"${organizationId}", "siteId", "${siteId}", "groupId", "${groupId}", "entityType", "${entityType}" }),
		@Result(name = "userRole", location = "/WEB-INF/content/org/user_role.jsp", params = { "actionName", "user", "userId", "${userId }" }),
		@Result(name = "viewProperties", location = "/WEB-INF/content/org/user_view_properties.jsp", params = { "actionName", "user", "userId", "${userId }" }),
		@Result(name = "userList", location = "/WEB-INF/content/org/user.jsp", params = { "actionName", "user", "siteId", "${siteId }", "organizationId",
				"${organizationId}" }) })
@com.kingnod.core.annotation.Generated("2012-02-01 14:07")
@ErrorMapping(method = "save")
public class UserAction extends FilterableEntityAction<User, Long> {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	@com.kingnod.core.annotation.Generated("2012-02-01 14:07")
	private UserService userService;

	@Autowired
	private UserPropertiesService userPropertiesService;

	@Autowired
	private SiteService siteService;// 站点

	@Autowired
	private RoleRefService roleRefService;

	@Autowired
	private RoleService roleService;
	
	@Autowired
	private NoticeService noticeService;
	
	@Autowired
	private OrganizationService organizationService;

	private Long organizationId;
	private Long siteId;
	private Long userGroupId;
	private Long userId;
	private String entityType;
	private List<Role> allRole = new ArrayList<Role>();
	private List<Role> userRole = new ArrayList<Role>();
	private List<UserProperties> userProperties;
	private List<Long> listSiteId = new ArrayList<Long>();// 当前站点以及父节点
	private String managerName;
	private boolean includeSubFolderVal;

	public Long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}

	@com.kingnod.core.annotation.Generated("2012-02-01 14:07")
	public String filterDefines() {
		return "org.userFilterItems";
	}

	@com.kingnod.core.annotation.Generated("2012-02-01 14:07")
	protected Object getEntityService() {
		return this.userService;
	}


	@Override
	public String save()throws Exception{
			boolean flag = false ;
			if(this.entity.getId() == null) flag =true;
			super.save();
			 if(flag)
				if(!StringUtils.isEmpty(this.entity.getEmail())){
					//原有siteId 参数替换为 0 ，为了方便测试
					noticeService.sendNoticeMailBySystem(noticeService.NOTICE_TYPE_A_REG, this.entity.getEmail(), siteId, this.entity);
				}
		return RELOAD;
	}
	
	@Override
	protected void afterPreparedCriteriaBuilder(CriteriaBuilder cb) {
		if (!includeSubFolderVal) { 
			cb.andNotEQ("id", 0L);
			if (organizationId != null)
				cb.andEQ("organizationId", organizationId);
			if (siteId != null) {
				cb.andEQ("siteId", siteId);
			}
		}
	}

	@SuppressWarnings("rawtypes")
	protected Map preparedCriteriaParams() {
		Map params = MapUtils.mapByAarray("userGroupId", userGroupId);
		if (includeSubFolderVal) {
			params.put("organizationId", organizationId);
		} 
		return params;
	}

	@Override
	protected void prepareModel() throws Exception {
		super.prepareModel();
		// 调用UserPropertiesService的方法获取一个List<UserProperties>设置到userProperties
		userProperties = userPropertiesService.findListBySiteId(siteId);
	}
	
	/**
	 * 删除用户之前，判断是否有其他用户引用为上级
	 * 
	 * @return String
	 */
	public String getUserReference(){
		String str = request.getParameter("ids");
		List<User> lists = userService.getUserManager(getIdsList(str));
		if(lists != null && lists.size() > 0){
			ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonRoot", "当前选中用户被其他用户引用，不能删除");
		}else{
			ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonRoot", true);
		}
		return "jsonResult";
	}

	/**
	 * 获取父节点Id，祖父节点Id
	 * 
	 * @param pSiteId
	 */
	public void getParentSiteId(Long pSiteId) {
		if (pSiteId != 0) {
			Site site = siteService.getSite(pSiteId);
			listSiteId.add(site.getParentId());
			getParentSiteId(site.getParentId());
		}
	}

	/**
	 * 获取当前站点以及当前站点以上站点的角色
	 * 
	 * @return
	 */
	public List<Role> getAllRoleBySiteId() {
		listSiteId.clear();
		listSiteId.add(siteId);
		getParentSiteId(siteId);

		List<Role> listRole = new ArrayList<Role>();
		for (Long id : listSiteId) {
			listRole.addAll(roleService.findRoleBySiteId(id));
		}
		return listRole;
	}

	/**
	 * 查询当前用户下的所有角色
	 * 
	 * @return String
	 */
	public String awardRoleToUser() {
		allRole = getAllRoleBySiteId();
		userRole = roleService.getRoleByUser(userId);
		allRole.removeAll(userRole);
		return "userRole";
	}

	/**
	 * 给用户赋角色
	 * 
	 * @return String
	 * @throws Exception
	 */
	public String applicationUserRole() {
		List<Long> aIds = new ArrayList<Long>();
		String[] ids = request.getParameter("ids").split(",");
		for (String str : ids) {
			Long aid = parseLong(str);
			if (aid != null) {
				aIds.add(aid);
			}
		}

		roleRefService.delRoleByUser(userId);// 删除用户原有角色
		for (Long roleId : aIds) {
			RoleRef roleRef = new RoleRef();
			roleRef.setOwnerId(userId);
			roleRef.setOwnerType("U");
			roleRef.setRoleId(roleId);
			roleRefService.saveRoleRef(roleRef);// 添加新角色
		}
		return awardRoleToUser();
	}

	public List<Long> getIdsList(String ids){
		List<Long> list = new ArrayList<Long>();
		if(StringUtils.isNotEmpty(ids)){
			String[] id = ids.split(",");
			for (String string : id) {
				Long idL = parseLong(string);
				if(idL != null){
					list.add(idL);
				}
			}
		}
		return list;
	}
	/**
	 * 将字符串强转成Long类型
	 * 
	 * @param str
	 * @return Long
	 */
	public Long parseLong(String str) {
		try {
			return StringUtils.isNotEmpty(str) ? Long.parseLong(str) : null;
		} catch (Exception e) {

		}
		return null;
	}

	/**
	 * 返回用户列表
	 * 
	 * @return String
	 */
	public String getBack() {
		return "userList";
	}

	/**
	 * 新增/修改
	 * 
	 * @return String
	 */
	@Override
	public String input() throws Exception {
		String userId = request.getParameter("ids");
		if (null != userId && !userId.equals("")) {
			Long managerId = entity.getManagerId();
			if (null != managerId)
				managerName = ((User) userService.getUser(managerId)).getFullName();
		}
		if (null == entity.getId()) {
			entity.setAdministrator(false);
			entity.setStatus("A");
			CriteriaBuilder cb = Cnd.builder(Organization.class);
			cb.andEQ("id", entity.getOrganizationId());
			List<Organization> orgList=organizationService.findOrganization(cb.buildCriteria()).getResult();
			for (Organization organization : orgList) {
				if(null!=organization.getManagerId()){
					managerName = ((User) userService.getUser(organization.getManagerId())).getFullName();
					entity.setManagerId(organization.getManagerId()); 
				}
			}
		}
		return super.input();
	}
	
	public String viewProperties() {
		Long userId = Long.valueOf(request.getParameter("ids"));
		entity=userService.getUser(userId);
		this.getValueStack().push(entity);
		return "viewProperties";
		
	}

	public List<Role> getAllRole() {
		return allRole;
	}

	public void setAllRole(List<Role> allRole) {
		this.allRole = allRole;
	}

	public List<Role> getUserRole() {
		return userRole;
	}

	public void setUserRole(List<Role> userRole) {
		this.userRole = userRole;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public List<UserProperties> getUserProperties() {
		return userProperties;
	}

	public void setUserProperties(List<UserProperties> userProperties) {
		this.userProperties = userProperties;
	}

	public Long getSiteId() {
		return siteId;
	}

	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}

	public Long getUserGroupId() {
		return userGroupId;
	}

	public void setUserGroupId(Long userGroupId) {
		this.userGroupId = userGroupId;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public boolean isIncludeSubFolderVal() {
		return includeSubFolderVal;
	}

	public void setIncludeSubFolderVal(boolean includeSubFolderVal) {
		this.includeSubFolderVal = includeSubFolderVal;
	}
	
	public String getEntityType() {
		return entityType;
	}

	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}
}