package in.nit.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
public class TestFilterOne implements Filter {
	public void destroy() {
		System.out.println("Destroy Filter one");
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("filter one pre-processing");
		chain.doFilter(request, response);
		System.out.println("filter one prost-processing");
	}
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("Init Filter one");
	}

}
