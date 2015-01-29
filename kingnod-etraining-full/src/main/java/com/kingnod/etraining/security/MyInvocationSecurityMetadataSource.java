package com.kingnod.etraining.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.AntUrlPathMatcher;
import org.springframework.security.web.util.UrlMatcher;

@Deprecated 
public class MyInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

  private UrlMatcher urlMatcher = new AntUrlPathMatcher();;
  private static Map<String, Collection<ConfigAttribute>> resourceMap = null;

  public MyInvocationSecurityMetadataSource() {
    loadResourceDefine();
  }

  private void loadResourceDefine() {
    resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
    Collection<ConfigAttribute> editUserAtts = new ArrayList<ConfigAttribute>();
    editUserAtts.add(new SecurityConfig("ROLE_USER"));
    resourceMap.put("/main.action", editUserAtts);
    resourceMap.put("/home.action", editUserAtts);
    resourceMap.put("/cmn/*", editUserAtts);
    resourceMap.put("/org/*", editUserAtts);
    resourceMap.put("/res/*", editUserAtts);
    resourceMap.put("/aty/*", editUserAtts);
    //resourceMap.put("/home.action", editUserAtts);
    //resourceMap.put("/scorm12/*.action*", editUserAtts);
    Collection<ConfigAttribute> anonymousUserAtts = new ArrayList<ConfigAttribute>();
    anonymousUserAtts.add(new SecurityConfig("ROLE_ANONYMOUS"));
    resourceMap.put("/login.action*", anonymousUserAtts);
    
    
  }

  // According to a URL, Find out permission configuration of this URL.
  public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
    // guess object is a URL.
    String url = ((FilterInvocation) object).getRequestUrl();
    Iterator<String> ite = resourceMap.keySet().iterator();
    while (ite.hasNext()) {
      String resURL = ite.next();
      if (urlMatcher.pathMatchesUrl(resURL, url)) {
        return resourceMap.get(resURL);
      }
    }
    return null;
  }

  public boolean supports(Class<?> clazz) {
    return true;
  }

  public Collection<ConfigAttribute> getAllConfigAttributes() {
    return null;
  }

}
