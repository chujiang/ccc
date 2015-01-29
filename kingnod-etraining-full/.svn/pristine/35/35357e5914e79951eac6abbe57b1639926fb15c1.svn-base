package com.kingnod.etraining.common.service.impl;

import java.util.List;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.common.NoticeType;
import com.kingnod.etraining.common.ObjectType;
import com.kingnod.etraining.common.dao.NoticeSettingsDAO;
import com.kingnod.etraining.common.entity.NoticeSettings;
import com.kingnod.etraining.common.service.NoticeSettingsService;

import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class NoticeSettingsServiceImpl implements NoticeSettingsService {

    @Autowired
    protected NoticeSettingsDAO noticeSettingsDAO;


    public NoticeSettings getNoticeSettings(Long id) {
        return noticeSettingsDAO.get(id);
    }

    public int saveNoticeSettings(NoticeSettings noticeSettings) {
        int count = 0;
        IdEntity<Long> idEntity = (IdEntity)noticeSettings;
        if(null != idEntity.getId() && null != noticeSettingsDAO.get(idEntity.getId())){
            count = noticeSettingsDAO.update(noticeSettings);
        }else{
            count = noticeSettingsDAO.insert(noticeSettings);
        }
        return count;
    }

    public int deleteNoticeSettings(NoticeSettings noticeSettings) {
        return noticeSettingsDAO.delete(noticeSettings);
    }

    public int deleteNoticeSettingsByIds(Long[] ids) {
        return noticeSettingsDAO.deleteById(ids);
    }

    public PagingResult<NoticeSettings> findNoticeSettings(Criteria criteria) {
        return noticeSettingsDAO.findPagingResult(criteria);
    }
    /**
     * 取得对应实例的通知设置信息
     */
    public NoticeSettings getNoticeSettings(ObjectType objectType,NoticeType noticeType, Long objectId ,Long siteId){
    	
		NoticeSettings noticeSettings = null ;
		
		CriteriaBuilder cb = Cnd.builder(NoticeSettings.class);
		cb.andEQ("siteId", siteId);
		cb.andEQ("objectType", objectType);
		cb.andEQ("noticeConfigType", noticeType);
		cb.andEQ("objectId", objectId);
		List noticeSettingsList = noticeSettingsDAO.findByCriteria(cb.buildCriteria());
		if (noticeSettingsList.size() > 0) {
			noticeSettings = (NoticeSettings)noticeSettingsList.get(0);
		}
		return noticeSettings;
    	
    }
    /**
     * 取得对应实例的通知设置信息
     */
    public NoticeSettings getNoticeSettings(ObjectType objectType, Long objectId ,Long siteId){
    	
    	NoticeSettings noticeSettings = null ;
    	
    	CriteriaBuilder cb = Cnd.builder(NoticeSettings.class);
    	cb.andEQ("siteId", siteId);
    	cb.andEQ("objectType", objectType);
    	cb.andEQ("objectId", objectId);
    	List noticeSettingsList = noticeSettingsDAO.findByCriteria(cb.buildCriteria());
    	if (noticeSettingsList.size() > 0) {
    		noticeSettings = (NoticeSettings)noticeSettingsList.get(0);
    	}
    	return noticeSettings;
    	
    }
    
}