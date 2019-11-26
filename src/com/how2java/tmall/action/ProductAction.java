package com.how2java.tmall.action;

import java.util.Date;

import org.apache.struts2.convention.annotation.Action;

import com.how2java.tmall.pojo.Product;
import com.how2java.tmall.util.DateUtil;
import com.how2java.tmall.util.Page;

public class ProductAction extends Action4Result {

	@Action("admin_product_list")
	public String list() {
		if (page == null) {
			page = new Page();
		}
		t2p(category);
		int total = productService.getTotalByParent(category);
		page.setTotal(total);
		page.setParam("&category.id=" + category.getId());
		products = productService.listByParent(category, page);
		for (Product p : products) {
			System.out.println("time: " + DateUtil.t2d(p.getCreateDate()));
		}
		return "listProduct";
	}
	
	@Action("admin_product_add")
	public String add() {
		Date createDate = new Date();
		product.setCreateDate(DateUtil.d2t(createDate));
		productService.save(product);
		return "listProductPage";
	}
	
	@Action("admin_product_delete")
	public String delete() {
		productService.delete(product);
		return "listProductPage";
	}
	
	@Action("admin_product_edit")
	public String edit() {
		t2p(product);
		return "editProduct";
	}
	
	@Action("admin_product_update")
	public String update() {
		productService.update(product);
		return "listProductPage";
	}
	
}
