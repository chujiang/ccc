package com.kingnod.etraining.activity.dao.interceptor;

import java.util.Date;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;
import net.sf.json.util.CycleDetectionStrategy;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;

import com.kingnod.core.entity.RecordStatus;
import com.kingnod.core.extensions.mybatis.interceptor.AbstractInterceptor;
import com.kingnod.core.util.DateUtils;
import com.kingnod.core.util.SpringUtils;
import com.kingnod.etraining.activity.dao.ActivityDetailsDAO;
import com.kingnod.etraining.activity.entity.Activity;
import com.kingnod.etraining.activity.entity.ActivityDetails;
import com.kingnod.etraining.activity.entity.Elearning;
import com.kingnod.etraining.common.ObjectType;
import com.kingnod.etraining.exam.ExamConstant;

@Intercepts({ @Signature(type = Executor.class, method = "update", args = { MappedStatement.class, Object.class }) })
public class ActivityHandlerInterceptor extends AbstractInterceptor  {
	
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
				if(ms.getId().startsWith("Elearning.")){
					handleActivity(ms, entity, ObjectType.A_EL);
				}else if(ms.getId().startsWith("Examination.")){
					handleActivity(ms, entity, ObjectType.A_XN);
				}
			}
		}
	}
	
	private void handleActivity(MappedStatement ms, Object entity, ObjectType activityType){
		if (ms.getSqlCommandType() == SqlCommandType.INSERT) {
			Activity activity = (Activity)entity;
			ActivityDetails activityDetails = new ActivityDetails();
			activityDetails.setName(activity.getName());
			activityDetails.setActivityId(activity.getActivityId());
			activityDetails.setType(activity.getActivityType());
			activityDetails.setFolderId(activity.getFolderId());
			handleRecordStatus(activityDetails, entity);
			activityDetails.setObjectDetails(getObjectDetails(entity));
			activityDetails.setReleaseStauts(ExamConstant.STATUS_P);
			activityDetailsDAO.insert(activityDetails);
		}else if(ms.getSqlCommandType() == SqlCommandType.UPDATE && entity instanceof Elearning){
		  Elearning activity = (Elearning)entity;
			ActivityDetails activityDetails = new ActivityDetails();
			activityDetails.setName(activity.getName());
			activityDetails.setActivityId(activity.getActivityId());
			activityDetails.setType(activity.getActivityType());
			activityDetails.setFolderId(activity.getFolderId());
			activityDetails.setReleaseStauts(activity.getReleaseStauts());
			activityDetails.setReleaseDate(activity.getReleaseDate());
			handleRecordStatus(activityDetails, entity);
			activityDetails.setObjectDetails(getObjectDetails(entity));
			activityDetailsDAO.update(activityDetails);
		}else if(ms.getSqlCommandType() == SqlCommandType.DELETE){
			Long activityId = (Long)entity;
			activityDetailsDAO.deleteById(activityType.name(), activityId);
		}
	}
	
	protected String getObjectDetails(Object entity){
		JsonConfig config = new JsonConfig();   
		config.setIgnoreDefaultExcludes(false);      
		config.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);    
		config.registerJsonValueProcessor(Date.class, new JsonValueProcessor(){
			public Object processArrayValue(Object value, JsonConfig jsonConfig) {
				return null;
			}
			public Object processObjectValue(String key, Object value, JsonConfig jsonConfig) {
				return DateUtils.format((Date)value, "yyyy-MM-dd HH:mm:ss.SSS");
			}
			});
		config.setExcludes(new String[]{//只要设置这个数组，指定过滤哪些字段。   
		  "activityObject",   
		  "activityClass",
		  "recordStatus",
		  "id",
		  "createDate",
		  "creatorId",
		  "updateDate",
		  "updaterId",
		  "updateCount",
		  "periods"
		});
		JSONObject objectDetails = JSONObject.fromObject(entity, config);
		return objectDetails.toString();
	}
	
	protected void handleRecordStatus(ActivityDetails activityDetails, Object entity){
		if (entity instanceof RecordStatus) {
			RecordStatus<Long> recordStatus = (RecordStatus<Long>) entity;
			activityDetails.setRecordStatus(recordStatus.getRecordStatus());
			activityDetails.setCreateDate(recordStatus.getCreateDate());
			activityDetails.setCreatorId(recordStatus.getCreatorId());
			activityDetails.setUpdateDate(recordStatus.getUpdateDate());
			activityDetails.setUpdaterId(recordStatus.getUpdaterId());
			activityDetails.setUpdateCount(recordStatus.getUpdateCount());
		}
	}
	
	@Override
	protected void afterSetProperties() {
		super.afterSetProperties();
		activityDetailsDAO = SpringUtils.getBean(ActivityDetailsDAO.class);
	}

}
