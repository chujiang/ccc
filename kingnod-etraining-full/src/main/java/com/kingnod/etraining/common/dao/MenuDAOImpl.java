package com.kingnod.etraining.common.dao;

import java.util.List;

import com.kingnod.core.dao.MybatisEntityDAO;
import com.kingnod.etraining.common.entity.Menu;

@org.springframework.stereotype.Repository

    @com.kingnod.core.annotation.Generated("2012-03-14 21:21")
public class MenuDAOImpl extends MybatisEntityDAO<Menu, Long> implements MenuDAO {

	/**
	 * 获取右键菜单选项
	 */
	public List<Menu> getMenu(String type){
		return getSqlSession().selectList("findMenuByType", type);
    }
}