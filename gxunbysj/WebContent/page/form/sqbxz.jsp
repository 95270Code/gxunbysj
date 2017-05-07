<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%String path = request.getContextPath();%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>选择奖助学金申请类型</title>
	<link rel="stylesheet" type="text/css" href="<%=path %>/jquery-easyui-1.5/themes/icon.css" />
    <link rel="stylesheet" type="text/css" href="<%=path %>/jquery-easyui-1.5/themes/default/easyui.css" />
    <script type="text/javascript" src="<%=path %>/jquery-easyui-1.5/jquery.min.js"></script>
    <script type="text/javascript" src="<%=path %>/jquery-easyui-1.5/jquery.easyui.min.js"></script>
  	<script type="text/javascript" src="<%=path %>/jquery-easyui-1.5/locale/easyui-lang-zh_CN.js" ></script>
</head>
<body>
	 <div style=" margin:auto; width:520px; height:auto; margin-top:10%;">
	    <h1 style="text-align: center;">请选择要申请的奖助学金类型</h1>
		<select id="sle" name="sqbbh" style="width:440px;height:30px;">   
		    <option value="1">国家励志奖学金</option>   
		    <option value="2">国家励志助学金</option>   
		</select>
		<a href="#" class="easyui-linkbutton" iconCls="icon-ok" onclick="ok()">确定</a>
	 </div>
<script>

function ok(){
	var s = $("#sle").val();
	if(s==1)
		location.href = "gjlzjxjsqb.jsp";
	if(s==2)
		location.href = "gjlzzxjsqb.jsp";
}
	
</script>
</body>
</html>