package com.kingnod.etraining.activity.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.dao.MybatisEntityDAO;
import com.kingnod.core.exception.Exceptions;
import com.kingnod.core.util.collection.ListUtils;
import com.kingnod.etraining.activity.entity.ActivityFolder;
import com.kingnod.etraining.activity.entity.ActivityFolderHierarchy;
import com.kingnod.etraining.activity.entity.Elearning;
import com.kingnod.etraining.activity.entity.Examination;
import com.kingnod.etraining.activity.entity.TrainingPlan;

@org.springframework.stereotype.Repository
@com.kingnod.core.annotation.Generated("2012-02-09 19:16")
public class ActivityFolderDAOImpl extends MybatisEntityDAO<ActivityFolder, Long> implements ActivityFolderDAO {

	@Autowired
	protected ActivityFolderHierarchyDAO activityFolderHierarchyDAO;
	
	@Autowired
	protected TrainingPlanDAO trainingPlanDAO;
	
	@Autowired
	protected ElearningDAO elearningDAO;
	
	@Autowired
	protected ExaminationDAO examinationDAO;
	
	/**
	 * 维护文件夹， 父文件夹及祖父文件夹的关系
	 * 
	 * @param folder
	 */
	public void insertActivityFolderHierarchy(ActivityFolder folder) {
		ActivityFolder hierarchyFolder = folder;
		int hierLevel = 0;
		while (null != hierarchyFolder) {
			ActivityFolderHierarchy siteHier = new ActivityFolderHierarchy();
			siteHier.setFolderId(folder.getId());
			siteHier.setHierarchyId(hierarchyFolder.getId());
			siteHier.setHierarchyLevel(hierLevel++);
			activityFolderHierarchyDAO.insert(siteHier);
			if (null != hierarchyFolder.getParentId()) {
				hierarchyFolder = get(hierarchyFolder.getParentId());
			} else {
				hierarchyFolder = null;
			}
		}
	}
	
	private int deleteActivityFolderHierarchy(Long folderId) {
		CriteriaBuilder orgHierCb = Cnd.builder(ActivityFolderHierarchy.class);
		orgHierCb.andEQ("folderId", folderId);
		return activityFolderHierarchyDAO.deleteByCriteria(orgHierCb.buildCriteria());
	}

	@Override
	protected void beforeInsert(ActivityFolder entity) {
		if (null != entity.getParentId()) {
			ActivityFolder parentEntity = get(entity.getParentId());
			int levelNumber = null == parentEntity ? 0 : parentEntity.getLevelNumber();
			entity.setLevelNumber(levelNumber + 1);
			entity.setObjectCount(0L);
			entity.setFolderCount(0L);
		}
	}
	
	@Override
	protected void afterInsert(ActivityFolder entity) {
		CriteriaBuilder cb = Cnd.builder(ActivityFolder.class);
		cb.andEQ("id", entity.getId());
		updateFolderCount(cb.buildCriteria().addParam("updateObj", "parent"));
		insertActivityFolderHierarchy(entity);
	}

	@Override
	public void beforeDelete(Long... ids) {
		for (Long id : ids) {
			int count = 0;
			CriteriaBuilder cb = Cnd.builder(ActivityFolder.class);
			cb.andEQ("parentId", id);
			int actCount = countByCriteria(cb.buildCriteria());
			cb = Cnd.builder(TrainingPlan.class);
			cb.andEQ("folderId", id);
			int trainingPlanCount = trainingPlanDAO.countByCriteria(cb.buildCriteria());
			cb = Cnd.builder(Elearning.class);
			cb.andEQ("folderId", id);
			int elearningCount = elearningDAO.countByCriteria(cb.buildCriteria());
			cb = Cnd.builder(Examination.class);
			cb.andEQ("folderId", id);
			int examinationCount = examinationDAO.countByCriteria(cb.buildCriteria());
			count = actCount+trainingPlanCount+elearningCount+examinationCount+count;
			if (count > 0) {
				throw Exceptions.createAppException("aty003001");
			}
		}
	}
	
	@Override
	protected void afterDelete(Long... ids) {
		for(Long id:ids){
			deleteActivityFolderHierarchy(id);
		}
		
		CriteriaBuilder cb = Cnd.builder(ActivityFolder.class);
		cb.andIn("id", ListUtils.of(ids));
		updateFolderCount(cb.buildCriteria().addParam("updateObj", "parent"));
	}

	public List<ActivityFolder> findTopLevelByCriteria(Criteria criteria) {
		return getSqlSession().selectList(sqlId("findTopLevelByCriteria"), criteria);
	}
	
	public List<ActivityFolder> findAllReadByCriteria(Criteria criteria) {
		return getSqlSession().selectList(sqlId("findAllReadByCriteria"), criteria);
	}
	
	public int updateObjectCount(Criteria criteria) {
		return getSqlSession().update(sqlId("updateObjectCount"), criteria);
	}
	
	public int updateFolderCount(Criteria criteria) {
		return getSqlSession().update(sqlId("updateFolderCount"), criteria);
	}
	public List<ActivityFolder>  findFolderPathById(Long id){
		return getSqlSession().selectList(sqlId("findFolderPathById"), id);
	}
}