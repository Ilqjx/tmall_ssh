package com.how2java.tmall.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.how2java.tmall.dao.impl.DAOImpl;
import com.how2java.tmall.service.BaseService;
import com.how2java.tmall.util.Page;

@Service
public class BaseServiceImpl implements BaseService {
	
	@Autowired
	private DAOImpl dao;
	
	protected Class clazz;
	
	public BaseServiceImpl() {
		try {
			throw new Exception();
		} catch (Exception e) {
			// e.getStackTrace() 获得方法的调用栈的数组
			StackTraceElement[] stes = e.getStackTrace();
			// stes[1] 对应调用此构造方法的那个类(new BaseServiceImpl 或者是其子类)
			// 获取 stes[1] 的全限定类名
			String serviceImplClassName = stes[1].getClassName();
			try {
				Class serviceImplClass = Class.forName(serviceImplClassName);
				String serviceImplClassSimpleName = serviceImplClass.getSimpleName();
				String pojoSimpleName = serviceImplClassSimpleName.replaceAll("ServiceImpl", "");
				String pojoPackageName = serviceImplClass.getPackage().getName().replaceAll(".service.impl", ".pojo");
				String pojoFullClassName = pojoPackageName + "." + pojoSimpleName;
				clazz = Class.forName(pojoFullClassName);
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
		}
	}

	@Override
	public Integer save(Object object) {
		return (Integer) dao.save(object);
	}

	@Override
	public void update(Object object) {
		dao.update(object);
	}

	@Override
	public void delete(Object object) {
		dao.delete(object);
	}

	@Override
	public Object get(Class clazz, int id) {
		return dao.get(clazz, id);
	}

	@Override
	public Object get(int id) {
		return dao.get(clazz, id);
	}

	@Override
	public List<Object> list() {
		DetachedCriteria dc = DetachedCriteria.forClass(clazz);
		dc.addOrder(Order.desc("id"));
		return dao.findByCriteria(dc);
	}

	@Override
	public List<Object> list(Page page) {
		DetachedCriteria dc = DetachedCriteria.forClass(clazz);
		dc.addOrder(Order.desc("id"));
		return dao.findByCriteria(dc, page.getStart(), page.getCount());
	}

	@Override
	public int getTotal() {
		String hql = "select count(*) from " + clazz.getName();
		List<Long> list = dao.find(hql);
		if (list.isEmpty()) {
			return 0;
		}
		Long total = list.get(0);
		return total.intValue();
	}

}
