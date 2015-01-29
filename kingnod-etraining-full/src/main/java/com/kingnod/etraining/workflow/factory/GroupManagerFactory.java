package com.kingnod.etraining.workflow.factory;

import org.activiti.engine.impl.interceptor.Session;
import org.activiti.engine.impl.interceptor.SessionFactory;

import com.kingnod.etraining.workflow.service.GroupManager;


/**
 * 自定义用户表
 * @author Administrator
 *
 */
public class GroupManagerFactory implements SessionFactory{

	public Class<?> getSessionType() {
		return GroupManager.class;
	}

	public Session openSession() {
		return new GroupManager();
	}

}
