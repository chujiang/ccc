<#if question.type == "T" || question.type == "A">
	<tr id="${question.type }_${question.id}_question" questiontype="${question.type }">
		<td class="kaoshibd">
			${question_index + 1 }、${question.content }（${question.score}分）
		</td>
	</tr>
	<tr id="${question.type }_${question.id}_question_content" questiontype="${question.type }">
		<td style="padding-left:10px;">
			<#if question.type == "A">
				<textarea readonly style="margin-left:35px;" cols="50" rows="5" >${question.examineeAnswer }</textarea><br>
				<span style="color:red">正确答案：${question.questionAnswers[0].itemContent }</span>
				<#if question.examineeQuestion?? && question.examineeQuestion.approveStatus?? && !question.examineeQuestion.approveStatus><br><br></#if>
			</#if>
			
			<#if question.type == "T">
				<span style="color:red">&nbsp;&nbsp;正确答案：
					<#list question.questionAnswers as answer >
						<#if answer_index == 0 >①</#if>
						<#if answer_index == 1 >②</#if>
						<#if answer_index == 2 >③</#if>
						<#if answer_index == 3 >④</#if>
						<#if answer_index == 4 >⑤</#if>
						<#if answer_index == 5 >⑥</#if>
						<#if answer_index == 6 >⑦</#if>
						<#if answer_index == 7 >⑧</#if>
						<#if answer_index == 8 >⑨</#if>
						<#if answer_index == 9 >⑩</#if>
						${answer.itemContent };&nbsp;&nbsp;&nbsp;&nbsp;
					</#list>
				</span>
				<#if question.examineeQuestion?? && question.examineeQuestion.approveStatus?? && !question.examineeQuestion.approveStatus><br><br></#if>
			</#if>
		</td>
	</tr>
	<#if question.examineeQuestion?? && question.examineeQuestion.approveStatus?? && question.examineeQuestion.approveStatus>
		<tr>
			<td style="padding-left:30px;padding-top:10px;">
				阅 卷 人：${question.examineeQuestion.viewPersonName?default("")?html}<br> 
				阅卷得分：${question.examineeQuestion.viewScore?default("")?html}<br> 
				审 核 人：${question.examineeQuestion.approvePersonName?default("")?html}<br> 
				审核得分：${question.examineeQuestion.approveScore?default("")?html}<br> 
				重新打分：<input type="text" id="${question.id}" onchange="saveScore(this);" onkeypress="return $k.checkIntegerTagIntKey(event, this, false);" onblur="return $k.checkIntegerTagIntKey(this);"/></br></br>
			</td>
	  	 	<input type="hidden" name="examNumber_${question.examineeQuestion.id}" value="${question.examineeQuestion.examNumber }" />
	  	  	<input type="hidden" name="questionId_${question.examineeQuestion.id}" value="${question.examineeQuestion.questionId }" />
	  	  	<input type="hidden" name="examinationId_${question.examineeQuestion.id}" value="${question.examineeQuestion.examinationId }" />
	  	  	
	  	  	<script type="text/javascript">
				function saveScore(obj) {
					var index = obj.id;
					var examNumber = $(":hidden[name='examNumber_" + index + "']").val();
					var questionId = $(":hidden[name='questionId_" + index + "']").val();
					var examinationId = $(":hidden[name='examinationId_" + index + "']").val();
					$k.ajax({
						url:"examinees-history!saveViewScore.action",
						data:{'examQuestion.examNumber':examNumber, 'examQuestion.score':obj.value, 'examQuestion.questionId':questionId, 'examQuestion.examinationId':examinationId},
						success:function(data, status){alert('已修改!');}});
				}
				
				function syncHeight() { 
					var wh = $(window.parent.document.body).find("#answerIFrame").height();
					var qh = $("#questionTable").height();
					var ah = wh-qh;
					$("#answerTable").height(ah); 
				}
				
				$(function(){
					syncHeight();
					$(window).resize(function(){ 
						syncHeight();
					});
				});
			</script>
		</tr>
	</#if>
<#else>
	<tr id="${question.type }_${question.id}_question" questiontype="${question.type }">
		<td class="kaoshibd">
		${question_index + 1 }、${question.content }（${question.score}分）
		</td>
	</tr>
	<tr id="${question.type }_${question.id}_question_content" questiontype="${question.type }">
		<td style="padding-left:30px;padding-top:10px;">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
	          	<tr>
	          		<td>
						<#list question.questionAnswers as answer >
							<#if answer??>
								<label>
								<#if question.type == "C"><#-- 多选-->
									<#-- 如果该选项是用户答案，默认选中-->
									<input type="checkbox" disabled="disabled"
									<#list question.examAnswer as examAnswer ><#if examAnswer == answer.id?string >checked="checked"</#if></#list>/>
									<#-- 如果该选项是正确答案，颜色标记为绿色 -->
									<span>${answer.itemContent } <#if answer.correct??> &nbsp;<img src="../images/kaoshiico1.gif" width="9" height="10"></#if></span>
								</#if>
								<#if question.type == "R" || question.type == "B"><#-- 单选和判断-->
									<input type="radio" disabled="disabled" 
									<#list question.examAnswer as examAnswer ><#if examAnswer == answer.id?string >checked="checked"</#if></#list>/>
									<span>${answer.itemContent }<#if answer.correct?? && answer.correct?string('true','false') == 'true'> &nbsp;<img src="../images/kaoshiico1.gif" width="9" height="10"></#if></span>
								</#if>
								</label>
								<br />
							</#if>
						</#list>
					</td>
				</tr>
			</table>
		<td>
	<tr/>
</#if>