package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bo.EditProductBO;

/**
 * Servlet implementation class EditProductServlet
 */
@WebServlet("/EditProductServlet")
public class EditProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		HttpSession session = request.getSession();
		if (session.getAttribute("accountInfor") == null) {
			response.sendRedirect("login.jsp?error=1");
		} else {
			String maHH = request.getParameter("maHH");
			String tenHH = request.getParameter("tenHH");
			String dvt = request.getParameter("dvt");
			String donGiaTK = request.getParameter("donGiaTK");
			String ghiChu = request.getParameter("ghiChu");
			System.out.println("[" + maHH + "] " + "[" + tenHH + "] " + "["
					+ dvt + "] " + "[" + donGiaTK + "] " + "[" + ghiChu + "] ");

			EditProductBO editProductBO = new EditProductBO();
			String returnedMessage = editProductBO.editProduct(maHH, tenHH,
					dvt, donGiaTK, ghiChu);

			RequestDispatcher rd = null;
			if ("No error".equals(returnedMessage)) {
				// Chá»‰nh sá»­a thÃ nh cÃ´ng
				rd = request
						.getRequestDispatcher("ShowProductListServlet?message=3");

			} else if ("Required Fields error".equals(returnedMessage)) {
				// Lá»—i thiáº¿u thÃ´ng tin cÃ¡c field báº¯t buá»™c nháº­p

				rd = request
						.getRequestDispatcher("ShowEditProductServlet?message=3");
			} else if ("Invalid DGTK error".equals(returnedMessage)) {
				// Lá»—i ko Ä‘Ãºng Ä‘á»‹nh dáº¡ng sá»‘ cá»§a Ä�VT

				rd = request
						.getRequestDispatcher("ShowEditProductServlet?message=4");
			} else {
				// Lá»—i khÃ´ng xÃ¡c Ä‘á»‹nh

				rd = request
						.getRequestDispatcher("ShowEditProductServlet?message=2");
			}
			rd.forward(request, response);
		}

	
		
	}


}