package com.kingnod.etraining.resource.service.impl;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.resource.dao.LocationDAO;
import com.kingnod.etraining.resource.entity.Location;
import com.kingnod.etraining.resource.service.LocationService;

import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    protected LocationDAO locationDAO;


    public Location getLocation(Long id) {
        return locationDAO.get(id);
    }

    public int saveLocation(Location location) {
        int count = 0;
        IdEntity<Long> idEntity = (IdEntity)location;
        if(null != idEntity.getId() && null != locationDAO.get(idEntity.getId())){
            count = locationDAO.update(location);
        }else{
            count = locationDAO.insert(location);
        }
        return count;
    }

    public int deleteLocation(Location location) {
        return locationDAO.delete(location);
    }

    public int deleteLocationByIds(Long[] ids) {
        return locationDAO.deleteById(ids);
    }

    public PagingResult<Location> findLocation(Criteria criteria) {
        return locationDAO.findPagingResult(criteria);
    }
}