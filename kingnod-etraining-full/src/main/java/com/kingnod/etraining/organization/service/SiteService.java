package com.kingnod.etraining.organization.service;

import java.util.List;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.organization.entity.Site;


    @com.kingnod.core.annotation.Generated("2012-02-06 16:47")
public interface SiteService {

    
    @com.kingnod.core.annotation.Generated("2012-02-06 16:47")
    Site getSite(Long id);

    
    @com.kingnod.core.annotation.Generated("2012-02-06 16:47")
    int saveSite(Site site);

    
    @com.kingnod.core.annotation.Generated("2012-02-06 16:47")
    int deleteSite(Site site);

    
    @com.kingnod.core.annotation.Generated("2012-02-06 16:47")
    int deleteSiteByIds(Long[] ids);
    
    @com.kingnod.core.annotation.Generated("2012-02-06 16:47")
    PagingResult<Site> findSite(Criteria criteria);
    
    /**
     * 获取当前用户有权限访问的最高层级的站点
     */
    List<Site> findTopLevelSite();
    
    /**
     * 获取指定站点的子站点， 假如无权限访问则抛出无权限访问的异常
     */
    List<Site> findChildsSite(Long siteId);
    
    /**
     * 检查当前用户是否有指定站点的查看权限
     */
    boolean checkSiteReadPermission(Long siteId);
}