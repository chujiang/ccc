package com.kingnod.etraining.common.dao;

import java.util.List;

import com.kingnod.core.dao.EntityDAO;
import com.kingnod.etraining.common.entity.Menu;


@com.kingnod.core.annotation.Generated("2012-03-14 21:21")
public interface MenuDAO extends EntityDAO<Menu, Long> {
	List<Menu> getMenu(String type);
}