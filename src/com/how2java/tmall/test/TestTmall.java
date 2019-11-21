package com.how2java.tmall.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.how2java.tmall.action.Action4Service;
import com.how2java.tmall.pojo.Category;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestTmall {

	@Autowired
	private Action4Service action4Service;
	
	@Test
	public void testT2p() {
		Category category = new Category();
		category.setId(140);
		action4Service.t2p(category);
	}
	
}
