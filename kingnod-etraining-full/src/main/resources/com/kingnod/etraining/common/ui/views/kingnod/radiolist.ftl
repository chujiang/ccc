<#if parameters.isLayout != "false">
	<#include "/com/kingnod/etraining/common/ui/views/kingnod/controlheader.ftl" />
<#else>
	<label>${parameters.label?html} : </label>
</#if>

<#--判断当前控件是否可编辑-->
<#if parameters.editable?default(true)>
  <#include "/com/kingnod/etraining/common/ui/views/simple/radiolist.ftl" />
<#else>
  <#include "/com/kingnod/etraining/common/ui/views/simple/radiolist-editable.ftl" />
</#if>

<#if parameters.isLayout != "false">
	<#include "/com/kingnod/etraining/common/ui/views/kingnod/controlfooter.ftl" />
</#if>