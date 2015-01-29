package com.kingnod.etraining.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

@Deprecated 
public class MyFilterSecurityInterceptor extends AbstractSecurityInterceptor implements Filter {
  
  private FilterInvocationSecurityMetadataSource securityMetadataSource;

  public void init(FilterConfig filterConfig) throws ServletException {

  }

  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
      ServletException {
    SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    FilterInvocation fi = new FilterInvocation(request, response, chain);
    invoke(fi);
  }
  
  public void invoke(FilterInvocation fi) throws IOException, ServletException {
    InterceptorStatusToken token = super.beforeInvocation(fi);
    try {
      fi.getChain().doFilter(fi.getRequest(), fi.getResponse());
    } finally {
      super.afterInvocation(token, null);
    }
  }

  public void destroy() {

  }

  @Override
  public Class<? extends Object> getSecureObjectClass() {
    return FilterInvocation.class;
  }

  @Override
  public SecurityMetadataSource obtainSecurityMetadataSource() {
    return this.securityMetadataSource;
  }
  
  public void setSecurityMetadataSource(FilterInvocationSecurityMetadataSource newSource) {
  this.securityMetadataSource = newSource;
}

}