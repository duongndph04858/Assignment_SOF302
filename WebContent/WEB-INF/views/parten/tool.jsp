<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
* {
	margin: 0;
	padding: 0
}

#tool {
	width: 100%;
	height: 150px;
	position: relative;
}

#tool h1{
text-align: center;
padding-top: 15px;
}

#timkiem {
	width: 200px;
	height: 30px;
	position: absolute;
	left: 27px;
	bottom: 30px;
}

#nut {
	position: absolute;
	left: 250px;
	bottom: 10px;
}

button{
width: 120px;
height: 30px;
margin-left: 10px;
}


#search {
	width: 200px;
	box-sizing: border-box;
	line-height: 25px;
	border: 1px solid #000;
	border-radius: 20px;
	padding-left: 20px;
	color: #000;
	position: absolute;
	top: 20px;
	right: 20px;
}
</style>
</head>
<body>
	<div id="tool">
	<h1>Nhân viên phòng ban</h1>
		<div id="timkiem">
			<form action="search" method="post">
				<input id="search" name="search" type="text" value=""
					placeholder="Nhập tên nhân viên" />
			</form>
		</div>
		<div id="nut">
			<form action="">
				<button name="add">Thêm nhân viên</button>
				<button name="change">Sửa nhân viên</button>
				<button name="delete">Xóa</button>
				<button name="export">Xuất danh sách</button>
			</form>
		</div>
	</div>
	<hr>
</body>
</html>