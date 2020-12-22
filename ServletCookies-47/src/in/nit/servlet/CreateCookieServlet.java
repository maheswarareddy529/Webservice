package in.nit.servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/create")
public class CreateCookieServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		//1.Reading data from Form
		String id=req.getParameter("id");
		String name=req.getParameter("name");
		
		//2.Create Cookies
		Cookie c=new Cookie(id,"101");
		Cookie c1=new Cookie(name,"Sankar");
		
		//set Max Life Time in seconds 
		c1.setMaxAge(20);// in seconds 
		
		//3.Add to Response 
		res.addCookie(c);
		res.addCookie(c1);
		
		//4.Print Done Message
		
		PrintWriter pw=res.getWriter();
		pw.print("Cookies Created");
		

	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
