/**
 * 
 */
package com.kingnod.etraining.common.entity;

/**
 * @author liuxiaobin
 *
 */
public class AuthorityRef {
	private Long id;
	private String name;
	
	public AuthorityRef(){}
	
	public AuthorityRef(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
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
}
