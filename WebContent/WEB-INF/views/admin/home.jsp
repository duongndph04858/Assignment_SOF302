<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${pageContext.servletContext.contextPath}/">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Trang chủ</title>
<link type="text/css" rel="stylesheet" href="css/style.css">
<style type="text/css">
table {
	width: 100%;
	border: none;
}

tr {
	border-bottom: 1px solid #000;
}
</style>
</head>
<body style="width: 100%; height: 100%">
	<jsp:include page="menu.jsp" />
	<div>
		<div id="right">
			<div id="tool">
				<h3>Top 10 nhân viên xuất sắc nhất tháng</h3>
			</div>
			<hr>
			<div>
			<div>
				<table>
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
					<c:forEach var="st" varStatus="status" items="${topstaff }">
						<tr style="border-bottom: 1px solid #000;">
							<td>${st.id }</td>
							<td><img width="100px;" src="images/${st.staff.photo }" /></td>
							<td>${st.staff.name }</td>
							<c:choose>
								<c:when test="${st.staff.gender ==true }">
									<td>Nữ</td>
								</c:when>
								<c:when test="${st.staff.gender ==false }">
									<td>Nam</td>
								</c:when>
							</c:choose>
							<td>${st.staff.birthday }</td>
							<td>${st.staff.level.name }</td>
							<td>${st.staff.email }</td>
							<td>${st.staff.depart.name }</td>
						</tr>
					</c:forEach>
				</table>
				</div>
				<div style="display: inline;margin-top: 460px;">
			<c:forEach var="item" varStatus="status" begin="0" end="${page }">
				<a
					style="text-decoration: none; padding: 0 5px; border: 1px solid #000;"
					href="home.htm?start=${status.index*3 }">${status.index+1 }</a>
			</c:forEach>
		</div>
			</div>
		</div>
	</div>
</body>
</html>