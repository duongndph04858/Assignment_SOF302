<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${pageContext.servletContext.contextPath}/">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="css/content.css">
<title>${lstP.get(0).depart.name}</title>
</head>
<body>
	<jsp:include page="menu.jsp" />
	<div id="right">
		<div id="timkiem">
			<form action="search.htm?DP=${lstP.get(0).depart.id}" method="post">
				<input id="search" name="search" type="text" value=""
					placeholder="<s:message code="table.search" />" /> <input
					type="hidden" name="DP" value="${lstP.get(0).depart.id}">
			</form>
		</div>
		<form style="height: 610px" action="staff.htm" method="post">
			<input type="hidden" name="DP" value="${lstP.get(0).depart.id}">
			<div id="tool">
				<h1>Nhân viên ${lstP.get(0).depart.name}</h1>
				<div id="nut">
					<button name="insertStaff">
						<s:message code="table.insert" />
					</button>
					<button id="btnEdit" disabled="disabled" name="editStaff">
						<s:message code="table.update" />
					</button>
					<button id="btnDelete" disabled="disabled" name="delete"
						onclick="if(confirm('Bạn chắc chắn muốn xóa?'))
							 return true; 
					else return false ">
						<s:message code="table.delete" />
					</button>
					<button id="btnExport" disabled="disabled" name="export">
						<s:message code="table.export" />
					</button>
				</div>
			</div>
			<hr>
			<div id="bang">
				<table>
					<tr style="height: 30px; font-weight: bold;">
						<td></td>
						<td><s:message code="table.image" /></td>
						<td><s:message code="table.name" /></td>
						<td><s:message code="table.gender" /></td>
						<td><s:message code="table.address" /></td>
						<td><s:message code="table.birthday" /></td>
						<td><s:message code="table.level" /></td>
						<td>Email</td>
						<td><s:message code="table.phone" /></td>
						<td><s:message code="table.salary" /></td>
						<td><s:message code="table.notes" /></td>
					</tr>
					<c:forEach var="staff" items="${lstP}">
						<tr>
							<td><input type="checkbox" name="u"
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
							<td>${staff.address }</td>
							<td><fmt:formatDate value="${staff.birthday }"
									pattern="dd/MM/yyyy" /></td>
							<td>${staff.level.name }</td>
							<td class="tdleft">${staff.email }</td>
							<td>${staff.phone }</td>
							<td>${staff.salary }</td>
							<td>${staff.notes}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</form>
		<div style="display: inline;">
			<c:forEach var="item" varStatus="status" begin="0" end="${page }">
				<a
					style="text-decoration: none; padding: 0 5px; border: 1px solid #000;"
					href="depart/${lstP.get(0).depart.id}.htm?start=${status.index*4 }">${status.index+1 }</a>
			</c:forEach>
		</div>
	</div>
	<script type="text/javascript">
		var checkbox = document.getElementsByName('u');
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
					document.getElementById('btnExport').disabled = false;
					document.getElementById('btnDelete').disabled = false;
				}

			};
		}
	</script>
	<script type="text/javascript">
		$(function() {
			$("a[data-lang]").click(function() {

				var lang = $(this).attr("data-lang");
				$.get("home.htm?language=" + lang, function() {
					location.reload();
				});
				return false;
			});

		});
	</script>
</body>
</html>