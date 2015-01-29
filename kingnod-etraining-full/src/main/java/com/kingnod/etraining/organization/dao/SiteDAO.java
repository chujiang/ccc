package com.kingnod.etraining.organization.dao;

import java.util.List;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.dao.EntityDAO;
import com.kingnod.etraining.organization.entity.Site;


    @com.kingnod.core.annotation.Generated("2012-02-06 16:47")
public interface SiteDAO extends EntityDAO<Site, Long> {
    	
    	/**
    	 * 获取有权限访问的Top站点
    	 */
    	public List<Site> findTopLevelByCriteria(Criteria criteria);

}