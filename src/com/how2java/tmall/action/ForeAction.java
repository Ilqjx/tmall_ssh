package com.how2java.tmall.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.web.util.HtmlUtils;

import com.how2java.tmall.pojo.OrderItem;
import com.how2java.tmall.pojo.User;
import com.how2java.tmall.service.OrderService;
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
	
	@Action("forebuyone")
	public String buyone() {
		User user = (User) ActionContext.getContext().getSession().get("user");
		OrderItem orderItem;
		List<OrderItem> list = orderItemService.list("user", user, "product", product, "order", null);
		if (list.isEmpty()) {
			orderItem = new OrderItem();
			orderItem.setProduct(product);
			orderItem.setUser(user);
			orderItem.setNumber(num);
			orderItemService.save(orderItem);
		} else {
			orderItem = list.get(0);
			orderItem.setNumber(orderItem.getNumber() + num);
			orderItemService.update(orderItem);
		}
		oiid = orderItem.getId();
		return "buyPage";
	}
	
	@Action("forebuy")
	public String buy() {
		orderItems = new ArrayList<>();
		total = 0;
		for (int oiid : oiids) {
			OrderItem orderItem = (OrderItem) orderItemService.get(oiid);
			productImageService.setFirstProductImage(orderItem.getProduct());
			orderItems.add(orderItem);
			total += orderItem.getProduct().getPromotePrice() * orderItem.getNumber();
		}
		// 在方法 createOrder 创建订单时需要这些订单项
		ActionContext.getContext().getSession().put("orderItems", orderItems);
		return "buy.jsp";
	}
	
	@Action("foreaddCart")
	public String addCart() {
		User user = (User) ActionContext.getContext().getSession().get("user");
		OrderItem orderItem;
		List<OrderItem> list = orderItemService.list("user", user, "product", product, "order", null);
		if (list.isEmpty()) {
			orderItem = new OrderItem();
			orderItem.setProduct(product);
			orderItem.setUser(user);
			orderItem.setNumber(num);
			orderItemService.save(orderItem);
		} else {
			orderItem = list.get(0);
			orderItem.setNumber(orderItem.getNumber() + num);
			orderItemService.update(orderItem);
		}
		return "success.jsp";
	}
	
	@Action("forecart")
	public String cart() {
		User user = (User) ActionContext.getContext().getSession().get("user");
		orderItems = orderItemService.list("user", user, "order", null);
		for (OrderItem orderItem : orderItems) {
			productImageService.setFirstProductImage(orderItem.getProduct());
		}
		return "cart.jsp";
	}
	
	@Action("forechangeOrderItem")
	public String changeOrderItem() {
		User user = (User) ActionContext.getContext().getSession().get("user");
		List<OrderItem> list = orderItemService.list("user", user, "product", product, "order", null);
		if (!list.isEmpty()) {
			OrderItem orderItem = list.get(0);
			orderItem.setNumber(num);
			orderItemService.update(orderItem);
			return "success.jsp";
		}
		return "fail.jsp";
	}
	
	@Action("foredeleteOrderItem")
	public String deleteOrderItem() {
		orderItemService.delete(orderItem);
		return "success.jsp";
	}
	
	@Action("forecreateOrder")
	public String createOrder() {
		orderItems = (List<OrderItem>) ActionContext.getContext().getSession().get("orderItems");
		if (orderItems.isEmpty()) {
			return "login.jsp";
		}
		orderService.createOrder(order, orderItems);
		return "alipayPage";
	}
	
	// 为了不暴露 jsp 转换路径
	@Action("forealipay")
	public String alipay() {
		return "alipay.jsp";
	}
	
	@Action("forepayed")
	public String payed() {
		t2p(order);
		order.setTotal(total);
		order.setPayDate(new Date());
		order.setStatus(OrderService.waitDelivery);
		orderService.update(order);
		return "payed.jsp";
	}
	
}
