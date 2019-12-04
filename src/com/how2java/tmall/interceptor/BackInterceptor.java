package com.how2java.tmall.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.StrutsStatics;

import com.how2java.tmall.pojo.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class BackInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext ctx = invocation.getInvocationContext();
		HttpServletRequest request = (HttpServletRequest) ctx.get(StrutsStatics.HTTP_REQUEST);
		HttpServletResponse response = (HttpServletResponse) ctx.get(StrutsStatics.HTTP_RESPONSE);
		String contextPath = request.getContextPath();
		String uri = request.getRequestURI();
		uri = StringUtils.remove(uri, contextPath);
		if (uri.startsWith("/admin") && !uri.equals("/admin_login_login")) {
			User user = (User) ctx.getSession().get("user_admin");
			if (user == null) {
				response.sendRedirect("backLogin.jsp");
				return null;
			}
		}
		return invocation.invoke();
	}

}
