package com.kingnod.etraining.activity.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.activity.dao.WorkFlowApprovalDAO;
import com.kingnod.etraining.activity.entity.WorkFlowApproval;
import com.kingnod.etraining.activity.service.WorkFlowApprovalService;

@org.springframework.stereotype.Service
public class WorkFlowApprovalServiceImpl implements WorkFlowApprovalService {

    @Autowired
    protected WorkFlowApprovalDAO workFlowApprovalDAO;


    public WorkFlowApproval getWorkFlowApproval(Long id) {
        return workFlowApprovalDAO.get(id);
    }

    public int saveWorkFlowApproval(WorkFlowApproval workFlowApproval) {
        int count = 0;
        IdEntity<Long> idEntity = (IdEntity)workFlowApproval;
        if(null != idEntity.getId() && null != workFlowApprovalDAO.get(idEntity.getId())){
            count = workFlowApprovalDAO.update(workFlowApproval);
        }else{
            count = workFlowApprovalDAO.insert(workFlowApproval);
        }
        return count;
    }

    public int deleteWorkFlowApproval(WorkFlowApproval workFlowApproval) {
        return workFlowApprovalDAO.delete(workFlowApproval);
    }

    public int deleteWorkFlowApprovalByIds(Long[] ids) {
        return workFlowApprovalDAO.deleteById(ids);
    }

    public PagingResult<WorkFlowApproval> findWorkFlowApproval(Criteria criteria) {
        return workFlowApprovalDAO.findPagingResult(criteria);
    }
    
    public List<WorkFlowApproval> workFlowApprovalList(String id){
    	CriteriaBuilder cb = Cnd.builder(WorkFlowApproval.class);
    	cb.andEQ("workflowId", id);
		List<WorkFlowApproval> workFlowApprovalList = workFlowApprovalDAO.findByCriteria(cb.buildCriteria());
		return workFlowApprovalList;
    }
}
