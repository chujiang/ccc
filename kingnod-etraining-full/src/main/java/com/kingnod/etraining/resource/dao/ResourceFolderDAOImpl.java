package com.kingnod.etraining.resource.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.dao.MybatisEntityDAO;
import com.kingnod.core.exception.Exceptions;
import com.kingnod.core.util.collection.ListUtils;
import com.kingnod.etraining.course.dao.CourseInfoDAO;
import com.kingnod.etraining.course.entity.CourseInfo;
import com.kingnod.etraining.exam.dao.KnowledgeDAO;
import com.kingnod.etraining.exam.dao.PaperDAO;
import com.kingnod.etraining.exam.dao.QuestionDAO;
import com.kingnod.etraining.exam.entity.Knowledge;
import com.kingnod.etraining.exam.entity.Paper;
import com.kingnod.etraining.exam.entity.Question;
import com.kingnod.etraining.resource.entity.ResourceFolder;
import com.kingnod.etraining.resource.entity.ResourceFolderHierarchy;

@org.springframework.stereotype.Repository
@com.kingnod.core.annotation.Generated("2012-02-09 16:17")
public class ResourceFolderDAOImpl extends MybatisEntityDAO<ResourceFolder, Long> implements ResourceFolderDAO {

	@Autowired
	protected ResourceFolderHierarchyDAO resourceFolderHierarchyDAO;
	
	@Autowired
	protected PaperDAO paperDAO;
	
	@Autowired
	protected QuestionDAO questionDAO;
	
	@Autowired
	protected KnowledgeDAO knowledgeDAO;
	
	@Autowired
	protected CourseInfoDAO courseInfoDAO;
	
	/**
	 * 维护文件夹， 父文件夹及祖父文件夹的关系
	 * 
	 * @param folder
	 */
	public void insertResourceFolderHierarchy(ResourceFolder folder) {
		ResourceFolder hierarchyFolder = folder;
		int hierLevel = 0;
		while (null != hierarchyFolder) {
			ResourceFolderHierarchy siteHier = new ResourceFolderHierarchy();
			siteHier.setFolderId(folder.getId());
			siteHier.setHierarchyId(hierarchyFolder.getId());
			siteHier.setHierarchyLevel(hierLevel++);
			resourceFolderHierarchyDAO.insert(siteHier);
			if (null != hierarchyFolder.getParentId()) {
				hierarchyFolder = get(hierarchyFolder.getParentId());
			} else {
				hierarchyFolder = null;
			}
		}
	}
	
	private int deleteResourceFolderHierarchy(Long folderId) {
		CriteriaBuilder orgHierCb = Cnd.builder(ResourceFolderHierarchy.class);
		orgHierCb.andEQ("folderId", folderId);
		return resourceFolderHierarchyDAO.deleteByCriteria(orgHierCb.buildCriteria());
	}

	@Override
	protected void beforeInsert(ResourceFolder entity) {
		if (null != entity.getParentId()) {
			ResourceFolder parentEntity = get(entity.getParentId());
			int levelNumber = null == parentEntity ? 0 : parentEntity.getLevelNumber();
			entity.setLevelNumber(levelNumber + 1);
			entity.setObjectCount(0L);
			entity.setFolderCount(0L);
		}
	}
	
	@Override
	protected void afterInsert(ResourceFolder entity) {
		CriteriaBuilder cb = Cnd.builder(ResourceFolder.class);
		cb.andEQ("id", entity.getId());
		updateFolderCount(cb.buildCriteria().addParam("updateObj", "parent"));
		insertResourceFolderHierarchy(entity);
	}

	@Override
	public void beforeDelete(Long... ids) {
		for (Long id : ids) {
			int count = 0;
			CriteriaBuilder cb = Cnd.builder(ResourceFolder.class);
			cb.andEQ("parentId", id);
			CriteriaBuilder papercb = Cnd.builder(Paper.class);
			papercb.andEQ("folderId", id);
			CriteriaBuilder questioncb = Cnd.builder(Question.class);
			questioncb.andEQ("folderId", id);
			CriteriaBuilder knowledgecb = Cnd.builder(Knowledge.class);
			knowledgecb.andEQ("folderId", id);
			CriteriaBuilder courseInfocb = Cnd.builder(CourseInfo.class);
			courseInfocb.andEQ("folderId", id);
			int resCount = countByCriteria(cb.buildCriteria());
			int paperCount=paperDAO.countByCriteria(papercb.buildCriteria());
			int questionCount=questionDAO.countByCriteria(questioncb.buildCriteria());
			int knowledgeCount=knowledgeDAO.countByCriteria(knowledgecb.buildCriteria());
			int courseInfocbCount=courseInfoDAO.countByCriteria(courseInfocb.buildCriteria());
			count = resCount+paperCount+questionCount+knowledgeCount+courseInfocbCount+ count;
			if (count > 0) {
				throw Exceptions.createAppException("res003003");
			}
		}
	}
	
	@Override
	protected void afterDelete(Long... ids) {
		for(Long id:ids){
			deleteResourceFolderHierarchy(id);
		}
		
		CriteriaBuilder cb = Cnd.builder(ResourceFolder.class);
		cb.andIn("id", ListUtils.of(ids));
		updateFolderCount(cb.buildCriteria().addParam("updateObj", "parent"));
	}
	
	public List<ResourceFolder> findTopLevelByCriteria(Criteria criteria) {
		return getSqlSession().selectList(sqlId("findTopLevelByCriteria"), criteria);
	}
	
	public List<ResourceFolder> findAllReadByCriteria(Criteria criteria) {
		return getSqlSession().selectList(sqlId("findAllReadByCriteria"), criteria);
	}

	public int updateObjectCount(Criteria criteria) {
		return getSqlSession().update(sqlId("updateObjectCount"), criteria);
	}
	
	public int updateFolderCount(Criteria criteria) {
		return getSqlSession().update(sqlId("updateFolderCount"), criteria);
	}

	public List<ResourceFolder> findAllObjectPickerByCriteria(Criteria criteria) {
		return getSqlSession().selectList(sqlId("findAllObjectPickerByCriteria"), criteria);
	}

	public int updateObjectRelationCount(Criteria criteria) {
		return getSqlSession().update(sqlId("updateObjectRelationCount"), criteria);
	}

	/**
   * 根据父节点获取所有子节点的id
   */
  public List<ResourceFolder> findAllChildsCrsCategoryById(Criteria criteria){
    return getSqlSession().selectList(sqlId("findAllChildsCrsCategoryById"), criteria);
  }
}