package com.kingnod.etraining.common.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.criteria.Order;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.core.util.SecurityUtils;
import com.kingnod.core.util.SysParameterUtils;
import com.kingnod.core.util.web.WebContextHolder;
import com.kingnod.etraining.common.CommonConstant;
import com.kingnod.etraining.common.ObjectType;
import com.kingnod.etraining.common.dao.BulletinDAO;
import com.kingnod.etraining.common.entity.Bulletin;
import com.kingnod.etraining.common.service.BulletinService;
import com.kingnod.etraining.security.entity.UserAccount;

@org.springframework.stereotype.Service
public class BulletinServiceImpl implements BulletinService {

    @Autowired
    protected BulletinDAO bulletinDAO;


    public Bulletin getBulletin(Long id) {
        return bulletinDAO.get(id);
    }

    public int saveBulletin(Bulletin bulletin) {
        int count = 0;
        IdEntity<Long> idEntity = (IdEntity)bulletin;
        if(null != idEntity.getId() && null != bulletinDAO.get(idEntity.getId())){
            count = bulletinDAO.update(bulletin);
        }else{
            count = bulletinDAO.insert(bulletin);
        }
        return count;
    }

    public int deleteBulletin(Bulletin bulletin) {
        return bulletinDAO.delete(bulletin);
    }

    public int deleteBulletinByIds(Long[] ids) {
        return bulletinDAO.deleteById(ids);
    }

    public PagingResult<Bulletin> findBulletin(Criteria criteria) {
        return bulletinDAO.findPagingResult(criteria);
    }
    
    
    /**
     * 查询当前用户的公告
     */
    public List<Bulletin> BelongsToList(){
    	UserAccount userAccount = (UserAccount)SecurityUtils.getCurrentUser();
    	CriteriaBuilder cb = Cnd.builder(Bulletin.class);
    	if(userAccount.getAttribute("orgId")==null){
    		cb.addParam("objectId2", 0);
    	}else{
    		cb.addParam("objectId2", userAccount.getAttribute("orgId"));
    	}
    	cb.addParam("objectId", userAccount.getSiteId());
    	cb.addParam("objectType", ObjectType.O_OS);
    	cb.addParam("objectType2", ObjectType.O_OO);
		return bulletinDAO.findNewBulletin(cb.buildCriteria());
    	
    }
    
    /**
     * 查询课程公告
     */
    public List<Bulletin> elearningBulletin(Long objectId,ObjectType objectType){
    	 CriteriaBuilder cb = Cnd.builder(Bulletin.class);
    	 cb.addParam("objectId", objectId);
    	 cb.addParam("objectType", objectType);
		return bulletinDAO.findElearningBulletin(cb.buildCriteria());
    	
    }
    
    /**
     * 查询当前用户最新5条公告
     */
    public List<Bulletin> newBulletin(){
    	int numbers=Integer.valueOf(SysParameterUtils.getString(CommonConstant.BULLETIN_SELECT_NUMBERS));
    	UserAccount userAccount = (UserAccount)SecurityUtils.getCurrentUser();
    	CriteriaBuilder cb = Cnd.builder(Bulletin.class);
    	if(userAccount.getAttribute("orgId")==null){
    		cb.addParam("objectId2", 0);
    	}else{
    		cb.addParam("objectId2", userAccount.getAttribute("orgId"));
    	}
    	cb.addParam("objectId", userAccount.getSiteId());
    	cb.addParam("objectType", ObjectType.O_OS);
    	cb.addParam("objectType2", ObjectType.O_OO);
    	cb.addParam("numbers", numbers);
		return bulletinDAO.findNewBulletin(cb.buildCriteria());
    	
    }

	public PagingResult<Bulletin> findNewBulletinList(Criteria criteria) {
		return bulletinDAO.findNewBulletinList(criteria);
	}
}
