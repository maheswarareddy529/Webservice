package in.nit.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
@ApplicationPath("/rest")//URL Pattern
public class AppConfig extends ResourceConfig {//FC: ServletContainer
	//Constructor
public AppConfig() {
	packages("in.nit");//init-param
}
}
