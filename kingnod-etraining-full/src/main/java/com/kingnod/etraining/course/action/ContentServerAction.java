package com.kingnod.etraining.course.action;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.exception.Exceptions;
import com.kingnod.core.extensions.struts2.action.EntityAction;
import com.kingnod.core.extensions.struts2.action.FilterableEntityAction;
import com.kingnod.core.extensions.struts2.annotation.ErrorMapping;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.core.util.StringUtils;
import com.kingnod.core.util.web.Struts2Utils;
import com.kingnod.etraining.course.entity.ContentServer;
import com.kingnod.etraining.course.entity.CourseInfo;
import com.kingnod.etraining.course.service.ContentServerService;
import com.kingnod.etraining.course.service.CourseInfoService;

@org.springframework.stereotype.Controller
@Namespace("/crs")
@Results( 
{
@Result(name = EntityAction.RELOAD, type = "redirectAction", params = {"siteId","${siteId}", "actionName", "content-server", "namespace", "/crs"})
}
)

    @com.kingnod.core.annotation.Generated("2012-02-20 16:00")
    @ErrorMapping(method="save")
public class ContentServerAction extends FilterableEntityAction<ContentServer, Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long siteId;
	private Long contentId;
    @Autowired
    
    @com.kingnod.core.annotation.Generated("2012-02-20 16:00")
    private ContentServerService contentServerService;
    @Autowired
    private CourseInfoService courseService;

    
    @com.kingnod.core.annotation.Generated("2012-02-20 16:00")
    public String filterDefines() {
        return "crs.contentServerFilterItems";
    }

    
    @com.kingnod.core.annotation.Generated("2012-02-20 16:00")
    protected Object getEntityService() {
        return this.contentServerService;
    }
    
    
	public String queryContent() throws Exception {
		// TODO Auto-generated method stub
    	ContentServer contentServer = contentServerService.getContentServer(contentId);
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonRoot", contentServer);
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonconfig", null);
		return "jsonResult";
	}
    
	@Override
	public String delete() throws Exception {
		// TODO Auto-generated method stub
		boolean isOk = false;
		String cServer = "";
		for(Long cId : this.getIdValues()){
			CriteriaBuilder builder = Cnd.builder(CourseInfo.class);
			builder = builder.andEQ("contentServerId", cId);
			PagingResult<CourseInfo> courseInfoResult = courseService.findCourseInfo(builder.buildCriteria());
			if(courseInfoResult.getResult().size() > 0){
				isOk = true;
				cServer = cServer.concat("--").concat(contentServerService.getContentServer(cId).getName()).concat("--");
			}
		}
		if(isOk){
			throw Exceptions.createAppException("crs001028",new String[]{cServer});
		}
		return super.delete();
	}

	public Long getSiteId() {
		return siteId;
	}


	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}


	public Long getContentId() {
		return contentId;
	}


	public void setContentId(Long contentId) {
		this.contentId = contentId;
	}


}