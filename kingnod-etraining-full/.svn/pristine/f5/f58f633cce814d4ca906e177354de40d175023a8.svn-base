package com.kingnod.etraining.activity.service.impl;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.activity.dao.FaceTeachingItemCostDAO;
import com.kingnod.etraining.activity.entity.FaceTeachingItemCost;
import com.kingnod.etraining.activity.service.FaceTeachingItemCostService;

import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class FaceTeachingItemCostServiceImpl implements FaceTeachingItemCostService {

    @Autowired
    protected FaceTeachingItemCostDAO faceTeachingItemCostDAO;


    public FaceTeachingItemCost getFaceTeachingItemCost(Long id) {
        return faceTeachingItemCostDAO.get(id);
    }

    public int saveFaceTeachingItemCost(FaceTeachingItemCost faceTeachingItemCost) {
        int count = 0;
        IdEntity<Long> idEntity = (IdEntity)faceTeachingItemCost;
        if(null != idEntity.getId() && null != faceTeachingItemCostDAO.get(idEntity.getId())){
            count = faceTeachingItemCostDAO.update(faceTeachingItemCost);
        }else{
            count = faceTeachingItemCostDAO.insert(faceTeachingItemCost);
        }
        return count;
    }

    public int deleteFaceTeachingItemCost(FaceTeachingItemCost faceTeachingItemCost) {
        return faceTeachingItemCostDAO.delete(faceTeachingItemCost);
    }

    public int deleteFaceTeachingItemCostByIds(Long[] ids) {
        return faceTeachingItemCostDAO.deleteById(ids);
    }

    public PagingResult<FaceTeachingItemCost> findFaceTeachingItemCost(Criteria criteria) {
        return faceTeachingItemCostDAO.findPagingResult(criteria);
    }
}