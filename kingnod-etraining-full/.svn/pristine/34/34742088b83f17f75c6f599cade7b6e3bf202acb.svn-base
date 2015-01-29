

<table width="100%">
<tr>
	<td>	
	<div style="float:left;">

	当前第<strong>${page}</strong> 页，共 <strong>${totalPages}</strong> 页，    每页${pageSize}条记录， 共有${totalCount}条记录 

    </div>
    
    <div style="float:right;">     
    <a href="javascript:void(kui.grid.jump(1,'${gridId}'));">首页</a> 
    <#if hasPre == true>
     <a href="javascript:void(kui.grid.jump(${prePage},'${gridId}'));">上一页</a>
    </#if> 
    <input type="text" style="width:30px;" gridId="${gridId}" title="请输入您想要进入的页码" onkeypress="return kui.grid.jumpInput(event,this);" totalPages="${totalPages}" />
    <#if hasNext == true>
      <a href="javascript:void(kui.grid.jump(${nextPage},'${gridId}'));">下一页</a>
    </#if> 
    <a href="javascript:void(kui.grid.jump(${totalPages},'${gridId}'));">尾页</a> 
   	</div>
    </td>
	</tr>
</table>