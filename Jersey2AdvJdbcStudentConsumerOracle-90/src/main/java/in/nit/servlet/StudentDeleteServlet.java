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

@WebServlet("/delete")
public class StudentDeleteServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//read request param 'id' and parse
		Integer stdId=Integer.parseInt(req.getParameter("id"));
		//Call Service Consumer Code:
		String msg=StudentRestConsumer.deleteStudent(stdId);
		//Send Message to UI
		req.setAttribute("message", msg);
		
	/*	//redirect to /all
		res.sendRedirect("all");*/
		
		//or 
		
		//----Show to message, Fetch Latest Data----------------
		List<Student> list=StudentRestConsumer.getAllStudents();
		//Send Data to UI
		req.setAttribute("list",list);
		//Dispatch to UI Page
		RequestDispatcher rd=req.getRequestDispatcher("data.jsp");
		rd.forward(req, res);
	}

}
