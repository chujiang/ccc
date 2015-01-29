package com.kingnod.etraining.common.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.common.dao.RoleDAO;
import com.kingnod.etraining.common.entity.Role;
import com.kingnod.etraining.common.service.RoleService;
import com.kingnod.etraining.security.PermisssionService;
import com.kingnod.etraining.security.dao.BitMappingDAO;
import com.kingnod.etraining.security.entity.BitMapping;

@org.springframework.stereotype.Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    protected RoleDAO roleDAO;
    @Autowired
    protected PermisssionService permisssionService;

    public Role getRole(Long id) {
        return roleDAO.get(id);
    }

    /**
     * 查找所有角色
     * @return List<Role>
     */
    public List<Role> getAllRole(){
    	return roleDAO.findAll();
    }
    
    /**
     * 根据站点Id查询角色
     */
    public List<Role> findRoleBySiteId(Map<String, Object> map){
    	List<Role> listRole = new ArrayList<Role>();
    	Object obj = map.get("siteId");
    	if(obj instanceof List){
    		List<Long> listSiteId = (List<Long>)obj;
    		for(Long siteId : listSiteId){
    			CriteriaBuilder siteCb = Cnd.builder(Role.class);
        		siteCb.andEQ("siteId", siteId);
        		if(map.get("name") != null){
        			siteCb.andLike("name", map.get("name").toString());
        		}
        		listRole.addAll(roleDAO.findByCriteria(siteCb.buildCriteria()));
    		}
    	}
		return listRole;
    }
	
    /**
     * 根据站点Id查询角色
     */
    public List<Role> findRoleBySiteId(Long siteId){
    	CriteriaBuilder siteCb = Cnd.builder(Role.class);
		siteCb.andEQ("siteId", siteId).andEQ("inheritAble",1);
		return roleDAO.findByCriteria(siteCb.buildCriteria());
    }
    
    /**
     * 根据用户Id查找对应的角色
     * @param userId
     * @return List<Role>
     */
    public List<Role> getRoleByUser(Long userId){
		return roleDAO.getRoleByUser(userId);
	}
    
    public int saveRole(Role role) {
        int count = 0;
        IdEntity<Long> idEntity = (IdEntity)role;
        if(null != idEntity.getId() && null != roleDAO.get(idEntity.getId())){
            count = roleDAO.update(role);
        }else{
            count = roleDAO.insert(role);
            permisssionService.saveBitMapping(BitMapping.USER_ROLE, role.getId());
        }
        return count;
    }

    public int deleteRole(Role role) {
        int result = roleDAO.delete(role);
        permisssionService.resetBitMapping(BitMapping.USER_ROLE, role.getId());
        return result;
    }

    public int deleteRoleByIds(Long[] ids) {
        int result = roleDAO.deleteById(ids);
        for(Long id:ids){
        	permisssionService.resetBitMapping(BitMapping.USER_ROLE, id);
        }
        return result;
    }

    public PagingResult<Role> findRole(Criteria criteria) {
        return roleDAO.findPagingResult(criteria);
    }
}