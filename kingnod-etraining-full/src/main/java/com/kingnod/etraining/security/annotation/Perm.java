package com.kingnod.etraining.security.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.kingnod.etraining.common.ObjectType;

/**
 * 数据权限控制元数据，根据此配置+AOP拦截器进行数据级权限控制。
 * @author Sam
 *
 */
@Retention(RetentionPolicy.RUNTIME )
@Target({ElementType.METHOD})
public @interface Perm {
	/**
	 * 对应要控制实体的ID属性值，以表达式方式从指定的参数对象取出来，如下：
	 * <pre>
	 * ${args[0].id}
	 * </pre>
	 * 其中的args代表传给服务类的参数,args[0]代表每一个参数地象的id属性。
	 * 目前支持的参数控制对象有[args|request|session|application|params]各个域
	 * @return
	 */
	String entityId();
	
	/**
	 * 对应的实体对象类型
	 * @see com.kingnod.etraining.common.ObjectType
	 * @return
	 */
	ObjectType entityType();
	
	/**
	 * 要操作此对象需要的权限值
	 * @return
	 */
	int permValue();
}
