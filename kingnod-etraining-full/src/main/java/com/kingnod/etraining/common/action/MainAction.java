package com.kingnod.etraining.common.action;

import com.opensymphony.xwork2.ActionSupport;

@org.apache.struts2.convention.annotation.Namespace("")
public class MainAction extends ActionSupport {

	public String getHomePageTimeFormat(){
//		return SysParameterUtils.getSystemParameter(SYS_PARAMETER_SYS_ADMIN_HOME_PAGE_TIME_FORMAT);
		return "yy年mm月dd日 W";
	}
	
}
