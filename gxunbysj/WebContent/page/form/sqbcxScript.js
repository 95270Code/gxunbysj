var path ;
function init(a){
	path = a;
	$('#sqbcxbg').datagrid({
		width : 1300,
		url : path+"/jzxj/submitQuery.do",
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
				field : 'sqbbh',
				title : '申请表编号',
				sortable : true,
				
				align : 'center',
				width : 100,
			},
			{
				field : 'xm',
				title : '学生姓名',
				sortable : true,
				/*fixed : true,*/
				align : 'center',
				width : 100,			
			},
			{
				field : 'xb',
				title : '性别',
				sortable : true,				
				align : 'center',
				width : 100,
			},
			{
				field : 'xh',
				title : '学号',
				sortable : true,				
				align : 'center',
				width : 100,
			},
			{
				field : 'xy',
				title : '学院',
				sortable : true,
				align : 'center',
				width : 100,			
			},
			{
				field : 'zy',
				title : '专业',
				sortable : true,
				align : 'center',
				width : 100,			
			},
			
			{
				field : 'nj',
				title : '年级',
				sortable : true,
				align : 'center',
				width : 100,			
			},
			{
				field : 'sfqrtj',
				title : '状态',
				sortable : true,
				/*fixed : true,*/
				align : 'center',
				width : 100,
			},
			
			{
				field : 'scsj',
				title : '创建时间',
				sortable : true,
				/*fixed : true,*/
				align : 'center',
				width : 100,
			},
			
			{
				field : 'cz',
				title : '操作',
				sortable : true,
				align : 'center',
				width : 100,
				formatter: function(value,row,index){
					var sqbbh1 = row.sqbbh;
					if(row.sfqrtj=="未提交")
						return '<a href="#" onclick="tz(\''+sqbbh1+'\',1)" style="color:red;">编辑</a>  '	
					else						
						return '<a href="#" onclick="tz(\''+sqbbh1+'\',2)" style="color:blue;">查看</a>  '	
				},
			},
			
		]],
		pagination : true,
		pageSize : 10,
		pageList : [10,20,30],
		remoteSort : false,
		sortOrder : 'DESC',	
		queryParams : {
			
		}
	});
}

/**
 * 搜索，查询
 * @returns
 */
function cx(){
	$('#sqbcxbg').datagrid('load', {
		sqblx : $('input[name="sqblx"]').val(),
		searchXh : $('input[name="searchXh"]').val(),
		searchXm : $('input[name="searchXm"]').val(),
		date_from : $('input[name="date_from"]').val(),
		date_to : $('input[name="date_to"]').val(),
		sfqrtj : $('input[name="sfqrtj"]').val(),
		bjyj : $('input[name="bjyj"]').val(),
		xyyj : $('input[name="xyyj"]').val(),
	});
}


/**
 * 跳转
 * @param sqbbh
 * @returns
 */
function tz(sqbbh,flag){
	var sqblx = $('input[name="sqblx"]').val()
	alert(sqbbh+","+flag);
	if(flag==1)
		addTab("申请表详情",path+"/page/form/gjlzjxjsqbCkbc.jsp?sqbbh="+sqbbh+"&sqblx="+sqblx);
	if(flag==2)
		addTab("申请表详情",path+"/page/form/gjlzjxjsqbCk.jsp?sqbbh="+sqbbh+"&sqblx="+sqblx);
}


function addTab(subtitle,url){
	var jq = top.jQuery;
	if(!jq('#tabs').tabs('exists',subtitle)){
		jq('#tabs').tabs('add',{
			title:subtitle,
			content:createFrame(url),
			closable:true,
		});
	}else{
		$('#tabs').tabs('select',subtitle);
		$('#mm-tabupdate').click();
	}
}

function createFrame(url)
{
	var s = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:100%;"></iframe>';
	return s;
}

