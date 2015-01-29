	<!--搜索后半段开始-->	
			<#if parameters.includeSubFolders==true >
			<td>
			<#if parameters.includeSubFolderVal?? >
			<input id="includeSubFolderVal" name="includeSubFolderVal" type="checkbox" value="true" checked="checked">包含子文件夹</input>
			<#else>
			<input id="includeSubFolderVal" name="includeSubFolderVal" type="checkbox" value="true">包含子文件夹</input>
			</#if>
			</td>
			</#if>
            <td class="td_search" nowrap="nowrap">
            	<table border="0" cellpadding="0" cellspacing="0" >
                    <tr>
                      <td class="buttonOffLeft" id="btn1_11" nowrap="nowrap"></td>
                      <td nowrap="nowrap" class="buttonOffMiddle" id="btn1_12" onClick="if (checkFilterForm() ) {document.mainForm.submit();}" onblur="btn_change(1)" onMouseOver="btn_change_over(1)" onMouseOut="btn_change_out(1)">
                      <img src="../images/ico_searchico.gif" border="0" align="absmiddle"> 查询</td>
                      <td class="buttonOffRight" id="btn1_13" nowrap="nowrap"></td>
                      <td>&nbsp;</td>
                      <td class="buttonOffLeft" id="btn1_21"></td>
                      <td class="buttonOffMiddle" id="btn1_22" onClick="resetText();" onblur="btn_change(2)" onMouseOver="btn_change_over(2)" onMouseOut="btn_change_out(2)" >
                      	<img src="../images/eraser.png" onClick="resetText();" border="0" align="absmiddle"> 清除
                      </td>
                       <td class="buttonOffRight" id="btn1_23"></td>
                    </tr>
                </table>
            </td>
          </tr>
        </table>
	</td>
  </tr>
</table>
<style>
.con_hidden{
	display:none;
}
</style>
<script type="text/javascript">
	function onFilterNameChange() {
		var value = $("#filterName").find("option:selected").attr("dateType");
		if(value == "java.util.Date") {
			var dateSty = $("#dateStyle");
			dateSty.removeClass("con_hidden").addClass("td_search");
			document.getElementById("start").disabled = "";
			document.getElementById("end").disabled = "";
			var textSty = $("#textStyle");
			textSty.removeClass("td_search").addClass("con_hidden");
			document.getElementById("KeyWord").disabled = true;
			$("#KeyWord").val("");
		} else {
			var dateSty = $("#dateStyle");
			dateSty.removeClass("td_search").addClass("con_hidden");
			document.getElementById("start").disabled = true;
			document.getElementById("end").disabled = true;
			var textSty = $("#textStyle");
			textSty.removeClass("con_hidden").addClass("td_search");
			document.getElementById("KeyWord").disabled = "";
			$("#start").val("");
			$("#end").val("");
		}
	}
	function resetText() {
		$(":input[name=filterKeyword]").val("");
		$("#includeSubFolderVal").attr("checked",false);
	    $("#searchTab select").each(function(i){
			$(this).val("");
		})
		document.mainForm.submit();
	}
	
	function checkFilterForm() {
		
		if (! checkFilterDate($("#start").val(), $("#end").val()) ) {
			alert("起始日期不能大于结束日期!");
			return false;
		}
		return true;
	}

	function checkFilterDate(dateStart, dateEnd) {
		var result = false;
		if(dateStart==""||dateEnd=="")
		{
			return true;
		}

		var spl = "/";
		var splitTemp = dateStart.substring(4,5);
		var splitArray = ["-","/"];
		for(var i=0; i<splitArray.length; i++)
		{
			if(splitTemp == splitArray[i])
			{
				spl = splitArray[i];
				break;
			}
		}
		var dateStartArray = dateStart.split(spl);
		var dateEndArray = dateEnd.split(spl);
		if(parseInt(dateStartArray[0])<parseInt(dateEndArray[0]))
		{
			result = true;
		}
		else if(parseInt(dateStartArray[0])==parseInt(dateEndArray[0]))
		{
			if(dateStartArray[1].length>1)
			{
				if(dateStartArray[1].substring(0,1)=='0')
				{
					dateStartArray[1] = dateStartArray[1].substring(1,2);
				}
			}
			if(dateEndArray[1].length>1)
			{
				if(dateEndArray[1].substring(0,1)=='0')
				{
					dateEndArray[1] = dateEndArray[1].substring(1,2);
				}
			}

			if(parseInt(dateStartArray[1])<parseInt(dateEndArray[1]))
			{
				result = true;
			}
			else if(parseInt(dateStartArray[1])==parseInt(dateEndArray[1]))
			{
				if(dateStartArray[2].length>1)
				{
					if(dateStartArray[2].substring(0,1)=='0')
					{
						dateStartArray[2] = dateStartArray[2].substring(1,2);
					}
				}
				if(dateEndArray[2].length>1)
				{
					if(dateEndArray[2].substring(0,1)=='0')
					{
						dateEndArray[2] = dateEndArray[2].substring(1,2);
					}
				}
				if(parseInt(dateStartArray[2])<=parseInt(dateEndArray[2]))
				{
					result = true;
				}
			}
		}
		return result;
	}
$(function(){ 
	$("#KeyWord").keydown(function(e){
		var curKey = e.which; 
		if(curKey == 13){ 
			 document.mainForm.submit();
		return false; 
		} 
  })
}); </script>
<!--搜索 结束-->