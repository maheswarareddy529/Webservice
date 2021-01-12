package in.nit.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

import in.nit.filters.MyRequstFilter;
import in.nit.filters.MyResponseFilter;
@ApplicationPath("/rest")//URL Pattern
public class AppConfig extends ResourceConfig {//FC: ServletContainer
	//Constructor
public AppConfig() {
	packages("in.nit");//init-param
	
	//Activate Filters
	register(MyRequstFilter.class);
	register(MyResponseFilter.class);
}
}
