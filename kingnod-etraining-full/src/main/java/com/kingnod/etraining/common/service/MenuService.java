package com.kingnod.etraining.common.service;

import java.util.List;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.common.entity.Menu;


    @com.kingnod.core.annotation.Generated("2012-03-14 21:21")
public interface MenuService {

    
    @com.kingnod.core.annotation.Generated("2012-03-14 21:21")
    Menu getMenu(Long id);

    
    @com.kingnod.core.annotation.Generated("2012-03-14 21:21")
    int saveMenu(Menu menu);

    
    @com.kingnod.core.annotation.Generated("2012-03-14 21:21")
    int deleteMenu(Menu menu);

    
    @com.kingnod.core.annotation.Generated("2012-03-14 21:21")
    int deleteMenuByIds(Long[] ids);

    
    @com.kingnod.core.annotation.Generated("2012-03-14 21:21")
    PagingResult<Menu> findMenu(Criteria criteria);
    
    List<Menu> getMenu(String type);
}