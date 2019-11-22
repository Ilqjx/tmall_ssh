package com.how2java.tmall.service;

import java.util.List;

import com.how2java.tmall.util.Page;

public interface BaseService {

	// 返回值为 Integer 是为了兼容 dao 委派模式
	public Integer save(Object object);
	
	public void delete(Object object);
	
	public void update(Object object);
	
	public Object get(Class clazz, int id);
	
	public Object get(int id);
	
	public List list();
	
	public List list(Page page);
	
}
