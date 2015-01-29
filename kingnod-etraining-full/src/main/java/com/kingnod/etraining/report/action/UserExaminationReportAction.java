package com.kingnod.etraining.report.action;

import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.criteria.Logic;
import com.kingnod.core.criteria.Operator;
import com.kingnod.core.extensions.struts2.action.EntityAction;
import com.kingnod.core.extensions.struts2.action.FilterableEntityAction;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.core.util.SpringUtils;
import com.kingnod.core.util.collection.ListUtils;
import com.kingnod.etraining.common.export.util.Exporters;
import com.kingnod.etraining.organization.entity.Site;
import com.kingnod.etraining.organization.service.SiteService;
import com.kingnod.etraining.report.entity.UserExaminationReport;
import com.kingnod.etraining.report.service.UserExaminationReportService;

/**
 * 员工考试报表
 * 
 * @author Huanhaibin
 *
 */
@org.springframework.stereotype.Controller
@Namespace("/rpt")
@Results( {
	@Result(name = EntityAction.RELOAD, type = "redirectAction", params = { "actionName", "user-examination-report", "namespace", "/rpt"})
})
public class UserExaminationReportAction extends FilterableEntityAction<UserExaminationReport, Long> {

    /**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 338683254698130111L;
	
	@Autowired
    private UserExaminationReportService userExaminationReportService;

    private String examName;		//考试名称
    private String examType;		//考试类型
    private String fullName;		//用户姓名
    private String examScore;		//分数
    private Long siteId;			//所属站点
    private Long orgId;				//所属组织
    private Long userGroupId;		//所属用户组
    private String examStatus;		//考试状态
    private Long examTime;			//考试次数
    private Long answerTimeLength;	//考试用时
    private Date finishDateStart;	//完成日期从...
    private Date finishDateEnd;		//完成日期到...
    private String examScoreOperators; 	//分数操作符
    private String examTimeOperators; 	//考试次数操作符
    private String objectPicker_userGroupId ; // 对象显示用户组ID
    
    @Autowired
    private SiteService siteService;
    
    
    public String filterDefines() {
        return "rpt.userExaminationReportFilterItems";
    }

    
    @com.kingnod.core.annotation.Generated("2012-05-22 14:29")
    protected Object getEntityService() {
        return this.userExaminationReportService;
    }
    
    @Override
    public String execute() throws Exception {
    	request.setAttribute("page", pager);
    	return SUCCESS;
    }
    
    /**
     * 查询员工考试报表
     */
    @Override
    public String list() throws Exception {
        CriteriaBuilder cb = Cnd.builder(UserExaminationReport.class);
        
        if(siteId != null && siteId.longValue() >= 0)
        	cb.andEQ("A.SITE_ID", siteId);
        
        if(StringUtils.isNotEmpty(examName))
        	cb.andLike("examName", examName);
        
        if(StringUtils.isNotEmpty(fullName))
        	cb.andLike("fullName", fullName);
        
        if(StringUtils.isNotEmpty(examType))
        	cb.andEQ("1", examType);
        
        if(StringUtils.isNotEmpty(examStatus))
        	cb.andEQ("examStatus", examStatus);
        
        String userGroupName = request.getParameter("objectPicker_userGroupId");
        if(userGroupName != null)
        	cb.andLike("user_group", userGroupName);
        
        if(userGroupId != null)
        	cb.andLike("user_group", userGroupName);
        
        if(orgId != null)
        	cb.andEQ("ORG_ID", orgId);
        
        if(examTime != null && examTime>0)
	    	cb.add(Cnd.createCriterion(Logic.AND, "examTime", Operator.valueOf(examTimeOperators), examTime));
        
        if(StringUtils.isNotEmpty(examScore))
        	cb.add(Cnd.createCriterion(Logic.AND, "final_Score", Operator.valueOf(examScoreOperators), examScore));
        
        if(finishDateStart != null)
        	cb.andGT("A_FINISH_DATE", finishDateStart);
        
        if(finishDateEnd != null)
        	cb.andLT("A_FINISH_DATE", finishDateEnd);
        
        Criteria limitCriter = cb.buildCriteria().limit(new Long(pager.getFirst()), new Long(pager.getLast()));
        
        PagingResult<UserExaminationReport> list = userExaminationReportService.findUserExaminationReport(limitCriter);
        pager.setTotalCount(list.getTotalRows());
        pager.setResult(list.getResult());
        request.setAttribute("page", pager);
        return SUCCESS;

    }

    
    /**
     * 导出EXCEL报表
     */
    public void export() {
    	PagingResult<UserExaminationReport> exportDataset = doQuery(createCriteria());
    	Site site = siteService.getSite(siteId);
    	Exporters.toXLSByXmlPublisherWithDownload(
    			"userExaminationReport",
    			ListUtils.of( "examName","fullName","scrollingTypeString","orgName","userGroup","examScore","examStatus","examTime","answerTimeLength","finishDate"), 
    			exportDataset.getResult(),
    			SpringUtils.getMessage("rpt.reportFolder_user_examination") + String.format("(%s)",site.getName()));
    }

	public String getExamName() {
		return examName;
	}


	public void setExamName(String examName) {
		this.examName = examName;
	}


	public String getExamType() {
		return examType;
	}


	public void setExamType(String examType) {
		this.examType = examType;
	}


	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public String getExamScore() {
		return examScore;
	}


	public void setExamScore(String examScore) {
		this.examScore = examScore;
	}


	public Long getOrgId() {
		return orgId;
	}


	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}


	public Long getUserGroupId() {
		return userGroupId;
	}


	public void setUserGroupId(Long userGroupId) {
		this.userGroupId = userGroupId;
	}


	public String getExamStatus() {
		return examStatus;
	}


	public void setExamStatus(String examStatus) {
		this.examStatus = examStatus;
	}


	public Long getExamTime() {
		return examTime;
	}


	public void setExamTime(Long examTime) {
		this.examTime = examTime;
	}


	public Long getAnswerTimeLength() {
		return answerTimeLength;
	}


	public void setAnswerTimeLength(Long answerTimeLength) {
		this.answerTimeLength = answerTimeLength;
	}


	public Date getFinishDateStart() {
		return finishDateStart;
	}


	public void setFinishDateStart(Date finishDateStart) {
		this.finishDateStart = finishDateStart;
	}


	public Date getFinishDateEnd() {
		return finishDateEnd;
	}


	public void setFinishDateEnd(Date finishDateEnd) {
		this.finishDateEnd = finishDateEnd;
	}


	public Long getSiteId() {
		return siteId;
	}


	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}


	public String getExamScoreOperators() {
		return examScoreOperators;
	}


	public void setExamScoreOperators(String examScoreOperators) {
		this.examScoreOperators = examScoreOperators;
	}


	public String getExamTimeOperators() {
		return examTimeOperators;
	}


	public void setExamTimeOperators(String examTimeOperators) {
		this.examTimeOperators = examTimeOperators;
	}


	public String getObjectPicker_userGroupId() {
		return objectPicker_userGroupId;
	}


	public void setObjectPicker_userGroupId(String objectPicker_userGroupId) {
		this.objectPicker_userGroupId = objectPicker_userGroupId;
	}
    
    
}