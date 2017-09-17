<%@ page language="java" import="java.util.*,java.io.OutputStream, cn.jxau.soft.utils.VerifyCode" 
	pageEncoding="UTF-8"%>
<%
	VerifyCode verifyCode = new VerifyCode();
	
	verifyCode.getImageAsOutStream(response.getOutputStream());
	session.setAttribute("verifyCode", verifyCode.getText());
	out.clear();
	out = pageContext.pushBody();
%>