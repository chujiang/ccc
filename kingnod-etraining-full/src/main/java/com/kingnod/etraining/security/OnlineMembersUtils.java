package com.kingnod.etraining.security;

import java.util.Map;

import com.kingnod.core.util.collection.MapUtils;
import com.kingnod.core.util.web.WebContext;
import com.kingnod.core.util.web.WebContextHolder;

/**
 * 在线人数统计工具类
 * @author Sam
 *
 */
public class OnlineMembersUtils {
	public static final String ON_LINE_MEMBERS = "ON_LINE_MEMBERS";
	
	private synchronized static void set(String loginNameWithSiteName,Type type) {
		WebContext webContext = WebContextHolder.getWebContext();
		Map<String,String> members = getCurrentLoginMembers();
		switch(type) {
		case SAVE:
			members.put(loginNameWithSiteName, loginNameWithSiteName);break;
		case DELETE:
			members.remove(loginNameWithSiteName);
		}
		
		webContext.getServletContext().setAttribute(ON_LINE_MEMBERS, members); 
	}
	 
	public static void add(String loginNameWithSiteName) {
		set(loginNameWithSiteName,Type.SAVE);
	}
	
	public static void remove(String loginNameWithSiteName) {
		set(  loginNameWithSiteName,Type.DELETE);
	}
	
	public static Map<String,String> getCurrentLoginMembers() {
		WebContext webContext = WebContextHolder.getWebContext();
		Map<String,String> members = 
			(Map<String,String>) webContext.getServletContext().getAttribute(ON_LINE_MEMBERS);
		if (members == null)
			return MapUtils.newMap();
		return members;
	}
	
	public static Integer countCurrentLoginMembers() {
		return getCurrentLoginMembers().size();
	}
	
	private static enum Type {
		SAVE, DELETE;
	}
}
