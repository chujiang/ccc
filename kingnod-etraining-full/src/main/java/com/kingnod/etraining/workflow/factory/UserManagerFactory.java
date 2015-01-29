package com.kingnod.etraining.workflow.factory;

import org.activiti.engine.impl.interceptor.Session;
import org.activiti.engine.impl.interceptor.SessionFactory;

import com.kingnod.etraining.workflow.service.UserManager;


/**
 * 自定义用户表
 * @author Administrator
 *
 */
public class UserManagerFactory implements SessionFactory{

	public Class<?> getSessionType() {
		return UserManager.class;
	}

	public Session openSession() {
		return new UserManager();
	}

}
