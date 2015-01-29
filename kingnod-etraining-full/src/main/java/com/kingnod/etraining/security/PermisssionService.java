package com.kingnod.etraining.security;

import java.util.List;
import java.util.Map;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.etraining.common.ObjectType;
import com.kingnod.etraining.security.entity.BitMapping;
import com.kingnod.etraining.security.entity.EntityAuthority;
import com.kingnod.etraining.security.entity.EntityObject;
import com.kingnod.etraining.security.entity.EntityPermission;
import com.kingnod.etraining.security.entity.EntityReadPermission;
import com.kingnod.etraining.security.entity.Owner;
import com.kingnod.etraining.security.entity.Permission;
import com.kingnod.etraining.security.entity.UserAccount;

/**
 * 授权服务接口
 * @author Sam
 *
 */
public interface PermisssionService {
	/**
	 * 授权，针对某条数据进行授权
	 * @param permList
	 */
	void perm(Permission...permList);
		 
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
	
	boolean hasPermission(Owner owner, EntityAuthority ea,ObjectType objectType,Long entityId);
	
	/**
	 * findAuthorityByType
	 * @param type
	 * @return List<EntityAuthority>
	 */
	List<EntityAuthority> findAuthorityByType(String type);
	
	/**
	 * 根据指定的类型获取没有使用的记录
	 */
	public BitMapping getNotUsedBitMapping(String mappingType);
	
	/**
	 * 初始化BitMapping
	 * @return List<BitMapping>
	 */
	List<BitMapping> getAllBitMapping();
	
	/**
	 * 存储一条读权限的映射记录
	 * @param bitMapping
	 */
	BitMapping saveBitMapping(String mappingType, Long objectId);
	
	void resetBitMapping(String mappingType, Long objectId);
	
	BitMapping getBitMapping(String mappingType, Long objectId);
	
	/**
	 * 获取权限拥有者的BitMapping int values
	 */
	public Integer[] getBitMappingIntValues(String ownerType, Long... ownerIds);
	
	/**
	 * 获取指定用户，指定类型的BitMapping int values
	 */
	public Integer[] getBitMappingIntValues(Long userId, String ownerType);
	
	/**
	 * 获取当前session用户，指定类型的BitMapping int values
	 */
	public Integer[] getBitMappingIntValues(String ownerType);
	
	/**
	 * 增加当前session用户的权限过滤条件
	 */
	public void addPermissionParams(Criteria criteria, ObjectType... entityTypes);
	
	/**
	 * 查询只读权限
	 * @param readPermission
	 * @return EntityReadPermission
	 */
	Long getEntityReadPermission(Map<String,Object> map);
	
	/**
	 * 保存读权限
	 * @param map
	 */
	void saveReadAthority(EntityObject entityObj, String ownerType, Long... readOwnerIds);
	
	/**
	 * 清除读取权限
	 * @param entityObj
	 * @return
	 */
	int removeReadAthority(EntityObject entityObj);
	
	/**
	 * 根据entityId获取EntityPermission
	 * @param entityId
	 * @return
	 */
	List<EntityPermission> getPermissionByEntityId(Long entityId);
	
	EntityReadPermission getReadPermissionByEntityId(EntityObject entityObj);
	
	void saveReadPermission(EntityReadPermission readPermission);
	
	
	/**
	 * 获取当前用户拥有某个实体的所有权限值
	 * @param entityId
	 * @param objectType
	 * @return
	 */
	public long getAllEntityPermissionValueByCurrentUser(Long entityId, String objectType);
	
	/**
	 * 获取当前用户拥有某个实体的所有权限
	 * @param entityId
	 * @param objectType
	 * @return
	 */
	public List<EntityPermission> getEntityPermissionByCurrentUser(Long entityId, String objectType);
	
	/**
	 * 获取用户的实体所有权限
	 * @param entityId
	 * @param objectType
	 * @param userId
	 * @return
	 */
	public List<EntityPermission> getEntityPermissionByUser(Long entityId, String objectType, Long userId);
	
	
	/**
	 * 获取用户的实体所有权限 
	 * @param entityId
	 * @param objectType
	 * @param user
	 * @return
	 */
	public List<EntityPermission> getEntityPermissionByUser(Long entityId, String objectType, UserAccount user);
	
	/**
	 * 获取用户组的实体所有权限
	 * @param entityId
	 * @param objectType
	 * @param groupId
	 * @return
	 */
	public List<EntityPermission> getEntityPermissionByUserGroup(Long entityId, String objectType, Long groupId);
}
