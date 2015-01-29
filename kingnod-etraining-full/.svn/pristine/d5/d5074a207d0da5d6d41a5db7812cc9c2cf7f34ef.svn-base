<#if parameters.items??>
<#list parameters.items as list>
<input type="radio"<#rt/>
<#if parameters.nameValue??>
	<#if parameters.nameValue == list.value>
		checked="checked"<#rt/>
	</#if>
</#if>
<#if parameters.id??>
 id="${parameters.id?html}"<#rt/>
</#if>
<#if parameters.name??>
 name="${parameters.name?html}"<#rt/>
</#if>
<#if list.value??>
 value="${list.value}"<#rt/>
</#if>
<#if parameters.labelKey??>
 labelKey="${parameters.labelKey?default("")?html}"<#rt/>
</#if>
<#if parameters.tabindex??>
 tabindex="${parameters.tabindex?html}"<#rt/>
</#if>
<#if parameters.cssClass??>
 class="${parameters.cssClass?html}"<#rt/>
</#if>
<#if parameters.cssStyle??>
 style="${parameters.cssStyle?html}"<#rt/>
</#if>
<#include "/template/simple/css.ftl" />
<#if parameters.title??>
 title="${parameters.title?html}"<#rt/>
</#if> 
<#include "/template/simple/scripting-events.ftl" />
<#include "/template/simple/common-attributes.ftl" />
<#include "/com/kingnod/etraining/common/ui/views/kingnod/common-attributes.ftl"/>
/>${list.name}
</#list>
</#if>