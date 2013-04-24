<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@taglib uri="/struts-tags" prefix="s" %>
<%String path = request.getContextPath();
String basePath = request.getScheme() + "://"
+ request.getServerName() + ":" + request.getServerPort()
+ path + "/"; %>
 <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <head>
        <base href="<%=basePath%>"><title>My JSP 'index.jsp' starting page</title>
        <meta http-equiv="pragma" content="no-cache">
        <meta http-equiv="cache-control" content="no-cache">
        <meta http-equiv="expires" content="0">
        <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
        <meta http-equiv="description" content="This is my page">
        <link rel="stylesheet" href="./css/demo.css" type="text/css">
        <link rel="stylesheet" href="./css/zTreeStyle/zTreeStyle.css" type="text/css">
        <script type="text/javascript" src="./js/jquery-1.4.4.min.js">
        </script>
        <script type="text/javascript" src="./js/jquery.ztree.core-3.3.js">
        </script>
        <script type="text/javascript" src="./js/jquery.ztree.excheck-3.3.js">
        </script>
        <script type="text/javascript" src="./js/jquery.ztree.exedit-3.3.js">
        </script>
        <SCRIPT type="text/javascript">
                                                                                                    <!--
                            var setting = {
                                view: {
                                    addHoverDom: addHoverDom,
                                    removeHoverDom: removeHoverDom,
                                    selectedMulti: false
                                },
                                edit: {
                                    enable: true,
                                    editNameSelectAll: true
                                },
                                data: {
                                    simpleData: {
                                        enable: true
                                    }
                                },
                                callback: {
                                    beforeDrag: beforeDrag,
                                    beforeEditName: beforeEditName,
                                    beforeRemove: beforeRemove,
                                    beforeRename: beforeRename,
                                    onRemove: onRemove,
                                    onRename: onRename
                                }
                            };
                            
                            var zNodes;
						
            				     
                            
                            var log, className = "dark";
                            function beforeDrag(treeId, treeNodes){
                                return false;
                            }
                            
                            function beforeEditName(treeId, treeNode){
                                className = (className === "dark" ? "" : "dark");
                                showLog("[ " + getTime() + " beforeEditName ]&nbsp;&nbsp;&nbsp;&nbsp; " + treeNode.name);
                                var zTree = $.fn.zTree.getZTreeObj("treeDemo");
                                zTree.selectNode(treeNode);
                                return confirm("进入节点 -- " + treeNode.name + " 的编辑状态吗？");
                            }
                            
                            function beforeRemove(treeId, treeNode){
                                className = (className === "dark" ? "" : "dark");
                                showLog("[ " + getTime() + " beforeRemove ]&nbsp;&nbsp;&nbsp;&nbsp; " + treeNode.name);
                                var zTree = $.fn.zTree.getZTreeObj("treeDemo");
                                zTree.selectNode(treeNode);
                                return confirm("确认删除 节点 -- " + treeNode.name + " 吗？");
                            }
                            
                            function onRemove(e, treeId, treeNode){
                                showLog("[ " + getTime() + " onRemove ]&nbsp;&nbsp;&nbsp;&nbsp; " + treeNode.name);
                            }
                            
                            function beforeRename(treeId, treeNode, newName){
                                className = (className === "dark" ? "" : "dark");
                                showLog("[ " + getTime() + " beforeRename ]&nbsp;&nbsp;&nbsp;&nbsp; " + treeNode.name);
                                if (newName.length == 0) {
                                    alert("节点名称不能为空.");
                                    var zTree = $.fn.zTree.getZTreeObj("treeDemo");
                                    setTimeout(function(){
                                        zTree.editName(treeNode)
                                    }, 10);
                                    return false;
                                }
                                return true;
                            }
                            
                            function onRename(e, treeId, treeNode){
                                showLog("[ " + getTime() + " onRename ]&nbsp;&nbsp;&nbsp;&nbsp; " + treeNode.name);
                            }
                            
                            function showLog(str){
                                if (!log) 
                                    log = $("#log");
                                log.append("<li class='" + className + "'>" + str + "</li>");
                                if (log.children("li").length > 8) {
                                    log.get(0).removeChild(log.children("li")[0]);
                                }
                            }
                            
                            function getTime(){
                                var now = new Date(), h = now.getHours(), m = now.getMinutes(), s = now.getSeconds(), ms = now.getMilliseconds();
                                return (h + ":" + m + ":" + s + " " + ms);
                            }
                            
                            var newCount = 1;
                            function addHoverDom(treeId, treeNode){
                                var sObj = $("#" + treeNode.tId + "_span");
                                if (treeNode.editNameFlag || $("#addBtn_" + treeNode.id).length > 0) 
                                    return;
                                var addStr = "<span class='button add' id='addBtn_" + treeNode.id +
                                "' title='add node' onfocus='this.blur();'></span>";
                                sObj.after(addStr);
                                var btn = $("#addBtn_" + treeNode.id);
                                if (btn) 
                                    btn.bind("click", function(){
                                        var zTree = $.fn.zTree.getZTreeObj("treeDemo");
                                        zTree.addNodes(treeNode, {
                                            id: (100 + newCount),
                                            pId: treeNode.id,
                                            name: "new node" + (newCount++)
                                        });
                                        return false;
                                    });
                            };
                            function removeHoverDom(treeId, treeNode){
                                $("#addBtn_" + treeNode.id).unbind().remove();
                            };
                            function selectAll(){
                                var zTree = $.fn.zTree.getZTreeObj("treeDemo");
                                zTree.setting.edit.editNameSelectAll = $("#selectAll").attr("checked");
                            }
                            
                            $(document).ready(function(){
            					 	  $.ajax({  
            				            async :false,  
            				            cache:true, 
										dataType:"json",
            				            url: "menuAction!list",//请求的action路径  
            				            error: function () {//请求失败处理函数  
            				                alert('请求失败');  
            				            },  
            				            success:function(data){ //请求成功后处理函数。 
            				           
									        alert(data);
										  	var jd = eval('(' + data + ')'); //把后台封装好的简单Json格式赋zNodes  
										  	zNodes = jd;
										  
										}   
            				                 
            				      
            				        });		
                                $.fn.zTree.init($("#treeDemo"), setting, zNodes);
                                $("#selectAll").bind("click", selectAll);
                                
                            });
                                           
                            //-->
                        
                            
                                                                                        
                                                                          
                                                                
                                                    
                                        
                            
                    
        </SCRIPT>
        <style type="text/css">
            .ztree li span.button.add {
                margin-left: 2px;
                margin-right: -1px;
                background-position: -144px 0;
                vertical-align: top; *
            
            vertical-align:middle
            }
        </style>
    </head>
    <body onload="javascript:getMenu();">
        <div class="content_wrap">
            <div class="zTreeDemoBackground left">
                <ul id="treeDemo" class="ztree">
                </ul>
            </div>
        </div>
        <a href="<%=path%>/menuAction!list">访问</a>
    </body>
</html>
