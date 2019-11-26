package com.how2java.tmall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.how2java.tmall.pojo.Product;
import com.how2java.tmall.pojo.ProductImage;
import com.how2java.tmall.service.ProductImageService;
import com.how2java.tmall.service.ProductService;

@Service
public class ProductServiceImpl extends BaseServiceImpl implements ProductService {

	@Autowired
	private ProductImageService productImageService;
	
	@Override
	public void setFirstProductImage(Product product) {
		List<ProductImage> productImages = productImageService.listByProduct(product, ProductImageService.single_type);
		if (!productImages.isEmpty()) {
			product.setFirstProductImage(productImages.get(0));
		}
	}

	@Override
	public void setFirstProductImage(List<Product> products) {
		for (Product product : products) {
			setFirstProductImage(product);
		}
	}

}
