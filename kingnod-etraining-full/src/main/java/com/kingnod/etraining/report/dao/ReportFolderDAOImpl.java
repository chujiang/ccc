package com.kingnod.etraining.report.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.dao.MybatisEntityDAO;
import com.kingnod.etraining.report.entity.ReportFolder;
import com.kingnod.etraining.report.entity.ReportFolderHierarchy;

@org.springframework.stereotype.Repository

    @com.kingnod.core.annotation.Generated("2012-05-11 10:26")
public class ReportFolderDAOImpl extends MybatisEntityDAO<ReportFolder, Long> implements ReportFolderDAO {
	
	@Autowired
	protected ReportFolderHierarchyDAO reportFolderHierarchyDAO;

	public List<ReportFolder> findTopLevelByCriteria(Criteria criteria) {
		return getSqlSession().selectList(sqlId("findTopLevelByCriteria"), criteria);
	}

	public List<ReportFolder> findAllReadByCriteria(Criteria criteria) {
		return getSqlSession().selectList(sqlId("findAllReadByCriteria"), criteria);
	}

	public int updateObjectCount(Criteria criteria) {
		return getSqlSession().update(sqlId("updateObjectCount"), criteria);
	}

	public int updateFolderCount(Criteria criteria) {
		return getSqlSession().update(sqlId("updateFolderCount"), criteria);
	}
	
	/**
	 * 维护文件夹， 父文件夹及祖父文件夹的关系
	 * 
	 * @param folder
	 */
	private void insertReportFolderHierarchy(ReportFolder folder) {
		ReportFolder hierarchyFolder = folder;
		int hierLevel = 0;
		while (null != hierarchyFolder) {
			ReportFolderHierarchy siteHier = new ReportFolderHierarchy();
			siteHier.setFolderId(folder.getId());
			siteHier.setHierarchyId(hierarchyFolder.getId());
			siteHier.setHierarchyLevel(hierLevel++);
			reportFolderHierarchyDAO.insert(siteHier);
			if (null != hierarchyFolder.getParentId()) {
				hierarchyFolder = get(hierarchyFolder.getParentId());
			} else {
				hierarchyFolder = null;
			}
		}
	}
	
	@Override
	protected void afterInsert(ReportFolder entity) {
		CriteriaBuilder cb = Cnd.builder(ReportFolder.class);
		cb.andEQ("id", entity.getId());
		updateFolderCount(cb.buildCriteria());
		insertReportFolderHierarchy(entity);
	}
	


}