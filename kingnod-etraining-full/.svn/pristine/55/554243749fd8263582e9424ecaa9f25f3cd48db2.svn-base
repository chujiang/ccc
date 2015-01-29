/**
 * 
 */
package com.kingnod.etraining.security.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.xwork.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.criteria.Logic;
import com.kingnod.core.util.SecurityUtils;
import com.kingnod.core.util.collection.ListUtils;
import com.kingnod.core.util.web.WebContext;
import com.kingnod.core.util.web.WebContextHolder;
import com.kingnod.etraining.common.CommonConstant;
import com.kingnod.etraining.common.ObjectType;
import com.kingnod.etraining.common.entity.Role;
import com.kingnod.etraining.organization.entity.UserGroup;
import com.kingnod.etraining.security.PermisssionService;
import com.kingnod.etraining.security.SecurityConstant;
import com.kingnod.etraining.security.dao.BitMappingDAO;
import com.kingnod.etraining.security.dao.EntityAuthorityDAO;
import com.kingnod.etraining.security.dao.EntityPermissionDAO;
import com.kingnod.etraining.security.dao.EntityReadPermissionDAO;
import com.kingnod.etraining.security.entity.BitMapping;
import com.kingnod.etraining.security.entity.EntityAuthority;
import com.kingnod.etraining.security.entity.EntityObject;
import com.kingnod.etraining.security.entity.EntityPermission;
import com.kingnod.etraining.security.entity.EntityReadPermission;
import com.kingnod.etraining.security.entity.Owner;
import com.kingnod.etraining.security.entity.Permission;
import com.kingnod.etraining.security.entity.UserAccount;

/**
 * PermisssionServiceImpl
 * 
 * @author liuxiaobin
 *
 */
@org.springframework.stereotype.Service
public class PermisssionServiceImpl implements PermisssionService {
	
	private static Map<String, String> ENTITY_TABLE_MAPPING = new HashMap<String, String>();
	
	static {
		ENTITY_TABLE_MAPPING.put(ObjectType.O_OS.name(), "ORG_ORGANIZATION");
		ENTITY_TABLE_MAPPING.put(ObjectType.O_OO.name(), "ORG_ORGANIZATION");
		
		ENTITY_TABLE_MAPPING.put(ObjectType.R_OS.name(), "RES_FOLDER");
		ENTITY_TABLE_MAPPING.put(ObjectType.R_CF.name(), "RES_FOLDER");
		ENTITY_TABLE_MAPPING.put(ObjectType.R_FF.name(), "RES_FOLDER");
		ENTITY_TABLE_MAPPING.put(ObjectType.R_PF.name(), "RES_FOLDER");
		ENTITY_TABLE_MAPPING.put(ObjectType.R_SF.name(), "RES_FOLDER");
		ENTITY_TABLE_MAPPING.put(ObjectType.R_ZF.name(), "RES_FOLDER");
		ENTITY_TABLE_MAPPING.put(ObjectType.R_QF.name(), "RES_FOLDER");
		
		ENTITY_TABLE_MAPPING.put(ObjectType.A_OS.name(), "ATY_FOLDER");
		ENTITY_TABLE_MAPPING.put(ObjectType.A_EF.name(), "ATY_FOLDER");
		ENTITY_TABLE_MAPPING.put(ObjectType.A_FF.name(), "ATY_FOLDER");
		ENTITY_TABLE_MAPPING.put(ObjectType.A_PF.name(), "ATY_FOLDER");
		ENTITY_TABLE_MAPPING.put(ObjectType.A_XF.name(), "ATY_FOLDER");
		
		ENTITY_TABLE_MAPPING.put(ObjectType.P_OS.name(), "RPT_FOLDER");
		ENTITY_TABLE_MAPPING.put(ObjectType.P_FF.name(), "RPT_FOLDER");
		ENTITY_TABLE_MAPPING.put(ObjectType.P_AF.name(), "RPT_FOLDER");
		ENTITY_TABLE_MAPPING.put(ObjectType.P_BF.name(), "RPT_FOLDER");
		ENTITY_TABLE_MAPPING.put(ObjectType.P_CF.name(), "RPT_FOLDER");
		ENTITY_TABLE_MAPPING.put(ObjectType.P_DF.name(), "RPT_FOLDER");
		
	}
	
	@Autowired
	private EntityAuthorityDAO entityAuthorityDAO;
	
	@Autowired
	private EntityPermissionDAO entityPermissionDAO;
	
	@Autowired
	private BitMappingDAO bitMappingDAO;
	
	@Autowired
	private EntityReadPermissionDAO readPermissionDAO;
	
	public void setEntityPermissionDAO(EntityPermissionDAO entityPermissionDAO) {
		this.entityPermissionDAO = entityPermissionDAO;
	}

	public void setEntityAuthorityDAO(EntityAuthorityDAO entityAuthorityDAO) {
		this.entityAuthorityDAO = entityAuthorityDAO;
	}

	/**
	 * 授权
	 */
	public void perm(Permission... permList) {
		
	}
	
	//---------------- 权限实体表  -------------------------------------------------------
	/**
	 * 根据站点Id获取角色
	 */
	public List<EntityAuthority> findAuthorityByType(String type){
		return entityAuthorityDAO.findAuthorityByType(type);
	}

	/**
	 * 授权
	 * @param list
	 */
	public void perm(List<EntityPermission> list){
		entityPermissionDAO.perm(list);
	}
	
	/**
	 * 判断是否拥有权限
	 */
	public boolean hasPermission(Owner owner, EntityAuthority ea,ObjectType objectType,Long[] ids) {
		return entityPermissionDAO.hasPermission( owner, ea,objectType,ids);
	}
	
	public boolean hasPermission(Owner owner, EntityAuthority ea, ObjectType objectType, Long entityId) {
		return entityPermissionDAO.hasPermission( owner, ea, objectType, ENTITY_TABLE_MAPPING.get(objectType.name()), entityId);
	}
	
	/**
	 * 根据entityId获取EntityPermission
	 * @param entityId
	 * @return
	 */
	public List<EntityPermission> getPermissionByEntityId(Long entityId){
		return entityPermissionDAO.getPermissionByEntityId(entityId);
	}
	
	//---------------- 读权限映射表  -------------------------------------------------------
	/**
	 * 初始化BitMapping
	 */
	public List<BitMapping> getAllBitMapping() {
		return bitMappingDAO.getAllBitMapping();
	}
	
	/**
	 * 存储一条读权限的映射记录
	 * @param bitMapping
	 */
	public BitMapping saveBitMapping(String mappingType, Long objectId){
		BitMapping bitMapping = bitMappingDAO.getNotUsedBitMapping(mappingType);
        bitMapping.setObjectId(objectId);
		bitMappingDAO.saveBitMapping(bitMapping);
		WebContext webContext = WebContextHolder.getWebContext();
		Map<Long, BitMapping> bitMappingMap = (Map<Long, BitMapping>)webContext.getServletContext().getAttribute(SecurityConstant.BIT_MAPPING + "_" + mappingType);
		bitMappingMap.put(bitMapping.getObjectId(), bitMapping);
		return bitMapping;
	}
	
	public void resetBitMapping(String mappingType, Long objectId){
		WebContext webContext = WebContextHolder.getWebContext();
		Map<Long, BitMapping> bitMappingMap = (Map<Long, BitMapping>)webContext.getServletContext().getAttribute(SecurityConstant.BIT_MAPPING + "_" + mappingType);
		BitMapping bitMapping = bitMappingMap.get(objectId);
		if(null != bitMapping){
			bitMapping.setObjectId(null);
			bitMappingDAO.saveBitMapping(bitMapping);
			bitMappingMap.remove(objectId);
		}
	}
	
	
	
	public BitMapping getBitMapping(String mappingType, Long objectId){
		WebContext webContext = WebContextHolder.getWebContext();
		Map<Long, BitMapping> bitMappingMap = (Map<Long, BitMapping>)webContext.getServletContext().getAttribute(SecurityConstant.BIT_MAPPING + "_" + mappingType);
		return bitMappingMap.get(objectId);
	}
	
	/**
	 * 获取权限拥有者的BitMapping int values
	 */
	public Integer[] getBitMappingIntValues(String ownerType, Long... ownerIds){
		if(null == ownerIds){
			return null;
		}
		Integer[] ownerIdsIntValue = new Integer[10];
		for(int i = 0; i < 10; i ++){
			ownerIdsIntValue[i] = new Integer(0);
		}
		for(Long ownerId:ownerIds){
			BitMapping bitMapping = getBitMapping(ownerType, ownerId);
			if(null != bitMapping){
				ownerIdsIntValue[bitMapping.getSerialNumber()] = ownerIdsIntValue[bitMapping.getSerialNumber()] | bitMapping.getIntValue();
			}
		}
		return ownerIdsIntValue;
	}
	
	public Integer[] getBitMappingIntValues(Long userId, String ownerType) {
		Integer[] ownerIdsIntValue = new Integer[10];
		for(int i = 0; i < 10; i ++){
			ownerIdsIntValue[i] = new Integer(0);
		}
		UserAccount userDetails = SecurityUtils.getCurrentUser();
		if(BitMapping.USER_GROUP.equals(ownerType)){
			for(UserGroup userGroup:userDetails.getGroups()){
				BitMapping bitMapping = getBitMapping(BitMapping.USER_GROUP, userGroup.getId());
				ownerIdsIntValue[bitMapping.getSerialNumber()] = ownerIdsIntValue[bitMapping.getSerialNumber()] | bitMapping.getIntValue();
			}
		}else if(BitMapping.USER_ROLE.equals(ownerType)){
			for(Role userRole:userDetails.getRoles()){
				BitMapping bitMapping = getBitMapping(BitMapping.USER_ROLE, userRole.getId());
				ownerIdsIntValue[bitMapping.getSerialNumber()] = ownerIdsIntValue[bitMapping.getSerialNumber()] | bitMapping.getIntValue();
			}
		}
		return ownerIdsIntValue;
	}
	
	public Integer[] getBitMappingIntValues(String ownerType) {
		UserAccount userDetails = SecurityUtils.getCurrentUser();
		if(BitMapping.USER_GROUP.equals(ownerType) && userDetails.getGroups().size() == 0){
			return null;
		}else if(BitMapping.USER_ROLE.equals(ownerType) && userDetails.getRoles().size() == 0){
			return null;
		}
		Integer[] ownerIdsIntValue = new Integer[10];
		for(int i = 0; i < 10; i ++){
			ownerIdsIntValue[i] = new Integer(0);
		}
		
		if(BitMapping.USER_GROUP.equals(ownerType)){
			for(UserGroup userGroup:userDetails.getGroups()){
				BitMapping bitMapping = getBitMapping(BitMapping.USER_GROUP, userGroup.getId());
				ownerIdsIntValue[bitMapping.getSerialNumber()] = ownerIdsIntValue[bitMapping.getSerialNumber()] | bitMapping.getIntValue();
			}
			return ownerIdsIntValue;
		}else if(BitMapping.USER_ROLE.equals(ownerType)){
			for(Role userRole:userDetails.getRoles()){
				BitMapping bitMapping = getBitMapping(BitMapping.USER_ROLE, userRole.getId());
				ownerIdsIntValue[bitMapping.getSerialNumber()] = ownerIdsIntValue[bitMapping.getSerialNumber()] | bitMapping.getIntValue();
			}
			return ownerIdsIntValue;
		}
		return null;
	}
	
	public void addPermissionParams(Criteria criteria, ObjectType... entityTypes) {
		/* Sample:
		 * (B.OWNER_TYPE = 'G' AND (BITAND(B.OWNER_0, 3) > 0 OR BITAND(B.OWNER_1, 1) > 0)) 
	     * OR (B.OWNER_TYPE = 'R' AND (BITAND(B.OWNER_0, 3) > 0 OR BITAND(B.OWNER_1, 1) > 0)) 
	     * OR (B.OWNER_TYPE = 'U' AND B.USER_ID = 1)
	     */
		UserAccount userDetails = SecurityUtils.getCurrentUser();
		Integer[] userGroupIntValues = getBitMappingIntValues(BitMapping.USER_GROUP);
		Integer[] userRoleIntValues = getBitMappingIntValues(BitMapping.USER_ROLE);
		
		if(null != userGroupIntValues){
			CriteriaBuilder groupPermCb = Cnd.builder();
			CriteriaBuilder groupGroupPermCb = Cnd.builder();
			for(int i = 0; i < userGroupIntValues.length; i ++){
				if(!userGroupIntValues[i].equals(new Integer(0))){
					groupGroupPermCb.orBitEQ("Z.OWNER_" + String.valueOf(i), userGroupIntValues[i]);
				}
			}
			groupPermCb.andEQ("Z.OWNER_TYPE", BitMapping.USER_GROUP).andGroup(groupGroupPermCb);
			criteria.addParam("groupPermission", groupPermCb.buildCriteria());
		}
		
		if(null != userRoleIntValues){
			CriteriaBuilder rolePermCb = Cnd.builder();
			CriteriaBuilder roleGroupPermCb = Cnd.builder();
			for(int i = 0; i < userRoleIntValues.length; i ++){
				if(!userRoleIntValues[i].equals(new Integer(0))){
					roleGroupPermCb.orBitEQ("Z.OWNER_" + String.valueOf(i), userRoleIntValues[i]);
				}
			}
			rolePermCb.andEQ("Z.OWNER_TYPE", BitMapping.USER_ROLE).andGroup(roleGroupPermCb);
			criteria.addParam("rolePermission", rolePermCb.buildCriteria());
		}
		
		CriteriaBuilder userPermCb = Cnd.builder();
		userPermCb.andEQ("Z.OWNER_TYPE", "U").andEQ("Z.USER_ID", userDetails.getId());
		
		criteria.addParam("userPermission", userPermCb.buildCriteria());
		
		if(null != entityTypes && entityTypes.length > 0){
			CriteriaBuilder entityTypesCb = Cnd.builder();
			for(ObjectType objtype:entityTypes){
				if(objtype.name().charAt(2) == '_'){
					String entityType = objtype.name();
					entityType = objtype.name().substring(0, 2);
					entityType = entityType + "%";
					entityType = entityType + objtype.name().substring(3, objtype.name().length());
					entityTypesCb.add(Cnd.like(Logic.OR,"Z.ENTITY_TYPE", entityType));
				}else if(objtype.name().endsWith("_")){
					String entityType = objtype.name();
					entityType = objtype.name().substring(0, entityType.length() - 1);
					entityType = entityType + "%";
					entityTypesCb.add(Cnd.like(Logic.OR,"Z.ENTITY_TYPE", entityType));
				}else{
					entityTypesCb.orEQ("Z.ENTITY_TYPE", objtype.name());
				}
			}
			criteria.addParam("entityTypes", entityTypesCb.buildCriteria());
		}
	}
	
	/**
	 * 获取当前用户拥有某个实体的所有权限值，包括从父级对象继承下来的权限值
	 * 1. 如果父对象跟当前实体类型相同，
	 * @param entityId
	 * @param objectType
	 * @return
	 */
	public long getAllEntityPermissionValueByCurrentUser(Long entityId, String objectType) {
		List<EntityPermission> permissions = getEntityPermissionByCurrentUser(entityId, objectType);
		long permValue = 0L;
		for (EntityPermission perm : permissions) {
			if (StringUtils.equals(objectType, perm.getEntityType())) { // 如果类型相同，累计所有权限
				permValue |= perm.getPermissionValue().longValue();
			} else {  //如果类型不同，只累计 RWDA 公共的权限 R - 1, W - 2, D- 4, A - 8累加就是 15
				permValue |= perm.getPermissionValue().longValue() & SecurityConstant.COMM_PERM_TOTAL;
			}
		}
		return permValue;
	}
	
	/**
	 * 获取当前用户拥有某个实体的所有权限
	 * @param entityId
	 * @param objectType
	 * @return
	 */
	public List<EntityPermission> getEntityPermissionByCurrentUser(Long entityId, String objectType) {
		UserAccount user = SecurityUtils.getCurrentUser();
		return getEntityPermissionByUser(entityId, objectType, user);
	}
	
	public List<EntityPermission> getEntityPermissionByUser(Long entityId, String objectType, Long userId) {
		CriteriaBuilder  builder = Cnd.builder(EntityPermission.class);
		builder.addParam("entityId", entityId)
			   .addParam("entityType", objectType)
			   .addParam("entityTable", ENTITY_TABLE_MAPPING.get(objectType))
			   .addParam("ownerType", SecurityConstant.USER).addParam("ownerId", userId);
		return entityPermissionDAO.findUserPermByCriteria(builder.buildCriteria());
	}
	
	/**
	 * 获取指定用户拥有某个实体的所有权限，包括他所继承的，他所属用户组的。
	 * @param entityId
	 * @param objectType
	 * @param user
	 * @return
	 */
	public List<EntityPermission> getEntityPermissionByUser(Long entityId, String objectType, UserAccount user) {
		CriteriaBuilder  builder = Cnd.builder(EntityPermission.class);
		builder.addParam("entityId", entityId).addParam("entityType", objectType).addParam("entityTable", ENTITY_TABLE_MAPPING.get(objectType));
		
		CriteriaBuilder userCnd = Cnd.builder(EntityPermission.class);
		userCnd.andEQ("ownerType", SecurityConstant.USER).andEQ("ownerId", user.getId());//用户
		
		if (!ListUtils.isEmpty(user.getGroups())) {
			CriteriaBuilder groupCnd = Cnd.builder(EntityPermission.class).andEQ("ownerType", SecurityConstant.USER_GROUP); //用户组
			CriteriaBuilder groupCndGroups = Cnd.builder();
			for ( UserGroup userGroup : user.getGroups() ) { 
				groupCndGroups.orEQ("A.OWNER_ID", userGroup.getId());
			}
			groupCnd.andGroup(groupCndGroups);
			builder.addParam("groupPermission", groupCnd.buildCriteria());
		}
		
		builder.addParam("userPermission", userCnd.buildCriteria());
		return entityPermissionDAO.findPermByCriteria(builder.buildCriteria());
	}
	
	/**
	 * 获取指定用户组的实体权限
	 * @param entityId
	 * @param objectType
	 * @param group
	 * @return
	 */
	public List<EntityPermission> getEntityPermissionByUserGroup(Long entityId, String objectType, Long groupId) {
		CriteriaBuilder  builder = Cnd.builder(EntityPermission.class);
		builder.addParam("entityId", entityId).addParam("entityType", objectType).addParam("entityTable", ENTITY_TABLE_MAPPING.get(objectType));
		
		CriteriaBuilder groupCnd = Cnd.builder(EntityPermission.class).andEQ("ownerType", SecurityConstant.USER_GROUP); //用户组
		CriteriaBuilder groupCndGroups = Cnd.builder();
		groupCndGroups.andEQ("A.OWNER_ID", groupId);
		groupCnd.andGroup(groupCndGroups);
		
		builder.addParam("groupPermission", groupCnd.buildCriteria());
		return entityPermissionDAO.findPermByCriteria(builder.buildCriteria());
	}
	
	//---------------- 读权限实体表  -------------------------------------------------------
	/**
	 * 查询只读权限
	 * @param readPermission
	 * @return EntityReadPermission
	 */
	public Long getEntityReadPermission(Map<String,Object> map){
		return readPermissionDAO.getEntityReadPermission(map);
	}
	
	/**
	 * 保存读权限
	 * @param map
	 */
	public void saveReadAthority(EntityObject entityObj, String ownerType, Long... readOwnerIds){
		
		EntityReadPermission readPermission = new EntityReadPermission();
		readPermission.setEntityId(Long.valueOf(entityObj.getEntityId()));
		readPermission.setEntityType(entityObj.getEntityType());
		readPermission.setOwnerType(ownerType);
		
		CriteriaBuilder cb = Cnd.builder(EntityReadPermission.class);
		cb.andEQ("entityId", readPermission.getEntityId())
		.andEQ("entityType", readPermission.getEntityType())
		.andEQ("ownerType", readPermission.getOwnerType())
		.andNotEQ("userId", CommonConstant.ADMIN_USER_ID);
		readPermissionDAO.deleteByCriteria(cb.buildCriteria());
		
		
		if(BitMapping.USER_GROUP.equals(ownerType) || BitMapping.USER_ROLE.equals(ownerType)){
			Integer[] bitMappingIntValues = getBitMappingIntValues(ownerType, readOwnerIds);
			readPermission.setOwner0(bitMappingIntValues[0]);
			readPermission.setOwner1(bitMappingIntValues[1]);
			readPermission.setOwner2(bitMappingIntValues[2]);
			readPermission.setOwner3(bitMappingIntValues[3]);
			readPermission.setOwner4(bitMappingIntValues[4]);
			readPermission.setOwner5(bitMappingIntValues[5]);
			readPermission.setOwner6(bitMappingIntValues[6]);
			readPermission.setOwner7(bitMappingIntValues[7]);
			readPermission.setOwner8(bitMappingIntValues[8]);
			readPermission.setOwner9(bitMappingIntValues[9]);
			readPermissionDAO.insert(readPermission);
		}else{
			for(Long userId:readOwnerIds){
				readPermission.setUserId(userId);
				readPermissionDAO.insert(readPermission);
			}
		}
		
	}
	
	public int removeReadAthority(EntityObject entityObj){
		
		CriteriaBuilder cb = Cnd.builder(EntityReadPermission.class);
		cb.andEQ("entityId", entityObj.getEntityId())
		.andEQ("entityType", entityObj.getEntityType());
		return readPermissionDAO.deleteByCriteria(cb.buildCriteria());
		
	}

	/*
	 * (non-Javadoc)
	 * @see com.kingnod.etraining.security.PermisssionService#getNotUsedBitMapping(java.lang.String)
	 */
	public BitMapping getNotUsedBitMapping(String mappingType) {
		return bitMappingDAO.getNotUsedBitMapping(BitMapping.USER_GROUP);
	}
	
	/**
	 * 根据entityId获取ReadPermission
	 * @param entityObj
	 * @return EntityReadPermission
	 */
	public EntityReadPermission getReadPermissionByEntityId(EntityObject entityObj){
		return readPermissionDAO.getReadPermissionByEntityId(entityObj);
	}
	
	/**
	 * 保存ReadPermission
	 * @param readPermission
	 */
	public void saveReadPermission(EntityReadPermission readPermission){
		readPermissionDAO.saveReadPermission(readPermission);
	}
}
