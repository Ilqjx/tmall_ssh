package com.how2java.tmall.service;

import java.util.List;

import com.how2java.tmall.pojo.Product;

public interface ProductService extends BaseService {
	
	public void setSaleAndReviewCount(Product product);
	
	public void setSaleAndReviewCount(List<Product> products);

}
