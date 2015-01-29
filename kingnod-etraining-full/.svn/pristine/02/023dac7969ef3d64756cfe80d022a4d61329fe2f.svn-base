package com.kingnod.etraining.common.action;

import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.extensions.struts2.action.EntityAction;
import com.kingnod.core.extensions.struts2.action.FilterableEntityAction;
import com.kingnod.core.util.SecurityUtils;
import com.kingnod.core.util.StringUtils;
import com.kingnod.core.util.TemplateUtils;
import com.kingnod.etraining.common.dao.NoticeUsersDAO;
import com.kingnod.etraining.common.dao.NoticeUsersDAOImpl;
import com.kingnod.etraining.common.entity.Notice;
import com.kingnod.etraining.common.entity.NoticeUsers;
import com.kingnod.etraining.common.service.NoticeService;
import com.kingnod.etraining.common.service.NoticeUsersService;
import com.kingnod.etraining.security.entity.UserAccount;

import java.util.Map;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Controller
@Namespace("/cmn")
@Results({ @Result(name = EntityAction.RELOAD, type = "redirectAction", params = {
		"actionName", "notice", "namespace", "/cmn","siteId", "${siteId}" }) })
@com.kingnod.core.annotation.Generated("2012-04-25 11:16")
public class NoticeAction extends FilterableEntityAction<Notice, Long> {
	
     

	private String receiveUsers; //  由对象选择器添加的用户
	private Notice notice;
	private Long noticeId;
	private Long siteId ;

	@Autowired
	private NoticeUsersService noticeUsersService; //通知用户群组

	@Autowired
	@com.kingnod.core.annotation.Generated("2012-04-25 11:16")
	private NoticeService noticeService;

	/**
	 * 重新父类save方法
	 */
	@Override
	public String save() {
		try {
			//this.entity.setReceivers(receiveUsers);
			super.save();
			//当发布用户不为空并且发布状态为 (1)发布时才真正操作 
				if (!StringUtils.isEmpty(this.entity.getReceivers())&&"1".equals(this.entity.getStatus())) {
					noticeUsersService.batchSaveNoticeUsers(this.entity.getReceivers(),
							this.entity.getId());
				}
				if("2".equals(this.entity.getStatus())){
					noticeUsersService.removeUsers(this.entity.getId());
				}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return RELOAD;
	}

	public String view() {
		notice = noticeService.getNotice(noticeId);
		return "view";
	}
	public String input(){
		this.setReceiveUsers(this.entity.getReceivers());
		if(this.entity.getId() == null){
			this.entity.setStatus("0");
		}
		return INPUT;
	}
	
	/**
	 * 过滤只能查看自己创建的通知，包括站点
	 */
     @Override
     public  void afterPreparedCriteriaBuilder(CriteriaBuilder cb) {
	   UserAccount userAccount = (UserAccount) SecurityUtils.getCurrentUser();
	   cb.andEQ("creatorId", userAccount.getId());
	   cb.andEQ("siteId", siteId);
	}
	



	public String getReceiveUsers() {
		return receiveUsers;
	}

	public void setReceiveUsers(String receiveUsers) {
		this.receiveUsers = receiveUsers;
	}

	public Notice getNotice() {
		return notice;
	}

	public void setNotice(Notice notice) {
		this.notice = notice;
	}

	public Long getNoticeId() {
		return noticeId;
	}

	public void setNoticeId(Long noticeId) {
		this.noticeId = noticeId;
	}

	@com.kingnod.core.annotation.Generated("2012-04-25 11:16")
	public String filterDefines() {
		return "cmn.noticeFilterItems";
	}

	@com.kingnod.core.annotation.Generated("2012-04-25 11:16")
	protected Object getEntityService() {
		return this.noticeService;
	}

	public Long getSiteId() {
		return siteId;
	}

	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}
	
}