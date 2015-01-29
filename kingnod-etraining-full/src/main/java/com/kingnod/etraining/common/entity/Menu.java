package com.kingnod.etraining.common.entity;

import java.math.BigDecimal;

import com.kingnod.core.criteria.annotations.SelectColumnMapping;
import com.kingnod.core.criteria.annotations.SelectColumnMappings;

@SelectColumnMappings({
  @SelectColumnMapping(property = "id", type = java.lang.Long.class, table = "SYS_MENU", tableAlias = "A", column = "ID"), 
  @SelectColumnMapping(property = "parentId", type = java.lang.Long.class, table = "SYS_MENU", tableAlias = "A", column = "PARENT_ID"), 
  @SelectColumnMapping(property = "name", type = java.lang.String.class, table = "SYS_MENU", tableAlias = "A", column = "NAME"), 
  @SelectColumnMapping(property = "type", type = java.lang.String.class, table = "SYS_MENU", tableAlias = "A", column = "TYPE"), 
  @SelectColumnMapping(property = "url", type = java.lang.String.class, table = "SYS_MENU", tableAlias = "A", column = "URL"), 
  @SelectColumnMapping(property = "icon", type = java.lang.String.class, table = "SYS_MENU", tableAlias = "A", column = "ICON"), 
  @SelectColumnMapping(property = "iconType", type = java.lang.String.class, table = "SYS_MENU", tableAlias = "A", column = "ICON_TYPE"), 
  @SelectColumnMapping(property = "description", type = java.lang.String.class, table = "SYS_MENU", tableAlias = "A", column = "DESCRIPTION"), 
  @SelectColumnMapping(property = "code", type = java.lang.String.class, table = "SYS_MENU", tableAlias = "A", column = "CODE"), 
  @SelectColumnMapping(property = "cssClass", type = java.lang.String.class, table = "SYS_MENU", tableAlias = "A", column = "CSS_CLASS"), 
  @SelectColumnMapping(property = "serialNumber", type = java.lang.Long.class, table = "SYS_MENU", tableAlias = "A", column = "SERIAL_NUMBER"), 
  @SelectColumnMapping(property = "openMode", type = java.lang.String.class, table = "SYS_MENU", tableAlias = "A", column = "OPEN_MODE"), 
  @SelectColumnMapping(property = "authId", type = java.lang.Long.class, table = "SYS_MENU", tableAlias = "A", column = "AUTH_ID"), 
  @SelectColumnMapping(property = "authorityValue", type = java.math.BigDecimal.class, table = "SYS_ENTITY_AUTHORITY", tableAlias = "B", column = "AUTHORITY_VALUE"), 
  @SelectColumnMapping(property = "authorityName", type = java.lang.String.class, table = "SYS_ENTITY_AUTHORITY", tableAlias = "B", column = "AUTHORITY_NAME")
})

    @com.kingnod.core.annotation.Generated("2012-05-17 11:35")
public class Menu {

    /**
     * null<br/>
     * 对应数据库字段 E0515.SYS_MENU.ID
     *
     * @mbggenerated 2012-05-17 11:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-17 11:35")
    private Long id;

    /**
     * ?ID<br/>
     * 对应数据库字段 E0515.SYS_MENU.PARENT_ID
     *
     * @mbggenerated 2012-05-17 11:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-17 11:35")
    private Long parentId;

    /**
     * ????<br/>
     * 对应数据库字段 E0515.SYS_MENU.NAME
     *
     * @mbggenerated 2012-05-17 11:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-17 11:35")
    private String name;

    /**
     * ????


<br/>
     * 对应数据库字段 E0515.SYS_MENU.TYPE
     *
     * @mbggenerated 2012-05-17 11:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-17 11:35")
    private String type;

    /**
     * ??????<br/>
     * 对应数据库字段 E0515.SYS_MENU.URL
     *
     * @mbggenerated 2012-05-17 11:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-17 11:35")
    private String url;

    /**
     * ????<br/>
     * 对应数据库字段 E0515.SYS_MENU.ICON
     *
     * @mbggenerated 2012-05-17 11:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-17 11:35")
    private String icon;

    /**
     * ??????
1-img?????
2-??div?span???class<br/>
     * 对应数据库字段 E0515.SYS_MENU.ICON_TYPE
     *
     * @mbggenerated 2012-05-17 11:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-17 11:35")
    private String iconType;

    /**
     * ??<br/>
     * 对应数据库字段 E0515.SYS_MENU.DESCRIPTION
     *
     * @mbggenerated 2012-05-17 11:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-17 11:35")
    private String description;

    /**
     * ????<br/>
     * 对应数据库字段 E0515.SYS_MENU.CODE
     *
     * @mbggenerated 2012-05-17 11:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-17 11:35")
    private String code;

    /**
     * null<br/>
     * 对应数据库字段 E0515.SYS_MENU.CSS_CLASS
     *
     * @mbggenerated 2012-05-17 11:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-17 11:35")
    private String cssClass;

    /**
     * null<br/>
     * 对应数据库字段 E0515.SYS_MENU.SERIAL_NUMBER
     *
     * @mbggenerated 2012-05-17 11:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-17 11:35")
    private Long serialNumber;

    /**
     * ????<br/>
     * 对应数据库字段 E0515.SYS_MENU.OPEN_MODE
     *
     * @mbggenerated 2012-05-17 11:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-17 11:35")
    private String openMode;

    /**
     * null<br/>
     * 对应数据库字段 E0515.SYS_MENU.AUTH_ID
     *
     * @mbggenerated 2012-05-17 11:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-17 11:35")
    private Long authId;

    /**
     * 权限值<br/>
     * 对应数据库字段 E0515.SYS_MENU.AUTHORITY_VALUE
     *
     * @mbggenerated 2012-05-17 11:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-17 11:35")
    private BigDecimal authorityValue;

    /**
     * 权限名<br/>
     * 对应数据库字段 E0515.SYS_MENU.AUTHORITY_NAME
     *
     * @mbggenerated 2012-05-17 11:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-17 11:35")
    private String authorityName;


    /**
     * 返回: null<br>
     * 对应数据库字段: E0515.SYS_MENU.ID
     *
     * @返回  E0515.SYS_MENU.ID
     *
     * @mbggenerated 2012-05-17 11:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-17 11:35")
    public Long getId() {
        return id;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: E0515.SYS_MENU.ID
     *
     * @param id null
     *
     * @mbggenerated 2012-05-17 11:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-17 11:35")
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 返回: ?ID<br>
     * 对应数据库字段: E0515.SYS_MENU.PARENT_ID
     *
     * @返回  E0515.SYS_MENU.PARENT_ID
     *
     * @mbggenerated 2012-05-17 11:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-17 11:35")
    public Long getParentId() {
        return parentId;
    }

    /**
     *  设置: ?ID<br>
     * 对应数据库字段: E0515.SYS_MENU.PARENT_ID
     *
     * @param parentId ?ID
     *
     * @mbggenerated 2012-05-17 11:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-17 11:35")
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * 返回: ????<br>
     * 对应数据库字段: E0515.SYS_MENU.NAME
     *
     * @返回  E0515.SYS_MENU.NAME
     *
     * @mbggenerated 2012-05-17 11:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-17 11:35")
    public String getName() {
        return name;
    }

    /**
     *  设置: ????<br>
     * 对应数据库字段: E0515.SYS_MENU.NAME
     *
     * @param name ????
     *
     * @mbggenerated 2012-05-17 11:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-17 11:35")
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 返回: ????


<br>
     * 对应数据库字段: E0515.SYS_MENU.TYPE
     *
     * @返回  E0515.SYS_MENU.TYPE
     *
     * @mbggenerated 2012-05-17 11:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-17 11:35")
    public String getType() {
        return type;
    }

    /**
     *  设置: ????


<br>
     * 对应数据库字段: E0515.SYS_MENU.TYPE
     *
     * @param type ????



     *
     * @mbggenerated 2012-05-17 11:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-17 11:35")
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 返回: ??????<br>
     * 对应数据库字段: E0515.SYS_MENU.URL
     *
     * @返回  E0515.SYS_MENU.URL
     *
     * @mbggenerated 2012-05-17 11:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-17 11:35")
    public String getUrl() {
        return url;
    }

    /**
     *  设置: ??????<br>
     * 对应数据库字段: E0515.SYS_MENU.URL
     *
     * @param url ??????
     *
     * @mbggenerated 2012-05-17 11:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-17 11:35")
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 返回: ????<br>
     * 对应数据库字段: E0515.SYS_MENU.ICON
     *
     * @返回  E0515.SYS_MENU.ICON
     *
     * @mbggenerated 2012-05-17 11:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-17 11:35")
    public String getIcon() {
        return icon;
    }

    /**
     *  设置: ????<br>
     * 对应数据库字段: E0515.SYS_MENU.ICON
     *
     * @param icon ????
     *
     * @mbggenerated 2012-05-17 11:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-17 11:35")
    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    /**
     * 返回: ??????
1-img?????
2-??div?span???class<br>
     * 对应数据库字段: E0515.SYS_MENU.ICON_TYPE
     *
     * @返回  E0515.SYS_MENU.ICON_TYPE
     *
     * @mbggenerated 2012-05-17 11:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-17 11:35")
    public String getIconType() {
        return iconType;
    }

    /**
     *  设置: ??????
1-img?????
2-??div?span???class<br>
     * 对应数据库字段: E0515.SYS_MENU.ICON_TYPE
     *
     * @param iconType ??????
1-img?????
2-??div?span???class
     *
     * @mbggenerated 2012-05-17 11:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-17 11:35")
    public void setIconType(String iconType) {
        this.iconType = iconType == null ? null : iconType.trim();
    }

    /**
     * 返回: ??<br>
     * 对应数据库字段: E0515.SYS_MENU.DESCRIPTION
     *
     * @返回  E0515.SYS_MENU.DESCRIPTION
     *
     * @mbggenerated 2012-05-17 11:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-17 11:35")
    public String getDescription() {
        return description;
    }

    /**
     *  设置: ??<br>
     * 对应数据库字段: E0515.SYS_MENU.DESCRIPTION
     *
     * @param description ??
     *
     * @mbggenerated 2012-05-17 11:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-17 11:35")
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 返回: ????<br>
     * 对应数据库字段: E0515.SYS_MENU.CODE
     *
     * @返回  E0515.SYS_MENU.CODE
     *
     * @mbggenerated 2012-05-17 11:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-17 11:35")
    public String getCode() {
        return code;
    }

    /**
     *  设置: ????<br>
     * 对应数据库字段: E0515.SYS_MENU.CODE
     *
     * @param code ????
     *
     * @mbggenerated 2012-05-17 11:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-17 11:35")
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: E0515.SYS_MENU.CSS_CLASS
     *
     * @返回  E0515.SYS_MENU.CSS_CLASS
     *
     * @mbggenerated 2012-05-17 11:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-17 11:35")
    public String getCssClass() {
        return cssClass;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: E0515.SYS_MENU.CSS_CLASS
     *
     * @param cssClass null
     *
     * @mbggenerated 2012-05-17 11:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-17 11:35")
    public void setCssClass(String cssClass) {
        this.cssClass = cssClass == null ? null : cssClass.trim();
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: E0515.SYS_MENU.SERIAL_NUMBER
     *
     * @返回  E0515.SYS_MENU.SERIAL_NUMBER
     *
     * @mbggenerated 2012-05-17 11:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-17 11:35")
    public Long getSerialNumber() {
        return serialNumber;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: E0515.SYS_MENU.SERIAL_NUMBER
     *
     * @param serialNumber null
     *
     * @mbggenerated 2012-05-17 11:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-17 11:35")
    public void setSerialNumber(Long serialNumber) {
        this.serialNumber = serialNumber;
    }

    /**
     * 返回: ????<br>
     * 对应数据库字段: E0515.SYS_MENU.OPEN_MODE
     *
     * @返回  E0515.SYS_MENU.OPEN_MODE
     *
     * @mbggenerated 2012-05-17 11:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-17 11:35")
    public String getOpenMode() {
        return openMode;
    }

    /**
     *  设置: ????<br>
     * 对应数据库字段: E0515.SYS_MENU.OPEN_MODE
     *
     * @param openMode ????
     *
     * @mbggenerated 2012-05-17 11:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-17 11:35")
    public void setOpenMode(String openMode) {
        this.openMode = openMode == null ? null : openMode.trim();
    }

    /**
     * 返回: null<br>
     * 对应数据库字段: E0515.SYS_MENU.AUTH_ID
     *
     * @返回  E0515.SYS_MENU.AUTH_ID
     *
     * @mbggenerated 2012-05-17 11:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-17 11:35")
    public Long getAuthId() {
        return authId;
    }

    /**
     *  设置: null<br>
     * 对应数据库字段: E0515.SYS_MENU.AUTH_ID
     *
     * @param authId null
     *
     * @mbggenerated 2012-05-17 11:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-17 11:35")
    public void setAuthId(Long authId) {
        this.authId = authId;
    }

    /**
     * 返回: 权限值<br>
     * 对应数据库字段: E0515.SYS_MENU.AUTHORITY_VALUE
     *
     * @返回  E0515.SYS_MENU.AUTHORITY_VALUE
     *
     * @mbggenerated 2012-05-17 11:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-17 11:35")
    public BigDecimal getAuthorityValue() {
        return authorityValue;
    }

    /**
     *  设置: 权限值<br>
     * 对应数据库字段: E0515.SYS_MENU.AUTHORITY_VALUE
     *
     * @param authorityValue 权限值
     *
     * @mbggenerated 2012-05-17 11:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-17 11:35")
    public void setAuthorityValue(BigDecimal authorityValue) {
        this.authorityValue = authorityValue;
    }

    /**
     * 返回: 权限名<br>
     * 对应数据库字段: E0515.SYS_MENU.AUTHORITY_NAME
     *
     * @返回  E0515.SYS_MENU.AUTHORITY_NAME
     *
     * @mbggenerated 2012-05-17 11:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-17 11:35")
    public String getAuthorityName() {
        return authorityName;
    }

    /**
     *  设置: 权限名<br>
     * 对应数据库字段: E0515.SYS_MENU.AUTHORITY_NAME
     *
     * @param authorityName 权限名
     *
     * @mbggenerated 2012-05-17 11:16
     */
    
    @com.kingnod.core.annotation.Generated("2012-05-17 11:35")
    public void setAuthorityName(String authorityName) {
        this.authorityName = authorityName == null ? null : authorityName.trim();
    }
}