<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dang Nhap</title>
</head>
<body>
       <% String error = request.getParameter("error"); %>
       <%=("1".equals(error)) ? "Mời bạn đăng nhập!" : "" %>
       <%=("2".equals(error)) ? "Sai roi ban eh!" : "" %>
       

<h1>DangNhap</h1>
	<form action="login" method="post">
		tên Đăng nhập: <input type="text" name="tenDangNhap" value="admin">
		Mật Khẩu: <input type="password" name="matKhau" value="12345">
		<input	 type="submit" value ="Dang Nhap" />
		<input type="button" value ="Quay ve trang chu"/>
	</form>
</body>
</html>