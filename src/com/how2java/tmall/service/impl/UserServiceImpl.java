package com.how2java.tmall.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

import com.how2java.tmall.pojo.User;
import com.how2java.tmall.service.UserService;

@Service
public class UserServiceImpl extends BaseServiceImpl implements UserService {

	@Override
	public boolean isExist(User user) {
		List<User> list = list("name", user.getName());
		if (!list.isEmpty()) {
			return true;
		}
		return false;
	}

}
