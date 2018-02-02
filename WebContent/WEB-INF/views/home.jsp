<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Trang chủ</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body style="width: 100%; height: 100%">
	<div>
		<jsp:include page="parten/menu.jsp"></jsp:include>
		<div id="right">
			<div id="tool">
				<h3>Top 10 nhân viên xuất sắc nhất tháng</h3>
			</div>
			<hr>
			<div id="content">
				<table border="1px solid #000">
					<tr>
						<td>STT</td>
						<td>Ảnh</td>
						<td>Họ và tên</td>						
						<td>Giới tính</td>
						<td>Ngày sinh</td>
						<td>Chức vụ</td>
						<td>Email</td>
						<td>Phòng ban</td>
					</tr>
					<tr>
						<td>1</td>
						<td></td>
						<td>Nguyễn Trà My</td>
						<td>Nữ</td>
						<td>21/10/1998</td>
						<td>Giám đốc</td>
						<td>myntph04991@fpt.edu.vn</td>
						<td>Giám đốc</td>
					</tr>
					<tr>
						<td>2</td>
						<td></td>
						<td>Nguyễn Đại Dương</td>
						<td>Nam</td>
						<td>4/11/1998</td>
						<td>Phó giám đốc</td>
						<td>duongndph04858@fpt.edu.vn</td>
						<td>Giám đốc</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</body>
</html>