package com.how2java.tmall.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.xwork.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.how2java.tmall.service.BaseService;
import com.how2java.tmall.util.Page;

public class BaseServiceImpl extends ServiceDelegateDAO implements BaseService {

	protected Class clazz;
	
	// 初始化 clazz
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

	@Override
	public List listByParent(Object parent) {
		String parentName = parent.getClass().getSimpleName();
		// 把首字母变成小写
		String parentNameWithLetterFirstLower = StringUtils.uncapitalize(parentName);
		DetachedCriteria dc = DetachedCriteria.forClass(clazz);
		// Restrictions.eq(属性名, 对象, 匹配方式)
		// 属性名 = 对象
		dc.add(Restrictions.eq(parentNameWithLetterFirstLower, parent));
		dc.addOrder(Order.desc("id"));
		return findByCriteria(dc);
	}

	@Override
	public List listByParent(Object parent, Page page) {
		String parentName = parent.getClass().getSimpleName();
		String parentNameWithLetterFirstLower = StringUtils.uncapitalize(parentName);
		DetachedCriteria dc = DetachedCriteria.forClass(clazz);
		dc.add(Restrictions.eq(parentNameWithLetterFirstLower, parent));
		dc.addOrder(Order.desc("id"));
		return findByCriteria(dc, page.getStart(), page.getCount());
	}

	@Override
	public int getTotalByParent(Object parent) {
		String parentName = parent.getClass().getSimpleName();
		String parentNameWithFirstLetterLower = StringUtils.uncapitalize(parentName);
		
		String hqlFormat = "select count(*) from %s pojo where pojo.%s = ?";
		String hql = String.format(hqlFormat, clazz.getSimpleName(), parentNameWithFirstLetterLower);
		List<Long> list = find(hql, parent);
		if (list.isEmpty()) {
			return 0;
		}
		return list.get(0).intValue();
	}

	@Override
	public List list(Object... pairParams) {
		Map<String, Object> map = new HashMap<>();
		for (int i = 0; i < pairParams.length; i += 2) {
			String key = pairParams[i].toString();
			Object value = null;
			if (i + 1 < pairParams.length) {
				value = pairParams[i+1];
			}
			map.put(key, value);
		}
		DetachedCriteria dc = DetachedCriteria.forClass(clazz);
		for (String key : map.keySet()) {
			if (map.get(key) == null) {
				// ? ? ?
				dc.add(Restrictions.isNull(key));
			} else {
				dc.add(Restrictions.eq(key, map.get(key)));
			}
		}
		dc.addOrder(Order.desc("id"));
		return findByCriteria(dc);
	}

}
