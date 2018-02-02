<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%
	String bg = "images/background" + request.getAttribute("stt") + ".jpg";
%>
<title>Đăng nhập</title>
<style type="text/css">
#login-form {
	position: absolute;
	top: 30px;
	right: 50px;
	font-size: 18px;
	text-align: center;
}

#login-form input {
	height: 25px;
	border-radius: 15px;
	border: 1px solid #000;
	padding-left: 10px;
}

#login-form a {
	margin-top: 0px;
	margin-left: 150px;
	line-height: 30px;
}

#login-form button {
	line-height: 20px;
	border-radius: 5px;
	font-weight: bold;
	border: 1px solid #000;
	vertical-align: middle;
}

#login-form button:hover {
	cursor: pointer;
	background: aqua;
}

#language select {
	width: 75px;
	padding-left: 20px;
}

#language select:hover {
	cursor: pointer;
}

#language option:hover {
	cursor: pointer;
}

body {
	background: url("<%=bg%>") no-repeat center center fixed;
	background-size: cover;
}
</style>
</head>
<body>
	<div style="width: 100%; position: relative;">
		<div id="language">
			<form action="change-language">
				<select>
					<option value="VIE">VIE</option>
					<option value="ENG">ENG</option>
				</select>
			</form>
		</div>
		<div id="login-form">
			<form action="login/verify.htm" method="post">
				<div>
					<label>Tài khoản:</label> <input type="text" name="username">
				</div><br>
				<div>
					<label>Mật khẩu :</label> <input type="password" name="password">
				</div>
				<a href="login.htm?reset-password">Quên mật khẩu</a>
				<div>
					<button>Đăng nhập</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>