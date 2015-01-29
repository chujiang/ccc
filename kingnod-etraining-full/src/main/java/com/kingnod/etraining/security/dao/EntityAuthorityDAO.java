package com.kingnod.etraining.security.dao;

import java.util.List;

import com.kingnod.core.dao.EntityDAO;
import com.kingnod.etraining.security.entity.EntityAuthority;

@com.kingnod.core.annotation.Generated("2012-03-26 14:51")
public interface EntityAuthorityDAO extends EntityDAO<EntityAuthority, Long> {
	List<EntityAuthority> findAuthorityByType(String type);
	
}