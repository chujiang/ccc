package com.kingnod.etraining.organization.dao;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.dao.MybatisEntityDAO;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.organization.entity.User;
import com.kingnod.etraining.organization.entity.UserGroupUsers;

@org.springframework.stereotype.Repository

    @com.kingnod.core.annotation.Generated("2012-02-23 19:36")
public class UserGroupUsersDAOImpl extends MybatisEntityDAO<UserGroupUsers, Long> implements UserGroupUsersDAO {

	public PagingResult<UserGroupUsers> findListByGroupId(Criteria criteria) {
		return pagingQuery(sqlId("countListByGroupId"),sqlId("findListByGroupId"),criteria);
	}
	
	@Override
	public int deleteByCriteria(Criteria criteria) {
		return getSqlSession().delete(sqlId(DELETE_BY_CRITERIA), criteria);
	}

}