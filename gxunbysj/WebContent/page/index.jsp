<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
  String path = request.getContextPath();
  request.setAttribute("path", path);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head id="Head1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>项目管理系统</title>
    <link href="<%=path %>/css/default.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" type="text/css" href="<%=path %>/jquery-easyui-1.5/themes/icon.css" />
    <link rel="stylesheet" type="text/css" href="<%=path %>/jquery-easyui-1.5/themes/default/easyui.css" />
    <script type="text/javascript" src="<%=path %>/jquery-easyui-1.5/jquery.min.js"></script>
    <script type="text/javascript" src="<%=path %>/jquery-easyui-1.5/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="<%=path %>/js/outlook2.js"></script>
    <script type="text/javascript" src="<%=path %>/js/index.js"></script>
    </head>
    <body class="easyui-layout" style="overflow-y: hidden" scroll="no" >
<noscript>
    <div style=" position:absolute; z-index:100000; height:2046px;top:0px;left:0px; width:100%; background:white; text-align:center;"> <img src="images/noscript.gif" alt='抱歉，请开启脚本支持！' /> </div>
    </noscript>
<div region="north" split="true" border="false" style="overflow: hidden; height: 40px;
        background: url(<%=path %>/images/layout-browser-hd-bg.gif) #7f99be repeat-x center 50%;
        line-height: 20px;color: #fff; font-family: Verdana, 微软雅黑,黑体"> 
   <c:if test="${sessionScope.user!=null}" var="result" scope="session">     
        <span style="float:right; padding-right:20px; position:relative; top:10px;" class="head">欢迎 ${sessionScope.user.s_name } 
	        <a href="#" id="editpass">修改密码</a> 
	        <a href="#" id="loginOut">安全退出</a>
        </span>
   </c:if>      
        <span style="padding-left:10px;position:relative;top:5px; font-size:20px; ">
        	<img src="<%=path %>/images/blocks.gif" width="20" height="20" align="absmiddle" /> 奖助学金申请管理系统
        </span>
</div>


<div region="south" split="true" style="height: 30px; background: #D2E0F2; ">
      <div class="footer">版权所有，翻版必究</div>
    </div>
<div region="west" hide="true" split="true" title="导航菜单" style="width:180px;" id="west">
      <div id="nav" class="easyui-accordion" fit="true" border="false"> 
    <!--  导航内容 --> 
    
  </div>
    </div>
<div id="mainPanle" region="center" style="background: #eee; overflow-y:hidden">
      <div id="tabs" class="easyui-tabs"  fit="true" border="false" >
    <div title="欢迎使用" style="padding:20px;overflow:hidden; color:red; " >
          <h1 style="font-size:24px;">欢迎使用项目管理系统</h1>
        </div>
  </div>
    </div>
<div region="east" title="日历" split="true" style="width:180px;overflow:hidden;">
      <div class="easyui-calendar"></div>
    </div>

<!--修改密码窗口-->
<div id="w" class="easyui-window" title="修改密码" collapsible="false" minimizable="false"
        maximizable="false" icon="icon-save"  style="width: 300px; height:180px;  padding: 5px;
        background: #fafafa;">
      <div class="easyui-layout" fit="true">
    <div region="center" border="false" style="padding: 10px; background: #fff; border: 1px solid #ccc;">
      <table cellpadding=3>
          
        <tr>
              <td>原始密码：</td>
              <td><input id="txtOldPass" type="password" class="txt01" /></td>
        </tr>

        <tr>
              <td>新密码：</td>
              <td><input id="txtNewPass" type="password" class="txt01" /></td>
        </tr>
        <tr>
              <td>确认密码：</td>
              <td><input id="txtRePass" type="password" class="txt01" /></td>
        </tr>
      </table>
        </div>
    <div region="south" border="false" style="text-align: right; height: 30px; line-height: 30px;"> <a id="btnEp" class="easyui-linkbutton" onclick="editPassword()" icon="icon-ok" href="javascript:void(0)" > 确定</a> <a id="btnCancel" class="easyui-linkbutton" icon="icon-cancel" href="javascript:void(0)">取消</a> </div>
  </div>
    </div>
<div id="mm" class="easyui-menu" style="width:150px;">
      <div id="mm-tabupdate">刷新</div>
      <div class="menu-sep"></div>
      <div id="mm-tabclose">关闭</div>
      <div id="mm-tabcloseall">全部关闭</div>
      <div id="mm-tabcloseother">除此之外全部关闭</div>
      <div class="menu-sep"></div>
      <div id="mm-tabcloseright">当前页右侧全部关闭</div>
      <div id="mm-tabcloseleft">当前页左侧全部关闭</div>
      <div class="menu-sep"></div>
      <div id="mm-exit">退出</div>
    </div>
</body>

<script type="text/javascript">
var _menus = {
        "menus":[
		           {"menuid":"1","icon":"icon-sys","menuname":"项目修改",
			      "menus":[
			    	<c:if test="${user.qx>=3}" var="result" scope="session">
			    	  {"menuid":"12","menuname":"用户管理","icon":"icon-page","url":"${path}/user/showUserList.do"},
					</c:if>  
					{"menuid":"13","menuname":"填写申请奖助学金","icon":"icon-class","url":"${path}/page/form/sqbxz.jsp"},
					{"menuid":"14","menuname":"申请表查询","icon":"icon-role","url":"${path}/page/form/sqbcx.jsp"},
					{"menuid":"15","menuname":"代办任务","icon":"icon-set","url":"demo.html"},
					{"menuid":"16","menuname":"菜单","icon":"icon-log","url":"demo1.html"}
				    ]},
		/* {"menuid":"8","icon":"icon-sys","menuname":"项目设计",
			"menus":[{"menuid":"21","menuname":"项目分析","icon":"icon-nav","url":"menu2/tree2.html"},
					{"menuid":"22","menuname":"菜单","icon":"icon-nav","url":"demo1.html"}
				]
		},{"menuid":"56","icon":"icon-sys","menuname":"菜单",
			"menus":[{"menuid":"31","menuname":"菜单","icon":"icon-nav","url":"demo1.html"},
					{"menuid":"32","menuname":"菜单","icon":"icon-nav","url":"demo2.html"}
				]
		},{"menuid":"28","icon":"icon-sys","menuname":"菜单",
			"menus":[{"menuid":"41","menuname":"菜单","icon":"icon-nav","url":"demo.html"},
					{"menuid":"42","menuname":"菜单","icon":"icon-nav","url":"demo1.html"},
					{"menuid":"43","menuname":"菜单","icon":"icon-nav","url":"demo2.html"}
				]
		},{"menuid":"39","icon":"icon-sys","menuname":"菜单",
			"menus":[{"menuid":"51","menuname":"菜单","icon":"icon-nav","url":"demo.html"},
					{"menuid":"52","menuname":"菜单","icon":"icon-nav","url":"demo1.html"},
					{"menuid":"53","menuname":"菜单","icon":"icon-nav","url":"demo2.html"}
				]
		} */
]};
</script>
</html>