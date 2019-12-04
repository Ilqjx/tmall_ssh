package com.how2java.tmall.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;

import com.how2java.tmall.pojo.User;
import com.opensymphony.xwork2.ActionContext;

public class BackAction extends Action4Result {
	
	@Action("admin_login_login")
	public String login() {
		if (!"root".equals(user.getName())) {
			msg = "账号不正确";
			return "backLogin.jsp";
		}
		List<User> users = userService.list("name", "root");
		if (!users.isEmpty()) {
			User user_ = users.get(0);
			if (!user_.getPassword().equals(user.getPassword())) {
				msg = "密码不正确";
				return "backLogin.jsp";
			}
			ActionContext.getContext().getSession().put("user_admin", user);
			return "listCategoryPage";
		}
		msg = "账号密码不正确";
		return "backLogin.jsp";
	}
	
	@Action("admin_login_logout")
	public String logout() {
		ActionContext.getContext().getSession().remove("user_admin");
		return "backLogin.jsp";
	}

}
