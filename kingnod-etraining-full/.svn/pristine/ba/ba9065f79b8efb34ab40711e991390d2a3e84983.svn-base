package com.kingnod.etraining.course.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.lang.xwork.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.criteria.Order;
import com.kingnod.core.entity.IdEntity;
import com.kingnod.core.entity.RecordStatus;
import com.kingnod.core.exception.Exceptions;
import com.kingnod.core.pager.Pager;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.core.util.collection.ListUtils;
import com.kingnod.etraining.activity.dao.ActivityDetailsDAO;
import com.kingnod.etraining.activity.dao.ElearningDAO;
import com.kingnod.etraining.activity.entity.ActivityDetails;
import com.kingnod.etraining.activity.entity.Elearning;
import com.kingnod.etraining.activity.service.ElearningService;
import com.kingnod.etraining.common.ObjectType;
import com.kingnod.etraining.common.dao.ObjectRelationDAO;
import com.kingnod.etraining.common.entity.Attachment;
import com.kingnod.etraining.common.entity.ObjectRelation;
import com.kingnod.etraining.common.entity.Type;
import com.kingnod.etraining.common.service.AttachmentService;
import com.kingnod.etraining.course.CourseConstant;
import com.kingnod.etraining.course.dao.ContentServerDAO;
import com.kingnod.etraining.course.dao.CourseEvaluationDAO;
import com.kingnod.etraining.course.dao.CourseInfoDAO;
import com.kingnod.etraining.course.dao.CourseTypeDAO;
import com.kingnod.etraining.course.dao.ItemInfoDAO;
import com.kingnod.etraining.course.entity.ContentServer;
import com.kingnod.etraining.course.entity.CourseEvaluation;
import com.kingnod.etraining.course.entity.CourseInfo;
import com.kingnod.etraining.course.entity.CourseType;
import com.kingnod.etraining.course.entity.ItemInfo;
import com.kingnod.etraining.course.service.ContentServerService;
import com.kingnod.etraining.course.service.CourseEvaluationService;
import com.kingnod.etraining.course.service.CourseInfoService;
import com.kingnod.etraining.course.service.CourseTypeService;
import com.kingnod.etraining.course.service.ItemInfoService;

@org.springframework.stereotype.Service
public class CourseInfoServiceImpl implements CourseInfoService,
		ItemInfoService, CourseTypeService,
		ContentServerService,CourseEvaluationService {

	@Autowired
	protected CourseInfoDAO courseInfoDAO;
	@Autowired
	protected ItemInfoDAO itemInfoDAO;
	@Autowired
	protected CourseTypeDAO courseTypeDAO;
	@Autowired
	protected ContentServerDAO contentDAO;
	@Autowired
	protected ObjectRelationDAO objectRelationDAO;
	
	@Autowired
	protected AttachmentService attachmentService;
	@Autowired
	protected ElearningService elearningService;
	@Autowired
  protected ActivityDetailsDAO activityDetailsDAO;
	@Autowired
  protected ElearningDAO elearningDAO;

	public CourseInfo getCourseInfo(Long id) {
		CourseInfo courseInfo = courseInfoDAO.get(id);
		Criteria criteria = Cnd.builder(ObjectRelation.class).andEQ("object1Id", id).andEQ("object1Type", ObjectType.R_CO).buildCriteria();
		Collection<ObjectRelation> courseSystemCategories = objectRelationDAO.findByCriteria(criteria);
		courseInfo.setCourseSystemCategories(courseSystemCategories);
		return courseInfo;
	}
	
	
	public int updateCourseByCourseId(Long id,String status){
		CourseInfo courseInfo = courseInfoDAO.get(id);
		if(status.equals(CourseConstant.RELEASE_STATUS_P)){
			PagingResult<Elearning> pagingResult = elearningService.findElearningByCourseId(id, null);
			if(pagingResult.getResult().size()>0){
				throw Exceptions.createAppException("crs001024");
			}
		}
		if(null == courseInfo){
			throw Exceptions.createAppException("crs001023");
		}
		courseInfo.setReleaseStatus(status);
		return courseInfoDAO.update(courseInfo);
	}

	/**
	 * 获取ItemInfos数据
	 */
	public List<ItemInfo> getItemInfoList(Long courseId) {
		CriteriaBuilder siteCb = Cnd.builder(ItemInfo.class);
		siteCb.andEQ("courseId", courseId).andEQ("recordStatus",RecordStatus.ACTIVE);
		siteCb.orderBy("sequence", Order.ASC);
		List<ItemInfo> typelist = itemInfoDAO.findByCriteria(siteCb.buildCriteria());
		return typelist;
	}
	
	public int countByCriteria(Criteria criteria){
		return itemInfoDAO.countByCriteria(criteria);
	}

	public boolean getChildLevel(ItemInfo type) {
		boolean childExist = true;
		if (type.getChildLevel() == 0) {
			childExist = false;
		}
		return childExist;
	}

	/**
	 * 删除
	 * 
	 * @param id
	 */
	public void deleteItemInfo(Long id) {
		CriteriaBuilder orgCb2 = Cnd.builder(ItemInfo.class);// 删除子目录
		orgCb2.andEQ("itemParent", id);
		List<ItemInfo> itemInfolist = itemInfoDAO.findByCriteria(orgCb2
				.buildCriteria());
			for(ItemInfo itemInfo : itemInfolist){
				deleteItemInfo(itemInfo);
			}
			itemInfoDAO.deleteById(id);
	}

	public void deleteByCourseId(long courseid) {
		itemInfoDAO.deleteByCriteria(Cnd.builder(ItemInfo.class).andEQ("courseId", courseid).buildCriteria());
	}
	

	/**
	 * 修改
	 * 
	 * @param id
	 * @param typeName
	 * @return
	 */
	public void updateItemInfo(Long id, String itemTitle) {
		CriteriaBuilder orgCb2 = Cnd.builder(Type.class);
		orgCb2.andEQ("id", id).andEQ("recordStatus", "A");
		List<ItemInfo> typelist = itemInfoDAO.findByCriteria(orgCb2
				.buildCriteria());
		if (typelist != null && typelist.size() == 1
				&& StringUtils.isNotEmpty(itemTitle)) {
			ItemInfo itemInfo = typelist.get(0);
			itemInfo.setItemTitle(itemTitle);
			saveItemInfo(itemInfo);
		}
	}

	/**
	 * 修改
	 * 
	 * @param itemInfo
	 */
	public void updateItemInfo(ItemInfo itemInfo) {
		if (itemInfo != null && itemInfo.getId() != null) {
			itemInfoDAO.update(itemInfo);
		}
	}

	/**
	 * 拖拽节点，修改位置
	 * 
	 * @param typeId
	 * @param targetId
	 */
	public void updateSequence(Long typeId, Long targetId) {
		ItemInfo curType = itemInfoDAO.get(typeId);
		ItemInfo tarType = itemInfoDAO.get(targetId);
		if (curType != null && tarType != null) {
			Long cSequence = curType.getSequence();
			Long tSequence = tarType.getSequence();
			curType.setSequence(tSequence);
			curType.setItemParent(tarType.getItemParent());
			tarType.setSequence(cSequence);
			itemInfoDAO.update(curType);
			itemInfoDAO.update(tarType);
		}
	}

	public int saveCourseInfo(CourseInfo courseInfo) {
		int count = 0;
		IdEntity<Long> idEntity = (IdEntity) courseInfo;
		if (null != idEntity.getId()
				&& null != courseInfoDAO.get(idEntity.getId())) {
			count = courseInfoDAO.update(courseInfo);
			Criteria criteria = Cnd.builder(ObjectRelation.class).andEQ("object1Id", idEntity.getId()).andEQ("object1Type", ObjectType.R_CO).buildCriteria();
			objectRelationDAO.deleteByCriteria(criteria);
			//保存课程与课程体系类别的关系
			if(null != courseInfo.getCourseSystemCategories()){
				for(ObjectRelation objRelation:courseInfo.getCourseSystemCategories()){
					objRelation.setObject1Id(courseInfo.getId());
					objRelation.setObject1Type(ObjectType.R_CO);
					objRelation.setObject2Type(ObjectType.R_SF);
					objectRelationDAO.insert(objRelation);
				}
			}
		} else {
			count = courseInfoDAO.insert(courseInfo);
			//保存课程与课程体系类别的关系
			if(null != courseInfo.getCourseSystemCategories()){
				for(ObjectRelation objRelation:courseInfo.getCourseSystemCategories()){
					objRelation.setObject1Id(courseInfo.getId());
					objRelation.setObject1Type(ObjectType.R_CO);
					objRelation.setObject2Type(ObjectType.R_SF);
					objectRelationDAO.insert(objRelation);
				}
			}
		}
		if(count>0 && null != courseInfo.getAttachmentId())
		{	
			Attachment attachment = attachmentService.getAttachment(courseInfo.getAttachmentId());
			attachment.setStatus("A");
			attachmentService.saveAttachment(attachment);
		}
		
		
		return count;
	}

	public int deleteCourseInfo(CourseInfo courseInfo) {
		
		Attachment attachment = attachmentService.getAttachment(courseInfo.getAttachmentId());
		attachmentService.deleteAttachment(attachment);
		return courseInfoDAO.delete(courseInfo);
	}

	public int deleteCourseInfoByIds(Long[] ids) {
		List<Long> attachmentIds = new ArrayList<Long>();
		for(int i = 0; i < ids.length; i++ )
		{
			Long tmpAttaid = courseInfoDAO.get(ids[i]).getAttachmentId();
			if(null != tmpAttaid){
				attachmentIds.add(tmpAttaid);
			}
		}
		if(!ListUtils.isEmpty(attachmentIds)){
			attachmentService.deleteAttachmentByIds(attachmentIds.toArray(new Long[attachmentIds.size()]));
			attachmentService.removeAttachment(attachmentIds.toArray(new Long[attachmentIds.size()]));
		}
		return courseInfoDAO.deleteById(ids);
	}

	public PagingResult<CourseInfo> findCourseInfo(Criteria criteria) {
		return courseInfoDAO.findPagingResult(criteria);
	}
	
	public PagingResult<CourseInfo> findCourseInfoByCategory(Criteria criteria, Long categoryId, String category) {
		return courseInfoDAO.findPagingResultByCategory(criteria, categoryId, category);
	}

	public ItemInfo getItemInfo(Long id) {
		return itemInfoDAO.get(id);
	}

	public int saveItemInfo(ItemInfo itemInfo) {
		int count = 0;
		IdEntity<Long> idEntity = (IdEntity) itemInfo;
		if (null != idEntity.getId()
				&& null != itemInfoDAO.get(idEntity.getId())) {
			count = itemInfoDAO.update(itemInfo);
		} else {
			count = itemInfoDAO.insert(itemInfo);
		}
		return count;
	}

	public int deleteItemInfo(ItemInfo itemInfo) {
		return itemInfoDAO.delete(itemInfo);
	}

	public int deleteItemInfoByIds(Long[] ids) {
		return itemInfoDAO.deleteById(ids);
	}

	public PagingResult<ItemInfo> findItemInfo(Criteria criteria) {
		return itemInfoDAO.findPagingResult(criteria);
	}

	public CourseType getCourseType(Long id) {
		return courseTypeDAO.get(id);
	}

	public int saveCourseType(CourseType courseType) {
		int count = 0;
		IdEntity<Long> idEntity = (IdEntity) courseType;
		if (null != idEntity.getId()
				&& null != courseTypeDAO.get(idEntity.getId())) {
			count = courseTypeDAO.update(courseType);
		} else {
			count = courseTypeDAO.insert(courseType);
		}
		return count;
	}

	public int deleteCourseType(CourseType courseType) {
		return courseTypeDAO.delete(courseType);
	}

	public int deleteCourseTypeByIds(Long[] ids) {
		return courseTypeDAO.deleteById(ids);
	}

	public PagingResult<CourseType> findCourseType(Criteria criteria) {
		return courseTypeDAO.findPagingResult(criteria);
	}
	public ContentServer getContentServer(Long id) {
		// TODO Auto-generated method stub
		return contentDAO.get(id);
	}

	public int saveContentServer(ContentServer contentServer) {
		// TODO Auto-generated method stub
		int count = 0;
		IdEntity<Long> idEntity = (IdEntity) contentServer;
		if (null != idEntity.getId()
				&& null != contentDAO.get(idEntity.getId())) {
			count = contentDAO.update(contentServer);
		} else {
			CriteriaBuilder builder = Cnd.builder(ContentServer.class);
			builder.andEQ("name", contentServer.getName());
			PagingResult<ContentServer> findContentServer =findContentServer(builder.buildCriteria());
			if(findContentServer.getResult().size()>0){
				throw Exceptions.createAppException("crs001018");
			}
			count = contentDAO.insert(contentServer);
		}
		return count;
	}

	public int deleteContentServer(ContentServer contentServer) {
		// TODO Auto-generated method stub
		return contentDAO.delete(contentServer);
	}

	public int deleteContentServerByIds(Long[] ids) {
		// TODO Auto-generated method stub
		return contentDAO.deleteById(ids);
	}

	public PagingResult<ContentServer> findContentServer(Criteria criteria) {
		// TODO Auto-generated method stub
		return contentDAO.findPagingResult(criteria);
	}
	
  /**
   * 根据活动ID查找课程ID
   * @param acivityId
   * @return Long
   */
	public Long findCourseIdByAcivityId(Long acivityId){
    Long courseId =-1l;
    ActivityDetails activity = activityDetailsDAO.get(ObjectType.A_EL, acivityId);
    
    Elearning elearning = (Elearning)activity.getActivityObject();
    return null!=elearning?elearning.getCourseId():null;
  }

	@Autowired
	CourseEvaluationDAO courseEvaluationDAO; 

public CourseEvaluation getCourseEvaluation(Long id) {
	// TODO Auto-generated method stub
	return courseEvaluationDAO.get(id);
}


public int saveCourseEvaluation(CourseEvaluation courseEvaluation) {
	// TODO Auto-generated method stub
	int count = 0;
	IdEntity<Long> idEntity = (IdEntity) courseEvaluation;
	if (null != idEntity.getId()
			&& null != courseEvaluationDAO.get(idEntity.getId())) {
		count = courseEvaluationDAO.update(courseEvaluation);
	} else {
		count = courseEvaluationDAO.insert(courseEvaluation);
	}
	return count;
}


public int deleteCourseEvaluation(CourseEvaluation courseEvaluation) {
	// TODO Auto-generated method stub
	return courseEvaluationDAO.delete(courseEvaluation);
}


public int deleteCourseEvaluationByIds(Long[] ids) {
	// TODO Auto-generated method stub
	return courseEvaluationDAO.deleteById(ids);
}


public PagingResult<CourseEvaluation> findCourseEvaluation(Criteria criteria) {
	// TODO Auto-generated method stub
	return courseEvaluationDAO.findPagingResult(criteria);
}

public List<CourseEvaluation> getCourseEvaluations(Long courseId ,Pager<CourseEvaluation> page){
	CriteriaBuilder ceBuilder = Cnd.builder(CourseEvaluation.class);	
	ceBuilder.andEQ("courseId", courseId).orderBy("id", Order.DESC);
	page.setTotalCount(findCourseEvaluation(ceBuilder.buildCriteria()).getResult().size());
	Criteria criteria = ceBuilder.buildCriteria().limit(new Long(page.getFirst()),new Long(page.getLast()));
	return findCourseEvaluation(criteria).getResult();
}


public int getSumByCourseId(Long courseId) {
	// TODO Auto-generated method stub
	CriteriaBuilder ceBuilder = Cnd.builder(CourseEvaluation.class);	
	ceBuilder.andEQ("courseId", courseId);
	return courseEvaluationDAO.getSumByCourseId(ceBuilder.buildCriteria());
}
	
	
}