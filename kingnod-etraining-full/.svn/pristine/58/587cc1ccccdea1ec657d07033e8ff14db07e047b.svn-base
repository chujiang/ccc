package com.kingnod.etraining.course.server.models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.core.util.StringUtils;
import com.kingnod.etraining.activity.entity.ActivityDetails;
import com.kingnod.etraining.activity.entity.Elearning;
import com.kingnod.etraining.activity.entity.EnrollLearner;
import com.kingnod.etraining.activity.entity.ItemInfoPerformance;
import com.kingnod.etraining.activity.entity.UserActivity;
import com.kingnod.etraining.activity.service.ActivityService;
import com.kingnod.etraining.activity.service.ElearningService;
import com.kingnod.etraining.activity.service.EnrollLearnerService;
import com.kingnod.etraining.activity.service.UserActivityService;
import com.kingnod.etraining.common.ObjectType;
import com.kingnod.etraining.common.entity.ObjectRelation;
import com.kingnod.etraining.common.entity.Type;
import com.kingnod.etraining.common.service.AttachmentService;
import com.kingnod.etraining.common.service.ObjectRelationService;
import com.kingnod.etraining.common.service.TypeService;
import com.kingnod.etraining.course.CourseConstant;
import com.kingnod.etraining.course.entity.CourseInfo;
import com.kingnod.etraining.course.service.CourseEvaluationService;
import com.kingnod.etraining.course.service.CourseInfoService;
import com.kingnod.etraining.course.service.ItemInfoService;
import com.kingnod.etraining.course.service.SCOPerformanceService;
import com.kingnod.etraining.resource.service.TrainerService;
import com.kingnod.etraining.security.entity.UserAccount;

@Component
public class FindAtyCourse {
	@Autowired
	ActivityService activityService;
	@Autowired
	ElearningService elearningService;
	@Autowired
	CourseInfoService courseInfoService;
	@Autowired
	ObjectRelationService objectRelationService;
	@Autowired
	ItemInfoService itemInfoService;
	@Autowired
	TrainerService trainerService;
	@Autowired
	SCOPerformanceService scoPerformanceService;
	@Autowired
	TypeService typeService;
	@Autowired
	CourseEvaluationService courseEvaluationService;
	@Autowired
	EnrollLearnerService enrollLearnerService;
	@Autowired
	UserActivityService userActivityService;
	@Autowired
	AttachmentService attachmentService;
	
	public  void findAtyCourseByAtyID(UserAccount userDetails,Long id ,ObjectType aType,AtyCourseInfo atyCourseInfo){
		Long elearnId = -1L;
		  Long userId = userDetails.getId() == null ? -1L : userDetails.getId();
		  Long siteId = userDetails.getSiteId() == null ? -1L : userDetails.getSiteId();
		  ObjectType type = null;
		  Long courseId = -1L;
		  atyCourseInfo.setItems(new ArrayList<ItemInfoPerformance>());
		  StringBuilder sortName = new StringBuilder();
		  CriteriaBuilder builder = Cnd.builder(ActivityDetails.class);
		  builder.andEQ("activityId", id).andEQ("type", aType);
//			PagingResult<Activity> findActivity = activityService.findActivity(activityCriteriaBuilder.buildCriteria());
			List<ActivityDetails> findActivityByCriteria = activityService.findActivityByCriteria(builder.buildCriteria());
			for(ActivityDetails activity : findActivityByCriteria){
				elearnId = activity.getActivityId();
				type = activity.getType();
				if(type.equals(ObjectType.A_EL)){
					Elearning activityObject = (Elearning)activity.getActivityObject();
					atyCourseInfo.setTrainerName(activityObject.getTrainerName());
					atyCourseInfo.setHour(activityObject.getLessons());
					courseId = activityObject.getCourseId();
					atyCourseInfo.setCourseId(courseId);
				}
				atyCourseInfo.setCompleteNumber(activity.getCompleteNumber());
				atyCourseInfo.setOnLineNumber(activity.getOnlineNumber());
				atyCourseInfo.setGrade(activity.getGrade()==null?0:activity.getGrade().intValue());
			}
			atyCourseInfo.setActivityId(id);
			
			if(courseId != -1L){
				CriteriaBuilder cbuilder = Cnd.builder(CourseInfo.class);
				cbuilder.andEQ("id", courseId);
				PagingResult<CourseInfo> findCourseInfo = courseInfoService.findCourseInfo(cbuilder.buildCriteria());
				for(CourseInfo courseInfo : findCourseInfo.getResult()){
					atyCourseInfo.setAuthor(courseInfo.getAuthor());
					atyCourseInfo.setDescription(courseInfo.getDescription());
					atyCourseInfo.setCourseName(courseInfo.getCourseTitle());
					atyCourseInfo.setCourseImgPath(attachmentService.getAttachmentUrl(courseInfo.getAttachmentId()));
					CriteriaBuilder obuilder = Cnd.builder(ObjectRelation.class);
					obuilder.andEQ("object1Id", courseId).andEQ("object1Type", "R_CO");
					List<String> findObjectRelationByCriteria = objectRelationService.findObjectRelationByCriteria(obuilder.buildCriteria());
					for(String objName : findObjectRelationByCriteria){
						if(null != objName){
						sortName.append(objName).append(" | ");
						}
					}
					if(null != sortName && !"".equals(sortName.toString())){
						atyCourseInfo.setSortName(sortName.toString().substring(0, sortName.toString().lastIndexOf("|")-1));
					}else{
						atyCourseInfo.setSortName("");
					}
				}
//				List<ItemInfo> itemInfoList = itemInfoService.getItemInfoList(courseId);
//					List<SCOPerformance> scoPerformanceList = scoPerformanceService.getSCOPerformanceList(courseId, userId);
//					String status = "";
//					Long time = -1L;
//					for(SCOPerformance sf : scoPerformanceList){
//						if(sf.getStatus().equals(CourseConstant.COURSESTATUS_COMPLETED)
//								||sf.getStatus().equals(CourseConstant.COURSESTATUS_PASSED)
//								||status.equals("")
//								||status.equals(CourseConstant.COURSESTATUS_COMPLETED)
//								||status.equals(CourseConstant.COURSESTATUS_PASSED)){
//							status = CourseConstant.COURSESTATUS_COMPLETED;
//						}else if(sf.getStatus().equals(CourseConstant.COURSESTATUS_INCOMPLETE)){
//							status = CourseConstant.COURSESTATUS_INCOMPLETE;
//							return;
//						}else if ((sf.getStatus().equals(CourseConstant.COURSESTATUS_FAILED)
//								||status.equals("")
//								||status.equals(CourseConstant.COURSESTATUS_COMPLETED)
//								||status.equals(CourseConstant.COURSESTATUS_PASSED)
//								||status.equals(CourseConstant.COURSESTATUS_FAILED))
//								&& !status.equals(CourseConstant.COURSESTATUS_INCOMPLETE) ){
//							status = CourseConstant.COURSESTATUS_FAILED;
//						}else if(sf.getStatus().equals(CourseConstant.COURSESTATUS_NOTATTEMPTED)
//								&&status.equals(CourseConstant.COURSESTATUS_NOTATTEMPTED)){
//							status = CourseConstant.COURSESTATUS_NOTATTEMPTED;
//						}else{
//							status = CourseConstant.COURSESTATUS_NOTATTEMPTED;
//						}
//						time += sf.getTotalTime();
//					}
//					atyCourseInfo.setCourseStatus(scoPerformanceService.getStatusMsg(status.equals("")?CourseConstant.COURSESTATUS_NOTATTEMPTED:status));
//					atyCourseInfo.setCourseLearnTime(com.kingnod.etraining.course.utils.TimeUtil.secToHHMMSS(time.intValue()));
//					atyCourseInfo.setLength(itemInfoList.size());
				String status = "";
				Long time = 0L;
				CriteriaBuilder ebuilder = Cnd.builder(EnrollLearner.class);
				ebuilder.andEQ("userId", userId).andEQ("activityId", id);
				PagingResult<UserActivity> findUserActivity = userActivityService.findUserActivity(ebuilder.buildCriteria());
				
				for(UserActivity ua : findUserActivity.getResult()){
					status = ua.getStatus();
					time = ua.getTotalTime();
				}
				atyCourseInfo.setCourseStatus(scoPerformanceService.getStatusMsg(StringUtils.isEmpty(status)?CourseConstant.COURSESTATUS_NOTATTEMPTED:status));
				atyCourseInfo.setCourseLearnTime(com.kingnod.etraining.course.utils.TimeUtil.secToHHMMSS(time==null?0:time));
					CriteriaBuilder typeBuilder = Cnd.builder(Type.class);
					typeBuilder.andEQ("parentId", CourseConstant.EVALUATION_TYPE_PARENT);
					Criteria criteria = typeBuilder.buildCriteria();
					criteria.addParam("visibleInherited", true).addParam("siteId", siteId);
					atyCourseInfo.setTypes(typeService.findType(criteria).getResult());
					atyCourseInfo.setCount(courseEvaluationService.getSumByCourseId(courseId));
					
			}
			
	}
	/**
	 * @author maxudong
	 * @since 由于活的需要发通知，故引用现有学员界面方法，由于学员界面课程信息一部分与登陆用户挂钩，
	 *        一部分不需要，而通知信息不需要用户信息，故引用原来方法而去掉用户信息部分
	 */
	public AtyCourseInfo findAtyCourseByAtyIdNoUser(Long id, ObjectType aType) {
		AtyCourseInfo atyCourseInfo = new AtyCourseInfo();
		Long elearnId = -1L;
		ObjectType type = null;
		Long courseId = -1L;
		atyCourseInfo.setItems(new ArrayList<ItemInfoPerformance>());
		StringBuilder sortName = new StringBuilder();
		CriteriaBuilder builder = Cnd.builder(ActivityDetails.class);
		builder.andEQ("activityId", id).andEQ("type", aType);
		// PagingResult<Activity> findActivity =
		// activityService.findActivity(activityCriteriaBuilder.buildCriteria());
		List<ActivityDetails> findActivityByCriteria = activityService.findActivityByCriteria(builder.buildCriteria());
		for (ActivityDetails activity : findActivityByCriteria) {
			elearnId = activity.getActivityId();
			type = activity.getType();
			if (type.equals(ObjectType.A_EL)) {
				Elearning activityObject = (Elearning) activity.getActivityObject();
				atyCourseInfo.setTrainerName(activityObject.getTrainerName());
				atyCourseInfo.setHour(activityObject.getLessons());
				courseId = activityObject.getCourseId();
				atyCourseInfo.setCourseId(courseId);
			}
			atyCourseInfo.setCompleteNumber(activity.getCompleteNumber());
			atyCourseInfo.setOnLineNumber(activity.getOnlineNumber());
			atyCourseInfo.setGrade(activity.getGrade() == null ? 0 : activity.getGrade().intValue());
		}
		atyCourseInfo.setActivityId(id);

		if (courseId != -1L) {
			CriteriaBuilder cbuilder = Cnd.builder(CourseInfo.class);
			cbuilder.andEQ("id", courseId);
			PagingResult<CourseInfo> findCourseInfo = courseInfoService.findCourseInfo(cbuilder.buildCriteria());
			for (CourseInfo courseInfo : findCourseInfo.getResult()) {
				atyCourseInfo.setAuthor(courseInfo.getAuthor());
				atyCourseInfo.setDescription(courseInfo.getDescription());
				atyCourseInfo.setCourseName(courseInfo.getCourseTitle());
				CriteriaBuilder obuilder = Cnd.builder(ObjectRelation.class);
				obuilder.andEQ("object1Id", courseId).andEQ("object1Type", "R_CO");
				List<String> findObjectRelationByCriteria = objectRelationService.findObjectRelationByCriteria(obuilder.buildCriteria());
				for (String objName : findObjectRelationByCriteria) {
					if (null != objName) {
						sortName.append(objName).append(" | ");
					}
				}
				if (null != sortName && !"".equals(sortName.toString())) {
					atyCourseInfo.setSortName(sortName.toString().substring(0, sortName.toString().lastIndexOf("|") - 1));
				} else {
					atyCourseInfo.setSortName("");
				}
			}
		}
		return atyCourseInfo;
	}
//	/**
//	 * 判断是强制还是自愿，还是审批。
//	 *in参数 activityId 活动id  
// 	 *in参数 userId 用户id
//	 *in参数 f注册类型
//	 *out参数 isObligatory 是否是相应的注册类型
//	 *out参数 isStatus 是否已注册
//	 * return boolean
//	 */
//	public void isObligatory(Long activityId,UserAccount userDetails,String f,boolean isObligatory,boolean isStatus){
//		CriteriaBuilder builder = Cnd.builder(EnrollLearner.class);
//		builder.andEQ("activityId", activityId).andEQ("userId", userDetails.getId() == null ? -1L : userDetails.getId());
//		PagingResult<EnrollLearner> findEnrollLearner = enrollLearnerService.findEnrollLearner(builder.buildCriteria());
//		for(EnrollLearner enrollLearner : findEnrollLearner.getResult()){
//			isObligatory = enrollLearner.getEnrollMode().equals(f);
//			isStatus = enrollLearner.getStauts().equals(ActivityConstant.ENROLL_STATUS_R);
//		}
//	}
	
	/**
	 * 判断是强制还是自愿，还是审批。
	 *in参数 activityId 活动id  
 	 *in参数 userId 用户id
	 *in参数 f注册类型
	 *out参数 isObligatory 是否是相应的注册类型
	 *out参数 isStatus 是否已注册
	 * return boolean
	 */
	public EnrollLearner getEnrollLearner(Long activityId,UserAccount userDetails){
		EnrollLearner eler = null;
		CriteriaBuilder builder = Cnd.builder(EnrollLearner.class);
		builder.andEQ("activityId", activityId).andEQ("userId", userDetails.getId() == null ? -1L : userDetails.getId()).andEQ("activityType", ObjectType.A_EL);
		PagingResult<EnrollLearner> findEnrollLearner = enrollLearnerService.findEnrollLearner(builder.buildCriteria());
		for(EnrollLearner enrollLearner : findEnrollLearner.getResult()){
			eler = enrollLearner;
		}
		return eler;
	}
}
