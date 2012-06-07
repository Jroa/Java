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
	@Autowired
	private RestTemplate restTemplate;
		
	@Before
	public void init(){
		url = "http://localhost:8080/jroa-spring-jax-rs/services/rest/empleado";
	}
	
	@Test
	public void testbuscarTodosLosEmpleados(){
		@SuppressWarnings("unchecked")
		List<Empleado> empleados =(List<Empleado>)restTemplate.getForObject(url + "/todos", List.class);
		logger.debug("Cantidad de empleados recuperado : " + empleados.size());
		Assert.assertTrue(empleados.size() > 0);
	}
}
