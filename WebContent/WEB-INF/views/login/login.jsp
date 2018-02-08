<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%
	String bg = "images/background" + new Random().nextInt(10) + ".jpg";
%>
<title>Đăng nhập</title>
<style type="text/css">
body {
	background: url("<%=bg%>") no-repeat center center fixed;
	background-size: cover;
}
</style>
<link type="text/css" rel="stylesheet" href="css/login.css">
</head>
<body>
	<div style="width: 100%; position: relative;">
		<div id="language">
			<%-- <form:form action="login.htm?change-language" modelAttribute="language">
				<form:select path="languages">
					<form:option value="VIE">VIE</form:option>
					<form:option value="ENG">ENG</form:option>
				</form:select>
			</form:form> --%>
		</div>
		<div id="login-form">
			<form action="login.htm" method="post">
				<div>
					<label>Tài khoản:</label> <input type="text" name="username">
				</div><br>
				<div>
					<label>Mật khẩu :</label> <input type="password" name="password">
				</div>
				<a href="login.htm?reset-password">Quên mật khẩu</a>
				<div>
					<button name="verify">Đăng nhập</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>