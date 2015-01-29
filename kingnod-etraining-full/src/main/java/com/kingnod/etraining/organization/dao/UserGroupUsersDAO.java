package com.kingnod.etraining.organization.dao;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.dao.EntityDAO;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.organization.entity.User;
import com.kingnod.etraining.organization.entity.UserGroupUsers;


    @com.kingnod.core.annotation.Generated("2012-02-23 19:36")
public interface UserGroupUsersDAO extends EntityDAO<UserGroupUsers, Long> {
    	PagingResult<UserGroupUsers> findListByGroupId(Criteria criteria);
}