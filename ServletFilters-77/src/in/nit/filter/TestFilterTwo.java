package in.nit.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
public class TestFilterTwo implements Filter {
	public void destroy() {
		System.out.println("Destroy Filter Two");
	}
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("filter Two pre-processing");
		chain.doFilter(request, response);
		System.out.println("filter Two prost-processing");
	}
	public void init(FilterConfig fConfig) throws ServletException {
		String data=fConfig.getInitParameter("data");
		System.out.println("Init Filter Two: "+data);
	}

}
