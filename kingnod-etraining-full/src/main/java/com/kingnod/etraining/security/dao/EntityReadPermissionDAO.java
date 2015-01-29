package com.kingnod.etraining.security.dao;

import java.util.Map;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.etraining.security.entity.BitMapping;
import com.kingnod.etraining.security.entity.EntityObject;
import com.kingnod.etraining.security.entity.EntityReadPermission;
import com.kingnod.etraining.security.entity.Owner;


@com.kingnod.core.annotation.Generated("2012-03-26 21:04")
public interface EntityReadPermissionDAO{
	/** 
	 * 新增一条数据级的读取权限
	 * @param erp
	 */
	void insert(EntityReadPermission erp);
	
	/** 
	 * 更新一条数据级的读取权限
	 * @param erp
	 */
	void update(EntityReadPermission erp);
	
	/** 
	 * 为某条数据设置读权限，如果已存在这条记录，则根据映射表中的序号更新相应拥有者。
	 * @param eo 实体对象实例
	 * @param owner 拥有者
	 * @param bm 映射信息对象
	 */
	void insertOrUpdate(EntityObject eo,Owner owner,BitMapping bm);
	
	/**
	 * 查询只读权限
	 * @param readPermission
	 * @return Long
	 */
	Long getEntityReadPermission(Map<String,Object> map);
	
	/**
	 * 保存读权限
	 * @param map
	 */
	void saveReadAthority(Map<String,Object> map);
	
	int deleteByCriteria(Criteria criteria);
	
	EntityReadPermission getReadPermissionByEntityId(EntityObject entityObj);
	
	void saveReadPermission(EntityReadPermission readPermission);
}