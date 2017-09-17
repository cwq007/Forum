<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>登录界面</title>
<meta http-equiv="contextType" content="text/html; charset=utf-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">

<link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
<link href="css/font-awesome.css?v=4.4.0" rel="stylesheet">
<link href="css/style.css?v=4.1.0" rel="stylesheet">
</head>

<body class="gray-bg top-navigation">
	<div id="page-wrapper" class="gray-bg">
		<jsp:include page="/jsps/common/commonTop.jsp"/>
	
		<div class="row">
			<div class="col-sm-offset-3 col-sm-6">
				<div class="ibox">
					<div class="ibox-title text-center">用户登录</div>

					<div class="ibox-content">
						<form class="form-horizontal m-t" id="loginForm" method="post" action="${basePath}user/user_login.action" baseUrl="${basePath}">
							<div class="form-group">
								<label class="col-sm-3 control-label">用户名：</label>
								<div class="col-sm-8">
									<input id="loginUser" name="loginUser" class="form-control" type="text"> 
								</div>
							</div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">密码：</label>
                                <div class="col-sm-8">
                                    <input id="loginPass" name="loginPass" class="form-control" type="password"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label">验证码：</label>
                                <div class="col-sm-5">
                                    <input id="loginVerifyCode" name="loginVerifyCode" class="form-control" type="text"/>
                                </div>
                                <div class="col-sm-3">
                                	<img src="${basePath}verifyCode.jsp" alt="验证码" onclick="this.src=this.src+'?'+new Date()"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-4 col-sm-offset-3">
                                    <div class="checkbox">
                                        <label>
                                            <input type="checkbox" class="checkbox" id="adminChecked" name="adminChecked">记住密码
                                        </label>
                                    </div>
                                </div>
								<div class="col-sm-4">
									<div class="checkbox"><label>
										<a href="${bathPath}jsps/users/regist.jsp">点击注册</a>
									</label></div>
								</div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-8 col-sm-offset-3">
                                    <button class="btn btn-primary" style="width: 100%;" type="submit">登录</button>
                                </div>
                            </div>
                            <div class="form-group">
                            	<c:if test="${actionErrors[0] != null }">
	                            	<div class="alert alert-danger alert-dismissable">
			                            <button data-dismiss="alert" class="close" type="button">×</button>
		                            	${actionErrors[0]}
			                        </div>
                            	</c:if>
                            </div>                            
                        </form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- 全局js -->
	<script src="js/jquery.min.js?v=2.1.4"></script>
	<script src="js/bootstrap.min.js?v=3.3.6"></script>

	<script src="js/plugins/validate/jquery.validate.min.js"></script>
	<script src="js/plugins/validate/messages_zh.min.js"></script>
	<script src="js/form-validate.js"></script>
</body>
</html>
