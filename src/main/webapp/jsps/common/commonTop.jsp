<%@ page language="java" import="java.util.*,java.io.OutputStream, cn.jxau.soft.utils.VerifyCode" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<div class="row border-bottom white-bg">
	<nav class="navbar navbar-static-top">
		<div class="navbar-header">
			<a href="javascript:void(0);" class="navbar-brand">论坛网站</a>
		</div>
		
		<div class="navbar-collapse collapse" id="navbar">
			<c:choose>
				<c:when test="${session.loginedUser != null}">
					<ul class="nav navbar-top-links navbar-right">
						<li>
							<a href="${basePath}user/user_loginout.action"><i class="fa fa-sign-out"></i>退出</a>
						</li>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" style="padding: 5px;"> 
								<span><img alt="用户头像" class="img-circle" src="${basePath}user/user_showimg.action?loginUser=${sessionScope.loginedUser.loginUser}" width="40" height="40" /></span> 
								<span class="caret"></span>
							</a>
							<ul class="dropdown-menu">
								<li><a href="${basePath}user/user_profile.action?part=userinfo">用户信息</a></li>
								<li><a href="${basePath}user/user_profile.action?part=chapterinfo">文章管理</a></li>
								<li><a href="${basePath}user/user_profile.action?part=userlikes">用户关注</a></li>
								<li><a href="${basePath}user/user_profile.action?part=usersubscribe">用户订阅</a></li>
							</ul>
						</li>
					</ul>
					<ul class="nav navbar-top-links navbar-right">
						<li>
							<a href="javascript:void(0);">${sessionScope.loginedUser.nickname}，欢迎进入</a>
						</li>
					</ul>
				</c:when>
				<c:otherwise>
					<ul class="nav navbar-top-links navbar-right">
						<li class="actived">
							<a href="${basepath}jsps/users/login.jsp">登录</a>
						</li>
					</ul>
				</c:otherwise>
			</c:choose>
			<ul class="nav navbar-top-links navbar-right">
				<li>
					<a href="#">回到主页</a>
				</li>
			</ul>
		</div>
	</nav>
</div>