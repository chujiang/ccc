package com.kingnod.etraining.organization.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.criteria.Order;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.entity.RecordStatus;
import com.kingnod.core.exception.ApplicationException;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.organization.dao.UserPropertiesDAO;
import com.kingnod.etraining.organization.dao.UserPropertyOptionDAO;
import com.kingnod.etraining.organization.entity.UserProperties;
import com.kingnod.etraining.organization.entity.UserPropertyOption;
import com.kingnod.etraining.organization.service.UserPropertiesService;
import com.kingnod.etraining.organization.service.UserPropertyOptionService;

@org.springframework.stereotype.Service
public class UserPropertiesServiceImpl implements UserPropertiesService, UserPropertyOptionService {

    @Autowired
    protected UserPropertiesDAO userPropertiesDAO;


    public UserProperties getUserProperties(Long id) {
        return userPropertiesDAO.get(id);
    }

    public int saveUserProperties(UserProperties userProperties) {
        int count = 0;
        IdEntity<Long> idEntity = (IdEntity<Long>)userProperties;
        if(null != idEntity.getId() && null != userPropertiesDAO.get(idEntity.getId())){
            count = userPropertiesDAO.update(userProperties);
        }else{
        	Integer sequence = userPropertiesDAO.findMaxBySequenceOne(userProperties);
			if(null == sequence) {
				sequence = 0;
			} else {
				sequence += 1;
			}
			 userProperties.setSeq(sequence);
        	int freePropertyNumber = this.getFreePropertyNumber(userProperties.getSiteId());
        	userProperties.setPropertyName("property" + String.valueOf(freePropertyNumber));
            count = userPropertiesDAO.insert(userProperties);
        }
        return count;
    }

    public int deleteUserProperties(UserProperties userProperties) {
        return userPropertiesDAO.delete(userProperties);
    }

    public int deleteUserPropertiesByIds(Long[] ids) {
        return userPropertiesDAO.deleteById(ids);
    }

    public PagingResult<UserProperties> findUserProperties(Criteria criteria) {
        return userPropertiesDAO.findPagingResult(criteria);
    }
 

    @Autowired
    protected UserPropertyOptionDAO userPropertyOptionDAO;


    public UserPropertyOption getUserPropertyOption(Long id) {
        return userPropertyOptionDAO.get(id);
    }

    public int saveUserPropertyOption(UserPropertyOption userPropertyOption) {
        int count = 0;
        IdEntity<Long> idEntity = (IdEntity<Long>)userPropertyOption;
        if(null != idEntity.getId() && null != userPropertyOptionDAO.get(idEntity.getId())){
            count = userPropertyOptionDAO.update(userPropertyOption);
        }else{
            count = userPropertyOptionDAO.insert(userPropertyOption);
        }
        return count;
    }

    public int deleteUserPropertyOption(UserPropertyOption userPropertyOption) {
        return userPropertyOptionDAO.delete(userPropertyOption);
    }

    public int deleteUserPropertyOptionByIds(Long[] ids) {
        return userPropertyOptionDAO.deleteById(ids);
    }

    public PagingResult<UserPropertyOption> findUserPropertyOption(Criteria criteria) {
        return userPropertyOptionDAO.findPagingResult(criteria);
    }

	public List<UserProperties> findListBySiteId(Long siteId) {
		CriteriaBuilder cb = Cnd.builder(UserProperties.class);
		cb.andEQ("siteId", siteId);
		cb.andEQ("recordStatus", RecordStatus.ACTIVE);
		cb.orderBy("seq", Order.ASC);
		return userPropertiesDAO.findByCriteria(cb.buildCriteria());
	}

	public int getFreePropertyNumber(Long siteId) throws ApplicationException {
		List<Integer> result = userPropertiesDAO.getNumberListByOrderPropertyNumber(siteId);
		for(int i = 0; i < 99; i ++){
			if(!result.contains(i)){
				return i;
			}
		}
		throw new ApplicationException("org.0000001");
	}
	
	/*
	 * 0 -- 上移+  1 -- 下移-   2 -- 至顶   3 -- 至尾
	 * (non-Javadoc)
	 * @see com.kingnod.etraining.organization.service.UserPropertiesService#movebleUserProperties(com.kingnod.etraining.organization.entity.UserProperties)
	 */
	public void movebleUserProperties(UserProperties userProperties) {
		String upOrDown = userProperties.getUpOrDown();
		Integer seq = userProperties.getSeq();
		UserProperties properties = null;
		List<UserProperties> userList = userPropertiesDAO.findBySequence(userProperties);
		if(null == userList || 0 == userList.size()) {
			return;
		}
		properties = userList.get(0);
		userProperties.setSeq(properties.getSeq());
		//至顶
		if("2".equals(upOrDown)) {
			userPropertiesDAO.update(userProperties);
			userProperties.setSeq(1);
			userProperties.setNewGroupSeq(seq);
			userPropertiesDAO.updateSequences(userProperties);
			return;
		}
		//至尾
		if("3".equals(upOrDown)) {
			userPropertiesDAO.update(userProperties);
			userProperties.setSeq(1);
			userProperties.setNewGroupSeq(seq);
			userPropertiesDAO.updateSequences(userProperties);
			return;
		}
		properties.setSeq(seq);
		userPropertiesDAO.update(properties);
		userPropertiesDAO.update(userProperties);
	}

}