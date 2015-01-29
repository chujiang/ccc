/**
 * 
 */
package com.kingnod.etraining.common.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuxiaobin
 *	一级菜单对象
 */
public class DefinedRoleFunction{
	private Long functionId;
	private String functionName;
	private List<DefinedFunction> list = new ArrayList<DefinedFunction>();
	
	public DefinedRoleFunction(){}
	
	public DefinedRoleFunction(Long functionId,
			String functionName, List<DefinedFunction> list) {
		super();
		this.functionId = functionId;
		this.functionName = functionName;
		this.list = list;
	}
	public Long getFunctionId() {
		return functionId;
	}
	public void setFunctionId(Long functionId) {
		this.functionId = functionId;
	}
	public String getFunctionName() {
		return functionName;
	}
	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}
	public List<DefinedFunction> getList() {
		return list;
	}
	public void setList(List<DefinedFunction> list) {
		this.list = list;
	}
}
