<#if parameters.enrollstatus== "R"&&parameters.isInValidateDate=="true"> 
        <a href="#" onclick="javascript:window.open(&quot;${parameters.srcHeader}/crs/player.action?acivityId=${parameters.acivityId}&amp;courseId=${parameters.courseId}&quot;,&quot;newwindow&quot; , &quot;toolbar=no,menubar=no,scrollbars=no, resizable=yes,location=no, status=notoolbar=no,menubar=no,scrollbars=no, resizable=yes,location=no, status=no&quot;);return false;">
             <img src="${parameters.srcHeader}/images/Broadcast-Yes.png">
		</a>
<#else>
	<img src="${parameters.srcHeader}/images/Broadcast-No.png"
	  <#if parameters.isInValidateDate=="false"> 
		  title="课程还没有到开放时间" 
      <#elseif parameters.enrollstatus=="N"?default(false)>
		   title="未注册，请先注册此课程" 
	  <#elseif parameters.enrollstatus=="O"?default(false)>
		   title="已经注销，请先注册此课程" 			        
      <#else>
           title="没有注册权限，请向管理员申请！" 
      </#if>
	 />
</#if>