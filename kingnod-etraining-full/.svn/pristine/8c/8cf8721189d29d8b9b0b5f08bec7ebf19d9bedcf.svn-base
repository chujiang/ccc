<#if question.type == "T" || question.type == "A">
	<tr id="${question.type }_${question.id}_question" questiontype="${question.type }" >
		<td class="kaoshibd">
			${question_index + 1 }、${question.content }（${question.score}分）
			<input type="hidden" name="question_${question.id?c}_id_status" value="false" />
			<input type="hidden" name="question_${question.id?c}_id" 
				<#if question.questionAnswers[0]?? >value="${ question.questionAnswers[0].questionId?c }" </#if>
			/>
			<input type="hidden" name="question_${question.id?c}_id_examinee_id" id="question_${question.id?c}_id_examinee_id" value="${question.id?c}" />
			<input type="image" onClick="markReview(this);" src="../images/kaoshiico4.gif" name="question_${question.id?c}_id"/>
		</td>
	</tr>
	<tr id="${question.type }_${question.id}_question_content" questiontype="${question.type }">
		<td>
			<#if question.type == "A">
				<textarea name="question_${question.id?c}" style="margin-left:35px;" cols="50" rows="5" onChange="saveTAnswers(this);" >${question.examineeAnswer }</textarea>
			</#if>
		</td>
	</tr>
<#else>
	<tr id="${question.type }_${question.id}_question" questiontype="${question.type }">
		<td class="kaoshibd">
			${question_index + 1 }、${question.content }（${question.score}分）
			<input type="hidden" name="question_${question.id?c}_id_status" value="false" />
			<input type="hidden" name="question_${question.id?c}_id_examinee_id" id="question_${question.id?c}_id_examinee_id" value="${question.id?c}" />
			<input type="image" onClick="markReview(this);" src="../images/kaoshiico4.gif" name="question_${question.id?c}_id" />
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
								<#if question.type == "C">
									<input type="hidden" name="question_${question.id?c}_id" value="${ answer.questionId?c }" />
									<input type="checkbox" 
										<#list question.examAnswer as examAnswer ><#if examAnswer == answer.id?string >checked="checked"</#if></#list>
										onClick="submitAnswers(this);" name="question_${question.id?c}" seq="${ answer.itemSeq }" value="${ answer.id?c }" />
									<#if answer.itemContent ??>
										${ answer.itemContent }
									</#if>
								</#if>
								<#if question.type == "R" || question.type == "B">
									<input type="hidden" name="question_${question.id?c}_id" value="${ answer.questionId?c }" />
									<input type="radio" <#if question.examineeAnswer == answer.id?string >checked="checked"</#if>
										 onClick="submitAnswers(this);" name="question_${question.id?c}" seq="${answer.itemSeq }" value="${answer.id?c}"/>
									<#if answer.itemContent ??>
										${answer.itemContent }
									</#if>
								</#if>
								</label><br>
							</#if>
						</#list>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</#if>