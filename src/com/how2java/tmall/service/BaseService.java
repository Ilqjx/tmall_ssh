package com.how2java.tmall.service;

import java.util.List;

import com.how2java.tmall.util.Page;

public interface BaseService {

	public Integer save(Object object);
	
	public void update(Object object);
	
	public void delete(Object object);
	
	public Object get(Class clazz, int id);
	
	public Object get(int id);
	
	public List list();
	
	public List list(Page page);
	
	public int getTotal();
	
}
