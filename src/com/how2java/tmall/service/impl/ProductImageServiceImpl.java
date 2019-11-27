package com.how2java.tmall.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.how2java.tmall.pojo.Product;
import com.how2java.tmall.pojo.ProductImage;
import com.how2java.tmall.service.ProductImageService;

@Service
public class ProductImageServiceImpl extends BaseServiceImpl implements ProductImageService {

	@Override
	public void setFirstProductImage(List<Product> products) {
		for (Product product : products) {
			List<ProductImage> productImages = list("product", product, "type", ProductImageService.single_type);
			if (!productImages.isEmpty()) {
				product.setFirstProductImage(productImages.get(0));
			}
		}
	}

}
