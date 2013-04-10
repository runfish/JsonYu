<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
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

		<pre>
	<s:set var="age" value="25"></s:set>
	
	
	<s:if test="#age>25">
	age大于25
	</s:if>

<s:elseif test="#age<=25">
age小于后者等于25
</s:elseif>	

<%
List<Date> listDate = new ArrayList<Date>();
   for(int i = 0;i<10;i++){
	   Date date = new Date();
	   listDate.add(date);
	   
   }

   request.setAttribute("date",listDate);
   
%>

<s:iterator var="date" value="#request.date">

    <s:property value="getDay()"/>

</s:iterator>
<s:iterator var="date" value="#request.date" status="status">

  <s:property value="#status.count"/>   
  <s:property value="#status.index"/>   

</s:iterator>
1:子迭代
<s:subset source="#request.date" count="3" start="2">
<s:iterator>
<s:property/>
</s:iterator>
</s:subset>
	</pre>

2：循环字符串
<s:generator separator="," val="%{'aa,ss,dd,f,werw,g,r,f,fg'}">
<s:iterator>
  <s:property/>
</s:iterator>

</s:generator>

<s:generator separator=","  val="%{'aaa,bbb,ccc,ddd,eee'}">
 <s:iterator>
     <s:property /><br/>
 </s:iterator>
</s:generator>


<s:iterator var ="i" begin="1" end="10" step="1">
<s:property/>
</s:iterator>



	</body>
</html>
