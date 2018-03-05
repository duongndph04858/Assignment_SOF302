<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String view = request.getParameter("view");
		if (view.startsWith("admin/")) {
			pageContext.forward("admin.jsp");
		} else if (view.startsWith("login/")){
			pageContext.forward("login/login.jsp");
		}
	%>
</body>
</html>