package com.kingnod.etraining.course.action;

import java.util.List;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonBeanProcessor;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.extensions.struts2.action.EntityAction;
import com.kingnod.core.extensions.struts2.action.FilterableEntityAction;
import com.kingnod.core.util.web.Struts2Utils;
import com.kingnod.etraining.activity.entity.ActivityDetails;
import com.kingnod.etraining.activity.service.ActivityService;
import com.kingnod.etraining.course.entity.CourseEvaluation;
import com.kingnod.etraining.course.service.CourseEvaluationService;

@org.springframework.stereotype.Controller
@Namespace("/crs")
@Results( 
{
@Result(name = EntityAction.RELOAD, type = "redirectAction", params = { "actionName", "course-evaluation", "namespace", "/crs"})
}
)

    @com.kingnod.core.annotation.Generated("2012-04-10 14:20")
public class CourseEvaluationAction extends FilterableEntityAction<CourseEvaluation, Long> {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private ActivityService activityService;
	@Autowired
    @com.kingnod.core.annotation.Generated("2012-04-10 14:20")
    private CourseEvaluationService courseEvaluationService;
	private int pageNo;
    Long activityId;
    
    @Override
	public String list() throws Exception {
		// TODO Auto-generated method stub
    
    	pager.setPageNo(pageNo);
    	pager.setPageSize(5);
    	List<CourseEvaluation> courseEvaluations = courseEvaluationService.getCourseEvaluations(entity.getCourseId(),pager);
		pager.setTotalPages(new Long(pager.getTotalPages()).intValue());
		pager.setResult(courseEvaluations);
		request.setAttribute("page", pager);
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonRoot", pager);
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonconfig", null);
		return "jsonResult";
	}


	@Override
	public String save() throws Exception {
		// TODO Auto-generated method stub
		int grade = 0;
		super.save();
		CriteriaBuilder ceBuilder = Cnd.builder(CourseEvaluation.class);
		ceBuilder.andEQ("courseId", entity.getCourseId());
		List<CourseEvaluation> courseEvaluations = courseEvaluationService.findCourseEvaluation(ceBuilder.buildCriteria()).getResult();
		for(CourseEvaluation ce : courseEvaluations){
			grade+=ce.getGrade();
		}
		
		CriteriaBuilder builder = Cnd.builder(ActivityDetails.class);
		builder.andEQ("activityId", activityId);
		for(ActivityDetails aty : activityService.findActivity(builder.buildCriteria()).getResult()){
			aty.setGrade((int)Math.rint(grade/(courseEvaluations==null?1:courseEvaluations.size())));
			activityService.saveActivity(aty);
		}
		JsonConfig jsonconfig = new JsonConfig();
		 jsonconfig.registerJsonBeanProcessor(CourseEvaluation.class, new JsonBeanProcessor(){
		        public JSONObject processBean(Object bean, JsonConfig jsonConfig) {
		        	CourseEvaluation ce = (CourseEvaluation)bean;
		          JSONObject jsonobj = new JSONObject();
		          jsonobj
		          .element("courseId", ce.getCourseId())
		          .element("type", ce.getType())
		           .element("typeName", ce.getTypeName())
		          .element("grade", ce.getGrade())
		          .element("description", ce.getDescription())
		          .element("createDate", ce.getCreateDate());
		          return jsonobj;
		        }});
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonRoot", entity);
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonconfig", jsonconfig);
		return "jsonResult";
	}


	@com.kingnod.core.annotation.Generated("2012-04-10 14:20")
    public String filterDefines() {
        return "crs.courseEvaluationFilterItems";
    }

    
    @com.kingnod.core.annotation.Generated("2012-04-10 14:20")
    protected Object getEntityService() {
        return this.courseEvaluationService;
    }


	public int getPageNo() {
		return pageNo;
	}


	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}


	public Long getActivityId() {
		return activityId;
	}


	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}
    
    
}