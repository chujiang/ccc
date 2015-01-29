package com.kingnod.etraining.organization.dao;

import java.util.HashMap;
import java.util.Map;

import com.kingnod.core.dao.MybatisEntityDAO;
import com.kingnod.etraining.organization.entity.UserPropertyData;

@org.springframework.stereotype.Repository

    @com.kingnod.core.annotation.Generated("2012-02-17 10:16")
public class UserPropertyDataDAOImpl extends MybatisEntityDAO<UserPropertyData, Long> implements UserPropertyDataDAO {

	public UserPropertyData getIdByLoginName(String loginName, Long siteId) {
		Map params = new HashMap();
		params.put("siteId", siteId);
		params.put("loginName", loginName);
		return (UserPropertyData) getSqlSession().selectOne(sqlId("getIdByLoginName"),params);
	}

}