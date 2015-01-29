package com.kingnod.etraining.common.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuxiaobin
 * 角色权限表
 */
public class RoleAuthority {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private List<DefinedAuthority> list = new ArrayList<DefinedAuthority>();
	
	public RoleAuthority(){}
	
	public RoleAuthority(Long id, String name, List<DefinedAuthority> list) {
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
	public List<DefinedAuthority> getList() {
		return list;
	}
	public void setList(List<DefinedAuthority> list) {
		this.list = list;
	}
}