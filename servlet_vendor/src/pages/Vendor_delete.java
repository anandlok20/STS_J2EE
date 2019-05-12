package pages;

import java.io.IOException;
import dao.*;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Vendor_delete
 */
@WebServlet("/vdelete")
public class Vendor_delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	private VendorDao vdao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		try(PrintWriter pr = response.getWriter()) 
		{
			HttpSession hs=request.getSession();
			hs.getAttribute("dao");
			int rid=Integer.parseInt(request.getParameter("id"));
			vdao = new VendorDao();
			vdao.deleteCustomer(rid);
			response.sendRedirect("VendorServlet");
			
		} catch (Exception e) {
			throw new ServletException("error in doGet",e);
		}
	}

}
