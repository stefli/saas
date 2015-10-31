<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>SAAS测试系统 - ${tenantKey }</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value="resources/css/common.css" />">
</head>
<body style="overflow: hidden; background-color: #3c8dbc;">
	<form name="frmLogin" action="j_spring_security_check" method="post">
		<input name="${tenantKeyName }" type="hidden" value="${tenantKey }" />
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
		<div class="login">
			<div class="logo">
				<img src="<c:url value="resources/images/header.png" />" />
			</div>
			<c:if test="${errors!=null}">
				<div class="error">出错啦! ${errors}</div>
			</c:if>
			<div class="content">
				<div class="input-section">
					<div class="login-label">用户名:</div>
					<span> <img
						src="<c:url value="resources/images/user.png" />" />
					</span> <input class="login-input" type="text" name="j_username"
						value="t1" placeholder="请输入用户名" />
				</div>
				<div class="input-section">
					<div class="login-label">密码:</div>
					<span> <img
						src="<c:url value="resources/images/lock.png" />" />
					</span> <input class="login-input" type="password" name="j_password"
						value="password" placeholder="请输入密码" />
				</div>
				<div class="login-button-group">
					<input class="login-button" type="submit" value="登 录 系 统" />
				</div>
				<div class="remember-section">
					<input type="checkbox" id="rememberMe" name="rememberMe" /> <label
						for="rememberMe">记住密码</label>
				</div>
				<div class="other-section">
					<a href="<c:url value="forgot"/>" />忘记密码?</a> | <a
						href="<c:url value="signup"/>" />免费注册</a>
				</div>
				<div class="other-section">
					<span>其他账号登录：</span> <a href="<c:url value="signup"/>" />QQ</a>&nbsp;&nbsp;&nbsp;<a
						href="<c:url value="signup"/>" />微博</a>
				</div>
			</div>
		</div>
	</form>
	<div class="copyright">© 2015 版权所有</div>
</body>
</html>