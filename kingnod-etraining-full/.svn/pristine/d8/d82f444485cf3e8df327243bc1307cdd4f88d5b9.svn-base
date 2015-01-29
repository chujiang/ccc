/**
 * 
 */
package com.kingnod.etraining.security;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.extensions.spring.web.WebListenerBean;
import com.kingnod.etraining.security.entity.BitMapping;

/**
 * BitMapping数据初始化
 * 
 * @author liuxiaobin
 *
 */
public class BitMappingInitBean implements WebListenerBean {

	@Autowired
	private PermisssionService permissionService;
	
	public void init(ServletContext servletContext) {
		List<BitMapping> list = permissionService.getAllBitMapping();
		Map<Long, BitMapping> userGroupMapping = new HashMap<Long, BitMapping>();
		Map<Long, BitMapping> userRoleMapping = new HashMap<Long, BitMapping>();
		for(BitMapping bitMapping:list){
			if(BitMapping.USER_GROUP.equals(bitMapping.getMappingType())){
				userGroupMapping.put(bitMapping.getObjectId(), bitMapping);
			}else if(BitMapping.USER_ROLE.equals(bitMapping.getMappingType())){
				userRoleMapping.put(bitMapping.getObjectId(), bitMapping);
			}
		}
		servletContext.setAttribute(SecurityConstant.BIT_MAPPING + "_" + BitMapping.USER_GROUP, userGroupMapping);
		servletContext.setAttribute(SecurityConstant.BIT_MAPPING + "_" + BitMapping.USER_ROLE, userRoleMapping);
	}

	public void destory(ServletContext servletContext) {
		servletContext.removeAttribute(SecurityConstant.BIT_MAPPING + "_" + BitMapping.USER_GROUP);
		servletContext.removeAttribute(SecurityConstant.BIT_MAPPING + "_" + BitMapping.USER_ROLE);
	}
}
