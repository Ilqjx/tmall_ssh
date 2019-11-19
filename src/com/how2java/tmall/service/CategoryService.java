package com.how2java.tmall.service;

import java.util.List;

import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.util.Page;

public interface CategoryService {

	public List<Category> list();
	
	public List<Category> list(Page page);
	
	public int getTotal();
	
	public void add(Category category);
	
	public void delete(Category category);
	
	public Category getCategory(Category category);
	
	public void update(Category category);
	
}
