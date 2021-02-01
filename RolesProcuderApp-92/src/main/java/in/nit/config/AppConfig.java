package in.nit.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

import in.nit.filter.SecureFilter;

@ApplicationPath("/rest")
public class AppConfig extends ResourceConfig {
	public AppConfig() {
		packages("in.nit");
		register(SecureFilter.class);// Activates Filter 
	}
}
