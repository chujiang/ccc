package com.kingnod.etraining.course.action;

import java.util.List;
import java.util.Map;

import net.sf.json.JsonConfig;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.Criteria;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.extensions.struts2.action.EntityAction;
import com.kingnod.core.extensions.struts2.action.FilterableEntityAction;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.core.util.SpringUtils;
import com.kingnod.core.util.collection.ListUtils;
import com.kingnod.core.util.web.Struts2Utils;
import com.kingnod.etraining.common.ObjectType;
import com.kingnod.etraining.common.entity.ObjectRelation;
import com.kingnod.etraining.common.service.ObjectRelationService;
import com.kingnod.etraining.common.service.TreeService;
import com.kingnod.etraining.common.tree.TreeViewUtils;
import com.kingnod.etraining.course.entity.CourseInfo;
import com.kingnod.etraining.course.service.CourseInfoService;
import com.kingnod.etraining.resource.entity.ResourceFolder;
import com.kingnod.etraining.resource.service.ResourceFolderService;
import com.opensymphony.xwork2.Action;

@org.springframework.stereotype.Controller
@Namespace("/crs")
@Results({ 
	@Result(name = Action.SUCCESS, location = "/WEB-INF/content/crs/category-course-list.jsp"),
	@Result(name = Action.INPUT, location = "/WEB-INF/content/crs/Category-course-info.jsp"),
	@Result(name = EntityAction.RELOAD, type = "redirectAction", params = { "actionName", "course-category",	"namespace", "/crs", "categoryId", "${categoryId}", "category", "${category}" }),
	@Result(name = "courseList", type = "redirectAction", params = { "actionName", "course-category",
			"namespace", "/crs", "folderId", "${folderId}", "siteId", "${siteId}","category", "${category}","del_course","${del_course}" }) 
	})
@com.kingnod.core.annotation.Generated("2012-03-15 02:04")
public class CourseCategoryAction extends FilterableEntityAction<CourseInfo, Long> {

	@Autowired
	@com.kingnod.core.annotation.Generated("2012-03-15 02:04")
	private CourseInfoService courseInfoService;
	
	@Autowired
	private TreeService treeService;
	
	private Long folderCount;
	
	private Long folderId;
	
	private String del_course;

	public String getDel_course() {
		return del_course;
	}

	public void setDel_course(String del_course) {
		this.del_course = del_course;
	}

	private Long siteId;
	
	private String category;
	
	private String qtype;
	
	@Autowired
	private ObjectRelationService objectRelationService;
	
	@Autowired
	private ResourceFolderService resourceFolderService;

    public Long getFolderId() {
		return folderId;
	}

	public void setFolderId(Long folderId) {
		this.folderId = folderId;
	}
	
	public Long getSiteId() {
		return siteId;
	}

	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}

	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	@com.kingnod.core.annotation.Generated("2012-03-15 02:04")
	public String filterDefines() {
		return "crs.courseInfoFilterItems";
	}
	
	public String courseSetting()
	{
		String idStrs = String.valueOf(request.getParameter("ids"));
		ObjectRelation objRelation;
		String[] ids = idStrs.split(",");
		for(String id :ids)
		{
			objRelation = new ObjectRelation();
			objRelation.setObject2Id(Long.valueOf(folderId));
			objRelation.setObject1Id(Long.valueOf(id));
			objRelation.setObject1Type(ObjectType.R_CO);
			objRelation.setObject2Type(ObjectType.R_SF);
			objectRelationService.saveObjectRelation(objRelation);
		}
		return "courseList";
			
	}
	
	public String removeObjectRelation()
	{
		Long[] ids = getIdValues();
		ObjectRelation objRelation;
		PagingResult<ResourceFolder> childs = null;
		if(null != ids){
			if(null == folderId)
			{
				CriteriaBuilder cb = Cnd.builder(ResourceFolder.class);
				cb.andEQ("siteId", this.siteId).andEQ("type", ObjectType.R_SF).andEQ("name", SpringUtils.getMessage("crs.CategoryCourse", null));
				childs = resourceFolderService.findResourceFolder(cb.buildCriteria());
				this.folderId = childs.getResult().get(0).getId();
				folderCount = childs.getResult().get(0).getObjectCount();
			}
//			ResourceFolder resFolder = new ResourceFolder();
//			resFolder.setId(folderId);
//			resFolder.setObjectCount(folderCount-ids.length);
//			resourceFolderService.saveResourceFolder(resFolder);
			for(Long id :ids){
				objRelation = new ObjectRelation();
				objRelation.setId(id);//RES_FOLDER
				objRelation.setObject2Id(Long.valueOf(folderId));
				objRelation.setObject1Id(Long.valueOf(id));
				objRelation.setObject1Type(ObjectType.R_CO);
				objRelation.setObject2Type(ObjectType.R_SF);
				objectRelationService.deleteObjectRelationByObjId(objRelation);
			}
		}
		this.del_course="true";
		return "courseList";
	}
	
	@Override
	public String list() throws Exception {
		if("test".equals(request.getParameter("test")))
		{
			return INPUT;
		}
		Criteria criteria = createCriteria();
		PagingResult<ResourceFolder> childs = null;
		Map params = preparedCriteriaParams();
		if (params != null) 
			criteria.setParams(params);
		//如果folderId为空则去查询folderId
		CriteriaBuilder cb = Cnd.builder(ResourceFolder.class);
		cb.andEQ("siteId", this.siteId).andEQ("type", ObjectType.R_SF).andEQ("name", SpringUtils.getMessage("crs.CategoryCourse", null));
		PagingResult<CourseInfo> pagingResult = courseInfoService.findCourseInfoByCategory(criteria, 
				folderId == null? ListUtils.isEmpty(resourceFolderService.findResourceFolder(cb.buildCriteria()).getResult())?-99999:
					resourceFolderService.findResourceFolder(cb.buildCriteria()).getResult().get(0).getId():folderId,
				category);
		pager.setTotalCount(pagingResult.getTotalRows());
		pager.setResult(pagingResult.getResult());
		request.setAttribute("page", pager);
		request.setAttribute("category", category);
		request.setAttribute("folderId", folderId);
		return SUCCESS;
	}
	
	public String getCourseSystemCatagories(){
		List childs = treeService.getAllChildsResourceFolder(null, null, ObjectType.split(category, ","));
		
		JsonConfig jsonconfig = new JsonConfig();
		jsonconfig.registerJsonBeanProcessor(ResourceFolder.class, TreeViewUtils.basicResFolderProcessor);
		
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonRoot", childs);
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonconfig", jsonconfig);
		
		return "jsonResult";
	}

	@com.kingnod.core.annotation.Generated("2012-03-15 02:04")
	protected Object getEntityService() {
		return this.courseInfoService;
	}
	
	
	@Override
	protected void afterPreparedCriteriaBuilder(CriteriaBuilder cb) {
		// TODO Auto-generated method stub
		if(!StringUtils.isEmpty(qtype)){
			cb.andGroup(Cnd.builder().andEQ("type", qtype));
		}
	}
	
	public String getQtype() {
		return qtype;
	}

	public void setQtype(String qtype) {
		this.qtype = qtype;
	}
}