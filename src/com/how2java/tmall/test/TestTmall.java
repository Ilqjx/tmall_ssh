package com.how2java.tmall.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.how2java.tmall.pojo.Product;
import com.how2java.tmall.pojo.ProductImage;
import com.how2java.tmall.service.CategoryService;
import com.how2java.tmall.service.ProductImageService;
import com.how2java.tmall.service.ProductService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestTmall {
	
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ProductService productService;
	@Autowired
	private ProductImageService productImageService;
	
	@Test
	public void testProductImage() {
		Product product = new Product();
		product.setId(1);
		List<ProductImage> pis = productImageService.listByProduct(product, ProductImageService.detail_type);
		for (ProductImage pi : pis) {
			System.out.println("piid: " + pi.getId());
			System.out.println("type: " + pi.getType());
		}
	}
	
}
