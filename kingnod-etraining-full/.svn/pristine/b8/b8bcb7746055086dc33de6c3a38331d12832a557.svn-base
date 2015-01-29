/**
 * 
 */
package com.kingnod.etraining.security.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 权限拥有者
 * 
 * @author liuxiaobin
 */
public class OwnerAuthority {
	private Long id;//对象Id
	
	private String name;//对象名：角色名称， 用户名称， 用户组名称
	
	private Long siteId;//所属站点
	
	private String siteName;
	
	private List<OwnerAutValue> list = new ArrayList<OwnerAutValue>();

	public OwnerAuthority(){}
	
	public OwnerAuthority(Long id, String name, List<OwnerAutValue> list) {
		super();
		this.id = id;
		this.name = name;
		this.list = list;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<OwnerAutValue> getList() {
		return list;
	}

	public void setList(List<OwnerAutValue> list) {
		this.list = list;
	}

	public Long getSiteId() {
		return siteId;
	}

	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
}

