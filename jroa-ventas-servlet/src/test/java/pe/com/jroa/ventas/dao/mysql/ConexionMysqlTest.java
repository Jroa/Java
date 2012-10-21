package pe.com.jroa.ventas.dao.mysql;

import java.sql.Connection;

import junit.framework.Assert;

import org.junit.Test;

import pe.com.jroa.ventas.dao.VentasDaoException;

public class ConexionMysqlTest {

	@Test
	public void testConnection() throws VentasDaoException {
		Connection connection;
		connection = ConexionMysql.getInstance().getConnection();
		Assert.assertNotNull(connection);
	}

}
