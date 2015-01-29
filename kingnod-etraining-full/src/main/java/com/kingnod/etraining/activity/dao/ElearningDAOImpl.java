package com.kingnod.etraining.activity.dao;

import java.util.Date;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;
import net.sf.json.util.CycleDetectionStrategy;

import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.dao.MybatisEntityDAO;
import com.kingnod.core.entity.RecordStatus;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.core.util.DateUtils;
import com.kingnod.core.util.collection.ListUtils;
import com.kingnod.etraining.activity.entity.Activity;
import com.kingnod.etraining.activity.entity.ActivityDetails;
import com.kingnod.etraining.activity.entity.Elearning;
import com.kingnod.etraining.activity.entity.ElearningSituation;
import com.kingnod.etraining.common.ObjectType;
import com.kingnod.etraining.exam.ExamConstant;

@org.springframework.stereotype.Repository

    @com.kingnod.core.annotation.Generated("2012-03-13 18:54")
public class ElearningDAOImpl extends MybatisEntityDAO<Elearning, Long> implements ElearningDAO {
	
	@Autowired
	protected ActivityFolderDAO activityFolderDAO;
	@Autowired
	protected ActivityDetailsDAO activityDetailsDAO;
	
	@Override
	protected void afterInsert(Elearning entity) {
		CriteriaBuilder cb = Cnd.builder(Elearning.class);
		cb.andEQ("id", entity.getId());
		Criteria criteria = cb.buildCriteria();
		criteria.addParam("tableName", "ATY_ELEARNING");
		activityFolderDAO.updateObjectCount(criteria);
		
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
	}
	
	@Override
	protected void afterUpdate(Elearning entity) {
		if(null != entity.getId()){
			entity = get(entity.getId());
			ActivityDetails activityDetails = activityDetailsDAO.get(ObjectType.A_EL, entity.getId());
			activityDetails.setName(entity.getName());
			activityDetails.setActivityId(entity.getActivityId());
			activityDetails.setType(entity.getActivityType());
			activityDetails.setFolderId(entity.getFolderId());
			activityDetails.setReleaseStauts(entity.getReleaseStauts());
			activityDetails.setReleaseDate(entity.getReleaseDate());
			handleRecordStatus(activityDetails, entity);
			activityDetails.setObjectDetails(getObjectDetails(entity));
			activityDetailsDAO.update(activityDetails);
		}
	}
	
	@Override
	protected void afterDelete(Long... ids) {
		CriteriaBuilder cb = Cnd.builder(Elearning.class);
		cb.andIn("id", ListUtils.of(ids));
		Criteria criteria = cb.buildCriteria();
		criteria.addParam("tableName", "ATY_ELEARNING");
		activityFolderDAO.updateObjectCount(criteria);
		
		activityDetailsDAO.deleteById(ObjectType.A_EL.name(), ids);
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
	
	public PagingResult<ElearningSituation> findBySituation(Criteria criteria) {
		return pagingQuery(sqlId("countBySituation"), sqlId("findBySituation"), criteria);
	}


}