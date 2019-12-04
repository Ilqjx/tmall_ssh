<%@ page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8" isELIgnored="false" %>

<%@ include file="../include/admin/adminHeader.jsp" %>
<%@ include file="../include/admin/adminNavigator.jsp" %>

<title>编辑分类</title>

<script>

	$(function () {
		$("form#editForm").submit(function () {
			if (!checkEmpty("name", "分类图片")) {
				return false;
			}
			return true;
		})
	})

</script>

<div class="workingArea">
	<ol class="breadcrumb">
		<li><a href="admin_category_list">所有分类</a></li>
		<li class="active">编辑分类</li>
	</ol>
	<div class="editDiv panel panel-warning">
		<div class="panel-heading">编辑分类</div>
		<div class="panel-body">
			<form id="editForm" action="admin_category_update" method="post" enctype="multipart/form-data">
				<table class="editTable">
					<tr>
						<td>分类名称</td>
						<td>
							<input id="name" class="form-control" type="text" name="category.name" value="${category.name}" />
						</td>
					</tr>
					<tr>
						<td>分类图片</td>
						<td>
							<input id="categoryPic" type="file" accept="image/*" name="img" />
						</td>
					</tr>
					<tr class="submitTR">
						<td colspan="2" align="center">
							<input type="hidden" name="category.id" value="${category.id}" />
							<button class="btn btn-success">提 交</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</div>

<%@ include file="../include/admin/adminFooter.jsp" %>
