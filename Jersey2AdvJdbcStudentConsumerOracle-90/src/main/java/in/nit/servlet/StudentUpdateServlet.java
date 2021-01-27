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
@WebServlet("/update")
public class StudentUpdateServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//1. Read form input:
		Integer stdId=Integer.parseInt(req.getParameter("stdId"));
		String stdName=req.getParameter("stdName");
		String stdCourse=req.getParameter("stdCourse");
		Double stdFee=Double.parseDouble(req.getParameter("stdFee"));
		//2.Convert data into model class Object
		Student sob=new Student(stdId, stdName, stdCourse, stdFee,0.0);
		//3.call Service Consumer Code
		String msg=StudentRestConsumer.updateStudent(sob);
		//4.Send Message to UI
		req.setAttribute("message",msg);
		//5.Fetch Latest All Rows:
		List<Student> list=StudentRestConsumer.getAllStudents();
		req.setAttribute("list",list);
		//5.Dispatch to data.jsp page
		RequestDispatcher rd=req.getRequestDispatcher("data.jsp");
		rd.forward(req, res);
	}

}
