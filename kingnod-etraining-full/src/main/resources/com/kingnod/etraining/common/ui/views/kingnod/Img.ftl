<#if parameters.isLayout != "false">
	<#include "/com/kingnod/etraining/common/ui/views/kingnod/controlheader.ftl" />
<#else>
	<label>${parameters.label?html} : </label>
</#if>


  <#include "/com/kingnod/etraining/common/ui/views/simple/Img.ftl" />


<#if parameters.isLayout != "false">
	<#include "/com/kingnod/etraining/common/ui/views/kingnod/controlfooter.ftl" />
</#if>