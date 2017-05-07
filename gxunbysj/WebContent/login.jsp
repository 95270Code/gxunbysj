<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String path = request.getContextPath();
   request.setAttribute("path", path);
%>
<!doctype html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
	<link rel="stylesheet" type="text/css" href="<%=path %>/jquery-easyui-1.5/themes/icon.css" />
    <link rel="stylesheet" type="text/css" href="<%=path %>/jquery-easyui-1.5/themes/default/easyui.css" />
    <script type="text/javascript" src="<%=path %>/jquery-easyui-1.5/jquery.min.js"></script>
    <script type="text/javascript" src="<%=path %>/jquery-easyui-1.5/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="<%=path %>/jquery-easyui-1.5/locale/easyui-lang-zh_CN.js" ></script>
</head>
<style>
body,div,dl,dt,dd,ul,ol,li,h1,h2,h3,h4,h5,h6,pre,form,fieldset,input,p,blockquote,th,td{margin:0;padding:0;border:none;}
body{font-size:12px; font-family:Cambria, "Hoefler Text", "Liberation Serif", Times, "Times New Roman", serifbackground:#fff;color:#2b2b2b;}
address,caption,cite,code,dfn,em,strong,th,var{font-style:normal;font-weight:normal;}
select,input,img{vertical-align:middle;}
table{border-collapse:collapse;border-spacing:0;}
table,td,tr,th{font-size:12px;}
a{text-decoration:none;cursor:pointer;}
fieldset,img{border:0;}

.main{ position:absolute;left:50%; top:50%; background:url(${path }/images/login.png) no-repeat; width:772px; height:468px; margin:-234px 0 0 -386px;}

.input-box{ position:absolute; top:110px; left:380px;color:#0952a1;}
.input-box p{ line-height:40px;}
.input-box .check{ width:14px; height:14px; margin-left:48px;}
.input-box .record{ margin-left:6px;}
.input-box .link{ margin-top:14px; margin-left:70px;}
a{ height:28px; width:72px; display:inline-block; color:#fff; line-height:28px; text-align:center; margin-top:10px;}
.log{ background:url(${path }/images/log.png) no-repeat; margin-right:16px; margin-left:48px}

.reset{ background:url(${path }/images/reset.png) no-repeat; color:#6d6d6d;}
.main-box .copy{ text-align:center; margin-top:8px; color:#666666;}
.text{ text-align:center; color:#fff; margin-top:398px; line-height:24px;}

</style>

<body style="background-color:#3987cf;" onkeydown="keyLogin()">

<div class="main">
<div class="login-box">
	 <div class="input-box">
	 	<form id="formLogin">
        	用户名：<input id="username" type="text" /><br><br>
           	<span style=" padding-right:12px;">密</span>码：<input id="password"/>
           	<p><input type="checkbox"  class="check"/><span class="record">记住登录名</span></p>
      <a href="#" class="log" onclick="doLogin()">登&nbsp;录</a><a href="#" class="reset">重&nbsp;置</a></form>
      </div>
   </div>
      <div class="text">
      <p>Copyright © 2016-2017 lhd.com
	 </p>
      </div>
</div>
      


</body>
<script type="text/javascript">
$('#username').textbox({       
    iconCls:'icon-man', 
    iconAlign:'right',
    width:200,
    height:30,
    required: true,
});

$('#password').textbox({       
    iconCls:'icon-lock', 
    iconAlign:'right',
    width:200,
    height:30,
    type:'password',
    required: true,
});


function doLogin(){	
	var username = $("#username").val();
	var password = $("#password").val();
	var flag = true;
	if(username==""){
		$.messager.alert('验证','请输入账号');
		flag = false;
	}
	else if(password==""){
		$.messager.alert('验证','请输入密码');
		flag = false;
	}
	if(flag){
		//$.messager.progress(); // 显示进度条
		$.ajax({
			url:'${path }/login/doLogin.do',
			type:'post',
			data:{username:username,password:password},
			success: function (result) {
				//$.messager.progress('close');// 隐藏进度条
				if(result=="true"){
					location.href="${path }/login/goIndex.do"
				}else{
					$.messager.alert('提示','请输入正确的账号和密码');
				}
			}
		});
	}
	
}

function keyLogin(){
	if(event.keyCode==13)
		doLogin();
}
</script>
</html>