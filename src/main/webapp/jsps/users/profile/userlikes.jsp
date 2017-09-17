<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>用户收藏界面</title> 
<meta http-equiv="contextType" content="text/html; charset=utf-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">

<link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
<link href="css/font-awesome.css?v=4.4.0" rel="stylesheet">
<link href="css/style.css?v=4.1.0" rel="stylesheet">
</head>
<body class="gray-bg top-navigation">
	<div id="wrapper" style="min-width: 600px;">  
		<div id="page-wrapper" class="gray-bg"> 
			<jsp:include page="/jsps/common/commonTop.jsp"></jsp:include>
			
			<!-- 设置id为contentContainer的min-height为84%，为了让底部一直在最下方 -->
			<div id="contentContainer" class="tabs-container">
				<ul class="nav nav-tabs">
					<li><a href="${basePath}user/user_profile.action?part=userinfo">用户信息</a></li>
					<li><a href="${basePath}user/user_profile.action?part=chapterinfo">文章管理</a></li>
					<li class="active"><a href="${basePath}user/user_profile.action?part=userlikes">用户关注</a></li>
					<li><a href="${basePath}user/user_profile.action?part=usersubscribe">用户订阅</a></li>
				</ul>  
				<div class="tab-content">
					<div id="userlikes" class="tab-pane active">
						<div class="panel-body">
							<div class="row">
				                <div class="contact-box">
		                        	
		                        	<s:if test="#session.userlikes.size == 0">
		                        		<div class="col-sm-12">你还没有关注任何用户</div>
		                        	</s:if>
		                        	<s:else>
				                        <s:iterator var="userlike" value="#session.userlikes">
								            <div class="col-sm-4">
						                        <div class="col-sm-4">
						                            <div class="text-center">
						                                <img alt="image" class="img-circle m-t-xs img-responsive" src="${basePath}user/user_showimg.action?loginUser=<s:property value='usersubscribe.loginUser'/>">
						                            </div> 
						                        </div>
						                        <div class="col-sm-8">
						                            <h3><strong><s:property value='usersubscribe.loginUser'/></strong></h3>
						                            <p><i class="fa fa-envelope"></i><s:property value='usersubscribe.nickname'/></p>
						                        </div>
						                        <div class="clearfix"></div>
							                </div> 
				                        </s:iterator>
		                        	</s:else>
	
					            </div>
				            </div>
						</div>
					</div> 
				</div>
			</div>
			
			<%@include file="/jsps/common/commonBottom.jsp" %>
		</div>
	</div>
	
	<!-- 全局js -->
	<script src="js/jquery.min.js?v=2.1.4"></script>
	<script src="js/bootstrap.min.js?v=3.3.6"></script>
	<script src="js/global.js"></script>
</body>
</html>
