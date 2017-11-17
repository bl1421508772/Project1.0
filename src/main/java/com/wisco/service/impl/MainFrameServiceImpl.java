package com.wisco.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wisco.dao.MainFrame;
import com.wisco.entity.Tbmenu;
import com.wisco.service.MainFrameService;
@Service
public class MainFrameServiceImpl implements MainFrameService {
	@Autowired
	private MainFrame mainFrame;
	
	public List<Tbmenu> getNavTreeByParentId(HttpServletRequest request){
		String id = request.getParameter("id");
		return mainFrame.getNavTree(Integer.parseInt(id == null? "0":id));
	}

}
