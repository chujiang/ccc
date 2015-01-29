<label<#rt/>
<#if parameters.id??>
 id="${parameters.id?html}"<#rt/>
</#if>
<#if parameters.cssClass??>
 class="${parameters.cssClass?html}"<#rt/>
</#if>
<#if parameters.cssStyle??>
 style="${parameters.cssStyle?html}"<#rt/>
</#if>
<#if parameters.title??>
 title="${parameters.title?html}"<#rt/>
</#if>
<#if parameters.for??>
 for="${parameters.for?html}"<#rt/>
</#if>
<#include "/template/simple/common-attributes.ftl" />
<#include "/template/simple/dynamic-attributes.ftl" />
><#rt/>
<#if parameters.value??>
${parameters.value }<#t/>
</#if>
</label>