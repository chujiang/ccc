package com.kingnod.etraining.common.service;

import java.util.List;
import java.util.Map;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.common.entity.Role;


    @com.kingnod.core.annotation.Generated("2012-03-06 15:30")
public interface RoleService {

    
    @com.kingnod.core.annotation.Generated("2012-03-06 15:30")
    Role getRole(Long id);

    
    @com.kingnod.core.annotation.Generated("2012-03-06 15:30")
    int saveRole(Role role);

    
    @com.kingnod.core.annotation.Generated("2012-03-06 15:30")
    int deleteRole(Role role);

    
    @com.kingnod.core.annotation.Generated("2012-03-06 15:30")
    int deleteRoleByIds(Long[] ids);

    
    @com.kingnod.core.annotation.Generated("2012-03-06 15:30")
    PagingResult<Role> findRole(Criteria criteria);
    
    @com.kingnod.core.annotation.Generated("2012-03-06 15:30")
    List<Role> getAllRole();
    
    @com.kingnod.core.annotation.Generated("2012-03-06 15:30")
    List<Role> getRoleByUser(Long userId);
    
    List<Role> findRoleBySiteId(Map<String,Object> map);
    
    List<Role> findRoleBySiteId(Long siteId);
}