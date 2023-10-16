package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Customer_dao;
import dto.Customer;

@WebServlet("/customerlogin")
public class Customer_login extends HttpServlet
{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String custid = req.getParameter("custid");
		
		String pwd = req.getParameter("pwd");
		
		long id = Long.parseLong(custid);
		
		Customer_dao customer_dao = new Customer_dao();
		
		Customer customer = customer_dao.fetchbyCustid(id);
		
		if (customer==null)
		{
			resp.getWriter().print("<h1> Invalid ID </h1>");
			req.getRequestDispatcher("Customerlogin.html").include(req, resp);
			
		}
		else
		{
			if(customer.getPwd().equals(pwd))
			{
				resp.getWriter().print("<h1>"+ customer.getName() +"</h1>");
				resp.getWriter().print("<h1> Login Success </h1>");
				req.getSession().setAttribute("customer", customer);
				req.getRequestDispatcher("CustomerHome.html").include(req, resp);
			}
			else
			{
				resp.getWriter().print("<h1> Invalid Password </h1>");
				req.getRequestDispatcher("Customerlogin.html").include(req, resp);
			}
		}
		
	}
}
