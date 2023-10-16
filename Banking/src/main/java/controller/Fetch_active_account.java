package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BankAccount;
import dto.Customer;

@WebServlet("/fetchactiveaccount")
public class Fetch_active_account extends HttpServlet
{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Customer customer = (Customer) req.getSession().getAttribute("customer");
		
		List<BankAccount> list1 = customer.getAccount();
		List<BankAccount> list2 = new ArrayList<>();
		
		for(BankAccount bankAccount : list1)
		{
			if(bankAccount.isStatus())
			{
				list2.add(bankAccount);
				resp.getWriter().print("<h1> Active Account found</h1>");
			}
			req.getSession().setAttribute("list", list2);
			
			req.getRequestDispatcher("Accounts.jsp").include(req, resp);
			
			
		}
		
	}
}
