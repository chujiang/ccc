package com.kingnod.etraining.common.service;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.common.NoticeType;
import com.kingnod.etraining.common.ObjectType;
import com.kingnod.etraining.common.entity.NoticeSettings;


    @com.kingnod.core.annotation.Generated("2012-05-15 17:11")
public interface NoticeSettingsService {
	/** 
	 * 获取实例的通知设置
	 */
	public NoticeSettings getNoticeSettings(ObjectType objectType,NoticeType noticeType,Long objectId,Long siteId);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public NoticeSettings getNoticeSettings(ObjectType objectType, Long objectId ,Long siteId);

    
    @com.kingnod.core.annotation.Generated("2012-05-15 17:11")
    NoticeSettings getNoticeSettings(Long id);

    
    @com.kingnod.core.annotation.Generated("2012-05-15 17:11")
    int saveNoticeSettings(NoticeSettings noticeSettings);

    
    @com.kingnod.core.annotation.Generated("2012-05-15 17:11")
    int deleteNoticeSettings(NoticeSettings noticeSettings);

    
    @com.kingnod.core.annotation.Generated("2012-05-15 17:11")
    int deleteNoticeSettingsByIds(Long[] ids);

    
    @com.kingnod.core.annotation.Generated("2012-05-15 17:11")
    PagingResult<NoticeSettings> findNoticeSettings(Criteria criteria);
}