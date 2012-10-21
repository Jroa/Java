package pe.com.jroa.ventas.dao.mysql;

import pe.com.jroa.ventas.dao.LocalDao;
import pe.com.jroa.ventas.dao.VendedorDao;
import pe.com.jroa.ventas.dao.VentasFactoryDao;

public class VentasFactoryDaoMysql extends VentasFactoryDao{

	@Override
	public LocalDao getLocalDao() {
		return new LocalDaoMysql();
	}

	@Override
	public VendedorDao getVendedorDao() {
		return new VendedorDaoMysql();
	}

}
