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

@WebServlet("/insert") //Servlets 3.x
public class StudentRegisterServlet 
	extends HttpServlet
{

	@Override
	protected void doPost(
			HttpServletRequest req,
			HttpServletResponse resp) 
					throws ServletException, IOException 
	{
		//1. Read Form data
		String sid=req.getParameter("stdId");
		String stdName=req.getParameter("stdName");
		String stdCourse=req.getParameter("stdCourse");
		String sfee=req.getParameter("stdFee");
		
		//2. Parse Data if required
		int stdId=Integer.parseInt(sid);
		double stdFee=Double.parseDouble(sfee);
		
		//3. Convert to Model class object
		Student std=new Student(stdId, stdName, stdCourse, stdFee, 0.0);
		
		//4. Call Consumer Code and get Response
		String msg=StudentRestConsumer.saveStudent(std);
		
		//5. send message to UI
		req.setAttribute("message", msg);
		System.out.println(msg);
		//6. Dispatch to Ui back
		RequestDispatcher rd=req.getRequestDispatcher("index.jsp");
		rd.forward(req, resp);
		
	}
}







