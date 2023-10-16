package controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Bank_Dao;
import dto.BankAccount;

@WebServlet("/changstatus")
public class ChangeStatus extends HttpServlet {

	Bank_Dao bankdao = new Bank_Dao();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String acn = req.getParameter("accno");

		long accno = Long.parseLong(acn);

		BankAccount bankaccount = bankdao.fetchByAccno(accno);

		if (bankaccount.isStatus()) {
			bankaccount.setStatus(false);

		} else {
			bankaccount.setStatus(true);
		}

		bankdao.update(bankaccount);
		List<BankAccount> list = bankdao.fetchAllBank();

		req.getSession().setAttribute("list", list);
		req.getRequestDispatcher("AccountHome.jsp").include(req, res);
		res.getWriter().print("<h1>Bank Status has been Updated</h1>");

	}

}