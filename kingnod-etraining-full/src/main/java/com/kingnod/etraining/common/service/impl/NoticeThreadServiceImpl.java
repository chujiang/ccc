package com.kingnod.etraining.common.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.etraining.activity.service.EnrollLearnerService;
import com.kingnod.etraining.common.NoticeType;
import com.kingnod.etraining.common.ObjectType;
import com.kingnod.etraining.common.service.NoticeService;
import com.kingnod.etraining.organization.entity.UserGroup;
import com.kingnod.etraining.organization.service.UserGroupService;


public class NoticeThreadServiceImpl implements Runnable{

	@Autowired
	protected NoticeService noticeService;
	private Long siteId ;
	private Long objectId;
	private NoticeType noticeType;
	private ObjectType objectType;
	
	private EnrollLearnerService enrollLearnerService ;
	
	private UserGroupService userGroupService;
	
	private UserGroup userGroup;
	
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	
	public void run() {
		logger.debug("**进入发送通知线程   begin ******************");
		if (objectType.equals(ObjectType.A_EL)) {
			enrollLearnerService.sendNoticeEnrollGroupChange(objectId, objectType, NoticeType.A_EL_CHANGE, siteId);
			return ;
		}
		if (objectType.equals(ObjectType.A_XN)) {
			enrollLearnerService.sendNoticeEnrollGroupChange(objectId, objectType, NoticeType.A_XN_CHANGE, siteId);
			return ;
		}
		if (objectType.equals(ObjectType.O_UP)) {
			userGroupService.sendNoticeUserGroupChange(userGroup);
		}
		logger.debug("**进入发送通知线程  end  *******************");
	}

	public NoticeService getNoticeService() {
		return noticeService;
	}

	public void setNoticeService(NoticeService noticeService) {
		this.noticeService = noticeService;
	}

	public Long getSiteId() {
		return siteId;
	}

	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}

	public Long getObjectId() {
		return objectId;
	}

	public void setObjectId(Long objectId) {
		this.objectId = objectId;
	}

	public NoticeType getNoticeType() {
		return noticeType;
	}

	public void setNoticeType(NoticeType noticeType) {
		this.noticeType = noticeType;
	}

	public ObjectType getObjectType() {
		return objectType;
	}

	public void setObjectType(ObjectType objectType) {
		this.objectType = objectType;
	}

	public EnrollLearnerService getEnrollLearnerService() {
		return enrollLearnerService;
	}

	public void setEnrollLearnerService(EnrollLearnerService enrollLearnerService) {
		this.enrollLearnerService = enrollLearnerService;
	}

	public UserGroupService getUserGroupService() {
		return userGroupService;
	}

	public void setUserGroupService(UserGroupService userGroupService) {
		this.userGroupService = userGroupService;
	}

	public UserGroup getUserGroup() {
		return userGroup;
	}

	public void setUserGroup(UserGroup userGroup) {
		this.userGroup = userGroup;
	}

}
