package com.how2java.tmall.service.impl;

import java.util.Collections;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.how2java.tmall.comparator.ProductAllComparator;
import com.how2java.tmall.comparator.ProductDateComparator;
import com.how2java.tmall.comparator.ProductPriceComparator;
import com.how2java.tmall.comparator.ProductReviewComparator;
import com.how2java.tmall.comparator.ProductSaleCountComparator;
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

	@Override
	public void sortProduct(List<Product> products ,String sort) {
		if ("price".equals(sort)) {
			Collections.sort(products, new ProductPriceComparator());
		} else if ("review".equals(sort)) {
			Collections.sort(products, new ProductReviewComparator());
		} else if ("date".equals(sort)) {
			Collections.sort(products, new ProductDateComparator());
		} else if ("saleCount".equals(sort)) {
			Collections.sort(products, new ProductSaleCountComparator());
		} else if ("all".equals(sort)) {
			Collections.sort(products, new ProductAllComparator());
		}
	}

	@Override
	public List search(String keyword, int start, int count) {
		DetachedCriteria dc = DetachedCriteria.forClass(clazz);
		dc.add(Restrictions.like("name", "%" + keyword + "%"));
		return findByCriteria(dc, start, count);
	}

}
