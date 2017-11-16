$(function(){
   $("#sign").click(function(){
	   alert(1);
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
            	   alert(result);
            	   $("#tip").text("账户或者密码错误");
               }
           }
       });
   }); 
})
