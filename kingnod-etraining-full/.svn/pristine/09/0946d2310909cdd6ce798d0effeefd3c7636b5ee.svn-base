package com.kingnod.etraining.activity.service;

import java.util.List;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.activity.entity.ActivityFolder;
import com.kingnod.etraining.common.ObjectType;

@com.kingnod.core.annotation.Generated("2012-02-09 19:16")
public interface ActivityFolderService {

	@com.kingnod.core.annotation.Generated("2012-02-09 19:16")
	ActivityFolder getActivityFolder(Long id);

	@com.kingnod.core.annotation.Generated("2012-02-09 19:16")
	int saveActivityFolder(ActivityFolder activityFolder);

	@com.kingnod.core.annotation.Generated("2012-02-09 19:16")
	int deleteActivityFolder(ActivityFolder activityFolder);

	@com.kingnod.core.annotation.Generated("2012-02-09 19:16")
	int deleteActivityFolderByIds(Long[] ids);

	@com.kingnod.core.annotation.Generated("2012-02-09 19:16")
	PagingResult<ActivityFolder> findActivityFolder(Criteria criteria);

	/**
	 * 获取指定站点或指定文件夹的子文件夹， 假如无权限访问则抛出无权限访问的异常
	 * 
	 * @param siteId
	 *            站点ID
	 * @param folderId
	 *            文件夹ID
	 * @param types
	 *            要获取的文件夹类型
	 * @return
	 */
	List<ActivityFolder> findChildsResourceFolder(Long folderId, ObjectType... types);

	/**
	 * 检查当前用户是否有指定文件夹的查看权限
	 * 
	 * @param folderId
	 *            文件夹ID
	 * @return
	 */
	public boolean checkResourceFolderReadPermission(Long folderId);

	/**
	 * 获取当前用户有权限访问的最高层级的文件夹
	 * @param types
	 *            要获取的文件夹类型
	 * @return
	 */
	List<ActivityFolder> findTopLevelResourceFolder(ObjectType... types);
	
	/**
	 * 查询所有有读取权限的文件夹
	 */
	public List<ActivityFolder> findAllReadByCriteria(Long folderId, String foldeNameKeyword, ObjectType... types);

	//移动活动文件夹位置
	void moveActivityFolder(Long sourceId, Long targetId, String moveType);
}