package com.how2java.tmall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.how2java.tmall.pojo.Order;
import com.how2java.tmall.pojo.OrderItem;
import com.how2java.tmall.service.OrderItemService;
import com.how2java.tmall.service.OrderService;
import com.how2java.tmall.service.ProductImageService;

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

}
