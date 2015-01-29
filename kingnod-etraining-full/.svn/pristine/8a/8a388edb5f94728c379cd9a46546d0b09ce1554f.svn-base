package com.kingnod.etraining.organization.service;

import java.util.List;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.common.ObjectType;
import com.kingnod.etraining.organization.entity.Organization;


    @com.kingnod.core.annotation.Generated("2012-02-06 17:39")
public interface OrganizationService {

    
    @com.kingnod.core.annotation.Generated("2012-02-06 17:39")
    Organization getOrganization(Long id);

    
    @com.kingnod.core.annotation.Generated("2012-02-06 17:39")
    int saveOrganization(Organization organization);

    
    @com.kingnod.core.annotation.Generated("2012-02-06 17:39")
    int deleteOrganization(Organization organization);

    
    @com.kingnod.core.annotation.Generated("2012-02-06 17:39")
    int deleteOrganizationByIds(Long[] ids);
    

    
    @com.kingnod.core.annotation.Generated("2012-02-06 17:39")
    PagingResult<Organization> findOrganization(Criteria criteria);
    
    /**
     * 获取指定站点或组织的子组织， 假如无权限访问则抛出无权限访问的异常
     * @param organizationId 组织ID
     * @param types 要获取的文件夹类型
     * @return
     */
	List<Organization> findChildsOrganization(Long organizationId, ObjectType... types);
	

	/**
	 * 获取当前用户有权限访问的最高层级的站点或组织
	 * @param excluseSiteIds 要排除的站点ID
	 * @param types 要获取的文件夹类型
	 * @return
	 */
	List<Organization> findTopLevelOrganization(ObjectType... types);
	
	/**
	 * 查询所有有读取权限的组织
	 */
	public List<Organization> findAllReadByCriteria(Long organizationId, String foldeNameKeyword, ObjectType... types);
	
	/**
	 * 查询所有有读取权限的组织
	 */
	public List<Organization> findAllObjectPickerByCriteria(Long organizationId, String foldeNameKeyword,String treeType, ObjectType... types);
	
	 //根据父组织id查询所有子组织id
  List<Long> finAllChildsOrgById(Long organizationId);
  
  	//移动组织到目标组织
  	public void moveOrganization(Long sourceId, Long targetId, String moveType);
  	
  	//根据组织id重设下属组织个数
  	public void resetOrganizationCount(Long organizationId);

  	//根据站点ID，获取要导出的组织列表
	List<Organization> getOrganizationsForExport(Long siteId);
	
	//组织用户导入
    int saveOrganization(Organization organization, boolean isImport);
    
    /**
     * 重置组织的层级数据
     * @param organization
     */
    public void resetOrganizationHierarchy(Organization organization);
    
}