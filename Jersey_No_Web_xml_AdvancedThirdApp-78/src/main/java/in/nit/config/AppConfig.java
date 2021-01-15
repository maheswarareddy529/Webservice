package in.nit.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

import in.nit.filter.MyRequestFilter;

@ApplicationPath("/rest")//url-pattern
public class AppConfig extends ResourceConfig{//FrontController
//Constructor
	public AppConfig() {
		packages("in.nit");//init-params
		register(MyRequestFilter.class);
	}
}
