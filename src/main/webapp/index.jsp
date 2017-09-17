<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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

<title>论坛主页</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
<link href="css/font-awesome.css?v=4.4.0" rel="stylesheet">
<link href="css/animate.css" rel="stylesheet">
<link href="css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg top-navigation">
	<div id="wrapper" style="min-width: 600px;">
		<div id="page-wrapper" class="gray-bg">
			<jsp:include page="/jsps/common/commonTop.jsp"></jsp:include>
			
			<div id="contentContainer" class="wrapper wrapper-content">
				<div class="container">
					<div class="row">
						<div class="col-md-3">
							<div class="ibox float-e-margins">
								<div class="ibox-title">
									<span class="label label-success pull-right">浏览量</span>
									<h5>本周最热</h5>
								</div>
								<div class="ibox-content">
									<h1 class="no-margins">
										<a href="#">nosql</a>
									</h1>
									<div class="stat-percent font-bold text-success">
										80次 <i class="fa fa-arrow-up"></i>
									</div>
									<small>总计浏览量：10000次</small>
								</div>
							</div>
						</div>
						
						<div class="col-md-3">
							<div class="ibox float-e-margins">
								<div class="ibox-title">
									<span class="label label-info pull-right">评论量</span>
									<h5>本周最热</h5>
								</div>
								<div class="ibox-content">
									<h1 class="no-margins">
										<a href="#">nosql</a>
									</h1>
									<div class="stat-percent font-bold text-success">
										100次 <i class="fa fa-arrow-up"></i>
									</div>
									<small>总计评论量：100条</small>
								</div>
							</div>
						</div>
						
						<div class="col-md-3">
							<div class="ibox float-e-margins">
								<div class="ibox-title">
									<span class="label label-warning pull-right">发表量</span>
									<h5>本周论坛之星</h5>
								</div>
								<div class="ibox-content">
									<h1 class="no-margins">
										<a href="#">nosql</a>
									</h1>
									<div class="stat-percent font-bold text-success">
										25篇 <i class="fa fa-arrow-up"></i>
									</div>
									<small>总计发表：100篇</small>
								</div>
							</div>
						</div>
						
						<div class="col-md-3">
							<div class="ibox float-e-margins">
								<div class="ibox-title">
									<span class="label label-danger pull-right">评论量</span>
									<h5>本周最热</h5>
								</div>
								<div class="ibox-content">
									<h1 class="no-margins">
										<a href="#">nosql</a>
									</h1>
									<div class="stat-percent font-bold text-success">
										100次 <i class="fa fa-arrow-up"></i>
									</div>
									<small>总计评论量：100条</small>
								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-lg-12">
							<div class="ibox float-e-margins">
								<div class="ibox-title">
									<h5>论坛文章</h5>
								</div>
								<div class="ibox-content">
									<div class="row">
										<div class="col-sm-9">
											<ul class="breadcrumb">
												<li><a href="#">国际新闻</a></li>
												<li class="active"><a href="#">nosql</a></li>
											</ul>
										</div>
										<div class="col-sm-3">
											<div class="input-group">
												<input type="text" placeholder="搜索" class="input-sm form-control"> 
												<span class="input-group-btn">
													<button type="button" class="btn btn-sm btn-primary">搜索</button>
												</span>
											</div>
										</div>
									</div>
								</div>
								<div class="ibox-content">
									<div class="row">
										<div class="col-lg-9">
											<div class="ibox">
												<div class="ibox-content">
													<a href="article.html" class="btn-link">
														<h2>想知道宁泽涛每天游多少圈？送他 Misfit 最新款 Speedo Shine</h2>
													</a>
													<div class="small m-b-xs">
														<strong>高 晨</strong> 
														<span class="text-muted"><i class="fa fa-clock-o"></i> 3 小时前</span>
													</div>
													<p>
														就算你敢带着 Apple Watch 下水游泳，它也不能记录你游了多少圈。
														夏天刚来时就不停地听到有人提起“有没有在我游泳的时候可以帮忙数圈的设备”，今天 Misfit
														终于赶在夏天结束之前推出可追踪游泳运动的新款 Shine。这款新设备是 Misfit 与泳衣品牌 Speedo
														（速比涛）合作推出，因此被命名为 Speedo Shine。
													</p>
													<div class="row">
														<div class="col-md-6">
															<h5>标签：</h5>
															<button class="btn btn-primary btn-xs" type="button">Apple Watch</button>
															<button class="btn btn-white btn-xs" type="button">速比涛</button>
														</div>
														<div class="col-md-6">
															<div class="small text-right">
																<h5>状态：</h5>
																<div> <i class="fa fa-comments-o"></i>56评论</div>
																<i class="fa fa-eye"></i>144 浏览
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
										<div class="col-lg-3">
											<div class="ibox float-e-margins">
												<div class="ibox-title">
													<h5>用户行为统计</h5>
												</div>
												<div class="ibox-content">
													<div class="row"></div>
												</div>
											</div>
										</div>
									</div>
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

	<!-- 自定义js -->
	<script src="js/content.js?v=1.0.0"></script>
</body>
</html>
