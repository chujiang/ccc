/**
 * 基于jquery提供项目的一些常用的工具类及UI相关的处理
 * 
 * @author Sam
 */
(function($) {

	/**
	 * ===================================================================================================================
	 * jquery validation 扩展
	 * ===================================================================================================================
	 */
	if ($.validator) {
		$.validator
				.setDefaults({
					// 自定义错误显示
					showErrors : function() {
						var t = this;
						for ( var i = 0; this.errorList[i]; i++) {
							var error = this.errorList[i];
							this.settings.highlight
									&& this.settings.highlight.call(this,
											error.element,
											this.settings.errorClass,
											this.settings.validClass);

							var elename = this.idOrName(error.element);
							// 错误信息div
							var errdiv = $('span[for=' + elename + ']');
							var space = "";
							if (errdiv.length == 0) { // 没有div则创建
								if ($k.isFireFox())
									space = "&nbsp;&nbsp;&nbsp;&nbsp;";
								errdiv = $('<span ><span  class="uncheck">'
										+ space + error.message
										+ '</span></span>');
								errdiv.attr({
									"for" : this.idOrName(error.element),
									generated : true
								}).addClass(this.settings.errorClass);

								// errdiv.powerFloat({
								// eventType : "hover",
								// targetMode : "remind",
								// target : error.message || "",
								// position : "1-4"
								// });
								errdiv.appendTo($(error.element).parent());
							}
							errdiv.show();
						}

						// 校验成功的去掉错误提示
						for ( var i = 0; this.successList[i]; i++) {
							$(
									'span[for="'
											+ this
													.idOrName(this.successList[i])
											+ '"]').remove();
						}

						// 自定义高亮
						if (this.settings.unhighlight) {
							for ( var i = 0, elements = this.validElements(); elements[i]; i++) {
								this.settings.unhighlight.call(this,
										elements[i], this.settings.errorClass,
										this.settings.validClass);
							}
						}
					}
				});
	}

	$k = $K = _K = _k = Kingnod = kingnod = {};
	$kui = kui = KUI = $k.ui = {};

	/**
	 * ===================================================================================================================
	 * kingnod js 核心库 定义
	 * ===================================================================================================================
	 */

	// 弹出对话框要使用的DIV
	var _alertDialog = document.createElement('div');

	// 弹出确认对话框要使用的DIV
	var _confirmDialog = document.createElement('div');

	// 超时 default 90 seconds
	var _timeout = "90000";

	// 是否显示loading的层，默认不显示
	var loading = false;

	$k.copyProperties = function(to, from) {

		if (!to || !from) {
			return;
		}

		if ($.isArray(to) && $.isArray(from)) {
			$.each(from, function(i, n) {
				var flag = false;
				$.each(to, function(j, m) {
					if (n.name == m.name) {
						m.value = n.value;
						flag = true;
						return;
					}
				});

				if (!flag) {
					to.push(n);
				}

				return;
			});

			return to;
		}
	}

	/**
	 * 功能：封装jquery.ajax请求方法，设置默认的通信格式
	 * 
	 * @param opts.url
	 *            请求路径
	 * @param opts.data
	 *            请求参数
	 * @param opts.async
	 *            请求是否异步
	 * @param opts.success
	 *            成功返回之后的处理函数
	 * @param opts.type
	 *            是否是GET 还是 POST
	 * @param opts.loadingMessage
	 *            请求过程中 loading层的显示信息
	 * @param opts.handleValidation
	 *            服务端验证失败时调用的处理函数
	 * 
	 */
	$k.ajax = function(opts) {
		opts.async = opts.async || true;

		if (!opts.async && loading) {
			return;
		}

		var tokenName = null;
		var token = null;
		$(document).find(':input').each(function(i, n) {
			if ($(n).attr('name') == 'struts.token.name') {
				tokenName = n;
			}
			if ($(n).attr('name') == 'struts.token') {
				token = n;
			}
		});
		if (!opts.data) {
			opts.data = [];
		}

		if (!opts.type) {
			opts.type = 'POST';
		}
		if (!$.isArray(opts.data)) {
			var o = [];
			$.each(opts.data, function(i, n) {
				o.push({
					name : i,
					value : n
				});
			});
			opts.data = o;
		}

		if (tokenName && token) {
			var topa = [ {
				name : $(tokenName).attr('name'),
				value : $(tokenName).attr('value')
			}, {
				name : $(token).attr('name'),
				value : $(token).attr('value')
			} ];
			copyProperties(opts.data, topa);
		}

		if (!opts.async) {
			loading = true;
		}

		// 将请求中的URL中的 "//" 转换为 "/"
		if (opts.url && opts.url.substring(0, 2) == "//") {
			opts.url = opts.url.substring(1);
		}
		if (opts.url.indexOf("?") != -1) {
			opts.url = opts.url + '&_=' + new Date().getTime();
		} else {
			opts.url = opts.url + '?_=' + new Date().getTime();
		}
		// 根据封装好的参数去调用jquery.ajax方法
		$.ajax({
			url : opts.url,
			data : opts.data,
			async : opts.async,
			dataType : 'json',
			timeout : _timeout,
			type : opts.type,
			// 服务器接受到客户端的请求，并且返回了处理客户端请求的处理结果
			success : function(data, textStatus) {

				if (!opts.async) {
					loading = false;
				}

				// 一下根据不同的返回结果做相应的处理
				if (data.sessionTimeout) {
					$.windowAlert("会话已超时，请重新登录", function() {
						if (data.loginPage) {
							window.top.location.href = data.loginPage;
						} else {
							$.showWindow({
								id : 'login',
								url : $.webPath + 'login.action',
								title : '登录页面',
								width : 800,
								height : 600
							});
						}
					});
					return;
				}

				// 返回的数据格式不符合规范
				if (typeof data.executeStatus == 'undefined') {
					$.windowAlert('您确认后台返回的是框架规定的jsonResult吗？');
					return;
				}

				if (token) {
					$(token).attr('value', data['struts.token']);
				}

				// 服务器端错误消息
				if (data.executeStatus == 2) {
					$.windowAlert(data.errorMessage);
					if (opts.error) {
						opts.error();
					}
					return;
				}

				// 成功能执行，调用success参数方法
				if (data.executeStatus == 0) {
					opts.success(data.values, textStatus);
				}

				// 校验失败
				if (data.executeStatus == 1) {
					if (opts.handleValidation) {
						opts.handleValidation(data.fieldErrors);
					} else {
						$('#validateTips').empty();
						$.each(data.fieldErrors, function(i, n) {
							var txt = document.getElementById(i);
							$(txt).addClass('ui-state-error');
							$('#validateTips').append('<p>' + n + '</p>');
						});
					}

				}
			},
			// 服务端没有接收到客户端的请求
			error : function(errors, textStatus) {

				if (!opts.async) {
					loading = false;
				}

				if ("timeout" == textStatus) {
					$.windowAlert("系统请求超时，请联系管理员！");
				}

				if (opts.error) {
					opts.error();
				}
			}
		});
	};

	/**
	 * 功能：将json数据转换成页面菜单
	 * 
	 * @param json数据
	 */
	$k.renderNavMenus = function(data) {
		var targetHtml = "";
		targetHtml = targetHtml
				+ '<table width="100%" border="0" cellpadding="5" cellspacing="0" class="grid_quickMenu_bg" onMouseOver="" onMouseOut="">\n';
		targetHtml = targetHtml + '  <tr>\n';
		targetHtml = targetHtml + '    <td>\n';
		targetHtml = targetHtml
				+ '      <table width="100%" border="0" cellpadding="2" cellspacing="0">\n';
		targetHtml = targetHtml + '        <tr>\n';
		targetHtml = targetHtml
				+ '          <td class="toolbarico">1-2A</td>\n';
		targetHtml = targetHtml + '        </tr>\n';
		targetHtml = targetHtml + '        <tr>\n';
		targetHtml = targetHtml
				+ '          <td class="quickMenu_toolbarico">\n';
		targetHtml = targetHtml
				+ '            <a href="#" onFocus="this.blur()" onClick="">\n';
		targetHtml = targetHtml
				+ '            <img src="../images/ico_amend.gif" alt="" width="16" height="16" border="0" align="absbottom">修改</a>\n';
		targetHtml = targetHtml + '          </td>\n';
		targetHtml = targetHtml + '        </tr>\n';
		targetHtml = targetHtml + '      </table>\n';
		targetHtml = targetHtml + '    </td>\n';
		targetHtml = targetHtml + '  </tr>\n';
		targetHtml = targetHtml + '</table>\n';
		return targetHtml;
	};

	$k.CheckTextArea = function(field, maxlimit) {
		if (field.value.length > maxlimit) { // if too long...trim it!
			field.value = field.value.substring(0, maxlimit);
		}
	} // end of the 'CheckTextArea()' function

	$k.startWith = function(str1, str2) {
		if (str2 == null || str2 == "" || str1.length == 0
				|| str2.length > str1.length)
			return false;
		if (str1.substr(0, str2.length) == str2)
			return true;
		else
			return false;
		return true;
	};

	$k.checkIntegerTagIntKey = function(evt, elm, hasNegative) { // check if
																	// the input
																	// key is
																	// allowed
		evt = evt ? evt : (window.event ? window.event : null);
		var key = evt.keyCode ? evt.keyCode : (evt.which ? evt.which
				: evt.charCode);
		if (hasNegative) {
			if (key == 45 && trim(elm.value) == '') { // negative sign '-' is
														// allowed
				return true;
			}
		}
		if ((key >= 48 && key <= 57) || (key == 8)) { // allow input of digit
														// 0-9 and back(Firefox)
			return true;
		}
		return false;
	};

	$k.checkIntegerTagIntValue = function(elm) { // check if the input is an
													// integer
		if (isNaN(elm.value) || elm.value.indexOf('.') != -1) {
			alert('Input must be an integer.');
			setTimeout(function() {
				elm.focus();
			}, 10);
			return false;
		}
	};

	$k.checkFloatTagFloatKey = function(evt, elm, hasNegative) {
		evt = evt ? evt : (window.event ? window.event : null);
		var key = evt.keyCode ? evt.keyCode : (evt.which ? evt.which
				: evt.charCode);
		if (hasNegative) {
			if (key == 45 && trim(elm.value) == '') {
				return true;
			}
		}
		if (key == 46) {
			if (elm.value.indexOf('.') != -1) {
				return false;
			}
		}
		if ((key >= 48 && key <= 57) || key == 46 || (key == 8)) { // allow
																	// input of
																	// digit 0-9
																	// and
																	// back(Firefox)
			return true;
		}
		return false;
	};
	$k.checkFloatTagFloatValue = function(elm) {
		if (isNaN(elm.value)) {
			alert('Input must be an float.');
			setTimeout(function() {
				elm.focus();
			}, 10);
			return false;
		}
	};
	$k.getPageSize = function() {
		var xScroll, yScroll;
		if (window.innerHeight && window.scrollMaxY) {
			xScroll = window.innerWidth + window.scrollMaxX;
			yScroll = window.innerHeight + window.scrollMaxY;
		} else if (document.body.scrollHeight > document.body.offsetHeight) { // all
																				// but
																				// Explorer
																				// Mac
			xScroll = document.body.scrollWidth;
			yScroll = document.body.scrollHeight;
		} else { // Explorer Mac...would also work in Explorer 6 Strict,
					// Mozilla and Safari
			xScroll = document.body.offsetWidth;
			yScroll = document.body.offsetHeight;
		}
		var windowWidth, windowHeight;
		if (self.innerHeight) { // all except Explorer
			if (document.documentElement.clientWidth) {
				windowWidth = document.documentElement.clientWidth;
			} else {
				windowWidth = self.innerWidth;
			}
			windowHeight = self.innerHeight;
		} else if (document.documentElement
				&& document.documentElement.clientHeight) { // Explorer 6 Strict
															// Mode
			windowWidth = document.documentElement.clientWidth;
			windowHeight = document.documentElement.clientHeight;
		} else if (document.body) { // other Explorers
			windowWidth = document.body.clientWidth;
			windowHeight = document.body.clientHeight;
		}
		// for small pages with total height less then height of the viewport
		if (yScroll < windowHeight) {
			pageHeight = windowHeight;
		} else {
			pageHeight = yScroll;
		}
		// for small pages with total width less then width of the viewport
		if (xScroll < windowWidth) {
			pageWidth = xScroll;
		} else {
			pageWidth = windowWidth;
		}
		arrayPageSize = new Array(pageWidth, pageHeight, windowWidth,
				windowHeight);
		return {
			pageWidth : pageWidth,
			pageHeight : pageHeight,
			windowWidth : windowWidth,
			windowHeight : windowHeight
		};
	};
	$k.maximumWindow = function(win) {
		if (typeof (win) == 'undefined') {
			window.moveTo(0, 0);
			window.resizeTo(window.screen.width, window.screen.height);
		} else {
			win.moveTo(0, 0);
			win.resizeTo(window.screen.width, window.screen.height);
		}
	};

	/**
	 * 功能：弹出alert窗口
	 * 
	 * @param msg
	 *            提示信息
	 * @param callback
	 *            点击确定的回调函数
	 * @param titleText
	 *            标题栏显示文本
	 * 
	 */
	$.alert_init = function(msg, callback, titleText) {
		if (window.top.jericho) {
			window.top.jericho.alertDialog(msg, callback, titleText);
		} else {
			var opts = {
				width : 300,
				height : 'auto',
				maxHeight : 600,
				autoOpen : false,
				modal : true,
				stack : true,
				simple : true,
				resizable : false,
				buttons : {
					'确定' : function() {
						if ($.isFunction(callback)) {
							callback();
						}
						$(this).dialog('close');
					}
				}
			};

			$(_confirmDialog).attr('id', 'alertWindow');
			if (titleText != null && typeof (titleText) != 'undefined'
					&& titleText.length != 0) {
				$(_alertDialog).attr('title', titleText);
			} else {
				$(_alertDialog).attr('title', '提示');
			}

			_alertDialog.innerHTML = "&nbsp;&nbsp;" + msg;
			$(_alertDialog).dialog(opts);
			$(_alertDialog).dialog('open');
		}
	};

	/**
	 * 功能：顶级窗口弹出alert窗口 （引用）
	 * 
	 * @param msg
	 *            提示信息
	 * @param callback
	 *            点击确定的回调函数
	 * @param titleText
	 *            标题栏显示文本
	 * 
	 */

	$.windowAlert = function(msg, callback, titleText) {
		window.top.$.alert_init(msg, callback, titleText);
	}

	$.alert = $.windowAlert;
	/**
	 * 功能：弹出comfrim窗口
	 * 
	 * @param msg
	 *            提示信息
	 * @param ok
	 *            点击确定的回调函数
	 * @param cancel
	 *            点击取消的回调函数
	 */
	$.confirm_init = function(msg, ok, cancel) {
		if (window.top.jericho) {
			window.top.jericho.confirmDialog(msg, ok, cancel);
		} else {

			var opts = {
				width : 300,
				height : 'auto',
				autoOpen : false,
				modal : true,
				simple : true,
				resizable : false,
				buttons : {
					'确定' : function() {
						if ($.isFunction(ok)) {
							ok();
						}
						$(this).dialog('close');
					},
					'取消' : function() {
						if ($.isFunction(cancel)) {
							cancel();
						}
						$(this).dialog('close');
					}
				}
			};

			$(_confirmDialog).attr('id', 'confirmWindow');
			$(_confirmDialog).attr('title', '信息提示');
			_confirmDialog.innerHTML = "&nbsp;&nbsp;" + msg;
			$(_confirmDialog).dialog(opts);
			$(_confirmDialog).dialog('open');
		}
	};

	/**
	 * 功能：顶级窗口弹出comfrim窗口（引用）
	 * 
	 * @param msg
	 *            提示信息
	 * @param ok
	 *            点击确定的回调函数
	 * @param cancel
	 *            点击取消的回调函数
	 */

	$.windowConfirm = function(msg, ok, cancel) {

		window.top.$.confirm_init(msg, ok, cancel);
	}

	$.confirm = $.windowConfirm;

	if (!window.top.jericho) {
		var openWindows = [];
	}

	/**
	 * 功能：打开新窗口层
	 * 
	 * @param p.url
	 *            请求路径
	 * @param p.title
	 *            窗口名称
	 * @param p.width
	 *            窗口宽度
	 * @param p.height
	 *            窗口高度
	 * @param p.type
	 *            弹出窗口类型：html为页面动态插入，iframe为通过来获取页面，默认为iframe
	 * @param p.onClose
	 *            窗口上面点击关闭图标的回调函数
	 */
	$.showWindow = function(p) {

		if (!p.url && !p.id) {
			$.alert("弹出窗口必须要设置url属性或者id属性！");
			return;
		}

		// 头"//" -> "/"
		if (p.url && p.url.substring(0, 2) == "//") {
			p.url = p.url.substring(1);
		}

		// apply default properties
		p = $.extend({
			title : '新窗口',
			type : 'iframe',
			width : '500',
			height : '600',
			buttons : {},
			simple : false,
			modal : true
		}, p);

		if (window.top.jericho) {
			window.top.jericho.showWindow(p);
			return;
		} else {

			/**
			 * 如果当前已经打开了一个窗口，则不再打开了
			 */
			var flag = false;
			$.each(openWindows, function(i, n) {
				if (n.id == p.id) {
					flag = true;
				}
			});
			if (flag) {
				return;
			}

			var dt = '' + new Date().getTime();
			var srcurl = p.url + '?_=' + dt;
			var fid = "iframe_" + dt;

			var opts = {
				id : p.id,
				width : p.width,
				height : p.height,
				autoOpen : false,
				modal : p.modal,
				simple : p.simple,
				buttons : p.buttons,
				resizable : false,
				close : function(event, ui, obj) {

					$('#' + fid).attr('src', '');
					$(this).dialog('destroy');
					$(this).remove();
					var _id;
					var _no = 0;
					var _relation;
					$.each(openWindows, function(i, n) {
						if (n.show) {
							_id = n.id;
							_no = i;
							_relation = n.relation;
							return;
						}
					});

					$.each(openWindows, function(i, n) {
						if (n.id == _relation) {
							n.show = true;
						}
					})

					var arr = new Array;
					$.each(openWindows, function(i, n) {
						if (_no != i) {
							arr.push(n);
						}
					});

					openWindows = arr;
					arr = null;

					if (p.onClose) {
						p.onClose(event, ui, obj);
					}

					// 删除遮盖层
					div_remove_over();
					// 恢复主窗体滚动条
					windowScroll("auto");
				}
			};

			$.each(openWindows, function(i, n) {
				n.show = false;
			});

			// create a window
			var _window = document.createElement('div');
			$(_window).attr('id', 'kuiDialog' + p.id);

			if (openWindows.length == 0) {
				openWindows.push({
					id : p.id,
					show : true,
					relation : ''
				});
			} else {
				var index = openWindows.length;
				openWindows.push({
					id : p.id,
					show : true,
					relation : openWindows[index - 1].id
				});
			}

			$(_window).empty();
			$(_window).attr('title', p.title);
			$(_window).css("overflow", "hidden")
			$(_window).attr('id', 'kuiDialog' + p.id);
			$(_window).dialog(opts);
			$(_window).dialog('open');

			if (p.type == 'html') {
				if (p.param) {
					$(_window).akfLoad(p.url, p.param);
				} else {
					$(_window).akfLoad(p.url);
				}
			}

			if (p.type == 'iframe') {
				if (p.param) {
					srcurl = srcurl + '&' + $.param(p.param);
				}

				var iframe = $(
						'<iframe id="' + fid + '" name="' + fid + '" src="'
								+ srcurl
								+ '" frameborder="0" scrolling="yes" />').css({
					width : '600px',
					height : '504px',
					border : 0
				}).appendTo($(_window));
			}

		}
	};

	/**
	 * 
	 */

	/**
	 * 功能：关闭窗口
	 * 
	 * @param callback
	 *            关闭窗口时的回调函数
	 */
	$.closeWindow = function(callback) {

		if ($.isFunction(callback)) {
			callback();
		}

		if (window.top.jericho) {
			window.top.jericho.closeWindow(callback);
			return;
		} else {
			var _id;
			$.each(openWindows, function(i, n) {
				if (n.show) {
					_id = n.id;
					return;
				}
			});

			$('#kuiDialog' + _id).dialog('close');
		}
	};

	/**
	 * 火狐浏览器判断
	 */
	$k.isFireFox = function() {
		var userAgent = navigator.userAgent.toLowerCase();
		var isFireFox = /mozilla/.test(userAgent)
				&& !/(compatible|webkit)/.test(userAgent);
		return isFireFox;
	}

	/**
	 * 
	 * 构造字符串函数,主要用于拼接字符串，可将json行对象拼接字符串
	 * 
	 * @param data
	 *            (json数据)，key(json数据key值)，sign 按符号拼接
	 * 
	 */

	$k.construct = function(data, key, sign) {
		var construct_str = "";

		for ( var i = 0; i < data.length; i++) {
			construct_str += eval("data[" + i + "]." + key) + sign;
		}

		construct_str = construct_str.substring(0, construct_str.length - 1);
		return construct_str;
	}

	/**
	 * 字符串转json
	 */
	$k.evalToJson = function(str) {
		return eval('(' + str + ')');
	}
	$k.eval = $k.evalToJson;

	/**
	 * 序列化方法
	 */
	$k.serialize = function(obj) {
		var elemArray = $(obj).serializeArray();
		var subStr = "";
		var flag = false;
		elemArray.sort(function(a, b) {
			if (a.name.toString().toLowerCase() < b.name.toString()
					.toLowerCase())
				return 1;
			return -1;

		});

		var reserver = {
			name : '@reserve@',
			value : ''
		}; // 预留字段，以便判断完整实现
		elemArray.push(reserver);

		for ( var i = 0; i < elemArray.length - 1; i++) {
			if (elemArray[i].name == elemArray[i + 1].name) {
				if (flag) {
					// 若还有相同则继续 2
					subStr += ",'" + elemArray[i + 1].value + "'";
				} else {
					// 首次出现相同formName 1
					subStr += elemArray[i].name + ":['" + elemArray[i].value
							+ "','" + elemArray[i + 1].value + "'";
					flag = true;
				}
			} else {
				if (flag) {
					// 若无，则结束相同判断，并重置为false，继续开始 3
					subStr += "],";
					flag = false;
				} else {
					// 程序进入 起点 1 ，若进入就相同则进入上诉 1
					subStr += elemArray[i].name + ":'" + elemArray[i].value
							+ "' ,";
				}
			}
		}
		subStr = "{" + subStr.substring(0, subStr.length - 1) + "}";
		return eval('(' + subStr + ')');
	}

	/**
	 * 对象选择器入口调用，由于首页布局iframe 原因 ,调用此入口
	 * 
	 * @param p
	 *            ={url:'',width:'500',height:'600',isfunction:'false'}
	 */
	$.showObjectPicker = function(p) {
		window.top.$.showObjectPickerWindow(p)
	}

	/**
	 * ===================================================================================================================
	 * 初始化对象选择器模态窗口初始化
	 * 
	 * @param {"width :
	 *            "300" ,height: "300 " ,function :"true", url :"xxx.action"}
	 *            ===================================================================================================================
	 */
	$.initObjectPickerDialog = function(p) {
		var divObj = document.getElementById("dialog-form");

		if (divObj != null) {
			divObj.parentNode.removeChild(divObj);
		}
		var _dialog = document.createElement('div');

		$(_dialog).attr("id", "dialog-form");

		if (p.width == undefined || p.width == "undefined" || p.width == "")
			p.width = 500;

		if (p.height == undefined || p.height == "undefined" || p.height == "")
			p.height = 550;

		if (isFirefox = navigator.userAgent.indexOf("Firefox") > 0) {
			if (p.height > 550)
				p.height = 550
		}
		if (p.isfunction != 'true')
			p.isfunction = "false";

		$(_dialog).dialog({
			autoOpen : false,
			height : p.height,
			width : p.width,
			modal : true,
			title : p.title,
			resizable : false,
			buttons : {
				"submit" : function() {
					try {
						$.callModalBack(p)

						$(this).dialog("close");
					} catch (e) {
						$(this).dialog("close");
					}
				},
				Cancel : function() {
					$(this).dialog("close");
				}
			},
			close : function() { // 点击关闭后调
				// 销毁iframe
				var ciframe = window.frames["iframe" + p.dialogid]
				var _document = ciframe.document;
				_document.write("");
				_document.clear();
				$(ciframe).remove();
				$("#dialog-form").dialog("destroy");
				// 销毁对象
				_dialog.parentNode.removeChild(_dialog);
			}

		});
		return _dialog;
	}

	/**
	 * ***************************************************************************************
	 * 显示模态对话框 对象选择器 p为传入数据 格式 {url : ''}
	 * ***************************************************************************************
	 */
	$.showObjectPickerWindow = function(p) {
		if (p.url == undefined || p.url == "undefined" || p.url == "") {
			alert("NullPointException : no url");
			return false;
		}

		p.scroll = p.scroll || "no";

		var _modeldiadog = $.initObjectPickerDialog(p);
		var date = new Date();
		var str = new Date().getTime()

		p.dialogid = str;
		var url = "";
		if (p.url.indexOf("?") > 0) {
			url = p.url + "&mutiSelect=" + p.mutiSelect + "&actionName="
					+ p.url.split(".")[0] + "&" + str;
		} else {
			url = p.url + "?mutiSelect=" + p.mutiSelect + "&actionName="
					+ p.url.split(".")[0] + "&" + str;

		}
		var type = "iframe";
		if (type == "iframe") {
			var iframe = $(
					'<iframe id="iframe' + p.dialogid + '" name="iframe'
							+ p.dialogid + '" src="' + url
							+ '" frameborder="0" scrolling="' + p.scroll
							+ '" width="100%" height="100%"/>').css({
				border : 0
			}).appendTo($(_modeldiadog));

			$("#dialog-form").dialog("open");

		} else {
			$(_modeldiadog).load(url);
			$("#dialog-form").dialog("open");
		}
		$(".ui-dialog-buttonpane&.ui-widget-content&.ui-helper-clearfix")
				.hide();

	}
	/**
	 * ***************************************************************************************
	 * objectPicker 回调函数
	 * 
	 * @param p
	 *            对象
	 *            ***************************************************************************************
	 */
	$.callModalBack = function(p) {
		try {
			var _window = p._window;
			var did = p.dialogid;

			var tdocument = $(window.frames["iframe" + did].document);

			var callDataBack = $(tdocument).find("#callDataBack").val()

			var calllBackDataToJson = $k.eval(callDataBack);

			var backObjShow = "objectPicker_" + p.pointValue;

			var backObjHidden = p.pointValue;

			if (p.isfunction == "true") {
				try {
					if (_window != undefined) {
						_window.modalBackHandle(calllBackDataToJson, p);
					} else {
						window.modalBackHandle(calllBackDataToJson, p);
					}
				} catch (e) {
					alert("callModalBack: no found function ");
				}

				return false;
			} else {
				if (p.pointValue == null || p.pointValue == "") {
					alert(" ObjectPicker :name or pointValue is null");
					return false;
				}
				var _id = "";
				var _name = "";
				if (p.dataType == "json") {
					if (p.idKey == null || p.idKey == undefined) {
						p.idKey = p.pointValue;
					}
					for ( var i in calllBackDataToJson) {
						_id += "{" + p.idKey + ":" + calllBackDataToJson[i].id
								+ "},";
					}
					_id = _id.substring(0, _id.length - 1);
					_id = "[" + _id + "]";
				} else {
					_id = $k.construct(calllBackDataToJson, "id", ",")
				}
				_name = $k.construct(calllBackDataToJson, "name", ",")
				if (_window != undefined) {
					_window.document.getElementById(backObjShow).value = _name;
					_window.document.getElementById(backObjHidden).value = _id;
					_window.document.getElementById(backObjShow).focus();
				} else {
					document.getElementById(backObjShow).value = _name;
					document.getElementById(backObjHidden).value = _id;
					_window.document.getElementById(backObjShow).focus();
				}
				try {
					_window.myfunction(p);	
				}
				catch(e){
				}
				return false;

			}
		} catch (e) {
			alert(" 执行 callModalBack 时出现异常" + e);
			return false;
		}
		return false;
	}
	/**
	 * **************************************************************************************
	 * 对象选择器清除按钮
	 * ***************************************************************************************
	 */
	$.clearObjectPickData = function(obj) {
		if (obj == "")
			return;
		if (obj.indexOf(".") > 0) {
			obj = obj.replace(".", "_");
		}
		var backObjShow = "objectPicker_" + obj;
		$("#" + obj).val("");
		$("#" + backObjShow).val("");
	}

	/**
	 * **************************************************************************************
	 * 取得对象选择器值，异步获取
	 * ***************************************************************************************
	 */
	$.getObjectPickData = function(p) {

		var url = p.url;
		var pointValue = p.pointValue;
		p.idKey = p.idKey || p.pointValue;
		if (pointValue.indexOf(".") > 0) {
			pointValue = pointValue.replace(".", "_");
		}
		var backObjShow = "objectPicker_" + pointValue;
		p.pointValue = pointValue;
		var objectHiddenId = $("#" + p.pointValue).val();
		if (objectHiddenId == "" || objectHiddenId == undefined) {
			return false;
		}

		if (p.dataType == "json") {
			objectHiddenId = $k.construct($k.evalToJson(objectHiddenId),
					p.idKey, ",");
		}
		$k.ajax({
			url : url,
			type : "POST",
			data : {
				objectId : objectHiddenId
			},
			success : function(data, textStatus) {
				$("#" + backObjShow).val($k.construct(data, "name", ","));
			}
		})
	}

	/**
	 * ===================================================================================================================
	 * 初始化对象选择器模态窗口初始化 end
	 * ===================================================================================================================
	 */

	/**
	 * 通用弹出窗口弹出对话框入口，由于结构问题调用此方法
	 * 
	 */
	$.showModalWindowUI = function(p) {
		window.top.$.showModalWindow(p)
	}

	/**
	 * 模态窗口初始化
	 * 
	 * @param p={url:"",width:"660",callbackfun:aaa,iframeName:""};
	 */

	$.showModalWindow = function(p) {

		var date = new Date();

		var divId = "div_n" + date.getTime();

		var _dialog = document.createElement('div');

		$(_dialog).attr("id", divId);

		if (p.width == undefined || p.width == "undefined" || p.width == "")
			p.width = 500;

		if (p.height == undefined || p.height == "undefined" || p.height == "")
			p.height = 550;

		if (isFirefox = navigator.userAgent.indexOf("Firefox") > 0) {
			if (p.height > 550)
				p.height = 550
		}
		if (p.callbackfun == undefined || p.callbackfun == "undefined"
				|| p.callbackfun == "")
			p.callbackfun = "showModelCallback()";

		if (p._window == undefined || p._window == "undefined"
				|| p._window == "")
			p._window = window;

		$(_dialog).dialog({
			autoOpen : false,
			height : p.height,
			width : p.width,
			modal : true,
			title : p.title,
			resizable : false,
			buttons : {
				"submit" : function() {
					try {
						p.callbackfun(p);
						$(this).dialog("close");
					} catch (e) {
						$(this).dialog("close");
					}
				},
				Cancel : function() {
					$(this).dialog("close");
				}
			},
			close : function() { // 点击关闭后调
				// 销毁iframe
				var ciframe = window.frames["iframe" + p.dialogid]
				var _document = ciframe.document;
				_document.write("");
				_document.clear();
				$(ciframe).remove();
				// 销毁div
				_dialog.parentNode.removeChild(_dialog);
				if (typeof p.callbackfClose == 'function')
					p.callbackfClose();

			}

		});

		p.scroll = p.scroll || "no";

		p.dialogid = date.getTime();

		var type = "iframe";
		if (type == "iframe") {
			var iframe = $(
					'<iframe id="iframe' + p.dialogid + '" name="iframe'
							+ p.dialogid + '" src="' + p.url
							+ '" frameborder="0" scrolling="' + p.scroll
							+ '" width="100%" height="100%"/>').css({
				border : 0
			}).appendTo($(_dialog));

			$("#" + divId).dialog("open");
		} else {
			$(_dialog).load(url);
			$("#" + divId).dialog("open");
		}

		$(".ui-dialog-buttonpane&.ui-widget-content&.ui-helper-clearfix")
				.hide();

		// $(".ui-dialog-titlebar&.ui-widget-header&.ui-corner-all&.ui-helper-clearfix").hide();
	}

	/**
	 * 功能：异步加载制定URL的数据/资源
	 * 
	 * @param url
	 *            资源所在的地址
	 * @param data
	 *            数据/资源
	 * @param cache
	 *            是取自否缓存
	 */
	$.fn.akfLoad = function(url, data, cache) {

		var http = url;

		var ff = $(this);
		// $(this).load(http, data);

		if (cache != "undefined" && cache == false) {

			// 重新请求服务器上的资源
			http = http + "?_" + new Date().getTime();
		}

		// 异步请求资源
		$.ajax({
			url : http,
			dataType : 'html',
			type : "POST",
			data : data ? data : {},
			async : false,
			success : function(html) {

				ff.empty();
				ff.append(html);
			}
		});
	};

	/**
	 * 功能：设置cookie，有效期为一天
	 * 
	 */
	$.setCookie = function(name, value) {

		var argv = $.setCookie.arguments;
		var argc = $.setCookie.arguments.length;
		var expires = (argc > 2) ? argv[2] : null;

		if (expires != null) {

			var LargeExpDate = new Date();
			LargeExpDate.setTime(LargeExpDate.getTime()
					+ (expires * 1000 * 3600 * 24));
		}

		document.cookie = name
				+ "="
				+ escape(value)
				+ ((expires == null) ? "" : ("; expires=" + LargeExpDate
						.toGMTString())) + "; path = /";
	};

	/**
	 * 功能：获取cookie
	 * 
	 * @param Name
	 *            获取cookie的名字
	 */
	$.getCookie = function(Name) {

		var search = Name + "=";
		if (document.cookie.length > 0) {

			offset = document.cookie.indexOf(search);
			if (offset != -1) {
				offset += search.length;
				end = document.cookie.indexOf(";", offset);

				if (end == -1) {
					end = document.cookie.length;
				}

				return unescape(document.cookie.substring(offset, end))
			} else {
				return "";
			}
		}
	};

	/**
	 * 功能：谈出上传窗口--上传文件使用
	 * 
	 * @param opts
	 */
	$.showFileUpload = function(opts) {

		if (opts.maxlength == undefined) {
			opts.maxlength = 1;
		}

		if (opts.accept == undefined) {
			opts.accept = false;
		}

		if ($.isFunction(opts.success)) {
			opts.success = opts.success.toString();
		}

		$.showWindow({
			id : 'fileUpload',
			url : $.webPath + 'jsp/common/frame/fileupload.jsp',
			type : 'html',
			title : '文件上传',
			param : opts,
			simple : true,
			width : 600,
			height : 450,
			onClose : function(event, ui) {
			}
		});
	}

	/**
	 * ===================================================================================================================
	 * KUI 定义
	 * ===================================================================================================================
	 */

	$
			.extend(
					kui,
					{
						/**
						 * 初始化表单验证器
						 * 
						 * @param form
						 *            表单ID、引用、名称
						 */
						initValidator : function(form) {
							var $form = $(form) || $(document.forms[form])
									|| $("#" + form);
							if ($form.length == 0)
								$form = $(document.forms[0]);
							if ($form.is("form")) {
								var rules = {}, messages = {};
								$form
										.find("input, select, textarea")
										.not(
												":submit, :reset, :image, [disabled]")
										.each(
												function(index) {
													var $this = $(this);
													var valiRule = {}, valiMessage = {};
													if ($this.attr("validator")) {
														var validators = $this
																.attr(
																		"validator")
																.split(";");
														for ( var i = 0; i < validators.length; i++) {
															var ruleDefs = validators[i]
																	.split(":");
															if (ruleDefs.length == 2
																	&& ruleDefs[1]) {

																valiRule[ruleDefs[0]] = eval(ruleDefs[1]);
															} else {
																valiRule[ruleDefs[0]] = true;
															}
														}
													}
													if ($this.attr("notnull") == "true") {
														valiRule['required'] = true;
													}
													rules[$this.attr("name")] = valiRule;

													if ($this.attr("valimsg")) {
														var validmsgs = $this
																.attr("valimsg")
																.split(",");
														for ( var i = 0; i < validmsgs.length; i++) {
															var msgDefs = validmsgs[i]
																	.split(":");
															if (msgDefs.length == 2
																	&& msgDefs[1]) {
																valiMessage[msgDefs[0]] = msgDefs[1];
															}
														}
													}
													messages[$this.attr("name")] = valiMessage;
												});

								$form.validate({
									'rules' : rules,
									'messages' : messages
								});
							}
						},

						/**
						 * 选择所有checkbox
						 * 
						 * @param checkbox
						 *            触发控件，其他的控件会以这个触发控件的值一至
						 */
						checkall : function(checkname, obj) {

							var checkvalue = false;

							if ($(obj).attr("checked") == "checked")
								checkvalue = true;
							var checks = $(":input[name='" + checkname + "']");
							if (checks && checks.length > 0) {
								checks.each(function(i) {
									$(this).attr("checked", checkvalue);
								})

							}
							return true;
						},

						/**
						 * 表格事件处理
						 */
						grid : {
							// 初始化表格，暂时，待到表格需要增加一些额外的功能如，调整列头长度等才需要
							init : function(gridId) {
								var $g = $("#" + gridId);
								if (!$g)
									$g = $("table.kuiGrid");
								$g.each(function() {
									var $$g = $(this);
								});
							},

							/**
							 * 分页条的text 页输入框事件处理
							 * 
							 * @param input
							 *            页码输入框对象
							 */
							jumpInput : function(event, input) {
								var inputPage = input.value;
								var totalPage = $(input).attr("totalPages");

								var gridId = $(input).attr("gridId");
								var evt = event ? event
										: (window.event ? window.event : null);
								var keyCode = evt.keyCode ? evt.keyCode
										: (evt.which ? evt.which : evt.charCode);
								if (keyCode == 13) {
									if (isNaN(inputPage)) {
										alert("输入页码无效，请重新输入！");
										return false;
									}
									if (parseInt(inputPage, 10) > parseInt(
											totalPage, 10)) {
										alert("输入页范围超出，请重新输入！");
										return false;
									}
									kui.grid.jump(inputPage, gridId);
									return false;
								}
								return true;
							},

							/**
							 * 跳到某一页
							 * 
							 * @param page
							 *            要查询的页码
							 * @param gridId
							 *            要查询的表格
							 * @param isSwitchSort
							 *            是否需要转换排序值
							 */
							jump : function(page, gridId, isSwitchSort,
									sortName) {
								var $g = $("#" + gridId);
								isSwitchSort = isSwitchSort || false
								if (!$g)
									return;
								var pagername = $g.attr("requestName")
										|| "pager";
								var submitForm = document.forms[$g.attr("form")]
										|| document.forms[0];
								var url = $g.attr("actionUrl")
										|| submitForm.action;
								var sortvalue = isSwitchSort ? ($g
										.attr("sortvalue") == "desc" ? "asc"
										: "desc") : $g.attr("sortvalue");
								var params = pagername + ".pageNo=" + page;
								var sortfield = sortName
										|| $g.attr("sortfield");
								if (typeof sortfield != 'undefined')
									params += "&" + pagername + ".orderBy="
											+ sortfield + "&" + pagername
											+ ".order=" + sortvalue;
								if (url.indexOf("?") == -1) {
									url += "?" + params;
								} else {
									url += "&" + params;
								}
								submitForm.action = url;
								submitForm.submit();
								return true;
							},

							/**
							 * 转换排序条件的查询
							 * 
							 * @param gridId
							 *            表格的ID
							 * @param sortname
							 *            要执行排序的字段
							 */
							switchSort : function(gridId, sortName) {
								var $g = $("#" + gridId);
								if (!$g)
									return;
								kui.grid.jump($g.attr("page"), gridId, true,
										sortName);
							}
						}
					});

})(jQuery);

/**
 * ===================================================================================================================
 * 普通常用函数定义
 * ===================================================================================================================
 */
/**
 * 关闭 objectOicker 对话框对应按钮绑定，
 * 
 * @param type
 *            "submit" or "close"
 */
function objectPicker_Operating(type) {
	if (type == "submit") {
		$("#dialog-form").parent().find(":button").eq(0).click();
	}
	if (type == "close") {
		$("#dialog-form").parent().find(":button").eq(1).click();
	}

}
/**
 * 关闭 showmodalwind 对话框对应按钮绑定，
 * 
 * @param type
 *            "submit" or "close"
 */
function showModalWindow_Operating(type) {
	if (type == "submit") {
		$(window.parent.document).find("div[role='dialog']").last().find(
				":button").eq(0).click();
	}
	if (type == "close") {
		$(window.parent.document).find("div[role='dialog']").last().find(
				":button").eq(1).click();
	}
}
/**
 * 初始化窗口showModelessDialog(火狐浏览器) 重新方法
 */

if ($k.isFireFox()) {
	window.showModelessDialog = function(url) {
		var windowName = (arguments[1] == null ? "" : arguments[1].toString());
		var feature = (arguments[2] == null ? "" : arguments[2].toString());
		var OpenedWindow = window.open(url, windowName, feature);
		window.addEventListener('click', function() {
			OpenedWindow.focus();
		}, false);
		return OpenedWindow;
	}
}

/**
 * ===================================================================================================================
 * 文字内容限定 定义
 * ===================================================================================================================
 */
$(function() {
	/**
	 * 为th添加contentLimit 有bug目前
	 */
	$(".columnHeaders th")
			.each(
					function(i) {
						var contentLimit = $(this).attr("contentLimit");
						var width = $(this).attr("width");

						if (contentLimit != undefined
								&& contentLimit != 'undefined') {
							var tdObj;
							var aObj;
							var content = "";
							$(".databody tr")
									.each(
											function() {
												tdObj = $(this).children(
														"td:eq(" + i + ")");
												if ($(tdObj).children().is("a")) {
													aObj = $(tdObj).children(
															"a");
												} else {
													aObj = tdObj;
												}
												innerHTML = $(aObj).html();
												content = $(aObj).text();

												$(tdObj).attr(
														"title",
														content.substring(0,
																300));
												if (contentLimit != ""
														&& contentLimit != "auto"
														&& contentLimit != "other") {
													if (content != ""
															&& content.length > contentLimit) {
														$(aObj)
																.html(
																		innerHTML
																				.replace(
																						content,
																						content
																								.substring(
																										0,
																										contentLimit)
																								+ "..."));
													}
												}
												if (contentLimit == "other") {
													innerHTML = $(aObj).html()
															.replace("<PRE>",
																	"")
															.replace("<CODE>",
																	"")
															.replace("</PRE>",
																	"")
															.replace("</CODE>",
																	"");
													if (width == 'undefined'
															|| width == "")
														width = "130";
													$(aObj)
															.html(
																	"<div style='width:"
																			+ width
																			+ "px; white-space:nowrap;overflow:hidden;text-overflow:ellipsis; '>"
																			+ innerHTML
																			+ "</div>");
												}
											});
						}
					});

	$("input[readOnly]").keydown(function(e) {
		e.preventDefault();
	});

})
