package com.kingnod.etraining.report.dao;

import java.util.List;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.dao.EntityDAO;
import com.kingnod.etraining.report.entity.ReportFolder;


    @com.kingnod.core.annotation.Generated("2012-05-11 10:26")
public interface ReportFolderDAO extends EntityDAO<ReportFolder, Long> {

    	/**
    	 * 获取有权限访问的Top文件夹
    	 */
    	public List<ReportFolder> findTopLevelByCriteria(Criteria criteria);

    	/**
    	 * 查询所有有读取权限的文件夹
    	 */
    	public List<ReportFolder> findAllReadByCriteria(Criteria criteria);

    	/**
    	 * 更新文件夹所属对象的数量
    	 * 
    	 * @param criteria
    	 * @return
    	 */
    	public int updateObjectCount(Criteria criteria);

    	/**
    	 * 更新文件夹所属子文件夹的数量
    	 * 
    	 * @param criteria
    	 * @return
    	 */
    	public int updateFolderCount(Criteria criteria);
}