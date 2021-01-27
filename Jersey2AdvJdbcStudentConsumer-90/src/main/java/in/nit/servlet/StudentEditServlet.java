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

@WebServlet("/edit")
public class StudentEditServlet 
	extends HttpServlet
{

	@Override
	protected void doGet(
			HttpServletRequest req, 
			HttpServletResponse resp)
					throws ServletException, IOException
	{
		//1. read id param
		String id=req.getParameter("id");
		//2. parse data 
		int sid=Integer.parseInt(id);
		//3. call service layer to get Student object
		Student s=StudentRestConsumer.getOneStudent(sid);
		//4. send this data to UI
		req.setAttribute("sob", s);
		//5. Dispatch to Edit JSP
		RequestDispatcher rd=req.getRequestDispatcher("Edit.jsp");
		rd.forward(req, resp);
		
		
	}
}




