<input type="text"<#rt/>
 id="userPicker_${parameters.id?default("")?html}"<#rt/>
 name="userPicker_${parameters.name?default("")?html}"<#rt/>
<#if parameters.get("size")??>
 size="${parameters.get("size")?html}"<#rt/>
</#if>
<#if parameters.maxlength??>
 maxlength="${parameters.maxlength?html}"<#rt/>
</#if>
<#if parameters.fullName??>
 value="<@s.property value="parameters.fullName"/>"<#rt/>
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
<#include "/template/simple/css.ftl" />
<#if parameters.title??>
 title="${parameters.title?html}"<#rt/>
</#if>
<#include "/template/simple/scripting-events.ftl" />
<#include "/template/simple/common-attributes.ftl" />
<#include "/template/simple/dynamic-attributes.ftl" />
/><input name="" type="button" class="szbtn" value=" 选 择 " onclick="${parameters.selectOnclick?default("")?html}"/>
<input id="${parameters.id?default("")?html}" name="${parameters.name?default("")?html}" type="hidden" value="${parameters.nameValue }"/>