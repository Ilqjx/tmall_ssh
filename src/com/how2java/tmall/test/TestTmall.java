package com.how2java.tmall.test;

import java.util.List;

import org.hibernate.sql.Sybase11JoinFragment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.pojo.Product;
import com.how2java.tmall.service.CategoryService;
import com.how2java.tmall.service.ProductService;
import com.how2java.tmall.util.Page;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestTmall {
	
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ProductService productService;
	
	@Test
	public void testListByParent() {
		Page page = new Page(0, 7);
		Category category = new Category();
		category.setId(144);
//		int total = productService.getTotalByParent(category);
//		System.out.println(total);
		List<Product> list = productService.listByParent(category);
		if (list != null) {
			for (Product p : list) {
				System.out.println("pname: " + p.getName());
			}
		}
	}
	
}
