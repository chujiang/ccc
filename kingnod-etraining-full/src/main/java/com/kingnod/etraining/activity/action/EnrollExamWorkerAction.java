package com.kingnod.etraining.activity.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.extensions.struts2.action.EntityAction;
import com.kingnod.core.extensions.struts2.action.FilterableEntityAction;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.core.util.StringUtils;
import com.kingnod.core.util.collection.ListUtils;
import com.kingnod.etraining.activity.entity.EnrollExamWorker;
import com.kingnod.etraining.activity.service.EnrollExamWorkerService;
import com.kingnod.etraining.activity.service.EnrollLearnerService;
import com.kingnod.etraining.common.ObjectType;

@org.springframework.stereotype.Controller
@Namespace("/aty")
@Results( 
{
@Result(name = EntityAction.RELOAD, type = "redirectAction", params = { "actionName", "enroll-exam-worker", "namespace", "/aty", "siteId", "${siteId}", "folderId", "${folderId}", "activityId", "${activityId}", "activityType", "${activityType}", "workType", "${workType}", "examinationId", "${activityId}"})
}
)

public class EnrollExamWorkerAction extends FilterableEntityAction<EnrollExamWorker, Long> {

    @Autowired
    private EnrollExamWorkerService enrollExamWorkerService;
    @Autowired
    private EnrollLearnerService enrollLearnerService;

    private Long siteId;
    private Long folderId;
    private Long activityId;
    private ObjectType activityType;
    private String workType;
    private String extparams;
    private String questionType;		//试题类型
    private String testGroupName;		//题纲
    private String markers;				//阅卷人
    private String auditors;			//审核人
    
    public String filterDefines() {
        return "aty.enrollExamWorkerFilterItems";
    }

    
    protected Object getEntityService() {
        return this.enrollExamWorkerService;
    }
    

    /**
     * 根据workType：I=监考员/M=阅卷员/A=审核员，取出不同的记录
     */
	@Override
	protected void afterPreparedCriteriaBuilder(CriteriaBuilder cb) {
//		cb.addParam("examinationId", activityId);
//		cb.andLike("workType", workType);
	}
	
	
	/**
	 * 保存
	 */
	@Override
	public String save() throws Exception {
		String users = request.getParameter("userId");
		String questions = request.getParameter("questionIds");
		if (null != users && null != questions) {
			List<Long> userIds = ListUtils.of(StringUtils.splitTo(users, ",", Long.class));
			List<Long> questionIds = ListUtils.of(StringUtils.splitTo(questions, ",", Long.class));
			enrollExamWorkerService.saveEnrollExamWorker(activityId, workType, userIds, questionIds);
		}
		return RELOAD;
	}
	
	
	/**
	 * 查询
	 */
	@Override
	public String list() throws Exception {
		CriteriaBuilder cb = Cnd.builder(EnrollExamWorker.class);
		cb.addParam("examinationId", activityId);
		if(StringUtils.isNotEmpty(questionType))
			cb.andEQ("eq.type", questionType);
		if(StringUtils.isNotEmpty(testGroupName))
			cb.andEQ("b.testGroupId", testGroupName);
		if(StringUtils.isNotEmpty(markers))
			cb.addParam("markers", markers);
		if(StringUtils.isNotEmpty(auditors))
			cb.addParam("auditors", auditors);
		PagingResult<EnrollExamWorker> pagingResult = enrollExamWorkerService.findByExaminationId(cb.buildCriteria());
		pager.setTotalCount(pagingResult.getTotalRows());
		pager.setResult(pagingResult.getResult());
		request.setAttribute("page", pager);
		
		String learnerIds = enrollLearnerService.getIdsByActivityId(String.valueOf(activityId));				//学员列表
		//学员不能为阅卷员、审核员，extparams为userPicker候选区中剔除的用户
		extparams = learnerIds;
		
		return SUCCESS;
	}


	public Long getSiteId() {
		return siteId;
	}


	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}


	public Long getFolderId() {
		return folderId;
	}


	public void setFolderId(Long folderId) {
		this.folderId = folderId;
	}


	public Long getActivityId() {
		return activityId;
	}


	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}


	public ObjectType getActivityType() {
		return activityType;
	}


	public void setActivityType(ObjectType activityType) {
		this.activityType = activityType;
	}


	public String getWorkType() {
		return workType;
	}


	public void setWorkType(String workType) {
		this.workType = workType;
	}


	public String getExtparams() {
		return extparams;
	}


	public void setExtparams(String extparams) {
		this.extparams = extparams;
	}


	public String getQuestionType() {
		return questionType;
	}


	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}


	public String getTestGroupName() {
		return testGroupName;
	}


	public void setTestGroupName(String testGroupName) {
		this.testGroupName = testGroupName;
	}


	public String getMarkers() {
		return markers;
	}


	public void setMarkers(String markers) {
		this.markers = markers;
	}


	public String getAuditors() {
		return auditors;
	}


	public void setAuditors(String auditors) {
		this.auditors = auditors;
	}
	
    
}