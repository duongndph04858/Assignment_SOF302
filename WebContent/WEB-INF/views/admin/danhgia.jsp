<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Thông tin nhân viên</title>
<style type="text/css">
* {
	margin: 0;
	padding: 0
}

#right {
	width: 81%;
	height: 635px;
	float: left;
	margin-left: 10px;
	border-bottom: 3px solid #ccc;
	position: relative;
	text-align: center;
}

h3 {
	font-size: 30px;
	margin: 20px 10px;
}

#r_left {
	width: 60%;
	float: left;
}

#r_right {
	width: 40%;
	float: left;
}

table {
	width: 80%;
	height: 60%;
	font-size: 18px;
	padding-top: 100px;
	margin-left: 180px;
}

tr {
	width: 100px;
	padding-top: 30px;
}

td {
	width: 100px;
}

tr, td {
	text-align: left;
	padding: 10px;
}

#img {
	width: 150px;
	height: 150px;
	text-align: center;
	margin-top: 110px;
	margin-left: 20px;
}

#rspass {
	width: 150px;
	height: 30px;
	margin-top: 100px;
	margin-right: 240px;
}
</style>
</head>
<body style="width: 100%; height: 100%">
	<jsp:include page="menu.jsp" />
	<div id="right">
		<h3>Thông tin cá nhân</h3>
		<hr>
		<div id="r_left">
			<table>
				<tr>
					<td>Họ và tên:</td>
					<td>${tk.name }</td>
				</tr>

				<tr>
					<td>Địa chỉ</td>
					<td>${tk.address }</td>
				</tr>

				<tr>
					<td>Số điện thoại</td>
					<td>${tk.phone }</td>
				</tr>

				<tr>
					<td>Giới tính</td>
					<c:choose>
						<c:when test="${tk.gender ==true }">
							<td>Nữ</td>
						</c:when>
						<c:when test="${tk.gender ==false }">
							<td>Nam</td>
						</c:when>
					</c:choose>
				</tr>

				<tr>
					<td>Ngày sinh</td>
					<td><fmt:formatDate value="${tk.birthday }"
							pattern="dd/MM/yyyy" /></td>
				</tr>

				<tr>
					<td>Mức lương</td>
					<td>${tk.salary }</td>
				</tr>

				<tr>
					<td>Email</td>
					<td>${tk.email }</td>
				</tr>
				
				<tr>
					<td>Lý do</td>
					<td><input type="textarea" > </td>
				</tr>
			</table>

		</div>
		<div id="r_right">
			<div id="img">
				<img width="150px" src="images/${tk.photo}">
			</div>
			<button class="appreciate">Khen thưởng</button>
			<button class="appreciate">Kỷ luật</button>

		</div>
	</div>
</body>
</html>