package com.kingnod.etraining.course.dao;

import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.dao.MybatisEntityDAO;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.core.util.collection.ListUtils;
import com.kingnod.etraining.course.entity.CourseInfo;
import com.kingnod.etraining.resource.dao.ResourceFolderDAO;

@org.springframework.stereotype.Repository

    @com.kingnod.core.annotation.Generated("2012-02-17 10:47")
public class CourseInfoDAOImpl extends MybatisEntityDAO<CourseInfo, Long> implements CourseInfoDAO {
	
	@Autowired
	protected ResourceFolderDAO resourceFolderDAO;
	
	@Override
	protected void afterInsert(CourseInfo entity) {
		CriteriaBuilder cb = Cnd.builder(CourseInfo.class);
		cb.andEQ("id", entity.getId());
		Criteria criteria = cb.buildCriteria();
		criteria.addParam("tableName", "CRS_COURSE_INFO");
		resourceFolderDAO.updateObjectCount(criteria);
	}
	
	@Override
	protected void afterDelete(Long... ids) {
		CriteriaBuilder cb = Cnd.builder(CourseInfo.class);
		cb.andIn("id", ListUtils.of(ids));
		Criteria criteria = cb.buildCriteria();
		criteria.addParam("tableName", "CRS_COURSE_INFO");
		resourceFolderDAO.updateObjectCount(criteria);
	}
	

	public PagingResult<CourseInfo> findPagingResultByCategory(Criteria criteria, Long categoryId, String category) {
		criteria.addParam("categoryId", categoryId);
		criteria.addParam("category", category);
		return pagingQuery(sqlId("countByCategory"),sqlId("findByCategory"),criteria);
	}

}