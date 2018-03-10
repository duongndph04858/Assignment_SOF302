<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${pageContext.servletContext.contextPath }/">
<link type="text/css" rel="stylesheet" href="css/content.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:message code="title.staff" /></title>
</head>
<body style="width: 100%; height: 100%">
	<jsp:include page="menu.jsp" />
	<div id="right">
		<div>
			<div id="tool">
				<h1><s:message code="title.staff"/></h1>
			</div>
		</div>
		<div style="height: 440px;" id="bang">
			<table>
				<tr style="height: 30px; font-weight: bold;">
					<td><s:message code="table.image"/> </td>
					<td><s:message code="table.name"/></td>
					<td><s:message code="table.gender"/></td>
					<td><s:message code="table.address"/></td>
					<td><s:message code="table.birthday"/></td>
					<td><s:message code="table.level"/></td>
					<td>Email</td>
					<td><s:message code="table.phone"/></td>
					<td><s:message code="table.salary"/></td>
					<td><s:message code="table.notes"/></td>
				</tr>
				<c:forEach var="staff" items="${lst}">
					<tr>
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
						<td>${staff.address }</td>
						<td><fmt:formatDate value="${staff.birthday }"
								pattern="dd-MM-yyyy" /></td>
						<td>${staff.level.name }</td>
						<td class="tdleft">${staff.email }</td>
						<td>${staff.phone }</td>
						<td>${staff.salary }</td>
						<td>${us}</td>
					</tr>
				</c:forEach>
			</table>

		</div>
		<div style="display: inline; margin-top: 10px;">
			<c:forEach var="item" varStatus="status" begin="0" end="${trang }">
				<a
					style="text-decoration: none; padding: 0 5px; border: 1px solid #000;"
					href="staff.htm?start=${status.index*4 }">${status.index+1 }</a>
			</c:forEach>
		</div>
	</div>
</body>
</html>