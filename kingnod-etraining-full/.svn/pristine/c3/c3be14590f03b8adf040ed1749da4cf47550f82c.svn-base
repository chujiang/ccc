package com.kingnod.etraining.report.service;

import java.util.List;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.common.ObjectType;
import com.kingnod.etraining.report.entity.ReportFolder;
import com.kingnod.etraining.resource.entity.ResourceFolder;


    @com.kingnod.core.annotation.Generated("2012-05-11 10:26")
public interface ReportFolderService {

    
    @com.kingnod.core.annotation.Generated("2012-05-11 10:26")
    ReportFolder getReportFolder(Long id);

    
    @com.kingnod.core.annotation.Generated("2012-05-11 10:26")
    int saveReportFolder(ReportFolder reportFolder);

    
    @com.kingnod.core.annotation.Generated("2012-05-11 10:26")
    int deleteReportFolder(ReportFolder reportFolder);

    
    @com.kingnod.core.annotation.Generated("2012-05-11 10:26")
    int deleteReportFolderByIds(Long[] ids);

    
    @com.kingnod.core.annotation.Generated("2012-05-11 10:26")
    PagingResult<ReportFolder> findReportFolder(Criteria criteria);
    
    /**
     * 获取指定站点或指定文件夹的子文件夹， 假如无权限访问则抛出无权限访问的异常
     * @param siteId 站点ID
     * @param folderId 文件夹ID
     * @param types 要获取的文件夹类型
     * @return
     */
	List<ReportFolder> findChildsReportFolder(Long folderId, ObjectType... types);
	
	/**
	 * 检查当前用户是否有指定文件夹的查看权限
	 * @param folderId 文件夹ID
	 * @return
	 */
	public boolean checkReportFolderReadPermission(Long folderId);
    
    
	/**
	 * 获取当前用户有权限访问的最高层级的文件夹
	 * @param excluseSiteIds 要排除的站点ID
	 * @param types 要获取的文件夹类型
	 * @return
	 */
	List<ReportFolder> findTopLevelReportFolder(ObjectType... types);
	
	/**
	 * 查询所有有读取权限的文件夹
	 */
	public List<ReportFolder> findAllReadByCriteria(Long folderId, String foldeNameKeyword, ObjectType... types);
}