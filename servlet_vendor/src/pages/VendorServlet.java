package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

//import javax.servlet.RequestDispatcher;
//import javax.servlet.Servlet;
//import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.VendorDao;
import pojos.Vendor;

/**
 * Servlet implementation class VendorServlet
 */
@WebServlet("/VendorServlet")
public class VendorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VendorDao dao;
	
	@Override
	public void init() throws ServletException {
		try {
			dao = new VendorDao();
		} catch (Exception e) {
			throw new ServletException("error in init",e);
		}
	}

	@Override
	public void destroy() {
		if(dao!=null)
			try {
				dao.cleanUp();
			} catch (Exception e) {
				throw new RuntimeException("Error in destroy",e);
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try(PrintWriter pr = response.getWriter()) 
		{
			HttpSession hs=request.getSession();
			hs.setAttribute("dao", dao);
			
			ArrayList <Vendor> v1 = (ArrayList<Vendor>) dao.getVendor();
			hs.setAttribute("ListofVendor", v1);
			pr.print("<h2><center>");
			pr.print("List of Vendors</center></h2>");
			pr.print("<table style=\"width:100%\" aling=\"left\"");

			for(Vendor v : v1)
			{
				pr.print("<tr>");
				pr.print("<td>Name: "+v.getName()+"</td>");
				pr.print("<td>Email: "+v.getEmail()+"</td>");
				pr.print("<td>City: "+v.getCity()+"</td>");
				pr.print("<td>Cell No: "+v.getCell_no()+"</td>");
				request.setAttribute("vname",v.getId());
				pr.print("<td><button type=\"button\" name=\"update1\"><a href=\\\"vupdate?id="+v.getId()+"\">Update</a></button></td>");
				pr.print("<td><button type=\"button\" name=\"delete1\"><a href=\"vdelete?id="+v.getId()+"\">Delete</a></button></td>");
				pr.print("</tr>");
			}
			pr.print("<h2><center><a href=\"add_vendor\">Add New Vendor</a></center></h2>");
		} catch (Exception e) {
			throw new ServletException("err in doPost",e);
		}
	}
}
