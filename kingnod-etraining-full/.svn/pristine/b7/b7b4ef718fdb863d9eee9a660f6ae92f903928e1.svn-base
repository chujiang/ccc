package com.kingnod.etraining.security.dao;

import java.util.List;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.etraining.common.ObjectType;
import com.kingnod.etraining.security.entity.EntityAuthority;
import com.kingnod.etraining.security.entity.EntityPermission;
import com.kingnod.etraining.security.entity.Owner;
/**
 * 数据权限数据访问接口，提供对数据级的权限（非读取权限，读取权限有另外的接口和表进行管理）的管理
 * @author Sam
 *
 */
@com.kingnod.core.annotation.Generated("2012-03-26 13:47")
public interface EntityPermissionDAO {
	/**
	 * 为某条数据设置一个权限
	 * @param ep
	 */
	public void insert(EntityPermission ep);
	
	/**
	 * 更新某条数据权限
	 * @param ep
	 */
	public void update(EntityPermission ep);
	
	/**
	 * 删除某条数据权限
	 * @param ep
	 */
	public void delete(EntityPermission ep);
	
	/**
	 * 获取某条数据权限
	 * @param eo
	 * @param owner
	 * @return
	 */
	public EntityPermission get(EntityPermission permission);
	
	/**
	 * 授权
	 * @param list
	 */
	void perm(List<EntityPermission> list);
	
	/**
	 * 检查某个Owner是否拥有对某条数据的操作权限
	 * @param p 权限对象
	 * @return boolean
	 */
	boolean hasPermission(Owner owner, EntityAuthority ea,ObjectType objectType,Long[] ids);
	
	boolean hasPermission(Owner owner, EntityAuthority ea,ObjectType objectType, String entityTable, Long entityId);
	
	/**
	 * 根据entityId获取EntityPermission
	 * @param entityId
	 * @return List<EntityPermission>
	 */
	List<EntityPermission> getPermissionByEntityId(Long entityId);
	
	List<EntityPermission> findPermByCriteria(Criteria criteria);
	
	List<EntityPermission> findUserPermByCriteria(Criteria criteria);
}