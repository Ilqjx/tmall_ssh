package com.how2java.tmall.action;

import org.apache.struts2.convention.annotation.Action;
import org.springframework.web.util.HtmlUtils;

public class ForeAction extends Action4Result {

	@Action("forehome")
	public String home() {
		categorys = categoryService.list();
		categoryService.fillCategory(categorys);
		categoryService.fillCategoryByRow(categorys);
		return "home.jsp";
	}
	
	@Action("foreregister")
	public String register() {
		user.setName(HtmlUtils.htmlEscape(user.getName()));
		if (userService.isExist(user)) {
			msg = "用户名已被使用  请重新输入";
			return "register.jsp";
		}
		userService.save(user);
		return "registerSuccess.jsp";
	}
	
}
