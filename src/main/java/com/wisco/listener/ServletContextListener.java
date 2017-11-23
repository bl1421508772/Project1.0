package com.wisco.listener;

import java.util.Date;

import javax.servlet.ServletContextEvent;

import com.wisco.entity.ApplicationConstants;

public class ServletContextListener implements javax.servlet.ServletContextListener{

	//服务器启动时调用
	public void contextDestroyed(ServletContextEvent arg0) {
		 ApplicationConstants.START_DATE = new Date();//记录启动时间
	}

	//服务器关闭时调用
	public void contextInitialized(ServletContextEvent arg0) {
        ApplicationConstants.START_DATE = null;//清空结果，也可以保存  
          
        ApplicationConstants.MAX_ONLINE_COUNT_DATE = null;  
		
	}

}
