<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList"%>
<%@ page import="model.bean.HangHoa"%>
<%@ page import="java.text.DecimalFormat"%>
<%@ page import="common.StringCommon"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EIt</title>
</head>
<body>
<%
           if (session.getAttribute("accountInfor") == null) {
        	   response.sendRedirect("login.jsp?error=1");
           }
           else{
       
 %> 
 
 <% String error = request.getParameter("message"); %>
       <%=("1".equals(error)) ? "Lỗi trùng mã hàng hóa, bạn vui lòng thao tác lại!" : "" %>
       <%=("2".equals(error)) ? "Đã có lỗi không xác định được nguyên nhân, bạn thử vui lòng thao tác lại, hoặc liên hệ với người quản trị hệ thống!" : "" %>
       <%=("3".equals(error)) ? "Lỗi chưa nhập đầy đủ tên hàng hóa, đơn vị tính, đơn giá tham khảo!" : "" %>
       <%=("4".equals(error)) ? "Đơn giá tham khảo phải là số!" : "" %>
       
 <br>

    <% 
           	String maHH = null;
       		String tenHH = null;
       		String dvt = null;
       		String donGiaTK = null;
       		String ghiChu = null;
       		
       		if (error == null || "".equals(error)) {
       			// Vào màn hình edit lần đầu
       			HangHoa hangHoa = (HangHoa)request.getAttribute("hangHoa");			
       			maHH = hangHoa.getMaHH();
       			tenHH = hangHoa.getTenHH();
       			dvt = hangHoa.getDonViTinh();
       			donGiaTK = StringCommon.convertDoubleToString(hangHoa.getDonGiaThamKhao());
       			ghiChu = hangHoa.getGhiChu();
       			
       		} else {
       			// Quay lại màn hình edit khi có lỗi trả về
       			maHH = request.getParameter("maHH") != null ? request.getParameter("maHH") : "";
       			tenHH = request.getParameter("tenHH") != null ? request.getParameter("tenHH") : "";
       			dvt = request.getParameter("dvt") != null ? request.getParameter("dvt") : "";
       			donGiaTK = request.getParameter("donGiaTK") != null ? request.getParameter("donGiaTK") : "";
       			ghiChu = request.getParameter("ghiChu") != null ? request.getParameter("ghiChu") : "";
       	
       		}   
        %>

<form action="EditProductServlet" method="post">

<!--Ma hang: <input type="text" name="maHH"  />!-->
Mã hàng: <input type="text" value="<%=maHH%>" disabled="disabled"/>

<input type="hidden" name="maHH" value="<%=maHH%>" />


     Tên hàng: <input type="text" name="tenHH" id="tenHH" value="<%=tenHH%>"/>

  Đơn vị tính: <input type="text" name="dvt" id="dvt" value="<%=dvt%>"/>
 Đơn giá tham khảo: <input type="text" name="donGiaTK" id="donGiaTK" value="<%=donGiaTK%>"/>

  Ghi chú: <input type="text" name="ghiChu" value="<%=ghiChu%>"/>

<input type="submit" onclick="return true" value="Sửa" />

<input type="reset" name="Huy bo" />
</form>
<script> function validate(){
	var errorMessage ="";

	if (document.getElementById("tenHH").value ==""){
		errorMessage = errorMessage +'hay nhap ten hang hoa ';
		
	}
	if (document.getElementById("dvt").value ==""){
		errorMessage =errorMessage + 'hay nhap ten dvt ';
	}
	if (document.getElementById("donGiaTK").value ==""){
		errorMessage = errorMessage +'hay nhap donGiaTK ';
	}
	/*
	   if (!(/^\d+$/.test(document.getElementById("donGiaTK").value))) {
		   errorMessage = errorMessage + 'Đơn giá tham khảo phải là một số nguyên';
	   }
	*/
	 var dgtkTmp = Number(document.getElementById("donGiaTK").value);			  
	if (Number.isNaN(dgtkTmp) || dgtkTmp < 0) {

		   errorMessage = errorMessage + 'Đơn giá tham khảo phải là một số nguyên';
	   }

	alert(errorMessage);
	return errorMessage =="";
	
}</script>
  <% } // Đóng else của session.getAttribute("accountInfor") %>
</body>
</html>