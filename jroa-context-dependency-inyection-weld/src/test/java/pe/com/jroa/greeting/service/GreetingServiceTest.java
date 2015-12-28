package pe.com.jroa.greeting.service;

import static org.junit.Assert.assertEquals;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.Test;

public class GreetingServiceTest {

	@Test
	public void testGreet(){
		WeldContainer weld = new Weld().initialize();
		GreetingService service = weld.instance().select(GreetingService.class).get();
		assertEquals("Hello Jonathan", service.greet("Jonathan"));
		
		System.out.println(service.greet("Jonathan"));
	}
}
