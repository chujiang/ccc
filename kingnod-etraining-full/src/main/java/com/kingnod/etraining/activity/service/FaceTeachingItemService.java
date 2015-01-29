package com.kingnod.etraining.activity.service;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.activity.entity.FaceTeachingItem;


    @com.kingnod.core.annotation.Generated("2012-03-03 11:28")
public interface FaceTeachingItemService {

    
    @com.kingnod.core.annotation.Generated("2012-03-03 11:28")
    FaceTeachingItem getFaceTeachingItem(Long id);

    
    @com.kingnod.core.annotation.Generated("2012-03-03 11:28")
    int saveFaceTeachingItem(FaceTeachingItem faceTeachingItem);

    
    @com.kingnod.core.annotation.Generated("2012-03-03 11:28")
    int deleteFaceTeachingItem(FaceTeachingItem faceTeachingItem);

    
    @com.kingnod.core.annotation.Generated("2012-03-03 11:28")
    int deleteFaceTeachingItemByIds(Long[] ids);

    
    @com.kingnod.core.annotation.Generated("2012-03-03 11:28")
    PagingResult<FaceTeachingItem> findFaceTeachingItem(Criteria criteria);
}