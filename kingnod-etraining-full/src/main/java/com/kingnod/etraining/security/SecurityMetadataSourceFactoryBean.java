/**
 * 修改历史：<br/>
 * =================================================================<br/>
 * 修改人 修改时间 修改原因/内容<br/>
 * =================================================================<br/>
 * Sam 20100111 增加修改历史注释<br/>
 * Sam 20120312 修改生成DefaultFilterInvocationDefinitionSource为FilterInvocationSecurityMetadataSource， DefaultFilterInvocationDefinitionSource已不建议被使用了
 * 
 */

package com.kingnod.etraining.security;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.access.intercept.DefaultFilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.access.intercept.RequestKey;
import org.springframework.security.web.util.AntUrlPathMatcher;
import org.springframework.security.web.util.UrlMatcher;

import com.kingnod.core.util.collection.CollectionUtils;
import com.kingnod.core.util.collection.ListUtils;

/**
 * SecurityMetadataSource工厂Bean.
 * 
 * 由注入的resourceDetailService读取在数据库或其它地方中定义的URL-授权关系, 提供Map<String, String>形式的URL及授权关系定义，
 * 并最终转为SpringSecurity所需的Map<RequestKey,Collection<ConfigAttribute>>形式的定义.
 * 
 * @see org.springframework.security.web.access.intercept.DefaultFilterInvocationSecurityMetadataSource
 * @see com.kingnod.etraining.security.ResourceDetailsService
 * 
 * @author calvin
 * @author Sam
 */
public class SecurityMetadataSourceFactoryBean implements FactoryBean<FilterInvocationSecurityMetadataSource> {
    
    private ResourceDetailsService resourceDetailsService;
    private UrlMatcher urlMatcher = new AntUrlPathMatcher();
    private List<String> defaultSecurityAttributes = ListUtils.newList();
    
    public void setResourceDetailsService(ResourceDetailsService resourceDetailsService) {
        this.resourceDetailsService = resourceDetailsService;
    }
    
    /**
     * 返回注入了Ant
     * Style的URLMatcher和ResourceDetailService提供的RequestMap的DefaultFilterInvocationDefinitionSource.
     */
    public FilterInvocationSecurityMetadataSource getObject() throws Exception {

        LinkedHashMap<RequestKey, Collection<ConfigAttribute>> requestMap = buildRequestMap();
        UrlMatcher matcher = getUrlMatcher();
        DefaultFilterInvocationSecurityMetadataSource securityMetadataSource =  
        	new DefaultFilterInvocationSecurityMetadataSource( matcher, requestMap);
        return securityMetadataSource;
    }
    
    /**
     * @see FactoryBean#getObjectType()
     */
    public Class<FilterInvocationSecurityMetadataSource> getObjectType() {
        return FilterInvocationSecurityMetadataSource.class;
    }
    
    /**
     * @see FactoryBean#isSingleton()
     */
    public boolean isSingleton() {
        return true;
    }
    
    /**
     * 默认提供Ant Style的URLMatcher.
     */
    protected UrlMatcher getUrlMatcher() {
        return urlMatcher;
    }
    
    /**
     * 将resourceDetailService提供LinkedHashMap<String, String>形式的URL及授权关系定义
     * 转化为DefaultFilterInvocationDefinitionSource需要的LinkedHashMap<RequestKey,
     * ConfigAttributeDefinition>形式.
     */
    protected LinkedHashMap<RequestKey, Collection<ConfigAttribute>> buildRequestMap()
        throws Exception {// NOSONAR
    
        Map<String, Collection<String>> srcMap = resourceDetailsService.getRequestMap();
        LinkedHashMap<RequestKey, Collection<ConfigAttribute>> distMap = new LinkedHashMap<RequestKey, Collection<ConfigAttribute>>();
        
        //从数据库读取的资源-权限
        for (Map.Entry<String, Collection<String>> entry : srcMap.entrySet()) {
            RequestKey key = new RequestKey(entry.getKey(), null);
            if (CollectionUtils.isNotEmpty(entry.getValue())) { 
                distMap.put(key, SecurityConfig.createList(CollectionUtils.toArray(entry.getValue())));
            }  
        }
        
        //加入默认的权限，必须用户登录才可以访问这些资源
        if (CollectionUtils.isNotEmpty(defaultSecurityAttributes)) { 
        	Collection<ConfigAttribute> userLogined = SecurityConfig.createList("M_USER_LOGINED");
        	for (String attr : defaultSecurityAttributes) {
        		distMap.put(new RequestKey(attr,null), userLogined);
        	}        	
        }
        
        
        
        return distMap;
    }
    
    

	public void setUrlMatcher(UrlMatcher urlMatcher) {
		this.urlMatcher = urlMatcher;
	}

	public List<String> getDefaultSecurityAttributes() {
		return defaultSecurityAttributes;
	}

	public void setDefaultSecurityAttributes(List<String> defaultSecurityAttributes) {
		this.defaultSecurityAttributes = defaultSecurityAttributes;
	}

 
}
