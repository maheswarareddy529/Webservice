package in.nit.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;

import in.nit.service.IEmpService;
import in.nit.service.impl.EmpServiceImpl;
@ApplicationPath("/rest")
public class AppConfig extends ResourceConfig {
public AppConfig() {
	packages("in.nit");//nit-param
	register(new AbstractBinder() {
		
		@Override
		public void configure() {
			bind(EmpServiceImpl.class).to(IEmpService.class);
		}
	});
}
}
