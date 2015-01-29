<#--
/*
 * $Id: a.ftl 753015 2009-03-12 21:00:23Z musachy $
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
<table width="100%" border="0" cellspacing="0" cellpadding="0" class="act">
  <tr>
    <td width="2%" align="center"><img src="../images/weizhi_le.jpg" width="44" height="30"></td>
    <td width="89%">
    	<table width="100%" border="0" cellspacing="0" cellpadding="0">
  			<tr id="currentPath">
  				<td width="75" align="right" nowrap  >&nbsp;&nbsp;当前位置：</td>

  				<#list parameters.objectList as item>
  					<td align="right" nowrap class="navlist">
  						<span><a href="${item.src}" target="_self">${item.name}</a></span>
  					</td>
  					<td id="nav_${item.objectType}_${item.objectId}" align="center" class="daip4">
  						<img src="../images/ico_point.gif" width="4" height="6">
  					</td>
  				</#list>