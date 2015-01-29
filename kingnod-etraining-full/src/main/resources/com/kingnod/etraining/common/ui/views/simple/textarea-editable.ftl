<#-- <@s.property value="parameters.nameValue"/> -->
<input type="hidden" name="${parameters.name?default("")?html}" value="${parameters.nameValue }"/>
<#-- update  @author PiJingwei 修复页面变形问题 -->
<#if parameters.nameValue??>
	<textarea disabled="disabled" cols="40" rows="4" title="" >${parameters.nameValue}</textarea>
</#if>
