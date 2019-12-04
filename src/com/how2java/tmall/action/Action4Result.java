package com.how2java.tmall.action;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

@Namespace("/")
@ParentPackage("basicstruts")
@Results({
	// ȫ�ֵ�
	@Result(name = "success.jsp", location = "/public/success.jsp"),
	@Result(name = "fail.jsp", location = "/public/fail.jsp"),
	
	// ��˵�½
	@Result(name = "backLogin.jsp", location = "/backLogin.jsp"),
	
	// �������
	@Result(name = "listCategory", location = "/admin/listCategory.jsp"),
	@Result(name = "editCategory", location = "/admin/editCategory.jsp"),
	@Result(name = "listCategoryPage", location = "admin_category_list", type = "redirect"),
	
	// ���Թ���
	@Result(name = "listProperty", location = "/admin/listProperty.jsp"),
	@Result(name = "editProperty", location = "/admin/editProperty.jsp"),
	@Result(name = "listPropertyPage", location = "admin_property_list?category.id=${property.category.id}", type = "redirect"),
	
	// ��Ʒ����
	@Result(name = "listProduct", location = "/admin/listProduct.jsp"),
	@Result(name = "editProduct", location = "/admin/editProduct.jsp"),
	@Result(name = "listProductPage", location = "admin_product_list?category.id=${product.category.id}", type = "redirect"),
	
	// ��ƷͼƬ����
	@Result(name = "listProductImage", location = "/admin/listProductImage.jsp"),
	@Result(name = "listProductImagePage", location = "admin_productImage_list?product.id=${productImage.product.id}", type = "redirect"),
	
	// ����ֵ����
	@Result(name = "editPropertyValue", location = "/admin/editPropertyValue.jsp"),
	
	// �û�����
	@Result(name = "listUser", location = "/admin/listUser.jsp"),
	
	// ��������
	@Result(name = "listOrder", location = "/admin/listOrder.jsp"),
	@Result(name = "listOrderPage", location = "admin_order_list", type = "redirect"),
	
	// ��ҳ�������ת
	@Result(name = "home.jsp", location = "/home.jsp"),
	@Result(name = "register.jsp", location = "/register.jsp"),
	@Result(name = "registerSuccess.jsp", location = "/registerSuccess.jsp"),
	@Result(name = "login.jsp", location = "/login.jsp"),
	@Result(name = "product.jsp", location = "/product.jsp"),
	@Result(name = "category.jsp", location = "/category.jsp"),
	@Result(name = "searchResult.jsp", location = "/searchResult.jsp"),
	@Result(name = "buy.jsp", location = "/buy.jsp"),
	@Result(name = "cart.jsp", location = "/cart.jsp"),
	@Result(name = "alipay.jsp", location = "/alipay.jsp"),
	@Result(name = "payed.jsp", location = "/payed.jsp"),
	@Result(name = "bought.jsp", location = "/bought.jsp"),
	@Result(name = "confirmPay.jsp", location = "/confirmPay.jsp"),
	@Result(name = "orderConfirmed.jsp", location = "/orderConfirmed.jsp"),
	@Result(name = "review.jsp", location = "/review.jsp"),
	
	// ��ҳ�ͻ�����ת
	@Result(name = "homePage", location = "forehome", type = "redirect"),
	@Result(name = "buyPage", location = "forebuy?oiids=${oiid}", type = "redirect"),
	@Result(name = "alipayPage", location = "forealipay?order.id=${order.id}&order.total=${order.total}", type = "redirect"),
	@Result(name = "reviewPage", location = "forereview?order.id=${order.id}", type = "redirect")
	
})
public class Action4Result extends Action4Parameter {

}
