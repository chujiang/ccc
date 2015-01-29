<div class="bookDesc" <#if parameters.titles??>
		title="${parameters.titles }"<#t/>
		</#if>>
	<img width="100" height="117" <#rt/>
	<#if parameters.imgSrc??>
	src="${parameters.imgSrc?html}"<#rt/> 
	</#if>/>
		<div class="bookLabel">
		<#if parameters.titles??>
		${parameters.titles }<#t/>
		</#if>
		</div>
		<div class="bookStars">
		<#include "/${parameters.templateDir}/kingnod/Grade.ftl" />
			</div>
		<div class="bookScore">
		<#if parameters.text??>
		${parameters.text }<#t/>
		</#if>
		<#include "/template/simple/common-attributes.ftl" />
		<#include "/template/simple/dynamic-attributes.ftl" />
		</div>
</div>