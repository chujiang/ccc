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
  				<#if parameters.body??>
					${parameters.body}
				</#if>

  				<td width="90%">&nbsp;</td>
			</tr>
		</table>
		</td>
    <td width="1%" align="right"><img src="../images/weizhi_rt.jpg" width="4" height="30"></td>
  </tr>
</table>
<#--
<SCRIPT type="text/javascript">
$(document).ready(function(){
<#list parameters.objectList as item>
		$("#nav_${item.objectType}_${item.objectId}").powerFloat({
			width: "150px",
			eventType: "click",
			target: {url:"/admin-web/cmn/navigation.action",data:{id:${item.objectId},objectType:"${item.objectType}"}},
			targetMode: "ajaxlist",
			callback:{renderMenus:$k.renderNavMenus}
		});
</#list>
});
</SCRIPT>
-->