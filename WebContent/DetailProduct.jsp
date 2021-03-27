<%@ page import="java.util.ArrayList"%>
<%@ page import="model.bean.HangHoa"%>
<%@ page import="model.bean.Comment"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <link rel="stylesheet" href="./DetailProduct.css">
</head>
<body>
 <header>
        <div class="container">
            <div class="row">
                <div class="col">
                    <img src="imgs/Logo-Greenwich.png" alt="Greenwich Logo" width="20%" style="padding-top: 15px;">
                </div>
                <div class="col" style="text-align: right; margin-top: 20px;">
                    <input id="search-input" type="text" placeholder="Search...">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
                        <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"/>
                    </svg>
                    <button id="sign-in">Sign In</button>
                    <button id="sign-up">Create an account</button>
                </div>
            </div>
            <div class="row" style="text-align: right; margin-bottom: 70px;">
                <div class="col" style="margin-top: 20px;">
                    <a href="#" class="menu">HOME</a>
                    <a href="#" class="menu">BUSINESS</a>
                    <a href="#" class="menu">DESIGN</a>
                    <a href="#" class="menu">INFORMATION TECHNOLOGY</a>
                    <a href="#" class="menu">MORE</a>
                </div>
            </div>
        </div>
    </header>
   <% ArrayList<Comment> comment = (ArrayList<Comment>)request.getAttribute("ListComment");  %>
	<% ArrayList<HangHoa> detailProduct = (ArrayList<HangHoa>)request.getAttribute("detailProduct");  %>
	
    <h1>Comment in here</h1>
   <div>--------------------------------------</div>
  <div class="comments-container">
 <% for(HangHoa dh: detailProduct){ %>

<% if(dh.getStatusComment() == true ){ %>
    <form action="AddCommentServlet" method="post">
    <h2><%= session.getAttribute("checkday")  %></h2>
	<h5><%dh.getMaHH();%></h5>
     <input name="nameAccount" value="<%=(String)session.getAttribute("accountInfor")%>"></input>
     <input name="proid" value="<%=(String)session.getAttribute("proid")%>"></input>
   <input type="text" name="comment" value="yourcomment">
   	<input type="submit" value="Add Comment" />
   
   </form>
   <%} else{  %>
	<h2><%=dh.getStatusComment()%></h2>
	<h5>ko comment duoc nua ban oi</h5>
	 <%} %>
	  <%} %> 
 			<!-- đóng for --> 


    <ul id="comments-list" class="comments-list">
     	 <% 	
 		 for (Comment cm : comment) { 
	 			
 	%>
        <li>
            <div class="comment-main-level">
                <!-- Avatar -->
                <div class="comment-avatar"><img src="http://i9.photobucket.com/albums/a88/creaticode/avatar_1_zps8e1c80cd.jpg" alt=""></div>
                <!-- Contenedor del Comentario -->
                <div class="comment-box">
                    <div class="comment-head">
                        <h6 class="comment-name"><a><%=cm.getnameAccount()%></a></h6>
                                               <i class="fa fa-reply"></i>
                        <i class="fa fa-heart"></i>
                    </div>
                    <div class="comment-content">
                    <%=cm.getContentComment()%>
                    </div>
                </div>
            </div>
        </li>
         <% } %>
    <!-- đóng for --> 
    </ul>
</div> 
     
       		
      
  
    	
     
  
</body>
</html>