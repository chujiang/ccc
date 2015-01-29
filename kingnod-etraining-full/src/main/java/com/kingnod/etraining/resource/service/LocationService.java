package com.kingnod.etraining.resource.service;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.resource.entity.Location;


    @com.kingnod.core.annotation.Generated("2012-02-10 18:41")
public interface LocationService {

    
    @com.kingnod.core.annotation.Generated("2012-02-10 18:41")
    Location getLocation(Long id);

    
    @com.kingnod.core.annotation.Generated("2012-02-10 18:41")
    int saveLocation(Location location);

    
    @com.kingnod.core.annotation.Generated("2012-02-10 18:41")
    int deleteLocation(Location location);

    
    @com.kingnod.core.annotation.Generated("2012-02-10 18:41")
    int deleteLocationByIds(Long[] ids);

    
    @com.kingnod.core.annotation.Generated("2012-02-10 18:41")
    PagingResult<Location> findLocation(Criteria criteria);
}