package com.how2java.tmall.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.how2java.tmall.pojo.Order;
import com.how2java.tmall.pojo.OrderItem;
import com.how2java.tmall.pojo.User;
import com.how2java.tmall.service.OrderItemService;
import com.how2java.tmall.service.OrderService;
import com.how2java.tmall.service.ProductImageService;
import com.opensymphony.xwork2.ActionContext;

@Service
public class OrderServiceImpl extends BaseServiceImpl implements OrderService {

	@Autowired
	private OrderItemService orderItemService;
	@Autowired
	private ProductImageService productImageService;
	
	@Override
	public void fillOrders(List<Order> orders) {
		for (Order order : orders) {
			fillOrder(order);
		}
	}
	
	public void fillOrder(Order order) {
		float total = 0;
		int totalNumber = 0;
		List<OrderItem> orderItems = orderItemService.listByParent(order);
		for (OrderItem orderItem : orderItems) {
			total += orderItem.getNumber() * orderItem.getProduct().getPromotePrice();
			totalNumber += orderItem.getNumber();
			
			// 为订单项的产品设置图片
			productImageService.setFirstProductImage(orderItem.getProduct());
		}
		order.setTotal(total);
		order.setTotalNumber(totalNumber);
		order.setOrderItems(orderItems);
	}

	// Propagation.REQUIRED 支持当前事务,如果没有就新建一个
	// rollbackForClassName 有异常就回滚
	@Transactional(propagation = Propagation.REQUIRED, rollbackForClassName = "Exception")
	@Override
	public void createOrder(Order order, List<OrderItem> orderItems) {
		float total = 0;
		User user = (User) ActionContext.getContext().getSession().get("user");
		Date createDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		int randomDigit = (int) (Math.random() * 9000) + 1000;
		// 年月日时分秒毫秒 + 4位随机数
		String orderCode = sdf.format(createDate) + randomDigit;
		
		order.setUser(user);
		order.setCreateDate(createDate);
		order.setOrderCode(orderCode);
		order.setStatus(OrderService.waitPay);
		save(order);
		
		for (OrderItem orderItem : orderItems) {
			orderItem.setOrder(order);
			orderItemService.update(orderItem);
			total += orderItem.getNumber() * orderItem.getProduct().getPromotePrice();
		}
		order.setTotal(total);
	}

}
