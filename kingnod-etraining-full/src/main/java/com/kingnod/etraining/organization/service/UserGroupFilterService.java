package com.kingnod.etraining.organization.service;

import java.util.List;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.organization.entity.UserGroupFilter;


    @com.kingnod.core.annotation.Generated("2012-02-09 18:44")
public interface UserGroupFilterService {

    
    @com.kingnod.core.annotation.Generated("2012-02-09 18:44")
    UserGroupFilter getUserGroupFilter(Long id);

    
    @com.kingnod.core.annotation.Generated("2012-02-09 18:44")
    int saveUserGroupFilter(UserGroupFilter userGroupFilter);

    
    @com.kingnod.core.annotation.Generated("2012-02-09 18:44")
    int deleteUserGroupFilter(UserGroupFilter userGroupFilter);

    
    @com.kingnod.core.annotation.Generated("2012-02-09 18:44")
    int deleteUserGroupFilterByIds(Long[] ids);

    
    @com.kingnod.core.annotation.Generated("2012-02-09 18:44")
    PagingResult<UserGroupFilter> findUserGroupFilter(Criteria criteria);
    
    /**
     * 用户组列表 - 条件设置 - 合并条件
     * @param ids
     */
    void mergeCondition(List<Long> ids);
    
    /**
     * 用户组列表 - 条件设置 - 取消合并
     * @param ids
     */
    void cancelMerge(List<Long> ids);
    
    /**
     * 批量新增用户
     * @param userGroupFilter
     * @param userIds
     * @return
     */
    int saveUserGroupFilter(UserGroupFilter userGroupFilter, String batchIds);
}