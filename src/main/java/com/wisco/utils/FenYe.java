/**
 * Project Name:dreamTeam
 * File Name:FenYe.java
 * Package Name:cn.java.utils
 * Date:2017年5月5日下午4:30:59
 * Copyright (c) 2017, bluemobi All Rights Reserved.
 *
 */

package com.wisco.utils;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestParam;



/**
 * Description: <br/>
 * Date: 2017年5月5日 下午4:30:59 <br/>
 * 
 * @author wangL
 * @version
 * @see
 */
public class FenYe {
    public static String listfenye(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
            @RequestParam(value = "pageSize", defaultValue = "5") int pageSize, HttpServletRequest request, int nim,
            List<com.wisco.entity.User> lists) throws Exception {

        int num = nim;// 总的数据数
        System.out.println(num);
        int yeshu = 0;// 页数
        if (num % pageSize == 0) {
            yeshu = num / pageSize;
        } else {
            yeshu = num / pageSize + 1;
        }
        int index = (pageNum - 1) * pageSize;// 当前页

        // System.out.println(index);
        // System.out.println(pageSize);
        List<com.wisco.entity.User> list = lists;
        // System.out.println(list);
        request.setAttribute("list", list);
        request.setAttribute("pageNo", pageNum); // pageNum当前页，
        request.setAttribute("pages", num);// 总的数据数
        request.setAttribute("maxshowpageitem", yeshu);// maxshowpageitem：页码个数
        return "admin/job";
    }
}
