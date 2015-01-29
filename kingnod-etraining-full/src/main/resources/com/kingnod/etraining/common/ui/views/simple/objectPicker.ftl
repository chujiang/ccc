<#if parameters.mutiSelect == "true" && parameters.showType != "input">
	<textarea rows="4"  style="resize:none; width:${parameters.maxlength?default("176")?html}"<#rt/>
	   id="objectPicker_${parameters.id?default("")?html}"<#rt/>
	   name="objectPicker_${parameters.name?default("")?html}"<#rt/>
	   <#if parameters.label??>
	     label="${parameters.label?default("")?html}"<#rt/>
	   </#if>
	   <#if parameters.labelKey??>
	    labelKey="${parameters.labelKey?default("")?html}"<#rt/> 
	   </#if>
	   <#if parameters.readonly?default(false)>
	     readonly="readonly"<#rt/>
	   </#if>
    <#include "/template/simple/scripting-events.ftl" />
	<#include "/template/simple/common-attributes.ftl" />
	<#include "/template/simple/dynamic-attributes.ftl" />
	<#include "/com/kingnod/etraining/common/ui/views/kingnod/common-attributes.ftl"/>
    >
	<#if parameters.showValue??>
    <@s.property value="parameters.showValue"/><#t/>
   </#if>
	</textarea>

<#else>
<input type="text"<#rt/>
 id="objectPicker_${parameters.id?default("")?html}"<#rt/>
 name="objectPicker_${parameters.name?default("")?html}"<#rt/>
<#if parameters.get("size")??>
 size="${parameters.get("size")?html}"<#rt/>
</#if>
<#if parameters.maxlength??>
 maxlength="${parameters.maxlength?html}"<#rt/>
</#if>
<#if parameters.showValue??>
 value="${parameters.get("showValue")?html}"<#rt/>
</#if>
<#if parameters.label??>
 label="${parameters.label?default("")?html}"<#rt/>
</#if>
<#if parameters.labelKey??>
 labelKey="${parameters.labelKey?default("")?html}"<#rt/>
</#if>
<#if parameters.readonly?default(false)>
 readonly="readonly"<#rt/>
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
<#include "/template/simple/scripting-events.ftl" />
<#include "/template/simple/common-attributes.ftl" />
<#include "/template/simple/dynamic-attributes.ftl" />
<#include "/com/kingnod/etraining/common/ui/views/kingnod/common-attributes.ftl"/>
/>
</#if>
<input name="" type="button" class="szbtn" value=" 选 择 " onclick="${parameters.selectOnclick?default("")?html}"/>&nbsp;<input id="clearObj_${parameters.id?default("")?html}" onclick="$.clearObjectPickData('${parameters.name?default("")?html}')"  type="button" class="szbtn" value=" 清 除 " />
<input id="${parameters.id?default("")?html}" name="${parameters.name?default("")?html}" type="hidden" value='${parameters.nameValue}'/>
<#if parameters.showValue == "">
   <script>$.getObjectPickData(${parameters.getObjectPickData?default("")?html})</script>
</#if>
