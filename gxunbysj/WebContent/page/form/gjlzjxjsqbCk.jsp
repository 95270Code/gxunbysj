<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%String path = request.getContextPath();
   request.setAttribute("path", path);
   if(request.getParameter("sqbbh")!=null){
	   String sqbbh = request.getParameter("sqbbh");
	   request.setAttribute("sqbbh", sqbbh);
   }
   if(request.getParameter("sqblx")!=null){
	   String sqblx = request.getParameter("sqblx");
	   request.setAttribute("sqblx", sqblx);
   }
   
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>广西民族大学国家励志奖学金申请表</title>
    <link rel="stylesheet" type="text/css" href="<%=path %>/jquery-easyui-1.5/themes/icon.css" />
    <link rel="stylesheet" type="text/css" href="<%=path %>/jquery-easyui-1.5/themes/default/easyui.css" />
    <script type="text/javascript" src="<%=path %>/jquery-easyui-1.5/jquery.min.js"></script>
    <script type="text/javascript" src="<%=path %>/jquery-easyui-1.5/jquery.easyui.min.js"></script>
  	<script type="text/javascript" src="<%=path %>/jquery-easyui-1.5/locale/easyui-lang-zh_CN.js" ></script>
</head>
<style>

	table{border-collapse:collapse;}
	td{
		border-style: solid;
	}
</style>

<body>
<h1>广西民族大学国家励志奖学金申请表</h1>
<form id="form1" class="easyui-form">
<table width="1000" border="1">
  <tr>
	    <td width="95" rowspan="7">个人情况</td>
	    <td width="106" height="50"><label for="name">姓名</label></td>
	    <td width="136"><input class="easyui-textbox" type="text" name="xm" data-options="required:true" readonly="true" style="height:100%; " /></td>
	    <td width="46">性别</td>
	    <td width="110">
                 <select class="easyui-combobox" name="xb" required="true" editable="false" readonly="true" style="width:110px;height:100%;">   
				    <option value="1">男</option>   
				    <option value="2">女</option>     
				</select>
        </td>
	    <td width="104">出生年月</td>
	    <td width="240"><div style="margin:auto; "><input name="csny" type= "text" class= "easyui-datebox" readonly="true" required ="required" editable="false" style="height:50px; width:240px;" /></div>  </td>
	    <td width="119" rowspan="6">
	     <div id="Imgdiv" style="margin-bottom: 190px;">
           <img id="Img" width="120px" height="150px" src="<%=path %>/jzxj/lookImage.do?sqbbh=${sqbbh }&sqblx=${sqblx}" />
    	 </div></td>
  </tr>
	  <tr>
	    <td height="48">民族</td>
	    <td><input class="easyui-textbox" type="text" name="mz" data-options="required:true" readonly="true" style="height:100%; " /></td>
	    <td>政治面貌</td>
	    <td><input class="easyui-textbox" type="text" name="zzmm" data-options="required:true" readonly="true" style=" width:110px;height:100%; " /></td>
	    <td>学号</td>
	    <td><input class="easyui-textbox" type="text" name="xh" data-options="required:true" readonly="true" style=" width:240px;height:50px; " /></td>
  </tr>
	  <tr>
	    <td height="35">身份证号码</td>
	    <td colspan="3"><input class="easyui-textbox" type="text" name="sfzhm" data-options="required:true" readonly="true" style=" width:335px;height:50px; " /></td>
	    <td>联系电话</td>
	    <td><input class="easyui-textbox" type="text" name="lxdh" data-options="required:true" readonly="true" style=" width:240px;height:50px; " /></td>
  </tr>
	  <tr>
	    <td rowspan="2">发奖学金银行账号</td>
	    <td height="60">本人银行卡号</td>
	    <td colspan="4"><input class="easyui-textbox" type="text" name="yhkh" data-options="required:true" readonly="true" style=" width:510px;height:57px; " /></td>
  </tr>
	  <tr>
	    <td height="57">开户行名称</td>
	    <td colspan="4"><input class="easyui-textbox" type="text" name="khhmc" data-options="required:true" readonly="true" style=" width:510px;height:57px; " /></td>
  </tr>
	  <tr>
	    <td height="43">学院</td>
	    <td> <select class="easyui-combobox" name="xy" required="true" readonly="true" editable="false" style="width:100%;height:100%;">   
				    <option value="1001">软件与信息安全学院</option>   
				    <option value="1002">信工学院</option>      
				</select></td>
	    <td>年级</td>
	    <td><select class="easyui-combobox" name="nj" required="true" readonly="true" editable="false" style="width:110px;height:100%;">   
				    <option value="13">13</option>   
				    <option value="14">14</option>
				    <option value="14">15</option>
				    <option value="14">16</option>
				    <option value="14">17</option>      
				</select></td>
	    <td>专业</td>
	    <td><select class="easyui-combobox" name="zy" required="true" readonly="true" editable="false" style="width:240px;height:50px;">   
				    <option value="2001">软件工程</option>   
				    <option value="2003">信息技术管理</option>   
				</select></td>
  </tr>
	  <tr>
	    <td height="110">曾获何种奖励</td>
	    <td colspan="6"><input class="easyui-textbox" type="text" name="chhzjl" data-options="multiline:true" readonly="true" style=" width:100%;height:100%; " /></td>
  </tr>
</table>
<table width="1000" border="1">
  <tr>
    <td width="88" rowspan="3">家庭<br>经济情况</td>
    <td width="185">家庭户口</td>
    <td colspan="3"><select id="cc" class="easyui-combobox" name="jthk" required="true" readonly="true" editable="false" style="width:440px;height:20px;">   
				    <option value="c">城镇</option>   
				    <option value="n">农村</option>   
				</select></td>
    <td width="154">家庭人口总数</td>
    <td width="120"><input class="easyui-numberbox" type="text" name="jtrkzs" data-options="required:true" readonly="true" style=" width:120px;height:20px; " /></td>
  </tr>
  <tr>
    <td>家庭月总收入</td>
    <td width="136"><input class="easyui-numberbox" type="text" name="jtysr" data-options="required:true,precision:2" readonly="true" style=" width:147px;height:20px; " /></td>
    <td width="136">人均月收入</td>
    <td width="136"><input class="easyui-numberbox" type="text" name="rjysr" data-options="required:true,precision:2" readonly="true" style=" width:147px;height:20px; " /></td>
    <td>收入来源</td>
    <td><input class="easyui-textbox" type="text" name="srly" data-options="required:true" readonly="true" style=" width:120px;height:20px; " /></td>
  </tr>
  <tr>
    <td>家庭住址</td>
    <td colspan="3"><input class="easyui-textbox" type="text" name="jtzz" data-options="required:true" readonly="true" style=" width:444px;height:20px; " /></td>
    <td>邮政编码</td>
    <td><input class="easyui-textbox" type="text" name="yzbm" data-options="required:true" readonly="true" style=" width:120px;height:20px; " /></td>
  </tr>
</table>
<table width="1000" height="211" border="1">
  <tr>
    <td width="86" rowspan="4">学习情况</td>
    <td width="176" height="48">该学年学习课程数</td>
    <td width="137"><input class="easyui-numberbox" type="text" name="kcs" data-options="required:true" readonly="true" style=" width:145px;height:47px; " /></td>
    <td width="86">其中平均成绩</td>
    <td width="116"><input class="easyui-numberbox" type="text" name="pjf" data-options="required:true,precision:2" readonly="true" style=" width:116px;height:47px; " /></td>
    <td width="108">最低成绩</td>
    <td width="109"><input class="easyui-numberbox" type="text" name="zdcj" data-options="required:true,precision:2" readonly="true" style=" width:109px;height:47px; " /></td>
    <td width="120">&nbsp;</td>
  </tr>
  <tr>
    <td height="36">成绩排名（名次/总人数）</td>
    <td>第<input class="easyui-numberbox" type="text" name="cjpm" data-options="required:true" readonly="true" style=" width:100px;height:36px; " />名</td>
    <td>总人数<input class="easyui-numberbox" type="text" name="bjzrs" data-options="required:true" readonly="true" style=" width:40px;height:36px; " /></td>
    <td>综合测评排名(名次/总人数）</td>
    <td>第<input class="easyui-numberbox" type="text" name="zhcppm" data-options="required:true" readonly="true" style=" width:50px;height:36px; " />名</td>
    <td>测评总人数<input class="easyui-numberbox" type="text" name="cpzrs" data-options="required:true" readonly="true" style=" width:110px;height:36px; " /></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td height="48">英语过级情况</td>
    <td><input class="easyui-textbox" type="text" name="yygjqk" data-options="multiline:true" readonly="true" style=" width:147px;height:47px; " /></td>
	<td>&nbsp;</td>
    <td>计算机等级情况</td>   
    <td colspan="2"><input class="easyui-textbox" type="text" name="jsjdjqk" data-options="multiline:true" readonly="true" style=" width:230px;height:47px; " /></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td height="55">其他考证</td>
    <td colspan="6"><input class="easyui-textbox" type="text" name="qtkz" data-options="multiline:true" readonly="true" style=" width:728px;height:50px; " /></td>
  </tr>
</table>
<table width="1000" border="1">
  <tr>
    <td height="78">申请理由</td>
    <td><input class="easyui-textbox" type="text" name="sqly" data-options="multiline:true" readonly="true" style=" width:907px;height:76px; " /></td>
  </tr>
  <c:choose>
  	<c:when test="${user.qx==2&&sqb.xyyj eq null}">
		<tr>
		    <td height="78"><p>班级推荐意见</p></td>
		    <td><input class="easyui-textbox" type="text" name="bjtjyj" data-options="multiline:true" style=" width:907px;height:76px; " /></td>
	    </tr>
	</c:when>
	
	<c:otherwise>
		<tr>
		    <td height="78"><p>班级推荐意见</p></td>
		    <td><input class="easyui-textbox" type="text" name="bjtjyj" data-options="multiline:true" readonly="true" style=" width:907px;height:76px; " /></td>
	    </tr>
	</c:otherwise>
			
 </c:choose>
  
 <c:choose>
  	<c:when test="${user.qx==3}">
		<tr>
		    <td height="78"><p>学院审核意见</p></td>
		    <td><input class="easyui-textbox" type="text" name="xyshyj" data-options="multiline:true" style=" width:907px;height:76px; " /></td>
	    </tr>
	</c:when>
	
	<c:otherwise>
		<tr>
		    <td height="78"><p>学院审核意见</p></td>
		    <td><input class="easyui-textbox" type="text" name="xyshyj" data-options="multiline:true" readonly="true" style=" width:907px;height:76px; " /></td>
	    </tr>
	</c:otherwise>
			
 </c:choose>
</table>
<br>

<c:choose>
  	<c:when test="${(user.qx==2||user.qx==4)&&sqb.xyyj eq null}">
		<select name="bjyj">
			<option value="Y" selected="selected">同意</option>
			<option value="N">不同意</option>
		</select>
		<a class="easyui-linkbutton" iconCls="icon-ok" onclick="submitOk('bj')">提交推荐意见</a>
	</c:when>
		
	<c:when test="${user.qx==3||user.qx==4}">
		
			<select name="xyyj">
			<option value="Y" selected="selected">同意</option>
			<option value="N">不同意</option>
			</select>
			<a class="easyui-linkbutton" iconCls="icon-ok" onclick="submitOk('xy')">提交审核意见</a>
							
			<a href="${path}/page/form/dy_gjlzjxjsqb.jsp" target="_blank">打印</a>

	</c:when>			
</c:choose>

</form>
</body>
<script>
var sqbbh = "";
var sqblx = "";
sqbbh = '${sqbbh}';
sqblx = '${sqblx}';
function submitOk(flag){
	if(sqbbh!=""){
		var i = $("#form1").form('enableValidation').form('validate');
		if(i){
			//var formData= $("#form1").serialize();
			$.messager.confirm('提示','您确认要提交？',function(r){ 
				 if(r){
					$.messager.progress(); // 显示进度条
					var url ="";
					var bjyj = $('[name="bjyj"]').val();
					var bjtjyj = $('[name="bjtjyj"]').val();
					var xyyj = $('[name="xyyj"]').val();
					var xyshyj = $('[name="xyshyj"]').val();
					if(flag=="bj"){
						url = '${path}/jzxj/submitBjtjyj.do';
					}
						
					if(flag=="xy"){
						url = '${path}/jzxj/submitXyShyj.do';
					}						
					$.ajax({
						url:url,
						type:'post',
						data:{sqbbh:sqbbh,
							  sqblx:sqblx,
							  bjyj:bjyj,
							  bjtjyj:bjtjyj,
							  xyyj:xyyj,
							  xyshyj:xyshyj
							},
						
						success: function (result) {
							if(result="true"){
								$.messager.progress('close');
								$.messager.alert('消息','提交成功！');
							}	
						}
					});				
				}	
			});	
		}
		
	}else{
		alert("出错");
	}
				
}


$(function () {
	$("#form1").form('load','${path}/jzxj/queryObjectBysqbbh.do?sqbbh='+sqbbh+'&sqblx='+sqblx);
});


</script>

</html>

