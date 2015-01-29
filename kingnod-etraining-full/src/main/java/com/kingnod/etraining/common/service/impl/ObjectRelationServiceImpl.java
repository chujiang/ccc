package com.kingnod.etraining.common.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.core.util.collection.ListUtils;
import com.kingnod.etraining.common.dao.ObjectRelationDAO;
import com.kingnod.etraining.common.entity.ObjectRelation;
import com.kingnod.etraining.common.service.ObjectRelationService;
import com.kingnod.etraining.resource.dao.ResourceFolderDAO;

@org.springframework.stereotype.Service
public class ObjectRelationServiceImpl implements ObjectRelationService {

    @Autowired
    protected ObjectRelationDAO objectRelationDAO;
    
    @Autowired
	protected ResourceFolderDAO resourceFolderDAO;


    public ObjectRelation getObjectRelation(Long id) {
        return objectRelationDAO.get(id);
    }

    public int saveObjectRelation(ObjectRelation objectRelation) {
        int count = 0;
        IdEntity<Long> idEntity = (IdEntity)objectRelation;
        if(null != idEntity.getId() && null != objectRelationDAO.get(idEntity.getId())){
            count = objectRelationDAO.update(objectRelation);
        }else{
        	objectRelationDAO.deleteObjectRelationByObjId(objectRelation);
            count = objectRelationDAO.insert(objectRelation);
        }
        return count;
    }

    public int deleteObjectRelation(ObjectRelation objectRelation) {
        return objectRelationDAO.delete(objectRelation);
    }

    public int deleteObjectRelationByIds(Long[] ids) {
    	
        return objectRelationDAO.deleteById(ids);
    }

    public PagingResult<ObjectRelation> findObjectRelation(Criteria criteria) {
        return objectRelationDAO.findPagingResult(criteria);
    }

	public List<String> findObjectRelationByCriteria(Criteria criteria) {
		// TODO Auto-generated method stub
		return objectRelationDAO.findObjectRelationByCriteria(criteria);
	}

	public int deleteObjectRelationByObjId(ObjectRelation objectRelation) {
		int count=0;
		// TODO Auto-generated method stub
		count=objectRelationDAO.deleteObjectRelationByObjId(objectRelation);
		
		//计算课程类别删除后数量
		if(count>0){
			CriteriaBuilder cb = Cnd.builder(ObjectRelation.class);
			cb.andIn("object2_Id", ListUtils.of(objectRelation.getObject2Id()));
			Criteria criteria = cb.buildCriteria();
			criteria.addParam("tableName", "CMN_OBJECT_RELATION");
			resourceFolderDAO.updateObjectRelationCount(criteria);
		}
			
		return count;
		
	}
}