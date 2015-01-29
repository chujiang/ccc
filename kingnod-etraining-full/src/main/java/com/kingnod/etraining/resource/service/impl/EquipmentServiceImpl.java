package com.kingnod.etraining.resource.service.impl;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.resource.dao.EquipmentDAO;
import com.kingnod.etraining.resource.entity.Equipment;
import com.kingnod.etraining.resource.service.EquipmentService;

import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class EquipmentServiceImpl implements EquipmentService {

    @Autowired
    protected EquipmentDAO equipmentDAO;


    public Equipment getEquipment(Long id) {
        return equipmentDAO.get(id);
    }

    public int saveEquipment(Equipment equipment) {
        int count = 0;
        IdEntity<Long> idEntity = (IdEntity)equipment;
        if(null != idEntity.getId() && null != equipmentDAO.get(idEntity.getId())){
            count = equipmentDAO.update(equipment);
        }else{
            count = equipmentDAO.insert(equipment);
        }
        return count;
    }

    public int deleteEquipment(Equipment equipment) {
        return equipmentDAO.delete(equipment);
    }

    public int deleteEquipmentByIds(Long[] ids) {
        return equipmentDAO.deleteById(ids);
    }

    public PagingResult<Equipment> findEquipment(Criteria criteria) {
        return equipmentDAO.findPagingResult(criteria);
    }
}