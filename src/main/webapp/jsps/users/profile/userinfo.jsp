<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>个人信息</title> 
<meta http-equiv="contextType" content="text/html; charset=utf-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">

<link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
<link href="css/font-awesome.css?v=4.4.0" rel="stylesheet">
<link href="css/style.css?v=4.1.0" rel="stylesheet">
<link href="css/plugins/iCheck/custom.css" rel="stylesheet">
</head>
<body class="gray-bg top-navigation">
	<div id="wrapper" style="min-width: 600px;">  
		<div id="page-wrapper" class="gray-bg"> 
			<jsp:include page="/jsps/common/commonTop.jsp"></jsp:include>
			
			<!-- 设置id为contentContainer的min-height为84%，为了让底部一直在最下方 -->
			<div id="contentContainer" class="tabs-container">
				<ul class="nav nav-tabs">
					<li class="active"><a href="${basePath}user/user_profile.action?part=userinfo">用户信息</a></li>
					<li><a href="${basePath}user/user_profile.action?part=chapterinfo">文章管理</a></li>
					<li><a href="${basePath}user/user_profile.action?part=userlikes">用户关注</a></li>
					<li><a href="${basePath}user/user_profile.action?part=usersubscribe">用户订阅</a></li>
				</ul> 
				<div class="tab-content">
					<div id="userinfo" class="tab-pane active"> 
						<div class="panel-body">
							<div class="row">
								<div class="col-sm-3 col-md-3">
									<div class="center-block">
			                            <img style="border: 1px solid gray; width: 128px; height: 128px;" alt="image" class="img-circle m-t-xs img-responsive" src="${basePath}user/user_showimg.action?loginUser=<s:property value='#session.loginedUser.loginUser'/>" title="点击更换图片" 
			                            	 data-toggle="modal" data-target="#updateImg" />
										<p>
											用户留言：${sessionScope.loginedUser.info} 
											<i class="fa fa-commenting" style="font-size: 20px;" 
											 data-toggle="modal" data-target="#updateInfo"></i>
										</p>
										<p>
											积分：${sessionScope.loginedUser.scores}
										</p>
									</div>
		                        </div>
		                        <div class="col-sm-8 col-md-3"> 
		                        	<div class="row">
		                        		<div class="col-offset-sm-8 col-offset-sm-2"> 
		                        			<button class="btn btn-primary pull-right" data-toggle="modal" data-target="#updateBaseInfo">修改信息</button>
		                        		</div>
		                        	</div> 
		                        	<div class="row">
		                        		<table id="userProfile" class="EditTable ui-common-table">
		                        			<tbody>
		                        				<tr class="FormData">
		                        					<td class="CaptionTD"><label>昵称：</label></td>
		                        					<td class="DataTD">
		                        						<p> 
			                        						<s:if test="#session.loginedUser.nickname != null"><s:property value="#session.loginedUser.nickname"/></s:if>
				                        					<s:else>未设置</s:else> 
		                        						</p>
			                        				</td>
	                        					</tr>
	                        					<tr class="FormData">
	                        						<td class="CaptionTD"><label>性别：</label></td>
	                        						<td class="DataTD">
					                        			<p>
						                        			<s:if test="#session.loginedUser.sex != null"><s:property value="#session.loginedUser.sex"/></s:if>
						                        			<s:else>未设置</s:else> 
					                        			</p>
	                        						</td>
                        						</tr>
                        						<tr class="FormData">
                        							<td class="CaptionTD"><label>出生年月：</label></td>
                        							<td class="DataTD">
					                        			<p> 
						                        			<s:if test="#session.loginedUser.birth != null"><s:property value="#session.loginedUser.birth"/></s:if>
						                        			<s:else>未设置</s:else> 
					                        			</p>
                        							</td>
                       							</tr>
                       							<tr class="FormData">
                       								<td class="CaptionTD"><label>籍贯：</label></td>
                       								<td class="DataTD">
														<p>
															<s:if test="#session.loginedUser.nativePlace != null"><s:property value="#session.loginedUser.nativePlace"/></s:if>
						                        			<s:else>未设置</s:else>
														</p>
													</td>
                     							</tr>
                      							<tr class="FormData">
                     								<td class="CaptionTD"><label>qq：</label></td>
                     								<td class="DataTD">
														<p>
															<s:if test="#session.loginedUser.qq != null"><s:property value="#session.loginedUser.qq"/></s:if>
						                        			<s:else>未设置</s:else>
														</p>
													</td>
                   								</tr>
                   								<tr class="FormData">
                   									<td class="CaptionTD"><label for="total">email：</label></td>
                   									<td class="DataTD">
														<p>
															<s:if test="#session.loginedUser.email != null"><s:property value="#session.loginedUser.email"/></s:if>
						                        			<s:else>未设置</s:else>
														</p>
													</td>
                 								</tr>
                 								<tr class="FormData">
                									<td class="CaptionTD"><label>手机号码：</label></td>
                									<td class="DataTD">
                										<p>
	                										<s:if test="#session.loginedUser.phoneNum != null"><s:property value="#session.loginedUser.phoneNum"/></s:if>
						                        			<s:else>未设置</s:else>
                										</p>
													</td>
                								</tr>
	               							</tbody>
	              						</table>
		                        </div>
		                        <div class="clearfix"></div>
							</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			
			<%@include file="/jsps/common/commonBottom.jsp" %>
		</div>
	</div>
	
	<div class="modal inmodal" id="updateImg" tabindex="-1">
         <div class="modal-dialog">
             <div class="modal-content animated fadeIn">
                 <div class="modal-header">
                     <button type="button" class="close" data-dismiss="modal"><span>&times;</span><span class="sr-only">Close</span></button>
                     <strong>更改头像</strong>
                 </div>
                 <div class="modal-body">
                 	<div><input id="userPhotoPath" multiple="multiple" type="file" onfocus="clearState();"/></div>
					<div class="progress">
						<div id="uploadBar" class="progress-bar"></div>
					</div>
					<label class="control-label text-center" id="uploadMsg"></label>
                 </div>
                 <div class="modal-footer">
                     <button type="button" class="btn btn-white" data-dismiss="modal" onclick="window.location.href=window.location.href;">关闭</button>
                     <button type="button" class="btn btn-primary" onclick="updateImg();">上传</button>
                 </div>
             </div>
         </div>
     </div>
	<div class="modal inmodal" id="updateInfo" tabindex="-1">
         <div class="modal-dialog">
             <div class="modal-content animated fadeIn">
                 <div class="modal-header">
                     <button type="button" class="close" data-dismiss="modal"><span>&times;</span>
                     <strong>更改用户留言</strong>
                 </div>
                 <div class="modal-body">
                 	<s:if test="#session.loginedUser.info != null"><s:set value="#session.loginedUser.info" var="info" scope="page"/></s:if>
                 	<textarea id="infoArea" name="info" style="width: 100%; height: 100px;">${pageScope.info}</textarea>
                 </div>
                 <div class="modal-footer">
                     <button type="button" class="btn btn-white" data-dismiss="modal">关闭</button>
                     <button type="button" class="btn btn-primary" onclick="updateInfo();">保存</button>
                 </div>
             </div>
         </div>
     </div>
	<div class="modal inmodal" id="updateBaseInfo" tabindex="-1">
         <div class="modal-dialog">
             <div class="modal-content animated fadeIn">
                 <div class="modal-header">
                     <button type="button" class="close" data-dismiss="modal"><span>&times;</span><span class="sr-only">Close</span></button>
                     <strong>更改用户基本信息</strong>
                 </div>
                 <div class="modal-body">
					<div>
					<form id="infoForm">
					<table id="userProfile" class="EditTable ui-common-table">
              			<tbody>
              				<tr class="FormData">
              					<td class="CaptionTD"><label>昵称：</label></td>
              					<td class="DataTD">
               						<s:if test="#session.loginedUser.nickname != null"><s:set value="#session.loginedUser.nickname" var="nickname" scope="page"/></s:if>
              						<input type="text" name="nickname" class="FormElement form-control" value="${pageScope.nickname}"/>
               					</td>
             					</tr>
           					<tr class="FormData">
           						<td class="CaptionTD"><label>性别：</label></td>
           						<td class="DataTD">
									<div> 
                                       <label class="radio-inline i-checks">
                                            <div class="iradio_square-green" style="position: relative;">
                                            	<input type="radio" name="sex" value="男" style="position: absolute; opacity: 0;" ${sessionScope.loginedUser.sex eq '男' ? 'checked' : ''} />
                                            	<ins class="iCheck-helper" style="position: absolute; top: 0%; left: 0%; display: block; width: 100%; height: 100%; margin: 0px; padding: 0px; background: rgb(255, 255, 255); border: 0px; opacity: 0;"></ins>
                                            </div> <i></i> 男
                                       </label>
                                       <label class="radio-inline i-checks">
                                            <div class="iradio_square-green" style="position: relative;">
                                            	<input type="radio" name="sex" value="女" style="position: absolute; opacity: 0;" ${sessionScope.loginedUser.sex eq '女' ? 'checked' : ''} />
                                            	<ins class="iCheck-helper" style="position: absolute; top: 0%; left: 0%; display: block; width: 100%; height: 100%; margin: 0px; padding: 0px; background: rgb(255, 255, 255); border: 0px; opacity: 0;"></ins>
                                            </div> <i></i> 女
                                       </label>
                                    </div>
            					</td>
       						</tr>
       						<tr class="FormData">
       							<td class="CaptionTD"><label>出生年月：</label></td>
       							<td class="DataTD">
       							<p>
		                  			<s:if test="#session.loginedUser.birth != null"><s:set value="#session.loginedUser.birth" var="birth" scope="request"/></s:if>
	              					<input type="text" name="birth" class="FormElement form-control layer-date" value="<s:property value="#request.birth"/>" id="birth" style="max-width: 100%;"/>
       							</p>   
            					</td>
           					</tr>
   							<tr class="FormData">
   								<td class="CaptionTD"><label>籍贯：</label></td>
   								<td class="DataTD">
									<p>
									<div class="row"> 
										<div class="col-sm-4">
											<select id="nativePlaceProvince" name="nativePlace" subTtitle="proOption" class="form-control" default-value="${loginedUser.nativePlace == null ? '北京' : fn:split(loginedUser.nativePlace, '-')[0]}"></select>
										</div>
										<div class="col-sm-4">
											<select id="nativePlaceCity" name="nativePlace" subTitle="cityOption" class="form-control" default-value="${loginedUser.nativePlace == null ? '北京' : fn:split(loginedUser.nativePlace, '-')[1]}"></select>
										</div>
										<div class="col-sm-4">
											<select id="nativePlaceArea" name="nativePlace" subTitle="areaOption" class="form-control" default-value="${loginedUser.nativePlace == null ? '东城区' : fn:split(loginedUser.nativePlace, '-')[2]}"></select>
										</div>
	               					</div>
									</p>
								</td>
       						</tr>
        					<tr class="FormData">
       							<td class="CaptionTD"><label>qq：</label></td>
       							<td class="DataTD">
								<p>
									<s:if test="#session.loginedUser.qq != null"><s:set value="#session.loginedUser.qq" var="qq" scope="page"/></s:if>
              						<input type="text" name="qq" class="FormElement form-control" value="${pageScope.qq}"/>
               					</p>
								</td>
							</tr>
							<tr class="FormData">
								<td class="CaptionTD"><label>email：</label></td>
								<td class="DataTD">
								<p>
									<s:if test="#session.loginedUser.email != null"><s:set value="#session.loginedUser.email" var="email" scope="page"/></s:if>
              						<input type="text" name="email" class="FormElement form-control" value="${pageScope.email}"/>
               					</p>
								</td>
							</tr>
							<tr class="FormData">
							<td class="CaptionTD"><label>手机号码：</label></td>
							<td class="DataTD">
								<p>
									<s:if test="#session.loginedUser.phoneNum != null"><s:set value="#session.loginedUser.phoneNum" var="phoneNum" scope="page"/></s:if>
              						<input type="text" name="phoneNum" class="FormElement form-control" value="${pageScope.phoneNum}"/>
               					</p>
							</td>
    					</tr>
    					</tbody>
   						</table>
					</form>
					</div>
                 </div>
                 <div class="modal-footer">
                     <button type="button" class="btn btn-white" data-dismiss="modal">取消</button>
                     <button type="button" class="btn btn-primary" onclick="updateBaseInfo();">保存</button>
                 </div>
             </div>
         </div>
     </div>
	
	<!-- 全局js -->
	<script src="js/jquery.min.js?v=2.1.4"></script>
	<script src="js/bootstrap.min.js?v=3.3.6"></script>
	<script src="js/plugins/iCheck/icheck.min.js"></script>
	<script src="js/plugins/layer/laydate/laydate.js"></script>
	<script src="js/global.js"></script>
	<script type="text/javascript">
		$(function() {
			initNativePlaces(); 
			
			$('.i-checks').iCheck({
                checkboxClass: 'icheckbox_square-green',
                radioClass: 'iradio_square-green',
            });
		})
		
		// 更新留言
		function updateInfo() {
			$.post("${basePath}userajax/userajax_updateuser.action", $.param($("#infoArea")), 
					function (data, statusTest) {
				if (data == "success") {
					window.location.href = window.location.href;
				} 
			});
		}
		
		
		// 更新基本信息
		function updateBaseInfo() {
			$.post("${basePath}userajax/userajax_updateuser.action", $("#infoForm").serializeArray(), 
					function (data, statusTest) {
				if (data == "success") {
					window.location.href = window.location.href;
				} 
			});
		}
		
  		var defaultProvince = $("#nativePlaceProvince").attr("default-value");
  		var defaultCity = $("#nativePlaceCity").attr("default-value");
  		var defaultArea = $("#nativePlaceArea").attr("default-value");
  		function initNativePlaces() { //加载城市信息
			$.post("${basePath}userajax/userajax_initNativePlaces.action", 
					{province: defaultProvince, city: defaultCity, area: defaultArea}, 
					function(data, statusText) {
				data = eval("(" + data + ")");
				addOptions(data.provinces, $("#nativePlaceProvince"));
				addOptions(data.cities, $("#nativePlaceCity"));
				addOptions(data.areas, $("#nativePlaceArea")); 
			});
  		}
  		
  		$("#nativePlaceProvince").change(function () { //城市信息改变
  			var province = $(this).find("option:selected").text();
  			var city = "";
  			$.post("${basePath}userajax/userajax_changeNativePlace.action", 
					{province: province, city: city}, function(data, statusText) {
				data = eval("(" + data + ")");
				$(".cityOption").remove();
				$(".areaOption").remove();
				addOptions(data.cities, $("#nativePlaceCity"));
				addOptions(data.areas, $("#nativePlaceArea"));
			});
  		})
  	
  		$("#nativePlaceCity").change(function () { //城市信息改变
  			var province = $("#nativePlaceProvince").find("option:selected").text();
  			var city = $(this).find("option:selected").text();
  			$.post("${basePath}userajax/userajax_changeNativePlace.action", 
					{province: province, city: city}, function(data, statusText) {
				data = eval("(" + data + ")");
				$(".areaOption").remove();
				addOptions(data.areas, $("#nativePlaceArea"));
			});
  		})
  		
  		// 添加option的工具函数 
  		function addOptions(data, container) {
  			for (var j=0; j<data.length; j++) {
				var newOption = $("<option class='" + container.attr("subTitle") + "'>" + data[j] + "</option>");
  				if (container.attr("default-value") == data[j]) {
  					newOption.attr("selected", "selected"); 
  				} 
				container.append(newOption);
			}
  		}
  		
		//外部js调用
        laydate({
            elem: '#birth', //目标元素。由于laydate.js封装了一个轻量级的选择器引擎，因此elem还允许你传入class、tag但必须按照这种方式 '#id .class'
            event: 'focus', //响应事件。如果没有传入event，则按照默认的click
            format: 'YYYY-MM-DD'
        });
		
        // 更新头像
    	function updateImg() {
    		var formData = new FormData();
    		formData.append("commonUpload", $("#userPhotoPath")[0].files[0]);
    		formData.append("savePath", "users/userphotos");
    		formData.append("allowedTypes", ".gif,.png,.jpg");
    		var userPhotoVal = $("#userPhotoPath")[0].value;
    		if (userPhotoVal.trim() != "") {
    			$.ajax({
    				url : "${basePath}updownload/updownload_upload.action",
    				type : "post",
    				data : formData,
    				processData : false,
    				cache : false,
    				contentType : false,
    				success : function(result) {
    					result = eval("(" + result + ")");
    					if (result.message == "上传成功！") {
    						$("#uploadMsg").text(result.message);
   							$.post("${basePath}userajax/userajax_updateuser.action", { // 文件最终名称finalFileName
   								"userPhotoPath" : result.finalFileName
   							});
    					} else {
    						$("#uploadMsg").text(result.message);
    					}
    				},
    				xhr : function() {
    					var xhr = $.ajaxSettings.xhr();
    					if (onprogress && xhr.upload) {
    						xhr.upload.addEventListener("progress", onprogress, false);
    						return xhr;
    					}
    				}
    			});
    		} else {
    			alert("请选择文件！");
    		}
    	}
    	
	</script>
</body>
</html>
