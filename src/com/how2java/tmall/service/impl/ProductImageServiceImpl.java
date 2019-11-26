package com.how2java.tmall.service.impl;

import java.util.List;

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

}
