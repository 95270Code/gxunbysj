 
        //设置修改密码
        function openPwd() {
            $('#w').window({
                title: '修改密码',
                width: 300,
                modal: true,
                shadow: true,
                closed: true,
                height:180,
                resizable:false
            });
        }
        //关闭修改密码
        function closePwd() {
            $('#w').window('close');
        }
        
      //设置登录窗口
        function openPersonMsg() {
            $('#personMsg').window({
                title: '个人信息',
                width: 500,
                modal: true,
                shadow: true,
                closed: true,
                height:260,
                resizable:false
            });
        }


        //修改密码
        function editPassword() {
        	var $oldPass = $('#txtOldPass');
            var $newpass = $('#txtNewPass');
            var $rePass = $('#txtRePass');
            
            if ($newpass.val() == '') {
                msgShow('系统提示', '请输入原始密码！', 'warning');
                return false;
            }
            
            if ($newpass.val() == '') {
                msgShow('系统提示', '请输入密码！', 'warning');
                return false;
            }
            if ($rePass.val() == '') {
                msgShow('系统提示', '请在一次输入密码！', 'warning');
                return false;
            }
            
            if ($newpass.val() == $oldPass.val()) {
                msgShow('系统提示', '新密码不能和旧密码相同！请重新输入', 'warning');
                return false;
            }

            if ($newpass.val() != $rePass.val()) {
                msgShow('系统提示', '两次密码不一至！请重新输入', 'warning');
                return false;
            }

            $.post('/gxunbysj/user/modifyPassword.do?oldpassword='+$oldPass.val()+'&newpassword=' + $newpass.val(), 
            	function(msg) {
            	if(msg.indexOf("1")>0){
            		 msgShow('系统提示', '恭喜，密码修改成功！5秒后返回重新登录界面', 'info');
                     setTimeout("location.href = 'doLogout.do'",5000);
            	}
            	if(msg.indexOf("2")>0){
           		    msgShow('系统提示', '数据库出错', 'info');          
            	}
            	if(msg.indexOf("3")>0){
           		    msgShow('系统提示', '初始密码错误', 'info');          
            	}
            	if(msg.indexOf("4")>0){
           		    msgShow('系统提示', '服务器出错', 'info');          
            	}                          
            });
            
        }

        $(function() {

            openPwd();
            openPersonMsg();
            $('#editpass').click(function() {
                $('#w').window('open');
            });
            
            $('#openPersonMsg').click(function() {
                $('#personMsg').window('open');
                $('#fm_msg').form('load','/gxunbysj/user/getPersonMsg.do'); 
            });


			$('#btnCancel').click(function(){closePwd();})
			
			$('#closePersonMsg').click(function(){
				$('#personMsg').window('close');
			})

            $('#loginOut').click(function() {
                $.messager.confirm('系统提示', '您确定要退出本次登录吗?', function(r) {

                    if (r) {
                        location.href = 'doLogout.do';
                    }
                });
            });
			/*==============================*/
			var width = parseInt($(window).width())/2;
			$('#box').datagrid({
				width : width,
				url : '/gxunbysj/gonggao/ggShowData.do',
				type:'post',
				iconCls : 'icon-search',
				striped : true,  //黑白交接显示
				loadMsg : '正在玩命加载中...',
				rownumbers : true,   //显示序号
				nowrap : true,
				singleSelect : true, //只能选中一行
				fitColumns : true,
				columns : [[
					{
						field : 'bt',
						title : '标题',
						sortable : true,
						align : 'center',
						width : 200,
						formatter: function(value,row,index){
							var bt = row.bt;
							var bh = row.bh;
							var nr = row.nr;
							return '<a href="#" onclick="tc(\''+nr+'\',\''+bt+'\')" style="color:#000000; font-weight:900;">'+bt+'</a>  '	
						},
					},
					
					
					{
						field : 'fbsj',
						title : '发布时间',
						sortable : true,
						align : 'center',
						width : 100,
					},
				]],
				pagination : true,
				pageSize : 10,
				pageList : [10,20,30],
				remoteSort : false,
				rownumbers:true,
				sortOrder : 'DESC',	
				queryParams : {
					id : 1,
				}
			});
			
			/*==============================*/
        });
        
        function tc(nr,bt){
        	$('#dd').dialog({    
        	    title: bt,    
        	    width: 400,    
        	    height: 200,    
        	    closed: false,    
        	    cache: false,    
        	    content:'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'+nr,
        	    modal: true   
        	});   
        }
        
		