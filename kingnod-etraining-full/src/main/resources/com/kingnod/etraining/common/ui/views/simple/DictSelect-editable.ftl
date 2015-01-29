<#list parameters.items as item>
	<#if item??>
	    <#if parameters.selectedValues[item.value]??>
	    	<label>${item.name?html }</label><input id="${parameters.name?default("")?html}" name="${parameters.name?default("")?html}" type="hidden" value="${item.value }"/><#rt/>
	    </#if>  
    </#if>
</#list>