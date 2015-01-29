package com.kingnod.etraining.activity.dao.interceptor;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.extensions.mybatis.interceptor.AbstractInterceptor;
import com.kingnod.core.util.SpringUtils;
import com.kingnod.etraining.activity.dao.ActivityDetailsDAO;
import com.kingnod.etraining.activity.dao.UserActivityDAO;
import com.kingnod.etraining.activity.entity.ActivityDetails;
import com.kingnod.etraining.activity.entity.UserActivity;
import com.kingnod.etraining.common.ObjectType;
import com.kingnod.etraining.course.entity.Performance;

/**
 * 用户活动拦截器，当用户活动的记录有更新时，保存活动状态、分数、总时长、完成时间和进度至USER_ACTIVITY.
 * @author Chujiang
 *
 */
@Intercepts({ @Signature(type = Executor.class, method = "update", args = { MappedStatement.class, Object.class }) })
public class UserActivityHandlerInterceptor extends AbstractInterceptor {

	protected UserActivityDAO userActivityDAO;
	protected ActivityDetailsDAO activityDetailsDAO;

	static int MAPPED_STATEMENT_INDEX = 0;
	static int PARAMETER_INDEX = 1;

	public Object intercept(Invocation invocation) throws Throwable {
		Object[] queryArgs = invocation.getArgs();
		MappedStatement ms = (MappedStatement) queryArgs[MAPPED_STATEMENT_INDEX];
		Object entity = queryArgs[PARAMETER_INDEX];
		try {
			return invocation.proceed();
		}finally {
			if(!(entity instanceof ActivityDetails)){
				if(ms.getId().startsWith("Performance.")){
					handleSCOPerformance(ms, entity);
				}
			}
		}
	}

	private void handleSCOPerformance(MappedStatement ms, Object entity) {
		if (ms.getSqlCommandType() == SqlCommandType.INSERT) {
			Performance performance = (Performance)entity;
			UserActivity userActivity = new UserActivity();
			userActivity.setActivityId(performance.getActivityId());
			userActivity.setUserId(performance.getUserId());
			userActivity.setStatus(performance.getStatus());
			userActivity.setTotalTime(performance.getLessonTotalTime());
			userActivity.setScore(performance.getScore());
			userActivity.setCompletedDate(performance.getCompletedDate());
			userActivity.setProgressRate(performance.getCompletedPercentage());
			userActivityDAO.insert(userActivity);
		}else if(ms.getSqlCommandType() == SqlCommandType.UPDATE){
			Performance performance = (Performance)entity;
			
			CriteriaBuilder cb = Cnd.builder(UserActivity.class);
			cb.andEQ("userId", performance.getUserId()).andEQ("activityId", performance.getActivityId());
			
			
			
			UserActivity userActivity = new UserActivity();
			userActivity.setStatus(performance.getStatus());
			userActivity.setTotalTime(performance.getLessonTotalTime());
	    userActivity.setScore(performance.getScore());
	    userActivity.setCompletedDate(performance.getCompletedDate());
      userActivity.setProgressRate(performance.getCompletedPercentage());
			userActivityDAO.updateByCriteria(userActivity, cb.buildCriteria());
			
			 //设置完成人数,设置完成时间的时候 说明这个课程已经完成
      if (performance.getCompletedDate() != null) {
        Long activityId = performance.getActivityId();
        if (activityId != null) {
          ActivityDetails activityDetailsTemp = activityDetailsDAO.get(ObjectType.A_EL, activityId);
            Long completeNumber = activityDetailsTemp.getCompleteNumber();
            if (completeNumber == null) {
              completeNumber = 0l;
            }
            ActivityDetails activityDetails = new ActivityDetails();
            activityDetails.setActivityId(activityId);
            activityDetails.setCompleteNumber(completeNumber + 1);
            activityDetails.setType(ObjectType.A_EL);
            activityDetailsDAO.update(activityDetails);
          }
      }
		}else if(ms.getSqlCommandType() == SqlCommandType.DELETE){
			
		}
	}
	
	@Override
	protected void afterSetProperties() {
		super.afterSetProperties();
		userActivityDAO = SpringUtils.getBean(UserActivityDAO.class);
		activityDetailsDAO = SpringUtils.getBean(ActivityDetailsDAO.class);
	}

}
