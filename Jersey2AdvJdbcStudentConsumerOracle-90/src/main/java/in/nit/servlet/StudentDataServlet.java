package in.nit.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.nit.consumer.StudentRestConsumer;
import in.nit.model.Student;
@WebServlet("/all")//Servlets3.x
public class StudentDataServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//1. Call to Consumer Code
		//2. Return List Student
		List<Student> list=StudentRestConsumer.getAllStudents();
		//3.Send Data To UI
		req.setAttribute("list",list);
		//4.Dispatch To UI Page
		RequestDispatcher rd=req.getRequestDispatcher("data.jsp");
		rd.forward(req, res);
	}

}
