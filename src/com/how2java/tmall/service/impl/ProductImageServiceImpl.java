package com.how2java.tmall.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import com.how2java.tmall.pojo.Product;
import com.how2java.tmall.pojo.ProductImage;
import com.how2java.tmall.service.ProductImageService;

@Service
public class ProductImageServiceImpl extends BaseServiceImpl implements ProductImageService {

	@Override
	public List<ProductImage> listByProduct(Product product, String type) {
		String hql = "from ProductImage pi where pi.product = ? and pi.type = ? order by id desc";
		return find(hql, product, type);
	}

	@Override
	public List<ProductImage> listByProduct(String product_key, Product product, String type_key, String type) {
		DetachedCriteria dc = DetachedCriteria.forClass(clazz);
		System.out.println("clazz: " + clazz);
		dc.add(Restrictions.eq(product_key, product));
		dc.add(Restrictions.eq(type_key, type));
		dc.addOrder(Order.desc("id"));
		return findByCriteria(dc);
	}
}
