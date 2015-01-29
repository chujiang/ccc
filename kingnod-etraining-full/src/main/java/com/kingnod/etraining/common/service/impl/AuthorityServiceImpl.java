package com.kingnod.etraining.common.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.core.util.collection.MapUtils;
import com.kingnod.core.util.web.EL;
import com.kingnod.etraining.common.dao.AuthorityDAO;
import com.kingnod.etraining.common.entity.Authority;
import com.kingnod.etraining.common.entity.AuthorityRef;
import com.kingnod.etraining.common.entity.RoleAuthorityRef;
import com.kingnod.etraining.common.service.AuthorityService;
import com.kingnod.etraining.organization.entity.Function;

@org.springframework.stereotype.Service
public class AuthorityServiceImpl implements AuthorityService {

    @Autowired
    protected AuthorityDAO authorityDAO;


    public Authority getAuthority(Long id) {
        return authorityDAO.get(id);
    }
    
    /**
     * 根据角色获取权限
     */
    public List<AuthorityRef> getAuthorityID(Long id){
    	List<AuthorityRef> listAuthorityRef = new ArrayList<AuthorityRef>();
    	//查询当前角色下的权限
    	List<AuthorityRef> list = authorityDAO.findAuthorityById(id);
    	for (AuthorityRef object : list) {
			listAuthorityRef.add(object);
		}
    	return listAuthorityRef;
    }
    
    /**
     * 应用权限
     * @param roleId
     * @param authorityId
     */
    public void applicationAuthority(Long roleId,List<Long> authorityId){
    	//删除当前角色的所有权限
    	authorityDAO.deleteAuthorityRefByRoleId(roleId);
    	for (Long aId : authorityId) {
    		RoleAuthorityRef authorityRef = new RoleAuthorityRef(roleId,"R",aId);
    		authorityDAO.insertAuthorityRef(authorityRef);
		}
    }
    
    /**
	 * 获取function表中的一级功能菜单
	 * @return List<Function>
	 */
	public List<Function> findFunctionStair(String functionType){
		Map params = MapUtils.map("type",functionType);
		return authorityDAO.findFunctionStair(params);
	}
	
	/**
	 * 获取function表中的二级功能菜单
	 * @return
	 */
	public List<Function> findFunctionSecondary(Long id){
		EL el = EL.createWebContextEL();
		List<Function> listSecondary =  authorityDAO.findFunctionSecondary(id);
		for (Function function : listSecondary) {
			if (function.getUri() != null
					&& function.getUri().contains("${")) {
				function.setUri(el.executeExpression(function.getUri()));
			}
		}
		return listSecondary;
	}
	
	/**
	 * 根据function表中的二级功能菜单，获取该菜单下所有的权限
	 * @return
	 */
	public List<Authority> findFunctionAuthority(Long id){
		return authorityDAO.findFunctionAuthority(id);
	}
	
    /**
     * 查询所有的权限记录
     */
    public List<Authority> getAllAuthority(){     	
    	return authorityDAO.findAll();
    }
    
    public int saveAuthority(Authority authority) {
        int count = 0;
        IdEntity<Long> idEntity = (IdEntity)authority;
        if(null != idEntity.getId() && null != authorityDAO.get(idEntity.getId())){
            count = authorityDAO.update(authority);
        }else{
            count = authorityDAO.insert(authority);
        }
        return count;
    }

    public int deleteAuthority(Authority authority) {
        return authorityDAO.delete(authority);
    }

    public int deleteAuthorityByIds(Long[] ids) {
        return authorityDAO.deleteById(ids);
    }

    public PagingResult<Authority> findAuthority(Criteria criteria) {
        return authorityDAO.findPagingResult(criteria);
    }
}