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
import com.kingnod.etraining.activity.entity.Examination;
import com.kingnod.etraining.common.ObjectType;
import com.kingnod.etraining.exam.ExamConstant;

@org.springframework.stereotype.Repository
@com.kingnod.core.annotation.Generated("2012-04-10 16:03")
public class ExaminationDAOImpl extends MybatisEntityDAO<Examination, Long> implements ExaminationDAO {
	
	@Autowired
	protected ActivityFolderDAO activityFolderDAO;
	@Autowired
	protected ActivityDetailsDAO activityDetailsDAO;
	
	@Override
	protected void afterInsert(Examination entity) {
		CriteriaBuilder cb = Cnd.builder(Examination.class);
		cb.andEQ("id", entity.getId());
		Criteria criteria = cb.buildCriteria();
		criteria.addParam("tableName", "ATY_EXAMINATION");
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
	protected void afterUpdate(Examination entity) {
		if(null != entity.getId()){
			entity = get(entity.getId());
			ActivityDetails activityDetails = activityDetailsDAO.get(ObjectType.A_XN, entity.getId());
			activityDetails.setName(entity.getName());
			activityDetails.setActivityId(entity.getActivityId());
			activityDetails.setType(entity.getActivityType());
			activityDetails.setFolderId(entity.getFolderId());
			handleRecordStatus(activityDetails, entity);
			activityDetails.setObjectDetails(getObjectDetails(entity));
			activityDetailsDAO.update(activityDetails);
		}
	}
	
	@Override
	protected void afterDelete(Long... ids) {
		CriteriaBuilder cb = Cnd.builder(Examination.class);
		cb.andIn("id", ListUtils.of(ids));
		Criteria criteria = cb.buildCriteria();
		criteria.addParam("tableName", "ATY_EXAMINATION");
		activityFolderDAO.updateObjectCount(criteria);
		
		activityDetailsDAO.deleteById(ObjectType.A_XM.name(), ids);
	}

	@SuppressWarnings("unchecked")
	public PagingResult<Examination> findUserByExamination(Criteria criteria) {
		return pagingQuery(sqlId(COUNT_BY_CRITERIA),sqlId("findUserByExaminationInfo"),criteria);
	}

	/**
	 * 查询文件夹名称
	 */
	public String findFolderName(Long folderId) {
		return (String) getSqlSession().selectOne(ExamConstant.FINDFOLDERNAME_EXAMINATION, folderId);
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
	
	/**
	 * findExaminationById
	 * @param examId
	 * @return Examination
	 */
	public Examination findExaminationById(Long examId){
		return (Examination) getSqlSession().selectOne(ExamConstant.FINDEXAMINATIONBYID,examId);
	}

	public PagingResult<Examination> findAlreadyExamByUserId(Criteria criteria) {
		return pagingQuery("countAlreadyExamByUserId", "findAlreadyExamByUserId", criteria);
	}
	
	/**
	 * 获取可以阅卷的考试活动ID
	 * @param map
	 * @return Examination
	 */
	public PagingResult<Examination> findAuswertungExamination(Criteria criteria){
		return pagingQuery(sqlId("countAuswertungExaminationByCriteria"),sqlId("findAuswertungExaminationByCriteria"),criteria);
	}

	/**
	 * 根据考试ids获取已发布考试的数量，如果存在已发布考试，则无法删除
	 */
	public int countPublishedByIds(String ids) {
		return (Integer) getSqlSession().selectOne("countPublishedByIds", ids);
	}
	
}