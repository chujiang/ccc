
<script type="text/javascript">
    this.daysMonth  = new Array(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);
	$(function()  
	{
	   var speed = 5;
	   var str =$("#jsonVar").val();
	  
	   if(str!=null && str!="")
	   {
		   var jsonObject = eval("(" + str + ")");
		    //alert(jsonObject.periodType);
		   
		   
		   $('#periodType').attr('value',jsonObject.periodType);
		   switch ($('#periodType').val())
			{ 
				case 'S':
					Period_show_S();
					break;
				case 'D':
					Period_show_D();
					break;
				case 'W':
					Period_show_W();
					break;
				default:
					$("#days_checkbox_td").remove();
					$('#days').hide();
					$('#time').hide();
					$('#week').hide();
					$('#availableDays').val='null';
			}
			
		}
		
	   
	}); 
	
	
	
</script>
<div name="${parameters.name?html}">
		<input id="jsonVar" type="hidden" name="${parameters.name?html}" size="200"
		<#if parameters.nameValue??>
 			value="<@s.property value="parameters.nameValue"/>"<#rt/>
		</#if>/>
		<input type="hidden" name="period_id" <#rt/>
		<#if parameters.periods??>
			<#if parameters.periods.id??>
				value="${parameters.periods.id}"<#rt/>
			</#if>
		</#if>
		 />
		<input type="hidden" id="availableDays" name="availableDays" <#rt/>
		<#if parameters.periods??>
			<#if parameters.periods.availableDays??>
			 	value="${parameters.periods.availableDays}"<#rt/>
			</#if>
		</#if>
		 />
		<input type="hidden" name="periodFlagType" <#rt/>
		<#if parameters.periods??>
			<#if parameters.periods.periodFlagType??> 
				value="${parameters.periods.periodFlagType?html}"<#rt/>
			</#if>
		</#if>
		/>
		<input type="hidden" name="periodFlagId" <#rt/>
		<#if parameters.periods??>
			<#if parameters.periods.periodeFlagId??> 
				value="${parameters.periods.periodFlagId?html}"<#rt/>
			</#if>
		</#if>
		/>
		 <label>${parameters.periodDate}</label>: 
		 <input id="d4312" type="text"<#rt/> name="startDate"
			 class="Wdate"
			 onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',oncleared:function(dp){period_chang(this.value);},onpicked:function(dp){period_chang(this.value);}})"
			 <#if parameters.periods??>
				<#if parameters.periods.startDate??> 
					value="${parameters.periods.startDateShow}"<#rt/>
				</#if>
			</#if> 
		 />
		 <label>${parameters.periodLink}</label>
		 <input type="text"<#rt/> name="endDate"
			 class="Wdate"
			 onfocus="WdatePicker({minDate:'#F{$dp.$D(\'d4312\')}',dateFmt:'yyyy-MM-dd',oncleared:function(dp){period_chang(this.value);},onpicked:function(dp){period_chang(this.value);}})"
			  <#if parameters.periods??>
				<#if parameters.periods.endDate??> 
					 value="${parameters.periods.endDateShow}"<#rt/>
				</#if>
			</#if> 
		 /><br>
		<label>${parameters.periodType}</label>:
		<input type="hidden" id="selected" <#rt/>
			<#if parameters.periods??>
				<#if parameters.periods.periodType??> 
					value="${parameters.periods.periodType}"<#rt/>
				</#if>
			<#else>
				value="N"<#rt/>
			</#if>
		/>
		<select name="periodType" id="periodType" onchange="periodTypeChange();">
		  <option value ="N">${parameters.timeType_N}</option>
		  <option value ="W">${parameters.timeType_W}</option>
		  <option value ="D">${parameters.timeType_D}</option>
		  <#--<option value ="S">${parameters.timeType_S}</option>-->
		</select>
		<div id="week" style="display:none;height:50px; width: 320px;top:150px;left:500px;">
			<table>
				<tr>
					<td>
						<input class="weekDays"  name="monday" value="1" type="checkbox" onchange="period_chang();"/><label>${parameters.monday}</label>,
						<input class="weekDays" name="tuesday" value="2" type="checkbox" onchange="period_chang();"/><label>${parameters.tuesday}</label>,
						<input class="weekDays" name="wednesday" value="3" type="checkbox" onchange="period_chang();"/><label>${parameters.wednesday}</label>,<br>
						<input class="weekDays" name="thursday" value="4" type="checkbox" onchange="period_chang();"/><label>${parameters.thursday}</label>,
						<input class="weekDays" name="friday" value="5" type="checkbox" onchange="period_chang();"/><label>${parameters.friday}</label>,
						<input class="weekDays" name="saturday" value="6" type="checkbox" onchange="period_chang();"/><label>${parameters.saturday}</label>,
						<input class="weekDays" name="sunday" value="7" type="checkbox" onchange="period_chang();"/><label>${parameters.sunday}</label>
					</td>
				</tr>
			</table>
		</div>			
		<div id="days" style="display:none;height:85px; width: 480px;top:150px;left:500px;">
			<table>
				<tr id="days_checkbox">
					

					
				</tr>
			</table>
		</div>
		<div id="time" style="display:none; height:50px; width: 360px;top:150px;left:500px;">
			<table style="margin-top: 5px;">
				<tr>
					<td colspan="3"> <label>${parameters.Expression}</label>: </td>
				</tr>
				<tr>
					<td>
						<input type="text" id="open_time" name="open_time" maxlength="100" onchange="period_chang();" />
					</td>
				</tr>
			</table>
		</div>
		<br>	
		<label>${parameters.periodTime}</label>: 
		<input id="d4313" type="text"<#rt/> name="startTime"
			 class="Wdate"
			 onfocus="WdatePicker({dateFmt:'HH:mm:ss',oncleared:function(dp){period_chang(this.value);},onpicked:function(dp){period_chang(this.value);}})"
			 <#if parameters.periods??>
				<#if parameters.periods.startTime??> 
					value="${parameters.periods.startTimeShow?html}"<#rt/>
				</#if>
			</#if>
			 onchange="period_chang();"
		 />
		 
		 <label>${parameters.periodLink}</label>
		 <input type="text"<#rt/> name="endTime"
			 class="Wdate"
			 onfocus="WdatePicker({minDate:'#F{$dp.$D(\'d4313\')}',dateFmt:'HH:mm:ss',oncleared:function(dp){period_chang(this.value);},onpicked:function(dp){period_chang(this.value);}})"
			 <#if parameters.periods??>
				<#if parameters.periods.endTime??> 
					value="${parameters.periods.endTimeShow?html}"<#rt/>
				</#if>
			</#if>
		 /><br>
		</div>