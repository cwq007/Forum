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

<title>文章管理界面</title> 
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
					<li class="active"><a href="${basePath}user/user_profile.action?part=chapterinfo">文章管理</a></li>
					<li><a href="${basePath}user/user_profile.action?part=userlikes">用户关注</a></li>
					<li><a href="${basePath}user/user_profile.action?part=usersubscribe">用户订阅</a></li>
				</ul>  
				<div class="tab-content">
					<div id="chapterinfo" class="tab-pane active">
						<div class="panel-body">
							
							<s:if test="#session.forumChapters.size == 0">
                        		<div class="col-sm-12">你还没有发表任何文章，<a href="${basePath}jsps/chapters/publishChapter.jsp">点击发表新文章</a></div>
                        	</s:if>
                        	<s:else>
								<div class="row">
						            <div class="col-sm-12">
				                        <div class="search-form">
				                            <form action="${basePath}forum/forum_chaptersearch.action" method="get">
				                                <div class="input-group">
				                                	<input name="keyword" type="text" class="form-control">
				                                    <div class="input-group-btn"><button class="btn btn-primary" type="button">搜索</button></div>
				                                </div>
				                            </form>
											<div class="alert alert-success alert-dismissable">
												<a href="${basePath}jsps/chapters/publishChapter.jsp">发表文章</a>
											</div>
				                        </div>
				                        <s:iterator var="forumChapter" value="#session.forumChapters">
					                        <div class="hr-line-dashed"></div>
						                        <div class="search-result">
						                            <h3><a href="${basePath}forum/forum_showchapter.action?id=${forumChapter.id}">${forumChapter.title}</a></h3>
						                            <small>发表时间：${forumChapter.createDate}</small>
						                        </div>
					                        <div class="hr-line-dashed"></div>
				                        </s:iterator>
			                        </div>
		                        	<div class="text-center"> 
		                       			<span>共${sessionScope.pager.rowsCount}条记录/共${sessionScope.pager.pageCount}页</span>    	
			                            <div class="btn-group">
			                                <a class="btn btn-white" type="button" href="${basePath}user/user_profile.action?part=chapterinfo&curPage=${pager.curPage-1 < 1 ? 1 : pager.curPage-1}"><i style="height:20px; line-height: 20px;" class="fa fa-chevron-left"></i></a>
			                                <s:iterator status="st" begin="1" end="#session.pager.pageCount">
			                                	${sessionScope.pager.curPage}  -- ${st.index+1}
				                                <s:if test="#session.pager.curPage == st.index+1">
					                                <a class="btn btn-white active" href="${basePath}user/user_profile.action?part=chapterinfo&curPage=${st.index+1}">${st.index+1}</a>
				                                </s:if>
				                                <s:else>
					                                <a class="btn btn-white" href="${basePath}user/user_profile.action?part=chapterinfo&curPage=${st.index+1}">${st.index+1}</a>
				                                </s:else>
			                                </s:iterator>
			                                <a class="btn btn-white" type="button" href="${basePath}user/user_profile.action?part=chapterinfo&curPage=${pager.curPage+1 > pager.pageCount ? pager.pageCount : pager.curPage+1}"><i style="height:20px; line-height: 20px;" class="fa fa-chevron-right"></i></a>
			                            </div>
		                        	</div>
			                    </div>
                        	</s:else>
                        	
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
