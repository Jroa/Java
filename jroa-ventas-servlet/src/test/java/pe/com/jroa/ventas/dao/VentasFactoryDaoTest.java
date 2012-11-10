package pe.com.jroa.ventas.dao;
import junit.framework.Assert;

import org.junit.Test;


public class VentasFactoryDaoTest {

	@Test
	public void test() throws VentasDaoException {
		VentasFactoryDao ventasDao = VentasFactoryDao.getFactory();
		Assert.assertNotNull(ventasDao);
	}

}
