package com.kingnod.etraining.common.service.impl;

import java.util.List;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.exception.Exceptions;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.common.dao.NoticeConfigDAO;
import com.kingnod.etraining.common.entity.NoticeConfig;
import com.kingnod.etraining.common.service.NoticeConfigService;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class NoticeConfigServiceImpl implements NoticeConfigService {

    @Autowired
    protected NoticeConfigDAO noticeConfigDAO;


    public NoticeConfig getNoticeConfig(Long id) {
        return noticeConfigDAO.get(id);
    }

    /**
     * 保存通知模板，并限制同一站点同一类型只保存一次
     */
    public int saveNoticeConfig(NoticeConfig noticeConfig) {
        int count = 0;
        IdEntity<Long> idEntity = (IdEntity)noticeConfig;
        if(null != idEntity.getId() && null != noticeConfigDAO.get(idEntity.getId())){
            count = noticeConfigDAO.update(noticeConfig);
        }else{
        	if(!StringUtils.isEmpty(noticeConfig.getNoticeType())&& !"NONE".equals(noticeConfig.getNoticeType())){
	        	CriteriaBuilder cb = Cnd.builder(NoticeConfig.class);
				cb.andEQ("siteId", noticeConfig.getSiteId());
				cb.andEQ("noticeType", noticeConfig.getNoticeType());
				Criteria criteria = cb.buildCriteria();
				if(noticeConfigDAO.countByCriteria(criteria)>0){
					throw Exceptions.createAppException("noticeconfig_type_0001");
				}
        	}
            count = noticeConfigDAO.insert(noticeConfig);
        }
        return count;
    }

    public int deleteNoticeConfig(NoticeConfig noticeConfig) {
        return noticeConfigDAO.delete(noticeConfig);
    }

    public int deleteNoticeConfigByIds(Long[] ids) {
        return noticeConfigDAO.deleteById(ids);
    }

    public PagingResult<NoticeConfig> findNoticeConfig(Criteria criteria) {
        return noticeConfigDAO.findPagingResult(criteria);
    }
}