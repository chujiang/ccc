package com.kingnod.etraining.activity.entity;

import java.io.Serializable;

import com.kingnod.etraining.common.ObjectType;

public interface Activity extends Serializable {
	
	/**
	 * 活动Id
	 * @return
	 */
	public Long getActivityId();
	
	/**
	 * 返回活动具体类型
	 * @return
	 */
	public ObjectType getActivityType();
	
	/**
	 * 返回活动类型对应的Class
	 * @return
	 */
    public Class<Activity> getActivityClass();
    
    /**
     * 返回具体的活动对象
     * @return
     */
    public Activity getActivityObject();

    /**
     * 活动文件夹Id
     * @return
     */
    public Long getFolderId();

    /**
     * 活动名称
     * @return
     */
    public String getName();

}
