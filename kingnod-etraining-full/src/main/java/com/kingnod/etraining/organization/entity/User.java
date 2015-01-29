package com.kingnod.etraining.organization.entity;

import com.kingnod.core.criteria.annotations.SelectColumnMapping;
import com.kingnod.core.criteria.annotations.SelectColumnMappings;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.entity.RecordStatus;
import java.io.Serializable;
import java.util.Date;

@SelectColumnMappings({
  @SelectColumnMapping(property = "id", type = java.lang.Long.class, table = "ORG_USER", tableAlias = "A", column = "ID"), 
  @SelectColumnMapping(property = "fullName", type = java.lang.String.class, table = "ORG_USER", tableAlias = "A", column = "FULL_NAME"), 
  @SelectColumnMapping(property = "nickName", type = java.lang.String.class, table = "ORG_USER", tableAlias = "A", column = "NICK_NAME"), 
  @SelectColumnMapping(property = "loginName", type = java.lang.String.class, table = "ORG_USER", tableAlias = "A", column = "LOGIN_NAME"), 
  @SelectColumnMapping(property = "password", type = java.lang.String.class, table = "ORG_USER", tableAlias = "A", column = "PASSWORD"), 
  @SelectColumnMapping(property = "email", type = java.lang.String.class, table = "ORG_USER", tableAlias = "A", column = "EMAIL"), 
  @SelectColumnMapping(property = "siteId", type = java.lang.Long.class, table = "ORG_USER", tableAlias = "A", column = "SITE_ID"), 
  @SelectColumnMapping(property = "organizationId", type = java.lang.Long.class, table = "ORG_USER", tableAlias = "A", column = "ORGANIZATION_ID"), 
  @SelectColumnMapping(property = "managerId", type = java.lang.Long.class, table = "ORG_USER", tableAlias = "A", column = "MANAGER_ID"), 
  @SelectColumnMapping(property = "administrator", type = java.lang.Boolean.class, table = "ORG_USER", tableAlias = "A", column = "ADMINISTRATOR"), 
  @SelectColumnMapping(property = "recordStatus", type = java.lang.String.class, table = "ORG_USER", tableAlias = "A", column = "RECORD_STATUS"), 
  @SelectColumnMapping(property = "updateCount", type = java.lang.Long.class, table = "ORG_USER", tableAlias = "A", column = "UPDATE_COUNT"), 
  @SelectColumnMapping(property = "creatorId", type = java.lang.Long.class, table = "ORG_USER", tableAlias = "A", column = "CREATOR_ID"), 
  @SelectColumnMapping(property = "createDate", type = java.util.Date.class, table = "ORG_USER", tableAlias = "A", column = "CREATE_DATE"), 
  @SelectColumnMapping(property = "updaterId", type = java.lang.Long.class, table = "ORG_USER", tableAlias = "A", column = "UPDATER_ID"), 
  @SelectColumnMapping(property = "updateDate", type = java.util.Date.class, table = "ORG_USER", tableAlias = "A", column = "UPDATE_DATE"), 
  @SelectColumnMapping(property = "status", type = java.lang.String.class, table = "ORG_USER", tableAlias = "A", column = "STATUS"), 
  @SelectColumnMapping(property = "validityDate", type = java.util.Date.class, table = "ORG_USER", tableAlias = "A", column = "VALIDITY_DATE")
})

    @com.kingnod.core.annotation.Generated("2012-03-28 10:13")
public class User implements IdEntity<Long>, RecordStatus<Long>, Serializable {

	private String shortName;			//所属组织（编码）
	private String managerLoginName;	//上级领导（登录名）
    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.ORG_USER.ID
     *
     * @mbggenerated 2012-03-28 10:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-28 10:13")
    private Long id;

    /**
     * 姓名<br/>
     * 对应数据库字段 ETRAINING.ORG_USER.FULL_NAME
     *
     * @mbggenerated 2012-03-28 10:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-28 10:13")
    private String fullName;

    /**
     * 昵称<br/>
     * 对应数据库字段 ETRAINING.ORG_USER.NICK_NAME
     *
     * @mbggenerated 2012-03-28 10:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-28 10:13")
    private String nickName;

    /**
     * 登录名<br/>
     * 对应数据库字段 ETRAINING.ORG_USER.LOGIN_NAME
     *
     * @mbggenerated 2012-03-28 10:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-28 10:13")
    private String loginName;

    /**
     * 密码<br/>
     * 对应数据库字段 ETRAINING.ORG_USER.PASSWORD
     *
     * @mbggenerated 2012-03-28 10:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-28 10:13")
    private String password;
    private String password2;

    /**
     * 电子邮件<br/>
     * 对应数据库字段 ETRAINING.ORG_USER.EMAIL
     *
     * @mbggenerated 2012-03-28 10:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-28 10:13")
    private String email;

    /**
     * 所属站点ID<br/>
     * 对应数据库字段 ETRAINING.ORG_USER.SITE_ID
     *
     * @mbggenerated 2012-03-28 10:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-28 10:13")
    private Long siteId;

    /**
     * 所属组织ID<br/>
     * 对应数据库字段 ETRAINING.ORG_USER.ORGANIZATION_ID
     *
     * @mbggenerated 2012-03-28 10:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-28 10:13")
    private Long organizationId;

    /**
     * 上级ID<br/>
     * 对应数据库字段 ETRAINING.ORG_USER.MANAGER_ID
     *
     * @mbggenerated 2012-03-28 10:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-28 10:13")
    private Long managerId;

    /**
     * 是否管理员<br/>
     * 对应数据库字段 ETRAINING.ORG_USER.ADMINISTRATOR
     *
     * @mbggenerated 2012-03-28 10:17
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-28 10:13")
    private Boolean administrator;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.ORG_USER.RECORD_STATUS
     *
     * @mbggenerated 2012-03-28 10:17
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-28 10:13")
    private String recordStatus;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.ORG_USER.UPDATE_COUNT
     *
     * @mbggenerated 2012-03-28 10:17
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-28 10:13")
    private Long updateCount;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.ORG_USER.CREATOR_ID
     *
     * @mbggenerated 2012-03-28 10:17
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-28 10:13")
    private Long creatorId;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.ORG_USER.CREATE_DATE
     *
     * @mbggenerated 2012-03-28 10:17
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-28 10:13")
    private Date createDate;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.ORG_USER.UPDATER_ID
     *
     * @mbggenerated 2012-03-28 10:17
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-28 10:13")
    private Long updaterId;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.ORG_USER.UPDATE_DATE
     *
     * @mbggenerated 2012-03-28 10:17
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-28 10:13")
    private Date updateDate;
    
    /**
     * 使用状态，L：锁定；A：有效<br/>
     * 对应数据库字段 ETRAINING_0409.ORG_USER.STATUS
     *
     * @mbggenerated 2012-04-20 10:37
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-20 10:38")
    private String status;

    /**
     * 使用有效期<br/>
     * 对应数据库字段 ETRAINING_0409.ORG_USER.VALIDITY_DATE
     *
     * @mbggenerated 2012-04-20 10:37
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-20 10:38")
    private Date validityDate;

    @com.kingnod.core.annotation.Generated("2012-03-28 10:13")
    private UserPropertyData propertyData = new UserPropertyData();


    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.ORG_USER.ID
     *
     * @返回  ETRAINING.ORG_USER.ID
     *
     * @mbggenerated 2012-03-28 10:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-28 10:13")
    public Long getId() {
        return id;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.ORG_USER.ID
     *
     * @param id null
     *
     * @mbggenerated 2012-03-28 10:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-28 10:13")
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 返回: 姓名<br>
     * 对应数据库字段: ETRAINING.ORG_USER.FULL_NAME
     *
     * @返回  ETRAINING.ORG_USER.FULL_NAME
     *
     * @mbggenerated 2012-03-28 10:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-28 10:13")
    public String getFullName() {
        return fullName;
    }

    /**
     *  设置: 姓名<br>
     * 对应数据库字段: ETRAINING.ORG_USER.FULL_NAME
     *
     * @param fullName 姓名
     *
     * @mbggenerated 2012-03-28 10:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-28 10:13")
    public void setFullName(String fullName) {
        this.fullName = fullName == null ? null : fullName.trim();
    }

    /**
     * 返回: 昵称<br>
     * 对应数据库字段: ETRAINING.ORG_USER.NICK_NAME
     *
     * @返回  ETRAINING.ORG_USER.NICK_NAME
     *
     * @mbggenerated 2012-03-28 10:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-28 10:13")
    public String getNickName() {
        return nickName;
    }

    /**
     *  设置: 昵称<br>
     * 对应数据库字段: ETRAINING.ORG_USER.NICK_NAME
     *
     * @param nickName 昵称
     *
     * @mbggenerated 2012-03-28 10:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-28 10:13")
    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    /**
     * 返回: 登录名<br>
     * 对应数据库字段: ETRAINING.ORG_USER.LOGIN_NAME
     *
     * @返回  ETRAINING.ORG_USER.LOGIN_NAME
     *
     * @mbggenerated 2012-03-28 10:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-28 10:13")
    public String getLoginName() {
        return loginName;
    }

    /**
     *  设置: 登录名<br>
     * 对应数据库字段: ETRAINING.ORG_USER.LOGIN_NAME
     *
     * @param loginName 登录名
     *
     * @mbggenerated 2012-03-28 10:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-28 10:13")
    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    /**
     * 返回: 密码<br>
     * 对应数据库字段: ETRAINING.ORG_USER.PASSWORD
     *
     * @返回  ETRAINING.ORG_USER.PASSWORD
     *
     * @mbggenerated 2012-03-28 10:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-28 10:13")
    public String getPassword() {
        return password;
    }

    /**
     *  设置: 密码<br>
     * 对应数据库字段: ETRAINING.ORG_USER.PASSWORD
     *
     * @param password 密码
     *
     * @mbggenerated 2012-03-28 10:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-28 10:13")
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 返回: 电子邮件<br>
     * 对应数据库字段: ETRAINING.ORG_USER.EMAIL
     *
     * @返回  ETRAINING.ORG_USER.EMAIL
     *
     * @mbggenerated 2012-03-28 10:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-28 10:13")
    public String getEmail() {
        return email;
    }

    /**
     *  设置: 电子邮件<br>
     * 对应数据库字段: ETRAINING.ORG_USER.EMAIL
     *
     * @param email 电子邮件
     *
     * @mbggenerated 2012-03-28 10:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-28 10:13")
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 返回: 所属站点ID<br>
     * 对应数据库字段: ETRAINING.ORG_USER.SITE_ID
     *
     * @返回  ETRAINING.ORG_USER.SITE_ID
     *
     * @mbggenerated 2012-03-28 10:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-28 10:13")
    public Long getSiteId() {
        return siteId;
    }

    /**
     *  设置: 所属站点ID<br>
     * 对应数据库字段: ETRAINING.ORG_USER.SITE_ID
     *
     * @param siteId 所属站点ID
     *
     * @mbggenerated 2012-03-28 10:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-28 10:13")
    public void setSiteId(Long siteId) {
        this.siteId = siteId;
    }

    /**
     * 返回: 所属组织ID<br>
     * 对应数据库字段: ETRAINING.ORG_USER.ORGANIZATION_ID
     *
     * @返回  ETRAINING.ORG_USER.ORGANIZATION_ID
     *
     * @mbggenerated 2012-03-28 10:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-28 10:13")
    public Long getOrganizationId() {
        return organizationId;
    }

    /**
     *  设置: 所属组织ID<br>
     * 对应数据库字段: ETRAINING.ORG_USER.ORGANIZATION_ID
     *
     * @param organizationId 所属组织ID
     *
     * @mbggenerated 2012-03-28 10:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-28 10:13")
    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    /**
     * 返回: 上级ID<br>
     * 对应数据库字段: ETRAINING.ORG_USER.MANAGER_ID
     *
     * @返回  ETRAINING.ORG_USER.MANAGER_ID
     *
     * @mbggenerated 2012-03-28 10:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-28 10:13")
    public Long getManagerId() {
        return managerId;
    }

    /**
     *  设置: 上级ID<br>
     * 对应数据库字段: ETRAINING.ORG_USER.MANAGER_ID
     *
     * @param managerId 上级ID
     *
     * @mbggenerated 2012-03-28 10:17
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-28 10:13")
    public void setManagerId(Long managerId) {
        this.managerId = managerId;
    }

    /**
     * 返回: 是否管理员<br>
     * 对应数据库字段: ETRAINING.ORG_USER.ADMINISTRATOR
     *
     * @返回  ETRAINING.ORG_USER.ADMINISTRATOR
     *
     * @mbggenerated 2012-03-28 10:17
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-28 10:13")
    public Boolean getAdministrator() {
        return administrator;
    }

    /**
     *  设置: 是否管理员<br>
     * 对应数据库字段: ETRAINING.ORG_USER.ADMINISTRATOR
     *
     * @param administrator 是否管理员
     *
     * @mbggenerated 2012-03-28 10:17
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-28 10:13")
    public void setAdministrator(Boolean administrator) {
        this.administrator = administrator;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.ORG_USER.RECORD_STATUS
     *
     * @返回  ETRAINING.ORG_USER.RECORD_STATUS
     *
     * @mbggenerated 2012-03-28 10:17
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-28 10:13")
    public String getRecordStatus() {
        return recordStatus;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.ORG_USER.RECORD_STATUS
     *
     * @param recordStatus null
     *
     * @mbggenerated 2012-03-28 10:17
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-28 10:13")
    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus == null ? null : recordStatus.trim();
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.ORG_USER.UPDATE_COUNT
     *
     * @返回  ETRAINING.ORG_USER.UPDATE_COUNT
     *
     * @mbggenerated 2012-03-28 10:17
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-28 10:13")
    public Long getUpdateCount() {
        return updateCount;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.ORG_USER.UPDATE_COUNT
     *
     * @param updateCount null
     *
     * @mbggenerated 2012-03-28 10:17
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-28 10:13")
    public void setUpdateCount(Long updateCount) {
        this.updateCount = updateCount;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.ORG_USER.CREATOR_ID
     *
     * @返回  ETRAINING.ORG_USER.CREATOR_ID
     *
     * @mbggenerated 2012-03-28 10:17
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-28 10:13")
    public Long getCreatorId() {
        return creatorId;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.ORG_USER.CREATOR_ID
     *
     * @param creatorId null
     *
     * @mbggenerated 2012-03-28 10:17
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-28 10:13")
    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.ORG_USER.CREATE_DATE
     *
     * @返回  ETRAINING.ORG_USER.CREATE_DATE
     *
     * @mbggenerated 2012-03-28 10:17
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-28 10:13")
    public Date getCreateDate() {
        return createDate;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.ORG_USER.CREATE_DATE
     *
     * @param createDate null
     *
     * @mbggenerated 2012-03-28 10:17
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-28 10:13")
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.ORG_USER.UPDATER_ID
     *
     * @返回  ETRAINING.ORG_USER.UPDATER_ID
     *
     * @mbggenerated 2012-03-28 10:17
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-28 10:13")
    public Long getUpdaterId() {
        return updaterId;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.ORG_USER.UPDATER_ID
     *
     * @param updaterId null
     *
     * @mbggenerated 2012-03-28 10:17
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-28 10:13")
    public void setUpdaterId(Long updaterId) {
        this.updaterId = updaterId;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.ORG_USER.UPDATE_DATE
     *
     * @返回  ETRAINING.ORG_USER.UPDATE_DATE
     *
     * @mbggenerated 2012-03-28 10:17
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-28 10:13")
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.ORG_USER.UPDATE_DATE
     *
     * @param updateDate null
     *
     * @mbggenerated 2012-03-28 10:17
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-28 10:13")
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }


    /**
     * 返回: 使用状态，L：锁定；A：有效<br>
     * 对应数据库字段: ETRAINING_0409.ORG_USER.STATUS
     *
     * @返回  ETRAINING_0409.ORG_USER.STATUS
     *
     * @mbggenerated 2012-04-20 10:37
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-20 10:38")
    public String getStatus() {
        return status;
    }

    /**
     *  设置: 使用状态，L：锁定；A：有效<br>
     * 对应数据库字段: ETRAINING_0409.ORG_USER.STATUS
     *
     * @param status 使用状态，L：锁定；A：有效
     *
     * @mbggenerated 2012-04-20 10:37
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-20 10:38")
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 返回: 使用有效期<br>
     * 对应数据库字段: ETRAINING_0409.ORG_USER.VALIDITY_DATE
     *
     * @返回  ETRAINING_0409.ORG_USER.VALIDITY_DATE
     *
     * @mbggenerated 2012-04-20 10:37
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-20 10:38")
    public Date getValidityDate() {
        return validityDate;
    }

    /**
     *  设置: 使用有效期<br>
     * 对应数据库字段: ETRAINING_0409.ORG_USER.VALIDITY_DATE
     *
     * @param validityDate 使用有效期
     *
     * @mbggenerated 2012-04-20 10:37
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-20 10:38")
    public void setValidityDate(Date validityDate) {
        this.validityDate = validityDate;
    }

    
    @com.kingnod.core.annotation.Generated("2012-03-28 10:13")
    public UserPropertyData getPropertyData() {
        return propertyData;
    }

    
    @com.kingnod.core.annotation.Generated("2012-03-28 10:13")
    public void setPropertyData(UserPropertyData propertyData) {
        this.propertyData = propertyData;
    }

	public String getPassword2() {
		return password;
	}

	public void setPassword2(String password2) {
		this.password2 = password;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getManagerLoginName() {
		return managerLoginName;
	}

	public void setManagerLoginName(String managerLoginName) {
		this.managerLoginName = managerLoginName;
	}

	
    
}