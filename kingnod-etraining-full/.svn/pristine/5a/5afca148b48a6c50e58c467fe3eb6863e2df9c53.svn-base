package com.kingnod.etraining.organization.dao;

import java.util.List;

import com.kingnod.core.dao.MybatisEntityDAO;
import com.kingnod.etraining.organization.entity.UserProperties;

@org.springframework.stereotype.Repository

    @com.kingnod.core.annotation.Generated("2012-02-18 18:13")
public class UserPropertiesDAOImpl extends MybatisEntityDAO<UserProperties, Long> implements UserPropertiesDAO {

	@SuppressWarnings("unchecked")
	public List<Integer> getNumberListByOrderPropertyNumber(Long siteId) {
		List<Integer> list = getSqlSession().selectList(sqlId("getNumberListByOrderPropertyNumber"),siteId);
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<UserProperties> findBySequence(UserProperties userProperties) {
		return getSqlSession().selectList("findUserPropertiesBySequence", userProperties);
	}

	public Integer updateSequences(UserProperties userProperties) {
		return getSqlSession().update("updateAllUserPropertiesSequences", userProperties);
	}

	public Integer findMaxBySequenceOne(UserProperties userProperties) {
		return (Integer) getSqlSession().selectOne("findMaxSeqByUserProperties", userProperties);
	}


}