package controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.query.criteria.internal.predicate.IsEmptyPredicate;

import dao.Customer_dao;
import dto.Customer;

@WebServlet("/customer_signup_page")
public class Customer_signup_page extends HttpServlet
{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		String Custname = req.getParameter("custname");
		String CustMobile = req.getParameter("mobile");
		String Password = req.getParameter("password");
		String Email = req.getParameter("email");
		String Gender = req.getParameter("Gender");
		String Dob = req.getParameter("dob");
		
		long mob = Long.parseLong(CustMobile);
		
//		res.getWriter().print("<h1> Name:- " + Custname + "</h1>");
//		res.getWriter().print("<h1> Mobile:- " + Mobile + "</h1>");
//		res.getWriter().print("<h1> Email:- " + Email + "</h1>");
//		res.getWriter().print("<h1> Password:- " + Password + "</h1>");
//		res.getWriter().print("<h1> Gender:- " + Gender + "</h1>");
//		res.getWriter().print("<h1> D.O.B:- " + Dob + "</h1>");
		
//		res.getWriter().print("Name:- "+Custname+"\n"
//				+"Mobile:- "+CustMobile+" \n"
//				+"Email:- "+Email+"\n "
//				+"Password:- "+Password+" \n"
//				+"Gender:- "+Gender+"\n "
//				+"D.O.B:- "+Dob+"\n ");
//		
		Date date = Date.valueOf(Dob);
		
		Period period = Period.between(date.toLocalDate(),LocalDate.now());
		
		int age = period.getYears();
		
		if(age<18)
		{
			res.getWriter().print("<h1> He is not eligiable to create account</h1>");
		}
		else 
		{
		//	res.getWriter().print("<h1> He is  eligiable to create account");
			
			Customer_dao customer_dao = new Customer_dao();
			
			List<Customer> list1 = customer_dao.fetch(mob);
			
			List<Customer> list2 = customer_dao.fetch(Email);
			
			
		if(list1.isEmpty()&& list2.isEmpty())
		{
			
			Customer customer = new Customer();
			
			customer.setName(Custname);
			customer.setEmail(Email);
			customer.setGender(Gender);
			customer.setDob(date);
			customer.setPwd(Password);
			customer.setMob(mob);
			
//			Customer_dao customer_dao = new Customer_dao();
			
			customer_dao.save(customer);
			
			Customer customer2 = new Customer_dao().fetch(Email).get(0);
			
			long id = customer2.getCustid();
			
			if(customer2.getGender().equals("male"))
			{
				res.getWriter().print("<h1> Hello Sir Account Has Been created Succesfully</h1>");
				res.getWriter().print("<h1> Your customer ID is :" +id+ "</h1>");
				req.getRequestDispatcher("home.html").include(req, res);
			}
			else
			{
				res.getWriter().print("<h1> Hello Madam Account Has Been created Succesfully</h1>");
				res.getWriter().print("<h1> Your customer ID is :" +id+ "</h1>");
				req.getRequestDispatcher("home.html").include(req, res);
			}
			
			
//			
//			res.getWriter().print("<h1> Account Has Been created Succesfully</h1>");
//			
//			
//		}
//		else 
//		{
//			res.getWriter().print("<h1> Account is already existed</h1>");
//			
//		}
//		 
		 
		
	}
	}

	
	}
}
