package com.kingnod.etraining.security;

import javax.servlet.http.HttpSessionEvent;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.session.HttpSessionEventPublisher;

import com.kingnod.etraining.security.entity.UserAccount;

/**
 * 在线人数登记
 * @author Sam
 *
 */
public class OnlineMembersHttpSessionEventPublisher extends HttpSessionEventPublisher {
 
	public void sessionDestroyed(HttpSessionEvent event) {
		// 将用户从在线用户列表中移除		
		super.sessionDestroyed(event);
		deleteOnlineUser(event );
	}

	public void deleteOnlineUser(HttpSessionEvent event ) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			Object principal = auth.getPrincipal();
			if (principal instanceof UserAccount) { 
				UserAccount ua = (UserAccount)principal;
				String loginNameWithSiteName = String.format("%s_%s", ua.getSiteName(),ua.getUsername());
				OnlineMembersUtils.remove(loginNameWithSiteName);
			}
		}
	}

 
}
