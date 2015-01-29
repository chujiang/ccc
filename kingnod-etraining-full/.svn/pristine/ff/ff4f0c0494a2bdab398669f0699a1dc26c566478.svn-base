<div>
	<input id="${parameters.id?html}" type="hidden" name="${parameters.name}" <#if parameters.nameValue??>value="${parameters.nameValue}"</#if>/>
	<img id="img${parameters.id?html}" <#if parameters.attachmentUrl??>src="${parameters.attachmentUrl}"</#if> width="100px" height="100px"/>
	<div id="queue${parameters.id?html}"></div>
	<div>
		<input type="file" name="file${parameters.name?default("")?html}" id="file${parameters.id?html}" />
	</div>
	<#if parameters.imgMassageKey??>
		<label>${parameters.imgMassageKey?html}</label>
	</#if>
</div>
<SCRIPT type="text/javascript">
		<!--
		$(document).ready(function(){
			$('#file${parameters.id?html}').uploadify({
				'method'   : 'post',
		        'swf'      : '${parameters.contextPath?html}/resource/js/uploadify/uploadify.swf',
		        'uploader' : '${parameters.contextPath?html}/upd/upload.do',
		        'queueID'  : 'some_file_queue',
		        'removeCompleted' : false,
		        'buttonText' : '选择',
		        'width' : 70,
		        'height' : 20,
		        'multi' : ${parameters.multi},
		        'onUploadSuccess' : function(file, data, response) {
		        	var attachment = eval(data)[0];
		        	$("#${parameters.id?html}").val(attachment.id);
		        	$("#" + file.id).removeClass("loading").addClass("completedx");
		        	$("#cancel" + file.id).remove();
		        	//$("<input type='checkbox' name='${parameters.name?default("")?html}' value='" + attachment.id + "'/>").insertBefore("#name" + file.id);
		        	$("#img${parameters.id?html}").attr("src", attachment.url);
		        },
		        'onUploadStart' : function(file) {
		            var oldattachmentId = $("#${parameters.id?html}").val();
		            if(oldattachmentId != ''){
		        		$k.ajax({
							url:'${parameters.contextPath?html}/upd/upload!remove.action',
							type:"POST",
							async:false,
							loadingMessage:"loading...",
							data:{id:oldattachmentId},
							success:function(data, textStatus){
								//alert(textStatus);
							}
						});
					}
		        	$("#queue${parameters.id?html}").empty();
		        	$("#queue${parameters.id?html}").append("<div id='"+file.id+"' class='loading'><span id='name"+file.id+"'>"+file.name+"</span>&nbsp;&nbsp;&nbsp;&nbsp;<a id='cancel"+file.id+"' href=\"javascript:$('#file_upload').uploadify('cancel','"+file.id+"')\">Cancel</a></div>");
		        }
		    });
		});
		//-->
</SCRIPT>