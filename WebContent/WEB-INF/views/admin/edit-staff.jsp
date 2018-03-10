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
<link type="text/css" rel="stylesheet" href="css/style.css">
<link type="text/css" rel="stylesheet" href="css/insertStaff.css">
<title>Cập nhật thông tin nhân viên</title>
</head>
<body style="width: 100%; height: 100%">
	<jsp:include page="menu.jsp" />
	<div id="right">
		<h1 style="margin-bottom: 40px;">Thông tin nhân viên</h1>
		<form:form action="staff.htm" method="post"
			enctype="multipart/form-data" modelAttribute="st">
			<table>
				<tr>
					<td colspan="2">
						<div style="height: 170px;">
							<label>Ảnh</label>
							<form:input cssStyle="width:250px" path="photo"
								autocomplete="true" type="file" class="image_uploads"
								name="image_uploads"></form:input>
							<div style="text-align: center;" class="preview">
								<img src="images/${st.photo }">
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
					<td><form:input required="required" path="name" /></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td><label>Địa chỉ:</label></td>
					<td><form:input required="required" path="address" /></td>
					<td><label>Tài khoản:</label></td>
					<td><form:input path="username" required="required" readonly="true"
							name="username" type="text" /></td>
				</tr>
				<tr>
					<td><label>Giới Tính:</label></td>
					<td><form:radiobutton cssStyle="width:10px;" path="gender"
							value="true" label="Nữ" /> <form:radiobutton
							cssStyle="width:10px;" path="gender" value="false" label="Nam" /></td>
					<td><label>Ngày Sinh:</label></td>
					<td><form:input path="birthday" required="required" name="dob" type="text" /></td>
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
					<td><form:input path="email" required="required" name="email" type="email" /></td>
					<td><label>Điện Thoại</label></td>
					<td><form:input path="phone" required="required" name="phone" type="text" /></td>
				</tr>
				<tr>
					<td><label>Lương</label></td>
					<td><form:input path="salary" required="required" name="salary" type="text" /></td>
					<td><label>Ghi Chú</label></td>
					<td><form:input path="notes" name="notes" type="text" /></td>
				</tr>
				<tr>
					<td colspan="4">
						<div id="button">
							<button type="submit" name="update">Lưu</button>
							<button type="button" onclick="back()">Hủy</button>
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
				list.appendChild(listItem);
			}
		}

		function back() {
			history.back();
		}
	</script>
</body>
</html>