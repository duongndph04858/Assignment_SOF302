<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Thông tin nhân viên</title>
<style type="text/css">
#right {
	width: 81%;
	height: 635px;
	float: left;
	margin-left: 10px;
	border-bottom: 3px solid #ccc;
	position: relative;
	text-align: center;
}
h3{
font-size: 30px;
}
#r_left{
width:60%;
float: left;
}

#r_right{
width:40%;
float: left;
}

table{
width:80%;
height:60%;
font-size:18px;
padding-top:100px;
margin-left: 180px;
}
tr{
width:100px;
padding-top: 30px;
}
td{
width: 100px;
}
tr,td{
text-align:left;
padding:10px;
}
#img{
width: 150px;
height: 150px;
background: aqua;
text-align: center;
margin-top: 110px;
margin-left: 20px;
}
#rspass{
width:150px;
height:30px;
margin-top: 100px;
margin-right: 250px;
}
</style>
</head>
<body style="width: 100%; height: 100%">
<jsp:include page="menu.jsp" />
<div id="right">
<h3>Thông tin cá nhân</h3>
<hr>
<div id="r_left">
	<table>
		<tr>
			<td>Họ và tên</td>
			<td>Nguyễn Trà My</td>
		</tr>
		
		<tr>
			<td>Địa chỉ</td>
			<td>Hạ Long</td>
		</tr>
		
		<tr>
			<td>Số điện thoại</td>
			<td>0904033217</td>
		</tr>
		
		<tr>
			<td>Giới tính</td>
			<td>Nữ</td>
		</tr>
		
		<tr>
			<td>Ngày sinh</td>
			<td>21/10/1998</td>
		</tr>
		
		<tr>
			<td>Mức lương</td>
			<td>1000$</td>
		</tr>
		
		<tr>
			<td>Email</td>
			<td>myntph04991@fpt.edu.vn</td>
		</tr>
	</table>

</div>
<div id="r_right">
	<div id="img"></div>
	
	<button id="rspass">Đặt lại mật khẩu</button>

</div>
</div>
</body>
</html>