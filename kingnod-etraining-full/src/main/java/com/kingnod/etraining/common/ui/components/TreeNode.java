package com.kingnod.etraining.common.ui.components;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.kingnod.core.util.SysParameterUtils;

/**
 * 保存节点数据
 * 
 * @author Chujiang
 * 
 */
public class TreeNode implements Serializable {

	private static final long serialVersionUID = -1249283954595909832L;

	public static final String SITE = "S";
	public static final String ORGANIZATION = "O";
	public static final String USER = "U";
	public static final String USER_GROUP = "G";
	public static final String ACTIVITY_FOLDER = "A";
	public static final String RESOURCE_FOLDER = "R";

	private String id;

	private String parentId;

	private String name;

	private boolean open;

	private boolean isParent;

	private String icon;

	private String iconOpen;

	private String iconClose;

	private String iconSkin;

	private String font;

	private String nodeType;

	private String src;

	private String openMode;

	private String target;

	private boolean editable = true;
	
	private boolean childNode = true;
	
	private boolean isRoot = false;
	
	private Integer width = 150;
	
	private boolean click = true;
	
	public boolean isClick() {
    return click;
  }

  public void setClick(boolean click) {
    this.click = click;
  }

  private List<ContextMenu> contextMenus = new ArrayList<ContextMenu>();

	public TreeNode(String id, String name, boolean isParent) {
		this.id = id;
		this.name = name;
		this.isParent = isParent;
		Integer tmpWidth = SysParameterUtils.getInteger("sys.tree_node_input_width");
		if(!new Integer(-1).equals(tmpWidth)){
			width = tmpWidth;
		}
	}

	public TreeNode(String id, String parentId, String name, boolean isParent) {
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

	@org.apache.struts2.json.annotations.JSON(name = "open")
	public boolean isOpen() {
		return open;
	}

	@org.apache.struts2.json.annotations.JSON(name = "icon")
	public String getIcon() {
		return icon;
	}

	@org.apache.struts2.json.annotations.JSON(name = "iconOpen")
	public String getIconOpen() {
		return iconOpen;
	}

	@org.apache.struts2.json.annotations.JSON(name = "iconClose")
	public String getIconClose() {
		return iconClose;
	}

	@org.apache.struts2.json.annotations.JSON(name = "iconSkin")
	public String getIconSkin() {
		return iconSkin;
	}

	@org.apache.struts2.json.annotations.JSON(name = "font")
	public String getFont() {
		return font;
	}

	@org.apache.struts2.json.annotations.JSON(name = "src")
	public String getSrc() {
		return src;
	}

	@org.apache.struts2.json.annotations.JSON(name = "nodeType")
	public String getNodeType() {
		return nodeType;
	}

	@org.apache.struts2.json.annotations.JSON(name = "openMode")
	public String getOpenMode() {
		return openMode;
	}

	@org.apache.struts2.json.annotations.JSON(name = "target")
	public String getTarget() {
		return target;
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

	public void setSrc(String src) {
		this.src = src;
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
	 * 设置节点的 展开/折叠 状态。<br/>
	 * 1、初始化节点数据时，如果设定 treeNode.open = true，则会直接展开此节点<br/>
	 * 2、叶子节点 treeNode.open = false
	 */
	public void setOpen(boolean open) {
		this.open = open;
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

	/**
	 * 设置父节点自定义展开时图标的 URL 路径。<br/>
	 * 1、此属性只针对父节点有效<br/>
	 * 2、此属性必须与 iconClose 同时使用<br/>
	 * 3、如果想利用 className 设置个性化图标，需要设置 treeNode.iconSkin 属性<br/>
	 */
	public void setIconOpen(String iconOpen) {
		this.iconOpen = iconOpen;
	}

	/**
	 * 设置父节点自定义折叠时图标的 URL 路径。<br/>
	 * 1、此属性只针对父节点有效<br/>
	 * 2、此属性必须与 iconOpen 同时使用<br/>
	 * 3、如果想利用 className 设置个性化图标，需要设置 treeNode.iconSkin 属性<br/>
	 */
	public void setIconClose(String iconClose) {
		this.iconClose = iconClose;
	}

	/**
	 * 节点自定义图标的 className<br/>
	 * 1、需要修改 css，增加相应 className 的设置<br/>
	 * 2、css 方式简单、方便，并且同时支持父节点展开、折叠状态切换图片<br/>
	 * 3、css 建议采用图片分割渲染的方式以减少反复加载图片，并且避免图片闪动<br/>
	 * 4、zTree v3.0 的 iconSkin 同样支持 IE6<br/>
	 * 5、如果想直接使用 图片的Url路径 设置节点的个性化图标，需要设置 treeNode.icon / treeNode.iconOpen /
	 * treeNode.iconClose 属性
	 */
	public void setIconSkin(String iconSkin) {
		this.iconSkin = iconSkin;
	}

	/**
	 * 设置节点个性化文字样式，只针对 zTree 在节点上显示的<A>对象。 例如：{color:"#ff0011",
	 * background:"blue"}
	 */
	public void setFont(String font) {
		this.font = font;
	}

	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}

	/**
	 * 当openMode=target时， 设置在指定的窗口打开
	 * 
	 * @param target
	 */
	public void setTarget(String target) {
		this.target = target;
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

}
