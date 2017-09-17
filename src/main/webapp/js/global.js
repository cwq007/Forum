// 上传条滚动
function onprogress(evt) {
	var loaded = evt.loaded;   //已经上传大小情况 
	var tot = evt.total;       //附件总大小 
	var per = Math.floor(100*loaded/tot);  //已经上传的百分比 
	$("#uploadBar").text(per +"%");
	$("#uploadBar").css("width", per +"%");
}
// 清除上传模态框的状态
function clearState() {
	$('#uploadBar').css('width', '0'); 
	$('#uploadMsg').text('');
}
