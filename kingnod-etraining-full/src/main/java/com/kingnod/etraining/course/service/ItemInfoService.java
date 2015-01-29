package com.kingnod.etraining.course.service;

import java.util.List;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.course.entity.ItemInfo;


    @com.kingnod.core.annotation.Generated("2012-02-07 10:41")
public interface ItemInfoService {

    
    @com.kingnod.core.annotation.Generated("2012-02-07 10:41")
    ItemInfo getItemInfo(Long id);

    
    @com.kingnod.core.annotation.Generated("2012-02-07 10:41")
    int saveItemInfo(ItemInfo itemInfo);

    
    @com.kingnod.core.annotation.Generated("2012-02-07 10:41")
    int deleteItemInfo(ItemInfo itemInfo);

    
    @com.kingnod.core.annotation.Generated("2012-02-07 10:41")
    int deleteItemInfoByIds(Long[] ids);

    
    @com.kingnod.core.annotation.Generated("2012-02-07 10:41")
    PagingResult<ItemInfo> findItemInfo(Criteria criteria);
    
    
    @com.kingnod.core.annotation.Generated("2012-02-07 10:41")
    List<ItemInfo> getItemInfoList(Long courseId);
    
    
    @com.kingnod.core.annotation.Generated("2012-02-07 10:41")
    void deleteItemInfo(Long id);
    
    
    @com.kingnod.core.annotation.Generated("2012-02-07 10:41")
    void updateItemInfo(Long id, String itemTitle);
    
    
    @com.kingnod.core.annotation.Generated("2012-02-07 10:41")
    void updateSequence(Long typeId,Long targetId);
    
    
    @com.kingnod.core.annotation.Generated("2012-02-07 10:41")
    void updateItemInfo(ItemInfo itemInfo);
    
    void deleteByCourseId(long courseid) ;
    int countByCriteria(Criteria criteria);
}