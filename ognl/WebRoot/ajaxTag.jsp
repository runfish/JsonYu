<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-dojo-tags" prefix="sx" %>
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
	
	<sx:head/>
  </head>
  
  <body>
 <pre>
 <sx:datetimepicker>
 </sx:datetimepicker>
 
 选项卡标签
 <sx:tabbedpanel id="test" >
   <sx:div id="one" label="本地数据" theme="ajax" labelposition="top" >
       This is the first pane<br/>
       <s:form>
           <s:textfield name="tt" label="Test Text"/>  <br/>
           <s:textfield name="tt2" label="Test Text2"/>
       </s:form>
   </sx:div>
   <sx:div id="three" label="远程数据" theme="ajax" href="index.jsp">
      
   </sx:div>
</sx:tabbedpanel>
 树的组件
 <sx:tree id="..." label="树的子节点">
   <sx:treenode id="..." label="叶节点" />
   <sx:treenode id="..." label="...">
       <s:treenode id="..." label="..." />
       <s:treenode id="..." label="..." />
   </sx:treenode>
   <sx:treenode id="..." label="..." />
</sx:tree>

 
 
 </pre>
 
  </body>
</html>
