package in.nit.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
@WebFilter({"/filter","/filter1"})
public class SecondFilterServlet implements Filter {
	public void destroy() {
	
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String name=request.getParameter("user");
		String pwd=request.getParameter("pwd");
		PrintWriter pw=response.getWriter();
		if(name.equals("admin1")&& pwd.equals("admin1")) {
		chain.doFilter(request, response);
		}
		else {
			pw.print("Second Filter....username and pwd wrong");
		}
	}
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
