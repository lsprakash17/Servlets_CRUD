package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import org.apache.catalina.tribes.util.Arrays;

import dao.Studentdao;
import dto.Student;

@WebServlet("/fetch")
public class FetchData extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

		   Studentdao d=new Studentdao();
		   List<Student> list=d.Fetchall();
		   req.setAttribute("list", list);
		   req.getRequestDispatcher("fetchall.jsp").include(req, res);
	}
}
