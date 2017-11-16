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

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain arg2) throws IOException,
            ServletException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        arg2.doFilter(request, response);

    }

    public void init(FilterConfig arg0) throws ServletException {
    }

}