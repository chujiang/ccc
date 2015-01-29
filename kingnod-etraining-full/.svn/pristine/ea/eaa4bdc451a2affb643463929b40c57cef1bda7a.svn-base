<#if question.type == "T" || question.type == "A">
	<tr id="${question.type }_${question.id}_question" questiontype="${question.type }">
		<td class="kaoshibd">
			${question_index + 1 }、${question.content }（${question.score}分）
		</td>
	</tr>
	<tr id="${question.type }_${question.id}_question_content" questiontype="${question.type }">
		<td>
			<#if question.type == "A">
				<textarea readonly style="margin-left:35px;" cols="50" rows="5" >${question.examineeAnswer }</textarea><br>
			</#if>
		</td>
	</tr>
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
									<span>${answer.itemContent }</span>
								</#if>
								<#if question.type == "R" || question.type == "B"><#-- 单选和判断-->
									<input type="radio" disabled="disabled" 
									<#list question.examAnswer as examAnswer ><#if examAnswer == answer.id?string >checked="checked"</#if></#list>/>
									<span>${answer.itemContent }</span>
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