<%@ page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8" isELIgnored="false" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<title>用户注册</title>

<script>

	$(function () {
		<c:if test="${!empty msg}">
			$("span.errorMessage").html("${msg}");
			$("div.registerErrorMessageDiv").show();
		</c:if>
		
		$("form#registerForm").submit(function () {
			if ($("input#name").val().length == 0) {
				$("span.errorMessage").html("请输入用户名");
				$("div.registerErrorMessageDiv").show();
				return false;
			}
			if ($("input#password").val().length == 0) {
				$("span.errorMessage").html("请输入密码");
				$("div.registerErrorMessageDiv").show();
				return false;
			}
			if ($("input#repeatpassword").val().length == 0) {
				$("span.errorMessage").html("请输入重复密码");
				$("div.registerErrorMessageDiv").show();
				return false;
			}
			if ($("input#password").val() != $("input#repeatpassword").val()) {
				$("span.errorMessage").html("重复密码不一致");
				$("div.registerErrorMessageDiv").show();
				return false;
			}
			if ($("input#password").val().length < 6) {
				$("span.errorMessage").html("密码长度不能小于6");
				$("div.registerErrorMessageDiv").show();
				return false;
			}
			return true;
		})
		
		$("form#registerForm input").keyup(function () {
			$("div.registerErrorMessageDiv").hide();
		})
	})
	
</script>

<link href="css/fore/page/registerPage.css" rel="stylesheet">

<form action="foreregister" method="post" id="registerForm">
	<div class="registerDiv">
		<div class="registerErrorMessageDiv">
			<div class="alert alert-danger" role="alert">
				<span class="errorMessage"></span>
			</div>
		</div>
		<table align="center" class="registerTable">
		    <tbody>
		        <tr>
		            <td class="registerTip registerTableLeftTD">设置会员名</td>
		            <td></td>
		        </tr>
		        <tr>
		            <td class="registerTableLeftTD">登陆名</td>
		            <td class="registerTableRightTD">
		                <input id="name" type="text" placeholder="会员名一旦设置成功，无法修改" name="user.name" />
		            </td>
		        </tr>
		        <tr>
		            <td class="registerTip registerTableLeftTD">设置登陆密码</td>
		            <td class="registerTableRightTD">登陆时验证，保护账号信息</td>
		        </tr>
		        <tr>
		            <td class="registerTableLeftTD">登陆密码</td>
		            <td class="registerTableRightTD">
		                <input id="password" type="password" placeholder="设置你的登陆密码" name="user.password" />
		            </td>
		        </tr>
		        <tr>
		            <td class="registerTableLeftTD">密码确认</td>
		            <td class="registerTableRightTD">
		                <input id="repeatpassword" type="password" placeholder="请再次输入你的密码" />
		            </td>
		        </tr>
		        <tr>
		            <td class="registerButtonTD" colspan="2">
	                	<button type="submit">提 交</button>
		            </td>
		        </tr>
		    </tbody>
		</table>
		<div style="height: 50px;"></div>
	</div>
</form>
