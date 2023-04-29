package controller;

import java.io.IOException;
import java.sql.Date;
import java.util.Arrays;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import dao.Studentdao;
import dto.Student;
@WebServlet("/insert")
public class InsertData extends HttpServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
//		String name=req.getParameter("Name");
//		long mob=Long.parseLong(req.getParameter("mobile"));
//		String email=req.getParameter("email");
//		String gender=req.getParameter("gender");
//		Date dob= Date.valueOf(req.getParameter("dob"));
//		String address=req.getParameter("address");
//		String[] lang=req.getParameterValues("language");
//		String country=req.getParameter("country");
//		res.getWriter().print("<h1>"
//				+ "Name:"+name
//				+ "<br>Mobile:"+mob
//				+ "<br>Email:"+email
//				+ "<br>Gender:"+gender
//				+ "<br>Dob:"+dob
//				+ "<br>address:"+address
//				+ "<br>Languages:"+Arrays.toString(lang)
//				+ "<br>Country:"+country
//				+"</h1>");
		
		
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
		
		
		
	}

}
