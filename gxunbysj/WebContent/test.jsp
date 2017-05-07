<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  String path = request.getContextPath();
  request.setAttribute("path", path);
%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="<%=path %>/css/default.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" type="text/css" href="<%=path %>/jquery-easyui-1.5/themes/icon.css" />
    <link rel="stylesheet" type="text/css" href="<%=path %>/jquery-easyui-1.5/themes/default/easyui.css" />
    <script type="text/javascript" src="<%=path %>/jquery-easyui-1.5/jquery.min.js"></script>
    <script type="text/javascript" src="<%=path %>/jquery-easyui-1.5/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="<%=path %>/js/outlook2.js"></script>
    <script type="text/javascript" src="<%=path %>/js/index.js"></script>
</head>
<script type="text/javascript">
	function aaa(){
		addTab("sss","test2.jsp");//增加tab
	}
	
	function addTab(subtitle,url){
		var jq = top.jQuery;
		if(!jq('#tabs').tabs('exists',subtitle)){
			jq('#tabs').tabs('add',{
				title:subtitle,
				content:createFrame(url),
				closable:true,
			});
		}else{
			$('#tabs').tabs('select',subtitle);
			$('#mm-tabupdate').click();
		}
		tabClose();
	}

	function createFrame(url)
	{
		var s = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';
		return s;
	}
</script>

<body>
	<input type="button" value="dwdwwd" onclick="aaa()" />
</body>
</html>