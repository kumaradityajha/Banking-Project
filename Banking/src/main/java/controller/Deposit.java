package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Bank_Dao;
import dto.BankAccount;

@WebServlet("/deposit")
public class Deposit extends HttpServlet
{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
{
  String amount = 	req.getParameter("amount");
  
   double amt = Double.parseDouble(amount);
   
    long acno = (Long) req.getSession().getAttribute("acno");
    
    Bank_Dao bank_Dao = new Bank_Dao();
    
    BankAccount bankAccount = bank_Dao.fetchByAccno(acno);
    
    bankAccount.setAmount((bankAccount.getAmount()+amt)); //  Before putting any data inside database we should set amount
    
    bank_Dao.update(bankAccount);
    
    resp.getWriter().print("<h1> Amount Has been Added Succesfully </h1>");
    
    
    
    
   
	
}
}
