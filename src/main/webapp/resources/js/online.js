changeTheme = function(themeName){
		var $easyuiTheme = $("#easyuiTheme");
		var url = $easyuiTheme.attr("href");
		var href = url.substring(0, url.indexOf('themes')) + 'themes/' + themeName + '/easyui.css';
		$easyuiTheme.attr('href', href);
		var $iframe = $('iframe');
		if ($iframe.length > 0) {
			for ( var i = 0; i < $iframe.length; i++) {
				var ifr = $iframe[i];
				$(ifr).contents().find('#easyuiTheme').attr('href', href);
			}
		}
		$.cookie('easyuiThemeName', themeName, {
			expires : 7
		});
	};
	if($.cookie('easyuiThemeName')){  
	    changeTheme($.cookie('easyuiThemeName'));  
	}
	
	function rowformatter(value , row , index){
		return '<a href="javascript:void(0)" onclick="unline('+ index +')">下线</a>';
	}
	
	function unline(index){
		$("#ManagerList").datagrid('selectRow' , index);
		var row = $("#ManagerList").datagrid('getSelected');
		$("#ManagerList").datagrid('deleteRow' , index);
		$.ajax({
			url :'./admin/dropin.do',
			data:{
	               user : row.user,
	        },
	        type:"post",
	        dataType:"json",
	        success:function(result){
	        	alert(result);
	        }
		});
	}