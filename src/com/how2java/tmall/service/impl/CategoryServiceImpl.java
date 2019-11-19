package com.how2java.tmall.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.how2java.tmall.dao.impl.DAOImpl;
import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.service.CategoryService;
import com.how2java.tmall.util.Page;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private DAOImpl dao;
	
	@Override
	public List<Category> list() {
		DetachedCriteria dc = DetachedCriteria.forClass(Category.class);
		dc.addOrder(Order.desc("id"));
		return dao.findByCriteria(dc);
	}
	
	@Override
	public List<Category> list(Page page) {
		DetachedCriteria dc = DetachedCriteria.forClass(Category.class);
		dc.addOrder(Order.desc("id"));
		return dao.findByCriteria(dc, page.getStart(), page.getCount());
	}

	@Override
	public int getTotal() {
		String hql = "select count(*) from Category";
		List<Long> list = dao.find(hql);
		Long total = list.get(0);
		return total.intValue();
	}

	@Override
	public void add(Category category) {
		dao.save(category);
	}

	@Override
	public void delete(Category category) {
		dao.delete(category);
	}

	@Override
	public Category getCategory(Category category) {
		return dao.get(Category.class, category.getId());
	}

	@Override
	public void update(Category category) {
		dao.update(category);
	}

}
