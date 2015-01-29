package com.kingnod.etraining.organization.service;

import java.util.List;
import java.util.Map;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.organization.entity.UserGroup;


    @com.kingnod.core.annotation.Generated("2012-02-08 16:26")
public interface UserGroupService {

    
    @com.kingnod.core.annotation.Generated("2012-02-08 16:26")
    UserGroup getUserGroup(Long id);

    
    @com.kingnod.core.annotation.Generated("2012-02-08 16:26")
    int saveUserGroup(UserGroup userGroup);

    
    @com.kingnod.core.annotation.Generated("2012-02-08 16:26")
    int deleteUserGroup(UserGroup userGroup);

    
    @com.kingnod.core.annotation.Generated("2012-02-08 16:26")
    int deleteUserGroupByIds(Long[] ids);

    
    @com.kingnod.core.annotation.Generated("2012-02-08 16:26")
    PagingResult<UserGroup> findUserGroup(Criteria criteria);
    
    void refreshAllUserGroupMember() ;
    
    void refreshMember(UserGroup userGroup) ;
    
    Long getGroupNumber();
    
    List<UserGroup> getUserGroupBySiteId(Map<String,Object> map);
    
     void sendNoticeUserGroupChange(UserGroup userGroup);
}