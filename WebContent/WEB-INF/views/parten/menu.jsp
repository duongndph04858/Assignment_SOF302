<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link type="text/css" rel="stylesheet" href="css/menu.css">
<script src="js/jquery-3.3.1.js"></script>
<style type="text/css">
#left {
	width: 18%;
	height: 635px;
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
			<h1 style="color: #ffc; text-shadow: 2px 2px 5px #ccc">Quản lý
				nhân sự</h1>
		</div>
		<div id="menu">
			<ul>
				<li class="mn"><a href="#">Trang chủ</a></li>
				<li class="mn"><a href="#">Thông báo</a></li>
				<li id="nv" class="mn"><a href="#">Nhân viên</a>
					<ul class="sub-menu">
						<li class="smn"><a href="home.htm">Danh sách nhân viên</a></li>
						<li class="smn"><a href="#">Danh sách đi công tác</a></li>
						<li class="smn"><a href="#">Danh sách khen thưởng</a></li>
						<li class="smn"><a href="#">Danh sách kỷ luật</a></li>
					</ul></li>
				<li class="mn"><a href="#">Chấm Công</a></li>
				<li id="pb" class="mn"><a href="#">Phòng ban</a>
					<ul class="sub-menu">
						<li class="smn"><a href="#">Phòng Giám Đốc</a></li>
						<li class="smn"><a href="#">Phòng IT</a></li>
						<li class="smn"><a href="#">Phòng Kế Toán</a></li>
						<li class="smn"><a href="#">Phòng Nhân Sự</a></li>
					</ul></li>
				<li class="mn"><a href="#">Tài nguyên</a></li>
				<li class="mn"><a href="login.htm">Cài đặt</a></li>
			</ul>
		</div>
	</div>
	<script type="text/javascript">
		$(function() {
			$('li.mn').children('a').click(function() {
				$('li.mn').children('a').removeClass();
				$(this).addClass('current');
			});
		});

		$(function() {
			$('li.smn').children('a').click(function() {
				$('li.mn').children('a').removeClass();
				$('li.smn').children('a').removeClass();
				$(this).addClass('subitems');
			});
		});

		var menu = document.querySelectorAll('#menu > ul > li');
		for (var i = 0; i < menu.length; i++) {
			menu[i].addEventListener("click", function() {
				var menuList = document
						.querySelectorAll('#menu > ul > li > ul');
				for (var j = 0; j < menuList.length; j++) {
					menuList[j].style.display = "none";
				}
				this.children[1].style.display = "block";
			});
		}
	</script>
</body>
</html>