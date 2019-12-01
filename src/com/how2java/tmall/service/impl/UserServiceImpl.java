package com.how2java.tmall.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.how2java.tmall.pojo.User;
import com.how2java.tmall.service.UserService;

@Service
public class UserServiceImpl extends BaseServiceImpl implements UserService {

	@Override
	public boolean isExist(String name) {
		List<User> list = list("name", name);
		if (!list.isEmpty()) {
			return true;
		}
		return false;
	}

	@Override
	public User getUser(User user) {
		List<User> list = list("name", user.getName(), "password", user.getPassword());
		if (list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}

}
