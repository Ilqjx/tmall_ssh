package com.how2java.tmall.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.how2java.tmall.service.CategoryService;

public class Action4Service extends Action4Pojo {

	@Autowired
	protected CategoryService categoryService;
	
	/**
	 * transient to persistent
	 * ˲ʱ����ת��Ϊ�־ö���
	 * @param object
	 */
	public void t2p(Object object) {
		try {
			Class clazz = object.getClass();
			int id = (int) clazz.getMethod("getId").invoke(object);
			String pojoSimpleName = clazz.getSimpleName();
			Object persistentObject = categoryService.get(clazz, id);
			this.getClass().getMethod("set" + pojoSimpleName, clazz).invoke(this, persistentObject);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
}
