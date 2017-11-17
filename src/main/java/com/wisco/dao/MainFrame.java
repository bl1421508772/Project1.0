package com.wisco.dao;

import java.util.List;

import com.wisco.entity.Tbmenu;

public interface MainFrame {
	List<Tbmenu> getNavTree(Integer id);
}
