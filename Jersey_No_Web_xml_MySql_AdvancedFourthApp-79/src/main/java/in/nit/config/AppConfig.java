package in.nit.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

import in.nit.filter.SecurityFilter;
//It is equals to writing web.xml
@ApplicationPath("/rest")//URL-Patterns
public class AppConfig extends ResourceConfig{//FC
	public AppConfig() {
		packages("in.nit");
		register(SecurityFilter.class);
	}
}
