package com.kingnod.etraining.common.dao;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.dao.MybatisEntityDAO;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.common.entity.SysParameter;

@org.springframework.stereotype.Repository
@com.kingnod.core.annotation.Generated("2012-02-02 11:42")
public class SysParameterDAOImpl extends MybatisEntityDAO<SysParameter, Long>
		implements SysParameterDAO {

	public PagingResult<SysParameter> findListSysParameterBySiteId(Long siteId,	Criteria criteria) {
		return pagingQuery(sqlId("countSysParameterBySiteId"), sqlId("findListSysParameterBySiteId"), criteria);
	}

	public SysParameter findByCode(String code) {
		return (SysParameter) getSqlSession().selectOne(sqlId("findByCode"), code);
	}

}