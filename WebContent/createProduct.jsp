<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Tao moi hang hoa
<form action="CreateProductServlet" method="post">
Ma hang: <input type="text" name="maHH" />
Ten Hang: <input type="text" name="tenHH" />
Don vi tinh: <input type="text" name="dvt" />
Don gia tham khao : <input type="text" name="donGiaTK" />
Ghi chu: <input type="text" name="ghiChu" />
<input type="submit" name="them" />
<input type="reset" name="Huy bo" />
</form>
</body>
</html>