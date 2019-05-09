package servFiles;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.Customer;
import dao.BookShopDaoImplement;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/test_login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookShopDaoImplement bsdI;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	@Override
	public void init() throws ServletException {
		try {
			bsdI = new BookShopDaoImplement();
		} catch (Exception e) {
			throw new ServletException("err in init", e);
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		if (bsdI != null) {
			try {
				bsdI.closeAll();
			} catch (Exception e) {
				throw new RuntimeException("err in destroy", e);
			}
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {
			String email = request.getParameter("em");
			String pwd = request.getParameter("pass");
			Customer cu = bsdI.validateCustomer(email, pwd);

			if (cu == null) {
				pw.print("<h4> Invalid Login , Pls <a href=login.html>Retry</a></h4>");
			} else {
				pw.print("success mesg from 1st page");
				response.sendRedirect("details");
			}
		} catch (Exception e) {
			throw new ServletException("error in doGet",e);
		}
	}

}
