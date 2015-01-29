package com.kingnod.etraining.common.dao;

import java.util.ArrayList;
import java.util.List;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.dao.MybatisEntityDAO;
import com.kingnod.etraining.common.entity.Notice;

@org.springframework.stereotype.Repository

    @com.kingnod.core.annotation.Generated("2012-04-25 11:16")
public class NoticeDAOImpl extends MybatisEntityDAO<Notice, Long> implements NoticeDAO {
	
	private static final String FIND_BY_CRITERIA_CLOB ="findByCriteriaWithClob";
	 
	@Override
	 public  Notice get(Long id){
	    return (Notice)getSqlSession().selectOne(sqlId(FIND_BY_ID),id);
	 }

	 public List<Notice>  findByCriteriaWithdClob(Criteria criteria){
		
		 List list = new ArrayList<Notice>();
		
		 list = getSqlSession().selectList(sqlId(FIND_BY_CRITERIA_CLOB),criteria); 
		 
		 return list;
	 }
	

}