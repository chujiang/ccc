package com.kingnod.etraining.security.action;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.stereotype.Controller;

import com.kingnod.core.exception.Exceptions;
import com.kingnod.core.extensions.struts2.action.ExtendedActionSupport;
import com.kingnod.core.extensions.struts2.annotation.ErrorMapping;
import com.kingnod.core.util.web.ServletUtils;
import com.kingnod.core.util.web.Struts2Utils;

/**
 * 自定义的SpringSecurity错误处理
 * @author Sam
 *
 */
@Namespace("/sec")
@Controller
@Results({ 
	@Result(name = "login", type = "redirectAction", params = { "actionName", "login", "namespace", "/" }) 
})
public class ErrorHandlerAction extends ExtendedActionSupport{
 
	private static final long serialVersionUID = -2566496696648402011L;
	
	public String execute() {		
		return ERROR;
	}
	
	@ErrorMapping(result="login")
	public String expired() {
		throw Exceptions.createAppException("sec002001"); 		
	}
	
	public String timeout() {
		if (ServletUtils.isJsonRequest(request)) {
			Struts2Utils.renderJson(String.format("{sessionTimeout:%s,loginPage:'%s'}",true,"/login.action"));
			return null;
		}
		return "login";
	}
}
