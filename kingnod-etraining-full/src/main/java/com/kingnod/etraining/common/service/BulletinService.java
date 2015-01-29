package com.kingnod.etraining.common.service;

import java.util.List;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.common.ObjectType;
import com.kingnod.etraining.common.entity.Bulletin;


    @com.kingnod.core.annotation.Generated("2012-04-21 11:11")
public interface BulletinService {

    
    @com.kingnod.core.annotation.Generated("2012-04-21 11:11")
    Bulletin getBulletin(Long id);

    
    @com.kingnod.core.annotation.Generated("2012-04-21 11:11")
    int saveBulletin(Bulletin bulletin);

    
    @com.kingnod.core.annotation.Generated("2012-04-21 11:11")
    int deleteBulletin(Bulletin bulletin);

    
    @com.kingnod.core.annotation.Generated("2012-04-21 11:11")
    int deleteBulletinByIds(Long[] ids);

    
    @com.kingnod.core.annotation.Generated("2012-04-21 11:11")
    PagingResult<Bulletin> findBulletin(Criteria criteria);
    
    public List<Bulletin> BelongsToList();
    
    public List<Bulletin> newBulletin();
    
    public List<Bulletin> elearningBulletin(Long objectId,ObjectType objectType);
    
    PagingResult<Bulletin> findNewBulletinList(Criteria criteria);
}