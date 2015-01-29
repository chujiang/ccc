package com.kingnod.etraining.organization.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.criteria.Logic;
import com.kingnod.core.criteria.Operator;
import com.kingnod.core.criteria.Order;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.entity.RecordStatus;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.core.util.DateUtils;
import com.kingnod.core.util.SecurityUtils;
import com.kingnod.core.util.SpringUtils;
import com.kingnod.core.util.collection.ListUtils;
import com.kingnod.core.util.collection.MapUtils;
import com.kingnod.etraining.common.NoticeType;
import com.kingnod.etraining.common.ObjectType;
import com.kingnod.etraining.common.service.NoticeService;
import com.kingnod.etraining.common.service.impl.NoticeThreadServiceImpl;
import com.kingnod.etraining.organization.dao.OrganizationDAO;
import com.kingnod.etraining.organization.dao.SiteDAO;
import com.kingnod.etraining.organization.dao.UserDAO;
import com.kingnod.etraining.organization.dao.UserGroupDAO;
import com.kingnod.etraining.organization.dao.UserGroupFilterDAO;
import com.kingnod.etraining.organization.dao.UserGroupUsersDAO;
import com.kingnod.etraining.organization.dao.UserPropertiesDAO;
import com.kingnod.etraining.organization.entity.Organization;
import com.kingnod.etraining.organization.entity.Site;
import com.kingnod.etraining.organization.entity.User;
import com.kingnod.etraining.organization.entity.UserGroup;
import com.kingnod.etraining.organization.entity.UserGroupFilter;
import com.kingnod.etraining.organization.entity.UserGroupUsers;
import com.kingnod.etraining.organization.entity.UserProperties;
import com.kingnod.etraining.organization.service.UserGroupFilterService;
import com.kingnod.etraining.organization.service.UserGroupService;
import com.kingnod.etraining.organization.service.UserGroupUsersService;
import com.kingnod.etraining.security.PermisssionService;
import com.kingnod.etraining.security.entity.BitMapping;

@org.springframework.stereotype.Service
public class UserGroupServiceImpl implements UserGroupService, UserGroupFilterService, UserGroupUsersService {

	@Autowired
	protected UserGroupDAO			userGroupDAO;

	@Autowired
	protected UserGroupFilterDAO	userGroupFilterDAO;

	@Autowired
	protected UserPropertiesDAO		userPropertiesDAO;

	@Autowired
	protected UserGroupUsersDAO		userGroupUsersDAO;

	@Autowired
	protected UserDAO				userDAO;

	@Autowired
	protected PermisssionService	permisssionService;

	@Autowired
	protected NoticeService			noticeService;

	@Autowired
	protected UserGroupUsersDAO		userGroupUserDAO;

	@Autowired
	protected SiteDAO				siteDAO;
	
	@Autowired
	protected OrganizationDAO		organizationDAO;

	// ******* UserGroupService Implement *******

	public UserGroup getUserGroup(Long id) {
		return userGroupDAO.get(id);
	}

	public int saveUserGroup(UserGroup userGroup) {
		int count = 0;
		IdEntity<Long> idEntity = (IdEntity) userGroup;
		if (null != idEntity.getId() && null != userGroupDAO.get(idEntity.getId())) {
			count = userGroupDAO.update(userGroup);
		}
		else {
			count = userGroupDAO.insert(userGroup);
			permisssionService.saveBitMapping(BitMapping.USER_GROUP, userGroup.getId());
		}
		return count;
	}

	public int deleteUserGroup(UserGroup userGroup) {
		int result = userGroupDAO.delete(userGroup);
		permisssionService.resetBitMapping(BitMapping.USER_GROUP, userGroup.getId());
		return result;
	}

	public int deleteUserGroupByIds(Long[] ids) {
		int result = userGroupDAO.deleteById(ids);
		for (Long id : ids) {
			permisssionService.resetBitMapping(BitMapping.USER_GROUP, id);
		}
		return result;
	}

	public PagingResult<UserGroup> findUserGroup(Criteria criteria) {
		return userGroupDAO.findPagingResult(criteria);
	}

	// ******* UserGroupFilterService Implement *******

	public UserGroupFilter getUserGroupFilter(Long id) {
		return userGroupFilterDAO.get(id);
	}

	public int saveUserGroupFilter(UserGroupFilter userGroupFilter) {
		int count = 0;
		IdEntity<Long> idEntity = (IdEntity) userGroupFilter;
		if (null != idEntity.getId() && null != userGroupFilterDAO.get(idEntity.getId())) {
			count = userGroupFilterDAO.update(userGroupFilter);
		}
		else {
			count = userGroupFilterDAO.insert(userGroupFilter);
		}
		return count;
	}
	
	public int saveUserGroupFilter(UserGroupFilter userGroupFilter, String batchIds) {
		int addCnt = 0;
		if(StringUtils.isNotEmpty(batchIds)) {
			for(String id : batchIds.split(",")) {
				Long groupNumber = getGroupNumber();
				UserGroupFilter filter = userGroupFilter;
				filter.setGroupNumber(NumberUtils.toInt(groupNumber.toString()));
				filter.setFilterValue(id);
				filter.setId(null);
				saveUserGroupFilter(filter);
				addCnt++;
			}
		}
		return addCnt;
	}

	public int deleteUserGroupFilter(UserGroupFilter userGroupFilter) {
		return userGroupFilterDAO.delete(userGroupFilter);
	}

	public int deleteUserGroupFilterByIds(Long[] ids) {
		return userGroupFilterDAO.deleteById(ids);
	}

	public PagingResult<UserGroupFilter> findUserGroupFilter(Criteria criteria) {
		return userGroupFilterDAO.findPagingResult(criteria);
	}

	// ******* UserGroupUsersService Implement *******

	public UserGroupUsers getUserGroupUsers(Long id) {
		return userGroupUsersDAO.get(id);
	}

	public int saveUserGroupUsers(UserGroupUsers userGroupUsers) {
		int count = 0;
		IdEntity<Long> idEntity = (IdEntity) userGroupUsers;
		if (null != idEntity.getId() && null != userGroupUsersDAO.get(idEntity.getId())) {
			count = userGroupUsersDAO.update(userGroupUsers);
		}
		else {
			count = userGroupUsersDAO.insert(userGroupUsers);
		}
		return count;
	}

	public int deleteUserGroupUsers(UserGroupUsers userGroupUsers) {
		return userGroupUsersDAO.delete(userGroupUsers);
	}

	public int deleteUserGroupUsersByIds(Long[] ids) {
		return userGroupUsersDAO.deleteById(ids);
	}

	public PagingResult<UserGroupUsers> findUserGroupUsers(Criteria criteria) {
		criteria.addParam("isQuery", "true");
		PagingResult<UserGroupUsers> pagingResult = userGroupUsersDAO.findPagingResult(criteria);
		List<UserGroupUsers> userGroupUsers = pagingResult.getResult();
		if(ListUtils.isNotEmpty(userGroupUsers)) {
			for(UserGroupUsers user : userGroupUsers) {
				CriteriaBuilder cb = Cnd.builder(Organization.class);
				cb.addParam("organizationID", user.getOrgid()).orderBy("hierarchy_level", Order.DESC);
				List<Organization> organizationList = organizationDAO.findhierarchyByChildId(cb.buildCriteria());
				String hierarchyName = "";
				for (Organization organization : organizationList) {
					hierarchyName += "/" + organization.getName();
				}
				user.setChildName(hierarchyName);
			}
		}
		return pagingResult;
	}

	public void mergeCondition(List<Long> ids) {
		Long gnum = userGroupFilterDAO.getGroupNumber();
		userGroupFilterDAO.mergeCondition(MapUtils.mapByAarray("groupNumber", gnum, "ids", ids));
	}

	public void cancelMerge(List<Long> ids) {
		userGroupFilterDAO.cancelMerge(MapUtils.mapByAarray("ids", ids));
	}

	public Long getGroupNumber() {
		Long groupNumber = userGroupFilterDAO.getGroupNumber();
		return groupNumber;
	}

	/**
	 * 定时刷新所有的用户组用户
	 */
	public void refreshAllUserGroupMember() {
		List<UserGroup> userGroupList = userGroupDAO.findAll();
		for (UserGroup userGroup : userGroupList) {
			refreshMember(userGroup);
		}
	}

	/**
	 * 用户组成员_刷新
	 */
	public void refreshMember(UserGroup userGroup) {
		List<UserGroupFilter> filters = userGroupFilterDAO.findByUserGroupId(userGroup.getId());
		CriteriaBuilder cb = Cnd.builder(User.class);
		CriteriaBuilder cbGroup = Cnd.builder(User.class);
		Map<Integer, CriteriaBuilder> groupMap = MapUtils.newMap();
		for (UserGroupFilter userGroupFilter : filters) {
			cbGroup = groupMap.get(userGroupFilter.getGroupNumber());
			if (cbGroup == null) {
				cbGroup = Cnd.builder();
				groupMap.put(userGroupFilter.getGroupNumber(), cbGroup);
			}
			addCriterion(cbGroup, userGroupFilter, Logic.AND, userGroup);
		}
		Collection<CriteriaBuilder> groupList = groupMap.values();
		for (CriteriaBuilder cg : groupList) {
			cb.orGroup(cg);
		}
		if (filters == null || filters.size() == 0) { // 如果org_user_group_filter条件设置项为空，则将org_user_group_users表清空，同时不再新增用户组成员
			cb.andEQ("1", 2);
		}
		Criteria criteria = cb.buildCriteria();
		criteria.addParam("groupId", userGroup.getId());
		// List<Long> users = userDAO.findUserIdsByCriteria(criteria);
		// //获取所有符合条件的用户
		List<Long> newUsers = userDAO.findNewUserIdsByCriteria(criteria);// 查询满足用户组条件设置的新进来的用户
		List<Long> removedUsers = userDAO.findRemovedUserIdsByCriteria(criteria);// 查询不满足用户组条件的将被剔除的用户

		/*
		 * CriteriaBuilder userGroupIdCnd = Cnd.builder(UserGroupUsers.class);
		 * userGroupIdCnd.andIn("userId", removedUsers);
		 * userGroupIdCnd.andEQ("excluded", "0");
		 * userGroupUsersDAO.deleteByCriteria(userGroupIdCnd.buildCriteria());
		 */// 删除用户组中排除状态为“否”的用户

		if (!ListUtils.isEmpty(newUsers)) {// 将符合条件的新进来的用户插入org_user_group_users表
			CriteriaBuilder excludedUserCnd = Cnd.builder(UserGroupUsers.class);
			excludedUserCnd.andEQ("userGroupId", userGroup.getId());
			excludedUserCnd.andEQ("excluded", "1");
			excludedUserCnd.andEQ("A.RECORD_STATUS", "A");
			List<UserGroupUsers> excludedUsers = userGroupUsersDAO.findByCriteria(excludedUserCnd.buildCriteria().addParam("isQuery", "true"));
			for (int i = 0; excludedUsers != null && i < excludedUsers.size(); i++) { // 剔除用户组中排除状态为“是”的用户
				UserGroupUsers user = excludedUsers.get(i);
				if (newUsers.contains(user.getUserId())) {
					newUsers.remove(user.getUserId());
				}
			}

			for (Long userId : newUsers) {
				UserGroupUsers userGroupUsers = new UserGroupUsers();
				userGroupUsers.setUserId(userId);
				userGroupUsers.setUserGroupId(userGroup.getId());
				userGroupUsers.setExcluded(false);
				userGroupUsers.setIsNew("1");
				userGroupUsersDAO.insert(userGroupUsers);
			}
		}

		if (!ListUtils.isEmpty(removedUsers)) {
			Long currentUserId = 0L;
			UserDetails userDetails = SecurityUtils.getCurrentUser();
			if (null != userDetails && userDetails instanceof IdEntity) {
				IdEntity<Long> idEntity = (IdEntity<Long>) userDetails;
				currentUserId = null != idEntity.getId() ? idEntity.getId() : currentUserId;
			}
			/*  这里不采用循环方式会提高效率
			for (Long userId : removedUsers) { // 将不符合条件的用户从org_user_group_users表删除
				UserGroupUsers userGroupUsers = new UserGroupUsers();
				userGroupUsers.setUserId(userId);
				userGroupUsers.setUserGroupId(userGroup.getId());
				userGroupUsers.setRecordStatus(RecordStatus.INACTIVE);
				userGroupUsers.setUpdateDate(new Date());
				userGroupUsers.setUpdaterId(currentUserId);
				userGroupUsers.setIsNew("1");
				CriteriaBuilder removedUsersCb = Cnd.builder(UserGroupUsers.class).andEQ("userGroupId", userGroup.getId()).andEQ("userId", userId).andEQ("userId", userId);
				userGroupUsersDAO.updateByCriteria(userGroupUsers, removedUsersCb.buildCriteria());
			}
			*/
			//这里新增加了一个条件  andEQ("recordStatus", RecordStatus.ACTIVE) ,就是修改只是当前活动的用户
			UserGroupUsers userGroupUsers = new UserGroupUsers();
			userGroupUsers.setUserGroupId(userGroup.getId());
			userGroupUsers.setRecordStatus(RecordStatus.INACTIVE);
			userGroupUsers.setUpdateDate(new Date());
			userGroupUsers.setUpdaterId(currentUserId);
			userGroupUsers.setIsNew("1");
			CriteriaBuilder removedUsersCb = Cnd.builder(UserGroupUsers.class).andEQ("userGroupId", userGroup.getId()).andEQ("recordStatus", RecordStatus.ACTIVE);
			removedUsersCb.andIn("userId", removedUsers);
			userGroupUsersDAO.updateByCriteria(userGroupUsers, removedUsersCb.buildCriteria());
		}
		// 发送通知信息 @author maxudomg
		NoticeThreadServiceImpl noticethread = new NoticeThreadServiceImpl();
		noticethread.setUserGroup(userGroup);
		noticethread.setObjectType(ObjectType.O_UP);
		noticethread.setUserGroupService(this);
		Thread thread = new Thread(noticethread);
		thread.start();
		// sendNoticeUserGroupChange(userGroup);
	}

	/**
	 * 用户组条件拼装
	 * 
	 * @param cb
	 * @param userGroupFilter
	 * @param logic
	 */
	private void addCriterion(CriteriaBuilder cb, UserGroupFilter userGroupFilter, Logic logic, UserGroup userGroup) {
		String criterionName = ""; // 字段名
		Object filterValue = userGroupFilter.getFilterValue(); // 字段值
		Map params = MapUtils.newMap();
		if (ObjectType.O_UP == userGroupFilter.getType()) { // 1.用户配置属性
//			cb.andEQ("siteId", userGroup.getSiteId());
			params.put("siteId", userGroup.getSiteId());
			UserProperties userProperties = userPropertiesDAO.get(NumberUtils.toLong(userGroupFilter.getFilterName()));
			String propertyName = userProperties.getPropertyName();
			criterionName = "b." + propertyName.substring(0, 8) + "_" + propertyName.substring(8, propertyName.length());
			if ("D".equalsIgnoreCase(userProperties.getType())) { // 1.1 日期
//				criterionName = "to_date(" + criterionName + ",'yyyy-MM-dd')";
//				filterValue = DateUtils.parse(userGroupFilter.getFilterValue(), "yyyy-MM-dd");
				params.put("isDateType", true);
				
//				cb.add(Cnd.createCriterion(logic, "a.site_id", Operator.EQ, userGroup.getSiteId()));
			}
			else if ("C".equalsIgnoreCase(userProperties.getType())) { // 1.2复选框
				if("like".equals(userGroupFilter.getFilterOperator())) {
					criterionName = String.format("getDataIntersection(%s,'%s')", criterionName, filterValue);
					cb.andIsNotNull(criterionName);
					return;
				} else {
					filterValue = ((String)filterValue).replace(" ", "");
				}
			}
		}
		else if (ObjectType.O_OS == userGroupFilter.getType()) { // 2.站点
			criterionName = "siteId";
		}
		else if (ObjectType.O_OU == userGroupFilter.getType()) { // 3.用户
			criterionName = "id";
		}
		else if (ObjectType.O_OG == userGroupFilter.getType()) { // 4.用户组
			criterionName = "c.USER_GROUP_ID";
		}
		else if (ObjectType.O_OO == userGroupFilter.getType()) { // 5.组织
			criterionName = "organizationId";
		}
		if (criterionName != null) {
			Operator operator = Operator.valueOf(operators.get(userGroupFilter.getFilterOperator()));
			if (operator == Operator.LIKE) {
				filterValue = "%" + filterValue + "%";
			}
			cb.add(Cnd.createCriterion(logic, criterionName, operator, filterValue,params));
		}
	}

	/**
	 * 根据站点查询用户组
	 * 
	 * @param siteId
	 * @return List<UserGroup>
	 */
	public List<UserGroup> getUserGroupBySiteId(Map<String, Object> map) {
		List<UserGroup> listUserGroup = new ArrayList<UserGroup>();
		Object obj = map.get("siteId");
		if (obj instanceof List) {
			List<Long> listSiteId = (List<Long>) obj;
			for (Long siteId : listSiteId) {
				CriteriaBuilder siteCb = Cnd.builder(UserGroup.class);
				siteCb.andEQ("siteId", siteId);
				if (map.get("name") != null) {
					siteCb.andLike("name", map.get("name").toString());
				}
				listUserGroup.addAll(userGroupDAO.findByCriteria(siteCb.buildCriteria()));
			}
		}
		return listUserGroup;
	}

	private static Map<String, String>	operators	= MapUtils.map("=", "EQ", ">", "GT", ">=", "GE", "<", "LT", "<=", "LE", "like", "LIKE");

	public PagingResult<UserGroupUsers> findListByGroupId(Criteria criteria) {
		return userGroupUsersDAO.findListByGroupId(criteria);
	}

	/**
	 * 发送用户组变动通知
	 * 
	 * @author maxudong
	 */
	public void sendNoticeUserGroupChange(UserGroup userGroup) {
		if (noticeService.getNoticeSettingsStatus(ObjectType.O_UP, NoticeType.O_UG_CHANGE, userGroup.getId(), userGroup.getSiteId()) > 0) {

			// 通知区域

			// 获取未发送通知用户,并借以user entity 中的 recordStatus 来表示变更加入还是移除，
			// status来表示操作有系统完成还是手动完成
			CriteriaBuilder noticeUserCb = Cnd.builder(User.class);
			noticeUserCb.addParam("groupId", userGroup.getId());
			noticeUserCb.addParam("removeUser", SpringUtils.getMessage("org.userGroup_removeUsers")); // 暂时这样做，否则想新建立一个专门发用户组变动的
																										// entity
			noticeUserCb.addParam("addUser", SpringUtils.getMessage("org.userGroup_addUsers"));
			noticeUserCb.addParam("userOperating", SpringUtils.getMessage("org.userGroup_userOperating"));
			noticeUserCb.addParam("sysOperating", SpringUtils.getMessage("org.userGroup_sysOperating"));
			List<User> listUser = userDAO.findNoSendNoticeUserByCriteria(noticeUserCb.buildCriteria());

			if (!ListUtils.isEmpty(listUser)) { // 若无用户变动则不进行任何操作
				Map<String, Object> noticeData = new HashMap<String, Object>();

				Site site = siteDAO.get(userGroup.getSiteId()); // 获取siteEntity

				if (!StringUtils.isEmpty(userGroup.getDescription())) { // 此处出现Description为null
																		// 时FreeMarker替换出错
					noticeData.put("description", userGroup.getDescription());
				}
				else {
					noticeData.put("description", "");
				}
				noticeData.put("listUser", listUser);
				noticeData.put("groupName", userGroup.getName());
				noticeData.put("siteName", site.getName());

				// 系统通知
				noticeService.saveNoticeFromSettingsBySystem(ObjectType.O_UP, userGroup.getId(), NoticeType.O_UG_CHANGE, userGroup.getSiteId(), noticeData);
				// 设置状态isnew 为2 ,下次不发送通知
				setUserChangeStatus(userGroup, listUser);

			}
		}
	}

	/**
	 * @author maxudong
	 * @param userGroup
	 * @param listUser
	 *            改变用户状态
	 */
	public void setUserChangeStatus(UserGroup userGroup, List<User> listUser) {
		// 改变用户状态，下次不在发送通知
		CriteriaBuilder noticeUserGroupUserCb = Cnd.builder(UserGroupUsers.class);
		noticeUserGroupUserCb.andEQ("userGroupId", userGroup.getId());
		List listUserId = new ArrayList();
		for (User user : listUser) {
			listUserId.add(user.getId());
		}
		noticeUserGroupUserCb.andIn("userId", listUserId);
		UserGroupUsers userGroupUser = new UserGroupUsers();
		userGroupUser.setIsNew("2");
		userGroupUserDAO.updateByCriteria(userGroupUser, noticeUserGroupUserCb.buildCriteria());
	}

}
