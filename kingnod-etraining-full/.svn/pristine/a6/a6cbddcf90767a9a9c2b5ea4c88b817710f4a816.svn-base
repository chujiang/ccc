/**
 * 下拉框联动处理
 * @author Sam
 */
(function ($) {
	/**
	 * 根据指定的数据重新设置下拉框的options
	 * @param select 要重设的下拉框id
	 * @param results 要重设置的option数据，必须是集合类型
	 * @param keyName results中item的属性对应生成option的text属性
	 * @param keyValue results中item的属性对应生成option的value属性
	 */
	function resetSelect(select,results,keyName,valueName) {
		var $_select = $(select);
		$_select.empty();
    	var options = [], i = 0, o = null;
    	if ($_select.attr("emptyOption") && 
    		($_select.attr("emptyOption") === 'true' || $_select.attr("emptyOption") === true)) {
    		options.push("<option value=''>" + ($_select.attr("emptyOptionText")||"") + "</option>");
        }
        for (i = 0; i < results.length; i++) {
        	options.push("<option value='"+results[i][valueName]+"'>"+results[i][keyName]+"</option>");
        }
        
        $_select.html(options.join(" "));
//        if ($(select).getSelectBoxId()) {
//        	$(select).selectbox();
//        }
        
	}
	
	/**
	 * 将id1,id2,id3转换成#id1,#id2,#id3，如果设置了targetType如id1:same、id1:reverse就要设置他的targetType属性
	 */
	function setTargetSelector(str,settings) {
		var _o = str.split(",");
    	for (var i = 0; i < _o.length; i++ ) {    		
    		if (_o[i].indexOf(":") != -1) {
    			var arr = _o[i].split(":");
    			_o[i] = arr[0];
    			if (arr[1] == "local") {
    				settings.locals[arr[0]] = arr[0];
    			} else if (arr[1] == "reverse") {
    				settings.reverses[arr[0]] = arr[0];
    			}
    		}
    		_o[i] = /\s*[#].*/.test(_o[i])?_o[i]:_o[i].replace(/^\s*/,"#");
    	}
    	return _o.join(",");
	}
	
	/**
	 * 调用一个函数，可以是基于字符串、直接传函数名、javascript代码
	 */
	function invokeFunction(functionDefined,owner,params) {
		if (!functionDefined)
			return;	
		
		if (typeof functionDefined == 'string') {
    		var exeScript = functionDefined.replace(/^\s*/,"");
    		if (/^\s*function[(]\w*[)]\s*[{].*[}].*/.test(functionDefined)) {
    			functionDefined = eval("(function(){ return "+functionDefined+"})();");
    		} else if (/^\s*\w*[(]\w*[)]\w*/.test(functionDefined) === false) {
    			functionDefined = eval(functionDefined);
    		} else {
    			return eval(functionDefined);
    		}
    	}

		if ($.isFunction(functionDefined)) {
    		return functionDefined.apply(owner,params);
    	}
		
    	
	}
	//处理tagetType=same 的联动
	function handleLocal(targets,val) {
		$(targets).each(function(){
			$(this).val(val);
			if ( ($(this).attr("chainable") === true || $(this).attr("chainable")==='true')) {
				$(this).trigger("change");
			}
		});
	}
	
	/**
	 * 联动刷新
	 * @param options see the defaults
	 */
    $.fn.selectChain = function (options) {
        var defaults = {
        	//联动后调用的事件方法
        	afterChain:null,
        	//联运刷新的URL
            url:$.webPath + "selectChain",
            //返回的JSON对象对应option text属性的属性名
            key:'name',
            //返回的JSON对象对应option value属性的属性名
            value:'value',
            //要提交的form参数
            form:document.forms[0],
            //要提交的参数
            params:{},
            //刷新提交之前调用的函数
            beforeChain:null,
            //要刷新的目标下拉框组件
            target:null,
            //本地处理的
            locals:{},
            //反向处理的
            reverses:{},
            //从服务器取回数据重设下拉框的处理器
            handler:function(rs,settings){   
            	if (rs && rs.length) {
            		for (i = 0; i < rs.length; i++) { 
            			if (settings.reverses[rs[i].id]) { 
            				$("#"+rs[i].id).val(rs[i].items[0][settings.value]);
            			} else {
            				resetSelect("#"+rs[i].id,rs[i].items,settings.key,settings.value);
//            				if ($("#filter_selected_"+rs[i].id))
//            					$("#filter_selected_"+rs[i].id).remove();
//            				$.filterselect.update("#"+rs[i].id);
            			}
            			var $_target = $("#"+rs[i].id);            			
            			if ( $("#"+rs[i].id + " option").length > 0 && 
            					($_target.attr("chainable") === true || $_target.attr("chainable")==='true')) {
            				$_target.trigger("change");
            			}
            		}
            	}
            }
        };
        if (typeof options == "object" && typeof options.target == "string") {
        	options.target = setTargetSelector(options.target,defaults);
        } else if (typeof options == "string") {
        	var _o = {
        			target : setTargetSelector(options,defaults),
        			url:arguments[1]||defaults.url,
        			beforeChain:arguments[2]||null,
        			handler:arguments[3]||defaults.handler
        			};
        	options = _o;
        }  
        var settings = $.extend({}, defaults, options);
        
        if (!(settings.target instanceof $)) settings.target = $(settings.target);
        
        return this.each(function () {
        	//非select不作处理
        	if (this.tagName.toLowerCase() != "select" )
        		return;
        	//要联动其他下拉框的jquery对象
            var $$ = $(this);
            
            $$.change(function () {
            	//提交到联动Servlet处理器的Json联动参数
            	var refParams = [];
            	
            	//联动时依赖的参数
            	var chainParams ={};
            	
            	/*
            	 * 如果当前的Select是定义在Form的情况，将Form的所有参数都提交过去，否则
            	 * 只提交当前Select的值
            	 */
            	if (typeof settings.form != 'undefined' ) {
            		var formParams = $.formParams(settings.form);
            		for (var i=0; i<formParams.length; i++) {
            			chainParams[formParams[i].name]=formParams[i].value;
            		}
            	} else if (typeof settings.params == 'object') {
            		var defaultParams = {};
            		defaultParams[$$.attr("name")]=$$.val();
            		chainParams = $.extend(defaultParams,settings.params);
                }
            	
            	//初始化提交到selectChainServlet的参数
            	var isOnlyLocal = false;//是否只有本地处理(如国家中文名联动国家英文名，它们的key值是相同的，所以没有必要提交到服务器)
            	var hasLocal = false;//是否有本地处理的联动
            	settings.target.each(function(idx){ 
            		var me = $(this);
            		if (settings.locals[this.id]) {
            			hasLocal = true;
            			isOnlyLocal = true;
            		} else {
            			isOnlyLocal = false;
            		}
            		
            		var aParam = {params:chainParams,dictName:me.attr("dictName"),id:this.id||this.name,local:isOnlyLocal};
            		refParams.push(aParam);
            	});
                
            	//触发beforeChain事件
            	var invokeRs = invokeFunction(settings.beforeChain,$$,[settings,refParams]);
            	if (invokeRs === false)
            		return;
                
            	if (isOnlyLocal) {
            		handleLocal(settings.target,$$.val());
            	} else { 
            		//如果有本地要处理的联动先进行处理            		
            		if (hasLocal) {
            			var targetss = [],newRefParams=[];
            			for (var i = 0; i < refParams.length; i++ ) {
            				if (refParams[i].local===true) {
            					targetss.push("#"+refParams[i].id);            					
            				} else {
            					newRefParams.push(refParams[i]);
            				}
            			}
            			handleLocal(targetss.join(","),$$.val());
            			refParams = newRefParams;            			
            		}
            		
            		//执行异步联动
	                $.ajax({
	                    url: settings.url,
	                    data: JSON.stringify(refParams),
	                    cache:false,
	                    contentType:'application/json',
	                    processData:false,
	                    type: 'post',
	                    dataType: 'json',
	                    success: function (rs) {//此处要注意，如果服务器端输出时没有设置contenetType可能会触发parsererror错误
	                		settings.handler.apply($$,[rs,settings]);  
	                		//触发afterChain事件
	                		invokeFunction(settings.afterChain,$$,[settings,refParams]);
	                    },
	                    error: function (xhr, desc, er) {
	                    	alert("联动刷新时出错了！\n错误信息"+desc+er);
			            }
	                });
            	}
            });
        });
    };
})(jQuery);