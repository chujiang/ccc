<#list parameters.quesList as question>
		<#if question.type == "T" || question.type == "A">
			<tr id="${question.type }_${question.id}_question" questiontype="${question.type }">
				<td class="kaoshibd">
				${question_index + 1 }、${question.content }（${question.score}分）<input type="image" src="../images/kaoshiico4.gif" />
				</td>
			</tr>
			<tr id="${question.type }_${question.id}_question_content" questiontype="${question.type }">
				<td>
					<#if question.type == "A">
						<textarea readonly style="margin-left:35px;" cols="50" rows="5" >${question.examAnswer.get(0) }</textarea><br>
					</#if>
					
					<#if question.type == "T">
						<span style="color:red">考生答案：</span><#list question.examAnswer as eAnswer >${eAnswer }</#list><br>
					</#if>
				</td>
			</tr>
		<#else>
			<tr id="${question.type }_${question.id}_question" questiontype="${question.type }">
				<td class="kaoshibd">
				${ question_index + 1 }、${question.content }（${question.score}分）
				<input type="image" src="../images/kaoshiico4.gif" name="question_${question.id?c}_id" />
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
											<#list question.examAnswer as examAnswer ><#if examAnswer == answer.itemContent >checked="checked"</#if></#list>/>
											${answer.itemContent }
										</#if>
										<#if question.type == "R" || question.type == "B"><#-- 单选和判断-->
											<input type="radio" disabled="disabled"
											<#list question.examAnswer as examAnswer ><#if examAnswer == answer.itemContent >checked="checked"</#if></#list>/>
											${answer.itemContent }
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
													<input style="margin-left: 15px;" type="checkbox" onClick="submitAnswers(this);" name="question_${childQuestion.id?c}" seq="${ childAnswer.itemSeq }" value="${ childAnswer.id?c }" />
													<#if childAnswer.itemContent ??>
														${ childAnswer.itemContent }
													</#if>
												</#if>
												<#if childQuestion.type == "R" || childQuestion.type == "B">
													<input type="hidden" name="question_${childQuestion.id?c}_id" value="${ childAnswer.questionId?c }" />
													<input style="margin-left: 15px;" type="radio" onClick="submitAnswers(this);" name="question_${childQuestion.id?c}" seq="${ childAnswer.itemSeq }" value="${childAnswer.id?c}"/>
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