package com.kingnod.etraining.activity.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.activity.ActivityConstant;
import com.kingnod.etraining.activity.dao.WokflowBusinessDAO;
import com.kingnod.etraining.activity.entity.WokflowBusiness;
import com.kingnod.etraining.activity.service.WokflowBusinessService;

@org.springframework.stereotype.Service
public class WokflowBusinessServiceImpl implements WokflowBusinessService {

    @Autowired
    protected WokflowBusinessDAO wokflowBusinessDAO;


    public WokflowBusiness getWokflowBusiness(Long id) {
        return wokflowBusinessDAO.get(id);
    }

    public int saveWokflowBusiness(WokflowBusiness wokflowBusiness) {
        int count = 0;
        IdEntity<Long> idEntity = (IdEntity)wokflowBusiness;
        if(null != idEntity.getId() && null != wokflowBusinessDAO.get(idEntity.getId())){
            count = wokflowBusinessDAO.update(wokflowBusiness);
        }else{
            count = wokflowBusinessDAO.insert(wokflowBusiness);
        }
        return count;
    }

    public int deleteWokflowBusiness(WokflowBusiness wokflowBusiness) {
        return wokflowBusinessDAO.delete(wokflowBusiness);
    }

    public int deleteWokflowBusinessByIds(Long[] ids) {
        return wokflowBusinessDAO.deleteById(ids);
    }

    public PagingResult<WokflowBusiness> findWokflowBusiness(Criteria criteria) {
        return wokflowBusinessDAO.findPagingResult(criteria);
    }
    
    public Long getBusinessid(String processInstanceId){
    	CriteriaBuilder cb = Cnd.builder(WokflowBusiness.class);
		cb.andEQ("workflowId", processInstanceId).andEQ("businessType", ActivityConstant.WORK_FLOW_TYPE);
		List<WokflowBusiness> wokflowBusinessList=wokflowBusinessDAO.findByCriteria(cb.buildCriteria());
		return Long.valueOf(wokflowBusinessList.get(0).getBusinessId());
    }
}
