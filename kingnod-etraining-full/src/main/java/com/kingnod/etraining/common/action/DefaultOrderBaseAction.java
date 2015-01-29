package com.kingnod.etraining.common.action;

import java.io.Serializable;

import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.criteria.Order;
import com.kingnod.core.extensions.struts2.action.FilterableEntityAction;

/**
 * 实现默认按更新时间倒序排序排序
 * @author Sam
 *
 * @param <E>
 * @param <ID>
 */
public abstract class DefaultOrderBaseAction<E,ID extends Serializable> extends FilterableEntityAction<E,ID> {
	
	 
	private static final long serialVersionUID = -5031488838230170632L;

	public DefaultOrderBaseAction() {
		super();
		if (getDefaultOrderField() != null && getDefaultOrderValue() != null )
			pager.orderBy(getDefaultOrderField()).order(getDefaultOrderValue().toString().trim().toLowerCase());
	}
	
	protected String getDefaultOrderField() {
		return "updateDate";
	}
	
	protected Order getDefaultOrderValue() {
		return Order.DESC;
	}
}
