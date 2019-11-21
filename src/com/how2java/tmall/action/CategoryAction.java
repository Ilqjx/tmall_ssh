package com.how2java.tmall.action;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;

import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.util.ImageUtil;
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
		// ServletActionContext 获取 ServletAction 上下文
		// getServletContext() 获取 Servlet 上下文
		// getRealPath() 获取 "img/category" 的绝对路径
		File imageFolder = new File(ServletActionContext.getServletContext().getRealPath("img/category"));
		File image = new File(imageFolder, category.getId() + ".jpg");
		image.getParentFile().mkdirs();
		try {
			FileUtils.copyFile(img, image);
			BufferedImage bufferedImage = ImageUtil.chang2jpg(image);
			ImageIO.write(bufferedImage, "jpg", image);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "listCategoryPage";
	}
	
	@Action("admin_category_delete")
	public String delete() {
		categoryService.delete(category);
		File imageFolder = new File(ServletActionContext.getServletContext().getRealPath("img/category"));
		File image = new File(imageFolder, category.getId() + ".jpg");
		image.delete();
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
		if (img != null) {
			File imageFolder = new File(ServletActionContext.getServletContext().getRealPath("img/category"));
			File image = new File(imageFolder, category.getId() + ".jpg");
			try {
				FileUtils.copyFile(img, image);
				BufferedImage bufferedImage = ImageUtil.chang2jpg(image);
				ImageIO.write(bufferedImage, "jpg", image);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "listCategoryPage";
	}
	
}
