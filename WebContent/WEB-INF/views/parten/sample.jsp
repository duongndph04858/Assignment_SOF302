<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
#left {
	width: 18%;
	float: left;
	text-align: right;
	background-color: #555;
	box-shadow: 4px 4px 7px #000;
	padding-bottom: 50px;
	background-size: cover;
}

#logo {
	padding-top: 100px;
	text-align: center;
	height: 100px;
}

li {
	line-height: 35px;
	margin-bottom: 5px;
	list-style: none;
}

li a {
	padding-right: 15px;
	border-radius: 5px;
	font-weight: bold;
	text-decoration: none;
	font-size: 20px;
	color: #fff;
	display: block;
	background: -webkit-linear-gradient(top, #690 0%, #090 100%);
	background: -webkit-linear-gradient(to bottom, #690 0%, #090 100%);
}

ul li a.active {
	color: #000;
	background: -webkit-linear-gradient(top, #6f0 0%, #0f0 100%);
	background: -webkit-linear-gradient(to bottom, #6f0 0%, #0f0 100%);
}

#sub-menu li a.active {
	display: block;
}

li a:hover {
	cursor: pointer;
	color: #000;
	background: -webkit-linear-gradient(top, #6f0 0%, #0f0 100%);
	background: -webkit-linear-gradient(to bottom, #6f0 0%, #0f0 100%);
}

#sub-menu {
	padding: 0;
	display: none;
}

#sub-menu a {
	background: none;
	color: #fff;
	font-size: 17px;
}

#sub-menu a:hover {
	color: #000;
	background: -webkit-linear-gradient(top, #eee 0%, #bbb 100%);
	background: -webkit-linear-gradient(to bottom, #eee 0%, #bbb 100%);
	font-size: 17px;
}

#nv:hover #sub-menu {
	display: block;
}
</style>
</head>
<body>
	<div id="left">
		<div id="logo">
			<h1 style="color: #ffc; text-shadow: 2px 2px 5px #ccc">Quản lý
				nhân sự</h1>
		</div>
		<div id="menu">
			<ul>
				<li><a href="#">Trang chủ</a></li>
				<li><a href="#">Thông báo</a></li>
				<li id="nv"><a href="#">Nhân viên</a>
					<ul id="sub-menu">
						<li><a href="#">Danh sách nhân viên</a></li>
						<li><a href="#">Danh sách đi công tác</a></li>
						<li><a href="#">Danh sách khen thưởng</a></li>
						<li><a href="#">Danh sách kỷ luật</a></li>
					</ul></li>
				<li><a href="#">Chấm Công</a></li>
				<li><a href="#">Phòng ban</a></li>
				<li><a href="#">Tài nguyên</a></li>
				<li><a href="#">Cài đặt</a></li>
			</ul>
		</div>
	</div>
</body>
</html>