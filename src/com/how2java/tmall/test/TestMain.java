package com.how2java.tmall.test;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;

import com.how2java.tmall.service.CategoryService;

public class TestMain {

	@Autowired
	private static CategoryService categoryService;
	
	public static void main(String[] args) {
		String path = "D:\\QQ\\python.txt";
		File file = new File(path);
		if (file.exists()) {
			System.out.println("file exist");
		} else {
			System.out.println("file not exist");
		}
	}
	
}
