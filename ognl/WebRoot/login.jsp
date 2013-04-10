<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  	<s:form id="form1" method="post" action="loginAction">
		<br/><br/>
		1：文本框标签：<s:textfield name="username"></s:textfield>
		<br/><br/>
		2：密码框标签：<s:password name="password"></s:password>
		
		<s:submit value="提交数据" name="button12"></s:submit>
	</s:form>
	<s:if test="#message != null">
		出错信息：<font color="red"><s:property value="#message"/></font>
	</s:if>
  </body>
</html>
