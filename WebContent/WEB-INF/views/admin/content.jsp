<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="css/content.css">
</head>
<body>
	<div id="right">
		<div id="timkiem">
			<form action="search" method="post">
				<input id="search" name="search" type="text" value=""
					placeholder ="Nhập tên nhân viên" />
			</form>
		</div>
		<form style="height: 610px" action="staff.htm" method="get">
			<div id="tool">
				<h1>Nhân viên ${dp}</h1>
				<div id="nut">
					<button name="insertStaff">Thêm nhân viên</button>
					<button id="btnEdit" disabled="disabled" name="editStaff">Sửa</button>
					<button id="btnDelete" disabled="disabled" name="delete">Xóa</button>
					<button id="btnExport" disabled="disabled" name="export">Xuất
						danh sách</button>
				</div>
			</div>
			<hr>
			<div id="bang">
				<table>
					<tr style="height: 30px; font-weight: bold;">
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
					<c:forEach var="staff" items="${lstP}">
						<tr>
							<td><input type="checkbox" name="username"
								value="${staff.username }"></td>
							<td><img style="height: 100px;" src="images/${staff.photo }"></td>
							<td class="tdleft">${staff.name }</td>
							<c:choose>
								<c:when test="${staff.gender ==true }">
									<td>Nữ</td>
								</c:when>
								<c:when test="${staff.gender ==false }">
									<td>Nam</td>
								</c:when>
							</c:choose>
							<td><fmt:formatDate value="${staff.birthday }"
									pattern="dd-MM-yyyy" /></td>
							<c:choose>
								<c:when test="${staff.levelId == 1 }">
									<td>Giám đốc</td>
								</c:when>
								<c:when test="${staff.levelId == 2 }">
									<td>Phó giám đốc</td>
								</c:when>
								<c:when test="${staff.levelId == 3 }">
									<td>Trưởng phòng</td>
								</c:when>
								<c:when test="${staff.levelId == 4 }">
									<td>Nhân viên</td>
								</c:when>
							</c:choose>
							<td class="tdleft">${staff.email }</td>
							<td>${staff.phone }</td>
							<td>${staff.salary }</td>
							<td>${us}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</form>
		<c:forEach var="item" varStatus="status" begin="0" end="${page }">
			<div style="display: inline;">
				<a style="text-decoration:none ;padding:0 5px; border: 1px solid #000;"
						href="depart.htm?DP=${phong}&start=${status.index*4 }">${status.index+1 }</a>
			
			</div>
		</c:forEach>
	</div>
	<script type="text/javascript">
		var checkbox = document.getElementsByName('username');
		for (var i = 0; i < checkbox.length; i++) {
			checkbox[i].onclick = function(e) {
				var sl = 0;
				for (var i = 0; i < checkbox.length; i++) {
					if (checkbox[i].checked === true) {
						sl += 1;
					}
				}
				if (sl < 1) {
					document.getElementById('btnExport').disabled = true;
					document.getElementById('btnDelete').disabled = true;
					document.getElementById('btnEdit').disabled = true;
				} else if (sl == 1) {
					document.getElementById('btnEdit').disabled = false;
					document.getElementById('btnExport').disabled = false;
					document.getElementById('btnDelete').disabled = false;
				} else {
					document.getElementById('btnEdit').disabled = true;
				}

			};
		}
	</script>
</body>
</html>