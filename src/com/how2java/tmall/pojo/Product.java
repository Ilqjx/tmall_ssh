package com.how2java.tmall.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "product")
public class Product {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String subTitle;
	private float originalPrice;
	private float promotePrice;
	private int stock;
	@ManyToOne
	@JoinColumn(name = "cid", referencedColumnName="id")
	private Category category;
	private Date createDate;
	@Transient
	private ProductImage firstProductImage;
	@Transient
	private int saleCount;
	@Transient
	private int reviewCount;
	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSubTitle() {
		return subTitle;
	}
	
	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}
	
	public float getOriginalPrice() {
		return originalPrice;
	}
	
	public void setOriginalPrice(float originalPrice) {
		this.originalPrice = originalPrice;
	}
	
	public float getPromotePrice() {
		return promotePrice;
	}
	
	public void setPromotePrice(float promotePrice) {
		this.promotePrice = promotePrice;
	}
	
	public int getStock() {
		return stock;
	}
	
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public Category getCategory() {
		return category;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}
	
	public Date getCreateDate() {
		return createDate;
	}
	
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	public ProductImage getFirstProductImage() {
		return firstProductImage;
	}
	
	public void setFirstProductImage(ProductImage firstProductImage) {
		this.firstProductImage = firstProductImage;
	}
	
	public int getSaleCount() {
		return saleCount;
	}
	
	public void setSaleCount(int saleCount) {
		this.saleCount = saleCount;
	}
	
	public int getReviewCount() {
		return reviewCount;
	}
	
	public void setReviewCount(int reviewCount) {
		this.reviewCount = reviewCount;
	}
	
}
