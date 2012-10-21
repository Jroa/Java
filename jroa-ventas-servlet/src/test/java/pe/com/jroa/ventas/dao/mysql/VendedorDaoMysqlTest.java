package pe.com.jroa.ventas.dao.mysql;


import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import pe.com.jroa.ventas.dao.VentasDaoException;
import pe.com.jroa.ventas.entities.Local;
import pe.com.jroa.ventas.entities.Vendedor;
import pe.com.jroa.ventas.util.Fecha;

public class VendedorDaoMysqlTest {

	Local local = null;
	Vendedor vendedor = null;
	Logger logger = Logger.getLogger(VendedorDaoMysqlTest.class);
	
	@Before
	public void init() {
		local = new Local();
		local.setId(1);
		local.setNombre("LIMA");
		
		
		vendedor = new Vendedor();
		vendedor.setNombre("Jonathan");
		vendedor.setApellido("Roa");
		vendedor.setDireccion("direccion");
		vendedor.setFecnac(Fecha.getDateFromString("30/04/1984"));
		vendedor.setSexo(true);
		vendedor.setLocal(local);
	}
	
	@Test
	public void testCrear() throws VentasDaoException {		
		VendedorDaoMysql vendedorDaoMysql = new VendedorDaoMysql();
		vendedorDaoMysql.crear(vendedor);
	}
	

}
