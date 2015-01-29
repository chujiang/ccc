package com.kingnod.etraining.activity.entity;

import java.io.Serializable;

import com.kingnod.etraining.course.entity.ItemInfo;
import com.kingnod.etraining.course.entity.SCOPerformance;

public class ItemInfoPerformance implements Serializable {

	private static final long serialVersionUID = 1L;
	
	protected ItemInfo item;
	protected SCOPerformance performance;
	
	public ItemInfo getItem() {
		return item;
	}
	public void setItem(ItemInfo item) {
		this.item = item;
	}
	public SCOPerformance getPerformance() {
		return performance;
	}
	public void setPerformance(SCOPerformance performance) {
		this.performance = performance;
	}

	
}
