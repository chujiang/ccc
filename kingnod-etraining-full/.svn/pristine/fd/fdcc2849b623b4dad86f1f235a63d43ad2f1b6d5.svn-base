package com.kingnod.etraining.organization.service;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.organization.entity.UserProperties;
import java.util.List;


    @com.kingnod.core.annotation.Generated("2012-02-18 18:13")
public interface UserPropertiesService {
    
    List<UserProperties> findListBySiteId(Long siteId);

    
    @com.kingnod.core.annotation.Generated("2012-02-18 18:13")
    UserProperties getUserProperties(Long id);

    
    @com.kingnod.core.annotation.Generated("2012-02-18 18:13")
    int saveUserProperties(UserProperties userProperties);

    
    @com.kingnod.core.annotation.Generated("2012-02-18 18:13")
    int deleteUserProperties(UserProperties userProperties);

    
    @com.kingnod.core.annotation.Generated("2012-02-18 18:13")
    int deleteUserPropertiesByIds(Long[] ids);

    
    @com.kingnod.core.annotation.Generated("2012-02-18 18:13")
    PagingResult<UserProperties> findUserProperties(Criteria criteria);

    /**
     * 处理 上移  下移  至顶  至尾
     * @param userProperties
     */
	void movebleUserProperties(UserProperties userProperties);
}