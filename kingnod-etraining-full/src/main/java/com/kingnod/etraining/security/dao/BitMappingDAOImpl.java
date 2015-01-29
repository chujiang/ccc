package com.kingnod.etraining.security.dao;

import java.util.List;

import com.kingnod.core.dao.MybatisDaoSupport;
import com.kingnod.etraining.security.entity.BitMapping;

@org.springframework.stereotype.Repository

@com.kingnod.core.annotation.Generated("2012-03-26 20:59")
public class BitMappingDAOImpl extends MybatisDaoSupport implements BitMappingDAO {

	public BitMapping getAll(){
	  return null;
	}
	
	public void deleteBitMapping(BitMapping bitMapping){
	}
	
	/**
	 * 初始化BitMapping
	 */
	@SuppressWarnings("unchecked")
	public List<BitMapping> getAllBitMapping() {
		return getSqlSession().selectList("getAllBitMapping");
	}
	
	/**
	 * 保存读权限的映射关系
	 */
	public void saveBitMapping(BitMapping bitMapping){
		getSqlSession().update("saveBitMapping",bitMapping);
	}
	
	/**
	 * 
	 */
	public BitMapping getNotUsedBitMapping(String mappingType){
		return (BitMapping)getSqlSession().selectOne("getNotUsedBitMapping", mappingType);
	}
}