package com.kingnod.etraining.organization.dao;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.dao.MybatisEntityDAO;
import com.kingnod.etraining.organization.entity.OrganizationHierarchy;

@org.springframework.stereotype.Repository

    @com.kingnod.core.annotation.Generated("2012-04-20 22:27")
public class OrganizationHierarchyDAOImpl extends MybatisEntityDAO<OrganizationHierarchy, Long> implements OrganizationHierarchyDAO {


	/**
	 * 硬删除
	 * @param criteria
	 * @return
	 */
	public int hardDeleteByCriteria(Criteria criteria) {
		return getSqlSession().delete(sqlId(DELETE_BY_CRITERIA), criteria);
	}
	
}