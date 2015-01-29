<#setting number_format="#.#####">
<select<#rt/>
 name="${parameters.name?default("")?html}"<#rt/>
<#if parameters.get("size")??>
 size="${parameters.get("size")?html}"<#rt/>
</#if>
<#if parameters.label??>
 label="${parameters.label?default("")?html}"<#rt/>
</#if>
<#if parameters.labelKey??>
 labelKey="${parameters.labelKey?default("")?html}"<#rt/>
</#if>
<#if parameters.tabindex??>
 tabindex="${parameters.tabindex?html}"<#rt/>
</#if>
<#if parameters.id??>
 id="${parameters.id?html}"<#rt/>
</#if>
<#include "/template/simple/css.ftl" />
<#if parameters.title??>
 title="${parameters.title?html}"<#rt/>
</#if>
<#if parameters.multiple??>
 multiple="multiple"<#rt/>
</#if>
<#if parameters.dictName?exists>
 dictName="${parameters.dictName}"<#rt/>
</#if>
<#if parameters.target?exists>
 target="${parameters.target}"<#rt/>
</#if>
<#if parameters.chainParam?exists>
 chainParam="${parameters.chainParam}"<#rt/>
</#if>
<#if parameters.chainable?exists>
 chainable=${parameters.chainable} <#rt/>
</#if>
<#if parameters.beforeChain?exists>
 beforeChain="${parameters.beforeChain}" <#rt/>
</#if>
<#if parameters.emptyOption??>
emptyOption="${parameters.emptyOption}" <#rt/>
</#if>
<#if parameters.emptyOptionText??>
emptyOptionText="${parameters.emptyOptionText}" <#rt/>
</#if>
<#include "/template/simple/scripting-events.ftl" />
<#include "/template/simple/common-attributes.ftl" />
<#include "/template/simple/dynamic-attributes.ftl" />
<#include "/com/kingnod/etraining/common/ui/views/kingnod/common-attributes.ftl"/>
>
<#if parameters.emptyOption??>
    <option value="">${parameters.emptyOptionText?default("")?html}</option>
</#if>
<#list parameters.items as item>
	<#if item??>
    <option 
    	value="${item.value}"<#rt/>
    	<#if parameters.selectedValues[item.value]??>
    	selected="selected" <#rt/>
    	</#if>  
    >
    
    <#if item.name??>
    ${item.name?default("")?html}<#lt/>
    </#if>
    </option>
    </#if>
</#list>

</select>
<#if parameters.target??>
<script>
if (jQuery) {
(function($){
$(function() {
	$("#${parameters.id}").selectChain("${parameters.target}"<#if parameters.beforeChain??>,null,"${parameters.beforeChain}"</#if>);
});	
})(jQuery);
}
</script>
</#if>
