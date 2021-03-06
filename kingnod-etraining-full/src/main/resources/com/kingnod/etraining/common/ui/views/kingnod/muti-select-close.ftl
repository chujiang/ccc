<#--
/*
 * $Id: a-close.ftl 753015 2009-03-12 21:00:23Z musachy $
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 * 
 */
-->
<ul id="${parameters.id?html}" class="ztree"/>
<SCRIPT type="text/javascript">

function refreshNode(e) {
			var zTree = $.fn.zTree.getZTreeObj(e.data.ids),
			type = e.data.type,
			silent = e.data.silent,
			nodes = zTree.getSelectedNodes();
			if (nodes.length == 0) {
				alert("请先选择一个父节点");
			}
			for (var i=0, l=nodes.length; i<l; i++) {
				zTree.reAsyncChildNodes(nodes[i], type, silent);
				if (!silent) zTree.selectNode(nodes[i]);
			}
		}
		function refres(ids,types,silents){
		id=window.setTimeout(function(){refresTree(ids,types,silents)},5000);
		}
	
		
		function refresTree(ids,types,silents)   {  
 		 var zTree = $.fn.zTree.getZTreeObj(ids),
 		 type = types,
 		 silent = silents,
 		 nodes = zTree.getSelectedNodes();
 		 if (nodes.length == 0) {
				alert("请先选择一个父节点");
			}
			for (var i=0, l=nodes.length; i<l; i++) {
				zTree.reAsyncChildNodes(nodes[i], type, silent);
				if (!silent) zTree.selectNode(nodes[i]);
			}
  } 
	<!--
	$(document).ready(function(){
		$("#${parameters.id?html}").bind("contextmenu", function(event){return false;});
		var setting = {
			view: {<#if parameters.edit>addHoverDom: addHoverDom,removeHoverDom: removeHoverDom,</#if>selectedMulti: false,showLine:true,showIcon:true,nameIsHTML: true,fontCss:getZtreeFont},
			edit: {enable: <#if parameters.edit>true<#else>false<#rt/></#if>},
			async: {enable: <#if parameters.async?if_exists != "">${parameters.async?html}</#if>,url:"<#if parameters.href?if_exists != "">${parameters.href}</#if>",autoParam:[<#if parameters.autoParam?if_exists != "">${parameters.autoParam}</#if>]},
			data: {simpleData: {enable: true,idKey:"id",pIdKey:"pId",rootPId:0}},
			callback: {beforeClick:beforeZtreeNodeClick,<#if parameters.onAsyncSuccess?if_exists != "">onAsyncSuccess:${parameters.onAsyncSuccess},</#if>onClick:<#if parameters.onclick?if_exists == "">onZtreeNodeClick</#if><#if parameters.onclick?if_exists != "">${parameters.onclick}</#if>, onRightClick:onZtreeNodeRightClick, onMouseDown:onZtreeNodeMouseDown<#if parameters.edit>,beforeDrag: zTreeBeforeDrag,beforeDrop: zTreeBeforeDrop,onRename: onRename,onRemove: onRemove,onClick: zTreeOnClick</#if>}
		};
	<#if parameters.async?if_exists == "false">
		jQuery.getJSON("<#if parameters.href?if_exists != "">${parameters.href}</#if>", <#if parameters.paramsJsonObj?if_exists != "">${parameters.paramsJsonObj}</#if>, function(data){
			$.fn.zTree.init($("#${parameters.id?html}"), setting, data);
			<#if parameters.initCompletedScript?if_exists != "">
				${parameters.initCompletedScript}
			</#if>
		});
	</#if>
	<#if parameters.async?if_exists == "true">
		$.fn.zTree.init($("#${parameters.id?html}"), setting);
		<#if parameters.initCompletedScript?if_exists != "">
			${parameters.initCompletedScript}
		</#if>
		$("#refreshNode").bind("click", {type:"refresh", silent:false,ids:"${parameters.id}"}, refreshNode);
		$("#refreshNodeSilent").bind("click", {type:"refresh", silent:true,ids:"${parameters.id}"}, refreshNode);
	</#if>
	});
	//-->
</SCRIPT>