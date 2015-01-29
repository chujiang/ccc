package com.kingnod.etraining.organization.service;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.organization.entity.UserPropertyData;


    @com.kingnod.core.annotation.Generated("2012-02-17 10:16")
public interface UserPropertyDataService {

    
    @com.kingnod.core.annotation.Generated("2012-02-17 10:16")
    UserPropertyData getUserPropertyData(Long id);

    
    @com.kingnod.core.annotation.Generated("2012-02-17 10:16")
    int saveUserPropertyData(UserPropertyData userPropertyData);

    
    @com.kingnod.core.annotation.Generated("2012-02-17 10:16")
    int deleteUserPropertyData(UserPropertyData userPropertyData);

    
    @com.kingnod.core.annotation.Generated("2012-02-17 10:16")
    int deleteUserPropertyDataByIds(Long[] ids);

    
    @com.kingnod.core.annotation.Generated("2012-02-17 10:16")
    PagingResult<UserPropertyData> findUserPropertyData(Criteria criteria);
    
	UserPropertyData getIdByLoginName(String loginName, Long siteId);
    
}