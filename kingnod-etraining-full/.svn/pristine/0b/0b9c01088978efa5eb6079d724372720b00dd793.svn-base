<#list parameters.testGroupList as group>
	<tr><td class="kaoshibd"><span style="color:green; font-size:16px;">${group.name } (共${group.questionList?size }道题，总计${group.score }分)</span></td></tr>
	
	<#list group.questionList as question>
		<#include "/com/kingnod/etraining/common/ui/views/simple/questions-consult-answer-distributary-admin-ques.ftl"/>
	</#list>
	<tr><td><br><br></td></tr>
</#list>