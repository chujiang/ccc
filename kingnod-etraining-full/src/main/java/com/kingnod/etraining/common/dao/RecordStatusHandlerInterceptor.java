package com.kingnod.etraining.common.dao;

import org.apache.ibatis.plugin.Invocation;

public class RecordStatusHandlerInterceptor extends	com.kingnod.core.extensions.mybatis.interceptor.RecordStatusHandlerInterceptor {

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		return super.intercept(invocation);
	}
	
}
