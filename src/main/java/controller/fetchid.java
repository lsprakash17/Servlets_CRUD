package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import org.apache.catalina.tribes.util.Arrays;

import dao.Studentdao;
import dto.Student;

@WebServlet("/fetchid")
public class fetchid extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
Studentdao d=new Studentdao();
Student student=d.find(Integer.parseInt(req.getParameter("id")));
if(student==null)
{
	res.getWriter().print("<h1>No data Found with the id</h1>");
}
else
{
List<Student> list= new ArrayList<Student>();
list.add(student);
req.setAttribute("list", list);
req.getRequestDispatcher("fetchall.jsp").forward(req, res);
}
}
}