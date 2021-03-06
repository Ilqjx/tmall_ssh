package com.how2java.tmall.service;

import java.util.List;

import com.how2java.tmall.pojo.Product;

public interface ProductImageService extends BaseService {
	
	public static final String single_type = "type_single";
	public static final String detail_type = "type_detail";
	
	public void setFirstProductImage(Product product);
	
	public void setFirstProductImage(List<Product> products);
	
}
