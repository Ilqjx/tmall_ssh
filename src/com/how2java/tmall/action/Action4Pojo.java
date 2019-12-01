package com.how2java.tmall.action;

import java.util.List;

import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.pojo.Order;
import com.how2java.tmall.pojo.Product;
import com.how2java.tmall.pojo.ProductImage;
import com.how2java.tmall.pojo.Property;
import com.how2java.tmall.pojo.PropertyValue;
import com.how2java.tmall.pojo.User;

public class Action4Pojo extends Action4Pagination {

	protected Category category;
	protected Property property;
	protected Product product;
	protected ProductImage productImage;
	protected PropertyValue propertyValue;
	protected User user;
	protected Order order;
	protected String msg;
	
	protected List<Category> categorys;
	protected List<Property> propertys;
	protected List<Product> products;
	protected List<ProductImage> productSingleImages;
	protected List<ProductImage> productDetailImages;
	protected List<PropertyValue> propertyValues;
	protected List<User> users;
	protected List<Order> orders;
	
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
	
	public ProductImage getProductImage() {
		return productImage;
	}
	
	public void setProductImage(ProductImage productImage) {
		this.productImage = productImage;
	}
	
	public PropertyValue getPropertyValue() {
		return propertyValue;
	}
	
	public void setPropertyValue(PropertyValue propertyValue) {
		this.propertyValue = propertyValue;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public Order getOrder() {
		return order;
	}
	
	public void setOrder(Order order) {
		this.order = order;
	}
	
	public String getMsg() {
		return msg;
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
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
	
	public List<ProductImage> getProductSingleImages() {
		return productSingleImages;
	}
	
	public void setProductSingleImages(List<ProductImage> productSingleImages) {
		this.productSingleImages = productSingleImages;
	}
	
	public List<ProductImage> getProductDetailImages() {
		return productDetailImages;
	}
	
	public void setProductDetailImages(List<ProductImage> productDetailImages) {
		this.productDetailImages = productDetailImages;
	}
	
	public List<PropertyValue> getPropertyValues() {
		return propertyValues;
	}
	
	public void setPropertyValues(List<PropertyValue> propertyValues) {
		this.propertyValues = propertyValues;
	}
	
	public List<User> getUsers() {
		return users;
	}
	
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	public List<Order> getOrders() {
		return orders;
	}
	
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
}
