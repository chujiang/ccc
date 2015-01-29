package com.kingnod.etraining.security.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.xwork.StringUtils;

import com.kingnod.core.util.collection.ListUtils;
import com.kingnod.etraining.security.ResourceDetailsService;
import com.kingnod.etraining.security.dao.SecurityDAO;
import com.kingnod.etraining.security.entity.UrlAuthority;
/**
 * 安全模块资源-授权定义的服务实现类
 * @author Sam
 *
 */
public class ResourceDetailsServiceImpl implements ResourceDetailsService {
	
	private SecurityDAO securityDAO;

	public Map<String, Collection<String>> getRequestMap() throws Exception {
		Collection<UrlAuthority> allUrlAuthorities = securityDAO.findAllUrlAuthority();
		Map<String, Collection<String>> urlAuthMap = new HashMap<String, Collection<String>>();
		if (CollectionUtils.isNotEmpty(allUrlAuthorities)) {
			for (UrlAuthority ua : allUrlAuthorities) {
				addToSecurityMetadata(urlAuthMap,ua);
			}
		}
		return urlAuthMap;
	}
	
	private void addToSecurityMetadata(Map<String, Collection<String>> urlAuthMap,UrlAuthority ua) {
		if ( urlAuthorityIsValid(ua) ) {
			if (ua.getUrl().contains(",")) {
				String[] urls = ua.getUrl().split(",");
				for (String url:urls) {
					urlAuthMap.put(url, ListUtils.of(ua.getAhthority()));
				}
			} else {
				urlAuthMap.put(ua.getUrl(), ListUtils.of(ua.getAhthority()));
			}
		}
	}
	
	private boolean urlAuthorityIsValid(UrlAuthority ua) {
		return ua != null && StringUtils.isNotBlank(ua.getAhthority()) && StringUtils.isNotBlank(ua.getUrl());
	}

	public void setSecurityDAO(SecurityDAO securityDAO) {
		this.securityDAO = securityDAO;
	}

	public SecurityDAO getSecurityDAO() {
		return securityDAO;
	}

}
