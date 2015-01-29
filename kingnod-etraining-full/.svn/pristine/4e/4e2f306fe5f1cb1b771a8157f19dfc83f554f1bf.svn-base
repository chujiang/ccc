package com.kingnod.etraining.common.dao;

import java.util.List;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.dao.MybatisEntityDAO;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.common.ObjectType;
import com.kingnod.etraining.common.entity.Bulletin;

@org.springframework.stereotype.Repository

    @com.kingnod.core.annotation.Generated("2012-04-21 11:11")
public class BulletinDAOImpl extends MybatisEntityDAO<Bulletin, Long> implements BulletinDAO {

	public List<Bulletin> findByReleaseCriteria(Criteria criteria) {
		return  getSqlSession().selectList("findByReleaseCriteria", criteria);
	}

	public List<Bulletin> findNewBulletin(Criteria criteria) {
		 return getSqlSession().selectList("findNewBulletin",criteria);
	}

	public List<Bulletin> findElearningBulletin(Criteria criteria) {
		return getSqlSession().selectList("findElearningBulletin",criteria);
	}

	public PagingResult<Bulletin> findNewBulletinList(Criteria criteria) {
		return pagingQuery(sqlId("countListByCriteria"), sqlId("findNewBulletin"), criteria);
	}


}