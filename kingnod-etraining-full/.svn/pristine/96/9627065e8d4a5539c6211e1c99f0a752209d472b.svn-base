package com.kingnod.etraining.organization.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.organization.dao.FunctionDAO;
import com.kingnod.etraining.organization.entity.Function;
import com.kingnod.etraining.organization.service.FunctionService;

@org.springframework.stereotype.Service
public class FunctionServiceImpl implements FunctionService {

    @Autowired
    protected FunctionDAO functionDAO;


    public Function getFunction(Long id) {
        return functionDAO.get(id);
    }

    public int saveFunction(Function function) {
        int count = 0;
        IdEntity<Long> idEntity = (IdEntity)function;
        if(null != idEntity.getId() && null != functionDAO.get(idEntity.getId())){
            count = functionDAO.update(function);
        }else{
            count = functionDAO.insert(function);
        }
        return count;
    }

    public int deleteFunction(Function function) {
        return functionDAO.delete(function);
    }

    public int deleteFunctionByIds(Long[] ids) {
        return functionDAO.deleteById(ids);
    }

    public PagingResult<Function> findFunction(Criteria criteria) {
        return functionDAO.findPagingResult(criteria);
    }
}