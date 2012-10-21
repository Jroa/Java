package pe.com.jroa.ventas.dao.mysql;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import pe.com.jroa.ventas.dao.VentasDaoException;
import pe.com.jroa.ventas.entities.Local;

public class LocalDaoMysqlTest {

	@Test
	public void testTraerTodos() throws VentasDaoException {
		LocalDaoMysql localDaoMysql = new LocalDaoMysql();
		List<Local> locales = localDaoMysql.traerTodos();
		Assert.assertTrue(locales.size() > 0);
	}

}
