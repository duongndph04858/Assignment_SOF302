<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="css/right.css">
</head>
<body>
<div id="right">
	<div id="timkiem">
		<form action="search" method="post">
			<input id="search" name="search" type="text" value=""
				placeholder="Nhập tên nhân viên" />
		</form>
	</div>
	<form action="depart.htm" method="post">
		<div id="tool">
			<h1>Nhân viên ${dp}</h1>
			<div id="nut">
					<button name="insertStaff">Thêm nhân viên</button>
					<button name="editStaff">Sửa</button>
					<button name="delete">Xóa</button>
					<button name="export">Xuất danh sách</button>
			</div>
		</div>
		<hr>
		<div id="bang">
			<table border="1">
				<tr>
					<td></td>
					<td>Ảnh</td>
					<td>Họ và Tên</td>
					<td>Giới Tính</td>
					<td>Ngày Sinh</td>
					<td>Cấp độ</td>
					<td>Email</td>
					<td>Điện Thoại</td>
					<td>Lương</td>
					<td>Ghi Chú</td>
				</tr>
				<c:forEach var="staff" items="${staffs}">
					<tr>
						<td><input type="checkbox" name="username"
							value="${staff.username }"></td>
						<td></td>
						<td class="tdleft">${staff.name }</td>
						<c:choose>
							<c:when test="${staff.gender ==true }">
								<td>Nữ</td>
							</c:when>
							<c:when test="${staff.gender ==false }">
								<td>Nam</td>
							</c:when>
						</c:choose>
						<td>${staff.birthday }</td>
						<td>${staff.level }</td>
						<td class="tdleft">${staff.email }</td>
						<td>${staff.phone }</td>
						<td>${staff.salary }</td>
						<td>${us}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</form>
</div>	
</body>
</html>