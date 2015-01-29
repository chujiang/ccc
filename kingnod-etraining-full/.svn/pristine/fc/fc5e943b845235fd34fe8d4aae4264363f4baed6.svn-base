package com.kingnod.etraining.organization.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.entity.RecordStatus;
import com.kingnod.core.exception.Exceptions;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.core.util.web.Struts2Utils;
import com.kingnod.etraining.common.ObjectType;
import com.kingnod.etraining.common.ui.components.TreeNode;
import com.kingnod.etraining.organization.dao.UserDAO;
import com.kingnod.etraining.organization.dao.UserGroupDAO;
import com.kingnod.etraining.organization.dao.UserPropertyDataDAO;
import com.kingnod.etraining.organization.entity.Organization;
import com.kingnod.etraining.organization.entity.Site;
import com.kingnod.etraining.organization.entity.User;
import com.kingnod.etraining.organization.entity.UserGroup;
import com.kingnod.etraining.organization.entity.UserPropertyData;
import com.kingnod.etraining.organization.service.OrganizationService;
import com.kingnod.etraining.organization.service.SiteService;
import com.kingnod.etraining.organization.service.UserPropertyDataService;
import com.kingnod.etraining.organization.service.UserService;
import com.kingnod.etraining.security.PermisssionService;

@org.springframework.stereotype.Service
public class UserServiceImpl implements UserService, UserPropertyDataService {

	@Autowired
	private UserDAO userDAO;
	@Autowired
	private UserGroupDAO userGroupDAO;
	@Autowired
	private SiteService siteService;
	@Autowired
	private OrganizationService organizationService;
	
	@Autowired
	private PermisssionService permisssionService;

	public User getUser(Long id) {
		return userDAO.get(id);
	}

	public int saveUser(User user) {
		int count = 0;
		IdEntity<Long> idEntity = (IdEntity) user;
		if (null != idEntity.getId() && null != userDAO.get(idEntity.getId())) {
			count = userDAO.update(user);
			this.saveUserPropertyData(user.getPropertyData());
		} else {
//			Organization organization = organizationService
//					.getOrganization(user.getOrganizationId());
//			user.setSiteId(organization.getSiteId());
			
			CriteriaBuilder cb = Cnd.builder(User.class);
			cb.andEQ("loginName", user.getLoginName());
			cb.andEQ("siteId", user.getSiteId());
			int nameCount=userDAO.countByCriteria(cb.buildCriteria());
//			Criteria criteria = cb.buildCriteria();
//			List userList = userDAO.findByCriteria(criteria);
			if(nameCount>0) { // 用户名是否已注册
				throw Exceptions.createAppException("org001001");
			} else {
				count = userDAO.insert(user);
				UserPropertyData upd = user.getPropertyData();
				upd.setUserId(user.getId());
				this.saveUserPropertyData(upd);
			}
		}
		return count;
	}

	public int deleteUser(User user) {
		return userDAO.delete(user);
	}

	public int deleteUserByIds(Long[] ids) {
		for (Long id : ids) {
			deleteUserPropertyData(id);
		}
		return userDAO.deleteById(ids);
	}
	
	public void deleteUserPropertyData(Long userId){
		CriteriaBuilder cb = Cnd.builder(UserPropertyData.class);
		cb.andEQ("userId", userId);
		userPropertyDataDAO.deleteByCriteria(cb.buildCriteria());
	}
	
	/**
	 * 判断当前用户是否被其他用户引用
	 * 
	 * @param userId
	 */
	public List<User> getUserManager(List<Long> userId){
		CriteriaBuilder cb = Cnd.builder(User.class);
		cb.andIn("managerId", userId);
		return userDAO.findByCriteria(cb.buildCriteria());
	}

	public PagingResult<User> findUser(Criteria criteria) {
		return userDAO.findPagingResult(criteria);
	}

	// 用户配置属性
	@Autowired
	protected UserPropertyDataDAO userPropertyDataDAO;

	public UserPropertyData getUserPropertyData(Long id) {
		return userPropertyDataDAO.get(id);
	}

	public int saveUserPropertyData(UserPropertyData userPropertyData) {
		int count = 0;
		IdEntity<Long> idEntity = (IdEntity) userPropertyData;
		if (null != idEntity.getId()
				&& null != userPropertyDataDAO.get(idEntity.getId())) {
			count = userPropertyDataDAO.update(userPropertyData);
		} else {
			count = userPropertyDataDAO.insert(userPropertyData);
		}
		return count;
	}

	public int deleteUserPropertyData(UserPropertyData userPropertyData) {
		return userPropertyDataDAO.delete(userPropertyData);
	}

	public int deleteUserPropertyDataByIds(Long[] ids) {
		return userPropertyDataDAO.deleteById(ids);
	}

	public PagingResult<UserPropertyData> findUserPropertyData(Criteria criteria) {
		return userPropertyDataDAO.findPagingResult(criteria);
	}

	public List<TreeNode> getObjectListByTree(Long nodeId, String nodeType,
			List<String> filterTypes) {
		List<TreeNode> listTree = new ArrayList<TreeNode>();
		if ("".equals(nodeType)) {
			listTree.addAll(getSiteList(nodeId));
		} else if (TreeNode.SITE.equals(nodeType)) {
			if(filterTypes.contains(TreeNode.SITE)){
				listTree.addAll(getSiteList(nodeId));
			}
			if(filterTypes.contains(TreeNode.ORGANIZATION)){
				listTree.addAll(getOrganizationList(nodeId));
			}
			if(filterTypes.contains(TreeNode.USER_GROUP)){
				listTree.addAll(getUserGroupList(nodeId));
			}
		} else if (TreeNode.ORGANIZATION.equals(nodeType)) {
			if(filterTypes.contains(TreeNode.ORGANIZATION)){
				listTree.addAll(getOrganizationList(nodeId));
			}
			if(filterTypes.contains(TreeNode.USER)){
				listTree.addAll(getUserList(nodeId));
			}
		}

		return listTree;
	}
	
	public List<TreeNode> getSiteList(Long parentId){
		List<TreeNode> listTree = new ArrayList<TreeNode>();
		CriteriaBuilder siteCb = Cnd.builder(Site.class);
		siteCb.andEQ("parentId", parentId).andEQ("recordStatus",	RecordStatus.ACTIVE);
		List<Site> sitelist = (siteService.findSite(siteCb.buildCriteria())).getResult();
		for (Site site : sitelist) {
			TreeNode tn = new TreeNode(site.getId().toString(),	String.valueOf(site.getParentId()), site.getName(),	true);
			tn.setNodeType(TreeNode.SITE);
			tn.setIcon(Struts2Utils.getRequest().getContextPath() + "/img/tree/site.gif");
			listTree.add(tn);
		}
		return listTree;
	}
	
	public List<TreeNode> getOrganizationList(Long parentId){
		List<TreeNode> listTree = new ArrayList<TreeNode>();
		CriteriaBuilder orgCb = Cnd.builder(Organization.class);
		orgCb.andEQ("siteId", parentId).andIsNull("parentId").andEQ("recordStatus", RecordStatus.ACTIVE);
		List<Organization> orglist = (organizationService.findOrganization(orgCb.buildCriteria())).getResult();
		for (Organization org : orglist) {
			TreeNode tn = new TreeNode(org.getId().toString(), org.getName(), true);
			tn.setNodeType(TreeNode.ORGANIZATION);
			tn.setIcon(Struts2Utils.getRequest().getContextPath() + "/img/tree/org.gif");
			listTree.add(tn);
		}
		return listTree;
	}
	
	public List<TreeNode> getUserList(Long parentId){
		List<TreeNode> listTree = new ArrayList<TreeNode>();
		CriteriaBuilder userCb = Cnd.builder(User.class);
		userCb.andEQ("organizationId", parentId).andEQ("recordStatus",RecordStatus.ACTIVE);
		List<User> userlist = userDAO.findByCriteria(userCb.buildCriteria());
		for (User user : userlist) {
			TreeNode tn = new TreeNode(user.getId().toString(),	user.getFullName(), true);
			tn.setNodeType(TreeNode.USER);
			tn.setIcon(Struts2Utils.getRequest().getContextPath()+ "/img/tree/user.gif");
			tn.setOpenMode("script");
			listTree.add(tn);
		}
		return listTree;
	}
	
	public List<TreeNode> getUserGroupList(Long parentId){
		List<TreeNode> listTree = new ArrayList<TreeNode>();
		CriteriaBuilder userGroupCb = Cnd.builder(UserGroup.class);
		userGroupCb.andEQ("siteId", parentId).andEQ("recordStatus",RecordStatus.ACTIVE);
		List<UserGroup> userGrouplist = userGroupDAO.findByCriteria(userGroupCb.buildCriteria());
		for (UserGroup userGroup : userGrouplist) {
			TreeNode tn = new TreeNode(userGroup.getId().toString(), userGroup.getName(), true);
			tn.setNodeType(TreeNode.USER_GROUP);
			tn.setIcon(Struts2Utils.getRequest().getContextPath()+ "/img/tree/user.gif");
			tn.setOpenMode("script");
			listTree.add(tn);
		}
		return listTree;
	}
	
	/**
	 * 根据站点查询用户
	 * @param siteId
	 * @return List<User>
	 */
	public List<User> getUserBySiteId(Map<String,Object> map){
		List<User> listUser = new ArrayList<User>();
    	Object obj = map.get("siteId");
    	if(obj instanceof List){
    		List<Long> listSiteId = (List<Long>)obj;
    		for(Long siteId : listSiteId){
    			CriteriaBuilder siteCb = Cnd.builder(User.class);
        		siteCb.andEQ("siteId", siteId);
        		if(map.get("name") != null){
        			siteCb.andGroup(Cnd.builder().andLike("full_Name", map.get("name").toString()).orLike("login_Name", map.get("name").toString()));
        		}
        		listUser.addAll(userDAO.findByCriteria(siteCb.buildCriteria()));
    		}
    	}
		return listUser;
	}
	
	public List<User> findAllReadableAdministrator() {
		CriteriaBuilder criteriaBuilder = Cnd.builder(User.class);
		criteriaBuilder.andEQ("recordStatus", RecordStatus.ACTIVE);
		criteriaBuilder.andEQ("administrator", true);
		criteriaBuilder.andNotEQ("id", 0L);
		
		Criteria criteria = criteriaBuilder.buildCriteria();
		criteria.addParam("columnName", "Y.ORGANIZATION_ID");
		criteria.addParam("hierarchyTableName", "ORG_ORGANIZATION_HIERARCHY");
		permisssionService.addPermissionParams(criteria, ObjectType.O_OS, ObjectType.O_OO);
		
		return userDAO.findAllReadByCriteria(criteria);
	}
	
	public List<User> findAllReadableAdministrator(Map<String,Object> map) {
		CriteriaBuilder criteriaBuilder = Cnd.builder(User.class);
		criteriaBuilder.andEQ("recordStatus", RecordStatus.ACTIVE);
		criteriaBuilder.andEQ("administrator", true);
		criteriaBuilder.andNotEQ("id", 0L);
		
		if(map != null && map.size() > 0 && map.get("name") != null){
			criteriaBuilder.andLike("fullName", map.get("name").toString());
		}
    	
		Criteria criteria = criteriaBuilder.buildCriteria();
		criteria.addParam("columnName", "Y.ORGANIZATION_ID");
		criteria.addParam("hierarchyTableName", "ORG_ORGANIZATION_HIERARCHY");
		permisssionService.addPermissionParams(criteria, ObjectType.O_OS, ObjectType.O_OO);
    	
		return userDAO.findAllReadByCriteria(criteria);
	}
	
	public List<User> findNoSendNoticeEnrollByCriteria(Criteria criteria) {
	  return userDAO.findNoSendNoticeEnrollByCriteria(criteria)	;
	}

	public UserPropertyData getIdByLoginName(String loginName, Long siteId) {
		  return userPropertyDataDAO.getIdByLoginName(loginName, siteId);
	}

	public List<User> getUsersForExport(Long siteId) {
		return userDAO.getUsersForExport(siteId);
	}
	
}	
