package com.how2java.tmall.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.xwork.StringUtils;
import org.apache.struts2.StrutsStatics;
import org.springframework.beans.factory.annotation.Autowired;

import com.how2java.tmall.pojo.OrderItem;
import com.how2java.tmall.pojo.User;
import com.how2java.tmall.service.OrderItemService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class CartTotalItemNumberInterceptor extends AbstractInterceptor {
	
	@Autowired
	private OrderItemService orderItemService;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext ctx = invocation.getInvocationContext();
		HttpServletRequest request = (HttpServletRequest) ctx.get(StrutsStatics.HTTP_REQUEST);
		String contextPath = request.getContextPath();
		String uri = request.getRequestURI();
		uri = StringUtils.remove(uri, contextPath);
		if (uri.startsWith("/fore")) {
			int cartTotalItemNumber = 0;
			User user = (User) ctx.getSession().get("user");
			List<OrderItem> orderItems = orderItemService.list("user", user, "order", null);
			if (!orderItems.isEmpty()) {
				for (OrderItem orderItem : orderItems) {
					cartTotalItemNumber += orderItem.getNumber();
				}
			}
			ctx.getSession().put("contextPath", contextPath);
			ctx.getSession().put("cartTotalItemNumber", cartTotalItemNumber);
		}
		return invocation.invoke();
	}

}
