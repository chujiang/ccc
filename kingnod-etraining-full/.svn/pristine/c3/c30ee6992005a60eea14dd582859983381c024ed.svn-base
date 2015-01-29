package com.kingnod.etraining.common.action;

import java.util.List;

import net.sf.json.JsonConfig;

import org.apache.commons.lang.xwork.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import com.kingnod.core.exception.ApplicationException;
import com.kingnod.core.extensions.struts2.action.ExtendedActionSupport;
import com.kingnod.core.util.web.Struts2Utils;
import com.kingnod.etraining.common.entity.Type;
import com.kingnod.etraining.common.service.TypeService;
import com.kingnod.etraining.common.tree.TreeViewUtils;
import com.kingnod.etraining.common.ui.components.TreeNode;

//@ParentPackage("json-default")
@Namespace("/cmn")
/*@Results({
		@Result(type = "json", name = "success", params = {
				"root",
				"result",
				"includeProperties",
				"\\[\\d+\\]\\.id, \\[\\d+\\]\\.pId, \\[\\d+\\]\\.width, \\[\\d+\\]\\.isRoot, \\[\\d+\\]\\.childNode, \\[\\d+\\]\\.name, \\[\\d+\\]\\.editable, \\[\\d+\\]\\.isParent,\\[\\d+\\]\\.src, \\[\\d+\\]\\.open, "
						+ "\\[\\d+\\]\\.icon, \\[\\d+\\]\\.iconOpen, \\[\\d+\\]\\.iconClose, \\[\\d+\\]\\.iconSkin, \\[\\d+\\]\\.font, \\[\\d+\\]\\.nodeType,"
						+ "\\[\\d+\\]\\.openMode, \\[\\d+\\]\\.target," }),
						
		@Result(type = "json", name = "save", params = {
				"root",
				"newTreeNode",
				"includeProperties",
				"\\.id, \\.pId, \\.width, \\.isRoot, \\.childNode,  \\.name, \\.editable, \\.isParent, \\.open, "
						+ "\\.icon, \\.iconOpen, \\.iconClose, \\.iconSkin, \\.font" })})*/
public class TypeeAction extends ExtendedActionSupport {

	private static final long serialVersionUID = 4242612202520616657L;
	@Autowired
	@com.kingnod.core.annotation.Generated("2012-02-13 09:20")
	private TypeService typeService;
	private Long siteId = 0L;
	private Long id = 0L;
	private String nodeType = StringUtils.EMPTY;
	private List<TreeNode> result = null;
	private Long typeId = 0L;
	private Long parentId = 0L;
	private String typeName = StringUtils.EMPTY;
	private TreeNode newTreeNode;
	
	//拖拽节点时，父节点的Id
	private Long targetId;

	public String execute() throws Exception {
		List<Type> listType = typeService.getTreeNodeList(id, nodeType,siteId);
		
		JsonConfig jsonconfig = new JsonConfig();
		jsonconfig.registerJsonBeanProcessor(Type.class, TreeViewUtils.viewTypeListProcessor);
		
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonRoot", listType);
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonconfig", jsonconfig);
		
		return "jsonResult";
	}

	/**
	 * 新建节点
	 */
	public String saveType() throws Exception {
		Type type = new Type();
		type.setRoot(false);
		type.setSiteId(0L);
		type.setParentId(parentId);
		type.setName("");
		type.setStatus("A");

		type.setDescription("");
		//type.setChildLevel((short)0);
		// 获取父节点的Object_Type
		if(parentId > 0){
			Type pType = typeService.getType(parentId);
			type.setObjectType(pType.getObjectType());
			type.setChildLevel(pType.getChildLevel() == -1 ? -1 : (short)(pType.getChildLevel()-1));
		}

		typeService.saveType(type);
		
		JsonConfig jsonconfig = new JsonConfig();
		
		jsonconfig.registerJsonBeanProcessor(Type.class, TreeViewUtils.viewTypeProcessor);
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonRoot", type);//MapUtils.mapByAarray("type",type)
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonconfig", jsonconfig);
		return "jsonResult";
	}
	
	/**
	 * 修改
	 * 
	 * @return String
	 * @throws Exception
	 */
	public String update()  {
		if(StringUtils.isEmpty(typeName)){
			throw new ApplicationException("cmn002001");
		}
		typeService.updateType(typeId, typeName);
		Type type = typeService.getType(typeId);
		
//		newTreeNode = new TreeNode(String.valueOf(type.getId()), type.getName(), false);
//		newTreeNode.setParentId(String.valueOf(type.getParentId()));
//		newTreeNode.setEditable(true);
		
		JsonConfig jsonconfig = new JsonConfig();
		
		jsonconfig.registerJsonBeanProcessor(Type.class, TreeViewUtils.viewTypeProcessor);
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonRoot", type);//MapUtils.mapByAarray("type",type)
		ServletActionContext.getValueStack(Struts2Utils.getRequest()).set("jsonconfig", jsonconfig);
		return "jsonResult";
	}
	
	
	/**
	 * 删除
	 * 
	 * @return String
	 * @throws Exception
	 */
	public String delete() throws Exception {
		typeService.deleteTypes(typeId);
		return StringUtils.EMPTY;
	}

	public Long getTargetId() {
		return targetId;
	}
	public void setTargetId(Long targetId) {
		this.targetId = targetId;
	}

	public Long getSiteId() {
		return siteId;
	}

	public void setSiteId(Long siteId) {
		this.siteId = siteId;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNodeType() {
		return nodeType;
	}

	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}

	public List<TreeNode> getResult() {
		return result;
	}

	public void setResult(List<TreeNode> result) {
		this.result = result;
	}
	public TreeNode getNewTreeNode() {
		return newTreeNode;
	}

	public void setNewTreeNode(TreeNode newTreeNode) {
		this.newTreeNode = newTreeNode;
	}
}
