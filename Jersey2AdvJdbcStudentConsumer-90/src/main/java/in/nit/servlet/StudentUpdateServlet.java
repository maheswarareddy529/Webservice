package in.nit.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.nit.consumer.StudentRestConsumer;
import in.nit.model.Student;

@WebServlet("/update")
public class StudentUpdateServlet 
	extends HttpServlet
{

	@Override
	protected void doPost(
			HttpServletRequest req, 
			HttpServletResponse resp) 
					throws ServletException, IOException 
	{
		//1. read form inputs
		String sid=req.getParameter("stdId");
		String stdName=req.getParameter("stdName");
		String sfee=req.getParameter("stdFee");
		String stdCourse=req.getParameter("stdCourse");
		
		//2. parse data if required
		int stdId=Integer.parseInt(sid);
		double stdFee=Double.parseDouble(sfee);
		
		//3. Convert data into model class object
		Student sob=new Student(stdId, stdName, stdCourse, stdFee, 0.0);
		
		//4. call service consumer code
		String msg=StudentRestConsumer.updateStudent(sob);
		
		//5. send message to UI
		req.setAttribute("message", msg);
		
		//6. fetch latest all rows
		List<Student> list=StudentRestConsumer.getAllStudents();
		req.setAttribute("list", list);
		
		//7. Dispatch to Data.jsp page
		req.getRequestDispatcher("Data.jsp")
		.forward(req, resp);
		
	}
}





