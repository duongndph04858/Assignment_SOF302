<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="css/content.css">
<title>Tìm kiếm</title>
</head>
<body>
<jsp:include page="menu.jsp" />
	<div id="right">
		<div id="timkiem">
			<form action="search.htm?DP=${lstP.get(0).depart.id}" method="post">
				<input id="search" name="search" type="text" value=""
					placeholder="Nhập tên nhân viên hoặc tên đăng nhập" />
			</form>
		</div>
		<form style="height: 610px" action="staff.htm" method="get">
		<input type="hidden" name="DP" value="${lstP.get(0).depart.id}">
			<div id="tool">
				<h1>Nhân viên ${lstP.get(0).depart.name}</h1>
				<div id="nut">
					<button name="insertStaff">Thêm	nhân viên</button>
					<button id="btnEdit" disabled="disabled" name="editStaff">Sửa</button>
					<button id="btnDelete" disabled="disabled" name="delete">Xóa</button>
					<button id="btnExport" disabled="disabled" name="export">Xuất
						danh sách</button>
				</div>
			</div>
			<hr>
			<div id="bang">
				<h1>Không tìm thấy nhân viên hợp lệ</h1>
			</div>
		</form>
		
	</div>
</body>
</html>