package com.how2java.tmall.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;

import com.how2java.tmall.service.BaseService;
import com.how2java.tmall.util.Page;

public class BaseServiceImpl extends ServiceDelegateDAO implements BaseService {

	protected Class clazz;
	
	// ≥ı ºªØ clazz
	public BaseServiceImpl() {
		try {
			throw new Exception();
		} catch (Exception e) {
			try {
				StackTraceElement[] stes = e.getStackTrace();
				Class serviceImplClass = Class.forName(stes[1].getClassName());
				String pojoSimpleName = serviceImplClass.getSimpleName().replace("ServiceImpl", "");
				String pojoPackageName = serviceImplClass.getPackage().getName().replace(".service.impl", ".pojo");
				clazz = Class.forName(pojoPackageName + "." + pojoSimpleName);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
	
	@Override
	public Integer save(Object object) {
		return (Integer) super.save(object);
	}
	
	@Override
	public int getTotal() {
		String hql = "select count(*) from " + clazz.getSimpleName();
		List<Long> list = find(hql);
		if (list.isEmpty()) {
			return 0;
		}
		return list.get(0).intValue();
	}
	
	@Override
	public Object get(Class clazz, int id) {
		return super.get(clazz, id);
	}

	@Override
	public Object get(int id) {
		return get(clazz, id);
	}

	@Override
	public List list() {
		DetachedCriteria dc = DetachedCriteria.forClass(clazz);
		dc.addOrder(Order.desc("id"));
		return findByCriteria(dc);
	}

	@Override
	public List list(Page page) {
		DetachedCriteria dc = DetachedCriteria.forClass(clazz);
		dc.addOrder(Order.desc("id"));
		return findByCriteria(dc, page.getStart(), page.getCount());
	}

}
