var newOredit = "";
$(function () {
	obj = {
			search : function () {
				$('#box').datagrid('load', {
					searchId : $('input[name="searchId"]').val(),
					searchName : $.trim($('input[name="searchName"]').val()),
					date_from : $('input[name="date_from"]').val(),
					date_to : $('input[name="date_to"]').val(),
				});
			},
			
			newUser : function () {
				$('#dlg').dialog('open').dialog('center').dialog('setTitle','新添用户');
	            $('#fm').form('clear');
	            newOredit ="new";
	            //url = 'save_user.php';
			},
			
			saveUser : function (){
				$.messager.progress(); // 显示进度条
				var s_id = $('input[name="s_id"]').val();
				var s_name = $('input[name="s_name"]').val();
				var s_password = $('input[name="s_password"]').val();
				var s_sex = $('input[name="s_sex"]').val();
				var s_academy = $('input[name="s_academy"]').val();
				var s_class = $('input[name="s_class"]').val();
				var s_grade = $('input[name="s_grade"]').val();
				var newOrEdit = newOredit;
				$('#fm').form('submit',{
					 	url:"saveUser.do",
		                onSubmit: function(param){
		                	param.s_id;
		                	param.s_name;
		                	param.s_password;
		                	param.s_sex;
		                	param.s_academy;
		                	param.s_class;
		                	param.s_grade;
		                	param.newOrEdit = newOrEdit;
		                	var isValid = $(this).form('validate');
		            		if (!isValid){
		            			$.messager.progress('close');	// 如果表单是无效的则隐藏进度条
		            		}
		            		return isValid;
		                },
		                success: function(result){
		                    //var result = eval('('+result+')');
		                    if (result=="false"){
		                    	$.messager.alert('消息','失败');
		                    	$.messager.progress('close');
		                    } else {
		                    	$.messager.progress('close');	// 如果提交成功则隐藏进度条
		                    	$.messager.alert('消息','成功'); 
		                        $('#dlg').dialog('close');        // close the dialog
		                        $('#box').datagrid('reload');    // reload the user data
		                    }
		                }
		        });
			},		
			cancle :function (){
				$('#dlg').dialog('close');
			},
			
		    editUser : function(){
	            var row = $('#box').datagrid('getSelected');
	            newOredit="edit";
	            if (row){
	                $('#dlg').dialog('open').dialog('center').dialog('setTitle','编辑用户信息');
	                $('#fm').form('load',row);
	                //url = 'DataController?id='+row.id;
	            }
	        },
	        
	        deleteUser : function (){
	        	var row = $('#box').datagrid('getSelected');
	        	$.messager.confirm('确认','您确认想要删除记录吗？',function(r){    
	        	    if (r){    
	        	    	$.ajax({
	        				url:'deleteUser.do',
	        				type:'post',
	        				data:{s_id:row.s_id},
	        				success: function (result) {
	        					if(result=="true"){
	        						$.messager.alert('消息','删除成功');
	        						$('#box').datagrid('reload'); 
	        					}
	        				}
	        			});    
	        	    }    
	        	});  
	        },
		};
	
	
	$('#box').datagrid({
		width : 1200,
		url : 'show.do',
		type:'post',
		title : '用户列表',
		iconCls : 'icon-search',
		striped : true,  //黑白交接显示
		loadMsg : '正在玩命加载中...',
		rownumbers : true,   //显示序号
		nowrap : true,
		singleSelect : true, //只能选中一行
		fitColumns : true,
		rowStyler : function (index,row) {
			if (row.s_id == '000') {
				//这里返回的也可以是CSS的class名称
				return 'background-color:orange';
			}
		},
		columns : [[
			{
				field : 's_id',
				title : '学号',
				sortable : true,
				
				align : 'center',
				width : 100,
			},
			{
				field : 's_name',
				title : '学生姓名',
				sortable : true,
				/*fixed : true,*/
				align : 'center',
				width : 100,			
			},
			{
				field : 's_password',
				title : '密码',
				sortable : true,				
				align : 'center',
				width : 100,
			},
			{
				field : 's_sex',
				title : '性别',
				sortable : true,				
				align : 'center',
				width : 100,
			},
			{
				field : 's_academy',
				title : '学院',
				sortable : true,
				align : 'center',
				width : 100,			
			},
			{
				field : 's_major',
				title : '专业',
				sortable : true,
				align : 'center',
				width : 100,			
			},
			{
				field : 's_class',
				title : '班级',
				sortable : true,
				align : 'center',
				width : 100,			
			},
			{
				field : 's_grade',
				title : '年级',
				sortable : true,
				align : 'center',
				width : 100,			
			},
			
			{
				field : 'update_time',
				title : '更新时间',
				sortable : true,
				/*fixed : true,*/
				align : 'center',
				width : 100,
			},
		]],
		toolbar : '#tb',
		pagination : true,
		pageSize : 10,
		pageList : [10,20,30],
		remoteSort : false,
		sortOrder : 'DESC',	
		queryParams : {
			id : 1,
		}
	});
	
});