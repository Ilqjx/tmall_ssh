package com.how2java.tmall.service;

import java.util.List;

import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.util.Page;

public interface PropertyService {

	public List listByCategory(Category category);
	
	public List listByCategory(Category category, Page page);
	
	public int total(Category category);
	
}
