package com.kingnod.etraining.organization.dao;

import com.kingnod.core.dao.EntityDAO;
import com.kingnod.etraining.organization.entity.UserPropertyData;


    @com.kingnod.core.annotation.Generated("2012-02-17 10:16")
public interface UserPropertyDataDAO extends EntityDAO<UserPropertyData, Long> {
    	UserPropertyData getIdByLoginName(String loginName, Long siteId);
}