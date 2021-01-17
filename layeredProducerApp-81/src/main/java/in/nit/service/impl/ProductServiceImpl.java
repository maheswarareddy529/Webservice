package in.nit.service.impl;

import javax.inject.Inject;

import in.nit.dao.IProductDao;
import in.nit.service.IProductService;

public class ProductServiceImpl implements IProductService {
    @Inject
	private IProductDao dao;//HAS-A
	@Override
	public String showService() {
		return ": Service :"+dao.show();
	}

}
