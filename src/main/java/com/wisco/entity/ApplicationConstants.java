package com.wisco.entity;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

public class ApplicationConstants {
	 	public static Map<String,HttpSession> SESSION_MAP = new HashMap<String,HttpSession>();//索引所有的session  
      
	    public static int CURRENT_LOGIN_COUNT = 0;//当前登录的用户总数  
	      
	    public static int TOTAL_HISTORY_COUNT = 0;//历史访客总数  
	      
	    public static Date START_DATE = new Date();//服务器启动事件  
	      
	    public static Date MAX_ONLINE_COUNT_DATE = new Date();//最高在线时间  
	      
	    public static int MAX_ONLINE_COUNT = 0;//最高在线人数  

		public static Map<String, HttpSession> getSESSION_MAP() {
			return SESSION_MAP;
		}

		public static void setSESSION_MAP(Map<String, HttpSession> sESSION_MAP) {
			SESSION_MAP = sESSION_MAP;
		}

		public static int getCURRENT_LOGIN_COUNT() {
			return CURRENT_LOGIN_COUNT;
		}

		public static void setCURRENT_LOGIN_COUNT(int cURRENT_LOGIN_COUNT) {
			CURRENT_LOGIN_COUNT = cURRENT_LOGIN_COUNT;
		}

		public static int getTOTAL_HISTORY_COUNT() {
			return TOTAL_HISTORY_COUNT;
		}

		public static void setTOTAL_HISTORY_COUNT(int tOTAL_HISTORY_COUNT) {
			TOTAL_HISTORY_COUNT = tOTAL_HISTORY_COUNT;
		}

		public static Date getSTART_DATE() {
			return START_DATE;
		}

		public static void setSTART_DATE(Date sTART_DATE) {
			START_DATE = sTART_DATE;
		}

		public static Date getMAX_ONLINE_COUNT_DATE() {
			return MAX_ONLINE_COUNT_DATE;
		}

		public static void setMAX_ONLINE_COUNT_DATE(Date mAX_ONLINE_COUNT_DATE) {
			MAX_ONLINE_COUNT_DATE = mAX_ONLINE_COUNT_DATE;
		}

		public static int getMAX_ONLINE_COUNT() {
			return MAX_ONLINE_COUNT;
		}

		public static void setMAX_ONLINE_COUNT(int mAX_ONLINE_COUNT) {
			MAX_ONLINE_COUNT = mAX_ONLINE_COUNT;
		}
	    
	    
}
