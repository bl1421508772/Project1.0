/**
 * Project Name:dreamTeam
 * File Name:CheckCode.java
 * Package Name:cn.java.utils
 * Date:2017年4月25日下午1:46:35
 * Copyright (c) 2017, bluemobi All Rights Reserved.
 *
 */

package com.wisco.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

/**
 * Description: 验证实体类中字段属性<br/>
 * Date: 2017年4月25日 下午1:46:35 <br/>
 * 
 * @author baoL
 * @version
 * @see
 */
public class CheckCode {
    public static List<Map<String, Object>> check(BindingResult errorResult) {
        List<Map<String, Object>> list = null;
        boolean mark = errorResult.hasErrors();
        if (mark) {
            list = new ArrayList<Map<String, Object>>();
            List<FieldError> error = errorResult.getFieldErrors();

            for (FieldError fieldError : error) {
                Map<String, Object> hm = new HashMap<String, Object>();
                String filed = fieldError.getField();
                String errorMassage = fieldError.getDefaultMessage();
                hm.put("filed", filed);
                hm.put("errorMassage", errorMassage);
                list.add(hm);
            }
        }
        return list;
    }
}
