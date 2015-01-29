package com.kingnod.etraining.common.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.common.dao.MenuDAO;
import com.kingnod.etraining.common.entity.Menu;
import com.kingnod.etraining.common.service.MenuService;

@org.springframework.stereotype.Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    protected MenuDAO menuDAO;


    public Menu getMenu(Long id) {
        return menuDAO.get(id);
    }

    public int saveMenu(Menu menu) {
        int count = 0;
        IdEntity<Long> idEntity = (IdEntity)menu;
        if(null != idEntity.getId() && null != menuDAO.get(idEntity.getId())){
            count = menuDAO.update(menu);
        }else{
            count = menuDAO.insert(menu);
        }
        return count;
    }

    public int deleteMenu(Menu menu) {
        return menuDAO.delete(menu);
    }

    public int deleteMenuByIds(Long[] ids) {
        return menuDAO.deleteById(ids);
    }

    public PagingResult<Menu> findMenu(Criteria criteria) {
        return menuDAO.findPagingResult(criteria);
    }
    
    public List<Menu> getMenu(String type){
    	return null;
    }
}