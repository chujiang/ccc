package com.kingnod.etraining.security.impl;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.kingnod.core.exception.Exceptions;
import com.kingnod.core.exception.WebApplicationException;
import com.kingnod.core.util.DateUtils;
import com.kingnod.core.util.web.HttpParameter;
import com.kingnod.core.util.web.WebContext;
import com.kingnod.core.util.web.WebContextHolder;
import com.kingnod.etraining.common.entity.Authority;
import com.kingnod.etraining.organization.entity.User;
import com.kingnod.etraining.security.OnlineMembersUtils;
import com.kingnod.etraining.security.SecurityConstant;
import com.kingnod.etraining.security.dao.SecurityDAO;
import com.kingnod.etraining.security.entity.UserAccount;
import com.kingnod.etraining.security.licensor.HardwareBinder;
import com.kingnod.etraining.security.licensor.License;

 
 
/**
 * 基于SpringSecurity的用户认证服务实现类
 * @author Sam
 *
 */
public class UserDetailsServiceImpl implements UserDetailsService {
	
	protected static Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
	 
	private SecurityDAO securityDAO;
	
	private String siteParameter = "sitename";
	
	private static final String clientScreenWidthParameter = "clientScreenWidth";
	
	private static final String clientScreenHeightParameter = "clientScreenHeight";
	
	/**
	 * 是否管理员平台,是的话则在管理员平台登录时要校验是否是管理员才可以进行访问后台管理系统。
	 */
	private boolean isAdminPlatform;
	
	/**
	 * 登录页面
	 */
	private String loginPage;
	
	private static License license = null;
	
	private byte[] digest = new byte[]{
	        (byte) 0x86, (byte) 0x1C, (byte) 0x2C, (byte) 0x13, (byte) 0x30,
	        (byte) 0x96, (byte) 0xD0, (byte) 0xBA, (byte) 0x90, (byte) 0x23,
	        (byte) 0x30, (byte) 0x69, (byte) 0x12, (byte) 0x3F, (byte) 0xAF,
	        (byte) 0x8F, (byte) 0xFD, (byte) 0xAE, (byte) 0x43, (byte) 0xBD,
	        (byte) 0xE1, (byte) 0x82, (byte) 0x73, (byte) 0x33, (byte) 0x0E,
	        (byte) 0x1A, (byte) 0x7A, (byte) 0x95, (byte) 0xF2, (byte) 0xE7,
	        (byte) 0xCF, (byte) 0x78
	    };
	
	public boolean checkLicense() throws WebApplicationException {
		try{
			if(null == license){
				license = new License();
				license.loadKeyRingFromResource("pubring.gpg", digest);
				license.setLicenseEncodedFromResource("com/kingnod/etraining/security/license.lic");
				logger.info("\nProduction License: ");
				logger.info(license.getLicenseString());
			}
			if(!license.isVerified()){
				throw Exceptions.createWebAppException("sec001006",loginPage,true);	
			}
			if(!"true".equals(license.getFeature("trial-version"))){
				HardwareBinder hb = new HardwareBinder();
				hb.setUseHwAddress();
				if(null == hb.getMachineId() || StringUtils.isEmpty(license.getFeature("network-card")) || !hb.getMachineId().toString().equals(license.getFeature("network-card"))){
					logger.error("Invalid network-card: " + license.getFeature("network-card"));
					logger.error("local network-card: " + hb.getMachineIdString());
					throw Exceptions.createWebAppException("sec001006",loginPage,true);	
				}
			}
			String validDateStr = license.getFeature("valid-date");
			if(StringUtils.isEmpty(validDateStr)){
				logger.error("Invalid valid-date: " + license.getFeature("valid-date"));
				throw Exceptions.createWebAppException("sec001006",loginPage,true);	
			}
			Date validDate = DateUtils.parse(validDateStr, "yyyy-MM-dd");
			if (new Date().after(validDate)) {
				logger.error("Invalid valid-date: " + license.getFeature("valid-date"));
				throw Exceptions.createWebAppException("sec001005",loginPage,true);	
			}
			return true;
		}catch(Exception e){
			logger.error(e.getMessage(), e);
			throw Exceptions.createWebAppException("sec001006",loginPage,true);	
		}
	}
	 
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException, DataAccessException {
		checkLicense();
		WebContext webContext = WebContextHolder.getWebContext();
		HttpParameter httpParameter = HttpParameter.create(webContext.getRequest());
		String sitename = StringUtils.isEmpty(httpParameter.getString(siteParameter)) ? (String) webContext.getRequest().getAttribute(siteParameter) : httpParameter.getString(siteParameter);
//		String clientScreenWidthValue = httpParameter.getString(clientScreenWidthParameter);
//		String clientScreenHeightValue = httpParameter.getString(clientScreenHeightParameter);		
		int clientScreenWidth = httpParameter.getInt(clientScreenWidthParameter, 1024);
		int clientScreenHeight = httpParameter.getInt(clientScreenHeightParameter,768);
		User user = securityDAO.findUserByUsername(sitename,userName,isAdminPlatform);
		 
		if (user == null)
			throw Exceptions.createWebAppException(SecurityConstant.USER_OR_PASSWORD_IS_NOT_VALID,loginPage,true);
		
		if ("L".equals(user.getStatus())) {
			throw Exceptions.createWebAppException(SecurityConstant.USER_IS_LOCKED,loginPage,true);
		}
		
		Collection<GrantedAuthority>  grantedAuths = obtainGrantedAuthorities(user);
		
		//只要用户成功登录就给予此权限
		grantedAuths.add(new GrantedAuthorityImpl("M_USER_LOGINED"));
		
		//设置到当前登录的所有用户列表
		if (webContext.getRequest().getAttribute(siteParameter) == null) {
			String loginNameWithSiteName = String.format("%s_%s", sitename,userName);
			OnlineMembersUtils.add(loginNameWithSiteName);
		}

		//设置帐号属性 --//		
		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;

		UserAccount account = new UserAccount( 
												user.getLoginName(), 
												user.getPassword(), 
												enabled, 
												accountNonExpired, 
												credentialsNonExpired,
												accountNonLocked, 
												grantedAuths);
		account.setSiteName(sitename);
		account.setSiteId(user.getSiteId());
		account.setEmail(user.getEmail()); 
		account.setId(user.getId()); 
		account.setFullName(user.getFullName());
		account.setAttribute("orgId", user.getOrganizationId());
		account.setRoles(securityDAO.findRoleByUser(user));
		account.setGroups(securityDAO.findGroupByUser(user));
		account.setClientScreenHeight(clientScreenHeight);
		account.setClientScreenWidth(clientScreenWidth);
		return account;
	}

	

	/**
	 * 获得用户所有角色的权限集合.
	 */
	private Collection<GrantedAuthority> obtainGrantedAuthorities(User user) {
		Collection<Authority> urlAuthorityList = securityDAO.findUrlAuthorityByUser(user);
		Set<GrantedAuthority> authSet = new HashSet<GrantedAuthority>();
		if (CollectionUtils.isNotEmpty(urlAuthorityList)) {
			for (Authority a : urlAuthorityList) 
				authSet.add(new GrantedAuthorityImpl(a.getCode()));
		}
		return authSet;
	}



	public SecurityDAO getSecurityDAO() {
		return securityDAO;
	}



	public void setSecurityDAO(SecurityDAO securityDAO) {
		this.securityDAO = securityDAO;
	}



	public String getSiteParameter() {
		return siteParameter;
	}



	public void setSiteParameter(String siteParameter) {
		this.siteParameter = siteParameter;
	}



	public void setAdminPlatform(boolean isAdminPlatform) {
		this.isAdminPlatform = isAdminPlatform;
	}



	public boolean isAdminPlatform() {
		return isAdminPlatform;
	}



	public String getLoginPage() {
		return loginPage;
	}



	public void setLoginPage(String loginPage) {
		this.loginPage = loginPage;
	}
 

}
