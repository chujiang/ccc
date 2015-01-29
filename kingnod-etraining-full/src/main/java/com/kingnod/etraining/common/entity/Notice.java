package com.kingnod.etraining.common.entity;

import com.kingnod.core.criteria.annotations.SelectColumnMapping;
import com.kingnod.core.criteria.annotations.SelectColumnMappings;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.entity.RecordStatus;
import com.kingnod.etraining.common.entity.NoticeUsers;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@SelectColumnMappings({
  @SelectColumnMapping(property = "id", type = java.lang.Long.class, table = "SYS_NOTICE", tableAlias = "A", column = "ID"), 
  @SelectColumnMapping(property = "noticeType", type = java.lang.String.class, table = "SYS_NOTICE", tableAlias = "A", column = "NOTICE_TYPE"), 
  @SelectColumnMapping(property = "title", type = java.lang.String.class, table = "SYS_NOTICE", tableAlias = "A", column = "TITLE"), 
  @SelectColumnMapping(property = "status", type = java.lang.String.class, table = "SYS_NOTICE", tableAlias = "A", column = "STATUS"), 
  @SelectColumnMapping(property = "sendDate", type = java.util.Date.class, table = "SYS_NOTICE", tableAlias = "A", column = "SEND_DATE"), 
  @SelectColumnMapping(property = "recordStatus", type = java.lang.String.class, table = "SYS_NOTICE", tableAlias = "A", column = "RECORD_STATUS"), 
  @SelectColumnMapping(property = "updateCount", type = java.lang.Long.class, table = "SYS_NOTICE", tableAlias = "A", column = "UPDATE_COUNT"), 
  @SelectColumnMapping(property = "creatorId", type = java.lang.Long.class, table = "SYS_NOTICE", tableAlias = "A", column = "CREATOR_ID"), 
  @SelectColumnMapping(property = "createDate", type = java.util.Date.class, table = "SYS_NOTICE", tableAlias = "A", column = "CREATE_DATE"), 
  @SelectColumnMapping(property = "updaterId", type = java.lang.Long.class, table = "SYS_NOTICE", tableAlias = "A", column = "UPDATER_ID"), 
  @SelectColumnMapping(property = "updateDate", type = java.util.Date.class, table = "SYS_NOTICE", tableAlias = "A", column = "UPDATE_DATE"), 
  @SelectColumnMapping(property = "summary", type = java.lang.String.class, table = "SYS_NOTICE", tableAlias = "A", column = "SUMMARY"),
  @SelectColumnMapping(property = "siteId", type = java.lang.String.class, table = "SYS_NOTICE", tableAlias = "A", column = "SITE_ID"),
  @SelectColumnMapping(property = "receivers", type = java.lang.String.class, table = "SYS_NOTICE", tableAlias = "A", column = "RECEIVERS")
})

    @com.kingnod.core.annotation.Generated("2012-04-25 11:16")
public class Notice implements IdEntity<Long>, RecordStatus<Long>, Serializable {

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0409.SYS_NOTICE.ID
     *
     * @mbggenerated 2012-04-25 11:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-25 11:16")
    private Long id;

    /**
     * 通知类型<br/>
     * 对应数据库字段 ETRAINING_0409.SYS_NOTICE.NOTICE_TYPE
     *
     * @mbggenerated 2012-04-25 11:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-25 11:16")
    private String noticeType;

    /**
     * 标题<br/>
     * 对应数据库字段 ETRAINING_0409.SYS_NOTICE.TITLE
     *
     * @mbggenerated 2012-04-25 11:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-25 11:16")
    private String title;

    /**
     * 状态<br/>
     * 对应数据库字段 ETRAINING_0409.SYS_NOTICE.STATUS
     *
     * @mbggenerated 2012-04-25 11:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-25 11:16")
    private String status;

    /**
     * 发送日期<br/>
     * 对应数据库字段 ETRAINING_0409.SYS_NOTICE.SEND_DATE
     *
     * @mbggenerated 2012-04-25 11:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-25 11:16")
    private Date sendDate;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0409.SYS_NOTICE.RECORD_STATUS
     *
     * @mbggenerated 2012-04-25 11:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-25 11:16")
    private String recordStatus;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0409.SYS_NOTICE.UPDATE_COUNT
     *
     * @mbggenerated 2012-04-25 11:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-25 11:16")
    private Long updateCount;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0409.SYS_NOTICE.CREATOR_ID
     *
     * @mbggenerated 2012-04-25 11:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-25 11:16")
    private Long creatorId;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0409.SYS_NOTICE.CREATE_DATE
     *
     * @mbggenerated 2012-04-25 11:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-25 11:16")
    private Date createDate;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0409.SYS_NOTICE.UPDATER_ID
     *
     * @mbggenerated 2012-04-25 11:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-25 11:16")
    private Long updaterId;

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING_0409.SYS_NOTICE.UPDATE_DATE
     *
     * @mbggenerated 2012-04-25 11:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-25 11:16")
    private Date updateDate;

    /**
     * 内容摘要<br/>
     * 对应数据库字段 ETRAINING_0409.SYS_NOTICE.SUMMARY
     *
     * @mbggenerated 2012-04-25 11:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-25 11:16")
    private String summary;

    /**
     * 内容<br/>
     * 对应数据库字段 ETRAINING_0409.SYS_NOTICE.CONTENT
     *
     * @mbggenerated 2012-04-25 11:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-25 11:16")
    private String content;

    
    @com.kingnod.core.annotation.Generated("2012-04-25 11:16")
    private List<NoticeUsers> noticeUsers;
    
    @com.kingnod.core.annotation.Generated("2012-04-25 11:16")
    private Long siteId;
    
    @com.kingnod.core.annotation.Generated("2012-04-25 11:16")
    private String  receivers;


    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0409.SYS_NOTICE.ID
     *
     * @返回  ETRAINING_0409.SYS_NOTICE.ID
     *
     * @mbggenerated 2012-04-25 11:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-25 11:16")
    public Long getId() {
        return id;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0409.SYS_NOTICE.ID
     *
     * @param id null
     *
     * @mbggenerated 2012-04-25 11:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-25 11:16")
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 返回: 通知类型<br>
     * 对应数据库字段: ETRAINING_0409.SYS_NOTICE.NOTICE_TYPE
     *
     * @返回  ETRAINING_0409.SYS_NOTICE.NOTICE_TYPE
     *
     * @mbggenerated 2012-04-25 11:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-25 11:16")
    public String getNoticeType() {
        return noticeType;
    }

    /**
     *  设置: 通知类型<br>
     * 对应数据库字段: ETRAINING_0409.SYS_NOTICE.NOTICE_TYPE
     *
     * @param noticeType 通知类型
     *
     * @mbggenerated 2012-04-25 11:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-25 11:16")
    public void setNoticeType(String noticeType) {
        this.noticeType = noticeType == null ? null : noticeType.trim();
    }

    /**
     * 返回: 标题<br>
     * 对应数据库字段: ETRAINING_0409.SYS_NOTICE.TITLE
     *
     * @返回  ETRAINING_0409.SYS_NOTICE.TITLE
     *
     * @mbggenerated 2012-04-25 11:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-25 11:16")
    public String getTitle() {
        return title;
    }

    /**
     *  设置: 标题<br>
     * 对应数据库字段: ETRAINING_0409.SYS_NOTICE.TITLE
     *
     * @param title 标题
     *
     * @mbggenerated 2012-04-25 11:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-25 11:16")
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 返回: 状态<br>
     * 对应数据库字段: ETRAINING_0409.SYS_NOTICE.STATUS
     *
     * @返回  ETRAINING_0409.SYS_NOTICE.STATUS
     *
     * @mbggenerated 2012-04-25 11:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-25 11:16")
    public String getStatus() {
        return status;
    }

    /**
     *  设置: 状态<br>
     * 对应数据库字段: ETRAINING_0409.SYS_NOTICE.STATUS
     *
     * @param status 状态
     *
     * @mbggenerated 2012-04-25 11:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-25 11:16")
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 返回: 发送日期<br>
     * 对应数据库字段: ETRAINING_0409.SYS_NOTICE.SEND_DATE
     *
     * @返回  ETRAINING_0409.SYS_NOTICE.SEND_DATE
     *
     * @mbggenerated 2012-04-25 11:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-25 11:16")
    public Date getSendDate() {
        return sendDate;
    }

    /**
     *  设置: 发送日期<br>
     * 对应数据库字段: ETRAINING_0409.SYS_NOTICE.SEND_DATE
     *
     * @param sendDate 发送日期
     *
     * @mbggenerated 2012-04-25 11:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-25 11:16")
    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0409.SYS_NOTICE.RECORD_STATUS
     *
     * @返回  ETRAINING_0409.SYS_NOTICE.RECORD_STATUS
     *
     * @mbggenerated 2012-04-25 11:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-25 11:16")
    public String getRecordStatus() {
        return recordStatus;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0409.SYS_NOTICE.RECORD_STATUS
     *
     * @param recordStatus null
     *
     * @mbggenerated 2012-04-25 11:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-25 11:16")
    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus == null ? null : recordStatus.trim();
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0409.SYS_NOTICE.UPDATE_COUNT
     *
     * @返回  ETRAINING_0409.SYS_NOTICE.UPDATE_COUNT
     *
     * @mbggenerated 2012-04-25 11:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-25 11:16")
    public Long getUpdateCount() {
        return updateCount;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0409.SYS_NOTICE.UPDATE_COUNT
     *
     * @param updateCount null
     *
     * @mbggenerated 2012-04-25 11:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-25 11:16")
    public void setUpdateCount(Long updateCount) {
        this.updateCount = updateCount;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0409.SYS_NOTICE.CREATOR_ID
     *
     * @返回  ETRAINING_0409.SYS_NOTICE.CREATOR_ID
     *
     * @mbggenerated 2012-04-25 11:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-25 11:16")
    public Long getCreatorId() {
        return creatorId;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0409.SYS_NOTICE.CREATOR_ID
     *
     * @param creatorId null
     *
     * @mbggenerated 2012-04-25 11:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-25 11:16")
    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0409.SYS_NOTICE.CREATE_DATE
     *
     * @返回  ETRAINING_0409.SYS_NOTICE.CREATE_DATE
     *
     * @mbggenerated 2012-04-25 11:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-25 11:16")
    public Date getCreateDate() {
        return createDate;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0409.SYS_NOTICE.CREATE_DATE
     *
     * @param createDate null
     *
     * @mbggenerated 2012-04-25 11:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-25 11:16")
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0409.SYS_NOTICE.UPDATER_ID
     *
     * @返回  ETRAINING_0409.SYS_NOTICE.UPDATER_ID
     *
     * @mbggenerated 2012-04-25 11:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-25 11:16")
    public Long getUpdaterId() {
        return updaterId;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0409.SYS_NOTICE.UPDATER_ID
     *
     * @param updaterId null
     *
     * @mbggenerated 2012-04-25 11:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-25 11:16")
    public void setUpdaterId(Long updaterId) {
        this.updaterId = updaterId;
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING_0409.SYS_NOTICE.UPDATE_DATE
     *
     * @返回  ETRAINING_0409.SYS_NOTICE.UPDATE_DATE
     *
     * @mbggenerated 2012-04-25 11:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-25 11:16")
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING_0409.SYS_NOTICE.UPDATE_DATE
     *
     * @param updateDate null
     *
     * @mbggenerated 2012-04-25 11:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-25 11:16")
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 返回: 内容摘要<br>
     * 对应数据库字段: ETRAINING_0409.SYS_NOTICE.SUMMARY
     *
     * @返回  ETRAINING_0409.SYS_NOTICE.SUMMARY
     *
     * @mbggenerated 2012-04-25 11:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-25 11:16")
    public String getSummary() {
        return summary;
    }

    /**
     *  设置: 内容摘要<br>
     * 对应数据库字段: ETRAINING_0409.SYS_NOTICE.SUMMARY
     *
     * @param summary 内容摘要
     *
     * @mbggenerated 2012-04-25 11:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-25 11:16")
    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    /**
     * 返回: 内容<br>
     * 对应数据库字段: ETRAINING_0409.SYS_NOTICE.CONTENT
     *
     * @返回  ETRAINING_0409.SYS_NOTICE.CONTENT
     *
     * @mbggenerated 2012-04-25 11:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-25 11:16")
    public String getContent() {
        return content;
    }

    /**
     *  设置: 内容<br>
     * 对应数据库字段: ETRAINING_0409.SYS_NOTICE.CONTENT
     *
     * @param content 内容
     *
     * @mbggenerated 2012-04-25 11:09
     */
    
    @com.kingnod.core.annotation.Generated("2012-04-25 11:16")
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    
    @com.kingnod.core.annotation.Generated("2012-04-25 11:16")
    public List<NoticeUsers> getNoticeUsers() {
        return noticeUsers;
    }

    
    @com.kingnod.core.annotation.Generated("2012-04-25 11:16")
    public void setNoticeUsers(List<NoticeUsers> noticeUsers) {
        this.noticeUsers = noticeUsers;
    }
    
    @com.kingnod.core.annotation.Generated("2012-04-25 11:16")
	public Long getSiteId() {
		return siteId;
	}
    @com.kingnod.core.annotation.Generated("2012-04-25 11:16")
	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}
    @com.kingnod.core.annotation.Generated("2012-04-25 11:16")
	public String getReceivers() {
		return receivers;
	}
    @com.kingnod.core.annotation.Generated("2012-04-25 11:16")
	public void setReceivers(String receivers) {
		this.receivers = receivers;
	}
    
    
}