package com.kingnod.etraining.common.service;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.common.entity.RoleRef;


    @com.kingnod.core.annotation.Generated("2012-03-16 09:42")
public interface RoleRefService {

    
    @com.kingnod.core.annotation.Generated("2012-03-16 09:42")
    RoleRef getRoleRef(Long id);

    
    @com.kingnod.core.annotation.Generated("2012-03-16 09:42")
    int saveRoleRef(RoleRef roleRef);

    
    @com.kingnod.core.annotation.Generated("2012-03-16 09:42")
    int deleteRoleRef(RoleRef roleRef);

    
    @com.kingnod.core.annotation.Generated("2012-03-16 09:42")
    int deleteRoleRefByIds(Long[] ids);

    
    @com.kingnod.core.annotation.Generated("2012-03-16 09:42")
    PagingResult<RoleRef> findRoleRef(Criteria criteria);
    
    @com.kingnod.core.annotation.Generated("2012-03-16 09:42")
    void delRoleByUser(Long ownerId);
}