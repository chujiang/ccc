package com.kingnod.etraining.security.dao;

import java.util.List;

import com.kingnod.etraining.security.entity.BitMapping;


@com.kingnod.core.annotation.Generated("2012-03-26 20:59")
public interface BitMappingDAO{
/** 
 * 获取所有ObjectId不为空的映射记录
 * @return
 */
public BitMapping getAll();
	/** 
	 * 保存一个映射值，系统在初始时应该已经提供了所有objectId为空（其他字段都有值）的记录，此处的保存
	 * 只是根据权限管理设计将某条Mapping中的ObjectId与ReadPermission中进行关联。
	 * @param bitMapping
	 */
	public void saveBitMapping(BitMapping bitMapping);
	/** 
	 * 删除某条映射值，并不删除记录，只是将ObjectId设置为null
	 * @param bitMapping
	 */
	public void deleteBitMapping(BitMapping bitMapping);
	
	/**
	 * 初始化BitMapping
	 * @return	List<BitMapping>
	 */
	public List<BitMapping> getAllBitMapping();
	
	/**
	 * 根据指定的类型获取没有使用的记录
	 */
	public BitMapping getNotUsedBitMapping(String mappingType);
	
}