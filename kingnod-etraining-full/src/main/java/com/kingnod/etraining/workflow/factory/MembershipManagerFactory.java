package com.kingnod.etraining.workflow.factory;

import org.activiti.engine.impl.interceptor.Session;
import org.activiti.engine.impl.interceptor.SessionFactory;

import com.kingnod.etraining.workflow.service.MembershipManager;

public class MembershipManagerFactory implements SessionFactory{

	public Class<?> getSessionType() {
		return MembershipManager.class;
	}

	public Session openSession() {
		return new MembershipManager();
	}

}
