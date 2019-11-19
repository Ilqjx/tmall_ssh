package com.how2java.tmall.action;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.how2java.tmall.pojo.Category;
import com.how2java.tmall.service.CategoryService;
import com.how2java.tmall.util.ImageUtil;
import com.how2java.tmall.util.Page;

@Namespace("/")
@ParentPackage("basicstruts")
@Results({
	@Result(name = "listCategoryJsp", location = "/admin/listCategory.jsp"),
	@Result(name = "admin_category_list", type="redirect", location = "admin_category_list"),
	@Result(name = "editCategoryJsp", location = "/admin/editCategory.jsp")
})
public class CategoryAction {

	@Autowired
	private CategoryService categoryService;
	private List<Category> categorys;
	private Page page;
	private Category category;
	private File img;
	
	@Action("admin_category_list")
	public String list() {
		if (page == null) {
			page = new Page();
		}
		categorys = categoryService.list(page);
		int total = categoryService.getTotal();
		page.setTotal(total);
		return "listCategoryJsp";
	}

	@Action("admin_category_add")
	public String add() {
		categoryService.add(category);
		File imageFolder = new File(ServletActionContext.getServletContext().getRealPath("img/category"));
		File image = new File(imageFolder, category.getId() + ".jpg");
		if (!image.getParentFile().exists()) {
			image.mkdirs();
		}
		try {
			FileUtils.copyFile(img, image);
			BufferedImage bufferedImage = ImageUtil.chang2jpg(image);
			ImageIO.write(bufferedImage, "jpg", image);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "admin_category_list";
	}
	
	@Action("admin_category_delete")
	public String delete() {
		categoryService.delete(category);
		File imageFolder = new File(ServletActionContext.getServletContext().getRealPath("img/category"));
		File image = new File(imageFolder, category.getId() + ".jpg");
		image.delete();
		return "admin_category_list";
	}
	
	@Action("admin_category_edit")
	public String edit() {
		category = categoryService.getCategory(category);
		return "editCategoryJsp";
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
		return "admin_category_list";
	}
	
	public List<Category> getCategorys() {
		return categorys;
	}
	
	public void setCategorys(List<Category> categorys) {
		this.categorys = categorys;
	}
	
	public Page getPage() {
		return page;
	}
	
	public void setPage(Page page) {
		this.page = page;
	}
	
	public Category getCategory() {
		return category;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}
	
	public File getImg() {
		return img;
	}
	
	public void setImg(File img) {
		this.img = img;
	}
	
}
