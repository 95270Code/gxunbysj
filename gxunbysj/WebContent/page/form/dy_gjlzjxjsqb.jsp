<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>无标题文档</title>
</head>
<style>

	table{border-collapse:collapse;}
	td{
		border-style: solid;
	}
</style>

<body>
<h1>广西民族大学国家励志奖学金申请表<OBJECT id="WebBrowser1" height=0 width=0 classid=CLSID:8856F961-340A-11D0-A96B-00C04FD705A2 name=wb></OBJECT>
<input type="button" value="打印" onclick="print()" id="a1"/><input type="button" value="打印预览" id="a2" onclick="printPreivew()"/>  
</h1>
<table width="1000" border="1">
	  <tr>
	    <td width="87" rowspan="7">个人情况</td>
	    <td width="106" height="50">姓名</td>
	    <td width="136">${sqb.xm }</td>
	    <td width="46">性别</td>
	    <td width="110">${sqb.xb }</td>
	    <td width="104">出生年月</td>
	    <td width="240">${sqb.csny }</td>
	    <td width="119" rowspan="6">&nbsp;</td>
  </tr>
	  <tr>
	    <td height="48">民族</td>
	    <td>${sqb.mz }</td>
	    <td>政治面貌</td>
	    <td>${sqb.zzmm }</td>
	    <td>学号</td>
	    <td>${sqb.xh }</td>
  </tr>
	  <tr>
	    <td height="35">身份证号码</td>
	    <td colspan="3">${sqb.sfzhm }</td>
	    <td>联系电话</td>
	    <td>${sqb.lxdh }</td>
  </tr>
	  <tr>
	    <td rowspan="2">发奖学金银行账号</td>
	    <td height="60">本人银行卡号</td>
	    <td colspan="4">${sqb.yhkh }</td>
  </tr>
	  <tr>
	    <td height="57">开户行名称</td>
	    <td colspan="4">${sqb.khhmc }</td>
  </tr>
	  <tr>
	    <td height="43">学院</td>
	    <td>${sqb.xy }</td>
	    <td>年级</td>
	    <td>${sqb.nj }</td>
	    <td>专业</td>
	    <td>${sqb.zy }</td>
  </tr>
	  <tr>
	    <td height="110">曾获何种奖励</td>
	    <td colspan="6">${sqb.chhzjl }</td>
  </tr>
</table>
<table width="1000" border="1">
  <tr>
    <td width="87" rowspan="3"><p align="center">家庭 <br />
      经济情况</p></td>
    <td width="185">家庭户口</td>
    <td colspan="3">${sqb.jthk }</td>
    <td width="154">家庭人口总数</td>
    <td width="120">${sqb.jtrkzs }</td>
  </tr>
  <tr>
    <td>家庭月总收入</td>
    <td width="136">${sqb.jtysr }</td>
    <td width="136">人均月收入</td>
    <td width="136">${sqb.rjysr }</td>
    <td>收入来源</td>
    <td>${sqb.srly }</td>
  </tr>
  <tr>
    <td>家庭住址</td>
    <td colspan="3">${sqb.jtzz }</td>
    <td>邮政编码</td>
    <td>${sqb.yzbm }</td>
  </tr>
</table>
<table width="1000" height="211" border="1">
  <tr>
    <td width="87" rowspan="4">学习情况</td>
    <td width="185" height="48">该学年学习课程数</td>
    <td width="137">${sqb.kcs }</td>
    <td width="86">其中平均成绩</td>
    <td width="116">${sqb.pjf }</td>
    <td width="108">最低成绩</td>
    <td width="109">${sqb.zdcj }</td>
    <td width="120">&nbsp;</td>
  </tr>
  <tr>
    <td height="36">成绩排名（名次/总人数）</td>
    <td colspan="2">${sqb.cjpm }/${sqb.bjzrs }</td>
    
    <td>综合测评排名<u>(</u>名次/总人数）</td>
    <td colspan="2">${sqb.zhcppm }/${sqb.cpzrs }</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td height="48">英语过级情况</td>
    <td colspan="2">${sqb.yygjqk }</td>
    <td>计算机等级情况</td>
    <td colspan="2">${sqb.jsjdjqk }</td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td height="55">其他考证</td>
    <td colspan="6"></td>
  </tr>
</table>
<table width="1000" border="1">
  <tr>
    <td height="78">申请理由</td>
    <td>${sqb.sqly }</td>
  </tr>
  <tr>
    <td height="78"><p>班级推荐意见</p></td>
    <td>${sqb.bjtjyj }</td>
  </tr>
  <tr>
    <td width="87" height="78"><p>学院审核意见</p></td>
    <td width="897">${sqb.xyshyj }</td>
  </tr>
</table>
</body>
<script>
//打印  
    function print(){  
    	hidden();
        document.getElementById("WebBrowser1").execWB(6,1); 
        visable();
    }  
    //打印预览  
    function printPreivew(){  
    	hidden();  
        document.getElementById("WebBrowser1").execWB(7,1);
        visable();
    } 
    
    function hidden(){
    	var a1 = document.getElementById("a1");
		var a2 = document.getElementById("a2");
		a1.style.display = "none";
		a2.style.display = "none";
		
    }
    function visable(){
    	var a1 = document.getElementById("a1");
		var a2 = document.getElementById("a2");
		a1.style.display = "block";
		a2.style.display = "block";
    }
</script>
</html>