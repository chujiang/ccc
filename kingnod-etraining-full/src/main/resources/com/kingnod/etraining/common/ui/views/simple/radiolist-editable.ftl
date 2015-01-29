<#list parameters.items as list>
	<#if parameters.nameValue??>
		<#if parameters.nameValue == list.value>
			<label>${list.name}</label><input name="${parameters.name?default("")?html}" type="hidden" value="${list.value }"/><#rt/>
		</#if>
	</#if>
</#list>