package controller;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Studentdao;
@WebServlet("/delete")
public class Delete extends HttpServlet
{
@Override
protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	int id =Integer.parseInt(req.getParameter("id"));
	Studentdao dao=new Studentdao();
	dao.Delete(id);
	
	res.getWriter().print("<h1>data deleted successfully</h1>");
	
	req.setAttribute("list", dao.Fetchall());
	req.getRequestDispatcher("fetchall.jsp").include(req, res);
	
}
	}

