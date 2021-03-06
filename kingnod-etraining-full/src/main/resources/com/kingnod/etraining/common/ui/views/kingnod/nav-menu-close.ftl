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
<td id="" align="right" nowrap class="navlist">
	<span>

<#if parameters.textPlan == true>
	<a style="color:#656565"><#if parameters.text??>${parameters.text}</#if></a>
<#else>
	<a<#if parameters.id?if_exists != ""> 
 id="${parameters.id?html}" <#rt/>
</#if> 
 href="#"<#rt/>
<#if parameters.onclick??> 
 onclick="${parameters.onclick?html}"<#rt/>
</#if>
><#if parameters.body??>${parameters.body}</#if><#if parameters.text??>${parameters.text}</#if><#rt/>
</a><#rt/>
</#if>

	</span>
</td>
<td align="center" class="daip4">
	<img src="../images/ico_point.gif" width="4" height="6">
</td>