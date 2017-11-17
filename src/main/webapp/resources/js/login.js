$(function(){
   $("#sign").click(function(){
       $.ajax({
           url:"./admin/sign.do",
           data:{
               username: $("input[name=username]").val(),
               password: $("input[name=password]").val()
           },
           type:"post",
           dataType:"json",
           success:function(result){
               if(result){
            	   window.location.href="./pages/admin/MainFrame.jsp";
            	   $("#tip").text();
               } else {
            	   $("#tip").text("账户或者密码错误");
            	   $("input[name=username]").val("");
                   $("input[name=password]").val("");
               }
           }
       });
   });
   $("#reset").click(function(){
	   $("input[name=username]").val("");
       $("input[name=password]").val("");
   });
})

