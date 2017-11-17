$(function(){
	$("#tabs").tabs({
		fit:true
	});
	$("#tt").tree({
		url:"./admin/tree.do",
		animate: false,  
		onClick: function(node) {  
			 	var text = node.text;
	            //判断是否是子节点false父节点，true子节点
	            var childrenNode = $("#tt").tree('isLeaf', node.target);
	            //获取根节点
	            var rootNode = $("#tt").tree("getRoots");
	            //获取点击的父节点
	            var parentNode = $(this).tree("getParent", node.target)
	            //防止循环;
	            if(!childrenNode && (null == parentNode)){ //判断是父节点
	            	for (var i = 0; i < rootNode.length; i++) {
						if (node.text != rootNode[i].text) {
							$("#tt").tree("collapse",
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
				}
				var isPanel = $("#tabs").tabs("exists", text);//判断是否存在该选项卡
				if(childrenNode){
					if(isPanel){ //如果存在当前页面，直接跳转当前页面
						$("#tabs").tabs("select", text);
					} else { //不存当前页面的时候 ,添加新的panel
						$("#tabs").tabs("add" , {
							title : text ,
							closable:true,
							iconCls : node.iconCls,
							content : '<iframe  frameborder="0" style="width:90%;height:77%" src="'+ node.url + '"></iframe>'
						});
					}
				}
	        },
		onLoadSuccess: function(data) {  
            //alert("加载成功！");  
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
	
	  showTime();
})

function showTime() {
            var date = new Date();
            var year = date.getFullYear();
            var month = date.getMonth() + 1;
            var day = date.getDate();
            var hour = date.getHours();
            var min = date.getMinutes();
            var sec = date.getSeconds();
            var week = date.getDay();
            var wks = ["星期日","星期一","星期二","星期三","星期四","星期五","星期六"];
            $("#currentTime").html(year + "年" + month + "月" + day + "日   " + hour + ":" + min + ":" + sec+"    "+wks[week]);
            setTimeout("showTime()",1000);
        }