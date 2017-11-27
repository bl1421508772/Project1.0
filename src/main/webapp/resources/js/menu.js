var tree_node = "";
$(function(){
	$("#tt2").tree("expandAll");
	$("#tt2").tree({
		url:"./admin/tree.do",
		animate: false,
		onContextMenu:function(e , node){
			e.preventDefault();  //阻止右键默认事件  
			var root = $('#tt2').tree('getParent', node.target)//判断该结点有没有父结点
			if(root == null){
				 $('#parentNode').menu('show', {    
                     left: e.pageX,    
                     top: e.pageY    
                 }); 
			}
			var leaf = $('#tt2').tree('isLeaf', node.target);  
            var parentOne = $('#tt2').tree('getParent', node.target);  
            if(leaf && parentOne != null){//本项目要求tree只有2层,若此时条件成立，说明已经是最底层（第三层），右键菜单去除添加节点  
                $('#leaf').menu('show', {    
                       left: e.pageX,    
                       top: e.pageY    
                   });  
           }else{//此时说明还可以添加子节点  
                $('#parentNode').menu('show', {    
                       left: e.pageX,    
                       top: e.pageY    
                   });  
           } 
           
		},
		onClick: function(node) { 
			var text = node.text;
			tree_node = node.parentId;
            //判断是否是子节点false父节点，true子节点
            var childrenNode = $("#tt2").tree('isLeaf', node.target);
            //获取根节点
            var rootNode = $("#tt2").tree("getRoots");
            //获取点击的父节点
            var parentNode = $(this).tree("getParent", node.target)
            //防止循环;
            if(!childrenNode && (null == parentNode)){ //判断是父节点
            	for (var i = 0; i < rootNode.length; i++) {
					if (node.text != rootNode[i].text) {
						$("#tt2").tree("collapse",
								rootNode[i].target);
					}
				}
            };
            
            /* 点击展开或折叠 */
			if (node.state == "closed") {
				$(this).tree("expand", node.target);
				node.state = "open";
			} else {
				$(this).tree("collapse", node.target);
				node.state = "closed";
			};
			$("input[name=mName]").val(node.text);
			$("input[name=url]").val(node.erl);
			$("input[name=icon]").val(node.iconCls);
			$("input[name=url]").val(node.url);
			if(childrenNode){
				//alert(childrenNode);
				$("#cD").attr("checked",'false');
				$("#hM").attr("checked",'checked');
			} else{
				$("#hM").attr("checked",'false');
				$("#cD").attr("checked",'checked');
			}
			$("input[name=mName]").blur(function(){
				var selectedNode = $("#tt2").tree("getSelected");
				$value = $("input[name=mName]").val()
				selectedNode.text = $("input[name=mName]").val();
				$("#tt2").tree('update' , {
					target: selectedNode.target,
				　　　text:$value,
				});
			});
		}
	});
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
	$("#icno_iconCls").click(function(){
		$('#win').window('open');
	});
    $("#icno_save").click(function(){
    	$mName = $("input[name=mName]").val();
    	$url = $("input[name=url]").val();
    	$icon = $("input[name=icon]").val();
    	$demo = $("input[name=demo]").val();
    	$state = $("input[name=type]:checked").val();  
    	alert($mName + ":" +$url + ":" + $icon + ":" + tree_node + ":" + $state);
    	$.ajax({
    		url:'./admin/saveMenu.do';
    		type:'post',
    		dataType:'json',
    		data:{
    			text:$mName,
    			state:($state == 'hm'?'open':'closed'),
    			parentId:tree_node,
    			iconCls:$icon,
    			url:$url
    		}
    		success:function(result){
    			alert(result)
    		}
    	});
    });
    
    
});

function icon(result){
	var iconCls = "icon-"+result.split(".")[0];
	$("input[name=icon]").val(iconCls);
	var selectedNode = $("#tt2").tree("getSelected");
	$("#tt2").tree('update' , {
		target: selectedNode.target,
	　　　iconCls:iconCls,
	});
	$('#win').window('close');
}

function addRootNode(){
	var tree = $("#tt2");
	var node = tree.tree("getSelected")
	$('#tt2').tree('append', {
	        parent:0,
	        data:{
	        	 text: '',
	             id : 0,
	             parentId : 0
	        }

	});
}

function addChildNode(){
	var tree = $("#tt2");
	var node = tree.tree("getSelected");
	$('#tt2').tree('append', {
	        parent:node.target,
	        data:{
	        	 text:'' ,
	             id : 0,
	             parentId : node.id
	        }

	});
}

