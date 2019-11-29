package com.how2java.tmall.service;

import java.util.List;

import com.how2java.tmall.pojo.Order;

public interface OrderService extends BaseService {
	
	public static final String waitPay = "waitPay";
	public static final String waitDelivery = "waitDelivery";
	public static final String waitConfirm = "waitConfirm";
	public static final String waitReview = "waitReview";
	public static final String finish = "finish";
	public static final String delete = "delete";
	
	public void fillOrders(List<Order> orders);
	
}
