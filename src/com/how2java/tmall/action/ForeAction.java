package com.how2java.tmall.action;

import org.apache.struts2.convention.annotation.Action;

public class ForeAction extends Action4Result {

	@Action("forehome")
	public String home() {
		categorys = categoryService.list();
		categoryService.fillCategory(categorys);
		categoryService.fillCategoryByRow(categorys);
		return "home.jsp";
	}
	
}
