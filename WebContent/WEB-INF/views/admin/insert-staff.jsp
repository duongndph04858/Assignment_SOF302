<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${pageContext.servletContext.contextPath }/">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="css/insertStaff.css" />
<link type="text/css" rel="stylesheet" href="css/style.css" />
<title>Thêm Nhân Viên</title>
</head>
<body style="width: 100%; height: 100%">
	<div id="right">
		<h1>Thêm Nhân Viên ${dp }</h1>
		<form action="staff.htm?DP=${phong }" method="post"
			enctype="multipart/form-data">
			<table>
				<tr style="height: 250px">
					<td colspan="2"><div style="height: 200px;">
							<label>Ảnh</label> <input type="file" class="image_uploads"
								name="image_uploads">
							<div style="text-align: center;" class="preview">
								<p>Chưa có file được chọn</p>
							</div>
						</div></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td><label>Họ Và Tên:</label></td>
					<td><input name="fullname" type="text"></td>
					<td><label>Tài khoản:</label></td>
					<td><input name="username" type="text"></td>
				</tr>
				<tr>
					<td><label>Giới Tính:</label></td>
					<td><input class="gioitinh" name="gender" type="radio"
						checked="checked"><label style="margin: 10px;">Nam</label>
						<input class="gioitinh" name="gender" type="radio"><label
						style="margin: 10px;">Nữ</label></td>
					<td><label>Ngày Sinh:</label></td>
					<td><input name="dob" type="date"></td>
				</tr>
				<tr>
					<td><label>Cấp độ:</label></td>
					<td style="padding-left: 30px;"><select name="level">
							<option>Trưởng Phòng</option>
							<option>Nhân Viên</option>
					</select></td>
					<td><label>Phòng ban: </label></td>
					<td><input type="text" name="depart" readonly="readonly"
						value="${dp }"></td>
				</tr>
				<tr>
					<td><label>Email</label></td>
					<td><input name="email" type="text"></td>
					<td><label>Điện Thoại</label></td>
					<td><input name="phone" type="text"></td>
				</tr>
				<tr>
					<td><label>Lương</label></td>
					<td><input name="salary" type="text"></td>
					<td><label>Ghi Chú</label></td>
					<td><input name="notes" type="text"></td>
				</tr>
				<tr>
					<td colspan="4">
						<div id="button">
							<button name="insert">Thêm</button>
							<button name="cancer">Hủy</button>
						</div>
					</td>
					<td></td>
				</tr>
			</table>
		</form>
	</div>
	<script type="text/javascript">
		var input = document.querySelector('.image_uploads');
		var preview = document.querySelector('.preview');
		input.addEventListener('change', updateImageDisplay);
		function updateImageDisplay() {
			while (preview.firstChild) {
				preview.removeChild(preview.firstChild);
			}
			var curFiles = input.files;
			var list = document.createElement('ol');
			preview.appendChild(list);
			for (var i = 0; i < curFiles.length; i++) {
				var listItem = document.createElement('li');
				var para = document.createElement('p');
				para.textContent = curFiles[i].name;
				var image = document.createElement('img');
				image.src = window.URL.createObjectURL(curFiles[i]);
				listItem.appendChild(image);
				listItem.appendChild(para);
				list.appendChild(listItem);
			}
		}
	</script>

</body>
</html>