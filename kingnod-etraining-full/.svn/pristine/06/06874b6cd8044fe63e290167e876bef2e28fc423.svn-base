package com.kingnod.etraining.organization.dao;

import java.util.List;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.dao.EntityDAO;
import com.kingnod.etraining.organization.entity.Organization;

@com.kingnod.core.annotation.Generated("2012-02-06 17:39")
public interface OrganizationDAO extends EntityDAO<Organization, Long> {

	/**
	 * 获取有权限访问的Top组织
	 */
	public List<Organization> findTopLevelByCriteria(Criteria criteria);

	/**
	 * 查询所有有读取权限的组织
	 */
	public List<Organization> findAllReadByCriteria(Criteria criteria);
	
	public List<Organization> findhierarchyByChildId(Criteria criteria);

	/**
	 * 用户选择器查询
	 * 
	 * @param criteria
	 * @return
	 */
	public List<Organization> findAllObjectPickerByCriteria(Criteria criteria);

	/**
	 * 更新组织所属用户的数量
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

	/**
	 * 根据父组织id查询所有子组织
	 */
	List<Organization> finAllChildsOrgById(Criteria criteria);

	/**
	 * 维护文件夹， 父文件夹及祖父文件夹的关系
	 * 
	 * @param folder
	 */
	public void insertOrganizationHierarchy(Organization organization);
	
	/**
	 * 根据组织id重设下属组织个数
	 * 
	 * @param organization
	 */
	public void resetOrganizationCount(Long organizationId);

	/**
	 * 根据站点ID，获取要导出的组织列表
	 * @param siteId
	 * @return
	 */
	public List<Organization> getOrganizationsForExport(Long siteId);

}