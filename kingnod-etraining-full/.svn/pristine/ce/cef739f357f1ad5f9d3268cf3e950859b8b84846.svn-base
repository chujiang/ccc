package com.kingnod.etraining.security;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Map;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.exception.Exceptions;
import com.kingnod.core.util.ObjectUtils;
import com.kingnod.core.util.SecurityUtils;
import com.kingnod.core.util.collection.MapUtils;
import com.kingnod.core.util.web.EL;
import com.kingnod.etraining.security.annotation.Perm;
import com.kingnod.etraining.security.entity.EntityAuthority;
import com.kingnod.etraining.security.entity.Owner;
import com.kingnod.etraining.security.entity.UserAccount;

/**
 * 
 * 数据级权限控制拦截器
 * @author Sam
 *
 */
public class PermissionAdvice implements MethodBeforeAdvice {
	
	@Autowired
	private PermisssionService permissionService;
	
	public void before(Method method, Object[] args, Object target) throws Throwable {
		Perm perm = method.getAnnotation(Perm.class);
		if (perm != null) {
			Long[] ids = getEntityObjects(args,perm);
			Owner owner = getOwner();
			EntityAuthority ea = getEntityAuthority(perm.permValue());
			if (!permissionService.hasPermission(  owner, ea,perm.entityType(),ids)) {
				throw Exceptions.createAppException(SecurityConstant.PERMISSION_DENIED);
			}
		}
	}		 
	
	private EntityAuthority getEntityAuthority(int permissionValue) {
		EntityAuthority ea = new EntityAuthority();
		ea.setAuthorityValue(BigDecimal.valueOf( permissionValue));
		return ea;		
	}
 
	private Long[]  getEntityObjects(Object[] args,Perm perm) {
		Map root = MapUtils.mapByAarray("args",args);
		String idExpression = perm.entityId();
		EL el = new EL(root);
		Object entityId = el.executeExpression(idExpression);		
		if (entityId == null)
			throw Exceptions.createAppException(SecurityConstant.OBJECT_ID_IS_NULL_CAN_NOT_DO_PERMISSION);
		if (ObjectUtils.isArray(entityId)) {
			return (Long[]) entityId;
		} else {
			return new Long[] {Long.valueOf(ObjectUtils.toString(entityId))};
		}  
		 
	}
	
	private Owner getOwner() {
		UserAccount userAccount = SecurityUtils.getCurrentUser();
		Owner owner = new Owner();
		owner.setOwnerId(userAccount.getId().intValue());
		owner.setOwnerType(Owner.USER);
		return owner;
	}
	
	

	
}
