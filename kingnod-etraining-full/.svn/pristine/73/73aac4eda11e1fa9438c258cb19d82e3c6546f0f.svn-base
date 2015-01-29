package com.kingnod.etraining.security.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.dao.MybatisDaoSupport;
import com.kingnod.core.util.collection.ListUtils;
import com.kingnod.core.util.collection.MapUtils;
import com.kingnod.etraining.common.ObjectType;
import com.kingnod.etraining.security.SecurityConstant;
import com.kingnod.etraining.security.entity.EntityAuthority;
import com.kingnod.etraining.security.entity.EntityPermission;
import com.kingnod.etraining.security.entity.Owner;
@org.springframework.stereotype.Repository

@com.kingnod.core.annotation.Generated("2012-03-26 13:47")
public  class EntityPermissionDAOImpl extends MybatisDaoSupport implements EntityPermissionDAO {
	
	/**
	 * 为某条数据设置一个权限
	 * @param ep
	 */
	public void insert(EntityPermission ep) {
		getSqlSession().insert("insertEntityPermission", ep);
		
	}

	/**
	 * 更新某条数据权限
	 * @param ep
	 */
	public void update(EntityPermission ep) {
		getSqlSession().update("updateEntityPermission", ep);
	}

	/**
	 * 删除某条数据权限
	 * @param ep
	 */
	public void delete(EntityPermission ep) {
		getSqlSession().delete("deleteEntityPermission", ep.getEntityId());
	}

	/**
	 * 获取某条数据权限
	 * @param entityPermission
	 * @return EntityPermission
	 */
	public EntityPermission get(EntityPermission entityPermission){
		Object obj = getSqlSession().selectOne("EntityPermission.getPermissionByOwner", entityPermission);
		if(obj instanceof EntityPermission){
			return (EntityPermission)obj;
		}
		return null;
	}
	
	/**
	 * 授权
	 * @param Owner
	 * @param val
	 */
	public void perm(List<EntityPermission> list){
		for (EntityPermission permission : list) {
			if(permission != null){
				Object obj = get(permission);//判断对象是否存在，如果存在就修改，否则就新建
				if(obj != null){
					getSqlSession().update("updatePermission", permission);
				}else{
					getSqlSession().insert("insertEntityPermission", permission);
				}
			}
		}
	}
	
	/**
	 *  检查某个Owner是否拥有对某条数据的操作权限
	 * @param p 权限对象
	 * @return boolean
	 */
	@SuppressWarnings("unchecked")
	public boolean hasPermission(Owner owner, EntityAuthority ea,ObjectType objectType,Long[] ids) {
		if(ids != null && owner != null && ea != null && objectType != null){ 
			Map params = MapUtils.mapByAarray("entityType",objectType.name(),
											  "entityIds",ListUtils.of(ids),
											  "ownerId",owner.getOwnerId(),
											  "ownerType",owner.getOwnerType(),
											  "permValue",ea.getAuthorityValue());
			List<EntityPermission> list = getSqlSession().selectList("selectPermissionByOwner",params);
			return ListUtils.isNotEmpty(list);
		}
		return false;
	}
	
	@SuppressWarnings("rawtypes")
	public boolean hasPermission(Owner owner, EntityAuthority ea,ObjectType objectType, String entityTable, Long entityId) {
		if(entityId != null && owner != null && ea != null && objectType != null){ 
			Map params = MapUtils.mapByAarray("entityType",objectType.name(),
											  "entityId", entityId,
											  "entityTable", entityTable,
											  "ownerId",owner.getOwnerId(),
											  "ownerType",owner.getOwnerType(),
											  "permValue",ea.getAuthorityValue(),
											  "commonPermTotalValue", SecurityConstant.COMM_PERM_TOTAL);
			List<EntityPermission> list = getSqlSession().selectList("selectOnePermissionByOwner",params);
			return ListUtils.isNotEmpty(list);
		}
		return false;
	}
	
	/**
	 * 判断当前对象是否有该权限
	 * @param permission
	 * @param ea
	 * @return boolean
	 */
	public boolean validatePermissionAuthority(EntityPermission permission,EntityAuthority ea){
		EntityPermission ePermission = get(permission);
		if(ePermission != null){
			Long pIntValue = ePermission.getPermissionValue().longValue();
			Long aIntValue = ea.getAuthorityValue().longValue();
			if((pIntValue&aIntValue) > 0){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 根据entityId获取EntityPermission
	 * @param entityId
	 * @return List<EntityPermission>
	 */
	@SuppressWarnings("unchecked")
	public List<EntityPermission> getPermissionByEntityId(Long entityId){
		List<EntityPermission> list = new ArrayList<EntityPermission>();
		if(entityId != null){
			list = getSqlSession().selectList("getPermissionByEntityId", entityId);
		}
		return list;
	}
	
	/**
	 * 根据criteria查询数据的操作权限
	 * @param criteria
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<EntityPermission> findPermByCriteria(Criteria criteria) {
		return getSqlSession().selectList("findPermByCriteria", criteria);
	}
	
	@SuppressWarnings("unchecked")
	public List<EntityPermission> findUserPermByCriteria(Criteria criteria) {
		return getSqlSession().selectList("findUserPermByCriteria", criteria);
	}
}