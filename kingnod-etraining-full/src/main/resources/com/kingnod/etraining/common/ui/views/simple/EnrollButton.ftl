<#if parameters.enrollMode=="S"&&parameters.enrollStatus=="N"> 
					           <div class="detail2words"><a href="javascript:enroll('${parameters.acivityId}')" class="pagelink">注册</a></div>
<#elseif parameters.enrollMode=="S"&&parameters.enrollStatus=="R"&&parameters.allowLogout=="Y">
					           <div class="detail2words"><a href="javascript:enrollLogOut('${parameters.acivityId}')" class="pagelink">注销</a></div>
<#elseif parameters.enrollMode=="S"&&parameters.enrollStatus=="R"&&parameters.allowLogout=="N">
					           <div class="detail2words_dis">注销</div>
<#elseif parameters.enrollMode=="S"&&parameters.enrollStatus=="O"> 
					           <div class="detail2words"><a href="javascript:enroll('${parameters.acivityId}')" class="pagelink">注册</a></div>
<#else>
					           <div class="detail2words_dis">注册</div>
</#if>
		            