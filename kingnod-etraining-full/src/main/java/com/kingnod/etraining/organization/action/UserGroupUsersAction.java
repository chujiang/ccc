package com.kingnod.etraining.organization.action;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.entity.RecordStatus;
import com.kingnod.core.extensions.struts2.action.EntityAction;
import com.kingnod.core.extensions.struts2.action.FilterableEntityAction;
import com.kingnod.core.util.StringUtils;
import com.kingnod.etraining.organization.entity.UserGroup;
import com.kingnod.etraining.organization.entity.UserGroupUsers;
import com.kingnod.etraining.organization.service.UserGroupService;
import com.kingnod.etraining.organization.service.UserGroupUsersService;

@org.springframework.stereotype.Controller
@Namespace("/org")
@Results( 
{
@Result(name = EntityAction.RELOAD, type = "redirectAction", params = { "actionName", "user-group-users", "namespace", "/org", "userGroupId", "${userGroupId}", "siteId", "${siteId}"})
}
)

    @com.kingnod.core.annotation.Generated("2012-02-23 19:36")
public class UserGroupUsersAction extends FilterableEntityAction<UserGroupUsers, Long> {

    @Autowired
    
    @com.kingnod.core.annotation.Generated("2012-02-23 19:36")
    private UserGroupUsersService userGroupUsersService;
    
    @Autowired
	private UserGroupService userGroupService;
    
    private Long userGroupId;
    private Long siteId;
    private String isExcluded;

    
	@com.kingnod.core.annotation.Generated("2012-02-23 19:36")
    public String filterDefines() {
        return "org.userGroupUsersFilterItems";
    }

    
    @com.kingnod.core.annotation.Generated("2012-02-23 19:36")
    protected Object getEntityService() {
        return this.userGroupUsersService;
    }
    
    
    /**
     * 根据用户组ID取出用户列表
     */
    @Override
    protected void afterPreparedCriteriaBuilder(CriteriaBuilder cb) {
    	cb.andEQ("userGroupId", userGroupId).andEQ("recordStatus", RecordStatus.ACTIVE);
    }
    
    /**
	 * 用户组成员_刷新
	 * @return
	 * @throws Exception
	 */
	public String refreshMember() throws Exception {
		UserGroup userGroup = userGroupService.getUserGroup(userGroupId);
		userGroupService.refreshMember(userGroup);
		return EntityAction.RELOAD;
	}
	
	/**
	 * 用户组成员_排除_取消排除
	 * @return
	 * @throws Exception
	 */
	public String excluded() throws Exception {
		Long[] ids = getIdValues();
		for (int i = 0; i < ids.length; i++) {
			UserGroupUsers userGroupUsers = userGroupUsersService.getUserGroupUsers(ids[i]);
			userGroupUsers.setExcluded(StringUtils.isTrue(isExcluded));
			userGroupUsersService.saveUserGroupUsers(userGroupUsers);
		}
		return RELOAD;
	}
	

    public Long getUserGroupId() {
		return userGroupId;
	}


	public void setUserGroupId(Long userGroupId) {
		this.userGroupId = userGroupId;
	}


	public Long getSiteId() {
		return siteId;
	}


	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}


	public String getIsExcluded() {
		return isExcluded;
	}


	public void setIsExcluded(String isExcluded) {
		this.isExcluded = isExcluded;
	}



}