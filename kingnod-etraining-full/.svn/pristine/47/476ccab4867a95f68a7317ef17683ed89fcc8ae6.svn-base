package com.kingnod.etraining.activity.action;

import java.util.Map;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.extensions.struts2.action.EntityAction;
import com.kingnod.core.extensions.struts2.action.FilterableEntityAction;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.core.util.StringUtils;
import com.kingnod.core.util.collection.ListUtils;
import com.kingnod.etraining.activity.entity.EnrollLearner;
import com.kingnod.etraining.activity.service.EnrollLearnerService;
import com.kingnod.etraining.common.ObjectType;

@org.springframework.stereotype.Controller
@Namespace("/aty")
@Results( 
{
@Result(name = EntityAction.RELOAD, type = "redirectAction", params = { "actionName", "enroll-learner", "namespace", "/aty", "siteId", "${siteId}", "folderId", "${folderId}", "activityId", "${activityId}", "activityType", "${activityType}", "folderType", "${folderType}"}),
@Result(name = "exam-details", location = "/WEB-INF/content/aty/enroll-learner-exam-details.jsp", params = { "actionName", "enroll-learner!examDetails", "namespace", "/aty", "siteId", "${siteId}", "folderId", "${folderId}", "activityId", "${activityId}", "activityType", "${activityType}", "paperId", "${paperId}"})
}
)

    @com.kingnod.core.annotation.Generated("2012-02-29 15:43")
public class EnrollLearnerAction extends FilterableEntityAction<EnrollLearner, Long> {

    @Autowired
    private EnrollLearnerService enrollLearnerService;

    
    private Long siteId;
    private Long folderId;
    private String folderType;
    private Long activityId;
    private String isExcluded;
    private ObjectType activityType;
    private Long paperId;

    
    @com.kingnod.core.annotation.Generated("2012-02-29 15:43")
    public String filterDefines() {
        return "aty.enrollLearnerFilterItems";
    }

    
    @com.kingnod.core.annotation.Generated("2012-02-29 15:43")
    protected Object getEntityService() {
        return this.enrollLearnerService;
    }
    
    /**
	 * 学员列表_刷新
	 * @return
	 * @throws Exception
	 */
	public String refreshMember() throws Exception {
		enrollLearnerService.refreshMember(activityId, activityType);
		return EntityAction.RELOAD;
	}
	
	/**
	 * 学员列表_排除_取消排除
	 * @return
	 * @throws Exception
	 */
	public String excluded() throws Exception {
		Long[] ids = getIdValues();
		if(ids != null) {
			for (int i = 0; i < ids.length; i++) {
				EnrollLearner enrollLearner = enrollLearnerService.getEnrollLearner(ids[i]);
				enrollLearner.setExcluded(StringUtils.isTrue(isExcluded));
				enrollLearnerService.saveEnrollLearner(enrollLearner);
			}
		}
		return RELOAD;
	}
    
 
    /**
     * 根据活动ID取出学员列表
     */
	@Override
	protected void afterPreparedCriteriaBuilder(CriteriaBuilder cb) {
		cb.andEQ("activityId", activityId).andEQ("activityType", activityType);
	}
	
	
	/**
	 * 设置登记方式
	 * @return
	 * @throws Exception
	 */
	public String enrollModeModify() throws Exception {
		Long[] ids = getIdValues();
		String enrollMode = request.getParameter("enrollMode");
		if (null != ids && ids.length > 0) {
			enrollLearnerService.enrollModeModify(ListUtils.of(ids), enrollMode, true);
		}
		return RELOAD;
	}
	

	public Long getSiteId() {
		return siteId;
	}


	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}


	public Long getActivityId() {
		return activityId;
	}


	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}


	public Long getFolderId() {
		return folderId;
	}


	public void setFolderId(Long folderId) {
		this.folderId = folderId;
	}


	public String getIsExcluded() {
		return isExcluded;
	}


	public void setIsExcluded(String isExcluded) {
		this.isExcluded = isExcluded;
	}


	public ObjectType getActivityType() {
		return activityType;
	}


	public void setActivityType(ObjectType activityType) {
		this.activityType = activityType;
	}


	public Long getPaperId() {
		return paperId;
	}


	public void setPaperId(Long paperId) {
		this.paperId = paperId;
	}


	public String getFolderType() {
		return folderType;
	}


	public void setFolderType(String folderType) {
		this.folderType = folderType;
	}


}