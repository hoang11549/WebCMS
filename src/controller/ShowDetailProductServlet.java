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

import model.bean.Comment;
import model.bean.HangHoa;
import model.bo.showListCommentBO;

/**
 * Servlet implementation class ShowProductListServlet
 */
@WebServlet("/ShowDetailProductServlet")
public class ShowDetailProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowDetailProductServlet() {
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
		String proId = request.getParameter("proId");
		HttpSession session = request.getSession();
		showListCommentBO showCommentBO = new showListCommentBO();			
		ArrayList<Comment> ListComment= showCommentBO.getListComment(proId);
		request.setAttribute("ListComment", ListComment);
		String proid = proId ;
		session.setAttribute("proid", proid);
		long checkday =0;
		checkday = showCommentBO.CheckDay(proId);
		session.setAttribute("checkday", checkday);
		if (checkday>=14) {
			showCommentBO.BlockComment(proId);			
		}
		ArrayList<HangHoa> detailProduct = showCommentBO.GetDetailHangHoa(proId);
		request.setAttribute("detailProduct", detailProduct);
		RequestDispatcher rd = request.getRequestDispatcher("DetailProduct.jsp");
		rd.forward(request, response);						
	}

}
