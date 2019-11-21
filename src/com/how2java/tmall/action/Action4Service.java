package com.how2java.tmall.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.how2java.tmall.service.CategoryService;

@Component
public class Action4Service extends Action4Pojo {

	@Autowired
	protected CategoryService categoryService;
	
	/**
	 * transient to persistent
	 * 瞬时对象转换为持久对象
	 * @param object
	 */
	public void t2p(Object object) {
		try {
			Class clazz = object.getClass();
			int id = (int) clazz.getMethod("getId").invoke(object);
			Object persistentBean = categoryService.get(clazz, id);
			String beanName = clazz.getSimpleName();
			getClass().getMethod("set" + beanName, clazz).invoke(this, persistentBean);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}























