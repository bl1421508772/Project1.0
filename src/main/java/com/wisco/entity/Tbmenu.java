package com.wisco.entity;

import java.io.Serializable;

public class Tbmenu implements Serializable{
	
	private static final long serialVersionUID = -4196774086422376505L;

	private Integer id;
	
	private String text;
	
	private String state;
	
	private String parentId;
	
	private String iconCls;
	
	private String url;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getIconCls() {
		return iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Tbmenu [id=" + id + ", text=" + text + ", state=" + state + ", parentId=" + parentId + ", iconCls="
				+ iconCls + ", url=" + url + "]";
	}
	

	
	
}
