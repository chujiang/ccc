<!--搜索 开始-->
<table id="searchTab" height="24" border="0" align="center" cellpadding="0" cellspacing="0" width="100%" class="le_titbg heit">
  <tr>
    <td width="100%" align="left" class="le_searchtit" nowrap="nowrap">&nbsp;搜索</td>
    <td width="5" align="right" valign="top"><img src="../images/list_rt.jpg" width="5" height="28"></td>
  </tr>
  <tr>
    <td colspan="2" class="midso" height="30" valign="top" >
         <table border="0" cellpadding="0" cellspacing="0" class="tab_search2" order="0" >
          <tr>
            <td class="td_search" nowrap="nowrap">查询条件：</td>
            <td class="td_search">
            <select id="filterName" name="filterName" onchange="onFilterNameChange();" style="width:110px;">
				<#list parameters.items as item >
					<#if item??>
    				<option value="${item.value}" 
    					<#if parameters.filterNameValue ??>
	    					<#if item.value == parameters.filterNameValue >
	    						selected = "selected"
	    					</#if>
    					</#if>
    				dateType="${typeMap[item.value]}" <#rt/>>
    				<#if item.name??>
    				${item.name?default("")?html}<#lt/>
    				</#if>
    				</option>
    				</#if>
				</#list>
			</select>
            </td>
            <td nowrap="nowrap" id="textStyle" <#if parameters.filterNameValueType != parameters.date > class="td_search" <#else> class="con_hidden" </#if> >
			关键字：<input <#if parameters.filterNameValueType == parameters.date > disabled="true" </#if> type="text" id="KeyWord" value="${parameters.allName}" name="filterKeyword" style="width: ${parameters.keywordWidth}px;"/>
			</td>
	        <td nowrap="nowrap" id="dateStyle" <#if parameters.filterNameValueType == parameters.date > class="td_search" <#else> class="con_hidden" </#if> >
				日期:<input size="9" <#if parameters.filterNameValueType != parameters.date > disabled="true" </#if> type="text" id="start" name="filterKeyword" value="${parameters.start}" id="filterKeyword" title="" onfocus="WdatePicker({&quot;dateFmt&quot;:&quot;yyyy-MM-dd&quot;})"/>
				至 <input size="9" <#if parameters.filterNameValueType != parameters.date > disabled="true" </#if> type="text" id="end" name="filterKeyword" value="${parameters.end}" id="filterKeyword" title="" onfocus="WdatePicker({&quot;dateFmt&quot;:&quot;yyyy-MM-dd&quot;})"/>
			</td>
<!--搜索 前半段结束-->			