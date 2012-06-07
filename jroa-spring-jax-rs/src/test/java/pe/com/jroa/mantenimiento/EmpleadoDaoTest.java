package pe.com.jroa.mantenimiento;

import junit.framework.Assert;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import pe.com.jroa.mantenimiento.dao.EmpleadoDao;
import pe.com.jroa.mantenimiento.model.Empleado;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext-test.xml")
@Transactional
public class EmpleadoDaoTest {
	private Logger logger = Logger.getLogger(EmpleadoDao.class);
	private Empleado empleado;
	
	@Autowired
	private EmpleadoDao empleadoDao;
	
	@Before
	public void init(){
		empleado = new Empleado();
		empleado.setNombre("Juan");
		empleado.setApellido("Diaz");
		empleado.setNumDocumento("12345678");
	}
	
	@Test
	public void buscarPorIdTest(){
		Assert.assertEquals("Jonathan", empleadoDao.buscarPorId(0).getNombre());
		logger.debug("buscarPorId Ejecutado");
	}
	
	@Test
	public void buscarTodosTest(){
		Assert.assertTrue(empleadoDao.buscarTodos().size() > 0);
		logger.debug("buscarTodos Ejecutado");
	}
	
	@Test
	public void buscarPorDocumentoTest(){
		Assert.assertEquals("Jonathan", empleadoDao.buscarPorDocumento("42364208").getNombre());
		logger.debug("buscarPorDocumento Ejecutado");
	}
	
	@Test
	public void empleadoCrud(){
		this.empleadoDao.agregar(empleado);
		Assert.assertEquals(empleado.getApellido(), empleadoDao.buscarPorDocumento(empleado.getNumDocumento()).getApellido());
		logger.debug("Cantidad de empleado service " + this.empleadoDao.buscarTodos().size());
		logger.debug("Se agrego al empleado");

		
		empleado = this.empleadoDao.buscarPorDocumento(empleado.getNumDocumento());
		empleado.setNombre("Nombre Modificado");
		this.empleadoDao.modificar(empleado);
		Assert.assertEquals(empleado.getNombre(), this.empleadoDao.buscarPorDocumento(empleado.getNumDocumento()).getNombre());
		logger.debug("Se modifico el empleado");
		
		empleado = this.empleadoDao.buscarPorDocumento(empleado.getNumDocumento());
		this.empleadoDao.eliminar(empleado);
		Assert.assertEquals(null, this.empleadoDao.buscarPorDocumento(empleado.getNumDocumento()));
		logger.debug("Se elimino el empleado");
	}
}
