package com.how2java.tmall.action;

import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

@Namespace("/")
@ParentPackage("basicstruts")
@Results({
	// �������
	@Result(name = "listCategory", location = "/admin/listCategory.jsp"),
	@Result(name = "editCategory", location = "/admin/editCategory.jsp"),
	@Result(name = "listCategoryPage", location = "admin_category_list", type = "redirect"),
	
	// ���Թ���
	@Result(name = "listProperty", location = "/admin/listProperty.jsp"),
	@Result(name = "editProperty", location = "/admin/editProperty.jsp"),
	@Result(name = "listPropertyPage", location = "admin_property_list?category.id=${property.category.id}", type = "redirect")
})
public class Action4Result extends Action4Service {

}
