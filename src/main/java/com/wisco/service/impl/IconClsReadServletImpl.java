package com.wisco.service.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.wisco.service.IconClsReadSerivce;
@Service
public class IconClsReadServletImpl implements IconClsReadSerivce {

	@Override
	public List<Map<String, Object>> getIcons(HttpServletRequest request) {
		String paths = request.getRequestURI();
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+path+"/";
		String png ="resources/easyui/themes/icons";
		String Pngpath=basePath+png;
	 String lujing=request.getServletContext().getRealPath("/")+ png;
	 
	 System.out.println(lujing);
	 List<Map<String , Object>> lists = new ArrayList<Map<String , Object>>();
	 File f =new File(lujing);
	    if(f.isDirectory()){
	    	File [] filelist=f.listFiles();
	        for(int j=0;j<filelist.length;j++){
	        	File F=filelist[j];
	        	if(F.isFile()){
	        		String name=F.getName();
	        		Map<String , Object> hashMap = new HashMap<String , Object>();
	        		hashMap.put(name , Pngpath + "/" + name);
	        		lists.add(hashMap);
	        		System.out.println(name);
	        	}
	        } 
	    }
		return lists;
	}

}
