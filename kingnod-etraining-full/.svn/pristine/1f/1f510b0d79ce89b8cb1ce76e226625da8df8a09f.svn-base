<#if parameters.errorInfo??>
<#if parameters.showType == 1>
<script>$(function(){$.windowAlert("${parameters.errorInfo}");});</script>
</#if>
<#if parameters.showType == 2>
<script>
$(function(){
var $at = $('#${parameters.at}');
var $error = $("<div class='${parameters.errorClass}' <#if parameters.errorStyle??> style='${parameters.errorStyle}'</#if> >${parameters.errorInfo}</div>");
<#if parameters.showPosition == 'left'>
$at.before($error);
</#if>
<#if parameters.showPosition == 'right'>
$at.after($error);
</#if>
<#if parameters.showPosition == 'included'>
$at.html($error);
</#if>
});
</script>
</#if>
<#if parameters.showType == 3>
${parameters.errorInfo}
</#if>
</#if>