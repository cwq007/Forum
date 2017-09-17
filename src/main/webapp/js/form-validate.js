//以下为修改jQuery Validation插件兼容Bootstrap的方法，没有直接写在插件中是为了便于插件升级
$.validator.setDefaults({
	highlight : function(element) {
		$(element).closest('.form-group').removeClass('has-success').addClass(
				'has-error');
	},
	success : function(element) {
		element.closest('.form-group').removeClass('has-error').addClass(
				'has-success');
	},
	errorElement : "span",
	errorPlacement : function(error, element) {
		if (element.is(":radio") || element.is(":checkbox")) {
			error.appendTo(element.parent().parent().parent());
		} else {
			error.appendTo(element.parent());
		}
	},
	errorClass : "help-block m-b-none",
	validClass : "help-block m-b-none"

});

$().ready(function() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	
	// validate 登录表单 when it is submitted
	$("#loginForm").validate({
		rules : {
			loginUser: {
				required: true,
				number: true,
				rangelength: [6,13]
			},
			loginPass: {
				required: true,
				rangelength: [6,13]
			},
			loginVerifyCode: {
				required: true, 
				remote: {
					url: $("#loginForm").attr("baseUrl")+"userajax/userajax_ckRigLoginVerifyCode.action",
					type: "get",
					dataType: "json",
					data: {
						loginVerifyCode: function() {return $("#loginVerifyCode").val();}
					}
				}
			}
		},
		messages : {
			loginUser : {
				required: icon + "请输入用户名",
				number: "用户名必须为数字",
				rangelength: "长度必须在{0},{1}之间"
			},
			loginPass : {
				required: icon + "请输入密码",
				rangelength: "长度必须在{0},{1}之间"
			},
			loginVerifyCode: {
				required: icon + "请输入验证码", 
				remote: "验证码错误"
			}
		}
	});

	// validate 注册表单 on keyup and submit
	$("#registForm").validate({
		rules : {
			loginUser: {
				required: true,
				number: true,
				rangelength: [6,13], 
				remote: {
					url: $("#registForm").attr("baseUrl")+"userajax/userajax_ckRepLoginUser.action", 
					type: "get", 
					dataType: "json", 
					data: {
						loginUser: function() {return $("#loginUser").val();}
					}
				}
			},
			loginPass: {
				required: true,
				rangelength: [6,13]
			},
			confirmPass: {
				required : true,
				equalTo : "#loginPass"
			},
			nickname: {
				required: true, 
				remote: {
					url: $("#registForm").attr("baseUrl")+"userajax/userajax_ckRepNickname.action",
					type: "get",
					dataType: "json",
					data: {
						nickname: function() {return $("#nickname").val();}
					}
				}
			},
			email : {
				required : true,
				email : true
			},
			agree : "required"
		},
		messages : {
			loginUser : {
				required: icon + "请输入用户名",
				number: "用户名必须为数字",
				rangelength: "长度必须在{0},{1}之间",
				remote: "用户已存在，请重新输入"
			},
			loginPass : {
				required: icon + "请输入密码",
				rangelength: "长度必须在{0},{1}之间"
			},
			confirmPass : {
				required : icon + "请再次输入密码",
				equalTo : icon + "两次输入的密码不一致"
			},
			nickname: {
				required: icon + "请输入昵称",
				remote: "该昵称已存在，请重新输入"
			},
			email : {
				required: icon + "请输入您的邮件地址",
			},
			agree : {
				required : icon + "必须同意协议后才能注册",
				element : '#agree-error'
			}
		}
	});

});
