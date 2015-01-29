package com.kingnod.etraining.security.dao;

import java.util.List;

import com.kingnod.core.dao.MybatisEntityDAO;
import com.kingnod.etraining.security.entity.EntityAuthority;

@org.springframework.stereotype.Repository

@com.kingnod.core.annotation.Generated("2012-03-26 14:51")
public class EntityAuthorityDAOImpl extends MybatisEntityDAO<EntityAuthority, Long> implements EntityAuthorityDAO {
	
	@SuppressWarnings("unchecked")
	public List<EntityAuthority> findAuthorityByType(String type){
		return getSqlSession().selectList("findAuthorityByType",type);
	}
}