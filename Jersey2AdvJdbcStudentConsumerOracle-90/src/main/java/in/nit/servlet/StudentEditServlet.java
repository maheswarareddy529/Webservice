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
public class StudentEditServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//1. Read id param
		Integer stdId=Integer.parseInt(req.getParameter("id"));
		//2.call service layer to get Student Object
		Student s=StudentRestConsumer.getOneStudent(stdId);
		//3.Send this data to UI
		req.setAttribute("sob",s);
		//4. Dispatch to Edit JSP
		RequestDispatcher rd=req.getRequestDispatcher("edit.jsp");
		rd.forward(req, res);
	}

}
