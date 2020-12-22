package in.nit.servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/read")
public class ReadCookieServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		//1.Reading all Cookies from request-head
		Cookie[] cks=req.getCookies();
		
		//2.Print Cookie name, Value
		PrintWriter pw=res.getWriter();
		if(cks!=null&& cks.length!=0) {
			for(int i=0;i<cks.length;i++) {
				pw.print("  Cookie Name= "+cks[i].getName()+"  , Value= "+cks[i].getValue());
			}
		}
		else {
			pw.print("No Cookies Found ");
		}
		
		
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
