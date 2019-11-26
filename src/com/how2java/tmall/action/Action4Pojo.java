package com.how2java.tmall.action;

import java.util.List;

import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.pojo.Product;
import com.how2java.tmall.pojo.Property;

public class Action4Pojo extends Action4Pagination {

	protected Category category;
	protected Property property;
	protected Product product;
	
	protected List<Category> categorys;
	protected List<Property> propertys;
	protected List<Product> products;
	
	public Category getCategory() {
		return category;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}
	
	public Property getProperty() {
		return property;
	}
	
	public void setProperty(Property property) {
		this.property = property;
	}
	
	public Product getProduct() {
		return product;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public List<Category> getCategorys() {
		return categorys;
	}
	
	public void setCategorys(List<Category> categorys) {
		this.categorys = categorys;
	}
	
	public List<Property> getPropertys() {
		return propertys;
	}
	
	public void setPropertys(List<Property> propertys) {
		this.propertys = propertys;
	}
	
	public List<Product> getProducts() {
		return products;
	}
	
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
}