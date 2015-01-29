package com.kingnod.etraining.activity.dao;

import java.util.List;
import java.util.Map;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.dao.MybatisDaoSupport;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.core.util.collection.ListUtils;
import com.kingnod.core.util.collection.MapUtils;
import com.kingnod.etraining.activity.entity.Activity;
import com.kingnod.etraining.activity.entity.ActivityDetails;
import com.kingnod.etraining.activity.entity.ActivityDetailsKey;
import com.kingnod.etraining.common.ObjectType;

@org.springframework.stereotype.Repository
public class ActivityDetailsDAOImpl extends MybatisDaoSupport implements ActivityDetailsDAO {

	public int insert(ActivityDetails entity) {
		return getSqlSession().insert(sqlId(INSERT), entity);
	}

	public int insert(List<ActivityDetails> entities) {
		if (ListUtils.isNotEmpty(entities)) {
			for (Activity e : entities)
				getSqlSession().insert(sqlId(INSERT), e);
			return entities.size();
		}
		return 0;
	}

	public int update(ActivityDetails entity) {
		return getSqlSession().update(sqlId(UPDATE), entity);
	}

	public int updateByCriteria(ActivityDetails entity, Criteria criteria) {
		return getSqlSession().update(
				sqlId(UPDATE_BY_CRITERIA),
				MapUtils.mapByAarray(String.class, Object.class, "record", entity, "conditions",
						criteria.getConditions()));
	}

	public int delete(ActivityDetails... entities) {
		int count = 0;
		for (ActivityDetails e : entities) {
			getSqlSession().delete(sqlId(DELETE), e);
			count++;
		}
		return count;
	}

	public int deleteById(String activityType, Long... activityId) {
		int count = 0;
		for (Long id : activityId) {
			ActivityDetailsKey key = new ActivityDetailsKey();
			key.setType(activityType);
			key.setActivityId(id);
			getSqlSession().delete(sqlId(DELETE_BY_ID), key);
			count++;
		}
		return count;
	}

	public int deleteByCriteria(Criteria criteria) {
		return getSqlSession().delete(sqlId(DELETE_BY_CRITERIA), criteria);
	}

	public ActivityDetails get(ObjectType activityType, Long activityId) {
		ActivityDetailsKey key = new ActivityDetailsKey();
		key.setType(activityType.name());
		key.setActivityId(activityId);
		return (ActivityDetails) getSqlSession().selectOne(sqlId(FIND_BY_ID), key);
	}

	public List<ActivityDetails> findAll() {
		return getSqlSession().selectList(sqlId(FIND_BY_CRITERIA));
	}

	public List<ActivityDetails> findByCriteria(Criteria criteria) {
		return getSqlSession().selectList(sqlId(FIND_BY_CRITERIA), criteria);
	}

	public int countAll() {
		return countByCriteria(null);
	}

	public int countByCriteria(Criteria criteria) {
		return (Integer) getSqlSession().selectOne(sqlId(COUNT_BY_CRITERIA), criteria);
	}

	public PagingResult<ActivityDetails> findPagingResult(Criteria criteria) {
		return pagingQuery(sqlId(COUNT_BY_CRITERIA), sqlId(FIND_BY_CRITERIA), criteria);
	}

	public List<ActivityDetails> findByMap(Map parameter) {
		return getSqlSession().selectList(sqlId(FIND_BY_MAP), parameter);
	}

	protected String sqlId(String suffix) {
		return ActivityDetails.class.getSimpleName() + "." + suffix;
	}
}