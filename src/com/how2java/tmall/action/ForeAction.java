package com.how2java.tmall.action;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.web.util.HtmlUtils;

import com.how2java.tmall.pojo.User;
import com.how2java.tmall.service.ProductImageService;
import com.opensymphony.xwork2.ActionContext;

public class ForeAction extends Action4Result {

	@Action("forehome")
	public String home() {
		categorys = categoryService.list();
		categoryService.fillCategory(categorys);
		categoryService.fillCategoryByRow(categorys);
		return "home.jsp";
	}
	
	@Action("foreregister")
	public String register() {
		user.setName(HtmlUtils.htmlEscape(user.getName()));
		if (userService.isExist(user.getName())) {
			msg = "用户名已被使用  请重新输入";
			return "register.jsp";
		}
		userService.save(user);
		return "registerSuccess.jsp";
	}
	
	@Action("forelogin")
	public String login() {
		user.setName(HtmlUtils.htmlEscape(user.getName()));
		if (!userService.isExist(user.getName())) {
			msg = "账号不存在";
			return "login.jsp";
		}
		User user_session = userService.getUser(user);
		if (user_session == null) {
			msg = "密码不正确";
			return "login.jsp";
		}
		ActionContext.getContext().getSession().put("user", user_session);
		return "homePage";
	}
	
	@Action("forelogout")
	public String logout() {
		ActionContext.getContext().getSession().remove("user");
		return "homePage";
	}
	
	@Action("foreproduct")
	public String product() {
		t2p(product);
		productService.setSaleAndReviewCount(product);
		productImageService.setFirstProductImage(product);
		reviews = reviewService.listByParent(product);
		propertyValues = propertyValueService.listByParent(product);
		if (propertyValues.isEmpty()) {
			System.out.println("empty");
		}
		productSingleImages = productImageService.list("product", product, "type", ProductImageService.single_type);
		productDetailImages = productImageService.list("product", product, "type", ProductImageService.detail_type);
		return "product.jsp";
	}
	
	@Action("forecheckLogin")
	public String checkLogin() {
		User user = (User) ActionContext.getContext().getSession().get("user");
		if (user != null) {
			return "success.jsp";
		}
		return "fail.jsp";
	}
	
	@Action("foreloginAjax")
	public String loginAjax() {
		user.setName(HtmlUtils.htmlEscape(user.getName()));
		User user_session = userService.getUser(user);
		if (user_session == null) {
			return "fail.jsp";
		}
		ActionContext.getContext().getSession().put("user", user_session);
		return "success.jsp";
	}
	
	@Action("forecategory")
	public String category() {
		t2p(category);
		categoryService.fillCategory(category);
		productService.setSaleAndReviewCount(category.getProducts());
		if (sort != null) {
			productService.sortProduct(category.getProducts(), sort);
		}
		return "category.jsp";
	}
	
	@Action("foresearch")
	public String search() {
		products = productService.search(keyword, 0, 20);
		productService.setSaleAndReviewCount(products);
		productImageService.setFirstProductImage(products);
		return "searchResult.jsp";
	}
	
}
