package com.kingnod.etraining.common.entity;

import com.kingnod.core.criteria.annotations.SelectColumnMapping;
import com.kingnod.core.criteria.annotations.SelectColumnMappings;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.entity.RecordStatus;
import java.io.Serializable;
import java.util.Date;

@SelectColumnMappings({
		@SelectColumnMapping(property = "id", type = java.lang.Long.class, table = "SYS_PARAMETER", tableAlias = "A", column = "ID"),
		@SelectColumnMapping(property = "code", type = java.lang.String.class, table = "SYS_PARAMETER", tableAlias = "A", column = "CODE"),
		@SelectColumnMapping(property = "name", type = java.lang.String.class, table = "SYS_PARAMETER", tableAlias = "A", column = "NAME"),
		@SelectColumnMapping(property = "value", type = java.lang.String.class, table = "SYS_PARAMETER", tableAlias = "A", column = "VALUE"),
		@SelectColumnMapping(property = "defaultValue", type = java.lang.String.class, table = "SYS_PARAMETER", tableAlias = "A", column = "DEFAULT_VALUE"),
		@SelectColumnMapping(property = "type", type = java.lang.String.class, table = "SYS_PARAMETER", tableAlias = "A", column = "TYPE"),
		@SelectColumnMapping(property = "description", type = java.lang.String.class, table = "SYS_PARAMETER", tableAlias = "A", column = "DESCRIPTION"),
		@SelectColumnMapping(property = "scope", type = java.lang.String.class, table = "SYS_PARAMETER", tableAlias = "A", column = "SCOPE"),
		@SelectColumnMapping(property = "siteId", type = java.lang.Long.class, table = "SYS_PARAMETER", tableAlias = "A", column = "SITE_ID"),
		@SelectColumnMapping(property = "recordStatus", type = java.lang.String.class, table = "SYS_PARAMETER", tableAlias = "A", column = "RECORD_STATUS"),
		@SelectColumnMapping(property = "updateCount", type = java.lang.Long.class, table = "SYS_PARAMETER", tableAlias = "A", column = "UPDATE_COUNT"),
		@SelectColumnMapping(property = "creatorId", type = java.lang.Long.class, table = "SYS_PARAMETER", tableAlias = "A", column = "CREATOR_ID"),
		@SelectColumnMapping(property = "createDate", type = java.util.Date.class, table = "SYS_PARAMETER", tableAlias = "A", column = "CREATE_DATE"),
		@SelectColumnMapping(property = "updaterId", type = java.lang.Long.class, table = "SYS_PARAMETER", tableAlias = "A", column = "UPDATER_ID"),
		@SelectColumnMapping(property = "updateDate", type = java.util.Date.class, table = "SYS_PARAMETER", tableAlias = "A", column = "UPDATE_DATE"),
		@SelectColumnMapping(property = "siteName", type = java.lang.String.class, table = "ORG_SITE", tableAlias = "B", column = "NAME") })
@com.kingnod.core.annotation.Generated("2012-02-02 11:42")
public class SysParameter implements IdEntity<Long>, RecordStatus<Long>,
		Serializable {

	/**
	 * null<br/>
	 * 对应数据库字段 ETRAINING.SYS_PARAMETER.ID
	 * 
	 * @mbggenerated 2012-02-02 11:39
	 */

	@com.kingnod.core.annotation.Generated("2012-02-02 11:42")
	private Long id;

	/**
	 * 系统参数代码<br/>
	 * 对应数据库字段 ETRAINING.SYS_PARAMETER.CODE
	 * 
	 * @mbggenerated 2012-02-02 11:39
	 */

	@com.kingnod.core.annotation.Generated("2012-02-02 11:42")
	private String code;

	/**
	 * 系统参数名称<br/>
	 * 对应数据库字段 ETRAINING.SYS_PARAMETER.NAME
	 * 
	 * @mbggenerated 2012-02-02 11:39
	 */

	@com.kingnod.core.annotation.Generated("2012-02-02 11:42")
	private String name;

	/**
	 * 系统参数的值<br/>
	 * 对应数据库字段 ETRAINING.SYS_PARAMETER.VALUE
	 * 
	 * @mbggenerated 2012-02-02 11:39
	 */

	@com.kingnod.core.annotation.Generated("2012-02-02 11:42")
	private String value;

	/**
	 * 系统参数默认值<br/>
	 * 对应数据库字段 ETRAINING.SYS_PARAMETER.DEFAULT_VALUE
	 * 
	 * @mbggenerated 2012-02-02 11:39
	 */

	@com.kingnod.core.annotation.Generated("2012-02-02 11:42")
	private String defaultValue;

	/**
	 * 系统参数类型， I(Integer),L(Long),D(Datetime),B(Boolean),C(Collection)<br/>
	 * 对应数据库字段 ETRAINING.SYS_PARAMETER.TYPE
	 * 
	 * @mbggenerated 2012-02-02 11:39
	 */

	@com.kingnod.core.annotation.Generated("2012-02-02 11:42")
	private String type;

	/**
	 * 系统参数详细描述<br/>
	 * 对应数据库字段 ETRAINING.SYS_PARAMETER.DESCRIPTION
	 * 
	 * @mbggenerated 2012-02-02 11:39
	 */

	@com.kingnod.core.annotation.Generated("2012-02-02 11:42")
	private String description;

	/**
	 * 系统参数影响的范围, A(应用级), S(站点级)<br/>
	 * 对应数据库字段 ETRAINING.SYS_PARAMETER.SCOPE
	 * 
	 * @mbggenerated 2012-02-02 11:39
	 */

	@com.kingnod.core.annotation.Generated("2012-02-02 11:42")
	private String scope;

	/**
	 * 系统参数影响的站点ID<br/>
	 * 对应数据库字段 ETRAINING.SYS_PARAMETER.SITE_ID
	 * 
	 * @mbggenerated 2012-02-02 11:39
	 */

	@com.kingnod.core.annotation.Generated("2012-02-02 11:42")
	private Long siteId;

	/**
	 * null<br/>
	 * 对应数据库字段 ETRAINING.SYS_PARAMETER.RECORD_STATUS
	 * 
	 * @mbggenerated 2012-02-02 11:39
	 */

	@com.kingnod.core.annotation.Generated("2012-02-02 11:42")
	private String recordStatus;

	/**
	 * null<br/>
	 * 对应数据库字段 ETRAINING.SYS_PARAMETER.UPDATE_COUNT
	 * 
	 * @mbggenerated 2012-02-02 11:39
	 */

	@com.kingnod.core.annotation.Generated("2012-02-02 11:42")
	private Long updateCount;

	/**
	 * null<br/>
	 * 对应数据库字段 ETRAINING.SYS_PARAMETER.CREATOR_ID
	 * 
	 * @mbggenerated 2012-02-02 11:39
	 */

	@com.kingnod.core.annotation.Generated("2012-02-02 11:42")
	private Long creatorId;

	/**
	 * null<br/>
	 * 对应数据库字段 ETRAINING.SYS_PARAMETER.CREATE_DATE
	 * 
	 * @mbggenerated 2012-02-02 11:39
	 */

	@com.kingnod.core.annotation.Generated("2012-02-02 11:42")
	private Date createDate;

	/**
	 * null<br/>
	 * 对应数据库字段 ETRAINING.SYS_PARAMETER.UPDATER_ID
	 * 
	 * @mbggenerated 2012-02-02 11:39
	 */

	@com.kingnod.core.annotation.Generated("2012-02-02 11:42")
	private Long updaterId;

	/**
	 * null<br/>
	 * 对应数据库字段 ETRAINING.SYS_PARAMETER.UPDATE_DATE
	 * 
	 * @mbggenerated 2012-02-02 11:39
	 */

	@com.kingnod.core.annotation.Generated("2012-02-02 11:42")
	private Date updateDate;

	/**
	 * 站点名称<br/>
	 * 对应数据库字段 ETRAINING.SYS_PARAMETER.NAME
	 * 
	 * @mbggenerated 2012-02-02 11:39
	 */

	@com.kingnod.core.annotation.Generated("2012-02-02 11:42")
	private String siteName;

	/**
	 * 返回: null<br>
	 * 对应数据库字段: ETRAINING.SYS_PARAMETER.ID
	 * 
	 * @返回 ETRAINING.SYS_PARAMETER.ID
	 * 
	 * @mbggenerated 2012-02-02 11:39
	 */

	@com.kingnod.core.annotation.Generated("2012-02-02 11:42")
	public Long getId() {
		return id;
	}

	/**
	 * 设置: null<br>
	 * 对应数据库字段: ETRAINING.SYS_PARAMETER.ID
	 * 
	 * @param id
	 *            null
	 * 
	 * @mbggenerated 2012-02-02 11:39
	 */

	@com.kingnod.core.annotation.Generated("2012-02-02 11:42")
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 返回: 系统参数代码<br>
	 * 对应数据库字段: ETRAINING.SYS_PARAMETER.CODE
	 * 
	 * @返回 ETRAINING.SYS_PARAMETER.CODE
	 * 
	 * @mbggenerated 2012-02-02 11:39
	 */

	@com.kingnod.core.annotation.Generated("2012-02-02 11:42")
	public String getCode() {
		return code;
	}

	/**
	 * 设置: 系统参数代码<br>
	 * 对应数据库字段: ETRAINING.SYS_PARAMETER.CODE
	 * 
	 * @param code
	 *            系统参数代码
	 * 
	 * @mbggenerated 2012-02-02 11:39
	 */

	@com.kingnod.core.annotation.Generated("2012-02-02 11:42")
	public void setCode(String code) {
		this.code = code == null ? null : code.trim();
	}

	/**
	 * 返回: 系统参数名称<br>
	 * 对应数据库字段: ETRAINING.SYS_PARAMETER.NAME
	 * 
	 * @返回 ETRAINING.SYS_PARAMETER.NAME
	 * 
	 * @mbggenerated 2012-02-02 11:39
	 */

	@com.kingnod.core.annotation.Generated("2012-02-02 11:42")
	public String getName() {
		return name;
	}

	/**
	 * 设置: 系统参数名称<br>
	 * 对应数据库字段: ETRAINING.SYS_PARAMETER.NAME
	 * 
	 * @param name
	 *            系统参数名称
	 * 
	 * @mbggenerated 2012-02-02 11:39
	 */

	@com.kingnod.core.annotation.Generated("2012-02-02 11:42")
	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	/**
	 * 返回: 系统参数的值<br>
	 * 对应数据库字段: ETRAINING.SYS_PARAMETER.VALUE
	 * 
	 * @返回 ETRAINING.SYS_PARAMETER.VALUE
	 * 
	 * @mbggenerated 2012-02-02 11:39
	 */

	@com.kingnod.core.annotation.Generated("2012-02-02 11:42")
	public String getValue() {
		return value;
	}

	/**
	 * 设置: 系统参数的值<br>
	 * 对应数据库字段: ETRAINING.SYS_PARAMETER.VALUE
	 * 
	 * @param value
	 *            系统参数的值
	 * 
	 * @mbggenerated 2012-02-02 11:39
	 */

	@com.kingnod.core.annotation.Generated("2012-02-02 11:42")
	public void setValue(String value) {
		this.value = value == null ? null : value.trim();
	}

	/**
	 * 返回: 系统参数默认值<br>
	 * 对应数据库字段: ETRAINING.SYS_PARAMETER.DEFAULT_VALUE
	 * 
	 * @返回 ETRAINING.SYS_PARAMETER.DEFAULT_VALUE
	 * 
	 * @mbggenerated 2012-02-02 11:39
	 */

	@com.kingnod.core.annotation.Generated("2012-02-02 11:42")
	public String getDefaultValue() {
		return defaultValue;
	}

	/**
	 * 设置: 系统参数默认值<br>
	 * 对应数据库字段: ETRAINING.SYS_PARAMETER.DEFAULT_VALUE
	 * 
	 * @param defaultValue
	 *            系统参数默认值
	 * 
	 * @mbggenerated 2012-02-02 11:39
	 */

	@com.kingnod.core.annotation.Generated("2012-02-02 11:42")
	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue == null ? null : defaultValue.trim();
	}

	/**
	 * 返回: 系统参数类型， I(Integer),L(Long),D(Datetime),B(Boolean),C(Collection)<br>
	 * 对应数据库字段: ETRAINING.SYS_PARAMETER.TYPE
	 * 
	 * @返回 ETRAINING.SYS_PARAMETER.TYPE
	 * 
	 * @mbggenerated 2012-02-02 11:39
	 */

	@com.kingnod.core.annotation.Generated("2012-02-02 11:42")
	public String getType() {
		return type;
	}

	/**
	 * 设置: 系统参数类型， I(Integer),L(Long),D(Datetime),B(Boolean),C(Collection)<br>
	 * 对应数据库字段: ETRAINING.SYS_PARAMETER.TYPE
	 * 
	 * @param type
	 *            系统参数类型，
	 *            I(Integer),L(Long),D(Datetime),B(Boolean),C(Collection)
	 * 
	 * @mbggenerated 2012-02-02 11:39
	 */

	@com.kingnod.core.annotation.Generated("2012-02-02 11:42")
	public void setType(String type) {
		this.type = type == null ? null : type.trim();
	}

	/**
	 * 返回: 系统参数详细描述<br>
	 * 对应数据库字段: ETRAINING.SYS_PARAMETER.DESCRIPTION
	 * 
	 * @返回 ETRAINING.SYS_PARAMETER.DESCRIPTION
	 * 
	 * @mbggenerated 2012-02-02 11:39
	 */

	@com.kingnod.core.annotation.Generated("2012-02-02 11:42")
	public String getDescription() {
		return description;
	}

	/**
	 * 设置: 系统参数详细描述<br>
	 * 对应数据库字段: ETRAINING.SYS_PARAMETER.DESCRIPTION
	 * 
	 * @param description
	 *            系统参数详细描述
	 * 
	 * @mbggenerated 2012-02-02 11:39
	 */

	@com.kingnod.core.annotation.Generated("2012-02-02 11:42")
	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	/**
	 * 返回: 系统参数影响的范围, A(应用级), S(站点级)<br>
	 * 对应数据库字段: ETRAINING.SYS_PARAMETER.SCOPE
	 * 
	 * @返回 ETRAINING.SYS_PARAMETER.SCOPE
	 * 
	 * @mbggenerated 2012-02-02 11:39
	 */

	@com.kingnod.core.annotation.Generated("2012-02-02 11:42")
	public String getScope() {
		return scope;
	}

	/**
	 * 设置: 系统参数影响的范围, A(应用级), S(站点级)<br>
	 * 对应数据库字段: ETRAINING.SYS_PARAMETER.SCOPE
	 * 
	 * @param scope
	 *            系统参数影响的范围, A(应用级), S(站点级)
	 * 
	 * @mbggenerated 2012-02-02 11:39
	 */

	@com.kingnod.core.annotation.Generated("2012-02-02 11:42")
	public void setScope(String scope) {
		this.scope = scope == null ? null : scope.trim();
	}

	/**
	 * 返回: 系统参数影响的站点ID<br>
	 * 对应数据库字段: ETRAINING.SYS_PARAMETER.SITE_ID
	 * 
	 * @返回 ETRAINING.SYS_PARAMETER.SITE_ID
	 * 
	 * @mbggenerated 2012-02-02 11:39
	 */

	@com.kingnod.core.annotation.Generated("2012-02-02 11:42")
	public Long getSiteId() {
		return siteId;
	}

	/**
	 * 设置: 系统参数影响的站点ID<br>
	 * 对应数据库字段: ETRAINING.SYS_PARAMETER.SITE_ID
	 * 
	 * @param siteId
	 *            系统参数影响的站点ID
	 * 
	 * @mbggenerated 2012-02-02 11:39
	 */

	@com.kingnod.core.annotation.Generated("2012-02-02 11:42")
	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}

	/**
	 * 返回: null<br>
	 * 对应数据库字段: ETRAINING.SYS_PARAMETER.RECORD_STATUS
	 * 
	 * @返回 ETRAINING.SYS_PARAMETER.RECORD_STATUS
	 * 
	 * @mbggenerated 2012-02-02 11:39
	 */

	@com.kingnod.core.annotation.Generated("2012-02-02 11:42")
	public String getRecordStatus() {
		return recordStatus;
	}

	/**
	 * 设置: null<br>
	 * 对应数据库字段: ETRAINING.SYS_PARAMETER.RECORD_STATUS
	 * 
	 * @param recordStatus
	 *            null
	 * 
	 * @mbggenerated 2012-02-02 11:39
	 */

	@com.kingnod.core.annotation.Generated("2012-02-02 11:42")
	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus == null ? null : recordStatus.trim();
	}

	/**
	 * 返回: null<br>
	 * 对应数据库字段: ETRAINING.SYS_PARAMETER.UPDATE_COUNT
	 * 
	 * @返回 ETRAINING.SYS_PARAMETER.UPDATE_COUNT
	 * 
	 * @mbggenerated 2012-02-02 11:39
	 */

	@com.kingnod.core.annotation.Generated("2012-02-02 11:42")
	public Long getUpdateCount() {
		return updateCount;
	}

	/**
	 * 设置: null<br>
	 * 对应数据库字段: ETRAINING.SYS_PARAMETER.UPDATE_COUNT
	 * 
	 * @param updateCount
	 *            null
	 * 
	 * @mbggenerated 2012-02-02 11:39
	 */

	@com.kingnod.core.annotation.Generated("2012-02-02 11:42")
	public void setUpdateCount(Long updateCount) {
		this.updateCount = updateCount;
	}

	/**
	 * 返回: null<br>
	 * 对应数据库字段: ETRAINING.SYS_PARAMETER.CREATOR_ID
	 * 
	 * @返回 ETRAINING.SYS_PARAMETER.CREATOR_ID
	 * 
	 * @mbggenerated 2012-02-02 11:39
	 */

	@com.kingnod.core.annotation.Generated("2012-02-02 11:42")
	public Long getCreatorId() {
		return creatorId;
	}

	/**
	 * 设置: null<br>
	 * 对应数据库字段: ETRAINING.SYS_PARAMETER.CREATOR_ID
	 * 
	 * @param creatorId
	 *            null
	 * 
	 * @mbggenerated 2012-02-02 11:39
	 */

	@com.kingnod.core.annotation.Generated("2012-02-02 11:42")
	public void setCreatorId(Long creatorId) {
		this.creatorId = creatorId;
	}

	/**
	 * 返回: null<br>
	 * 对应数据库字段: ETRAINING.SYS_PARAMETER.CREATE_DATE
	 * 
	 * @返回 ETRAINING.SYS_PARAMETER.CREATE_DATE
	 * 
	 * @mbggenerated 2012-02-02 11:39
	 */

	@com.kingnod.core.annotation.Generated("2012-02-02 11:42")
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * 设置: null<br>
	 * 对应数据库字段: ETRAINING.SYS_PARAMETER.CREATE_DATE
	 * 
	 * @param createDate
	 *            null
	 * 
	 * @mbggenerated 2012-02-02 11:39
	 */

	@com.kingnod.core.annotation.Generated("2012-02-02 11:42")
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * 返回: null<br>
	 * 对应数据库字段: ETRAINING.SYS_PARAMETER.UPDATER_ID
	 * 
	 * @返回 ETRAINING.SYS_PARAMETER.UPDATER_ID
	 * 
	 * @mbggenerated 2012-02-02 11:39
	 */

	@com.kingnod.core.annotation.Generated("2012-02-02 11:42")
	public Long getUpdaterId() {
		return updaterId;
	}

	/**
	 * 设置: null<br>
	 * 对应数据库字段: ETRAINING.SYS_PARAMETER.UPDATER_ID
	 * 
	 * @param updaterId
	 *            null
	 * 
	 * @mbggenerated 2012-02-02 11:39
	 */

	@com.kingnod.core.annotation.Generated("2012-02-02 11:42")
	public void setUpdaterId(Long updaterId) {
		this.updaterId = updaterId;
	}

	/**
	 * 返回: null<br>
	 * 对应数据库字段: ETRAINING.SYS_PARAMETER.UPDATE_DATE
	 * 
	 * @返回 ETRAINING.SYS_PARAMETER.UPDATE_DATE
	 * 
	 * @mbggenerated 2012-02-02 11:39
	 */

	@com.kingnod.core.annotation.Generated("2012-02-02 11:42")
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * 设置: null<br>
	 * 对应数据库字段: ETRAINING.SYS_PARAMETER.UPDATE_DATE
	 * 
	 * @param updateDate
	 *            null
	 * 
	 * @mbggenerated 2012-02-02 11:39
	 */

	@com.kingnod.core.annotation.Generated("2012-02-02 11:42")
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * 返回: 站点名称<br>
	 * 对应数据库字段: ETRAINING.SYS_PARAMETER.NAME
	 * 
	 * @返回 ETRAINING.SYS_PARAMETER.NAME
	 * 
	 * @mbggenerated 2012-02-02 11:39
	 */

	@com.kingnod.core.annotation.Generated("2012-02-02 11:42")
	public String getSiteName() {
		return siteName;
	}

	/**
	 * 设置: 站点名称<br>
	 * 对应数据库字段: ETRAINING.SYS_PARAMETER.NAME
	 * 
	 * @param siteName
	 *            站点名称
	 * 
	 * @mbggenerated 2012-02-02 11:39
	 */

	@com.kingnod.core.annotation.Generated("2012-02-02 11:42")
	public void setSiteName(String siteName) {
		this.siteName = siteName == null ? null : siteName.trim();
	}
}