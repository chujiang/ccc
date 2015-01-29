package com.kingnod.etraining.organization.entity;

import java.util.ArrayList;
import java.util.List;

public class FunctionObj extends Function{
	private List<Function> list = new ArrayList<Function>();

	public FunctionObj(){}
	
	public FunctionObj(List<Function> list) {
		super();
		this.list = list;
	}

	public List<Function> getList() {
		return list;
	}

	public void setList(List<Function> list) {
		this.list = list;
	}
}