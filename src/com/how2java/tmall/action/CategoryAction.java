package com.how2java.tmall.action;

import org.apache.struts2.convention.annotation.Action;

import com.how2java.tmall.util.Page;

public class CategoryAction extends Action4Result {

	@Action("admin_category_list")
	public String list() {
		if (page == null) {
			page = new Page();
		}
		int total = categoryService.getTotal();
		page.setTotal(total);
		categorys = categoryService.list(page);
		return "listCategory";
	}

	@Action("admin_category_add")
	public String add() {
		categoryService.save(category);
		uploadImg(category, "img/category");
		return "listCategoryPage";
	}
	
	@Action("admin_category_delete")
	public String delete() {
		categoryService.delete(category);
		deleteImg(category, "img/category");
		return "listCategoryPage";
	}
	
	@Action("admin_category_edit")
	public String edit() {
		t2p(category);
		return "editCategory";
	}
	
	@Action("admin_category_update")
	public String update() {
		categoryService.update(category);
		uploadImg(category, "img/category");
		return "listCategoryPage";
	}
	
}
