package com.kingnod.etraining.organization.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.exception.Exceptions;
import com.kingnod.core.extensions.struts2.action.EntityAction;
import com.kingnod.core.extensions.struts2.action.FilterableEntityAction;
import com.kingnod.core.extensions.struts2.annotation.ErrorMapping;
import com.kingnod.etraining.common.ObjectType;
import com.kingnod.etraining.common.entity.NoticeSettings;
import com.kingnod.etraining.common.service.NoticeSettingsService;
import com.kingnod.etraining.organization.entity.UserGroup;
import com.kingnod.etraining.organization.service.UserGroupService;

@org.springframework.stereotype.Controller
@Namespace("/org")
@Results( 
{
@Result(name = EntityAction.RELOAD, type = "redirectAction", params = { "actionName", "user-group", "namespace", "/org", "siteId", "${siteId}"}),
@Result(name = "users", type = "redirectAction", params = { "actionName", "user", "namespace", "/org", "userGroupId", "${userGroupId}", "siteId", "${siteId}"})
}
)

    @com.kingnod.core.annotation.Generated("2012-02-08 16:26")
public class UserGroupAction extends FilterableEntityAction<UserGroup, Long> {

    @Autowired
    
    @com.kingnod.core.annotation.Generated("2012-02-08 16:26")
    private UserGroupService userGroupService;
    
   @Autowired 
    private NoticeSettingsService noticeSettingsService ;
    private NoticeSettings noticeSettings;
   
    private Long siteId;
    private Long userGroupId;
    
    
    @com.kingnod.core.annotation.Generated("2012-02-08 16:26")
    public String filterDefines() {
        return "org.userGroupFilterItems";
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

	@Override
	protected void afterPreparedCriteriaBuilder(CriteriaBuilder cb) {
		cb.andEQ("siteId", siteId);
	}

	@com.kingnod.core.annotation.Generated("2012-02-08 16:26")
    protected Object getEntityService() {
        return this.userGroupService;
    }
	
	/**
	 * 保存
	 */
	@ErrorMapping
	@Override
	public String save() throws Exception {
		CriteriaBuilder cb = Cnd.builder(UserGroup.class);
		cb.andEQ("siteId", entity.getSiteId());
		cb.andEQ("name", entity.getName());
		if(null != entity.getId()) {
			cb.andNotEQ("id", entity.getId());
		}
		List<UserGroup> groups = userGroupService.findUserGroup(cb.buildCriteria()).getResult();
		if(null != groups && groups.size() > 0) {	//相同站点下，用户组名称不能重复
			throw Exceptions.createAppException("org001009");
		}
		
		super.save();
		//id为空时为首次设置通知区域
		if(noticeSettings.getId() == null){
			noticeSettings.setObjectType(ObjectType.O_UP);
			noticeSettings.setObjectId(this.entity.getId());
		}
		noticeSettingsService.saveNoticeSettings(noticeSettings);
		return RELOAD;
	}
    /**
     * 重写input方法，为了读取通知设置
     * @return
     */
	public String input(){
		if(this.entity.getId()!=null){
		noticeSettings = noticeSettingsService.getNoticeSettings(ObjectType.O_UP, this.entity.getId(), this.entity.getSiteId());
		}
		return INPUT;
	}
	
	public NoticeSettings getNoticeSettings() {
		return noticeSettings;
	}

	public void setNoticeSettings(NoticeSettings noticeSettings) {
		this.noticeSettings = noticeSettings;
	}
    
	
	
}