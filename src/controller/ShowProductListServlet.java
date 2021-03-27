package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import model.bean.HangHoa;
import model.bo.ShowProductListBO;


/**
 * Servlet implementation class ShowProductListServlet
 */
@WebServlet("/ShowProductListServlet")
public class ShowProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowProductListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("text/html; charset=UTF-8");
		String message = request.getParameter("message");
		System.out.println("message=" + message);
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		if (session.getAttribute("accountInfor") == null) {
		     	   response.sendRedirect("login.jsp?error=1");
		}
		else {
			ShowProductListBO showProductListBO = new ShowProductListBO();
			ArrayList<HangHoa> dsHangHoa = showProductListBO.getDsHangHoa();
			request.setAttribute("dsHangHoa", dsHangHoa);
			RequestDispatcher rd = request.getRequestDispatcher("productList.jsp");
			rd.forward(request, response);
		}
		
				
	}

}
