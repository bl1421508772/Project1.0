package com.wisco.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public  interface IconClsReadSerivce {
   public List<Map<String , Object>> getIcons(HttpServletRequest request);
}
