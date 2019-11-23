package com.how2java.tmall.action;

import java.util.List;

import com.how2java.tmall.pojo.Category;

public class Action4Pojo extends Action4Pagination {

	protected Category category;
	protected List<Category> categorys;
	
	public Category getCategory() {
		return category;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}
	
	public List<Category> getCategorys() {
		return categorys;
	}
	
	public void setCategorys(List<Category> categorys) {
		this.categorys = categorys;
	}
	
}
