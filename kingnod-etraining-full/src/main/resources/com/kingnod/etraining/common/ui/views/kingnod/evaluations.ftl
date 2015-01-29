<div style="width: 92%; margin: 30px 20px; float: left;">
	<div id="navigation">
		<ul><li class="selected"><a href="javascript:void(0);" relate="div1">评论</a></li></ul>
	</div>
</div>
<div>
	<div class="divtablyout" style="width: 90%; float: left; padding: 15px 5px; margin-left: 20px;" id="div1">
		<em id = et></em>
		<div id="spndiv1"></div>
		<ul id="evaluationUl" style="text-align: right; padding-top: 10px;"></ul>
		<a href="#et" id="at"></a>
		<ul style="border-top: 1px dashed #cccccc; margin-top: 20px; float: left; width: 100%;"></ul>
	</div>
</div>

<div style="text-align: left; margin-top: 30px; margin-left: 30px; color: #c60109; float: left; width: 90%;">我要评论</div>
<table class="startstasktable" style="margin-bottom: 20px; margin-left: 30px; width: 90%;">
	<tr>
		<td>
			<div style="float: left; margin-left: 20px;">
				<ul>
					<li style="height: 25px;" class="start"><div style="float:left; width: 8%;">星级 :</div>			
						 <img id ="1" src="../images/wj-huise.png" class="imgcss" style="margin-left: 5px;">
						 <img id ="2" src="../images/wj-huise.png" class="imgcss" style="margin-left: 5px;">
						 <img id ="3" src="../images/wj-huise.png" class="imgcss" style="margin-left: 5px;">
						 <img id ="4" src="../images/wj-huise.png" class="imgcss" style="margin-left: 5px;">
						 <img id ="5" src="../images/wj-huise.png" class="imgcss" style="margin-left: 5px;">
						 <font style="margin-left: 5px;" color="red" id ="cerror"></font>
					 </li>
					<li style="height: 25px;"><div style="float:left; width: 8%;">类别：</div>
						<#if types ?? >
							<#list types as type>
								<input type="radio"  class=${type.name } name="ctype" value=${type.id } style="margin-left: 5px;" />${type.name }
							</#list>
						</#if>
					</li>
					<li style="height: 90px;">
						<div style="float:left; width: 8%; margin-top: 25px;">内容:</div>
						<div style="float:left; width: 85%;">
							<textarea cols="10" rows="5" id="cc" style="width:500px;text-align: left;"></textarea>
						</div>
					</li>
					<li>
						<#if evaluationAuthority ?? >
							<#if evaluationAuthority.look>
								<#if evaluationAuthority.obligatory || evaluationAuthority.status >
									<a id="sb" class="newa" href="####" style="padding: 3px 20px; margin-left: 45px; margin-top: 15px; margin-bottom: 15px;">提 交</a>
								<#else>
									<a id="nn" class="newa" href="####" style="color:#f2f2f2; padding: 3px 20px; margin-left: 45px; margin-top: 15px; margin-bottom: 15px;">提 交</a>
								</#if>
							<#else>
								<a id="nt" class="newa" href="####" style="color:#f2f2f2; padding: 3px 20px; margin-left: 45px; margin-top: 15px; margin-bottom: 15px;">提 交</a>
							</#if>
						</#if>
						<a id="ce" class="newa" href="####" style="padding: 3px 20px; margin-left: 45px; margin-top: 15px; margin-bottom: 15px;">取 消</a>
					</li>
				</ul>
			</div>
		</td>
	</tr>
</table>
<div>
	<input type="hidden" name="activityId" id="activityId" value="${activityId}"/>
	<input type="hidden" name="activityType" id="activityType" value="${activityType}"/>
	<input type="hidden" name="contextPath" id="contextPath" value="${contextPath}"/>
 	<k:button type="button" onclick="history.back();" textKey="cmn.authority_back" cssStyle="margin: 30px; float: right;"/>
</div>