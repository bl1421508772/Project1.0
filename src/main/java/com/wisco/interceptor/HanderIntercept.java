/**
 * Project Name:dt29_lession36
 * File Name:HanderIntercept.java
 * Package Name:cn.java.interceptor
 * Date:2017年4月6日下午6:23:09
 * Copyright (c) 2017, bluemobi All Rights Reserved.
 *
 */

package com.wisco.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * Description: <br/>
 * Date: 2017年4月6日 下午6:23:09 <br/>
 * 
 * @author baoL
 * @version
 * @see
 */
public class HanderIntercept implements HandlerInterceptor {

    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {

        // Auto-generated method stub

    }

    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
            throws Exception {

        // Auto-generated method stub

    }

    public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {

        // Auto-generated method stub
        return true;
    }

}
