package com.kingnod.etraining.activity.service.impl;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.activity.dao.FaceTeachingDAO;
import com.kingnod.etraining.activity.entity.FaceTeaching;
import com.kingnod.etraining.activity.service.FaceTeachingService;

import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class FaceTeachingServiceImpl implements FaceTeachingService {

    @Autowired
    protected FaceTeachingDAO faceTeachingDAO;


    public FaceTeaching getFaceTeaching(Long id) {
        return faceTeachingDAO.get(id);
    }

    public int saveFaceTeaching(FaceTeaching faceTeaching) {
        int count = 0;
        IdEntity<Long> idEntity = (IdEntity)faceTeaching;
        if(null != idEntity.getId() && null != faceTeachingDAO.get(idEntity.getId())){
            count = faceTeachingDAO.update(faceTeaching);
        }else{
            count = faceTeachingDAO.insert(faceTeaching);
        }
        return count;
    }

    public int deleteFaceTeaching(FaceTeaching faceTeaching) {
        return faceTeachingDAO.delete(faceTeaching);
    }

    public int deleteFaceTeachingByIds(Long[] ids) {
        return faceTeachingDAO.deleteById(ids);
    }

    public PagingResult<FaceTeaching> findFaceTeaching(Criteria criteria) {
        return faceTeachingDAO.findPagingResult(criteria);
    }
}