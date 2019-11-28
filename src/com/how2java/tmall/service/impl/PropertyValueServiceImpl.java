package com.how2java.tmall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.how2java.tmall.pojo.Product;
import com.how2java.tmall.pojo.Property;
import com.how2java.tmall.pojo.PropertyValue;
import com.how2java.tmall.service.PropertyService;
import com.how2java.tmall.service.PropertyValueService;

@Service
public class PropertyValueServiceImpl extends BaseServiceImpl implements PropertyValueService {

	@Autowired
	private PropertyService propertyService;
	
	@Override
	public void init(Product product) {
		List<Property> propertys = propertyService.listByParent(product.getCategory());
		for (Property property : propertys) {
			// 有可能会添加新的属性
			PropertyValue propertyValue = getPropertyValue(product, property);
			if (propertyValue == null) {
				propertyValue = new PropertyValue();
				propertyValue.setProduct(product);
				propertyValue.setProperty(property);
				save(propertyValue);
			}
		}
	}
	
	public PropertyValue getPropertyValue(Product product, Property property) {
		List<PropertyValue> list = list("product", product, "property", property);
		if (list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}

}
