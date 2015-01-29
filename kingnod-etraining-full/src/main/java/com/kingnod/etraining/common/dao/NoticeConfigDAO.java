package com.kingnod.etraining.common.dao;

import java.util.List;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.dao.EntityDAO;
import com.kingnod.etraining.common.entity.NoticeConfig;


    @com.kingnod.core.annotation.Generated("2012-04-24 10:44")
	
    public interface NoticeConfigDAO extends EntityDAO<NoticeConfig, Long> {
	  public List<NoticeConfig>  findByCriteriaWithdClob(Criteria criteria);
	}