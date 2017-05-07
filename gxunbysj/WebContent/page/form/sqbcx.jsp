<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%String path = request.getContextPath();
   request.setAttribute("path", path);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>申请表查询</title>
    <link rel="stylesheet" type="text/css" href="<%=path %>/jquery-easyui-1.5/themes/icon.css" />
    <link rel="stylesheet" type="text/css" href="<%=path %>/jquery-easyui-1.5/themes/default/easyui.css" />
    <script type="text/javascript" src="<%=path %>/jquery-easyui-1.5/jquery.min.js"></script>
    <script type="text/javascript" src="<%=path %>/jquery-easyui-1.5/jquery.easyui.min.js"></script>
  	<script type="text/javascript" src="<%=path %>/jquery-easyui-1.5/locale/easyui-lang-zh_CN.js" ></script>
    <script type="text/javascript" src="<%=path %>/page/form/sqbcxScript.js"> </script>
</head>
<body onload="init('${path}')">
<table id="sqbcxbg"></table>
<div id="tb" style="padding:5px;">
	
	<div style="padding:0 0 0 7px;color:#333;">
		申请表类型：<select class="easyui-combobox" name="sqblx" required="true" editable="false" style="width:110px;height:30x;">   
				    <option value="gjlzjxjsqb">国家励志奖学金</option>   
				    <option value="14">14</option>
				    <option value="14">15</option>
				    <option value="14">16</option>
				    <option value="14">17</option>      
				</select>	&nbsp;
			
		<c:if test="${user.qx>=2}" var="result" scope="session">
			学生学号：<input type="text" class="textbox" name="searchXh" style="width:130px;height:25px;">&nbsp;
			学生姓名：<input type="text" class="textbox" name="searchXm" style="width:110px;height:25px;">&nbsp;
		</c:if>
		
		<c:choose>
			<c:when test="${user.qx==1}">
				状态：<select class="easyui-combobox" name="sfqrtj" editable="false" style="width:110px;height:30x;">   
				    <option value="">全部</option>   
				    <option value="Y">已提交</option>
				    <option value="N">未提交</option>   
				</select>	&nbsp;
			</c:when>
			
			<c:when test="${user.qx==2}">
				状态：<select class="easyui-combobox" name="bjyj"  editable="false" style="width:110px;height:30x;">   
				    <option value="">全部</option>   
				    <option value="Y">已审核</option>
				    <option value="N">未审核</option>   
				</select>	&nbsp;
			</c:when>
			
			<c:when test="${user.qx==3}">
				状态：<select class="easyui-combobox" name="xyyj"  editable="false" style="width:110px;height:30x;">   
				    <option value="">全部</option>   
				    <option value="Y">已审核</option>
				    <option value="N">未审核</option>   
				</select>	&nbsp;
			</c:when>
			
		</c:choose>
		
		创建时间从：<input type="text" name="date_from" class="easyui-datebox" editable="false" style="width:150px;height:25px;">&nbsp;&nbsp;
		到：<input type="text" name="date_to" class="easyui-datebox" editable="false" style="width:150px;height:25px;">&nbsp;
		<button onclick="cx()" style="height:25px">查询</button>
	</div>
</div>
</body>
</html>