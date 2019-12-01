package com.how2java.tmall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.how2java.tmall.pojo.Order;
import com.how2java.tmall.pojo.OrderItem;
import com.how2java.tmall.pojo.Product;
import com.how2java.tmall.service.OrderItemService;
import com.how2java.tmall.service.OrderService;
import com.how2java.tmall.service.ProductService;
import com.how2java.tmall.service.ReviewService;

@Service
public class ProductServiceImpl extends BaseServiceImpl implements ProductService {

	@Autowired
	private ReviewService reviewService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private OrderItemService orderItemService;
	
	@Override
	public void setSaleAndReviewCount(Product product) {
		int saleCount = 0;
		int reviewCount = reviewService.getTotalByParent(product);
		List<Order> orders = orderService.list();
		for (Order order : orders) {
			List<OrderItem> orderItems = orderItemService.list("order", order, "product", product);
			if (!orderItems.isEmpty()) {
				saleCount += orderItems.get(0).getNumber();
			}
		}
		product.setSaleCount(saleCount);
		product.setReviewCount(reviewCount);
	}

	@Override
	public void setSaleAndReviewCount(List<Product> products) {
		for (Product product : products) {
			setSaleAndReviewCount(product);
		}
	}

}
