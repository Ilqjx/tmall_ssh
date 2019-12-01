package com.how2java.tmall.service;

import com.how2java.tmall.pojo.User;

public interface UserService extends BaseService {
	
	public boolean isExist(String name);
	
	public User getUser(User user);

}
