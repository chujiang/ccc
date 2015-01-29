package com.kingnod.etraining.security.dao;

import java.util.HashMap;
import java.util.Map;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.dao.MybatisDaoSupport;
import com.kingnod.etraining.security.entity.BitMapping;
import com.kingnod.etraining.security.entity.EntityObject;
import com.kingnod.etraining.security.entity.EntityReadPermission;
import com.kingnod.etraining.security.entity.Owner;

@org.springframework.stereotype.Repository
@com.kingnod.core.annotation.Generated("2012-03-26 21:04")
public class EntityReadPermissionDAOImpl extends MybatisDaoSupport implements EntityReadPermissionDAO {

	public void insert(EntityReadPermission entityReadPermission) {
		getSqlSession().insert("EntityReadPermission.insert", entityReadPermission);
	}

	public void update(EntityReadPermission erp) {
	}

	public void insertOrUpdate(EntityObject eo, Owner owner, BitMapping bm) {
	}

	/**
	 * 查询只读权限
	 * 
	 * @param readPermission
	 * @return EntityReadPermission
	 */
	public Long getEntityReadPermission(Map<String, Object> map) {
		return (Long) getSqlSession().selectOne("findReadAthorityObj", map);
	}

	/**
	 * 保存读权限
	 * 
	 * @param map
	 */
	public void saveReadAthority(Map<String, Object> map) {
		Long count = (Long) getSqlSession().selectOne("findReadAthority", map);
		if (count == 0) {
			getSqlSession().insert("saveReadAthority", map);
		}
		getSqlSession().update("updateReadAthority", map);
	}

	public int deleteByCriteria(Criteria criteria) {
		return getSqlSession().delete("EntityReadPermission.deleteByCriteria", criteria);
	}

	/**
	 * 根据entityId获取ReadPermission
	 * @param entityObj
	 * @return EntityReadPermission
	 */
	public EntityReadPermission getReadPermissionByEntityId(EntityObject entityObj){
		EntityReadPermission readPermission = null;
		if(entityObj != null){
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("entityId", entityObj.getEntityId());
			map.put("entityType", entityObj.getEntityType());
			readPermission = (EntityReadPermission)getSqlSession().selectOne("getReadPermissionByEntityId",map);
		}
		return readPermission;
	}
	
	/**
	 * 保存ReadPermission
	 * @param readPermission
	 */
	public void saveReadPermission(EntityReadPermission readPermission){
		if(readPermission != null){
			EntityObject eObject = new EntityObject();
			eObject.setEntityId(readPermission.getEntityId().intValue());
			eObject.setEntityType(readPermission.getEntityType());
			
			EntityReadPermission permission = getReadPermissionByEntityId(eObject);
			if(permission != null){
				getSqlSession().update("updateReadPermission",readPermission);
			}else{
				getSqlSession().insert("saveReadPermission",readPermission);
			}
		}
	}
}