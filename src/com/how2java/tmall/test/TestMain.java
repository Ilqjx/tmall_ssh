package com.how2java.tmall.test;

import com.how2java.tmall.action.Action4Service;
import com.how2java.tmall.pojo.Category;

public class TestMain {

	public static void main(String[] args) {
		Category category = new Category();
		category.setId(140);
		new Action4Service().t2p(category);
	}
	
}
