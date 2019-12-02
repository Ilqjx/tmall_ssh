package com.how2java.tmall.service;

import java.util.List;

import com.how2java.tmall.pojo.Category;

public interface CategoryService extends BaseService {
	
	public void fillCategory(Category category);
	
	public void fillCategory(List<Category> categorys);
	
	public void fillCategoryByRow(List<Category> categorys);
	
}
