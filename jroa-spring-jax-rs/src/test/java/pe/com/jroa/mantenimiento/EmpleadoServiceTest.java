package pe.com.jroa.mantenimiento;

import junit.framework.Assert;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pe.com.jroa.mantenimiento.model.Empleado;
import pe.com.jroa.mantenimiento.service.EmpleadoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext-test.xml")
public class EmpleadoServiceTest {
	private Logger logger = Logger.getLogger(EmpleadoServiceTest.class);
	private Empleado empleado;
	
	@Autowired
	private EmpleadoService empleadoService;
	
	@Before
	public void init(){
		empleado = new Empleado();
		empleado.setNombre("Eduardo");
		empleado.setApellido("Tenorio");
		empleado.setNumDocumento("44445555");
	}
	
	@Test
	public void buscarPorIdTest(){
		Assert.assertEquals("Jonathan", empleadoService.buscarPorId(0).getNombre());
		logger.debug("buscarPorId Ejecutado");
	}
	
	@Test
	public void buscarTodosTest(){
		Assert.assertNotSame(0, this.empleadoService.buscarTodos().size());
		logger.debug("buscarTodos Ejecutado");
	}
	
	@Test
	public void buscarPorDocumentoTest(){
		Assert.assertEquals("Jonathan", this.empleadoService.buscarPorDocumento("42364208").getNombre());
		logger.debug("buscarporDocumento Ejecutado");
	}
	
	@Test
	public void EmpleadoServiceCrud(){
		this.empleadoService.agregar(empleado);
		Assert.assertEquals(empleado.getNombre(), this.empleadoService.buscarPorDocumento(empleado.getNumDocumento()).getNombre());
		logger.debug("empleado agregado");
		
		empleado = this.empleadoService.buscarPorId(1);
		empleado.setNombre("Nombre Modificado");
		this.empleadoService.modificar(empleado);
		Assert.assertEquals(empleado.getNombre(), this.empleadoService.buscarPorDocumento(empleado.getNumDocumento()).getNombre());
		logger.debug("empleado modificado");
		
		empleado = this.empleadoService.buscarPorId(1);
		this.empleadoService.eliminar(empleado);
		Assert.assertEquals(null, this.empleadoService.buscarPorDocumento(empleado.getNumDocumento()));
		logger.debug("empleado eliminado");
	}
}
