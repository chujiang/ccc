package com.kingnod.etraining.activity.service.impl;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.activity.dao.FaceTeachingItemDAO;
import com.kingnod.etraining.activity.entity.FaceTeachingItem;
import com.kingnod.etraining.activity.service.FaceTeachingItemService;

import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class FaceTeachingItemServiceImpl implements FaceTeachingItemService {

    @Autowired
    protected FaceTeachingItemDAO faceTeachingItemDAO;


    public FaceTeachingItem getFaceTeachingItem(Long id) {
        return faceTeachingItemDAO.get(id);
    }

    public int saveFaceTeachingItem(FaceTeachingItem faceTeachingItem) {
        int count = 0;
        IdEntity<Long> idEntity = (IdEntity)faceTeachingItem;
        if(null != idEntity.getId() && null != faceTeachingItemDAO.get(idEntity.getId())){
            count = faceTeachingItemDAO.update(faceTeachingItem);
        }else{
            count = faceTeachingItemDAO.insert(faceTeachingItem);
        }
        return count;
    }

    public int deleteFaceTeachingItem(FaceTeachingItem faceTeachingItem) {
        return faceTeachingItemDAO.delete(faceTeachingItem);
    }

    public int deleteFaceTeachingItemByIds(Long[] ids) {
        return faceTeachingItemDAO.deleteById(ids);
    }

    public PagingResult<FaceTeachingItem> findFaceTeachingItem(Criteria criteria) {
        return faceTeachingItemDAO.findPagingResult(criteria);
    }
}