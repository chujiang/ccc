package com.kingnod.etraining.security.entity;
/**
 * URL-授权实体类,一个URL-授权表示了要访问这个URL当前登录的用户必须拥有的权限。
 * @author Sam
 *
 */
public class UrlAuthority {
	/**
	 * URL
	 */
	private String url;
	
	/**
	 * 权限
	 */
	private String ahthority;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getAhthority() {
		return ahthority;
	}
	public void setAhthority(String ahthority) {
		this.ahthority = ahthority;
	}
	
}
