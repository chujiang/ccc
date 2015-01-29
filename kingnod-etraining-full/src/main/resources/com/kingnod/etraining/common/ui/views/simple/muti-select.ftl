<textarea<#rt/>
 id="mutiselect_${parameters.id?default("")?html}"<#rt/>
 name="mutiselect_${parameters.name?default("")?html}"<#rt/>
<#if parameters.get("size")??>
 size="${parameters.get("size")?html}"<#rt/>
</#if>
<#if parameters.maxlength??>
 maxlength="${parameters.maxlength?html}"<#rt/>
</#if>
<#if parameters.fullName??>
 value="<@s.property value="parameters.fullName"/>"<#rt/>
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
 onclick="mutiSelectContentShow('${parameters.id?default("")?html}');"
<#if parameters.tabindex??>
 tabindex="${parameters.tabindex?html}"<#rt/>
</#if>
<#include "/template/simple/css.ftl" />
<#if parameters.title??>
 title="${parameters.title?html}"<#rt/>
</#if>
<#include "/template/simple/scripting-events.ftl" />
<#include "/template/simple/common-attributes.ftl" />
<#include "/template/simple/dynamic-attributes.ftl" />
></textarea><a id="selectbtn_${parameters.id?default("")?html}" onclick="mutiSelectContentShow('${parameters.id?default("")?html}'); return false;" href="#">选择</a>
<input id="${parameters.id?default("")?html}" name="${parameters.name?default("")?html}" type="hidden" value="${parameters.nameValue?html}"/>
<div id="selectContent_${parameters.id?default("")?html}" class="menuContent" style="display:none;position: absolute;">
	<ul id="tree_${parameters.id?default("")?html}" class="ztree" style="margin-top:0; width:180px; height: 300px;"></ul>
</div>
<SCRIPT type="text/javascript">
	<!--
	$(document).ready(function(){
		$k.ajax({
			url:"<#if parameters.href?if_exists != "">${parameters.href}</#if>",
			type:"POST",
			<#if parameters.jsondata?if_exists != "">
			data:${parameters.jsondata?default("")}</#if>,
			loadingMessage:"loading...",
			success:function(data, textStatus){
				var treeObj = $.fn.zTree.init($("#tree_${parameters.id?default("")?html}"), mutiSelectSetting, data);
				mutiSelectContentCheck("${parameters.id?default("")?html}");
			}
		});
	});
	//-->
</SCRIPT>