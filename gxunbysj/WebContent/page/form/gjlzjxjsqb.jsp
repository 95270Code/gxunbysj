<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String path = request.getContextPath();
   request.setAttribute("path", path);
   request.setAttribute("type", "gjlzjxjsqb");
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
  	<script type="text/javascript" src="<%=path %>/js/upload.js" ></script>
  	<script type="text/javascript" src="<%=path %>/js/ajaxfileupload.js" ></script>
</head>
<style>

	table{border-collapse:collapse;}
	td{
		border-style: solid;
	}
</style>

<body>
<h1>广西民族大学国家励志奖学金申请表</h1>
<form id="form1" class="easyui-form" enctype="multipart/form-data">
<table width="1000" border="1">
  <tr>
	    <td width="103" rowspan="7" style="text-align:center;">个<br/>人<br/>情<br/>况</td>
	    <td width="106" height="50"><label for="name">姓名</label></td>
	    <td width="136"><input class="easyui-textbox" type="text" name="xm" data-options="required:true" style="height:100%; width:180px;" value="${user.s_name }" /></td>
	    <td width="46">性别</td>
	    <td width="110">
                 <select class="easyui-combobox" name="xb" required="true" editable="false" style="width:110px;height:100%;">   
				    <option value="1">男</option>   
				    <option value="2">女</option>     
				</select>
        </td>
	    <td width="104">出生年月</td>
	    <td width="240"><div style="margin:auto; "><input name="csnyString" type= "text" class= "easyui-datebox" required ="required" editable="false" style="height:50px; width:240px;" /></div>  </td>
	    <td width="119" rowspan="6">
	     <div id="Imgdiv" style="margin-bottom: 190px;">
           <img id="Img" width="120px" height="150px" alt="个人照片"/><p></p>
            <input style="width:70px;margin-left: 25px;" onChange = "change_photo()" id="file_upload" name="file_upload" type="file" />
    	 </div>
	    </td>
  </tr>
	  <tr>
	    <td height="48">民族</td>
	    <td><input class="easyui-textbox" type="text" name="mz" data-options="required:true" style="height:100%;width:180px; " /></td>
	    <td>政治面貌</td>
	    <td><input class="easyui-textbox" type="text" name="zzmm" data-options="required:true" style=" width:110px;height:100%; " /></td>
	    <td>学号</td>
	    <td><input class="easyui-textbox" type="text" name="xh" data-options="required:true" style=" width:240px;height:50px; " value="${user.s_id }" /></td>
  </tr>
	  <tr>
	    <td height="35">身份证号码</td>
	    <td colspan="3"><input class="easyui-textbox" type="text" name="sfzhm" data-options="required:true" style=" width:342px;height:100%; " /></td>
	    <td>联系电话</td>
	    <td><input class="easyui-textbox" type="text" name="lxdh" data-options="required:true" style=" width:241px;height:100%; " /></td>
  </tr>
	  <tr>
	    <td rowspan="2">发奖学金银行账号</td>
	    <td height="60">本人银行卡号</td>
	    <td colspan="4"><input class="easyui-textbox" type="text" name="yhkh" data-options="required:true" style=" width:510px;height:100%; " /></td>
  </tr>
	  <tr>
	    <td height="57">开户行名称</td>
	    <td colspan="4"><input class="easyui-textbox" type="text" name="khhmc" data-options="required:true" style=" width:510px;height:100%; " /></td>
  </tr>
	  <tr>
	    <td height="43">学院</td>
	    <td> <select class="easyui-combobox" name="xy" required="true" editable="false" style="width:100%;height:100%;">   
				    <option value="1001">软件与信息安全学院</option>   
				    <option value="1002">信工学院</option>      
				</select></td>
	    <td>年级</td>
	    <td><select class="easyui-combobox" name="nj" required="true" editable="false" style="width:110px;height:100%;">   
				    <option value="13">13</option>   
				    <option value="14">14</option>
				    <option value="14">15</option>
				    <option value="14">16</option>
				    <option value="14">17</option>      
				</select></td>
	    <td>专业</td>
	    <td><select class="easyui-combobox" name="zy" required="true" editable="false" style="width:240px;height:50px;">   
				    <option value="2001">软件工程</option>   
				    <option value="2003">信息技术管理</option>   
				</select></td>
  </tr>
	  <tr>
	    <td height="110">曾获何种奖励</td>
	    <td colspan="6"><input class="easyui-textbox" type="text" name="chhzjl" data-options="multiline:true" style=" width:815px;height:100%; " /></td>
  </tr>
</table>
<table width="1000" border="1">
  <tr>
    <td width="87" rowspan="3" style="text-align:center;">家<br/>庭<br>经<br/>济<br/>情<br/>况</td>
    <td width="188">家庭户口</td>
    <td colspan="3"><select id="cc" class="easyui-combobox" name="jthk" required="true" editable="false" style="width:445px;height:20px;">   
				    <option value="c">城镇</option>   
				    <option value="n">农村</option>   
				</select></td>
    <td width="136">家庭人口总数</td>
    <td width="128"><input class="easyui-numberbox" type="text" name="jtrkzs" data-options="required:true" style=" width:120px;height:20px; " /></td>
  </tr>
  <tr>
    <td>家庭月总收入</td>
    <td width="155"><input class="easyui-numberbox" type="text" name="jtysr" data-options="required:true,precision:2" style=" width:147px;height:20px; " /></td>
    <td width="140">人均月收入</td>
    <td width="153"><input class="easyui-numberbox" type="text" name="rjysr" data-options="required:true,precision:2" style=" width:147px;height:20px; " /></td>
    <td>收入来源</td>
    <td><input class="easyui-textbox" type="text" name="srly" data-options="required:true" style=" width:120px;height:20px; " /></td>
  </tr>
  <tr>
    <td>家庭住址</td>
    <td colspan="3"><input class="easyui-textbox" type="text" name="jtzz" data-options="required:true" style=" width:444px;height:20px; " /></td>
    <td>邮政编码</td>
    <td><input class="easyui-textbox" type="text" name="yzbm" data-options="required:true" style=" width:120px;height:20px; " /></td>
  </tr>
</table>
<table width="1000" height="211" border="1">
  <tr>
    <td width="87" rowspan="4" style="text-align:center;">学<br/>习<br/>情<br/>况</td>
    <td width="178" height="48">该学年学习课程数</td>
    <td width="133"><input class="easyui-numberbox" type="text" name="kcs" data-options="required:true" style=" width:148px;height:49px; " /></td>
    <td width="86">其中平均成绩</td>
    <td width="116"><input class="easyui-numberbox" type="text" name="pjf" data-options="required:true,precision:2" style=" width:122px;height:49px; " /></td>
    <td width="120">最低成绩</td>
    <td width="109"><input class="easyui-numberbox" type="text" name="zdcj" data-options="required:true,precision:2" style=" width:115px;height:49px; " /></td>
    <td width="120">&nbsp;</td>
  </tr>
  <tr>
    <td height="36">成绩排名（名次/总人数）</td>
    <td>第<input class="easyui-numberbox" type="text" name="cjpm" data-options="required:true" style=" width:100px;height:36px; " />名</td>
    <td>总人数<input class="easyui-numberbox" type="text" name="bjzrs" data-options="required:true" style=" width:40px;height:36px; " /></td>
    <td>综合测评排名(名次/总人数）</td>
    <td>第<input class="easyui-numberbox" type="text" name="zhcppm" data-options="required:true" style=" width:50px;height:36px; " />名</td>
    <td>测评总人数<input class="easyui-numberbox" type="text" name="cpzrs" data-options="required:true" style=" width:110px;height:36px; " /></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td height="48">英语过级情况</td>
    <td><input class="easyui-textbox" type="text" name="yygjqk" data-options="multiline:true" style=" width:147px;height:47px; " /></td>
	<td>&nbsp;</td>
    <td>计算机等级情况</td>   
    <td colspan="2"><input class="easyui-textbox" type="text" name="jsjdjqk" data-options="multiline:true" style=" width:230px;height:47px; " /></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td height="55">其他考证</td>
    <td colspan="6"><input class="easyui-textbox" type="text" name="qtkz" data-options="multiline:true" style=" width:728px;height:50px; " /></td>
  </tr>
</table>
<table width="1000" border="1">
  <tr>
    <td height="88" style="text-align:center;">申<br/>请<br/>理<br/>由</td>
    <td><input class="easyui-textbox" type="text" name="sqly" data-options="multiline:true" style=" width:910px;height:auto; " /></td>
  </tr>
  <tr>
    <td height="88" style="text-align:center;"><p>班<br/>级<br/>推<br/>荐<br/>意<br/>见</p></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td width="88" height="78" style="text-align:center;"><p>学<br/>院<br/>审<br/>核<br/>意<br/>见</p></td>
    <td width="910">&nbsp;</td>
  </tr>
</table>
<br>
<a class="easyui-linkbutton" iconCls="icon-ok" onclick="submitOk('Y')">提交</a>
<a class="easyui-linkbutton" iconCls="icon-tip" onclick="submitOk('N')">保存</a>
</form>
</body>
<script>
var sqbbh = "";
sqbbh = '${sqbbh}';
//alert(sqbbh);

function submitOk(flag){
	if(sqbbh==""){
		var url ="";
		if(flag=="N")
			url='${path}/jzxj/submitSqb.do?sfqrtj=N';
		if(flag=="Y")
			url='${path}/jzxj/submitSqb.do?sfqrtj=Y';
		var i = $("#form1").form('enableValidation').form('validate');
		if(i){
			var formData= $("#form1").serialize();
			alert(formData);
			$.messager.confirm('提示','您确认要提交申请表了？',function(r){ 
				 if(r){
					$.messager.progress(); // 显示进度条
					$.ajax({
						url:url,
						type:'post',
						data:formData,
						success: function (result) {
							if(result.indexOf("true")>=0){
								uploadAjax(result);							
								/* var jq = top.jQuery;自动关闭选项卡
								setTimeout(function () {
									jq('#tabs').tabs('close', "填写申请奖助学金");
							    }, 5000); */
								
							}	
						}
					});				
				}	
			});	
		}
		
	}else{
		saveForm();
	}
				
}


function saveForm(){
	var formData= $("#form1").serialize();
	//alert(formData);
	$.ajax({
		url:'${path}/jzxj/submitSave.do?sfqrtj=N&sqbbh='+sqbbh,
		type:'post',
		data:formData,
		success: function (result) {
			if(result=="true")
				alert("保存成功");
			else
				alert("保存失败");
		}
	});
}


function uploadAjax(result){
	var bh = result.split(",");
	$.ajaxFileUpload({
		url: '${path}/jzxj/upload.do?type=${type}', //用于文件上传的服务器端请求地址
		secureuri: false, //是否需要安全协议，一般设置为false
		fileElementId: 'file_upload', //文件上传域的ID  
		//dataType: 'json', //返回值类型 一般设置为json
		data:{bh:bh[1]},
		success: function (data,stuats) //服务器成功响应处理函数
		{	
			if(stuats=="success"){
				$.messager.progress('close');
				$.messager.alert('消息','提交成功！');
				setTimeout(function () {
					location.href="${path}/page/form/sqbxz.jsp";
			    }, 5000);
				
			}
		},
		error: function (data, status, e)//服务器响应失败处理函数
		{
			alert(e);
		},
		
		/* success: function (data){
			if(data=="true"){
				$.messager.progress('close');
				$.messager.alert('消息','提交成功！');
				location.href="${path}/page/form/sqbxz.jsp";
			}else{
				$.messager.alert('消息','提交失败！');
			}
			
		}, */
										
	});
}
</script>
</html>