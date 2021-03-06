<%@ page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8" isELIgnored="false" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ include file="../include/admin/adminHeader.jsp" %>
<%@ include file="../include/admin/adminNavigator.jsp" %>

<title>产品管理</title>

<script>

	$(function () {
		$("form#addForm").submit(function () {
			if (!checkEmpty("name", "产品名称")) {
				return false;
			}
			if (!checkEmpty("subTitle", "产品小标题")) {
				return false;
			}
			if (!checkNumber("originalPrice", "原价格")) {
				return false;
			}
			if (!checkNumber("promotePrice", "优惠价格")) {
				return false;
			}
			if (!checkInt("stock", "库存")) {
				return false;
			}
			return true;
		})
	})
	
</script>

<div class="workingArea">
	<ol class="breadcrumb">
		<li><a href="admin_category_list">所有分类</a></li>
		<li><a href="admin_product_list?category.id=${category.id}">${category.name}</a></li>
		<li class="active">产品管理</li>
	</ol>
	<div class="listDataTableDiv">
		<table class="showTable table table-striped table-bordered table-hover table-condensed">
			<thead >
				<tr class="success">
					<th>ID</th>
					<th>图片</th>
					<th>产品名称</th>
					<th>产品小标题</th>
					<th width="53px">原价格</th>
					<th width="80px">优惠价格</th>
					<th width="80px">库存数量</th>
					<th width="80px">图片管理</th>
					<th width="80px">设置属性</th>
					<th width="42px">编辑</th>
					<th width="42px">删除</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${products}" var="p">
					<tr>
						<td>${p.id}</td>
						<td>
							<c:if test="${!empty p.firstProductImage}">
								<img width="40px" src="img/productSingleImage/${p.firstProductImage.id}.jpg">
							</c:if>
						</td>
						<td>${p.name}</td>
						<td>${p.subTitle}</td>
						<td>${p.originalPrice}</td>
						<td>${p.promotePrice}</td>
						<td>${p.stock}</td>
						<td>
							<a href="admin_productImage_list?product.id=${p.id}">
								<span class="glyphicon glyphicon-picture"></span>
							</a>
						</td>
						<td>
							<a href="admin_propertyValue_edit?product.id=${p.id}">
								<span class="glyphicon glyphicon-th-list"></span>
							</a>
						</td>
						<td>
							<a href="admin_product_edit?product.id=${p.id}">
								<span class="glyphicon glyphicon-edit"></span>
							</a>
						</td>
						<td>
							<a deleteLink="true" href="admin_product_delete?product.id=${p.id}">
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
		<div class="panel-heading">新增产品</div>
		<div class="panel-body">
			<form id="addForm" action="admin_product_add" method="post">
				<table class="addTable">
					<tr>
						<td>产品名称</td>
						<td>
							<input id="name" class="form-control" type="text" name="product.name" />
						</td>
					</tr>
					<tr>
						<td>产品小标题</td>
						<td>
							<input id="subTitle" class="form-control" type="text" name="product.subTitle" />
						</td>
					</tr>
					<tr>
						<td>原价格</td>
						<td>
							<input id="originalPrice" class="form-control" type="text" name="product.originalPrice" value="99" />
						</td>
					</tr>
					<tr>
						<td>优惠价格</td>
						<td>
							<input id="promotePrice" class="form-control" type="text" name="product.promotePrice" value="9.9" />
						</td>
					</tr>
					<tr>
						<td>库存</td>
						<td>
							<input id="stock" class="form-control" type="text" name="product.stock" value="99" />
						</td>
					</tr>
					<tr class="submitTR">
						<td colspan="2" align="center">
							<input type="hidden" name="product.category.id" value="${category.id}" />
							<button type="submit" class="btn btn-success">提 交</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</div>

<%-- <%@ include file="../include/admin/adminFooter.jsp" %> --%>
