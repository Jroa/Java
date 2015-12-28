package pe.com.jroa.greeting;
import static org.junit.Assert.assertEquals;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.Test;

public class GreetingTest {
		
	@Test
	public void testGreet(){		
		WeldContainer weld = new Weld().initialize();
		Greeting greeting = weld.instance().select(Greeting.class).get();
		assertEquals("Hello Jonathan",greeting.greet("Jonathan"));

		System.out.println(greeting.greet("Jonathan"));
	}
}
