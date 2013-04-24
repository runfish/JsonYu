<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@taglib uri="/struts-tags" prefix="s" %>
<%String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; %>
 <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
        <title>My JSP 'index.jsp' starting page</title>
        <meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
        <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
        <meta http-equiv="description" content="This is my page">
        <script type="text/javascript" src="<%=path%>/js/jquery-1.4.4.min.js">
        </script>
        <script language="javascript">
            function deleteDept(dept_id){
                var flag = window.confirm("确定删除部门的数据?");
                if (flag == true) {
                
                    var deleteURL = "<%=path%>/deptAction!deleteDept?dept_id=" + dept_id + "&date=" + new Date() + "";
                    //alert(deleteURL);
                    jQuery.get(deleteURL, function(jsonData){
                        var flag = jsonData.flag;
                        var message = jsonData.message;
                        if (flag == true) {
                            window.location.reload();
                            window.parent.updateMain();
                        }
                        else {
                            window.alert("删除部门出错，错误为 = " + message);
                        }
                    }, "json");
                    
                }
            }
            
            
            
            function addDept(dept_id, grade, isleaf){
				var nodeName = window.prompt("请输入节点名称");
				if (nodeName == "") {
					alert("操作失败！节点名称不能为空!");
				    return;
				}
				else {
					if (nodeName != null) {
						var addURL = "<%=path%>/deptAction!addDept?dept_id=" + dept_id +"&grade="+grade+"&dept_name="+encodeURI(encodeURI(nodeName))+"&date=" + new Date() + "";
						$.get(addURL, function(jsonData){
						 var flag = jsonData.flag;
						 var message = jsonData.message;
						 
						 if(flag==true){
						 	window.location.reload();
							window.parent.updateMain();
						 }
						 else{
						 	window.alert(message);
						 }
						
						}, "json")
					}
				}
			}
			
			
			
		 function modifyDept(dept_id){
		 			var nodeName = window.prompt("请输入部门名称");
				if (nodeName == "") {
				    return;
				}
				else {
					if (nodeName != null) {
						var modifyURL = "<%=path%>/deptAction!modifyDept?dept_id=" + dept_id +"&dept_name="+encodeURI(encodeURI(nodeName))+"&date=" + new Date() + "";
						$.get(modifyURL, function(jsonData){
						 var flag = jsonData.flag;
						 var message = jsonData.message;
						 
						 if(flag==true){
						 	window.location.reload();
							window.parent.updateMain();
						 }
						 else{
						 	window.alert(message);
						 }
						
						}, "json")
					}
				}
			
			
			
		 }
			
                    
        </script>
    </head>
    <body>
        <table width="100%" id="mytab" border="1" class="t2">
            <thead>
                <th width="10%">
                    部门编号
                </th>
                <th>
                    部门名称
                </th>
                <th width="20%">
                    部门级别
                </th>
                <th width="30%">
                    操作
                </th>
            </thead>
            <s:iterator value="#deptList">
                <tr>
                    <td height="25">
                        <s:property value="dept_id" />
                    </td>
                    <td>
                        <s:property value="dept_name" escape="false" />
                    </td>
                    <td>
                        <s:property value="grade" />
                    </td>
                    <td align="right">
                        <a href="#" onclick="javascript:addDept('<s:property value="dept_id"/>','<s:property value="grade"/>','<s:property value="isleaf"/>');">添加子类</a>
                        <a href="#" onclick="javascript:modifyDept('<s:property value="dept_id"/>');">修改</a>
                        <a href="#" onclick="javascript:deleteDept('<s:property value="dept_id"/>');">删除</a>
                    </td>
                </tr>
            </s:iterator>
        </table>
    </body>
</html>
