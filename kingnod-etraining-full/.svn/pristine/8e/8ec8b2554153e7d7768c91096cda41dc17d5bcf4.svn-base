<#include "/com/kingnod/etraining/common/ui/views/kingnod/form-common.ftl" />
<#if parameters.onreset??>
 onreset="${parameters.onreset?html}"<#rt/>
</#if>
> 
<#if parameters.autoParams??>
<#list parameters.autoParams?keys as mykey><#rt/>
  <#assign paramValues=parameters.autoParams[mykey] ><#rt/>
  <#list paramValues as paramValue><#rt/>
  <input type="hidden" name="${mykey}" value="${paramValue}" id="${mykey}"/> 
  </#list><#rt/>
</#list><#rt/>
</#if>