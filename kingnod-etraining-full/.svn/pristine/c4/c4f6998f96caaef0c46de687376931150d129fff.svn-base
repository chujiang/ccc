package com.kingnod.etraining.organization.service;

import java.util.List;
import java.util.Map;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.common.ui.components.TreeNode;
import com.kingnod.etraining.organization.entity.User;


    @com.kingnod.core.annotation.Generated("2012-02-02 11:10")
public interface UserService {

    
    @com.kingnod.core.annotation.Generated("2012-02-02 11:10")
    User getUser(Long id);

    
    @com.kingnod.core.annotation.Generated("2012-02-02 11:10")
    int saveUser(User user);

    
    @com.kingnod.core.annotation.Generated("2012-02-02 11:10")
    int deleteUser(User user);

    
    @com.kingnod.core.annotation.Generated("2012-02-02 11:10")
    int deleteUserByIds(Long[] ids);

    
    @com.kingnod.core.annotation.Generated("2012-02-02 11:10")
    PagingResult<User> findUser(Criteria criteria);
    
    public List<TreeNode> getObjectListByTree(Long nodeId, String nodeType, List<String> filterTypes);
    
    List<User> getUserBySiteId(Map<String,Object> map);
    
    /**
	 * 查询所有有读取权限的管理员用户
	 * @param criteria
	 * @return
	 */
	public List<User> findAllReadableAdministrator();
	
	List<User> findAllReadableAdministrator(Map<String,Object> map);
	
	/**
	 * 查询在线学习用户组信息
	 */
	public List<User> findNoSendNoticeEnrollByCriteria(Criteria criteria) ;

	/**
	 * 根据站点ID，获取要导出的用户列表
	 * @param siteId
	 * @return
	 */
	List<User> getUsersForExport(Long siteId);
	
	/**
	 * 判断当前用户是否被其他用户引用
	 * 
	 * @param userId
	 */
	public List<User> getUserManager(List<Long> userId);
}