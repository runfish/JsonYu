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
	
	<s:form action="" method="post">
	
	<s:hidden name="" value=""></s:hidden>
	<s:hidden name="" value=""></s:hidden>
		<pre>
 1:表单标签
 
 2; 文本框标签<s:textfield name="username"></s:textfield>
 3:密码框标签<s:password name="password"></s:password>
 4；文本域标签<s:textarea name="user_textArea" rows="5" cols="50"></s:textarea>
 5:单选框<s:radio name="" list="{'男','女'}"></s:radio>
 6:单选框<s:radio name="" list="#{1:'男',2:'女',0:'未知'}"></s:radio>
 7:单选框<s:radio name="" list="#classList" listKey="classid"
				listValue="classname"></s:radio>
 8:下拉框<s:select list="{'男','女'}"></s:select> 
11:文件域：<s:file name=""></s:file>

<s:updownselect
list="#{'england':'England', 'america':'America', 'germany':'Germany'}"
name="prioritisedFavouriteCountries"
headerKey="-1"
headerValue="--- Please Order Them Accordingly ---"
emptyOption="true" />

selectAllLabel="Select All" />

 </pre>
 
 9: 复选框<s:checkbox name="" ></s:checkbox>
 
 10： 复选框2：<s:checkboxlist name="" list="#classList" listKey="classid" listValue="classname"></s:checkboxlist>
<s:reset value="重置"></s:reset>

<s:select label="My Selection"
           name="mySelection"
           value="%{'POPEYE'}"
           list="{''}">
   <s:optgroup label="Adult"
                list="%{#{'SOUTH_PARK':'South Park'}}" />
   <s:optgroup label="Japanese"
                list="%{#{'POKEMON':'pokemon','DIGIMON':'digimon','SAILORMOON':'Sailormoon'}}" />
</s:select>
 <s:optiontransferselect
     label="Favourite Cartoons Characters"
     name="leftSideCartoonCharacters"
     leftTitle="Left Title"
     rightTitle="Right Title"
     list="{'Popeye', 'He-Man', 'Spiderman'}"
     multiple="true"
     headerKey="headerKey"
     headerValue="--- Please Select ---"
     emptyOption="true"
     doubleList="{'Superman', 'Mickey Mouse', 'Donald Duck'}"
     doubleName="rightSideCartoonCharacters"
     doubleHeaderKey="doubleHeaderKey"
     doubleHeaderValue="--- Please Select ---"
     doubleEmptyOption="true"
     doubleMultiple="true"
 />
<s:combobox
    label="My Favourite Fruit"
    name="myFavouriteFruit"
    list="{'apple','banana','grape','pear'}"
    headerKey="-1"
    headerValue="--- Please Select ---"
    emptyOption="true"
    value="banana" />

</s:form>


	</body>
</html>
