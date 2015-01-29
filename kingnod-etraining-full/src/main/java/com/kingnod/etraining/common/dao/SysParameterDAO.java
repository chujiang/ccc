package com.kingnod.etraining.common.dao;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.dao.EntityDAO;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.common.entity.SysParameter;

@com.kingnod.core.annotation.Generated("2012-02-02 11:42")
public interface SysParameterDAO extends EntityDAO<SysParameter, Long> {

	/**
	 * 根据站点ID获取系统参数的list， list包括系统级和站点级， 假如某站点已更新过系统参数， 则取更新后的记录， 否则取初始化时的记录
	 */
	PagingResult<SysParameter> findListSysParameterBySiteId(Long siteId, Criteria criteria);
	
	SysParameter findByCode(String code);

}