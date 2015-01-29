package com.kingnod.etraining.resource.entity;

import java.io.Serializable;
import java.util.Date;

import com.kingnod.core.criteria.annotations.SelectColumnMapping;
import com.kingnod.core.criteria.annotations.SelectColumnMappings;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.entity.RecordStatus;

@SelectColumnMappings({
		@SelectColumnMapping(property = "id", type = java.lang.Long.class, table = "RES_TREE_NODE", tableAlias = "A", column = "ID"),
		@SelectColumnMapping(property = "parentId", type = java.lang.Long.class, table = "RES_TREE_NODE", tableAlias = "A", column = "PARENT_ID"),
		@SelectColumnMapping(property = "text", type = java.lang.String.class, table = "RES_TREE_NODE", tableAlias = "A", column = "TEXT"),
		@SelectColumnMapping(property = "hint", type = java.lang.String.class, table = "RES_TREE_NODE", tableAlias = "A", column = "HINT"),
		@SelectColumnMapping(property = "icon", type = java.lang.String.class, table = "RES_TREE_NODE", tableAlias = "A", column = "ICON"),
		@SelectColumnMapping(property = "data", type = java.util.Date.class, table = "RES_TREE_NODE", tableAlias = "A", column = "DATA"),
		@SelectColumnMapping(property = "url", type = java.lang.String.class, table = "RES_TREE_NODE", tableAlias = "A", column = "URL"),
		@SelectColumnMapping(property = "target", type = java.lang.String.class, table = "RES_TREE_NODE", tableAlias = "A", column = "TARGET"),
		@SelectColumnMapping(property = "method", type = java.lang.String.class, table = "RES_TREE_NODE", tableAlias = "A", column = "METHOD"),
		@SelectColumnMapping(property = "recordStatus", type = java.lang.String.class, table = "RES_TREE_NODE", tableAlias = "A", column = "RECORD_STATUS"),
		@SelectColumnMapping(property = "updateCount", type = java.lang.Long.class, table = "RES_TREE_NODE", tableAlias = "A", column = "UPDATE_COUNT"),
		@SelectColumnMapping(property = "creatorId", type = java.lang.Long.class, table = "RES_TREE_NODE", tableAlias = "A", column = "CREATOR_ID"),
		@SelectColumnMapping(property = "createDate", type = java.util.Date.class, table = "RES_TREE_NODE", tableAlias = "A", column = "CREATE_DATE"),
		@SelectColumnMapping(property = "updaterId", type = java.lang.Long.class, table = "RES_TREE_NODE", tableAlias = "A", column = "UPDATER_ID"),
		@SelectColumnMapping(property = "updateDate", type = java.util.Date.class, table = "RES_TREE_NODE", tableAlias = "A", column = "UPDATE_DATE"),
		@SelectColumnMapping(property = "nodeType", type = java.lang.String.class, table = "RES_TREE_NODE", tableAlias = "A", column = "NODE_TYPE"),
		@SelectColumnMapping(property = "nodeLocation", type = java.lang.String.class, table = "RES_TREE_NODE", tableAlias = "A", column = "NODE_LOCATION") })
@com.kingnod.core.annotation.Generated("2012-01-30 11:14")
public class ResTreeNode implements IdEntity<Long>, RecordStatus<Long>,
		Serializable {

	/**
	 * null<br/>
	 * 对应数据库字段 RES_TREE_NODE.ID
	 * 
	 * @mbggenerated 2012-01-30 11:58
	 */

	@com.kingnod.core.annotation.Generated("2012-01-30 11:14")
	private Long id;

	/**
	 * null<br/>
	 * 对应数据库字段 RES_TREE_NODE.PARENT_ID
	 * 
	 * @mbggenerated 2012-01-30 11:58
	 */

	@com.kingnod.core.annotation.Generated("2012-01-30 11:14")
	private Long parentId;

	/**
	 * null<br/>
	 * 对应数据库字段 RES_TREE_NODE.TEXT
	 * 
	 * @mbggenerated 2012-01-30 11:58
	 */

	@com.kingnod.core.annotation.Generated("2012-01-30 11:14")
	private String text;

	/**
	 * null<br/>
	 * 对应数据库字段 RES_TREE_NODE.HINT
	 * 
	 * @mbggenerated 2012-01-30 11:58
	 */

	@com.kingnod.core.annotation.Generated("2012-01-30 11:14")
	private String hint;

	/**
	 * null<br/>
	 * 对应数据库字段 RES_TREE_NODE.ICON
	 * 
	 * @mbggenerated 2012-01-30 11:58
	 */

	@com.kingnod.core.annotation.Generated("2012-01-30 11:14")
	private String icon;

	/**
	 * null<br/>
	 * 对应数据库字段 RES_TREE_NODE.DATA
	 * 
	 * @mbggenerated 2012-01-30 11:58
	 */

	@com.kingnod.core.annotation.Generated("2012-01-30 11:14")
	private Date data;

	/**
	 * null<br/>
	 * 对应数据库字段 RES_TREE_NODE.URL
	 * 
	 * @mbggenerated 2012-01-30 11:58
	 */

	@com.kingnod.core.annotation.Generated("2012-01-30 11:14")
	private String url;

	/**
	 * null<br/>
	 * 对应数据库字段 RES_TREE_NODE.TARGET
	 * 
	 * @mbggenerated 2012-01-30 11:58
	 */

	@com.kingnod.core.annotation.Generated("2012-01-30 11:14")
	private String target;

	/**
	 * null<br/>
	 * 对应数据库字段 RES_TREE_NODE.METHOD
	 * 
	 * @mbggenerated 2012-01-30 11:58
	 */

	@com.kingnod.core.annotation.Generated("2012-01-30 11:14")
	private String method;

	/**
	 * null<br/>
	 * 对应数据库字段 RES_TREE_NODE.RECORD_STATUS
	 * 
	 * @mbggenerated 2012-01-30 11:58
	 */

	@com.kingnod.core.annotation.Generated("2012-01-30 11:14")
	private String recordStatus;

	/**
	 * null<br/>
	 * 对应数据库字段 RES_TREE_NODE.UPDATE_COUNT
	 * 
	 * @mbggenerated 2012-01-30 11:58
	 */

	@com.kingnod.core.annotation.Generated("2012-01-30 11:14")
	private Long updateCount;

	/**
	 * null<br/>
	 * 对应数据库字段 RES_TREE_NODE.CREATOR_ID
	 * 
	 * @mbggenerated 2012-01-30 11:58
	 */

	@com.kingnod.core.annotation.Generated("2012-01-30 11:14")
	private Long creatorId;

	/**
	 * null<br/>
	 * 对应数据库字段 RES_TREE_NODE.CREATE_DATE
	 * 
	 * @mbggenerated 2012-01-30 11:58
	 */

	@com.kingnod.core.annotation.Generated("2012-01-30 11:14")
	private Date createDate;

	/**
	 * null<br/>
	 * 对应数据库字段 RES_TREE_NODE.UPDATER_ID
	 * 
	 * @mbggenerated 2012-01-30 11:58
	 */

	@com.kingnod.core.annotation.Generated("2012-01-30 11:14")
	private Long updaterId;

	/**
	 * null<br/>
	 * 对应数据库字段 RES_TREE_NODE.UPDATE_DATE
	 * 
	 * @mbggenerated 2012-01-30 11:58
	 */

	@com.kingnod.core.annotation.Generated("2012-01-30 11:14")
	private Date updateDate;

	/**
	 * null<br/>
	 * 对应数据库字段 RES_TREE_NODE.NODE_TYPE
	 * 
	 * @mbggenerated 2012-01-30 11:58
	 */

	@com.kingnod.core.annotation.Generated("2012-01-30 11:14")
	private String nodeType;

	/**
	 * null<br/>
	 * 对应数据库字段 RES_TREE_NODE.NODE_LOCATION
	 * 
	 * @mbggenerated 2012-01-30 11:58
	 */

	@com.kingnod.core.annotation.Generated("2012-01-30 11:14")
	private String nodeLocation;

	@com.kingnod.core.annotation.Generated("2012-01-30 11:14")
	public static final String ID = "id";

	@com.kingnod.core.annotation.Generated("2012-01-30 11:14")
	public static final String PARENT_ID = "parentId";

	@com.kingnod.core.annotation.Generated("2012-01-30 11:14")
	public static final String TEXT = "text";

	@com.kingnod.core.annotation.Generated("2012-01-30 11:14")
	public static final String HINT = "hint";

	@com.kingnod.core.annotation.Generated("2012-01-30 11:14")
	public static final String ICON = "icon";

	@com.kingnod.core.annotation.Generated("2012-01-30 11:14")
	public static final String DATA = "data";

	@com.kingnod.core.annotation.Generated("2012-01-30 11:14")
	public static final String URL = "url";

	@com.kingnod.core.annotation.Generated("2012-01-30 11:14")
	public static final String TARGET = "target";

	@com.kingnod.core.annotation.Generated("2012-01-30 11:14")
	public static final String METHOD = "method";

	@com.kingnod.core.annotation.Generated("2012-01-30 11:14")
	public static final String RECORD_STATUS = "recordStatus";

	@com.kingnod.core.annotation.Generated("2012-01-30 11:14")
	public static final String UPDATE_COUNT = "updateCount";

	@com.kingnod.core.annotation.Generated("2012-01-30 11:14")
	public static final String CREATOR_ID = "creatorId";

	@com.kingnod.core.annotation.Generated("2012-01-30 11:14")
	public static final String CREATE_DATE = "createDate";

	@com.kingnod.core.annotation.Generated("2012-01-30 11:14")
	public static final String UPDATER_ID = "updaterId";

	@com.kingnod.core.annotation.Generated("2012-01-30 11:14")
	public static final String UPDATE_DATE = "updateDate";

	@com.kingnod.core.annotation.Generated("2012-01-30 11:14")
	public static final String NODE_TYPE = "nodeType";

	@com.kingnod.core.annotation.Generated("2012-01-30 11:14")
	public static final String NODE_LOCATION = "nodeLocation";

	/**
	 * 返回: null<br>
	 * 对应数据库字段: RES_TREE_NODE.ID
	 * 
	 * @返回 RES_TREE_NODE.ID
	 * 
	 * @mbggenerated 2012-01-30 11:58
	 */

	@com.kingnod.core.annotation.Generated("2012-01-30 11:14")
	public Long getId() {
		return id;
	}

	/**
	 * 设置: null<br>
	 * 对应数据库字段: RES_TREE_NODE.ID
	 * 
	 * @param id
	 *            null
	 * 
	 * @mbggenerated 2012-01-30 11:58
	 */

	@com.kingnod.core.annotation.Generated("2012-01-30 11:14")
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * 返回: null<br>
	 * 对应数据库字段: RES_TREE_NODE.PARENT_ID
	 * 
	 * @返回 RES_TREE_NODE.PARENT_ID
	 * 
	 * @mbggenerated 2012-01-30 11:58
	 */

	@com.kingnod.core.annotation.Generated("2012-01-30 11:14")
	public Long getParentId() {
		return parentId;
	}

	/**
	 * 设置: null<br>
	 * 对应数据库字段: RES_TREE_NODE.PARENT_ID
	 * 
	 * @param parentId
	 *            null
	 * 
	 * @mbggenerated 2012-01-30 11:58
	 */

	@com.kingnod.core.annotation.Generated("2012-01-30 11:14")
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	/**
	 * 返回: null<br>
	 * 对应数据库字段: RES_TREE_NODE.TEXT
	 * 
	 * @返回 RES_TREE_NODE.TEXT
	 * 
	 * @mbggenerated 2012-01-30 11:58
	 */

	@com.kingnod.core.annotation.Generated("2012-01-30 11:14")
	public String getText() {
		return text;
	}

	/**
	 * 设置: null<br>
	 * 对应数据库字段: RES_TREE_NODE.TEXT
	 * 
	 * @param text
	 *            null
	 * 
	 * @mbggenerated 2012-01-30 11:58
	 */

	@com.kingnod.core.annotation.Generated("2012-01-30 11:14")
	public void setText(String text) {
		this.text = text == null ? null : text.trim();
	}

	/**
	 * 返回: null<br>
	 * 对应数据库字段: RES_TREE_NODE.HINT
	 * 
	 * @返回 RES_TREE_NODE.HINT
	 * 
	 * @mbggenerated 2012-01-30 11:58
	 */

	@com.kingnod.core.annotation.Generated("2012-01-30 11:14")
	public String getHint() {
		return hint;
	}

	/**
	 * 设置: null<br>
	 * 对应数据库字段: RES_TREE_NODE.HINT
	 * 
	 * @param hint
	 *            null
	 * 
	 * @mbggenerated 2012-01-30 11:58
	 */

	@com.kingnod.core.annotation.Generated("2012-01-30 11:14")
	public void setHint(String hint) {
		this.hint = hint == null ? null : hint.trim();
	}

	/**
	 * 返回: null<br>
	 * 对应数据库字段: RES_TREE_NODE.ICON
	 * 
	 * @返回 RES_TREE_NODE.ICON
	 * 
	 * @mbggenerated 2012-01-30 11:58
	 */

	@com.kingnod.core.annotation.Generated("2012-01-30 11:14")
	public String getIcon() {
		return icon;
	}

	/**
	 * 设置: null<br>
	 * 对应数据库字段: RES_TREE_NODE.ICON
	 * 
	 * @param icon
	 *            null
	 * 
	 * @mbggenerated 2012-01-30 11:58
	 */

	@com.kingnod.core.annotation.Generated("2012-01-30 11:14")
	public void setIcon(String icon) {
		this.icon = icon == null ? null : icon.trim();
	}

	/**
	 * 返回: null<br>
	 * 对应数据库字段: RES_TREE_NODE.DATA
	 * 
	 * @返回 RES_TREE_NODE.DATA
	 * 
	 * @mbggenerated 2012-01-30 11:58
	 */

	@com.kingnod.core.annotation.Generated("2012-01-30 11:14")
	public Date getData() {
		return data;
	}

	/**
	 * 设置: null<br>
	 * 对应数据库字段: RES_TREE_NODE.DATA
	 * 
	 * @param data
	 *            null
	 * 
	 * @mbggenerated 2012-01-30 11:58
	 */

	@com.kingnod.core.annotation.Generated("2012-01-30 11:14")
	public void setData(Date data) {
		this.data = data;
	}

	/**
	 * 返回: null<br>
	 * 对应数据库字段: RES_TREE_NODE.URL
	 * 
	 * @返回 RES_TREE_NODE.URL
	 * 
	 * @mbggenerated 2012-01-30 11:58
	 */

	@com.kingnod.core.annotation.Generated("2012-01-30 11:14")
	public String getUrl() {
		return url;
	}

	/**
	 * 设置: null<br>
	 * 对应数据库字段: RES_TREE_NODE.URL
	 * 
	 * @param url
	 *            null
	 * 
	 * @mbggenerated 2012-01-30 11:58
	 */

	@com.kingnod.core.annotation.Generated("2012-01-30 11:14")
	public void setUrl(String url) {
		this.url = url == null ? null : url.trim();
	}

	/**
	 * 返回: null<br>
	 * 对应数据库字段: RES_TREE_NODE.TARGET
	 * 
	 * @返回 RES_TREE_NODE.TARGET
	 * 
	 * @mbggenerated 2012-01-30 11:58
	 */

	@com.kingnod.core.annotation.Generated("2012-01-30 11:14")
	public String getTarget() {
		return target;
	}

	/**
	 * 设置: null<br>
	 * 对应数据库字段: RES_TREE_NODE.TARGET
	 * 
	 * @param target
	 *            null
	 * 
	 * @mbggenerated 2012-01-30 11:58
	 */

	@com.kingnod.core.annotation.Generated("2012-01-30 11:14")
	public void setTarget(String target) {
		this.target = target == null ? null : target.trim();
	}

	/**
	 * 返回: null<br>
	 * 对应数据库字段: RES_TREE_NODE.METHOD
	 * 
	 * @返回 RES_TREE_NODE.METHOD
	 * 
	 * @mbggenerated 2012-01-30 11:58
	 */

	@com.kingnod.core.annotation.Generated("2012-01-30 11:14")
	public String getMethod() {
		return method;
	}

	/**
	 * 设置: null<br>
	 * 对应数据库字段: RES_TREE_NODE.METHOD
	 * 
	 * @param method
	 *            null
	 * 
	 * @mbggenerated 2012-01-30 11:58
	 */

	@com.kingnod.core.annotation.Generated("2012-01-30 11:14")
	public void setMethod(String method) {
		this.method = method == null ? null : method.trim();
	}

	/**
	 * 返回: null<br>
	 * 对应数据库字段: RES_TREE_NODE.RECORD_STATUS
	 * 
	 * @返回 RES_TREE_NODE.RECORD_STATUS
	 * 
	 * @mbggenerated 2012-01-30 11:58
	 */

	@com.kingnod.core.annotation.Generated("2012-01-30 11:14")
	public String getRecordStatus() {
		return recordStatus;
	}

	/**
	 * 设置: null<br>
	 * 对应数据库字段: RES_TREE_NODE.RECORD_STATUS
	 * 
	 * @param recordStatus
	 *            null
	 * 
	 * @mbggenerated 2012-01-30 11:58
	 */

	@com.kingnod.core.annotation.Generated("2012-01-30 11:14")
	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus == null ? null : recordStatus.trim();
	}

	/**
	 * 返回: null<br>
	 * 对应数据库字段: RES_TREE_NODE.UPDATE_COUNT
	 * 
	 * @返回 RES_TREE_NODE.UPDATE_COUNT
	 * 
	 * @mbggenerated 2012-01-30 11:58
	 */

	@com.kingnod.core.annotation.Generated("2012-01-30 11:14")
	public Long getUpdateCount() {
		return updateCount;
	}

	/**
	 * 设置: null<br>
	 * 对应数据库字段: RES_TREE_NODE.UPDATE_COUNT
	 * 
	 * @param updateCount
	 *            null
	 * 
	 * @mbggenerated 2012-01-30 11:58
	 */

	@com.kingnod.core.annotation.Generated("2012-01-30 11:14")
	public void setUpdateCount(Long updateCount) {
		this.updateCount = updateCount;
	}

	/**
	 * 返回: null<br>
	 * 对应数据库字段: RES_TREE_NODE.CREATOR_ID
	 * 
	 * @返回 RES_TREE_NODE.CREATOR_ID
	 * 
	 * @mbggenerated 2012-01-30 11:58
	 */

	@com.kingnod.core.annotation.Generated("2012-01-30 11:14")
	public Long getCreatorId() {
		return creatorId;
	}

	/**
	 * 设置: null<br>
	 * 对应数据库字段: RES_TREE_NODE.CREATOR_ID
	 * 
	 * @param creatorId
	 *            null
	 * 
	 * @mbggenerated 2012-01-30 11:58
	 */

	@com.kingnod.core.annotation.Generated("2012-01-30 11:14")
	public void setCreatorId(Long creatorId) {
		this.creatorId = creatorId;
	}

	/**
	 * 返回: null<br>
	 * 对应数据库字段: RES_TREE_NODE.CREATE_DATE
	 * 
	 * @返回 RES_TREE_NODE.CREATE_DATE
	 * 
	 * @mbggenerated 2012-01-30 11:58
	 */

	@com.kingnod.core.annotation.Generated("2012-01-30 11:14")
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * 设置: null<br>
	 * 对应数据库字段: RES_TREE_NODE.CREATE_DATE
	 * 
	 * @param createDate
	 *            null
	 * 
	 * @mbggenerated 2012-01-30 11:58
	 */

	@com.kingnod.core.annotation.Generated("2012-01-30 11:14")
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * 返回: null<br>
	 * 对应数据库字段: RES_TREE_NODE.UPDATER_ID
	 * 
	 * @返回 RES_TREE_NODE.UPDATER_ID
	 * 
	 * @mbggenerated 2012-01-30 11:58
	 */

	@com.kingnod.core.annotation.Generated("2012-01-30 11:14")
	public Long getUpdaterId() {
		return updaterId;
	}

	/**
	 * 设置: null<br>
	 * 对应数据库字段: RES_TREE_NODE.UPDATER_ID
	 * 
	 * @param updaterId
	 *            null
	 * 
	 * @mbggenerated 2012-01-30 11:58
	 */

	@com.kingnod.core.annotation.Generated("2012-01-30 11:14")
	public void setUpdaterId(Long updaterId) {
		this.updaterId = updaterId;
	}

	/**
	 * 返回: null<br>
	 * 对应数据库字段: RES_TREE_NODE.UPDATE_DATE
	 * 
	 * @返回 RES_TREE_NODE.UPDATE_DATE
	 * 
	 * @mbggenerated 2012-01-30 11:58
	 */

	@com.kingnod.core.annotation.Generated("2012-01-30 11:14")
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * 设置: null<br>
	 * 对应数据库字段: RES_TREE_NODE.UPDATE_DATE
	 * 
	 * @param updateDate
	 *            null
	 * 
	 * @mbggenerated 2012-01-30 11:58
	 */

	@com.kingnod.core.annotation.Generated("2012-01-30 11:14")
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * 返回: null<br>
	 * 对应数据库字段: RES_TREE_NODE.NODE_TYPE
	 * 
	 * @返回 RES_TREE_NODE.NODE_TYPE
	 * 
	 * @mbggenerated 2012-01-30 11:58
	 */

	@com.kingnod.core.annotation.Generated("2012-01-30 11:14")
	public String getNodeType() {
		return nodeType;
	}

	/**
	 * 设置: null<br>
	 * 对应数据库字段: RES_TREE_NODE.NODE_TYPE
	 * 
	 * @param nodeType
	 *            null
	 * 
	 * @mbggenerated 2012-01-30 11:58
	 */

	@com.kingnod.core.annotation.Generated("2012-01-30 11:14")
	public void setNodeType(String nodeType) {
		this.nodeType = nodeType == null ? null : nodeType.trim();
	}

	/**
	 * 返回: null<br>
	 * 对应数据库字段: RES_TREE_NODE.NODE_LOCATION
	 * 
	 * @返回 RES_TREE_NODE.NODE_LOCATION
	 * 
	 * @mbggenerated 2012-01-30 11:58
	 */

	@com.kingnod.core.annotation.Generated("2012-01-30 11:14")
	public String getNodeLocation() {
		return nodeLocation;
	}

	/**
	 * 设置: null<br>
	 * 对应数据库字段: RES_TREE_NODE.NODE_LOCATION
	 * 
	 * @param nodeLocation
	 *            null
	 * 
	 * @mbggenerated 2012-01-30 11:58
	 */

	@com.kingnod.core.annotation.Generated("2012-01-30 11:14")
	public void setNodeLocation(String nodeLocation) {
		this.nodeLocation = nodeLocation == null ? null : nodeLocation.trim();
	}
}