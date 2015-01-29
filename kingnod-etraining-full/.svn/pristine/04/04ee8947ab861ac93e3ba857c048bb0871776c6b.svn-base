package com.kingnod.etraining.exam.action;

import java.util.List;

import net.sf.json.JsonConfig;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.criteria.Cnd;
import com.kingnod.core.criteria.CriteriaBuilder;
import com.kingnod.core.pager.PagingResult;
import com.kingnod.core.util.StringUtils;
import com.kingnod.core.util.collection.ListUtils;
import com.kingnod.core.util.web.Struts2Utils;
import com.kingnod.etraining.common.ObjectType;
import com.kingnod.etraining.common.action.ObjectPickerAction;
import com.kingnod.etraining.common.tree.TreeViewUtils;
import com.kingnod.etraining.resource.entity.ResourceFolder;
import com.kingnod.etraining.resource.service.ResourceFolderService;

@org.springframework.stereotype.Controller
@Namespace("/exm")
public class QuestionPickerAction extends ObjectPickerAction {

	/**
	 * 选择题库
	 */
	private static final long serialVersionUID = 4406209287925863200L;
	@Autowired
	private ResourceFolderService resourceFolderService;
	
	private String keyword;

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	public String tree() throws Exception {
		//List<?> childs = treeService.getChildsByFilterTypes(null==id?0L:id, nodeType, ListUtils.of("O_OS;R_QM;R_QF;".split(";")));
		List<?> childs =null;
		if(null!=keyword){
			if(StringUtils.isNotEmpty(keyword.trim())){
				childs = treeService.getResourceTreeViewChilds(id, keyword.trim(),ObjectType.R_QF.toString(), ObjectType.R_OS, ObjectType.R_QF, ObjectType.R_QF);
			}else{
				childs = treeService.getResourceViewChilds(id, ObjectType.R_OS, ObjectType.R_QF);
			}
			
		}else{
			childs = treeService.getResourceViewChilds(id, ObjectType.R_OS, ObjectType.R_QF);
		}
		JsonConfig jsonconfig = new JsonConfig();
		jsonconfig.registerJsonBeanProcessor(ResourceFolder.class, TreeViewUtils.pickerResFolderProcessor);
		
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonRoot", childs);
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonconfig", jsonconfig);
		
		return "jsonResult";
	}
	
	public String list() throws Exception {
		CriteriaBuilder cb = Cnd.builder(ResourceFolder.class);
		cb.andEQ("parentId", id).andIn("type", ListUtils.of(ObjectType.R_QF, ObjectType.R_QB));
		PagingResult<ResourceFolder> result = resourceFolderService.findResourceFolder(cb.buildCriteria());
		
		JsonConfig jsonconfig = new JsonConfig();
		jsonconfig.registerJsonBeanProcessor(ResourceFolder.class, TreeViewUtils.basicResFolderProcessor);
		
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonRoot", result.getResult());
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonconfig", jsonconfig);
		
		return "jsonResult";
	}
	
	@Override
	public String name() throws Exception {
		long objids[] = this.getObjId();
	    if(objids == null) {
	    	return "jsonResult";
		}
		CriteriaBuilder cb = Cnd.builder(ResourceFolder.class);
		for(long objid: objids){
			cb.orEQ("id",objid );
		}
		PagingResult<ResourceFolder> result = resourceFolderService.findResourceFolder(cb.buildCriteria());
		
		JsonConfig jsonconfig = new JsonConfig();
		jsonconfig.registerJsonBeanProcessor(ResourceFolder.class, TreeViewUtils.basicResFolderProcessor);
		
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonRoot", result.getResult());
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonconfig", jsonconfig);
		
		return "jsonResult";
	}
}
