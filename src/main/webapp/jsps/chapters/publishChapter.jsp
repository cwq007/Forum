<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>

<head>
	<base href="<%=basePath%>">
    <meta charset="utf-8">
    <title>发表文章</title>
    <link href="css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
    <link href="css/plugins/summernote/summernote.css" rel="stylesheet">
    <link href="css/plugins/summernote/summernote-bs3.css" rel="stylesheet">
    <link href="css/style.css?v=4.1.0" rel="stylesheet">
</head>

<body class="gray-bg top-navigation">
   	<div id="page-wrapper" class="gray-bg"> 
		<jsp:include page="/jsps/common/commonTop.jsp"/>
			
		<form id="contentContainer" method="post" action="">
	        <div class="row">
	            <div class="col-sm-12">
	                <div class="ibox float-e-margins">
	                    <div class="ibox-title"> 
				          <div class="input-group">
				   			  <span class="input-group-addon">文章标题：</span>
				              <input id="title" name="title" type="text" class="form-control input-md">
				          </div>
	                      <div style="margin-top: 2%;">
	                    	  <a href="#" data-toggle="modal" data-target="#uploadAttachments"><i class="fa fa-link"></i>添加附件：</a>
	                      	  <span id="attachment-container"></span>
	                      	  <div id="attname" style="display: none;"></div>
	                      	  <div id="atturl" style="display: none;"></div>
	                      </div>
	                    </div>
	                    <div class="ibox-content no-padding">
	                        <div class="summernote">
	                        </div>
	                    </div>
	                    <div>
	                    	<button class="btn btn-primary" type="button" style="width:100%;" onclick="publishChapter();">发表</button>
	                    </div>
	                </div>
	            </div>
	        </div>
        </form>
    </div>
    
    <div class="modal inmodal" id="uploadAttachments" tabindex="-1">
		<div class="modal-dialog">
			<div class="modal-content animated fadeIn">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"><span>&times;</span></button>
					<strong>上传</strong>
				</div>
				<div class="modal-body">
					<div>
						<input id="attachment" multiple="multiple" type="file" onfocus="clearState();" />
					</div>
					
					<div class="progress">
						<div id="uploadBar" class="progress-bar"></div>
					</div>
					<label class="control-label text-center" id="uploadMsg"></label>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-white" data-dismiss="modal" onclick="clearState();">关闭</button>
					<button type="button" class="btn btn-primary" onclick="uploadAttachment();">上传</button>
				</div>
			</div>
		</div>
	</div>

    <script src="js/jquery.min.js?v=2.1.4"></script>
    <script src="js/bootstrap.min.js?v=3.3.6"></script>
    <script src="js/global.js"></script>
    <script src="js/plugins/summernote/summernote.min.js"></script>
    <script src="js/plugins/summernote/summernote-zh-CN.js"></script>

    <script>
        $(document).ready(function () {
            $('.summernote').summernote({
                lang: 'zh-CN'
            });
            
	        $(".note-editable").css("height", "250px")
	        	.attr("id", "content");
        });
		
        var index = 0; //附件的索引
        function uploadAttachment() {
        	var formData = new FormData();
  			formData.append("commonUpload", $("#attachment")[0].files[0]);
  			formData.append("savePath", "chapters/chapterattachments");
  			formData.append("allowedTypes", ".rar,.zip,.gz");
  			var attachmentName = $("#attachment")[0].value;
  			var simpleAttName = attachmentName.substring(attachmentName.lastIndexOf("\\")+1);
  			if (attachmentName.trim() != "") {
  				$.ajax({
  					url: "${basePath}updownload/updownload_upload.action", 
  					type: "post", 
  					data: formData, 
  					processData: false,
  					cache: false,
  					contentType: false, 
					success: function (result) {
						result = eval("(" + result + ")"); 
						if (result.message == "上传成功！") {
							$("#attachment-container").append("<a href='javascript:void(0);' style='margin-right: 0.5%;' title='"+attachmentName+"'>"+simpleAttName+"</a>");
							$("#atturl").append("<input type='text' class='attachment-name' value='"+simpleAttName+"' />");
							$("#attname").append("<input type='text' class='attachment-url' value='"+result.finalFileName+"' />");
							index ++;
						}
						$("#uploadMsg").text(result.message);
					},
  					xhr: function() {
  					    var xhr = $.ajaxSettings.xhr();
  					    if(onprogress && xhr.upload) {
  					    	xhr.upload.addEventListener("progress" , onprogress, false);
  					    	return xhr;
  					    }
  					}
 				});
  			} else {
  				alert("请选择文件！");
  			}
		}
        
        function publishChapter() {
        	if ($("#title").val().trim() == "") {
        		alert("文章标题不能为空");
        		return;
        	}
        	if ($("#content").text().trim() == "") {
        		alert("文章内容不能为空");
        		return;
        	}
        	/*var dec1 = {
        		chapter: {title: "adaa", content: "<p>fda</p>", 
        			attachments: [{name: "nameaaa", url: "urlaaa"}, {name: "nameaaa", url: "urlbbb"}]
        		},
        	}; */
        	$.ajax({
        		url: "${basePath}chapterajax/chapterajax_publish.action", 
        		type: "post",
				data: stringifiedForm(),
				processData: false,
				cache : false,
				contentType : "application/json",
				success: function(result) {
					if (result == "success") {
						window.location.href="${basePath}jsps/chapters/publishSuccess.jsp";
					}
				}
        	});
        }        
        
     	// 获取form的json表达形式，并将其字符化
        function stringifiedForm() {
     		var jsonObj = {
     			chapter: {
					title: $("#title").val(),
	     			content: $("#content").html(), 
     			}
     		};
			var atts = [];
			alert($(".attachment-name").size());
			for (var i=0; i<$(".attachment-name").size(); i++) {
				var att = {};
				att.name = $(".attachment-name").eq(i).val();
				att.url = $(".attachment-url").eq(i).val();
				atts.push(att);				
			}
     		jsonObj.chapter.attachments = atts;
        	return JSON.stringify(jsonObj);
        }
    </script>
</body>

</html>
