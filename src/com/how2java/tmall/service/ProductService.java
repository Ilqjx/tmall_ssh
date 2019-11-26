package com.how2java.tmall.service;

import java.util.List;

import com.how2java.tmall.pojo.Product;

public interface ProductService extends BaseService {

	public void setFirstProductImage(Product product);
	
	public void setFirstProductImage(List<Product> products);
	
}
