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
	<link rel="stylesheet" type="text/css" href="<%=path %>/jquery-easyui-1.5/themes/icon.css" />
    <link rel="stylesheet" type="text/css" href="<%=path %>/jquery-easyui-1.5/themes/default/easyui.css" />
    <script type="text/javascript" src="<%=path %>/jquery-easyui-1.5/jquery.min.js"></script>
    <script type="text/javascript" src="<%=path %>/jquery-easyui-1.5/jquery.easyui.min.js"></script>
  	<script type="text/javascript" src="<%=path %>/jquery-easyui-1.5/locale/easyui-lang-zh_CN.js" ></script>
  	<script type="text/javascript" src="<%=path %>/js/upload.js" ></script>
  	<script type="text/javascript" src="<%=path %>/js/ajaxfileupload.js" ></script>
<title>广西民族大学国家助学金申请表</title>
</head>
<style>
table{border-collapse:collapse;}
	td{
		border-style: solid;
	}
</style>
<body>
<h1>广西民族大学国家助学金申请表</h1>
<table width="1050" border="1">
  <tr>
    <td width="72" rowspan="5" style=" text-align:center;">本<br />人<br />情<br />况</td>
    <td width="118" height="28">姓名</td>
    <td width="190"><input class="easyui-textbox" type="text" name="xm" data-options="required:true" style="height:100%; width:188px;" /></td>
    <td width="103">性别</td>
    <td width="154"><select class="easyui-combobox" name="xb" required="true" editable="false" style="width:152px;height:100%;">   
				    <option value="1">男</option>   
				    <option value="2">女</option>     
				</select></td>
    <td width="101">出生年月</td>
    <td width="159"><div style="margin:auto; "><input name="csnyString" type= "text" class= "easyui-datebox" required ="required" editable="false" style="height:100%; width:158px;" /></div></td>
    <td width="101" rowspan="5">&nbsp;</td>
  </tr>
  <tr>
    <td height="28">民族</td>
    <td><input class="easyui-textbox" type="text" name="mz" data-options="required:true" style="height:100%;width:188px; " /></td>
    <td>政治面貌</td>
    <td><input class="easyui-textbox" type="text" name="zzmm" data-options="required:true" style=" width:152px;height:100%; " /></td>
    <td>学号</td>
    <td><input class="easyui-textbox" type="text" name="xh" data-options="required:true" style=" width:158px;height:100%; " /></td>
  </tr>
  <tr>
    <td height="28">身份证号码</td>
    <td><input class="easyui-textbox" type="text" name="sfzhm" data-options="required:true" style=" width:188px;height:100%; " /></td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>联系电话</td>
    <td><input class="easyui-textbox" type="text" name="lxdh" data-options="required:true" style=" width:158px;height:100%; " /></td>
  </tr>
  <tr>
    <td height="28">本人银行卡号</td>
    <td colspan="2"><input class="easyui-textbox" type="text" name="yhkh" data-options="required:true" style=" width:298px;height:100%; " /></td>
    <td>&nbsp;</td>
    <td>开户行名称</td>
    <td><input class="easyui-textbox" type="text" name="khhmc" data-options="required:true" style=" width:158px;height:100%; " /></td>
  </tr>
  <tr>
    <td height="28">学院</td>
    <td><select class="easyui-combobox" name="xy" required="true" editable="false" style="width:188px;height:100%;">   
				    <option value="1001">软件与信息安全学院</option>   
				    <option value="1002">信工学院</option>      
				</select></td>
    <td>专业</td>
    <td><select class="easyui-combobox" name="zy" required="true" editable="false" style="width:152px;height:100%;">   
				    <option value="2001">软件工程</option>   
				    <option value="2003">信息技术管理</option>   
				</select></td>
    <td>班级</td>
    <td><input class="easyui-textbox" type="text" name="bj" data-options="required:true" style=" width:158px;height:100%; " /></td>
  </tr>
</table>
<table width="1050" border="1">
  <tr>
    <td width="72" rowspan="3" style="text-align:center;">家<br />庭<br />经<br />济<br />情<br />况</td>
    <td width="118" height="32">家庭户口</td>
    <td colspan="2"><select id="cc" class="easyui-combobox" name="jthk" required="true" editable="false" style="width:188px;height:100%;">   
				    <option value="城镇">城镇</option>   
				    <option value="农村">农村</option>   
				</select></td>
    <td width="259">家庭人口总数</td>
    <td colspan="2"><input class="easyui-numberbox" type="text" name="jtrkzs" data-options="required:true" style=" width:158px;height:100%; " /></td>
  </tr>
  <tr>
    <td height="32">家庭月总收入</td>
    <td width="190"><input class="easyui-numberbox" type="text" name="jtysr" data-options="required:true,precision:2" style=" width:188px;height:100%; " /></td>
    <td width="103">人均月收入</td>
    <td><input class="easyui-numberbox" type="text" name="rjysr" data-options="required:true,precision:2" style=" width:147px;height:100%; " /></td>
    <td width="88">收入来源</td>
    <td width="171"><input class="easyui-textbox" type="text" name="srly" data-options="required:true" style=" width:170px;height:100%; " /></td>
  </tr>
  <tr>
    <td height="32">家庭住址</td>
    <td colspan="2"><input class="easyui-textbox" type="text" name="jtzz" data-options="required:true,multiline:true" style=" width:300px;height:100%; " /></td>
    <td>邮政编码</td>
    <td colspan="2"><input class="easyui-textbox" type="text" name="yzbm" data-options="required:true" style=" width:263px;height:100%; " /></td>
  </tr>
</table>
<table width="1050" border="1">
  <tr>
    <td width="72" rowspan="6" style=" text-align:center;">家<br />庭<br />成<br />员<br />情<br />况</td>
    <td width="261" height="30">姓名</td>
    <td width="230">年龄</td>
    <td width="225">与本人关系</td>
    <td width="228">工作或学习单位</td>
  </tr>
  <tr>
    <td height="30"><input class="easyui-textbox" type="text" name="xm1" style=" width:200px;height:100%; " /></td>
    <td><input class="easyui-textbox" type="text" name="nl1" style=" width:200px;height:100%; " /></td>
    <td><input class="easyui-textbox" type="text" name="ybrgx1" style=" width:200px;height:100%; " /></td>
    <td><input class="easyui-textbox" type="text" name="gzhxxdw1" style=" width:200px;height:100%; " /></td>
  </tr>
  <tr>
    <td height="30"><input class="easyui-textbox" type="text" name="xm2" style=" width:200px;height:100%; " /></td>
    <td><input class="easyui-textbox" type="text" name="nl2" style=" width:200px;height:100%; " /></td>
    <td><input class="easyui-textbox" type="text" name="ybrgx2" style=" width:200px;height:100%; " /></td>
    <td><input class="easyui-textbox" type="text" name="gzhxxdw2" style=" width:200px;height:100%; " /></td>
  </tr>
  <tr>
    <td height="30"><input class="easyui-textbox" type="text" name="xm3" style=" width:200px;height:100%; " /></td>
    <td><input class="easyui-textbox" type="text" name="nl3" style=" width:200px;height:100%; " /></td>
    <td><input class="easyui-textbox" type="text" name="ybrgx3" style=" width:200px;height:100%; " /></td>
    <td><input class="easyui-textbox" type="text" name="gzhxxdw3" style=" width:200px;height:100%; " /></td>
  </tr>
  <tr>
    <td height="30"><input class="easyui-textbox" type="text" name="xm4" style=" width:200px;height:100%; " /></td>
    <td><input class="easyui-textbox" type="text" name="nl4" style=" width:200px;height:100%; " /></td>
    <td><input class="easyui-textbox" type="text" name="ybrgx4" style=" width:200px;height:100%; " /></td>
    <td><input class="easyui-textbox" type="text" name="gzhxxdw4" style=" width:200px;height:100%; " /></td>
  </tr>
  <tr>
    <td height="30"><input class="easyui-textbox" type="text" name="xm5" style=" width:200px;height:100%; " /></td>
    <td><input class="easyui-textbox" type="text" name="nl5" style=" width:200px;height:100%; " /></td>
    <td><input class="easyui-textbox" type="text" name="ybrgx5" style=" width:200px;height:100%; " /></td>
    <td><input class="easyui-textbox" type="text" name="gzhxxdw5" style=" width:200px;height:100%; " /></td>
  </tr>
</table>
<table width="1050" border="1" height="40">
  <tr>
    <td width="816">申请等级（一等助学金或二等助学金）</td>
    <td width="234"><select id="cc" class="easyui-combobox" name="jthk" required="true" editable="false" style="width:180px;height:100%;">   
				    <option value="一等助学金">一等助学金</option>   
				    <option value="二等助学金">二等助学金</option>   
				</select></td>
  </tr>
</table>
<table width="1050" border="1">
  <tr>
    <td height="100">申请理由：<br><input class="easyui-textbox" type="text" name="sqly" data-options="multiline:true" style=" width:95%;height:70%; " /></td>
  </tr>
  <tr>
    <td height="100">班级评议意见：<br><input class="easyui-textbox" type="text" name="bjpyyj" data-options="multiline:true" style=" width:95%;height:70%; " />	</td>
  </tr>
  <tr>
    <td height="100">学院审核意见：<br><input class="easyui-textbox" type="text" name="xyshyj" data-options="multiline:true" style=" width:95%;height:70%; " /></td>
  </tr>
  
</table>
<br>
<a class="easyui-linkbutton" iconCls="icon-ok" onclick="submitOk('Y')">提交</a>
<a class="easyui-linkbutton" iconCls="icon-tip" onclick="submitOk('N')">保存</a>
</body>

</html>
