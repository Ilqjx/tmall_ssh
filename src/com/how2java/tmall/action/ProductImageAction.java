package com.how2java.tmall.action;

import org.apache.struts2.convention.annotation.Action;

import com.how2java.tmall.service.ProductImageService;

public class ProductImageAction extends Action4Result {

	@Action("admin_productImage_list")
	public String list() {
		t2p(product);
		productSingleImages = productImageService.list("product", product, "type", ProductImageService.single_type);
		productDetailImages = productImageService.list("product", product, "type", ProductImageService.detail_type);
		return "listProductImage";
	}
	
	@Action("admin_productImage_add")
	public String add() {
		productImageService.save(productImage);
		if (ProductImageService.single_type.equals(productImage.getType())) {
			uploadImg(productImage, "img/productSingleImage");
		} else {
			uploadImg(productImage, "img/productDetailImage");
		}
		return "listProductImagePage";
	}
	
	@Action("admin_productImage_delete")
	public String delete() {
		t2p(productImage);
		productImageService.delete(productImage);
		if (productImage.getType().equals(ProductImageService.single_type)) {
			deleteImg(productImage, "img/productSingleImage");
		} else {
			deleteImg(productImage, "img/productDetailImage");
		}
		return "listProductImagePage";
	}
	
}
