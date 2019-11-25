<!DOCTYPE html>

<%@ page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8" isELIgnored="false" %>

<script type="text/javascript" src="js/jquery/2.0.0/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap/3.3.6/bootstrap.min.js"></script>
<link href="css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet" />
<link href="css/back/style.css" rel="stylesheet" />

<script>

	function checkEmpty(id, name) {
		var value = $("#" + id).val();
		if (value.length == 0) {
			alert(name + "不能为空");
			$("#" + id).focus();
			return false;
		}
		return true;
	}
	
	function checkNumber(id, name) {
		if (!checkEmpty(id, name)) {
			return false;
		}
		var value = $("#" + id).val();
		if (isNaN(value)) {
			alert(name + "必须是数字");
			$("#" + id).focus();
			return false;
		}
		return true;
	}
	
	function checkInt(id, name) {
		if (!checkEmpty(id, name)) {
			return false;
		}
		var value = $("#" + id).val();
		if (value != parseInt(value)) {
			alert(name + "必须是整数");
			$("#" + id).focus();
			return false;
		}
		return true;
	}
	
	$(function () {
		$("a").click(function () {
			var deleteLink = $(this).attr("deleteLink");
			if (deleteLink == "true") {
				var confirmDelete = confirm("确认删除？");
				if (confirmDelete) {
					return true;
				}
				return false;
			}
		})
	})

</script>
