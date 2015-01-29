<input type="radio" name="${parameters.name?html}" value="${parameters.fieldValue?html}"<#rt/>

<#if parameters.nameValue?? && parameters.nameValue>
 checked="checked"<#rt/>
</#if>
<#if parameters.disabled?default(false)>
 disabled="disabled"<#rt/>
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
/>
<input type="hidden" id="__radio_${parameters.id?html}" name="__radio_${parameters.name?html}" value="${parameters.fieldValue?html}"<#rt/>
<#if parameters.disabled?default(false)>
 disabled="disabled"<#rt/>
</#if>
 /> 