package com.wisco.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class MyRequestListener implements ServletRequestListener{

	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void requestInitialized(ServletRequestEvent event) {
		 HttpServletRequest request = (HttpServletRequest) event.getServletRequest();  
	        HttpSession session = request.getSession(true);//对应的session  
	        session.setAttribute("ip", request.getRemoteAddr());//记录ip地址  
	          
	        String uri = request.getRequestURI();  
	        String[] suffix = {".html",".do",".jsp",".action"};//指定后缀  
	          
	        for (int i = 0; i < suffix.length; i++) {  
	            if(uri.endsWith(suffix[i])){  
	                break;//程序继续运行  
	            }  
	            if(i ==suffix.length -1){  
	                return;//否则返回  
	            }  
	              
	        }  
	        Integer activeTimes = (Integer) session.getAttribute("activeTime");  
	        if(activeTimes == null){  
	            activeTimes = 0;  
	        }  
	        session.setAttribute("activeTimes", activeTimes+1);//更新访问次数  
	    }  
		

}
