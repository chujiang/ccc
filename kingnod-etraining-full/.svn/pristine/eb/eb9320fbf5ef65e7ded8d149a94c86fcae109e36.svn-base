<#list parameters.items as item>
	<#if item??>
		<#if parameters.selectedValues[item.value]??>
			<input type="checkbox" checked="checked" onclick="javascript:return false;" /> 
			<label>${item.name}</label><input name="${parameters.name?default("")?html}" type="hidden" value="${item.value }"/><#rt/>
		</#if>    
    </#if>
</#list>
