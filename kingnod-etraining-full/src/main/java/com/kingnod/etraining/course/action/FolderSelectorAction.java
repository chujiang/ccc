package com.kingnod.etraining.course.action;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonBeanProcessor;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.util.web.Struts2Utils;
import com.kingnod.etraining.course.entity.ContentServer;
import com.kingnod.etraining.course.samplerte.server.UploadServer;
import com.kingnod.etraining.course.server.models.FolderNode;
import com.kingnod.etraining.course.service.ContentServerService;
import com.opensymphony.xwork2.ActionSupport;

@org.springframework.stereotype.Controller
@Namespace("/crs")
public class FolderSelectorAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private ContentServerService contentServic;
	private List<FolderNode> result = null;
	private String contentServer;
	private FolderNode fNode;
	private int id = 0;
	private String path = "";
	
	public List<FolderNode> getResult() {
		return result;
	}

	public void setResult(List<FolderNode> result) {
		this.result = result;
	}
	
	public void setContentServer(String contentServer) {
		this.contentServer = contentServer;
	}

	public String getContentServer() {
		return contentServer;
	}
	
	
	public String folderSelector() throws Exception {
		File file = null;
		ContentServer server = contentServic.getContentServer(Long.valueOf(contentServer));
		if(com.kingnod.core.util.StringUtils.isEmpty(path)){
			file = new File(server.getFtpUserName());
		}else{
			file = new File(server.getFtpUserName().concat(File.separator).concat(path));
		}
		if(file.isDirectory()){
			result = UploadServer.getDirectoriesNameList(new ArrayList<FolderNode>(),file,path,id);
		}
		
		JsonConfig jsonconfig = new JsonConfig();
		jsonconfig.registerJsonBeanProcessor(FolderNode.class, new JsonBeanProcessor(){

			public JSONObject processBean(Object bean, JsonConfig jsonConfig) {
				FolderNode folder = (FolderNode)bean;
				JSONObject jsonobj = new JSONObject();
				jsonobj.element("childNode", folder.isChildNode())
				.element("click", folder.isClick())
				.element("editable", folder.isEditable())
				.element("icon", folder.getIcon())
				.element("id", folder.getId())
				.element("name", folder.getName())
				.element("nodeType", folder.getNodeType())
				.element("isParent", folder.isParent())
				.element("pId", folder.getParentId())
				.element("path", folder.getPath());
				return jsonobj;
			}});
		
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonRoot", result);
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonconfig", jsonconfig);
		
		return "jsonResult";
		
	}

	public FolderNode getfNode() {
		return fNode;
	}

	public void setfNode(FolderNode fNode) {
		this.fNode = fNode;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	

}
