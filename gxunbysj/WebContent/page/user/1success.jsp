<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String path = request.getContextPath();%>
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
  	<script type="text/javascript" src="<%=path %>/jquery-easyui-1.5/locale/easyui-lang-zh_CN.js" ></script>
    <script type="text/javascript" src="<%=path %>/page/user/successScript.js"> </script> 
	
</head>
<body>
<table id="box"></table>
<div id="tb" style="padding:5px;">
	<div style="margin-bottom:5px;">
		<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="obj.newUser();">添加</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="obj.editUser();">修改</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="obj.deleteUser()">删除</a>
	</div>
	<div style="padding:0 0 0 7px;color:#333;">
		学号：<input type="text" class="textbox" name="searchId" style="width:180px;height:25px;">&nbsp;&nbsp;
		姓名：<input type="text" class="textbox" name="searchName" style="width:130px;height:25px;">&nbsp;&nbsp;
		创建时间从：<input type="text" name="date_from" class="easyui-datebox" editable="false" style="width:150px;height:25px;">&nbsp;&nbsp;
		到：<input type="text" name="date_to" class="easyui-datebox" editable="false" style="width:150px;height:25px;">&nbsp;&nbsp;
		<a href="#" class="easyui-linkbutton" iconCls="icon-search" onclick="obj.search();">查询</a>
	</div>
</div>

 <div id="dlg" class="easyui-dialog" style="width:400px"
            closed="true" buttons="#dlg-buttons">
        <form id="fm" method="post" novalidate style="margin:0;padding:20px 50px">
            <div style="margin-bottom:20px;font-size:14px;border-bottom:1px solid #ccc">添加新用户</div>
            <div style="margin-bottom:10px">
                <input name="s_id" class="easyui-textbox" required="true" label="学号" style="width:90%">
            </div>
            <div style="margin-bottom:10px">
                <input name="s_name" class="easyui-textbox" required="true" label="姓名:" style="width:90%">
            </div>
           
           <div style="margin-bottom:10px">
                <input name="s_password" class="easyui-textbox" required="true" label="密码:" style="width:90%">
           </div>
           
           <div style="margin-bottom:10px">
           		<select id="cc" class="easyui-combobox" name="s_sex" label="性别:" required="true" style="width:90%">   
				    <option value="1">男</option>   
				    <option value="2">女</option>      
				</select> 
           </div>
           
           <div style="margin-bottom:10px">
                <select id="cc" class="easyui-combobox" name="s_academy" required="true" label="学院:" editable="false" style="width:90%">   
				    <option value="1001">软件与信息安全学院</option>   
				    <option value="1002">信工学院</option>      
				</select> 
           </div>
           
           <div style="margin-bottom:10px">
                 <select id="cc" class="easyui-combobox" name="s_major" label="专业:" required="true" editable="false" style="width:90%">   
				    <option value="2001">软件工程</option>   
				    <option value="2003">信息技术管理</option>   
				</select>
           </div>
           
           
           <div style="margin-bottom:10px">
                 <select id="cc" class="easyui-combobox" name="s_class" label="班级:" required="true" editable="false" style="width:90%">   
				    <option value="01">01</option>   
				    <option value="02">02</option>
					<option value="03">03</option>
					<option value="04">04</option>
					<option value="05">05</option>     
				</select>
           </div>
           
           <div style="margin-bottom:10px">
               <select id="cc" class="easyui-combobox" name="s_grade" label="年级:" required="true" editable="false" style="width:90%">   
				    <option value="13">13</option>   
				    <option value="14">14</option>
					<option value="15">15</option>
					<option value="16">16</option>
					<option value="17">17</option>
					<option value="18">18</option>
					<option value="19">19</option>
					<option value="20">20</option>     
				</select> 
           </div>
          
        </form>
 </div>
 <div id="dlg-buttons">
        <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="obj.saveUser();" style="width:90px">保存</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="obj.cancle();" style="width:90px">取消</a>
 </div>
</body>
</html>