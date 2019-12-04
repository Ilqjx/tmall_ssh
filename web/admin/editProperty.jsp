<%@ page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8" isELIgnored="false" %>

<%@ include file="../include/admin/adminHeader.jsp" %>
<%@ include file="../include/admin/adminNavigator.jsp" %>

<title>编辑属性</title>

<script>

	$(function () {
		$("form#editForm").submit(function () {
			if (!checkEmpty("name", "属性名称")) {
				return false;
			}
			return true;
		})
	})

</script>

<div class="workingArea">
	<ol class="breadcrumb">
		<li><a href="admin_category_list">所有分类</a></li>
		<li><a href="admin_property_list?category.id=${property.category.id}">${property.category.name}</a></li>
		<li class="active">编辑属性</li>
	</ol>
	<div class="editDiv panel panel-warning">
		<div class="panel-heading">编辑属性</div>
		<div class="panel-body">
			<form id="editForm" action="admin_property_update" method="post">
				<table class="editTable">
					<tr>
						<td>属性名称</td>
						<td>
							<input id="name" class="form-control" type="text" name="property.name" value="${property.name}" />
						</td>
					</tr>
					<tr class="submitTR">
						<td colspan="2" align="center">
							<input type="hidden" name="property.id" value="${property.id}" />
							<input type="hidden" name="property.category.id" value="${property.category.id}" />
							<button class="btn btn-success">提 交</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</div>

<%@ include file="../include/admin/adminFooter.jsp" %>
