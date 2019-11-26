package com.how2java.tmall.service;

import java.util.List;

import com.how2java.tmall.pojo.Product;
import com.how2java.tmall.pojo.ProductImage;

public interface ProductImageService extends BaseService {
	
	public static final String single_type = "single";
	public static final String detail_type = "detail";

	public List<ProductImage> listByProduct(Product product, String type);
	
}
