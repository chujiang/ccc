package com.kingnod.etraining.security.entity;

/**
 * 系统记录级权限
 * @author Sam
 *
 */
public class Permission {
	/**
	 * 数据级读权限
	 */
	public final static int READ = 1;
	
	/**
	 * 数据级写权限
	 */
	public final static int WRITE = 2;
	
	/**
	 * 数据级删除权限
	 */
	public final static int DELETE = 4;
	
	/**
	 * 数据级授权权限
	 */
	public final static int AUTHORIZATION = 8;
 
	
	/**
	 * 数据记录对象
	 */
	private EntityObject entityObject;
	
	/**
	 * 要授权的对象（角色、用户、用户组）
	 */
	private Owner owner;
	
	/**
	 * 权限十进制值
	 */
	private int permIntValue;
	
	/**
	 * 权限二进制值
	 */
	private String permBitValue;
	
	public EntityObject getEntityObject() {
		return entityObject;
	}
	public void setEntityObject(EntityObject entityObject) {
		this.entityObject = entityObject;
	}
	public Owner getOwner() {
		return owner;
	}
	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	public int getPermIntValue() {
		return permIntValue;
	}
	public void setPermIntValue(int permIntValue) {
		this.permIntValue = permIntValue;
	}
	public String getPermBitValue() {
		return permBitValue;
	}
	public void setPermBitValue(String permBitValue) {
		this.permBitValue = permBitValue;
	}
	
	
}
