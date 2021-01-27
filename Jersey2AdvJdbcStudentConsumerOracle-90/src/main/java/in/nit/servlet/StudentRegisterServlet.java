package in.nit.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.nit.consumer.StudentRestConsumer;
import in.nit.model.Student;
@WebServlet("/insert")//Servlets3.x
public class StudentRegisterServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//1. Read Form Data
		String id=req.getParameter("stdId");
		String stdName=req.getParameter("stdName");
		String stdCourse=req.getParameter("stdCourse");
		String fee=req.getParameter("stdFee");
		
		//2. Parse Data If Required
		Integer stdId=Integer.parseInt(id);
		Double stdFee=Double.parseDouble(fee);
		
		//3. Convert to Model class Object
		Student std=new Student(stdId, stdName, stdCourse, stdFee, 0.0);
		
		//4.Call Consumer Code and get Response
		String msg=StudentRestConsumer.saveStudent(std);
		//5. Send Message to UI
		req.setAttribute("message",msg);
		
		//6. Dispatch To UI Back
		RequestDispatcher rd=req.getRequestDispatcher("index.jsp");
		rd.forward(req, res);
	}

}
