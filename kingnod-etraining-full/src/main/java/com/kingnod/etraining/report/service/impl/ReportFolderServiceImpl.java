package com.kingnod.etraining.report.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.criteria.Logic;
import com.kingnod.core.criteria.Order;
import com.kingnod.core.entity.RecordStatus;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.common.ObjectType;
import com.kingnod.etraining.common.ui.util.TagUtils;
import com.kingnod.etraining.organization.dao.SiteDAO;
import com.kingnod.etraining.organization.service.SiteService;
import com.kingnod.etraining.report.dao.ReportFolderDAO;
import com.kingnod.etraining.report.dao.ReportFolderHierarchyDAO;
import com.kingnod.etraining.report.entity.ReportFolder;
import com.kingnod.etraining.report.service.ReportFolderService;
import com.kingnod.etraining.security.PermisssionService;


@org.springframework.stereotype.Service
public class ReportFolderServiceImpl implements ReportFolderService{

	@Autowired
	protected ReportFolderDAO reportFolderDAO;
	
	@Autowired
	protected ReportFolderHierarchyDAO reportFolderHierarchyDAO;
	
	@Autowired
	protected SiteService siteService;

	@Autowired
	protected SiteDAO siteDAO;
	
	@Autowired
	private PermisssionService permisssionService;

	public ReportFolder getReportFolder(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public int saveReportFolder(ReportFolder reportFolder) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteReportFolder(ReportFolder reportFolder) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int deleteReportFolderByIds(Long[] ids) {
		// TODO Auto-generated method stub
		return 0;
	}

	public PagingResult<ReportFolder> findReportFolder(Criteria criteria) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private CriteriaBuilder getTypesCriteriaBuilder(ObjectType... types) {
		if (null != types && types.length > 0) {
			CriteriaBuilder folderTypeCb = Cnd.builder(ReportFolder.class);
			for (ObjectType objtype : types) {
				if (objtype.name().charAt(2) == '_') {
					String entityType = objtype.name();
					entityType = objtype.name().substring(0, 2);
					entityType = entityType + "%";
					entityType = entityType + objtype.name().substring(3, objtype.name().length());
					folderTypeCb.add(Cnd.like(Logic.OR, "type", entityType));
				} else if (objtype.name().endsWith("_")) {
					String entityType = objtype.name();
					entityType = entityType.substring(0, entityType.length() - 1);
					entityType = entityType + "%";
					folderTypeCb.add(Cnd.like(Logic.OR, "type", entityType));
				} else {
					folderTypeCb.orEQ("type", objtype.name());
				}
			}
			return folderTypeCb;
		}
		return null;
	}

	public List<ReportFolder> findChildsReportFolder(Long folderId, ObjectType... types) {
		CriteriaBuilder criteriaBuilder = Cnd.builder(ReportFolder.class);

		criteriaBuilder.andEQ("parentId", folderId);

		CriteriaBuilder typesCriteriaBuilder = getTypesCriteriaBuilder(types);
		if (null != typesCriteriaBuilder) {
			criteriaBuilder.andGroup(typesCriteriaBuilder);
		}
		return reportFolderDAO.findByCriteria(criteriaBuilder.buildCriteria());
	}

	public boolean checkReportFolderReadPermission(Long folderId) {
		return true;
	}

	public List<ReportFolder> findTopLevelReportFolder(ObjectType... types) {
		CriteriaBuilder criteriaBuilder = Cnd.builder(ReportFolder.class);

		Criteria criteria = criteriaBuilder.buildCriteria();

		permisssionService.addPermissionParams(criteria, types);

		CriteriaBuilder typesCriteriaBuilder = getTypesCriteriaBuilder(types);
		if (null != typesCriteriaBuilder) {
			criteriaBuilder.andGroup(typesCriteriaBuilder);
		}

		return reportFolderDAO.findTopLevelByCriteria(criteria);
	}

	public List<ReportFolder> findAllReadByCriteria(Long folderId, String foldeNameKeyword, ObjectType... types) {
		CriteriaBuilder criteriaBuilder = Cnd.builder(ReportFolder.class);

		if (!StringUtils.isEmpty(foldeNameKeyword)) {
			foldeNameKeyword=TagUtils.filterString(foldeNameKeyword);
			criteriaBuilder.addParam("foldeNameKeyword", "%" + foldeNameKeyword + "%");
		}
		criteriaBuilder.andEQ("recordStatus", RecordStatus.ACTIVE);
		Criteria criteria = criteriaBuilder.buildCriteria();
		if (null != folderId) {
			criteria.addParam("folderId", folderId);
		}
		criteriaBuilder.orderBy("name", Order.ASC);
		criteria.addParam("columnName", "Y.FOLDER_ID");
		criteria.addParam("hierarchyTableName", "RPT_FOLDER_HIERARCHY");
		permisssionService.addPermissionParams(criteria, types);

		CriteriaBuilder typesCriteriaBuilder = getTypesCriteriaBuilder(types);
		if (null != typesCriteriaBuilder) {
			criteriaBuilder.andGroup(typesCriteriaBuilder);
		}

		return reportFolderDAO.findAllReadByCriteria(criteria);
	}
}
