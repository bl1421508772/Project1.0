package com.wisco.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.wisco.entity.Tbmenu;

public interface MainFrameService {
	List<Tbmenu> getNavTreeByParentId(HttpServletRequest request);
}
