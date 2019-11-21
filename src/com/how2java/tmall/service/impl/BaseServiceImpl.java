package com.how2java.tmall.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Service;

import com.how2java.tmall.service.BaseService;
import com.how2java.tmall.util.Page;

@Service
public class BaseServiceImpl extends ServiceDelegateDAO implements BaseService {
	
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
		return (Integer) super.save(object);
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

	@Override
	public int getTotal() {
		String hql = "select count(*) from " + clazz.getName();
		List<Long> list = find(hql);
		if (list.isEmpty()) {
			return 0;
		}
		Long total = list.get(0);
		return total.intValue();
	}

}
