/**
 * Project Name:teacherwork
 * File Name:EncodFilter.java
 * Package Name:cn.java.felter
 * Date:2017年3月25日上午10:57:57
 * Copyright (c) 2017, bluemobi All Rights Reserved.
 *
 */

package com.wisco.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Description: <br/>
 * Date: 2017年3月25日 上午10:57:57 <br/>
 * 
 * @author baoL
 * @version
 * @see
 */
public class EncodFilter implements Filter {

    public void destroy() {
    }

    public void doFilter(ServletRequest ServletRequest, ServletResponse ServletResponse, FilterChain arg2) throws IOException,
            ServletException {
    	ServletRequest.setCharacterEncoding("utf-8");
    	ServletResponse.setCharacterEncoding("utf-8");
    	ServletResponse.setContentType("text/html;charset=utf-8");
        HttpServletRequest request = (HttpServletRequest) ServletRequest;
        HttpServletResponse response = (HttpServletResponse) ServletResponse;
        HttpSession session = request.getSession();
        String user = (String) session.getAttribute("user");
        //获取根目录所对应的绝对路径
        String currentURL = request.getRequestURI();
        //截取到当前文件名用于比较
        String targetURL = currentURL.substring(currentURL.lastIndexOf("/") ,currentURL.length());
        //登陆页面无需过滤
        String path = request.getContextPath();
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
        if(currentURL.indexOf("/login.jsp") > -1) {
        	arg2.doFilter(ServletRequest, ServletResponse);
            return;
        } else if((path+"/").equals(currentURL) && "path".equals(currentURL)){
        	arg2.doFilter(ServletRequest, ServletResponse);
        }
        
        if(null == user || "".equals(user)){
        	response.sendRedirect("/login.jsp");
        } else {
        	arg2.doFilter(ServletRequest, ServletResponse);
        }

    }

    public void init(FilterConfig arg0) throws ServletException {
    }

}