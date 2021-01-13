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
@WebFilter("/filter")
public class FirstFilterServlet implements Filter {
	public void destroy() {
	
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String name=request.getParameter("user");
		PrintWriter pw=response.getWriter();
		if(name.length()==6) {
		chain.doFilter(request, response);
		}
		else {
			pw.print("First Filter......Must Enter exact 6 digits username");
		}
	}
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
