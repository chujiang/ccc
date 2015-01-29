package com.kingnod.etraining.organization.dao;

import java.util.List;
import java.util.Map;

import com.kingnod.core.dao.MybatisEntityDAO;
import com.kingnod.etraining.organization.entity.UserGroupFilter;

@org.springframework.stereotype.Repository

    @com.kingnod.core.annotation.Generated("2012-02-09 18:44")
public class UserGroupFilterDAOImpl extends MybatisEntityDAO<UserGroupFilter, Long> implements UserGroupFilterDAO {

	public Long getGroupNumber() {
		return (Long) getSqlSession().selectOne(sqlId("getGroupNumber"));
	}

	public void mergeCondition(Map ids) {
		getSqlSession().update(sqlId("mergeCondition"),ids);
	}

	public void cancelMerge(Map ids) {
		getSqlSession().update(sqlId("cancelMerge"),ids);
	}

	public List<UserGroupFilter> findByUserGroupId(Long groupId) {
		return getSqlSession().selectList(sqlId("findByUserGroupId"),groupId);
	}

}