package com.kingnod.etraining.resource.service;

import java.util.List;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.common.ObjectType;
import com.kingnod.etraining.common.ui.components.TreeNode;
import com.kingnod.etraining.resource.entity.ResourceFolder;

@com.kingnod.core.annotation.Generated("2012-02-09 16:17")
public interface ResourceFolderService {

	@com.kingnod.core.annotation.Generated("2012-02-09 16:17")
	ResourceFolder getResourceFolder(Long id);

	@com.kingnod.core.annotation.Generated("2012-02-09 16:17")
	int saveResourceFolder(ResourceFolder resourceFolder);

	@com.kingnod.core.annotation.Generated("2012-02-09 16:17")
	int deleteResourceFolder(ResourceFolder resourceFolder);

	@com.kingnod.core.annotation.Generated("2012-02-09 16:17")
	int deleteResourceFolderByIds(Long[] ids);

	@com.kingnod.core.annotation.Generated("2012-02-09 16:17")
	PagingResult<ResourceFolder> findResourceFolder(Criteria criteria);

	// 查询首页课程分类树
	List<TreeNode> getHomeCrsCategoryTreeList(Long userId, Long siteId);

	// 查询课程分类树
	List<TreeNode> getCrsCategoryTreeList(Long userId, Long siteId);

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
	List<ResourceFolder> findChildsResourceFolder(Long folderId, ObjectType... types);

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
	 * 
	 * @param excluseSiteIds
	 *            要排除的站点ID
	 * @param types
	 *            要获取的文件夹类型
	 * @return
	 */
	List<ResourceFolder> findTopLevelResourceFolder(ObjectType... types);

	/**
	 * 查询所有有读取权限的文件夹
	 */
	public List<ResourceFolder> findAllReadByCriteria(Long folderId, String foldeNameKeyword, ObjectType... types);

	/**
	 * 查询树文件夹
	 * 
	 * @param folderId
	 * @param foldeNameKeyword
	 * @param treeType
	 * @param types
	 * @return
	 */
	public List<ResourceFolder> findAllObjectPickerByCriteria(Long folderId, String foldeNameKeyword, String treeType, ObjectType... types);

	// 根据父节点获取所有子节点的id
	List<Long> findAllChildsCrsCategoryById(Long folderId);

	//移动资源文件夹位置
	void moveResourceFolder(Long id, Long targetId, String moveType);

}