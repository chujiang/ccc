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
				<span style="color:red">正确答案：${question.questionAnswers[0].itemContent }</span><br><br>
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
						<#if answer.itemContent ??>
						${answer.itemContent }
						</#if>
						;&nbsp;&nbsp;&nbsp;&nbsp;
					</#list>
				</span><br><br>
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
									<#-- 如果该选项是正确答案，颜色标记为绿色 -->
									<span>${answer.itemContent } <#if answer.correct??><img src="../images/kaoshiico1.gif" width="9" height="10"></#if></span>
								</#if>
								<#if question.type == "R" || question.type == "B"><#-- 单选和判断-->
									<input type="radio" disabled="disabled" 
									<#list question.examAnswer as examAnswer ><#if examAnswer == answer.id?string >checked="checked"</#if></#list>/>
									<span>${answer.itemContent } <#if answer.correct?? && answer.correct?string('true','false') == 'true'><img src="../images/kaoshiico1.gif" width="9" height="10"></#if></span>
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