<#if parameters.password==true>
<input type="password"<#rt/>
</#if>
<#if parameters.password==false>
<input type="text"<#rt/>
</#if>
 name="${parameters.name?default("")?html}"<#rt/>
<#if parameters.get("size")??>
 size="${parameters.get("size")?html}"<#rt/>
</#if>
<#if parameters.maxlength??>
 maxlength="${parameters.maxlength?html}"<#rt/>
</#if>
<#if parameters.nameValue??>
 value="<@s.property value="parameters.nameValue"/>"<#rt/>
</#if>
<#if parameters.label??>
 label="${parameters.label?default("")?html}"<#rt/>
</#if>
<#if parameters.labelKey??>
 labelKey="${parameters.labelKey?default("")?html}"<#rt/>
</#if>
<#if parameters.readonly?default(false)>
 readonly="readonly"<#rt/>
</#if>
<#if parameters.tabindex??>
 tabindex="${parameters.tabindex?html}"<#rt/>
</#if>
<#if parameters.id??>
 id="${parameters.id?html}"<#rt/>
</#if>
<#include "/template/simple/css.ftl" />
<#if parameters.title??>
 title="${parameters.title?html}"<#rt/>
</#if>
<#include "/template/simple/scripting-events.ftl" />
<#include "/template/simple/common-attributes.ftl" />
<#include "/template/simple/dynamic-attributes.ftl" />
<#include "/com/kingnod/etraining/common/ui/views/kingnod/common-attributes.ftl"/>
/>