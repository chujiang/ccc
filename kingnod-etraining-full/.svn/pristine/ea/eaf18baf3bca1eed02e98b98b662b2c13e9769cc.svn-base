package com.kingnod.etraining.resource.dao;

import java.util.List;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.dao.EntityDAO;
import com.kingnod.etraining.resource.entity.ResourceFolder;

@com.kingnod.core.annotation.Generated("2012-02-09 16:17")
public interface ResourceFolderDAO extends EntityDAO<ResourceFolder, Long> {

	/**
	 * 获取有权限访问的Top文件夹
	 */
	public List<ResourceFolder> findTopLevelByCriteria(Criteria criteria);

	/**
	 * 查询所有有读取权限的文件夹
	 */
	public List<ResourceFolder> findAllReadByCriteria(Criteria criteria);
	
	/**
	 * 查询所有选择器文件夹
	 */
	public List<ResourceFolder> findAllObjectPickerByCriteria(Criteria criteria);

	/**
	 * 更新文件夹所属对象的数量
	 * 
	 * @param criteria
	 * @return
	 */
	public int updateObjectCount(Criteria criteria);
	
	/**
	 * 更新课程类别数量
	 * @param criteria
	 * @return
	 */
	public int updateObjectRelationCount(Criteria criteria);

	/**
	 * 更新文件夹所属子文件夹的数量
	 * 
	 * @param criteria
	 * @return
	 */
	public int updateFolderCount(Criteria criteria);
	
	
	/**
   * 根据父节点获取所有子节点的id
   */
  public List<ResourceFolder> findAllChildsCrsCategoryById(Criteria criteria);
  
  /**
	 * 维护文件夹， 父文件夹及祖父文件夹的关系
	 * 
	 * @param folder
	 */
	public void insertResourceFolderHierarchy(ResourceFolder folder);

}