package com.kingnod.etraining.report.action;

import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.extensions.struts2.action.EntityAction;
import com.kingnod.core.extensions.struts2.action.FilterableEntityAction;
import com.kingnod.core.extensions.struts2.interceptor.FilterBean;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.core.util.SecurityUtils;
import com.kingnod.core.util.SpringUtils;
import com.kingnod.core.util.StringUtils;
import com.kingnod.core.util.collection.ListUtils;
import com.kingnod.etraining.common.export.util.Exporters;
import com.kingnod.etraining.course.utils.TimeUtil;
import com.kingnod.etraining.organization.entity.Site;
import com.kingnod.etraining.organization.service.SiteService;
import com.kingnod.etraining.report.entity.CourseMessage;
import com.kingnod.etraining.report.service.CourseMessageService;
import com.kingnod.etraining.security.entity.UserAccount;

import java.util.Date;
import java.util.List;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Controller
@Namespace("/rpt")
@Results( 
{
@Result(name = EntityAction.RELOAD, type = "redirectAction", params = { "actionName", "course-message", "namespace", "/rpt","activityCompleteNumber",
		"start_Time","${start_Time}","end_Time","${end_Time}","userNumber_Compare","${userNumber_Compare}",
		"avgTotalTime_Compare","${avgTotalTime_Compare}","activityCompleteNumber_Compare","${activityCompleteNumber_Compare}",
		"${activityCompleteNumber}","userNumber","${userNumber}","courseType","${courseType}","avgTotalTimeHour","${avgTotalTimeHour}","activityName","${activityName}",
		"activityType","${activityType}"})
}
)

    @com.kingnod.core.annotation.Generated("2012-05-15 10:55")
public class CourseMessageAction extends FilterableEntityAction<CourseMessage,Long> {

    /**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 3575102012211251478L;

	@Autowired
    @com.kingnod.core.annotation.Generated("2012-05-15 10:55")
    private CourseMessageService courseMessageService;
    
    private Long userNumber;
    private String avgTotalTimeHour;
	private String courseType;  
    private Long avgTotalTime;
    private String activityName;
    private Long activityCompleteNumber;
    private Date end_Time;
    private Date start_Time;
    private int userNumber_Compare;
    private int avgTotalTime_Compare;
    private int activityCompleteNumber_Compare;
    
    @Autowired
    private SiteService siteService;
    
    private Long siteId;

    @Override
    public String execute() throws Exception {
    	request.setAttribute("page", pager);
    	return SUCCESS;
    }

	/**
     * 导出EXCEL报表
     */
    public void export() {
    	PagingResult<CourseMessage> exportDataset = doQuery(createCriteria());
    	Site site = siteService.getSite(siteId);
    	Exporters.toXLSByXmlPublisherWithDownload(
    			"courseMessage",
    			ListUtils.of("activityName","courseType","userNumber","avgTotalTimeShow","activityCompleteNumber","activityType"), 
    			exportDataset.getResult(),
    			SpringUtils.getMessage("rpt.reportFolder_courseInfo") + String.format("(%s)",site.getName()));
    }
	
	public void setFilters(List<FilterBean> filters){
	}

	@Override
    protected void afterPreparedCriteriaBuilder(CriteriaBuilder cb) {
		 UserAccount userDetails = SecurityUtils.getCurrentUser();
		
		 //通过siteId获得推荐课程的性息
		 Long siteId = userDetails.getSiteId();
		 
		 cb.addParam("siteId", siteId);
    	 if(!StringUtils.isEmpty(this.activityName))
    	 {
    		 cb.andLike("activityName", "%" + activityName + "%");
    	 }

    	 if(!StringUtils.isEmpty(courseType))
    	 {
    		 cb.addParam("courseType", Long.valueOf(courseType));
    	 }
    	 
    	 if(!StringUtils.isEmpty(avgTotalTimeHour))
    	 {
    		avgTotalTime = TimeUtil.HHMMSSToSec(avgTotalTimeHour);
    		switch (avgTotalTime_Compare) {
			case 1:
				cb.andGE("avgTotalTime",avgTotalTime);
				break;
			case -1:
				cb.andLT("avgTotalTime",avgTotalTime);
				break;
			case 0:
				cb.andEQ("avgTotalTime",avgTotalTime);
				break;

			default:
				break;
			}
    		 
    	 }
    	 if (null != userNumber) {
			switch (userNumber_Compare) {
			case 1:
				cb.andGE("userNumber",userNumber);
				break;
			case -1:
				cb.andLT("userNumber", userNumber);
				break;
			case 0:
				cb.andEQ("userNumber",userNumber);
				break;
			default:
				break;
			}
		}
		if (null != activityCompleteNumber) {
			switch (activityCompleteNumber_Compare) {
			case 1:
				cb.andGE("activityCompleteNumber", activityCompleteNumber);
				break;
			case -1:
				cb.andLT("activityCompleteNumber", activityCompleteNumber);
				break;
			case 0:
				cb.andEQ("activityCompleteNumber", activityCompleteNumber);
				break;
			default:
				break;
			}
		}
		
		if(null != start_Time)
		{
			cb.addParam("start_Time", start_Time);
		}
		
		if(null != end_Time)
		{
			cb.addParam("end_Time", end_Time);
		}
    	 
    }
    
    @com.kingnod.core.annotation.Generated("2012-05-15 10:55")
    public String filterDefines() {
        return "rpt.courseMessageFilterItems";
    }

    
    @com.kingnod.core.annotation.Generated("2012-05-15 10:55")
    protected Object getEntityService() {
        return this.courseMessageService;
    }
    
    public String getAvgTotalTimeHour() {
		return avgTotalTimeHour;
	}


	public void setAvgTotalTimeHour(String avgTotalTimeHour) {
		this.avgTotalTimeHour = avgTotalTimeHour;
	}


    public int getUserNumber_Compare() {
		return userNumber_Compare;
	}


	public void setUserNumber_Compare(int userNumber_Compare) {
		this.userNumber_Compare = userNumber_Compare;
	}


	public int getAvgTotalTime_Compare() {
		return avgTotalTime_Compare;
	}


	public void setAvgTotalTime_Compare(int avgTotalTime_Compare) {
		this.avgTotalTime_Compare = avgTotalTime_Compare;
	}


	public int getActivityCompleteNumber_Compare() {
		return activityCompleteNumber_Compare;
	}


	public void setActivityCompleteNumber_Compare(int activityCompleteNumber_Compare) {
		this.activityCompleteNumber_Compare = activityCompleteNumber_Compare;
	}

    
    public Date getEnd_Time() {
		return end_Time;
	}


	public void setEnd_Time(Date end_Time) {
		this.end_Time = end_Time;
	}


	public Date getStart_Time() {
		return start_Time;
	}


	public void setStart_Time(Date start_Time) {
		this.start_Time = start_Time;
	}

	public Long getUserNumber() {
		return userNumber;
	}


	public void setUserNumber(Long userNumber) {
		this.userNumber = userNumber;
	}


	public String getCourseType() {
		return courseType;
	}


	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}


	public Long getAvgTotalTime() {
		return avgTotalTime;
	}


	public void setAvgTotalTime(Long avgTotalTime) {
		this.avgTotalTime = avgTotalTime;
	}


	public String getActivityName() {
		return activityName;
	}


	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public Long getActivityCompleteNumber() {
		return null == activityCompleteNumber?0:activityCompleteNumber;
	}


	public void setActivityCompleteNumber(Long activityCompleteNumber) {
		this.activityCompleteNumber = activityCompleteNumber;
	}

	public Long getSiteId() {
		return siteId;
	}

	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}
}