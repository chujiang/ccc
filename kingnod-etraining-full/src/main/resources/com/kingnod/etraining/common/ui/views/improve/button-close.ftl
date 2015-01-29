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
 */
-->
<table border="0" cellpadding="0" cellspacing="0"<#rt/>
<#if parameters.id?if_exists != "">
 id="${parameters.id?html}"<#rt/>
</#if>
<#if parameters.onclick??>
 onclick="${parameters.onclick?html}"<#rt/>
</#if>
<#if parameters.cssStyle??>
 style="${parameters.cssStyle?html}"<#rt/>
</#if>
<#include "/${parameters.templateDir}/kingnod/common-attributes.ftl" />
<#include "/${parameters.templateDir}/kingnod/dynamic-attributes.ftl" />
>
	<tr>
		<td class="buttonOffLeft" id="btn1_11"></td>
		<td class="buttonOffMiddle" id="btn1_12" onblur="btn_change(1)" onMouseOver="btn_change_over(1)" onMouseOut="btn_change_out(1)">
		<img alt="" border="0" align="absmiddle"
		<#if parameters.iconSrc??>
 		src="${parameters.iconSrc?html}"<#rt/>
 		>
 		</#if>
		 ${parameters.text}</td>
		<td class="buttonOffRight" id="btn1_13"></td>
	</tr>
</table>