<%@ page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8" isELIgnored="false" %>

<%@ include file="../include/admin/adminHeader.jsp" %>
<%@ include file="../include/admin/adminNavigator.jsp" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script>
	
	$(function () {
		$("input.pvInput").focus(function () {
			var parentSpan = $(this).parent("span");
			parentSpan.css("border", "1px solid #FFFF00");
		})
		
		$("input.pvInput").blur(function () {
			var pvid = $(this).attr("pvid");
			var value = $(this).val();
			var parentSpan = $(this).parent("span");
			var url = "admin_propertyValue_update";
			
			$.post(
				url,
				{"propertyValue.id" : pvid, "propertyValue.value" : value},
				function (res) {
					if (res == "success") {
						parentSpan.css("border", "1px solid #008000");
					} else {
						parentSpan.css("border", "1px solid #FF0000");
					}
				}
			)
		})
	})
	
</script>

<title>编辑产品属性值</title>

<div class="workingArea">
	<ol class="breadcrumb">
		<li><a href="admin_category_list">所有分类</a></li>
		<li><a href="admin_product_list?category.id=${product.category.id}">${product.category.name}</a></li>
		<li class="active">${product.name}</li>
		<li class="active">编辑产品属性</li>
	</ol>
	<div class="pvAllDiv">
		<c:forEach items="${propertyValues}" var="pv">
				<div class="pvDiv">
					<span class="pvName">${pv.property.name}</span>
					<span class="pvValue">
						<input class="pvInput" pvid="${pv.id}" type="text" value="${pv.value}" />
					</span>
				</div>
		</c:forEach>
		<div style="clear: both;"></div>
	</div>
</div>

<%@ include file="../include/admin/adminFooter.jsp" %>
