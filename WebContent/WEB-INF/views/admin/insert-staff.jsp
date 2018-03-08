<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${pageContext.servletContext.contextPath}/">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="css/insertStaff.css" />
<link type="text/css" rel="stylesheet" href="css/style.css" />
<title>Thêm Nhân Viên</title>
</head>
<body style="width: 100%; height: 100%">
	<jsp:include page="menu.jsp" />
	<div id="right">
		<h1>Thêm Nhân Viên</h1>
		<form:form action="staff/insertStaff.htm" method="post"
			enctype="multipart/form-data" modelAttribute="stf">
			<table>
				<tr style="height: 250px">
					<td colspan="2"><div style="height: 200px;">
							<label>Ảnh</label>
							<form:input path="photo" type="file" class="image_uploads"
								name="image_uploads" />
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
					<td><form:input path="name" name="fullname" type="text" /></td>
					<td><label>Tài khoản:</label></td>
					<td><form:input path="username" name="username" type="text" /></td>
				</tr>
				<tr>
					<td><label>Giới Tính:</label></td>
					<td><form:radiobutton cssStyle="width:10px;" path="gender"
							value="true" label="Nữ" /> <form:radiobutton
							cssStyle="width:10px;" path="gender" value="false" label="Nam" />
					<td><label>Ngày Sinh:</label></td>
					<td><form:input path="birthday" name="birhtday" type="text" /></td>
				</tr>
				<tr>
					<td><label>Cấp độ:</label></td>
					<td style="padding-left: 30px;"><form:select path="level">
							<form:option value="1" label="Giám đốc"></form:option>
							<form:option value="2" label="Phó Giám đốc"></form:option>
							<form:option value="3" label="Trưởng phòng"></form:option>
							<form:option value="4" label="Nhân viên"></form:option>
						</form:select>
					<td><label>Phòng ban: </label></td>
					<td><form:select cssStyle="margin-left:30px;" path="depart">
							<form:option value="GD" label="Phòng Giám đốc"></form:option>
							<form:option value="IT" label="Phòng IT"></form:option>
							<form:option value="NS" label="Phòng Nhân sự"></form:option>
							<form:option value="KT" label="Phòng Kế toán"></form:option>
						</form:select></td>
				</tr>
				<tr>
					<td><label>Email</label></td>
					<td><form:input path="email" name="email" type="text" /></td>
					<td><label>Điện Thoại</label></td>
					<td><form:input path="phone" name="phone" type="text" /></td>
				</tr>
				<tr>
					<td><label>Lương</label></td>
					<td><form:input path="salary" name="salary" type="text" /></td>
					<td><label>Ghi Chú</label></td>
					<td><input name="notes" type="text" /></td>
				</tr>
				<tr>
					<td colspan="4">
						<div id="button">
							<button type="submit">Thêm</button>
							<button name="cancer">Hủy</button>
						</div>
					</td>
					<td></td>
				</tr>
			</table>
		</form:form>
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