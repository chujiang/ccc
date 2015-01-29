<#list parameters.quesList as question>
		<#if question.type == "T" || question.type == "A">
			<tr id="${question.type }_${question.id}_question" questiontype="${question.type }" >
				<td class="kaoshibd">
				${question_index + 1 }、${question.content }（${question.score}分）
				<input type="hidden" name="question_${question.id?c}_id_status" value="false" />
				<input type="hidden" name="question_${question.id?c}_id" 
					<#if question.questionAnswers[0]?? >value="${ question.questionAnswers[0].questionId?c }" </#if>
				/>
				<input type="hidden" name="question_${question.id?c}_id_examinee_id" id="question_${question.id?c}_id_examinee_id" value="${question.id?c}" />
				<input type="image" onClick="" src="../images/kaoshiico4.gif" name="question_${question.id?c}_id"/>
				</td>
			</tr>
			<tr id="${question.type }_${question.id}_question_content" questiontype="${question.type }">
				<td>
					<#if question.type == "A">
						<textarea readonly name="question_${question.id?c}" style="margin-left:35px;text-align:left;" cols="50" rows="5" onChange="" >
							<#list question.questionAnswers as answer >
								${ answer.itemContent }
							</#list>
						</textarea>
					</#if>
				</td>
			</tr>
		<#else>
			<tr id="${question.type }_${question.id}_question" questiontype="${question.type }">
				<td class="kaoshibd">
				${question_index + 1 }、${question.content }（${question.score}分）
				<input type="hidden" name="question_${question.id?c}_id_status" value="false" />
				<input type="hidden" name="question_${question.id?c}_id_examinee_id" id="question_${question.id?c}_id_examinee_id" value="${question.id?c}" />
				<input type="image" onClick="" src="../images/kaoshiico4.gif" name="question_${question.id?c}_id" />
				</td>
			</tr>
			<td style="padding-left:30px;padding-top:10px;">
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
          	<tr id="${question.type }_${question.id}_question_content" questiontype="${question.type }">
          		<td>
			<#list question.questionAnswers as answer >
				<#if answer??>
					<label>
					<#if question.type == "C">
						<input type="hidden" name="question_${question.id?c}_id" value="${ answer.questionId?c }" />
						<input type="checkbox" onClick="" disabled="disabled"
						<#if answer.correct ?? && answer.correct == true>
							checked="checked"
						</#if>
						name="question_${question.id?c}" seq="${ answer.itemSeq }" value="${ answer.id?c }" />
						<#if answer.itemContent ??>
							${ answer.itemContent }
						</#if>
					</#if>
					<#if question.type == "R" || question.type == "B">
						<input type="hidden" name="question_${question.id?c}_id" value="${ answer.questionId?c }" />
						<input type="radio" disabled="disabled" onClick="" <#if answer.correct?? && answer.correct>checked="checked"</#if> name="question_${question.id?c}" seq="${answer.itemSeq }" value="${answer.id?c}"/>
						<#if answer.itemContent ??>${answer.itemContent }</#if>
					</#if>
					</label>
					<br />
				</#if>
			</#list>
			<#if question.childQuestionList??>
				<#list question.childQuestionList as childQuestion>
					${ childQuestion_index + 1 }、${childQuestion.content }（${childQuestion.score}分）
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
			          	<tr><td>
					<#list childQuestion.questionAnswers as childAnswer >
						<#if childAnswer??>
							<label>
							<#if childQuestion.type == "C">
								<input type="hidden" name="question_${childQuestion.id?c}_id" value="${ childAnswer.questionId?c }" />
								<input style="margin-left: 15px;" type="checkbox" 
								<#if childAnswer.correct ?? && childAnswer.correct>
									checked="checked"
								</#if>
								onClick="" name="question_${childQuestion.id?c}" seq="${ childAnswer.itemSeq }" value="${ childAnswer.id?c }" />
								<#if childAnswer.itemContent ??>
									${ childAnswer.itemContent }
								</#if>
							</#if>
							<#if childQuestion.type == "R" || childQuestion.type == "B">
								<input type="hidden" name="question_${childQuestion.id?c}_id" value="${ childAnswer.questionId?c }" />
								<input style="margin-left: 15px;" type="radio" 
								<#if childAnswer.correct ?? && childAnswer.correct>
									checked="checked"
								</#if>
								onClick="" name="question_${childQuestion.id?c}" seq="${ childAnswer.itemSeq }" value="${childAnswer.id?c}"/>
								<#if childAnswer.itemContent ??>
									${ childAnswer.itemContent }
								</#if>
							</#if>
							</label>
							<br />
						</#if>
					</#list>
					</td></tr>
					</table>
				</#list>
			</#if>
			</td>
			</tr>
			</table>
			<td>
			<tr/>
		</#if>
</#list>