package com.kingnod.etraining.common.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.common.dao.RoleRefDAO;
import com.kingnod.etraining.common.entity.RoleRef;
import com.kingnod.etraining.common.service.RoleRefService;

@org.springframework.stereotype.Service
public class RoleRefServiceImpl implements RoleRefService {

    @Autowired
    protected RoleRefDAO roleRefDAO;


    public RoleRef getRoleRef(Long id) {
        return roleRefDAO.get(id);
    }

    public int saveRoleRef(RoleRef roleRef) {
        int count = 0;
        if(roleRef != null && roleRef.getId() != null && roleRefDAO.get(roleRef.getId()) != null){
        	count = roleRefDAO.update(roleRef);
        }else{
        	count = roleRefDAO.insert(roleRef);
        }
//        IdEntity<Long> idEntity = (IdEntity)roleRef;
//        if(null != idEntity.getId() && null != roleRefDAO.get(idEntity.getId())){
//            
//        }else{
//            count = roleRefDAO.insert(roleRef);
//        }
        return count;
    }

    /**
	 * 删除当前用户下所有的角色
	 * @param ownerId
	 */
	public void delRoleByUser(Long ownerId){
		roleRefDAO.delRoleByUser(ownerId);
	}
	
    public int deleteRoleRef(RoleRef roleRef) {
        return roleRefDAO.delete(roleRef);
    }

    public int deleteRoleRefByIds(Long[] ids) {
        return roleRefDAO.deleteById(ids);
    }

    public PagingResult<RoleRef> findRoleRef(Criteria criteria) {
        return roleRefDAO.findPagingResult(criteria);
    }
}