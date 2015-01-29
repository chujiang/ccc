package com.kingnod.etraining.organization.dao;

import java.util.List;
import java.util.Map;

import com.kingnod.core.dao.EntityDAO;
import com.kingnod.etraining.organization.entity.UserGroupFilter;


    @com.kingnod.core.annotation.Generated("2012-02-09 18:44")
public interface UserGroupFilterDAO extends EntityDAO<UserGroupFilter, Long> {
    	public Long getGroupNumber();
    	public void mergeCondition(Map ids);
    	public void cancelMerge(Map ids);
    	List<UserGroupFilter> findByUserGroupId(Long groupId);
}