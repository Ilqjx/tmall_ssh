package com.how2java.tmall.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.pojo.Product;
import com.how2java.tmall.service.CategoryService;
import com.how2java.tmall.service.ProductImageService;
import com.how2java.tmall.service.ProductService;

@Service
public class CategoryServiceImpl extends BaseServiceImpl implements CategoryService {

	@Autowired
	private ProductService productService;
	@Autowired
	private ProductImageService productImageService;
	
	@Override
	public void fillCategory(Category category) {
		List<Product> products = productService.listByParent(category);
		productImageService.setFirstProductImage(products);
		category.setProducts(products);
	}

	@Override
	public void fillCategory(List<Category> categorys) {
		for (Category category : categorys) {
			fillCategory(category);
		}
	}

	@Override
	public void fillCategoryByRow(List<Category> categorys) {
		int productNumberByRow = 8;
		for (Category category : categorys) {
			List<Product> products = category.getProducts();
			List<List<Product>> productsByRow = new ArrayList<>();
			for (int i = 0; i < products.size(); i += productNumberByRow) {
				int endIndex = i + productNumberByRow;
				endIndex = endIndex > products.size() ? products.size() : endIndex;
				List<Product> productsByEachRow  = products.subList(i, endIndex);
				productsByRow.add(productsByEachRow);
			}
			category.setProductsByRow(productsByRow);
		}
	}

}
