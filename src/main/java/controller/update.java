package controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Studentdao;
import dto.Student;

@WebServlet("/Update")
public class update extends HttpServlet
{
 @Override
protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	 
	 Student s=new Student();
		s.setName(req.getParameter("Name"));
		s.setMob(Long.parseLong(req.getParameter("mobile")));
		s.setEmail(req.getParameter("email"));
		s.setGender(req.getParameter("gender"));
		s.setDob(Date.valueOf(req.getParameter("dob")));
		s.setAddress(req.getParameter("address"));
		s.setLang(req.getParameterValues("language"));
		s.setCountry(req.getParameter("country"));
		
		Studentdao dao=new Studentdao();
		dao.save(s);
		res.getWriter().print("<h1>successfull</h1>");
		req.getRequestDispatcher("home.html").include(req, res);
}
}
