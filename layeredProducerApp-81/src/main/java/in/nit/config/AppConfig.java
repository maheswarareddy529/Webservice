package in.nit.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;

import in.nit.dao.IProductDao;
import in.nit.dao.ProductDaoImpl;
import in.nit.service.IProductService;
import in.nit.service.impl.ProductServiceImpl;
@ApplicationPath("/rest")
public class AppConfig extends ResourceConfig {
public AppConfig() {
	packages("in.nit");//nit-param
	register(new AbstractBinder() {
		@Override
		public void configure() {
			bind(ProductDaoImpl.class).to(IProductDao.class);
			bind(ProductServiceImpl.class).to(IProductService.class);
		}
	});
}
}
