<#if parameters.isStartTr>
<tr class="${parameters.rowClass}">
</#if>
<#if parameters.layoutCols != 0>
		<td align="right" width="${parameters.labelWidth?html}"><#rt/>
</#if>
<#if parameters.label != "">
<#if parameters.notnull?if_exists = "true">
<font style="padding-right:2px; color:red;">*</font><#rt/>
</#if>
<label>${parameters.label?html} : </label><#rt/>
</#if>
<#if parameters.layoutCols != 0>
</td><td<#rt/>
<#if parameters.colspan??>
 colspan="${parameters.colspan?html}"<#rt/>
</#if>
><#rt/>
</#if>