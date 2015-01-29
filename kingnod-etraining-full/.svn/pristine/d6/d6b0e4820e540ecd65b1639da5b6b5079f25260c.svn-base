package com.kingnod.etraining.common.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.extensions.struts2.action.EntityAction;
import com.kingnod.core.util.SecurityUtils;
import com.kingnod.core.util.SysParameterUtils;
import com.kingnod.core.util.web.Struts2Utils;
import com.kingnod.etraining.organization.entity.Site;
import com.kingnod.etraining.organization.entity.User;
import com.kingnod.etraining.organization.service.SiteService;
import com.kingnod.etraining.organization.service.UserService;
import com.kingnod.etraining.security.entity.UserAccount;
import com.opensymphony.xwork2.ActionSupport;


@org.springframework.stereotype.Controller
@Namespace("/html")
@Results( 
{
@Result(name = EntityAction.RELOAD, type = "redirectAction", params = { "actionName", "html-test", "namespace", "/html"}),
@Result(name = "midBox", location="/WEB-INF/content/html/midbox.jsp"),
@Result(name = "topbar", location="/WEB-INF/content/html/topbar.jsp"),
@Result(name = "ipanel", location="/WEB-INF/content/html/ipanel.jsp"),
@Result(name = "categoryTree", location="/WEB-INF/content/crs/category-tree.jsp"),
@Result(name = "mind", location="/WEB-INF/content/html/mind.jsp"),
@Result(name = "home", location="/WEB-INF/content/html/home.jsp")
}
)
public class HtmlTestAction extends ActionSupport implements  ServletRequestAware, ServletResponseAware{
	
	/**
	 * HTTP服务端响应信息
	 */
	protected HttpServletResponse response;
	
	/**
	 * HTTP客户端请求信息
	 */
	protected HttpServletRequest request;
	
	@Autowired
	UserService userService;
	@Autowired
	SiteService siteService;
	
	private static int ii = 0;
	private String types;
	
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
		
	}
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
		
	}
	
	public String getTypes() {
		return types;
	}
	public void setTypes(String types) {
		this.types = types;
	}
	public String midBox(){
		System.out.println("midBox " +ii++);
		System.out.println("midBox " +types);
		return "midBox";
	}
	public String topbar(){
		return "topbar";
	}
	public String ipanel(){
		System.out.println("ipanel " +ii++);
		System.out.println("ipanel " +types);
		return "ipanel";
	}
	public String categoryTree()
	{
		System.out.println("categoryTree " +ii++);
		System.out.println("categoryTree " +types);
		return "categoryTree";
	}
	public String mind(){
		System.out.println("mind " +ii++);
		System.out.println("mind " +types);
		return "mind";
	}
	public String home(){
		return "home";
	}
	
	/**
	 * 学员登录管理员
	 */
	public String loginAdmin() {
		String url = SysParameterUtils.getString("sys.learner-web_url");
		if(url.indexOf("http:")<0){
			url=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/"+url;
		}
		UserAccount userAccount = (UserAccount) SecurityUtils.getCurrentUser();
		Map<String, String> map = new HashMap<String, String>();
		if (null != userAccount) {
			User user = userService.getUser(userAccount.getId());
			Site site = siteService.getSite(user.getSiteId());
				map.put("j_username", user.getLoginName());
				map.put("j_password", user.getPassword());
				map.put("siteName", site.getShortName());
				map.put("url", url);
		}

		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonRoot", map);
		return "jsonResult";
	}



}
