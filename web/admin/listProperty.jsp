<%@ page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8" isELIgnored="false" %>

<%@ include file="../include/admin/adminHeader.jsp" %>
<%@ include file="../include/admin/adminNavigator.jsp" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<title>属性管理</title>

<script>

	$(function () {
		$("form#addForm").submit(function () {
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
		<li><a href="admin_property_list?category.id=${category.id}">${category.name}</a></li>
		<li class="active">属性管理</li>
	</ol>
	<div class="listDataTableDiv">
		<table class="showTable table table-striped table-bordered table-hover table-condensed">
			<thead>
				<tr class="success">
					<th>ID</th>
					<th>属性名称</th>
					<th>编辑</th>
					<th>删除</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${propertys}" var="p">
					<tr>
						<td>${p.id}</td>
						<td>${p.name}</td>
						<td>
							<a href="admin_property_edit?property.id=${p.id}">
								<span class="glyphicon glyphicon-edit"></span>
							</a>
						</td>
						<td>
							<a deleteLink="true" href="admin_property_delete?property.id=${p.id}">
								<span class="glyphicon glyphicon-trash"></span>
							</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	<div class="pageDiv">
		<%@ include file="../include/admin/adminPage.jsp" %>
	</div>
	
	<div class="addDiv panel panel-warning">
		<div class="panel-heading">新增属性</div>
		<div class="panel-body">
			<form id="addForm" action="admin_property_add" method="post">
				<table class="addTable">
					<tr>
						<td>属性名称</td>
						<td>
							<input id="name" class="form-control" type="text" name="property.name" />
						</td>
					</tr>
					<tr class="submitTR">
						<td colspan="2" align="center">
							<input type="hidden" name="property.category.id" value="${category.id}" />
							<button class="btn btn-success">提 交</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	
</div>

<%@ include file="../include/admin/adminFooter.jsp" %>
