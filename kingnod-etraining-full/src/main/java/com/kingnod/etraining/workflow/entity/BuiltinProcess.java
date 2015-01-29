package com.kingnod.etraining.workflow.entity;


/**
 * 流程定义配置属性
 * @author binfeng
 *
 */
public class BuiltinProcess {
	
	private String key;
	private String name;
	private String xmlPath;
	private String pngPath;
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getXmlPath() {
		return xmlPath;
	}
	public void setXmlPath(String xmlPath) {
		this.xmlPath = xmlPath;
	}
	public String getPngPath() {
		return pngPath;
	}
	public void setPngPath(String pngPath) {
		this.pngPath = pngPath;
	}
	
	

}
