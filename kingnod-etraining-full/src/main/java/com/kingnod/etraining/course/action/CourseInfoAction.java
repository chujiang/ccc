package com.kingnod.etraining.course.action;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import net.sf.json.JsonConfig;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.exception.ApplicationException;
import com.kingnod.core.exception.Exceptions;
import com.kingnod.core.extensions.struts2.action.EntityAction;
import com.kingnod.core.extensions.struts2.action.FilterableEntityAction;
import com.kingnod.core.extensions.struts2.annotation.ErrorMapping;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.core.util.SecurityUtils;
import com.kingnod.core.util.SpringUtils;
import com.kingnod.core.util.SysParameterUtils;
import com.kingnod.core.util.collection.MapUtils;
import com.kingnod.core.util.io.FileUtils;
import com.kingnod.core.util.web.Struts2Utils;
import com.kingnod.etraining.activity.entity.Elearning;
import com.kingnod.etraining.activity.service.ElearningService;
import com.kingnod.etraining.common.entity.ObjectRelation;
import com.kingnod.etraining.common.service.ObjectRelationService;
import com.kingnod.etraining.common.service.Pdf2SwfConverterService;
import com.kingnod.etraining.common.ui.components.TreeNode;
import com.kingnod.etraining.common.webservices.impl.ExaminationServicesImpl;
import com.kingnod.etraining.course.CourseConstant;
import com.kingnod.etraining.course.control.ControlStation;
import com.kingnod.etraining.course.entity.ContentServer;
import com.kingnod.etraining.course.entity.CourseInfo;
import com.kingnod.etraining.course.samplerte.server.FtpServer;
import com.kingnod.etraining.course.samplerte.server.UploadServer;
import com.kingnod.etraining.course.server.models.FolderNode;
import com.kingnod.etraining.course.service.ContentServerService;
import com.kingnod.etraining.course.service.CourseInfoService;
import com.kingnod.etraining.course.service.ItemInfoService;
import com.kingnod.etraining.organization.entity.Site;
import com.kingnod.etraining.organization.service.SiteService;
import com.kingnod.etraining.organization.service.UserService;
import com.kingnod.etraining.resource.entity.ResourceFolder;
import com.kingnod.etraining.resource.service.ResourceFolderService;
import com.kingnod.etraining.security.entity.UserAccount;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

@org.springframework.stereotype.Controller
@Namespace("/crs")
@com.kingnod.core.annotation.Generated("2012-02-15 16:36")
@Results({ 
	@Result(name = EntityAction.RELOAD, type = "redirectAction", params = { "actionName", "course-info", "namespace", "/crs", "folderId", "${folderId}", "category", "${category}" }),
	@Result(name = "courseList", type = "redirectAction", params = { "actionName", "course-category",	"namespace", "/crs", "categoryId", "${categoryId}"})
	})
public class CourseInfoAction extends FilterableEntityAction<CourseInfo, Long> {
	
	Logger log = LoggerFactory.getLogger(CourseInfoAction.class);
	private static final long serialVersionUID = 1L;
	private File file;
	private File uploadFile;
	private String Filename;
	private String uploadFileFileName;//设置上传文件的文件名
    private String uploadFileContentType;//上传文件的类型
	private String contentServer;
	private String uploadPath;
	private List<FolderNode> result = null;
	private String nodeType = "";
	private String category;
	private Integer integer;
	private String courseType;
	private boolean includeSubFolderVal;
	private String folderId;
	private String qtype;
	@Autowired
	@com.kingnod.core.annotation.Generated("2012-02-15 16:36")
	private CourseInfoService courseInfoService;
	@Autowired
	private ContentServerService contentServic;
	@Autowired
	private ItemInfoService itemInfoService;
	@Autowired
	private ResourceFolderService resourceFolderService;
	@Autowired
	private ObjectRelationService objectRelationService;
	@Autowired
	private ElearningService elearningService;
	@Autowired
	private UserService userService;
	
	/*  update maxudong   pdf文件转化服务类 */
	@Autowired
	private Pdf2SwfConverterService pdf2SwfConverterService;
	
	
	
	public String contentName = "";
	public String folderName = "";
	
	@Override
	protected void afterPreparedCriteriaBuilder(CriteriaBuilder cb) {
		if(includeSubFolderVal){
			cb.addParam("folderId", folderId);
		}else{
			cb.andGroup(Cnd.builder().andEQ("folderId", entity.getFolderId()));
		}
		if(!StringUtils.isEmpty(qtype)){
			cb.andGroup(Cnd.builder().andEQ("type", qtype));
		}
		cb.add(Cnd.orderBy("A.UPDATE_DATE", "DESC"));
	}
	
	public String createCourse() throws Exception{
		getObject();
		return "new";
	}
	
	public String newSave() throws Exception {
		// TODO Auto-generated method stub
		super.save();
		Long courseId = -1L;
		String courseName = "";
		CriteriaBuilder builder = Cnd.builder(CourseInfo.class);
		CriteriaBuilder andEQ = builder.andEQ("folderId", entity.getFolderId()).andEQ("courseTitle", entity.getCourseTitle());
		PagingResult<CourseInfo> findCourseInfo = courseInfoService.findCourseInfo(andEQ.buildCriteria());
		for(CourseInfo course : findCourseInfo.getResult()){
			courseId = course.getId();
			courseName = course.getCourseTitle();
		}
		UploadServer.saveItem(courseId, courseName, "","", itemInfoService);
		return RELOAD;
	}
	private String generateFileName(String fileName) {   
        DateFormat format = new SimpleDateFormat("yyMMddHHmmss");   
        String formatDate = format.format(new Date());   
           
        int random = new Random().nextInt(10000);   
           
        int position = fileName.lastIndexOf(".");   
        String extension = fileName.substring(position);   
           
        return formatDate + random + extension;   
    }      

	@Override
	public String input() throws Exception {
		// TODO Auto-generated method stub
		getObject();
		return super.input();
	}
	
	private void getObject(){
		if(null != entity.getContentServerId())
		{
		CriteriaBuilder criteriaBuilder = Cnd.builder(ContentServer.class);
		criteriaBuilder = criteriaBuilder.andEQ("id",entity.getContentServerId());
		PagingResult<ContentServer> pagingResult = contentServic
				.findContentServer(criteriaBuilder.buildCriteria());
		List<ContentServer> list = pagingResult.getResult();
		
		for (ContentServer contentS : list) {
			contentName = contentS.getName();
			entity.setContentServerId(contentS.getId());
		}
		}
		if(null !=  entity.getFolderId()){
		CriteriaBuilder resCriteriaBuilder = Cnd.builder(ResourceFolder.class);
		resCriteriaBuilder = resCriteriaBuilder.andEQ("id", entity.getFolderId());
		PagingResult<ResourceFolder> resPagingResult = resourceFolderService.findResourceFolder(resCriteriaBuilder.buildCriteria());
		for (ResourceFolder res : resPagingResult.getResult()) {
			folderName = res.getName();
		}
		}
		if(null != entity.getId()){
		CriteriaBuilder builder = Cnd.builder(ObjectRelation.class);
		builder.andEQ("object1Id", entity.getId());
		PagingResult<ObjectRelation> findObjectRelation = objectRelationService.findObjectRelation(builder.buildCriteria());
		 int i = 0;
		 StringBuffer sb = new StringBuffer();
		for(ObjectRelation or : findObjectRelation.getResult()){
			if(i < findObjectRelation.getResult().size()-1){
				sb.append(or.getObject2Id()).append(",");
			}else{
				sb.append(or.getObject2Id());
			}
			i++;
		}
		
		courseType = sb.toString();
		}
	}
	
	@Override
	public String delete() throws Exception {
		// TODO Auto-generated method stub
		FtpServer ftpServer = null;
		for(Long cId : this.getIdValues()){
			CriteriaBuilder eCriteriaBuilder = Cnd.builder(Elearning.class);
			eCriteriaBuilder.andEQ("courseId", cId);
			PagingResult<Elearning> findElearning = elearningService.findElearning(eCriteriaBuilder.buildCriteria());
			if(findElearning.getResult().size()>0){
				throw Exceptions.createAppException("crs001001");
			}
			CriteriaBuilder cCriteriaBuilder = Cnd.builder(CourseInfo.class);
			cCriteriaBuilder.andEQ("id", cId);
			PagingResult<CourseInfo> findCourseInfo = courseInfoService.findCourseInfo(cCriteriaBuilder.buildCriteria());
			for(CourseInfo c : findCourseInfo.getResult()){
				CriteriaBuilder oCriteriaBuilder = Cnd.builder(ObjectRelation.class);
				oCriteriaBuilder.andEQ("object1Id", c.getId()).andEQ("object2Id", c.getFolderId());
				PagingResult<ObjectRelation> findObjectRelation = objectRelationService.findObjectRelation(oCriteriaBuilder.buildCriteria());
				for(ObjectRelation or : findObjectRelation.getResult()){
					objectRelationService.deleteObjectRelationByIds(or.getId());
				}
					Long contentServerId = c.getContentServerId();
					ContentServer server = contentServic.getContentServer(contentServerId);
					String path = server.getFtpUserName();
					File courseFile = new File(path.concat(c.getLocation()));
					if(courseFile.exists()){
						FileUtils.deleteDirectory(courseFile);
					}
//					ftpServer.deleteFoldAndsubFiles(c.getLocation());
				itemInfoService.deleteByCourseId(c.getId());
			}
		}
		return super.delete();
	}
	
	public String redirectBack() throws IOException{
		return "back";
	}
//	public String loginServer() throws IOException{
//		ExaminationServicesImpl es = new ExaminationServicesImpl();
//		Site site = SpringUtils.getBean(SiteService.class).getSite(Long.valueOf(request.getParameter("loginSite")+""));
//		String result = es.login(request.getParameter("loginName")+"", request.getParameter("loginPass")+"", site.getShortName());
//		Map resultMap = new HashMap();
//		resultMap.put("success", "success");
//		response.setContentType("text/plain");
//		response.getWriter().write(request.getParameter("callbackMethod") + "({'success':'success'})");
//		return null;
//	}
	public String redirectImport(){
		return "import";
	}
	public String redirect(){
		PagingResult<ContentServer> cr = contentServic.findContentServer(Cnd.builder(ContentServer.class).andIsNotNull("name").buildCriteria());
		ContentServer cs = cr.getResult().get(0);
		contentServer = String.valueOf(cs.getId());
		return "redirect";
	}
	public String getCourseSystemCatagories(){
		List<TreeNode> list = new ArrayList<TreeNode>();
		TreeNode treeNode = new TreeNode("1", "abcd", true);
		list.add(treeNode);
		treeNode = new TreeNode("2", "abcd", true);
		list.add(treeNode);
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonRoot", list);
		return "jsonResult";
	}

	public String upload() throws IOException  {
		String errorCode = "";
		String message = "";
		String userName = "";
		Long userId =-1L;
		try {
			UserAccount userDetails = SecurityUtils.getCurrentUser();
			if (null == userDetails) {
				userId =Long.valueOf(request.getParameter("userId"));
				userName = userService.getUser(userId).getLoginName();
			} else {
				userId = userDetails.getId() == null ? 0L : userDetails.getId();
				userName = userDetails.getUsername();
			}
			processUploadCourse(userId,userName);
		} 
		catch(Exception ex) {
			errorCode = "-300";
			if(ex instanceof ApplicationException){
				message =  java.net.URLDecoder.decode(SpringUtils.getMessage(((ApplicationException) ex).getErrorCode()),"UTF_8");
			}else{
				message =  java.net.URLDecoder.decode(SpringUtils.getMessage("crs001022"),"UTF_8");
			}
			log.error(message);
		}
		finally{
			if(file.exists())
			file.delete();
			String importPath = SysParameterUtils.getString("crs.course_upload_file_location")
			.concat(File.separator).concat(userName);
			if(new File(importPath).exists()){
			// update by maxudong  	暂时屏蔽删除文件代码，可考虑每星期清理或每月定时任务清理临时文件
			//	FileUtils.deleteDirectory(new File(importPath));
			}

		}
		JsonConfig jsonconfig = new JsonConfig();
		if (!StringUtils.isEmpty(errorCode)) {
			//ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonRoot", MapUtils.map("errorCode",errorCode,"message",message));
			ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonRoot", new String[] { errorCode,message });
		} else {
			ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonRoot", new String[] {});
		}
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonconfig", jsonconfig);
		return "jsonResult";
	}
	

	public String processUploadCourse(Long userId,String userName) throws Exception {
		if (file == null || Filename == null || Filename.isEmpty()) {
			throw Exceptions.createAppException("crs001003");
		}
		String serverUplodPath = "";
		Filename = Filename.replaceAll("\\s+", "");
		uploadPath = uploadPath.replaceAll("\\\\", "/");
		File unZipFile = null;
		String concat =	"";
		CriteriaBuilder criteriaBuilder = Cnd.builder(ContentServer.class);
		criteriaBuilder = criteriaBuilder.andEQ("id", contentServer);
		PagingResult<ContentServer> pagingResult = contentServic
				.findContentServer(criteriaBuilder.buildCriteria());
		List<ContentServer> list = pagingResult.getResult();
		ContentServer content = null;
		for (ContentServer contentS : list) {
			content = contentS;
		}
		if (null != content) {
			serverUplodPath = content.getFtpUserName();
		}else{
			throw Exceptions.createAppException("crs001002");
		}
		if(uploadPath.startsWith(File.separator)){
			 concat = uploadPath.concat(File.separator).concat(Filename.indexOf(".") >= 0 ? Filename.substring(0,
			Filename.lastIndexOf(".")) : Filename);
		}else{
			concat = File.separator.concat(uploadPath).concat(File.separator).concat(Filename.indexOf(".") >= 0 ? Filename.substring(0,
				Filename.lastIndexOf(".")) : Filename);
		}
		serverUplodPath = serverUplodPath.concat(concat);//改成系统参数，ftp服务器的绝对路径 
		String importPath = serverUplodPath.
				concat(File.separator).concat(Filename);
		File destFile = new File(importPath);
		if(destFile.exists()){
			throw Exceptions.createAppException("crs001016");
		}
		if(destFile.getParentFile().exists()){
			FileUtils.deleteDirectory(destFile.getParentFile());
		}
		org.apache.commons.io.FileUtils.copyFile(file, destFile);
		file.delete();
		boolean parse = false;
		if (Filename.endsWith(".zip")) {
			if(UploadServer.checkChinese(Filename)){
				throw Exceptions.createAppException("crs001026");
			}
			if(UploadServer.checkChinese(uploadPath)){
				throw Exceptions.createAppException("crs001027");
			}
			unZipFile = new File(serverUplodPath);
			if (!unZipFile.exists()) {
				unZipFile.mkdir();
			}
			// String realPath = request.getRealPath("/scorm12xsd");
			parse = UploadServer.openContentPackage(destFile,
					unZipFile, concat, entity.getFolderId(),
					Long.valueOf(contentServer));
			if (!parse) {//非标准课件的ITEM,只记录本文件。或者包下的文件。
				ControlStation.getSharedInstance().unpackZip(destFile, unZipFile);
			} 
			File createTxtFile = FileUtils.createTxtFile(unZipFile.getPath(), "isCourse.txt", "");
		} 
		if(!parse){
			CriteriaBuilder cb = Cnd.builder(CourseInfo.class);
			cb = cb.andEQ("courseTitle", destFile.getName()==null?"":destFile.getName().substring(
				0,
				destFile.getName().lastIndexOf(
						CourseConstant.COURSE_SEPARATOR))).andEQ("folderId", this.folderId);
			if(courseInfoService.findCourseInfo(cb.buildCriteria()).getResult().size()>0){
				throw Exceptions.createAppException("crs001017");
			}
			
			CourseInfo courseInfo = UploadServer.saveCourseInfo(destFile, concat, entity.getFolderId(),Long.valueOf(contentServer), courseInfoService);
			Long courseId = -1L;
			String courseName = "";
			CriteriaBuilder builder = Cnd.builder(CourseInfo.class);
			builder.andEQ("courseTitle", courseInfo.getCourseTitle()).andEQ("location", courseInfo.getLocation());
			PagingResult<CourseInfo> findCourseInfo = SpringUtils.getBean(
					CourseInfoService.class).findCourseInfo(
					builder.buildCriteria());
			List<CourseInfo> result = findCourseInfo.getResult();
			
			for (Iterator<CourseInfo> iterator = result.iterator(); iterator
					.hasNext();) {
				CourseInfo info = iterator.next();
				courseId = info.getId();
				courseName = info.getCourseTitle();
			}
			UploadServer.saveItem(courseId,courseName,destFile.getName().substring(destFile.getName().lastIndexOf(".")),destFile.getName(),itemInfoService);//保存非标准课件的item文件
		}
		
		File createTxtFile = FileUtils.createTxtFile(destFile.getParent(), "isCourse.txt", "");
		
	    //    update by maxudong  暂时屏蔽删除文件代码，可考虑每星期清理或每月定时任务清理临时文件
	    //	destFile.delete();     
		//ftpServer.closeFTPClient();
		// update by maxudong pdf类文件转换接口
		if(destFile.getPath().endsWith(".pdf")){
			
			//myfile 文件完整路径包括文件名称
			//destFilePath 转换文件呢目标存放地址（不包括文件名）
			//destFileName 转换之后文件名称
			String desetFileName = new String(destFile.getName().substring(0,destFile.getName().lastIndexOf("."))).concat(".swf");
		    pdf2SwfConverterService.pdf2swf(destFile.getPath(),destFile.getParent(),desetFileName,"pdf2swf"); 

		}
		return "define";
	}

	/**
	   * 发布
	   * @return
	   * @throws Exception 
	   */
	  public String publish() throws Exception {
	    courseInfoService.updateCourseByCourseId(entity.getId(), CourseConstant.RELEASE_STATUS_R);
	    return RELOAD;
	  }
	  
	  /**
	   * 取消发布
	   * @return
	   * @throws Exception
	   */
	  public String cancelPublish() throws Exception {
		  courseInfoService.updateCourseByCourseId(entity.getId(), CourseConstant.RELEASE_STATUS_P);
	    return RELOAD;
	  }
	  
	
	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFilename() {
		return Filename;
	}

	public void setFilename(String filename) {
		Filename = filename;
	}

	public List<FolderNode> getResult() {
		return result;
	}

	public void setResult(List<FolderNode> result) {
		this.result = result;
	}

	@com.kingnod.core.annotation.Generated("2012-02-15 16:36")
	public String filterDefines() {
		return "crs.courseInfoFilterItems";
	}

	@com.kingnod.core.annotation.Generated("2012-02-15 16:36")
	protected Object getEntityService() {
		return this.courseInfoService;
	}

	public void setContentServer(String contentServer) {
		this.contentServer = contentServer;
	}

	public String getContentServer() {
		return contentServer;
	}

	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}

	public String getUploadPath() {
		return uploadPath;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Integer getInteger() {
		return integer;
	}

	public void setInteger(Integer integer) {
		this.integer = integer;
	}

	public void setUploadFile(File uploadFile) {
		this.uploadFile = uploadFile;
	}

	public File getUploadFile() {
		return uploadFile;
	}

	public String getCourseType() {
		return courseType;
	}

	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}

	public String define() throws Exception {
		return "define";
	}

	public String fileImport() throws Exception {
		ExaminationServicesImpl es = new ExaminationServicesImpl();
		Site site = SpringUtils.getBean(SiteService.class).getSite(Long.valueOf(request.getParameter("loginSite")+""));
		String result = es.login(request.getParameter("loginName")+"", request.getParameter("loginPass")+"", site.getShortName());
		integer = SysParameterUtils.getInteger("crs.course_file_size_limit");
		UserAccount userDetails = SecurityUtils.getCurrentUser();
		request.setAttribute("ctxPath", request.getParameter("ctxPath"));
		request.setAttribute("userId", userDetails.getId());
		return "import";
	}

	public String folderSelector() throws Exception {
		return "folderSelector";
	}

	public String getNodeType() {
		return nodeType;
	}

	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}
	public String getUploadFileFileName() {
		return uploadFileFileName;
	}

	public void setUploadFileFileName(String uploadFileName) {
		this.uploadFileFileName = uploadFileName;
	}

	public String getUploadFileContentType() {
		return uploadFileContentType;
	}

	public void setUploadFileContentType(String uploadContentType) {
		this.uploadFileContentType = uploadContentType;
	}


	public String getFolderId() {
		return folderId;
	}

	public void setFolderId(String folderId) {
		this.folderId = folderId;
	}

	public boolean isIncludeSubFolderVal() {
		return includeSubFolderVal;
	}

	public void setIncludeSubFolderVal(boolean includeSubFolderVal) {
		this.includeSubFolderVal = includeSubFolderVal;
	}

	public String getQtype() {
		return qtype;
	}

	public void setQtype(String qtype) {
		this.qtype = qtype;
	}
	

	
	
	
}