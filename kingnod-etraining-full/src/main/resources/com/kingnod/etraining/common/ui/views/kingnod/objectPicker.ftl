<#include "/com/kingnod/etraining/common/ui/views/kingnod/controlheader.ftl" />

<#--判断当前控件是否可编辑-->
<#if parameters.editable?default(true)>
  <#include "/com/kingnod/etraining/common/ui/views/simple/objectPicker.ftl" />
<#else>
  <@s.property value="parameters.fullName"/><input name="${parameters.name?default("")?html}" type="hidden" value="${parameters.nameValue }"/>
  <#if parameters.showValue??>
    <@s.property value="parameters.showValue"/><#t/>
  </#if>
</#if>

<#include "/com/kingnod/etraining/common/ui/views/kingnod/controlfooter.ftl" />