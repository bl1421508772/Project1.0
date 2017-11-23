package com.wisco.listener;

import java.util.Date;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.wisco.entity.ApplicationConstants;

public class MySessionListener implements HttpSessionListener , HttpSessionAttributeListener {
	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		 if(event.getName().equals("user")){  
	            ApplicationConstants.CURRENT_LOGIN_COUNT++;  
	            HttpSession session = event.getSession();  
	            //查找该账号有么有在其他机器上登录  
	            for (HttpSession sess : ApplicationConstants.SESSION_MAP.values()) {  
	                //如果该账号已经在其他机器上登录了，则以前的登录失效  
	                if(event.getValue().equals(sess.getAttribute("user")) && session.getId()!= sess.getId()){  
	                    sess.invalidate();//使session失效  
	                }  
	            }  
	        }  
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		 // 移除属性时被调用  
        if(event.getName().equals("user")){  
            ApplicationConstants.CURRENT_LOGIN_COUNT--;  
        }  
		
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		 // 修改属性时被调用  
        if(event.getName().equals("user")){  
            HttpSession session = event.getSession();  
            //查找该账号有么有在其他机器上登录  
            for (HttpSession sess : ApplicationConstants.SESSION_MAP.values()) {  
                //如果该账号已经在其他机器上登录了，则以前的登录失效  
                if(event.getValue().equals(sess.getAttribute("user")) && session.getId()!= sess.getId()){  
                    sess.invalidate();//使session失效  
                }  
            }  
        }  
	}
	@Override
	public void sessionCreated(HttpSessionEvent event) {
		//Session创建时被调用  
        HttpSession session = event.getSession();  
        ApplicationConstants.SESSION_MAP.put(session.getId(), session);//保存session  
        ApplicationConstants.TOTAL_HISTORY_COUNT++;//访问人数增加  
        //如果当前在线人数超过历史记录  
        if(ApplicationConstants.SESSION_MAP.size()>ApplicationConstants.MAX_ONLINE_COUNT){  
            ApplicationConstants.MAX_ONLINE_COUNT = ApplicationConstants.SESSION_MAP.size();//更新最大在线人数  
            ApplicationConstants.MAX_ONLINE_COUNT_DATE = new Date();//更新时间  
        }  
	}
	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		//session被销毁时调用  
        HttpSession session = event.getSession();  
        ApplicationConstants.SESSION_MAP.remove(session.getId());//移除session记录  
		
	}

}
