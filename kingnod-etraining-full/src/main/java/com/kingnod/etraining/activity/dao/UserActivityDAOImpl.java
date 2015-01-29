package com.kingnod.etraining.activity.dao;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.dao.MybatisEntityDAO;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.etraining.activity.entity.UserActivity;
import com.kingnod.etraining.activity.entity.UserActivitySummary;

@org.springframework.stereotype.Repository

    @com.kingnod.core.annotation.Generated("2012-03-13 18:40")
public class UserActivityDAOImpl extends MybatisEntityDAO<UserActivity, Long> implements UserActivityDAO {

	public PagingResult<UserActivitySummary> findUserActivitiesByCriteria(
			Criteria criteria) {
		return pagingQuery(sqlId("findUserActivitiesCount"),sqlId("findUserActivitiesByCriteria"),criteria);
	}
	
//根据课程分类查找活动
	public PagingResult<UserActivitySummary> findUserActivitiesByCriteriaCaegory(
      Criteria criteria) {
    return pagingQuery(sqlId("findActivitiesByCategoryCount"),sqlId("findActivitiesByCategoryCriteria"),criteria);
  }

	public int findUserActivitiesCount(Criteria criteria) {
		// TODO Auto-generated method stub
		return (Integer) getSqlSession().selectOne(sqlId("findUserActivitiesCount"), criteria);
	}
	
	/**
     * 根据活动Id获取UserActivity
     * @param activityId
     * @return UserActivity
     */
    public UserActivity getUserActivityByActId(Long actyId){
    	if(actyId != null && actyId.intValue() > 0){
    		Object obj = getSqlSession().selectOne("getUserActivityByActId",actyId);
        	if(obj != null && obj instanceof UserActivity){
        		return (UserActivity)obj;
        	}
    	}
    	return null;
    }

}