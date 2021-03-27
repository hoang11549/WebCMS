<%@ page import="java.util.ArrayList"%>
<%@ page import="model.bean.HangHoa"%>
<%@ page import="model.bean.Comment"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Danh sách hàng hóa</title>
</head>

<body>

 
 <%
           if (session.getAttribute("accountInfor") == null) {
        	   response.sendRedirect("login.jsp?error=1");
           }
           else{
       
 %> 
	 <% String error =request.getParameter("message");  %>
 <%=("1".equals(error)) ? "Da xoa thanh cong": "" %>
 <div style="background-color: yellow; width: 100px"><a href="LogoutServlet">Đăng xuất</a></div>
   <h1> TÊN CỬA HÀNG </h1>
   <h2> QUẢN LÝ DANH MỤC HÀNG HÓA </h2>
 
     <% ArrayList<HangHoa> dsHangHoa = (ArrayList<HangHoa>)request.getAttribute("dsHangHoa");  %>
         <input type="button" onclick="location.href='SendEmailServlet?accId=<%=session.getAttribute("accountInfor")%>';" value="sendMail" />
     <input type="button" onclick="location.href='ShowCreateProductServlet'" value="Tạo mới" />
      
      <div class="container">
            <div class="jumbotron text-center">
                <h1>Send Email in Servlet jsp</h1>
                
            </div>
            <br>
            <form action="./SendEmail" method="post">
                <table class="table table-hover">
                    <tr>
                        <td>Name</td>
                        <td><input type="text" required="" placeholder="Name" name="name" class="form-control"></td>
                    </tr>

                    <tr>
                        <td>Email</td>
                        <td><input type="email" required="" placeholder="Email" name="email" class="form-control"></td>
                    </tr>
                    <tr>
                        <td>Subject</td>
                        <td><input type="text" required="" placeholder="Subject" name="subject" class="form-control"></td>
                    </tr>
                    <tr>
                        <td>Message</td>
                        <td><textarea name="message" required="" rows="5" cols="100" placeholder="Your Message"></textarea></td>
                    </tr>
                    <tr>
                        <td><input type="submit" id="submit" class="btn btn-primary" value="Submit"></td>
                    </tr>
                </table>
            </form>

        </div>		
   <table border="1" >
   
      <tr>
         <th>STT</th>
         <th>Mã hàng</th>
         <th>Tên hàng</th>
         <th>Đơn giá tham khảo</th>
         <th>Đơn vị tính</th>
         <th>Ghi chú</th>
         <th>Hành động</th>
      </tr>
      <% int i =1; %>
       <% for (HangHoa hh : dsHangHoa) { %>
      <tr>
         <td><%=i++ %></td>
         <td><%=hh.getMaHH() %></td>
         <td><%=hh.getTenHH() %></td>
         <td><%=hh.getDonGiaThamKhao() %></td>
         <td><%=hh.getDonViTinh() %></td>
         <td><%=hh.getGhiChu() %></td>
         <td>
             
             <input type="button"  onclick="location.href='ShowDetailProductServlet?proId=<%=hh.getMaHH() %>';" value="view detal"/>
             <input type="button" onclick="deleteProduct('<%=hh.getMaHH()%>')" value="Xóa" />
              <input type="button" onclick="location.href='ShowEditProductServlet?proId=<%=hh.getMaHH() %>';" value="Chỉnh sửa" />
                      </td>
      </tr>
  
      <% }  %> <!-- đóng for -->
      </table>
     
   
 
        <% } %> <!-- đóng else --> 
   
  
   
  
<script> function deleteProduct(proId)
		{
	if(confirm('Ban co muon xoa khong?'))
		{
		location.href="DeleteProductServlet?proId="+proId;
			}
		}</script>
</body>
</html>
