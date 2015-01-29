package com.kingnod.etraining.activity.service.impl;

import java.util.ArrayList;
import java.util.Collection;
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
import com.kingnod.etraining.activity.dao.ActivityFolderDAO;
import com.kingnod.etraining.activity.dao.ElearningDAO;
import com.kingnod.etraining.activity.dao.EnrollLearnerDAO;
import com.kingnod.etraining.activity.dao.EnrollLearnerFilterDAO;
import com.kingnod.etraining.activity.dao.ExaminationDAO;
import com.kingnod.etraining.activity.dao.ExamineesHistoryDAO;
import com.kingnod.etraining.activity.entity.ActivityFolder;
import com.kingnod.etraining.activity.entity.Elearning;
import com.kingnod.etraining.activity.entity.EnrollLearner;
import com.kingnod.etraining.activity.entity.EnrollLearnerFilter;
import com.kingnod.etraining.activity.entity.Examination;
import com.kingnod.etraining.activity.service.EnrollLearnerFilterService;
import com.kingnod.etraining.activity.service.EnrollLearnerService;
import com.kingnod.etraining.common.NoticeType;
import com.kingnod.etraining.common.ObjectType;
import com.kingnod.etraining.common.service.NoticeService;
import com.kingnod.etraining.common.service.impl.NoticeThreadServiceImpl;
import com.kingnod.etraining.course.server.models.AtyCourseInfo;
import com.kingnod.etraining.course.server.models.FindAtyCourse;
import com.kingnod.etraining.exam.dao.PaperDAO;
import com.kingnod.etraining.exam.dao.TestGroupDAO;
import com.kingnod.etraining.organization.dao.OrganizationDAO;
import com.kingnod.etraining.organization.dao.SiteDAO;
import com.kingnod.etraining.organization.dao.UserDAO;
import com.kingnod.etraining.organization.dao.UserPropertiesDAO;
import com.kingnod.etraining.organization.entity.Organization;
import com.kingnod.etraining.organization.entity.Site;
import com.kingnod.etraining.organization.entity.User;
import com.kingnod.etraining.organization.entity.UserProperties;
/**
 * 
 * @author Huanghaibin
 * @TODO KET-596
 */
@org.springframework.stereotype.Service
public class EnrollLearnerServiceImpl implements EnrollLearnerService, EnrollLearnerFilterService {

	@Autowired
	protected EnrollLearnerDAO enrollLearnerDAO;

	@Autowired
	protected EnrollLearnerFilterDAO enrollLearnerFilterDAO;

	@Autowired
	protected UserDAO userDAO;

	@Autowired
	protected UserPropertiesDAO userPropertiesDAO;

	@Autowired
	protected ElearningDAO elearningDAO;

	@Autowired
	protected ExaminationDAO examinationDAO;

	@Autowired
	protected PaperDAO paperDAO;

	@Autowired
	protected TestGroupDAO testGroupDAO;

	@Autowired
	protected ExamineesHistoryDAO examineesHistoryDAO;

	@Autowired
	protected NoticeService noticeService;

	@Autowired
	FindAtyCourse findAtyCourse;

	@Autowired
	protected SiteDAO siteDAO;

	@Autowired
	protected ActivityFolderDAO activityFolderDAO;
	
	@Autowired
	protected OrganizationDAO organizationDAO;
	

	// ******* EnrollLearnerService Implement *******

	public EnrollLearner getEnrollLearner(Long id) {
		return enrollLearnerDAO.get(id);
	}

	public int saveEnrollLearner(EnrollLearner enrollLearner) {
		int count = 0;
		IdEntity<Long> idEntity = (IdEntity) enrollLearner;
		if (null != idEntity.getId() && null != enrollLearnerDAO.get(idEntity.getId())) {
			count = enrollLearnerDAO.update(enrollLearner);
		} else {
			count = enrollLearnerDAO.insert(enrollLearner);
		}
		return count;
	}

	public int deleteEnrollLearner(EnrollLearner enrollLearner) {
		return enrollLearnerDAO.delete(enrollLearner);
	}

	public int deleteEnrollLearnerByIds(Long[] ids) {
		return enrollLearnerDAO.deleteById(ids);
	}

	public PagingResult<EnrollLearner> findEnrollLearner(Criteria criteria) {
		criteria.addParam("isQuery", "true");
		PagingResult<EnrollLearner> pg=enrollLearnerDAO.findPagingResult(criteria);
		List<EnrollLearner> enrollLearnerList=pg.getResult();
		
		for (EnrollLearner enrollLearner : enrollLearnerList) {
			CriteriaBuilder cb = Cnd.builder(Organization.class);
			cb.addParam("organizationID", enrollLearner.getOrgid()).orderBy("hierarchy_level", Order.DESC);
			List<Organization> organizationList=organizationDAO.findhierarchyByChildId(cb.buildCriteria());
			String hierarchyName="";
			for (Organization organization : organizationList) {
				hierarchyName+="/"+organization.getName();
			}
			enrollLearner.setChildName(hierarchyName);
		}
		return pg;
	}

	// ******* EnrollLearnerFilterService Implement *******

	public EnrollLearnerFilter getEnrollLearnerFilter(Long id) {
		return enrollLearnerFilterDAO.get(id);
	}

	public int saveEnrollLearnerFilter(EnrollLearnerFilter enrollLearnerFilter) {
		int count = 0;
		IdEntity<Long> idEntity = (IdEntity) enrollLearnerFilter;
		if (null != idEntity.getId() && null != enrollLearnerFilterDAO.get(idEntity.getId())) {
			count = enrollLearnerFilterDAO.update(enrollLearnerFilter);
		} else {
			count = enrollLearnerFilterDAO.insert(enrollLearnerFilter);
		}
		return count;
	}
	

	public int saveEnrollLearnerFilter(EnrollLearnerFilter enrollLearnerFilter, String batchIds) {
		int addCnt = 0;
		if(StringUtils.isNotEmpty(batchIds)) {
			for(String id : batchIds.split(",")) {
				Long groupNumber = getGroupNumber();
				EnrollLearnerFilter filter = enrollLearnerFilter;
				filter.setGroupNumber(NumberUtils.toInt(groupNumber.toString()));
				filter.setFilterValue(id);
				filter.setEnrollMode("S");
				filter.setId(null);
				saveEnrollLearnerFilter(filter);
				addCnt++;
			}
		}
		return addCnt;
	}

	public int deleteEnrollLearnerFilter(EnrollLearnerFilter enrollLearnerFilter) {
		return enrollLearnerFilterDAO.delete(enrollLearnerFilter);
	}

	public int deleteEnrollLearnerFilterByIds(Long[] ids) {
		return enrollLearnerFilterDAO.deleteById(ids);
	}

	public PagingResult<EnrollLearnerFilter> findEnrollLearnerFilter(Criteria criteria) {
		return enrollLearnerFilterDAO.findPagingResult(criteria);
	}

	public void mergeCondition(List<Long> ids) {
		Long gnum = enrollLearnerFilterDAO.getGroupNumber();
		enrollLearnerFilterDAO.mergeCondition(MapUtils.mapByAarray("groupNumber", gnum, "ids", ids));
	}

	public Long getGroupNumber() {
		Long groupNumber = enrollLearnerFilterDAO.getGroupNumber();
		return groupNumber;
	}

	/**
	 * 定时刷新所有活动的学员列表
	 */
	public void refreshAllEnrollLearnerMember() {
		List<Elearning> elearningList = elearningDAO.findAll();
		for (Elearning elearning : elearningList) {
			refreshMember(elearning.getId(), ObjectType.A_EL);
			System.out.println("------------------------" + elearning.getName() + "--------------------------");
		}
	}

	/**
	 * 学员列表_刷新
	 */
	public void refreshMember_bak(Long activityId, ObjectType activityType) {
		Long siteId = enrollLearnerDAO.getSiteIdByActivityId(activityId, activityType);
		List<EnrollLearnerFilter> filters = enrollLearnerFilterDAO.findByActivityId(activityId, activityType);
		CriteriaBuilder cb = Cnd.builder(User.class);
		CriteriaBuilder cbGroup = Cnd.builder(User.class);
		Map<Integer, CriteriaBuilder> groupMap = MapUtils.newMap();
		for (EnrollLearnerFilter enrollLearnerFilter : filters) {
			cbGroup = groupMap.get(enrollLearnerFilter.getGroupNumber());
			if (cbGroup == null) {
				cbGroup = Cnd.builder();
				groupMap.put(enrollLearnerFilter.getGroupNumber(), cbGroup);
			}
			addCriterion(cbGroup, enrollLearnerFilter, Logic.AND);
		}
		Collection<CriteriaBuilder> groupList = groupMap.values();
		for (CriteriaBuilder cg : groupList) {
			cb.orGroup(cg);
		}
		if (filters == null || filters.size() == 0) { // 如果aty_enroll_learner_filter条件设置项为空，则将aty_enroll_learner表清空，同时不再新增学员
			cb.andEQ("1", 2);
		}
		Criteria criteria = cb.buildCriteria();
		criteria.addParam("siteId", siteId);
		List<Long> users = userDAO.findUserIdsByCriteria(criteria); // 获取所有符合条件的用户

		CriteriaBuilder enrollLearnerCnd = Cnd.builder(EnrollLearner.class);
		enrollLearnerCnd.andEQ("activityId", activityId);
		enrollLearnerCnd.andEQ("excluded", "0");
		enrollLearnerDAO.deleteByCriteria(enrollLearnerCnd.buildCriteria()); // 删除用户组中排除状态为“否”的用户

		CriteriaBuilder excludedUserCnd = Cnd.builder(EnrollLearner.class);
		excludedUserCnd.andEQ("activityId", activityId);
		excludedUserCnd.andEQ("excluded", "1");
		List<EnrollLearner> excludedUsers = enrollLearnerDAO.findByCriteria(excludedUserCnd.buildCriteria());
		for (int i = 0; excludedUsers != null && i < excludedUsers.size(); i++) { // 剔除用户组中排除状态为“是”的用户
			EnrollLearner user = excludedUsers.get(i);
			if (users.contains(user.getUserId())) {
				users.remove(user.getUserId());
			}
		}

		for (Long userId : users) { // 将符合条件的用户插入aty_enroll_learner表
			EnrollLearner enrollLearner = new EnrollLearner();
			enrollLearner.setUserId(userId);
			enrollLearner.setActivityId(activityId);
			enrollLearner.setExcluded(false);
			enrollLearner.setEnrollMode("F");
			enrollLearner.setStauts("R");
			enrollLearner.setActivityType(activityType);
			enrollLearnerDAO.insert(enrollLearner);
		}
	}

	/**
	 * 用户组条件拼装
	 * 
	 * @param cb
	 * @param userGroupFilter
	 * @param logic
	 */
	private void addCriterion(CriteriaBuilder cb, EnrollLearnerFilter enrollLearnerFilter, Logic logic) {
		String criterionName = ""; // 字段名
		Object filterValue = enrollLearnerFilter.getFilterValue(); // 字段值
		Map params = MapUtils.newMap();
		if (enrollLearnerFilter.getType() == ObjectType.O_UP) { // 1.用户配置属性			
			UserProperties userProperties = userPropertiesDAO.get(NumberUtils.toLong(enrollLearnerFilter.getFilterName()));
			params.put("siteId", userProperties.getSiteId());
			String propertyName = userProperties.getPropertyName();
			criterionName = "b." + propertyName.substring(0, 8) + "_" + propertyName.substring(8, propertyName.length());
			if ("D".equalsIgnoreCase(userProperties.getType())) { // 1.1 日期
//				criterionName = "to_date(" + criterionName + ",'yyyy-MM-dd')";
//				filterValue = DateUtils.parse(enrollLearnerFilter.getFilterValue(), "yyyy-MM-dd");
				params.put("isDateType", true);
			} else if ("C".equalsIgnoreCase(userProperties.getType())) { // 1.2
																			// 复选框
				criterionName = String.format("getDataIntersection(%s,'%s')", criterionName, filterValue);
				cb.andIsNotNull(criterionName);
				return;
			}
		} else if (enrollLearnerFilter.getType() == ObjectType.O_OS) { // 2.站点
			criterionName = "siteId";
		} else if (enrollLearnerFilter.getType() == ObjectType.O_OU) { // 3.用户
			criterionName = "id";
		} else if (enrollLearnerFilter.getType() == ObjectType.O_OG) { // 4.用户组
			criterionName = "c.USER_GROUP_ID";
		} else if (enrollLearnerFilter.getType() == ObjectType.O_OO) { // 5.组织
			criterionName = "organizationId";
		}
		if (criterionName != null) {
			Operator operator = Operator.valueOf(operators.get(enrollLearnerFilter.getFilterOperator()));
			cb.add(Cnd.createCriterion(logic, criterionName, operator, filterValue,params));
		}
	}

	private static Map<String, String> operators = MapUtils.map("=", "EQ", ">", "GT", ">=", "GE", "<", "LT", "<=", "LE", "like", "LIKE");

	/**
	 * 设置登记方式
	 */
	public void enrollModeModify(List<Long> ids, String enrollMode, boolean isEnrollLearner) {
		if (isEnrollLearner) { // 学员列表
			for (Long id : ids) {
				EnrollLearner filter = enrollLearnerDAO.get(id);
				filter.setEnrollMode(enrollMode);
				if (!"F".equals(enrollMode)) {	// 当ATY_ENROLL_LEARNER表的字段ENROLL_MODE为非强制的时候 stauts 默认为N:未注册
					filter.setStauts("N");
				} else {
					filter.setStauts("R");
				}
				enrollLearnerDAO.update(filter);
			}
		} else { // 条件设置
			for (Long id : ids) {
				EnrollLearnerFilter filter = enrollLearnerFilterDAO.get(id);
				filter.setEnrollMode(enrollMode);
				enrollLearnerFilterDAO.update(filter);
			}
		}
	}

	/**
	 * 根据活动ID，获取学员ID集合
	 */
	public String getIdsByActivityId(String activityId) {
		String ids = "";
		List<EnrollLearner> learners = enrollLearnerDAO.findByCriteria(Cnd.builder(EnrollLearner.class).andEQ("activityId", activityId).buildCriteria());
		for (EnrollLearner learner : learners) {
			Long id = learner.getUserId();
			ids += id + ",";
		}
		if (!StringUtils.isEmpty(ids))
			ids = StringUtils.substring(ids, 0, ids.length() - 1);
		return ids;
	}

	/**
	 * 定时刷新活动的学员列表 @author maxudong
	 */
	public void refreshMember(Long activityId, ObjectType activityType) {

		Long siteId = enrollLearnerDAO.getSiteIdByActivityId(activityId,activityType);
		List<EnrollLearnerFilter> filters = enrollLearnerFilterDAO.findByActivityId(activityId, activityType);
		CriteriaBuilder cb = Cnd.builder(User.class);
		CriteriaBuilder cbGroup = Cnd.builder(User.class);
		Map<Integer, CriteriaBuilder> groupMap = MapUtils.newMap();
		for (EnrollLearnerFilter enrollLearnerFilter : filters) {
			cbGroup = groupMap.get(enrollLearnerFilter.getGroupNumber());
			if (cbGroup == null) {
				cbGroup = Cnd.builder();
				groupMap.put(enrollLearnerFilter.getGroupNumber(), cbGroup);
			}
			addCriterion(cbGroup, enrollLearnerFilter, Logic.AND);
		}
		Collection<CriteriaBuilder> groupList = groupMap.values();
		for (CriteriaBuilder cg : groupList) {
			cb.orGroup(cg);
		}
		if (filters == null || filters.size() == 0) { // 如果aty_enroll_learner_filter条件设置项为空，则将aty_enroll_learner表清空，同时不再新增学员
			cb.andEQ("1", 2);
		}
		Criteria criteria = cb.buildCriteria();
		criteria.addParam("siteId", siteId);
		criteria.addParam("isEnrollLearner", true);

		/************************************************************************************************************************/
		criteria.addParam("activityId", activityId);
		criteria.addParam("activityType", activityType);
		List<Long> newUsers = userDAO.findNewEnrollIdsByCriteria(criteria);// 查询满足用户组条件设置的新进来的用户
		List<Long> removedUsers = userDAO.findRemovedEnrollIdsByCriteria(criteria);// 查询不满足用户组条件的将被剔除的用户

		if (!ListUtils.isEmpty(newUsers)) {// 将符合条件的新进来的用户插入aty_enroll_learner表
			CriteriaBuilder excludedUserCnd = Cnd.builder(EnrollLearner.class);
			excludedUserCnd.andEQ("activityId", activityId);
			excludedUserCnd.andEQ("excluded", "1");
			List<EnrollLearner> excludedUsers = enrollLearnerDAO.findByCriteria(excludedUserCnd.buildCriteria());
			for (int i = 0; excludedUsers != null && i < excludedUsers.size(); i++) { // 剔除用户组中排除状态为“是”的用户
				EnrollLearner user = excludedUsers.get(i);
				if (newUsers.contains(user.getUserId())) {
					newUsers.remove(user.getUserId());
				}
			}
			for (Long userId : newUsers) { // 将符合条件的用户插入aty_enroll_learner表
				EnrollLearner enrollLearner = new EnrollLearner();
				enrollLearner.setUserId(userId);
				enrollLearner.setActivityId(activityId);
				enrollLearner.setExcluded(false);
				enrollLearner.setEnrollMode("F");	//登记方式默认为F：强制
				enrollLearner.setStauts("R");		//状态默认为R：注册
				enrollLearner.setIsNew("1"); 		// 1 未新用户 未发送通知状态 2为已发送状态
				enrollLearner.setActivityType(activityType);
				enrollLearnerDAO.insert(enrollLearner);
			}
		}

		if (!ListUtils.isEmpty(removedUsers)) {
			Long currentUserId = 0L;
			UserDetails userDetails = SecurityUtils.getCurrentUser();
			if (null != userDetails && userDetails instanceof IdEntity) {
				IdEntity<Long> idEntity = (IdEntity<Long>) userDetails;
				currentUserId = null != idEntity.getId() ? idEntity.getId() : currentUserId;
			}
			CriteriaBuilder enrollLearnerCnd = Cnd.builder(EnrollLearner.class);
			enrollLearnerCnd.andEQ("activityId", activityId);
			enrollLearnerCnd.andEQ("excluded", "0");
			enrollLearnerCnd.andEQ("recordStatus", "A");
			enrollLearnerCnd.andIn("userId", removedUsers);
			EnrollLearner enrollLearner = new EnrollLearner();
			// 这里设置setUpdaterId 是为了区分是系统修改还是手动修改？
			enrollLearner.setUpdaterId(currentUserId);
			enrollLearner.setIsNew("1");
			enrollLearner.setRecordStatus(RecordStatus.INACTIVE);
			enrollLearnerDAO.updateByCriteria(enrollLearner, enrollLearnerCnd.buildCriteria());
		}
		/************************************************************************************************************************/
		NoticeThreadServiceImpl noticethread = new NoticeThreadServiceImpl();
		noticethread.setObjectId(activityId);
		noticethread.setObjectType(activityType);
		noticethread.setSiteId(siteId);
		noticethread.setEnrollLearnerService(this);
		Thread thread = new Thread(noticethread);
		thread.start();

	}

	/**
	 * 发送用户组变动通知
	 * 
	 * @author maxudong
	 */
	public void sendNoticeEnrollGroupChange(Long activityId, ObjectType activityType, NoticeType noticeType, Long siteId) {
		if (noticeService.getNoticeSettingsStatus(activityType, noticeType, activityId, siteId) > 0) {

			// 通知区域
			CriteriaBuilder noticeUserCb = Cnd.builder(User.class);
			noticeUserCb.addParam("activityId", activityId);
			noticeUserCb.addParam("isNew", "1");
			// 暂时这样做，否则想新建立一个专门发用户组变动的 entity
			noticeUserCb.addParam("removeUser", SpringUtils.getMessage("org.userGroup_removeUsers"));
			noticeUserCb.addParam("addUser", SpringUtils.getMessage("org.userGroup_addUsers"));
			noticeUserCb.addParam("userOperating", SpringUtils.getMessage("org.userGroup_userOperating"));
			noticeUserCb.addParam("sysOperating", SpringUtils.getMessage("org.userGroup_sysOperating"));

			// 获取未发送通知用户,并借以user entity 中的 recordStatus 来表示变更加入还是移除，status来表示操作有系统完成还是手动完成
			List<User> listUser = userDAO.findNoSendNoticeEnrollByCriteria(noticeUserCb.buildCriteria());

			
			if (!ListUtils.isEmpty(listUser)) { // 若无用户变动则不进行任何操作
				// 取出 AtyFolder 和 courser 信息
				Long folderId = null;
				String ObjectName = "";
				if (activityType.equals(ObjectType.A_EL)) {//取出在线学习数据
					Elearning elearning = elearningDAO.get(activityId);
					folderId = elearning.getFolderId();
					ObjectName = elearning.getName();
				}
				if (activityType.equals(ObjectType.A_XN)) {//取出在线考试数据
					Examination exam = examinationDAO.get(activityId);
					folderId = exam.getFolderId();
					ObjectName = exam.getName();
				}
				//初始化数据
				Map<String, Object> noticeData = new HashMap<String, Object>();
				noticeData.put("listUser", listUser);

				if (folderId == null)
					return;
				List<ActivityFolder> atyFolderList = activityFolderDAO.findFolderPathById(folderId);
				StringBuffer buf = new StringBuffer();
				String siteName = "";
				if (!ListUtils.isEmpty(atyFolderList)) {
					siteName = atyFolderList.get(0).getName();
					for (ActivityFolder aty : atyFolderList) {
						buf.append(aty.getName());
						buf.append("--");
					}
				}
				buf.append(ObjectName);
				noticeData.put("folderPath", buf.toString());
				noticeData.put("siteName", siteName);
				//初始化数据end 
				
				//调用通知接口
				noticeService.saveNoticeFromSettingsBySystem(activityType, activityId, noticeType, siteId, noticeData);
				//给新近入的人发送学习通知
				if (activityType.equals(ObjectType.A_EL)) {
				
					sendNoticeToNewEnroll(activityId, activityType, NoticeType.A_EL_NEW, siteId, null);
				}
				if (activityType.equals(ObjectType.A_XN)) {
					sendNoticeToNewEnroll(activityId, activityType, NoticeType.A_XN_NEW, siteId, null);
				}

				// 设置状态isnew 为2 ,下次不发送通知
				setEnrollChangeStatus(activityId, listUser);

			}
		}
	}

	/**
	 * 
	 * @param activityId
	 * @param activityType
	 * @param noticeType
	 * @param siteId
	 * @param userList
	 */
	public void sendNoticeToNewEnroll(Long activityId, ObjectType activityType, NoticeType noticeType, Long siteId, List<User> userList) {
		//实例判断是否存在通知设置 先设置为 0 ，为演示做准备
		if (noticeService.getNoticeSettingsStatus(activityType, noticeType, Long.valueOf(0), Long.valueOf(0)) > 0) {
			List<User> listUser;
			if (!ListUtils.isEmpty(userList)) {
				listUser = new ArrayList<User>();
				for(User users:userList){
					if(!StringUtils.isEmpty(users.getRecordStatus())&& "A".equals(users.getRecordStatus()))
					listUser.add(users);
				}
			} else {
				// 取得要发送用户信息
				CriteriaBuilder noticeUserCb = Cnd.builder(User.class);
				noticeUserCb.addParam("activityId", activityId);
				noticeUserCb.addParam("recordStatus", "A");
				noticeUserCb.addParam("isNew", "1");
				listUser = userDAO.findNoSendNoticeEnrollByCriteria(noticeUserCb.buildCriteria());
			}
			Map<String, Object> noticeData = new HashMap<String, Object>();
			Site site = siteDAO.get(siteId);
			noticeData.put("siteName", site.getName());
			if (!ListUtils.isEmpty(listUser)) {
				if (activityType.equals(ObjectType.A_XN)) {
					Examination exam = examinationDAO.get(activityId);
					noticeData.put("name", exam.getName());
					noticeData.put("atyTime", exam.getAtyTime());
					noticeData.put("reexamTimes", exam.getReexamTimes());
					noticeData.put("scoringType", exam.getScoringType());
					noticeData.put("displayScore", exam.getDisplayScore());
					if(!StringUtils.isEmpty(exam.getRemarks())){
						noticeData.put("remarks", exam.getRemarks());
					}
					else{
						noticeData.put("remarks", "暂无");
					}
					noticeData.put("totalScore", exam.getTotalScore());
					noticeData.put("advanceTime", exam.getAdvanceTime());
				}
				if (activityType.equals(ObjectType.A_EL)) {
					Elearning elearning = elearningDAO.get(activityId);

					AtyCourseInfo atyCourseInfo = findAtyCourse.findAtyCourseByAtyIdNoUser(activityId, activityType);

					noticeData.put("courseName", atyCourseInfo.getCourseName());
					noticeData.put("sortName", atyCourseInfo.getSortName());
					noticeData.put("hour", atyCourseInfo.getHour());
					noticeData.put("description", atyCourseInfo.getDescription());
					noticeData.put("sortName", atyCourseInfo.getSortName());

				}

				// 调用发送通知接口
				noticeService.saveNoticeFromSettingsBySystem(activityType, Long.valueOf(0), noticeType, Long.valueOf(0), listUser, noticeData);
				setEnrollChangeStatus(activityId, listUser);
			}
		}
	}

	/**
	 * 设置通知发送完毕后操作
	 * 
	 * @param activityId
	 * @param listUser
	 */
	public void setEnrollChangeStatus(Long activityId, List<User> listUser) {

		CriteriaBuilder enrollLearnerCnd = Cnd.builder(EnrollLearner.class);
		enrollLearnerCnd.andEQ("activityId", activityId);
		List listUserId = new ArrayList();
		for (User user : listUser) {
			listUserId.add(user.getId());
		}
		enrollLearnerCnd.andIn("userId", listUserId);
		EnrollLearner enrollLearner = new EnrollLearner();
		enrollLearner.setIsNew("2");
		enrollLearnerDAO.updateByCriteria(enrollLearner, enrollLearnerCnd.buildCriteria());
	}
}