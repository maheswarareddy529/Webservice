package in.nit.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;

import in.nit.dao.IStudentDao;
import in.nit.dao.impl.StudentDaoImpl;
import in.nit.service.IStudentService;
import in.nit.service.impl.StudentServiceImpl;

@ApplicationPath("/rest")
public class AppConfig extends ResourceConfig {

	public AppConfig() {
		this.packages("in.nit");
		this.register(new AbstractBinder() {
			
			@Override
			protected void configure() {
				bind(StudentDaoImpl.class).to(IStudentDao.class);
				bind(StudentServiceImpl.class).to(IStudentService.class);
			}
		});
	}
}



