<%@ page import="model.bean.Accounts"%>
<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <% ArrayList<Accounts> dsAccount = (ArrayList<Accounts>)request.getAttribute("dsAccount");  %>
<%
           if (session.getAttribute("accountInfor") == null) {
        	   response.sendRedirect("login.jsp?error=1");
           }
       
 %>
 <div style="background-color: yellow; width: 100px"><a href="ShowProductListServlet">Hàng hóa</a></div>
<div><%=session.getAttribute("accountInfor")%></div>
       
       <div style="background-color: yellow; width: 100px"><a href="LogoutServlet">Đăng xuất</a></div>
      
   
      
        
</body>
</html>