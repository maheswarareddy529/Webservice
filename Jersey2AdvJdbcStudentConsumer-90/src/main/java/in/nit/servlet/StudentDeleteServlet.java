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
public class StudentDeleteServlet 
	extends HttpServlet
{

	@Override
	protected void doGet(
			HttpServletRequest req, 
			HttpServletResponse resp) 
			throws ServletException, IOException {
		//read request param 'id'
		String id=req.getParameter("id");
		
		//parse data if required
		int stdId=Integer.parseInt(id);
		
		//call service consumer code
		String msg=StudentRestConsumer.deleteStudent(stdId);
		
		//send message to UI
		req.setAttribute("message", msg);
		/*
		//redirect to /all
		resp.sendRedirect("all");
		*/
		
		
		//----to show message, fetch latest data-------------------
		List<Student> list=StudentRestConsumer.getAllStudents();
		
		//Send data to UI
		req.setAttribute("list",list);
		//Displatch to UI page
		RequestDispatcher rd=req.getRequestDispatcher("Data.jsp");
		rd.forward(req, resp);
		
	}
}





