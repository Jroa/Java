package pe.com.jroa.greeting;

public class SimpleGreeting implements Greeting {

	public String greet(String name) {
		return "Hello " + name;
	}
}
