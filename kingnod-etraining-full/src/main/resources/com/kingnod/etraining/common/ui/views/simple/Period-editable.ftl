
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
	
	
function Period_show_D() {
	var days_checked = "";
	if(document.getElementById("availableDays") != null) {
		days_checked = (document.getElementById("availableDays").value).split("-");
	}
	var d = new Date();
	var y = d.getYear();
	var m = d.getMonth() + 1;
	daysMonth[1] = (0 == y % 4 && (y % 100 != 0 || y % 400 == 0)) ? 29 : 28;

	$("#days_checkbox").append("<td id='days_checkbox_td'>");
	for ( var i = 1; i < daysMonth[m - 1] + 1; i++) {
		$("#days_checkbox_td").append(
				"&nbsp;&nbsp;&nbsp;<input id=" + i + " name=" + i
						+ " type='checkbox' onblur='period_chang(this.value);' disabled/>");
		if (i < 10) {
			$("#days_checkbox_td").append("&nbsp" + i + "&nbsp;");
		} else {
			$("#days_checkbox_td").append(i + "");
		}
		if (0 == i % 10) {
			$("#days_checkbox_td").append("<br>");
		}

		if (-1 < $.inArray(i + "", days_checked)) {
			$("input[name=" + i + "]:checkbox").attr("checked", true);
		}
	}
	$("#days_checkbox").append("</td>");
	var speed = 5;
	$('#week').hide(speed);
	$('#time').hide(speed);
	$('#days').show(speed);
}
	
	
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
		 
		<input type="hidden" name="flagType" <#rt/>
		<#if parameters.periods??>
			<#if parameters.periods.flagType??> 
				value="${parameters.periods.flagType?html}"<#rt/>
			</#if>
		</#if>
		/>
		
		<input type="hidden" name="flagId" <#rt/>
		<#if parameters.periods??>
			<#if parameters.periods.flagId??> 
				value="${parameters.periods.flagId?html}"<#rt/>
			</#if>
		</#if>
		/>
		
		 <label>${parameters.periodDate}</label>: 
		 <#if parameters.periods??>
			<#if parameters.periods.startDate??> 
				${parameters.periods.startDateShow}<#rt/>
			</#if>
		</#if> 
			
		 <label>${parameters.periodLink}</label>
		  <#if parameters.periods??>
			<#if parameters.periods.endDate??> 
				 ${parameters.periods.endDateShow}<#rt/>
			</#if>
		 </#if> 
		 <br>
		 
		 
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
		<select name="periodType" id="periodType" onchange="periodTypeChange();" disabled>
		  <option value ="N">${parameters.timeType_N}</option>
		  <option value ="W">${parameters.timeType_W}</option>
		  <option value ="D">${parameters.timeType_D}</option>
		  <option value ="S">${parameters.timeType_S}</option>
		</select>
		
		<div id="week" style="display:none;height:50px; width: 320px;top:150px;left:500px;">
			<table>
				<tr>
					<td>
						<input id="weekDays"  name="monday" value="1" type="checkbox" onchange="period_chang();" disabled/><label>${parameters.monday}</label>,
						<input id="weekDays" name="tuesday" value="2" type="checkbox" onchange="period_chang();" disabled/><label>${parameters.tuesday}</label>,
						<input id="weekDays" name="wednesday" value="3" type="checkbox" onchange="period_chang();" disabled/><label>${parameters.wednesday}</label>,<br>
						<input id="weekDays" name="thursday" value="4" type="checkbox" onchange="period_chang();" disabled/><label>${parameters.thursday}</label>,
						<input id="weekDays" name="friday" value="5" type="checkbox" onchange="period_chang();" disabled/><label>${parameters.friday}</label>,
						<input id="weekDays" name="saturday" value="6" type="checkbox" onchange="period_chang();" disabled/><label>${parameters.saturday}</label>,
						<input id="weekDays" name="sunday" value="7" type="checkbox" onchange="period_chang();" disabled/><label>${parameters.sunday}</label>
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
		<#if parameters.periods??>
			<#if parameters.periods.startTime??> 
				${parameters.periods.startTime?html}<#rt/>
			</#if>
		</#if>
		 
		 <label>${parameters.periodLink}</label>
			 <#if parameters.periods??>
				<#if parameters.periods.endTime??> 
					${parameters.periods.endTime?html}<#rt/>
				</#if>
			</#if>
		 <br>
		</div>