<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="${pageContext.servletContext.contextPath}/">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="css/menu.css">
<script src="js/jquery-3.3.1.js"></script>
<style type="text/css">
#left {
	width: 18%;
	height: 490px;
	float: left;
	text-align: right;
	background: url("images/1899.png ") no-repeat;
	box-shadow: 4px 4px 7px #000;
	padding: 100px 0px 50px 0px;
	background-size: cover;
}
</style>
</head>
<body>
	<div id="left">
		<div id="logo">
			<h1 style="color: #ffc; text-shadow: 2px 2px 5px #ccc">
				<s:message code="title.manage" />
			</h1>
		</div>
		<div id="menu">
			<ul>
				<li class="mn"><a href="home.htm"><s:message
							code="global.home" /> </a></li>
				<li class="mn"><a href="#"><s:message
							code="global.notifications" /></a></li>
				<li id="nv" class="mn"><a href="staff.htm"><s:message
							code="global.staffs" /></a>
					<ul class="sub-menu">
						<li class="smn"><a href="staff.htm"><s:message
									code="global.liststaff" /></a></li>
						<li class="smn"><a href="#"><s:message
									code="global.liststaffB" /></a></li>
						<li class="smn"><a href="reward.htm"><s:message
									code="global.reward" /></a></li>
						<li class="smn"><a href="#"><s:message
									code="global.disciplines" /></a></li>
					</ul></li>
				<li class="mn"><a href="#"><s:message
							code="global.timesheet" /></a></li>
				<li id="pb" class="mn"><a href="mndepart.htm"><s:message
							code="global.depart" /></a>
					<ul class="sub-menu">
						<c:forEach var="depart" items="${departs }">
							<li class="smn"><a href="depart/${depart.id}.htm?start=0">
									<c:if test="${depart.id.equals('GD')}">
										<s:message code="global.director" />
									</c:if> <c:if test="${depart.id.equals('IT')}">
										<s:message code="global.it" />
									</c:if> <c:if test="${depart.id.equals('KT')}">
										<s:message code="global.accountant" />
									</c:if> <c:if test="${depart.id.equals('NS')}">
										<s:message code="global.personnel" />
									</c:if>
							</a></li>
						</c:forEach>
					</ul></li>
				<li class="mn"><a href="#"><s:message
							code="global.resources" /></a></li>
				<li id="language" class="smn"><a href="#"><s:message
							code="global.language" /></a>
					<ul class="sub-menu">
						<li class="smn"><a href="?language=en" data-lang="en">English</a></li>
						<li class="smn"><a href="?language=vi" data-lang="vi">Tiếng
								Việt</a></li>
					</ul></li>
				<li id="setting" class="mn"><a href="#"><s:message
							code="global.setting" /></a>
					<ul class="sub-menu">
						<li class="smn"><a href="thongtin.htm"><s:message
									code="global.information" /></a></li>
						<li class="smn"><a href="login.htm?logout"><s:message
									code="global.logout" /></a></li>

					</ul></li>
			</ul>
		</div>
	</div>
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