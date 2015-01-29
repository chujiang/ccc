package com.kingnod.etraining.common.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.dao.MybatisEntityDAO;
import com.kingnod.core.util.StringUtils;
import com.kingnod.core.util.collection.ListUtils;
import com.kingnod.etraining.common.entity.ObjectRelation;
import com.kingnod.etraining.resource.dao.ResourceFolderDAO;

@org.springframework.stereotype.Repository

    @com.kingnod.core.annotation.Generated("2012-03-14 17:08")
public class ObjectRelationDAOImpl extends MybatisEntityDAO<ObjectRelation, Long> implements ObjectRelationDAO {
	
	@Autowired
	protected ResourceFolderDAO resourceFolderDAO;

	@SuppressWarnings("unchecked")
	public List<String> findObjectRelationByCriteria(Criteria criteria){
		return  getSqlSession().selectList("findObjectByCriteria", criteria);
		
	}
	
	public int deleteObjectRelationByObjId(ObjectRelation objectRelation)
	{
//		objectRelation.setId(((ObjectRelation)getSqlSession().selectList("getIdByObjectRelation", objectRelation).get(0)).getId());
//		if(null!=objectRelation.getId()){
//			afterDelete(objectRelation.getId());
//		}
		
		return  getSqlSession().delete("deleteObjectRelationByObjID", objectRelation);
	}
	
	@Override
	protected void afterInsert(ObjectRelation entity) {
		CriteriaBuilder cb = Cnd.builder(ObjectRelation.class);
		cb.andEQ("id", entity.getId());
		Criteria criteria = cb.buildCriteria();
		criteria.addParam("tableName", "CMN_OBJECT_RELATION");
		resourceFolderDAO.updateObjectRelationCount(criteria);
	}
	
	@Override
	protected void afterDelete(Long... ids) {
		CriteriaBuilder cb = Cnd.builder(ObjectRelation.class);
		cb.andIn("id", ListUtils.of(ids));
		Criteria criteria = cb.buildCriteria();
		criteria.addParam("tableName", "CMN_OBJECT_RELATION");
		resourceFolderDAO.updateObjectRelationCount(criteria);
	}
}