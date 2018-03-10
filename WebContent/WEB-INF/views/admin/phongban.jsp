<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="css/content.css">
<title>Phòng ban</title>
</head>
<body>
	<jsp:include page="menu.jsp" />
	<div id="right">
		<form style="height: 610px" action="mndepart.htm" method="post">
			<div id="tool">
			<h1>Quản lý phòng ban</h1>
				<div id="nut">
					<button name="insertDepart">Thêm phòng ban</button>
					<button id="btnDelete" disabled="disabled" name="delete">Xóa</button>
				</div>
			</div>
			<hr>
			<div id="bang">
				<table>
					<tr style="height: 30px; font-weight: bold;">
						<td></td>
						<td>Mã phòng ban</td>
						<td>Tên phòng ban</td>
						<td>Số nhân viên</td>
						<td>Trưởng phòng</td>
					</tr>
					<c:forEach var="dep" items="${departs}">
						<tr>
							<td><input type="checkbox" name="depart" value="${dep.id }"></td>
							<td>${dep.id }</td>
							<td>${dep.name }</td>
							<c:if test="${dep.id.equals('GD') }">
								<td>${GD }</td>
								<td>${leaderGD.name}</td>
							</c:if>
							<c:if test="${dep.id.equals('KT') }">
								<td>${KT }</td>
								<td>${leaderKT.name}</td>
							</c:if>
							<c:if test="${dep.id.equals('NS') }">
								<td>${NS }</td>
								<td>${leaderNS.name}</td>
							</c:if>
							<c:if test="${dep.id.equals('IT') }">
								<td>${IT }</td>
								<td>${leaderIT.name}</td>
							</c:if>
							
						</tr>
					</c:forEach>
				</table>
			</div>
		</form>
	</div>
	<script type="text/javascript">
		var checkbox = document.getElementsByName('depart');
		for (var i = 0; i < checkbox.length; i++) {
			checkbox[i].onclick = function(e) {
				var sl = 0;
				for (var i = 0; i < checkbox.length; i++) {
					if (checkbox[i].checked === true) {
						sl += 1;
					}
				}
				if (sl < 1) {
					document.getElementById('btnDelete').disabled = true;
				} else if (sl == 1) {
					document.getElementById('btnDelete').disabled = false;
				} else {
					document.getElementById('btnDelete').disabled = false;
				}

			};
		}
	</script>
</body>
</html>