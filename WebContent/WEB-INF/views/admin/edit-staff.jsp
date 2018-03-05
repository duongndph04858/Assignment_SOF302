<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${pageContext.servletContext.contextPath }/">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="css/style.css">
<link type="text/css" rel="stylesheet" href="css/insertStaff.css">
<title>Thêm Nhân Viên</title>
</head>
<body style="width: 100%; height: 100%">
	<div id="right">
		<h1 style="margin-bottom: 40px;">Thông tin nhân viên</h1>
		<form:form action="staff.htm" method="post"
			enctype="multipart/form-data" modelAttribute="user">
			<table>
				<tr>

					<td colspan="2">
						<div style="height: 200px;">
							<label>Ảnh</label>
							<form:input path="photo" type="file" class="image_uploads"
								name="image_uploads"></form:input>
							<div style="text-align: center;" class="preview">
								<img src="images/${user.photo }">
								<p>${message }</p>
							</div>
						</div>
					</td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td><label>Họ Và Tên:</label></td>
					<td><form:input path="name" /></td>
					<td><label>Tài khoản:</label></td>
					<td><form:input path="username" readonly="true"
							name="username" type="text" /></td>
				</tr>
				<tr>
					<td><label>Giới Tính:</label></td>
					<td><input class="gioitinh" name="gender" value="0"
						type="radio" checked="checked"><label
						style="margin: 10px;">Nam</label> <input class="gioitinh"
						value="1" name="gender" type="radio"><label
						style="margin: 10px;">Nữ</label></td>
					<td><label>Ngày Sinh:</label></td>
					<td><form:input path="birthday" name="dob" type="text" /></td>
				</tr>
				<tr>
					<td><label>Cấp độ:</label></td>
					<td style="padding-left: 30px;"><select name="level">
					<option value="1">Giám đốc</option>
							<option value="2">Phó Giám đốc</option>
							<option value="3">Trưởng Phòng</option>
							<option value="4">Nhân Viên</option>
					</select></td>
					<td><label>Phòng ban: </label></td>
					<td style="padding-left: 30px;"><select name="depart">
							<c:forEach var="depart" items="${departs }">
								<option value="${depart.id}">${depart.name}</option>
							</c:forEach>
					</select></td>
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
					<td><form:input path="notes" name="notes" type="text" /></td>
				</tr>
				<tr>
					<td colspan="4">
						<div id="button">
							<button name="update">Lưu</button>
							<button name="cancer">Hủy</button>
						</div>
					</td>
					<td></td>
				</tr>
			</table>
		</form:form>
	</div>
	<div>
		<jsp:include page="${param.view }"></jsp:include>
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