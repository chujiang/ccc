package com.kingnod.etraining.organization.service;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.organization.entity.User;
import com.kingnod.etraining.organization.entity.UserGroupUsers;


    @com.kingnod.core.annotation.Generated("2012-02-23 19:36")
public interface UserGroupUsersService {

    
    @com.kingnod.core.annotation.Generated("2012-02-23 19:36")
    UserGroupUsers getUserGroupUsers(Long id);

    
    @com.kingnod.core.annotation.Generated("2012-02-23 19:36")
    int saveUserGroupUsers(UserGroupUsers userGroupUsers);

    
    @com.kingnod.core.annotation.Generated("2012-02-23 19:36")
    int deleteUserGroupUsers(UserGroupUsers userGroupUsers);

    
    @com.kingnod.core.annotation.Generated("2012-02-23 19:36")
    int deleteUserGroupUsersByIds(Long[] ids);

    
    @com.kingnod.core.annotation.Generated("2012-02-23 19:36")
    PagingResult<UserGroupUsers> findUserGroupUsers(Criteria criteria);
    
    PagingResult<UserGroupUsers> findListByGroupId(Criteria criteria);
}