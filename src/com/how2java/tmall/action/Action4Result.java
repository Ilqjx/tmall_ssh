package com.how2java.tmall.action;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

@Namespace("/")
@ParentPackage("basicstruts")
@Results({
	// 分类管理
	@Result(name = "listCategory", location = "/admin/listCategory.jsp"),
	@Result(name = "editCategory", location = "/admin/editCategory.jsp"),
	@Result(name = "listCategoryPage", location = "admin_category_list", type = "redirect"),
	
	// 属性管理
	@Result(name = "listProperty", location = "/admin/listProperty.jsp"),
	@Result(name = "editProperty", location = "/admin/editProperty.jsp"),
	@Result(name = "listPropertyPage", location = "admin_property_list?category.id=${property.category.id}", type = "redirect"),
	
	// 产品管理
	@Result(name = "listProduct", location = "/admin/listProduct.jsp"),
	@Result(name = "editProduct", location = "/admin/editProduct.jsp"),
	@Result(name = "listProductPage", location = "admin_product_list?category.id=${product.category.id}", type = "redirect"),
	
	// 产品图片管理
	@Result(name = "listProductImage", location = "/admin/listProductImage.jsp"),
	@Result(name = "listProductImagePage", location = "admin_productImage_list?product.id=${productImage.product.id}", type = "redirect")
})
public class Action4Result extends Action4Service {

}
