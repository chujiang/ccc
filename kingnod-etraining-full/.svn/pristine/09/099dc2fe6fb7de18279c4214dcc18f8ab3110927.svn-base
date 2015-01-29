package com.kingnod.etraining.course.server.models;

import java.util.ArrayList;
import java.util.List;

import com.kingnod.core.util.SysParameterUtils;
import com.kingnod.etraining.common.ui.components.ContextMenu;

public class FolderNode {
	public static final String COURSEWARE = "W";
	public static final String COURSE_FOLDER = "C";
	private String id;

	private String parentId;

	private String name;

	private boolean isParent;

	private boolean click;
	
	private String icon;

	private String nodeType;

	private String openMode;
	
	private String path;

	private boolean editable = true;
	
	private boolean childNode = true;
	
	private boolean isRoot = false;
	
	private Integer width = 150;
	
	private List<ContextMenu> contextMenus = new ArrayList<ContextMenu>();

	public FolderNode(String id, String name, boolean isParent) {
		this.id = id;
		this.name = name;
		this.isParent = isParent;
		Integer tmpWidth = SysParameterUtils.getInteger("sys.tree_node_input_width");
		if(!new Integer(-1).equals(tmpWidth)){
			width = tmpWidth;
		}
	}

	public FolderNode(String id, String parentId, String name, boolean isParent) {
		this.id = id;
		this.name = name;
		this.isParent = isParent;
		this.parentId = parentId;
	}

	@org.apache.struts2.json.annotations.JSON(name = "id")
	public String getId() {
		return id;
	}

	@org.apache.struts2.json.annotations.JSON(name = "pId")
	public String getParentId() {
		return parentId;
	}

	@org.apache.struts2.json.annotations.JSON(name = "name")
	public String getName() {
		return null!=name?name.trim():"";
	}

	@org.apache.struts2.json.annotations.JSON(name = "isParent")
	public boolean isParent() {
		return isParent;
	}



	@org.apache.struts2.json.annotations.JSON(name = "icon")
	public String getIcon() {
		return icon;
	}

	@org.apache.struts2.json.annotations.JSON(name = "nodeType")
	public String getNodeType() {
		return nodeType;
	}

	@org.apache.struts2.json.annotations.JSON(name = "openMode")
	public String getOpenMode() {
		return openMode;
	}


	@org.apache.struts2.json.annotations.JSON(name = "contextMenus")
	public List<ContextMenu> getContextMenus() {
		return contextMenus;
	}

	@org.apache.struts2.json.annotations.JSON(name = "editable")
	public boolean isEditable() {
		return editable;
	}
	
	@org.apache.struts2.json.annotations.JSON(name = "childNode")
	public boolean isChildNode() {
		return childNode;
	}

	@org.apache.struts2.json.annotations.JSON(name = "width")
	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	/**
	 * 判断当前节点是否能添加子节点
	 * @param childNode
	 */
	public void setChildNode(boolean childNode) {
		this.childNode = childNode;
	}

	@org.apache.struts2.json.annotations.JSON(name = "isRoot")
	public boolean isRoot() {
		return isRoot;
	}

	public void setRoot(boolean isRoot) {
		this.isRoot = isRoot;
	}

	/**
	 * 设置根节点不能编辑和删除
	 * @param editable
	 */
	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	/**
	 * 设置节点的id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 设置父节点id， 要使用这个属性，必须设置 setting.data.simple 内的属
	 */
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	/**
	 * 设置节点的名称
	 */
	public void setName(String name) {
		 this.name = name == null ? "" : name.trim();
	}

	/**
	 * 设置节点是否为父节点。
	 */
	public void setParent(boolean isParent) {
		this.isParent = isParent;
	}

	/**
	 * 设置节点自定义图标的 URL 路径。<br/>
	 * 1、父节点如果只设置 icon ，会导致展开、折叠时都使用同一个图标<br/>
	 * 2、父节点展开、折叠使用不同的个性化图标需要同时设置 treeNode.iconOpen/treeNode.iconClose 两个属性<br/>
	 * 3、如果想利用 className 设置个性化图标，需要设置 treeNode.iconSkin 属性
	 * 
	 * @param icon
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}

	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}

	/**
	 * 窗口打开方式：self(在本窗口打开), popup(弹出子窗口), dialog(模式对话框),
	 * target(在target属性指定的窗口打开)
	 * 
	 * @param openMode
	 */
	public void setOpenMode(String openMode) {
		this.openMode = openMode;
	}

	/**
	 * 添加节点的右键菜单
	 * 
	 * @param contextMenu
	 */
	public void addContextMenus(ContextMenu contextMenu) {
		this.contextMenus.add(contextMenu);
	}
	@org.apache.struts2.json.annotations.JSON(name = "path")
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public boolean isClick() {
		return click;
	}
	@org.apache.struts2.json.annotations.JSON(name = "click")
	public void setClick(boolean click) {
		this.click = click;
	}

	
	
}
