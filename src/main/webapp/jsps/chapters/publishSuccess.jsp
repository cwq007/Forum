<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>发表成功界面</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">

<link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
<link href="css/style.css?v=4.1.0" rel="stylesheet">
</head>

<body class="gray-bg">
	<div class="wrapper wrapper-content">
		<div class="row">
			<div class="col-sm-offset-3 col-sm-6">
				<div class="ibox">
					<div class="ibox-content text-center">
						<div class="alert alert-success alert-dismissable">
							<a href="${basePath}user/user_profile.action?part=chapterinfo" style="margin-right: 1%;">返回文章管理界面</a>
							<a href="${basePath}jsps/chapters/publishChapter.jsp">继续发表</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
