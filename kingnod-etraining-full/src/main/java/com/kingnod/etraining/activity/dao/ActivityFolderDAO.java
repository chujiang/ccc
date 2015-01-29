package com.kingnod.etraining.activity.dao;

import java.util.List;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.dao.EntityDAO;
import com.kingnod.etraining.activity.entity.ActivityFolder;

@com.kingnod.core.annotation.Generated("2012-02-09 19:16")
public interface ActivityFolderDAO extends EntityDAO<ActivityFolder, Long> {

	/**
	 * 获取有权限访问的Top文件夹
	 */
	public List<ActivityFolder> findTopLevelByCriteria(Criteria criteria);
	
	/**
	 * 查询所有有读取权限的文件夹
	 */
	List<ActivityFolder> findAllReadByCriteria(Criteria criteria);
	
	/**
	 * 更新文件夹所属对象的数量
	 * @param criteria
	 * @return
	 */
	public int updateObjectCount(Criteria criteria);
	
	/**
	 * 更新文件夹所属子文件夹的数量
	 * @param criteria
	 * @return
	 */
	public int updateFolderCount(Criteria criteria);
	/**
	 * 获取文件夹位置
	 * @param criteria
	 * @return
	 */
	public List<ActivityFolder>  findFolderPathById(Long id);
	
	/**
	 * 维护文件夹， 父文件夹及祖父文件夹的关系
	 * 
	 * @param folder
	 */
	public void insertActivityFolderHierarchy(ActivityFolder folder);

}