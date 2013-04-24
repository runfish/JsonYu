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
  <s:form action="reportAction!save" method="post" enctype="multipart/form-data">
  
      <br>
      <br>
      公告标题 <s:textfield name="reportTitle" cssStyle="width:200px;"></s:textfield>
      <br>
      <br>
      <br>
      公告内容<s:textarea cols="50" rows="10" name="reportContext"></s:textarea>
      <br>
      <br>
      增加附件<s:file name="rider" value="添加附件"></s:file>
      <br>
      <br>
      增加附件<s:file name="rider" value="添加附件"></s:file>
      <br>
      <br>
      增加附件<s:file name="rider" value="添加附件"></s:file>
      <br>
      <br>
      <br>
      
     <s:submit value="提交" action="reportAction!save"></s:submit>
  
  </s:form>
  

  </body>
</html>
