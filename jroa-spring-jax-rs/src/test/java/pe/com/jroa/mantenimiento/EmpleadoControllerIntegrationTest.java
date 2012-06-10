package pe.com.jroa.mantenimiento;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import pe.com.jroa.mantenimiento.model.Empleado;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext-test.xml")
public class EmpleadoControllerIntegrationTest {
	private Logger logger = Logger.getLogger(EmpleadoControllerIntegrationTest.class);
	private String url = "";
	private Empleado empleadoTest;
	
	@Autowired
	private RestTemplate restTemplate;
		
	@Before
	public void init(){
		url = "http://localhost:8080/jroa-spring-jax-rs/services/rest/empleado/";
		empleadoTest = new Empleado();
		empleadoTest.setNombre("Christopher");
		empleadoTest.setApellido("Roa");
		empleadoTest.setNumDocumento("44556677");
	}
	
	@Test
	public void testBuscarTodosLosEmpleados(){
		String urlBuscarTodos = url + "todos";
		@SuppressWarnings("unchecked")
		List<Empleado> empleados =(List<Empleado>)restTemplate.getForObject(urlBuscarTodos, List.class);
		logger.debug("Cantidad de empleados recuperado : " + empleados.size());
		Assert.assertTrue(empleados.size() > 0);
	}
	
	@Test
	public void testBuscarEmpleadoPorDocumento(){
		String urlBuscarPorDocumento = url + "42364208";
		Empleado empleado = restTemplate.getForObject(urlBuscarPorDocumento, Empleado.class);
		Assert.assertEquals("Jonathan", empleado.getNombre());
	}
	
	@Test
	public void testAgregarEmpleadoYBuscarEmpleadoAgregado(){
		String resultado = this.restTemplate.postForObject(url, empleadoTest, String.class);
		logger.debug("Resultado de agregar el empleado : " + resultado);	
		Empleado empleadoAgregado = this.buscarEmpleadoPorDocumento(empleadoTest.getNumDocumento());
		Assert.assertEquals(empleadoTest.getNombre(), empleadoAgregado.getNombre());
	}
	
	@Test
	public void testActualizarEmpleadoYBuscarEmpleadoActualizado(){
		empleadoTest = this.buscarEmpleadoPorDocumento(empleadoTest.getNumDocumento());
		
		empleadoTest.setNombre("Christopher Modificado");
		this.restTemplate.put(url , empleadoTest);
		
		Empleado empleadoActualizado = this.buscarEmpleadoPorDocumento(empleadoTest.getNumDocumento());
		
		Assert.assertEquals(empleadoTest.getNombre(), empleadoActualizado.getNombre());
		logger.debug("Nombre del Empleado: " + empleadoTest.getNombre());
	}
	
	@Test
	public void testEliminarEmpleado(){
		this.restTemplate.delete(url + empleadoTest.getNumDocumento());
	}
	
	public Empleado buscarEmpleadoPorDocumento(String numDocumento){
		Empleado empleadoEncontrado = this.restTemplate.getForObject(url + numDocumento, Empleado.class);
		return empleadoEncontrado;
	}
	
}
