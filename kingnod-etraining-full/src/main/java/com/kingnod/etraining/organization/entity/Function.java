package com.kingnod.etraining.organization.entity;

import com.kingnod.core.criteria.annotations.SelectColumnMapping;
import com.kingnod.core.criteria.annotations.SelectColumnMappings;

@SelectColumnMappings({
  @SelectColumnMapping(property = "id", type = java.lang.Long.class, table = "SYS_FUNCTION", tableAlias = "A", column = "ID"), 
  @SelectColumnMapping(property = "name", type = java.lang.String.class, table = "SYS_FUNCTION", tableAlias = "A", column = "NAME"), 
  @SelectColumnMapping(property = "type", type = java.lang.String.class, table = "SYS_FUNCTION", tableAlias = "A", column = "TYPE"), 
  @SelectColumnMapping(property = "description", type = java.lang.String.class, table = "SYS_FUNCTION", tableAlias = "A", column = "DESCRIPTION"), 
  @SelectColumnMapping(property = "parentId", type = java.lang.Long.class, table = "SYS_FUNCTION", tableAlias = "A", column = "PARENT_ID"), 
  @SelectColumnMapping(property = "uri", type = java.lang.String.class, table = "SYS_FUNCTION", tableAlias = "A", column = "URI"), 
  @SelectColumnMapping(property = "position", type = java.lang.Short.class, table = "SYS_FUNCTION", tableAlias = "A", column = "POSITION"), 
  @SelectColumnMapping(property = "enable", type = java.lang.String.class, table = "SYS_FUNCTION", tableAlias = "A", column = "ENABLE"), 
  @SelectColumnMapping(property = "isLeaf", type = java.lang.String.class, table = "SYS_FUNCTION", tableAlias = "A", column = "IS_LEAF")
})

    @com.kingnod.core.annotation.Generated("2012-03-12 16:51")
public class Function {

    /**
     * null<br/>
     * 对应数据库字段 ETRAINING.SYS_FUNCTION.ID
     *
     * @mbggenerated 2012-03-12 16:54
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-12 16:51")
    private Long id;

    /**
     * 系统功能名称<br/>
     * 对应数据库字段 ETRAINING.SYS_FUNCTION.NAME
     *
     * @mbggenerated 2012-03-12 16:54
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-12 16:51")
    private String name;

    /**
     * 系统功能类型： SYS_MENU-系统功能菜单 <br/>
     * 对应数据库字段 ETRAINING.SYS_FUNCTION.TYPE
     *
     * @mbggenerated 2012-03-12 16:54
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-12 16:51")
    private String type;

    /**
     * 功能描述<br/>
     * 对应数据库字段 ETRAINING.SYS_FUNCTION.DESCRIPTION
     *
     * @mbggenerated 2012-03-12 16:54
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-12 16:51")
    private String description;

    /**
     * 父功能ID -1 表示此功能对象为根结点<br/>
     * 对应数据库字段 ETRAINING.SYS_FUNCTION.PARENT_ID
     *
     * @mbggenerated 2012-03-12 16:54
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-12 16:51")
    private Long parentId;

    /**
     * 此功能对应的URI，定义时可以加入下面前缀，不加前缀刚默认为url url:表示此资源为一个url class:表示对应一个自定义的class bean:表示对应一个spring中的bean<br/>
     * 对应数据库字段 ETRAINING.SYS_FUNCTION.URI
     *
     * @mbggenerated 2012-03-12 16:54
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-12 16:51")
    private String uri;

    /**
     * 功能菜单的显示位置<br/>
     * 对应数据库字段 ETRAINING.SYS_FUNCTION.POSITION
     *
     * @mbggenerated 2012-03-12 16:54
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-12 16:51")
    private Short position;

    /**
     * 是否禁用此功能 1-启用 0-禁用<br/>
     * 对应数据库字段 ETRAINING.SYS_FUNCTION.ENABLE
     *
     * @mbggenerated 2012-03-12 16:54
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-12 16:51")
    private String enable;

    /**
     * 是否叶子节点
1-是
0-否<br/>
     * 对应数据库字段 ETRAINING.SYS_FUNCTION.IS_LEAF
     *
     * @mbggenerated 2012-03-12 16:54
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-12 16:51")
    private String isLeaf;


    /**
     * 返回: null<br>
     * 对应数据库字段: ETRAINING.SYS_FUNCTION.ID
     *
     * @返回  ETRAINING.SYS_FUNCTION.ID
     *
     * @mbggenerated 2012-03-12 16:54
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-12 16:51")
    public Long getId() {
        return id;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: ETRAINING.SYS_FUNCTION.ID
     *
     * @param id null
     *
     * @mbggenerated 2012-03-12 16:54
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-12 16:51")
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 返回: 系统功能名称<br>
     * 对应数据库字段: ETRAINING.SYS_FUNCTION.NAME
     *
     * @返回  ETRAINING.SYS_FUNCTION.NAME
     *
     * @mbggenerated 2012-03-12 16:54
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-12 16:51")
    public String getName() {
        return name;
    }

    /**
     *  设置: 系统功能名称<br>
     * 对应数据库字段: ETRAINING.SYS_FUNCTION.NAME
     *
     * @param name 系统功能名称
     *
     * @mbggenerated 2012-03-12 16:54
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-12 16:51")
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 返回: 系统功能类型： SYS_MENU-系统功能菜单 <br>
     * 对应数据库字段: ETRAINING.SYS_FUNCTION.TYPE
     *
     * @返回  ETRAINING.SYS_FUNCTION.TYPE
     *
     * @mbggenerated 2012-03-12 16:54
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-12 16:51")
    public String getType() {
        return type;
    }

    /**
     *  设置: 系统功能类型： SYS_MENU-系统功能菜单 <br>
     * 对应数据库字段: ETRAINING.SYS_FUNCTION.TYPE
     *
     * @param type 系统功能类型： SYS_MENU-系统功能菜单 
     *
     * @mbggenerated 2012-03-12 16:54
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-12 16:51")
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 返回: 功能描述<br>
     * 对应数据库字段: ETRAINING.SYS_FUNCTION.DESCRIPTION
     *
     * @返回  ETRAINING.SYS_FUNCTION.DESCRIPTION
     *
     * @mbggenerated 2012-03-12 16:54
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-12 16:51")
    public String getDescription() {
        return description;
    }

    /**
     *  设置: 功能描述<br>
     * 对应数据库字段: ETRAINING.SYS_FUNCTION.DESCRIPTION
     *
     * @param description 功能描述
     *
     * @mbggenerated 2012-03-12 16:54
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-12 16:51")
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 返回: 父功能ID -1 表示此功能对象为根结点<br>
     * 对应数据库字段: ETRAINING.SYS_FUNCTION.PARENT_ID
     *
     * @返回  ETRAINING.SYS_FUNCTION.PARENT_ID
     *
     * @mbggenerated 2012-03-12 16:54
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-12 16:51")
    public Long getParentId() {
        return parentId;
    }

    /**
     *  设置: 父功能ID -1 表示此功能对象为根结点<br>
     * 对应数据库字段: ETRAINING.SYS_FUNCTION.PARENT_ID
     *
     * @param parentId 父功能ID -1 表示此功能对象为根结点
     *
     * @mbggenerated 2012-03-12 16:54
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-12 16:51")
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * 返回: 此功能对应的URI，定义时可以加入下面前缀，不加前缀刚默认为url url:表示此资源为一个url class:表示对应一个自定义的class bean:表示对应一个spring中的bean<br>
     * 对应数据库字段: ETRAINING.SYS_FUNCTION.URI
     *
     * @返回  ETRAINING.SYS_FUNCTION.URI
     *
     * @mbggenerated 2012-03-12 16:54
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-12 16:51")
    public String getUri() {
        return uri;
    }

    /**
     *  设置: 此功能对应的URI，定义时可以加入下面前缀，不加前缀刚默认为url url:表示此资源为一个url class:表示对应一个自定义的class bean:表示对应一个spring中的bean<br>
     * 对应数据库字段: ETRAINING.SYS_FUNCTION.URI
     *
     * @param uri 此功能对应的URI，定义时可以加入下面前缀，不加前缀刚默认为url url:表示此资源为一个url class:表示对应一个自定义的class bean:表示对应一个spring中的bean
     *
     * @mbggenerated 2012-03-12 16:54
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-12 16:51")
    public void setUri(String uri) {
        this.uri = uri == null ? null : uri.trim();
    }

    /**
     * 返回: 功能菜单的显示位置<br>
     * 对应数据库字段: ETRAINING.SYS_FUNCTION.POSITION
     *
     * @返回  ETRAINING.SYS_FUNCTION.POSITION
     *
     * @mbggenerated 2012-03-12 16:54
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-12 16:51")
    public Short getPosition() {
        return position;
    }

    /**
     *  设置: 功能菜单的显示位置<br>
     * 对应数据库字段: ETRAINING.SYS_FUNCTION.POSITION
     *
     * @param position 功能菜单的显示位置
     *
     * @mbggenerated 2012-03-12 16:54
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-12 16:51")
    public void setPosition(Short position) {
        this.position = position;
    }

    /**
     * 返回: 是否禁用此功能 1-启用 0-禁用<br>
     * 对应数据库字段: ETRAINING.SYS_FUNCTION.ENABLE
     *
     * @返回  ETRAINING.SYS_FUNCTION.ENABLE
     *
     * @mbggenerated 2012-03-12 16:54
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-12 16:51")
    public String getEnable() {
        return enable;
    }

    /**
     *  设置: 是否禁用此功能 1-启用 0-禁用<br>
     * 对应数据库字段: ETRAINING.SYS_FUNCTION.ENABLE
     *
     * @param enable 是否禁用此功能 1-启用 0-禁用
     *
     * @mbggenerated 2012-03-12 16:54
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-12 16:51")
    public void setEnable(String enable) {
        this.enable = enable == null ? null : enable.trim();
    }

    /**
     * 返回: 是否叶子节点
1-是
0-否<br>
     * 对应数据库字段: ETRAINING.SYS_FUNCTION.IS_LEAF
     *
     * @返回  ETRAINING.SYS_FUNCTION.IS_LEAF
     *
     * @mbggenerated 2012-03-12 16:54
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-12 16:51")
    public String getIsLeaf() {
        return isLeaf;
    }

    /**
     *  设置: 是否叶子节点
1-是
0-否<br>
     * 对应数据库字段: ETRAINING.SYS_FUNCTION.IS_LEAF
     *
     * @param isLeaf 是否叶子节点
1-是
0-否
     *
     * @mbggenerated 2012-03-12 16:54
     */
    
    @com.kingnod.core.annotation.Generated("2012-03-12 16:51")
    public void setIsLeaf(String isLeaf) {
        this.isLeaf = isLeaf == null ? null : isLeaf.trim();
    }
}