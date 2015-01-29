package com.kingnod.etraining.common.dao;

import java.util.ArrayList;
import java.util.List;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.dao.MybatisEntityDAO;
import com.kingnod.etraining.common.entity.NoticeConfig;

@org.springframework.stereotype.Repository

    @com.kingnod.core.annotation.Generated("2012-04-24 10:44")
public class NoticeConfigDAOImpl extends MybatisEntityDAO<NoticeConfig, Long> implements NoticeConfigDAO {
	 
	private static final String FIND_BY_CRITERIA_CLOB ="findByCriteriaWithClob";
	
	@Override
	 public  NoticeConfig get(Long id){
	    return (NoticeConfig)getSqlSession().selectOne(sqlId(FIND_BY_ID),id);
	 }
	 public List<NoticeConfig>  findByCriteriaWithdClob(Criteria criteria){
			
		 List list = new ArrayList<NoticeConfig>();
		
		 list = getSqlSession().selectList(sqlId(FIND_BY_CRITERIA_CLOB),criteria); 
		 
		 return list;
	 }
		
}